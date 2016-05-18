package com.athena.module.loggers.model;

import java.math.BigDecimal;
import java.util.Date;

import com.athena.common.base.entity.PageModel;

/**
 * 日志
 * @author niebinxiao
 */
public class Logger extends PageModel<Logger> {
	private static final long serialVersionUID = 6642625282358234985L;

	private BigDecimal id;

	// 操作用户id
	private BigDecimal userId;

	// 操作用户昵称
	private String userNickname;

	// 操作类型(0:添加;1:修改;2:删除)
	private String optorType;

	// 操作业务类型名称(枚举定义, 选项字典)
	private String entityName;

	// 操作实体标题
	private String modelTitle;

	// 操作实体id
	private BigDecimal modelId;

	// 操作时间
	private Date optorTime;

	// 操作详细说明
	private String optorDetail;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public BigDecimal getUserId() {
		return userId;
	}

	public void setUserId(BigDecimal userId) {
		this.userId = userId;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname == null ? null : userNickname.trim();
	}

	public String getOptorType() {
		return optorType;
	}

	public void setOptorType(String optorType) {
		this.optorType = optorType == null ? null : optorType.trim();
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName == null ? null : entityName.trim();
	}

	public String getModelTitle() {
		return modelTitle;
	}

	public void setModelTitle(String modelTitle) {
		this.modelTitle = modelTitle == null ? null : modelTitle.trim();
	}

	public BigDecimal getModelId() {
		return modelId;
	}

	public void setModelId(BigDecimal modelId) {
		this.modelId = modelId;
	}

	public Date getOptorTime() {
		return optorTime;
	}

	public void setOptorTime(Date optorTime) {
		this.optorTime = optorTime;
	}

	public String getOptorDetail() {
		return optorDetail;
	}

	public void setOptorDetail(String optorDetail) {
		this.optorDetail = optorDetail == null ? null : optorDetail.trim();
	}
}