package cn.zx.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StaffTaskLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StaffTaskLogExample() {
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

        public Criteria andTask_progressIsNull() {
            addCriterion("task_progress is null");
            return (Criteria) this;
        }

        public Criteria andTask_progressIsNotNull() {
            addCriterion("task_progress is not null");
            return (Criteria) this;
        }

        public Criteria andTask_progressEqualTo(Integer value) {
            addCriterion("task_progress =", value, "task_progress");
            return (Criteria) this;
        }

        public Criteria andTask_progressNotEqualTo(Integer value) {
            addCriterion("task_progress <>", value, "task_progress");
            return (Criteria) this;
        }

        public Criteria andTask_progressGreaterThan(Integer value) {
            addCriterion("task_progress >", value, "task_progress");
            return (Criteria) this;
        }

        public Criteria andTask_progressGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_progress >=", value, "task_progress");
            return (Criteria) this;
        }

        public Criteria andTask_progressLessThan(Integer value) {
            addCriterion("task_progress <", value, "task_progress");
            return (Criteria) this;
        }

        public Criteria andTask_progressLessThanOrEqualTo(Integer value) {
            addCriterion("task_progress <=", value, "task_progress");
            return (Criteria) this;
        }

        public Criteria andTask_progressIn(List<Integer> values) {
            addCriterion("task_progress in", values, "task_progress");
            return (Criteria) this;
        }

        public Criteria andTask_progressNotIn(List<Integer> values) {
            addCriterion("task_progress not in", values, "task_progress");
            return (Criteria) this;
        }

        public Criteria andTask_progressBetween(Integer value1, Integer value2) {
            addCriterion("task_progress between", value1, value2, "task_progress");
            return (Criteria) this;
        }

        public Criteria andTask_progressNotBetween(Integer value1, Integer value2) {
            addCriterion("task_progress not between", value1, value2, "task_progress");
            return (Criteria) this;
        }

        public Criteria andNod_descIsNull() {
            addCriterion("nod_desc is null");
            return (Criteria) this;
        }

        public Criteria andNod_descIsNotNull() {
            addCriterion("nod_desc is not null");
            return (Criteria) this;
        }

        public Criteria andNod_descEqualTo(String value) {
            addCriterion("nod_desc =", value, "nod_desc");
            return (Criteria) this;
        }

        public Criteria andNod_descNotEqualTo(String value) {
            addCriterion("nod_desc <>", value, "nod_desc");
            return (Criteria) this;
        }

        public Criteria andNod_descGreaterThan(String value) {
            addCriterion("nod_desc >", value, "nod_desc");
            return (Criteria) this;
        }

        public Criteria andNod_descGreaterThanOrEqualTo(String value) {
            addCriterion("nod_desc >=", value, "nod_desc");
            return (Criteria) this;
        }

        public Criteria andNod_descLessThan(String value) {
            addCriterion("nod_desc <", value, "nod_desc");
            return (Criteria) this;
        }

        public Criteria andNod_descLessThanOrEqualTo(String value) {
            addCriterion("nod_desc <=", value, "nod_desc");
            return (Criteria) this;
        }

        public Criteria andNod_descLike(String value) {
            addCriterion("nod_desc like", value, "nod_desc");
            return (Criteria) this;
        }

        public Criteria andNod_descNotLike(String value) {
            addCriterion("nod_desc not like", value, "nod_desc");
            return (Criteria) this;
        }

        public Criteria andNod_descIn(List<String> values) {
            addCriterion("nod_desc in", values, "nod_desc");
            return (Criteria) this;
        }

        public Criteria andNod_descNotIn(List<String> values) {
            addCriterion("nod_desc not in", values, "nod_desc");
            return (Criteria) this;
        }

        public Criteria andNod_descBetween(String value1, String value2) {
            addCriterion("nod_desc between", value1, value2, "nod_desc");
            return (Criteria) this;
        }

        public Criteria andNod_descNotBetween(String value1, String value2) {
            addCriterion("nod_desc not between", value1, value2, "nod_desc");
            return (Criteria) this;
        }

        public Criteria andSub_timeIsNull() {
            addCriterion("sub_time is null");
            return (Criteria) this;
        }

        public Criteria andSub_timeIsNotNull() {
            addCriterion("sub_time is not null");
            return (Criteria) this;
        }

        public Criteria andSub_timeEqualTo(Date value) {
            addCriterion("sub_time =", value, "sub_time");
            return (Criteria) this;
        }

        public Criteria andSub_timeNotEqualTo(Date value) {
            addCriterion("sub_time <>", value, "sub_time");
            return (Criteria) this;
        }

        public Criteria andSub_timeGreaterThan(Date value) {
            addCriterion("sub_time >", value, "sub_time");
            return (Criteria) this;
        }

        public Criteria andSub_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("sub_time >=", value, "sub_time");
            return (Criteria) this;
        }

        public Criteria andSub_timeLessThan(Date value) {
            addCriterion("sub_time <", value, "sub_time");
            return (Criteria) this;
        }

        public Criteria andSub_timeLessThanOrEqualTo(Date value) {
            addCriterion("sub_time <=", value, "sub_time");
            return (Criteria) this;
        }

        public Criteria andSub_timeIn(List<Date> values) {
            addCriterion("sub_time in", values, "sub_time");
            return (Criteria) this;
        }

        public Criteria andSub_timeNotIn(List<Date> values) {
            addCriterion("sub_time not in", values, "sub_time");
            return (Criteria) this;
        }

        public Criteria andSub_timeBetween(Date value1, Date value2) {
            addCriterion("sub_time between", value1, value2, "sub_time");
            return (Criteria) this;
        }

        public Criteria andSub_timeNotBetween(Date value1, Date value2) {
            addCriterion("sub_time not between", value1, value2, "sub_time");
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