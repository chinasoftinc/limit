package com.athena.common.listener;

import java.util.Date;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.athena.common.context.Constants.UserModel.IsLogin;
import com.athena.common.context.DictionaryProvider;
import com.athena.common.utils.ApplicationContextUtils;
import com.athena.module.users.model.User;
import com.athena.module.users.service.UserService;

public class UserStatusListener implements HttpSessionAttributeListener, HttpSessionListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		if (se.getName().equals(DictionaryProvider.USER_SESSION_KEY)) {
			User user = new User();
			Date now = new Date();
			User sessionUser = (User) se.getValue();
			user.setId(sessionUser.getId());
			user.setLastAccessIp(sessionUser.getLastAccessIp()); // ip
			user.setLastAccessTime(now); // 最后访问时间
			user.setLastLoginTime(now); // 最后登录时间
			user.setIsLogin(IsLogin.LOGIN.code); // 已登录
			ApplicationContextUtils.getBean(UserService.class).updateByPrimaryKeySelective(user);
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		if (se.getName().equals(DictionaryProvider.USER_SESSION_KEY)) {
			User user = new User();
			Date now = new Date();
			User sessionUser = (User) se.getValue();

			User dbUser = ApplicationContextUtils.getBean(UserService.class).selectByPrimaryKey(sessionUser.getId());

			// 在线时长增加计算
			Date loginTime = null;
			if ((loginTime = dbUser.getLastLoginTime()) != null) {
				long time = now.getTime() - loginTime.getTime();
				user.setOnlineTime(dbUser.getOnlineTime() + ((Long) (time / 60000)).intValue());
			}

			user.setId(sessionUser.getId());
			user.setLastAccessTime(now); // 最后访问时间
			user.setIsLogin(IsLogin.NOT.code); // 未登录
			ApplicationContextUtils.getBean(UserService.class).updateByPrimaryKeySelective(user);
		}
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
	}

}
