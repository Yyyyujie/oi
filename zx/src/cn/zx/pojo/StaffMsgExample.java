package cn.zx.pojo;

import java.util.ArrayList;
import java.util.List;

public class StaffMsgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StaffMsgExample() {
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

        public Criteria andS_m_idIsNull() {
            addCriterion("s_m_id is null");
            return (Criteria) this;
        }

        public Criteria andS_m_idIsNotNull() {
            addCriterion("s_m_id is not null");
            return (Criteria) this;
        }

        public Criteria andS_m_idEqualTo(Integer value) {
            addCriterion("s_m_id =", value, "s_m_id");
            return (Criteria) this;
        }

        public Criteria andS_m_idNotEqualTo(Integer value) {
            addCriterion("s_m_id <>", value, "s_m_id");
            return (Criteria) this;
        }

        public Criteria andS_m_idGreaterThan(Integer value) {
            addCriterion("s_m_id >", value, "s_m_id");
            return (Criteria) this;
        }

        public Criteria andS_m_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("s_m_id >=", value, "s_m_id");
            return (Criteria) this;
        }

        public Criteria andS_m_idLessThan(Integer value) {
            addCriterion("s_m_id <", value, "s_m_id");
            return (Criteria) this;
        }

        public Criteria andS_m_idLessThanOrEqualTo(Integer value) {
            addCriterion("s_m_id <=", value, "s_m_id");
            return (Criteria) this;
        }

        public Criteria andS_m_idIn(List<Integer> values) {
            addCriterion("s_m_id in", values, "s_m_id");
            return (Criteria) this;
        }

        public Criteria andS_m_idNotIn(List<Integer> values) {
            addCriterion("s_m_id not in", values, "s_m_id");
            return (Criteria) this;
        }

        public Criteria andS_m_idBetween(Integer value1, Integer value2) {
            addCriterion("s_m_id between", value1, value2, "s_m_id");
            return (Criteria) this;
        }

        public Criteria andS_m_idNotBetween(Integer value1, Integer value2) {
            addCriterion("s_m_id not between", value1, value2, "s_m_id");
            return (Criteria) this;
        }

        public Criteria andUse_idIsNull() {
            addCriterion("use_id is null");
            return (Criteria) this;
        }

        public Criteria andUse_idIsNotNull() {
            addCriterion("use_id is not null");
            return (Criteria) this;
        }

        public Criteria andUse_idEqualTo(Integer value) {
            addCriterion("use_id =", value, "use_id");
            return (Criteria) this;
        }

        public Criteria andUse_idNotEqualTo(Integer value) {
            addCriterion("use_id <>", value, "use_id");
            return (Criteria) this;
        }

        public Criteria andUse_idGreaterThan(Integer value) {
            addCriterion("use_id >", value, "use_id");
            return (Criteria) this;
        }

        public Criteria andUse_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("use_id >=", value, "use_id");
            return (Criteria) this;
        }

        public Criteria andUse_idLessThan(Integer value) {
            addCriterion("use_id <", value, "use_id");
            return (Criteria) this;
        }

        public Criteria andUse_idLessThanOrEqualTo(Integer value) {
            addCriterion("use_id <=", value, "use_id");
            return (Criteria) this;
        }

        public Criteria andUse_idIn(List<Integer> values) {
            addCriterion("use_id in", values, "use_id");
            return (Criteria) this;
        }

        public Criteria andUse_idNotIn(List<Integer> values) {
            addCriterion("use_id not in", values, "use_id");
            return (Criteria) this;
        }

        public Criteria andUse_idBetween(Integer value1, Integer value2) {
            addCriterion("use_id between", value1, value2, "use_id");
            return (Criteria) this;
        }

        public Criteria andUse_idNotBetween(Integer value1, Integer value2) {
            addCriterion("use_id not between", value1, value2, "use_id");
            return (Criteria) this;
        }

        public Criteria andUse_msgIsNull() {
            addCriterion("use_msg is null");
            return (Criteria) this;
        }

        public Criteria andUse_msgIsNotNull() {
            addCriterion("use_msg is not null");
            return (Criteria) this;
        }

        public Criteria andUse_msgEqualTo(Integer value) {
            addCriterion("use_msg =", value, "use_msg");
            return (Criteria) this;
        }

        public Criteria andUse_msgNotEqualTo(Integer value) {
            addCriterion("use_msg <>", value, "use_msg");
            return (Criteria) this;
        }

        public Criteria andUse_msgGreaterThan(Integer value) {
            addCriterion("use_msg >", value, "use_msg");
            return (Criteria) this;
        }

        public Criteria andUse_msgGreaterThanOrEqualTo(Integer value) {
            addCriterion("use_msg >=", value, "use_msg");
            return (Criteria) this;
        }

        public Criteria andUse_msgLessThan(Integer value) {
            addCriterion("use_msg <", value, "use_msg");
            return (Criteria) this;
        }

        public Criteria andUse_msgLessThanOrEqualTo(Integer value) {
            addCriterion("use_msg <=", value, "use_msg");
            return (Criteria) this;
        }

        public Criteria andUse_msgIn(List<Integer> values) {
            addCriterion("use_msg in", values, "use_msg");
            return (Criteria) this;
        }

        public Criteria andUse_msgNotIn(List<Integer> values) {
            addCriterion("use_msg not in", values, "use_msg");
            return (Criteria) this;
        }

        public Criteria andUse_msgBetween(Integer value1, Integer value2) {
            addCriterion("use_msg between", value1, value2, "use_msg");
            return (Criteria) this;
        }

        public Criteria andUse_msgNotBetween(Integer value1, Integer value2) {
            addCriterion("use_msg not between", value1, value2, "use_msg");
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