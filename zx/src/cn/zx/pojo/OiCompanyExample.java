package cn.zx.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OiCompanyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OiCompanyExample() {
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

        public Criteria andCity_idIsNull() {
            addCriterion("city_id is null");
            return (Criteria) this;
        }

        public Criteria andCity_idIsNotNull() {
            addCriterion("city_id is not null");
            return (Criteria) this;
        }

        public Criteria andCity_idEqualTo(Integer value) {
            addCriterion("city_id =", value, "city_id");
            return (Criteria) this;
        }

        public Criteria andCity_idNotEqualTo(Integer value) {
            addCriterion("city_id <>", value, "city_id");
            return (Criteria) this;
        }

        public Criteria andCity_idGreaterThan(Integer value) {
            addCriterion("city_id >", value, "city_id");
            return (Criteria) this;
        }

        public Criteria andCity_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("city_id >=", value, "city_id");
            return (Criteria) this;
        }

        public Criteria andCity_idLessThan(Integer value) {
            addCriterion("city_id <", value, "city_id");
            return (Criteria) this;
        }

        public Criteria andCity_idLessThanOrEqualTo(Integer value) {
            addCriterion("city_id <=", value, "city_id");
            return (Criteria) this;
        }

        public Criteria andCity_idIn(List<Integer> values) {
            addCriterion("city_id in", values, "city_id");
            return (Criteria) this;
        }

        public Criteria andCity_idNotIn(List<Integer> values) {
            addCriterion("city_id not in", values, "city_id");
            return (Criteria) this;
        }

        public Criteria andCity_idBetween(Integer value1, Integer value2) {
            addCriterion("city_id between", value1, value2, "city_id");
            return (Criteria) this;
        }

        public Criteria andCity_idNotBetween(Integer value1, Integer value2) {
            addCriterion("city_id not between", value1, value2, "city_id");
            return (Criteria) this;
        }

        public Criteria andArea_idIsNull() {
            addCriterion("area_id is null");
            return (Criteria) this;
        }

        public Criteria andArea_idIsNotNull() {
            addCriterion("area_id is not null");
            return (Criteria) this;
        }

        public Criteria andArea_idEqualTo(Integer value) {
            addCriterion("area_id =", value, "area_id");
            return (Criteria) this;
        }

        public Criteria andArea_idNotEqualTo(Integer value) {
            addCriterion("area_id <>", value, "area_id");
            return (Criteria) this;
        }

        public Criteria andArea_idGreaterThan(Integer value) {
            addCriterion("area_id >", value, "area_id");
            return (Criteria) this;
        }

        public Criteria andArea_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("area_id >=", value, "area_id");
            return (Criteria) this;
        }

        public Criteria andArea_idLessThan(Integer value) {
            addCriterion("area_id <", value, "area_id");
            return (Criteria) this;
        }

        public Criteria andArea_idLessThanOrEqualTo(Integer value) {
            addCriterion("area_id <=", value, "area_id");
            return (Criteria) this;
        }

        public Criteria andArea_idIn(List<Integer> values) {
            addCriterion("area_id in", values, "area_id");
            return (Criteria) this;
        }

        public Criteria andArea_idNotIn(List<Integer> values) {
            addCriterion("area_id not in", values, "area_id");
            return (Criteria) this;
        }

        public Criteria andArea_idBetween(Integer value1, Integer value2) {
            addCriterion("area_id between", value1, value2, "area_id");
            return (Criteria) this;
        }

        public Criteria andArea_idNotBetween(Integer value1, Integer value2) {
            addCriterion("area_id not between", value1, value2, "area_id");
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

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
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

        public Criteria andCorporate_repIsNull() {
            addCriterion("corporate_rep is null");
            return (Criteria) this;
        }

        public Criteria andCorporate_repIsNotNull() {
            addCriterion("corporate_rep is not null");
            return (Criteria) this;
        }

        public Criteria andCorporate_repEqualTo(String value) {
            addCriterion("corporate_rep =", value, "corporate_rep");
            return (Criteria) this;
        }

        public Criteria andCorporate_repNotEqualTo(String value) {
            addCriterion("corporate_rep <>", value, "corporate_rep");
            return (Criteria) this;
        }

        public Criteria andCorporate_repGreaterThan(String value) {
            addCriterion("corporate_rep >", value, "corporate_rep");
            return (Criteria) this;
        }

        public Criteria andCorporate_repGreaterThanOrEqualTo(String value) {
            addCriterion("corporate_rep >=", value, "corporate_rep");
            return (Criteria) this;
        }

        public Criteria andCorporate_repLessThan(String value) {
            addCriterion("corporate_rep <", value, "corporate_rep");
            return (Criteria) this;
        }

        public Criteria andCorporate_repLessThanOrEqualTo(String value) {
            addCriterion("corporate_rep <=", value, "corporate_rep");
            return (Criteria) this;
        }

        public Criteria andCorporate_repLike(String value) {
            addCriterion("corporate_rep like", value, "corporate_rep");
            return (Criteria) this;
        }

        public Criteria andCorporate_repNotLike(String value) {
            addCriterion("corporate_rep not like", value, "corporate_rep");
            return (Criteria) this;
        }

        public Criteria andCorporate_repIn(List<String> values) {
            addCriterion("corporate_rep in", values, "corporate_rep");
            return (Criteria) this;
        }

        public Criteria andCorporate_repNotIn(List<String> values) {
            addCriterion("corporate_rep not in", values, "corporate_rep");
            return (Criteria) this;
        }

        public Criteria andCorporate_repBetween(String value1, String value2) {
            addCriterion("corporate_rep between", value1, value2, "corporate_rep");
            return (Criteria) this;
        }

        public Criteria andCorporate_repNotBetween(String value1, String value2) {
            addCriterion("corporate_rep not between", value1, value2, "corporate_rep");
            return (Criteria) this;
        }

        public Criteria andContactIsNull() {
            addCriterion("contact is null");
            return (Criteria) this;
        }

        public Criteria andContactIsNotNull() {
            addCriterion("contact is not null");
            return (Criteria) this;
        }

        public Criteria andContactEqualTo(String value) {
            addCriterion("contact =", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotEqualTo(String value) {
            addCriterion("contact <>", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThan(String value) {
            addCriterion("contact >", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThanOrEqualTo(String value) {
            addCriterion("contact >=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThan(String value) {
            addCriterion("contact <", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThanOrEqualTo(String value) {
            addCriterion("contact <=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLike(String value) {
            addCriterion("contact like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotLike(String value) {
            addCriterion("contact not like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactIn(List<String> values) {
            addCriterion("contact in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotIn(List<String> values) {
            addCriterion("contact not in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactBetween(String value1, String value2) {
            addCriterion("contact between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotBetween(String value1, String value2) {
            addCriterion("contact not between", value1, value2, "contact");
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

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
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

        public Criteria andLogoIsNull() {
            addCriterion("logo is null");
            return (Criteria) this;
        }

        public Criteria andLogoIsNotNull() {
            addCriterion("logo is not null");
            return (Criteria) this;
        }

        public Criteria andLogoEqualTo(String value) {
            addCriterion("logo =", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotEqualTo(String value) {
            addCriterion("logo <>", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoGreaterThan(String value) {
            addCriterion("logo >", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoGreaterThanOrEqualTo(String value) {
            addCriterion("logo >=", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLessThan(String value) {
            addCriterion("logo <", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLessThanOrEqualTo(String value) {
            addCriterion("logo <=", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLike(String value) {
            addCriterion("logo like", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotLike(String value) {
            addCriterion("logo not like", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoIn(List<String> values) {
            addCriterion("logo in", values, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotIn(List<String> values) {
            addCriterion("logo not in", values, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoBetween(String value1, String value2) {
            addCriterion("logo between", value1, value2, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotBetween(String value1, String value2) {
            addCriterion("logo not between", value1, value2, "logo");
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

        public Criteria andAuditIsNull() {
            addCriterion("audit is null");
            return (Criteria) this;
        }

        public Criteria andAuditIsNotNull() {
            addCriterion("audit is not null");
            return (Criteria) this;
        }

        public Criteria andAuditEqualTo(Integer value) {
            addCriterion("audit =", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditNotEqualTo(Integer value) {
            addCriterion("audit <>", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditGreaterThan(Integer value) {
            addCriterion("audit >", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditGreaterThanOrEqualTo(Integer value) {
            addCriterion("audit >=", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditLessThan(Integer value) {
            addCriterion("audit <", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditLessThanOrEqualTo(Integer value) {
            addCriterion("audit <=", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditIn(List<Integer> values) {
            addCriterion("audit in", values, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditNotIn(List<Integer> values) {
            addCriterion("audit not in", values, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditBetween(Integer value1, Integer value2) {
            addCriterion("audit between", value1, value2, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditNotBetween(Integer value1, Integer value2) {
            addCriterion("audit not between", value1, value2, "audit");
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

        public Criteria andAudit_timeIsNull() {
            addCriterion("audit_time is null");
            return (Criteria) this;
        }

        public Criteria andAudit_timeIsNotNull() {
            addCriterion("audit_time is not null");
            return (Criteria) this;
        }

        public Criteria andAudit_timeEqualTo(Date value) {
            addCriterion("audit_time =", value, "audit_time");
            return (Criteria) this;
        }

        public Criteria andAudit_timeNotEqualTo(Date value) {
            addCriterion("audit_time <>", value, "audit_time");
            return (Criteria) this;
        }

        public Criteria andAudit_timeGreaterThan(Date value) {
            addCriterion("audit_time >", value, "audit_time");
            return (Criteria) this;
        }

        public Criteria andAudit_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("audit_time >=", value, "audit_time");
            return (Criteria) this;
        }

        public Criteria andAudit_timeLessThan(Date value) {
            addCriterion("audit_time <", value, "audit_time");
            return (Criteria) this;
        }

        public Criteria andAudit_timeLessThanOrEqualTo(Date value) {
            addCriterion("audit_time <=", value, "audit_time");
            return (Criteria) this;
        }

        public Criteria andAudit_timeIn(List<Date> values) {
            addCriterion("audit_time in", values, "audit_time");
            return (Criteria) this;
        }

        public Criteria andAudit_timeNotIn(List<Date> values) {
            addCriterion("audit_time not in", values, "audit_time");
            return (Criteria) this;
        }

        public Criteria andAudit_timeBetween(Date value1, Date value2) {
            addCriterion("audit_time between", value1, value2, "audit_time");
            return (Criteria) this;
        }

        public Criteria andAudit_timeNotBetween(Date value1, Date value2) {
            addCriterion("audit_time not between", value1, value2, "audit_time");
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