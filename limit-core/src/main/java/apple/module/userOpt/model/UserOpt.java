package apple.module.userOpt.model;

import java.util.Date;

import apple.common.base.entity.AbstractModel;

/**
 * 用户操作记录
 * @author niebx
 */
public class UserOpt extends AbstractModel<UserOpt> {
	private static final long serialVersionUID = 3063652075226772878L;

	private Long id;
	// 用户ID
	private Long userId;
	// 用户昵称
	private String nickname;
	// 操作是否成功
	private String isSuccess;
	// 操作类型, 通过方法的前缀判断, 定义一个操作数组静态枚举类类, 如add, insert为一组, 表示添加 [0:添加, 1:更新, 2:删除]
	private String optType;
	// 操作实体的类型 [依次判断所有入参, 是否是GeneratorEntity的子类, 是就直接获取, 不是跳过, 存中文]
	private String entityType;
	// 实体的ID
	private Long entityId;
	// 实体的标题, id和标题的话, 业务实体实现GeneratorEntity, getGenerateId, getGenerateTitle, 让需要的子类覆写, 如果找到实体类型, 那就强转成GeneratorEntity
	private String entityTitle;
	// 操作详细信息
	private String optDetail;
	// 操作时间
	private Date optTime;

	// --------------------------------

	// 最小时间, 页面筛选
	transient Date minTime;
	// 最大时间, 页面筛选
	transient Date maxTime;

	// --------------------------------

	public Date getMinTime() {
		return minTime;
	}

	public void setMinTime(Date minTime) {
		this.minTime = minTime;
	}

	public Date getMaxTime() {
		return maxTime;
	}

	public void setMaxTime(Date maxTime) {
		this.maxTime = maxTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname == null ? null : nickname.trim();
	}

	public String getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(String isSuccess) {
		this.isSuccess = isSuccess == null ? null : isSuccess.trim();
	}

	public String getOptType() {
		return optType;
	}

	public void setOptType(String optType) {
		this.optType = optType == null ? null : optType.trim();
	}

	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType == null ? null : entityType.trim();
	}

	public Long getEntityId() {
		return entityId;
	}

	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}

	public String getEntityTitle() {
		return entityTitle;
	}

	public void setEntityTitle(String entityTitle) {
		this.entityTitle = entityTitle == null ? null : entityTitle.trim();
	}

	public Date getOptTime() {
		return optTime;
	}

	public void setOptTime(Date optTime) {
		this.optTime = optTime;
	}

	public String getOptDetail() {
		return optDetail;
	}

	public void setOptDetail(String optDetail) {
		this.optDetail = optDetail == null ? null : optDetail.trim();
	}

}