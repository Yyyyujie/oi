package cn.zx.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompanyTaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompanyTaskExample() {
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

        public Criteria andTask_idIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTask_idIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTask_idEqualTo(Integer value) {
            addCriterion("task_id =", value, "task_id");
            return (Criteria) this;
        }

        public Criteria andTask_idNotEqualTo(Integer value) {
            addCriterion("task_id <>", value, "task_id");
            return (Criteria) this;
        }

        public Criteria andTask_idGreaterThan(Integer value) {
            addCriterion("task_id >", value, "task_id");
            return (Criteria) this;
        }

        public Criteria andTask_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_id >=", value, "task_id");
            return (Criteria) this;
        }

        public Criteria andTask_idLessThan(Integer value) {
            addCriterion("task_id <", value, "task_id");
            return (Criteria) this;
        }

        public Criteria andTask_idLessThanOrEqualTo(Integer value) {
            addCriterion("task_id <=", value, "task_id");
            return (Criteria) this;
        }

        public Criteria andTask_idIn(List<Integer> values) {
            addCriterion("task_id in", values, "task_id");
            return (Criteria) this;
        }

        public Criteria andTask_idNotIn(List<Integer> values) {
            addCriterion("task_id not in", values, "task_id");
            return (Criteria) this;
        }

        public Criteria andTask_idBetween(Integer value1, Integer value2) {
            addCriterion("task_id between", value1, value2, "task_id");
            return (Criteria) this;
        }

        public Criteria andTask_idNotBetween(Integer value1, Integer value2) {
            addCriterion("task_id not between", value1, value2, "task_id");
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

        public Criteria andTask_titleIsNull() {
            addCriterion("task_title is null");
            return (Criteria) this;
        }

        public Criteria andTask_titleIsNotNull() {
            addCriterion("task_title is not null");
            return (Criteria) this;
        }

        public Criteria andTask_titleEqualTo(String value) {
            addCriterion("task_title =", value, "task_title");
            return (Criteria) this;
        }

        public Criteria andTask_titleNotEqualTo(String value) {
            addCriterion("task_title <>", value, "task_title");
            return (Criteria) this;
        }

        public Criteria andTask_titleGreaterThan(String value) {
            addCriterion("task_title >", value, "task_title");
            return (Criteria) this;
        }

        public Criteria andTask_titleGreaterThanOrEqualTo(String value) {
            addCriterion("task_title >=", value, "task_title");
            return (Criteria) this;
        }

        public Criteria andTask_titleLessThan(String value) {
            addCriterion("task_title <", value, "task_title");
            return (Criteria) this;
        }

        public Criteria andTask_titleLessThanOrEqualTo(String value) {
            addCriterion("task_title <=", value, "task_title");
            return (Criteria) this;
        }

        public Criteria andTask_titleLike(String value) {
            addCriterion("task_title like", value, "task_title");
            return (Criteria) this;
        }

        public Criteria andTask_titleNotLike(String value) {
            addCriterion("task_title not like", value, "task_title");
            return (Criteria) this;
        }

        public Criteria andTask_titleIn(List<String> values) {
            addCriterion("task_title in", values, "task_title");
            return (Criteria) this;
        }

        public Criteria andTask_titleNotIn(List<String> values) {
            addCriterion("task_title not in", values, "task_title");
            return (Criteria) this;
        }

        public Criteria andTask_titleBetween(String value1, String value2) {
            addCriterion("task_title between", value1, value2, "task_title");
            return (Criteria) this;
        }

        public Criteria andTask_titleNotBetween(String value1, String value2) {
            addCriterion("task_title not between", value1, value2, "task_title");
            return (Criteria) this;
        }

        public Criteria andTo_userIsNull() {
            addCriterion("to_user is null");
            return (Criteria) this;
        }

        public Criteria andTo_userIsNotNull() {
            addCriterion("to_user is not null");
            return (Criteria) this;
        }

        public Criteria andTo_userEqualTo(Integer value) {
            addCriterion("to_user =", value, "to_user");
            return (Criteria) this;
        }

        public Criteria andTo_userNotEqualTo(Integer value) {
            addCriterion("to_user <>", value, "to_user");
            return (Criteria) this;
        }

        public Criteria andTo_userGreaterThan(Integer value) {
            addCriterion("to_user >", value, "to_user");
            return (Criteria) this;
        }

        public Criteria andTo_userGreaterThanOrEqualTo(Integer value) {
            addCriterion("to_user >=", value, "to_user");
            return (Criteria) this;
        }

        public Criteria andTo_userLessThan(Integer value) {
            addCriterion("to_user <", value, "to_user");
            return (Criteria) this;
        }

        public Criteria andTo_userLessThanOrEqualTo(Integer value) {
            addCriterion("to_user <=", value, "to_user");
            return (Criteria) this;
        }

        public Criteria andTo_userIn(List<Integer> values) {
            addCriterion("to_user in", values, "to_user");
            return (Criteria) this;
        }

        public Criteria andTo_userNotIn(List<Integer> values) {
            addCriterion("to_user not in", values, "to_user");
            return (Criteria) this;
        }

        public Criteria andTo_userBetween(Integer value1, Integer value2) {
            addCriterion("to_user between", value1, value2, "to_user");
            return (Criteria) this;
        }

        public Criteria andTo_userNotBetween(Integer value1, Integer value2) {
            addCriterion("to_user not between", value1, value2, "to_user");
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

        public Criteria andTask_objIsNull() {
            addCriterion("task_obj is null");
            return (Criteria) this;
        }

        public Criteria andTask_objIsNotNull() {
            addCriterion("task_obj is not null");
            return (Criteria) this;
        }

        public Criteria andTask_objEqualTo(Integer value) {
            addCriterion("task_obj =", value, "task_obj");
            return (Criteria) this;
        }

        public Criteria andTask_objNotEqualTo(Integer value) {
            addCriterion("task_obj <>", value, "task_obj");
            return (Criteria) this;
        }

        public Criteria andTask_objGreaterThan(Integer value) {
            addCriterion("task_obj >", value, "task_obj");
            return (Criteria) this;
        }

        public Criteria andTask_objGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_obj >=", value, "task_obj");
            return (Criteria) this;
        }

        public Criteria andTask_objLessThan(Integer value) {
            addCriterion("task_obj <", value, "task_obj");
            return (Criteria) this;
        }

        public Criteria andTask_objLessThanOrEqualTo(Integer value) {
            addCriterion("task_obj <=", value, "task_obj");
            return (Criteria) this;
        }

        public Criteria andTask_objIn(List<Integer> values) {
            addCriterion("task_obj in", values, "task_obj");
            return (Criteria) this;
        }

        public Criteria andTask_objNotIn(List<Integer> values) {
            addCriterion("task_obj not in", values, "task_obj");
            return (Criteria) this;
        }

        public Criteria andTask_objBetween(Integer value1, Integer value2) {
            addCriterion("task_obj between", value1, value2, "task_obj");
            return (Criteria) this;
        }

        public Criteria andTask_objNotBetween(Integer value1, Integer value2) {
            addCriterion("task_obj not between", value1, value2, "task_obj");
            return (Criteria) this;
        }

        public Criteria andTask_create_timeIsNull() {
            addCriterion("task_create_time is null");
            return (Criteria) this;
        }

        public Criteria andTask_create_timeIsNotNull() {
            addCriterion("task_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andTask_create_timeEqualTo(Date value) {
            addCriterion("task_create_time =", value, "task_create_time");
            return (Criteria) this;
        }

        public Criteria andTask_create_timeNotEqualTo(Date value) {
            addCriterion("task_create_time <>", value, "task_create_time");
            return (Criteria) this;
        }

        public Criteria andTask_create_timeGreaterThan(Date value) {
            addCriterion("task_create_time >", value, "task_create_time");
            return (Criteria) this;
        }

        public Criteria andTask_create_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("task_create_time >=", value, "task_create_time");
            return (Criteria) this;
        }

        public Criteria andTask_create_timeLessThan(Date value) {
            addCriterion("task_create_time <", value, "task_create_time");
            return (Criteria) this;
        }

        public Criteria andTask_create_timeLessThanOrEqualTo(Date value) {
            addCriterion("task_create_time <=", value, "task_create_time");
            return (Criteria) this;
        }

        public Criteria andTask_create_timeIn(List<Date> values) {
            addCriterion("task_create_time in", values, "task_create_time");
            return (Criteria) this;
        }

        public Criteria andTask_create_timeNotIn(List<Date> values) {
            addCriterion("task_create_time not in", values, "task_create_time");
            return (Criteria) this;
        }

        public Criteria andTask_create_timeBetween(Date value1, Date value2) {
            addCriterion("task_create_time between", value1, value2, "task_create_time");
            return (Criteria) this;
        }

        public Criteria andTask_create_timeNotBetween(Date value1, Date value2) {
            addCriterion("task_create_time not between", value1, value2, "task_create_time");
            return (Criteria) this;
        }

        public Criteria andTask_accept_timeIsNull() {
            addCriterion("task_accept_time is null");
            return (Criteria) this;
        }

        public Criteria andTask_accept_timeIsNotNull() {
            addCriterion("task_accept_time is not null");
            return (Criteria) this;
        }

        public Criteria andTask_accept_timeEqualTo(Date value) {
            addCriterion("task_accept_time =", value, "task_accept_time");
            return (Criteria) this;
        }

        public Criteria andTask_accept_timeNotEqualTo(Date value) {
            addCriterion("task_accept_time <>", value, "task_accept_time");
            return (Criteria) this;
        }

        public Criteria andTask_accept_timeGreaterThan(Date value) {
            addCriterion("task_accept_time >", value, "task_accept_time");
            return (Criteria) this;
        }

        public Criteria andTask_accept_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("task_accept_time >=", value, "task_accept_time");
            return (Criteria) this;
        }

        public Criteria andTask_accept_timeLessThan(Date value) {
            addCriterion("task_accept_time <", value, "task_accept_time");
            return (Criteria) this;
        }

        public Criteria andTask_accept_timeLessThanOrEqualTo(Date value) {
            addCriterion("task_accept_time <=", value, "task_accept_time");
            return (Criteria) this;
        }

        public Criteria andTask_accept_timeIn(List<Date> values) {
            addCriterion("task_accept_time in", values, "task_accept_time");
            return (Criteria) this;
        }

        public Criteria andTask_accept_timeNotIn(List<Date> values) {
            addCriterion("task_accept_time not in", values, "task_accept_time");
            return (Criteria) this;
        }

        public Criteria andTask_accept_timeBetween(Date value1, Date value2) {
            addCriterion("task_accept_time between", value1, value2, "task_accept_time");
            return (Criteria) this;
        }

        public Criteria andTask_accept_timeNotBetween(Date value1, Date value2) {
            addCriterion("task_accept_time not between", value1, value2, "task_accept_time");
            return (Criteria) this;
        }

        public Criteria andTask_start_timeIsNull() {
            addCriterion("task_start_time is null");
            return (Criteria) this;
        }

        public Criteria andTask_start_timeIsNotNull() {
            addCriterion("task_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andTask_start_timeEqualTo(Date value) {
            addCriterion("task_start_time =", value, "task_start_time");
            return (Criteria) this;
        }

        public Criteria andTask_start_timeNotEqualTo(Date value) {
            addCriterion("task_start_time <>", value, "task_start_time");
            return (Criteria) this;
        }

        public Criteria andTask_start_timeGreaterThan(Date value) {
            addCriterion("task_start_time >", value, "task_start_time");
            return (Criteria) this;
        }

        public Criteria andTask_start_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("task_start_time >=", value, "task_start_time");
            return (Criteria) this;
        }

        public Criteria andTask_start_timeLessThan(Date value) {
            addCriterion("task_start_time <", value, "task_start_time");
            return (Criteria) this;
        }

        public Criteria andTask_start_timeLessThanOrEqualTo(Date value) {
            addCriterion("task_start_time <=", value, "task_start_time");
            return (Criteria) this;
        }

        public Criteria andTask_start_timeIn(List<Date> values) {
            addCriterion("task_start_time in", values, "task_start_time");
            return (Criteria) this;
        }

        public Criteria andTask_start_timeNotIn(List<Date> values) {
            addCriterion("task_start_time not in", values, "task_start_time");
            return (Criteria) this;
        }

        public Criteria andTask_start_timeBetween(Date value1, Date value2) {
            addCriterion("task_start_time between", value1, value2, "task_start_time");
            return (Criteria) this;
        }

        public Criteria andTask_start_timeNotBetween(Date value1, Date value2) {
            addCriterion("task_start_time not between", value1, value2, "task_start_time");
            return (Criteria) this;
        }

        public Criteria andTask_end_timeIsNull() {
            addCriterion("task_end_time is null");
            return (Criteria) this;
        }

        public Criteria andTask_end_timeIsNotNull() {
            addCriterion("task_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andTask_end_timeEqualTo(Date value) {
            addCriterion("task_end_time =", value, "task_end_time");
            return (Criteria) this;
        }

        public Criteria andTask_end_timeNotEqualTo(Date value) {
            addCriterion("task_end_time <>", value, "task_end_time");
            return (Criteria) this;
        }

        public Criteria andTask_end_timeGreaterThan(Date value) {
            addCriterion("task_end_time >", value, "task_end_time");
            return (Criteria) this;
        }

        public Criteria andTask_end_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("task_end_time >=", value, "task_end_time");
            return (Criteria) this;
        }

        public Criteria andTask_end_timeLessThan(Date value) {
            addCriterion("task_end_time <", value, "task_end_time");
            return (Criteria) this;
        }

        public Criteria andTask_end_timeLessThanOrEqualTo(Date value) {
            addCriterion("task_end_time <=", value, "task_end_time");
            return (Criteria) this;
        }

        public Criteria andTask_end_timeIn(List<Date> values) {
            addCriterion("task_end_time in", values, "task_end_time");
            return (Criteria) this;
        }

        public Criteria andTask_end_timeNotIn(List<Date> values) {
            addCriterion("task_end_time not in", values, "task_end_time");
            return (Criteria) this;
        }

        public Criteria andTask_end_timeBetween(Date value1, Date value2) {
            addCriterion("task_end_time between", value1, value2, "task_end_time");
            return (Criteria) this;
        }

        public Criteria andTask_end_timeNotBetween(Date value1, Date value2) {
            addCriterion("task_end_time not between", value1, value2, "task_end_time");
            return (Criteria) this;
        }

        public Criteria andTask_complete_timeIsNull() {
            addCriterion("task_complete_time is null");
            return (Criteria) this;
        }

        public Criteria andTask_complete_timeIsNotNull() {
            addCriterion("task_complete_time is not null");
            return (Criteria) this;
        }

        public Criteria andTask_complete_timeEqualTo(Date value) {
            addCriterion("task_complete_time =", value, "task_complete_time");
            return (Criteria) this;
        }

        public Criteria andTask_complete_timeNotEqualTo(Date value) {
            addCriterion("task_complete_time <>", value, "task_complete_time");
            return (Criteria) this;
        }

        public Criteria andTask_complete_timeGreaterThan(Date value) {
            addCriterion("task_complete_time >", value, "task_complete_time");
            return (Criteria) this;
        }

        public Criteria andTask_complete_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("task_complete_time >=", value, "task_complete_time");
            return (Criteria) this;
        }

        public Criteria andTask_complete_timeLessThan(Date value) {
            addCriterion("task_complete_time <", value, "task_complete_time");
            return (Criteria) this;
        }

        public Criteria andTask_complete_timeLessThanOrEqualTo(Date value) {
            addCriterion("task_complete_time <=", value, "task_complete_time");
            return (Criteria) this;
        }

        public Criteria andTask_complete_timeIn(List<Date> values) {
            addCriterion("task_complete_time in", values, "task_complete_time");
            return (Criteria) this;
        }

        public Criteria andTask_complete_timeNotIn(List<Date> values) {
            addCriterion("task_complete_time not in", values, "task_complete_time");
            return (Criteria) this;
        }

        public Criteria andTask_complete_timeBetween(Date value1, Date value2) {
            addCriterion("task_complete_time between", value1, value2, "task_complete_time");
            return (Criteria) this;
        }

        public Criteria andTask_complete_timeNotBetween(Date value1, Date value2) {
            addCriterion("task_complete_time not between", value1, value2, "task_complete_time");
            return (Criteria) this;
        }

        public Criteria andTask_progressIsNull() {
            addCriterion("task_progress is null");
            return (Criteria) this;
        }

        public Criteria andTask_progressIsNotNull() {
            addCriterion("task_progress is not null");
            return (Criteria) this;
        }

        public Criteria andTask_progressEqualTo(Integer value) {
            addCriterion("task_progress =", value, "task_progress");
            return (Criteria) this;
        }

        public Criteria andTask_progressNotEqualTo(Integer value) {
            addCriterion("task_progress <>", value, "task_progress");
            return (Criteria) this;
        }

        public Criteria andTask_progressGreaterThan(Integer value) {
            addCriterion("task_progress >", value, "task_progress");
            return (Criteria) this;
        }

        public Criteria andTask_progressGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_progress >=", value, "task_progress");
            return (Criteria) this;
        }

        public Criteria andTask_progressLessThan(Integer value) {
            addCriterion("task_progress <", value, "task_progress");
            return (Criteria) this;
        }

        public Criteria andTask_progressLessThanOrEqualTo(Integer value) {
            addCriterion("task_progress <=", value, "task_progress");
            return (Criteria) this;
        }

        public Criteria andTask_progressIn(List<Integer> values) {
            addCriterion("task_progress in", values, "task_progress");
            return (Criteria) this;
        }

        public Criteria andTask_progressNotIn(List<Integer> values) {
            addCriterion("task_progress not in", values, "task_progress");
            return (Criteria) this;
        }

        public Criteria andTask_progressBetween(Integer value1, Integer value2) {
            addCriterion("task_progress between", value1, value2, "task_progress");
            return (Criteria) this;
        }

        public Criteria andTask_progressNotBetween(Integer value1, Integer value2) {
            addCriterion("task_progress not between", value1, value2, "task_progress");
            return (Criteria) this;
        }

        public Criteria andTask_urgentIsNull() {
            addCriterion("task_urgent is null");
            return (Criteria) this;
        }

        public Criteria andTask_urgentIsNotNull() {
            addCriterion("task_urgent is not null");
            return (Criteria) this;
        }

        public Criteria andTask_urgentEqualTo(Integer value) {
            addCriterion("task_urgent =", value, "task_urgent");
            return (Criteria) this;
        }

        public Criteria andTask_urgentNotEqualTo(Integer value) {
            addCriterion("task_urgent <>", value, "task_urgent");
            return (Criteria) this;
        }

        public Criteria andTask_urgentGreaterThan(Integer value) {
            addCriterion("task_urgent >", value, "task_urgent");
            return (Criteria) this;
        }

        public Criteria andTask_urgentGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_urgent >=", value, "task_urgent");
            return (Criteria) this;
        }

        public Criteria andTask_urgentLessThan(Integer value) {
            addCriterion("task_urgent <", value, "task_urgent");
            return (Criteria) this;
        }

        public Criteria andTask_urgentLessThanOrEqualTo(Integer value) {
            addCriterion("task_urgent <=", value, "task_urgent");
            return (Criteria) this;
        }

        public Criteria andTask_urgentIn(List<Integer> values) {
            addCriterion("task_urgent in", values, "task_urgent");
            return (Criteria) this;
        }

        public Criteria andTask_urgentNotIn(List<Integer> values) {
            addCriterion("task_urgent not in", values, "task_urgent");
            return (Criteria) this;
        }

        public Criteria andTask_urgentBetween(Integer value1, Integer value2) {
            addCriterion("task_urgent between", value1, value2, "task_urgent");
            return (Criteria) this;
        }

        public Criteria andTask_urgentNotBetween(Integer value1, Integer value2) {
            addCriterion("task_urgent not between", value1, value2, "task_urgent");
            return (Criteria) this;
        }

        public Criteria andTask_importantIsNull() {
            addCriterion("task_important is null");
            return (Criteria) this;
        }

        public Criteria andTask_importantIsNotNull() {
            addCriterion("task_important is not null");
            return (Criteria) this;
        }

        public Criteria andTask_importantEqualTo(Integer value) {
            addCriterion("task_important =", value, "task_important");
            return (Criteria) this;
        }

        public Criteria andTask_importantNotEqualTo(Integer value) {
            addCriterion("task_important <>", value, "task_important");
            return (Criteria) this;
        }

        public Criteria andTask_importantGreaterThan(Integer value) {
            addCriterion("task_important >", value, "task_important");
            return (Criteria) this;
        }

        public Criteria andTask_importantGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_important >=", value, "task_important");
            return (Criteria) this;
        }

        public Criteria andTask_importantLessThan(Integer value) {
            addCriterion("task_important <", value, "task_important");
            return (Criteria) this;
        }

        public Criteria andTask_importantLessThanOrEqualTo(Integer value) {
            addCriterion("task_important <=", value, "task_important");
            return (Criteria) this;
        }

        public Criteria andTask_importantIn(List<Integer> values) {
            addCriterion("task_important in", values, "task_important");
            return (Criteria) this;
        }

        public Criteria andTask_importantNotIn(List<Integer> values) {
            addCriterion("task_important not in", values, "task_important");
            return (Criteria) this;
        }

        public Criteria andTask_importantBetween(Integer value1, Integer value2) {
            addCriterion("task_important between", value1, value2, "task_important");
            return (Criteria) this;
        }

        public Criteria andTask_importantNotBetween(Integer value1, Integer value2) {
            addCriterion("task_important not between", value1, value2, "task_important");
            return (Criteria) this;
        }

        public Criteria andTask_contentIsNull() {
            addCriterion("task_content is null");
            return (Criteria) this;
        }

        public Criteria andTask_contentIsNotNull() {
            addCriterion("task_content is not null");
            return (Criteria) this;
        }

        public Criteria andTask_contentEqualTo(String value) {
            addCriterion("task_content =", value, "task_content");
            return (Criteria) this;
        }

        public Criteria andTask_contentNotEqualTo(String value) {
            addCriterion("task_content <>", value, "task_content");
            return (Criteria) this;
        }

        public Criteria andTask_contentGreaterThan(String value) {
            addCriterion("task_content >", value, "task_content");
            return (Criteria) this;
        }

        public Criteria andTask_contentGreaterThanOrEqualTo(String value) {
            addCriterion("task_content >=", value, "task_content");
            return (Criteria) this;
        }

        public Criteria andTask_contentLessThan(String value) {
            addCriterion("task_content <", value, "task_content");
            return (Criteria) this;
        }

        public Criteria andTask_contentLessThanOrEqualTo(String value) {
            addCriterion("task_content <=", value, "task_content");
            return (Criteria) this;
        }

        public Criteria andTask_contentLike(String value) {
            addCriterion("task_content like", value, "task_content");
            return (Criteria) this;
        }

        public Criteria andTask_contentNotLike(String value) {
            addCriterion("task_content not like", value, "task_content");
            return (Criteria) this;
        }

        public Criteria andTask_contentIn(List<String> values) {
            addCriterion("task_content in", values, "task_content");
            return (Criteria) this;
        }

        public Criteria andTask_contentNotIn(List<String> values) {
            addCriterion("task_content not in", values, "task_content");
            return (Criteria) this;
        }

        public Criteria andTask_contentBetween(String value1, String value2) {
            addCriterion("task_content between", value1, value2, "task_content");
            return (Criteria) this;
        }

        public Criteria andTask_contentNotBetween(String value1, String value2) {
            addCriterion("task_content not between", value1, value2, "task_content");
            return (Criteria) this;
        }

        public Criteria andTask_statusIsNull() {
            addCriterion("task_status is null");
            return (Criteria) this;
        }

        public Criteria andTask_statusIsNotNull() {
            addCriterion("task_status is not null");
            return (Criteria) this;
        }

        public Criteria andTask_statusEqualTo(Integer value) {
            addCriterion("task_status =", value, "task_status");
            return (Criteria) this;
        }

        public Criteria andTask_statusNotEqualTo(Integer value) {
            addCriterion("task_status <>", value, "task_status");
            return (Criteria) this;
        }

        public Criteria andTask_statusGreaterThan(Integer value) {
            addCriterion("task_status >", value, "task_status");
            return (Criteria) this;
        }

        public Criteria andTask_statusGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_status >=", value, "task_status");
            return (Criteria) this;
        }

        public Criteria andTask_statusLessThan(Integer value) {
            addCriterion("task_status <", value, "task_status");
            return (Criteria) this;
        }

        public Criteria andTask_statusLessThanOrEqualTo(Integer value) {
            addCriterion("task_status <=", value, "task_status");
            return (Criteria) this;
        }

        public Criteria andTask_statusIn(List<Integer> values) {
            addCriterion("task_status in", values, "task_status");
            return (Criteria) this;
        }

        public Criteria andTask_statusNotIn(List<Integer> values) {
            addCriterion("task_status not in", values, "task_status");
            return (Criteria) this;
        }

        public Criteria andTask_statusBetween(Integer value1, Integer value2) {
            addCriterion("task_status between", value1, value2, "task_status");
            return (Criteria) this;
        }

        public Criteria andTask_statusNotBetween(Integer value1, Integer value2) {
            addCriterion("task_status not between", value1, value2, "task_status");
            return (Criteria) this;
        }

        public Criteria andTask_del_reasionIsNull() {
            addCriterion("task_del_reasion is null");
            return (Criteria) this;
        }

        public Criteria andTask_del_reasionIsNotNull() {
            addCriterion("task_del_reasion is not null");
            return (Criteria) this;
        }

        public Criteria andTask_del_reasionEqualTo(String value) {
            addCriterion("task_del_reasion =", value, "task_del_reasion");
            return (Criteria) this;
        }

        public Criteria andTask_del_reasionNotEqualTo(String value) {
            addCriterion("task_del_reasion <>", value, "task_del_reasion");
            return (Criteria) this;
        }

        public Criteria andTask_del_reasionGreaterThan(String value) {
            addCriterion("task_del_reasion >", value, "task_del_reasion");
            return (Criteria) this;
        }

        public Criteria andTask_del_reasionGreaterThanOrEqualTo(String value) {
            addCriterion("task_del_reasion >=", value, "task_del_reasion");
            return (Criteria) this;
        }

        public Criteria andTask_del_reasionLessThan(String value) {
            addCriterion("task_del_reasion <", value, "task_del_reasion");
            return (Criteria) this;
        }

        public Criteria andTask_del_reasionLessThanOrEqualTo(String value) {
            addCriterion("task_del_reasion <=", value, "task_del_reasion");
            return (Criteria) this;
        }

        public Criteria andTask_del_reasionLike(String value) {
            addCriterion("task_del_reasion like", value, "task_del_reasion");
            return (Criteria) this;
        }

        public Criteria andTask_del_reasionNotLike(String value) {
            addCriterion("task_del_reasion not like", value, "task_del_reasion");
            return (Criteria) this;
        }

        public Criteria andTask_del_reasionIn(List<String> values) {
            addCriterion("task_del_reasion in", values, "task_del_reasion");
            return (Criteria) this;
        }

        public Criteria andTask_del_reasionNotIn(List<String> values) {
            addCriterion("task_del_reasion not in", values, "task_del_reasion");
            return (Criteria) this;
        }

        public Criteria andTask_del_reasionBetween(String value1, String value2) {
            addCriterion("task_del_reasion between", value1, value2, "task_del_reasion");
            return (Criteria) this;
        }

        public Criteria andTask_del_reasionNotBetween(String value1, String value2) {
            addCriterion("task_del_reasion not between", value1, value2, "task_del_reasion");
            return (Criteria) this;
        }

        public Criteria andTask_reback_reasionIsNull() {
            addCriterion("task_reback_reasion is null");
            return (Criteria) this;
        }

        public Criteria andTask_reback_reasionIsNotNull() {
            addCriterion("task_reback_reasion is not null");
            return (Criteria) this;
        }

        public Criteria andTask_reback_reasionEqualTo(String value) {
            addCriterion("task_reback_reasion =", value, "task_reback_reasion");
            return (Criteria) this;
        }

        public Criteria andTask_reback_reasionNotEqualTo(String value) {
            addCriterion("task_reback_reasion <>", value, "task_reback_reasion");
            return (Criteria) this;
        }

        public Criteria andTask_reback_reasionGreaterThan(String value) {
            addCriterion("task_reback_reasion >", value, "task_reback_reasion");
            return (Criteria) this;
        }

        public Criteria andTask_reback_reasionGreaterThanOrEqualTo(String value) {
            addCriterion("task_reback_reasion >=", value, "task_reback_reasion");
            return (Criteria) this;
        }

        public Criteria andTask_reback_reasionLessThan(String value) {
            addCriterion("task_reback_reasion <", value, "task_reback_reasion");
            return (Criteria) this;
        }

        public Criteria andTask_reback_reasionLessThanOrEqualTo(String value) {
            addCriterion("task_reback_reasion <=", value, "task_reback_reasion");
            return (Criteria) this;
        }

        public Criteria andTask_reback_reasionLike(String value) {
            addCriterion("task_reback_reasion like", value, "task_reback_reasion");
            return (Criteria) this;
        }

        public Criteria andTask_reback_reasionNotLike(String value) {
            addCriterion("task_reback_reasion not like", value, "task_reback_reasion");
            return (Criteria) this;
        }

        public Criteria andTask_reback_reasionIn(List<String> values) {
            addCriterion("task_reback_reasion in", values, "task_reback_reasion");
            return (Criteria) this;
        }

        public Criteria andTask_reback_reasionNotIn(List<String> values) {
            addCriterion("task_reback_reasion not in", values, "task_reback_reasion");
            return (Criteria) this;
        }

        public Criteria andTask_reback_reasionBetween(String value1, String value2) {
            addCriterion("task_reback_reasion between", value1, value2, "task_reback_reasion");
            return (Criteria) this;
        }

        public Criteria andTask_reback_reasionNotBetween(String value1, String value2) {
            addCriterion("task_reback_reasion not between", value1, value2, "task_reback_reasion");
            return (Criteria) this;
        }

        public Criteria andIs_remarkIsNull() {
            addCriterion("is_remark is null");
            return (Criteria) this;
        }

        public Criteria andIs_remarkIsNotNull() {
            addCriterion("is_remark is not null");
            return (Criteria) this;
        }

        public Criteria andIs_remarkEqualTo(Byte value) {
            addCriterion("is_remark =", value, "is_remark");
            return (Criteria) this;
        }

        public Criteria andIs_remarkNotEqualTo(Byte value) {
            addCriterion("is_remark <>", value, "is_remark");
            return (Criteria) this;
        }

        public Criteria andIs_remarkGreaterThan(Byte value) {
            addCriterion("is_remark >", value, "is_remark");
            return (Criteria) this;
        }

        public Criteria andIs_remarkGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_remark >=", value, "is_remark");
            return (Criteria) this;
        }

        public Criteria andIs_remarkLessThan(Byte value) {
            addCriterion("is_remark <", value, "is_remark");
            return (Criteria) this;
        }

        public Criteria andIs_remarkLessThanOrEqualTo(Byte value) {
            addCriterion("is_remark <=", value, "is_remark");
            return (Criteria) this;
        }

        public Criteria andIs_remarkIn(List<Byte> values) {
            addCriterion("is_remark in", values, "is_remark");
            return (Criteria) this;
        }

        public Criteria andIs_remarkNotIn(List<Byte> values) {
            addCriterion("is_remark not in", values, "is_remark");
            return (Criteria) this;
        }

        public Criteria andIs_remarkBetween(Byte value1, Byte value2) {
            addCriterion("is_remark between", value1, value2, "is_remark");
            return (Criteria) this;
        }

        public Criteria andIs_remarkNotBetween(Byte value1, Byte value2) {
            addCriterion("is_remark not between", value1, value2, "is_remark");
            return (Criteria) this;
        }

        public Criteria andIs_forwardIsNull() {
            addCriterion("is_forward is null");
            return (Criteria) this;
        }

        public Criteria andIs_forwardIsNotNull() {
            addCriterion("is_forward is not null");
            return (Criteria) this;
        }

        public Criteria andIs_forwardEqualTo(Byte value) {
            addCriterion("is_forward =", value, "is_forward");
            return (Criteria) this;
        }

        public Criteria andIs_forwardNotEqualTo(Byte value) {
            addCriterion("is_forward <>", value, "is_forward");
            return (Criteria) this;
        }

        public Criteria andIs_forwardGreaterThan(Byte value) {
            addCriterion("is_forward >", value, "is_forward");
            return (Criteria) this;
        }

        public Criteria andIs_forwardGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_forward >=", value, "is_forward");
            return (Criteria) this;
        }

        public Criteria andIs_forwardLessThan(Byte value) {
            addCriterion("is_forward <", value, "is_forward");
            return (Criteria) this;
        }

        public Criteria andIs_forwardLessThanOrEqualTo(Byte value) {
            addCriterion("is_forward <=", value, "is_forward");
            return (Criteria) this;
        }

        public Criteria andIs_forwardIn(List<Byte> values) {
            addCriterion("is_forward in", values, "is_forward");
            return (Criteria) this;
        }

        public Criteria andIs_forwardNotIn(List<Byte> values) {
            addCriterion("is_forward not in", values, "is_forward");
            return (Criteria) this;
        }

        public Criteria andIs_forwardBetween(Byte value1, Byte value2) {
            addCriterion("is_forward between", value1, value2, "is_forward");
            return (Criteria) this;
        }

        public Criteria andIs_forwardNotBetween(Byte value1, Byte value2) {
            addCriterion("is_forward not between", value1, value2, "is_forward");
            return (Criteria) this;
        }

        public Criteria andIs_delayIsNull() {
            addCriterion("is_delay is null");
            return (Criteria) this;
        }

        public Criteria andIs_delayIsNotNull() {
            addCriterion("is_delay is not null");
            return (Criteria) this;
        }

        public Criteria andIs_delayEqualTo(Integer value) {
            addCriterion("is_delay =", value, "is_delay");
            return (Criteria) this;
        }

        public Criteria andIs_delayNotEqualTo(Integer value) {
            addCriterion("is_delay <>", value, "is_delay");
            return (Criteria) this;
        }

        public Criteria andIs_delayGreaterThan(Integer value) {
            addCriterion("is_delay >", value, "is_delay");
            return (Criteria) this;
        }

        public Criteria andIs_delayGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_delay >=", value, "is_delay");
            return (Criteria) this;
        }

        public Criteria andIs_delayLessThan(Integer value) {
            addCriterion("is_delay <", value, "is_delay");
            return (Criteria) this;
        }

        public Criteria andIs_delayLessThanOrEqualTo(Integer value) {
            addCriterion("is_delay <=", value, "is_delay");
            return (Criteria) this;
        }

        public Criteria andIs_delayIn(List<Integer> values) {
            addCriterion("is_delay in", values, "is_delay");
            return (Criteria) this;
        }

        public Criteria andIs_delayNotIn(List<Integer> values) {
            addCriterion("is_delay not in", values, "is_delay");
            return (Criteria) this;
        }

        public Criteria andIs_delayBetween(Integer value1, Integer value2) {
            addCriterion("is_delay between", value1, value2, "is_delay");
            return (Criteria) this;
        }

        public Criteria andIs_delayNotBetween(Integer value1, Integer value2) {
            addCriterion("is_delay not between", value1, value2, "is_delay");
            return (Criteria) this;
        }

        public Criteria andIs_cuiIsNull() {
            addCriterion("is_cui is null");
            return (Criteria) this;
        }

        public Criteria andIs_cuiIsNotNull() {
            addCriterion("is_cui is not null");
            return (Criteria) this;
        }

        public Criteria andIs_cuiEqualTo(Integer value) {
            addCriterion("is_cui =", value, "is_cui");
            return (Criteria) this;
        }

        public Criteria andIs_cuiNotEqualTo(Integer value) {
            addCriterion("is_cui <>", value, "is_cui");
            return (Criteria) this;
        }

        public Criteria andIs_cuiGreaterThan(Integer value) {
            addCriterion("is_cui >", value, "is_cui");
            return (Criteria) this;
        }

        public Criteria andIs_cuiGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_cui >=", value, "is_cui");
            return (Criteria) this;
        }

        public Criteria andIs_cuiLessThan(Integer value) {
            addCriterion("is_cui <", value, "is_cui");
            return (Criteria) this;
        }

        public Criteria andIs_cuiLessThanOrEqualTo(Integer value) {
            addCriterion("is_cui <=", value, "is_cui");
            return (Criteria) this;
        }

        public Criteria andIs_cuiIn(List<Integer> values) {
            addCriterion("is_cui in", values, "is_cui");
            return (Criteria) this;
        }

        public Criteria andIs_cuiNotIn(List<Integer> values) {
            addCriterion("is_cui not in", values, "is_cui");
            return (Criteria) this;
        }

        public Criteria andIs_cuiBetween(Integer value1, Integer value2) {
            addCriterion("is_cui between", value1, value2, "is_cui");
            return (Criteria) this;
        }

        public Criteria andIs_cuiNotBetween(Integer value1, Integer value2) {
            addCriterion("is_cui not between", value1, value2, "is_cui");
            return (Criteria) this;
        }

        public Criteria andTask_qualityIsNull() {
            addCriterion("task_quality is null");
            return (Criteria) this;
        }

        public Criteria andTask_qualityIsNotNull() {
            addCriterion("task_quality is not null");
            return (Criteria) this;
        }

        public Criteria andTask_qualityEqualTo(Integer value) {
            addCriterion("task_quality =", value, "task_quality");
            return (Criteria) this;
        }

        public Criteria andTask_qualityNotEqualTo(Integer value) {
            addCriterion("task_quality <>", value, "task_quality");
            return (Criteria) this;
        }

        public Criteria andTask_qualityGreaterThan(Integer value) {
            addCriterion("task_quality >", value, "task_quality");
            return (Criteria) this;
        }

        public Criteria andTask_qualityGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_quality >=", value, "task_quality");
            return (Criteria) this;
        }

        public Criteria andTask_qualityLessThan(Integer value) {
            addCriterion("task_quality <", value, "task_quality");
            return (Criteria) this;
        }

        public Criteria andTask_qualityLessThanOrEqualTo(Integer value) {
            addCriterion("task_quality <=", value, "task_quality");
            return (Criteria) this;
        }

        public Criteria andTask_qualityIn(List<Integer> values) {
            addCriterion("task_quality in", values, "task_quality");
            return (Criteria) this;
        }

        public Criteria andTask_qualityNotIn(List<Integer> values) {
            addCriterion("task_quality not in", values, "task_quality");
            return (Criteria) this;
        }

        public Criteria andTask_qualityBetween(Integer value1, Integer value2) {
            addCriterion("task_quality between", value1, value2, "task_quality");
            return (Criteria) this;
        }

        public Criteria andTask_qualityNotBetween(Integer value1, Integer value2) {
            addCriterion("task_quality not between", value1, value2, "task_quality");
            return (Criteria) this;
        }

        public Criteria andTask_efficiencyIsNull() {
            addCriterion("task_efficiency is null");
            return (Criteria) this;
        }

        public Criteria andTask_efficiencyIsNotNull() {
            addCriterion("task_efficiency is not null");
            return (Criteria) this;
        }

        public Criteria andTask_efficiencyEqualTo(Integer value) {
            addCriterion("task_efficiency =", value, "task_efficiency");
            return (Criteria) this;
        }

        public Criteria andTask_efficiencyNotEqualTo(Integer value) {
            addCriterion("task_efficiency <>", value, "task_efficiency");
            return (Criteria) this;
        }

        public Criteria andTask_efficiencyGreaterThan(Integer value) {
            addCriterion("task_efficiency >", value, "task_efficiency");
            return (Criteria) this;
        }

        public Criteria andTask_efficiencyGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_efficiency >=", value, "task_efficiency");
            return (Criteria) this;
        }

        public Criteria andTask_efficiencyLessThan(Integer value) {
            addCriterion("task_efficiency <", value, "task_efficiency");
            return (Criteria) this;
        }

        public Criteria andTask_efficiencyLessThanOrEqualTo(Integer value) {
            addCriterion("task_efficiency <=", value, "task_efficiency");
            return (Criteria) this;
        }

        public Criteria andTask_efficiencyIn(List<Integer> values) {
            addCriterion("task_efficiency in", values, "task_efficiency");
            return (Criteria) this;
        }

        public Criteria andTask_efficiencyNotIn(List<Integer> values) {
            addCriterion("task_efficiency not in", values, "task_efficiency");
            return (Criteria) this;
        }

        public Criteria andTask_efficiencyBetween(Integer value1, Integer value2) {
            addCriterion("task_efficiency between", value1, value2, "task_efficiency");
            return (Criteria) this;
        }

        public Criteria andTask_efficiencyNotBetween(Integer value1, Integer value2) {
            addCriterion("task_efficiency not between", value1, value2, "task_efficiency");
            return (Criteria) this;
        }

        public Criteria andTask_communion_recIsNull() {
            addCriterion("task_communion_rec is null");
            return (Criteria) this;
        }

        public Criteria andTask_communion_recIsNotNull() {
            addCriterion("task_communion_rec is not null");
            return (Criteria) this;
        }

        public Criteria andTask_communion_recEqualTo(Integer value) {
            addCriterion("task_communion_rec =", value, "task_communion_rec");
            return (Criteria) this;
        }

        public Criteria andTask_communion_recNotEqualTo(Integer value) {
            addCriterion("task_communion_rec <>", value, "task_communion_rec");
            return (Criteria) this;
        }

        public Criteria andTask_communion_recGreaterThan(Integer value) {
            addCriterion("task_communion_rec >", value, "task_communion_rec");
            return (Criteria) this;
        }

        public Criteria andTask_communion_recGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_communion_rec >=", value, "task_communion_rec");
            return (Criteria) this;
        }

        public Criteria andTask_communion_recLessThan(Integer value) {
            addCriterion("task_communion_rec <", value, "task_communion_rec");
            return (Criteria) this;
        }

        public Criteria andTask_communion_recLessThanOrEqualTo(Integer value) {
            addCriterion("task_communion_rec <=", value, "task_communion_rec");
            return (Criteria) this;
        }

        public Criteria andTask_communion_recIn(List<Integer> values) {
            addCriterion("task_communion_rec in", values, "task_communion_rec");
            return (Criteria) this;
        }

        public Criteria andTask_communion_recNotIn(List<Integer> values) {
            addCriterion("task_communion_rec not in", values, "task_communion_rec");
            return (Criteria) this;
        }

        public Criteria andTask_communion_recBetween(Integer value1, Integer value2) {
            addCriterion("task_communion_rec between", value1, value2, "task_communion_rec");
            return (Criteria) this;
        }

        public Criteria andTask_communion_recNotBetween(Integer value1, Integer value2) {
            addCriterion("task_communion_rec not between", value1, value2, "task_communion_rec");
            return (Criteria) this;
        }

        public Criteria andTask_communion_pubIsNull() {
            addCriterion("task_communion_pub is null");
            return (Criteria) this;
        }

        public Criteria andTask_communion_pubIsNotNull() {
            addCriterion("task_communion_pub is not null");
            return (Criteria) this;
        }

        public Criteria andTask_communion_pubEqualTo(Integer value) {
            addCriterion("task_communion_pub =", value, "task_communion_pub");
            return (Criteria) this;
        }

        public Criteria andTask_communion_pubNotEqualTo(Integer value) {
            addCriterion("task_communion_pub <>", value, "task_communion_pub");
            return (Criteria) this;
        }

        public Criteria andTask_communion_pubGreaterThan(Integer value) {
            addCriterion("task_communion_pub >", value, "task_communion_pub");
            return (Criteria) this;
        }

        public Criteria andTask_communion_pubGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_communion_pub >=", value, "task_communion_pub");
            return (Criteria) this;
        }

        public Criteria andTask_communion_pubLessThan(Integer value) {
            addCriterion("task_communion_pub <", value, "task_communion_pub");
            return (Criteria) this;
        }

        public Criteria andTask_communion_pubLessThanOrEqualTo(Integer value) {
            addCriterion("task_communion_pub <=", value, "task_communion_pub");
            return (Criteria) this;
        }

        public Criteria andTask_communion_pubIn(List<Integer> values) {
            addCriterion("task_communion_pub in", values, "task_communion_pub");
            return (Criteria) this;
        }

        public Criteria andTask_communion_pubNotIn(List<Integer> values) {
            addCriterion("task_communion_pub not in", values, "task_communion_pub");
            return (Criteria) this;
        }

        public Criteria andTask_communion_pubBetween(Integer value1, Integer value2) {
            addCriterion("task_communion_pub between", value1, value2, "task_communion_pub");
            return (Criteria) this;
        }

        public Criteria andTask_communion_pubNotBetween(Integer value1, Integer value2) {
            addCriterion("task_communion_pub not between", value1, value2, "task_communion_pub");
            return (Criteria) this;
        }

        public Criteria andTask_studyIsNull() {
            addCriterion("task_study is null");
            return (Criteria) this;
        }

        public Criteria andTask_studyIsNotNull() {
            addCriterion("task_study is not null");
            return (Criteria) this;
        }

        public Criteria andTask_studyEqualTo(Integer value) {
            addCriterion("task_study =", value, "task_study");
            return (Criteria) this;
        }

        public Criteria andTask_studyNotEqualTo(Integer value) {
            addCriterion("task_study <>", value, "task_study");
            return (Criteria) this;
        }

        public Criteria andTask_studyGreaterThan(Integer value) {
            addCriterion("task_study >", value, "task_study");
            return (Criteria) this;
        }

        public Criteria andTask_studyGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_study >=", value, "task_study");
            return (Criteria) this;
        }

        public Criteria andTask_studyLessThan(Integer value) {
            addCriterion("task_study <", value, "task_study");
            return (Criteria) this;
        }

        public Criteria andTask_studyLessThanOrEqualTo(Integer value) {
            addCriterion("task_study <=", value, "task_study");
            return (Criteria) this;
        }

        public Criteria andTask_studyIn(List<Integer> values) {
            addCriterion("task_study in", values, "task_study");
            return (Criteria) this;
        }

        public Criteria andTask_studyNotIn(List<Integer> values) {
            addCriterion("task_study not in", values, "task_study");
            return (Criteria) this;
        }

        public Criteria andTask_studyBetween(Integer value1, Integer value2) {
            addCriterion("task_study between", value1, value2, "task_study");
            return (Criteria) this;
        }

        public Criteria andTask_studyNotBetween(Integer value1, Integer value2) {
            addCriterion("task_study not between", value1, value2, "task_study");
            return (Criteria) this;
        }

        public Criteria andTask_innovateIsNull() {
            addCriterion("task_innovate is null");
            return (Criteria) this;
        }

        public Criteria andTask_innovateIsNotNull() {
            addCriterion("task_innovate is not null");
            return (Criteria) this;
        }

        public Criteria andTask_innovateEqualTo(Integer value) {
            addCriterion("task_innovate =", value, "task_innovate");
            return (Criteria) this;
        }

        public Criteria andTask_innovateNotEqualTo(Integer value) {
            addCriterion("task_innovate <>", value, "task_innovate");
            return (Criteria) this;
        }

        public Criteria andTask_innovateGreaterThan(Integer value) {
            addCriterion("task_innovate >", value, "task_innovate");
            return (Criteria) this;
        }

        public Criteria andTask_innovateGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_innovate >=", value, "task_innovate");
            return (Criteria) this;
        }

        public Criteria andTask_innovateLessThan(Integer value) {
            addCriterion("task_innovate <", value, "task_innovate");
            return (Criteria) this;
        }

        public Criteria andTask_innovateLessThanOrEqualTo(Integer value) {
            addCriterion("task_innovate <=", value, "task_innovate");
            return (Criteria) this;
        }

        public Criteria andTask_innovateIn(List<Integer> values) {
            addCriterion("task_innovate in", values, "task_innovate");
            return (Criteria) this;
        }

        public Criteria andTask_innovateNotIn(List<Integer> values) {
            addCriterion("task_innovate not in", values, "task_innovate");
            return (Criteria) this;
        }

        public Criteria andTask_innovateBetween(Integer value1, Integer value2) {
            addCriterion("task_innovate between", value1, value2, "task_innovate");
            return (Criteria) this;
        }

        public Criteria andTask_innovateNotBetween(Integer value1, Integer value2) {
            addCriterion("task_innovate not between", value1, value2, "task_innovate");
            return (Criteria) this;
        }

        public Criteria andTask_leaderIsNull() {
            addCriterion("task_leader is null");
            return (Criteria) this;
        }

        public Criteria andTask_leaderIsNotNull() {
            addCriterion("task_leader is not null");
            return (Criteria) this;
        }

        public Criteria andTask_leaderEqualTo(Integer value) {
            addCriterion("task_leader =", value, "task_leader");
            return (Criteria) this;
        }

        public Criteria andTask_leaderNotEqualTo(Integer value) {
            addCriterion("task_leader <>", value, "task_leader");
            return (Criteria) this;
        }

        public Criteria andTask_leaderGreaterThan(Integer value) {
            addCriterion("task_leader >", value, "task_leader");
            return (Criteria) this;
        }

        public Criteria andTask_leaderGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_leader >=", value, "task_leader");
            return (Criteria) this;
        }

        public Criteria andTask_leaderLessThan(Integer value) {
            addCriterion("task_leader <", value, "task_leader");
            return (Criteria) this;
        }

        public Criteria andTask_leaderLessThanOrEqualTo(Integer value) {
            addCriterion("task_leader <=", value, "task_leader");
            return (Criteria) this;
        }

        public Criteria andTask_leaderIn(List<Integer> values) {
            addCriterion("task_leader in", values, "task_leader");
            return (Criteria) this;
        }

        public Criteria andTask_leaderNotIn(List<Integer> values) {
            addCriterion("task_leader not in", values, "task_leader");
            return (Criteria) this;
        }

        public Criteria andTask_leaderBetween(Integer value1, Integer value2) {
            addCriterion("task_leader between", value1, value2, "task_leader");
            return (Criteria) this;
        }

        public Criteria andTask_leaderNotBetween(Integer value1, Integer value2) {
            addCriterion("task_leader not between", value1, value2, "task_leader");
            return (Criteria) this;
        }

        public Criteria andTask_evaluateIsNull() {
            addCriterion("task_evaluate is null");
            return (Criteria) this;
        }

        public Criteria andTask_evaluateIsNotNull() {
            addCriterion("task_evaluate is not null");
            return (Criteria) this;
        }

        public Criteria andTask_evaluateEqualTo(String value) {
            addCriterion("task_evaluate =", value, "task_evaluate");
            return (Criteria) this;
        }

        public Criteria andTask_evaluateNotEqualTo(String value) {
            addCriterion("task_evaluate <>", value, "task_evaluate");
            return (Criteria) this;
        }

        public Criteria andTask_evaluateGreaterThan(String value) {
            addCriterion("task_evaluate >", value, "task_evaluate");
            return (Criteria) this;
        }

        public Criteria andTask_evaluateGreaterThanOrEqualTo(String value) {
            addCriterion("task_evaluate >=", value, "task_evaluate");
            return (Criteria) this;
        }

        public Criteria andTask_evaluateLessThan(String value) {
            addCriterion("task_evaluate <", value, "task_evaluate");
            return (Criteria) this;
        }

        public Criteria andTask_evaluateLessThanOrEqualTo(String value) {
            addCriterion("task_evaluate <=", value, "task_evaluate");
            return (Criteria) this;
        }

        public Criteria andTask_evaluateLike(String value) {
            addCriterion("task_evaluate like", value, "task_evaluate");
            return (Criteria) this;
        }

        public Criteria andTask_evaluateNotLike(String value) {
            addCriterion("task_evaluate not like", value, "task_evaluate");
            return (Criteria) this;
        }

        public Criteria andTask_evaluateIn(List<String> values) {
            addCriterion("task_evaluate in", values, "task_evaluate");
            return (Criteria) this;
        }

        public Criteria andTask_evaluateNotIn(List<String> values) {
            addCriterion("task_evaluate not in", values, "task_evaluate");
            return (Criteria) this;
        }

        public Criteria andTask_evaluateBetween(String value1, String value2) {
            addCriterion("task_evaluate between", value1, value2, "task_evaluate");
            return (Criteria) this;
        }

        public Criteria andTask_evaluateNotBetween(String value1, String value2) {
            addCriterion("task_evaluate not between", value1, value2, "task_evaluate");
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