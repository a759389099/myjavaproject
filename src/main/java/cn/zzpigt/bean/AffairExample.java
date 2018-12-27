package cn.zzpigt.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AffairExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AffairExample() {
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

        public Criteria andAffairidIsNull() {
            addCriterion("affairId is null");
            return (Criteria) this;
        }

        public Criteria andAffairidIsNotNull() {
            addCriterion("affairId is not null");
            return (Criteria) this;
        }

        public Criteria andAffairidEqualTo(Integer value) {
            addCriterion("affairId =", value, "affairid");
            return (Criteria) this;
        }

        public Criteria andAffairidNotEqualTo(Integer value) {
            addCriterion("affairId <>", value, "affairid");
            return (Criteria) this;
        }

        public Criteria andAffairidGreaterThan(Integer value) {
            addCriterion("affairId >", value, "affairid");
            return (Criteria) this;
        }

        public Criteria andAffairidGreaterThanOrEqualTo(Integer value) {
            addCriterion("affairId >=", value, "affairid");
            return (Criteria) this;
        }

        public Criteria andAffairidLessThan(Integer value) {
            addCriterion("affairId <", value, "affairid");
            return (Criteria) this;
        }

        public Criteria andAffairidLessThanOrEqualTo(Integer value) {
            addCriterion("affairId <=", value, "affairid");
            return (Criteria) this;
        }

        public Criteria andAffairidIn(List<Integer> values) {
            addCriterion("affairId in", values, "affairid");
            return (Criteria) this;
        }

        public Criteria andAffairidNotIn(List<Integer> values) {
            addCriterion("affairId not in", values, "affairid");
            return (Criteria) this;
        }

        public Criteria andAffairidBetween(Integer value1, Integer value2) {
            addCriterion("affairId between", value1, value2, "affairid");
            return (Criteria) this;
        }

        public Criteria andAffairidNotBetween(Integer value1, Integer value2) {
            addCriterion("affairId not between", value1, value2, "affairid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andAffairtimeIsNull() {
            addCriterion("affairTime is null");
            return (Criteria) this;
        }

        public Criteria andAffairtimeIsNotNull() {
            addCriterion("affairTime is not null");
            return (Criteria) this;
        }

        public Criteria andAffairtimeEqualTo(Date value) {
            addCriterion("affairTime =", value, "affairtime");
            return (Criteria) this;
        }

        public Criteria andAffairtimeNotEqualTo(Date value) {
            addCriterion("affairTime <>", value, "affairtime");
            return (Criteria) this;
        }

        public Criteria andAffairtimeGreaterThan(Date value) {
            addCriterion("affairTime >", value, "affairtime");
            return (Criteria) this;
        }

        public Criteria andAffairtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("affairTime >=", value, "affairtime");
            return (Criteria) this;
        }

        public Criteria andAffairtimeLessThan(Date value) {
            addCriterion("affairTime <", value, "affairtime");
            return (Criteria) this;
        }

        public Criteria andAffairtimeLessThanOrEqualTo(Date value) {
            addCriterion("affairTime <=", value, "affairtime");
            return (Criteria) this;
        }

        public Criteria andAffairtimeIn(List<Date> values) {
            addCriterion("affairTime in", values, "affairtime");
            return (Criteria) this;
        }

        public Criteria andAffairtimeNotIn(List<Date> values) {
            addCriterion("affairTime not in", values, "affairtime");
            return (Criteria) this;
        }

        public Criteria andAffairtimeBetween(Date value1, Date value2) {
            addCriterion("affairTime between", value1, value2, "affairtime");
            return (Criteria) this;
        }

        public Criteria andAffairtimeNotBetween(Date value1, Date value2) {
            addCriterion("affairTime not between", value1, value2, "affairtime");
            return (Criteria) this;
        }

        public Criteria andAffairstateIsNull() {
            addCriterion("affairState is null");
            return (Criteria) this;
        }

        public Criteria andAffairstateIsNotNull() {
            addCriterion("affairState is not null");
            return (Criteria) this;
        }

        public Criteria andAffairstateEqualTo(Byte value) {
            addCriterion("affairState =", value, "affairstate");
            return (Criteria) this;
        }

        public Criteria andAffairstateNotEqualTo(Byte value) {
            addCriterion("affairState <>", value, "affairstate");
            return (Criteria) this;
        }

        public Criteria andAffairstateGreaterThan(Byte value) {
            addCriterion("affairState >", value, "affairstate");
            return (Criteria) this;
        }

        public Criteria andAffairstateGreaterThanOrEqualTo(Byte value) {
            addCriterion("affairState >=", value, "affairstate");
            return (Criteria) this;
        }

        public Criteria andAffairstateLessThan(Byte value) {
            addCriterion("affairState <", value, "affairstate");
            return (Criteria) this;
        }

        public Criteria andAffairstateLessThanOrEqualTo(Byte value) {
            addCriterion("affairState <=", value, "affairstate");
            return (Criteria) this;
        }

        public Criteria andAffairstateIn(List<Byte> values) {
            addCriterion("affairState in", values, "affairstate");
            return (Criteria) this;
        }

        public Criteria andAffairstateNotIn(List<Byte> values) {
            addCriterion("affairState not in", values, "affairstate");
            return (Criteria) this;
        }

        public Criteria andAffairstateBetween(Byte value1, Byte value2) {
            addCriterion("affairState between", value1, value2, "affairstate");
            return (Criteria) this;
        }

        public Criteria andAffairstateNotBetween(Byte value1, Byte value2) {
            addCriterion("affairState not between", value1, value2, "affairstate");
            return (Criteria) this;
        }

        public Criteria andAffairmodelidIsNull() {
            addCriterion("affairModelId is null");
            return (Criteria) this;
        }

        public Criteria andAffairmodelidIsNotNull() {
            addCriterion("affairModelId is not null");
            return (Criteria) this;
        }

        public Criteria andAffairmodelidEqualTo(Integer value) {
            addCriterion("affairModelId =", value, "affairmodelid");
            return (Criteria) this;
        }

        public Criteria andAffairmodelidNotEqualTo(Integer value) {
            addCriterion("affairModelId <>", value, "affairmodelid");
            return (Criteria) this;
        }

        public Criteria andAffairmodelidGreaterThan(Integer value) {
            addCriterion("affairModelId >", value, "affairmodelid");
            return (Criteria) this;
        }

        public Criteria andAffairmodelidGreaterThanOrEqualTo(Integer value) {
            addCriterion("affairModelId >=", value, "affairmodelid");
            return (Criteria) this;
        }

        public Criteria andAffairmodelidLessThan(Integer value) {
            addCriterion("affairModelId <", value, "affairmodelid");
            return (Criteria) this;
        }

        public Criteria andAffairmodelidLessThanOrEqualTo(Integer value) {
            addCriterion("affairModelId <=", value, "affairmodelid");
            return (Criteria) this;
        }

        public Criteria andAffairmodelidIn(List<Integer> values) {
            addCriterion("affairModelId in", values, "affairmodelid");
            return (Criteria) this;
        }

        public Criteria andAffairmodelidNotIn(List<Integer> values) {
            addCriterion("affairModelId not in", values, "affairmodelid");
            return (Criteria) this;
        }

        public Criteria andAffairmodelidBetween(Integer value1, Integer value2) {
            addCriterion("affairModelId between", value1, value2, "affairmodelid");
            return (Criteria) this;
        }

        public Criteria andAffairmodelidNotBetween(Integer value1, Integer value2) {
            addCriterion("affairModelId not between", value1, value2, "affairmodelid");
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