package com.athena.module.menus.model;

import com.athena.common.dto.Pagination;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MenuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Pagination pagination;

    public MenuExample() {
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

        public Criteria andMenuNameIsNull() {
            addCriterion("MENU_NAME is null");
            return (Criteria) this;
        }

        public Criteria andMenuNameIsNotNull() {
            addCriterion("MENU_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andMenuNameEqualTo(String value) {
            addCriterion("MENU_NAME =", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotEqualTo(String value) {
            addCriterion("MENU_NAME <>", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThan(String value) {
            addCriterion("MENU_NAME >", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThanOrEqualTo(String value) {
            addCriterion("MENU_NAME >=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThan(String value) {
            addCriterion("MENU_NAME <", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThanOrEqualTo(String value) {
            addCriterion("MENU_NAME <=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLike(String value) {
            addCriterion("MENU_NAME like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotLike(String value) {
            addCriterion("MENU_NAME not like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameIn(List<String> values) {
            addCriterion("MENU_NAME in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotIn(List<String> values) {
            addCriterion("MENU_NAME not in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameBetween(String value1, String value2) {
            addCriterion("MENU_NAME between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotBetween(String value1, String value2) {
            addCriterion("MENU_NAME not between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuUrlIsNull() {
            addCriterion("MENU_URL is null");
            return (Criteria) this;
        }

        public Criteria andMenuUrlIsNotNull() {
            addCriterion("MENU_URL is not null");
            return (Criteria) this;
        }

        public Criteria andMenuUrlEqualTo(String value) {
            addCriterion("MENU_URL =", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotEqualTo(String value) {
            addCriterion("MENU_URL <>", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlGreaterThan(String value) {
            addCriterion("MENU_URL >", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlGreaterThanOrEqualTo(String value) {
            addCriterion("MENU_URL >=", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlLessThan(String value) {
            addCriterion("MENU_URL <", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlLessThanOrEqualTo(String value) {
            addCriterion("MENU_URL <=", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlLike(String value) {
            addCriterion("MENU_URL like", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotLike(String value) {
            addCriterion("MENU_URL not like", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlIn(List<String> values) {
            addCriterion("MENU_URL in", values, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotIn(List<String> values) {
            addCriterion("MENU_URL not in", values, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlBetween(String value1, String value2) {
            addCriterion("MENU_URL between", value1, value2, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotBetween(String value1, String value2) {
            addCriterion("MENU_URL not between", value1, value2, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdIsNull() {
            addCriterion("MENU_PARENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdIsNotNull() {
            addCriterion("MENU_PARENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdEqualTo(BigDecimal value) {
            addCriterion("MENU_PARENT_ID =", value, "menuParentId");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdNotEqualTo(BigDecimal value) {
            addCriterion("MENU_PARENT_ID <>", value, "menuParentId");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdGreaterThan(BigDecimal value) {
            addCriterion("MENU_PARENT_ID >", value, "menuParentId");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MENU_PARENT_ID >=", value, "menuParentId");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdLessThan(BigDecimal value) {
            addCriterion("MENU_PARENT_ID <", value, "menuParentId");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MENU_PARENT_ID <=", value, "menuParentId");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdIn(List<BigDecimal> values) {
            addCriterion("MENU_PARENT_ID in", values, "menuParentId");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdNotIn(List<BigDecimal> values) {
            addCriterion("MENU_PARENT_ID not in", values, "menuParentId");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MENU_PARENT_ID between", value1, value2, "menuParentId");
            return (Criteria) this;
        }

        public Criteria andMenuParentIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MENU_PARENT_ID not between", value1, value2, "menuParentId");
            return (Criteria) this;
        }

        public Criteria andMenuPrivilegeCodeIsNull() {
            addCriterion("MENU_PRIVILEGE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andMenuPrivilegeCodeIsNotNull() {
            addCriterion("MENU_PRIVILEGE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andMenuPrivilegeCodeEqualTo(BigDecimal value) {
            addCriterion("MENU_PRIVILEGE_CODE =", value, "menuPrivilegeCode");
            return (Criteria) this;
        }

        public Criteria andMenuPrivilegeCodeNotEqualTo(BigDecimal value) {
            addCriterion("MENU_PRIVILEGE_CODE <>", value, "menuPrivilegeCode");
            return (Criteria) this;
        }

        public Criteria andMenuPrivilegeCodeGreaterThan(BigDecimal value) {
            addCriterion("MENU_PRIVILEGE_CODE >", value, "menuPrivilegeCode");
            return (Criteria) this;
        }

        public Criteria andMenuPrivilegeCodeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MENU_PRIVILEGE_CODE >=", value, "menuPrivilegeCode");
            return (Criteria) this;
        }

        public Criteria andMenuPrivilegeCodeLessThan(BigDecimal value) {
            addCriterion("MENU_PRIVILEGE_CODE <", value, "menuPrivilegeCode");
            return (Criteria) this;
        }

        public Criteria andMenuPrivilegeCodeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MENU_PRIVILEGE_CODE <=", value, "menuPrivilegeCode");
            return (Criteria) this;
        }

        public Criteria andMenuPrivilegeCodeIn(List<BigDecimal> values) {
            addCriterion("MENU_PRIVILEGE_CODE in", values, "menuPrivilegeCode");
            return (Criteria) this;
        }

        public Criteria andMenuPrivilegeCodeNotIn(List<BigDecimal> values) {
            addCriterion("MENU_PRIVILEGE_CODE not in", values, "menuPrivilegeCode");
            return (Criteria) this;
        }

        public Criteria andMenuPrivilegeCodeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MENU_PRIVILEGE_CODE between", value1, value2, "menuPrivilegeCode");
            return (Criteria) this;
        }

        public Criteria andMenuPrivilegeCodeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MENU_PRIVILEGE_CODE not between", value1, value2, "menuPrivilegeCode");
            return (Criteria) this;
        }

        public Criteria andMenuPrivilegePosIsNull() {
            addCriterion("MENU_PRIVILEGE_POS is null");
            return (Criteria) this;
        }

        public Criteria andMenuPrivilegePosIsNotNull() {
            addCriterion("MENU_PRIVILEGE_POS is not null");
            return (Criteria) this;
        }

        public Criteria andMenuPrivilegePosEqualTo(BigDecimal value) {
            addCriterion("MENU_PRIVILEGE_POS =", value, "menuPrivilegePos");
            return (Criteria) this;
        }

        public Criteria andMenuPrivilegePosNotEqualTo(BigDecimal value) {
            addCriterion("MENU_PRIVILEGE_POS <>", value, "menuPrivilegePos");
            return (Criteria) this;
        }

        public Criteria andMenuPrivilegePosGreaterThan(BigDecimal value) {
            addCriterion("MENU_PRIVILEGE_POS >", value, "menuPrivilegePos");
            return (Criteria) this;
        }

        public Criteria andMenuPrivilegePosGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MENU_PRIVILEGE_POS >=", value, "menuPrivilegePos");
            return (Criteria) this;
        }

        public Criteria andMenuPrivilegePosLessThan(BigDecimal value) {
            addCriterion("MENU_PRIVILEGE_POS <", value, "menuPrivilegePos");
            return (Criteria) this;
        }

        public Criteria andMenuPrivilegePosLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MENU_PRIVILEGE_POS <=", value, "menuPrivilegePos");
            return (Criteria) this;
        }

        public Criteria andMenuPrivilegePosIn(List<BigDecimal> values) {
            addCriterion("MENU_PRIVILEGE_POS in", values, "menuPrivilegePos");
            return (Criteria) this;
        }

        public Criteria andMenuPrivilegePosNotIn(List<BigDecimal> values) {
            addCriterion("MENU_PRIVILEGE_POS not in", values, "menuPrivilegePos");
            return (Criteria) this;
        }

        public Criteria andMenuPrivilegePosBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MENU_PRIVILEGE_POS between", value1, value2, "menuPrivilegePos");
            return (Criteria) this;
        }

        public Criteria andMenuPrivilegePosNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MENU_PRIVILEGE_POS not between", value1, value2, "menuPrivilegePos");
            return (Criteria) this;
        }

        public Criteria andMenuDescriptionIsNull() {
            addCriterion("MENU_DESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andMenuDescriptionIsNotNull() {
            addCriterion("MENU_DESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andMenuDescriptionEqualTo(String value) {
            addCriterion("MENU_DESCRIPTION =", value, "menuDescription");
            return (Criteria) this;
        }

        public Criteria andMenuDescriptionNotEqualTo(String value) {
            addCriterion("MENU_DESCRIPTION <>", value, "menuDescription");
            return (Criteria) this;
        }

        public Criteria andMenuDescriptionGreaterThan(String value) {
            addCriterion("MENU_DESCRIPTION >", value, "menuDescription");
            return (Criteria) this;
        }

        public Criteria andMenuDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("MENU_DESCRIPTION >=", value, "menuDescription");
            return (Criteria) this;
        }

        public Criteria andMenuDescriptionLessThan(String value) {
            addCriterion("MENU_DESCRIPTION <", value, "menuDescription");
            return (Criteria) this;
        }

        public Criteria andMenuDescriptionLessThanOrEqualTo(String value) {
            addCriterion("MENU_DESCRIPTION <=", value, "menuDescription");
            return (Criteria) this;
        }

        public Criteria andMenuDescriptionLike(String value) {
            addCriterion("MENU_DESCRIPTION like", value, "menuDescription");
            return (Criteria) this;
        }

        public Criteria andMenuDescriptionNotLike(String value) {
            addCriterion("MENU_DESCRIPTION not like", value, "menuDescription");
            return (Criteria) this;
        }

        public Criteria andMenuDescriptionIn(List<String> values) {
            addCriterion("MENU_DESCRIPTION in", values, "menuDescription");
            return (Criteria) this;
        }

        public Criteria andMenuDescriptionNotIn(List<String> values) {
            addCriterion("MENU_DESCRIPTION not in", values, "menuDescription");
            return (Criteria) this;
        }

        public Criteria andMenuDescriptionBetween(String value1, String value2) {
            addCriterion("MENU_DESCRIPTION between", value1, value2, "menuDescription");
            return (Criteria) this;
        }

        public Criteria andMenuDescriptionNotBetween(String value1, String value2) {
            addCriterion("MENU_DESCRIPTION not between", value1, value2, "menuDescription");
            return (Criteria) this;
        }

        public Criteria andMenuSortNoIsNull() {
            addCriterion("MENU_SORT_NO is null");
            return (Criteria) this;
        }

        public Criteria andMenuSortNoIsNotNull() {
            addCriterion("MENU_SORT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andMenuSortNoEqualTo(Short value) {
            addCriterion("MENU_SORT_NO =", value, "menuSortNo");
            return (Criteria) this;
        }

        public Criteria andMenuSortNoNotEqualTo(Short value) {
            addCriterion("MENU_SORT_NO <>", value, "menuSortNo");
            return (Criteria) this;
        }

        public Criteria andMenuSortNoGreaterThan(Short value) {
            addCriterion("MENU_SORT_NO >", value, "menuSortNo");
            return (Criteria) this;
        }

        public Criteria andMenuSortNoGreaterThanOrEqualTo(Short value) {
            addCriterion("MENU_SORT_NO >=", value, "menuSortNo");
            return (Criteria) this;
        }

        public Criteria andMenuSortNoLessThan(Short value) {
            addCriterion("MENU_SORT_NO <", value, "menuSortNo");
            return (Criteria) this;
        }

        public Criteria andMenuSortNoLessThanOrEqualTo(Short value) {
            addCriterion("MENU_SORT_NO <=", value, "menuSortNo");
            return (Criteria) this;
        }

        public Criteria andMenuSortNoIn(List<Short> values) {
            addCriterion("MENU_SORT_NO in", values, "menuSortNo");
            return (Criteria) this;
        }

        public Criteria andMenuSortNoNotIn(List<Short> values) {
            addCriterion("MENU_SORT_NO not in", values, "menuSortNo");
            return (Criteria) this;
        }

        public Criteria andMenuSortNoBetween(Short value1, Short value2) {
            addCriterion("MENU_SORT_NO between", value1, value2, "menuSortNo");
            return (Criteria) this;
        }

        public Criteria andMenuSortNoNotBetween(Short value1, Short value2) {
            addCriterion("MENU_SORT_NO not between", value1, value2, "menuSortNo");
            return (Criteria) this;
        }

        public Criteria andMenuNameLikeInsensitive(String value) {
            addCriterion("upper(MENU_NAME) like", value.toUpperCase(), "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuUrlLikeInsensitive(String value) {
            addCriterion("upper(MENU_URL) like", value.toUpperCase(), "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuDescriptionLikeInsensitive(String value) {
            addCriterion("upper(MENU_DESCRIPTION) like", value.toUpperCase(), "menuDescription");
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