package limit.common.userOptLog;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import limit.common.context.Dictionary;
import limit.module.user.model.User;
import limit.module.userOpt.service.UserOptService;

/**
 * <pre>
 * 日志记录切面 [切入点: service, 在spring-service中配置], 弃用
 * 	设计思路: 
 * 		采用注解的方式切入切入点, 为了避免读取注解, 采用map缓存的方式缓存注解信息, 先根据方法签名或类限定名读取map缓存信息, 若没有, 读取注解再缓存到map
 * @author niebinxiao
 */
public class UserOptAdvice implements InitializingBean {
	private static Logger logger = LoggerFactory.getLogger(UserOptAdvice.class);

	/**
	 * 枚举描述:　操作类型
	 * @author niebinxiao
	 */
	public enum DML {
		INSERT("0", "插入"), UPDATE("1", "更新"), DELETE("2", "删除");
		public String code;
		public String name;

		private DML(String code, String name) {
			this.code = code;
			this.name = name;
		}
	}

	@SuppressWarnings("unused")
	@Inject
	private UserOptService userOptsService;

	public void afterPropertiesSet() throws Exception {
		logger.info("加载日志记录切面成功");
	}

	/**
	 * 日志记录切入代码, 日志记录只针对写入操作
	 * @param point
	 * @return
	 * @throws Throwable
	 */
	public Object record(ProceedingJoinPoint point) throws Throwable {
		// 执行目标代码, 获取返回类型
		Object exec;
		try {
			exec = point.proceed();
		} catch (Exception e) {
			// 目标代码异常, 直接抛出
			throw e;
		}
		return exec;
	}

	// 获取用户信息
	@SuppressWarnings("unused")
	private User getOperationUser() {
		RequestAttributes requestAttr = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes servletRequestAttr = requestAttr != null ? (ServletRequestAttributes) requestAttr : null;
		HttpServletRequest request = servletRequestAttr != null ? servletRequestAttr.getRequest() : null;
		return request != null ? (User) request.getSession().getAttribute(Dictionary.USER_SESSION_KEY) : null;
	}

}
