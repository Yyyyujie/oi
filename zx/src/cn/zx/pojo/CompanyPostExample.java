package cn.zx.pojo;

import java.util.ArrayList;
import java.util.List;

public class CompanyPostExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompanyPostExample() {
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

        public Criteria andPost_idIsNull() {
            addCriterion("post_id is null");
            return (Criteria) this;
        }

        public Criteria andPost_idIsNotNull() {
            addCriterion("post_id is not null");
            return (Criteria) this;
        }

        public Criteria andPost_idEqualTo(Integer value) {
            addCriterion("post_id =", value, "post_id");
            return (Criteria) this;
        }

        public Criteria andPost_idNotEqualTo(Integer value) {
            addCriterion("post_id <>", value, "post_id");
            return (Criteria) this;
        }

        public Criteria andPost_idGreaterThan(Integer value) {
            addCriterion("post_id >", value, "post_id");
            return (Criteria) this;
        }

        public Criteria andPost_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("post_id >=", value, "post_id");
            return (Criteria) this;
        }

        public Criteria andPost_idLessThan(Integer value) {
            addCriterion("post_id <", value, "post_id");
            return (Criteria) this;
        }

        public Criteria andPost_idLessThanOrEqualTo(Integer value) {
            addCriterion("post_id <=", value, "post_id");
            return (Criteria) this;
        }

        public Criteria andPost_idIn(List<Integer> values) {
            addCriterion("post_id in", values, "post_id");
            return (Criteria) this;
        }

        public Criteria andPost_idNotIn(List<Integer> values) {
            addCriterion("post_id not in", values, "post_id");
            return (Criteria) this;
        }

        public Criteria andPost_idBetween(Integer value1, Integer value2) {
            addCriterion("post_id between", value1, value2, "post_id");
            return (Criteria) this;
        }

        public Criteria andPost_idNotBetween(Integer value1, Integer value2) {
            addCriterion("post_id not between", value1, value2, "post_id");
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

        public Criteria andPost_nameIsNull() {
            addCriterion("post_name is null");
            return (Criteria) this;
        }

        public Criteria andPost_nameIsNotNull() {
            addCriterion("post_name is not null");
            return (Criteria) this;
        }

        public Criteria andPost_nameEqualTo(String value) {
            addCriterion("post_name =", value, "post_name");
            return (Criteria) this;
        }

        public Criteria andPost_nameNotEqualTo(String value) {
            addCriterion("post_name <>", value, "post_name");
            return (Criteria) this;
        }

        public Criteria andPost_nameGreaterThan(String value) {
            addCriterion("post_name >", value, "post_name");
            return (Criteria) this;
        }

        public Criteria andPost_nameGreaterThanOrEqualTo(String value) {
            addCriterion("post_name >=", value, "post_name");
            return (Criteria) this;
        }

        public Criteria andPost_nameLessThan(String value) {
            addCriterion("post_name <", value, "post_name");
            return (Criteria) this;
        }

        public Criteria andPost_nameLessThanOrEqualTo(String value) {
            addCriterion("post_name <=", value, "post_name");
            return (Criteria) this;
        }

        public Criteria andPost_nameLike(String value) {
            addCriterion("post_name like", value, "post_name");
            return (Criteria) this;
        }

        public Criteria andPost_nameNotLike(String value) {
            addCriterion("post_name not like", value, "post_name");
            return (Criteria) this;
        }

        public Criteria andPost_nameIn(List<String> values) {
            addCriterion("post_name in", values, "post_name");
            return (Criteria) this;
        }

        public Criteria andPost_nameNotIn(List<String> values) {
            addCriterion("post_name not in", values, "post_name");
            return (Criteria) this;
        }

        public Criteria andPost_nameBetween(String value1, String value2) {
            addCriterion("post_name between", value1, value2, "post_name");
            return (Criteria) this;
        }

        public Criteria andPost_nameNotBetween(String value1, String value2) {
            addCriterion("post_name not between", value1, value2, "post_name");
            return (Criteria) this;
        }

        public Criteria andPost_remarkIsNull() {
            addCriterion("post_remark is null");
            return (Criteria) this;
        }

        public Criteria andPost_remarkIsNotNull() {
            addCriterion("post_remark is not null");
            return (Criteria) this;
        }

        public Criteria andPost_remarkEqualTo(String value) {
            addCriterion("post_remark =", value, "post_remark");
            return (Criteria) this;
        }

        public Criteria andPost_remarkNotEqualTo(String value) {
            addCriterion("post_remark <>", value, "post_remark");
            return (Criteria) this;
        }

        public Criteria andPost_remarkGreaterThan(String value) {
            addCriterion("post_remark >", value, "post_remark");
            return (Criteria) this;
        }

        public Criteria andPost_remarkGreaterThanOrEqualTo(String value) {
            addCriterion("post_remark >=", value, "post_remark");
            return (Criteria) this;
        }

        public Criteria andPost_remarkLessThan(String value) {
            addCriterion("post_remark <", value, "post_remark");
            return (Criteria) this;
        }

        public Criteria andPost_remarkLessThanOrEqualTo(String value) {
            addCriterion("post_remark <=", value, "post_remark");
            return (Criteria) this;
        }

        public Criteria andPost_remarkLike(String value) {
            addCriterion("post_remark like", value, "post_remark");
            return (Criteria) this;
        }

        public Criteria andPost_remarkNotLike(String value) {
            addCriterion("post_remark not like", value, "post_remark");
            return (Criteria) this;
        }

        public Criteria andPost_remarkIn(List<String> values) {
            addCriterion("post_remark in", values, "post_remark");
            return (Criteria) this;
        }

        public Criteria andPost_remarkNotIn(List<String> values) {
            addCriterion("post_remark not in", values, "post_remark");
            return (Criteria) this;
        }

        public Criteria andPost_remarkBetween(String value1, String value2) {
            addCriterion("post_remark between", value1, value2, "post_remark");
            return (Criteria) this;
        }

        public Criteria andPost_remarkNotBetween(String value1, String value2) {
            addCriterion("post_remark not between", value1, value2, "post_remark");
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

        public Criteria andIsdeleteIsNull() {
            addCriterion("isdelete is null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIsNotNull() {
            addCriterion("isdelete is not null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteEqualTo(Integer value) {
            addCriterion("isdelete =", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotEqualTo(Integer value) {
            addCriterion("isdelete <>", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThan(Integer value) {
            addCriterion("isdelete >", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("isdelete >=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThan(Integer value) {
            addCriterion("isdelete <", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThanOrEqualTo(Integer value) {
            addCriterion("isdelete <=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIn(List<Integer> values) {
            addCriterion("isdelete in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotIn(List<Integer> values) {
            addCriterion("isdelete not in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteBetween(Integer value1, Integer value2) {
            addCriterion("isdelete between", value1, value2, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("isdelete not between", value1, value2, "isdelete");
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