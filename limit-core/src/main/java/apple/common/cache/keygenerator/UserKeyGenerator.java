package apple.common.cache.keygenerator;

import java.util.Arrays;
import java.util.List;

import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;

import com.alibaba.fastjson.JSON;

import apple.common.base.entity.AbstractModel;
import apple.module.user.dao.UserDao;

/**
 * 用户缓存key生成器
 * @author niebinxiao
 */
public class UserKeyGenerator extends KeyGenerator {

	private static final String DAO_NAME = UserDao.class.getName();

	@Override
	public List<String> dmlRefushKeys(MethodInvocationProceedingJoinPoint point) {
		if (this.isUniqueDML(point)) {
			Object[] args = point.getArgs();
			if (args != null && args.length == 1) {
				String id = null;
				if (args[0] instanceof Long)
					id = String.valueOf(args[0]);
				else if (args[0] instanceof AbstractModel)
					id = String.valueOf(((AbstractModel<?>) args[0]).getId());
				// unique刷新unique对应的单例缓存和所有hash缓存
				return Arrays.asList(new String[] { DAO_NAME + UNIQUE_WORD + id, DAO_NAME + HASH_WORD + "*" });
			}
		}
		// 其他刷新所有缓存
		return Arrays.asList(new String[] { DAO_NAME + "*" });
	}

	@Override
	public String selectCacheKey(MethodInvocationProceedingJoinPoint point) {
		Object[] args = point.getArgs();
		if (args != null && args.length == 1 && args[0] instanceof Long) {
			return DAO_NAME + UNIQUE_WORD + String.valueOf(args[0]);
		}
		return DAO_NAME + HASH_WORD;
	}

	@Override
	public String selectCacheField(MethodInvocationProceedingJoinPoint point) {
		Object[] args = point.getArgs();
		StringBuffer sb = new StringBuffer();
		for (Object arg : args) {
			sb.append(JSON.toJSONString(arg));
		}
		return String.valueOf(new String(sb).hashCode());
	}

	@Override
	public List<String> getCascadeOtherDaoRefushKeys(MethodInvocationProceedingJoinPoint point) {
		return null;
	}

	@Override
	protected List<String> getUniqueDMLs() {
		return null;
	}

	@Override
	protected List<String> getHashDMLs() {
		return null;
	}

}
