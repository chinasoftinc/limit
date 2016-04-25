package apple.common.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

/**
 * <pre>
 * 自定义全局异常跳转, 重置response, 防止response输出流被打开而跳转再次打开导致出错
 * 	<!-- 全局异常处理mvc bean配置 -->
 * 	<bean class="apple.common.exception.ExceptionRedirector">
 * 		<!-- 异常匹配重定向映射(这里是路由串, 定向到视图解析器), 视图中可以通过request的exception属性拿到异常信息 -->
 * 		<property name="exceptionMappings">
 * 			<props>
 * 				<prop key="Exception">error/error</prop>
 * 			</props>
 * 		</property>
 * 		<!-- 设置日志输出级别, 如果不设置, 该异常将不会被日志记录 -->
 * 		<property name="warnLogCategory" value="ERROR" />
 * 	</bean>
 * @author niebinxiao
 */
public class ExceptionRedirector extends SimpleMappingExceptionResolver {

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

		// 屏蔽资源文件请求产生的异常, 包括解决uploadify在chrom下的连接异常
		if (handler instanceof ResourceHttpRequestHandler) {
			return null;
		}
		response.reset();
		return super.doResolveException(request, response, handler, ex);
	}
}
