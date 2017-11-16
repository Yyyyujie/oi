package cn.zx.pojo;

import java.util.ArrayList;
import java.util.List;

public class EmailMessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EmailMessageExample() {
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

        public Criteria andEmail_idIsNull() {
            addCriterion("email_id is null");
            return (Criteria) this;
        }

        public Criteria andEmail_idIsNotNull() {
            addCriterion("email_id is not null");
            return (Criteria) this;
        }

        public Criteria andEmail_idEqualTo(Integer value) {
            addCriterion("email_id =", value, "email_id");
            return (Criteria) this;
        }

        public Criteria andEmail_idNotEqualTo(Integer value) {
            addCriterion("email_id <>", value, "email_id");
            return (Criteria) this;
        }

        public Criteria andEmail_idGreaterThan(Integer value) {
            addCriterion("email_id >", value, "email_id");
            return (Criteria) this;
        }

        public Criteria andEmail_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("email_id >=", value, "email_id");
            return (Criteria) this;
        }

        public Criteria andEmail_idLessThan(Integer value) {
            addCriterion("email_id <", value, "email_id");
            return (Criteria) this;
        }

        public Criteria andEmail_idLessThanOrEqualTo(Integer value) {
            addCriterion("email_id <=", value, "email_id");
            return (Criteria) this;
        }

        public Criteria andEmail_idIn(List<Integer> values) {
            addCriterion("email_id in", values, "email_id");
            return (Criteria) this;
        }

        public Criteria andEmail_idNotIn(List<Integer> values) {
            addCriterion("email_id not in", values, "email_id");
            return (Criteria) this;
        }

        public Criteria andEmail_idBetween(Integer value1, Integer value2) {
            addCriterion("email_id between", value1, value2, "email_id");
            return (Criteria) this;
        }

        public Criteria andEmail_idNotBetween(Integer value1, Integer value2) {
            addCriterion("email_id not between", value1, value2, "email_id");
            return (Criteria) this;
        }

        public Criteria andEmail_accountIsNull() {
            addCriterion("email_account is null");
            return (Criteria) this;
        }

        public Criteria andEmail_accountIsNotNull() {
            addCriterion("email_account is not null");
            return (Criteria) this;
        }

        public Criteria andEmail_accountEqualTo(String value) {
            addCriterion("email_account =", value, "email_account");
            return (Criteria) this;
        }

        public Criteria andEmail_accountNotEqualTo(String value) {
            addCriterion("email_account <>", value, "email_account");
            return (Criteria) this;
        }

        public Criteria andEmail_accountGreaterThan(String value) {
            addCriterion("email_account >", value, "email_account");
            return (Criteria) this;
        }

        public Criteria andEmail_accountGreaterThanOrEqualTo(String value) {
            addCriterion("email_account >=", value, "email_account");
            return (Criteria) this;
        }

        public Criteria andEmail_accountLessThan(String value) {
            addCriterion("email_account <", value, "email_account");
            return (Criteria) this;
        }

        public Criteria andEmail_accountLessThanOrEqualTo(String value) {
            addCriterion("email_account <=", value, "email_account");
            return (Criteria) this;
        }

        public Criteria andEmail_accountLike(String value) {
            addCriterion("email_account like", value, "email_account");
            return (Criteria) this;
        }

        public Criteria andEmail_accountNotLike(String value) {
            addCriterion("email_account not like", value, "email_account");
            return (Criteria) this;
        }

        public Criteria andEmail_accountIn(List<String> values) {
            addCriterion("email_account in", values, "email_account");
            return (Criteria) this;
        }

        public Criteria andEmail_accountNotIn(List<String> values) {
            addCriterion("email_account not in", values, "email_account");
            return (Criteria) this;
        }

        public Criteria andEmail_accountBetween(String value1, String value2) {
            addCriterion("email_account between", value1, value2, "email_account");
            return (Criteria) this;
        }

        public Criteria andEmail_accountNotBetween(String value1, String value2) {
            addCriterion("email_account not between", value1, value2, "email_account");
            return (Criteria) this;
        }

        public Criteria andEmail_passwordIsNull() {
            addCriterion("email_password is null");
            return (Criteria) this;
        }

        public Criteria andEmail_passwordIsNotNull() {
            addCriterion("email_password is not null");
            return (Criteria) this;
        }

        public Criteria andEmail_passwordEqualTo(String value) {
            addCriterion("email_password =", value, "email_password");
            return (Criteria) this;
        }

        public Criteria andEmail_passwordNotEqualTo(String value) {
            addCriterion("email_password <>", value, "email_password");
            return (Criteria) this;
        }

        public Criteria andEmail_passwordGreaterThan(String value) {
            addCriterion("email_password >", value, "email_password");
            return (Criteria) this;
        }

        public Criteria andEmail_passwordGreaterThanOrEqualTo(String value) {
            addCriterion("email_password >=", value, "email_password");
            return (Criteria) this;
        }

        public Criteria andEmail_passwordLessThan(String value) {
            addCriterion("email_password <", value, "email_password");
            return (Criteria) this;
        }

        public Criteria andEmail_passwordLessThanOrEqualTo(String value) {
            addCriterion("email_password <=", value, "email_password");
            return (Criteria) this;
        }

        public Criteria andEmail_passwordLike(String value) {
            addCriterion("email_password like", value, "email_password");
            return (Criteria) this;
        }

        public Criteria andEmail_passwordNotLike(String value) {
            addCriterion("email_password not like", value, "email_password");
            return (Criteria) this;
        }

        public Criteria andEmail_passwordIn(List<String> values) {
            addCriterion("email_password in", values, "email_password");
            return (Criteria) this;
        }

        public Criteria andEmail_passwordNotIn(List<String> values) {
            addCriterion("email_password not in", values, "email_password");
            return (Criteria) this;
        }

        public Criteria andEmail_passwordBetween(String value1, String value2) {
            addCriterion("email_password between", value1, value2, "email_password");
            return (Criteria) this;
        }

        public Criteria andEmail_passwordNotBetween(String value1, String value2) {
            addCriterion("email_password not between", value1, value2, "email_password");
            return (Criteria) this;
        }

        public Criteria andEmail_smtp_hostIsNull() {
            addCriterion("email_smtp_host is null");
            return (Criteria) this;
        }

        public Criteria andEmail_smtp_hostIsNotNull() {
            addCriterion("email_smtp_host is not null");
            return (Criteria) this;
        }

        public Criteria andEmail_smtp_hostEqualTo(String value) {
            addCriterion("email_smtp_host =", value, "email_smtp_host");
            return (Criteria) this;
        }

        public Criteria andEmail_smtp_hostNotEqualTo(String value) {
            addCriterion("email_smtp_host <>", value, "email_smtp_host");
            return (Criteria) this;
        }

        public Criteria andEmail_smtp_hostGreaterThan(String value) {
            addCriterion("email_smtp_host >", value, "email_smtp_host");
            return (Criteria) this;
        }

        public Criteria andEmail_smtp_hostGreaterThanOrEqualTo(String value) {
            addCriterion("email_smtp_host >=", value, "email_smtp_host");
            return (Criteria) this;
        }

        public Criteria andEmail_smtp_hostLessThan(String value) {
            addCriterion("email_smtp_host <", value, "email_smtp_host");
            return (Criteria) this;
        }

        public Criteria andEmail_smtp_hostLessThanOrEqualTo(String value) {
            addCriterion("email_smtp_host <=", value, "email_smtp_host");
            return (Criteria) this;
        }

        public Criteria andEmail_smtp_hostLike(String value) {
            addCriterion("email_smtp_host like", value, "email_smtp_host");
            return (Criteria) this;
        }

        public Criteria andEmail_smtp_hostNotLike(String value) {
            addCriterion("email_smtp_host not like", value, "email_smtp_host");
            return (Criteria) this;
        }

        public Criteria andEmail_smtp_hostIn(List<String> values) {
            addCriterion("email_smtp_host in", values, "email_smtp_host");
            return (Criteria) this;
        }

        public Criteria andEmail_smtp_hostNotIn(List<String> values) {
            addCriterion("email_smtp_host not in", values, "email_smtp_host");
            return (Criteria) this;
        }

        public Criteria andEmail_smtp_hostBetween(String value1, String value2) {
            addCriterion("email_smtp_host between", value1, value2, "email_smtp_host");
            return (Criteria) this;
        }

        public Criteria andEmail_smtp_hostNotBetween(String value1, String value2) {
            addCriterion("email_smtp_host not between", value1, value2, "email_smtp_host");
            return (Criteria) this;
        }

        public Criteria andSend_mailIsNull() {
            addCriterion("send_mail is null");
            return (Criteria) this;
        }

        public Criteria andSend_mailIsNotNull() {
            addCriterion("send_mail is not null");
            return (Criteria) this;
        }

        public Criteria andSend_mailEqualTo(String value) {
            addCriterion("send_mail =", value, "send_mail");
            return (Criteria) this;
        }

        public Criteria andSend_mailNotEqualTo(String value) {
            addCriterion("send_mail <>", value, "send_mail");
            return (Criteria) this;
        }

        public Criteria andSend_mailGreaterThan(String value) {
            addCriterion("send_mail >", value, "send_mail");
            return (Criteria) this;
        }

        public Criteria andSend_mailGreaterThanOrEqualTo(String value) {
            addCriterion("send_mail >=", value, "send_mail");
            return (Criteria) this;
        }

        public Criteria andSend_mailLessThan(String value) {
            addCriterion("send_mail <", value, "send_mail");
            return (Criteria) this;
        }

        public Criteria andSend_mailLessThanOrEqualTo(String value) {
            addCriterion("send_mail <=", value, "send_mail");
            return (Criteria) this;
        }

        public Criteria andSend_mailLike(String value) {
            addCriterion("send_mail like", value, "send_mail");
            return (Criteria) this;
        }

        public Criteria andSend_mailNotLike(String value) {
            addCriterion("send_mail not like", value, "send_mail");
            return (Criteria) this;
        }

        public Criteria andSend_mailIn(List<String> values) {
            addCriterion("send_mail in", values, "send_mail");
            return (Criteria) this;
        }

        public Criteria andSend_mailNotIn(List<String> values) {
            addCriterion("send_mail not in", values, "send_mail");
            return (Criteria) this;
        }

        public Criteria andSend_mailBetween(String value1, String value2) {
            addCriterion("send_mail between", value1, value2, "send_mail");
            return (Criteria) this;
        }

        public Criteria andSend_mailNotBetween(String value1, String value2) {
            addCriterion("send_mail not between", value1, value2, "send_mail");
            return (Criteria) this;
        }

        public Criteria andRec_mail_accountIsNull() {
            addCriterion("rec_mail_account is null");
            return (Criteria) this;
        }

        public Criteria andRec_mail_accountIsNotNull() {
            addCriterion("rec_mail_account is not null");
            return (Criteria) this;
        }

        public Criteria andRec_mail_accountEqualTo(String value) {
            addCriterion("rec_mail_account =", value, "rec_mail_account");
            return (Criteria) this;
        }

        public Criteria andRec_mail_accountNotEqualTo(String value) {
            addCriterion("rec_mail_account <>", value, "rec_mail_account");
            return (Criteria) this;
        }

        public Criteria andRec_mail_accountGreaterThan(String value) {
            addCriterion("rec_mail_account >", value, "rec_mail_account");
            return (Criteria) this;
        }

        public Criteria andRec_mail_accountGreaterThanOrEqualTo(String value) {
            addCriterion("rec_mail_account >=", value, "rec_mail_account");
            return (Criteria) this;
        }

        public Criteria andRec_mail_accountLessThan(String value) {
            addCriterion("rec_mail_account <", value, "rec_mail_account");
            return (Criteria) this;
        }

        public Criteria andRec_mail_accountLessThanOrEqualTo(String value) {
            addCriterion("rec_mail_account <=", value, "rec_mail_account");
            return (Criteria) this;
        }

        public Criteria andRec_mail_accountLike(String value) {
            addCriterion("rec_mail_account like", value, "rec_mail_account");
            return (Criteria) this;
        }

        public Criteria andRec_mail_accountNotLike(String value) {
            addCriterion("rec_mail_account not like", value, "rec_mail_account");
            return (Criteria) this;
        }

        public Criteria andRec_mail_accountIn(List<String> values) {
            addCriterion("rec_mail_account in", values, "rec_mail_account");
            return (Criteria) this;
        }

        public Criteria andRec_mail_accountNotIn(List<String> values) {
            addCriterion("rec_mail_account not in", values, "rec_mail_account");
            return (Criteria) this;
        }

        public Criteria andRec_mail_accountBetween(String value1, String value2) {
            addCriterion("rec_mail_account between", value1, value2, "rec_mail_account");
            return (Criteria) this;
        }

        public Criteria andRec_mail_accountNotBetween(String value1, String value2) {
            addCriterion("rec_mail_account not between", value1, value2, "rec_mail_account");
            return (Criteria) this;
        }

        public Criteria andRec_mailIsNull() {
            addCriterion("rec_mail is null");
            return (Criteria) this;
        }

        public Criteria andRec_mailIsNotNull() {
            addCriterion("rec_mail is not null");
            return (Criteria) this;
        }

        public Criteria andRec_mailEqualTo(String value) {
            addCriterion("rec_mail =", value, "rec_mail");
            return (Criteria) this;
        }

        public Criteria andRec_mailNotEqualTo(String value) {
            addCriterion("rec_mail <>", value, "rec_mail");
            return (Criteria) this;
        }

        public Criteria andRec_mailGreaterThan(String value) {
            addCriterion("rec_mail >", value, "rec_mail");
            return (Criteria) this;
        }

        public Criteria andRec_mailGreaterThanOrEqualTo(String value) {
            addCriterion("rec_mail >=", value, "rec_mail");
            return (Criteria) this;
        }

        public Criteria andRec_mailLessThan(String value) {
            addCriterion("rec_mail <", value, "rec_mail");
            return (Criteria) this;
        }

        public Criteria andRec_mailLessThanOrEqualTo(String value) {
            addCriterion("rec_mail <=", value, "rec_mail");
            return (Criteria) this;
        }

        public Criteria andRec_mailLike(String value) {
            addCriterion("rec_mail like", value, "rec_mail");
            return (Criteria) this;
        }

        public Criteria andRec_mailNotLike(String value) {
            addCriterion("rec_mail not like", value, "rec_mail");
            return (Criteria) this;
        }

        public Criteria andRec_mailIn(List<String> values) {
            addCriterion("rec_mail in", values, "rec_mail");
            return (Criteria) this;
        }

        public Criteria andRec_mailNotIn(List<String> values) {
            addCriterion("rec_mail not in", values, "rec_mail");
            return (Criteria) this;
        }

        public Criteria andRec_mailBetween(String value1, String value2) {
            addCriterion("rec_mail between", value1, value2, "rec_mail");
            return (Criteria) this;
        }

        public Criteria andRec_mailNotBetween(String value1, String value2) {
            addCriterion("rec_mail not between", value1, value2, "rec_mail");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNull() {
            addCriterion("subject is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNotNull() {
            addCriterion("subject is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectEqualTo(String value) {
            addCriterion("subject =", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotEqualTo(String value) {
            addCriterion("subject <>", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThan(String value) {
            addCriterion("subject >", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("subject >=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThan(String value) {
            addCriterion("subject <", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThanOrEqualTo(String value) {
            addCriterion("subject <=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLike(String value) {
            addCriterion("subject like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotLike(String value) {
            addCriterion("subject not like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectIn(List<String> values) {
            addCriterion("subject in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotIn(List<String> values) {
            addCriterion("subject not in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectBetween(String value1, String value2) {
            addCriterion("subject between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotBetween(String value1, String value2) {
            addCriterion("subject not between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
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