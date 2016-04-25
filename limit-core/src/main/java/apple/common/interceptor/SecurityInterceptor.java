package apple.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.UrlPathHelper;

import apple.common.context.SecurityMgr;
import apple.module.user.model.User;

/**
 * 请求安全拦截器
 * @author niebinxiao
 */
public class SecurityInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		/* 自动登录管理员账户配置, 方便开发测试 */
		if (isAutoLogin && SecurityMgr.getLoginUser(request) == null) {
			User user = new User();
			user.setId(1L);
			user.setUsername("admin");
			user.setPassword("admin");
			SecurityMgr.login(SecurityMgr.validateUser(user).getUser(), request);
		}

		// 权限过滤
		if (isOpenSecurityFilter) {
			if (SecurityMgr.hasPrivilege(urlPathHelper.getLookupPathForRequest(request), request)) {
				return true;
			} else {
				// 无权限直接跳转到入口页面
				response.sendRedirect(urlPathHelper.getContextPath(request) + enterPage);
				return false;
			}
		} else {
			return true;
		}
	}

	// 是否自动登录管理员帐号(方便开发)
	private boolean isAutoLogin = true;

	// 是否开启权限过滤(方便开发测试)
	private boolean isOpenSecurityFilter = true;

	// 入口页面
	private String enterPage;

	// 系统安全管理器
	private apple.common.context.SecurityMgr SecurityMgr;

	// spring 请求地址解析帮助类
	private UrlPathHelper urlPathHelper;

	public String getEnterPage() {
		return enterPage;
	}

	public void setEnterPage(String enterPage) {
		this.enterPage = enterPage;
	}

	public SecurityMgr getSecurityMgr() {
		return SecurityMgr;
	}

	public void setSecurityMgr(SecurityMgr securityMgr) {
		SecurityMgr = securityMgr;
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

}
