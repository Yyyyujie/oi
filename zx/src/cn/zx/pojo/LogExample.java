package cn.zx.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LogExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTableNameIsNull() {
            addCriterion("tableName is null");
            return (Criteria) this;
        }

        public Criteria andTableNameIsNotNull() {
            addCriterion("tableName is not null");
            return (Criteria) this;
        }

        public Criteria andTableNameEqualTo(String value) {
            addCriterion("tableName =", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotEqualTo(String value) {
            addCriterion("tableName <>", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameGreaterThan(String value) {
            addCriterion("tableName >", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameGreaterThanOrEqualTo(String value) {
            addCriterion("tableName >=", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameLessThan(String value) {
            addCriterion("tableName <", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameLessThanOrEqualTo(String value) {
            addCriterion("tableName <=", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameLike(String value) {
            addCriterion("tableName like", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotLike(String value) {
            addCriterion("tableName not like", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameIn(List<String> values) {
            addCriterion("tableName in", values, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotIn(List<String> values) {
            addCriterion("tableName not in", values, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameBetween(String value1, String value2) {
            addCriterion("tableName between", value1, value2, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotBetween(String value1, String value2) {
            addCriterion("tableName not between", value1, value2, "tableName");
            return (Criteria) this;
        }

        public Criteria andTable_remarksIsNull() {
            addCriterion("table_remarks is null");
            return (Criteria) this;
        }

        public Criteria andTable_remarksIsNotNull() {
            addCriterion("table_remarks is not null");
            return (Criteria) this;
        }

        public Criteria andTable_remarksEqualTo(String value) {
            addCriterion("table_remarks =", value, "table_remarks");
            return (Criteria) this;
        }

        public Criteria andTable_remarksNotEqualTo(String value) {
            addCriterion("table_remarks <>", value, "table_remarks");
            return (Criteria) this;
        }

        public Criteria andTable_remarksGreaterThan(String value) {
            addCriterion("table_remarks >", value, "table_remarks");
            return (Criteria) this;
        }

        public Criteria andTable_remarksGreaterThanOrEqualTo(String value) {
            addCriterion("table_remarks >=", value, "table_remarks");
            return (Criteria) this;
        }

        public Criteria andTable_remarksLessThan(String value) {
            addCriterion("table_remarks <", value, "table_remarks");
            return (Criteria) this;
        }

        public Criteria andTable_remarksLessThanOrEqualTo(String value) {
            addCriterion("table_remarks <=", value, "table_remarks");
            return (Criteria) this;
        }

        public Criteria andTable_remarksLike(String value) {
            addCriterion("table_remarks like", value, "table_remarks");
            return (Criteria) this;
        }

        public Criteria andTable_remarksNotLike(String value) {
            addCriterion("table_remarks not like", value, "table_remarks");
            return (Criteria) this;
        }

        public Criteria andTable_remarksIn(List<String> values) {
            addCriterion("table_remarks in", values, "table_remarks");
            return (Criteria) this;
        }

        public Criteria andTable_remarksNotIn(List<String> values) {
            addCriterion("table_remarks not in", values, "table_remarks");
            return (Criteria) this;
        }

        public Criteria andTable_remarksBetween(String value1, String value2) {
            addCriterion("table_remarks between", value1, value2, "table_remarks");
            return (Criteria) this;
        }

        public Criteria andTable_remarksNotBetween(String value1, String value2) {
            addCriterion("table_remarks not between", value1, value2, "table_remarks");
            return (Criteria) this;
        }

        public Criteria andListIsNull() {
            addCriterion("list is null");
            return (Criteria) this;
        }

        public Criteria andListIsNotNull() {
            addCriterion("list is not null");
            return (Criteria) this;
        }

        public Criteria andListEqualTo(String value) {
            addCriterion("list =", value, "list");
            return (Criteria) this;
        }

        public Criteria andListNotEqualTo(String value) {
            addCriterion("list <>", value, "list");
            return (Criteria) this;
        }

        public Criteria andListGreaterThan(String value) {
            addCriterion("list >", value, "list");
            return (Criteria) this;
        }

        public Criteria andListGreaterThanOrEqualTo(String value) {
            addCriterion("list >=", value, "list");
            return (Criteria) this;
        }

        public Criteria andListLessThan(String value) {
            addCriterion("list <", value, "list");
            return (Criteria) this;
        }

        public Criteria andListLessThanOrEqualTo(String value) {
            addCriterion("list <=", value, "list");
            return (Criteria) this;
        }

        public Criteria andListLike(String value) {
            addCriterion("list like", value, "list");
            return (Criteria) this;
        }

        public Criteria andListNotLike(String value) {
            addCriterion("list not like", value, "list");
            return (Criteria) this;
        }

        public Criteria andListIn(List<String> values) {
            addCriterion("list in", values, "list");
            return (Criteria) this;
        }

        public Criteria andListNotIn(List<String> values) {
            addCriterion("list not in", values, "list");
            return (Criteria) this;
        }

        public Criteria andListBetween(String value1, String value2) {
            addCriterion("list between", value1, value2, "list");
            return (Criteria) this;
        }

        public Criteria andListNotBetween(String value1, String value2) {
            addCriterion("list not between", value1, value2, "list");
            return (Criteria) this;
        }

        public Criteria andList_remarksIsNull() {
            addCriterion("list_remarks is null");
            return (Criteria) this;
        }

        public Criteria andList_remarksIsNotNull() {
            addCriterion("list_remarks is not null");
            return (Criteria) this;
        }

        public Criteria andList_remarksEqualTo(String value) {
            addCriterion("list_remarks =", value, "list_remarks");
            return (Criteria) this;
        }

        public Criteria andList_remarksNotEqualTo(String value) {
            addCriterion("list_remarks <>", value, "list_remarks");
            return (Criteria) this;
        }

        public Criteria andList_remarksGreaterThan(String value) {
            addCriterion("list_remarks >", value, "list_remarks");
            return (Criteria) this;
        }

        public Criteria andList_remarksGreaterThanOrEqualTo(String value) {
            addCriterion("list_remarks >=", value, "list_remarks");
            return (Criteria) this;
        }

        public Criteria andList_remarksLessThan(String value) {
            addCriterion("list_remarks <", value, "list_remarks");
            return (Criteria) this;
        }

        public Criteria andList_remarksLessThanOrEqualTo(String value) {
            addCriterion("list_remarks <=", value, "list_remarks");
            return (Criteria) this;
        }

        public Criteria andList_remarksLike(String value) {
            addCriterion("list_remarks like", value, "list_remarks");
            return (Criteria) this;
        }

        public Criteria andList_remarksNotLike(String value) {
            addCriterion("list_remarks not like", value, "list_remarks");
            return (Criteria) this;
        }

        public Criteria andList_remarksIn(List<String> values) {
            addCriterion("list_remarks in", values, "list_remarks");
            return (Criteria) this;
        }

        public Criteria andList_remarksNotIn(List<String> values) {
            addCriterion("list_remarks not in", values, "list_remarks");
            return (Criteria) this;
        }

        public Criteria andList_remarksBetween(String value1, String value2) {
            addCriterion("list_remarks between", value1, value2, "list_remarks");
            return (Criteria) this;
        }

        public Criteria andList_remarksNotBetween(String value1, String value2) {
            addCriterion("list_remarks not between", value1, value2, "list_remarks");
            return (Criteria) this;
        }

        public Criteria andData_idIsNull() {
            addCriterion("data_id is null");
            return (Criteria) this;
        }

        public Criteria andData_idIsNotNull() {
            addCriterion("data_id is not null");
            return (Criteria) this;
        }

        public Criteria andData_idEqualTo(Integer value) {
            addCriterion("data_id =", value, "data_id");
            return (Criteria) this;
        }

        public Criteria andData_idNotEqualTo(Integer value) {
            addCriterion("data_id <>", value, "data_id");
            return (Criteria) this;
        }

        public Criteria andData_idGreaterThan(Integer value) {
            addCriterion("data_id >", value, "data_id");
            return (Criteria) this;
        }

        public Criteria andData_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("data_id >=", value, "data_id");
            return (Criteria) this;
        }

        public Criteria andData_idLessThan(Integer value) {
            addCriterion("data_id <", value, "data_id");
            return (Criteria) this;
        }

        public Criteria andData_idLessThanOrEqualTo(Integer value) {
            addCriterion("data_id <=", value, "data_id");
            return (Criteria) this;
        }

        public Criteria andData_idIn(List<Integer> values) {
            addCriterion("data_id in", values, "data_id");
            return (Criteria) this;
        }

        public Criteria andData_idNotIn(List<Integer> values) {
            addCriterion("data_id not in", values, "data_id");
            return (Criteria) this;
        }

        public Criteria andData_idBetween(Integer value1, Integer value2) {
            addCriterion("data_id between", value1, value2, "data_id");
            return (Criteria) this;
        }

        public Criteria andData_idNotBetween(Integer value1, Integer value2) {
            addCriterion("data_id not between", value1, value2, "data_id");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUNameIsNull() {
            addCriterion("uName is null");
            return (Criteria) this;
        }

        public Criteria andUNameIsNotNull() {
            addCriterion("uName is not null");
            return (Criteria) this;
        }

        public Criteria andUNameEqualTo(String value) {
            addCriterion("uName =", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameNotEqualTo(String value) {
            addCriterion("uName <>", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameGreaterThan(String value) {
            addCriterion("uName >", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameGreaterThanOrEqualTo(String value) {
            addCriterion("uName >=", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameLessThan(String value) {
            addCriterion("uName <", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameLessThanOrEqualTo(String value) {
            addCriterion("uName <=", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameLike(String value) {
            addCriterion("uName like", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameNotLike(String value) {
            addCriterion("uName not like", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameIn(List<String> values) {
            addCriterion("uName in", values, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameNotIn(List<String> values) {
            addCriterion("uName not in", values, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameBetween(String value1, String value2) {
            addCriterion("uName between", value1, value2, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameNotBetween(String value1, String value2) {
            addCriterion("uName not between", value1, value2, "uName");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("createDate is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("createDate is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("createDate =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("createDate <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("createDate >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("createDate >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("createDate <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("createDate <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("createDate in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("createDate not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("createDate between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("createDate not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCharactIsNull() {
            addCriterion("charact is null");
            return (Criteria) this;
        }

        public Criteria andCharactIsNotNull() {
            addCriterion("charact is not null");
            return (Criteria) this;
        }

        public Criteria andCharactEqualTo(Integer value) {
            addCriterion("charact =", value, "charact");
            return (Criteria) this;
        }

        public Criteria andCharactNotEqualTo(Integer value) {
            addCriterion("charact <>", value, "charact");
            return (Criteria) this;
        }

        public Criteria andCharactGreaterThan(Integer value) {
            addCriterion("charact >", value, "charact");
            return (Criteria) this;
        }

        public Criteria andCharactGreaterThanOrEqualTo(Integer value) {
            addCriterion("charact >=", value, "charact");
            return (Criteria) this;
        }

        public Criteria andCharactLessThan(Integer value) {
            addCriterion("charact <", value, "charact");
            return (Criteria) this;
        }

        public Criteria andCharactLessThanOrEqualTo(Integer value) {
            addCriterion("charact <=", value, "charact");
            return (Criteria) this;
        }

        public Criteria andCharactIn(List<Integer> values) {
            addCriterion("charact in", values, "charact");
            return (Criteria) this;
        }

        public Criteria andCharactNotIn(List<Integer> values) {
            addCriterion("charact not in", values, "charact");
            return (Criteria) this;
        }

        public Criteria andCharactBetween(Integer value1, Integer value2) {
            addCriterion("charact between", value1, value2, "charact");
            return (Criteria) this;
        }

        public Criteria andCharactNotBetween(Integer value1, Integer value2) {
            addCriterion("charact not between", value1, value2, "charact");
            return (Criteria) this;
        }

        public Criteria andCreateIPIsNull() {
            addCriterion("createIP is null");
            return (Criteria) this;
        }

        public Criteria andCreateIPIsNotNull() {
            addCriterion("createIP is not null");
            return (Criteria) this;
        }

        public Criteria andCreateIPEqualTo(String value) {
            addCriterion("createIP =", value, "createIP");
            return (Criteria) this;
        }

        public Criteria andCreateIPNotEqualTo(String value) {
            addCriterion("createIP <>", value, "createIP");
            return (Criteria) this;
        }

        public Criteria andCreateIPGreaterThan(String value) {
            addCriterion("createIP >", value, "createIP");
            return (Criteria) this;
        }

        public Criteria andCreateIPGreaterThanOrEqualTo(String value) {
            addCriterion("createIP >=", value, "createIP");
            return (Criteria) this;
        }

        public Criteria andCreateIPLessThan(String value) {
            addCriterion("createIP <", value, "createIP");
            return (Criteria) this;
        }

        public Criteria andCreateIPLessThanOrEqualTo(String value) {
            addCriterion("createIP <=", value, "createIP");
            return (Criteria) this;
        }

        public Criteria andCreateIPLike(String value) {
            addCriterion("createIP like", value, "createIP");
            return (Criteria) this;
        }

        public Criteria andCreateIPNotLike(String value) {
            addCriterion("createIP not like", value, "createIP");
            return (Criteria) this;
        }

        public Criteria andCreateIPIn(List<String> values) {
            addCriterion("createIP in", values, "createIP");
            return (Criteria) this;
        }

        public Criteria andCreateIPNotIn(List<String> values) {
            addCriterion("createIP not in", values, "createIP");
            return (Criteria) this;
        }

        public Criteria andCreateIPBetween(String value1, String value2) {
            addCriterion("createIP between", value1, value2, "createIP");
            return (Criteria) this;
        }

        public Criteria andCreateIPNotBetween(String value1, String value2) {
            addCriterion("createIP not between", value1, value2, "createIP");
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