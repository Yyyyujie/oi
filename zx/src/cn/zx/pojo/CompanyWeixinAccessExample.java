package cn.zx.pojo;

import java.util.ArrayList;
import java.util.List;

public class CompanyWeixinAccessExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompanyWeixinAccessExample() {
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

        public Criteria andAcc_idIsNull() {
            addCriterion("acc_id is null");
            return (Criteria) this;
        }

        public Criteria andAcc_idIsNotNull() {
            addCriterion("acc_id is not null");
            return (Criteria) this;
        }

        public Criteria andAcc_idEqualTo(Integer value) {
            addCriterion("acc_id =", value, "acc_id");
            return (Criteria) this;
        }

        public Criteria andAcc_idNotEqualTo(Integer value) {
            addCriterion("acc_id <>", value, "acc_id");
            return (Criteria) this;
        }

        public Criteria andAcc_idGreaterThan(Integer value) {
            addCriterion("acc_id >", value, "acc_id");
            return (Criteria) this;
        }

        public Criteria andAcc_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("acc_id >=", value, "acc_id");
            return (Criteria) this;
        }

        public Criteria andAcc_idLessThan(Integer value) {
            addCriterion("acc_id <", value, "acc_id");
            return (Criteria) this;
        }

        public Criteria andAcc_idLessThanOrEqualTo(Integer value) {
            addCriterion("acc_id <=", value, "acc_id");
            return (Criteria) this;
        }

        public Criteria andAcc_idIn(List<Integer> values) {
            addCriterion("acc_id in", values, "acc_id");
            return (Criteria) this;
        }

        public Criteria andAcc_idNotIn(List<Integer> values) {
            addCriterion("acc_id not in", values, "acc_id");
            return (Criteria) this;
        }

        public Criteria andAcc_idBetween(Integer value1, Integer value2) {
            addCriterion("acc_id between", value1, value2, "acc_id");
            return (Criteria) this;
        }

        public Criteria andAcc_idNotBetween(Integer value1, Integer value2) {
            addCriterion("acc_id not between", value1, value2, "acc_id");
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

        public Criteria andAccess_tokenIsNull() {
            addCriterion("access_token is null");
            return (Criteria) this;
        }

        public Criteria andAccess_tokenIsNotNull() {
            addCriterion("access_token is not null");
            return (Criteria) this;
        }

        public Criteria andAccess_tokenEqualTo(String value) {
            addCriterion("access_token =", value, "access_token");
            return (Criteria) this;
        }

        public Criteria andAccess_tokenNotEqualTo(String value) {
            addCriterion("access_token <>", value, "access_token");
            return (Criteria) this;
        }

        public Criteria andAccess_tokenGreaterThan(String value) {
            addCriterion("access_token >", value, "access_token");
            return (Criteria) this;
        }

        public Criteria andAccess_tokenGreaterThanOrEqualTo(String value) {
            addCriterion("access_token >=", value, "access_token");
            return (Criteria) this;
        }

        public Criteria andAccess_tokenLessThan(String value) {
            addCriterion("access_token <", value, "access_token");
            return (Criteria) this;
        }

        public Criteria andAccess_tokenLessThanOrEqualTo(String value) {
            addCriterion("access_token <=", value, "access_token");
            return (Criteria) this;
        }

        public Criteria andAccess_tokenLike(String value) {
            addCriterion("access_token like", value, "access_token");
            return (Criteria) this;
        }

        public Criteria andAccess_tokenNotLike(String value) {
            addCriterion("access_token not like", value, "access_token");
            return (Criteria) this;
        }

        public Criteria andAccess_tokenIn(List<String> values) {
            addCriterion("access_token in", values, "access_token");
            return (Criteria) this;
        }

        public Criteria andAccess_tokenNotIn(List<String> values) {
            addCriterion("access_token not in", values, "access_token");
            return (Criteria) this;
        }

        public Criteria andAccess_tokenBetween(String value1, String value2) {
            addCriterion("access_token between", value1, value2, "access_token");
            return (Criteria) this;
        }

        public Criteria andAccess_tokenNotBetween(String value1, String value2) {
            addCriterion("access_token not between", value1, value2, "access_token");
            return (Criteria) this;
        }

        public Criteria andExpir_timeIsNull() {
            addCriterion("expir_time is null");
            return (Criteria) this;
        }

        public Criteria andExpir_timeIsNotNull() {
            addCriterion("expir_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpir_timeEqualTo(Integer value) {
            addCriterion("expir_time =", value, "expir_time");
            return (Criteria) this;
        }

        public Criteria andExpir_timeNotEqualTo(Integer value) {
            addCriterion("expir_time <>", value, "expir_time");
            return (Criteria) this;
        }

        public Criteria andExpir_timeGreaterThan(Integer value) {
            addCriterion("expir_time >", value, "expir_time");
            return (Criteria) this;
        }

        public Criteria andExpir_timeGreaterThanOrEqualTo(Integer value) {
            addCriterion("expir_time >=", value, "expir_time");
            return (Criteria) this;
        }

        public Criteria andExpir_timeLessThan(Integer value) {
            addCriterion("expir_time <", value, "expir_time");
            return (Criteria) this;
        }

        public Criteria andExpir_timeLessThanOrEqualTo(Integer value) {
            addCriterion("expir_time <=", value, "expir_time");
            return (Criteria) this;
        }

        public Criteria andExpir_timeIn(List<Integer> values) {
            addCriterion("expir_time in", values, "expir_time");
            return (Criteria) this;
        }

        public Criteria andExpir_timeNotIn(List<Integer> values) {
            addCriterion("expir_time not in", values, "expir_time");
            return (Criteria) this;
        }

        public Criteria andExpir_timeBetween(Integer value1, Integer value2) {
            addCriterion("expir_time between", value1, value2, "expir_time");
            return (Criteria) this;
        }

        public Criteria andExpir_timeNotBetween(Integer value1, Integer value2) {
            addCriterion("expir_time not between", value1, value2, "expir_time");
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