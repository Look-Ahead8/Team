package com.team.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class LifeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LifeExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andLifeIdIsNull() {
            addCriterion("life_id is null");
            return (Criteria) this;
        }

        public Criteria andLifeIdIsNotNull() {
            addCriterion("life_id is not null");
            return (Criteria) this;
        }

        public Criteria andLifeIdEqualTo(Integer value) {
            addCriterion("life_id =", value, "lifeId");
            return (Criteria) this;
        }

        public Criteria andLifeIdNotEqualTo(Integer value) {
            addCriterion("life_id <>", value, "lifeId");
            return (Criteria) this;
        }

        public Criteria andLifeIdGreaterThan(Integer value) {
            addCriterion("life_id >", value, "lifeId");
            return (Criteria) this;
        }

        public Criteria andLifeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("life_id >=", value, "lifeId");
            return (Criteria) this;
        }

        public Criteria andLifeIdLessThan(Integer value) {
            addCriterion("life_id <", value, "lifeId");
            return (Criteria) this;
        }

        public Criteria andLifeIdLessThanOrEqualTo(Integer value) {
            addCriterion("life_id <=", value, "lifeId");
            return (Criteria) this;
        }

        public Criteria andLifeIdIn(List<Integer> values) {
            addCriterion("life_id in", values, "lifeId");
            return (Criteria) this;
        }

        public Criteria andLifeIdNotIn(List<Integer> values) {
            addCriterion("life_id not in", values, "lifeId");
            return (Criteria) this;
        }

        public Criteria andLifeIdBetween(Integer value1, Integer value2) {
            addCriterion("life_id between", value1, value2, "lifeId");
            return (Criteria) this;
        }

        public Criteria andLifeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("life_id not between", value1, value2, "lifeId");
            return (Criteria) this;
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

        public Criteria andContextIsNull() {
            addCriterion("context is null");
            return (Criteria) this;
        }

        public Criteria andContextIsNotNull() {
            addCriterion("context is not null");
            return (Criteria) this;
        }

        public Criteria andContextEqualTo(String value) {
            addCriterion("context =", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextNotEqualTo(String value) {
            addCriterion("context <>", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextGreaterThan(String value) {
            addCriterion("context >", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextGreaterThanOrEqualTo(String value) {
            addCriterion("context >=", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextLessThan(String value) {
            addCriterion("context <", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextLessThanOrEqualTo(String value) {
            addCriterion("context <=", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextLike(String value) {
            addCriterion("context like", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextNotLike(String value) {
            addCriterion("context not like", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextIn(List<String> values) {
            addCriterion("context in", values, "context");
            return (Criteria) this;
        }

        public Criteria andContextNotIn(List<String> values) {
            addCriterion("context not in", values, "context");
            return (Criteria) this;
        }

        public Criteria andContextBetween(String value1, String value2) {
            addCriterion("context between", value1, value2, "context");
            return (Criteria) this;
        }

        public Criteria andContextNotBetween(String value1, String value2) {
            addCriterion("context not between", value1, value2, "context");
            return (Criteria) this;
        }

        public Criteria andLifeDateIsNull() {
            addCriterion("life_date is null");
            return (Criteria) this;
        }

        public Criteria andLifeDateIsNotNull() {
            addCriterion("life_date is not null");
            return (Criteria) this;
        }

        public Criteria andLifeDateEqualTo(Date value) {
            addCriterionForJDBCDate("life_date =", value, "lifeDate");
            return (Criteria) this;
        }

        public Criteria andLifeDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("life_date <>", value, "lifeDate");
            return (Criteria) this;
        }

        public Criteria andLifeDateGreaterThan(Date value) {
            addCriterionForJDBCDate("life_date >", value, "lifeDate");
            return (Criteria) this;
        }

        public Criteria andLifeDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("life_date >=", value, "lifeDate");
            return (Criteria) this;
        }

        public Criteria andLifeDateLessThan(Date value) {
            addCriterionForJDBCDate("life_date <", value, "lifeDate");
            return (Criteria) this;
        }

        public Criteria andLifeDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("life_date <=", value, "lifeDate");
            return (Criteria) this;
        }

        public Criteria andLifeDateIn(List<Date> values) {
            addCriterionForJDBCDate("life_date in", values, "lifeDate");
            return (Criteria) this;
        }

        public Criteria andLifeDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("life_date not in", values, "lifeDate");
            return (Criteria) this;
        }

        public Criteria andLifeDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("life_date between", value1, value2, "lifeDate");
            return (Criteria) this;
        }

        public Criteria andLifeDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("life_date not between", value1, value2, "lifeDate");
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