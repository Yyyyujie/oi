package cn.zx.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WechatTmplExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WechatTmplExample() {
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

        public Criteria andTmpl_idIsNull() {
            addCriterion("tmpl_id is null");
            return (Criteria) this;
        }

        public Criteria andTmpl_idIsNotNull() {
            addCriterion("tmpl_id is not null");
            return (Criteria) this;
        }

        public Criteria andTmpl_idEqualTo(Integer value) {
            addCriterion("tmpl_id =", value, "tmpl_id");
            return (Criteria) this;
        }

        public Criteria andTmpl_idNotEqualTo(Integer value) {
            addCriterion("tmpl_id <>", value, "tmpl_id");
            return (Criteria) this;
        }

        public Criteria andTmpl_idGreaterThan(Integer value) {
            addCriterion("tmpl_id >", value, "tmpl_id");
            return (Criteria) this;
        }

        public Criteria andTmpl_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("tmpl_id >=", value, "tmpl_id");
            return (Criteria) this;
        }

        public Criteria andTmpl_idLessThan(Integer value) {
            addCriterion("tmpl_id <", value, "tmpl_id");
            return (Criteria) this;
        }

        public Criteria andTmpl_idLessThanOrEqualTo(Integer value) {
            addCriterion("tmpl_id <=", value, "tmpl_id");
            return (Criteria) this;
        }

        public Criteria andTmpl_idIn(List<Integer> values) {
            addCriterion("tmpl_id in", values, "tmpl_id");
            return (Criteria) this;
        }

        public Criteria andTmpl_idNotIn(List<Integer> values) {
            addCriterion("tmpl_id not in", values, "tmpl_id");
            return (Criteria) this;
        }

        public Criteria andTmpl_idBetween(Integer value1, Integer value2) {
            addCriterion("tmpl_id between", value1, value2, "tmpl_id");
            return (Criteria) this;
        }

        public Criteria andTmpl_idNotBetween(Integer value1, Integer value2) {
            addCriterion("tmpl_id not between", value1, value2, "tmpl_id");
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

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
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

        public Criteria andSerialIsNull() {
            addCriterion("serial is null");
            return (Criteria) this;
        }

        public Criteria andSerialIsNotNull() {
            addCriterion("serial is not null");
            return (Criteria) this;
        }

        public Criteria andSerialEqualTo(String value) {
            addCriterion("serial =", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialNotEqualTo(String value) {
            addCriterion("serial <>", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialGreaterThan(String value) {
            addCriterion("serial >", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialGreaterThanOrEqualTo(String value) {
            addCriterion("serial >=", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialLessThan(String value) {
            addCriterion("serial <", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialLessThanOrEqualTo(String value) {
            addCriterion("serial <=", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialLike(String value) {
            addCriterion("serial like", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialNotLike(String value) {
            addCriterion("serial not like", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialIn(List<String> values) {
            addCriterion("serial in", values, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialNotIn(List<String> values) {
            addCriterion("serial not in", values, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialBetween(String value1, String value2) {
            addCriterion("serial between", value1, value2, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialNotBetween(String value1, String value2) {
            addCriterion("serial not between", value1, value2, "serial");
            return (Criteria) this;
        }

        public Criteria andTemplate_idIsNull() {
            addCriterion("template_id is null");
            return (Criteria) this;
        }

        public Criteria andTemplate_idIsNotNull() {
            addCriterion("template_id is not null");
            return (Criteria) this;
        }

        public Criteria andTemplate_idEqualTo(String value) {
            addCriterion("template_id =", value, "template_id");
            return (Criteria) this;
        }

        public Criteria andTemplate_idNotEqualTo(String value) {
            addCriterion("template_id <>", value, "template_id");
            return (Criteria) this;
        }

        public Criteria andTemplate_idGreaterThan(String value) {
            addCriterion("template_id >", value, "template_id");
            return (Criteria) this;
        }

        public Criteria andTemplate_idGreaterThanOrEqualTo(String value) {
            addCriterion("template_id >=", value, "template_id");
            return (Criteria) this;
        }

        public Criteria andTemplate_idLessThan(String value) {
            addCriterion("template_id <", value, "template_id");
            return (Criteria) this;
        }

        public Criteria andTemplate_idLessThanOrEqualTo(String value) {
            addCriterion("template_id <=", value, "template_id");
            return (Criteria) this;
        }

        public Criteria andTemplate_idLike(String value) {
            addCriterion("template_id like", value, "template_id");
            return (Criteria) this;
        }

        public Criteria andTemplate_idNotLike(String value) {
            addCriterion("template_id not like", value, "template_id");
            return (Criteria) this;
        }

        public Criteria andTemplate_idIn(List<String> values) {
            addCriterion("template_id in", values, "template_id");
            return (Criteria) this;
        }

        public Criteria andTemplate_idNotIn(List<String> values) {
            addCriterion("template_id not in", values, "template_id");
            return (Criteria) this;
        }

        public Criteria andTemplate_idBetween(String value1, String value2) {
            addCriterion("template_id between", value1, value2, "template_id");
            return (Criteria) this;
        }

        public Criteria andTemplate_idNotBetween(String value1, String value2) {
            addCriterion("template_id not between", value1, value2, "template_id");
            return (Criteria) this;
        }

        public Criteria andFirstdataIsNull() {
            addCriterion("firstdata is null");
            return (Criteria) this;
        }

        public Criteria andFirstdataIsNotNull() {
            addCriterion("firstdata is not null");
            return (Criteria) this;
        }

        public Criteria andFirstdataEqualTo(String value) {
            addCriterion("firstdata =", value, "firstdata");
            return (Criteria) this;
        }

        public Criteria andFirstdataNotEqualTo(String value) {
            addCriterion("firstdata <>", value, "firstdata");
            return (Criteria) this;
        }

        public Criteria andFirstdataGreaterThan(String value) {
            addCriterion("firstdata >", value, "firstdata");
            return (Criteria) this;
        }

        public Criteria andFirstdataGreaterThanOrEqualTo(String value) {
            addCriterion("firstdata >=", value, "firstdata");
            return (Criteria) this;
        }

        public Criteria andFirstdataLessThan(String value) {
            addCriterion("firstdata <", value, "firstdata");
            return (Criteria) this;
        }

        public Criteria andFirstdataLessThanOrEqualTo(String value) {
            addCriterion("firstdata <=", value, "firstdata");
            return (Criteria) this;
        }

        public Criteria andFirstdataLike(String value) {
            addCriterion("firstdata like", value, "firstdata");
            return (Criteria) this;
        }

        public Criteria andFirstdataNotLike(String value) {
            addCriterion("firstdata not like", value, "firstdata");
            return (Criteria) this;
        }

        public Criteria andFirstdataIn(List<String> values) {
            addCriterion("firstdata in", values, "firstdata");
            return (Criteria) this;
        }

        public Criteria andFirstdataNotIn(List<String> values) {
            addCriterion("firstdata not in", values, "firstdata");
            return (Criteria) this;
        }

        public Criteria andFirstdataBetween(String value1, String value2) {
            addCriterion("firstdata between", value1, value2, "firstdata");
            return (Criteria) this;
        }

        public Criteria andFirstdataNotBetween(String value1, String value2) {
            addCriterion("firstdata not between", value1, value2, "firstdata");
            return (Criteria) this;
        }

        public Criteria andKeyword1IsNull() {
            addCriterion("keyword1 is null");
            return (Criteria) this;
        }

        public Criteria andKeyword1IsNotNull() {
            addCriterion("keyword1 is not null");
            return (Criteria) this;
        }

        public Criteria andKeyword1EqualTo(String value) {
            addCriterion("keyword1 =", value, "keyword1");
            return (Criteria) this;
        }

        public Criteria andKeyword1NotEqualTo(String value) {
            addCriterion("keyword1 <>", value, "keyword1");
            return (Criteria) this;
        }

        public Criteria andKeyword1GreaterThan(String value) {
            addCriterion("keyword1 >", value, "keyword1");
            return (Criteria) this;
        }

        public Criteria andKeyword1GreaterThanOrEqualTo(String value) {
            addCriterion("keyword1 >=", value, "keyword1");
            return (Criteria) this;
        }

        public Criteria andKeyword1LessThan(String value) {
            addCriterion("keyword1 <", value, "keyword1");
            return (Criteria) this;
        }

        public Criteria andKeyword1LessThanOrEqualTo(String value) {
            addCriterion("keyword1 <=", value, "keyword1");
            return (Criteria) this;
        }

        public Criteria andKeyword1Like(String value) {
            addCriterion("keyword1 like", value, "keyword1");
            return (Criteria) this;
        }

        public Criteria andKeyword1NotLike(String value) {
            addCriterion("keyword1 not like", value, "keyword1");
            return (Criteria) this;
        }

        public Criteria andKeyword1In(List<String> values) {
            addCriterion("keyword1 in", values, "keyword1");
            return (Criteria) this;
        }

        public Criteria andKeyword1NotIn(List<String> values) {
            addCriterion("keyword1 not in", values, "keyword1");
            return (Criteria) this;
        }

        public Criteria andKeyword1Between(String value1, String value2) {
            addCriterion("keyword1 between", value1, value2, "keyword1");
            return (Criteria) this;
        }

        public Criteria andKeyword1NotBetween(String value1, String value2) {
            addCriterion("keyword1 not between", value1, value2, "keyword1");
            return (Criteria) this;
        }

        public Criteria andKeyword2IsNull() {
            addCriterion("keyword2 is null");
            return (Criteria) this;
        }

        public Criteria andKeyword2IsNotNull() {
            addCriterion("keyword2 is not null");
            return (Criteria) this;
        }

        public Criteria andKeyword2EqualTo(String value) {
            addCriterion("keyword2 =", value, "keyword2");
            return (Criteria) this;
        }

        public Criteria andKeyword2NotEqualTo(String value) {
            addCriterion("keyword2 <>", value, "keyword2");
            return (Criteria) this;
        }

        public Criteria andKeyword2GreaterThan(String value) {
            addCriterion("keyword2 >", value, "keyword2");
            return (Criteria) this;
        }

        public Criteria andKeyword2GreaterThanOrEqualTo(String value) {
            addCriterion("keyword2 >=", value, "keyword2");
            return (Criteria) this;
        }

        public Criteria andKeyword2LessThan(String value) {
            addCriterion("keyword2 <", value, "keyword2");
            return (Criteria) this;
        }

        public Criteria andKeyword2LessThanOrEqualTo(String value) {
            addCriterion("keyword2 <=", value, "keyword2");
            return (Criteria) this;
        }

        public Criteria andKeyword2Like(String value) {
            addCriterion("keyword2 like", value, "keyword2");
            return (Criteria) this;
        }

        public Criteria andKeyword2NotLike(String value) {
            addCriterion("keyword2 not like", value, "keyword2");
            return (Criteria) this;
        }

        public Criteria andKeyword2In(List<String> values) {
            addCriterion("keyword2 in", values, "keyword2");
            return (Criteria) this;
        }

        public Criteria andKeyword2NotIn(List<String> values) {
            addCriterion("keyword2 not in", values, "keyword2");
            return (Criteria) this;
        }

        public Criteria andKeyword2Between(String value1, String value2) {
            addCriterion("keyword2 between", value1, value2, "keyword2");
            return (Criteria) this;
        }

        public Criteria andKeyword2NotBetween(String value1, String value2) {
            addCriterion("keyword2 not between", value1, value2, "keyword2");
            return (Criteria) this;
        }

        public Criteria andKeyword3IsNull() {
            addCriterion("keyword3 is null");
            return (Criteria) this;
        }

        public Criteria andKeyword3IsNotNull() {
            addCriterion("keyword3 is not null");
            return (Criteria) this;
        }

        public Criteria andKeyword3EqualTo(String value) {
            addCriterion("keyword3 =", value, "keyword3");
            return (Criteria) this;
        }

        public Criteria andKeyword3NotEqualTo(String value) {
            addCriterion("keyword3 <>", value, "keyword3");
            return (Criteria) this;
        }

        public Criteria andKeyword3GreaterThan(String value) {
            addCriterion("keyword3 >", value, "keyword3");
            return (Criteria) this;
        }

        public Criteria andKeyword3GreaterThanOrEqualTo(String value) {
            addCriterion("keyword3 >=", value, "keyword3");
            return (Criteria) this;
        }

        public Criteria andKeyword3LessThan(String value) {
            addCriterion("keyword3 <", value, "keyword3");
            return (Criteria) this;
        }

        public Criteria andKeyword3LessThanOrEqualTo(String value) {
            addCriterion("keyword3 <=", value, "keyword3");
            return (Criteria) this;
        }

        public Criteria andKeyword3Like(String value) {
            addCriterion("keyword3 like", value, "keyword3");
            return (Criteria) this;
        }

        public Criteria andKeyword3NotLike(String value) {
            addCriterion("keyword3 not like", value, "keyword3");
            return (Criteria) this;
        }

        public Criteria andKeyword3In(List<String> values) {
            addCriterion("keyword3 in", values, "keyword3");
            return (Criteria) this;
        }

        public Criteria andKeyword3NotIn(List<String> values) {
            addCriterion("keyword3 not in", values, "keyword3");
            return (Criteria) this;
        }

        public Criteria andKeyword3Between(String value1, String value2) {
            addCriterion("keyword3 between", value1, value2, "keyword3");
            return (Criteria) this;
        }

        public Criteria andKeyword3NotBetween(String value1, String value2) {
            addCriterion("keyword3 not between", value1, value2, "keyword3");
            return (Criteria) this;
        }

        public Criteria andKeyword4IsNull() {
            addCriterion("keyword4 is null");
            return (Criteria) this;
        }

        public Criteria andKeyword4IsNotNull() {
            addCriterion("keyword4 is not null");
            return (Criteria) this;
        }

        public Criteria andKeyword4EqualTo(String value) {
            addCriterion("keyword4 =", value, "keyword4");
            return (Criteria) this;
        }

        public Criteria andKeyword4NotEqualTo(String value) {
            addCriterion("keyword4 <>", value, "keyword4");
            return (Criteria) this;
        }

        public Criteria andKeyword4GreaterThan(String value) {
            addCriterion("keyword4 >", value, "keyword4");
            return (Criteria) this;
        }

        public Criteria andKeyword4GreaterThanOrEqualTo(String value) {
            addCriterion("keyword4 >=", value, "keyword4");
            return (Criteria) this;
        }

        public Criteria andKeyword4LessThan(String value) {
            addCriterion("keyword4 <", value, "keyword4");
            return (Criteria) this;
        }

        public Criteria andKeyword4LessThanOrEqualTo(String value) {
            addCriterion("keyword4 <=", value, "keyword4");
            return (Criteria) this;
        }

        public Criteria andKeyword4Like(String value) {
            addCriterion("keyword4 like", value, "keyword4");
            return (Criteria) this;
        }

        public Criteria andKeyword4NotLike(String value) {
            addCriterion("keyword4 not like", value, "keyword4");
            return (Criteria) this;
        }

        public Criteria andKeyword4In(List<String> values) {
            addCriterion("keyword4 in", values, "keyword4");
            return (Criteria) this;
        }

        public Criteria andKeyword4NotIn(List<String> values) {
            addCriterion("keyword4 not in", values, "keyword4");
            return (Criteria) this;
        }

        public Criteria andKeyword4Between(String value1, String value2) {
            addCriterion("keyword4 between", value1, value2, "keyword4");
            return (Criteria) this;
        }

        public Criteria andKeyword4NotBetween(String value1, String value2) {
            addCriterion("keyword4 not between", value1, value2, "keyword4");
            return (Criteria) this;
        }

        public Criteria andKeyword5IsNull() {
            addCriterion("keyword5 is null");
            return (Criteria) this;
        }

        public Criteria andKeyword5IsNotNull() {
            addCriterion("keyword5 is not null");
            return (Criteria) this;
        }

        public Criteria andKeyword5EqualTo(String value) {
            addCriterion("keyword5 =", value, "keyword5");
            return (Criteria) this;
        }

        public Criteria andKeyword5NotEqualTo(String value) {
            addCriterion("keyword5 <>", value, "keyword5");
            return (Criteria) this;
        }

        public Criteria andKeyword5GreaterThan(String value) {
            addCriterion("keyword5 >", value, "keyword5");
            return (Criteria) this;
        }

        public Criteria andKeyword5GreaterThanOrEqualTo(String value) {
            addCriterion("keyword5 >=", value, "keyword5");
            return (Criteria) this;
        }

        public Criteria andKeyword5LessThan(String value) {
            addCriterion("keyword5 <", value, "keyword5");
            return (Criteria) this;
        }

        public Criteria andKeyword5LessThanOrEqualTo(String value) {
            addCriterion("keyword5 <=", value, "keyword5");
            return (Criteria) this;
        }

        public Criteria andKeyword5Like(String value) {
            addCriterion("keyword5 like", value, "keyword5");
            return (Criteria) this;
        }

        public Criteria andKeyword5NotLike(String value) {
            addCriterion("keyword5 not like", value, "keyword5");
            return (Criteria) this;
        }

        public Criteria andKeyword5In(List<String> values) {
            addCriterion("keyword5 in", values, "keyword5");
            return (Criteria) this;
        }

        public Criteria andKeyword5NotIn(List<String> values) {
            addCriterion("keyword5 not in", values, "keyword5");
            return (Criteria) this;
        }

        public Criteria andKeyword5Between(String value1, String value2) {
            addCriterion("keyword5 between", value1, value2, "keyword5");
            return (Criteria) this;
        }

        public Criteria andKeyword5NotBetween(String value1, String value2) {
            addCriterion("keyword5 not between", value1, value2, "keyword5");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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