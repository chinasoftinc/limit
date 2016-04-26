package limit.common.base.controller;

import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

import limit.common.base.entity.PageModel;
import limit.common.context.Constants;
import limit.common.exception.BusinessException;
import limit.common.exception.ExceptionCode;

/**
 * @author NieBinxiao
 */
public abstract class AbstractWebController {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 设置添加标记
	 * @param mv
	 */
	public void setAddOperation(ModelAndView mv) {
		mv.addObject("operation", "add");
	}

	/**
	 * 设置修改标记
	 * @param mv
	 */
	public void setEditOperation(ModelAndView mv) {
		mv.addObject("operation", "edit");
	}

	/**
	 * 判断是否是添加操作
	 * @param form
	 * @return
	 */
	public boolean isAddOperation(PageModel<?> form) {
		return "add".equals(form.getOperation());
	}

	/**
	 * 判断是否是编辑操作
	 * @param form
	 * @return
	 */
	public boolean isEditOperation(PageModel<?> form) {
		return "edit".equals(form.getOperation());
	}

	/**
	 * 设置当前窗口id
	 * @param mv
	 * @param form
	 */
	public void setCurrentWinId(ModelAndView mv, PageModel<?> form) {
		mv.addObject("winId", form.getWinId());
	}

	/**
	 * 设置父窗口id
	 * @param mv
	 * @param form
	 */
	public void setParentWinId(ModelAndView mv, PageModel<?> form) {
		mv.addObject("parentWinId", form.getParentWinId());
	}

	/**
	 * 设置操作成功响应页面
	 * @param mv
	 */
	public void setSuccessView(ModelAndView mv) {
		mv.setViewName("/common/tip/success");
	}

	/**
	 * 设置操作完成响应页面
	 * @param mv
	 */
	public void setCompleteView(ModelAndView mv) {
		mv.setViewName("/common/tip/complete");
	}

	/**
	 * 设置操作错误响应页面
	 * @param mv
	 */
	public void setErrorView(ModelAndView mv, String errorMsg) {
		mv.addObject("optRs", "false");
		mv.addObject("errorMsg", errorMsg);
		mv.setViewName("/common/tip/complete");
	}

	/**
	 * 获取相对路径的服务器路径
	 * @param request
	 * @param relativePath
	 * @return
	 */
	public static String realPath(HttpServletRequest request, String relativePath) {
		return request.getSession().getServletContext().getRealPath(relativePath);
	}

	/**
	 * 说明: 输出json数据
	 * @param response
	 * @param target
	 */
	public static void responseJson(HttpServletResponse response, String json) {
		try {
			response.setContentType("application/json;charset=UTF-8");
			response.setCharacterEncoding("utf-8");
			response.setHeader("Charset", "utf-8");
			response.setHeader("Cache-Control", "no-cache");
			PrintWriter writer = response.getWriter();
			writer.print(json);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			throw new BusinessException(ExceptionCode.SystemException, "输出json出现异常");
		}
	}

	/**
	 * 清除session中的所有属性(非invalidate,保持集群会话一致性)
	 * @author niebinxiao
	 */
	public static void cleanSession(HttpSession session) {
		Enumeration<?> keys = session.getAttributeNames();
		if (null != keys) {
			while (keys.hasMoreElements()) {
				String key = (String) keys.nextElement();
				session.removeAttribute(key);
			}

		}
	}

	/**
	 * 获取客户端IP的方法。
	 * @return IP
	 */
	public static String getClientIp(HttpServletRequest request) {
		String ip = null;
		ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
			if (ip.equals("127.0.0.1")) {
				// 根据网卡取本机配置的IP
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				ip = inet.getHostAddress();
			}
		}
		// 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		if (ip != null && ip.length() > 15) {
			// = 15
			if (ip.indexOf(",") > 0) {
				ip = ip.substring(0, ip.indexOf(","));
			}
		}
		return ip;
	}

	/**
	 * 异常处理器注册
	 * @param request
	 * @param e
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler(Exception.class)
	public String registExceptionHandler(HttpServletRequest request, Exception e) throws Exception {
		request.setAttribute("exception", e);
		return "error/error";
	}

	/**
	 * 日期格式转化器注册
	 * @param binder
	 */
	@InitBinder
	final public void registDateConver(WebDataBinder binder) {

		SimpleDateFormat fullDataConver = new SimpleDateFormat(Constants.FULL_DATE_FORMAT);
		fullDataConver.setLenient(false);
		binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {

			private SimpleDateFormat longFormat = new SimpleDateFormat(Constants.FULL_DATE_FORMAT);
			private SimpleDateFormat shortFormat = new SimpleDateFormat(Constants.SIMPLE_DATE_FORMAT);

			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				if (StringUtils.isEmpty(text)) {
					setValue(null);
				} else {
					try {
						setValue(this.longFormat.parse(text));
					} catch (ParseException e1) {
						try {
							setValue(this.shortFormat.parseObject(text));
						} catch (ParseException e2) {
							throw new BusinessException(ExceptionCode.SystemException, "InitBinder注册的自定义属性编辑器, 无法转化的日期格式: [" + text + "]\rerror" + e2.getMessage());
						}
					}
				}
			}

			@Override
			public String getAsText() {
				Date value = (Date) getValue();
				return (value != null ? longFormat.format(value) : "");
			}
		});
	}

}
