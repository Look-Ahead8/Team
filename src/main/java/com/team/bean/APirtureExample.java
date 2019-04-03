package com.team.bean;

import java.util.ArrayList;
import java.util.List;

public class APirtureExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public APirtureExample() {
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

        public Criteria andApIdIsNull() {
            addCriterion("ap_id is null");
            return (Criteria) this;
        }

        public Criteria andApIdIsNotNull() {
            addCriterion("ap_id is not null");
            return (Criteria) this;
        }

        public Criteria andApIdEqualTo(Integer value) {
            addCriterion("ap_id =", value, "apId");
            return (Criteria) this;
        }

        public Criteria andApIdNotEqualTo(Integer value) {
            addCriterion("ap_id <>", value, "apId");
            return (Criteria) this;
        }

        public Criteria andApIdGreaterThan(Integer value) {
            addCriterion("ap_id >", value, "apId");
            return (Criteria) this;
        }

        public Criteria andApIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ap_id >=", value, "apId");
            return (Criteria) this;
        }

        public Criteria andApIdLessThan(Integer value) {
            addCriterion("ap_id <", value, "apId");
            return (Criteria) this;
        }

        public Criteria andApIdLessThanOrEqualTo(Integer value) {
            addCriterion("ap_id <=", value, "apId");
            return (Criteria) this;
        }

        public Criteria andApIdIn(List<Integer> values) {
            addCriterion("ap_id in", values, "apId");
            return (Criteria) this;
        }

        public Criteria andApIdNotIn(List<Integer> values) {
            addCriterion("ap_id not in", values, "apId");
            return (Criteria) this;
        }

        public Criteria andApIdBetween(Integer value1, Integer value2) {
            addCriterion("ap_id between", value1, value2, "apId");
            return (Criteria) this;
        }

        public Criteria andApIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ap_id not between", value1, value2, "apId");
            return (Criteria) this;
        }

        public Criteria andAwardIdIsNull() {
            addCriterion("award_id is null");
            return (Criteria) this;
        }

        public Criteria andAwardIdIsNotNull() {
            addCriterion("award_id is not null");
            return (Criteria) this;
        }

        public Criteria andAwardIdEqualTo(Integer value) {
            addCriterion("award_id =", value, "awardId");
            return (Criteria) this;
        }

        public Criteria andAwardIdNotEqualTo(Integer value) {
            addCriterion("award_id <>", value, "awardId");
            return (Criteria) this;
        }

        public Criteria andAwardIdGreaterThan(Integer value) {
            addCriterion("award_id >", value, "awardId");
            return (Criteria) this;
        }

        public Criteria andAwardIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("award_id >=", value, "awardId");
            return (Criteria) this;
        }

        public Criteria andAwardIdLessThan(Integer value) {
            addCriterion("award_id <", value, "awardId");
            return (Criteria) this;
        }

        public Criteria andAwardIdLessThanOrEqualTo(Integer value) {
            addCriterion("award_id <=", value, "awardId");
            return (Criteria) this;
        }

        public Criteria andAwardIdIn(List<Integer> values) {
            addCriterion("award_id in", values, "awardId");
            return (Criteria) this;
        }

        public Criteria andAwardIdNotIn(List<Integer> values) {
            addCriterion("award_id not in", values, "awardId");
            return (Criteria) this;
        }

        public Criteria andAwardIdBetween(Integer value1, Integer value2) {
            addCriterion("award_id between", value1, value2, "awardId");
            return (Criteria) this;
        }

        public Criteria andAwardIdNotBetween(Integer value1, Integer value2) {
            addCriterion("award_id not between", value1, value2, "awardId");
            return (Criteria) this;
        }

        public Criteria andPirturePathIsNull() {
            addCriterion("pirture_path is null");
            return (Criteria) this;
        }

        public Criteria andPirturePathIsNotNull() {
            addCriterion("pirture_path is not null");
            return (Criteria) this;
        }

        public Criteria andPirturePathEqualTo(String value) {
            addCriterion("pirture_path =", value, "pirturePath");
            return (Criteria) this;
        }

        public Criteria andPirturePathNotEqualTo(String value) {
            addCriterion("pirture_path <>", value, "pirturePath");
            return (Criteria) this;
        }

        public Criteria andPirturePathGreaterThan(String value) {
            addCriterion("pirture_path >", value, "pirturePath");
            return (Criteria) this;
        }

        public Criteria andPirturePathGreaterThanOrEqualTo(String value) {
            addCriterion("pirture_path >=", value, "pirturePath");
            return (Criteria) this;
        }

        public Criteria andPirturePathLessThan(String value) {
            addCriterion("pirture_path <", value, "pirturePath");
            return (Criteria) this;
        }

        public Criteria andPirturePathLessThanOrEqualTo(String value) {
            addCriterion("pirture_path <=", value, "pirturePath");
            return (Criteria) this;
        }

        public Criteria andPirturePathLike(String value) {
            addCriterion("pirture_path like", value, "pirturePath");
            return (Criteria) this;
        }

        public Criteria andPirturePathNotLike(String value) {
            addCriterion("pirture_path not like", value, "pirturePath");
            return (Criteria) this;
        }

        public Criteria andPirturePathIn(List<String> values) {
            addCriterion("pirture_path in", values, "pirturePath");
            return (Criteria) this;
        }

        public Criteria andPirturePathNotIn(List<String> values) {
            addCriterion("pirture_path not in", values, "pirturePath");
            return (Criteria) this;
        }

        public Criteria andPirturePathBetween(String value1, String value2) {
            addCriterion("pirture_path between", value1, value2, "pirturePath");
            return (Criteria) this;
        }

        public Criteria andPirturePathNotBetween(String value1, String value2) {
            addCriterion("pirture_path not between", value1, value2, "pirturePath");
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