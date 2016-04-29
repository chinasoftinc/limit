package com.athena.common.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

public class ExceptionRedirector extends SimpleMappingExceptionResolver {

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

		// 屏蔽资源文件请求产生的异常, 包括解决uploadify在chrome下的socket异常
		if (handler instanceof ResourceHttpRequestHandler) {
			return null;
		}
		response.reset();
		return super.doResolveException(request, response, handler, ex);
	}
}
