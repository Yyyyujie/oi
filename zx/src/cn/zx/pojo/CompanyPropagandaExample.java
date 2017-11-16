package cn.zx.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompanyPropagandaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompanyPropagandaExample() {
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

        public Criteria andP_idIsNull() {
            addCriterion("p_id is null");
            return (Criteria) this;
        }

        public Criteria andP_idIsNotNull() {
            addCriterion("p_id is not null");
            return (Criteria) this;
        }

        public Criteria andP_idEqualTo(Integer value) {
            addCriterion("p_id =", value, "p_id");
            return (Criteria) this;
        }

        public Criteria andP_idNotEqualTo(Integer value) {
            addCriterion("p_id <>", value, "p_id");
            return (Criteria) this;
        }

        public Criteria andP_idGreaterThan(Integer value) {
            addCriterion("p_id >", value, "p_id");
            return (Criteria) this;
        }

        public Criteria andP_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_id >=", value, "p_id");
            return (Criteria) this;
        }

        public Criteria andP_idLessThan(Integer value) {
            addCriterion("p_id <", value, "p_id");
            return (Criteria) this;
        }

        public Criteria andP_idLessThanOrEqualTo(Integer value) {
            addCriterion("p_id <=", value, "p_id");
            return (Criteria) this;
        }

        public Criteria andP_idIn(List<Integer> values) {
            addCriterion("p_id in", values, "p_id");
            return (Criteria) this;
        }

        public Criteria andP_idNotIn(List<Integer> values) {
            addCriterion("p_id not in", values, "p_id");
            return (Criteria) this;
        }

        public Criteria andP_idBetween(Integer value1, Integer value2) {
            addCriterion("p_id between", value1, value2, "p_id");
            return (Criteria) this;
        }

        public Criteria andP_idNotBetween(Integer value1, Integer value2) {
            addCriterion("p_id not between", value1, value2, "p_id");
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

        public Criteria andP_titleIsNull() {
            addCriterion("p_title is null");
            return (Criteria) this;
        }

        public Criteria andP_titleIsNotNull() {
            addCriterion("p_title is not null");
            return (Criteria) this;
        }

        public Criteria andP_titleEqualTo(String value) {
            addCriterion("p_title =", value, "p_title");
            return (Criteria) this;
        }

        public Criteria andP_titleNotEqualTo(String value) {
            addCriterion("p_title <>", value, "p_title");
            return (Criteria) this;
        }

        public Criteria andP_titleGreaterThan(String value) {
            addCriterion("p_title >", value, "p_title");
            return (Criteria) this;
        }

        public Criteria andP_titleGreaterThanOrEqualTo(String value) {
            addCriterion("p_title >=", value, "p_title");
            return (Criteria) this;
        }

        public Criteria andP_titleLessThan(String value) {
            addCriterion("p_title <", value, "p_title");
            return (Criteria) this;
        }

        public Criteria andP_titleLessThanOrEqualTo(String value) {
            addCriterion("p_title <=", value, "p_title");
            return (Criteria) this;
        }

        public Criteria andP_titleLike(String value) {
            addCriterion("p_title like", value, "p_title");
            return (Criteria) this;
        }

        public Criteria andP_titleNotLike(String value) {
            addCriterion("p_title not like", value, "p_title");
            return (Criteria) this;
        }

        public Criteria andP_titleIn(List<String> values) {
            addCriterion("p_title in", values, "p_title");
            return (Criteria) this;
        }

        public Criteria andP_titleNotIn(List<String> values) {
            addCriterion("p_title not in", values, "p_title");
            return (Criteria) this;
        }

        public Criteria andP_titleBetween(String value1, String value2) {
            addCriterion("p_title between", value1, value2, "p_title");
            return (Criteria) this;
        }

        public Criteria andP_titleNotBetween(String value1, String value2) {
            addCriterion("p_title not between", value1, value2, "p_title");
            return (Criteria) this;
        }

        public Criteria andPic_URLIsNull() {
            addCriterion("pic_URL is null");
            return (Criteria) this;
        }

        public Criteria andPic_URLIsNotNull() {
            addCriterion("pic_URL is not null");
            return (Criteria) this;
        }

        public Criteria andPic_URLEqualTo(String value) {
            addCriterion("pic_URL =", value, "pic_URL");
            return (Criteria) this;
        }

        public Criteria andPic_URLNotEqualTo(String value) {
            addCriterion("pic_URL <>", value, "pic_URL");
            return (Criteria) this;
        }

        public Criteria andPic_URLGreaterThan(String value) {
            addCriterion("pic_URL >", value, "pic_URL");
            return (Criteria) this;
        }

        public Criteria andPic_URLGreaterThanOrEqualTo(String value) {
            addCriterion("pic_URL >=", value, "pic_URL");
            return (Criteria) this;
        }

        public Criteria andPic_URLLessThan(String value) {
            addCriterion("pic_URL <", value, "pic_URL");
            return (Criteria) this;
        }

        public Criteria andPic_URLLessThanOrEqualTo(String value) {
            addCriterion("pic_URL <=", value, "pic_URL");
            return (Criteria) this;
        }

        public Criteria andPic_URLLike(String value) {
            addCriterion("pic_URL like", value, "pic_URL");
            return (Criteria) this;
        }

        public Criteria andPic_URLNotLike(String value) {
            addCriterion("pic_URL not like", value, "pic_URL");
            return (Criteria) this;
        }

        public Criteria andPic_URLIn(List<String> values) {
            addCriterion("pic_URL in", values, "pic_URL");
            return (Criteria) this;
        }

        public Criteria andPic_URLNotIn(List<String> values) {
            addCriterion("pic_URL not in", values, "pic_URL");
            return (Criteria) this;
        }

        public Criteria andPic_URLBetween(String value1, String value2) {
            addCriterion("pic_URL between", value1, value2, "pic_URL");
            return (Criteria) this;
        }

        public Criteria andPic_URLNotBetween(String value1, String value2) {
            addCriterion("pic_URL not between", value1, value2, "pic_URL");
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

        public Criteria andOIsNull() {
            addCriterion("o is null");
            return (Criteria) this;
        }

        public Criteria andOIsNotNull() {
            addCriterion("o is not null");
            return (Criteria) this;
        }

        public Criteria andOEqualTo(Integer value) {
            addCriterion("o =", value, "o");
            return (Criteria) this;
        }

        public Criteria andONotEqualTo(Integer value) {
            addCriterion("o <>", value, "o");
            return (Criteria) this;
        }

        public Criteria andOGreaterThan(Integer value) {
            addCriterion("o >", value, "o");
            return (Criteria) this;
        }

        public Criteria andOGreaterThanOrEqualTo(Integer value) {
            addCriterion("o >=", value, "o");
            return (Criteria) this;
        }

        public Criteria andOLessThan(Integer value) {
            addCriterion("o <", value, "o");
            return (Criteria) this;
        }

        public Criteria andOLessThanOrEqualTo(Integer value) {
            addCriterion("o <=", value, "o");
            return (Criteria) this;
        }

        public Criteria andOIn(List<Integer> values) {
            addCriterion("o in", values, "o");
            return (Criteria) this;
        }

        public Criteria andONotIn(List<Integer> values) {
            addCriterion("o not in", values, "o");
            return (Criteria) this;
        }

        public Criteria andOBetween(Integer value1, Integer value2) {
            addCriterion("o between", value1, value2, "o");
            return (Criteria) this;
        }

        public Criteria andONotBetween(Integer value1, Integer value2) {
            addCriterion("o not between", value1, value2, "o");
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