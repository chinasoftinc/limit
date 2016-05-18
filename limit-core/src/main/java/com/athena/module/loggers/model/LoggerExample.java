package com.athena.module.loggers.model;

import com.athena.common.dto.Pagination;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class LoggerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Pagination pagination;

    public LoggerExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(BigDecimal value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(BigDecimal value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(BigDecimal value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(BigDecimal value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<BigDecimal> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<BigDecimal> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserNicknameIsNull() {
            addCriterion("USER_NICKNAME is null");
            return (Criteria) this;
        }

        public Criteria andUserNicknameIsNotNull() {
            addCriterion("USER_NICKNAME is not null");
            return (Criteria) this;
        }

        public Criteria andUserNicknameEqualTo(String value) {
            addCriterion("USER_NICKNAME =", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameNotEqualTo(String value) {
            addCriterion("USER_NICKNAME <>", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameGreaterThan(String value) {
            addCriterion("USER_NICKNAME >", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("USER_NICKNAME >=", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameLessThan(String value) {
            addCriterion("USER_NICKNAME <", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameLessThanOrEqualTo(String value) {
            addCriterion("USER_NICKNAME <=", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameLike(String value) {
            addCriterion("USER_NICKNAME like", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameNotLike(String value) {
            addCriterion("USER_NICKNAME not like", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameIn(List<String> values) {
            addCriterion("USER_NICKNAME in", values, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameNotIn(List<String> values) {
            addCriterion("USER_NICKNAME not in", values, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameBetween(String value1, String value2) {
            addCriterion("USER_NICKNAME between", value1, value2, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameNotBetween(String value1, String value2) {
            addCriterion("USER_NICKNAME not between", value1, value2, "userNickname");
            return (Criteria) this;
        }

        public Criteria andOptorTypeIsNull() {
            addCriterion("OPTOR_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andOptorTypeIsNotNull() {
            addCriterion("OPTOR_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andOptorTypeEqualTo(String value) {
            addCriterion("OPTOR_TYPE =", value, "optorType");
            return (Criteria) this;
        }

        public Criteria andOptorTypeNotEqualTo(String value) {
            addCriterion("OPTOR_TYPE <>", value, "optorType");
            return (Criteria) this;
        }

        public Criteria andOptorTypeGreaterThan(String value) {
            addCriterion("OPTOR_TYPE >", value, "optorType");
            return (Criteria) this;
        }

        public Criteria andOptorTypeGreaterThanOrEqualTo(String value) {
            addCriterion("OPTOR_TYPE >=", value, "optorType");
            return (Criteria) this;
        }

        public Criteria andOptorTypeLessThan(String value) {
            addCriterion("OPTOR_TYPE <", value, "optorType");
            return (Criteria) this;
        }

        public Criteria andOptorTypeLessThanOrEqualTo(String value) {
            addCriterion("OPTOR_TYPE <=", value, "optorType");
            return (Criteria) this;
        }

        public Criteria andOptorTypeLike(String value) {
            addCriterion("OPTOR_TYPE like", value, "optorType");
            return (Criteria) this;
        }

        public Criteria andOptorTypeNotLike(String value) {
            addCriterion("OPTOR_TYPE not like", value, "optorType");
            return (Criteria) this;
        }

        public Criteria andOptorTypeIn(List<String> values) {
            addCriterion("OPTOR_TYPE in", values, "optorType");
            return (Criteria) this;
        }

        public Criteria andOptorTypeNotIn(List<String> values) {
            addCriterion("OPTOR_TYPE not in", values, "optorType");
            return (Criteria) this;
        }

        public Criteria andOptorTypeBetween(String value1, String value2) {
            addCriterion("OPTOR_TYPE between", value1, value2, "optorType");
            return (Criteria) this;
        }

        public Criteria andOptorTypeNotBetween(String value1, String value2) {
            addCriterion("OPTOR_TYPE not between", value1, value2, "optorType");
            return (Criteria) this;
        }

        public Criteria andEntityNameIsNull() {
            addCriterion("ENTITY_NAME is null");
            return (Criteria) this;
        }

        public Criteria andEntityNameIsNotNull() {
            addCriterion("ENTITY_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andEntityNameEqualTo(String value) {
            addCriterion("ENTITY_NAME =", value, "entityName");
            return (Criteria) this;
        }

        public Criteria andEntityNameNotEqualTo(String value) {
            addCriterion("ENTITY_NAME <>", value, "entityName");
            return (Criteria) this;
        }

        public Criteria andEntityNameGreaterThan(String value) {
            addCriterion("ENTITY_NAME >", value, "entityName");
            return (Criteria) this;
        }

        public Criteria andEntityNameGreaterThanOrEqualTo(String value) {
            addCriterion("ENTITY_NAME >=", value, "entityName");
            return (Criteria) this;
        }

        public Criteria andEntityNameLessThan(String value) {
            addCriterion("ENTITY_NAME <", value, "entityName");
            return (Criteria) this;
        }

        public Criteria andEntityNameLessThanOrEqualTo(String value) {
            addCriterion("ENTITY_NAME <=", value, "entityName");
            return (Criteria) this;
        }

        public Criteria andEntityNameLike(String value) {
            addCriterion("ENTITY_NAME like", value, "entityName");
            return (Criteria) this;
        }

        public Criteria andEntityNameNotLike(String value) {
            addCriterion("ENTITY_NAME not like", value, "entityName");
            return (Criteria) this;
        }

        public Criteria andEntityNameIn(List<String> values) {
            addCriterion("ENTITY_NAME in", values, "entityName");
            return (Criteria) this;
        }

        public Criteria andEntityNameNotIn(List<String> values) {
            addCriterion("ENTITY_NAME not in", values, "entityName");
            return (Criteria) this;
        }

        public Criteria andEntityNameBetween(String value1, String value2) {
            addCriterion("ENTITY_NAME between", value1, value2, "entityName");
            return (Criteria) this;
        }

        public Criteria andEntityNameNotBetween(String value1, String value2) {
            addCriterion("ENTITY_NAME not between", value1, value2, "entityName");
            return (Criteria) this;
        }

        public Criteria andModelTitleIsNull() {
            addCriterion("MODEL_TITLE is null");
            return (Criteria) this;
        }

        public Criteria andModelTitleIsNotNull() {
            addCriterion("MODEL_TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andModelTitleEqualTo(String value) {
            addCriterion("MODEL_TITLE =", value, "modelTitle");
            return (Criteria) this;
        }

        public Criteria andModelTitleNotEqualTo(String value) {
            addCriterion("MODEL_TITLE <>", value, "modelTitle");
            return (Criteria) this;
        }

        public Criteria andModelTitleGreaterThan(String value) {
            addCriterion("MODEL_TITLE >", value, "modelTitle");
            return (Criteria) this;
        }

        public Criteria andModelTitleGreaterThanOrEqualTo(String value) {
            addCriterion("MODEL_TITLE >=", value, "modelTitle");
            return (Criteria) this;
        }

        public Criteria andModelTitleLessThan(String value) {
            addCriterion("MODEL_TITLE <", value, "modelTitle");
            return (Criteria) this;
        }

        public Criteria andModelTitleLessThanOrEqualTo(String value) {
            addCriterion("MODEL_TITLE <=", value, "modelTitle");
            return (Criteria) this;
        }

        public Criteria andModelTitleLike(String value) {
            addCriterion("MODEL_TITLE like", value, "modelTitle");
            return (Criteria) this;
        }

        public Criteria andModelTitleNotLike(String value) {
            addCriterion("MODEL_TITLE not like", value, "modelTitle");
            return (Criteria) this;
        }

        public Criteria andModelTitleIn(List<String> values) {
            addCriterion("MODEL_TITLE in", values, "modelTitle");
            return (Criteria) this;
        }

        public Criteria andModelTitleNotIn(List<String> values) {
            addCriterion("MODEL_TITLE not in", values, "modelTitle");
            return (Criteria) this;
        }

        public Criteria andModelTitleBetween(String value1, String value2) {
            addCriterion("MODEL_TITLE between", value1, value2, "modelTitle");
            return (Criteria) this;
        }

        public Criteria andModelTitleNotBetween(String value1, String value2) {
            addCriterion("MODEL_TITLE not between", value1, value2, "modelTitle");
            return (Criteria) this;
        }

        public Criteria andModelIdIsNull() {
            addCriterion("MODEL_ID is null");
            return (Criteria) this;
        }

        public Criteria andModelIdIsNotNull() {
            addCriterion("MODEL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andModelIdEqualTo(BigDecimal value) {
            addCriterion("MODEL_ID =", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotEqualTo(BigDecimal value) {
            addCriterion("MODEL_ID <>", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThan(BigDecimal value) {
            addCriterion("MODEL_ID >", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MODEL_ID >=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThan(BigDecimal value) {
            addCriterion("MODEL_ID <", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MODEL_ID <=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdIn(List<BigDecimal> values) {
            addCriterion("MODEL_ID in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotIn(List<BigDecimal> values) {
            addCriterion("MODEL_ID not in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MODEL_ID between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MODEL_ID not between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andOptorTimeIsNull() {
            addCriterion("OPTOR_TIME is null");
            return (Criteria) this;
        }

        public Criteria andOptorTimeIsNotNull() {
            addCriterion("OPTOR_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andOptorTimeEqualTo(Date value) {
            addCriterionForJDBCDate("OPTOR_TIME =", value, "optorTime");
            return (Criteria) this;
        }

        public Criteria andOptorTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("OPTOR_TIME <>", value, "optorTime");
            return (Criteria) this;
        }

        public Criteria andOptorTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("OPTOR_TIME >", value, "optorTime");
            return (Criteria) this;
        }

        public Criteria andOptorTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("OPTOR_TIME >=", value, "optorTime");
            return (Criteria) this;
        }

        public Criteria andOptorTimeLessThan(Date value) {
            addCriterionForJDBCDate("OPTOR_TIME <", value, "optorTime");
            return (Criteria) this;
        }

        public Criteria andOptorTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("OPTOR_TIME <=", value, "optorTime");
            return (Criteria) this;
        }

        public Criteria andOptorTimeIn(List<Date> values) {
            addCriterionForJDBCDate("OPTOR_TIME in", values, "optorTime");
            return (Criteria) this;
        }

        public Criteria andOptorTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("OPTOR_TIME not in", values, "optorTime");
            return (Criteria) this;
        }

        public Criteria andOptorTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("OPTOR_TIME between", value1, value2, "optorTime");
            return (Criteria) this;
        }

        public Criteria andOptorTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("OPTOR_TIME not between", value1, value2, "optorTime");
            return (Criteria) this;
        }

        public Criteria andOptorDetailIsNull() {
            addCriterion("OPTOR_DETAIL is null");
            return (Criteria) this;
        }

        public Criteria andOptorDetailIsNotNull() {
            addCriterion("OPTOR_DETAIL is not null");
            return (Criteria) this;
        }

        public Criteria andOptorDetailEqualTo(String value) {
            addCriterion("OPTOR_DETAIL =", value, "optorDetail");
            return (Criteria) this;
        }

        public Criteria andOptorDetailNotEqualTo(String value) {
            addCriterion("OPTOR_DETAIL <>", value, "optorDetail");
            return (Criteria) this;
        }

        public Criteria andOptorDetailGreaterThan(String value) {
            addCriterion("OPTOR_DETAIL >", value, "optorDetail");
            return (Criteria) this;
        }

        public Criteria andOptorDetailGreaterThanOrEqualTo(String value) {
            addCriterion("OPTOR_DETAIL >=", value, "optorDetail");
            return (Criteria) this;
        }

        public Criteria andOptorDetailLessThan(String value) {
            addCriterion("OPTOR_DETAIL <", value, "optorDetail");
            return (Criteria) this;
        }

        public Criteria andOptorDetailLessThanOrEqualTo(String value) {
            addCriterion("OPTOR_DETAIL <=", value, "optorDetail");
            return (Criteria) this;
        }

        public Criteria andOptorDetailLike(String value) {
            addCriterion("OPTOR_DETAIL like", value, "optorDetail");
            return (Criteria) this;
        }

        public Criteria andOptorDetailNotLike(String value) {
            addCriterion("OPTOR_DETAIL not like", value, "optorDetail");
            return (Criteria) this;
        }

        public Criteria andOptorDetailIn(List<String> values) {
            addCriterion("OPTOR_DETAIL in", values, "optorDetail");
            return (Criteria) this;
        }

        public Criteria andOptorDetailNotIn(List<String> values) {
            addCriterion("OPTOR_DETAIL not in", values, "optorDetail");
            return (Criteria) this;
        }

        public Criteria andOptorDetailBetween(String value1, String value2) {
            addCriterion("OPTOR_DETAIL between", value1, value2, "optorDetail");
            return (Criteria) this;
        }

        public Criteria andOptorDetailNotBetween(String value1, String value2) {
            addCriterion("OPTOR_DETAIL not between", value1, value2, "optorDetail");
            return (Criteria) this;
        }

        public Criteria andUserNicknameLikeInsensitive(String value) {
            addCriterion("upper(USER_NICKNAME) like", value.toUpperCase(), "userNickname");
            return (Criteria) this;
        }

        public Criteria andOptorTypeLikeInsensitive(String value) {
            addCriterion("upper(OPTOR_TYPE) like", value.toUpperCase(), "optorType");
            return (Criteria) this;
        }

        public Criteria andEntityNameLikeInsensitive(String value) {
            addCriterion("upper(ENTITY_NAME) like", value.toUpperCase(), "entityName");
            return (Criteria) this;
        }

        public Criteria andModelTitleLikeInsensitive(String value) {
            addCriterion("upper(MODEL_TITLE) like", value.toUpperCase(), "modelTitle");
            return (Criteria) this;
        }

        public Criteria andOptorDetailLikeInsensitive(String value) {
            addCriterion("upper(OPTOR_DETAIL) like", value.toUpperCase(), "optorDetail");
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