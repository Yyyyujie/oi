package cn.zx.pojo;

import java.util.ArrayList;
import java.util.List;

public class OiSiteExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OiSiteExample() {
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

        public Criteria andS_idIsNull() {
            addCriterion("s_id is null");
            return (Criteria) this;
        }

        public Criteria andS_idIsNotNull() {
            addCriterion("s_id is not null");
            return (Criteria) this;
        }

        public Criteria andS_idEqualTo(Integer value) {
            addCriterion("s_id =", value, "s_id");
            return (Criteria) this;
        }

        public Criteria andS_idNotEqualTo(Integer value) {
            addCriterion("s_id <>", value, "s_id");
            return (Criteria) this;
        }

        public Criteria andS_idGreaterThan(Integer value) {
            addCriterion("s_id >", value, "s_id");
            return (Criteria) this;
        }

        public Criteria andS_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("s_id >=", value, "s_id");
            return (Criteria) this;
        }

        public Criteria andS_idLessThan(Integer value) {
            addCriterion("s_id <", value, "s_id");
            return (Criteria) this;
        }

        public Criteria andS_idLessThanOrEqualTo(Integer value) {
            addCriterion("s_id <=", value, "s_id");
            return (Criteria) this;
        }

        public Criteria andS_idIn(List<Integer> values) {
            addCriterion("s_id in", values, "s_id");
            return (Criteria) this;
        }

        public Criteria andS_idNotIn(List<Integer> values) {
            addCriterion("s_id not in", values, "s_id");
            return (Criteria) this;
        }

        public Criteria andS_idBetween(Integer value1, Integer value2) {
            addCriterion("s_id between", value1, value2, "s_id");
            return (Criteria) this;
        }

        public Criteria andS_idNotBetween(Integer value1, Integer value2) {
            addCriterion("s_id not between", value1, value2, "s_id");
            return (Criteria) this;
        }

        public Criteria andS_URLIsNull() {
            addCriterion("s_URL is null");
            return (Criteria) this;
        }

        public Criteria andS_URLIsNotNull() {
            addCriterion("s_URL is not null");
            return (Criteria) this;
        }

        public Criteria andS_URLEqualTo(String value) {
            addCriterion("s_URL =", value, "s_URL");
            return (Criteria) this;
        }

        public Criteria andS_URLNotEqualTo(String value) {
            addCriterion("s_URL <>", value, "s_URL");
            return (Criteria) this;
        }

        public Criteria andS_URLGreaterThan(String value) {
            addCriterion("s_URL >", value, "s_URL");
            return (Criteria) this;
        }

        public Criteria andS_URLGreaterThanOrEqualTo(String value) {
            addCriterion("s_URL >=", value, "s_URL");
            return (Criteria) this;
        }

        public Criteria andS_URLLessThan(String value) {
            addCriterion("s_URL <", value, "s_URL");
            return (Criteria) this;
        }

        public Criteria andS_URLLessThanOrEqualTo(String value) {
            addCriterion("s_URL <=", value, "s_URL");
            return (Criteria) this;
        }

        public Criteria andS_URLLike(String value) {
            addCriterion("s_URL like", value, "s_URL");
            return (Criteria) this;
        }

        public Criteria andS_URLNotLike(String value) {
            addCriterion("s_URL not like", value, "s_URL");
            return (Criteria) this;
        }

        public Criteria andS_URLIn(List<String> values) {
            addCriterion("s_URL in", values, "s_URL");
            return (Criteria) this;
        }

        public Criteria andS_URLNotIn(List<String> values) {
            addCriterion("s_URL not in", values, "s_URL");
            return (Criteria) this;
        }

        public Criteria andS_URLBetween(String value1, String value2) {
            addCriterion("s_URL between", value1, value2, "s_URL");
            return (Criteria) this;
        }

        public Criteria andS_URLNotBetween(String value1, String value2) {
            addCriterion("s_URL not between", value1, value2, "s_URL");
            return (Criteria) this;
        }

        public Criteria andS_titleIsNull() {
            addCriterion("s_title is null");
            return (Criteria) this;
        }

        public Criteria andS_titleIsNotNull() {
            addCriterion("s_title is not null");
            return (Criteria) this;
        }

        public Criteria andS_titleEqualTo(String value) {
            addCriterion("s_title =", value, "s_title");
            return (Criteria) this;
        }

        public Criteria andS_titleNotEqualTo(String value) {
            addCriterion("s_title <>", value, "s_title");
            return (Criteria) this;
        }

        public Criteria andS_titleGreaterThan(String value) {
            addCriterion("s_title >", value, "s_title");
            return (Criteria) this;
        }

        public Criteria andS_titleGreaterThanOrEqualTo(String value) {
            addCriterion("s_title >=", value, "s_title");
            return (Criteria) this;
        }

        public Criteria andS_titleLessThan(String value) {
            addCriterion("s_title <", value, "s_title");
            return (Criteria) this;
        }

        public Criteria andS_titleLessThanOrEqualTo(String value) {
            addCriterion("s_title <=", value, "s_title");
            return (Criteria) this;
        }

        public Criteria andS_titleLike(String value) {
            addCriterion("s_title like", value, "s_title");
            return (Criteria) this;
        }

        public Criteria andS_titleNotLike(String value) {
            addCriterion("s_title not like", value, "s_title");
            return (Criteria) this;
        }

        public Criteria andS_titleIn(List<String> values) {
            addCriterion("s_title in", values, "s_title");
            return (Criteria) this;
        }

        public Criteria andS_titleNotIn(List<String> values) {
            addCriterion("s_title not in", values, "s_title");
            return (Criteria) this;
        }

        public Criteria andS_titleBetween(String value1, String value2) {
            addCriterion("s_title between", value1, value2, "s_title");
            return (Criteria) this;
        }

        public Criteria andS_titleNotBetween(String value1, String value2) {
            addCriterion("s_title not between", value1, value2, "s_title");
            return (Criteria) this;
        }

        public Criteria andS_nameIsNull() {
            addCriterion("s_name is null");
            return (Criteria) this;
        }

        public Criteria andS_nameIsNotNull() {
            addCriterion("s_name is not null");
            return (Criteria) this;
        }

        public Criteria andS_nameEqualTo(String value) {
            addCriterion("s_name =", value, "s_name");
            return (Criteria) this;
        }

        public Criteria andS_nameNotEqualTo(String value) {
            addCriterion("s_name <>", value, "s_name");
            return (Criteria) this;
        }

        public Criteria andS_nameGreaterThan(String value) {
            addCriterion("s_name >", value, "s_name");
            return (Criteria) this;
        }

        public Criteria andS_nameGreaterThanOrEqualTo(String value) {
            addCriterion("s_name >=", value, "s_name");
            return (Criteria) this;
        }

        public Criteria andS_nameLessThan(String value) {
            addCriterion("s_name <", value, "s_name");
            return (Criteria) this;
        }

        public Criteria andS_nameLessThanOrEqualTo(String value) {
            addCriterion("s_name <=", value, "s_name");
            return (Criteria) this;
        }

        public Criteria andS_nameLike(String value) {
            addCriterion("s_name like", value, "s_name");
            return (Criteria) this;
        }

        public Criteria andS_nameNotLike(String value) {
            addCriterion("s_name not like", value, "s_name");
            return (Criteria) this;
        }

        public Criteria andS_nameIn(List<String> values) {
            addCriterion("s_name in", values, "s_name");
            return (Criteria) this;
        }

        public Criteria andS_nameNotIn(List<String> values) {
            addCriterion("s_name not in", values, "s_name");
            return (Criteria) this;
        }

        public Criteria andS_nameBetween(String value1, String value2) {
            addCriterion("s_name between", value1, value2, "s_name");
            return (Criteria) this;
        }

        public Criteria andS_nameNotBetween(String value1, String value2) {
            addCriterion("s_name not between", value1, value2, "s_name");
            return (Criteria) this;
        }

        public Criteria andS_depictIsNull() {
            addCriterion("s_depict is null");
            return (Criteria) this;
        }

        public Criteria andS_depictIsNotNull() {
            addCriterion("s_depict is not null");
            return (Criteria) this;
        }

        public Criteria andS_depictEqualTo(String value) {
            addCriterion("s_depict =", value, "s_depict");
            return (Criteria) this;
        }

        public Criteria andS_depictNotEqualTo(String value) {
            addCriterion("s_depict <>", value, "s_depict");
            return (Criteria) this;
        }

        public Criteria andS_depictGreaterThan(String value) {
            addCriterion("s_depict >", value, "s_depict");
            return (Criteria) this;
        }

        public Criteria andS_depictGreaterThanOrEqualTo(String value) {
            addCriterion("s_depict >=", value, "s_depict");
            return (Criteria) this;
        }

        public Criteria andS_depictLessThan(String value) {
            addCriterion("s_depict <", value, "s_depict");
            return (Criteria) this;
        }

        public Criteria andS_depictLessThanOrEqualTo(String value) {
            addCriterion("s_depict <=", value, "s_depict");
            return (Criteria) this;
        }

        public Criteria andS_depictLike(String value) {
            addCriterion("s_depict like", value, "s_depict");
            return (Criteria) this;
        }

        public Criteria andS_depictNotLike(String value) {
            addCriterion("s_depict not like", value, "s_depict");
            return (Criteria) this;
        }

        public Criteria andS_depictIn(List<String> values) {
            addCriterion("s_depict in", values, "s_depict");
            return (Criteria) this;
        }

        public Criteria andS_depictNotIn(List<String> values) {
            addCriterion("s_depict not in", values, "s_depict");
            return (Criteria) this;
        }

        public Criteria andS_depictBetween(String value1, String value2) {
            addCriterion("s_depict between", value1, value2, "s_depict");
            return (Criteria) this;
        }

        public Criteria andS_depictNotBetween(String value1, String value2) {
            addCriterion("s_depict not between", value1, value2, "s_depict");
            return (Criteria) this;
        }

        public Criteria andS_keywordsIsNull() {
            addCriterion("s_keywords is null");
            return (Criteria) this;
        }

        public Criteria andS_keywordsIsNotNull() {
            addCriterion("s_keywords is not null");
            return (Criteria) this;
        }

        public Criteria andS_keywordsEqualTo(String value) {
            addCriterion("s_keywords =", value, "s_keywords");
            return (Criteria) this;
        }

        public Criteria andS_keywordsNotEqualTo(String value) {
            addCriterion("s_keywords <>", value, "s_keywords");
            return (Criteria) this;
        }

        public Criteria andS_keywordsGreaterThan(String value) {
            addCriterion("s_keywords >", value, "s_keywords");
            return (Criteria) this;
        }

        public Criteria andS_keywordsGreaterThanOrEqualTo(String value) {
            addCriterion("s_keywords >=", value, "s_keywords");
            return (Criteria) this;
        }

        public Criteria andS_keywordsLessThan(String value) {
            addCriterion("s_keywords <", value, "s_keywords");
            return (Criteria) this;
        }

        public Criteria andS_keywordsLessThanOrEqualTo(String value) {
            addCriterion("s_keywords <=", value, "s_keywords");
            return (Criteria) this;
        }

        public Criteria andS_keywordsLike(String value) {
            addCriterion("s_keywords like", value, "s_keywords");
            return (Criteria) this;
        }

        public Criteria andS_keywordsNotLike(String value) {
            addCriterion("s_keywords not like", value, "s_keywords");
            return (Criteria) this;
        }

        public Criteria andS_keywordsIn(List<String> values) {
            addCriterion("s_keywords in", values, "s_keywords");
            return (Criteria) this;
        }

        public Criteria andS_keywordsNotIn(List<String> values) {
            addCriterion("s_keywords not in", values, "s_keywords");
            return (Criteria) this;
        }

        public Criteria andS_keywordsBetween(String value1, String value2) {
            addCriterion("s_keywords between", value1, value2, "s_keywords");
            return (Criteria) this;
        }

        public Criteria andS_keywordsNotBetween(String value1, String value2) {
            addCriterion("s_keywords not between", value1, value2, "s_keywords");
            return (Criteria) this;
        }

        public Criteria andS_editionIsNull() {
            addCriterion("s_edition is null");
            return (Criteria) this;
        }

        public Criteria andS_editionIsNotNull() {
            addCriterion("s_edition is not null");
            return (Criteria) this;
        }

        public Criteria andS_editionEqualTo(String value) {
            addCriterion("s_edition =", value, "s_edition");
            return (Criteria) this;
        }

        public Criteria andS_editionNotEqualTo(String value) {
            addCriterion("s_edition <>", value, "s_edition");
            return (Criteria) this;
        }

        public Criteria andS_editionGreaterThan(String value) {
            addCriterion("s_edition >", value, "s_edition");
            return (Criteria) this;
        }

        public Criteria andS_editionGreaterThanOrEqualTo(String value) {
            addCriterion("s_edition >=", value, "s_edition");
            return (Criteria) this;
        }

        public Criteria andS_editionLessThan(String value) {
            addCriterion("s_edition <", value, "s_edition");
            return (Criteria) this;
        }

        public Criteria andS_editionLessThanOrEqualTo(String value) {
            addCriterion("s_edition <=", value, "s_edition");
            return (Criteria) this;
        }

        public Criteria andS_editionLike(String value) {
            addCriterion("s_edition like", value, "s_edition");
            return (Criteria) this;
        }

        public Criteria andS_editionNotLike(String value) {
            addCriterion("s_edition not like", value, "s_edition");
            return (Criteria) this;
        }

        public Criteria andS_editionIn(List<String> values) {
            addCriterion("s_edition in", values, "s_edition");
            return (Criteria) this;
        }

        public Criteria andS_editionNotIn(List<String> values) {
            addCriterion("s_edition not in", values, "s_edition");
            return (Criteria) this;
        }

        public Criteria andS_editionBetween(String value1, String value2) {
            addCriterion("s_edition between", value1, value2, "s_edition");
            return (Criteria) this;
        }

        public Criteria andS_editionNotBetween(String value1, String value2) {
            addCriterion("s_edition not between", value1, value2, "s_edition");
            return (Criteria) this;
        }

        public Criteria andS_recordIsNull() {
            addCriterion("s_record is null");
            return (Criteria) this;
        }

        public Criteria andS_recordIsNotNull() {
            addCriterion("s_record is not null");
            return (Criteria) this;
        }

        public Criteria andS_recordEqualTo(String value) {
            addCriterion("s_record =", value, "s_record");
            return (Criteria) this;
        }

        public Criteria andS_recordNotEqualTo(String value) {
            addCriterion("s_record <>", value, "s_record");
            return (Criteria) this;
        }

        public Criteria andS_recordGreaterThan(String value) {
            addCriterion("s_record >", value, "s_record");
            return (Criteria) this;
        }

        public Criteria andS_recordGreaterThanOrEqualTo(String value) {
            addCriterion("s_record >=", value, "s_record");
            return (Criteria) this;
        }

        public Criteria andS_recordLessThan(String value) {
            addCriterion("s_record <", value, "s_record");
            return (Criteria) this;
        }

        public Criteria andS_recordLessThanOrEqualTo(String value) {
            addCriterion("s_record <=", value, "s_record");
            return (Criteria) this;
        }

        public Criteria andS_recordLike(String value) {
            addCriterion("s_record like", value, "s_record");
            return (Criteria) this;
        }

        public Criteria andS_recordNotLike(String value) {
            addCriterion("s_record not like", value, "s_record");
            return (Criteria) this;
        }

        public Criteria andS_recordIn(List<String> values) {
            addCriterion("s_record in", values, "s_record");
            return (Criteria) this;
        }

        public Criteria andS_recordNotIn(List<String> values) {
            addCriterion("s_record not in", values, "s_record");
            return (Criteria) this;
        }

        public Criteria andS_recordBetween(String value1, String value2) {
            addCriterion("s_record between", value1, value2, "s_record");
            return (Criteria) this;
        }

        public Criteria andS_recordNotBetween(String value1, String value2) {
            addCriterion("s_record not between", value1, value2, "s_record");
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