package cn.zx.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompanyPromotionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompanyPromotionExample() {
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

        public Criteria andCurrent_post_levelIsNull() {
            addCriterion("current_post_level is null");
            return (Criteria) this;
        }

        public Criteria andCurrent_post_levelIsNotNull() {
            addCriterion("current_post_level is not null");
            return (Criteria) this;
        }

        public Criteria andCurrent_post_levelEqualTo(Integer value) {
            addCriterion("current_post_level =", value, "current_post_level");
            return (Criteria) this;
        }

        public Criteria andCurrent_post_levelNotEqualTo(Integer value) {
            addCriterion("current_post_level <>", value, "current_post_level");
            return (Criteria) this;
        }

        public Criteria andCurrent_post_levelGreaterThan(Integer value) {
            addCriterion("current_post_level >", value, "current_post_level");
            return (Criteria) this;
        }

        public Criteria andCurrent_post_levelGreaterThanOrEqualTo(Integer value) {
            addCriterion("current_post_level >=", value, "current_post_level");
            return (Criteria) this;
        }

        public Criteria andCurrent_post_levelLessThan(Integer value) {
            addCriterion("current_post_level <", value, "current_post_level");
            return (Criteria) this;
        }

        public Criteria andCurrent_post_levelLessThanOrEqualTo(Integer value) {
            addCriterion("current_post_level <=", value, "current_post_level");
            return (Criteria) this;
        }

        public Criteria andCurrent_post_levelIn(List<Integer> values) {
            addCriterion("current_post_level in", values, "current_post_level");
            return (Criteria) this;
        }

        public Criteria andCurrent_post_levelNotIn(List<Integer> values) {
            addCriterion("current_post_level not in", values, "current_post_level");
            return (Criteria) this;
        }

        public Criteria andCurrent_post_levelBetween(Integer value1, Integer value2) {
            addCriterion("current_post_level between", value1, value2, "current_post_level");
            return (Criteria) this;
        }

        public Criteria andCurrent_post_levelNotBetween(Integer value1, Integer value2) {
            addCriterion("current_post_level not between", value1, value2, "current_post_level");
            return (Criteria) this;
        }

        public Criteria andNext_post_levelIsNull() {
            addCriterion("next_post_level is null");
            return (Criteria) this;
        }

        public Criteria andNext_post_levelIsNotNull() {
            addCriterion("next_post_level is not null");
            return (Criteria) this;
        }

        public Criteria andNext_post_levelEqualTo(Integer value) {
            addCriterion("next_post_level =", value, "next_post_level");
            return (Criteria) this;
        }

        public Criteria andNext_post_levelNotEqualTo(Integer value) {
            addCriterion("next_post_level <>", value, "next_post_level");
            return (Criteria) this;
        }

        public Criteria andNext_post_levelGreaterThan(Integer value) {
            addCriterion("next_post_level >", value, "next_post_level");
            return (Criteria) this;
        }

        public Criteria andNext_post_levelGreaterThanOrEqualTo(Integer value) {
            addCriterion("next_post_level >=", value, "next_post_level");
            return (Criteria) this;
        }

        public Criteria andNext_post_levelLessThan(Integer value) {
            addCriterion("next_post_level <", value, "next_post_level");
            return (Criteria) this;
        }

        public Criteria andNext_post_levelLessThanOrEqualTo(Integer value) {
            addCriterion("next_post_level <=", value, "next_post_level");
            return (Criteria) this;
        }

        public Criteria andNext_post_levelIn(List<Integer> values) {
            addCriterion("next_post_level in", values, "next_post_level");
            return (Criteria) this;
        }

        public Criteria andNext_post_levelNotIn(List<Integer> values) {
            addCriterion("next_post_level not in", values, "next_post_level");
            return (Criteria) this;
        }

        public Criteria andNext_post_levelBetween(Integer value1, Integer value2) {
            addCriterion("next_post_level between", value1, value2, "next_post_level");
            return (Criteria) this;
        }

        public Criteria andNext_post_levelNotBetween(Integer value1, Integer value2) {
            addCriterion("next_post_level not between", value1, value2, "next_post_level");
            return (Criteria) this;
        }

        public Criteria andLast_post_levelIsNull() {
            addCriterion("last_post_level is null");
            return (Criteria) this;
        }

        public Criteria andLast_post_levelIsNotNull() {
            addCriterion("last_post_level is not null");
            return (Criteria) this;
        }

        public Criteria andLast_post_levelEqualTo(Integer value) {
            addCriterion("last_post_level =", value, "last_post_level");
            return (Criteria) this;
        }

        public Criteria andLast_post_levelNotEqualTo(Integer value) {
            addCriterion("last_post_level <>", value, "last_post_level");
            return (Criteria) this;
        }

        public Criteria andLast_post_levelGreaterThan(Integer value) {
            addCriterion("last_post_level >", value, "last_post_level");
            return (Criteria) this;
        }

        public Criteria andLast_post_levelGreaterThanOrEqualTo(Integer value) {
            addCriterion("last_post_level >=", value, "last_post_level");
            return (Criteria) this;
        }

        public Criteria andLast_post_levelLessThan(Integer value) {
            addCriterion("last_post_level <", value, "last_post_level");
            return (Criteria) this;
        }

        public Criteria andLast_post_levelLessThanOrEqualTo(Integer value) {
            addCriterion("last_post_level <=", value, "last_post_level");
            return (Criteria) this;
        }

        public Criteria andLast_post_levelIn(List<Integer> values) {
            addCriterion("last_post_level in", values, "last_post_level");
            return (Criteria) this;
        }

        public Criteria andLast_post_levelNotIn(List<Integer> values) {
            addCriterion("last_post_level not in", values, "last_post_level");
            return (Criteria) this;
        }

        public Criteria andLast_post_levelBetween(Integer value1, Integer value2) {
            addCriterion("last_post_level between", value1, value2, "last_post_level");
            return (Criteria) this;
        }

        public Criteria andLast_post_levelNotBetween(Integer value1, Integer value2) {
            addCriterion("last_post_level not between", value1, value2, "last_post_level");
            return (Criteria) this;
        }

        public Criteria andSumIsNull() {
            addCriterion("sum is null");
            return (Criteria) this;
        }

        public Criteria andSumIsNotNull() {
            addCriterion("sum is not null");
            return (Criteria) this;
        }

        public Criteria andSumEqualTo(Integer value) {
            addCriterion("sum =", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumNotEqualTo(Integer value) {
            addCriterion("sum <>", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumGreaterThan(Integer value) {
            addCriterion("sum >", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumGreaterThanOrEqualTo(Integer value) {
            addCriterion("sum >=", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumLessThan(Integer value) {
            addCriterion("sum <", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumLessThanOrEqualTo(Integer value) {
            addCriterion("sum <=", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumIn(List<Integer> values) {
            addCriterion("sum in", values, "sum");
            return (Criteria) this;
        }

        public Criteria andSumNotIn(List<Integer> values) {
            addCriterion("sum not in", values, "sum");
            return (Criteria) this;
        }

        public Criteria andSumBetween(Integer value1, Integer value2) {
            addCriterion("sum between", value1, value2, "sum");
            return (Criteria) this;
        }

        public Criteria andSumNotBetween(Integer value1, Integer value2) {
            addCriterion("sum not between", value1, value2, "sum");
            return (Criteria) this;
        }

        public Criteria andAgreeIsNull() {
            addCriterion("agree is null");
            return (Criteria) this;
        }

        public Criteria andAgreeIsNotNull() {
            addCriterion("agree is not null");
            return (Criteria) this;
        }

        public Criteria andAgreeEqualTo(Integer value) {
            addCriterion("agree =", value, "agree");
            return (Criteria) this;
        }

        public Criteria andAgreeNotEqualTo(Integer value) {
            addCriterion("agree <>", value, "agree");
            return (Criteria) this;
        }

        public Criteria andAgreeGreaterThan(Integer value) {
            addCriterion("agree >", value, "agree");
            return (Criteria) this;
        }

        public Criteria andAgreeGreaterThanOrEqualTo(Integer value) {
            addCriterion("agree >=", value, "agree");
            return (Criteria) this;
        }

        public Criteria andAgreeLessThan(Integer value) {
            addCriterion("agree <", value, "agree");
            return (Criteria) this;
        }

        public Criteria andAgreeLessThanOrEqualTo(Integer value) {
            addCriterion("agree <=", value, "agree");
            return (Criteria) this;
        }

        public Criteria andAgreeIn(List<Integer> values) {
            addCriterion("agree in", values, "agree");
            return (Criteria) this;
        }

        public Criteria andAgreeNotIn(List<Integer> values) {
            addCriterion("agree not in", values, "agree");
            return (Criteria) this;
        }

        public Criteria andAgreeBetween(Integer value1, Integer value2) {
            addCriterion("agree between", value1, value2, "agree");
            return (Criteria) this;
        }

        public Criteria andAgreeNotBetween(Integer value1, Integer value2) {
            addCriterion("agree not between", value1, value2, "agree");
            return (Criteria) this;
        }

        public Criteria andOpposeIsNull() {
            addCriterion("oppose is null");
            return (Criteria) this;
        }

        public Criteria andOpposeIsNotNull() {
            addCriterion("oppose is not null");
            return (Criteria) this;
        }

        public Criteria andOpposeEqualTo(Integer value) {
            addCriterion("oppose =", value, "oppose");
            return (Criteria) this;
        }

        public Criteria andOpposeNotEqualTo(Integer value) {
            addCriterion("oppose <>", value, "oppose");
            return (Criteria) this;
        }

        public Criteria andOpposeGreaterThan(Integer value) {
            addCriterion("oppose >", value, "oppose");
            return (Criteria) this;
        }

        public Criteria andOpposeGreaterThanOrEqualTo(Integer value) {
            addCriterion("oppose >=", value, "oppose");
            return (Criteria) this;
        }

        public Criteria andOpposeLessThan(Integer value) {
            addCriterion("oppose <", value, "oppose");
            return (Criteria) this;
        }

        public Criteria andOpposeLessThanOrEqualTo(Integer value) {
            addCriterion("oppose <=", value, "oppose");
            return (Criteria) this;
        }

        public Criteria andOpposeIn(List<Integer> values) {
            addCriterion("oppose in", values, "oppose");
            return (Criteria) this;
        }

        public Criteria andOpposeNotIn(List<Integer> values) {
            addCriterion("oppose not in", values, "oppose");
            return (Criteria) this;
        }

        public Criteria andOpposeBetween(Integer value1, Integer value2) {
            addCriterion("oppose between", value1, value2, "oppose");
            return (Criteria) this;
        }

        public Criteria andOpposeNotBetween(Integer value1, Integer value2) {
            addCriterion("oppose not between", value1, value2, "oppose");
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