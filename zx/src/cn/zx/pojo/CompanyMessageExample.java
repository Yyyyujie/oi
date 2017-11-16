package cn.zx.pojo;

import java.util.ArrayList;
import java.util.List;

public class CompanyMessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompanyMessageExample() {
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

        public Criteria andM_idIsNull() {
            addCriterion("m_id is null");
            return (Criteria) this;
        }

        public Criteria andM_idIsNotNull() {
            addCriterion("m_id is not null");
            return (Criteria) this;
        }

        public Criteria andM_idEqualTo(Integer value) {
            addCriterion("m_id =", value, "m_id");
            return (Criteria) this;
        }

        public Criteria andM_idNotEqualTo(Integer value) {
            addCriterion("m_id <>", value, "m_id");
            return (Criteria) this;
        }

        public Criteria andM_idGreaterThan(Integer value) {
            addCriterion("m_id >", value, "m_id");
            return (Criteria) this;
        }

        public Criteria andM_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("m_id >=", value, "m_id");
            return (Criteria) this;
        }

        public Criteria andM_idLessThan(Integer value) {
            addCriterion("m_id <", value, "m_id");
            return (Criteria) this;
        }

        public Criteria andM_idLessThanOrEqualTo(Integer value) {
            addCriterion("m_id <=", value, "m_id");
            return (Criteria) this;
        }

        public Criteria andM_idIn(List<Integer> values) {
            addCriterion("m_id in", values, "m_id");
            return (Criteria) this;
        }

        public Criteria andM_idNotIn(List<Integer> values) {
            addCriterion("m_id not in", values, "m_id");
            return (Criteria) this;
        }

        public Criteria andM_idBetween(Integer value1, Integer value2) {
            addCriterion("m_id between", value1, value2, "m_id");
            return (Criteria) this;
        }

        public Criteria andM_idNotBetween(Integer value1, Integer value2) {
            addCriterion("m_id not between", value1, value2, "m_id");
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

        public Criteria andType_idIsNull() {
            addCriterion("type_id is null");
            return (Criteria) this;
        }

        public Criteria andType_idIsNotNull() {
            addCriterion("type_id is not null");
            return (Criteria) this;
        }

        public Criteria andType_idEqualTo(Integer value) {
            addCriterion("type_id =", value, "type_id");
            return (Criteria) this;
        }

        public Criteria andType_idNotEqualTo(Integer value) {
            addCriterion("type_id <>", value, "type_id");
            return (Criteria) this;
        }

        public Criteria andType_idGreaterThan(Integer value) {
            addCriterion("type_id >", value, "type_id");
            return (Criteria) this;
        }

        public Criteria andType_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("type_id >=", value, "type_id");
            return (Criteria) this;
        }

        public Criteria andType_idLessThan(Integer value) {
            addCriterion("type_id <", value, "type_id");
            return (Criteria) this;
        }

        public Criteria andType_idLessThanOrEqualTo(Integer value) {
            addCriterion("type_id <=", value, "type_id");
            return (Criteria) this;
        }

        public Criteria andType_idIn(List<Integer> values) {
            addCriterion("type_id in", values, "type_id");
            return (Criteria) this;
        }

        public Criteria andType_idNotIn(List<Integer> values) {
            addCriterion("type_id not in", values, "type_id");
            return (Criteria) this;
        }

        public Criteria andType_idBetween(Integer value1, Integer value2) {
            addCriterion("type_id between", value1, value2, "type_id");
            return (Criteria) this;
        }

        public Criteria andType_idNotBetween(Integer value1, Integer value2) {
            addCriterion("type_id not between", value1, value2, "type_id");
            return (Criteria) this;
        }

        public Criteria andType_nameIsNull() {
            addCriterion("type_name is null");
            return (Criteria) this;
        }

        public Criteria andType_nameIsNotNull() {
            addCriterion("type_name is not null");
            return (Criteria) this;
        }

        public Criteria andType_nameEqualTo(String value) {
            addCriterion("type_name =", value, "type_name");
            return (Criteria) this;
        }

        public Criteria andType_nameNotEqualTo(String value) {
            addCriterion("type_name <>", value, "type_name");
            return (Criteria) this;
        }

        public Criteria andType_nameGreaterThan(String value) {
            addCriterion("type_name >", value, "type_name");
            return (Criteria) this;
        }

        public Criteria andType_nameGreaterThanOrEqualTo(String value) {
            addCriterion("type_name >=", value, "type_name");
            return (Criteria) this;
        }

        public Criteria andType_nameLessThan(String value) {
            addCriterion("type_name <", value, "type_name");
            return (Criteria) this;
        }

        public Criteria andType_nameLessThanOrEqualTo(String value) {
            addCriterion("type_name <=", value, "type_name");
            return (Criteria) this;
        }

        public Criteria andType_nameLike(String value) {
            addCriterion("type_name like", value, "type_name");
            return (Criteria) this;
        }

        public Criteria andType_nameNotLike(String value) {
            addCriterion("type_name not like", value, "type_name");
            return (Criteria) this;
        }

        public Criteria andType_nameIn(List<String> values) {
            addCriterion("type_name in", values, "type_name");
            return (Criteria) this;
        }

        public Criteria andType_nameNotIn(List<String> values) {
            addCriterion("type_name not in", values, "type_name");
            return (Criteria) this;
        }

        public Criteria andType_nameBetween(String value1, String value2) {
            addCriterion("type_name between", value1, value2, "type_name");
            return (Criteria) this;
        }

        public Criteria andType_nameNotBetween(String value1, String value2) {
            addCriterion("type_name not between", value1, value2, "type_name");
            return (Criteria) this;
        }

        public Criteria andCompany_numIsNull() {
            addCriterion("company_num is null");
            return (Criteria) this;
        }

        public Criteria andCompany_numIsNotNull() {
            addCriterion("company_num is not null");
            return (Criteria) this;
        }

        public Criteria andCompany_numEqualTo(Integer value) {
            addCriterion("company_num =", value, "company_num");
            return (Criteria) this;
        }

        public Criteria andCompany_numNotEqualTo(Integer value) {
            addCriterion("company_num <>", value, "company_num");
            return (Criteria) this;
        }

        public Criteria andCompany_numGreaterThan(Integer value) {
            addCriterion("company_num >", value, "company_num");
            return (Criteria) this;
        }

        public Criteria andCompany_numGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_num >=", value, "company_num");
            return (Criteria) this;
        }

        public Criteria andCompany_numLessThan(Integer value) {
            addCriterion("company_num <", value, "company_num");
            return (Criteria) this;
        }

        public Criteria andCompany_numLessThanOrEqualTo(Integer value) {
            addCriterion("company_num <=", value, "company_num");
            return (Criteria) this;
        }

        public Criteria andCompany_numIn(List<Integer> values) {
            addCriterion("company_num in", values, "company_num");
            return (Criteria) this;
        }

        public Criteria andCompany_numNotIn(List<Integer> values) {
            addCriterion("company_num not in", values, "company_num");
            return (Criteria) this;
        }

        public Criteria andCompany_numBetween(Integer value1, Integer value2) {
            addCriterion("company_num between", value1, value2, "company_num");
            return (Criteria) this;
        }

        public Criteria andCompany_numNotBetween(Integer value1, Integer value2) {
            addCriterion("company_num not between", value1, value2, "company_num");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andAddrIsNull() {
            addCriterion("addr is null");
            return (Criteria) this;
        }

        public Criteria andAddrIsNotNull() {
            addCriterion("addr is not null");
            return (Criteria) this;
        }

        public Criteria andAddrEqualTo(String value) {
            addCriterion("addr =", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotEqualTo(String value) {
            addCriterion("addr <>", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrGreaterThan(String value) {
            addCriterion("addr >", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrGreaterThanOrEqualTo(String value) {
            addCriterion("addr >=", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLessThan(String value) {
            addCriterion("addr <", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLessThanOrEqualTo(String value) {
            addCriterion("addr <=", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLike(String value) {
            addCriterion("addr like", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotLike(String value) {
            addCriterion("addr not like", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrIn(List<String> values) {
            addCriterion("addr in", values, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotIn(List<String> values) {
            addCriterion("addr not in", values, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrBetween(String value1, String value2) {
            addCriterion("addr between", value1, value2, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotBetween(String value1, String value2) {
            addCriterion("addr not between", value1, value2, "addr");
            return (Criteria) this;
        }

        public Criteria andContactsIsNull() {
            addCriterion("contacts is null");
            return (Criteria) this;
        }

        public Criteria andContactsIsNotNull() {
            addCriterion("contacts is not null");
            return (Criteria) this;
        }

        public Criteria andContactsEqualTo(String value) {
            addCriterion("contacts =", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotEqualTo(String value) {
            addCriterion("contacts <>", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsGreaterThan(String value) {
            addCriterion("contacts >", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsGreaterThanOrEqualTo(String value) {
            addCriterion("contacts >=", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsLessThan(String value) {
            addCriterion("contacts <", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsLessThanOrEqualTo(String value) {
            addCriterion("contacts <=", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsLike(String value) {
            addCriterion("contacts like", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotLike(String value) {
            addCriterion("contacts not like", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsIn(List<String> values) {
            addCriterion("contacts in", values, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotIn(List<String> values) {
            addCriterion("contacts not in", values, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsBetween(String value1, String value2) {
            addCriterion("contacts between", value1, value2, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotBetween(String value1, String value2) {
            addCriterion("contacts not between", value1, value2, "contacts");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(Integer value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(Integer value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(Integer value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(Integer value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(Integer value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(Integer value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<Integer> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<Integer> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(Integer value1, Integer value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(Integer value1, Integer value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andLicense_idIsNull() {
            addCriterion("license_id is null");
            return (Criteria) this;
        }

        public Criteria andLicense_idIsNotNull() {
            addCriterion("license_id is not null");
            return (Criteria) this;
        }

        public Criteria andLicense_idEqualTo(String value) {
            addCriterion("license_id =", value, "license_id");
            return (Criteria) this;
        }

        public Criteria andLicense_idNotEqualTo(String value) {
            addCriterion("license_id <>", value, "license_id");
            return (Criteria) this;
        }

        public Criteria andLicense_idGreaterThan(String value) {
            addCriterion("license_id >", value, "license_id");
            return (Criteria) this;
        }

        public Criteria andLicense_idGreaterThanOrEqualTo(String value) {
            addCriterion("license_id >=", value, "license_id");
            return (Criteria) this;
        }

        public Criteria andLicense_idLessThan(String value) {
            addCriterion("license_id <", value, "license_id");
            return (Criteria) this;
        }

        public Criteria andLicense_idLessThanOrEqualTo(String value) {
            addCriterion("license_id <=", value, "license_id");
            return (Criteria) this;
        }

        public Criteria andLicense_idLike(String value) {
            addCriterion("license_id like", value, "license_id");
            return (Criteria) this;
        }

        public Criteria andLicense_idNotLike(String value) {
            addCriterion("license_id not like", value, "license_id");
            return (Criteria) this;
        }

        public Criteria andLicense_idIn(List<String> values) {
            addCriterion("license_id in", values, "license_id");
            return (Criteria) this;
        }

        public Criteria andLicense_idNotIn(List<String> values) {
            addCriterion("license_id not in", values, "license_id");
            return (Criteria) this;
        }

        public Criteria andLicense_idBetween(String value1, String value2) {
            addCriterion("license_id between", value1, value2, "license_id");
            return (Criteria) this;
        }

        public Criteria andLicense_idNotBetween(String value1, String value2) {
            addCriterion("license_id not between", value1, value2, "license_id");
            return (Criteria) this;
        }

        public Criteria andLicense_imgIsNull() {
            addCriterion("license_img is null");
            return (Criteria) this;
        }

        public Criteria andLicense_imgIsNotNull() {
            addCriterion("license_img is not null");
            return (Criteria) this;
        }

        public Criteria andLicense_imgEqualTo(String value) {
            addCriterion("license_img =", value, "license_img");
            return (Criteria) this;
        }

        public Criteria andLicense_imgNotEqualTo(String value) {
            addCriterion("license_img <>", value, "license_img");
            return (Criteria) this;
        }

        public Criteria andLicense_imgGreaterThan(String value) {
            addCriterion("license_img >", value, "license_img");
            return (Criteria) this;
        }

        public Criteria andLicense_imgGreaterThanOrEqualTo(String value) {
            addCriterion("license_img >=", value, "license_img");
            return (Criteria) this;
        }

        public Criteria andLicense_imgLessThan(String value) {
            addCriterion("license_img <", value, "license_img");
            return (Criteria) this;
        }

        public Criteria andLicense_imgLessThanOrEqualTo(String value) {
            addCriterion("license_img <=", value, "license_img");
            return (Criteria) this;
        }

        public Criteria andLicense_imgLike(String value) {
            addCriterion("license_img like", value, "license_img");
            return (Criteria) this;
        }

        public Criteria andLicense_imgNotLike(String value) {
            addCriterion("license_img not like", value, "license_img");
            return (Criteria) this;
        }

        public Criteria andLicense_imgIn(List<String> values) {
            addCriterion("license_img in", values, "license_img");
            return (Criteria) this;
        }

        public Criteria andLicense_imgNotIn(List<String> values) {
            addCriterion("license_img not in", values, "license_img");
            return (Criteria) this;
        }

        public Criteria andLicense_imgBetween(String value1, String value2) {
            addCriterion("license_img between", value1, value2, "license_img");
            return (Criteria) this;
        }

        public Criteria andLicense_imgNotBetween(String value1, String value2) {
            addCriterion("license_img not between", value1, value2, "license_img");
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