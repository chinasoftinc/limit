package com.athena.common.dto;

import java.io.Serializable;

import com.athena.common.context.Constants.CommonResult;
import com.athena.common.exception.BusinessException;

/**
 * 请求响应体
 * @author niebinxiao
 */
public class ResponseResult implements Serializable {
	private static final long serialVersionUID = 5176884281460610977L;

	// 是否成功
	private boolean success;

	// 远程数据
	private Object data;

	// 返回码
	private String code;

	// 说明
	private String description;

	// 用户提示
	private String message;

	public ResponseResult(boolean success, Object data) {
		this.success = success;
		this.data = data;
	}

	/**
	 * 统一异常响应参数
	 * @param success
	 * @param ex 系统异常
	 */
	public ResponseResult(boolean success, BusinessException ex) {
		this(success, ex.getCode().getCode(), ex.getCode().getType(), ex.getMessage());
	}

	/**
	 * 统一响应枚举响应参数
	 * @param success
	 * @param result 响应枚举
	 */
	public ResponseResult(boolean success, CommonResult result) {
		this(success, result.getCode(), result.getDescription(), result.getMessage());
	}

	/**
	 * 自定义响应参数
	 * @param success 是否成功
	 * @param code 返回码
	 * @param description 说明
	 * @param message 用户提示
	 */
	public ResponseResult(boolean success, String code, String description, String message) {
		this.success = success;
		this.code = code;
		this.description = description;
		this.message = message;
	}

	/**
	 * 自定义响应参数
	 * @param success 是否成功
	 * @param description 说明
	 * @param message 用户提示
	 */
	public ResponseResult(boolean success, String description, String message) {
		this(success, null, description, message);
	}

	/**
	 * 自定义响应参数
	 * @param success 是否成功
	 * @param message 用户提示
	 */
	public ResponseResult(boolean success, String message) {
		this(success, null, null, message);
	}

	/**
	 * 自定义响应参数
	 * @param success 是否成功
	 */
	public ResponseResult(boolean success) {
		this(success, null, null, null);
	}

	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
