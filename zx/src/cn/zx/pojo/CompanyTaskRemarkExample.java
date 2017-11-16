package cn.zx.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompanyTaskRemarkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompanyTaskRemarkExample() {
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

        public Criteria andTask_idIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTask_idIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTask_idEqualTo(Integer value) {
            addCriterion("task_id =", value, "task_id");
            return (Criteria) this;
        }

        public Criteria andTask_idNotEqualTo(Integer value) {
            addCriterion("task_id <>", value, "task_id");
            return (Criteria) this;
        }

        public Criteria andTask_idGreaterThan(Integer value) {
            addCriterion("task_id >", value, "task_id");
            return (Criteria) this;
        }

        public Criteria andTask_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_id >=", value, "task_id");
            return (Criteria) this;
        }

        public Criteria andTask_idLessThan(Integer value) {
            addCriterion("task_id <", value, "task_id");
            return (Criteria) this;
        }

        public Criteria andTask_idLessThanOrEqualTo(Integer value) {
            addCriterion("task_id <=", value, "task_id");
            return (Criteria) this;
        }

        public Criteria andTask_idIn(List<Integer> values) {
            addCriterion("task_id in", values, "task_id");
            return (Criteria) this;
        }

        public Criteria andTask_idNotIn(List<Integer> values) {
            addCriterion("task_id not in", values, "task_id");
            return (Criteria) this;
        }

        public Criteria andTask_idBetween(Integer value1, Integer value2) {
            addCriterion("task_id between", value1, value2, "task_id");
            return (Criteria) this;
        }

        public Criteria andTask_idNotBetween(Integer value1, Integer value2) {
            addCriterion("task_id not between", value1, value2, "task_id");
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

        public Criteria andUser_idIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUser_idIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUser_idEqualTo(Integer value) {
            addCriterion("user_id =", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThan(Integer value) {
            addCriterion("user_id >", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThan(Integer value) {
            addCriterion("user_id <", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idIn(List<Integer> values) {
            addCriterion("user_id in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andTask_ratioIsNull() {
            addCriterion("task_ratio is null");
            return (Criteria) this;
        }

        public Criteria andTask_ratioIsNotNull() {
            addCriterion("task_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andTask_ratioEqualTo(Integer value) {
            addCriterion("task_ratio =", value, "task_ratio");
            return (Criteria) this;
        }

        public Criteria andTask_ratioNotEqualTo(Integer value) {
            addCriterion("task_ratio <>", value, "task_ratio");
            return (Criteria) this;
        }

        public Criteria andTask_ratioGreaterThan(Integer value) {
            addCriterion("task_ratio >", value, "task_ratio");
            return (Criteria) this;
        }

        public Criteria andTask_ratioGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_ratio >=", value, "task_ratio");
            return (Criteria) this;
        }

        public Criteria andTask_ratioLessThan(Integer value) {
            addCriterion("task_ratio <", value, "task_ratio");
            return (Criteria) this;
        }

        public Criteria andTask_ratioLessThanOrEqualTo(Integer value) {
            addCriterion("task_ratio <=", value, "task_ratio");
            return (Criteria) this;
        }

        public Criteria andTask_ratioIn(List<Integer> values) {
            addCriterion("task_ratio in", values, "task_ratio");
            return (Criteria) this;
        }

        public Criteria andTask_ratioNotIn(List<Integer> values) {
            addCriterion("task_ratio not in", values, "task_ratio");
            return (Criteria) this;
        }

        public Criteria andTask_ratioBetween(Integer value1, Integer value2) {
            addCriterion("task_ratio between", value1, value2, "task_ratio");
            return (Criteria) this;
        }

        public Criteria andTask_ratioNotBetween(Integer value1, Integer value2) {
            addCriterion("task_ratio not between", value1, value2, "task_ratio");
            return (Criteria) this;
        }

        public Criteria andTask_qualityIsNull() {
            addCriterion("task_quality is null");
            return (Criteria) this;
        }

        public Criteria andTask_qualityIsNotNull() {
            addCriterion("task_quality is not null");
            return (Criteria) this;
        }

        public Criteria andTask_qualityEqualTo(Integer value) {
            addCriterion("task_quality =", value, "task_quality");
            return (Criteria) this;
        }

        public Criteria andTask_qualityNotEqualTo(Integer value) {
            addCriterion("task_quality <>", value, "task_quality");
            return (Criteria) this;
        }

        public Criteria andTask_qualityGreaterThan(Integer value) {
            addCriterion("task_quality >", value, "task_quality");
            return (Criteria) this;
        }

        public Criteria andTask_qualityGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_quality >=", value, "task_quality");
            return (Criteria) this;
        }

        public Criteria andTask_qualityLessThan(Integer value) {
            addCriterion("task_quality <", value, "task_quality");
            return (Criteria) this;
        }

        public Criteria andTask_qualityLessThanOrEqualTo(Integer value) {
            addCriterion("task_quality <=", value, "task_quality");
            return (Criteria) this;
        }

        public Criteria andTask_qualityIn(List<Integer> values) {
            addCriterion("task_quality in", values, "task_quality");
            return (Criteria) this;
        }

        public Criteria andTask_qualityNotIn(List<Integer> values) {
            addCriterion("task_quality not in", values, "task_quality");
            return (Criteria) this;
        }

        public Criteria andTask_qualityBetween(Integer value1, Integer value2) {
            addCriterion("task_quality between", value1, value2, "task_quality");
            return (Criteria) this;
        }

        public Criteria andTask_qualityNotBetween(Integer value1, Integer value2) {
            addCriterion("task_quality not between", value1, value2, "task_quality");
            return (Criteria) this;
        }

        public Criteria andTask_remarkIsNull() {
            addCriterion("task_remark is null");
            return (Criteria) this;
        }

        public Criteria andTask_remarkIsNotNull() {
            addCriterion("task_remark is not null");
            return (Criteria) this;
        }

        public Criteria andTask_remarkEqualTo(String value) {
            addCriterion("task_remark =", value, "task_remark");
            return (Criteria) this;
        }

        public Criteria andTask_remarkNotEqualTo(String value) {
            addCriterion("task_remark <>", value, "task_remark");
            return (Criteria) this;
        }

        public Criteria andTask_remarkGreaterThan(String value) {
            addCriterion("task_remark >", value, "task_remark");
            return (Criteria) this;
        }

        public Criteria andTask_remarkGreaterThanOrEqualTo(String value) {
            addCriterion("task_remark >=", value, "task_remark");
            return (Criteria) this;
        }

        public Criteria andTask_remarkLessThan(String value) {
            addCriterion("task_remark <", value, "task_remark");
            return (Criteria) this;
        }

        public Criteria andTask_remarkLessThanOrEqualTo(String value) {
            addCriterion("task_remark <=", value, "task_remark");
            return (Criteria) this;
        }

        public Criteria andTask_remarkLike(String value) {
            addCriterion("task_remark like", value, "task_remark");
            return (Criteria) this;
        }

        public Criteria andTask_remarkNotLike(String value) {
            addCriterion("task_remark not like", value, "task_remark");
            return (Criteria) this;
        }

        public Criteria andTask_remarkIn(List<String> values) {
            addCriterion("task_remark in", values, "task_remark");
            return (Criteria) this;
        }

        public Criteria andTask_remarkNotIn(List<String> values) {
            addCriterion("task_remark not in", values, "task_remark");
            return (Criteria) this;
        }

        public Criteria andTask_remarkBetween(String value1, String value2) {
            addCriterion("task_remark between", value1, value2, "task_remark");
            return (Criteria) this;
        }

        public Criteria andTask_remarkNotBetween(String value1, String value2) {
            addCriterion("task_remark not between", value1, value2, "task_remark");
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