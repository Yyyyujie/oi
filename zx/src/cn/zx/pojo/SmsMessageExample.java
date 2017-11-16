package cn.zx.pojo;

import java.util.ArrayList;
import java.util.List;

public class SmsMessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SmsMessageExample() {
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

        public Criteria andMsg_idIsNull() {
            addCriterion("msg_id is null");
            return (Criteria) this;
        }

        public Criteria andMsg_idIsNotNull() {
            addCriterion("msg_id is not null");
            return (Criteria) this;
        }

        public Criteria andMsg_idEqualTo(Integer value) {
            addCriterion("msg_id =", value, "msg_id");
            return (Criteria) this;
        }

        public Criteria andMsg_idNotEqualTo(Integer value) {
            addCriterion("msg_id <>", value, "msg_id");
            return (Criteria) this;
        }

        public Criteria andMsg_idGreaterThan(Integer value) {
            addCriterion("msg_id >", value, "msg_id");
            return (Criteria) this;
        }

        public Criteria andMsg_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("msg_id >=", value, "msg_id");
            return (Criteria) this;
        }

        public Criteria andMsg_idLessThan(Integer value) {
            addCriterion("msg_id <", value, "msg_id");
            return (Criteria) this;
        }

        public Criteria andMsg_idLessThanOrEqualTo(Integer value) {
            addCriterion("msg_id <=", value, "msg_id");
            return (Criteria) this;
        }

        public Criteria andMsg_idIn(List<Integer> values) {
            addCriterion("msg_id in", values, "msg_id");
            return (Criteria) this;
        }

        public Criteria andMsg_idNotIn(List<Integer> values) {
            addCriterion("msg_id not in", values, "msg_id");
            return (Criteria) this;
        }

        public Criteria andMsg_idBetween(Integer value1, Integer value2) {
            addCriterion("msg_id between", value1, value2, "msg_id");
            return (Criteria) this;
        }

        public Criteria andMsg_idNotBetween(Integer value1, Integer value2) {
            addCriterion("msg_id not between", value1, value2, "msg_id");
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

        public Criteria andUidEqualTo(String value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(String value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(String value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(String value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(String value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(String value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLike(String value) {
            addCriterion("uid like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotLike(String value) {
            addCriterion("uid not like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<String> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<String> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(String value1, String value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(String value1, String value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andKeyIsNull() {
            addCriterion("key is null");
            return (Criteria) this;
        }

        public Criteria andKeyIsNotNull() {
            addCriterion("key is not null");
            return (Criteria) this;
        }

        public Criteria andKeyEqualTo(String value) {
            addCriterion("key =", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotEqualTo(String value) {
            addCriterion("key <>", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyGreaterThan(String value) {
            addCriterion("key >", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyGreaterThanOrEqualTo(String value) {
            addCriterion("key >=", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyLessThan(String value) {
            addCriterion("key <", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyLessThanOrEqualTo(String value) {
            addCriterion("key <=", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyLike(String value) {
            addCriterion("key like", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotLike(String value) {
            addCriterion("key not like", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyIn(List<String> values) {
            addCriterion("key in", values, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotIn(List<String> values) {
            addCriterion("key not in", values, "key");
            return (Criteria) this;
        }

        public Criteria andKeyBetween(String value1, String value2) {
            addCriterion("key between", value1, value2, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotBetween(String value1, String value2) {
            addCriterion("key not between", value1, value2, "key");
            return (Criteria) this;
        }

        public Criteria andSmsmobIsNull() {
            addCriterion("smsmob is null");
            return (Criteria) this;
        }

        public Criteria andSmsmobIsNotNull() {
            addCriterion("smsmob is not null");
            return (Criteria) this;
        }

        public Criteria andSmsmobEqualTo(String value) {
            addCriterion("smsmob =", value, "smsmob");
            return (Criteria) this;
        }

        public Criteria andSmsmobNotEqualTo(String value) {
            addCriterion("smsmob <>", value, "smsmob");
            return (Criteria) this;
        }

        public Criteria andSmsmobGreaterThan(String value) {
            addCriterion("smsmob >", value, "smsmob");
            return (Criteria) this;
        }

        public Criteria andSmsmobGreaterThanOrEqualTo(String value) {
            addCriterion("smsmob >=", value, "smsmob");
            return (Criteria) this;
        }

        public Criteria andSmsmobLessThan(String value) {
            addCriterion("smsmob <", value, "smsmob");
            return (Criteria) this;
        }

        public Criteria andSmsmobLessThanOrEqualTo(String value) {
            addCriterion("smsmob <=", value, "smsmob");
            return (Criteria) this;
        }

        public Criteria andSmsmobLike(String value) {
            addCriterion("smsmob like", value, "smsmob");
            return (Criteria) this;
        }

        public Criteria andSmsmobNotLike(String value) {
            addCriterion("smsmob not like", value, "smsmob");
            return (Criteria) this;
        }

        public Criteria andSmsmobIn(List<String> values) {
            addCriterion("smsmob in", values, "smsmob");
            return (Criteria) this;
        }

        public Criteria andSmsmobNotIn(List<String> values) {
            addCriterion("smsmob not in", values, "smsmob");
            return (Criteria) this;
        }

        public Criteria andSmsmobBetween(String value1, String value2) {
            addCriterion("smsmob between", value1, value2, "smsmob");
            return (Criteria) this;
        }

        public Criteria andSmsmobNotBetween(String value1, String value2) {
            addCriterion("smsmob not between", value1, value2, "smsmob");
            return (Criteria) this;
        }

        public Criteria andSmtextIsNull() {
            addCriterion("smtext is null");
            return (Criteria) this;
        }

        public Criteria andSmtextIsNotNull() {
            addCriterion("smtext is not null");
            return (Criteria) this;
        }

        public Criteria andSmtextEqualTo(String value) {
            addCriterion("smtext =", value, "smtext");
            return (Criteria) this;
        }

        public Criteria andSmtextNotEqualTo(String value) {
            addCriterion("smtext <>", value, "smtext");
            return (Criteria) this;
        }

        public Criteria andSmtextGreaterThan(String value) {
            addCriterion("smtext >", value, "smtext");
            return (Criteria) this;
        }

        public Criteria andSmtextGreaterThanOrEqualTo(String value) {
            addCriterion("smtext >=", value, "smtext");
            return (Criteria) this;
        }

        public Criteria andSmtextLessThan(String value) {
            addCriterion("smtext <", value, "smtext");
            return (Criteria) this;
        }

        public Criteria andSmtextLessThanOrEqualTo(String value) {
            addCriterion("smtext <=", value, "smtext");
            return (Criteria) this;
        }

        public Criteria andSmtextLike(String value) {
            addCriterion("smtext like", value, "smtext");
            return (Criteria) this;
        }

        public Criteria andSmtextNotLike(String value) {
            addCriterion("smtext not like", value, "smtext");
            return (Criteria) this;
        }

        public Criteria andSmtextIn(List<String> values) {
            addCriterion("smtext in", values, "smtext");
            return (Criteria) this;
        }

        public Criteria andSmtextNotIn(List<String> values) {
            addCriterion("smtext not in", values, "smtext");
            return (Criteria) this;
        }

        public Criteria andSmtextBetween(String value1, String value2) {
            addCriterion("smtext between", value1, value2, "smtext");
            return (Criteria) this;
        }

        public Criteria andSmtextNotBetween(String value1, String value2) {
            addCriterion("smtext not between", value1, value2, "smtext");
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