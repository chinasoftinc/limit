package com.athena.module.dictionaries.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.athena.common.dto.Pagination;

public class DictionaryExample {
	
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	protected Pagination pagination;

	public DictionaryExample() {
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
			addCriterion("ID is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("ID is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(BigDecimal value) {
			addCriterion("ID =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(BigDecimal value) {
			addCriterion("ID <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(BigDecimal value) {
			addCriterion("ID >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("ID >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(BigDecimal value) {
			addCriterion("ID <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(BigDecimal value) {
			addCriterion("ID <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<BigDecimal> values) {
			addCriterion("ID in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<BigDecimal> values) {
			addCriterion("ID not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("ID between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("ID not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andOptNameIsNull() {
			addCriterion("OPT_NAME is null");
			return (Criteria) this;
		}

		public Criteria andOptNameIsNotNull() {
			addCriterion("OPT_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andOptNameEqualTo(String value) {
			addCriterion("OPT_NAME =", value, "optName");
			return (Criteria) this;
		}

		public Criteria andOptNameNotEqualTo(String value) {
			addCriterion("OPT_NAME <>", value, "optName");
			return (Criteria) this;
		}

		public Criteria andOptNameGreaterThan(String value) {
			addCriterion("OPT_NAME >", value, "optName");
			return (Criteria) this;
		}

		public Criteria andOptNameGreaterThanOrEqualTo(String value) {
			addCriterion("OPT_NAME >=", value, "optName");
			return (Criteria) this;
		}

		public Criteria andOptNameLessThan(String value) {
			addCriterion("OPT_NAME <", value, "optName");
			return (Criteria) this;
		}

		public Criteria andOptNameLessThanOrEqualTo(String value) {
			addCriterion("OPT_NAME <=", value, "optName");
			return (Criteria) this;
		}

		public Criteria andOptNameLike(String value) {
			addCriterion("OPT_NAME like", value, "optName");
			return (Criteria) this;
		}

		public Criteria andOptNameNotLike(String value) {
			addCriterion("OPT_NAME not like", value, "optName");
			return (Criteria) this;
		}

		public Criteria andOptNameIn(List<String> values) {
			addCriterion("OPT_NAME in", values, "optName");
			return (Criteria) this;
		}

		public Criteria andOptNameNotIn(List<String> values) {
			addCriterion("OPT_NAME not in", values, "optName");
			return (Criteria) this;
		}

		public Criteria andOptNameBetween(String value1, String value2) {
			addCriterion("OPT_NAME between", value1, value2, "optName");
			return (Criteria) this;
		}

		public Criteria andOptNameNotBetween(String value1, String value2) {
			addCriterion("OPT_NAME not between", value1, value2, "optName");
			return (Criteria) this;
		}

		public Criteria andOptKeyIsNull() {
			addCriterion("OPT_KEY is null");
			return (Criteria) this;
		}

		public Criteria andOptKeyIsNotNull() {
			addCriterion("OPT_KEY is not null");
			return (Criteria) this;
		}

		public Criteria andOptKeyEqualTo(String value) {
			addCriterion("OPT_KEY =", value, "optKey");
			return (Criteria) this;
		}

		public Criteria andOptKeyNotEqualTo(String value) {
			addCriterion("OPT_KEY <>", value, "optKey");
			return (Criteria) this;
		}

		public Criteria andOptKeyGreaterThan(String value) {
			addCriterion("OPT_KEY >", value, "optKey");
			return (Criteria) this;
		}

		public Criteria andOptKeyGreaterThanOrEqualTo(String value) {
			addCriterion("OPT_KEY >=", value, "optKey");
			return (Criteria) this;
		}

		public Criteria andOptKeyLessThan(String value) {
			addCriterion("OPT_KEY <", value, "optKey");
			return (Criteria) this;
		}

		public Criteria andOptKeyLessThanOrEqualTo(String value) {
			addCriterion("OPT_KEY <=", value, "optKey");
			return (Criteria) this;
		}

		public Criteria andOptKeyLike(String value) {
			addCriterion("OPT_KEY like", value, "optKey");
			return (Criteria) this;
		}

		public Criteria andOptKeyNotLike(String value) {
			addCriterion("OPT_KEY not like", value, "optKey");
			return (Criteria) this;
		}

		public Criteria andOptKeyIn(List<String> values) {
			addCriterion("OPT_KEY in", values, "optKey");
			return (Criteria) this;
		}

		public Criteria andOptKeyNotIn(List<String> values) {
			addCriterion("OPT_KEY not in", values, "optKey");
			return (Criteria) this;
		}

		public Criteria andOptKeyBetween(String value1, String value2) {
			addCriterion("OPT_KEY between", value1, value2, "optKey");
			return (Criteria) this;
		}

		public Criteria andOptKeyNotBetween(String value1, String value2) {
			addCriterion("OPT_KEY not between", value1, value2, "optKey");
			return (Criteria) this;
		}

		public Criteria andOptValueIsNull() {
			addCriterion("OPT_VALUE is null");
			return (Criteria) this;
		}

		public Criteria andOptValueIsNotNull() {
			addCriterion("OPT_VALUE is not null");
			return (Criteria) this;
		}

		public Criteria andOptValueEqualTo(String value) {
			addCriterion("OPT_VALUE =", value, "optValue");
			return (Criteria) this;
		}

		public Criteria andOptValueNotEqualTo(String value) {
			addCriterion("OPT_VALUE <>", value, "optValue");
			return (Criteria) this;
		}

		public Criteria andOptValueGreaterThan(String value) {
			addCriterion("OPT_VALUE >", value, "optValue");
			return (Criteria) this;
		}

		public Criteria andOptValueGreaterThanOrEqualTo(String value) {
			addCriterion("OPT_VALUE >=", value, "optValue");
			return (Criteria) this;
		}

		public Criteria andOptValueLessThan(String value) {
			addCriterion("OPT_VALUE <", value, "optValue");
			return (Criteria) this;
		}

		public Criteria andOptValueLessThanOrEqualTo(String value) {
			addCriterion("OPT_VALUE <=", value, "optValue");
			return (Criteria) this;
		}

		public Criteria andOptValueLike(String value) {
			addCriterion("OPT_VALUE like", value, "optValue");
			return (Criteria) this;
		}

		public Criteria andOptValueNotLike(String value) {
			addCriterion("OPT_VALUE not like", value, "optValue");
			return (Criteria) this;
		}

		public Criteria andOptValueIn(List<String> values) {
			addCriterion("OPT_VALUE in", values, "optValue");
			return (Criteria) this;
		}

		public Criteria andOptValueNotIn(List<String> values) {
			addCriterion("OPT_VALUE not in", values, "optValue");
			return (Criteria) this;
		}

		public Criteria andOptValueBetween(String value1, String value2) {
			addCriterion("OPT_VALUE between", value1, value2, "optValue");
			return (Criteria) this;
		}

		public Criteria andOptValueNotBetween(String value1, String value2) {
			addCriterion("OPT_VALUE not between", value1, value2, "optValue");
			return (Criteria) this;
		}

		public Criteria andOptParentIdIsNull() {
			addCriterion("OPT_PARENT_ID is null");
			return (Criteria) this;
		}

		public Criteria andOptParentIdIsNotNull() {
			addCriterion("OPT_PARENT_ID is not null");
			return (Criteria) this;
		}

		public Criteria andOptParentIdEqualTo(BigDecimal value) {
			addCriterion("OPT_PARENT_ID =", value, "optParentId");
			return (Criteria) this;
		}

		public Criteria andOptParentIdNotEqualTo(BigDecimal value) {
			addCriterion("OPT_PARENT_ID <>", value, "optParentId");
			return (Criteria) this;
		}

		public Criteria andOptParentIdGreaterThan(BigDecimal value) {
			addCriterion("OPT_PARENT_ID >", value, "optParentId");
			return (Criteria) this;
		}

		public Criteria andOptParentIdGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("OPT_PARENT_ID >=", value, "optParentId");
			return (Criteria) this;
		}

		public Criteria andOptParentIdLessThan(BigDecimal value) {
			addCriterion("OPT_PARENT_ID <", value, "optParentId");
			return (Criteria) this;
		}

		public Criteria andOptParentIdLessThanOrEqualTo(BigDecimal value) {
			addCriterion("OPT_PARENT_ID <=", value, "optParentId");
			return (Criteria) this;
		}

		public Criteria andOptParentIdIn(List<BigDecimal> values) {
			addCriterion("OPT_PARENT_ID in", values, "optParentId");
			return (Criteria) this;
		}

		public Criteria andOptParentIdNotIn(List<BigDecimal> values) {
			addCriterion("OPT_PARENT_ID not in", values, "optParentId");
			return (Criteria) this;
		}

		public Criteria andOptParentIdBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("OPT_PARENT_ID between", value1, value2, "optParentId");
			return (Criteria) this;
		}

		public Criteria andOptParentIdNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("OPT_PARENT_ID not between", value1, value2, "optParentId");
			return (Criteria) this;
		}

		public Criteria andOptDescriptionIsNull() {
			addCriterion("OPT_DESCRIPTION is null");
			return (Criteria) this;
		}

		public Criteria andOptDescriptionIsNotNull() {
			addCriterion("OPT_DESCRIPTION is not null");
			return (Criteria) this;
		}

		public Criteria andOptDescriptionEqualTo(String value) {
			addCriterion("OPT_DESCRIPTION =", value, "optDescription");
			return (Criteria) this;
		}

		public Criteria andOptDescriptionNotEqualTo(String value) {
			addCriterion("OPT_DESCRIPTION <>", value, "optDescription");
			return (Criteria) this;
		}

		public Criteria andOptDescriptionGreaterThan(String value) {
			addCriterion("OPT_DESCRIPTION >", value, "optDescription");
			return (Criteria) this;
		}

		public Criteria andOptDescriptionGreaterThanOrEqualTo(String value) {
			addCriterion("OPT_DESCRIPTION >=", value, "optDescription");
			return (Criteria) this;
		}

		public Criteria andOptDescriptionLessThan(String value) {
			addCriterion("OPT_DESCRIPTION <", value, "optDescription");
			return (Criteria) this;
		}

		public Criteria andOptDescriptionLessThanOrEqualTo(String value) {
			addCriterion("OPT_DESCRIPTION <=", value, "optDescription");
			return (Criteria) this;
		}

		public Criteria andOptDescriptionLike(String value) {
			addCriterion("OPT_DESCRIPTION like", value, "optDescription");
			return (Criteria) this;
		}

		public Criteria andOptDescriptionNotLike(String value) {
			addCriterion("OPT_DESCRIPTION not like", value, "optDescription");
			return (Criteria) this;
		}

		public Criteria andOptDescriptionIn(List<String> values) {
			addCriterion("OPT_DESCRIPTION in", values, "optDescription");
			return (Criteria) this;
		}

		public Criteria andOptDescriptionNotIn(List<String> values) {
			addCriterion("OPT_DESCRIPTION not in", values, "optDescription");
			return (Criteria) this;
		}

		public Criteria andOptDescriptionBetween(String value1, String value2) {
			addCriterion("OPT_DESCRIPTION between", value1, value2, "optDescription");
			return (Criteria) this;
		}

		public Criteria andOptDescriptionNotBetween(String value1, String value2) {
			addCriterion("OPT_DESCRIPTION not between", value1, value2, "optDescription");
			return (Criteria) this;
		}

		public Criteria andOptSortNoIsNull() {
			addCriterion("OPT_SORT_NO is null");
			return (Criteria) this;
		}

		public Criteria andOptSortNoIsNotNull() {
			addCriterion("OPT_SORT_NO is not null");
			return (Criteria) this;
		}

		public Criteria andOptSortNoEqualTo(Short value) {
			addCriterion("OPT_SORT_NO =", value, "optSortNo");
			return (Criteria) this;
		}

		public Criteria andOptSortNoNotEqualTo(Short value) {
			addCriterion("OPT_SORT_NO <>", value, "optSortNo");
			return (Criteria) this;
		}

		public Criteria andOptSortNoGreaterThan(Short value) {
			addCriterion("OPT_SORT_NO >", value, "optSortNo");
			return (Criteria) this;
		}

		public Criteria andOptSortNoGreaterThanOrEqualTo(Short value) {
			addCriterion("OPT_SORT_NO >=", value, "optSortNo");
			return (Criteria) this;
		}

		public Criteria andOptSortNoLessThan(Short value) {
			addCriterion("OPT_SORT_NO <", value, "optSortNo");
			return (Criteria) this;
		}

		public Criteria andOptSortNoLessThanOrEqualTo(Short value) {
			addCriterion("OPT_SORT_NO <=", value, "optSortNo");
			return (Criteria) this;
		}

		public Criteria andOptSortNoIn(List<Short> values) {
			addCriterion("OPT_SORT_NO in", values, "optSortNo");
			return (Criteria) this;
		}

		public Criteria andOptSortNoNotIn(List<Short> values) {
			addCriterion("OPT_SORT_NO not in", values, "optSortNo");
			return (Criteria) this;
		}

		public Criteria andOptSortNoBetween(Short value1, Short value2) {
			addCriterion("OPT_SORT_NO between", value1, value2, "optSortNo");
			return (Criteria) this;
		}

		public Criteria andOptSortNoNotBetween(Short value1, Short value2) {
			addCriterion("OPT_SORT_NO not between", value1, value2, "optSortNo");
			return (Criteria) this;
		}

		public Criteria andOptIsDirIsNull() {
			addCriterion("OPT_IS_DIR is null");
			return (Criteria) this;
		}

		public Criteria andOptIsDirIsNotNull() {
			addCriterion("OPT_IS_DIR is not null");
			return (Criteria) this;
		}

		public Criteria andOptIsDirEqualTo(String value) {
			addCriterion("OPT_IS_DIR =", value, "optIsDir");
			return (Criteria) this;
		}

		public Criteria andOptIsDirNotEqualTo(String value) {
			addCriterion("OPT_IS_DIR <>", value, "optIsDir");
			return (Criteria) this;
		}

		public Criteria andOptIsDirGreaterThan(String value) {
			addCriterion("OPT_IS_DIR >", value, "optIsDir");
			return (Criteria) this;
		}

		public Criteria andOptIsDirGreaterThanOrEqualTo(String value) {
			addCriterion("OPT_IS_DIR >=", value, "optIsDir");
			return (Criteria) this;
		}

		public Criteria andOptIsDirLessThan(String value) {
			addCriterion("OPT_IS_DIR <", value, "optIsDir");
			return (Criteria) this;
		}

		public Criteria andOptIsDirLessThanOrEqualTo(String value) {
			addCriterion("OPT_IS_DIR <=", value, "optIsDir");
			return (Criteria) this;
		}

		public Criteria andOptIsDirLike(String value) {
			addCriterion("OPT_IS_DIR like", value, "optIsDir");
			return (Criteria) this;
		}

		public Criteria andOptIsDirNotLike(String value) {
			addCriterion("OPT_IS_DIR not like", value, "optIsDir");
			return (Criteria) this;
		}

		public Criteria andOptIsDirIn(List<String> values) {
			addCriterion("OPT_IS_DIR in", values, "optIsDir");
			return (Criteria) this;
		}

		public Criteria andOptIsDirNotIn(List<String> values) {
			addCriterion("OPT_IS_DIR not in", values, "optIsDir");
			return (Criteria) this;
		}

		public Criteria andOptIsDirBetween(String value1, String value2) {
			addCriterion("OPT_IS_DIR between", value1, value2, "optIsDir");
			return (Criteria) this;
		}

		public Criteria andOptIsDirNotBetween(String value1, String value2) {
			addCriterion("OPT_IS_DIR not between", value1, value2, "optIsDir");
			return (Criteria) this;
		}

		public Criteria andOptTypeIsNull() {
			addCriterion("OPT_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andOptTypeIsNotNull() {
			addCriterion("OPT_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andOptTypeEqualTo(String value) {
			addCriterion("OPT_TYPE =", value, "optType");
			return (Criteria) this;
		}

		public Criteria andOptTypeNotEqualTo(String value) {
			addCriterion("OPT_TYPE <>", value, "optType");
			return (Criteria) this;
		}

		public Criteria andOptTypeGreaterThan(String value) {
			addCriterion("OPT_TYPE >", value, "optType");
			return (Criteria) this;
		}

		public Criteria andOptTypeGreaterThanOrEqualTo(String value) {
			addCriterion("OPT_TYPE >=", value, "optType");
			return (Criteria) this;
		}

		public Criteria andOptTypeLessThan(String value) {
			addCriterion("OPT_TYPE <", value, "optType");
			return (Criteria) this;
		}

		public Criteria andOptTypeLessThanOrEqualTo(String value) {
			addCriterion("OPT_TYPE <=", value, "optType");
			return (Criteria) this;
		}

		public Criteria andOptTypeLike(String value) {
			addCriterion("OPT_TYPE like", value, "optType");
			return (Criteria) this;
		}

		public Criteria andOptTypeNotLike(String value) {
			addCriterion("OPT_TYPE not like", value, "optType");
			return (Criteria) this;
		}

		public Criteria andOptTypeIn(List<String> values) {
			addCriterion("OPT_TYPE in", values, "optType");
			return (Criteria) this;
		}

		public Criteria andOptTypeNotIn(List<String> values) {
			addCriterion("OPT_TYPE not in", values, "optType");
			return (Criteria) this;
		}

		public Criteria andOptTypeBetween(String value1, String value2) {
			addCriterion("OPT_TYPE between", value1, value2, "optType");
			return (Criteria) this;
		}

		public Criteria andOptTypeNotBetween(String value1, String value2) {
			addCriterion("OPT_TYPE not between", value1, value2, "optType");
			return (Criteria) this;
		}

		public Criteria andOptDeepIsNull() {
			addCriterion("OPT_DEEP is null");
			return (Criteria) this;
		}

		public Criteria andOptDeepIsNotNull() {
			addCriterion("OPT_DEEP is not null");
			return (Criteria) this;
		}

		public Criteria andOptDeepEqualTo(Short value) {
			addCriterion("OPT_DEEP =", value, "optDeep");
			return (Criteria) this;
		}

		public Criteria andOptDeepNotEqualTo(Short value) {
			addCriterion("OPT_DEEP <>", value, "optDeep");
			return (Criteria) this;
		}

		public Criteria andOptDeepGreaterThan(Short value) {
			addCriterion("OPT_DEEP >", value, "optDeep");
			return (Criteria) this;
		}

		public Criteria andOptDeepGreaterThanOrEqualTo(Short value) {
			addCriterion("OPT_DEEP >=", value, "optDeep");
			return (Criteria) this;
		}

		public Criteria andOptDeepLessThan(Short value) {
			addCriterion("OPT_DEEP <", value, "optDeep");
			return (Criteria) this;
		}

		public Criteria andOptDeepLessThanOrEqualTo(Short value) {
			addCriterion("OPT_DEEP <=", value, "optDeep");
			return (Criteria) this;
		}

		public Criteria andOptDeepIn(List<Short> values) {
			addCriterion("OPT_DEEP in", values, "optDeep");
			return (Criteria) this;
		}

		public Criteria andOptDeepNotIn(List<Short> values) {
			addCriterion("OPT_DEEP not in", values, "optDeep");
			return (Criteria) this;
		}

		public Criteria andOptDeepBetween(Short value1, Short value2) {
			addCriterion("OPT_DEEP between", value1, value2, "optDeep");
			return (Criteria) this;
		}

		public Criteria andOptDeepNotBetween(Short value1, Short value2) {
			addCriterion("OPT_DEEP not between", value1, value2, "optDeep");
			return (Criteria) this;
		}

		public Criteria andOptNameLikeInsensitive(String value) {
			addCriterion("upper(OPT_NAME) like", value.toUpperCase(), "optName");
			return (Criteria) this;
		}

		public Criteria andOptKeyLikeInsensitive(String value) {
			addCriterion("upper(OPT_KEY) like", value.toUpperCase(), "optKey");
			return (Criteria) this;
		}

		public Criteria andOptValueLikeInsensitive(String value) {
			addCriterion("upper(OPT_VALUE) like", value.toUpperCase(), "optValue");
			return (Criteria) this;
		}

		public Criteria andOptDescriptionLikeInsensitive(String value) {
			addCriterion("upper(OPT_DESCRIPTION) like", value.toUpperCase(), "optDescription");
			return (Criteria) this;
		}

		public Criteria andOptIsDirLikeInsensitive(String value) {
			addCriterion("upper(OPT_IS_DIR) like", value.toUpperCase(), "optIsDir");
			return (Criteria) this;
		}

		public Criteria andOptTypeLikeInsensitive(String value) {
			addCriterion("upper(OPT_TYPE) like", value.toUpperCase(), "optType");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table T_DICTIONARIES
	 * @mbggenerated Fri Apr 29 23:54:15 CST 2016
	 */
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

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table T_DICTIONARIES
	 * @mbggenerated do_not_delete_during_merge Fri Apr 29 23:54:15 CST 2016
	 */
	public static class Criteria extends GeneratedCriteria {

		protected Criteria() {
			super();
		}
	}
}