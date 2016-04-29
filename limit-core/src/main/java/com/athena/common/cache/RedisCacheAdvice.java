package com.athena.common.cache;

import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import com.athena.common.cache.keygenerator.KeyGenerator;
import com.athena.common.cache.utils.RedisCacheUtils;
import com.athena.common.utils.ConcurrentExecutor;

/**
 * <pre>
 * @author niebinxiao
 */
public class RedisCacheAdvice implements InitializingBean {
	private static Logger logger = org.slf4j.LoggerFactory.getLogger(RedisCacheAdvice.class);
	private RedisTemplate<String, Object> template;

	// 缓存切面
	public Object around(ProceedingJoinPoint point) throws Throwable {
		
		// 业务方法执行结果
		Object invokeResult = null;
		
		// 缓存key
		String cacheKey = null;
		
		// 转型为方法切入点
		final MethodInvocationProceedingJoinPoint methodPoint = (MethodInvocationProceedingJoinPoint) point;

		// 根据切入点获取对应的key生成器
		final KeyGenerator generator = KeyGenerator.getKeyGenerator(methodPoint);

		try {
			if (generator != null) {
				// 读写操作刷新缓存
				if (generator.isDml(methodPoint)) {
					// 根据方法签名获取需要刷新的key, 根据((MethodSignature)methodPoint.getSignature()).getReturnType() 返回的returnType来判断是单体还是列表
					final List<String> refushKeys = generator.dmlRefushKeys(methodPoint);
					logger.debug("写入方法: {}, 刷新keys:{}", ((MethodSignature) methodPoint.getSignature()).getMethod().getName(), ArrayUtils.toString(refushKeys));
					// 异步开启管道执行刷新操作
					ConcurrentExecutor.execute(new Runnable() {
						public void run() {
							template.executePipelined(new RedisCallback<Object>() {
								public Object doInRedis(RedisConnection connection) throws DataAccessException {
									// 根据key获取符合的keys, 删除对应缓存
									for (String refushKey : refushKeys) {
										Set<byte[]> keySet = connection.keys((refushKey).getBytes());
										if (null != keySet && !keySet.isEmpty()) {
											for (byte[] bs : keySet) {
												connection.del(bs);
											}
										}
										Set<byte[]> hKeySet = connection.hKeys((refushKey).getBytes());
										if (null != hKeySet && !hKeySet.isEmpty()) {
											for (byte[] bs : hKeySet) {
												connection.hDel(bs);
											}
										}
									}
									return 1L;
								}
							});
						}
					});

					// 获取其他级联dao刷新key
					final List<String> cascadeRefushKeys = generator.getCascadeOtherDaoRefushKeys(methodPoint);
					if (CollectionUtils.isNotEmpty(cascadeRefushKeys)) {
						// 异步开启管道执行刷新操作
						ConcurrentExecutor.execute(new Runnable() {
							public void run() {
								template.executePipelined(new RedisCallback<Object>() {
									public Object doInRedis(RedisConnection connection) throws DataAccessException {
										// 根据key获取符合的keys, 删除对应缓存
										for (String refushKey : cascadeRefushKeys) {
											Set<byte[]> keySet = connection.keys((refushKey).getBytes());
											if (null != keySet && !keySet.isEmpty()) {
												for (byte[] bs : keySet) {
													connection.del(bs);
												}
											}
											Set<byte[]> hKeySet = connection.hKeys((refushKey).getBytes());
											if (null != hKeySet && !hKeySet.isEmpty()) {
												for (byte[] bs : hKeySet) {
													connection.hDel(bs);
												}
											}
										}
										return 1L;
									}
								});
							}
						});
					}

					return point.proceed();

					// 查询方法
				} else {
					cacheKey = generator.selectCacheKey(methodPoint);
					final String _cacheKey = cacheKey;
					invokeResult = template.execute(new RedisCallback<Object>() {
						public Object doInRedis(RedisConnection connection) throws DataAccessException {
							Object rs = null;
							// 查询单例
							if (!generator.isHashSelect(_cacheKey)) {
								rs = connection.get(_cacheKey.getBytes());
								// 查询多例
							} else {
								String cachefield = generator.selectCacheField(methodPoint);
								if (connection.hExists(_cacheKey.getBytes(), cachefield.getBytes())) {
									rs = connection.hGet(_cacheKey.getBytes(), cachefield.getBytes());
								}
							}
							return RedisCacheUtils.byte2Object((byte[]) rs);
						}
					});
				}

				// 如果缓存没有, 查询并加入缓存
				if (invokeResult == null) {
					final Object rs;
					final String _cacheKey = cacheKey;
					invokeResult = rs = point.proceed();
					// 缓存多例
					if (invokeResult instanceof List) {
						final String cachefield = generator.selectCacheField(methodPoint);
						ConcurrentExecutor.execute(new Runnable() {
							public void run() {
								template.execute(new RedisCallback<Object>() {
									public Object doInRedis(RedisConnection connection) throws DataAccessException {
										connection.hSet(_cacheKey.getBytes(), cachefield.getBytes(), RedisCacheUtils.object2Byte(rs));
										logger.debug("插入hash缓存, key:{}, field:{}", _cacheKey, cachefield);
										return 1L;
									}
								});
							}
						});

						// 缓存单例
					} else {
						ConcurrentExecutor.execute(new Runnable() {
							public void run() {
								template.execute(new RedisCallback<Object>() {
									public Object doInRedis(RedisConnection connection) throws DataAccessException {
										connection.set(_cacheKey.getBytes(), RedisCacheUtils.object2Byte(rs));
										logger.debug("插入unique缓存, key:{}", _cacheKey);
										return 1L;
									}
								});
							}
						});
					}
				}
			}
		} catch (Throwable e) {
			logger.error("缓存模块异常\rerror: " + e);
		}

		return invokeResult == null ? point.proceed() : invokeResult;
	}

	public RedisTemplate<String, Object> getTemplate() {
		return template;
	}

	public void setTemplate(RedisTemplate<String, Object> template) {
		this.template = template;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		logger.info("redis缓存初始化成功");
	}

}
