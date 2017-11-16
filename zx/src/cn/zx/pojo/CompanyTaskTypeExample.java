package cn.zx.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompanyTaskTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompanyTaskTypeExample() {
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

        public Criteria andTask_type_idIsNull() {
            addCriterion("task_type_id is null");
            return (Criteria) this;
        }

        public Criteria andTask_type_idIsNotNull() {
            addCriterion("task_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTask_type_idEqualTo(Integer value) {
            addCriterion("task_type_id =", value, "task_type_id");
            return (Criteria) this;
        }

        public Criteria andTask_type_idNotEqualTo(Integer value) {
            addCriterion("task_type_id <>", value, "task_type_id");
            return (Criteria) this;
        }

        public Criteria andTask_type_idGreaterThan(Integer value) {
            addCriterion("task_type_id >", value, "task_type_id");
            return (Criteria) this;
        }

        public Criteria andTask_type_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_type_id >=", value, "task_type_id");
            return (Criteria) this;
        }

        public Criteria andTask_type_idLessThan(Integer value) {
            addCriterion("task_type_id <", value, "task_type_id");
            return (Criteria) this;
        }

        public Criteria andTask_type_idLessThanOrEqualTo(Integer value) {
            addCriterion("task_type_id <=", value, "task_type_id");
            return (Criteria) this;
        }

        public Criteria andTask_type_idIn(List<Integer> values) {
            addCriterion("task_type_id in", values, "task_type_id");
            return (Criteria) this;
        }

        public Criteria andTask_type_idNotIn(List<Integer> values) {
            addCriterion("task_type_id not in", values, "task_type_id");
            return (Criteria) this;
        }

        public Criteria andTask_type_idBetween(Integer value1, Integer value2) {
            addCriterion("task_type_id between", value1, value2, "task_type_id");
            return (Criteria) this;
        }

        public Criteria andTask_type_idNotBetween(Integer value1, Integer value2) {
            addCriterion("task_type_id not between", value1, value2, "task_type_id");
            return (Criteria) this;
        }

        public Criteria andCompany_idIsNull() {
            addCriterion("company_id is null");
            return (Criteria) this;
        }

        public Criteria andCompany_idIsNotNull() {
            addCriterion("company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompany_idEqualTo(Integer value) {
            addCriterion("company_id =", value, "company_id");
            return (Criteria) this;
        }

        public Criteria andCompany_idNotEqualTo(Integer value) {
            addCriterion("company_id <>", value, "company_id");
            return (Criteria) this;
        }

        public Criteria andCompany_idGreaterThan(Integer value) {
            addCriterion("company_id >", value, "company_id");
            return (Criteria) this;
        }

        public Criteria andCompany_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_id >=", value, "company_id");
            return (Criteria) this;
        }

        public Criteria andCompany_idLessThan(Integer value) {
            addCriterion("company_id <", value, "company_id");
            return (Criteria) this;
        }

        public Criteria andCompany_idLessThanOrEqualTo(Integer value) {
            addCriterion("company_id <=", value, "company_id");
            return (Criteria) this;
        }

        public Criteria andCompany_idIn(List<Integer> values) {
            addCriterion("company_id in", values, "company_id");
            return (Criteria) this;
        }

        public Criteria andCompany_idNotIn(List<Integer> values) {
            addCriterion("company_id not in", values, "company_id");
            return (Criteria) this;
        }

        public Criteria andCompany_idBetween(Integer value1, Integer value2) {
            addCriterion("company_id between", value1, value2, "company_id");
            return (Criteria) this;
        }

        public Criteria andCompany_idNotBetween(Integer value1, Integer value2) {
            addCriterion("company_id not between", value1, value2, "company_id");
            return (Criteria) this;
        }

        public Criteria andTask_typeIsNull() {
            addCriterion("task_type is null");
            return (Criteria) this;
        }

        public Criteria andTask_typeIsNotNull() {
            addCriterion("task_type is not null");
            return (Criteria) this;
        }

        public Criteria andTask_typeEqualTo(String value) {
            addCriterion("task_type =", value, "task_type");
            return (Criteria) this;
        }

        public Criteria andTask_typeNotEqualTo(String value) {
            addCriterion("task_type <>", value, "task_type");
            return (Criteria) this;
        }

        public Criteria andTask_typeGreaterThan(String value) {
            addCriterion("task_type >", value, "task_type");
            return (Criteria) this;
        }

        public Criteria andTask_typeGreaterThanOrEqualTo(String value) {
            addCriterion("task_type >=", value, "task_type");
            return (Criteria) this;
        }

        public Criteria andTask_typeLessThan(String value) {
            addCriterion("task_type <", value, "task_type");
            return (Criteria) this;
        }

        public Criteria andTask_typeLessThanOrEqualTo(String value) {
            addCriterion("task_type <=", value, "task_type");
            return (Criteria) this;
        }

        public Criteria andTask_typeLike(String value) {
            addCriterion("task_type like", value, "task_type");
            return (Criteria) this;
        }

        public Criteria andTask_typeNotLike(String value) {
            addCriterion("task_type not like", value, "task_type");
            return (Criteria) this;
        }

        public Criteria andTask_typeIn(List<String> values) {
            addCriterion("task_type in", values, "task_type");
            return (Criteria) this;
        }

        public Criteria andTask_typeNotIn(List<String> values) {
            addCriterion("task_type not in", values, "task_type");
            return (Criteria) this;
        }

        public Criteria andTask_typeBetween(String value1, String value2) {
            addCriterion("task_type between", value1, value2, "task_type");
            return (Criteria) this;
        }

        public Criteria andTask_typeNotBetween(String value1, String value2) {
            addCriterion("task_type not between", value1, value2, "task_type");
            return (Criteria) this;
        }

        public Criteria andTask_type_remarksIsNull() {
            addCriterion("task_type_remarks is null");
            return (Criteria) this;
        }

        public Criteria andTask_type_remarksIsNotNull() {
            addCriterion("task_type_remarks is not null");
            return (Criteria) this;
        }

        public Criteria andTask_type_remarksEqualTo(String value) {
            addCriterion("task_type_remarks =", value, "task_type_remarks");
            return (Criteria) this;
        }

        public Criteria andTask_type_remarksNotEqualTo(String value) {
            addCriterion("task_type_remarks <>", value, "task_type_remarks");
            return (Criteria) this;
        }

        public Criteria andTask_type_remarksGreaterThan(String value) {
            addCriterion("task_type_remarks >", value, "task_type_remarks");
            return (Criteria) this;
        }

        public Criteria andTask_type_remarksGreaterThanOrEqualTo(String value) {
            addCriterion("task_type_remarks >=", value, "task_type_remarks");
            return (Criteria) this;
        }

        public Criteria andTask_type_remarksLessThan(String value) {
            addCriterion("task_type_remarks <", value, "task_type_remarks");
            return (Criteria) this;
        }

        public Criteria andTask_type_remarksLessThanOrEqualTo(String value) {
            addCriterion("task_type_remarks <=", value, "task_type_remarks");
            return (Criteria) this;
        }

        public Criteria andTask_type_remarksLike(String value) {
            addCriterion("task_type_remarks like", value, "task_type_remarks");
            return (Criteria) this;
        }

        public Criteria andTask_type_remarksNotLike(String value) {
            addCriterion("task_type_remarks not like", value, "task_type_remarks");
            return (Criteria) this;
        }

        public Criteria andTask_type_remarksIn(List<String> values) {
            addCriterion("task_type_remarks in", values, "task_type_remarks");
            return (Criteria) this;
        }

        public Criteria andTask_type_remarksNotIn(List<String> values) {
            addCriterion("task_type_remarks not in", values, "task_type_remarks");
            return (Criteria) this;
        }

        public Criteria andTask_type_remarksBetween(String value1, String value2) {
            addCriterion("task_type_remarks between", value1, value2, "task_type_remarks");
            return (Criteria) this;
        }

        public Criteria andTask_type_remarksNotBetween(String value1, String value2) {
            addCriterion("task_type_remarks not between", value1, value2, "task_type_remarks");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeEqualTo(Date value) {
            addCriterion("create_time =", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThan(Date value) {
            addCriterion("create_time >", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThan(Date value) {
            addCriterion("create_time <", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIn(List<Date> values) {
            addCriterion("create_time in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNull() {
            addCriterion("creater is null");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNotNull() {
            addCriterion("creater is not null");
            return (Criteria) this;
        }

        public Criteria andCreaterEqualTo(Integer value) {
            addCriterion("creater =", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotEqualTo(Integer value) {
            addCriterion("creater <>", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThan(Integer value) {
            addCriterion("creater >", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThanOrEqualTo(Integer value) {
            addCriterion("creater >=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThan(Integer value) {
            addCriterion("creater <", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThanOrEqualTo(Integer value) {
            addCriterion("creater <=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterIn(List<Integer> values) {
            addCriterion("creater in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotIn(List<Integer> values) {
            addCriterion("creater not in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterBetween(Integer value1, Integer value2) {
            addCriterion("creater between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotBetween(Integer value1, Integer value2) {
            addCriterion("creater not between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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