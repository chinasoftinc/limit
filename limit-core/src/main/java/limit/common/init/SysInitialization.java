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
 * @author niebinxiao
 */
public class SysInitialization implements ApplicationListener<ApplicationEvent>, ServletContextAware, ServletContextListener {
	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(SysInitialization.class);

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof ContextRefreshedEvent) {
			if (((ApplicationContextEvent) event).getApplicationContext().getParent() == null) {
				// do some thing...
			} else {
				ApplicationContextUtils.setWebApplicationContext((WebApplicationContext) ((ContextRefreshedEvent) event).getApplicationContext());
			}
		}
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
	}

}
