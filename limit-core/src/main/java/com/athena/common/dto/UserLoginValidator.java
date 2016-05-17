package com.athena.common.dto;

import com.athena.common.context.Constants.LoginStatus;
import com.athena.module.users.model.User;

/**
 * 用户登录校验返回dto
 * @author niebinxiao
 */
public class UserLoginValidator {

	// 用户
	private User user;

	// 用户登录状态
	private LoginStatus status;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LoginStatus getStatus() {
		return status;
	}

	public void setStatus(LoginStatus status) {
		this.status = status;
	}

	public UserLoginValidator() {
		super();
	}

	public UserLoginValidator(User user, LoginStatus status) {
		super();
		this.user = user;
		this.status = status;
	}

}
