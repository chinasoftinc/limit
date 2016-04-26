package limit.common.cache.keygenerator;

import java.util.Arrays;
import java.util.List;

import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;

import com.alibaba.fastjson.JSON;

import limit.common.base.entity.PageModel;

public class CommonKeyGenerator extends KeyGenerator {

	@Override
	public List<String> dmlRefushKeys(MethodInvocationProceedingJoinPoint point) {
		String className = point.getTarget().getClass().getName();

		if (this.isUniqueDML(point)) {
			Object[] args = point.getArgs();
			if (args != null && args.length == 1) {
				String id = null;
				if (args[0] instanceof Long)
					id = String.valueOf(args[0]);
				else if (args[0] instanceof PageModel)
					id = String.valueOf(((PageModel<?>) args[0]).getId());
				// unique刷新unique对应的单例缓存和所有hash缓存
				return Arrays.asList(new String[] { className + UNIQUE_WORD + id, className + HASH_WORD + "*" });
			}
		}
		// 其他刷新所有缓存
		return Arrays.asList(new String[] { className + "*" });
	}

	@Override
	public String selectCacheKey(MethodInvocationProceedingJoinPoint point) {
		String className = point.getTarget().getClass().getName();
		Object[] args = point.getArgs();
		if (args != null && args.length == 1 && args[0] instanceof Long) {
			return className + UNIQUE_WORD + String.valueOf(args[0]);
		}
		return className + HASH_WORD;
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
	protected List<String> getCustomUniqueDMLs() {
		return null;
	}

	@Override
	protected List<String> getCustomHashDMLs() {
		return null;
	}
}
