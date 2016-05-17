package com.athena.common.interceptor;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.UrlPathHelper;

import com.athena.common.context.Constants.LoginStatus;
import com.athena.common.context.SecurityManager;
import com.athena.module.users.model.User;

/**
 * 请求安全拦截器
 * @author niebinxiao
 */
public class SecurityInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		if (isAutoLogin && securityManager.getLoginUser(request) == null) {
			User user = new User();
			user.setId(BigDecimal.ONE);
			user.setUserName("admin");
			user.setPassWord("admin");
			user.setNickName("聂宾潇");
			user.setUserStatus(LoginStatus.ADMIN.code);
			securityManager.login(securityManager.validateUser(user).getUser(), request);
		}

		if (isOpenSecurityFilter) {
			if (securityManager.hasPrivilege(urlPathHelper.getLookupPathForRequest(request), request)) {
				return true;
				
			} else {
				response.sendRedirect(urlPathHelper.getContextPath(request) + enterPage);
				return false;
				
			}
			
		} else {
			return true;
			
		}
	}

	private boolean isAutoLogin = true;

	private boolean isOpenSecurityFilter = true;

	private String enterPage;

	private SecurityManager securityManager;

	private UrlPathHelper urlPathHelper;

	public String getEnterPage() {
		return enterPage;
	}

	public void setEnterPage(String enterPage) {
		this.enterPage = enterPage;
	}

	public UrlPathHelper getUrlPathHelper() {
		return urlPathHelper;
	}

	public void setUrlPathHelper(UrlPathHelper urlPathHelper) {
		this.urlPathHelper = urlPathHelper;
	}

	public boolean isAutoLogin() {
		return isAutoLogin;
	}

	public void setAutoLogin(boolean isAutoLogin) {
		this.isAutoLogin = isAutoLogin;
	}

	public boolean isOpenSecurityFilter() {
		return isOpenSecurityFilter;
	}

	public void setOpenSecurityFilter(boolean isOpenSecurityFilter) {
		this.isOpenSecurityFilter = isOpenSecurityFilter;
	}

	public SecurityManager getSecurityManager() {
		return securityManager;
	}

	public void setSecurityManager(SecurityManager securityManager) {
		this.securityManager = securityManager;
	}

}
