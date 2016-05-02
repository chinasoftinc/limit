package com.athena.module.areas.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import com.athena.common.dto.Pagination;

public class AreaExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_AREAS
     *
     * @mbggenerated Fri Apr 29 23:51:40 CST 2016
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_AREAS
     *
     * @mbggenerated Fri Apr 29 23:51:40 CST 2016
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_AREAS
     *
     * @mbggenerated Fri Apr 29 23:51:40 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_AREAS
     *
     * @mbggenerated Fri Apr 29 23:51:40 CST 2016
     */
    protected Pagination pagination;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_AREAS
     *
     * @mbggenerated Fri Apr 29 23:51:40 CST 2016
     */
    public AreaExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_AREAS
     *
     * @mbggenerated Fri Apr 29 23:51:40 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_AREAS
     *
     * @mbggenerated Fri Apr 29 23:51:40 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_AREAS
     *
     * @mbggenerated Fri Apr 29 23:51:40 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_AREAS
     *
     * @mbggenerated Fri Apr 29 23:51:40 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_AREAS
     *
     * @mbggenerated Fri Apr 29 23:51:40 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_AREAS
     *
     * @mbggenerated Fri Apr 29 23:51:40 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_AREAS
     *
     * @mbggenerated Fri Apr 29 23:51:40 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_AREAS
     *
     * @mbggenerated Fri Apr 29 23:51:40 CST 2016
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_AREAS
     *
     * @mbggenerated Fri Apr 29 23:51:40 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_AREAS
     *
     * @mbggenerated Fri Apr 29 23:51:40 CST 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_AREAS
     *
     * @mbggenerated Fri Apr 29 23:51:40 CST 2016
     */
    public void setPagination(Pagination pagination) {
        this.pagination=pagination;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_AREAS
     *
     * @mbggenerated Fri Apr 29 23:51:40 CST 2016
     */
    public Pagination getPagination() {
        return pagination;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table T_AREAS
     *
     * @mbggenerated Fri Apr 29 23:51:40 CST 2016
     */
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

        public Criteria andAreasNameIsNull() {
            addCriterion("AREAS_NAME is null");
            return (Criteria) this;
        }

        public Criteria andAreasNameIsNotNull() {
            addCriterion("AREAS_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andAreasNameEqualTo(String value) {
            addCriterion("AREAS_NAME =", value, "areasName");
            return (Criteria) this;
        }

        public Criteria andAreasNameNotEqualTo(String value) {
            addCriterion("AREAS_NAME <>", value, "areasName");
            return (Criteria) this;
        }

        public Criteria andAreasNameGreaterThan(String value) {
            addCriterion("AREAS_NAME >", value, "areasName");
            return (Criteria) this;
        }

        public Criteria andAreasNameGreaterThanOrEqualTo(String value) {
            addCriterion("AREAS_NAME >=", value, "areasName");
            return (Criteria) this;
        }

        public Criteria andAreasNameLessThan(String value) {
            addCriterion("AREAS_NAME <", value, "areasName");
            return (Criteria) this;
        }

        public Criteria andAreasNameLessThanOrEqualTo(String value) {
            addCriterion("AREAS_NAME <=", value, "areasName");
            return (Criteria) this;
        }

        public Criteria andAreasNameLike(String value) {
            addCriterion("AREAS_NAME like", value, "areasName");
            return (Criteria) this;
        }

        public Criteria andAreasNameNotLike(String value) {
            addCriterion("AREAS_NAME not like", value, "areasName");
            return (Criteria) this;
        }

        public Criteria andAreasNameIn(List<String> values) {
            addCriterion("AREAS_NAME in", values, "areasName");
            return (Criteria) this;
        }

        public Criteria andAreasNameNotIn(List<String> values) {
            addCriterion("AREAS_NAME not in", values, "areasName");
            return (Criteria) this;
        }

        public Criteria andAreasNameBetween(String value1, String value2) {
            addCriterion("AREAS_NAME between", value1, value2, "areasName");
            return (Criteria) this;
        }

        public Criteria andAreasNameNotBetween(String value1, String value2) {
            addCriterion("AREAS_NAME not between", value1, value2, "areasName");
            return (Criteria) this;
        }

        public Criteria andAreasHeadLetterIsNull() {
            addCriterion("AREAS_HEAD_LETTER is null");
            return (Criteria) this;
        }

        public Criteria andAreasHeadLetterIsNotNull() {
            addCriterion("AREAS_HEAD_LETTER is not null");
            return (Criteria) this;
        }

        public Criteria andAreasHeadLetterEqualTo(String value) {
            addCriterion("AREAS_HEAD_LETTER =", value, "areasHeadLetter");
            return (Criteria) this;
        }

        public Criteria andAreasHeadLetterNotEqualTo(String value) {
            addCriterion("AREAS_HEAD_LETTER <>", value, "areasHeadLetter");
            return (Criteria) this;
        }

        public Criteria andAreasHeadLetterGreaterThan(String value) {
            addCriterion("AREAS_HEAD_LETTER >", value, "areasHeadLetter");
            return (Criteria) this;
        }

        public Criteria andAreasHeadLetterGreaterThanOrEqualTo(String value) {
            addCriterion("AREAS_HEAD_LETTER >=", value, "areasHeadLetter");
            return (Criteria) this;
        }

        public Criteria andAreasHeadLetterLessThan(String value) {
            addCriterion("AREAS_HEAD_LETTER <", value, "areasHeadLetter");
            return (Criteria) this;
        }

        public Criteria andAreasHeadLetterLessThanOrEqualTo(String value) {
            addCriterion("AREAS_HEAD_LETTER <=", value, "areasHeadLetter");
            return (Criteria) this;
        }

        public Criteria andAreasHeadLetterLike(String value) {
            addCriterion("AREAS_HEAD_LETTER like", value, "areasHeadLetter");
            return (Criteria) this;
        }

        public Criteria andAreasHeadLetterNotLike(String value) {
            addCriterion("AREAS_HEAD_LETTER not like", value, "areasHeadLetter");
            return (Criteria) this;
        }

        public Criteria andAreasHeadLetterIn(List<String> values) {
            addCriterion("AREAS_HEAD_LETTER in", values, "areasHeadLetter");
            return (Criteria) this;
        }

        public Criteria andAreasHeadLetterNotIn(List<String> values) {
            addCriterion("AREAS_HEAD_LETTER not in", values, "areasHeadLetter");
            return (Criteria) this;
        }

        public Criteria andAreasHeadLetterBetween(String value1, String value2) {
            addCriterion("AREAS_HEAD_LETTER between", value1, value2, "areasHeadLetter");
            return (Criteria) this;
        }

        public Criteria andAreasHeadLetterNotBetween(String value1, String value2) {
            addCriterion("AREAS_HEAD_LETTER not between", value1, value2, "areasHeadLetter");
            return (Criteria) this;
        }

        public Criteria andAreasParentIdIsNull() {
            addCriterion("AREAS_PARENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andAreasParentIdIsNotNull() {
            addCriterion("AREAS_PARENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAreasParentIdEqualTo(BigDecimal value) {
            addCriterion("AREAS_PARENT_ID =", value, "areasParentId");
            return (Criteria) this;
        }

        public Criteria andAreasParentIdNotEqualTo(BigDecimal value) {
            addCriterion("AREAS_PARENT_ID <>", value, "areasParentId");
            return (Criteria) this;
        }

        public Criteria andAreasParentIdGreaterThan(BigDecimal value) {
            addCriterion("AREAS_PARENT_ID >", value, "areasParentId");
            return (Criteria) this;
        }

        public Criteria andAreasParentIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("AREAS_PARENT_ID >=", value, "areasParentId");
            return (Criteria) this;
        }

        public Criteria andAreasParentIdLessThan(BigDecimal value) {
            addCriterion("AREAS_PARENT_ID <", value, "areasParentId");
            return (Criteria) this;
        }

        public Criteria andAreasParentIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("AREAS_PARENT_ID <=", value, "areasParentId");
            return (Criteria) this;
        }

        public Criteria andAreasParentIdIn(List<BigDecimal> values) {
            addCriterion("AREAS_PARENT_ID in", values, "areasParentId");
            return (Criteria) this;
        }

        public Criteria andAreasParentIdNotIn(List<BigDecimal> values) {
            addCriterion("AREAS_PARENT_ID not in", values, "areasParentId");
            return (Criteria) this;
        }

        public Criteria andAreasParentIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AREAS_PARENT_ID between", value1, value2, "areasParentId");
            return (Criteria) this;
        }

        public Criteria andAreasParentIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AREAS_PARENT_ID not between", value1, value2, "areasParentId");
            return (Criteria) this;
        }

        public Criteria andAreasSortNoIsNull() {
            addCriterion("AREAS_SORT_NO is null");
            return (Criteria) this;
        }

        public Criteria andAreasSortNoIsNotNull() {
            addCriterion("AREAS_SORT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andAreasSortNoEqualTo(Short value) {
            addCriterion("AREAS_SORT_NO =", value, "areasSortNo");
            return (Criteria) this;
        }

        public Criteria andAreasSortNoNotEqualTo(Short value) {
            addCriterion("AREAS_SORT_NO <>", value, "areasSortNo");
            return (Criteria) this;
        }

        public Criteria andAreasSortNoGreaterThan(Short value) {
            addCriterion("AREAS_SORT_NO >", value, "areasSortNo");
            return (Criteria) this;
        }

        public Criteria andAreasSortNoGreaterThanOrEqualTo(Short value) {
            addCriterion("AREAS_SORT_NO >=", value, "areasSortNo");
            return (Criteria) this;
        }

        public Criteria andAreasSortNoLessThan(Short value) {
            addCriterion("AREAS_SORT_NO <", value, "areasSortNo");
            return (Criteria) this;
        }

        public Criteria andAreasSortNoLessThanOrEqualTo(Short value) {
            addCriterion("AREAS_SORT_NO <=", value, "areasSortNo");
            return (Criteria) this;
        }

        public Criteria andAreasSortNoIn(List<Short> values) {
            addCriterion("AREAS_SORT_NO in", values, "areasSortNo");
            return (Criteria) this;
        }

        public Criteria andAreasSortNoNotIn(List<Short> values) {
            addCriterion("AREAS_SORT_NO not in", values, "areasSortNo");
            return (Criteria) this;
        }

        public Criteria andAreasSortNoBetween(Short value1, Short value2) {
            addCriterion("AREAS_SORT_NO between", value1, value2, "areasSortNo");
            return (Criteria) this;
        }

        public Criteria andAreasSortNoNotBetween(Short value1, Short value2) {
            addCriterion("AREAS_SORT_NO not between", value1, value2, "areasSortNo");
            return (Criteria) this;
        }

        public Criteria andAreasDeepIsNull() {
            addCriterion("AREAS_DEEP is null");
            return (Criteria) this;
        }

        public Criteria andAreasDeepIsNotNull() {
            addCriterion("AREAS_DEEP is not null");
            return (Criteria) this;
        }

        public Criteria andAreasDeepEqualTo(Short value) {
            addCriterion("AREAS_DEEP =", value, "areasDeep");
            return (Criteria) this;
        }

        public Criteria andAreasDeepNotEqualTo(Short value) {
            addCriterion("AREAS_DEEP <>", value, "areasDeep");
            return (Criteria) this;
        }

        public Criteria andAreasDeepGreaterThan(Short value) {
            addCriterion("AREAS_DEEP >", value, "areasDeep");
            return (Criteria) this;
        }

        public Criteria andAreasDeepGreaterThanOrEqualTo(Short value) {
            addCriterion("AREAS_DEEP >=", value, "areasDeep");
            return (Criteria) this;
        }

        public Criteria andAreasDeepLessThan(Short value) {
            addCriterion("AREAS_DEEP <", value, "areasDeep");
            return (Criteria) this;
        }

        public Criteria andAreasDeepLessThanOrEqualTo(Short value) {
            addCriterion("AREAS_DEEP <=", value, "areasDeep");
            return (Criteria) this;
        }

        public Criteria andAreasDeepIn(List<Short> values) {
            addCriterion("AREAS_DEEP in", values, "areasDeep");
            return (Criteria) this;
        }

        public Criteria andAreasDeepNotIn(List<Short> values) {
            addCriterion("AREAS_DEEP not in", values, "areasDeep");
            return (Criteria) this;
        }

        public Criteria andAreasDeepBetween(Short value1, Short value2) {
            addCriterion("AREAS_DEEP between", value1, value2, "areasDeep");
            return (Criteria) this;
        }

        public Criteria andAreasDeepNotBetween(Short value1, Short value2) {
            addCriterion("AREAS_DEEP not between", value1, value2, "areasDeep");
            return (Criteria) this;
        }

        public Criteria andAreasNameLikeInsensitive(String value) {
            addCriterion("upper(AREAS_NAME) like", value.toUpperCase(), "areasName");
            return (Criteria) this;
        }

        public Criteria andAreasHeadLetterLikeInsensitive(String value) {
            addCriterion("upper(AREAS_HEAD_LETTER) like", value.toUpperCase(), "areasHeadLetter");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table T_AREAS
     *
     * @mbggenerated do_not_delete_during_merge Fri Apr 29 23:51:40 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table T_AREAS
     *
     * @mbggenerated Fri Apr 29 23:51:40 CST 2016
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
}