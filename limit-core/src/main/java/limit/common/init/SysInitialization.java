package limit.common.init;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.WebApplicationContext;

import limit.common.utils.ApplicationContextUtils;

/**
 * <pre>
 * 系统初始化监听器 
 * ApplicationListener 是Spring的自定义监听器, 包括监听容器的初始化
 * ServletContextAware 是spring的注入servletContetxt的接口
 * @author niebinxiao
 */
public class SysInitialization implements ApplicationListener<ApplicationEvent>, ServletContextAware, ServletContextListener {
	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(SysInitialization.class);

	@Override
	/**
	 * spring容器刷新事件触发后调用该方法
	 * spring容器的整个生命周期的操作会回调该接口, 如容器刷新(refresh, 构建所需的java对象), 容器启动, 容器销毁
	 * 回调时传入的event对象将会明确是哪个容器的刷新操作
	 * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent)
	 */
	public void onApplicationEvent(ApplicationEvent event) {
		// 判断是否是容器刷新事件, 该事件会在spring所有bean初始化成功时调用, 意味着BeanFactory完全初始化成功
		if (event instanceof ContextRefreshedEvent) {
			// 判断容器是否是父容器刷新, 而不是web容器
			if (((ApplicationContextEvent) event).getApplicationContext().getParent() == null) {
				// do some thing...
			} else {
				// 不是父容器, 则是mvc容器的刷新事件, 做一些处理
				ApplicationContextUtils.setWebApplicationContext((WebApplicationContext) ((ContextRefreshedEvent) event).getApplicationContext());
			}
		}
	}

	// spring 对servlet上下文的注入
	@Override
	public void setServletContext(ServletContext servletContext) {
		// do some thing...
	}

	@Override
	// servlet上下文销毁处理
	public void contextDestroyed(ServletContextEvent event) {
		// do some thing...
	}

	@Override
	// servlet上下文初始化处理
	public void contextInitialized(ServletContextEvent event) {
		// do some thing...
	}

}
