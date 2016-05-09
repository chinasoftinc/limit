package com.athena.module.departments.model;

import com.athena.common.dto.Pagination;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DepartmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Pagination pagination;

    public DepartmentExample() {
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
        this.pagination=pagination;
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

        public Criteria andDeptCodeIsNull() {
            addCriterion("DEPT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andDeptCodeIsNotNull() {
            addCriterion("DEPT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andDeptCodeEqualTo(String value) {
            addCriterion("DEPT_CODE =", value, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeNotEqualTo(String value) {
            addCriterion("DEPT_CODE <>", value, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeGreaterThan(String value) {
            addCriterion("DEPT_CODE >", value, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeGreaterThanOrEqualTo(String value) {
            addCriterion("DEPT_CODE >=", value, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeLessThan(String value) {
            addCriterion("DEPT_CODE <", value, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeLessThanOrEqualTo(String value) {
            addCriterion("DEPT_CODE <=", value, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeLike(String value) {
            addCriterion("DEPT_CODE like", value, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeNotLike(String value) {
            addCriterion("DEPT_CODE not like", value, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeIn(List<String> values) {
            addCriterion("DEPT_CODE in", values, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeNotIn(List<String> values) {
            addCriterion("DEPT_CODE not in", values, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeBetween(String value1, String value2) {
            addCriterion("DEPT_CODE between", value1, value2, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeNotBetween(String value1, String value2) {
            addCriterion("DEPT_CODE not between", value1, value2, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptShortNameIsNull() {
            addCriterion("DEPT_SHORT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andDeptShortNameIsNotNull() {
            addCriterion("DEPT_SHORT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andDeptShortNameEqualTo(String value) {
            addCriterion("DEPT_SHORT_NAME =", value, "deptShortName");
            return (Criteria) this;
        }

        public Criteria andDeptShortNameNotEqualTo(String value) {
            addCriterion("DEPT_SHORT_NAME <>", value, "deptShortName");
            return (Criteria) this;
        }

        public Criteria andDeptShortNameGreaterThan(String value) {
            addCriterion("DEPT_SHORT_NAME >", value, "deptShortName");
            return (Criteria) this;
        }

        public Criteria andDeptShortNameGreaterThanOrEqualTo(String value) {
            addCriterion("DEPT_SHORT_NAME >=", value, "deptShortName");
            return (Criteria) this;
        }

        public Criteria andDeptShortNameLessThan(String value) {
            addCriterion("DEPT_SHORT_NAME <", value, "deptShortName");
            return (Criteria) this;
        }

        public Criteria andDeptShortNameLessThanOrEqualTo(String value) {
            addCriterion("DEPT_SHORT_NAME <=", value, "deptShortName");
            return (Criteria) this;
        }

        public Criteria andDeptShortNameLike(String value) {
            addCriterion("DEPT_SHORT_NAME like", value, "deptShortName");
            return (Criteria) this;
        }

        public Criteria andDeptShortNameNotLike(String value) {
            addCriterion("DEPT_SHORT_NAME not like", value, "deptShortName");
            return (Criteria) this;
        }

        public Criteria andDeptShortNameIn(List<String> values) {
            addCriterion("DEPT_SHORT_NAME in", values, "deptShortName");
            return (Criteria) this;
        }

        public Criteria andDeptShortNameNotIn(List<String> values) {
            addCriterion("DEPT_SHORT_NAME not in", values, "deptShortName");
            return (Criteria) this;
        }

        public Criteria andDeptShortNameBetween(String value1, String value2) {
            addCriterion("DEPT_SHORT_NAME between", value1, value2, "deptShortName");
            return (Criteria) this;
        }

        public Criteria andDeptShortNameNotBetween(String value1, String value2) {
            addCriterion("DEPT_SHORT_NAME not between", value1, value2, "deptShortName");
            return (Criteria) this;
        }

        public Criteria andDeptNameIsNull() {
            addCriterion("DEPT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andDeptNameIsNotNull() {
            addCriterion("DEPT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andDeptNameEqualTo(String value) {
            addCriterion("DEPT_NAME =", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotEqualTo(String value) {
            addCriterion("DEPT_NAME <>", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameGreaterThan(String value) {
            addCriterion("DEPT_NAME >", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameGreaterThanOrEqualTo(String value) {
            addCriterion("DEPT_NAME >=", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameLessThan(String value) {
            addCriterion("DEPT_NAME <", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameLessThanOrEqualTo(String value) {
            addCriterion("DEPT_NAME <=", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameLike(String value) {
            addCriterion("DEPT_NAME like", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotLike(String value) {
            addCriterion("DEPT_NAME not like", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameIn(List<String> values) {
            addCriterion("DEPT_NAME in", values, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotIn(List<String> values) {
            addCriterion("DEPT_NAME not in", values, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameBetween(String value1, String value2) {
            addCriterion("DEPT_NAME between", value1, value2, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotBetween(String value1, String value2) {
            addCriterion("DEPT_NAME not between", value1, value2, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptAreaCodeIsNull() {
            addCriterion("DEPT_AREA_CODE is null");
            return (Criteria) this;
        }

        public Criteria andDeptAreaCodeIsNotNull() {
            addCriterion("DEPT_AREA_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andDeptAreaCodeEqualTo(BigDecimal value) {
            addCriterion("DEPT_AREA_CODE =", value, "deptAreaCode");
            return (Criteria) this;
        }

        public Criteria andDeptAreaCodeNotEqualTo(BigDecimal value) {
            addCriterion("DEPT_AREA_CODE <>", value, "deptAreaCode");
            return (Criteria) this;
        }

        public Criteria andDeptAreaCodeGreaterThan(BigDecimal value) {
            addCriterion("DEPT_AREA_CODE >", value, "deptAreaCode");
            return (Criteria) this;
        }

        public Criteria andDeptAreaCodeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DEPT_AREA_CODE >=", value, "deptAreaCode");
            return (Criteria) this;
        }

        public Criteria andDeptAreaCodeLessThan(BigDecimal value) {
            addCriterion("DEPT_AREA_CODE <", value, "deptAreaCode");
            return (Criteria) this;
        }

        public Criteria andDeptAreaCodeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DEPT_AREA_CODE <=", value, "deptAreaCode");
            return (Criteria) this;
        }

        public Criteria andDeptAreaCodeIn(List<BigDecimal> values) {
            addCriterion("DEPT_AREA_CODE in", values, "deptAreaCode");
            return (Criteria) this;
        }

        public Criteria andDeptAreaCodeNotIn(List<BigDecimal> values) {
            addCriterion("DEPT_AREA_CODE not in", values, "deptAreaCode");
            return (Criteria) this;
        }

        public Criteria andDeptAreaCodeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DEPT_AREA_CODE between", value1, value2, "deptAreaCode");
            return (Criteria) this;
        }

        public Criteria andDeptAreaCodeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DEPT_AREA_CODE not between", value1, value2, "deptAreaCode");
            return (Criteria) this;
        }

        public Criteria andDeptDistrictCodeIsNull() {
            addCriterion("DEPT_DISTRICT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andDeptDistrictCodeIsNotNull() {
            addCriterion("DEPT_DISTRICT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andDeptDistrictCodeEqualTo(BigDecimal value) {
            addCriterion("DEPT_DISTRICT_CODE =", value, "deptDistrictCode");
            return (Criteria) this;
        }

        public Criteria andDeptDistrictCodeNotEqualTo(BigDecimal value) {
            addCriterion("DEPT_DISTRICT_CODE <>", value, "deptDistrictCode");
            return (Criteria) this;
        }

        public Criteria andDeptDistrictCodeGreaterThan(BigDecimal value) {
            addCriterion("DEPT_DISTRICT_CODE >", value, "deptDistrictCode");
            return (Criteria) this;
        }

        public Criteria andDeptDistrictCodeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DEPT_DISTRICT_CODE >=", value, "deptDistrictCode");
            return (Criteria) this;
        }

        public Criteria andDeptDistrictCodeLessThan(BigDecimal value) {
            addCriterion("DEPT_DISTRICT_CODE <", value, "deptDistrictCode");
            return (Criteria) this;
        }

        public Criteria andDeptDistrictCodeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DEPT_DISTRICT_CODE <=", value, "deptDistrictCode");
            return (Criteria) this;
        }

        public Criteria andDeptDistrictCodeIn(List<BigDecimal> values) {
            addCriterion("DEPT_DISTRICT_CODE in", values, "deptDistrictCode");
            return (Criteria) this;
        }

        public Criteria andDeptDistrictCodeNotIn(List<BigDecimal> values) {
            addCriterion("DEPT_DISTRICT_CODE not in", values, "deptDistrictCode");
            return (Criteria) this;
        }

        public Criteria andDeptDistrictCodeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DEPT_DISTRICT_CODE between", value1, value2, "deptDistrictCode");
            return (Criteria) this;
        }

        public Criteria andDeptDistrictCodeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DEPT_DISTRICT_CODE not between", value1, value2, "deptDistrictCode");
            return (Criteria) this;
        }

        public Criteria andDeptDescriptionIsNull() {
            addCriterion("DEPT_DESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andDeptDescriptionIsNotNull() {
            addCriterion("DEPT_DESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andDeptDescriptionEqualTo(String value) {
            addCriterion("DEPT_DESCRIPTION =", value, "deptDescription");
            return (Criteria) this;
        }

        public Criteria andDeptDescriptionNotEqualTo(String value) {
            addCriterion("DEPT_DESCRIPTION <>", value, "deptDescription");
            return (Criteria) this;
        }

        public Criteria andDeptDescriptionGreaterThan(String value) {
            addCriterion("DEPT_DESCRIPTION >", value, "deptDescription");
            return (Criteria) this;
        }

        public Criteria andDeptDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("DEPT_DESCRIPTION >=", value, "deptDescription");
            return (Criteria) this;
        }

        public Criteria andDeptDescriptionLessThan(String value) {
            addCriterion("DEPT_DESCRIPTION <", value, "deptDescription");
            return (Criteria) this;
        }

        public Criteria andDeptDescriptionLessThanOrEqualTo(String value) {
            addCriterion("DEPT_DESCRIPTION <=", value, "deptDescription");
            return (Criteria) this;
        }

        public Criteria andDeptDescriptionLike(String value) {
            addCriterion("DEPT_DESCRIPTION like", value, "deptDescription");
            return (Criteria) this;
        }

        public Criteria andDeptDescriptionNotLike(String value) {
            addCriterion("DEPT_DESCRIPTION not like", value, "deptDescription");
            return (Criteria) this;
        }

        public Criteria andDeptDescriptionIn(List<String> values) {
            addCriterion("DEPT_DESCRIPTION in", values, "deptDescription");
            return (Criteria) this;
        }

        public Criteria andDeptDescriptionNotIn(List<String> values) {
            addCriterion("DEPT_DESCRIPTION not in", values, "deptDescription");
            return (Criteria) this;
        }

        public Criteria andDeptDescriptionBetween(String value1, String value2) {
            addCriterion("DEPT_DESCRIPTION between", value1, value2, "deptDescription");
            return (Criteria) this;
        }

        public Criteria andDeptDescriptionNotBetween(String value1, String value2) {
            addCriterion("DEPT_DESCRIPTION not between", value1, value2, "deptDescription");
            return (Criteria) this;
        }

        public Criteria andDeptTypeIsNull() {
            addCriterion("DEPT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andDeptTypeIsNotNull() {
            addCriterion("DEPT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andDeptTypeEqualTo(String value) {
            addCriterion("DEPT_TYPE =", value, "deptType");
            return (Criteria) this;
        }

        public Criteria andDeptTypeNotEqualTo(String value) {
            addCriterion("DEPT_TYPE <>", value, "deptType");
            return (Criteria) this;
        }

        public Criteria andDeptTypeGreaterThan(String value) {
            addCriterion("DEPT_TYPE >", value, "deptType");
            return (Criteria) this;
        }

        public Criteria andDeptTypeGreaterThanOrEqualTo(String value) {
            addCriterion("DEPT_TYPE >=", value, "deptType");
            return (Criteria) this;
        }

        public Criteria andDeptTypeLessThan(String value) {
            addCriterion("DEPT_TYPE <", value, "deptType");
            return (Criteria) this;
        }

        public Criteria andDeptTypeLessThanOrEqualTo(String value) {
            addCriterion("DEPT_TYPE <=", value, "deptType");
            return (Criteria) this;
        }

        public Criteria andDeptTypeLike(String value) {
            addCriterion("DEPT_TYPE like", value, "deptType");
            return (Criteria) this;
        }

        public Criteria andDeptTypeNotLike(String value) {
            addCriterion("DEPT_TYPE not like", value, "deptType");
            return (Criteria) this;
        }

        public Criteria andDeptTypeIn(List<String> values) {
            addCriterion("DEPT_TYPE in", values, "deptType");
            return (Criteria) this;
        }

        public Criteria andDeptTypeNotIn(List<String> values) {
            addCriterion("DEPT_TYPE not in", values, "deptType");
            return (Criteria) this;
        }

        public Criteria andDeptTypeBetween(String value1, String value2) {
            addCriterion("DEPT_TYPE between", value1, value2, "deptType");
            return (Criteria) this;
        }

        public Criteria andDeptTypeNotBetween(String value1, String value2) {
            addCriterion("DEPT_TYPE not between", value1, value2, "deptType");
            return (Criteria) this;
        }

        public Criteria andDeptParentIdIsNull() {
            addCriterion("DEPT_PARENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andDeptParentIdIsNotNull() {
            addCriterion("DEPT_PARENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDeptParentIdEqualTo(BigDecimal value) {
            addCriterion("DEPT_PARENT_ID =", value, "deptParentId");
            return (Criteria) this;
        }

        public Criteria andDeptParentIdNotEqualTo(BigDecimal value) {
            addCriterion("DEPT_PARENT_ID <>", value, "deptParentId");
            return (Criteria) this;
        }

        public Criteria andDeptParentIdGreaterThan(BigDecimal value) {
            addCriterion("DEPT_PARENT_ID >", value, "deptParentId");
            return (Criteria) this;
        }

        public Criteria andDeptParentIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DEPT_PARENT_ID >=", value, "deptParentId");
            return (Criteria) this;
        }

        public Criteria andDeptParentIdLessThan(BigDecimal value) {
            addCriterion("DEPT_PARENT_ID <", value, "deptParentId");
            return (Criteria) this;
        }

        public Criteria andDeptParentIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DEPT_PARENT_ID <=", value, "deptParentId");
            return (Criteria) this;
        }

        public Criteria andDeptParentIdIn(List<BigDecimal> values) {
            addCriterion("DEPT_PARENT_ID in", values, "deptParentId");
            return (Criteria) this;
        }

        public Criteria andDeptParentIdNotIn(List<BigDecimal> values) {
            addCriterion("DEPT_PARENT_ID not in", values, "deptParentId");
            return (Criteria) this;
        }

        public Criteria andDeptParentIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DEPT_PARENT_ID between", value1, value2, "deptParentId");
            return (Criteria) this;
        }

        public Criteria andDeptParentIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DEPT_PARENT_ID not between", value1, value2, "deptParentId");
            return (Criteria) this;
        }

        public Criteria andDeptSubCountIsNull() {
            addCriterion("DEPT_SUB_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andDeptSubCountIsNotNull() {
            addCriterion("DEPT_SUB_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andDeptSubCountEqualTo(Short value) {
            addCriterion("DEPT_SUB_COUNT =", value, "deptSubCount");
            return (Criteria) this;
        }

        public Criteria andDeptSubCountNotEqualTo(Short value) {
            addCriterion("DEPT_SUB_COUNT <>", value, "deptSubCount");
            return (Criteria) this;
        }

        public Criteria andDeptSubCountGreaterThan(Short value) {
            addCriterion("DEPT_SUB_COUNT >", value, "deptSubCount");
            return (Criteria) this;
        }

        public Criteria andDeptSubCountGreaterThanOrEqualTo(Short value) {
            addCriterion("DEPT_SUB_COUNT >=", value, "deptSubCount");
            return (Criteria) this;
        }

        public Criteria andDeptSubCountLessThan(Short value) {
            addCriterion("DEPT_SUB_COUNT <", value, "deptSubCount");
            return (Criteria) this;
        }

        public Criteria andDeptSubCountLessThanOrEqualTo(Short value) {
            addCriterion("DEPT_SUB_COUNT <=", value, "deptSubCount");
            return (Criteria) this;
        }

        public Criteria andDeptSubCountIn(List<Short> values) {
            addCriterion("DEPT_SUB_COUNT in", values, "deptSubCount");
            return (Criteria) this;
        }

        public Criteria andDeptSubCountNotIn(List<Short> values) {
            addCriterion("DEPT_SUB_COUNT not in", values, "deptSubCount");
            return (Criteria) this;
        }

        public Criteria andDeptSubCountBetween(Short value1, Short value2) {
            addCriterion("DEPT_SUB_COUNT between", value1, value2, "deptSubCount");
            return (Criteria) this;
        }

        public Criteria andDeptSubCountNotBetween(Short value1, Short value2) {
            addCriterion("DEPT_SUB_COUNT not between", value1, value2, "deptSubCount");
            return (Criteria) this;
        }

        public Criteria andDeptSortNoIsNull() {
            addCriterion("DEPT_SORT_NO is null");
            return (Criteria) this;
        }

        public Criteria andDeptSortNoIsNotNull() {
            addCriterion("DEPT_SORT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andDeptSortNoEqualTo(Short value) {
            addCriterion("DEPT_SORT_NO =", value, "deptSortNo");
            return (Criteria) this;
        }

        public Criteria andDeptSortNoNotEqualTo(Short value) {
            addCriterion("DEPT_SORT_NO <>", value, "deptSortNo");
            return (Criteria) this;
        }

        public Criteria andDeptSortNoGreaterThan(Short value) {
            addCriterion("DEPT_SORT_NO >", value, "deptSortNo");
            return (Criteria) this;
        }

        public Criteria andDeptSortNoGreaterThanOrEqualTo(Short value) {
            addCriterion("DEPT_SORT_NO >=", value, "deptSortNo");
            return (Criteria) this;
        }

        public Criteria andDeptSortNoLessThan(Short value) {
            addCriterion("DEPT_SORT_NO <", value, "deptSortNo");
            return (Criteria) this;
        }

        public Criteria andDeptSortNoLessThanOrEqualTo(Short value) {
            addCriterion("DEPT_SORT_NO <=", value, "deptSortNo");
            return (Criteria) this;
        }

        public Criteria andDeptSortNoIn(List<Short> values) {
            addCriterion("DEPT_SORT_NO in", values, "deptSortNo");
            return (Criteria) this;
        }

        public Criteria andDeptSortNoNotIn(List<Short> values) {
            addCriterion("DEPT_SORT_NO not in", values, "deptSortNo");
            return (Criteria) this;
        }

        public Criteria andDeptSortNoBetween(Short value1, Short value2) {
            addCriterion("DEPT_SORT_NO between", value1, value2, "deptSortNo");
            return (Criteria) this;
        }

        public Criteria andDeptSortNoNotBetween(Short value1, Short value2) {
            addCriterion("DEPT_SORT_NO not between", value1, value2, "deptSortNo");
            return (Criteria) this;
        }

        public Criteria andDeptDeepIsNull() {
            addCriterion("DEPT_DEEP is null");
            return (Criteria) this;
        }

        public Criteria andDeptDeepIsNotNull() {
            addCriterion("DEPT_DEEP is not null");
            return (Criteria) this;
        }

        public Criteria andDeptDeepEqualTo(Short value) {
            addCriterion("DEPT_DEEP =", value, "deptDeep");
            return (Criteria) this;
        }

        public Criteria andDeptDeepNotEqualTo(Short value) {
            addCriterion("DEPT_DEEP <>", value, "deptDeep");
            return (Criteria) this;
        }

        public Criteria andDeptDeepGreaterThan(Short value) {
            addCriterion("DEPT_DEEP >", value, "deptDeep");
            return (Criteria) this;
        }

        public Criteria andDeptDeepGreaterThanOrEqualTo(Short value) {
            addCriterion("DEPT_DEEP >=", value, "deptDeep");
            return (Criteria) this;
        }

        public Criteria andDeptDeepLessThan(Short value) {
            addCriterion("DEPT_DEEP <", value, "deptDeep");
            return (Criteria) this;
        }

        public Criteria andDeptDeepLessThanOrEqualTo(Short value) {
            addCriterion("DEPT_DEEP <=", value, "deptDeep");
            return (Criteria) this;
        }

        public Criteria andDeptDeepIn(List<Short> values) {
            addCriterion("DEPT_DEEP in", values, "deptDeep");
            return (Criteria) this;
        }

        public Criteria andDeptDeepNotIn(List<Short> values) {
            addCriterion("DEPT_DEEP not in", values, "deptDeep");
            return (Criteria) this;
        }

        public Criteria andDeptDeepBetween(Short value1, Short value2) {
            addCriterion("DEPT_DEEP between", value1, value2, "deptDeep");
            return (Criteria) this;
        }

        public Criteria andDeptDeepNotBetween(Short value1, Short value2) {
            addCriterion("DEPT_DEEP not between", value1, value2, "deptDeep");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNull() {
            addCriterion("IS_DEL is null");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNotNull() {
            addCriterion("IS_DEL is not null");
            return (Criteria) this;
        }

        public Criteria andIsDelEqualTo(String value) {
            addCriterion("IS_DEL =", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotEqualTo(String value) {
            addCriterion("IS_DEL <>", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThan(String value) {
            addCriterion("IS_DEL >", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThanOrEqualTo(String value) {
            addCriterion("IS_DEL >=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThan(String value) {
            addCriterion("IS_DEL <", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThanOrEqualTo(String value) {
            addCriterion("IS_DEL <=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLike(String value) {
            addCriterion("IS_DEL like", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotLike(String value) {
            addCriterion("IS_DEL not like", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelIn(List<String> values) {
            addCriterion("IS_DEL in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotIn(List<String> values) {
            addCriterion("IS_DEL not in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelBetween(String value1, String value2) {
            addCriterion("IS_DEL between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotBetween(String value1, String value2) {
            addCriterion("IS_DEL not between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andCreateUseridIsNull() {
            addCriterion("CREATE_USERID is null");
            return (Criteria) this;
        }

        public Criteria andCreateUseridIsNotNull() {
            addCriterion("CREATE_USERID is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUseridEqualTo(BigDecimal value) {
            addCriterion("CREATE_USERID =", value, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridNotEqualTo(BigDecimal value) {
            addCriterion("CREATE_USERID <>", value, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridGreaterThan(BigDecimal value) {
            addCriterion("CREATE_USERID >", value, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CREATE_USERID >=", value, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridLessThan(BigDecimal value) {
            addCriterion("CREATE_USERID <", value, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CREATE_USERID <=", value, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridIn(List<BigDecimal> values) {
            addCriterion("CREATE_USERID in", values, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridNotIn(List<BigDecimal> values) {
            addCriterion("CREATE_USERID not in", values, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CREATE_USERID between", value1, value2, "createUserid");
            return (Criteria) this;
        }

        public Criteria andCreateUseridNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CREATE_USERID not between", value1, value2, "createUserid");
            return (Criteria) this;
        }

        public Criteria andUpdateUseridIsNull() {
            addCriterion("UPDATE_USERID is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUseridIsNotNull() {
            addCriterion("UPDATE_USERID is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUseridEqualTo(BigDecimal value) {
            addCriterion("UPDATE_USERID =", value, "updateUserid");
            return (Criteria) this;
        }

        public Criteria andUpdateUseridNotEqualTo(BigDecimal value) {
            addCriterion("UPDATE_USERID <>", value, "updateUserid");
            return (Criteria) this;
        }

        public Criteria andUpdateUseridGreaterThan(BigDecimal value) {
            addCriterion("UPDATE_USERID >", value, "updateUserid");
            return (Criteria) this;
        }

        public Criteria andUpdateUseridGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("UPDATE_USERID >=", value, "updateUserid");
            return (Criteria) this;
        }

        public Criteria andUpdateUseridLessThan(BigDecimal value) {
            addCriterion("UPDATE_USERID <", value, "updateUserid");
            return (Criteria) this;
        }

        public Criteria andUpdateUseridLessThanOrEqualTo(BigDecimal value) {
            addCriterion("UPDATE_USERID <=", value, "updateUserid");
            return (Criteria) this;
        }

        public Criteria andUpdateUseridIn(List<BigDecimal> values) {
            addCriterion("UPDATE_USERID in", values, "updateUserid");
            return (Criteria) this;
        }

        public Criteria andUpdateUseridNotIn(List<BigDecimal> values) {
            addCriterion("UPDATE_USERID not in", values, "updateUserid");
            return (Criteria) this;
        }

        public Criteria andUpdateUseridBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("UPDATE_USERID between", value1, value2, "updateUserid");
            return (Criteria) this;
        }

        public Criteria andUpdateUseridNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("UPDATE_USERID not between", value1, value2, "updateUserid");
            return (Criteria) this;
        }

        public Criteria andVersionNoIsNull() {
            addCriterion("VERSION_NO is null");
            return (Criteria) this;
        }

        public Criteria andVersionNoIsNotNull() {
            addCriterion("VERSION_NO is not null");
            return (Criteria) this;
        }

        public Criteria andVersionNoEqualTo(BigDecimal value) {
            addCriterion("VERSION_NO =", value, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoNotEqualTo(BigDecimal value) {
            addCriterion("VERSION_NO <>", value, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoGreaterThan(BigDecimal value) {
            addCriterion("VERSION_NO >", value, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("VERSION_NO >=", value, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoLessThan(BigDecimal value) {
            addCriterion("VERSION_NO <", value, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoLessThanOrEqualTo(BigDecimal value) {
            addCriterion("VERSION_NO <=", value, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoIn(List<BigDecimal> values) {
            addCriterion("VERSION_NO in", values, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoNotIn(List<BigDecimal> values) {
            addCriterion("VERSION_NO not in", values, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("VERSION_NO between", value1, value2, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("VERSION_NO not between", value1, value2, "versionNo");
            return (Criteria) this;
        }

        public Criteria andDeptCodeLikeInsensitive(String value) {
            addCriterion("upper(DEPT_CODE) like", value.toUpperCase(), "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptShortNameLikeInsensitive(String value) {
            addCriterion("upper(DEPT_SHORT_NAME) like", value.toUpperCase(), "deptShortName");
            return (Criteria) this;
        }

        public Criteria andDeptNameLikeInsensitive(String value) {
            addCriterion("upper(DEPT_NAME) like", value.toUpperCase(), "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptDescriptionLikeInsensitive(String value) {
            addCriterion("upper(DEPT_DESCRIPTION) like", value.toUpperCase(), "deptDescription");
            return (Criteria) this;
        }

        public Criteria andDeptTypeLikeInsensitive(String value) {
            addCriterion("upper(DEPT_TYPE) like", value.toUpperCase(), "deptType");
            return (Criteria) this;
        }

        public Criteria andIsDelLikeInsensitive(String value) {
            addCriterion("upper(IS_DEL) like", value.toUpperCase(), "isDel");
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