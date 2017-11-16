package cn.zx.pojo;

import java.util.ArrayList;
import java.util.List;

public class StaffTaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StaffTaskExample() {
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

        public Criteria andS_t_idIsNull() {
            addCriterion("s_t_id is null");
            return (Criteria) this;
        }

        public Criteria andS_t_idIsNotNull() {
            addCriterion("s_t_id is not null");
            return (Criteria) this;
        }

        public Criteria andS_t_idEqualTo(Integer value) {
            addCriterion("s_t_id =", value, "s_t_id");
            return (Criteria) this;
        }

        public Criteria andS_t_idNotEqualTo(Integer value) {
            addCriterion("s_t_id <>", value, "s_t_id");
            return (Criteria) this;
        }

        public Criteria andS_t_idGreaterThan(Integer value) {
            addCriterion("s_t_id >", value, "s_t_id");
            return (Criteria) this;
        }

        public Criteria andS_t_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("s_t_id >=", value, "s_t_id");
            return (Criteria) this;
        }

        public Criteria andS_t_idLessThan(Integer value) {
            addCriterion("s_t_id <", value, "s_t_id");
            return (Criteria) this;
        }

        public Criteria andS_t_idLessThanOrEqualTo(Integer value) {
            addCriterion("s_t_id <=", value, "s_t_id");
            return (Criteria) this;
        }

        public Criteria andS_t_idIn(List<Integer> values) {
            addCriterion("s_t_id in", values, "s_t_id");
            return (Criteria) this;
        }

        public Criteria andS_t_idNotIn(List<Integer> values) {
            addCriterion("s_t_id not in", values, "s_t_id");
            return (Criteria) this;
        }

        public Criteria andS_t_idBetween(Integer value1, Integer value2) {
            addCriterion("s_t_id between", value1, value2, "s_t_id");
            return (Criteria) this;
        }

        public Criteria andS_t_idNotBetween(Integer value1, Integer value2) {
            addCriterion("s_t_id not between", value1, value2, "s_t_id");
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

        public Criteria andTask_titleIsNull() {
            addCriterion("task_title is null");
            return (Criteria) this;
        }

        public Criteria andTask_titleIsNotNull() {
            addCriterion("task_title is not null");
            return (Criteria) this;
        }

        public Criteria andTask_titleEqualTo(String value) {
            addCriterion("task_title =", value, "task_title");
            return (Criteria) this;
        }

        public Criteria andTask_titleNotEqualTo(String value) {
            addCriterion("task_title <>", value, "task_title");
            return (Criteria) this;
        }

        public Criteria andTask_titleGreaterThan(String value) {
            addCriterion("task_title >", value, "task_title");
            return (Criteria) this;
        }

        public Criteria andTask_titleGreaterThanOrEqualTo(String value) {
            addCriterion("task_title >=", value, "task_title");
            return (Criteria) this;
        }

        public Criteria andTask_titleLessThan(String value) {
            addCriterion("task_title <", value, "task_title");
            return (Criteria) this;
        }

        public Criteria andTask_titleLessThanOrEqualTo(String value) {
            addCriterion("task_title <=", value, "task_title");
            return (Criteria) this;
        }

        public Criteria andTask_titleLike(String value) {
            addCriterion("task_title like", value, "task_title");
            return (Criteria) this;
        }

        public Criteria andTask_titleNotLike(String value) {
            addCriterion("task_title not like", value, "task_title");
            return (Criteria) this;
        }

        public Criteria andTask_titleIn(List<String> values) {
            addCriterion("task_title in", values, "task_title");
            return (Criteria) this;
        }

        public Criteria andTask_titleNotIn(List<String> values) {
            addCriterion("task_title not in", values, "task_title");
            return (Criteria) this;
        }

        public Criteria andTask_titleBetween(String value1, String value2) {
            addCriterion("task_title between", value1, value2, "task_title");
            return (Criteria) this;
        }

        public Criteria andTask_titleNotBetween(String value1, String value2) {
            addCriterion("task_title not between", value1, value2, "task_title");
            return (Criteria) this;
        }

        public Criteria andUse_taskIsNull() {
            addCriterion("use_task is null");
            return (Criteria) this;
        }

        public Criteria andUse_taskIsNotNull() {
            addCriterion("use_task is not null");
            return (Criteria) this;
        }

        public Criteria andUse_taskEqualTo(String value) {
            addCriterion("use_task =", value, "use_task");
            return (Criteria) this;
        }

        public Criteria andUse_taskNotEqualTo(String value) {
            addCriterion("use_task <>", value, "use_task");
            return (Criteria) this;
        }

        public Criteria andUse_taskGreaterThan(String value) {
            addCriterion("use_task >", value, "use_task");
            return (Criteria) this;
        }

        public Criteria andUse_taskGreaterThanOrEqualTo(String value) {
            addCriterion("use_task >=", value, "use_task");
            return (Criteria) this;
        }

        public Criteria andUse_taskLessThan(String value) {
            addCriterion("use_task <", value, "use_task");
            return (Criteria) this;
        }

        public Criteria andUse_taskLessThanOrEqualTo(String value) {
            addCriterion("use_task <=", value, "use_task");
            return (Criteria) this;
        }

        public Criteria andUse_taskLike(String value) {
            addCriterion("use_task like", value, "use_task");
            return (Criteria) this;
        }

        public Criteria andUse_taskNotLike(String value) {
            addCriterion("use_task not like", value, "use_task");
            return (Criteria) this;
        }

        public Criteria andUse_taskIn(List<String> values) {
            addCriterion("use_task in", values, "use_task");
            return (Criteria) this;
        }

        public Criteria andUse_taskNotIn(List<String> values) {
            addCriterion("use_task not in", values, "use_task");
            return (Criteria) this;
        }

        public Criteria andUse_taskBetween(String value1, String value2) {
            addCriterion("use_task between", value1, value2, "use_task");
            return (Criteria) this;
        }

        public Criteria andUse_taskNotBetween(String value1, String value2) {
            addCriterion("use_task not between", value1, value2, "use_task");
            return (Criteria) this;
        }

        public Criteria andTask_statusIsNull() {
            addCriterion("task_status is null");
            return (Criteria) this;
        }

        public Criteria andTask_statusIsNotNull() {
            addCriterion("task_status is not null");
            return (Criteria) this;
        }

        public Criteria andTask_statusEqualTo(Integer value) {
            addCriterion("task_status =", value, "task_status");
            return (Criteria) this;
        }

        public Criteria andTask_statusNotEqualTo(Integer value) {
            addCriterion("task_status <>", value, "task_status");
            return (Criteria) this;
        }

        public Criteria andTask_statusGreaterThan(Integer value) {
            addCriterion("task_status >", value, "task_status");
            return (Criteria) this;
        }

        public Criteria andTask_statusGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_status >=", value, "task_status");
            return (Criteria) this;
        }

        public Criteria andTask_statusLessThan(Integer value) {
            addCriterion("task_status <", value, "task_status");
            return (Criteria) this;
        }

        public Criteria andTask_statusLessThanOrEqualTo(Integer value) {
            addCriterion("task_status <=", value, "task_status");
            return (Criteria) this;
        }

        public Criteria andTask_statusIn(List<Integer> values) {
            addCriterion("task_status in", values, "task_status");
            return (Criteria) this;
        }

        public Criteria andTask_statusNotIn(List<Integer> values) {
            addCriterion("task_status not in", values, "task_status");
            return (Criteria) this;
        }

        public Criteria andTask_statusBetween(Integer value1, Integer value2) {
            addCriterion("task_status between", value1, value2, "task_status");
            return (Criteria) this;
        }

        public Criteria andTask_statusNotBetween(Integer value1, Integer value2) {
            addCriterion("task_status not between", value1, value2, "task_status");
            return (Criteria) this;
        }

        public Criteria andTask_pointIsNull() {
            addCriterion("task_point is null");
            return (Criteria) this;
        }

        public Criteria andTask_pointIsNotNull() {
            addCriterion("task_point is not null");
            return (Criteria) this;
        }

        public Criteria andTask_pointEqualTo(Integer value) {
            addCriterion("task_point =", value, "task_point");
            return (Criteria) this;
        }

        public Criteria andTask_pointNotEqualTo(Integer value) {
            addCriterion("task_point <>", value, "task_point");
            return (Criteria) this;
        }

        public Criteria andTask_pointGreaterThan(Integer value) {
            addCriterion("task_point >", value, "task_point");
            return (Criteria) this;
        }

        public Criteria andTask_pointGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_point >=", value, "task_point");
            return (Criteria) this;
        }

        public Criteria andTask_pointLessThan(Integer value) {
            addCriterion("task_point <", value, "task_point");
            return (Criteria) this;
        }

        public Criteria andTask_pointLessThanOrEqualTo(Integer value) {
            addCriterion("task_point <=", value, "task_point");
            return (Criteria) this;
        }

        public Criteria andTask_pointIn(List<Integer> values) {
            addCriterion("task_point in", values, "task_point");
            return (Criteria) this;
        }

        public Criteria andTask_pointNotIn(List<Integer> values) {
            addCriterion("task_point not in", values, "task_point");
            return (Criteria) this;
        }

        public Criteria andTask_pointBetween(Integer value1, Integer value2) {
            addCriterion("task_point between", value1, value2, "task_point");
            return (Criteria) this;
        }

        public Criteria andTask_pointNotBetween(Integer value1, Integer value2) {
            addCriterion("task_point not between", value1, value2, "task_point");
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