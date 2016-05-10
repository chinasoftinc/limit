package com.athena.common.exception;

import org.apache.commons.lang.StringUtils;

/**
 * 业务及系统异常
 * @author niebinxiao
 */
public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = -7447903959517559688L;

	// 异常码
	private ExceptionCode code;

	// 是否是自定义异常消息
	private boolean isCustom = false;

	/**
	 * 指定异常状态码和异常消息
	 * @param code
	 * @param msg
	 */
	public BusinessException(ExceptionCode code, String msg) {
		super(msg);
		isCustom = StringUtils.isNotBlank(msg) ? true : false;
		this.code = code;
	}

	/**
	 * 指定异常状态码
	 * @param code
	 */
	public BusinessException(ExceptionCode code) {
		this(code, null);
	}

	/**
	 * 指定异常消息, 不指定状态码
	 * @param msg
	 */
	public BusinessException(String msg) {
		this(null, msg);
	}

	@Override
	public String toString() {

		// 获取异常目标类的限定名
		String exceptionTargetClassName = getClass().getName();

		// 自定义异常消息以及包括JVM本地抛出的为国际化的异常信息(或默认构造接收的字符串), 前者会覆盖后者
		String message = getLocalizedMessage();

		// 异常消息
		String msg = "";

		if (StringUtils.isNotBlank(message)) {

			if (code != null && isCustom) {
				// 自定义异常消息且包含异常码
				msg = exceptionTargetClassName.concat(": [(状态码: ").concat(code.getCode()).concat("), (异常类型: ").concat(code.getType()).concat("), (异常消息: ").concat(message).concat(")]");

			} else {
				// 只包含异常消息
				msg = exceptionTargetClassName.concat("(异常类型: ").concat(message).concat(")]");

			}
		} else {
			// 只包含异常码
			msg = exceptionTargetClassName.concat(": [(状态码: ").concat(code.getCode()).concat("), (异常类型: ").concat(code.getType()).concat(")]");
		}

		return msg;
	}

	public ExceptionCode getCode() {
		return code;
	}

	public void setCode(ExceptionCode code) {
		this.code = code;
	}

	public static void main(String[] args) {
		Integer test = 2;

		if (test == 1)
			throw new BusinessException(ExceptionCode.IllegalParamException);

		else if (test == 2)
			throw new BusinessException(ExceptionCode.IllegalParamException, "2肯定大于1");

		else if (test == 3)
			throw new BusinessException("2肯定大于1");
	}

}
