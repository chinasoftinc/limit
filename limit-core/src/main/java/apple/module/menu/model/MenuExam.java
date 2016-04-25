package apple.module.menu.model;

import java.util.ArrayList;
import java.util.List;

import apple.common.base.entity.Entity;
import apple.common.dto.Pagination;

public class MenuExam extends Entity<MenuExam> {
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	protected Pagination pagination;

	public MenuExam() {
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

		public Criteria andMenuNameIsNull() {
			addCriterion("menu_name is null");
			return (Criteria) this;
		}

		public Criteria andMenuNameIsNotNull() {
			addCriterion("menu_name is not null");
			return (Criteria) this;
		}

		public Criteria andMenuNameEqualTo(String value) {
			addCriterion("menu_name =", value, "menuName");
			return (Criteria) this;
		}

		public Criteria andMenuNameNotEqualTo(String value) {
			addCriterion("menu_name <>", value, "menuName");
			return (Criteria) this;
		}

		public Criteria andMenuNameGreaterThan(String value) {
			addCriterion("menu_name >", value, "menuName");
			return (Criteria) this;
		}

		public Criteria andMenuNameGreaterThanOrEqualTo(String value) {
			addCriterion("menu_name >=", value, "menuName");
			return (Criteria) this;
		}

		public Criteria andMenuNameLessThan(String value) {
			addCriterion("menu_name <", value, "menuName");
			return (Criteria) this;
		}

		public Criteria andMenuNameLessThanOrEqualTo(String value) {
			addCriterion("menu_name <=", value, "menuName");
			return (Criteria) this;
		}

		public Criteria andMenuNameLike(String value) {
			addCriterion("menu_name like", value, "menuName");
			return (Criteria) this;
		}

		public Criteria andMenuNameNotLike(String value) {
			addCriterion("menu_name not like", value, "menuName");
			return (Criteria) this;
		}

		public Criteria andMenuNameIn(List<String> values) {
			addCriterion("menu_name in", values, "menuName");
			return (Criteria) this;
		}

		public Criteria andMenuNameNotIn(List<String> values) {
			addCriterion("menu_name not in", values, "menuName");
			return (Criteria) this;
		}

		public Criteria andMenuNameBetween(String value1, String value2) {
			addCriterion("menu_name between", value1, value2, "menuName");
			return (Criteria) this;
		}

		public Criteria andMenuNameNotBetween(String value1, String value2) {
			addCriterion("menu_name not between", value1, value2, "menuName");
			return (Criteria) this;
		}

		public Criteria andMenuUrlIsNull() {
			addCriterion("menu_url is null");
			return (Criteria) this;
		}

		public Criteria andMenuUrlIsNotNull() {
			addCriterion("menu_url is not null");
			return (Criteria) this;
		}

		public Criteria andMenuUrlEqualTo(String value) {
			addCriterion("menu_url =", value, "menuUrl");
			return (Criteria) this;
		}

		public Criteria andMenuUrlNotEqualTo(String value) {
			addCriterion("menu_url <>", value, "menuUrl");
			return (Criteria) this;
		}

		public Criteria andMenuUrlGreaterThan(String value) {
			addCriterion("menu_url >", value, "menuUrl");
			return (Criteria) this;
		}

		public Criteria andMenuUrlGreaterThanOrEqualTo(String value) {
			addCriterion("menu_url >=", value, "menuUrl");
			return (Criteria) this;
		}

		public Criteria andMenuUrlLessThan(String value) {
			addCriterion("menu_url <", value, "menuUrl");
			return (Criteria) this;
		}

		public Criteria andMenuUrlLessThanOrEqualTo(String value) {
			addCriterion("menu_url <=", value, "menuUrl");
			return (Criteria) this;
		}

		public Criteria andMenuUrlLike(String value) {
			addCriterion("menu_url like", value, "menuUrl");
			return (Criteria) this;
		}

		public Criteria andMenuUrlNotLike(String value) {
			addCriterion("menu_url not like", value, "menuUrl");
			return (Criteria) this;
		}

		public Criteria andMenuUrlIn(List<String> values) {
			addCriterion("menu_url in", values, "menuUrl");
			return (Criteria) this;
		}

		public Criteria andMenuUrlNotIn(List<String> values) {
			addCriterion("menu_url not in", values, "menuUrl");
			return (Criteria) this;
		}

		public Criteria andMenuUrlBetween(String value1, String value2) {
			addCriterion("menu_url between", value1, value2, "menuUrl");
			return (Criteria) this;
		}

		public Criteria andMenuUrlNotBetween(String value1, String value2) {
			addCriterion("menu_url not between", value1, value2, "menuUrl");
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

		public Criteria andPrivilegeCodeIsNull() {
			addCriterion("privilege_code is null");
			return (Criteria) this;
		}

		public Criteria andPrivilegeCodeIsNotNull() {
			addCriterion("privilege_code is not null");
			return (Criteria) this;
		}

		public Criteria andPrivilegeCodeEqualTo(Long value) {
			addCriterion("privilege_code =", value, "privilegeCode");
			return (Criteria) this;
		}

		public Criteria andPrivilegeCodeNotEqualTo(Long value) {
			addCriterion("privilege_code <>", value, "privilegeCode");
			return (Criteria) this;
		}

		public Criteria andPrivilegeCodeGreaterThan(Long value) {
			addCriterion("privilege_code >", value, "privilegeCode");
			return (Criteria) this;
		}

		public Criteria andPrivilegeCodeGreaterThanOrEqualTo(Long value) {
			addCriterion("privilege_code >=", value, "privilegeCode");
			return (Criteria) this;
		}

		public Criteria andPrivilegeCodeLessThan(Long value) {
			addCriterion("privilege_code <", value, "privilegeCode");
			return (Criteria) this;
		}

		public Criteria andPrivilegeCodeLessThanOrEqualTo(Long value) {
			addCriterion("privilege_code <=", value, "privilegeCode");
			return (Criteria) this;
		}

		public Criteria andPrivilegeCodeIn(List<Long> values) {
			addCriterion("privilege_code in", values, "privilegeCode");
			return (Criteria) this;
		}

		public Criteria andPrivilegeCodeNotIn(List<Long> values) {
			addCriterion("privilege_code not in", values, "privilegeCode");
			return (Criteria) this;
		}

		public Criteria andPrivilegeCodeBetween(Long value1, Long value2) {
			addCriterion("privilege_code between", value1, value2, "privilegeCode");
			return (Criteria) this;
		}

		public Criteria andPrivilegeCodeNotBetween(Long value1, Long value2) {
			addCriterion("privilege_code not between", value1, value2, "privilegeCode");
			return (Criteria) this;
		}

		public Criteria andPrivilegePosIsNull() {
			addCriterion("privilege_pos is null");
			return (Criteria) this;
		}

		public Criteria andPrivilegePosIsNotNull() {
			addCriterion("privilege_pos is not null");
			return (Criteria) this;
		}

		public Criteria andPrivilegePosEqualTo(Integer value) {
			addCriterion("privilege_pos =", value, "privilegePos");
			return (Criteria) this;
		}

		public Criteria andPrivilegePosNotEqualTo(Integer value) {
			addCriterion("privilege_pos <>", value, "privilegePos");
			return (Criteria) this;
		}

		public Criteria andPrivilegePosGreaterThan(Integer value) {
			addCriterion("privilege_pos >", value, "privilegePos");
			return (Criteria) this;
		}

		public Criteria andPrivilegePosGreaterThanOrEqualTo(Integer value) {
			addCriterion("privilege_pos >=", value, "privilegePos");
			return (Criteria) this;
		}

		public Criteria andPrivilegePosLessThan(Integer value) {
			addCriterion("privilege_pos <", value, "privilegePos");
			return (Criteria) this;
		}

		public Criteria andPrivilegePosLessThanOrEqualTo(Integer value) {
			addCriterion("privilege_pos <=", value, "privilegePos");
			return (Criteria) this;
		}

		public Criteria andPrivilegePosIn(List<Integer> values) {
			addCriterion("privilege_pos in", values, "privilegePos");
			return (Criteria) this;
		}

		public Criteria andPrivilegePosNotIn(List<Integer> values) {
			addCriterion("privilege_pos not in", values, "privilegePos");
			return (Criteria) this;
		}

		public Criteria andPrivilegePosBetween(Integer value1, Integer value2) {
			addCriterion("privilege_pos between", value1, value2, "privilegePos");
			return (Criteria) this;
		}

		public Criteria andPrivilegePosNotBetween(Integer value1, Integer value2) {
			addCriterion("privilege_pos not between", value1, value2, "privilegePos");
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

		public Criteria andMenuOrderIsNull() {
			addCriterion("menu_order is null");
			return (Criteria) this;
		}

		public Criteria andMenuOrderIsNotNull() {
			addCriterion("menu_order is not null");
			return (Criteria) this;
		}

		public Criteria andMenuOrderEqualTo(Integer value) {
			addCriterion("menu_order =", value, "menuOrder");
			return (Criteria) this;
		}

		public Criteria andMenuOrderNotEqualTo(Integer value) {
			addCriterion("menu_order <>", value, "menuOrder");
			return (Criteria) this;
		}

		public Criteria andMenuOrderGreaterThan(Integer value) {
			addCriterion("menu_order >", value, "menuOrder");
			return (Criteria) this;
		}

		public Criteria andMenuOrderGreaterThanOrEqualTo(Integer value) {
			addCriterion("menu_order >=", value, "menuOrder");
			return (Criteria) this;
		}

		public Criteria andMenuOrderLessThan(Integer value) {
			addCriterion("menu_order <", value, "menuOrder");
			return (Criteria) this;
		}

		public Criteria andMenuOrderLessThanOrEqualTo(Integer value) {
			addCriterion("menu_order <=", value, "menuOrder");
			return (Criteria) this;
		}

		public Criteria andMenuOrderIn(List<Integer> values) {
			addCriterion("menu_order in", values, "menuOrder");
			return (Criteria) this;
		}

		public Criteria andMenuOrderNotIn(List<Integer> values) {
			addCriterion("menu_order not in", values, "menuOrder");
			return (Criteria) this;
		}

		public Criteria andMenuOrderBetween(Integer value1, Integer value2) {
			addCriterion("menu_order between", value1, value2, "menuOrder");
			return (Criteria) this;
		}

		public Criteria andMenuOrderNotBetween(Integer value1, Integer value2) {
			addCriterion("menu_order not between", value1, value2, "menuOrder");
			return (Criteria) this;
		}

		public Criteria andMenuNameLikeInsensitive(String value) {
			addCriterion("upper(menu_name) like", value.toUpperCase(), "menuName");
			return (Criteria) this;
		}

		public Criteria andMenuUrlLikeInsensitive(String value) {
			addCriterion("upper(menu_url) like", value.toUpperCase(), "menuUrl");
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
