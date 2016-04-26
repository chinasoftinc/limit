package limit.module.userOpt.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import limit.common.base.entity.Entity;
import limit.common.dto.Pagination;

public class UserOptExam extends Entity<UserOptExam> {
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	protected Pagination pagination;

	public UserOptExam() {
		oredCriteria = new ArrayList<Criteria>();
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	public boolean isDistinct() {
		return distinct;
	}

	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public Pagination getPagination() {
		return pagination;
	}

	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Long value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Long value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Long value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Long value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Long value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Long value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Long> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Long> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Long value1, Long value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Long value1, Long value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNull() {
			addCriterion("user_id is null");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNotNull() {
			addCriterion("user_id is not null");
			return (Criteria) this;
		}

		public Criteria andUserIdEqualTo(Long value) {
			addCriterion("user_id =", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotEqualTo(Long value) {
			addCriterion("user_id <>", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThan(Long value) {
			addCriterion("user_id >", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("user_id >=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThan(Long value) {
			addCriterion("user_id <", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThanOrEqualTo(Long value) {
			addCriterion("user_id <=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdIn(List<Long> values) {
			addCriterion("user_id in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotIn(List<Long> values) {
			addCriterion("user_id not in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdBetween(Long value1, Long value2) {
			addCriterion("user_id between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotBetween(Long value1, Long value2) {
			addCriterion("user_id not between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andNicknameIsNull() {
			addCriterion("nickname is null");
			return (Criteria) this;
		}

		public Criteria andNicknameIsNotNull() {
			addCriterion("nickname is not null");
			return (Criteria) this;
		}

		public Criteria andNicknameEqualTo(String value) {
			addCriterion("nickname =", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameNotEqualTo(String value) {
			addCriterion("nickname <>", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameGreaterThan(String value) {
			addCriterion("nickname >", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameGreaterThanOrEqualTo(String value) {
			addCriterion("nickname >=", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameLessThan(String value) {
			addCriterion("nickname <", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameLessThanOrEqualTo(String value) {
			addCriterion("nickname <=", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameLike(String value) {
			addCriterion("nickname like", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameNotLike(String value) {
			addCriterion("nickname not like", value, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameIn(List<String> values) {
			addCriterion("nickname in", values, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameNotIn(List<String> values) {
			addCriterion("nickname not in", values, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameBetween(String value1, String value2) {
			addCriterion("nickname between", value1, value2, "nickname");
			return (Criteria) this;
		}

		public Criteria andNicknameNotBetween(String value1, String value2) {
			addCriterion("nickname not between", value1, value2, "nickname");
			return (Criteria) this;
		}

		public Criteria andIsSuccessIsNull() {
			addCriterion("is_success is null");
			return (Criteria) this;
		}

		public Criteria andIsSuccessIsNotNull() {
			addCriterion("is_success is not null");
			return (Criteria) this;
		}

		public Criteria andIsSuccessEqualTo(String value) {
			addCriterion("is_success =", value, "isSuccess");
			return (Criteria) this;
		}

		public Criteria andIsSuccessNotEqualTo(String value) {
			addCriterion("is_success <>", value, "isSuccess");
			return (Criteria) this;
		}

		public Criteria andIsSuccessGreaterThan(String value) {
			addCriterion("is_success >", value, "isSuccess");
			return (Criteria) this;
		}

		public Criteria andIsSuccessGreaterThanOrEqualTo(String value) {
			addCriterion("is_success >=", value, "isSuccess");
			return (Criteria) this;
		}

		public Criteria andIsSuccessLessThan(String value) {
			addCriterion("is_success <", value, "isSuccess");
			return (Criteria) this;
		}

		public Criteria andIsSuccessLessThanOrEqualTo(String value) {
			addCriterion("is_success <=", value, "isSuccess");
			return (Criteria) this;
		}

		public Criteria andIsSuccessLike(String value) {
			addCriterion("is_success like", value, "isSuccess");
			return (Criteria) this;
		}

		public Criteria andIsSuccessNotLike(String value) {
			addCriterion("is_success not like", value, "isSuccess");
			return (Criteria) this;
		}

		public Criteria andIsSuccessIn(List<String> values) {
			addCriterion("is_success in", values, "isSuccess");
			return (Criteria) this;
		}

		public Criteria andIsSuccessNotIn(List<String> values) {
			addCriterion("is_success not in", values, "isSuccess");
			return (Criteria) this;
		}

		public Criteria andIsSuccessBetween(String value1, String value2) {
			addCriterion("is_success between", value1, value2, "isSuccess");
			return (Criteria) this;
		}

		public Criteria andIsSuccessNotBetween(String value1, String value2) {
			addCriterion("is_success not between", value1, value2, "isSuccess");
			return (Criteria) this;
		}

		public Criteria andOptTypeIsNull() {
			addCriterion("opt_type is null");
			return (Criteria) this;
		}

		public Criteria andOptTypeIsNotNull() {
			addCriterion("opt_type is not null");
			return (Criteria) this;
		}

		public Criteria andOptTypeEqualTo(String value) {
			addCriterion("opt_type =", value, "optType");
			return (Criteria) this;
		}

		public Criteria andOptTypeNotEqualTo(String value) {
			addCriterion("opt_type <>", value, "optType");
			return (Criteria) this;
		}

		public Criteria andOptTypeGreaterThan(String value) {
			addCriterion("opt_type >", value, "optType");
			return (Criteria) this;
		}

		public Criteria andOptTypeGreaterThanOrEqualTo(String value) {
			addCriterion("opt_type >=", value, "optType");
			return (Criteria) this;
		}

		public Criteria andOptTypeLessThan(String value) {
			addCriterion("opt_type <", value, "optType");
			return (Criteria) this;
		}

		public Criteria andOptTypeLessThanOrEqualTo(String value) {
			addCriterion("opt_type <=", value, "optType");
			return (Criteria) this;
		}

		public Criteria andOptTypeLike(String value) {
			addCriterion("opt_type like", value, "optType");
			return (Criteria) this;
		}

		public Criteria andOptTypeNotLike(String value) {
			addCriterion("opt_type not like", value, "optType");
			return (Criteria) this;
		}

		public Criteria andOptTypeIn(List<String> values) {
			addCriterion("opt_type in", values, "optType");
			return (Criteria) this;
		}

		public Criteria andOptTypeNotIn(List<String> values) {
			addCriterion("opt_type not in", values, "optType");
			return (Criteria) this;
		}

		public Criteria andOptTypeBetween(String value1, String value2) {
			addCriterion("opt_type between", value1, value2, "optType");
			return (Criteria) this;
		}

		public Criteria andOptTypeNotBetween(String value1, String value2) {
			addCriterion("opt_type not between", value1, value2, "optType");
			return (Criteria) this;
		}

		public Criteria andEntityIdIsNull() {
			addCriterion("entity_id is null");
			return (Criteria) this;
		}

		public Criteria andEntityIdIsNotNull() {
			addCriterion("entity_id is not null");
			return (Criteria) this;
		}

		public Criteria andEntityIdEqualTo(Long value) {
			addCriterion("entity_id =", value, "entityId");
			return (Criteria) this;
		}

		public Criteria andEntityIdNotEqualTo(Long value) {
			addCriterion("entity_id <>", value, "entityId");
			return (Criteria) this;
		}

		public Criteria andEntityIdGreaterThan(Long value) {
			addCriterion("entity_id >", value, "entityId");
			return (Criteria) this;
		}

		public Criteria andEntityIdGreaterThanOrEqualTo(Long value) {
			addCriterion("entity_id >=", value, "entityId");
			return (Criteria) this;
		}

		public Criteria andEntityIdLessThan(Long value) {
			addCriterion("entity_id <", value, "entityId");
			return (Criteria) this;
		}

		public Criteria andEntityIdLessThanOrEqualTo(Long value) {
			addCriterion("entity_id <=", value, "entityId");
			return (Criteria) this;
		}

		public Criteria andEntityIdIn(List<Long> values) {
			addCriterion("entity_id in", values, "entityId");
			return (Criteria) this;
		}

		public Criteria andEntityIdNotIn(List<Long> values) {
			addCriterion("entity_id not in", values, "entityId");
			return (Criteria) this;
		}

		public Criteria andEntityIdBetween(Long value1, Long value2) {
			addCriterion("entity_id between", value1, value2, "entityId");
			return (Criteria) this;
		}

		public Criteria andEntityIdNotBetween(Long value1, Long value2) {
			addCriterion("entity_id not between", value1, value2, "entityId");
			return (Criteria) this;
		}

		public Criteria andEntityTypeIsNull() {
			addCriterion("entity_type is null");
			return (Criteria) this;
		}

		public Criteria andEntityTypeIsNotNull() {
			addCriterion("entity_type is not null");
			return (Criteria) this;
		}

		public Criteria andEntityTypeEqualTo(String value) {
			addCriterion("entity_type =", value, "entityType");
			return (Criteria) this;
		}

		public Criteria andEntityTypeNotEqualTo(String value) {
			addCriterion("entity_type <>", value, "entityType");
			return (Criteria) this;
		}

		public Criteria andEntityTypeGreaterThan(String value) {
			addCriterion("entity_type >", value, "entityType");
			return (Criteria) this;
		}

		public Criteria andEntityTypeGreaterThanOrEqualTo(String value) {
			addCriterion("entity_type >=", value, "entityType");
			return (Criteria) this;
		}

		public Criteria andEntityTypeLessThan(String value) {
			addCriterion("entity_type <", value, "entityType");
			return (Criteria) this;
		}

		public Criteria andEntityTypeLessThanOrEqualTo(String value) {
			addCriterion("entity_type <=", value, "entityType");
			return (Criteria) this;
		}

		public Criteria andEntityTypeLike(String value) {
			addCriterion("entity_type like", value, "entityType");
			return (Criteria) this;
		}

		public Criteria andEntityTypeNotLike(String value) {
			addCriterion("entity_type not like", value, "entityType");
			return (Criteria) this;
		}

		public Criteria andEntityTypeIn(List<String> values) {
			addCriterion("entity_type in", values, "entityType");
			return (Criteria) this;
		}

		public Criteria andEntityTypeNotIn(List<String> values) {
			addCriterion("entity_type not in", values, "entityType");
			return (Criteria) this;
		}

		public Criteria andEntityTypeBetween(String value1, String value2) {
			addCriterion("entity_type between", value1, value2, "entityType");
			return (Criteria) this;
		}

		public Criteria andEntityTypeNotBetween(String value1, String value2) {
			addCriterion("entity_type not between", value1, value2, "entityType");
			return (Criteria) this;
		}

		public Criteria andEntityTitleIsNull() {
			addCriterion("entity_title is null");
			return (Criteria) this;
		}

		public Criteria andEntityTitleIsNotNull() {
			addCriterion("entity_title is not null");
			return (Criteria) this;
		}

		public Criteria andEntityTitleEqualTo(String value) {
			addCriterion("entity_title =", value, "entityTitle");
			return (Criteria) this;
		}

		public Criteria andEntityTitleNotEqualTo(String value) {
			addCriterion("entity_title <>", value, "entityTitle");
			return (Criteria) this;
		}

		public Criteria andEntityTitleGreaterThan(String value) {
			addCriterion("entity_title >", value, "entityTitle");
			return (Criteria) this;
		}

		public Criteria andEntityTitleGreaterThanOrEqualTo(String value) {
			addCriterion("entity_title >=", value, "entityTitle");
			return (Criteria) this;
		}

		public Criteria andEntityTitleLessThan(String value) {
			addCriterion("entity_title <", value, "entityTitle");
			return (Criteria) this;
		}

		public Criteria andEntityTitleLessThanOrEqualTo(String value) {
			addCriterion("entity_title <=", value, "entityTitle");
			return (Criteria) this;
		}

		public Criteria andEntityTitleLike(String value) {
			addCriterion("entity_title like", value, "entityTitle");
			return (Criteria) this;
		}

		public Criteria andEntityTitleNotLike(String value) {
			addCriterion("entity_title not like", value, "entityTitle");
			return (Criteria) this;
		}

		public Criteria andEntityTitleIn(List<String> values) {
			addCriterion("entity_title in", values, "entityTitle");
			return (Criteria) this;
		}

		public Criteria andEntityTitleNotIn(List<String> values) {
			addCriterion("entity_title not in", values, "entityTitle");
			return (Criteria) this;
		}

		public Criteria andEntityTitleBetween(String value1, String value2) {
			addCriterion("entity_title between", value1, value2, "entityTitle");
			return (Criteria) this;
		}

		public Criteria andEntityTitleNotBetween(String value1, String value2) {
			addCriterion("entity_title not between", value1, value2, "entityTitle");
			return (Criteria) this;
		}

		public Criteria andOptDetailIsNull() {
			addCriterion("opt_detail is null");
			return (Criteria) this;
		}

		public Criteria andOptDetailIsNotNull() {
			addCriterion("opt_detail is not null");
			return (Criteria) this;
		}

		public Criteria andOptDetailEqualTo(String value) {
			addCriterion("opt_detail =", value, "optDetail");
			return (Criteria) this;
		}

		public Criteria andOptDetailNotEqualTo(String value) {
			addCriterion("opt_detail <>", value, "optDetail");
			return (Criteria) this;
		}

		public Criteria andOptDetailGreaterThan(String value) {
			addCriterion("opt_detail >", value, "optDetail");
			return (Criteria) this;
		}

		public Criteria andOptDetailGreaterThanOrEqualTo(String value) {
			addCriterion("opt_detail >=", value, "optDetail");
			return (Criteria) this;
		}

		public Criteria andOptDetailLessThan(String value) {
			addCriterion("opt_detail <", value, "optDetail");
			return (Criteria) this;
		}

		public Criteria andOptDetailLessThanOrEqualTo(String value) {
			addCriterion("opt_detail <=", value, "optDetail");
			return (Criteria) this;
		}

		public Criteria andOptDetailLike(String value) {
			addCriterion("opt_detail like", value, "optDetail");
			return (Criteria) this;
		}

		public Criteria andOptDetailNotLike(String value) {
			addCriterion("opt_detail not like", value, "optDetail");
			return (Criteria) this;
		}

		public Criteria andOptDetailIn(List<String> values) {
			addCriterion("opt_detail in", values, "optDetail");
			return (Criteria) this;
		}

		public Criteria andOptDetailNotIn(List<String> values) {
			addCriterion("opt_detail not in", values, "optDetail");
			return (Criteria) this;
		}

		public Criteria andOptDetailBetween(String value1, String value2) {
			addCriterion("opt_detail between", value1, value2, "optDetail");
			return (Criteria) this;
		}

		public Criteria andOptDetailNotBetween(String value1, String value2) {
			addCriterion("opt_detail not between", value1, value2, "optDetail");
			return (Criteria) this;
		}

		public Criteria andOptTimeIsNull() {
			addCriterion("opt_time is null");
			return (Criteria) this;
		}

		public Criteria andOptTimeIsNotNull() {
			addCriterion("opt_time is not null");
			return (Criteria) this;
		}

		public Criteria andOptTimeEqualTo(Date value) {
			addCriterion("opt_time =", value, "optTime");
			return (Criteria) this;
		}

		public Criteria andOptTimeNotEqualTo(Date value) {
			addCriterion("opt_time <>", value, "optTime");
			return (Criteria) this;
		}

		public Criteria andOptTimeGreaterThan(Date value) {
			addCriterion("opt_time >", value, "optTime");
			return (Criteria) this;
		}

		public Criteria andOptTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("opt_time >=", value, "optTime");
			return (Criteria) this;
		}

		public Criteria andOptTimeLessThan(Date value) {
			addCriterion("opt_time <", value, "optTime");
			return (Criteria) this;
		}

		public Criteria andOptTimeLessThanOrEqualTo(Date value) {
			addCriterion("opt_time <=", value, "optTime");
			return (Criteria) this;
		}

		public Criteria andOptTimeIn(List<Date> values) {
			addCriterion("opt_time in", values, "optTime");
			return (Criteria) this;
		}

		public Criteria andOptTimeNotIn(List<Date> values) {
			addCriterion("opt_time not in", values, "optTime");
			return (Criteria) this;
		}

		public Criteria andOptTimeBetween(Date value1, Date value2) {
			addCriterion("opt_time between", value1, value2, "optTime");
			return (Criteria) this;
		}

		public Criteria andOptTimeNotBetween(Date value1, Date value2) {
			addCriterion("opt_time not between", value1, value2, "optTime");
			return (Criteria) this;
		}

		public Criteria andNicknameLikeInsensitive(String value) {
			addCriterion("upper(nickname) like", value.toUpperCase(), "nickname");
			return (Criteria) this;
		}

		public Criteria andIsSuccessLikeInsensitive(String value) {
			addCriterion("upper(is_success) like", value.toUpperCase(), "isSuccess");
			return (Criteria) this;
		}

		public Criteria andOptTypeLikeInsensitive(String value) {
			addCriterion("upper(opt_type) like", value.toUpperCase(), "optType");
			return (Criteria) this;
		}

		public Criteria andEntityTypeLikeInsensitive(String value) {
			addCriterion("upper(entity_type) like", value.toUpperCase(), "entityType");
			return (Criteria) this;
		}

		public Criteria andEntityTitleLikeInsensitive(String value) {
			addCriterion("upper(entity_title) like", value.toUpperCase(), "entityTitle");
			return (Criteria) this;
		}

		public Criteria andOptDetailLikeInsensitive(String value) {
			addCriterion("upper(opt_detail) like", value.toUpperCase(), "optDetail");
			return (Criteria) this;
		}
	}

	public static class Criteria extends GeneratedCriteria {

		protected Criteria() {
			super();
		}
	}

	public static class Criterion {
		private String condition;

		private Object value;

		private Object secondValue;

		private boolean noValue;

		private boolean singleValue;

		private boolean betweenValue;

		private boolean listValue;

		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}
}