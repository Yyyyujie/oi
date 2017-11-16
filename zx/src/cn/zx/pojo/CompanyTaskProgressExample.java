package cn.zx.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompanyTaskProgressExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompanyTaskProgressExample() {
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

        public Criteria andPro_idIsNull() {
            addCriterion("pro_id is null");
            return (Criteria) this;
        }

        public Criteria andPro_idIsNotNull() {
            addCriterion("pro_id is not null");
            return (Criteria) this;
        }

        public Criteria andPro_idEqualTo(Integer value) {
            addCriterion("pro_id =", value, "pro_id");
            return (Criteria) this;
        }

        public Criteria andPro_idNotEqualTo(Integer value) {
            addCriterion("pro_id <>", value, "pro_id");
            return (Criteria) this;
        }

        public Criteria andPro_idGreaterThan(Integer value) {
            addCriterion("pro_id >", value, "pro_id");
            return (Criteria) this;
        }

        public Criteria andPro_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("pro_id >=", value, "pro_id");
            return (Criteria) this;
        }

        public Criteria andPro_idLessThan(Integer value) {
            addCriterion("pro_id <", value, "pro_id");
            return (Criteria) this;
        }

        public Criteria andPro_idLessThanOrEqualTo(Integer value) {
            addCriterion("pro_id <=", value, "pro_id");
            return (Criteria) this;
        }

        public Criteria andPro_idIn(List<Integer> values) {
            addCriterion("pro_id in", values, "pro_id");
            return (Criteria) this;
        }

        public Criteria andPro_idNotIn(List<Integer> values) {
            addCriterion("pro_id not in", values, "pro_id");
            return (Criteria) this;
        }

        public Criteria andPro_idBetween(Integer value1, Integer value2) {
            addCriterion("pro_id between", value1, value2, "pro_id");
            return (Criteria) this;
        }

        public Criteria andPro_idNotBetween(Integer value1, Integer value2) {
            addCriterion("pro_id not between", value1, value2, "pro_id");
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

        public Criteria andTask_textIsNull() {
            addCriterion("task_text is null");
            return (Criteria) this;
        }

        public Criteria andTask_textIsNotNull() {
            addCriterion("task_text is not null");
            return (Criteria) this;
        }

        public Criteria andTask_textEqualTo(String value) {
            addCriterion("task_text =", value, "task_text");
            return (Criteria) this;
        }

        public Criteria andTask_textNotEqualTo(String value) {
            addCriterion("task_text <>", value, "task_text");
            return (Criteria) this;
        }

        public Criteria andTask_textGreaterThan(String value) {
            addCriterion("task_text >", value, "task_text");
            return (Criteria) this;
        }

        public Criteria andTask_textGreaterThanOrEqualTo(String value) {
            addCriterion("task_text >=", value, "task_text");
            return (Criteria) this;
        }

        public Criteria andTask_textLessThan(String value) {
            addCriterion("task_text <", value, "task_text");
            return (Criteria) this;
        }

        public Criteria andTask_textLessThanOrEqualTo(String value) {
            addCriterion("task_text <=", value, "task_text");
            return (Criteria) this;
        }

        public Criteria andTask_textLike(String value) {
            addCriterion("task_text like", value, "task_text");
            return (Criteria) this;
        }

        public Criteria andTask_textNotLike(String value) {
            addCriterion("task_text not like", value, "task_text");
            return (Criteria) this;
        }

        public Criteria andTask_textIn(List<String> values) {
            addCriterion("task_text in", values, "task_text");
            return (Criteria) this;
        }

        public Criteria andTask_textNotIn(List<String> values) {
            addCriterion("task_text not in", values, "task_text");
            return (Criteria) this;
        }

        public Criteria andTask_textBetween(String value1, String value2) {
            addCriterion("task_text between", value1, value2, "task_text");
            return (Criteria) this;
        }

        public Criteria andTask_textNotBetween(String value1, String value2) {
            addCriterion("task_text not between", value1, value2, "task_text");
            return (Criteria) this;
        }

        public Criteria andTask_stafferIsNull() {
            addCriterion("task_staffer is null");
            return (Criteria) this;
        }

        public Criteria andTask_stafferIsNotNull() {
            addCriterion("task_staffer is not null");
            return (Criteria) this;
        }

        public Criteria andTask_stafferEqualTo(String value) {
            addCriterion("task_staffer =", value, "task_staffer");
            return (Criteria) this;
        }

        public Criteria andTask_stafferNotEqualTo(String value) {
            addCriterion("task_staffer <>", value, "task_staffer");
            return (Criteria) this;
        }

        public Criteria andTask_stafferGreaterThan(String value) {
            addCriterion("task_staffer >", value, "task_staffer");
            return (Criteria) this;
        }

        public Criteria andTask_stafferGreaterThanOrEqualTo(String value) {
            addCriterion("task_staffer >=", value, "task_staffer");
            return (Criteria) this;
        }

        public Criteria andTask_stafferLessThan(String value) {
            addCriterion("task_staffer <", value, "task_staffer");
            return (Criteria) this;
        }

        public Criteria andTask_stafferLessThanOrEqualTo(String value) {
            addCriterion("task_staffer <=", value, "task_staffer");
            return (Criteria) this;
        }

        public Criteria andTask_stafferLike(String value) {
            addCriterion("task_staffer like", value, "task_staffer");
            return (Criteria) this;
        }

        public Criteria andTask_stafferNotLike(String value) {
            addCriterion("task_staffer not like", value, "task_staffer");
            return (Criteria) this;
        }

        public Criteria andTask_stafferIn(List<String> values) {
            addCriterion("task_staffer in", values, "task_staffer");
            return (Criteria) this;
        }

        public Criteria andTask_stafferNotIn(List<String> values) {
            addCriterion("task_staffer not in", values, "task_staffer");
            return (Criteria) this;
        }

        public Criteria andTask_stafferBetween(String value1, String value2) {
            addCriterion("task_staffer between", value1, value2, "task_staffer");
            return (Criteria) this;
        }

        public Criteria andTask_stafferNotBetween(String value1, String value2) {
            addCriterion("task_staffer not between", value1, value2, "task_staffer");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeEqualTo(Date value) {
            addCriterion("update_time =", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeGreaterThan(Date value) {
            addCriterion("update_time >", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeLessThan(Date value) {
            addCriterion("update_time <", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIn(List<Date> values) {
            addCriterion("update_time in", values, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "update_time");
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