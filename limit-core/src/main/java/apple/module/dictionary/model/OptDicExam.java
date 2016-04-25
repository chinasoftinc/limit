package apple.module.dictionary.model;

import java.util.ArrayList;
import java.util.List;

import apple.common.base.entity.Entity;
import apple.common.dto.Pagination;

public class OptDicExam extends Entity<OptDicExam> {
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	protected Pagination pagination;

	public OptDicExam() {
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

		public Criteria andOptNameIsNull() {
			addCriterion("opt_name is null");
			return (Criteria) this;
		}

		public Criteria andOptNameIsNotNull() {
			addCriterion("opt_name is not null");
			return (Criteria) this;
		}

		public Criteria andOptNameEqualTo(String value) {
			addCriterion("opt_name =", value, "optName");
			return (Criteria) this;
		}

		public Criteria andOptNameNotEqualTo(String value) {
			addCriterion("opt_name <>", value, "optName");
			return (Criteria) this;
		}

		public Criteria andOptNameGreaterThan(String value) {
			addCriterion("opt_name >", value, "optName");
			return (Criteria) this;
		}

		public Criteria andOptNameGreaterThanOrEqualTo(String value) {
			addCriterion("opt_name >=", value, "optName");
			return (Criteria) this;
		}

		public Criteria andOptNameLessThan(String value) {
			addCriterion("opt_name <", value, "optName");
			return (Criteria) this;
		}

		public Criteria andOptNameLessThanOrEqualTo(String value) {
			addCriterion("opt_name <=", value, "optName");
			return (Criteria) this;
		}

		public Criteria andOptNameLike(String value) {
			addCriterion("opt_name like", value, "optName");
			return (Criteria) this;
		}

		public Criteria andOptNameNotLike(String value) {
			addCriterion("opt_name not like", value, "optName");
			return (Criteria) this;
		}

		public Criteria andOptNameIn(List<String> values) {
			addCriterion("opt_name in", values, "optName");
			return (Criteria) this;
		}

		public Criteria andOptNameNotIn(List<String> values) {
			addCriterion("opt_name not in", values, "optName");
			return (Criteria) this;
		}

		public Criteria andOptNameBetween(String value1, String value2) {
			addCriterion("opt_name between", value1, value2, "optName");
			return (Criteria) this;
		}

		public Criteria andOptNameNotBetween(String value1, String value2) {
			addCriterion("opt_name not between", value1, value2, "optName");
			return (Criteria) this;
		}

		public Criteria andOptKeyIsNull() {
			addCriterion("opt_key is null");
			return (Criteria) this;
		}

		public Criteria andOptKeyIsNotNull() {
			addCriterion("opt_key is not null");
			return (Criteria) this;
		}

		public Criteria andOptKeyEqualTo(String value) {
			addCriterion("opt_key =", value, "optKey");
			return (Criteria) this;
		}

		public Criteria andOptKeyNotEqualTo(String value) {
			addCriterion("opt_key <>", value, "optKey");
			return (Criteria) this;
		}

		public Criteria andOptKeyGreaterThan(String value) {
			addCriterion("opt_key >", value, "optKey");
			return (Criteria) this;
		}

		public Criteria andOptKeyGreaterThanOrEqualTo(String value) {
			addCriterion("opt_key >=", value, "optKey");
			return (Criteria) this;
		}

		public Criteria andOptKeyLessThan(String value) {
			addCriterion("opt_key <", value, "optKey");
			return (Criteria) this;
		}

		public Criteria andOptKeyLessThanOrEqualTo(String value) {
			addCriterion("opt_key <=", value, "optKey");
			return (Criteria) this;
		}

		public Criteria andOptKeyLike(String value) {
			addCriterion("opt_key like", value, "optKey");
			return (Criteria) this;
		}

		public Criteria andOptKeyNotLike(String value) {
			addCriterion("opt_key not like", value, "optKey");
			return (Criteria) this;
		}

		public Criteria andOptKeyIn(List<String> values) {
			addCriterion("opt_key in", values, "optKey");
			return (Criteria) this;
		}

		public Criteria andOptKeyNotIn(List<String> values) {
			addCriterion("opt_key not in", values, "optKey");
			return (Criteria) this;
		}

		public Criteria andOptKeyBetween(String value1, String value2) {
			addCriterion("opt_key between", value1, value2, "optKey");
			return (Criteria) this;
		}

		public Criteria andOptKeyNotBetween(String value1, String value2) {
			addCriterion("opt_key not between", value1, value2, "optKey");
			return (Criteria) this;
		}

		public Criteria andOptValIsNull() {
			addCriterion("opt_val is null");
			return (Criteria) this;
		}

		public Criteria andOptValIsNotNull() {
			addCriterion("opt_val is not null");
			return (Criteria) this;
		}

		public Criteria andOptValEqualTo(String value) {
			addCriterion("opt_val =", value, "optVal");
			return (Criteria) this;
		}

		public Criteria andOptValNotEqualTo(String value) {
			addCriterion("opt_val <>", value, "optVal");
			return (Criteria) this;
		}

		public Criteria andOptValGreaterThan(String value) {
			addCriterion("opt_val >", value, "optVal");
			return (Criteria) this;
		}

		public Criteria andOptValGreaterThanOrEqualTo(String value) {
			addCriterion("opt_val >=", value, "optVal");
			return (Criteria) this;
		}

		public Criteria andOptValLessThan(String value) {
			addCriterion("opt_val <", value, "optVal");
			return (Criteria) this;
		}

		public Criteria andOptValLessThanOrEqualTo(String value) {
			addCriterion("opt_val <=", value, "optVal");
			return (Criteria) this;
		}

		public Criteria andOptValLike(String value) {
			addCriterion("opt_val like", value, "optVal");
			return (Criteria) this;
		}

		public Criteria andOptValNotLike(String value) {
			addCriterion("opt_val not like", value, "optVal");
			return (Criteria) this;
		}

		public Criteria andOptValIn(List<String> values) {
			addCriterion("opt_val in", values, "optVal");
			return (Criteria) this;
		}

		public Criteria andOptValNotIn(List<String> values) {
			addCriterion("opt_val not in", values, "optVal");
			return (Criteria) this;
		}

		public Criteria andOptValBetween(String value1, String value2) {
			addCriterion("opt_val between", value1, value2, "optVal");
			return (Criteria) this;
		}

		public Criteria andOptValNotBetween(String value1, String value2) {
			addCriterion("opt_val not between", value1, value2, "optVal");
			return (Criteria) this;
		}

		public Criteria andParentIdIsNull() {
			addCriterion("parent_id is null");
			return (Criteria) this;
		}

		public Criteria andParentIdIsNotNull() {
			addCriterion("parent_id is not null");
			return (Criteria) this;
		}

		public Criteria andParentIdEqualTo(Long value) {
			addCriterion("parent_id =", value, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdNotEqualTo(Long value) {
			addCriterion("parent_id <>", value, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdGreaterThan(Long value) {
			addCriterion("parent_id >", value, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdGreaterThanOrEqualTo(Long value) {
			addCriterion("parent_id >=", value, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdLessThan(Long value) {
			addCriterion("parent_id <", value, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdLessThanOrEqualTo(Long value) {
			addCriterion("parent_id <=", value, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdIn(List<Long> values) {
			addCriterion("parent_id in", values, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdNotIn(List<Long> values) {
			addCriterion("parent_id not in", values, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdBetween(Long value1, Long value2) {
			addCriterion("parent_id between", value1, value2, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdNotBetween(Long value1, Long value2) {
			addCriterion("parent_id not between", value1, value2, "parentId");
			return (Criteria) this;
		}

		public Criteria andDescriptionIsNull() {
			addCriterion("description is null");
			return (Criteria) this;
		}

		public Criteria andDescriptionIsNotNull() {
			addCriterion("description is not null");
			return (Criteria) this;
		}

		public Criteria andDescriptionEqualTo(String value) {
			addCriterion("description =", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotEqualTo(String value) {
			addCriterion("description <>", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionGreaterThan(String value) {
			addCriterion("description >", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
			addCriterion("description >=", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionLessThan(String value) {
			addCriterion("description <", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionLessThanOrEqualTo(String value) {
			addCriterion("description <=", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionLike(String value) {
			addCriterion("description like", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotLike(String value) {
			addCriterion("description not like", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionIn(List<String> values) {
			addCriterion("description in", values, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotIn(List<String> values) {
			addCriterion("description not in", values, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionBetween(String value1, String value2) {
			addCriterion("description between", value1, value2, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotBetween(String value1, String value2) {
			addCriterion("description not between", value1, value2, "description");
			return (Criteria) this;
		}

		public Criteria andOptNameLikeInsensitive(String value) {
			addCriterion("upper(opt_name) like", value.toUpperCase(), "optName");
			return (Criteria) this;
		}

		public Criteria andOptKeyLikeInsensitive(String value) {
			addCriterion("upper(opt_key) like", value.toUpperCase(), "optKey");
			return (Criteria) this;
		}

		public Criteria andOptValLikeInsensitive(String value) {
			addCriterion("upper(opt_val) like", value.toUpperCase(), "optVal");
			return (Criteria) this;
		}

		public Criteria andDescriptionLikeInsensitive(String value) {
			addCriterion("upper(description) like", value.toUpperCase(), "description");
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