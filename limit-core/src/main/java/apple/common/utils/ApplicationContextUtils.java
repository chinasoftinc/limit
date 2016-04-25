package apple.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.WebApplicationContext;

/**
 * spring容器工具类
 * @author niebinxiao
 */
/**
 * @author niebinxiao
 */
public class ApplicationContextUtils implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	private static WebApplicationContext webApplicationContext;

	public static Object getBean(String id) {
		return applicationContext.getBean(id);
	}

	public static <T> T getBean(Class<T> classType) {
		return applicationContext.getBean(classType);
	}

	// 由sysInitilization注入mvc容器
	public static void setWebApplicationContext(WebApplicationContext webApplicationContext) {
		ApplicationContextUtils.webApplicationContext = webApplicationContext;
	}

	public static WebApplicationContext getWebApplicationContext() {
		return webApplicationContext;
	}

	// 由spring回调接口注入容器
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ApplicationContextUtils.applicationContext = applicationContext;
	}

}
