package cn.zx.pojo;

import java.util.ArrayList;
import java.util.List;

public class CompanyBasicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompanyBasicExample() {
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

        public Criteria andB_idIsNull() {
            addCriterion("B_id is null");
            return (Criteria) this;
        }

        public Criteria andB_idIsNotNull() {
            addCriterion("B_id is not null");
            return (Criteria) this;
        }

        public Criteria andB_idEqualTo(Integer value) {
            addCriterion("B_id =", value, "b_id");
            return (Criteria) this;
        }

        public Criteria andB_idNotEqualTo(Integer value) {
            addCriterion("B_id <>", value, "b_id");
            return (Criteria) this;
        }

        public Criteria andB_idGreaterThan(Integer value) {
            addCriterion("B_id >", value, "b_id");
            return (Criteria) this;
        }

        public Criteria andB_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("B_id >=", value, "b_id");
            return (Criteria) this;
        }

        public Criteria andB_idLessThan(Integer value) {
            addCriterion("B_id <", value, "b_id");
            return (Criteria) this;
        }

        public Criteria andB_idLessThanOrEqualTo(Integer value) {
            addCriterion("B_id <=", value, "b_id");
            return (Criteria) this;
        }

        public Criteria andB_idIn(List<Integer> values) {
            addCriterion("B_id in", values, "b_id");
            return (Criteria) this;
        }

        public Criteria andB_idNotIn(List<Integer> values) {
            addCriterion("B_id not in", values, "b_id");
            return (Criteria) this;
        }

        public Criteria andB_idBetween(Integer value1, Integer value2) {
            addCriterion("B_id between", value1, value2, "b_id");
            return (Criteria) this;
        }

        public Criteria andB_idNotBetween(Integer value1, Integer value2) {
            addCriterion("B_id not between", value1, value2, "b_id");
            return (Criteria) this;
        }

        public Criteria andCompany_nameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompany_nameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompany_nameEqualTo(String value) {
            addCriterion("company_name =", value, "company_name");
            return (Criteria) this;
        }

        public Criteria andCompany_nameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "company_name");
            return (Criteria) this;
        }

        public Criteria andCompany_nameGreaterThan(String value) {
            addCriterion("company_name >", value, "company_name");
            return (Criteria) this;
        }

        public Criteria andCompany_nameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "company_name");
            return (Criteria) this;
        }

        public Criteria andCompany_nameLessThan(String value) {
            addCriterion("company_name <", value, "company_name");
            return (Criteria) this;
        }

        public Criteria andCompany_nameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "company_name");
            return (Criteria) this;
        }

        public Criteria andCompany_nameLike(String value) {
            addCriterion("company_name like", value, "company_name");
            return (Criteria) this;
        }

        public Criteria andCompany_nameNotLike(String value) {
            addCriterion("company_name not like", value, "company_name");
            return (Criteria) this;
        }

        public Criteria andCompany_nameIn(List<String> values) {
            addCriterion("company_name in", values, "company_name");
            return (Criteria) this;
        }

        public Criteria andCompany_nameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "company_name");
            return (Criteria) this;
        }

        public Criteria andCompany_nameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "company_name");
            return (Criteria) this;
        }

        public Criteria andCompany_nameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "company_name");
            return (Criteria) this;
        }

        public Criteria andURLIsNull() {
            addCriterion("URL is null");
            return (Criteria) this;
        }

        public Criteria andURLIsNotNull() {
            addCriterion("URL is not null");
            return (Criteria) this;
        }

        public Criteria andURLEqualTo(String value) {
            addCriterion("URL =", value, "URL");
            return (Criteria) this;
        }

        public Criteria andURLNotEqualTo(String value) {
            addCriterion("URL <>", value, "URL");
            return (Criteria) this;
        }

        public Criteria andURLGreaterThan(String value) {
            addCriterion("URL >", value, "URL");
            return (Criteria) this;
        }

        public Criteria andURLGreaterThanOrEqualTo(String value) {
            addCriterion("URL >=", value, "URL");
            return (Criteria) this;
        }

        public Criteria andURLLessThan(String value) {
            addCriterion("URL <", value, "URL");
            return (Criteria) this;
        }

        public Criteria andURLLessThanOrEqualTo(String value) {
            addCriterion("URL <=", value, "URL");
            return (Criteria) this;
        }

        public Criteria andURLLike(String value) {
            addCriterion("URL like", value, "URL");
            return (Criteria) this;
        }

        public Criteria andURLNotLike(String value) {
            addCriterion("URL not like", value, "URL");
            return (Criteria) this;
        }

        public Criteria andURLIn(List<String> values) {
            addCriterion("URL in", values, "URL");
            return (Criteria) this;
        }

        public Criteria andURLNotIn(List<String> values) {
            addCriterion("URL not in", values, "URL");
            return (Criteria) this;
        }

        public Criteria andURLBetween(String value1, String value2) {
            addCriterion("URL between", value1, value2, "URL");
            return (Criteria) this;
        }

        public Criteria andURLNotBetween(String value1, String value2) {
            addCriterion("URL not between", value1, value2, "URL");
            return (Criteria) this;
        }

        public Criteria andSloganIsNull() {
            addCriterion("slogan is null");
            return (Criteria) this;
        }

        public Criteria andSloganIsNotNull() {
            addCriterion("slogan is not null");
            return (Criteria) this;
        }

        public Criteria andSloganEqualTo(String value) {
            addCriterion("slogan =", value, "slogan");
            return (Criteria) this;
        }

        public Criteria andSloganNotEqualTo(String value) {
            addCriterion("slogan <>", value, "slogan");
            return (Criteria) this;
        }

        public Criteria andSloganGreaterThan(String value) {
            addCriterion("slogan >", value, "slogan");
            return (Criteria) this;
        }

        public Criteria andSloganGreaterThanOrEqualTo(String value) {
            addCriterion("slogan >=", value, "slogan");
            return (Criteria) this;
        }

        public Criteria andSloganLessThan(String value) {
            addCriterion("slogan <", value, "slogan");
            return (Criteria) this;
        }

        public Criteria andSloganLessThanOrEqualTo(String value) {
            addCriterion("slogan <=", value, "slogan");
            return (Criteria) this;
        }

        public Criteria andSloganLike(String value) {
            addCriterion("slogan like", value, "slogan");
            return (Criteria) this;
        }

        public Criteria andSloganNotLike(String value) {
            addCriterion("slogan not like", value, "slogan");
            return (Criteria) this;
        }

        public Criteria andSloganIn(List<String> values) {
            addCriterion("slogan in", values, "slogan");
            return (Criteria) this;
        }

        public Criteria andSloganNotIn(List<String> values) {
            addCriterion("slogan not in", values, "slogan");
            return (Criteria) this;
        }

        public Criteria andSloganBetween(String value1, String value2) {
            addCriterion("slogan between", value1, value2, "slogan");
            return (Criteria) this;
        }

        public Criteria andSloganNotBetween(String value1, String value2) {
            addCriterion("slogan not between", value1, value2, "slogan");
            return (Criteria) this;
        }

        public Criteria andPeriodIsNull() {
            addCriterion("period is null");
            return (Criteria) this;
        }

        public Criteria andPeriodIsNotNull() {
            addCriterion("period is not null");
            return (Criteria) this;
        }

        public Criteria andPeriodEqualTo(Integer value) {
            addCriterion("period =", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotEqualTo(Integer value) {
            addCriterion("period <>", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodGreaterThan(Integer value) {
            addCriterion("period >", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodGreaterThanOrEqualTo(Integer value) {
            addCriterion("period >=", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodLessThan(Integer value) {
            addCriterion("period <", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodLessThanOrEqualTo(Integer value) {
            addCriterion("period <=", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodIn(List<Integer> values) {
            addCriterion("period in", values, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotIn(List<Integer> values) {
            addCriterion("period not in", values, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodBetween(Integer value1, Integer value2) {
            addCriterion("period between", value1, value2, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotBetween(Integer value1, Integer value2) {
            addCriterion("period not between", value1, value2, "period");
            return (Criteria) this;
        }

        public Criteria andStandardIsNull() {
            addCriterion("standard is null");
            return (Criteria) this;
        }

        public Criteria andStandardIsNotNull() {
            addCriterion("standard is not null");
            return (Criteria) this;
        }

        public Criteria andStandardEqualTo(Integer value) {
            addCriterion("standard =", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardNotEqualTo(Integer value) {
            addCriterion("standard <>", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardGreaterThan(Integer value) {
            addCriterion("standard >", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardGreaterThanOrEqualTo(Integer value) {
            addCriterion("standard >=", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardLessThan(Integer value) {
            addCriterion("standard <", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardLessThanOrEqualTo(Integer value) {
            addCriterion("standard <=", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardIn(List<Integer> values) {
            addCriterion("standard in", values, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardNotIn(List<Integer> values) {
            addCriterion("standard not in", values, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardBetween(Integer value1, Integer value2) {
            addCriterion("standard between", value1, value2, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardNotBetween(Integer value1, Integer value2) {
            addCriterion("standard not between", value1, value2, "standard");
            return (Criteria) this;
        }

        public Criteria andDaysIsNull() {
            addCriterion("days is null");
            return (Criteria) this;
        }

        public Criteria andDaysIsNotNull() {
            addCriterion("days is not null");
            return (Criteria) this;
        }

        public Criteria andDaysEqualTo(Integer value) {
            addCriterion("days =", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotEqualTo(Integer value) {
            addCriterion("days <>", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysGreaterThan(Integer value) {
            addCriterion("days >", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("days >=", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysLessThan(Integer value) {
            addCriterion("days <", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysLessThanOrEqualTo(Integer value) {
            addCriterion("days <=", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysIn(List<Integer> values) {
            addCriterion("days in", values, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotIn(List<Integer> values) {
            addCriterion("days not in", values, "days");
            return (Criteria) this;
        }

        public Criteria andDaysBetween(Integer value1, Integer value2) {
            addCriterion("days between", value1, value2, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("days not between", value1, value2, "days");
            return (Criteria) this;
        }

        public Criteria andPanel_pointIsNull() {
            addCriterion("panel_point is null");
            return (Criteria) this;
        }

        public Criteria andPanel_pointIsNotNull() {
            addCriterion("panel_point is not null");
            return (Criteria) this;
        }

        public Criteria andPanel_pointEqualTo(Integer value) {
            addCriterion("panel_point =", value, "panel_point");
            return (Criteria) this;
        }

        public Criteria andPanel_pointNotEqualTo(Integer value) {
            addCriterion("panel_point <>", value, "panel_point");
            return (Criteria) this;
        }

        public Criteria andPanel_pointGreaterThan(Integer value) {
            addCriterion("panel_point >", value, "panel_point");
            return (Criteria) this;
        }

        public Criteria andPanel_pointGreaterThanOrEqualTo(Integer value) {
            addCriterion("panel_point >=", value, "panel_point");
            return (Criteria) this;
        }

        public Criteria andPanel_pointLessThan(Integer value) {
            addCriterion("panel_point <", value, "panel_point");
            return (Criteria) this;
        }

        public Criteria andPanel_pointLessThanOrEqualTo(Integer value) {
            addCriterion("panel_point <=", value, "panel_point");
            return (Criteria) this;
        }

        public Criteria andPanel_pointIn(List<Integer> values) {
            addCriterion("panel_point in", values, "panel_point");
            return (Criteria) this;
        }

        public Criteria andPanel_pointNotIn(List<Integer> values) {
            addCriterion("panel_point not in", values, "panel_point");
            return (Criteria) this;
        }

        public Criteria andPanel_pointBetween(Integer value1, Integer value2) {
            addCriterion("panel_point between", value1, value2, "panel_point");
            return (Criteria) this;
        }

        public Criteria andPanel_pointNotBetween(Integer value1, Integer value2) {
            addCriterion("panel_point not between", value1, value2, "panel_point");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
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