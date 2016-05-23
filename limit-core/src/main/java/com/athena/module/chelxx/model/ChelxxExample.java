package com.athena.module.chelxx.model;

import com.athena.common.dto.Pagination;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ChelxxExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Pagination pagination;

    public ChelxxExample() {
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

        public Criteria andChelidIsNull() {
            addCriterion("CHELID is null");
            return (Criteria) this;
        }

        public Criteria andChelidIsNotNull() {
            addCriterion("CHELID is not null");
            return (Criteria) this;
        }

        public Criteria andChelidEqualTo(String value) {
            addCriterion("CHELID =", value, "chelid");
            return (Criteria) this;
        }

        public Criteria andChelidNotEqualTo(String value) {
            addCriterion("CHELID <>", value, "chelid");
            return (Criteria) this;
        }

        public Criteria andChelidGreaterThan(String value) {
            addCriterion("CHELID >", value, "chelid");
            return (Criteria) this;
        }

        public Criteria andChelidGreaterThanOrEqualTo(String value) {
            addCriterion("CHELID >=", value, "chelid");
            return (Criteria) this;
        }

        public Criteria andChelidLessThan(String value) {
            addCriterion("CHELID <", value, "chelid");
            return (Criteria) this;
        }

        public Criteria andChelidLessThanOrEqualTo(String value) {
            addCriterion("CHELID <=", value, "chelid");
            return (Criteria) this;
        }

        public Criteria andChelidLike(String value) {
            addCriterion("CHELID like", value, "chelid");
            return (Criteria) this;
        }

        public Criteria andChelidNotLike(String value) {
            addCriterion("CHELID not like", value, "chelid");
            return (Criteria) this;
        }

        public Criteria andChelidIn(List<String> values) {
            addCriterion("CHELID in", values, "chelid");
            return (Criteria) this;
        }

        public Criteria andChelidNotIn(List<String> values) {
            addCriterion("CHELID not in", values, "chelid");
            return (Criteria) this;
        }

        public Criteria andChelidBetween(String value1, String value2) {
            addCriterion("CHELID between", value1, value2, "chelid");
            return (Criteria) this;
        }

        public Criteria andChelidNotBetween(String value1, String value2) {
            addCriterion("CHELID not between", value1, value2, "chelid");
            return (Criteria) this;
        }

        public Criteria andChephIsNull() {
            addCriterion("CHEPH is null");
            return (Criteria) this;
        }

        public Criteria andChephIsNotNull() {
            addCriterion("CHEPH is not null");
            return (Criteria) this;
        }

        public Criteria andChephEqualTo(String value) {
            addCriterion("CHEPH =", value, "cheph");
            return (Criteria) this;
        }

        public Criteria andChephNotEqualTo(String value) {
            addCriterion("CHEPH <>", value, "cheph");
            return (Criteria) this;
        }

        public Criteria andChephGreaterThan(String value) {
            addCriterion("CHEPH >", value, "cheph");
            return (Criteria) this;
        }

        public Criteria andChephGreaterThanOrEqualTo(String value) {
            addCriterion("CHEPH >=", value, "cheph");
            return (Criteria) this;
        }

        public Criteria andChephLessThan(String value) {
            addCriterion("CHEPH <", value, "cheph");
            return (Criteria) this;
        }

        public Criteria andChephLessThanOrEqualTo(String value) {
            addCriterion("CHEPH <=", value, "cheph");
            return (Criteria) this;
        }

        public Criteria andChephLike(String value) {
            addCriterion("CHEPH like", value, "cheph");
            return (Criteria) this;
        }

        public Criteria andChephNotLike(String value) {
            addCriterion("CHEPH not like", value, "cheph");
            return (Criteria) this;
        }

        public Criteria andChephIn(List<String> values) {
            addCriterion("CHEPH in", values, "cheph");
            return (Criteria) this;
        }

        public Criteria andChephNotIn(List<String> values) {
            addCriterion("CHEPH not in", values, "cheph");
            return (Criteria) this;
        }

        public Criteria andChephBetween(String value1, String value2) {
            addCriterion("CHEPH between", value1, value2, "cheph");
            return (Criteria) this;
        }

        public Criteria andChephNotBetween(String value1, String value2) {
            addCriterion("CHEPH not between", value1, value2, "cheph");
            return (Criteria) this;
        }

        public Criteria andChepysIsNull() {
            addCriterion("CHEPYS is null");
            return (Criteria) this;
        }

        public Criteria andChepysIsNotNull() {
            addCriterion("CHEPYS is not null");
            return (Criteria) this;
        }

        public Criteria andChepysEqualTo(String value) {
            addCriterion("CHEPYS =", value, "chepys");
            return (Criteria) this;
        }

        public Criteria andChepysNotEqualTo(String value) {
            addCriterion("CHEPYS <>", value, "chepys");
            return (Criteria) this;
        }

        public Criteria andChepysGreaterThan(String value) {
            addCriterion("CHEPYS >", value, "chepys");
            return (Criteria) this;
        }

        public Criteria andChepysGreaterThanOrEqualTo(String value) {
            addCriterion("CHEPYS >=", value, "chepys");
            return (Criteria) this;
        }

        public Criteria andChepysLessThan(String value) {
            addCriterion("CHEPYS <", value, "chepys");
            return (Criteria) this;
        }

        public Criteria andChepysLessThanOrEqualTo(String value) {
            addCriterion("CHEPYS <=", value, "chepys");
            return (Criteria) this;
        }

        public Criteria andChepysLike(String value) {
            addCriterion("CHEPYS like", value, "chepys");
            return (Criteria) this;
        }

        public Criteria andChepysNotLike(String value) {
            addCriterion("CHEPYS not like", value, "chepys");
            return (Criteria) this;
        }

        public Criteria andChepysIn(List<String> values) {
            addCriterion("CHEPYS in", values, "chepys");
            return (Criteria) this;
        }

        public Criteria andChepysNotIn(List<String> values) {
            addCriterion("CHEPYS not in", values, "chepys");
            return (Criteria) this;
        }

        public Criteria andChepysBetween(String value1, String value2) {
            addCriterion("CHEPYS between", value1, value2, "chepys");
            return (Criteria) this;
        }

        public Criteria andChepysNotBetween(String value1, String value2) {
            addCriterion("CHEPYS not between", value1, value2, "chepys");
            return (Criteria) this;
        }

        public Criteria andShifgcIsNull() {
            addCriterion("SHIFGC is null");
            return (Criteria) this;
        }

        public Criteria andShifgcIsNotNull() {
            addCriterion("SHIFGC is not null");
            return (Criteria) this;
        }

        public Criteria andShifgcEqualTo(String value) {
            addCriterion("SHIFGC =", value, "shifgc");
            return (Criteria) this;
        }

        public Criteria andShifgcNotEqualTo(String value) {
            addCriterion("SHIFGC <>", value, "shifgc");
            return (Criteria) this;
        }

        public Criteria andShifgcGreaterThan(String value) {
            addCriterion("SHIFGC >", value, "shifgc");
            return (Criteria) this;
        }

        public Criteria andShifgcGreaterThanOrEqualTo(String value) {
            addCriterion("SHIFGC >=", value, "shifgc");
            return (Criteria) this;
        }

        public Criteria andShifgcLessThan(String value) {
            addCriterion("SHIFGC <", value, "shifgc");
            return (Criteria) this;
        }

        public Criteria andShifgcLessThanOrEqualTo(String value) {
            addCriterion("SHIFGC <=", value, "shifgc");
            return (Criteria) this;
        }

        public Criteria andShifgcLike(String value) {
            addCriterion("SHIFGC like", value, "shifgc");
            return (Criteria) this;
        }

        public Criteria andShifgcNotLike(String value) {
            addCriterion("SHIFGC not like", value, "shifgc");
            return (Criteria) this;
        }

        public Criteria andShifgcIn(List<String> values) {
            addCriterion("SHIFGC in", values, "shifgc");
            return (Criteria) this;
        }

        public Criteria andShifgcNotIn(List<String> values) {
            addCriterion("SHIFGC not in", values, "shifgc");
            return (Criteria) this;
        }

        public Criteria andShifgcBetween(String value1, String value2) {
            addCriterion("SHIFGC between", value1, value2, "shifgc");
            return (Criteria) this;
        }

        public Criteria andShifgcNotBetween(String value1, String value2) {
            addCriterion("SHIFGC not between", value1, value2, "shifgc");
            return (Criteria) this;
        }

        public Criteria andChellxIsNull() {
            addCriterion("CHELLX is null");
            return (Criteria) this;
        }

        public Criteria andChellxIsNotNull() {
            addCriterion("CHELLX is not null");
            return (Criteria) this;
        }

        public Criteria andChellxEqualTo(String value) {
            addCriterion("CHELLX =", value, "chellx");
            return (Criteria) this;
        }

        public Criteria andChellxNotEqualTo(String value) {
            addCriterion("CHELLX <>", value, "chellx");
            return (Criteria) this;
        }

        public Criteria andChellxGreaterThan(String value) {
            addCriterion("CHELLX >", value, "chellx");
            return (Criteria) this;
        }

        public Criteria andChellxGreaterThanOrEqualTo(String value) {
            addCriterion("CHELLX >=", value, "chellx");
            return (Criteria) this;
        }

        public Criteria andChellxLessThan(String value) {
            addCriterion("CHELLX <", value, "chellx");
            return (Criteria) this;
        }

        public Criteria andChellxLessThanOrEqualTo(String value) {
            addCriterion("CHELLX <=", value, "chellx");
            return (Criteria) this;
        }

        public Criteria andChellxLike(String value) {
            addCriterion("CHELLX like", value, "chellx");
            return (Criteria) this;
        }

        public Criteria andChellxNotLike(String value) {
            addCriterion("CHELLX not like", value, "chellx");
            return (Criteria) this;
        }

        public Criteria andChellxIn(List<String> values) {
            addCriterion("CHELLX in", values, "chellx");
            return (Criteria) this;
        }

        public Criteria andChellxNotIn(List<String> values) {
            addCriterion("CHELLX not in", values, "chellx");
            return (Criteria) this;
        }

        public Criteria andChellxBetween(String value1, String value2) {
            addCriterion("CHELLX between", value1, value2, "chellx");
            return (Criteria) this;
        }

        public Criteria andChellxNotBetween(String value1, String value2) {
            addCriterion("CHELLX not between", value1, value2, "chellx");
            return (Criteria) this;
        }

        public Criteria andGuigIsNull() {
            addCriterion("GUIG is null");
            return (Criteria) this;
        }

        public Criteria andGuigIsNotNull() {
            addCriterion("GUIG is not null");
            return (Criteria) this;
        }

        public Criteria andGuigEqualTo(String value) {
            addCriterion("GUIG =", value, "guig");
            return (Criteria) this;
        }

        public Criteria andGuigNotEqualTo(String value) {
            addCriterion("GUIG <>", value, "guig");
            return (Criteria) this;
        }

        public Criteria andGuigGreaterThan(String value) {
            addCriterion("GUIG >", value, "guig");
            return (Criteria) this;
        }

        public Criteria andGuigGreaterThanOrEqualTo(String value) {
            addCriterion("GUIG >=", value, "guig");
            return (Criteria) this;
        }

        public Criteria andGuigLessThan(String value) {
            addCriterion("GUIG <", value, "guig");
            return (Criteria) this;
        }

        public Criteria andGuigLessThanOrEqualTo(String value) {
            addCriterion("GUIG <=", value, "guig");
            return (Criteria) this;
        }

        public Criteria andGuigLike(String value) {
            addCriterion("GUIG like", value, "guig");
            return (Criteria) this;
        }

        public Criteria andGuigNotLike(String value) {
            addCriterion("GUIG not like", value, "guig");
            return (Criteria) this;
        }

        public Criteria andGuigIn(List<String> values) {
            addCriterion("GUIG in", values, "guig");
            return (Criteria) this;
        }

        public Criteria andGuigNotIn(List<String> values) {
            addCriterion("GUIG not in", values, "guig");
            return (Criteria) this;
        }

        public Criteria andGuigBetween(String value1, String value2) {
            addCriterion("GUIG between", value1, value2, "guig");
            return (Criteria) this;
        }

        public Criteria andGuigNotBetween(String value1, String value2) {
            addCriterion("GUIG not between", value1, value2, "guig");
            return (Criteria) this;
        }

        public Criteria andJiegIsNull() {
            addCriterion("JIEG is null");
            return (Criteria) this;
        }

        public Criteria andJiegIsNotNull() {
            addCriterion("JIEG is not null");
            return (Criteria) this;
        }

        public Criteria andJiegEqualTo(String value) {
            addCriterion("JIEG =", value, "jieg");
            return (Criteria) this;
        }

        public Criteria andJiegNotEqualTo(String value) {
            addCriterion("JIEG <>", value, "jieg");
            return (Criteria) this;
        }

        public Criteria andJiegGreaterThan(String value) {
            addCriterion("JIEG >", value, "jieg");
            return (Criteria) this;
        }

        public Criteria andJiegGreaterThanOrEqualTo(String value) {
            addCriterion("JIEG >=", value, "jieg");
            return (Criteria) this;
        }

        public Criteria andJiegLessThan(String value) {
            addCriterion("JIEG <", value, "jieg");
            return (Criteria) this;
        }

        public Criteria andJiegLessThanOrEqualTo(String value) {
            addCriterion("JIEG <=", value, "jieg");
            return (Criteria) this;
        }

        public Criteria andJiegLike(String value) {
            addCriterion("JIEG like", value, "jieg");
            return (Criteria) this;
        }

        public Criteria andJiegNotLike(String value) {
            addCriterion("JIEG not like", value, "jieg");
            return (Criteria) this;
        }

        public Criteria andJiegIn(List<String> values) {
            addCriterion("JIEG in", values, "jieg");
            return (Criteria) this;
        }

        public Criteria andJiegNotIn(List<String> values) {
            addCriterion("JIEG not in", values, "jieg");
            return (Criteria) this;
        }

        public Criteria andJiegBetween(String value1, String value2) {
            addCriterion("JIEG between", value1, value2, "jieg");
            return (Criteria) this;
        }

        public Criteria andJiegNotBetween(String value1, String value2) {
            addCriterion("JIEG not between", value1, value2, "jieg");
            return (Criteria) this;
        }

        public Criteria andChelhylbIsNull() {
            addCriterion("CHELHYLB is null");
            return (Criteria) this;
        }

        public Criteria andChelhylbIsNotNull() {
            addCriterion("CHELHYLB is not null");
            return (Criteria) this;
        }

        public Criteria andChelhylbEqualTo(String value) {
            addCriterion("CHELHYLB =", value, "chelhylb");
            return (Criteria) this;
        }

        public Criteria andChelhylbNotEqualTo(String value) {
            addCriterion("CHELHYLB <>", value, "chelhylb");
            return (Criteria) this;
        }

        public Criteria andChelhylbGreaterThan(String value) {
            addCriterion("CHELHYLB >", value, "chelhylb");
            return (Criteria) this;
        }

        public Criteria andChelhylbGreaterThanOrEqualTo(String value) {
            addCriterion("CHELHYLB >=", value, "chelhylb");
            return (Criteria) this;
        }

        public Criteria andChelhylbLessThan(String value) {
            addCriterion("CHELHYLB <", value, "chelhylb");
            return (Criteria) this;
        }

        public Criteria andChelhylbLessThanOrEqualTo(String value) {
            addCriterion("CHELHYLB <=", value, "chelhylb");
            return (Criteria) this;
        }

        public Criteria andChelhylbLike(String value) {
            addCriterion("CHELHYLB like", value, "chelhylb");
            return (Criteria) this;
        }

        public Criteria andChelhylbNotLike(String value) {
            addCriterion("CHELHYLB not like", value, "chelhylb");
            return (Criteria) this;
        }

        public Criteria andChelhylbIn(List<String> values) {
            addCriterion("CHELHYLB in", values, "chelhylb");
            return (Criteria) this;
        }

        public Criteria andChelhylbNotIn(List<String> values) {
            addCriterion("CHELHYLB not in", values, "chelhylb");
            return (Criteria) this;
        }

        public Criteria andChelhylbBetween(String value1, String value2) {
            addCriterion("CHELHYLB between", value1, value2, "chelhylb");
            return (Criteria) this;
        }

        public Criteria andChelhylbNotBetween(String value1, String value2) {
            addCriterion("CHELHYLB not between", value1, value2, "chelhylb");
            return (Criteria) this;
        }

        public Criteria andChesysIsNull() {
            addCriterion("CHESYS is null");
            return (Criteria) this;
        }

        public Criteria andChesysIsNotNull() {
            addCriterion("CHESYS is not null");
            return (Criteria) this;
        }

        public Criteria andChesysEqualTo(String value) {
            addCriterion("CHESYS =", value, "chesys");
            return (Criteria) this;
        }

        public Criteria andChesysNotEqualTo(String value) {
            addCriterion("CHESYS <>", value, "chesys");
            return (Criteria) this;
        }

        public Criteria andChesysGreaterThan(String value) {
            addCriterion("CHESYS >", value, "chesys");
            return (Criteria) this;
        }

        public Criteria andChesysGreaterThanOrEqualTo(String value) {
            addCriterion("CHESYS >=", value, "chesys");
            return (Criteria) this;
        }

        public Criteria andChesysLessThan(String value) {
            addCriterion("CHESYS <", value, "chesys");
            return (Criteria) this;
        }

        public Criteria andChesysLessThanOrEqualTo(String value) {
            addCriterion("CHESYS <=", value, "chesys");
            return (Criteria) this;
        }

        public Criteria andChesysLike(String value) {
            addCriterion("CHESYS like", value, "chesys");
            return (Criteria) this;
        }

        public Criteria andChesysNotLike(String value) {
            addCriterion("CHESYS not like", value, "chesys");
            return (Criteria) this;
        }

        public Criteria andChesysIn(List<String> values) {
            addCriterion("CHESYS in", values, "chesys");
            return (Criteria) this;
        }

        public Criteria andChesysNotIn(List<String> values) {
            addCriterion("CHESYS not in", values, "chesys");
            return (Criteria) this;
        }

        public Criteria andChesysBetween(String value1, String value2) {
            addCriterion("CHESYS between", value1, value2, "chesys");
            return (Criteria) this;
        }

        public Criteria andChesysNotBetween(String value1, String value2) {
            addCriterion("CHESYS not between", value1, value2, "chesys");
            return (Criteria) this;
        }

        public Criteria andChangpIsNull() {
            addCriterion("CHANGP is null");
            return (Criteria) this;
        }

        public Criteria andChangpIsNotNull() {
            addCriterion("CHANGP is not null");
            return (Criteria) this;
        }

        public Criteria andChangpEqualTo(String value) {
            addCriterion("CHANGP =", value, "changp");
            return (Criteria) this;
        }

        public Criteria andChangpNotEqualTo(String value) {
            addCriterion("CHANGP <>", value, "changp");
            return (Criteria) this;
        }

        public Criteria andChangpGreaterThan(String value) {
            addCriterion("CHANGP >", value, "changp");
            return (Criteria) this;
        }

        public Criteria andChangpGreaterThanOrEqualTo(String value) {
            addCriterion("CHANGP >=", value, "changp");
            return (Criteria) this;
        }

        public Criteria andChangpLessThan(String value) {
            addCriterion("CHANGP <", value, "changp");
            return (Criteria) this;
        }

        public Criteria andChangpLessThanOrEqualTo(String value) {
            addCriterion("CHANGP <=", value, "changp");
            return (Criteria) this;
        }

        public Criteria andChangpLike(String value) {
            addCriterion("CHANGP like", value, "changp");
            return (Criteria) this;
        }

        public Criteria andChangpNotLike(String value) {
            addCriterion("CHANGP not like", value, "changp");
            return (Criteria) this;
        }

        public Criteria andChangpIn(List<String> values) {
            addCriterion("CHANGP in", values, "changp");
            return (Criteria) this;
        }

        public Criteria andChangpNotIn(List<String> values) {
            addCriterion("CHANGP not in", values, "changp");
            return (Criteria) this;
        }

        public Criteria andChangpBetween(String value1, String value2) {
            addCriterion("CHANGP between", value1, value2, "changp");
            return (Criteria) this;
        }

        public Criteria andChangpNotBetween(String value1, String value2) {
            addCriterion("CHANGP not between", value1, value2, "changp");
            return (Criteria) this;
        }

        public Criteria andXinghIsNull() {
            addCriterion("XINGH is null");
            return (Criteria) this;
        }

        public Criteria andXinghIsNotNull() {
            addCriterion("XINGH is not null");
            return (Criteria) this;
        }

        public Criteria andXinghEqualTo(String value) {
            addCriterion("XINGH =", value, "xingh");
            return (Criteria) this;
        }

        public Criteria andXinghNotEqualTo(String value) {
            addCriterion("XINGH <>", value, "xingh");
            return (Criteria) this;
        }

        public Criteria andXinghGreaterThan(String value) {
            addCriterion("XINGH >", value, "xingh");
            return (Criteria) this;
        }

        public Criteria andXinghGreaterThanOrEqualTo(String value) {
            addCriterion("XINGH >=", value, "xingh");
            return (Criteria) this;
        }

        public Criteria andXinghLessThan(String value) {
            addCriterion("XINGH <", value, "xingh");
            return (Criteria) this;
        }

        public Criteria andXinghLessThanOrEqualTo(String value) {
            addCriterion("XINGH <=", value, "xingh");
            return (Criteria) this;
        }

        public Criteria andXinghLike(String value) {
            addCriterion("XINGH like", value, "xingh");
            return (Criteria) this;
        }

        public Criteria andXinghNotLike(String value) {
            addCriterion("XINGH not like", value, "xingh");
            return (Criteria) this;
        }

        public Criteria andXinghIn(List<String> values) {
            addCriterion("XINGH in", values, "xingh");
            return (Criteria) this;
        }

        public Criteria andXinghNotIn(List<String> values) {
            addCriterion("XINGH not in", values, "xingh");
            return (Criteria) this;
        }

        public Criteria andXinghBetween(String value1, String value2) {
            addCriterion("XINGH between", value1, value2, "xingh");
            return (Criteria) this;
        }

        public Criteria andXinghNotBetween(String value1, String value2) {
            addCriterion("XINGH not between", value1, value2, "xingh");
            return (Criteria) this;
        }

        public Criteria andFadjxhIsNull() {
            addCriterion("FADJXH is null");
            return (Criteria) this;
        }

        public Criteria andFadjxhIsNotNull() {
            addCriterion("FADJXH is not null");
            return (Criteria) this;
        }

        public Criteria andFadjxhEqualTo(String value) {
            addCriterion("FADJXH =", value, "fadjxh");
            return (Criteria) this;
        }

        public Criteria andFadjxhNotEqualTo(String value) {
            addCriterion("FADJXH <>", value, "fadjxh");
            return (Criteria) this;
        }

        public Criteria andFadjxhGreaterThan(String value) {
            addCriterion("FADJXH >", value, "fadjxh");
            return (Criteria) this;
        }

        public Criteria andFadjxhGreaterThanOrEqualTo(String value) {
            addCriterion("FADJXH >=", value, "fadjxh");
            return (Criteria) this;
        }

        public Criteria andFadjxhLessThan(String value) {
            addCriterion("FADJXH <", value, "fadjxh");
            return (Criteria) this;
        }

        public Criteria andFadjxhLessThanOrEqualTo(String value) {
            addCriterion("FADJXH <=", value, "fadjxh");
            return (Criteria) this;
        }

        public Criteria andFadjxhLike(String value) {
            addCriterion("FADJXH like", value, "fadjxh");
            return (Criteria) this;
        }

        public Criteria andFadjxhNotLike(String value) {
            addCriterion("FADJXH not like", value, "fadjxh");
            return (Criteria) this;
        }

        public Criteria andFadjxhIn(List<String> values) {
            addCriterion("FADJXH in", values, "fadjxh");
            return (Criteria) this;
        }

        public Criteria andFadjxhNotIn(List<String> values) {
            addCriterion("FADJXH not in", values, "fadjxh");
            return (Criteria) this;
        }

        public Criteria andFadjxhBetween(String value1, String value2) {
            addCriterion("FADJXH between", value1, value2, "fadjxh");
            return (Criteria) this;
        }

        public Criteria andFadjxhNotBetween(String value1, String value2) {
            addCriterion("FADJXH not between", value1, value2, "fadjxh");
            return (Criteria) this;
        }

        public Criteria andFadjhmIsNull() {
            addCriterion("FADJHM is null");
            return (Criteria) this;
        }

        public Criteria andFadjhmIsNotNull() {
            addCriterion("FADJHM is not null");
            return (Criteria) this;
        }

        public Criteria andFadjhmEqualTo(String value) {
            addCriterion("FADJHM =", value, "fadjhm");
            return (Criteria) this;
        }

        public Criteria andFadjhmNotEqualTo(String value) {
            addCriterion("FADJHM <>", value, "fadjhm");
            return (Criteria) this;
        }

        public Criteria andFadjhmGreaterThan(String value) {
            addCriterion("FADJHM >", value, "fadjhm");
            return (Criteria) this;
        }

        public Criteria andFadjhmGreaterThanOrEqualTo(String value) {
            addCriterion("FADJHM >=", value, "fadjhm");
            return (Criteria) this;
        }

        public Criteria andFadjhmLessThan(String value) {
            addCriterion("FADJHM <", value, "fadjhm");
            return (Criteria) this;
        }

        public Criteria andFadjhmLessThanOrEqualTo(String value) {
            addCriterion("FADJHM <=", value, "fadjhm");
            return (Criteria) this;
        }

        public Criteria andFadjhmLike(String value) {
            addCriterion("FADJHM like", value, "fadjhm");
            return (Criteria) this;
        }

        public Criteria andFadjhmNotLike(String value) {
            addCriterion("FADJHM not like", value, "fadjhm");
            return (Criteria) this;
        }

        public Criteria andFadjhmIn(List<String> values) {
            addCriterion("FADJHM in", values, "fadjhm");
            return (Criteria) this;
        }

        public Criteria andFadjhmNotIn(List<String> values) {
            addCriterion("FADJHM not in", values, "fadjhm");
            return (Criteria) this;
        }

        public Criteria andFadjhmBetween(String value1, String value2) {
            addCriterion("FADJHM between", value1, value2, "fadjhm");
            return (Criteria) this;
        }

        public Criteria andFadjhmNotBetween(String value1, String value2) {
            addCriterion("FADJHM not between", value1, value2, "fadjhm");
            return (Criteria) this;
        }

        public Criteria andFadjglIsNull() {
            addCriterion("FADJGL is null");
            return (Criteria) this;
        }

        public Criteria andFadjglIsNotNull() {
            addCriterion("FADJGL is not null");
            return (Criteria) this;
        }

        public Criteria andFadjglEqualTo(BigDecimal value) {
            addCriterion("FADJGL =", value, "fadjgl");
            return (Criteria) this;
        }

        public Criteria andFadjglNotEqualTo(BigDecimal value) {
            addCriterion("FADJGL <>", value, "fadjgl");
            return (Criteria) this;
        }

        public Criteria andFadjglGreaterThan(BigDecimal value) {
            addCriterion("FADJGL >", value, "fadjgl");
            return (Criteria) this;
        }

        public Criteria andFadjglGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FADJGL >=", value, "fadjgl");
            return (Criteria) this;
        }

        public Criteria andFadjglLessThan(BigDecimal value) {
            addCriterion("FADJGL <", value, "fadjgl");
            return (Criteria) this;
        }

        public Criteria andFadjglLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FADJGL <=", value, "fadjgl");
            return (Criteria) this;
        }

        public Criteria andFadjglIn(List<BigDecimal> values) {
            addCriterion("FADJGL in", values, "fadjgl");
            return (Criteria) this;
        }

        public Criteria andFadjglNotIn(List<BigDecimal> values) {
            addCriterion("FADJGL not in", values, "fadjgl");
            return (Criteria) this;
        }

        public Criteria andFadjglBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FADJGL between", value1, value2, "fadjgl");
            return (Criteria) this;
        }

        public Criteria andFadjglNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FADJGL not between", value1, value2, "fadjgl");
            return (Criteria) this;
        }

        public Criteria andChelsbvinIsNull() {
            addCriterion("CHELSBVIN is null");
            return (Criteria) this;
        }

        public Criteria andChelsbvinIsNotNull() {
            addCriterion("CHELSBVIN is not null");
            return (Criteria) this;
        }

        public Criteria andChelsbvinEqualTo(String value) {
            addCriterion("CHELSBVIN =", value, "chelsbvin");
            return (Criteria) this;
        }

        public Criteria andChelsbvinNotEqualTo(String value) {
            addCriterion("CHELSBVIN <>", value, "chelsbvin");
            return (Criteria) this;
        }

        public Criteria andChelsbvinGreaterThan(String value) {
            addCriterion("CHELSBVIN >", value, "chelsbvin");
            return (Criteria) this;
        }

        public Criteria andChelsbvinGreaterThanOrEqualTo(String value) {
            addCriterion("CHELSBVIN >=", value, "chelsbvin");
            return (Criteria) this;
        }

        public Criteria andChelsbvinLessThan(String value) {
            addCriterion("CHELSBVIN <", value, "chelsbvin");
            return (Criteria) this;
        }

        public Criteria andChelsbvinLessThanOrEqualTo(String value) {
            addCriterion("CHELSBVIN <=", value, "chelsbvin");
            return (Criteria) this;
        }

        public Criteria andChelsbvinLike(String value) {
            addCriterion("CHELSBVIN like", value, "chelsbvin");
            return (Criteria) this;
        }

        public Criteria andChelsbvinNotLike(String value) {
            addCriterion("CHELSBVIN not like", value, "chelsbvin");
            return (Criteria) this;
        }

        public Criteria andChelsbvinIn(List<String> values) {
            addCriterion("CHELSBVIN in", values, "chelsbvin");
            return (Criteria) this;
        }

        public Criteria andChelsbvinNotIn(List<String> values) {
            addCriterion("CHELSBVIN not in", values, "chelsbvin");
            return (Criteria) this;
        }

        public Criteria andChelsbvinBetween(String value1, String value2) {
            addCriterion("CHELSBVIN between", value1, value2, "chelsbvin");
            return (Criteria) this;
        }

        public Criteria andChelsbvinNotBetween(String value1, String value2) {
            addCriterion("CHELSBVIN not between", value1, value2, "chelsbvin");
            return (Criteria) this;
        }

        public Criteria andXingszclrqIsNull() {
            addCriterion("XINGSZCLRQ is null");
            return (Criteria) this;
        }

        public Criteria andXingszclrqIsNotNull() {
            addCriterion("XINGSZCLRQ is not null");
            return (Criteria) this;
        }

        public Criteria andXingszclrqEqualTo(String value) {
            addCriterion("XINGSZCLRQ =", value, "xingszclrq");
            return (Criteria) this;
        }

        public Criteria andXingszclrqNotEqualTo(String value) {
            addCriterion("XINGSZCLRQ <>", value, "xingszclrq");
            return (Criteria) this;
        }

        public Criteria andXingszclrqGreaterThan(String value) {
            addCriterion("XINGSZCLRQ >", value, "xingszclrq");
            return (Criteria) this;
        }

        public Criteria andXingszclrqGreaterThanOrEqualTo(String value) {
            addCriterion("XINGSZCLRQ >=", value, "xingszclrq");
            return (Criteria) this;
        }

        public Criteria andXingszclrqLessThan(String value) {
            addCriterion("XINGSZCLRQ <", value, "xingszclrq");
            return (Criteria) this;
        }

        public Criteria andXingszclrqLessThanOrEqualTo(String value) {
            addCriterion("XINGSZCLRQ <=", value, "xingszclrq");
            return (Criteria) this;
        }

        public Criteria andXingszclrqLike(String value) {
            addCriterion("XINGSZCLRQ like", value, "xingszclrq");
            return (Criteria) this;
        }

        public Criteria andXingszclrqNotLike(String value) {
            addCriterion("XINGSZCLRQ not like", value, "xingszclrq");
            return (Criteria) this;
        }

        public Criteria andXingszclrqIn(List<String> values) {
            addCriterion("XINGSZCLRQ in", values, "xingszclrq");
            return (Criteria) this;
        }

        public Criteria andXingszclrqNotIn(List<String> values) {
            addCriterion("XINGSZCLRQ not in", values, "xingszclrq");
            return (Criteria) this;
        }

        public Criteria andXingszclrqBetween(String value1, String value2) {
            addCriterion("XINGSZCLRQ between", value1, value2, "xingszclrq");
            return (Criteria) this;
        }

        public Criteria andXingszclrqNotBetween(String value1, String value2) {
            addCriterion("XINGSZCLRQ not between", value1, value2, "xingszclrq");
            return (Criteria) this;
        }

        public Criteria andCheldjhIsNull() {
            addCriterion("CHELDJH is null");
            return (Criteria) this;
        }

        public Criteria andCheldjhIsNotNull() {
            addCriterion("CHELDJH is not null");
            return (Criteria) this;
        }

        public Criteria andCheldjhEqualTo(String value) {
            addCriterion("CHELDJH =", value, "cheldjh");
            return (Criteria) this;
        }

        public Criteria andCheldjhNotEqualTo(String value) {
            addCriterion("CHELDJH <>", value, "cheldjh");
            return (Criteria) this;
        }

        public Criteria andCheldjhGreaterThan(String value) {
            addCriterion("CHELDJH >", value, "cheldjh");
            return (Criteria) this;
        }

        public Criteria andCheldjhGreaterThanOrEqualTo(String value) {
            addCriterion("CHELDJH >=", value, "cheldjh");
            return (Criteria) this;
        }

        public Criteria andCheldjhLessThan(String value) {
            addCriterion("CHELDJH <", value, "cheldjh");
            return (Criteria) this;
        }

        public Criteria andCheldjhLessThanOrEqualTo(String value) {
            addCriterion("CHELDJH <=", value, "cheldjh");
            return (Criteria) this;
        }

        public Criteria andCheldjhLike(String value) {
            addCriterion("CHELDJH like", value, "cheldjh");
            return (Criteria) this;
        }

        public Criteria andCheldjhNotLike(String value) {
            addCriterion("CHELDJH not like", value, "cheldjh");
            return (Criteria) this;
        }

        public Criteria andCheldjhIn(List<String> values) {
            addCriterion("CHELDJH in", values, "cheldjh");
            return (Criteria) this;
        }

        public Criteria andCheldjhNotIn(List<String> values) {
            addCriterion("CHELDJH not in", values, "cheldjh");
            return (Criteria) this;
        }

        public Criteria andCheldjhBetween(String value1, String value2) {
            addCriterion("CHELDJH between", value1, value2, "cheldjh");
            return (Criteria) this;
        }

        public Criteria andCheldjhNotBetween(String value1, String value2) {
            addCriterion("CHELDJH not between", value1, value2, "cheldjh");
            return (Criteria) this;
        }

        public Criteria andDengjzdjrqIsNull() {
            addCriterion("DENGJZDJRQ is null");
            return (Criteria) this;
        }

        public Criteria andDengjzdjrqIsNotNull() {
            addCriterion("DENGJZDJRQ is not null");
            return (Criteria) this;
        }

        public Criteria andDengjzdjrqEqualTo(String value) {
            addCriterion("DENGJZDJRQ =", value, "dengjzdjrq");
            return (Criteria) this;
        }

        public Criteria andDengjzdjrqNotEqualTo(String value) {
            addCriterion("DENGJZDJRQ <>", value, "dengjzdjrq");
            return (Criteria) this;
        }

        public Criteria andDengjzdjrqGreaterThan(String value) {
            addCriterion("DENGJZDJRQ >", value, "dengjzdjrq");
            return (Criteria) this;
        }

        public Criteria andDengjzdjrqGreaterThanOrEqualTo(String value) {
            addCriterion("DENGJZDJRQ >=", value, "dengjzdjrq");
            return (Criteria) this;
        }

        public Criteria andDengjzdjrqLessThan(String value) {
            addCriterion("DENGJZDJRQ <", value, "dengjzdjrq");
            return (Criteria) this;
        }

        public Criteria andDengjzdjrqLessThanOrEqualTo(String value) {
            addCriterion("DENGJZDJRQ <=", value, "dengjzdjrq");
            return (Criteria) this;
        }

        public Criteria andDengjzdjrqLike(String value) {
            addCriterion("DENGJZDJRQ like", value, "dengjzdjrq");
            return (Criteria) this;
        }

        public Criteria andDengjzdjrqNotLike(String value) {
            addCriterion("DENGJZDJRQ not like", value, "dengjzdjrq");
            return (Criteria) this;
        }

        public Criteria andDengjzdjrqIn(List<String> values) {
            addCriterion("DENGJZDJRQ in", values, "dengjzdjrq");
            return (Criteria) this;
        }

        public Criteria andDengjzdjrqNotIn(List<String> values) {
            addCriterion("DENGJZDJRQ not in", values, "dengjzdjrq");
            return (Criteria) this;
        }

        public Criteria andDengjzdjrqBetween(String value1, String value2) {
            addCriterion("DENGJZDJRQ between", value1, value2, "dengjzdjrq");
            return (Criteria) this;
        }

        public Criteria andDengjzdjrqNotBetween(String value1, String value2) {
            addCriterion("DENGJZDJRQ not between", value1, value2, "dengjzdjrq");
            return (Criteria) this;
        }

        public Criteria andDengjzffrqIsNull() {
            addCriterion("DENGJZFFRQ is null");
            return (Criteria) this;
        }

        public Criteria andDengjzffrqIsNotNull() {
            addCriterion("DENGJZFFRQ is not null");
            return (Criteria) this;
        }

        public Criteria andDengjzffrqEqualTo(String value) {
            addCriterion("DENGJZFFRQ =", value, "dengjzffrq");
            return (Criteria) this;
        }

        public Criteria andDengjzffrqNotEqualTo(String value) {
            addCriterion("DENGJZFFRQ <>", value, "dengjzffrq");
            return (Criteria) this;
        }

        public Criteria andDengjzffrqGreaterThan(String value) {
            addCriterion("DENGJZFFRQ >", value, "dengjzffrq");
            return (Criteria) this;
        }

        public Criteria andDengjzffrqGreaterThanOrEqualTo(String value) {
            addCriterion("DENGJZFFRQ >=", value, "dengjzffrq");
            return (Criteria) this;
        }

        public Criteria andDengjzffrqLessThan(String value) {
            addCriterion("DENGJZFFRQ <", value, "dengjzffrq");
            return (Criteria) this;
        }

        public Criteria andDengjzffrqLessThanOrEqualTo(String value) {
            addCriterion("DENGJZFFRQ <=", value, "dengjzffrq");
            return (Criteria) this;
        }

        public Criteria andDengjzffrqLike(String value) {
            addCriterion("DENGJZFFRQ like", value, "dengjzffrq");
            return (Criteria) this;
        }

        public Criteria andDengjzffrqNotLike(String value) {
            addCriterion("DENGJZFFRQ not like", value, "dengjzffrq");
            return (Criteria) this;
        }

        public Criteria andDengjzffrqIn(List<String> values) {
            addCriterion("DENGJZFFRQ in", values, "dengjzffrq");
            return (Criteria) this;
        }

        public Criteria andDengjzffrqNotIn(List<String> values) {
            addCriterion("DENGJZFFRQ not in", values, "dengjzffrq");
            return (Criteria) this;
        }

        public Criteria andDengjzffrqBetween(String value1, String value2) {
            addCriterion("DENGJZFFRQ between", value1, value2, "dengjzffrq");
            return (Criteria) this;
        }

        public Criteria andDengjzffrqNotBetween(String value1, String value2) {
            addCriterion("DENGJZFFRQ not between", value1, value2, "dengjzffrq");
            return (Criteria) this;
        }

        public Criteria andHedzwsIsNull() {
            addCriterion("HEDZWS is null");
            return (Criteria) this;
        }

        public Criteria andHedzwsIsNotNull() {
            addCriterion("HEDZWS is not null");
            return (Criteria) this;
        }

        public Criteria andHedzwsEqualTo(Integer value) {
            addCriterion("HEDZWS =", value, "hedzws");
            return (Criteria) this;
        }

        public Criteria andHedzwsNotEqualTo(Integer value) {
            addCriterion("HEDZWS <>", value, "hedzws");
            return (Criteria) this;
        }

        public Criteria andHedzwsGreaterThan(Integer value) {
            addCriterion("HEDZWS >", value, "hedzws");
            return (Criteria) this;
        }

        public Criteria andHedzwsGreaterThanOrEqualTo(Integer value) {
            addCriterion("HEDZWS >=", value, "hedzws");
            return (Criteria) this;
        }

        public Criteria andHedzwsLessThan(Integer value) {
            addCriterion("HEDZWS <", value, "hedzws");
            return (Criteria) this;
        }

        public Criteria andHedzwsLessThanOrEqualTo(Integer value) {
            addCriterion("HEDZWS <=", value, "hedzws");
            return (Criteria) this;
        }

        public Criteria andHedzwsIn(List<Integer> values) {
            addCriterion("HEDZWS in", values, "hedzws");
            return (Criteria) this;
        }

        public Criteria andHedzwsNotIn(List<Integer> values) {
            addCriterion("HEDZWS not in", values, "hedzws");
            return (Criteria) this;
        }

        public Criteria andHedzwsBetween(Integer value1, Integer value2) {
            addCriterion("HEDZWS between", value1, value2, "hedzws");
            return (Criteria) this;
        }

        public Criteria andHedzwsNotBetween(Integer value1, Integer value2) {
            addCriterion("HEDZWS not between", value1, value2, "hedzws");
            return (Criteria) this;
        }

        public Criteria andRanllxdmIsNull() {
            addCriterion("RANLLXDM is null");
            return (Criteria) this;
        }

        public Criteria andRanllxdmIsNotNull() {
            addCriterion("RANLLXDM is not null");
            return (Criteria) this;
        }

        public Criteria andRanllxdmEqualTo(String value) {
            addCriterion("RANLLXDM =", value, "ranllxdm");
            return (Criteria) this;
        }

        public Criteria andRanllxdmNotEqualTo(String value) {
            addCriterion("RANLLXDM <>", value, "ranllxdm");
            return (Criteria) this;
        }

        public Criteria andRanllxdmGreaterThan(String value) {
            addCriterion("RANLLXDM >", value, "ranllxdm");
            return (Criteria) this;
        }

        public Criteria andRanllxdmGreaterThanOrEqualTo(String value) {
            addCriterion("RANLLXDM >=", value, "ranllxdm");
            return (Criteria) this;
        }

        public Criteria andRanllxdmLessThan(String value) {
            addCriterion("RANLLXDM <", value, "ranllxdm");
            return (Criteria) this;
        }

        public Criteria andRanllxdmLessThanOrEqualTo(String value) {
            addCriterion("RANLLXDM <=", value, "ranllxdm");
            return (Criteria) this;
        }

        public Criteria andRanllxdmLike(String value) {
            addCriterion("RANLLXDM like", value, "ranllxdm");
            return (Criteria) this;
        }

        public Criteria andRanllxdmNotLike(String value) {
            addCriterion("RANLLXDM not like", value, "ranllxdm");
            return (Criteria) this;
        }

        public Criteria andRanllxdmIn(List<String> values) {
            addCriterion("RANLLXDM in", values, "ranllxdm");
            return (Criteria) this;
        }

        public Criteria andRanllxdmNotIn(List<String> values) {
            addCriterion("RANLLXDM not in", values, "ranllxdm");
            return (Criteria) this;
        }

        public Criteria andRanllxdmBetween(String value1, String value2) {
            addCriterion("RANLLXDM between", value1, value2, "ranllxdm");
            return (Criteria) this;
        }

        public Criteria andRanllxdmNotBetween(String value1, String value2) {
            addCriterion("RANLLXDM not between", value1, value2, "ranllxdm");
            return (Criteria) this;
        }

        public Criteria andCheljsdjIsNull() {
            addCriterion("CHELJSDJ is null");
            return (Criteria) this;
        }

        public Criteria andCheljsdjIsNotNull() {
            addCriterion("CHELJSDJ is not null");
            return (Criteria) this;
        }

        public Criteria andCheljsdjEqualTo(String value) {
            addCriterion("CHELJSDJ =", value, "cheljsdj");
            return (Criteria) this;
        }

        public Criteria andCheljsdjNotEqualTo(String value) {
            addCriterion("CHELJSDJ <>", value, "cheljsdj");
            return (Criteria) this;
        }

        public Criteria andCheljsdjGreaterThan(String value) {
            addCriterion("CHELJSDJ >", value, "cheljsdj");
            return (Criteria) this;
        }

        public Criteria andCheljsdjGreaterThanOrEqualTo(String value) {
            addCriterion("CHELJSDJ >=", value, "cheljsdj");
            return (Criteria) this;
        }

        public Criteria andCheljsdjLessThan(String value) {
            addCriterion("CHELJSDJ <", value, "cheljsdj");
            return (Criteria) this;
        }

        public Criteria andCheljsdjLessThanOrEqualTo(String value) {
            addCriterion("CHELJSDJ <=", value, "cheljsdj");
            return (Criteria) this;
        }

        public Criteria andCheljsdjLike(String value) {
            addCriterion("CHELJSDJ like", value, "cheljsdj");
            return (Criteria) this;
        }

        public Criteria andCheljsdjNotLike(String value) {
            addCriterion("CHELJSDJ not like", value, "cheljsdj");
            return (Criteria) this;
        }

        public Criteria andCheljsdjIn(List<String> values) {
            addCriterion("CHELJSDJ in", values, "cheljsdj");
            return (Criteria) this;
        }

        public Criteria andCheljsdjNotIn(List<String> values) {
            addCriterion("CHELJSDJ not in", values, "cheljsdj");
            return (Criteria) this;
        }

        public Criteria andCheljsdjBetween(String value1, String value2) {
            addCriterion("CHELJSDJ between", value1, value2, "cheljsdj");
            return (Criteria) this;
        }

        public Criteria andCheljsdjNotBetween(String value1, String value2) {
            addCriterion("CHELJSDJ not between", value1, value2, "cheljsdj");
            return (Criteria) this;
        }

        public Criteria andChucrqIsNull() {
            addCriterion("CHUCRQ is null");
            return (Criteria) this;
        }

        public Criteria andChucrqIsNotNull() {
            addCriterion("CHUCRQ is not null");
            return (Criteria) this;
        }

        public Criteria andChucrqEqualTo(String value) {
            addCriterion("CHUCRQ =", value, "chucrq");
            return (Criteria) this;
        }

        public Criteria andChucrqNotEqualTo(String value) {
            addCriterion("CHUCRQ <>", value, "chucrq");
            return (Criteria) this;
        }

        public Criteria andChucrqGreaterThan(String value) {
            addCriterion("CHUCRQ >", value, "chucrq");
            return (Criteria) this;
        }

        public Criteria andChucrqGreaterThanOrEqualTo(String value) {
            addCriterion("CHUCRQ >=", value, "chucrq");
            return (Criteria) this;
        }

        public Criteria andChucrqLessThan(String value) {
            addCriterion("CHUCRQ <", value, "chucrq");
            return (Criteria) this;
        }

        public Criteria andChucrqLessThanOrEqualTo(String value) {
            addCriterion("CHUCRQ <=", value, "chucrq");
            return (Criteria) this;
        }

        public Criteria andChucrqLike(String value) {
            addCriterion("CHUCRQ like", value, "chucrq");
            return (Criteria) this;
        }

        public Criteria andChucrqNotLike(String value) {
            addCriterion("CHUCRQ not like", value, "chucrq");
            return (Criteria) this;
        }

        public Criteria andChucrqIn(List<String> values) {
            addCriterion("CHUCRQ in", values, "chucrq");
            return (Criteria) this;
        }

        public Criteria andChucrqNotIn(List<String> values) {
            addCriterion("CHUCRQ not in", values, "chucrq");
            return (Criteria) this;
        }

        public Criteria andChucrqBetween(String value1, String value2) {
            addCriterion("CHUCRQ between", value1, value2, "chucrq");
            return (Criteria) this;
        }

        public Criteria andChucrqNotBetween(String value1, String value2) {
            addCriterion("CHUCRQ not between", value1, value2, "chucrq");
            return (Criteria) this;
        }

        public Criteria andGoucrqIsNull() {
            addCriterion("GOUCRQ is null");
            return (Criteria) this;
        }

        public Criteria andGoucrqIsNotNull() {
            addCriterion("GOUCRQ is not null");
            return (Criteria) this;
        }

        public Criteria andGoucrqEqualTo(String value) {
            addCriterion("GOUCRQ =", value, "goucrq");
            return (Criteria) this;
        }

        public Criteria andGoucrqNotEqualTo(String value) {
            addCriterion("GOUCRQ <>", value, "goucrq");
            return (Criteria) this;
        }

        public Criteria andGoucrqGreaterThan(String value) {
            addCriterion("GOUCRQ >", value, "goucrq");
            return (Criteria) this;
        }

        public Criteria andGoucrqGreaterThanOrEqualTo(String value) {
            addCriterion("GOUCRQ >=", value, "goucrq");
            return (Criteria) this;
        }

        public Criteria andGoucrqLessThan(String value) {
            addCriterion("GOUCRQ <", value, "goucrq");
            return (Criteria) this;
        }

        public Criteria andGoucrqLessThanOrEqualTo(String value) {
            addCriterion("GOUCRQ <=", value, "goucrq");
            return (Criteria) this;
        }

        public Criteria andGoucrqLike(String value) {
            addCriterion("GOUCRQ like", value, "goucrq");
            return (Criteria) this;
        }

        public Criteria andGoucrqNotLike(String value) {
            addCriterion("GOUCRQ not like", value, "goucrq");
            return (Criteria) this;
        }

        public Criteria andGoucrqIn(List<String> values) {
            addCriterion("GOUCRQ in", values, "goucrq");
            return (Criteria) this;
        }

        public Criteria andGoucrqNotIn(List<String> values) {
            addCriterion("GOUCRQ not in", values, "goucrq");
            return (Criteria) this;
        }

        public Criteria andGoucrqBetween(String value1, String value2) {
            addCriterion("GOUCRQ between", value1, value2, "goucrq");
            return (Criteria) this;
        }

        public Criteria andGoucrqNotBetween(String value1, String value2) {
            addCriterion("GOUCRQ not between", value1, value2, "goucrq");
            return (Criteria) this;
        }

        public Criteria andLuohrqIsNull() {
            addCriterion("LUOHRQ is null");
            return (Criteria) this;
        }

        public Criteria andLuohrqIsNotNull() {
            addCriterion("LUOHRQ is not null");
            return (Criteria) this;
        }

        public Criteria andLuohrqEqualTo(String value) {
            addCriterion("LUOHRQ =", value, "luohrq");
            return (Criteria) this;
        }

        public Criteria andLuohrqNotEqualTo(String value) {
            addCriterion("LUOHRQ <>", value, "luohrq");
            return (Criteria) this;
        }

        public Criteria andLuohrqGreaterThan(String value) {
            addCriterion("LUOHRQ >", value, "luohrq");
            return (Criteria) this;
        }

        public Criteria andLuohrqGreaterThanOrEqualTo(String value) {
            addCriterion("LUOHRQ >=", value, "luohrq");
            return (Criteria) this;
        }

        public Criteria andLuohrqLessThan(String value) {
            addCriterion("LUOHRQ <", value, "luohrq");
            return (Criteria) this;
        }

        public Criteria andLuohrqLessThanOrEqualTo(String value) {
            addCriterion("LUOHRQ <=", value, "luohrq");
            return (Criteria) this;
        }

        public Criteria andLuohrqLike(String value) {
            addCriterion("LUOHRQ like", value, "luohrq");
            return (Criteria) this;
        }

        public Criteria andLuohrqNotLike(String value) {
            addCriterion("LUOHRQ not like", value, "luohrq");
            return (Criteria) this;
        }

        public Criteria andLuohrqIn(List<String> values) {
            addCriterion("LUOHRQ in", values, "luohrq");
            return (Criteria) this;
        }

        public Criteria andLuohrqNotIn(List<String> values) {
            addCriterion("LUOHRQ not in", values, "luohrq");
            return (Criteria) this;
        }

        public Criteria andLuohrqBetween(String value1, String value2) {
            addCriterion("LUOHRQ between", value1, value2, "luohrq");
            return (Criteria) this;
        }

        public Criteria andLuohrqNotBetween(String value1, String value2) {
            addCriterion("LUOHRQ not between", value1, value2, "luohrq");
            return (Criteria) this;
        }

        public Criteria andZhoujIsNull() {
            addCriterion("ZHOUJ is null");
            return (Criteria) this;
        }

        public Criteria andZhoujIsNotNull() {
            addCriterion("ZHOUJ is not null");
            return (Criteria) this;
        }

        public Criteria andZhoujEqualTo(Integer value) {
            addCriterion("ZHOUJ =", value, "zhouj");
            return (Criteria) this;
        }

        public Criteria andZhoujNotEqualTo(Integer value) {
            addCriterion("ZHOUJ <>", value, "zhouj");
            return (Criteria) this;
        }

        public Criteria andZhoujGreaterThan(Integer value) {
            addCriterion("ZHOUJ >", value, "zhouj");
            return (Criteria) this;
        }

        public Criteria andZhoujGreaterThanOrEqualTo(Integer value) {
            addCriterion("ZHOUJ >=", value, "zhouj");
            return (Criteria) this;
        }

        public Criteria andZhoujLessThan(Integer value) {
            addCriterion("ZHOUJ <", value, "zhouj");
            return (Criteria) this;
        }

        public Criteria andZhoujLessThanOrEqualTo(Integer value) {
            addCriterion("ZHOUJ <=", value, "zhouj");
            return (Criteria) this;
        }

        public Criteria andZhoujIn(List<Integer> values) {
            addCriterion("ZHOUJ in", values, "zhouj");
            return (Criteria) this;
        }

        public Criteria andZhoujNotIn(List<Integer> values) {
            addCriterion("ZHOUJ not in", values, "zhouj");
            return (Criteria) this;
        }

        public Criteria andZhoujBetween(Integer value1, Integer value2) {
            addCriterion("ZHOUJ between", value1, value2, "zhouj");
            return (Criteria) this;
        }

        public Criteria andZhoujNotBetween(Integer value1, Integer value2) {
            addCriterion("ZHOUJ not between", value1, value2, "zhouj");
            return (Criteria) this;
        }

        public Criteria andChecIsNull() {
            addCriterion("CHEC is null");
            return (Criteria) this;
        }

        public Criteria andChecIsNotNull() {
            addCriterion("CHEC is not null");
            return (Criteria) this;
        }

        public Criteria andChecEqualTo(Integer value) {
            addCriterion("CHEC =", value, "chec");
            return (Criteria) this;
        }

        public Criteria andChecNotEqualTo(Integer value) {
            addCriterion("CHEC <>", value, "chec");
            return (Criteria) this;
        }

        public Criteria andChecGreaterThan(Integer value) {
            addCriterion("CHEC >", value, "chec");
            return (Criteria) this;
        }

        public Criteria andChecGreaterThanOrEqualTo(Integer value) {
            addCriterion("CHEC >=", value, "chec");
            return (Criteria) this;
        }

        public Criteria andChecLessThan(Integer value) {
            addCriterion("CHEC <", value, "chec");
            return (Criteria) this;
        }

        public Criteria andChecLessThanOrEqualTo(Integer value) {
            addCriterion("CHEC <=", value, "chec");
            return (Criteria) this;
        }

        public Criteria andChecIn(List<Integer> values) {
            addCriterion("CHEC in", values, "chec");
            return (Criteria) this;
        }

        public Criteria andChecNotIn(List<Integer> values) {
            addCriterion("CHEC not in", values, "chec");
            return (Criteria) this;
        }

        public Criteria andChecBetween(Integer value1, Integer value2) {
            addCriterion("CHEC between", value1, value2, "chec");
            return (Criteria) this;
        }

        public Criteria andChecNotBetween(Integer value1, Integer value2) {
            addCriterion("CHEC not between", value1, value2, "chec");
            return (Criteria) this;
        }

        public Criteria andChegIsNull() {
            addCriterion("CHEG is null");
            return (Criteria) this;
        }

        public Criteria andChegIsNotNull() {
            addCriterion("CHEG is not null");
            return (Criteria) this;
        }

        public Criteria andChegEqualTo(Integer value) {
            addCriterion("CHEG =", value, "cheg");
            return (Criteria) this;
        }

        public Criteria andChegNotEqualTo(Integer value) {
            addCriterion("CHEG <>", value, "cheg");
            return (Criteria) this;
        }

        public Criteria andChegGreaterThan(Integer value) {
            addCriterion("CHEG >", value, "cheg");
            return (Criteria) this;
        }

        public Criteria andChegGreaterThanOrEqualTo(Integer value) {
            addCriterion("CHEG >=", value, "cheg");
            return (Criteria) this;
        }

        public Criteria andChegLessThan(Integer value) {
            addCriterion("CHEG <", value, "cheg");
            return (Criteria) this;
        }

        public Criteria andChegLessThanOrEqualTo(Integer value) {
            addCriterion("CHEG <=", value, "cheg");
            return (Criteria) this;
        }

        public Criteria andChegIn(List<Integer> values) {
            addCriterion("CHEG in", values, "cheg");
            return (Criteria) this;
        }

        public Criteria andChegNotIn(List<Integer> values) {
            addCriterion("CHEG not in", values, "cheg");
            return (Criteria) this;
        }

        public Criteria andChegBetween(Integer value1, Integer value2) {
            addCriterion("CHEG between", value1, value2, "cheg");
            return (Criteria) this;
        }

        public Criteria andChegNotBetween(Integer value1, Integer value2) {
            addCriterion("CHEG not between", value1, value2, "cheg");
            return (Criteria) this;
        }

        public Criteria andChekIsNull() {
            addCriterion("CHEK is null");
            return (Criteria) this;
        }

        public Criteria andChekIsNotNull() {
            addCriterion("CHEK is not null");
            return (Criteria) this;
        }

        public Criteria andChekEqualTo(Integer value) {
            addCriterion("CHEK =", value, "chek");
            return (Criteria) this;
        }

        public Criteria andChekNotEqualTo(Integer value) {
            addCriterion("CHEK <>", value, "chek");
            return (Criteria) this;
        }

        public Criteria andChekGreaterThan(Integer value) {
            addCriterion("CHEK >", value, "chek");
            return (Criteria) this;
        }

        public Criteria andChekGreaterThanOrEqualTo(Integer value) {
            addCriterion("CHEK >=", value, "chek");
            return (Criteria) this;
        }

        public Criteria andChekLessThan(Integer value) {
            addCriterion("CHEK <", value, "chek");
            return (Criteria) this;
        }

        public Criteria andChekLessThanOrEqualTo(Integer value) {
            addCriterion("CHEK <=", value, "chek");
            return (Criteria) this;
        }

        public Criteria andChekIn(List<Integer> values) {
            addCriterion("CHEK in", values, "chek");
            return (Criteria) this;
        }

        public Criteria andChekNotIn(List<Integer> values) {
            addCriterion("CHEK not in", values, "chek");
            return (Criteria) this;
        }

        public Criteria andChekBetween(Integer value1, Integer value2) {
            addCriterion("CHEK between", value1, value2, "chek");
            return (Criteria) this;
        }

        public Criteria andChekNotBetween(Integer value1, Integer value2) {
            addCriterion("CHEK not between", value1, value2, "chek");
            return (Criteria) this;
        }

        public Criteria andChezsIsNull() {
            addCriterion("CHEZS is null");
            return (Criteria) this;
        }

        public Criteria andChezsIsNotNull() {
            addCriterion("CHEZS is not null");
            return (Criteria) this;
        }

        public Criteria andChezsEqualTo(Short value) {
            addCriterion("CHEZS =", value, "chezs");
            return (Criteria) this;
        }

        public Criteria andChezsNotEqualTo(Short value) {
            addCriterion("CHEZS <>", value, "chezs");
            return (Criteria) this;
        }

        public Criteria andChezsGreaterThan(Short value) {
            addCriterion("CHEZS >", value, "chezs");
            return (Criteria) this;
        }

        public Criteria andChezsGreaterThanOrEqualTo(Short value) {
            addCriterion("CHEZS >=", value, "chezs");
            return (Criteria) this;
        }

        public Criteria andChezsLessThan(Short value) {
            addCriterion("CHEZS <", value, "chezs");
            return (Criteria) this;
        }

        public Criteria andChezsLessThanOrEqualTo(Short value) {
            addCriterion("CHEZS <=", value, "chezs");
            return (Criteria) this;
        }

        public Criteria andChezsIn(List<Short> values) {
            addCriterion("CHEZS in", values, "chezs");
            return (Criteria) this;
        }

        public Criteria andChezsNotIn(List<Short> values) {
            addCriterion("CHEZS not in", values, "chezs");
            return (Criteria) this;
        }

        public Criteria andChezsBetween(Short value1, Short value2) {
            addCriterion("CHEZS between", value1, value2, "chezs");
            return (Criteria) this;
        }

        public Criteria andChezsNotBetween(Short value1, Short value2) {
            addCriterion("CHEZS not between", value1, value2, "chezs");
            return (Criteria) this;
        }

        public Criteria andHouzgbthpsIsNull() {
            addCriterion("HOUZGBTHPS is null");
            return (Criteria) this;
        }

        public Criteria andHouzgbthpsIsNotNull() {
            addCriterion("HOUZGBTHPS is not null");
            return (Criteria) this;
        }

        public Criteria andHouzgbthpsEqualTo(Short value) {
            addCriterion("HOUZGBTHPS =", value, "houzgbthps");
            return (Criteria) this;
        }

        public Criteria andHouzgbthpsNotEqualTo(Short value) {
            addCriterion("HOUZGBTHPS <>", value, "houzgbthps");
            return (Criteria) this;
        }

        public Criteria andHouzgbthpsGreaterThan(Short value) {
            addCriterion("HOUZGBTHPS >", value, "houzgbthps");
            return (Criteria) this;
        }

        public Criteria andHouzgbthpsGreaterThanOrEqualTo(Short value) {
            addCriterion("HOUZGBTHPS >=", value, "houzgbthps");
            return (Criteria) this;
        }

        public Criteria andHouzgbthpsLessThan(Short value) {
            addCriterion("HOUZGBTHPS <", value, "houzgbthps");
            return (Criteria) this;
        }

        public Criteria andHouzgbthpsLessThanOrEqualTo(Short value) {
            addCriterion("HOUZGBTHPS <=", value, "houzgbthps");
            return (Criteria) this;
        }

        public Criteria andHouzgbthpsIn(List<Short> values) {
            addCriterion("HOUZGBTHPS in", values, "houzgbthps");
            return (Criteria) this;
        }

        public Criteria andHouzgbthpsNotIn(List<Short> values) {
            addCriterion("HOUZGBTHPS not in", values, "houzgbthps");
            return (Criteria) this;
        }

        public Criteria andHouzgbthpsBetween(Short value1, Short value2) {
            addCriterion("HOUZGBTHPS between", value1, value2, "houzgbthps");
            return (Criteria) this;
        }

        public Criteria andHouzgbthpsNotBetween(Short value1, Short value2) {
            addCriterion("HOUZGBTHPS not between", value1, value2, "houzgbthps");
            return (Criteria) this;
        }

        public Criteria andXuanjxsIsNull() {
            addCriterion("XUANJXS is null");
            return (Criteria) this;
        }

        public Criteria andXuanjxsIsNotNull() {
            addCriterion("XUANJXS is not null");
            return (Criteria) this;
        }

        public Criteria andXuanjxsEqualTo(String value) {
            addCriterion("XUANJXS =", value, "xuanjxs");
            return (Criteria) this;
        }

        public Criteria andXuanjxsNotEqualTo(String value) {
            addCriterion("XUANJXS <>", value, "xuanjxs");
            return (Criteria) this;
        }

        public Criteria andXuanjxsGreaterThan(String value) {
            addCriterion("XUANJXS >", value, "xuanjxs");
            return (Criteria) this;
        }

        public Criteria andXuanjxsGreaterThanOrEqualTo(String value) {
            addCriterion("XUANJXS >=", value, "xuanjxs");
            return (Criteria) this;
        }

        public Criteria andXuanjxsLessThan(String value) {
            addCriterion("XUANJXS <", value, "xuanjxs");
            return (Criteria) this;
        }

        public Criteria andXuanjxsLessThanOrEqualTo(String value) {
            addCriterion("XUANJXS <=", value, "xuanjxs");
            return (Criteria) this;
        }

        public Criteria andXuanjxsLike(String value) {
            addCriterion("XUANJXS like", value, "xuanjxs");
            return (Criteria) this;
        }

        public Criteria andXuanjxsNotLike(String value) {
            addCriterion("XUANJXS not like", value, "xuanjxs");
            return (Criteria) this;
        }

        public Criteria andXuanjxsIn(List<String> values) {
            addCriterion("XUANJXS in", values, "xuanjxs");
            return (Criteria) this;
        }

        public Criteria andXuanjxsNotIn(List<String> values) {
            addCriterion("XUANJXS not in", values, "xuanjxs");
            return (Criteria) this;
        }

        public Criteria andXuanjxsBetween(String value1, String value2) {
            addCriterion("XUANJXS between", value1, value2, "xuanjxs");
            return (Criteria) this;
        }

        public Criteria andXuanjxsNotBetween(String value1, String value2) {
            addCriterion("XUANJXS not between", value1, value2, "xuanjxs");
            return (Criteria) this;
        }

        public Criteria andDangahIsNull() {
            addCriterion("DANGAH is null");
            return (Criteria) this;
        }

        public Criteria andDangahIsNotNull() {
            addCriterion("DANGAH is not null");
            return (Criteria) this;
        }

        public Criteria andDangahEqualTo(String value) {
            addCriterion("DANGAH =", value, "dangah");
            return (Criteria) this;
        }

        public Criteria andDangahNotEqualTo(String value) {
            addCriterion("DANGAH <>", value, "dangah");
            return (Criteria) this;
        }

        public Criteria andDangahGreaterThan(String value) {
            addCriterion("DANGAH >", value, "dangah");
            return (Criteria) this;
        }

        public Criteria andDangahGreaterThanOrEqualTo(String value) {
            addCriterion("DANGAH >=", value, "dangah");
            return (Criteria) this;
        }

        public Criteria andDangahLessThan(String value) {
            addCriterion("DANGAH <", value, "dangah");
            return (Criteria) this;
        }

        public Criteria andDangahLessThanOrEqualTo(String value) {
            addCriterion("DANGAH <=", value, "dangah");
            return (Criteria) this;
        }

        public Criteria andDangahLike(String value) {
            addCriterion("DANGAH like", value, "dangah");
            return (Criteria) this;
        }

        public Criteria andDangahNotLike(String value) {
            addCriterion("DANGAH not like", value, "dangah");
            return (Criteria) this;
        }

        public Criteria andDangahIn(List<String> values) {
            addCriterion("DANGAH in", values, "dangah");
            return (Criteria) this;
        }

        public Criteria andDangahNotIn(List<String> values) {
            addCriterion("DANGAH not in", values, "dangah");
            return (Criteria) this;
        }

        public Criteria andDangahBetween(String value1, String value2) {
            addCriterion("DANGAH between", value1, value2, "dangah");
            return (Criteria) this;
        }

        public Criteria andDangahNotBetween(String value1, String value2) {
            addCriterion("DANGAH not between", value1, value2, "dangah");
            return (Criteria) this;
        }

        public Criteria andDaolyszzhIsNull() {
            addCriterion("DAOLYSZZH is null");
            return (Criteria) this;
        }

        public Criteria andDaolyszzhIsNotNull() {
            addCriterion("DAOLYSZZH is not null");
            return (Criteria) this;
        }

        public Criteria andDaolyszzhEqualTo(String value) {
            addCriterion("DAOLYSZZH =", value, "daolyszzh");
            return (Criteria) this;
        }

        public Criteria andDaolyszzhNotEqualTo(String value) {
            addCriterion("DAOLYSZZH <>", value, "daolyszzh");
            return (Criteria) this;
        }

        public Criteria andDaolyszzhGreaterThan(String value) {
            addCriterion("DAOLYSZZH >", value, "daolyszzh");
            return (Criteria) this;
        }

        public Criteria andDaolyszzhGreaterThanOrEqualTo(String value) {
            addCriterion("DAOLYSZZH >=", value, "daolyszzh");
            return (Criteria) this;
        }

        public Criteria andDaolyszzhLessThan(String value) {
            addCriterion("DAOLYSZZH <", value, "daolyszzh");
            return (Criteria) this;
        }

        public Criteria andDaolyszzhLessThanOrEqualTo(String value) {
            addCriterion("DAOLYSZZH <=", value, "daolyszzh");
            return (Criteria) this;
        }

        public Criteria andDaolyszzhLike(String value) {
            addCriterion("DAOLYSZZH like", value, "daolyszzh");
            return (Criteria) this;
        }

        public Criteria andDaolyszzhNotLike(String value) {
            addCriterion("DAOLYSZZH not like", value, "daolyszzh");
            return (Criteria) this;
        }

        public Criteria andDaolyszzhIn(List<String> values) {
            addCriterion("DAOLYSZZH in", values, "daolyszzh");
            return (Criteria) this;
        }

        public Criteria andDaolyszzhNotIn(List<String> values) {
            addCriterion("DAOLYSZZH not in", values, "daolyszzh");
            return (Criteria) this;
        }

        public Criteria andDaolyszzhBetween(String value1, String value2) {
            addCriterion("DAOLYSZZH between", value1, value2, "daolyszzh");
            return (Criteria) this;
        }

        public Criteria andDaolyszzhNotBetween(String value1, String value2) {
            addCriterion("DAOLYSZZH not between", value1, value2, "daolyszzh");
            return (Criteria) this;
        }

        public Criteria andZhengjjymIsNull() {
            addCriterion("ZHENGJJYM is null");
            return (Criteria) this;
        }

        public Criteria andZhengjjymIsNotNull() {
            addCriterion("ZHENGJJYM is not null");
            return (Criteria) this;
        }

        public Criteria andZhengjjymEqualTo(String value) {
            addCriterion("ZHENGJJYM =", value, "zhengjjym");
            return (Criteria) this;
        }

        public Criteria andZhengjjymNotEqualTo(String value) {
            addCriterion("ZHENGJJYM <>", value, "zhengjjym");
            return (Criteria) this;
        }

        public Criteria andZhengjjymGreaterThan(String value) {
            addCriterion("ZHENGJJYM >", value, "zhengjjym");
            return (Criteria) this;
        }

        public Criteria andZhengjjymGreaterThanOrEqualTo(String value) {
            addCriterion("ZHENGJJYM >=", value, "zhengjjym");
            return (Criteria) this;
        }

        public Criteria andZhengjjymLessThan(String value) {
            addCriterion("ZHENGJJYM <", value, "zhengjjym");
            return (Criteria) this;
        }

        public Criteria andZhengjjymLessThanOrEqualTo(String value) {
            addCriterion("ZHENGJJYM <=", value, "zhengjjym");
            return (Criteria) this;
        }

        public Criteria andZhengjjymLike(String value) {
            addCriterion("ZHENGJJYM like", value, "zhengjjym");
            return (Criteria) this;
        }

        public Criteria andZhengjjymNotLike(String value) {
            addCriterion("ZHENGJJYM not like", value, "zhengjjym");
            return (Criteria) this;
        }

        public Criteria andZhengjjymIn(List<String> values) {
            addCriterion("ZHENGJJYM in", values, "zhengjjym");
            return (Criteria) this;
        }

        public Criteria andZhengjjymNotIn(List<String> values) {
            addCriterion("ZHENGJJYM not in", values, "zhengjjym");
            return (Criteria) this;
        }

        public Criteria andZhengjjymBetween(String value1, String value2) {
            addCriterion("ZHENGJJYM between", value1, value2, "zhengjjym");
            return (Criteria) this;
        }

        public Criteria andZhengjjymNotBetween(String value1, String value2) {
            addCriterion("ZHENGJJYM not between", value1, value2, "zhengjjym");
            return (Criteria) this;
        }

        public Criteria andZhengjclrqIsNull() {
            addCriterion("ZHENGJCLRQ is null");
            return (Criteria) this;
        }

        public Criteria andZhengjclrqIsNotNull() {
            addCriterion("ZHENGJCLRQ is not null");
            return (Criteria) this;
        }

        public Criteria andZhengjclrqEqualTo(String value) {
            addCriterion("ZHENGJCLRQ =", value, "zhengjclrq");
            return (Criteria) this;
        }

        public Criteria andZhengjclrqNotEqualTo(String value) {
            addCriterion("ZHENGJCLRQ <>", value, "zhengjclrq");
            return (Criteria) this;
        }

        public Criteria andZhengjclrqGreaterThan(String value) {
            addCriterion("ZHENGJCLRQ >", value, "zhengjclrq");
            return (Criteria) this;
        }

        public Criteria andZhengjclrqGreaterThanOrEqualTo(String value) {
            addCriterion("ZHENGJCLRQ >=", value, "zhengjclrq");
            return (Criteria) this;
        }

        public Criteria andZhengjclrqLessThan(String value) {
            addCriterion("ZHENGJCLRQ <", value, "zhengjclrq");
            return (Criteria) this;
        }

        public Criteria andZhengjclrqLessThanOrEqualTo(String value) {
            addCriterion("ZHENGJCLRQ <=", value, "zhengjclrq");
            return (Criteria) this;
        }

        public Criteria andZhengjclrqLike(String value) {
            addCriterion("ZHENGJCLRQ like", value, "zhengjclrq");
            return (Criteria) this;
        }

        public Criteria andZhengjclrqNotLike(String value) {
            addCriterion("ZHENGJCLRQ not like", value, "zhengjclrq");
            return (Criteria) this;
        }

        public Criteria andZhengjclrqIn(List<String> values) {
            addCriterion("ZHENGJCLRQ in", values, "zhengjclrq");
            return (Criteria) this;
        }

        public Criteria andZhengjclrqNotIn(List<String> values) {
            addCriterion("ZHENGJCLRQ not in", values, "zhengjclrq");
            return (Criteria) this;
        }

        public Criteria andZhengjclrqBetween(String value1, String value2) {
            addCriterion("ZHENGJCLRQ between", value1, value2, "zhengjclrq");
            return (Criteria) this;
        }

        public Criteria andZhengjclrqNotBetween(String value1, String value2) {
            addCriterion("ZHENGJCLRQ not between", value1, value2, "zhengjclrq");
            return (Criteria) this;
        }

        public Criteria andZhengjyxqqIsNull() {
            addCriterion("ZHENGJYXQQ is null");
            return (Criteria) this;
        }

        public Criteria andZhengjyxqqIsNotNull() {
            addCriterion("ZHENGJYXQQ is not null");
            return (Criteria) this;
        }

        public Criteria andZhengjyxqqEqualTo(String value) {
            addCriterion("ZHENGJYXQQ =", value, "zhengjyxqq");
            return (Criteria) this;
        }

        public Criteria andZhengjyxqqNotEqualTo(String value) {
            addCriterion("ZHENGJYXQQ <>", value, "zhengjyxqq");
            return (Criteria) this;
        }

        public Criteria andZhengjyxqqGreaterThan(String value) {
            addCriterion("ZHENGJYXQQ >", value, "zhengjyxqq");
            return (Criteria) this;
        }

        public Criteria andZhengjyxqqGreaterThanOrEqualTo(String value) {
            addCriterion("ZHENGJYXQQ >=", value, "zhengjyxqq");
            return (Criteria) this;
        }

        public Criteria andZhengjyxqqLessThan(String value) {
            addCriterion("ZHENGJYXQQ <", value, "zhengjyxqq");
            return (Criteria) this;
        }

        public Criteria andZhengjyxqqLessThanOrEqualTo(String value) {
            addCriterion("ZHENGJYXQQ <=", value, "zhengjyxqq");
            return (Criteria) this;
        }

        public Criteria andZhengjyxqqLike(String value) {
            addCriterion("ZHENGJYXQQ like", value, "zhengjyxqq");
            return (Criteria) this;
        }

        public Criteria andZhengjyxqqNotLike(String value) {
            addCriterion("ZHENGJYXQQ not like", value, "zhengjyxqq");
            return (Criteria) this;
        }

        public Criteria andZhengjyxqqIn(List<String> values) {
            addCriterion("ZHENGJYXQQ in", values, "zhengjyxqq");
            return (Criteria) this;
        }

        public Criteria andZhengjyxqqNotIn(List<String> values) {
            addCriterion("ZHENGJYXQQ not in", values, "zhengjyxqq");
            return (Criteria) this;
        }

        public Criteria andZhengjyxqqBetween(String value1, String value2) {
            addCriterion("ZHENGJYXQQ between", value1, value2, "zhengjyxqq");
            return (Criteria) this;
        }

        public Criteria andZhengjyxqqNotBetween(String value1, String value2) {
            addCriterion("ZHENGJYXQQ not between", value1, value2, "zhengjyxqq");
            return (Criteria) this;
        }

        public Criteria andZhengjyxqzIsNull() {
            addCriterion("ZHENGJYXQZ is null");
            return (Criteria) this;
        }

        public Criteria andZhengjyxqzIsNotNull() {
            addCriterion("ZHENGJYXQZ is not null");
            return (Criteria) this;
        }

        public Criteria andZhengjyxqzEqualTo(String value) {
            addCriterion("ZHENGJYXQZ =", value, "zhengjyxqz");
            return (Criteria) this;
        }

        public Criteria andZhengjyxqzNotEqualTo(String value) {
            addCriterion("ZHENGJYXQZ <>", value, "zhengjyxqz");
            return (Criteria) this;
        }

        public Criteria andZhengjyxqzGreaterThan(String value) {
            addCriterion("ZHENGJYXQZ >", value, "zhengjyxqz");
            return (Criteria) this;
        }

        public Criteria andZhengjyxqzGreaterThanOrEqualTo(String value) {
            addCriterion("ZHENGJYXQZ >=", value, "zhengjyxqz");
            return (Criteria) this;
        }

        public Criteria andZhengjyxqzLessThan(String value) {
            addCriterion("ZHENGJYXQZ <", value, "zhengjyxqz");
            return (Criteria) this;
        }

        public Criteria andZhengjyxqzLessThanOrEqualTo(String value) {
            addCriterion("ZHENGJYXQZ <=", value, "zhengjyxqz");
            return (Criteria) this;
        }

        public Criteria andZhengjyxqzLike(String value) {
            addCriterion("ZHENGJYXQZ like", value, "zhengjyxqz");
            return (Criteria) this;
        }

        public Criteria andZhengjyxqzNotLike(String value) {
            addCriterion("ZHENGJYXQZ not like", value, "zhengjyxqz");
            return (Criteria) this;
        }

        public Criteria andZhengjyxqzIn(List<String> values) {
            addCriterion("ZHENGJYXQZ in", values, "zhengjyxqz");
            return (Criteria) this;
        }

        public Criteria andZhengjyxqzNotIn(List<String> values) {
            addCriterion("ZHENGJYXQZ not in", values, "zhengjyxqz");
            return (Criteria) this;
        }

        public Criteria andZhengjyxqzBetween(String value1, String value2) {
            addCriterion("ZHENGJYXQZ between", value1, value2, "zhengjyxqz");
            return (Criteria) this;
        }

        public Criteria andZhengjyxqzNotBetween(String value1, String value2) {
            addCriterion("ZHENGJYXQZ not between", value1, value2, "zhengjyxqz");
            return (Criteria) this;
        }

        public Criteria andZhengjffrqIsNull() {
            addCriterion("ZHENGJFFRQ is null");
            return (Criteria) this;
        }

        public Criteria andZhengjffrqIsNotNull() {
            addCriterion("ZHENGJFFRQ is not null");
            return (Criteria) this;
        }

        public Criteria andZhengjffrqEqualTo(String value) {
            addCriterion("ZHENGJFFRQ =", value, "zhengjffrq");
            return (Criteria) this;
        }

        public Criteria andZhengjffrqNotEqualTo(String value) {
            addCriterion("ZHENGJFFRQ <>", value, "zhengjffrq");
            return (Criteria) this;
        }

        public Criteria andZhengjffrqGreaterThan(String value) {
            addCriterion("ZHENGJFFRQ >", value, "zhengjffrq");
            return (Criteria) this;
        }

        public Criteria andZhengjffrqGreaterThanOrEqualTo(String value) {
            addCriterion("ZHENGJFFRQ >=", value, "zhengjffrq");
            return (Criteria) this;
        }

        public Criteria andZhengjffrqLessThan(String value) {
            addCriterion("ZHENGJFFRQ <", value, "zhengjffrq");
            return (Criteria) this;
        }

        public Criteria andZhengjffrqLessThanOrEqualTo(String value) {
            addCriterion("ZHENGJFFRQ <=", value, "zhengjffrq");
            return (Criteria) this;
        }

        public Criteria andZhengjffrqLike(String value) {
            addCriterion("ZHENGJFFRQ like", value, "zhengjffrq");
            return (Criteria) this;
        }

        public Criteria andZhengjffrqNotLike(String value) {
            addCriterion("ZHENGJFFRQ not like", value, "zhengjffrq");
            return (Criteria) this;
        }

        public Criteria andZhengjffrqIn(List<String> values) {
            addCriterion("ZHENGJFFRQ in", values, "zhengjffrq");
            return (Criteria) this;
        }

        public Criteria andZhengjffrqNotIn(List<String> values) {
            addCriterion("ZHENGJFFRQ not in", values, "zhengjffrq");
            return (Criteria) this;
        }

        public Criteria andZhengjffrqBetween(String value1, String value2) {
            addCriterion("ZHENGJFFRQ between", value1, value2, "zhengjffrq");
            return (Criteria) this;
        }

        public Criteria andZhengjffrqNotBetween(String value1, String value2) {
            addCriterion("ZHENGJFFRQ not between", value1, value2, "zhengjffrq");
            return (Criteria) this;
        }

        public Criteria andFazjgIsNull() {
            addCriterion("FAZJG is null");
            return (Criteria) this;
        }

        public Criteria andFazjgIsNotNull() {
            addCriterion("FAZJG is not null");
            return (Criteria) this;
        }

        public Criteria andFazjgEqualTo(String value) {
            addCriterion("FAZJG =", value, "fazjg");
            return (Criteria) this;
        }

        public Criteria andFazjgNotEqualTo(String value) {
            addCriterion("FAZJG <>", value, "fazjg");
            return (Criteria) this;
        }

        public Criteria andFazjgGreaterThan(String value) {
            addCriterion("FAZJG >", value, "fazjg");
            return (Criteria) this;
        }

        public Criteria andFazjgGreaterThanOrEqualTo(String value) {
            addCriterion("FAZJG >=", value, "fazjg");
            return (Criteria) this;
        }

        public Criteria andFazjgLessThan(String value) {
            addCriterion("FAZJG <", value, "fazjg");
            return (Criteria) this;
        }

        public Criteria andFazjgLessThanOrEqualTo(String value) {
            addCriterion("FAZJG <=", value, "fazjg");
            return (Criteria) this;
        }

        public Criteria andFazjgLike(String value) {
            addCriterion("FAZJG like", value, "fazjg");
            return (Criteria) this;
        }

        public Criteria andFazjgNotLike(String value) {
            addCriterion("FAZJG not like", value, "fazjg");
            return (Criteria) this;
        }

        public Criteria andFazjgIn(List<String> values) {
            addCriterion("FAZJG in", values, "fazjg");
            return (Criteria) this;
        }

        public Criteria andFazjgNotIn(List<String> values) {
            addCriterion("FAZJG not in", values, "fazjg");
            return (Criteria) this;
        }

        public Criteria andFazjgBetween(String value1, String value2) {
            addCriterion("FAZJG between", value1, value2, "fazjg");
            return (Criteria) this;
        }

        public Criteria andFazjgNotBetween(String value1, String value2) {
            addCriterion("FAZJG not between", value1, value2, "fazjg");
            return (Criteria) this;
        }

        public Criteria andChezzdcjIsNull() {
            addCriterion("CHEZZDCJ is null");
            return (Criteria) this;
        }

        public Criteria andChezzdcjIsNotNull() {
            addCriterion("CHEZZDCJ is not null");
            return (Criteria) this;
        }

        public Criteria andChezzdcjEqualTo(String value) {
            addCriterion("CHEZZDCJ =", value, "chezzdcj");
            return (Criteria) this;
        }

        public Criteria andChezzdcjNotEqualTo(String value) {
            addCriterion("CHEZZDCJ <>", value, "chezzdcj");
            return (Criteria) this;
        }

        public Criteria andChezzdcjGreaterThan(String value) {
            addCriterion("CHEZZDCJ >", value, "chezzdcj");
            return (Criteria) this;
        }

        public Criteria andChezzdcjGreaterThanOrEqualTo(String value) {
            addCriterion("CHEZZDCJ >=", value, "chezzdcj");
            return (Criteria) this;
        }

        public Criteria andChezzdcjLessThan(String value) {
            addCriterion("CHEZZDCJ <", value, "chezzdcj");
            return (Criteria) this;
        }

        public Criteria andChezzdcjLessThanOrEqualTo(String value) {
            addCriterion("CHEZZDCJ <=", value, "chezzdcj");
            return (Criteria) this;
        }

        public Criteria andChezzdcjLike(String value) {
            addCriterion("CHEZZDCJ like", value, "chezzdcj");
            return (Criteria) this;
        }

        public Criteria andChezzdcjNotLike(String value) {
            addCriterion("CHEZZDCJ not like", value, "chezzdcj");
            return (Criteria) this;
        }

        public Criteria andChezzdcjIn(List<String> values) {
            addCriterion("CHEZZDCJ in", values, "chezzdcj");
            return (Criteria) this;
        }

        public Criteria andChezzdcjNotIn(List<String> values) {
            addCriterion("CHEZZDCJ not in", values, "chezzdcj");
            return (Criteria) this;
        }

        public Criteria andChezzdcjBetween(String value1, String value2) {
            addCriterion("CHEZZDCJ between", value1, value2, "chezzdcj");
            return (Criteria) this;
        }

        public Criteria andChezzdcjNotBetween(String value1, String value2) {
            addCriterion("CHEZZDCJ not between", value1, value2, "chezzdcj");
            return (Criteria) this;
        }

        public Criteria andChezzdxhIsNull() {
            addCriterion("CHEZZDXH is null");
            return (Criteria) this;
        }

        public Criteria andChezzdxhIsNotNull() {
            addCriterion("CHEZZDXH is not null");
            return (Criteria) this;
        }

        public Criteria andChezzdxhEqualTo(String value) {
            addCriterion("CHEZZDXH =", value, "chezzdxh");
            return (Criteria) this;
        }

        public Criteria andChezzdxhNotEqualTo(String value) {
            addCriterion("CHEZZDXH <>", value, "chezzdxh");
            return (Criteria) this;
        }

        public Criteria andChezzdxhGreaterThan(String value) {
            addCriterion("CHEZZDXH >", value, "chezzdxh");
            return (Criteria) this;
        }

        public Criteria andChezzdxhGreaterThanOrEqualTo(String value) {
            addCriterion("CHEZZDXH >=", value, "chezzdxh");
            return (Criteria) this;
        }

        public Criteria andChezzdxhLessThan(String value) {
            addCriterion("CHEZZDXH <", value, "chezzdxh");
            return (Criteria) this;
        }

        public Criteria andChezzdxhLessThanOrEqualTo(String value) {
            addCriterion("CHEZZDXH <=", value, "chezzdxh");
            return (Criteria) this;
        }

        public Criteria andChezzdxhLike(String value) {
            addCriterion("CHEZZDXH like", value, "chezzdxh");
            return (Criteria) this;
        }

        public Criteria andChezzdxhNotLike(String value) {
            addCriterion("CHEZZDXH not like", value, "chezzdxh");
            return (Criteria) this;
        }

        public Criteria andChezzdxhIn(List<String> values) {
            addCriterion("CHEZZDXH in", values, "chezzdxh");
            return (Criteria) this;
        }

        public Criteria andChezzdxhNotIn(List<String> values) {
            addCriterion("CHEZZDXH not in", values, "chezzdxh");
            return (Criteria) this;
        }

        public Criteria andChezzdxhBetween(String value1, String value2) {
            addCriterion("CHEZZDXH between", value1, value2, "chezzdxh");
            return (Criteria) this;
        }

        public Criteria andChezzdxhNotBetween(String value1, String value2) {
            addCriterion("CHEZZDXH not between", value1, value2, "chezzdxh");
            return (Criteria) this;
        }

        public Criteria andChezzdbhIsNull() {
            addCriterion("CHEZZDBH is null");
            return (Criteria) this;
        }

        public Criteria andChezzdbhIsNotNull() {
            addCriterion("CHEZZDBH is not null");
            return (Criteria) this;
        }

        public Criteria andChezzdbhEqualTo(String value) {
            addCriterion("CHEZZDBH =", value, "chezzdbh");
            return (Criteria) this;
        }

        public Criteria andChezzdbhNotEqualTo(String value) {
            addCriterion("CHEZZDBH <>", value, "chezzdbh");
            return (Criteria) this;
        }

        public Criteria andChezzdbhGreaterThan(String value) {
            addCriterion("CHEZZDBH >", value, "chezzdbh");
            return (Criteria) this;
        }

        public Criteria andChezzdbhGreaterThanOrEqualTo(String value) {
            addCriterion("CHEZZDBH >=", value, "chezzdbh");
            return (Criteria) this;
        }

        public Criteria andChezzdbhLessThan(String value) {
            addCriterion("CHEZZDBH <", value, "chezzdbh");
            return (Criteria) this;
        }

        public Criteria andChezzdbhLessThanOrEqualTo(String value) {
            addCriterion("CHEZZDBH <=", value, "chezzdbh");
            return (Criteria) this;
        }

        public Criteria andChezzdbhLike(String value) {
            addCriterion("CHEZZDBH like", value, "chezzdbh");
            return (Criteria) this;
        }

        public Criteria andChezzdbhNotLike(String value) {
            addCriterion("CHEZZDBH not like", value, "chezzdbh");
            return (Criteria) this;
        }

        public Criteria andChezzdbhIn(List<String> values) {
            addCriterion("CHEZZDBH in", values, "chezzdbh");
            return (Criteria) this;
        }

        public Criteria andChezzdbhNotIn(List<String> values) {
            addCriterion("CHEZZDBH not in", values, "chezzdbh");
            return (Criteria) this;
        }

        public Criteria andChezzdbhBetween(String value1, String value2) {
            addCriterion("CHEZZDBH between", value1, value2, "chezzdbh");
            return (Criteria) this;
        }

        public Criteria andChezzdbhNotBetween(String value1, String value2) {
            addCriterion("CHEZZDBH not between", value1, value2, "chezzdbh");
            return (Criteria) this;
        }

        public Criteria andZhongdazrqIsNull() {
            addCriterion("ZHONGDAZRQ is null");
            return (Criteria) this;
        }

        public Criteria andZhongdazrqIsNotNull() {
            addCriterion("ZHONGDAZRQ is not null");
            return (Criteria) this;
        }

        public Criteria andZhongdazrqEqualTo(String value) {
            addCriterion("ZHONGDAZRQ =", value, "zhongdazrq");
            return (Criteria) this;
        }

        public Criteria andZhongdazrqNotEqualTo(String value) {
            addCriterion("ZHONGDAZRQ <>", value, "zhongdazrq");
            return (Criteria) this;
        }

        public Criteria andZhongdazrqGreaterThan(String value) {
            addCriterion("ZHONGDAZRQ >", value, "zhongdazrq");
            return (Criteria) this;
        }

        public Criteria andZhongdazrqGreaterThanOrEqualTo(String value) {
            addCriterion("ZHONGDAZRQ >=", value, "zhongdazrq");
            return (Criteria) this;
        }

        public Criteria andZhongdazrqLessThan(String value) {
            addCriterion("ZHONGDAZRQ <", value, "zhongdazrq");
            return (Criteria) this;
        }

        public Criteria andZhongdazrqLessThanOrEqualTo(String value) {
            addCriterion("ZHONGDAZRQ <=", value, "zhongdazrq");
            return (Criteria) this;
        }

        public Criteria andZhongdazrqLike(String value) {
            addCriterion("ZHONGDAZRQ like", value, "zhongdazrq");
            return (Criteria) this;
        }

        public Criteria andZhongdazrqNotLike(String value) {
            addCriterion("ZHONGDAZRQ not like", value, "zhongdazrq");
            return (Criteria) this;
        }

        public Criteria andZhongdazrqIn(List<String> values) {
            addCriterion("ZHONGDAZRQ in", values, "zhongdazrq");
            return (Criteria) this;
        }

        public Criteria andZhongdazrqNotIn(List<String> values) {
            addCriterion("ZHONGDAZRQ not in", values, "zhongdazrq");
            return (Criteria) this;
        }

        public Criteria andZhongdazrqBetween(String value1, String value2) {
            addCriterion("ZHONGDAZRQ between", value1, value2, "zhongdazrq");
            return (Criteria) this;
        }

        public Criteria andZhongdazrqNotBetween(String value1, String value2) {
            addCriterion("ZHONGDAZRQ not between", value1, value2, "zhongdazrq");
            return (Criteria) this;
        }

        public Criteria andXingsjlyxhIsNull() {
            addCriterion("XINGSJLYXH is null");
            return (Criteria) this;
        }

        public Criteria andXingsjlyxhIsNotNull() {
            addCriterion("XINGSJLYXH is not null");
            return (Criteria) this;
        }

        public Criteria andXingsjlyxhEqualTo(String value) {
            addCriterion("XINGSJLYXH =", value, "xingsjlyxh");
            return (Criteria) this;
        }

        public Criteria andXingsjlyxhNotEqualTo(String value) {
            addCriterion("XINGSJLYXH <>", value, "xingsjlyxh");
            return (Criteria) this;
        }

        public Criteria andXingsjlyxhGreaterThan(String value) {
            addCriterion("XINGSJLYXH >", value, "xingsjlyxh");
            return (Criteria) this;
        }

        public Criteria andXingsjlyxhGreaterThanOrEqualTo(String value) {
            addCriterion("XINGSJLYXH >=", value, "xingsjlyxh");
            return (Criteria) this;
        }

        public Criteria andXingsjlyxhLessThan(String value) {
            addCriterion("XINGSJLYXH <", value, "xingsjlyxh");
            return (Criteria) this;
        }

        public Criteria andXingsjlyxhLessThanOrEqualTo(String value) {
            addCriterion("XINGSJLYXH <=", value, "xingsjlyxh");
            return (Criteria) this;
        }

        public Criteria andXingsjlyxhLike(String value) {
            addCriterion("XINGSJLYXH like", value, "xingsjlyxh");
            return (Criteria) this;
        }

        public Criteria andXingsjlyxhNotLike(String value) {
            addCriterion("XINGSJLYXH not like", value, "xingsjlyxh");
            return (Criteria) this;
        }

        public Criteria andXingsjlyxhIn(List<String> values) {
            addCriterion("XINGSJLYXH in", values, "xingsjlyxh");
            return (Criteria) this;
        }

        public Criteria andXingsjlyxhNotIn(List<String> values) {
            addCriterion("XINGSJLYXH not in", values, "xingsjlyxh");
            return (Criteria) this;
        }

        public Criteria andXingsjlyxhBetween(String value1, String value2) {
            addCriterion("XINGSJLYXH between", value1, value2, "xingsjlyxh");
            return (Criteria) this;
        }

        public Criteria andXingsjlyxhNotBetween(String value1, String value2) {
            addCriterion("XINGSJLYXH not between", value1, value2, "xingsjlyxh");
            return (Criteria) this;
        }

        public Criteria andXingsjlybhIsNull() {
            addCriterion("XINGSJLYBH is null");
            return (Criteria) this;
        }

        public Criteria andXingsjlybhIsNotNull() {
            addCriterion("XINGSJLYBH is not null");
            return (Criteria) this;
        }

        public Criteria andXingsjlybhEqualTo(String value) {
            addCriterion("XINGSJLYBH =", value, "xingsjlybh");
            return (Criteria) this;
        }

        public Criteria andXingsjlybhNotEqualTo(String value) {
            addCriterion("XINGSJLYBH <>", value, "xingsjlybh");
            return (Criteria) this;
        }

        public Criteria andXingsjlybhGreaterThan(String value) {
            addCriterion("XINGSJLYBH >", value, "xingsjlybh");
            return (Criteria) this;
        }

        public Criteria andXingsjlybhGreaterThanOrEqualTo(String value) {
            addCriterion("XINGSJLYBH >=", value, "xingsjlybh");
            return (Criteria) this;
        }

        public Criteria andXingsjlybhLessThan(String value) {
            addCriterion("XINGSJLYBH <", value, "xingsjlybh");
            return (Criteria) this;
        }

        public Criteria andXingsjlybhLessThanOrEqualTo(String value) {
            addCriterion("XINGSJLYBH <=", value, "xingsjlybh");
            return (Criteria) this;
        }

        public Criteria andXingsjlybhLike(String value) {
            addCriterion("XINGSJLYBH like", value, "xingsjlybh");
            return (Criteria) this;
        }

        public Criteria andXingsjlybhNotLike(String value) {
            addCriterion("XINGSJLYBH not like", value, "xingsjlybh");
            return (Criteria) this;
        }

        public Criteria andXingsjlybhIn(List<String> values) {
            addCriterion("XINGSJLYBH in", values, "xingsjlybh");
            return (Criteria) this;
        }

        public Criteria andXingsjlybhNotIn(List<String> values) {
            addCriterion("XINGSJLYBH not in", values, "xingsjlybh");
            return (Criteria) this;
        }

        public Criteria andXingsjlybhBetween(String value1, String value2) {
            addCriterion("XINGSJLYBH between", value1, value2, "xingsjlybh");
            return (Criteria) this;
        }

        public Criteria andXingsjlybhNotBetween(String value1, String value2) {
            addCriterion("XINGSJLYBH not between", value1, value2, "xingsjlybh");
            return (Criteria) this;
        }

        public Criteria andYehidIsNull() {
            addCriterion("YEHID is null");
            return (Criteria) this;
        }

        public Criteria andYehidIsNotNull() {
            addCriterion("YEHID is not null");
            return (Criteria) this;
        }

        public Criteria andYehidEqualTo(String value) {
            addCriterion("YEHID =", value, "yehid");
            return (Criteria) this;
        }

        public Criteria andYehidNotEqualTo(String value) {
            addCriterion("YEHID <>", value, "yehid");
            return (Criteria) this;
        }

        public Criteria andYehidGreaterThan(String value) {
            addCriterion("YEHID >", value, "yehid");
            return (Criteria) this;
        }

        public Criteria andYehidGreaterThanOrEqualTo(String value) {
            addCriterion("YEHID >=", value, "yehid");
            return (Criteria) this;
        }

        public Criteria andYehidLessThan(String value) {
            addCriterion("YEHID <", value, "yehid");
            return (Criteria) this;
        }

        public Criteria andYehidLessThanOrEqualTo(String value) {
            addCriterion("YEHID <=", value, "yehid");
            return (Criteria) this;
        }

        public Criteria andYehidLike(String value) {
            addCriterion("YEHID like", value, "yehid");
            return (Criteria) this;
        }

        public Criteria andYehidNotLike(String value) {
            addCriterion("YEHID not like", value, "yehid");
            return (Criteria) this;
        }

        public Criteria andYehidIn(List<String> values) {
            addCriterion("YEHID in", values, "yehid");
            return (Criteria) this;
        }

        public Criteria andYehidNotIn(List<String> values) {
            addCriterion("YEHID not in", values, "yehid");
            return (Criteria) this;
        }

        public Criteria andYehidBetween(String value1, String value2) {
            addCriterion("YEHID between", value1, value2, "yehid");
            return (Criteria) this;
        }

        public Criteria andYehidNotBetween(String value1, String value2) {
            addCriterion("YEHID not between", value1, value2, "yehid");
            return (Criteria) this;
        }

        public Criteria andGuanxjgIsNull() {
            addCriterion("GUANXJG is null");
            return (Criteria) this;
        }

        public Criteria andGuanxjgIsNotNull() {
            addCriterion("GUANXJG is not null");
            return (Criteria) this;
        }

        public Criteria andGuanxjgEqualTo(String value) {
            addCriterion("GUANXJG =", value, "guanxjg");
            return (Criteria) this;
        }

        public Criteria andGuanxjgNotEqualTo(String value) {
            addCriterion("GUANXJG <>", value, "guanxjg");
            return (Criteria) this;
        }

        public Criteria andGuanxjgGreaterThan(String value) {
            addCriterion("GUANXJG >", value, "guanxjg");
            return (Criteria) this;
        }

        public Criteria andGuanxjgGreaterThanOrEqualTo(String value) {
            addCriterion("GUANXJG >=", value, "guanxjg");
            return (Criteria) this;
        }

        public Criteria andGuanxjgLessThan(String value) {
            addCriterion("GUANXJG <", value, "guanxjg");
            return (Criteria) this;
        }

        public Criteria andGuanxjgLessThanOrEqualTo(String value) {
            addCriterion("GUANXJG <=", value, "guanxjg");
            return (Criteria) this;
        }

        public Criteria andGuanxjgLike(String value) {
            addCriterion("GUANXJG like", value, "guanxjg");
            return (Criteria) this;
        }

        public Criteria andGuanxjgNotLike(String value) {
            addCriterion("GUANXJG not like", value, "guanxjg");
            return (Criteria) this;
        }

        public Criteria andGuanxjgIn(List<String> values) {
            addCriterion("GUANXJG in", values, "guanxjg");
            return (Criteria) this;
        }

        public Criteria andGuanxjgNotIn(List<String> values) {
            addCriterion("GUANXJG not in", values, "guanxjg");
            return (Criteria) this;
        }

        public Criteria andGuanxjgBetween(String value1, String value2) {
            addCriterion("GUANXJG between", value1, value2, "guanxjg");
            return (Criteria) this;
        }

        public Criteria andGuanxjgNotBetween(String value1, String value2) {
            addCriterion("GUANXJG not between", value1, value2, "guanxjg");
            return (Criteria) this;
        }

        public Criteria andJingxfwdmIsNull() {
            addCriterion("JINGXFWDM is null");
            return (Criteria) this;
        }

        public Criteria andJingxfwdmIsNotNull() {
            addCriterion("JINGXFWDM is not null");
            return (Criteria) this;
        }

        public Criteria andJingxfwdmEqualTo(String value) {
            addCriterion("JINGXFWDM =", value, "jingxfwdm");
            return (Criteria) this;
        }

        public Criteria andJingxfwdmNotEqualTo(String value) {
            addCriterion("JINGXFWDM <>", value, "jingxfwdm");
            return (Criteria) this;
        }

        public Criteria andJingxfwdmGreaterThan(String value) {
            addCriterion("JINGXFWDM >", value, "jingxfwdm");
            return (Criteria) this;
        }

        public Criteria andJingxfwdmGreaterThanOrEqualTo(String value) {
            addCriterion("JINGXFWDM >=", value, "jingxfwdm");
            return (Criteria) this;
        }

        public Criteria andJingxfwdmLessThan(String value) {
            addCriterion("JINGXFWDM <", value, "jingxfwdm");
            return (Criteria) this;
        }

        public Criteria andJingxfwdmLessThanOrEqualTo(String value) {
            addCriterion("JINGXFWDM <=", value, "jingxfwdm");
            return (Criteria) this;
        }

        public Criteria andJingxfwdmLike(String value) {
            addCriterion("JINGXFWDM like", value, "jingxfwdm");
            return (Criteria) this;
        }

        public Criteria andJingxfwdmNotLike(String value) {
            addCriterion("JINGXFWDM not like", value, "jingxfwdm");
            return (Criteria) this;
        }

        public Criteria andJingxfwdmIn(List<String> values) {
            addCriterion("JINGXFWDM in", values, "jingxfwdm");
            return (Criteria) this;
        }

        public Criteria andJingxfwdmNotIn(List<String> values) {
            addCriterion("JINGXFWDM not in", values, "jingxfwdm");
            return (Criteria) this;
        }

        public Criteria andJingxfwdmBetween(String value1, String value2) {
            addCriterion("JINGXFWDM between", value1, value2, "jingxfwdm");
            return (Criteria) this;
        }

        public Criteria andJingxfwdmNotBetween(String value1, String value2) {
            addCriterion("JINGXFWDM not between", value1, value2, "jingxfwdm");
            return (Criteria) this;
        }

        public Criteria andJingxfwmcIsNull() {
            addCriterion("JINGXFWMC is null");
            return (Criteria) this;
        }

        public Criteria andJingxfwmcIsNotNull() {
            addCriterion("JINGXFWMC is not null");
            return (Criteria) this;
        }

        public Criteria andJingxfwmcEqualTo(String value) {
            addCriterion("JINGXFWMC =", value, "jingxfwmc");
            return (Criteria) this;
        }

        public Criteria andJingxfwmcNotEqualTo(String value) {
            addCriterion("JINGXFWMC <>", value, "jingxfwmc");
            return (Criteria) this;
        }

        public Criteria andJingxfwmcGreaterThan(String value) {
            addCriterion("JINGXFWMC >", value, "jingxfwmc");
            return (Criteria) this;
        }

        public Criteria andJingxfwmcGreaterThanOrEqualTo(String value) {
            addCriterion("JINGXFWMC >=", value, "jingxfwmc");
            return (Criteria) this;
        }

        public Criteria andJingxfwmcLessThan(String value) {
            addCriterion("JINGXFWMC <", value, "jingxfwmc");
            return (Criteria) this;
        }

        public Criteria andJingxfwmcLessThanOrEqualTo(String value) {
            addCriterion("JINGXFWMC <=", value, "jingxfwmc");
            return (Criteria) this;
        }

        public Criteria andJingxfwmcLike(String value) {
            addCriterion("JINGXFWMC like", value, "jingxfwmc");
            return (Criteria) this;
        }

        public Criteria andJingxfwmcNotLike(String value) {
            addCriterion("JINGXFWMC not like", value, "jingxfwmc");
            return (Criteria) this;
        }

        public Criteria andJingxfwmcIn(List<String> values) {
            addCriterion("JINGXFWMC in", values, "jingxfwmc");
            return (Criteria) this;
        }

        public Criteria andJingxfwmcNotIn(List<String> values) {
            addCriterion("JINGXFWMC not in", values, "jingxfwmc");
            return (Criteria) this;
        }

        public Criteria andJingxfwmcBetween(String value1, String value2) {
            addCriterion("JINGXFWMC between", value1, value2, "jingxfwmc");
            return (Criteria) this;
        }

        public Criteria andJingxfwmcNotBetween(String value1, String value2) {
            addCriterion("JINGXFWMC not between", value1, value2, "jingxfwmc");
            return (Criteria) this;
        }

        public Criteria andXingzqhbmIsNull() {
            addCriterion("XINGZQHBM is null");
            return (Criteria) this;
        }

        public Criteria andXingzqhbmIsNotNull() {
            addCriterion("XINGZQHBM is not null");
            return (Criteria) this;
        }

        public Criteria andXingzqhbmEqualTo(String value) {
            addCriterion("XINGZQHBM =", value, "xingzqhbm");
            return (Criteria) this;
        }

        public Criteria andXingzqhbmNotEqualTo(String value) {
            addCriterion("XINGZQHBM <>", value, "xingzqhbm");
            return (Criteria) this;
        }

        public Criteria andXingzqhbmGreaterThan(String value) {
            addCriterion("XINGZQHBM >", value, "xingzqhbm");
            return (Criteria) this;
        }

        public Criteria andXingzqhbmGreaterThanOrEqualTo(String value) {
            addCriterion("XINGZQHBM >=", value, "xingzqhbm");
            return (Criteria) this;
        }

        public Criteria andXingzqhbmLessThan(String value) {
            addCriterion("XINGZQHBM <", value, "xingzqhbm");
            return (Criteria) this;
        }

        public Criteria andXingzqhbmLessThanOrEqualTo(String value) {
            addCriterion("XINGZQHBM <=", value, "xingzqhbm");
            return (Criteria) this;
        }

        public Criteria andXingzqhbmLike(String value) {
            addCriterion("XINGZQHBM like", value, "xingzqhbm");
            return (Criteria) this;
        }

        public Criteria andXingzqhbmNotLike(String value) {
            addCriterion("XINGZQHBM not like", value, "xingzqhbm");
            return (Criteria) this;
        }

        public Criteria andXingzqhbmIn(List<String> values) {
            addCriterion("XINGZQHBM in", values, "xingzqhbm");
            return (Criteria) this;
        }

        public Criteria andXingzqhbmNotIn(List<String> values) {
            addCriterion("XINGZQHBM not in", values, "xingzqhbm");
            return (Criteria) this;
        }

        public Criteria andXingzqhbmBetween(String value1, String value2) {
            addCriterion("XINGZQHBM between", value1, value2, "xingzqhbm");
            return (Criteria) this;
        }

        public Criteria andXingzqhbmNotBetween(String value1, String value2) {
            addCriterion("XINGZQHBM not between", value1, value2, "xingzqhbm");
            return (Criteria) this;
        }

        public Criteria andLisqxdmIsNull() {
            addCriterion("LISQXDM is null");
            return (Criteria) this;
        }

        public Criteria andLisqxdmIsNotNull() {
            addCriterion("LISQXDM is not null");
            return (Criteria) this;
        }

        public Criteria andLisqxdmEqualTo(String value) {
            addCriterion("LISQXDM =", value, "lisqxdm");
            return (Criteria) this;
        }

        public Criteria andLisqxdmNotEqualTo(String value) {
            addCriterion("LISQXDM <>", value, "lisqxdm");
            return (Criteria) this;
        }

        public Criteria andLisqxdmGreaterThan(String value) {
            addCriterion("LISQXDM >", value, "lisqxdm");
            return (Criteria) this;
        }

        public Criteria andLisqxdmGreaterThanOrEqualTo(String value) {
            addCriterion("LISQXDM >=", value, "lisqxdm");
            return (Criteria) this;
        }

        public Criteria andLisqxdmLessThan(String value) {
            addCriterion("LISQXDM <", value, "lisqxdm");
            return (Criteria) this;
        }

        public Criteria andLisqxdmLessThanOrEqualTo(String value) {
            addCriterion("LISQXDM <=", value, "lisqxdm");
            return (Criteria) this;
        }

        public Criteria andLisqxdmLike(String value) {
            addCriterion("LISQXDM like", value, "lisqxdm");
            return (Criteria) this;
        }

        public Criteria andLisqxdmNotLike(String value) {
            addCriterion("LISQXDM not like", value, "lisqxdm");
            return (Criteria) this;
        }

        public Criteria andLisqxdmIn(List<String> values) {
            addCriterion("LISQXDM in", values, "lisqxdm");
            return (Criteria) this;
        }

        public Criteria andLisqxdmNotIn(List<String> values) {
            addCriterion("LISQXDM not in", values, "lisqxdm");
            return (Criteria) this;
        }

        public Criteria andLisqxdmBetween(String value1, String value2) {
            addCriterion("LISQXDM between", value1, value2, "lisqxdm");
            return (Criteria) this;
        }

        public Criteria andLisqxdmNotBetween(String value1, String value2) {
            addCriterion("LISQXDM not between", value1, value2, "lisqxdm");
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

        public Criteria andZhengjztIsNull() {
            addCriterion("ZHENGJZT is null");
            return (Criteria) this;
        }

        public Criteria andZhengjztIsNotNull() {
            addCriterion("ZHENGJZT is not null");
            return (Criteria) this;
        }

        public Criteria andZhengjztEqualTo(String value) {
            addCriterion("ZHENGJZT =", value, "zhengjzt");
            return (Criteria) this;
        }

        public Criteria andZhengjztNotEqualTo(String value) {
            addCriterion("ZHENGJZT <>", value, "zhengjzt");
            return (Criteria) this;
        }

        public Criteria andZhengjztGreaterThan(String value) {
            addCriterion("ZHENGJZT >", value, "zhengjzt");
            return (Criteria) this;
        }

        public Criteria andZhengjztGreaterThanOrEqualTo(String value) {
            addCriterion("ZHENGJZT >=", value, "zhengjzt");
            return (Criteria) this;
        }

        public Criteria andZhengjztLessThan(String value) {
            addCriterion("ZHENGJZT <", value, "zhengjzt");
            return (Criteria) this;
        }

        public Criteria andZhengjztLessThanOrEqualTo(String value) {
            addCriterion("ZHENGJZT <=", value, "zhengjzt");
            return (Criteria) this;
        }

        public Criteria andZhengjztLike(String value) {
            addCriterion("ZHENGJZT like", value, "zhengjzt");
            return (Criteria) this;
        }

        public Criteria andZhengjztNotLike(String value) {
            addCriterion("ZHENGJZT not like", value, "zhengjzt");
            return (Criteria) this;
        }

        public Criteria andZhengjztIn(List<String> values) {
            addCriterion("ZHENGJZT in", values, "zhengjzt");
            return (Criteria) this;
        }

        public Criteria andZhengjztNotIn(List<String> values) {
            addCriterion("ZHENGJZT not in", values, "zhengjzt");
            return (Criteria) this;
        }

        public Criteria andZhengjztBetween(String value1, String value2) {
            addCriterion("ZHENGJZT between", value1, value2, "zhengjzt");
            return (Criteria) this;
        }

        public Criteria andZhengjztNotBetween(String value1, String value2) {
            addCriterion("ZHENGJZT not between", value1, value2, "zhengjzt");
            return (Criteria) this;
        }

        public Criteria andYingyztIsNull() {
            addCriterion("YINGYZT is null");
            return (Criteria) this;
        }

        public Criteria andYingyztIsNotNull() {
            addCriterion("YINGYZT is not null");
            return (Criteria) this;
        }

        public Criteria andYingyztEqualTo(String value) {
            addCriterion("YINGYZT =", value, "yingyzt");
            return (Criteria) this;
        }

        public Criteria andYingyztNotEqualTo(String value) {
            addCriterion("YINGYZT <>", value, "yingyzt");
            return (Criteria) this;
        }

        public Criteria andYingyztGreaterThan(String value) {
            addCriterion("YINGYZT >", value, "yingyzt");
            return (Criteria) this;
        }

        public Criteria andYingyztGreaterThanOrEqualTo(String value) {
            addCriterion("YINGYZT >=", value, "yingyzt");
            return (Criteria) this;
        }

        public Criteria andYingyztLessThan(String value) {
            addCriterion("YINGYZT <", value, "yingyzt");
            return (Criteria) this;
        }

        public Criteria andYingyztLessThanOrEqualTo(String value) {
            addCriterion("YINGYZT <=", value, "yingyzt");
            return (Criteria) this;
        }

        public Criteria andYingyztLike(String value) {
            addCriterion("YINGYZT like", value, "yingyzt");
            return (Criteria) this;
        }

        public Criteria andYingyztNotLike(String value) {
            addCriterion("YINGYZT not like", value, "yingyzt");
            return (Criteria) this;
        }

        public Criteria andYingyztIn(List<String> values) {
            addCriterion("YINGYZT in", values, "yingyzt");
            return (Criteria) this;
        }

        public Criteria andYingyztNotIn(List<String> values) {
            addCriterion("YINGYZT not in", values, "yingyzt");
            return (Criteria) this;
        }

        public Criteria andYingyztBetween(String value1, String value2) {
            addCriterion("YINGYZT between", value1, value2, "yingyzt");
            return (Criteria) this;
        }

        public Criteria andYingyztNotBetween(String value1, String value2) {
            addCriterion("YINGYZT not between", value1, value2, "yingyzt");
            return (Criteria) this;
        }

        public Criteria andBaoxidIsNull() {
            addCriterion("BAOXID is null");
            return (Criteria) this;
        }

        public Criteria andBaoxidIsNotNull() {
            addCriterion("BAOXID is not null");
            return (Criteria) this;
        }

        public Criteria andBaoxidEqualTo(String value) {
            addCriterion("BAOXID =", value, "baoxid");
            return (Criteria) this;
        }

        public Criteria andBaoxidNotEqualTo(String value) {
            addCriterion("BAOXID <>", value, "baoxid");
            return (Criteria) this;
        }

        public Criteria andBaoxidGreaterThan(String value) {
            addCriterion("BAOXID >", value, "baoxid");
            return (Criteria) this;
        }

        public Criteria andBaoxidGreaterThanOrEqualTo(String value) {
            addCriterion("BAOXID >=", value, "baoxid");
            return (Criteria) this;
        }

        public Criteria andBaoxidLessThan(String value) {
            addCriterion("BAOXID <", value, "baoxid");
            return (Criteria) this;
        }

        public Criteria andBaoxidLessThanOrEqualTo(String value) {
            addCriterion("BAOXID <=", value, "baoxid");
            return (Criteria) this;
        }

        public Criteria andBaoxidLike(String value) {
            addCriterion("BAOXID like", value, "baoxid");
            return (Criteria) this;
        }

        public Criteria andBaoxidNotLike(String value) {
            addCriterion("BAOXID not like", value, "baoxid");
            return (Criteria) this;
        }

        public Criteria andBaoxidIn(List<String> values) {
            addCriterion("BAOXID in", values, "baoxid");
            return (Criteria) this;
        }

        public Criteria andBaoxidNotIn(List<String> values) {
            addCriterion("BAOXID not in", values, "baoxid");
            return (Criteria) this;
        }

        public Criteria andBaoxidBetween(String value1, String value2) {
            addCriterion("BAOXID between", value1, value2, "baoxid");
            return (Criteria) this;
        }

        public Criteria andBaoxidNotBetween(String value1, String value2) {
            addCriterion("BAOXID not between", value1, value2, "baoxid");
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

        public Criteria andNiansyxrqIsNull() {
            addCriterion("NIANSYXRQ is null");
            return (Criteria) this;
        }

        public Criteria andNiansyxrqIsNotNull() {
            addCriterion("NIANSYXRQ is not null");
            return (Criteria) this;
        }

        public Criteria andNiansyxrqEqualTo(String value) {
            addCriterion("NIANSYXRQ =", value, "niansyxrq");
            return (Criteria) this;
        }

        public Criteria andNiansyxrqNotEqualTo(String value) {
            addCriterion("NIANSYXRQ <>", value, "niansyxrq");
            return (Criteria) this;
        }

        public Criteria andNiansyxrqGreaterThan(String value) {
            addCriterion("NIANSYXRQ >", value, "niansyxrq");
            return (Criteria) this;
        }

        public Criteria andNiansyxrqGreaterThanOrEqualTo(String value) {
            addCriterion("NIANSYXRQ >=", value, "niansyxrq");
            return (Criteria) this;
        }

        public Criteria andNiansyxrqLessThan(String value) {
            addCriterion("NIANSYXRQ <", value, "niansyxrq");
            return (Criteria) this;
        }

        public Criteria andNiansyxrqLessThanOrEqualTo(String value) {
            addCriterion("NIANSYXRQ <=", value, "niansyxrq");
            return (Criteria) this;
        }

        public Criteria andNiansyxrqLike(String value) {
            addCriterion("NIANSYXRQ like", value, "niansyxrq");
            return (Criteria) this;
        }

        public Criteria andNiansyxrqNotLike(String value) {
            addCriterion("NIANSYXRQ not like", value, "niansyxrq");
            return (Criteria) this;
        }

        public Criteria andNiansyxrqIn(List<String> values) {
            addCriterion("NIANSYXRQ in", values, "niansyxrq");
            return (Criteria) this;
        }

        public Criteria andNiansyxrqNotIn(List<String> values) {
            addCriterion("NIANSYXRQ not in", values, "niansyxrq");
            return (Criteria) this;
        }

        public Criteria andNiansyxrqBetween(String value1, String value2) {
            addCriterion("NIANSYXRQ between", value1, value2, "niansyxrq");
            return (Criteria) this;
        }

        public Criteria andNiansyxrqNotBetween(String value1, String value2) {
            addCriterion("NIANSYXRQ not between", value1, value2, "niansyxrq");
            return (Criteria) this;
        }

        public Criteria andErjwhyxrqIsNull() {
            addCriterion("ERJWHYXRQ is null");
            return (Criteria) this;
        }

        public Criteria andErjwhyxrqIsNotNull() {
            addCriterion("ERJWHYXRQ is not null");
            return (Criteria) this;
        }

        public Criteria andErjwhyxrqEqualTo(String value) {
            addCriterion("ERJWHYXRQ =", value, "erjwhyxrq");
            return (Criteria) this;
        }

        public Criteria andErjwhyxrqNotEqualTo(String value) {
            addCriterion("ERJWHYXRQ <>", value, "erjwhyxrq");
            return (Criteria) this;
        }

        public Criteria andErjwhyxrqGreaterThan(String value) {
            addCriterion("ERJWHYXRQ >", value, "erjwhyxrq");
            return (Criteria) this;
        }

        public Criteria andErjwhyxrqGreaterThanOrEqualTo(String value) {
            addCriterion("ERJWHYXRQ >=", value, "erjwhyxrq");
            return (Criteria) this;
        }

        public Criteria andErjwhyxrqLessThan(String value) {
            addCriterion("ERJWHYXRQ <", value, "erjwhyxrq");
            return (Criteria) this;
        }

        public Criteria andErjwhyxrqLessThanOrEqualTo(String value) {
            addCriterion("ERJWHYXRQ <=", value, "erjwhyxrq");
            return (Criteria) this;
        }

        public Criteria andErjwhyxrqLike(String value) {
            addCriterion("ERJWHYXRQ like", value, "erjwhyxrq");
            return (Criteria) this;
        }

        public Criteria andErjwhyxrqNotLike(String value) {
            addCriterion("ERJWHYXRQ not like", value, "erjwhyxrq");
            return (Criteria) this;
        }

        public Criteria andErjwhyxrqIn(List<String> values) {
            addCriterion("ERJWHYXRQ in", values, "erjwhyxrq");
            return (Criteria) this;
        }

        public Criteria andErjwhyxrqNotIn(List<String> values) {
            addCriterion("ERJWHYXRQ not in", values, "erjwhyxrq");
            return (Criteria) this;
        }

        public Criteria andErjwhyxrqBetween(String value1, String value2) {
            addCriterion("ERJWHYXRQ between", value1, value2, "erjwhyxrq");
            return (Criteria) this;
        }

        public Criteria andErjwhyxrqNotBetween(String value1, String value2) {
            addCriterion("ERJWHYXRQ not between", value1, value2, "erjwhyxrq");
            return (Criteria) this;
        }

        public Criteria andJisdjyxrqIsNull() {
            addCriterion("JISDJYXRQ is null");
            return (Criteria) this;
        }

        public Criteria andJisdjyxrqIsNotNull() {
            addCriterion("JISDJYXRQ is not null");
            return (Criteria) this;
        }

        public Criteria andJisdjyxrqEqualTo(String value) {
            addCriterion("JISDJYXRQ =", value, "jisdjyxrq");
            return (Criteria) this;
        }

        public Criteria andJisdjyxrqNotEqualTo(String value) {
            addCriterion("JISDJYXRQ <>", value, "jisdjyxrq");
            return (Criteria) this;
        }

        public Criteria andJisdjyxrqGreaterThan(String value) {
            addCriterion("JISDJYXRQ >", value, "jisdjyxrq");
            return (Criteria) this;
        }

        public Criteria andJisdjyxrqGreaterThanOrEqualTo(String value) {
            addCriterion("JISDJYXRQ >=", value, "jisdjyxrq");
            return (Criteria) this;
        }

        public Criteria andJisdjyxrqLessThan(String value) {
            addCriterion("JISDJYXRQ <", value, "jisdjyxrq");
            return (Criteria) this;
        }

        public Criteria andJisdjyxrqLessThanOrEqualTo(String value) {
            addCriterion("JISDJYXRQ <=", value, "jisdjyxrq");
            return (Criteria) this;
        }

        public Criteria andJisdjyxrqLike(String value) {
            addCriterion("JISDJYXRQ like", value, "jisdjyxrq");
            return (Criteria) this;
        }

        public Criteria andJisdjyxrqNotLike(String value) {
            addCriterion("JISDJYXRQ not like", value, "jisdjyxrq");
            return (Criteria) this;
        }

        public Criteria andJisdjyxrqIn(List<String> values) {
            addCriterion("JISDJYXRQ in", values, "jisdjyxrq");
            return (Criteria) this;
        }

        public Criteria andJisdjyxrqNotIn(List<String> values) {
            addCriterion("JISDJYXRQ not in", values, "jisdjyxrq");
            return (Criteria) this;
        }

        public Criteria andJisdjyxrqBetween(String value1, String value2) {
            addCriterion("JISDJYXRQ between", value1, value2, "jisdjyxrq");
            return (Criteria) this;
        }

        public Criteria andJisdjyxrqNotBetween(String value1, String value2) {
            addCriterion("JISDJYXRQ not between", value1, value2, "jisdjyxrq");
            return (Criteria) this;
        }

        public Criteria andKecdjIsNull() {
            addCriterion("KECDJ is null");
            return (Criteria) this;
        }

        public Criteria andKecdjIsNotNull() {
            addCriterion("KECDJ is not null");
            return (Criteria) this;
        }

        public Criteria andKecdjEqualTo(Short value) {
            addCriterion("KECDJ =", value, "kecdj");
            return (Criteria) this;
        }

        public Criteria andKecdjNotEqualTo(Short value) {
            addCriterion("KECDJ <>", value, "kecdj");
            return (Criteria) this;
        }

        public Criteria andKecdjGreaterThan(Short value) {
            addCriterion("KECDJ >", value, "kecdj");
            return (Criteria) this;
        }

        public Criteria andKecdjGreaterThanOrEqualTo(Short value) {
            addCriterion("KECDJ >=", value, "kecdj");
            return (Criteria) this;
        }

        public Criteria andKecdjLessThan(Short value) {
            addCriterion("KECDJ <", value, "kecdj");
            return (Criteria) this;
        }

        public Criteria andKecdjLessThanOrEqualTo(Short value) {
            addCriterion("KECDJ <=", value, "kecdj");
            return (Criteria) this;
        }

        public Criteria andKecdjIn(List<Short> values) {
            addCriterion("KECDJ in", values, "kecdj");
            return (Criteria) this;
        }

        public Criteria andKecdjNotIn(List<Short> values) {
            addCriterion("KECDJ not in", values, "kecdj");
            return (Criteria) this;
        }

        public Criteria andKecdjBetween(Short value1, Short value2) {
            addCriterion("KECDJ between", value1, value2, "kecdj");
            return (Criteria) this;
        }

        public Criteria andKecdjNotBetween(Short value1, Short value2) {
            addCriterion("KECDJ not between", value1, value2, "kecdj");
            return (Criteria) this;
        }

        public Criteria andKecdjyxrqIsNull() {
            addCriterion("KECDJYXRQ is null");
            return (Criteria) this;
        }

        public Criteria andKecdjyxrqIsNotNull() {
            addCriterion("KECDJYXRQ is not null");
            return (Criteria) this;
        }

        public Criteria andKecdjyxrqEqualTo(String value) {
            addCriterion("KECDJYXRQ =", value, "kecdjyxrq");
            return (Criteria) this;
        }

        public Criteria andKecdjyxrqNotEqualTo(String value) {
            addCriterion("KECDJYXRQ <>", value, "kecdjyxrq");
            return (Criteria) this;
        }

        public Criteria andKecdjyxrqGreaterThan(String value) {
            addCriterion("KECDJYXRQ >", value, "kecdjyxrq");
            return (Criteria) this;
        }

        public Criteria andKecdjyxrqGreaterThanOrEqualTo(String value) {
            addCriterion("KECDJYXRQ >=", value, "kecdjyxrq");
            return (Criteria) this;
        }

        public Criteria andKecdjyxrqLessThan(String value) {
            addCriterion("KECDJYXRQ <", value, "kecdjyxrq");
            return (Criteria) this;
        }

        public Criteria andKecdjyxrqLessThanOrEqualTo(String value) {
            addCriterion("KECDJYXRQ <=", value, "kecdjyxrq");
            return (Criteria) this;
        }

        public Criteria andKecdjyxrqLike(String value) {
            addCriterion("KECDJYXRQ like", value, "kecdjyxrq");
            return (Criteria) this;
        }

        public Criteria andKecdjyxrqNotLike(String value) {
            addCriterion("KECDJYXRQ not like", value, "kecdjyxrq");
            return (Criteria) this;
        }

        public Criteria andKecdjyxrqIn(List<String> values) {
            addCriterion("KECDJYXRQ in", values, "kecdjyxrq");
            return (Criteria) this;
        }

        public Criteria andKecdjyxrqNotIn(List<String> values) {
            addCriterion("KECDJYXRQ not in", values, "kecdjyxrq");
            return (Criteria) this;
        }

        public Criteria andKecdjyxrqBetween(String value1, String value2) {
            addCriterion("KECDJYXRQ between", value1, value2, "kecdjyxrq");
            return (Criteria) this;
        }

        public Criteria andKecdjyxrqNotBetween(String value1, String value2) {
            addCriterion("KECDJYXRQ not between", value1, value2, "kecdjyxrq");
            return (Criteria) this;
        }

        public Criteria andHedzzlIsNull() {
            addCriterion("HEDZZL is null");
            return (Criteria) this;
        }

        public Criteria andHedzzlIsNotNull() {
            addCriterion("HEDZZL is not null");
            return (Criteria) this;
        }

        public Criteria andHedzzlEqualTo(BigDecimal value) {
            addCriterion("HEDZZL =", value, "hedzzl");
            return (Criteria) this;
        }

        public Criteria andHedzzlNotEqualTo(BigDecimal value) {
            addCriterion("HEDZZL <>", value, "hedzzl");
            return (Criteria) this;
        }

        public Criteria andHedzzlGreaterThan(BigDecimal value) {
            addCriterion("HEDZZL >", value, "hedzzl");
            return (Criteria) this;
        }

        public Criteria andHedzzlGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("HEDZZL >=", value, "hedzzl");
            return (Criteria) this;
        }

        public Criteria andHedzzlLessThan(BigDecimal value) {
            addCriterion("HEDZZL <", value, "hedzzl");
            return (Criteria) this;
        }

        public Criteria andHedzzlLessThanOrEqualTo(BigDecimal value) {
            addCriterion("HEDZZL <=", value, "hedzzl");
            return (Criteria) this;
        }

        public Criteria andHedzzlIn(List<BigDecimal> values) {
            addCriterion("HEDZZL in", values, "hedzzl");
            return (Criteria) this;
        }

        public Criteria andHedzzlNotIn(List<BigDecimal> values) {
            addCriterion("HEDZZL not in", values, "hedzzl");
            return (Criteria) this;
        }

        public Criteria andHedzzlBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HEDZZL between", value1, value2, "hedzzl");
            return (Criteria) this;
        }

        public Criteria andHedzzlNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HEDZZL not between", value1, value2, "hedzzl");
            return (Criteria) this;
        }

        public Criteria andIckkhIsNull() {
            addCriterion("ICKKH is null");
            return (Criteria) this;
        }

        public Criteria andIckkhIsNotNull() {
            addCriterion("ICKKH is not null");
            return (Criteria) this;
        }

        public Criteria andIckkhEqualTo(String value) {
            addCriterion("ICKKH =", value, "ickkh");
            return (Criteria) this;
        }

        public Criteria andIckkhNotEqualTo(String value) {
            addCriterion("ICKKH <>", value, "ickkh");
            return (Criteria) this;
        }

        public Criteria andIckkhGreaterThan(String value) {
            addCriterion("ICKKH >", value, "ickkh");
            return (Criteria) this;
        }

        public Criteria andIckkhGreaterThanOrEqualTo(String value) {
            addCriterion("ICKKH >=", value, "ickkh");
            return (Criteria) this;
        }

        public Criteria andIckkhLessThan(String value) {
            addCriterion("ICKKH <", value, "ickkh");
            return (Criteria) this;
        }

        public Criteria andIckkhLessThanOrEqualTo(String value) {
            addCriterion("ICKKH <=", value, "ickkh");
            return (Criteria) this;
        }

        public Criteria andIckkhLike(String value) {
            addCriterion("ICKKH like", value, "ickkh");
            return (Criteria) this;
        }

        public Criteria andIckkhNotLike(String value) {
            addCriterion("ICKKH not like", value, "ickkh");
            return (Criteria) this;
        }

        public Criteria andIckkhIn(List<String> values) {
            addCriterion("ICKKH in", values, "ickkh");
            return (Criteria) this;
        }

        public Criteria andIckkhNotIn(List<String> values) {
            addCriterion("ICKKH not in", values, "ickkh");
            return (Criteria) this;
        }

        public Criteria andIckkhBetween(String value1, String value2) {
            addCriterion("ICKKH between", value1, value2, "ickkh");
            return (Criteria) this;
        }

        public Criteria andIckkhNotBetween(String value1, String value2) {
            addCriterion("ICKKH not between", value1, value2, "ickkh");
            return (Criteria) this;
        }

        public Criteria andChelidLikeInsensitive(String value) {
            addCriterion("upper(CHELID) like", value.toUpperCase(), "chelid");
            return (Criteria) this;
        }

        public Criteria andChephLikeInsensitive(String value) {
            addCriterion("upper(CHEPH) like", value.toUpperCase(), "cheph");
            return (Criteria) this;
        }

        public Criteria andChepysLikeInsensitive(String value) {
            addCriterion("upper(CHEPYS) like", value.toUpperCase(), "chepys");
            return (Criteria) this;
        }

        public Criteria andShifgcLikeInsensitive(String value) {
            addCriterion("upper(SHIFGC) like", value.toUpperCase(), "shifgc");
            return (Criteria) this;
        }

        public Criteria andChellxLikeInsensitive(String value) {
            addCriterion("upper(CHELLX) like", value.toUpperCase(), "chellx");
            return (Criteria) this;
        }

        public Criteria andGuigLikeInsensitive(String value) {
            addCriterion("upper(GUIG) like", value.toUpperCase(), "guig");
            return (Criteria) this;
        }

        public Criteria andJiegLikeInsensitive(String value) {
            addCriterion("upper(JIEG) like", value.toUpperCase(), "jieg");
            return (Criteria) this;
        }

        public Criteria andChelhylbLikeInsensitive(String value) {
            addCriterion("upper(CHELHYLB) like", value.toUpperCase(), "chelhylb");
            return (Criteria) this;
        }

        public Criteria andChesysLikeInsensitive(String value) {
            addCriterion("upper(CHESYS) like", value.toUpperCase(), "chesys");
            return (Criteria) this;
        }

        public Criteria andChangpLikeInsensitive(String value) {
            addCriterion("upper(CHANGP) like", value.toUpperCase(), "changp");
            return (Criteria) this;
        }

        public Criteria andXinghLikeInsensitive(String value) {
            addCriterion("upper(XINGH) like", value.toUpperCase(), "xingh");
            return (Criteria) this;
        }

        public Criteria andFadjxhLikeInsensitive(String value) {
            addCriterion("upper(FADJXH) like", value.toUpperCase(), "fadjxh");
            return (Criteria) this;
        }

        public Criteria andFadjhmLikeInsensitive(String value) {
            addCriterion("upper(FADJHM) like", value.toUpperCase(), "fadjhm");
            return (Criteria) this;
        }

        public Criteria andChelsbvinLikeInsensitive(String value) {
            addCriterion("upper(CHELSBVIN) like", value.toUpperCase(), "chelsbvin");
            return (Criteria) this;
        }

        public Criteria andXingszclrqLikeInsensitive(String value) {
            addCriterion("upper(XINGSZCLRQ) like", value.toUpperCase(), "xingszclrq");
            return (Criteria) this;
        }

        public Criteria andCheldjhLikeInsensitive(String value) {
            addCriterion("upper(CHELDJH) like", value.toUpperCase(), "cheldjh");
            return (Criteria) this;
        }

        public Criteria andDengjzdjrqLikeInsensitive(String value) {
            addCriterion("upper(DENGJZDJRQ) like", value.toUpperCase(), "dengjzdjrq");
            return (Criteria) this;
        }

        public Criteria andDengjzffrqLikeInsensitive(String value) {
            addCriterion("upper(DENGJZFFRQ) like", value.toUpperCase(), "dengjzffrq");
            return (Criteria) this;
        }

        public Criteria andRanllxdmLikeInsensitive(String value) {
            addCriterion("upper(RANLLXDM) like", value.toUpperCase(), "ranllxdm");
            return (Criteria) this;
        }

        public Criteria andCheljsdjLikeInsensitive(String value) {
            addCriterion("upper(CHELJSDJ) like", value.toUpperCase(), "cheljsdj");
            return (Criteria) this;
        }

        public Criteria andChucrqLikeInsensitive(String value) {
            addCriterion("upper(CHUCRQ) like", value.toUpperCase(), "chucrq");
            return (Criteria) this;
        }

        public Criteria andGoucrqLikeInsensitive(String value) {
            addCriterion("upper(GOUCRQ) like", value.toUpperCase(), "goucrq");
            return (Criteria) this;
        }

        public Criteria andLuohrqLikeInsensitive(String value) {
            addCriterion("upper(LUOHRQ) like", value.toUpperCase(), "luohrq");
            return (Criteria) this;
        }

        public Criteria andXuanjxsLikeInsensitive(String value) {
            addCriterion("upper(XUANJXS) like", value.toUpperCase(), "xuanjxs");
            return (Criteria) this;
        }

        public Criteria andDangahLikeInsensitive(String value) {
            addCriterion("upper(DANGAH) like", value.toUpperCase(), "dangah");
            return (Criteria) this;
        }

        public Criteria andDaolyszzhLikeInsensitive(String value) {
            addCriterion("upper(DAOLYSZZH) like", value.toUpperCase(), "daolyszzh");
            return (Criteria) this;
        }

        public Criteria andZhengjjymLikeInsensitive(String value) {
            addCriterion("upper(ZHENGJJYM) like", value.toUpperCase(), "zhengjjym");
            return (Criteria) this;
        }

        public Criteria andZhengjclrqLikeInsensitive(String value) {
            addCriterion("upper(ZHENGJCLRQ) like", value.toUpperCase(), "zhengjclrq");
            return (Criteria) this;
        }

        public Criteria andZhengjyxqqLikeInsensitive(String value) {
            addCriterion("upper(ZHENGJYXQQ) like", value.toUpperCase(), "zhengjyxqq");
            return (Criteria) this;
        }

        public Criteria andZhengjyxqzLikeInsensitive(String value) {
            addCriterion("upper(ZHENGJYXQZ) like", value.toUpperCase(), "zhengjyxqz");
            return (Criteria) this;
        }

        public Criteria andZhengjffrqLikeInsensitive(String value) {
            addCriterion("upper(ZHENGJFFRQ) like", value.toUpperCase(), "zhengjffrq");
            return (Criteria) this;
        }

        public Criteria andFazjgLikeInsensitive(String value) {
            addCriterion("upper(FAZJG) like", value.toUpperCase(), "fazjg");
            return (Criteria) this;
        }

        public Criteria andChezzdcjLikeInsensitive(String value) {
            addCriterion("upper(CHEZZDCJ) like", value.toUpperCase(), "chezzdcj");
            return (Criteria) this;
        }

        public Criteria andChezzdxhLikeInsensitive(String value) {
            addCriterion("upper(CHEZZDXH) like", value.toUpperCase(), "chezzdxh");
            return (Criteria) this;
        }

        public Criteria andChezzdbhLikeInsensitive(String value) {
            addCriterion("upper(CHEZZDBH) like", value.toUpperCase(), "chezzdbh");
            return (Criteria) this;
        }

        public Criteria andZhongdazrqLikeInsensitive(String value) {
            addCriterion("upper(ZHONGDAZRQ) like", value.toUpperCase(), "zhongdazrq");
            return (Criteria) this;
        }

        public Criteria andXingsjlyxhLikeInsensitive(String value) {
            addCriterion("upper(XINGSJLYXH) like", value.toUpperCase(), "xingsjlyxh");
            return (Criteria) this;
        }

        public Criteria andXingsjlybhLikeInsensitive(String value) {
            addCriterion("upper(XINGSJLYBH) like", value.toUpperCase(), "xingsjlybh");
            return (Criteria) this;
        }

        public Criteria andYehidLikeInsensitive(String value) {
            addCriterion("upper(YEHID) like", value.toUpperCase(), "yehid");
            return (Criteria) this;
        }

        public Criteria andGuanxjgLikeInsensitive(String value) {
            addCriterion("upper(GUANXJG) like", value.toUpperCase(), "guanxjg");
            return (Criteria) this;
        }

        public Criteria andJingxfwdmLikeInsensitive(String value) {
            addCriterion("upper(JINGXFWDM) like", value.toUpperCase(), "jingxfwdm");
            return (Criteria) this;
        }

        public Criteria andJingxfwmcLikeInsensitive(String value) {
            addCriterion("upper(JINGXFWMC) like", value.toUpperCase(), "jingxfwmc");
            return (Criteria) this;
        }

        public Criteria andXingzqhbmLikeInsensitive(String value) {
            addCriterion("upper(XINGZQHBM) like", value.toUpperCase(), "xingzqhbm");
            return (Criteria) this;
        }

        public Criteria andLisqxdmLikeInsensitive(String value) {
            addCriterion("upper(LISQXDM) like", value.toUpperCase(), "lisqxdm");
            return (Criteria) this;
        }

        public Criteria andChuangjrLikeInsensitive(String value) {
            addCriterion("upper(CHUANGJR) like", value.toUpperCase(), "chuangjr");
            return (Criteria) this;
        }

        public Criteria andChuangjsjLikeInsensitive(String value) {
            addCriterion("upper(CHUANGJSJ) like", value.toUpperCase(), "chuangjsj");
            return (Criteria) this;
        }

        public Criteria andXiugrLikeInsensitive(String value) {
            addCriterion("upper(XIUGR) like", value.toUpperCase(), "xiugr");
            return (Criteria) this;
        }

        public Criteria andXiugsjLikeInsensitive(String value) {
            addCriterion("upper(XIUGSJ) like", value.toUpperCase(), "xiugsj");
            return (Criteria) this;
        }

        public Criteria andZhengjztLikeInsensitive(String value) {
            addCriterion("upper(ZHENGJZT) like", value.toUpperCase(), "zhengjzt");
            return (Criteria) this;
        }

        public Criteria andYingyztLikeInsensitive(String value) {
            addCriterion("upper(YINGYZT) like", value.toUpperCase(), "yingyzt");
            return (Criteria) this;
        }

        public Criteria andBaoxidLikeInsensitive(String value) {
            addCriterion("upper(BAOXID) like", value.toUpperCase(), "baoxid");
            return (Criteria) this;
        }

        public Criteria andBeizLikeInsensitive(String value) {
            addCriterion("upper(BEIZ) like", value.toUpperCase(), "beiz");
            return (Criteria) this;
        }

        public Criteria andNiansyxrqLikeInsensitive(String value) {
            addCriterion("upper(NIANSYXRQ) like", value.toUpperCase(), "niansyxrq");
            return (Criteria) this;
        }

        public Criteria andErjwhyxrqLikeInsensitive(String value) {
            addCriterion("upper(ERJWHYXRQ) like", value.toUpperCase(), "erjwhyxrq");
            return (Criteria) this;
        }

        public Criteria andJisdjyxrqLikeInsensitive(String value) {
            addCriterion("upper(JISDJYXRQ) like", value.toUpperCase(), "jisdjyxrq");
            return (Criteria) this;
        }

        public Criteria andKecdjyxrqLikeInsensitive(String value) {
            addCriterion("upper(KECDJYXRQ) like", value.toUpperCase(), "kecdjyxrq");
            return (Criteria) this;
        }

        public Criteria andIckkhLikeInsensitive(String value) {
            addCriterion("upper(ICKKH) like", value.toUpperCase(), "ickkh");
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