package com.athena.common.exception;

/**
 * 系统异常码枚举类
 * @author niebinxiao
 */
public enum ExceptionCode {

	SystemException("-1", "系统异常"),

	IllegalParamException("-2", "参数异常"),

	UserStatusException("0", "账户异常"),

	ReqTargetHostException("1", "请求目标主机异常"),

	DownloadFileException("2", "下载文件异常"),

	BusinessException("8","业务流程限制");

	private String code;

	private String type;

	private ExceptionCode(String code, String type) {
		this.code = code;
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
