package com.team.bean;

import java.util.ArrayList;
import java.util.List;

public class MemberExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MemberExample() {
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

        public Criteria andMIdIsNull() {
            addCriterion("m_id is null");
            return (Criteria) this;
        }

        public Criteria andMIdIsNotNull() {
            addCriterion("m_id is not null");
            return (Criteria) this;
        }

        public Criteria andMIdEqualTo(Integer value) {
            addCriterion("m_id =", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdNotEqualTo(Integer value) {
            addCriterion("m_id <>", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdGreaterThan(Integer value) {
            addCriterion("m_id >", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("m_id >=", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdLessThan(Integer value) {
            addCriterion("m_id <", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdLessThanOrEqualTo(Integer value) {
            addCriterion("m_id <=", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdIn(List<Integer> values) {
            addCriterion("m_id in", values, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdNotIn(List<Integer> values) {
            addCriterion("m_id not in", values, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdBetween(Integer value1, Integer value2) {
            addCriterion("m_id between", value1, value2, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdNotBetween(Integer value1, Integer value2) {
            addCriterion("m_id not between", value1, value2, "mId");
            return (Criteria) this;
        }

        public Criteria andStudentNoIsNull() {
            addCriterion("student_no is null");
            return (Criteria) this;
        }

        public Criteria andStudentNoIsNotNull() {
            addCriterion("student_no is not null");
            return (Criteria) this;
        }

        public Criteria andStudentNoEqualTo(String value) {
            addCriterion("student_no =", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoNotEqualTo(String value) {
            addCriterion("student_no <>", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoGreaterThan(String value) {
            addCriterion("student_no >", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoGreaterThanOrEqualTo(String value) {
            addCriterion("student_no >=", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoLessThan(String value) {
            addCriterion("student_no <", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoLessThanOrEqualTo(String value) {
            addCriterion("student_no <=", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoLike(String value) {
            addCriterion("student_no like", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoNotLike(String value) {
            addCriterion("student_no not like", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoIn(List<String> values) {
            addCriterion("student_no in", values, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoNotIn(List<String> values) {
            addCriterion("student_no not in", values, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoBetween(String value1, String value2) {
            addCriterion("student_no between", value1, value2, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoNotBetween(String value1, String value2) {
            addCriterion("student_no not between", value1, value2, "studentNo");
            return (Criteria) this;
        }

        public Criteria andGradeIsNull() {
            addCriterion("grade is null");
            return (Criteria) this;
        }

        public Criteria andGradeIsNotNull() {
            addCriterion("grade is not null");
            return (Criteria) this;
        }

        public Criteria andGradeEqualTo(String value) {
            addCriterion("grade =", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotEqualTo(String value) {
            addCriterion("grade <>", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThan(String value) {
            addCriterion("grade >", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThanOrEqualTo(String value) {
            addCriterion("grade >=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThan(String value) {
            addCriterion("grade <", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThanOrEqualTo(String value) {
            addCriterion("grade <=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLike(String value) {
            addCriterion("grade like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotLike(String value) {
            addCriterion("grade not like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeIn(List<String> values) {
            addCriterion("grade in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotIn(List<String> values) {
            addCriterion("grade not in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeBetween(String value1, String value2) {
            addCriterion("grade between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotBetween(String value1, String value2) {
            addCriterion("grade not between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andPhonenumberIsNull() {
            addCriterion("phonenumber is null");
            return (Criteria) this;
        }

        public Criteria andPhonenumberIsNotNull() {
            addCriterion("phonenumber is not null");
            return (Criteria) this;
        }

        public Criteria andPhonenumberEqualTo(String value) {
            addCriterion("phonenumber =", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotEqualTo(String value) {
            addCriterion("phonenumber <>", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberGreaterThan(String value) {
            addCriterion("phonenumber >", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberGreaterThanOrEqualTo(String value) {
            addCriterion("phonenumber >=", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberLessThan(String value) {
            addCriterion("phonenumber <", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberLessThanOrEqualTo(String value) {
            addCriterion("phonenumber <=", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberLike(String value) {
            addCriterion("phonenumber like", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotLike(String value) {
            addCriterion("phonenumber not like", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberIn(List<String> values) {
            addCriterion("phonenumber in", values, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotIn(List<String> values) {
            addCriterion("phonenumber not in", values, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberBetween(String value1, String value2) {
            addCriterion("phonenumber between", value1, value2, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotBetween(String value1, String value2) {
            addCriterion("phonenumber not between", value1, value2, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andProfessionIsNull() {
            addCriterion("profession is null");
            return (Criteria) this;
        }

        public Criteria andProfessionIsNotNull() {
            addCriterion("profession is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionEqualTo(String value) {
            addCriterion("profession =", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionNotEqualTo(String value) {
            addCriterion("profession <>", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionGreaterThan(String value) {
            addCriterion("profession >", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionGreaterThanOrEqualTo(String value) {
            addCriterion("profession >=", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionLessThan(String value) {
            addCriterion("profession <", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionLessThanOrEqualTo(String value) {
            addCriterion("profession <=", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionLike(String value) {
            addCriterion("profession like", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionNotLike(String value) {
            addCriterion("profession not like", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionIn(List<String> values) {
            addCriterion("profession in", values, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionNotIn(List<String> values) {
            addCriterion("profession not in", values, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionBetween(String value1, String value2) {
            addCriterion("profession between", value1, value2, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionNotBetween(String value1, String value2) {
            addCriterion("profession not between", value1, value2, "profession");
            return (Criteria) this;
        }

        public Criteria andWechatIsNull() {
            addCriterion("wechat is null");
            return (Criteria) this;
        }

        public Criteria andWechatIsNotNull() {
            addCriterion("wechat is not null");
            return (Criteria) this;
        }

        public Criteria andWechatEqualTo(String value) {
            addCriterion("wechat =", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatNotEqualTo(String value) {
            addCriterion("wechat <>", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatGreaterThan(String value) {
            addCriterion("wechat >", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatGreaterThanOrEqualTo(String value) {
            addCriterion("wechat >=", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatLessThan(String value) {
            addCriterion("wechat <", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatLessThanOrEqualTo(String value) {
            addCriterion("wechat <=", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatLike(String value) {
            addCriterion("wechat like", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatNotLike(String value) {
            addCriterion("wechat not like", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatIn(List<String> values) {
            addCriterion("wechat in", values, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatNotIn(List<String> values) {
            addCriterion("wechat not in", values, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatBetween(String value1, String value2) {
            addCriterion("wechat between", value1, value2, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatNotBetween(String value1, String value2) {
            addCriterion("wechat not between", value1, value2, "wechat");
            return (Criteria) this;
        }

        public Criteria andGraduationIsNull() {
            addCriterion("graduation is null");
            return (Criteria) this;
        }

        public Criteria andGraduationIsNotNull() {
            addCriterion("graduation is not null");
            return (Criteria) this;
        }

        public Criteria andGraduationEqualTo(String value) {
            addCriterion("graduation =", value, "graduation");
            return (Criteria) this;
        }

        public Criteria andGraduationNotEqualTo(String value) {
            addCriterion("graduation <>", value, "graduation");
            return (Criteria) this;
        }

        public Criteria andGraduationGreaterThan(String value) {
            addCriterion("graduation >", value, "graduation");
            return (Criteria) this;
        }

        public Criteria andGraduationGreaterThanOrEqualTo(String value) {
            addCriterion("graduation >=", value, "graduation");
            return (Criteria) this;
        }

        public Criteria andGraduationLessThan(String value) {
            addCriterion("graduation <", value, "graduation");
            return (Criteria) this;
        }

        public Criteria andGraduationLessThanOrEqualTo(String value) {
            addCriterion("graduation <=", value, "graduation");
            return (Criteria) this;
        }

        public Criteria andGraduationLike(String value) {
            addCriterion("graduation like", value, "graduation");
            return (Criteria) this;
        }

        public Criteria andGraduationNotLike(String value) {
            addCriterion("graduation not like", value, "graduation");
            return (Criteria) this;
        }

        public Criteria andGraduationIn(List<String> values) {
            addCriterion("graduation in", values, "graduation");
            return (Criteria) this;
        }

        public Criteria andGraduationNotIn(List<String> values) {
            addCriterion("graduation not in", values, "graduation");
            return (Criteria) this;
        }

        public Criteria andGraduationBetween(String value1, String value2) {
            addCriterion("graduation between", value1, value2, "graduation");
            return (Criteria) this;
        }

        public Criteria andGraduationNotBetween(String value1, String value2) {
            addCriterion("graduation not between", value1, value2, "graduation");
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