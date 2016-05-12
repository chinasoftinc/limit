package com.athena.common.exception;

/**
 * 系统异常码枚举类
 * @author niebinxiao
 */
public enum ExceptionCode {

	/**
	 * 系统异常
	 */
	SystemException("-1", "系统底层异常"),

	/**
	 * 参数异常
	 */
	IllegalParamException("-2", "参数不正确异常"),

	/**
	 * 账户异常
	 */
	UserStatusException("0", "账户登录异常"),

	/**
	 * 通信异常
	 */
	HostException("1", "网络通信异常"),

	/**
	 * 文件操作异常
	 */
	DownloadFileException("2", "下载或上传服务器文件磁盘存储异常"),

	/**
	 * 业务规则异常
	 */
	BusinessException("8", "业务流程限制或错误操作等异常");

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
