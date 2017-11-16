package cn.zx.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompanyPromotionMsgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompanyPromotionMsgExample() {
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

        public Criteria andPromotion_msg_idIsNull() {
            addCriterion("promotion_msg_id is null");
            return (Criteria) this;
        }

        public Criteria andPromotion_msg_idIsNotNull() {
            addCriterion("promotion_msg_id is not null");
            return (Criteria) this;
        }

        public Criteria andPromotion_msg_idEqualTo(Integer value) {
            addCriterion("promotion_msg_id =", value, "promotion_msg_id");
            return (Criteria) this;
        }

        public Criteria andPromotion_msg_idNotEqualTo(Integer value) {
            addCriterion("promotion_msg_id <>", value, "promotion_msg_id");
            return (Criteria) this;
        }

        public Criteria andPromotion_msg_idGreaterThan(Integer value) {
            addCriterion("promotion_msg_id >", value, "promotion_msg_id");
            return (Criteria) this;
        }

        public Criteria andPromotion_msg_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("promotion_msg_id >=", value, "promotion_msg_id");
            return (Criteria) this;
        }

        public Criteria andPromotion_msg_idLessThan(Integer value) {
            addCriterion("promotion_msg_id <", value, "promotion_msg_id");
            return (Criteria) this;
        }

        public Criteria andPromotion_msg_idLessThanOrEqualTo(Integer value) {
            addCriterion("promotion_msg_id <=", value, "promotion_msg_id");
            return (Criteria) this;
        }

        public Criteria andPromotion_msg_idIn(List<Integer> values) {
            addCriterion("promotion_msg_id in", values, "promotion_msg_id");
            return (Criteria) this;
        }

        public Criteria andPromotion_msg_idNotIn(List<Integer> values) {
            addCriterion("promotion_msg_id not in", values, "promotion_msg_id");
            return (Criteria) this;
        }

        public Criteria andPromotion_msg_idBetween(Integer value1, Integer value2) {
            addCriterion("promotion_msg_id between", value1, value2, "promotion_msg_id");
            return (Criteria) this;
        }

        public Criteria andPromotion_msg_idNotBetween(Integer value1, Integer value2) {
            addCriterion("promotion_msg_id not between", value1, value2, "promotion_msg_id");
            return (Criteria) this;
        }

        public Criteria andPromotion_idIsNull() {
            addCriterion("promotion_id is null");
            return (Criteria) this;
        }

        public Criteria andPromotion_idIsNotNull() {
            addCriterion("promotion_id is not null");
            return (Criteria) this;
        }

        public Criteria andPromotion_idEqualTo(Integer value) {
            addCriterion("promotion_id =", value, "promotion_id");
            return (Criteria) this;
        }

        public Criteria andPromotion_idNotEqualTo(Integer value) {
            addCriterion("promotion_id <>", value, "promotion_id");
            return (Criteria) this;
        }

        public Criteria andPromotion_idGreaterThan(Integer value) {
            addCriterion("promotion_id >", value, "promotion_id");
            return (Criteria) this;
        }

        public Criteria andPromotion_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("promotion_id >=", value, "promotion_id");
            return (Criteria) this;
        }

        public Criteria andPromotion_idLessThan(Integer value) {
            addCriterion("promotion_id <", value, "promotion_id");
            return (Criteria) this;
        }

        public Criteria andPromotion_idLessThanOrEqualTo(Integer value) {
            addCriterion("promotion_id <=", value, "promotion_id");
            return (Criteria) this;
        }

        public Criteria andPromotion_idIn(List<Integer> values) {
            addCriterion("promotion_id in", values, "promotion_id");
            return (Criteria) this;
        }

        public Criteria andPromotion_idNotIn(List<Integer> values) {
            addCriterion("promotion_id not in", values, "promotion_id");
            return (Criteria) this;
        }

        public Criteria andPromotion_idBetween(Integer value1, Integer value2) {
            addCriterion("promotion_id between", value1, value2, "promotion_id");
            return (Criteria) this;
        }

        public Criteria andPromotion_idNotBetween(Integer value1, Integer value2) {
            addCriterion("promotion_id not between", value1, value2, "promotion_id");
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

        public Criteria andObj_userIsNull() {
            addCriterion("obj_user is null");
            return (Criteria) this;
        }

        public Criteria andObj_userIsNotNull() {
            addCriterion("obj_user is not null");
            return (Criteria) this;
        }

        public Criteria andObj_userEqualTo(Integer value) {
            addCriterion("obj_user =", value, "obj_user");
            return (Criteria) this;
        }

        public Criteria andObj_userNotEqualTo(Integer value) {
            addCriterion("obj_user <>", value, "obj_user");
            return (Criteria) this;
        }

        public Criteria andObj_userGreaterThan(Integer value) {
            addCriterion("obj_user >", value, "obj_user");
            return (Criteria) this;
        }

        public Criteria andObj_userGreaterThanOrEqualTo(Integer value) {
            addCriterion("obj_user >=", value, "obj_user");
            return (Criteria) this;
        }

        public Criteria andObj_userLessThan(Integer value) {
            addCriterion("obj_user <", value, "obj_user");
            return (Criteria) this;
        }

        public Criteria andObj_userLessThanOrEqualTo(Integer value) {
            addCriterion("obj_user <=", value, "obj_user");
            return (Criteria) this;
        }

        public Criteria andObj_userIn(List<Integer> values) {
            addCriterion("obj_user in", values, "obj_user");
            return (Criteria) this;
        }

        public Criteria andObj_userNotIn(List<Integer> values) {
            addCriterion("obj_user not in", values, "obj_user");
            return (Criteria) this;
        }

        public Criteria andObj_userBetween(Integer value1, Integer value2) {
            addCriterion("obj_user between", value1, value2, "obj_user");
            return (Criteria) this;
        }

        public Criteria andObj_userNotBetween(Integer value1, Integer value2) {
            addCriterion("obj_user not between", value1, value2, "obj_user");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andIs_voteIsNull() {
            addCriterion("is_vote is null");
            return (Criteria) this;
        }

        public Criteria andIs_voteIsNotNull() {
            addCriterion("is_vote is not null");
            return (Criteria) this;
        }

        public Criteria andIs_voteEqualTo(Integer value) {
            addCriterion("is_vote =", value, "is_vote");
            return (Criteria) this;
        }

        public Criteria andIs_voteNotEqualTo(Integer value) {
            addCriterion("is_vote <>", value, "is_vote");
            return (Criteria) this;
        }

        public Criteria andIs_voteGreaterThan(Integer value) {
            addCriterion("is_vote >", value, "is_vote");
            return (Criteria) this;
        }

        public Criteria andIs_voteGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_vote >=", value, "is_vote");
            return (Criteria) this;
        }

        public Criteria andIs_voteLessThan(Integer value) {
            addCriterion("is_vote <", value, "is_vote");
            return (Criteria) this;
        }

        public Criteria andIs_voteLessThanOrEqualTo(Integer value) {
            addCriterion("is_vote <=", value, "is_vote");
            return (Criteria) this;
        }

        public Criteria andIs_voteIn(List<Integer> values) {
            addCriterion("is_vote in", values, "is_vote");
            return (Criteria) this;
        }

        public Criteria andIs_voteNotIn(List<Integer> values) {
            addCriterion("is_vote not in", values, "is_vote");
            return (Criteria) this;
        }

        public Criteria andIs_voteBetween(Integer value1, Integer value2) {
            addCriterion("is_vote between", value1, value2, "is_vote");
            return (Criteria) this;
        }

        public Criteria andIs_voteNotBetween(Integer value1, Integer value2) {
            addCriterion("is_vote not between", value1, value2, "is_vote");
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

        public Criteria andEnd_timeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEnd_timeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEnd_timeEqualTo(Date value) {
            addCriterion("end_time =", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeGreaterThan(Date value) {
            addCriterion("end_time >", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeLessThan(Date value) {
            addCriterion("end_time <", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeIn(List<Date> values) {
            addCriterion("end_time in", values, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "end_time");
            return (Criteria) this;
        }

        public Criteria andEnd_timeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "end_time");
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