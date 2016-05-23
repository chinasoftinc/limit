package com.athena.module.congyry.model;

import com.athena.common.dto.Pagination;
import java.util.ArrayList;
import java.util.List;

public class CongyryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Pagination pagination;

    public CongyryExample() {
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

        public Criteria andCongyryidIsNull() {
            addCriterion("CONGYRYID is null");
            return (Criteria) this;
        }

        public Criteria andCongyryidIsNotNull() {
            addCriterion("CONGYRYID is not null");
            return (Criteria) this;
        }

        public Criteria andCongyryidEqualTo(String value) {
            addCriterion("CONGYRYID =", value, "congyryid");
            return (Criteria) this;
        }

        public Criteria andCongyryidNotEqualTo(String value) {
            addCriterion("CONGYRYID <>", value, "congyryid");
            return (Criteria) this;
        }

        public Criteria andCongyryidGreaterThan(String value) {
            addCriterion("CONGYRYID >", value, "congyryid");
            return (Criteria) this;
        }

        public Criteria andCongyryidGreaterThanOrEqualTo(String value) {
            addCriterion("CONGYRYID >=", value, "congyryid");
            return (Criteria) this;
        }

        public Criteria andCongyryidLessThan(String value) {
            addCriterion("CONGYRYID <", value, "congyryid");
            return (Criteria) this;
        }

        public Criteria andCongyryidLessThanOrEqualTo(String value) {
            addCriterion("CONGYRYID <=", value, "congyryid");
            return (Criteria) this;
        }

        public Criteria andCongyryidLike(String value) {
            addCriterion("CONGYRYID like", value, "congyryid");
            return (Criteria) this;
        }

        public Criteria andCongyryidNotLike(String value) {
            addCriterion("CONGYRYID not like", value, "congyryid");
            return (Criteria) this;
        }

        public Criteria andCongyryidIn(List<String> values) {
            addCriterion("CONGYRYID in", values, "congyryid");
            return (Criteria) this;
        }

        public Criteria andCongyryidNotIn(List<String> values) {
            addCriterion("CONGYRYID not in", values, "congyryid");
            return (Criteria) this;
        }

        public Criteria andCongyryidBetween(String value1, String value2) {
            addCriterion("CONGYRYID between", value1, value2, "congyryid");
            return (Criteria) this;
        }

        public Criteria andCongyryidNotBetween(String value1, String value2) {
            addCriterion("CONGYRYID not between", value1, value2, "congyryid");
            return (Criteria) this;
        }

        public Criteria andXingmIsNull() {
            addCriterion("XINGM is null");
            return (Criteria) this;
        }

        public Criteria andXingmIsNotNull() {
            addCriterion("XINGM is not null");
            return (Criteria) this;
        }

        public Criteria andXingmEqualTo(String value) {
            addCriterion("XINGM =", value, "xingm");
            return (Criteria) this;
        }

        public Criteria andXingmNotEqualTo(String value) {
            addCriterion("XINGM <>", value, "xingm");
            return (Criteria) this;
        }

        public Criteria andXingmGreaterThan(String value) {
            addCriterion("XINGM >", value, "xingm");
            return (Criteria) this;
        }

        public Criteria andXingmGreaterThanOrEqualTo(String value) {
            addCriterion("XINGM >=", value, "xingm");
            return (Criteria) this;
        }

        public Criteria andXingmLessThan(String value) {
            addCriterion("XINGM <", value, "xingm");
            return (Criteria) this;
        }

        public Criteria andXingmLessThanOrEqualTo(String value) {
            addCriterion("XINGM <=", value, "xingm");
            return (Criteria) this;
        }

        public Criteria andXingmLike(String value) {
            addCriterion("XINGM like", value, "xingm");
            return (Criteria) this;
        }

        public Criteria andXingmNotLike(String value) {
            addCriterion("XINGM not like", value, "xingm");
            return (Criteria) this;
        }

        public Criteria andXingmIn(List<String> values) {
            addCriterion("XINGM in", values, "xingm");
            return (Criteria) this;
        }

        public Criteria andXingmNotIn(List<String> values) {
            addCriterion("XINGM not in", values, "xingm");
            return (Criteria) this;
        }

        public Criteria andXingmBetween(String value1, String value2) {
            addCriterion("XINGM between", value1, value2, "xingm");
            return (Criteria) this;
        }

        public Criteria andXingmNotBetween(String value1, String value2) {
            addCriterion("XINGM not between", value1, value2, "xingm");
            return (Criteria) this;
        }

        public Criteria andXingbIsNull() {
            addCriterion("XINGB is null");
            return (Criteria) this;
        }

        public Criteria andXingbIsNotNull() {
            addCriterion("XINGB is not null");
            return (Criteria) this;
        }

        public Criteria andXingbEqualTo(String value) {
            addCriterion("XINGB =", value, "xingb");
            return (Criteria) this;
        }

        public Criteria andXingbNotEqualTo(String value) {
            addCriterion("XINGB <>", value, "xingb");
            return (Criteria) this;
        }

        public Criteria andXingbGreaterThan(String value) {
            addCriterion("XINGB >", value, "xingb");
            return (Criteria) this;
        }

        public Criteria andXingbGreaterThanOrEqualTo(String value) {
            addCriterion("XINGB >=", value, "xingb");
            return (Criteria) this;
        }

        public Criteria andXingbLessThan(String value) {
            addCriterion("XINGB <", value, "xingb");
            return (Criteria) this;
        }

        public Criteria andXingbLessThanOrEqualTo(String value) {
            addCriterion("XINGB <=", value, "xingb");
            return (Criteria) this;
        }

        public Criteria andXingbLike(String value) {
            addCriterion("XINGB like", value, "xingb");
            return (Criteria) this;
        }

        public Criteria andXingbNotLike(String value) {
            addCriterion("XINGB not like", value, "xingb");
            return (Criteria) this;
        }

        public Criteria andXingbIn(List<String> values) {
            addCriterion("XINGB in", values, "xingb");
            return (Criteria) this;
        }

        public Criteria andXingbNotIn(List<String> values) {
            addCriterion("XINGB not in", values, "xingb");
            return (Criteria) this;
        }

        public Criteria andXingbBetween(String value1, String value2) {
            addCriterion("XINGB between", value1, value2, "xingb");
            return (Criteria) this;
        }

        public Criteria andXingbNotBetween(String value1, String value2) {
            addCriterion("XINGB not between", value1, value2, "xingb");
            return (Criteria) this;
        }

        public Criteria andChusrqIsNull() {
            addCriterion("CHUSRQ is null");
            return (Criteria) this;
        }

        public Criteria andChusrqIsNotNull() {
            addCriterion("CHUSRQ is not null");
            return (Criteria) this;
        }

        public Criteria andChusrqEqualTo(String value) {
            addCriterion("CHUSRQ =", value, "chusrq");
            return (Criteria) this;
        }

        public Criteria andChusrqNotEqualTo(String value) {
            addCriterion("CHUSRQ <>", value, "chusrq");
            return (Criteria) this;
        }

        public Criteria andChusrqGreaterThan(String value) {
            addCriterion("CHUSRQ >", value, "chusrq");
            return (Criteria) this;
        }

        public Criteria andChusrqGreaterThanOrEqualTo(String value) {
            addCriterion("CHUSRQ >=", value, "chusrq");
            return (Criteria) this;
        }

        public Criteria andChusrqLessThan(String value) {
            addCriterion("CHUSRQ <", value, "chusrq");
            return (Criteria) this;
        }

        public Criteria andChusrqLessThanOrEqualTo(String value) {
            addCriterion("CHUSRQ <=", value, "chusrq");
            return (Criteria) this;
        }

        public Criteria andChusrqLike(String value) {
            addCriterion("CHUSRQ like", value, "chusrq");
            return (Criteria) this;
        }

        public Criteria andChusrqNotLike(String value) {
            addCriterion("CHUSRQ not like", value, "chusrq");
            return (Criteria) this;
        }

        public Criteria andChusrqIn(List<String> values) {
            addCriterion("CHUSRQ in", values, "chusrq");
            return (Criteria) this;
        }

        public Criteria andChusrqNotIn(List<String> values) {
            addCriterion("CHUSRQ not in", values, "chusrq");
            return (Criteria) this;
        }

        public Criteria andChusrqBetween(String value1, String value2) {
            addCriterion("CHUSRQ between", value1, value2, "chusrq");
            return (Criteria) this;
        }

        public Criteria andChusrqNotBetween(String value1, String value2) {
            addCriterion("CHUSRQ not between", value1, value2, "chusrq");
            return (Criteria) this;
        }

        public Criteria andShenfzjlbIsNull() {
            addCriterion("SHENFZJLB is null");
            return (Criteria) this;
        }

        public Criteria andShenfzjlbIsNotNull() {
            addCriterion("SHENFZJLB is not null");
            return (Criteria) this;
        }

        public Criteria andShenfzjlbEqualTo(String value) {
            addCriterion("SHENFZJLB =", value, "shenfzjlb");
            return (Criteria) this;
        }

        public Criteria andShenfzjlbNotEqualTo(String value) {
            addCriterion("SHENFZJLB <>", value, "shenfzjlb");
            return (Criteria) this;
        }

        public Criteria andShenfzjlbGreaterThan(String value) {
            addCriterion("SHENFZJLB >", value, "shenfzjlb");
            return (Criteria) this;
        }

        public Criteria andShenfzjlbGreaterThanOrEqualTo(String value) {
            addCriterion("SHENFZJLB >=", value, "shenfzjlb");
            return (Criteria) this;
        }

        public Criteria andShenfzjlbLessThan(String value) {
            addCriterion("SHENFZJLB <", value, "shenfzjlb");
            return (Criteria) this;
        }

        public Criteria andShenfzjlbLessThanOrEqualTo(String value) {
            addCriterion("SHENFZJLB <=", value, "shenfzjlb");
            return (Criteria) this;
        }

        public Criteria andShenfzjlbLike(String value) {
            addCriterion("SHENFZJLB like", value, "shenfzjlb");
            return (Criteria) this;
        }

        public Criteria andShenfzjlbNotLike(String value) {
            addCriterion("SHENFZJLB not like", value, "shenfzjlb");
            return (Criteria) this;
        }

        public Criteria andShenfzjlbIn(List<String> values) {
            addCriterion("SHENFZJLB in", values, "shenfzjlb");
            return (Criteria) this;
        }

        public Criteria andShenfzjlbNotIn(List<String> values) {
            addCriterion("SHENFZJLB not in", values, "shenfzjlb");
            return (Criteria) this;
        }

        public Criteria andShenfzjlbBetween(String value1, String value2) {
            addCriterion("SHENFZJLB between", value1, value2, "shenfzjlb");
            return (Criteria) this;
        }

        public Criteria andShenfzjlbNotBetween(String value1, String value2) {
            addCriterion("SHENFZJLB not between", value1, value2, "shenfzjlb");
            return (Criteria) this;
        }

        public Criteria andShenfzjbhIsNull() {
            addCriterion("SHENFZJBH is null");
            return (Criteria) this;
        }

        public Criteria andShenfzjbhIsNotNull() {
            addCriterion("SHENFZJBH is not null");
            return (Criteria) this;
        }

        public Criteria andShenfzjbhEqualTo(String value) {
            addCriterion("SHENFZJBH =", value, "shenfzjbh");
            return (Criteria) this;
        }

        public Criteria andShenfzjbhNotEqualTo(String value) {
            addCriterion("SHENFZJBH <>", value, "shenfzjbh");
            return (Criteria) this;
        }

        public Criteria andShenfzjbhGreaterThan(String value) {
            addCriterion("SHENFZJBH >", value, "shenfzjbh");
            return (Criteria) this;
        }

        public Criteria andShenfzjbhGreaterThanOrEqualTo(String value) {
            addCriterion("SHENFZJBH >=", value, "shenfzjbh");
            return (Criteria) this;
        }

        public Criteria andShenfzjbhLessThan(String value) {
            addCriterion("SHENFZJBH <", value, "shenfzjbh");
            return (Criteria) this;
        }

        public Criteria andShenfzjbhLessThanOrEqualTo(String value) {
            addCriterion("SHENFZJBH <=", value, "shenfzjbh");
            return (Criteria) this;
        }

        public Criteria andShenfzjbhLike(String value) {
            addCriterion("SHENFZJBH like", value, "shenfzjbh");
            return (Criteria) this;
        }

        public Criteria andShenfzjbhNotLike(String value) {
            addCriterion("SHENFZJBH not like", value, "shenfzjbh");
            return (Criteria) this;
        }

        public Criteria andShenfzjbhIn(List<String> values) {
            addCriterion("SHENFZJBH in", values, "shenfzjbh");
            return (Criteria) this;
        }

        public Criteria andShenfzjbhNotIn(List<String> values) {
            addCriterion("SHENFZJBH not in", values, "shenfzjbh");
            return (Criteria) this;
        }

        public Criteria andShenfzjbhBetween(String value1, String value2) {
            addCriterion("SHENFZJBH between", value1, value2, "shenfzjbh");
            return (Criteria) this;
        }

        public Criteria andShenfzjbhNotBetween(String value1, String value2) {
            addCriterion("SHENFZJBH not between", value1, value2, "shenfzjbh");
            return (Criteria) this;
        }

        public Criteria andLisqxIsNull() {
            addCriterion("LISQX is null");
            return (Criteria) this;
        }

        public Criteria andLisqxIsNotNull() {
            addCriterion("LISQX is not null");
            return (Criteria) this;
        }

        public Criteria andLisqxEqualTo(String value) {
            addCriterion("LISQX =", value, "lisqx");
            return (Criteria) this;
        }

        public Criteria andLisqxNotEqualTo(String value) {
            addCriterion("LISQX <>", value, "lisqx");
            return (Criteria) this;
        }

        public Criteria andLisqxGreaterThan(String value) {
            addCriterion("LISQX >", value, "lisqx");
            return (Criteria) this;
        }

        public Criteria andLisqxGreaterThanOrEqualTo(String value) {
            addCriterion("LISQX >=", value, "lisqx");
            return (Criteria) this;
        }

        public Criteria andLisqxLessThan(String value) {
            addCriterion("LISQX <", value, "lisqx");
            return (Criteria) this;
        }

        public Criteria andLisqxLessThanOrEqualTo(String value) {
            addCriterion("LISQX <=", value, "lisqx");
            return (Criteria) this;
        }

        public Criteria andLisqxLike(String value) {
            addCriterion("LISQX like", value, "lisqx");
            return (Criteria) this;
        }

        public Criteria andLisqxNotLike(String value) {
            addCriterion("LISQX not like", value, "lisqx");
            return (Criteria) this;
        }

        public Criteria andLisqxIn(List<String> values) {
            addCriterion("LISQX in", values, "lisqx");
            return (Criteria) this;
        }

        public Criteria andLisqxNotIn(List<String> values) {
            addCriterion("LISQX not in", values, "lisqx");
            return (Criteria) this;
        }

        public Criteria andLisqxBetween(String value1, String value2) {
            addCriterion("LISQX between", value1, value2, "lisqx");
            return (Criteria) this;
        }

        public Criteria andLisqxNotBetween(String value1, String value2) {
            addCriterion("LISQX not between", value1, value2, "lisqx");
            return (Criteria) this;
        }

        public Criteria andGuddhIsNull() {
            addCriterion("GUDDH is null");
            return (Criteria) this;
        }

        public Criteria andGuddhIsNotNull() {
            addCriterion("GUDDH is not null");
            return (Criteria) this;
        }

        public Criteria andGuddhEqualTo(String value) {
            addCriterion("GUDDH =", value, "guddh");
            return (Criteria) this;
        }

        public Criteria andGuddhNotEqualTo(String value) {
            addCriterion("GUDDH <>", value, "guddh");
            return (Criteria) this;
        }

        public Criteria andGuddhGreaterThan(String value) {
            addCriterion("GUDDH >", value, "guddh");
            return (Criteria) this;
        }

        public Criteria andGuddhGreaterThanOrEqualTo(String value) {
            addCriterion("GUDDH >=", value, "guddh");
            return (Criteria) this;
        }

        public Criteria andGuddhLessThan(String value) {
            addCriterion("GUDDH <", value, "guddh");
            return (Criteria) this;
        }

        public Criteria andGuddhLessThanOrEqualTo(String value) {
            addCriterion("GUDDH <=", value, "guddh");
            return (Criteria) this;
        }

        public Criteria andGuddhLike(String value) {
            addCriterion("GUDDH like", value, "guddh");
            return (Criteria) this;
        }

        public Criteria andGuddhNotLike(String value) {
            addCriterion("GUDDH not like", value, "guddh");
            return (Criteria) this;
        }

        public Criteria andGuddhIn(List<String> values) {
            addCriterion("GUDDH in", values, "guddh");
            return (Criteria) this;
        }

        public Criteria andGuddhNotIn(List<String> values) {
            addCriterion("GUDDH not in", values, "guddh");
            return (Criteria) this;
        }

        public Criteria andGuddhBetween(String value1, String value2) {
            addCriterion("GUDDH between", value1, value2, "guddh");
            return (Criteria) this;
        }

        public Criteria andGuddhNotBetween(String value1, String value2) {
            addCriterion("GUDDH not between", value1, value2, "guddh");
            return (Criteria) this;
        }

        public Criteria andYiddhIsNull() {
            addCriterion("YIDDH is null");
            return (Criteria) this;
        }

        public Criteria andYiddhIsNotNull() {
            addCriterion("YIDDH is not null");
            return (Criteria) this;
        }

        public Criteria andYiddhEqualTo(String value) {
            addCriterion("YIDDH =", value, "yiddh");
            return (Criteria) this;
        }

        public Criteria andYiddhNotEqualTo(String value) {
            addCriterion("YIDDH <>", value, "yiddh");
            return (Criteria) this;
        }

        public Criteria andYiddhGreaterThan(String value) {
            addCriterion("YIDDH >", value, "yiddh");
            return (Criteria) this;
        }

        public Criteria andYiddhGreaterThanOrEqualTo(String value) {
            addCriterion("YIDDH >=", value, "yiddh");
            return (Criteria) this;
        }

        public Criteria andYiddhLessThan(String value) {
            addCriterion("YIDDH <", value, "yiddh");
            return (Criteria) this;
        }

        public Criteria andYiddhLessThanOrEqualTo(String value) {
            addCriterion("YIDDH <=", value, "yiddh");
            return (Criteria) this;
        }

        public Criteria andYiddhLike(String value) {
            addCriterion("YIDDH like", value, "yiddh");
            return (Criteria) this;
        }

        public Criteria andYiddhNotLike(String value) {
            addCriterion("YIDDH not like", value, "yiddh");
            return (Criteria) this;
        }

        public Criteria andYiddhIn(List<String> values) {
            addCriterion("YIDDH in", values, "yiddh");
            return (Criteria) this;
        }

        public Criteria andYiddhNotIn(List<String> values) {
            addCriterion("YIDDH not in", values, "yiddh");
            return (Criteria) this;
        }

        public Criteria andYiddhBetween(String value1, String value2) {
            addCriterion("YIDDH between", value1, value2, "yiddh");
            return (Criteria) this;
        }

        public Criteria andYiddhNotBetween(String value1, String value2) {
            addCriterion("YIDDH not between", value1, value2, "yiddh");
            return (Criteria) this;
        }

        public Criteria andShenfzdzIsNull() {
            addCriterion("SHENFZDZ is null");
            return (Criteria) this;
        }

        public Criteria andShenfzdzIsNotNull() {
            addCriterion("SHENFZDZ is not null");
            return (Criteria) this;
        }

        public Criteria andShenfzdzEqualTo(String value) {
            addCriterion("SHENFZDZ =", value, "shenfzdz");
            return (Criteria) this;
        }

        public Criteria andShenfzdzNotEqualTo(String value) {
            addCriterion("SHENFZDZ <>", value, "shenfzdz");
            return (Criteria) this;
        }

        public Criteria andShenfzdzGreaterThan(String value) {
            addCriterion("SHENFZDZ >", value, "shenfzdz");
            return (Criteria) this;
        }

        public Criteria andShenfzdzGreaterThanOrEqualTo(String value) {
            addCriterion("SHENFZDZ >=", value, "shenfzdz");
            return (Criteria) this;
        }

        public Criteria andShenfzdzLessThan(String value) {
            addCriterion("SHENFZDZ <", value, "shenfzdz");
            return (Criteria) this;
        }

        public Criteria andShenfzdzLessThanOrEqualTo(String value) {
            addCriterion("SHENFZDZ <=", value, "shenfzdz");
            return (Criteria) this;
        }

        public Criteria andShenfzdzLike(String value) {
            addCriterion("SHENFZDZ like", value, "shenfzdz");
            return (Criteria) this;
        }

        public Criteria andShenfzdzNotLike(String value) {
            addCriterion("SHENFZDZ not like", value, "shenfzdz");
            return (Criteria) this;
        }

        public Criteria andShenfzdzIn(List<String> values) {
            addCriterion("SHENFZDZ in", values, "shenfzdz");
            return (Criteria) this;
        }

        public Criteria andShenfzdzNotIn(List<String> values) {
            addCriterion("SHENFZDZ not in", values, "shenfzdz");
            return (Criteria) this;
        }

        public Criteria andShenfzdzBetween(String value1, String value2) {
            addCriterion("SHENFZDZ between", value1, value2, "shenfzdz");
            return (Criteria) this;
        }

        public Criteria andShenfzdzNotBetween(String value1, String value2) {
            addCriterion("SHENFZDZ not between", value1, value2, "shenfzdz");
            return (Criteria) this;
        }

        public Criteria andXianzdzIsNull() {
            addCriterion("XIANZDZ is null");
            return (Criteria) this;
        }

        public Criteria andXianzdzIsNotNull() {
            addCriterion("XIANZDZ is not null");
            return (Criteria) this;
        }

        public Criteria andXianzdzEqualTo(String value) {
            addCriterion("XIANZDZ =", value, "xianzdz");
            return (Criteria) this;
        }

        public Criteria andXianzdzNotEqualTo(String value) {
            addCriterion("XIANZDZ <>", value, "xianzdz");
            return (Criteria) this;
        }

        public Criteria andXianzdzGreaterThan(String value) {
            addCriterion("XIANZDZ >", value, "xianzdz");
            return (Criteria) this;
        }

        public Criteria andXianzdzGreaterThanOrEqualTo(String value) {
            addCriterion("XIANZDZ >=", value, "xianzdz");
            return (Criteria) this;
        }

        public Criteria andXianzdzLessThan(String value) {
            addCriterion("XIANZDZ <", value, "xianzdz");
            return (Criteria) this;
        }

        public Criteria andXianzdzLessThanOrEqualTo(String value) {
            addCriterion("XIANZDZ <=", value, "xianzdz");
            return (Criteria) this;
        }

        public Criteria andXianzdzLike(String value) {
            addCriterion("XIANZDZ like", value, "xianzdz");
            return (Criteria) this;
        }

        public Criteria andXianzdzNotLike(String value) {
            addCriterion("XIANZDZ not like", value, "xianzdz");
            return (Criteria) this;
        }

        public Criteria andXianzdzIn(List<String> values) {
            addCriterion("XIANZDZ in", values, "xianzdz");
            return (Criteria) this;
        }

        public Criteria andXianzdzNotIn(List<String> values) {
            addCriterion("XIANZDZ not in", values, "xianzdz");
            return (Criteria) this;
        }

        public Criteria andXianzdzBetween(String value1, String value2) {
            addCriterion("XIANZDZ between", value1, value2, "xianzdz");
            return (Criteria) this;
        }

        public Criteria andXianzdzNotBetween(String value1, String value2) {
            addCriterion("XIANZDZ not between", value1, value2, "xianzdz");
            return (Criteria) this;
        }

        public Criteria andDianzyxIsNull() {
            addCriterion("DIANZYX is null");
            return (Criteria) this;
        }

        public Criteria andDianzyxIsNotNull() {
            addCriterion("DIANZYX is not null");
            return (Criteria) this;
        }

        public Criteria andDianzyxEqualTo(String value) {
            addCriterion("DIANZYX =", value, "dianzyx");
            return (Criteria) this;
        }

        public Criteria andDianzyxNotEqualTo(String value) {
            addCriterion("DIANZYX <>", value, "dianzyx");
            return (Criteria) this;
        }

        public Criteria andDianzyxGreaterThan(String value) {
            addCriterion("DIANZYX >", value, "dianzyx");
            return (Criteria) this;
        }

        public Criteria andDianzyxGreaterThanOrEqualTo(String value) {
            addCriterion("DIANZYX >=", value, "dianzyx");
            return (Criteria) this;
        }

        public Criteria andDianzyxLessThan(String value) {
            addCriterion("DIANZYX <", value, "dianzyx");
            return (Criteria) this;
        }

        public Criteria andDianzyxLessThanOrEqualTo(String value) {
            addCriterion("DIANZYX <=", value, "dianzyx");
            return (Criteria) this;
        }

        public Criteria andDianzyxLike(String value) {
            addCriterion("DIANZYX like", value, "dianzyx");
            return (Criteria) this;
        }

        public Criteria andDianzyxNotLike(String value) {
            addCriterion("DIANZYX not like", value, "dianzyx");
            return (Criteria) this;
        }

        public Criteria andDianzyxIn(List<String> values) {
            addCriterion("DIANZYX in", values, "dianzyx");
            return (Criteria) this;
        }

        public Criteria andDianzyxNotIn(List<String> values) {
            addCriterion("DIANZYX not in", values, "dianzyx");
            return (Criteria) this;
        }

        public Criteria andDianzyxBetween(String value1, String value2) {
            addCriterion("DIANZYX between", value1, value2, "dianzyx");
            return (Criteria) this;
        }

        public Criteria andDianzyxNotBetween(String value1, String value2) {
            addCriterion("DIANZYX not between", value1, value2, "dianzyx");
            return (Criteria) this;
        }

        public Criteria andZhuzyzbmIsNull() {
            addCriterion("ZHUZYZBM is null");
            return (Criteria) this;
        }

        public Criteria andZhuzyzbmIsNotNull() {
            addCriterion("ZHUZYZBM is not null");
            return (Criteria) this;
        }

        public Criteria andZhuzyzbmEqualTo(String value) {
            addCriterion("ZHUZYZBM =", value, "zhuzyzbm");
            return (Criteria) this;
        }

        public Criteria andZhuzyzbmNotEqualTo(String value) {
            addCriterion("ZHUZYZBM <>", value, "zhuzyzbm");
            return (Criteria) this;
        }

        public Criteria andZhuzyzbmGreaterThan(String value) {
            addCriterion("ZHUZYZBM >", value, "zhuzyzbm");
            return (Criteria) this;
        }

        public Criteria andZhuzyzbmGreaterThanOrEqualTo(String value) {
            addCriterion("ZHUZYZBM >=", value, "zhuzyzbm");
            return (Criteria) this;
        }

        public Criteria andZhuzyzbmLessThan(String value) {
            addCriterion("ZHUZYZBM <", value, "zhuzyzbm");
            return (Criteria) this;
        }

        public Criteria andZhuzyzbmLessThanOrEqualTo(String value) {
            addCriterion("ZHUZYZBM <=", value, "zhuzyzbm");
            return (Criteria) this;
        }

        public Criteria andZhuzyzbmLike(String value) {
            addCriterion("ZHUZYZBM like", value, "zhuzyzbm");
            return (Criteria) this;
        }

        public Criteria andZhuzyzbmNotLike(String value) {
            addCriterion("ZHUZYZBM not like", value, "zhuzyzbm");
            return (Criteria) this;
        }

        public Criteria andZhuzyzbmIn(List<String> values) {
            addCriterion("ZHUZYZBM in", values, "zhuzyzbm");
            return (Criteria) this;
        }

        public Criteria andZhuzyzbmNotIn(List<String> values) {
            addCriterion("ZHUZYZBM not in", values, "zhuzyzbm");
            return (Criteria) this;
        }

        public Criteria andZhuzyzbmBetween(String value1, String value2) {
            addCriterion("ZHUZYZBM between", value1, value2, "zhuzyzbm");
            return (Criteria) this;
        }

        public Criteria andZhuzyzbmNotBetween(String value1, String value2) {
            addCriterion("ZHUZYZBM not between", value1, value2, "zhuzyzbm");
            return (Criteria) this;
        }

        public Criteria andZhuanyjsIsNull() {
            addCriterion("ZHUANYJS is null");
            return (Criteria) this;
        }

        public Criteria andZhuanyjsIsNotNull() {
            addCriterion("ZHUANYJS is not null");
            return (Criteria) this;
        }

        public Criteria andZhuanyjsEqualTo(String value) {
            addCriterion("ZHUANYJS =", value, "zhuanyjs");
            return (Criteria) this;
        }

        public Criteria andZhuanyjsNotEqualTo(String value) {
            addCriterion("ZHUANYJS <>", value, "zhuanyjs");
            return (Criteria) this;
        }

        public Criteria andZhuanyjsGreaterThan(String value) {
            addCriterion("ZHUANYJS >", value, "zhuanyjs");
            return (Criteria) this;
        }

        public Criteria andZhuanyjsGreaterThanOrEqualTo(String value) {
            addCriterion("ZHUANYJS >=", value, "zhuanyjs");
            return (Criteria) this;
        }

        public Criteria andZhuanyjsLessThan(String value) {
            addCriterion("ZHUANYJS <", value, "zhuanyjs");
            return (Criteria) this;
        }

        public Criteria andZhuanyjsLessThanOrEqualTo(String value) {
            addCriterion("ZHUANYJS <=", value, "zhuanyjs");
            return (Criteria) this;
        }

        public Criteria andZhuanyjsLike(String value) {
            addCriterion("ZHUANYJS like", value, "zhuanyjs");
            return (Criteria) this;
        }

        public Criteria andZhuanyjsNotLike(String value) {
            addCriterion("ZHUANYJS not like", value, "zhuanyjs");
            return (Criteria) this;
        }

        public Criteria andZhuanyjsIn(List<String> values) {
            addCriterion("ZHUANYJS in", values, "zhuanyjs");
            return (Criteria) this;
        }

        public Criteria andZhuanyjsNotIn(List<String> values) {
            addCriterion("ZHUANYJS not in", values, "zhuanyjs");
            return (Criteria) this;
        }

        public Criteria andZhuanyjsBetween(String value1, String value2) {
            addCriterion("ZHUANYJS between", value1, value2, "zhuanyjs");
            return (Criteria) this;
        }

        public Criteria andZhuanyjsNotBetween(String value1, String value2) {
            addCriterion("ZHUANYJS not between", value1, value2, "zhuanyjs");
            return (Criteria) this;
        }

        public Criteria andJiaszhIsNull() {
            addCriterion("JIASZH is null");
            return (Criteria) this;
        }

        public Criteria andJiaszhIsNotNull() {
            addCriterion("JIASZH is not null");
            return (Criteria) this;
        }

        public Criteria andJiaszhEqualTo(String value) {
            addCriterion("JIASZH =", value, "jiaszh");
            return (Criteria) this;
        }

        public Criteria andJiaszhNotEqualTo(String value) {
            addCriterion("JIASZH <>", value, "jiaszh");
            return (Criteria) this;
        }

        public Criteria andJiaszhGreaterThan(String value) {
            addCriterion("JIASZH >", value, "jiaszh");
            return (Criteria) this;
        }

        public Criteria andJiaszhGreaterThanOrEqualTo(String value) {
            addCriterion("JIASZH >=", value, "jiaszh");
            return (Criteria) this;
        }

        public Criteria andJiaszhLessThan(String value) {
            addCriterion("JIASZH <", value, "jiaszh");
            return (Criteria) this;
        }

        public Criteria andJiaszhLessThanOrEqualTo(String value) {
            addCriterion("JIASZH <=", value, "jiaszh");
            return (Criteria) this;
        }

        public Criteria andJiaszhLike(String value) {
            addCriterion("JIASZH like", value, "jiaszh");
            return (Criteria) this;
        }

        public Criteria andJiaszhNotLike(String value) {
            addCriterion("JIASZH not like", value, "jiaszh");
            return (Criteria) this;
        }

        public Criteria andJiaszhIn(List<String> values) {
            addCriterion("JIASZH in", values, "jiaszh");
            return (Criteria) this;
        }

        public Criteria andJiaszhNotIn(List<String> values) {
            addCriterion("JIASZH not in", values, "jiaszh");
            return (Criteria) this;
        }

        public Criteria andJiaszhBetween(String value1, String value2) {
            addCriterion("JIASZH between", value1, value2, "jiaszh");
            return (Criteria) this;
        }

        public Criteria andJiaszhNotBetween(String value1, String value2) {
            addCriterion("JIASZH not between", value1, value2, "jiaszh");
            return (Criteria) this;
        }

        public Criteria andZhunjcxIsNull() {
            addCriterion("ZHUNJCX is null");
            return (Criteria) this;
        }

        public Criteria andZhunjcxIsNotNull() {
            addCriterion("ZHUNJCX is not null");
            return (Criteria) this;
        }

        public Criteria andZhunjcxEqualTo(String value) {
            addCriterion("ZHUNJCX =", value, "zhunjcx");
            return (Criteria) this;
        }

        public Criteria andZhunjcxNotEqualTo(String value) {
            addCriterion("ZHUNJCX <>", value, "zhunjcx");
            return (Criteria) this;
        }

        public Criteria andZhunjcxGreaterThan(String value) {
            addCriterion("ZHUNJCX >", value, "zhunjcx");
            return (Criteria) this;
        }

        public Criteria andZhunjcxGreaterThanOrEqualTo(String value) {
            addCriterion("ZHUNJCX >=", value, "zhunjcx");
            return (Criteria) this;
        }

        public Criteria andZhunjcxLessThan(String value) {
            addCriterion("ZHUNJCX <", value, "zhunjcx");
            return (Criteria) this;
        }

        public Criteria andZhunjcxLessThanOrEqualTo(String value) {
            addCriterion("ZHUNJCX <=", value, "zhunjcx");
            return (Criteria) this;
        }

        public Criteria andZhunjcxLike(String value) {
            addCriterion("ZHUNJCX like", value, "zhunjcx");
            return (Criteria) this;
        }

        public Criteria andZhunjcxNotLike(String value) {
            addCriterion("ZHUNJCX not like", value, "zhunjcx");
            return (Criteria) this;
        }

        public Criteria andZhunjcxIn(List<String> values) {
            addCriterion("ZHUNJCX in", values, "zhunjcx");
            return (Criteria) this;
        }

        public Criteria andZhunjcxNotIn(List<String> values) {
            addCriterion("ZHUNJCX not in", values, "zhunjcx");
            return (Criteria) this;
        }

        public Criteria andZhunjcxBetween(String value1, String value2) {
            addCriterion("ZHUNJCX between", value1, value2, "zhunjcx");
            return (Criteria) this;
        }

        public Criteria andZhunjcxNotBetween(String value1, String value2) {
            addCriterion("ZHUNJCX not between", value1, value2, "zhunjcx");
            return (Criteria) this;
        }

        public Criteria andJiazclrqIsNull() {
            addCriterion("JIAZCLRQ is null");
            return (Criteria) this;
        }

        public Criteria andJiazclrqIsNotNull() {
            addCriterion("JIAZCLRQ is not null");
            return (Criteria) this;
        }

        public Criteria andJiazclrqEqualTo(String value) {
            addCriterion("JIAZCLRQ =", value, "jiazclrq");
            return (Criteria) this;
        }

        public Criteria andJiazclrqNotEqualTo(String value) {
            addCriterion("JIAZCLRQ <>", value, "jiazclrq");
            return (Criteria) this;
        }

        public Criteria andJiazclrqGreaterThan(String value) {
            addCriterion("JIAZCLRQ >", value, "jiazclrq");
            return (Criteria) this;
        }

        public Criteria andJiazclrqGreaterThanOrEqualTo(String value) {
            addCriterion("JIAZCLRQ >=", value, "jiazclrq");
            return (Criteria) this;
        }

        public Criteria andJiazclrqLessThan(String value) {
            addCriterion("JIAZCLRQ <", value, "jiazclrq");
            return (Criteria) this;
        }

        public Criteria andJiazclrqLessThanOrEqualTo(String value) {
            addCriterion("JIAZCLRQ <=", value, "jiazclrq");
            return (Criteria) this;
        }

        public Criteria andJiazclrqLike(String value) {
            addCriterion("JIAZCLRQ like", value, "jiazclrq");
            return (Criteria) this;
        }

        public Criteria andJiazclrqNotLike(String value) {
            addCriterion("JIAZCLRQ not like", value, "jiazclrq");
            return (Criteria) this;
        }

        public Criteria andJiazclrqIn(List<String> values) {
            addCriterion("JIAZCLRQ in", values, "jiazclrq");
            return (Criteria) this;
        }

        public Criteria andJiazclrqNotIn(List<String> values) {
            addCriterion("JIAZCLRQ not in", values, "jiazclrq");
            return (Criteria) this;
        }

        public Criteria andJiazclrqBetween(String value1, String value2) {
            addCriterion("JIAZCLRQ between", value1, value2, "jiazclrq");
            return (Criteria) this;
        }

        public Criteria andJiazclrqNotBetween(String value1, String value2) {
            addCriterion("JIAZCLRQ not between", value1, value2, "jiazclrq");
            return (Criteria) this;
        }

        public Criteria andJiazyxqsIsNull() {
            addCriterion("JIAZYXQS is null");
            return (Criteria) this;
        }

        public Criteria andJiazyxqsIsNotNull() {
            addCriterion("JIAZYXQS is not null");
            return (Criteria) this;
        }

        public Criteria andJiazyxqsEqualTo(String value) {
            addCriterion("JIAZYXQS =", value, "jiazyxqs");
            return (Criteria) this;
        }

        public Criteria andJiazyxqsNotEqualTo(String value) {
            addCriterion("JIAZYXQS <>", value, "jiazyxqs");
            return (Criteria) this;
        }

        public Criteria andJiazyxqsGreaterThan(String value) {
            addCriterion("JIAZYXQS >", value, "jiazyxqs");
            return (Criteria) this;
        }

        public Criteria andJiazyxqsGreaterThanOrEqualTo(String value) {
            addCriterion("JIAZYXQS >=", value, "jiazyxqs");
            return (Criteria) this;
        }

        public Criteria andJiazyxqsLessThan(String value) {
            addCriterion("JIAZYXQS <", value, "jiazyxqs");
            return (Criteria) this;
        }

        public Criteria andJiazyxqsLessThanOrEqualTo(String value) {
            addCriterion("JIAZYXQS <=", value, "jiazyxqs");
            return (Criteria) this;
        }

        public Criteria andJiazyxqsLike(String value) {
            addCriterion("JIAZYXQS like", value, "jiazyxqs");
            return (Criteria) this;
        }

        public Criteria andJiazyxqsNotLike(String value) {
            addCriterion("JIAZYXQS not like", value, "jiazyxqs");
            return (Criteria) this;
        }

        public Criteria andJiazyxqsIn(List<String> values) {
            addCriterion("JIAZYXQS in", values, "jiazyxqs");
            return (Criteria) this;
        }

        public Criteria andJiazyxqsNotIn(List<String> values) {
            addCriterion("JIAZYXQS not in", values, "jiazyxqs");
            return (Criteria) this;
        }

        public Criteria andJiazyxqsBetween(String value1, String value2) {
            addCriterion("JIAZYXQS between", value1, value2, "jiazyxqs");
            return (Criteria) this;
        }

        public Criteria andJiazyxqsNotBetween(String value1, String value2) {
            addCriterion("JIAZYXQS not between", value1, value2, "jiazyxqs");
            return (Criteria) this;
        }

        public Criteria andJiazyxqzIsNull() {
            addCriterion("JIAZYXQZ is null");
            return (Criteria) this;
        }

        public Criteria andJiazyxqzIsNotNull() {
            addCriterion("JIAZYXQZ is not null");
            return (Criteria) this;
        }

        public Criteria andJiazyxqzEqualTo(String value) {
            addCriterion("JIAZYXQZ =", value, "jiazyxqz");
            return (Criteria) this;
        }

        public Criteria andJiazyxqzNotEqualTo(String value) {
            addCriterion("JIAZYXQZ <>", value, "jiazyxqz");
            return (Criteria) this;
        }

        public Criteria andJiazyxqzGreaterThan(String value) {
            addCriterion("JIAZYXQZ >", value, "jiazyxqz");
            return (Criteria) this;
        }

        public Criteria andJiazyxqzGreaterThanOrEqualTo(String value) {
            addCriterion("JIAZYXQZ >=", value, "jiazyxqz");
            return (Criteria) this;
        }

        public Criteria andJiazyxqzLessThan(String value) {
            addCriterion("JIAZYXQZ <", value, "jiazyxqz");
            return (Criteria) this;
        }

        public Criteria andJiazyxqzLessThanOrEqualTo(String value) {
            addCriterion("JIAZYXQZ <=", value, "jiazyxqz");
            return (Criteria) this;
        }

        public Criteria andJiazyxqzLike(String value) {
            addCriterion("JIAZYXQZ like", value, "jiazyxqz");
            return (Criteria) this;
        }

        public Criteria andJiazyxqzNotLike(String value) {
            addCriterion("JIAZYXQZ not like", value, "jiazyxqz");
            return (Criteria) this;
        }

        public Criteria andJiazyxqzIn(List<String> values) {
            addCriterion("JIAZYXQZ in", values, "jiazyxqz");
            return (Criteria) this;
        }

        public Criteria andJiazyxqzNotIn(List<String> values) {
            addCriterion("JIAZYXQZ not in", values, "jiazyxqz");
            return (Criteria) this;
        }

        public Criteria andJiazyxqzBetween(String value1, String value2) {
            addCriterion("JIAZYXQZ between", value1, value2, "jiazyxqz");
            return (Criteria) this;
        }

        public Criteria andJiazyxqzNotBetween(String value1, String value2) {
            addCriterion("JIAZYXQZ not between", value1, value2, "jiazyxqz");
            return (Criteria) this;
        }

        public Criteria andJiazyxqxIsNull() {
            addCriterion("JIAZYXQX is null");
            return (Criteria) this;
        }

        public Criteria andJiazyxqxIsNotNull() {
            addCriterion("JIAZYXQX is not null");
            return (Criteria) this;
        }

        public Criteria andJiazyxqxEqualTo(Short value) {
            addCriterion("JIAZYXQX =", value, "jiazyxqx");
            return (Criteria) this;
        }

        public Criteria andJiazyxqxNotEqualTo(Short value) {
            addCriterion("JIAZYXQX <>", value, "jiazyxqx");
            return (Criteria) this;
        }

        public Criteria andJiazyxqxGreaterThan(Short value) {
            addCriterion("JIAZYXQX >", value, "jiazyxqx");
            return (Criteria) this;
        }

        public Criteria andJiazyxqxGreaterThanOrEqualTo(Short value) {
            addCriterion("JIAZYXQX >=", value, "jiazyxqx");
            return (Criteria) this;
        }

        public Criteria andJiazyxqxLessThan(Short value) {
            addCriterion("JIAZYXQX <", value, "jiazyxqx");
            return (Criteria) this;
        }

        public Criteria andJiazyxqxLessThanOrEqualTo(Short value) {
            addCriterion("JIAZYXQX <=", value, "jiazyxqx");
            return (Criteria) this;
        }

        public Criteria andJiazyxqxIn(List<Short> values) {
            addCriterion("JIAZYXQX in", values, "jiazyxqx");
            return (Criteria) this;
        }

        public Criteria andJiazyxqxNotIn(List<Short> values) {
            addCriterion("JIAZYXQX not in", values, "jiazyxqx");
            return (Criteria) this;
        }

        public Criteria andJiazyxqxBetween(Short value1, Short value2) {
            addCriterion("JIAZYXQX between", value1, value2, "jiazyxqx");
            return (Criteria) this;
        }

        public Criteria andJiazyxqxNotBetween(Short value1, Short value2) {
            addCriterion("JIAZYXQX not between", value1, value2, "jiazyxqx");
            return (Criteria) this;
        }

        public Criteria andJiazfzjgIsNull() {
            addCriterion("JIAZFZJG is null");
            return (Criteria) this;
        }

        public Criteria andJiazfzjgIsNotNull() {
            addCriterion("JIAZFZJG is not null");
            return (Criteria) this;
        }

        public Criteria andJiazfzjgEqualTo(String value) {
            addCriterion("JIAZFZJG =", value, "jiazfzjg");
            return (Criteria) this;
        }

        public Criteria andJiazfzjgNotEqualTo(String value) {
            addCriterion("JIAZFZJG <>", value, "jiazfzjg");
            return (Criteria) this;
        }

        public Criteria andJiazfzjgGreaterThan(String value) {
            addCriterion("JIAZFZJG >", value, "jiazfzjg");
            return (Criteria) this;
        }

        public Criteria andJiazfzjgGreaterThanOrEqualTo(String value) {
            addCriterion("JIAZFZJG >=", value, "jiazfzjg");
            return (Criteria) this;
        }

        public Criteria andJiazfzjgLessThan(String value) {
            addCriterion("JIAZFZJG <", value, "jiazfzjg");
            return (Criteria) this;
        }

        public Criteria andJiazfzjgLessThanOrEqualTo(String value) {
            addCriterion("JIAZFZJG <=", value, "jiazfzjg");
            return (Criteria) this;
        }

        public Criteria andJiazfzjgLike(String value) {
            addCriterion("JIAZFZJG like", value, "jiazfzjg");
            return (Criteria) this;
        }

        public Criteria andJiazfzjgNotLike(String value) {
            addCriterion("JIAZFZJG not like", value, "jiazfzjg");
            return (Criteria) this;
        }

        public Criteria andJiazfzjgIn(List<String> values) {
            addCriterion("JIAZFZJG in", values, "jiazfzjg");
            return (Criteria) this;
        }

        public Criteria andJiazfzjgNotIn(List<String> values) {
            addCriterion("JIAZFZJG not in", values, "jiazfzjg");
            return (Criteria) this;
        }

        public Criteria andJiazfzjgBetween(String value1, String value2) {
            addCriterion("JIAZFZJG between", value1, value2, "jiazfzjg");
            return (Criteria) this;
        }

        public Criteria andJiazfzjgNotBetween(String value1, String value2) {
            addCriterion("JIAZFZJG not between", value1, value2, "jiazfzjg");
            return (Criteria) this;
        }

        public Criteria andZhaopljIsNull() {
            addCriterion("ZHAOPLJ is null");
            return (Criteria) this;
        }

        public Criteria andZhaopljIsNotNull() {
            addCriterion("ZHAOPLJ is not null");
            return (Criteria) this;
        }

        public Criteria andZhaopljEqualTo(String value) {
            addCriterion("ZHAOPLJ =", value, "zhaoplj");
            return (Criteria) this;
        }

        public Criteria andZhaopljNotEqualTo(String value) {
            addCriterion("ZHAOPLJ <>", value, "zhaoplj");
            return (Criteria) this;
        }

        public Criteria andZhaopljGreaterThan(String value) {
            addCriterion("ZHAOPLJ >", value, "zhaoplj");
            return (Criteria) this;
        }

        public Criteria andZhaopljGreaterThanOrEqualTo(String value) {
            addCriterion("ZHAOPLJ >=", value, "zhaoplj");
            return (Criteria) this;
        }

        public Criteria andZhaopljLessThan(String value) {
            addCriterion("ZHAOPLJ <", value, "zhaoplj");
            return (Criteria) this;
        }

        public Criteria andZhaopljLessThanOrEqualTo(String value) {
            addCriterion("ZHAOPLJ <=", value, "zhaoplj");
            return (Criteria) this;
        }

        public Criteria andZhaopljLike(String value) {
            addCriterion("ZHAOPLJ like", value, "zhaoplj");
            return (Criteria) this;
        }

        public Criteria andZhaopljNotLike(String value) {
            addCriterion("ZHAOPLJ not like", value, "zhaoplj");
            return (Criteria) this;
        }

        public Criteria andZhaopljIn(List<String> values) {
            addCriterion("ZHAOPLJ in", values, "zhaoplj");
            return (Criteria) this;
        }

        public Criteria andZhaopljNotIn(List<String> values) {
            addCriterion("ZHAOPLJ not in", values, "zhaoplj");
            return (Criteria) this;
        }

        public Criteria andZhaopljBetween(String value1, String value2) {
            addCriterion("ZHAOPLJ between", value1, value2, "zhaoplj");
            return (Criteria) this;
        }

        public Criteria andZhaopljNotBetween(String value1, String value2) {
            addCriterion("ZHAOPLJ not between", value1, value2, "zhaoplj");
            return (Criteria) this;
        }

        public Criteria andCongyzgdmIsNull() {
            addCriterion("CONGYZGDM is null");
            return (Criteria) this;
        }

        public Criteria andCongyzgdmIsNotNull() {
            addCriterion("CONGYZGDM is not null");
            return (Criteria) this;
        }

        public Criteria andCongyzgdmEqualTo(String value) {
            addCriterion("CONGYZGDM =", value, "congyzgdm");
            return (Criteria) this;
        }

        public Criteria andCongyzgdmNotEqualTo(String value) {
            addCriterion("CONGYZGDM <>", value, "congyzgdm");
            return (Criteria) this;
        }

        public Criteria andCongyzgdmGreaterThan(String value) {
            addCriterion("CONGYZGDM >", value, "congyzgdm");
            return (Criteria) this;
        }

        public Criteria andCongyzgdmGreaterThanOrEqualTo(String value) {
            addCriterion("CONGYZGDM >=", value, "congyzgdm");
            return (Criteria) this;
        }

        public Criteria andCongyzgdmLessThan(String value) {
            addCriterion("CONGYZGDM <", value, "congyzgdm");
            return (Criteria) this;
        }

        public Criteria andCongyzgdmLessThanOrEqualTo(String value) {
            addCriterion("CONGYZGDM <=", value, "congyzgdm");
            return (Criteria) this;
        }

        public Criteria andCongyzgdmLike(String value) {
            addCriterion("CONGYZGDM like", value, "congyzgdm");
            return (Criteria) this;
        }

        public Criteria andCongyzgdmNotLike(String value) {
            addCriterion("CONGYZGDM not like", value, "congyzgdm");
            return (Criteria) this;
        }

        public Criteria andCongyzgdmIn(List<String> values) {
            addCriterion("CONGYZGDM in", values, "congyzgdm");
            return (Criteria) this;
        }

        public Criteria andCongyzgdmNotIn(List<String> values) {
            addCriterion("CONGYZGDM not in", values, "congyzgdm");
            return (Criteria) this;
        }

        public Criteria andCongyzgdmBetween(String value1, String value2) {
            addCriterion("CONGYZGDM between", value1, value2, "congyzgdm");
            return (Criteria) this;
        }

        public Criteria andCongyzgdmNotBetween(String value1, String value2) {
            addCriterion("CONGYZGDM not between", value1, value2, "congyzgdm");
            return (Criteria) this;
        }

        public Criteria andCongyzgmcIsNull() {
            addCriterion("CONGYZGMC is null");
            return (Criteria) this;
        }

        public Criteria andCongyzgmcIsNotNull() {
            addCriterion("CONGYZGMC is not null");
            return (Criteria) this;
        }

        public Criteria andCongyzgmcEqualTo(String value) {
            addCriterion("CONGYZGMC =", value, "congyzgmc");
            return (Criteria) this;
        }

        public Criteria andCongyzgmcNotEqualTo(String value) {
            addCriterion("CONGYZGMC <>", value, "congyzgmc");
            return (Criteria) this;
        }

        public Criteria andCongyzgmcGreaterThan(String value) {
            addCriterion("CONGYZGMC >", value, "congyzgmc");
            return (Criteria) this;
        }

        public Criteria andCongyzgmcGreaterThanOrEqualTo(String value) {
            addCriterion("CONGYZGMC >=", value, "congyzgmc");
            return (Criteria) this;
        }

        public Criteria andCongyzgmcLessThan(String value) {
            addCriterion("CONGYZGMC <", value, "congyzgmc");
            return (Criteria) this;
        }

        public Criteria andCongyzgmcLessThanOrEqualTo(String value) {
            addCriterion("CONGYZGMC <=", value, "congyzgmc");
            return (Criteria) this;
        }

        public Criteria andCongyzgmcLike(String value) {
            addCriterion("CONGYZGMC like", value, "congyzgmc");
            return (Criteria) this;
        }

        public Criteria andCongyzgmcNotLike(String value) {
            addCriterion("CONGYZGMC not like", value, "congyzgmc");
            return (Criteria) this;
        }

        public Criteria andCongyzgmcIn(List<String> values) {
            addCriterion("CONGYZGMC in", values, "congyzgmc");
            return (Criteria) this;
        }

        public Criteria andCongyzgmcNotIn(List<String> values) {
            addCriterion("CONGYZGMC not in", values, "congyzgmc");
            return (Criteria) this;
        }

        public Criteria andCongyzgmcBetween(String value1, String value2) {
            addCriterion("CONGYZGMC between", value1, value2, "congyzgmc");
            return (Criteria) this;
        }

        public Criteria andCongyzgmcNotBetween(String value1, String value2) {
            addCriterion("CONGYZGMC not between", value1, value2, "congyzgmc");
            return (Criteria) this;
        }

        public Criteria andAnqjsjlIsNull() {
            addCriterion("ANQJSJL is null");
            return (Criteria) this;
        }

        public Criteria andAnqjsjlIsNotNull() {
            addCriterion("ANQJSJL is not null");
            return (Criteria) this;
        }

        public Criteria andAnqjsjlEqualTo(Short value) {
            addCriterion("ANQJSJL =", value, "anqjsjl");
            return (Criteria) this;
        }

        public Criteria andAnqjsjlNotEqualTo(Short value) {
            addCriterion("ANQJSJL <>", value, "anqjsjl");
            return (Criteria) this;
        }

        public Criteria andAnqjsjlGreaterThan(Short value) {
            addCriterion("ANQJSJL >", value, "anqjsjl");
            return (Criteria) this;
        }

        public Criteria andAnqjsjlGreaterThanOrEqualTo(Short value) {
            addCriterion("ANQJSJL >=", value, "anqjsjl");
            return (Criteria) this;
        }

        public Criteria andAnqjsjlLessThan(Short value) {
            addCriterion("ANQJSJL <", value, "anqjsjl");
            return (Criteria) this;
        }

        public Criteria andAnqjsjlLessThanOrEqualTo(Short value) {
            addCriterion("ANQJSJL <=", value, "anqjsjl");
            return (Criteria) this;
        }

        public Criteria andAnqjsjlIn(List<Short> values) {
            addCriterion("ANQJSJL in", values, "anqjsjl");
            return (Criteria) this;
        }

        public Criteria andAnqjsjlNotIn(List<Short> values) {
            addCriterion("ANQJSJL not in", values, "anqjsjl");
            return (Criteria) this;
        }

        public Criteria andAnqjsjlBetween(Short value1, Short value2) {
            addCriterion("ANQJSJL between", value1, value2, "anqjsjl");
            return (Criteria) this;
        }

        public Criteria andAnqjsjlNotBetween(Short value1, Short value2) {
            addCriterion("ANQJSJL not between", value1, value2, "anqjsjl");
            return (Criteria) this;
        }

        public Criteria andXingzqhIsNull() {
            addCriterion("XINGZQH is null");
            return (Criteria) this;
        }

        public Criteria andXingzqhIsNotNull() {
            addCriterion("XINGZQH is not null");
            return (Criteria) this;
        }

        public Criteria andXingzqhEqualTo(String value) {
            addCriterion("XINGZQH =", value, "xingzqh");
            return (Criteria) this;
        }

        public Criteria andXingzqhNotEqualTo(String value) {
            addCriterion("XINGZQH <>", value, "xingzqh");
            return (Criteria) this;
        }

        public Criteria andXingzqhGreaterThan(String value) {
            addCriterion("XINGZQH >", value, "xingzqh");
            return (Criteria) this;
        }

        public Criteria andXingzqhGreaterThanOrEqualTo(String value) {
            addCriterion("XINGZQH >=", value, "xingzqh");
            return (Criteria) this;
        }

        public Criteria andXingzqhLessThan(String value) {
            addCriterion("XINGZQH <", value, "xingzqh");
            return (Criteria) this;
        }

        public Criteria andXingzqhLessThanOrEqualTo(String value) {
            addCriterion("XINGZQH <=", value, "xingzqh");
            return (Criteria) this;
        }

        public Criteria andXingzqhLike(String value) {
            addCriterion("XINGZQH like", value, "xingzqh");
            return (Criteria) this;
        }

        public Criteria andXingzqhNotLike(String value) {
            addCriterion("XINGZQH not like", value, "xingzqh");
            return (Criteria) this;
        }

        public Criteria andXingzqhIn(List<String> values) {
            addCriterion("XINGZQH in", values, "xingzqh");
            return (Criteria) this;
        }

        public Criteria andXingzqhNotIn(List<String> values) {
            addCriterion("XINGZQH not in", values, "xingzqh");
            return (Criteria) this;
        }

        public Criteria andXingzqhBetween(String value1, String value2) {
            addCriterion("XINGZQH between", value1, value2, "xingzqh");
            return (Criteria) this;
        }

        public Criteria andXingzqhNotBetween(String value1, String value2) {
            addCriterion("XINGZQH not between", value1, value2, "xingzqh");
            return (Criteria) this;
        }

        public Criteria andJigidIsNull() {
            addCriterion("JIGID is null");
            return (Criteria) this;
        }

        public Criteria andJigidIsNotNull() {
            addCriterion("JIGID is not null");
            return (Criteria) this;
        }

        public Criteria andJigidEqualTo(String value) {
            addCriterion("JIGID =", value, "jigid");
            return (Criteria) this;
        }

        public Criteria andJigidNotEqualTo(String value) {
            addCriterion("JIGID <>", value, "jigid");
            return (Criteria) this;
        }

        public Criteria andJigidGreaterThan(String value) {
            addCriterion("JIGID >", value, "jigid");
            return (Criteria) this;
        }

        public Criteria andJigidGreaterThanOrEqualTo(String value) {
            addCriterion("JIGID >=", value, "jigid");
            return (Criteria) this;
        }

        public Criteria andJigidLessThan(String value) {
            addCriterion("JIGID <", value, "jigid");
            return (Criteria) this;
        }

        public Criteria andJigidLessThanOrEqualTo(String value) {
            addCriterion("JIGID <=", value, "jigid");
            return (Criteria) this;
        }

        public Criteria andJigidLike(String value) {
            addCriterion("JIGID like", value, "jigid");
            return (Criteria) this;
        }

        public Criteria andJigidNotLike(String value) {
            addCriterion("JIGID not like", value, "jigid");
            return (Criteria) this;
        }

        public Criteria andJigidIn(List<String> values) {
            addCriterion("JIGID in", values, "jigid");
            return (Criteria) this;
        }

        public Criteria andJigidNotIn(List<String> values) {
            addCriterion("JIGID not in", values, "jigid");
            return (Criteria) this;
        }

        public Criteria andJigidBetween(String value1, String value2) {
            addCriterion("JIGID between", value1, value2, "jigid");
            return (Criteria) this;
        }

        public Criteria andJigidNotBetween(String value1, String value2) {
            addCriterion("JIGID not between", value1, value2, "jigid");
            return (Criteria) this;
        }

        public Criteria andZhucidIsNull() {
            addCriterion("ZHUCID is null");
            return (Criteria) this;
        }

        public Criteria andZhucidIsNotNull() {
            addCriterion("ZHUCID is not null");
            return (Criteria) this;
        }

        public Criteria andZhucidEqualTo(String value) {
            addCriterion("ZHUCID =", value, "zhucid");
            return (Criteria) this;
        }

        public Criteria andZhucidNotEqualTo(String value) {
            addCriterion("ZHUCID <>", value, "zhucid");
            return (Criteria) this;
        }

        public Criteria andZhucidGreaterThan(String value) {
            addCriterion("ZHUCID >", value, "zhucid");
            return (Criteria) this;
        }

        public Criteria andZhucidGreaterThanOrEqualTo(String value) {
            addCriterion("ZHUCID >=", value, "zhucid");
            return (Criteria) this;
        }

        public Criteria andZhucidLessThan(String value) {
            addCriterion("ZHUCID <", value, "zhucid");
            return (Criteria) this;
        }

        public Criteria andZhucidLessThanOrEqualTo(String value) {
            addCriterion("ZHUCID <=", value, "zhucid");
            return (Criteria) this;
        }

        public Criteria andZhucidLike(String value) {
            addCriterion("ZHUCID like", value, "zhucid");
            return (Criteria) this;
        }

        public Criteria andZhucidNotLike(String value) {
            addCriterion("ZHUCID not like", value, "zhucid");
            return (Criteria) this;
        }

        public Criteria andZhucidIn(List<String> values) {
            addCriterion("ZHUCID in", values, "zhucid");
            return (Criteria) this;
        }

        public Criteria andZhucidNotIn(List<String> values) {
            addCriterion("ZHUCID not in", values, "zhucid");
            return (Criteria) this;
        }

        public Criteria andZhucidBetween(String value1, String value2) {
            addCriterion("ZHUCID between", value1, value2, "zhucid");
            return (Criteria) this;
        }

        public Criteria andZhucidNotBetween(String value1, String value2) {
            addCriterion("ZHUCID not between", value1, value2, "zhucid");
            return (Criteria) this;
        }

        public Criteria andChuangjsjIsNull() {
            addCriterion("CHUANGJSJ is null");
            return (Criteria) this;
        }

        public Criteria andChuangjsjIsNotNull() {
            addCriterion("CHUANGJSJ is not null");
            return (Criteria) this;
        }

        public Criteria andChuangjsjEqualTo(String value) {
            addCriterion("CHUANGJSJ =", value, "chuangjsj");
            return (Criteria) this;
        }

        public Criteria andChuangjsjNotEqualTo(String value) {
            addCriterion("CHUANGJSJ <>", value, "chuangjsj");
            return (Criteria) this;
        }

        public Criteria andChuangjsjGreaterThan(String value) {
            addCriterion("CHUANGJSJ >", value, "chuangjsj");
            return (Criteria) this;
        }

        public Criteria andChuangjsjGreaterThanOrEqualTo(String value) {
            addCriterion("CHUANGJSJ >=", value, "chuangjsj");
            return (Criteria) this;
        }

        public Criteria andChuangjsjLessThan(String value) {
            addCriterion("CHUANGJSJ <", value, "chuangjsj");
            return (Criteria) this;
        }

        public Criteria andChuangjsjLessThanOrEqualTo(String value) {
            addCriterion("CHUANGJSJ <=", value, "chuangjsj");
            return (Criteria) this;
        }

        public Criteria andChuangjsjLike(String value) {
            addCriterion("CHUANGJSJ like", value, "chuangjsj");
            return (Criteria) this;
        }

        public Criteria andChuangjsjNotLike(String value) {
            addCriterion("CHUANGJSJ not like", value, "chuangjsj");
            return (Criteria) this;
        }

        public Criteria andChuangjsjIn(List<String> values) {
            addCriterion("CHUANGJSJ in", values, "chuangjsj");
            return (Criteria) this;
        }

        public Criteria andChuangjsjNotIn(List<String> values) {
            addCriterion("CHUANGJSJ not in", values, "chuangjsj");
            return (Criteria) this;
        }

        public Criteria andChuangjsjBetween(String value1, String value2) {
            addCriterion("CHUANGJSJ between", value1, value2, "chuangjsj");
            return (Criteria) this;
        }

        public Criteria andChuangjsjNotBetween(String value1, String value2) {
            addCriterion("CHUANGJSJ not between", value1, value2, "chuangjsj");
            return (Criteria) this;
        }

        public Criteria andChuangjrIsNull() {
            addCriterion("CHUANGJR is null");
            return (Criteria) this;
        }

        public Criteria andChuangjrIsNotNull() {
            addCriterion("CHUANGJR is not null");
            return (Criteria) this;
        }

        public Criteria andChuangjrEqualTo(String value) {
            addCriterion("CHUANGJR =", value, "chuangjr");
            return (Criteria) this;
        }

        public Criteria andChuangjrNotEqualTo(String value) {
            addCriterion("CHUANGJR <>", value, "chuangjr");
            return (Criteria) this;
        }

        public Criteria andChuangjrGreaterThan(String value) {
            addCriterion("CHUANGJR >", value, "chuangjr");
            return (Criteria) this;
        }

        public Criteria andChuangjrGreaterThanOrEqualTo(String value) {
            addCriterion("CHUANGJR >=", value, "chuangjr");
            return (Criteria) this;
        }

        public Criteria andChuangjrLessThan(String value) {
            addCriterion("CHUANGJR <", value, "chuangjr");
            return (Criteria) this;
        }

        public Criteria andChuangjrLessThanOrEqualTo(String value) {
            addCriterion("CHUANGJR <=", value, "chuangjr");
            return (Criteria) this;
        }

        public Criteria andChuangjrLike(String value) {
            addCriterion("CHUANGJR like", value, "chuangjr");
            return (Criteria) this;
        }

        public Criteria andChuangjrNotLike(String value) {
            addCriterion("CHUANGJR not like", value, "chuangjr");
            return (Criteria) this;
        }

        public Criteria andChuangjrIn(List<String> values) {
            addCriterion("CHUANGJR in", values, "chuangjr");
            return (Criteria) this;
        }

        public Criteria andChuangjrNotIn(List<String> values) {
            addCriterion("CHUANGJR not in", values, "chuangjr");
            return (Criteria) this;
        }

        public Criteria andChuangjrBetween(String value1, String value2) {
            addCriterion("CHUANGJR between", value1, value2, "chuangjr");
            return (Criteria) this;
        }

        public Criteria andChuangjrNotBetween(String value1, String value2) {
            addCriterion("CHUANGJR not between", value1, value2, "chuangjr");
            return (Criteria) this;
        }

        public Criteria andXiugsjIsNull() {
            addCriterion("XIUGSJ is null");
            return (Criteria) this;
        }

        public Criteria andXiugsjIsNotNull() {
            addCriterion("XIUGSJ is not null");
            return (Criteria) this;
        }

        public Criteria andXiugsjEqualTo(String value) {
            addCriterion("XIUGSJ =", value, "xiugsj");
            return (Criteria) this;
        }

        public Criteria andXiugsjNotEqualTo(String value) {
            addCriterion("XIUGSJ <>", value, "xiugsj");
            return (Criteria) this;
        }

        public Criteria andXiugsjGreaterThan(String value) {
            addCriterion("XIUGSJ >", value, "xiugsj");
            return (Criteria) this;
        }

        public Criteria andXiugsjGreaterThanOrEqualTo(String value) {
            addCriterion("XIUGSJ >=", value, "xiugsj");
            return (Criteria) this;
        }

        public Criteria andXiugsjLessThan(String value) {
            addCriterion("XIUGSJ <", value, "xiugsj");
            return (Criteria) this;
        }

        public Criteria andXiugsjLessThanOrEqualTo(String value) {
            addCriterion("XIUGSJ <=", value, "xiugsj");
            return (Criteria) this;
        }

        public Criteria andXiugsjLike(String value) {
            addCriterion("XIUGSJ like", value, "xiugsj");
            return (Criteria) this;
        }

        public Criteria andXiugsjNotLike(String value) {
            addCriterion("XIUGSJ not like", value, "xiugsj");
            return (Criteria) this;
        }

        public Criteria andXiugsjIn(List<String> values) {
            addCriterion("XIUGSJ in", values, "xiugsj");
            return (Criteria) this;
        }

        public Criteria andXiugsjNotIn(List<String> values) {
            addCriterion("XIUGSJ not in", values, "xiugsj");
            return (Criteria) this;
        }

        public Criteria andXiugsjBetween(String value1, String value2) {
            addCriterion("XIUGSJ between", value1, value2, "xiugsj");
            return (Criteria) this;
        }

        public Criteria andXiugsjNotBetween(String value1, String value2) {
            addCriterion("XIUGSJ not between", value1, value2, "xiugsj");
            return (Criteria) this;
        }

        public Criteria andXiugrIsNull() {
            addCriterion("XIUGR is null");
            return (Criteria) this;
        }

        public Criteria andXiugrIsNotNull() {
            addCriterion("XIUGR is not null");
            return (Criteria) this;
        }

        public Criteria andXiugrEqualTo(String value) {
            addCriterion("XIUGR =", value, "xiugr");
            return (Criteria) this;
        }

        public Criteria andXiugrNotEqualTo(String value) {
            addCriterion("XIUGR <>", value, "xiugr");
            return (Criteria) this;
        }

        public Criteria andXiugrGreaterThan(String value) {
            addCriterion("XIUGR >", value, "xiugr");
            return (Criteria) this;
        }

        public Criteria andXiugrGreaterThanOrEqualTo(String value) {
            addCriterion("XIUGR >=", value, "xiugr");
            return (Criteria) this;
        }

        public Criteria andXiugrLessThan(String value) {
            addCriterion("XIUGR <", value, "xiugr");
            return (Criteria) this;
        }

        public Criteria andXiugrLessThanOrEqualTo(String value) {
            addCriterion("XIUGR <=", value, "xiugr");
            return (Criteria) this;
        }

        public Criteria andXiugrLike(String value) {
            addCriterion("XIUGR like", value, "xiugr");
            return (Criteria) this;
        }

        public Criteria andXiugrNotLike(String value) {
            addCriterion("XIUGR not like", value, "xiugr");
            return (Criteria) this;
        }

        public Criteria andXiugrIn(List<String> values) {
            addCriterion("XIUGR in", values, "xiugr");
            return (Criteria) this;
        }

        public Criteria andXiugrNotIn(List<String> values) {
            addCriterion("XIUGR not in", values, "xiugr");
            return (Criteria) this;
        }

        public Criteria andXiugrBetween(String value1, String value2) {
            addCriterion("XIUGR between", value1, value2, "xiugr");
            return (Criteria) this;
        }

        public Criteria andXiugrNotBetween(String value1, String value2) {
            addCriterion("XIUGR not between", value1, value2, "xiugr");
            return (Criteria) this;
        }

        public Criteria andFuwqbsIsNull() {
            addCriterion("FUWQBS is null");
            return (Criteria) this;
        }

        public Criteria andFuwqbsIsNotNull() {
            addCriterion("FUWQBS is not null");
            return (Criteria) this;
        }

        public Criteria andFuwqbsEqualTo(String value) {
            addCriterion("FUWQBS =", value, "fuwqbs");
            return (Criteria) this;
        }

        public Criteria andFuwqbsNotEqualTo(String value) {
            addCriterion("FUWQBS <>", value, "fuwqbs");
            return (Criteria) this;
        }

        public Criteria andFuwqbsGreaterThan(String value) {
            addCriterion("FUWQBS >", value, "fuwqbs");
            return (Criteria) this;
        }

        public Criteria andFuwqbsGreaterThanOrEqualTo(String value) {
            addCriterion("FUWQBS >=", value, "fuwqbs");
            return (Criteria) this;
        }

        public Criteria andFuwqbsLessThan(String value) {
            addCriterion("FUWQBS <", value, "fuwqbs");
            return (Criteria) this;
        }

        public Criteria andFuwqbsLessThanOrEqualTo(String value) {
            addCriterion("FUWQBS <=", value, "fuwqbs");
            return (Criteria) this;
        }

        public Criteria andFuwqbsLike(String value) {
            addCriterion("FUWQBS like", value, "fuwqbs");
            return (Criteria) this;
        }

        public Criteria andFuwqbsNotLike(String value) {
            addCriterion("FUWQBS not like", value, "fuwqbs");
            return (Criteria) this;
        }

        public Criteria andFuwqbsIn(List<String> values) {
            addCriterion("FUWQBS in", values, "fuwqbs");
            return (Criteria) this;
        }

        public Criteria andFuwqbsNotIn(List<String> values) {
            addCriterion("FUWQBS not in", values, "fuwqbs");
            return (Criteria) this;
        }

        public Criteria andFuwqbsBetween(String value1, String value2) {
            addCriterion("FUWQBS between", value1, value2, "fuwqbs");
            return (Criteria) this;
        }

        public Criteria andFuwqbsNotBetween(String value1, String value2) {
            addCriterion("FUWQBS not between", value1, value2, "fuwqbs");
            return (Criteria) this;
        }

        public Criteria andBeizIsNull() {
            addCriterion("BEIZ is null");
            return (Criteria) this;
        }

        public Criteria andBeizIsNotNull() {
            addCriterion("BEIZ is not null");
            return (Criteria) this;
        }

        public Criteria andBeizEqualTo(String value) {
            addCriterion("BEIZ =", value, "beiz");
            return (Criteria) this;
        }

        public Criteria andBeizNotEqualTo(String value) {
            addCriterion("BEIZ <>", value, "beiz");
            return (Criteria) this;
        }

        public Criteria andBeizGreaterThan(String value) {
            addCriterion("BEIZ >", value, "beiz");
            return (Criteria) this;
        }

        public Criteria andBeizGreaterThanOrEqualTo(String value) {
            addCriterion("BEIZ >=", value, "beiz");
            return (Criteria) this;
        }

        public Criteria andBeizLessThan(String value) {
            addCriterion("BEIZ <", value, "beiz");
            return (Criteria) this;
        }

        public Criteria andBeizLessThanOrEqualTo(String value) {
            addCriterion("BEIZ <=", value, "beiz");
            return (Criteria) this;
        }

        public Criteria andBeizLike(String value) {
            addCriterion("BEIZ like", value, "beiz");
            return (Criteria) this;
        }

        public Criteria andBeizNotLike(String value) {
            addCriterion("BEIZ not like", value, "beiz");
            return (Criteria) this;
        }

        public Criteria andBeizIn(List<String> values) {
            addCriterion("BEIZ in", values, "beiz");
            return (Criteria) this;
        }

        public Criteria andBeizNotIn(List<String> values) {
            addCriterion("BEIZ not in", values, "beiz");
            return (Criteria) this;
        }

        public Criteria andBeizBetween(String value1, String value2) {
            addCriterion("BEIZ between", value1, value2, "beiz");
            return (Criteria) this;
        }

        public Criteria andBeizNotBetween(String value1, String value2) {
            addCriterion("BEIZ not between", value1, value2, "beiz");
            return (Criteria) this;
        }

        public Criteria andCongyryidLikeInsensitive(String value) {
            addCriterion("upper(CONGYRYID) like", value.toUpperCase(), "congyryid");
            return (Criteria) this;
        }

        public Criteria andXingmLikeInsensitive(String value) {
            addCriterion("upper(XINGM) like", value.toUpperCase(), "xingm");
            return (Criteria) this;
        }

        public Criteria andXingbLikeInsensitive(String value) {
            addCriterion("upper(XINGB) like", value.toUpperCase(), "xingb");
            return (Criteria) this;
        }

        public Criteria andChusrqLikeInsensitive(String value) {
            addCriterion("upper(CHUSRQ) like", value.toUpperCase(), "chusrq");
            return (Criteria) this;
        }

        public Criteria andShenfzjlbLikeInsensitive(String value) {
            addCriterion("upper(SHENFZJLB) like", value.toUpperCase(), "shenfzjlb");
            return (Criteria) this;
        }

        public Criteria andShenfzjbhLikeInsensitive(String value) {
            addCriterion("upper(SHENFZJBH) like", value.toUpperCase(), "shenfzjbh");
            return (Criteria) this;
        }

        public Criteria andLisqxLikeInsensitive(String value) {
            addCriterion("upper(LISQX) like", value.toUpperCase(), "lisqx");
            return (Criteria) this;
        }

        public Criteria andGuddhLikeInsensitive(String value) {
            addCriterion("upper(GUDDH) like", value.toUpperCase(), "guddh");
            return (Criteria) this;
        }

        public Criteria andYiddhLikeInsensitive(String value) {
            addCriterion("upper(YIDDH) like", value.toUpperCase(), "yiddh");
            return (Criteria) this;
        }

        public Criteria andShenfzdzLikeInsensitive(String value) {
            addCriterion("upper(SHENFZDZ) like", value.toUpperCase(), "shenfzdz");
            return (Criteria) this;
        }

        public Criteria andXianzdzLikeInsensitive(String value) {
            addCriterion("upper(XIANZDZ) like", value.toUpperCase(), "xianzdz");
            return (Criteria) this;
        }

        public Criteria andDianzyxLikeInsensitive(String value) {
            addCriterion("upper(DIANZYX) like", value.toUpperCase(), "dianzyx");
            return (Criteria) this;
        }

        public Criteria andZhuzyzbmLikeInsensitive(String value) {
            addCriterion("upper(ZHUZYZBM) like", value.toUpperCase(), "zhuzyzbm");
            return (Criteria) this;
        }

        public Criteria andZhuanyjsLikeInsensitive(String value) {
            addCriterion("upper(ZHUANYJS) like", value.toUpperCase(), "zhuanyjs");
            return (Criteria) this;
        }

        public Criteria andJiaszhLikeInsensitive(String value) {
            addCriterion("upper(JIASZH) like", value.toUpperCase(), "jiaszh");
            return (Criteria) this;
        }

        public Criteria andZhunjcxLikeInsensitive(String value) {
            addCriterion("upper(ZHUNJCX) like", value.toUpperCase(), "zhunjcx");
            return (Criteria) this;
        }

        public Criteria andJiazclrqLikeInsensitive(String value) {
            addCriterion("upper(JIAZCLRQ) like", value.toUpperCase(), "jiazclrq");
            return (Criteria) this;
        }

        public Criteria andJiazyxqsLikeInsensitive(String value) {
            addCriterion("upper(JIAZYXQS) like", value.toUpperCase(), "jiazyxqs");
            return (Criteria) this;
        }

        public Criteria andJiazyxqzLikeInsensitive(String value) {
            addCriterion("upper(JIAZYXQZ) like", value.toUpperCase(), "jiazyxqz");
            return (Criteria) this;
        }

        public Criteria andJiazfzjgLikeInsensitive(String value) {
            addCriterion("upper(JIAZFZJG) like", value.toUpperCase(), "jiazfzjg");
            return (Criteria) this;
        }

        public Criteria andZhaopljLikeInsensitive(String value) {
            addCriterion("upper(ZHAOPLJ) like", value.toUpperCase(), "zhaoplj");
            return (Criteria) this;
        }

        public Criteria andCongyzgdmLikeInsensitive(String value) {
            addCriterion("upper(CONGYZGDM) like", value.toUpperCase(), "congyzgdm");
            return (Criteria) this;
        }

        public Criteria andCongyzgmcLikeInsensitive(String value) {
            addCriterion("upper(CONGYZGMC) like", value.toUpperCase(), "congyzgmc");
            return (Criteria) this;
        }

        public Criteria andXingzqhLikeInsensitive(String value) {
            addCriterion("upper(XINGZQH) like", value.toUpperCase(), "xingzqh");
            return (Criteria) this;
        }

        public Criteria andJigidLikeInsensitive(String value) {
            addCriterion("upper(JIGID) like", value.toUpperCase(), "jigid");
            return (Criteria) this;
        }

        public Criteria andZhucidLikeInsensitive(String value) {
            addCriterion("upper(ZHUCID) like", value.toUpperCase(), "zhucid");
            return (Criteria) this;
        }

        public Criteria andChuangjsjLikeInsensitive(String value) {
            addCriterion("upper(CHUANGJSJ) like", value.toUpperCase(), "chuangjsj");
            return (Criteria) this;
        }

        public Criteria andChuangjrLikeInsensitive(String value) {
            addCriterion("upper(CHUANGJR) like", value.toUpperCase(), "chuangjr");
            return (Criteria) this;
        }

        public Criteria andXiugsjLikeInsensitive(String value) {
            addCriterion("upper(XIUGSJ) like", value.toUpperCase(), "xiugsj");
            return (Criteria) this;
        }

        public Criteria andXiugrLikeInsensitive(String value) {
            addCriterion("upper(XIUGR) like", value.toUpperCase(), "xiugr");
            return (Criteria) this;
        }

        public Criteria andFuwqbsLikeInsensitive(String value) {
            addCriterion("upper(FUWQBS) like", value.toUpperCase(), "fuwqbs");
            return (Criteria) this;
        }

        public Criteria andBeizLikeInsensitive(String value) {
            addCriterion("upper(BEIZ) like", value.toUpperCase(), "beiz");
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