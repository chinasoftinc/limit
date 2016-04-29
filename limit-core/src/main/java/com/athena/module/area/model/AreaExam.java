package com.athena.module.area.model;

import java.util.ArrayList;
import java.util.List;

import com.athena.common.base.entity.Model;
import com.athena.common.dto.Pagination;

public class AreaExam extends Model<AreaExam> {
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	protected Pagination pagination;

	public AreaExam() {
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

		public Criteria andAreaidIsNull() {
			addCriterion("AreaId is null");
			return (Criteria) this;
		}

		public Criteria andAreaidIsNotNull() {
			addCriterion("AreaId is not null");
			return (Criteria) this;
		}

		public Criteria andAreaidEqualTo(Long value) {
			addCriterion("AreaId =", value, "areaid");
			return (Criteria) this;
		}

		public Criteria andAreaidNotEqualTo(Long value) {
			addCriterion("AreaId <>", value, "areaid");
			return (Criteria) this;
		}

		public Criteria andAreaidGreaterThan(Long value) {
			addCriterion("AreaId >", value, "areaid");
			return (Criteria) this;
		}

		public Criteria andAreaidGreaterThanOrEqualTo(Long value) {
			addCriterion("AreaId >=", value, "areaid");
			return (Criteria) this;
		}

		public Criteria andAreaidLessThan(Long value) {
			addCriterion("AreaId <", value, "areaid");
			return (Criteria) this;
		}

		public Criteria andAreaidLessThanOrEqualTo(Long value) {
			addCriterion("AreaId <=", value, "areaid");
			return (Criteria) this;
		}

		public Criteria andAreaidIn(List<Long> values) {
			addCriterion("AreaId in", values, "areaid");
			return (Criteria) this;
		}

		public Criteria andAreaidNotIn(List<Long> values) {
			addCriterion("AreaId not in", values, "areaid");
			return (Criteria) this;
		}

		public Criteria andAreaidBetween(Long value1, Long value2) {
			addCriterion("AreaId between", value1, value2, "areaid");
			return (Criteria) this;
		}

		public Criteria andAreaidNotBetween(Long value1, Long value2) {
			addCriterion("AreaId not between", value1, value2, "areaid");
			return (Criteria) this;
		}

		public Criteria andAreanameIsNull() {
			addCriterion("AreaName is null");
			return (Criteria) this;
		}

		public Criteria andAreanameIsNotNull() {
			addCriterion("AreaName is not null");
			return (Criteria) this;
		}

		public Criteria andAreanameEqualTo(String value) {
			addCriterion("AreaName =", value, "areaname");
			return (Criteria) this;
		}

		public Criteria andAreanameNotEqualTo(String value) {
			addCriterion("AreaName <>", value, "areaname");
			return (Criteria) this;
		}

		public Criteria andAreanameGreaterThan(String value) {
			addCriterion("AreaName >", value, "areaname");
			return (Criteria) this;
		}

		public Criteria andAreanameGreaterThanOrEqualTo(String value) {
			addCriterion("AreaName >=", value, "areaname");
			return (Criteria) this;
		}

		public Criteria andAreanameLessThan(String value) {
			addCriterion("AreaName <", value, "areaname");
			return (Criteria) this;
		}

		public Criteria andAreanameLessThanOrEqualTo(String value) {
			addCriterion("AreaName <=", value, "areaname");
			return (Criteria) this;
		}

		public Criteria andAreanameLike(String value) {
			addCriterion("AreaName like", value, "areaname");
			return (Criteria) this;
		}

		public Criteria andAreanameNotLike(String value) {
			addCriterion("AreaName not like", value, "areaname");
			return (Criteria) this;
		}

		public Criteria andAreanameIn(List<String> values) {
			addCriterion("AreaName in", values, "areaname");
			return (Criteria) this;
		}

		public Criteria andAreanameNotIn(List<String> values) {
			addCriterion("AreaName not in", values, "areaname");
			return (Criteria) this;
		}

		public Criteria andAreanameBetween(String value1, String value2) {
			addCriterion("AreaName between", value1, value2, "areaname");
			return (Criteria) this;
		}

		public Criteria andAreanameNotBetween(String value1, String value2) {
			addCriterion("AreaName not between", value1, value2, "areaname");
			return (Criteria) this;
		}

		public Criteria andParentareaidIsNull() {
			addCriterion("ParentAreaId is null");
			return (Criteria) this;
		}

		public Criteria andParentareaidIsNotNull() {
			addCriterion("ParentAreaId is not null");
			return (Criteria) this;
		}

		public Criteria andParentareaidEqualTo(Long value) {
			addCriterion("ParentAreaId =", value, "parentareaid");
			return (Criteria) this;
		}

		public Criteria andParentareaidNotEqualTo(Long value) {
			addCriterion("ParentAreaId <>", value, "parentareaid");
			return (Criteria) this;
		}

		public Criteria andParentareaidGreaterThan(Long value) {
			addCriterion("ParentAreaId >", value, "parentareaid");
			return (Criteria) this;
		}

		public Criteria andParentareaidGreaterThanOrEqualTo(Long value) {
			addCriterion("ParentAreaId >=", value, "parentareaid");
			return (Criteria) this;
		}

		public Criteria andParentareaidLessThan(Long value) {
			addCriterion("ParentAreaId <", value, "parentareaid");
			return (Criteria) this;
		}

		public Criteria andParentareaidLessThanOrEqualTo(Long value) {
			addCriterion("ParentAreaId <=", value, "parentareaid");
			return (Criteria) this;
		}

		public Criteria andParentareaidIn(List<Long> values) {
			addCriterion("ParentAreaId in", values, "parentareaid");
			return (Criteria) this;
		}

		public Criteria andParentareaidNotIn(List<Long> values) {
			addCriterion("ParentAreaId not in", values, "parentareaid");
			return (Criteria) this;
		}

		public Criteria andParentareaidBetween(Long value1, Long value2) {
			addCriterion("ParentAreaId between", value1, value2, "parentareaid");
			return (Criteria) this;
		}

		public Criteria andParentareaidNotBetween(Long value1, Long value2) {
			addCriterion("ParentAreaId not between", value1, value2, "parentareaid");
			return (Criteria) this;
		}

		public Criteria andArealevelIsNull() {
			addCriterion("AreaLevel is null");
			return (Criteria) this;
		}

		public Criteria andArealevelIsNotNull() {
			addCriterion("AreaLevel is not null");
			return (Criteria) this;
		}

		public Criteria andArealevelEqualTo(Integer value) {
			addCriterion("AreaLevel =", value, "arealevel");
			return (Criteria) this;
		}

		public Criteria andArealevelNotEqualTo(Integer value) {
			addCriterion("AreaLevel <>", value, "arealevel");
			return (Criteria) this;
		}

		public Criteria andArealevelGreaterThan(Integer value) {
			addCriterion("AreaLevel >", value, "arealevel");
			return (Criteria) this;
		}

		public Criteria andArealevelGreaterThanOrEqualTo(Integer value) {
			addCriterion("AreaLevel >=", value, "arealevel");
			return (Criteria) this;
		}

		public Criteria andArealevelLessThan(Integer value) {
			addCriterion("AreaLevel <", value, "arealevel");
			return (Criteria) this;
		}

		public Criteria andArealevelLessThanOrEqualTo(Integer value) {
			addCriterion("AreaLevel <=", value, "arealevel");
			return (Criteria) this;
		}

		public Criteria andArealevelIn(List<Integer> values) {
			addCriterion("AreaLevel in", values, "arealevel");
			return (Criteria) this;
		}

		public Criteria andArealevelNotIn(List<Integer> values) {
			addCriterion("AreaLevel not in", values, "arealevel");
			return (Criteria) this;
		}

		public Criteria andArealevelBetween(Integer value1, Integer value2) {
			addCriterion("AreaLevel between", value1, value2, "arealevel");
			return (Criteria) this;
		}

		public Criteria andArealevelNotBetween(Integer value1, Integer value2) {
			addCriterion("AreaLevel not between", value1, value2, "arealevel");
			return (Criteria) this;
		}

		public Criteria andAreanameLikeInsensitive(String value) {
			addCriterion("upper(AreaName) like", value.toUpperCase(), "areaname");
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