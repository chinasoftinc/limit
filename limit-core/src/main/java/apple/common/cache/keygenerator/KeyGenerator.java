package apple.common.cache.keygenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;

import apple.module.user.dao.UserDao;

/**
 * <pre>
 * 缓存key生成超类
 * 		1. 所有key生成类继承该类
 * 		2. 所有dml方法按分类写死在继承类中
 * @author niebinxiao
 */
public abstract class KeyGenerator {

	// unique key 组合关键字
	protected static final String UNIQUE_WORD = "_unique_";

	// hash key 组合关键字
	protected static final String HASH_WORD = "_hash";

	// 通用的单例写入方法数组
	protected static List<String> commonUniqueSaveDMLs = Arrays.asList(new String[] { "deleteByExample", "updateByExampleSelective", "updateByExample" });

	// 通用的多例或其他写入方法数组
	protected static List<String> commonHashSaveDMLs = Arrays.asList(new String[] { "deleteByPrimaryKey", "insert", "insertSelective", "updateByPrimaryKeySelective", "updateByPrimaryKey" });;

	// 获取自定义的单例写入方法
	protected abstract List<String> getUniqueDMLs();

	// 获取自定义的多例写入方法
	protected abstract List<String> getHashDMLs();

	/**
	 * 根据切入点获取实体对应的缓存key生成器
	 * @param point
	 * @return
	 */
	public static KeyGenerator getKeyGenerator(MethodInvocationProceedingJoinPoint point) {
		Object target = point.getTarget();
		if (UserDao.class.isInstance(target)) {
			return new UserKeyGenerator();
		}
		return null;
	}

	/**
	 * 当该dao刷新时, 获取级联的其他dao刷新key
	 * @return
	 */
	public abstract List<String> getCascadeOtherDaoRefushKeys(MethodInvocationProceedingJoinPoint point);

	/**
	 * 根据dml方法的切入点获取刷新key
	 * @return
	 */
	public abstract List<String> dmlRefushKeys(MethodInvocationProceedingJoinPoint point);

	/**
	 * 根据查询方法的切入点生成缓存key (多例返回UserDaoImp_hash, 单例返回UserDaoImp_unique_{id})
	 * @return
	 */
	public abstract String selectCacheKey(MethodInvocationProceedingJoinPoint point);

	/**
	 * 根据查询方法的切入点获取缓存field (查询参数的toString), 多例hash需要
	 * @return
	 */
	public abstract String selectCacheField(MethodInvocationProceedingJoinPoint point);

	/**
	 * 是否是dml方法
	 * @param methodPoint
	 * @return
	 */
	public boolean isDml(MethodInvocationProceedingJoinPoint methodPoint) {
		String methodName = ((MethodSignature) methodPoint.getSignature()).getMethod().getName();
		// 获取所有写入方法
		ArrayList<String> dmls = new ArrayList<String>();
		dmls.addAll(commonHashSaveDMLs);
		dmls.addAll(commonUniqueSaveDMLs);
		if (CollectionUtils.isNotEmpty(getUniqueDMLs())) {
			dmls.addAll(getUniqueDMLs());
		}
		if (CollectionUtils.isNotEmpty(getHashDMLs())) {
			dmls.addAll(getHashDMLs());
		}
		return dmls.contains(methodName);
	}

	/**
	 * 是否是unique dml方法
	 * @param methodPoint
	 * @return
	 */
	public boolean isUniqueDML(MethodInvocationProceedingJoinPoint methodPoint) {
		String methodName = ((MethodSignature) methodPoint.getSignature()).getMethod().getName();
		// 获取所有单例写入方法
		ArrayList<String> dmls = new ArrayList<String>();
		dmls.addAll(commonUniqueSaveDMLs);
		if (CollectionUtils.isNotEmpty(getUniqueDMLs())) {
			dmls.addAll(getUniqueDMLs());
		}
		return dmls.contains(methodName);
	}

	/**
	 * 是否是hash查询
	 * @param cacheKey
	 * @return
	 */
	public boolean isHashSelect(String cacheKey) {
		return cacheKey.endsWith(HASH_WORD);
	}

}
