package cn.zzpigt.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AttenddutyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AttenddutyExample() {
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

        public Criteria andRegistertypeIsNull() {
            addCriterion("registerType is null");
            return (Criteria) this;
        }

        public Criteria andRegistertypeIsNotNull() {
            addCriterion("registerType is not null");
            return (Criteria) this;
        }

        public Criteria andRegistertypeEqualTo(String value) {
            addCriterion("registerType =", value, "registertype");
            return (Criteria) this;
        }

        public Criteria andRegistertypeNotEqualTo(String value) {
            addCriterion("registerType <>", value, "registertype");
            return (Criteria) this;
        }

        public Criteria andRegistertypeGreaterThan(String value) {
            addCriterion("registerType >", value, "registertype");
            return (Criteria) this;
        }

        public Criteria andRegistertypeGreaterThanOrEqualTo(String value) {
            addCriterion("registerType >=", value, "registertype");
            return (Criteria) this;
        }

        public Criteria andRegistertypeLessThan(String value) {
            addCriterion("registerType <", value, "registertype");
            return (Criteria) this;
        }

        public Criteria andRegistertypeLessThanOrEqualTo(String value) {
            addCriterion("registerType <=", value, "registertype");
            return (Criteria) this;
        }

        public Criteria andRegistertypeLike(String value) {
            addCriterion("registerType like", value, "registertype");
            return (Criteria) this;
        }

        public Criteria andRegistertypeNotLike(String value) {
            addCriterion("registerType not like", value, "registertype");
            return (Criteria) this;
        }

        public Criteria andRegistertypeIn(List<String> values) {
            addCriterion("registerType in", values, "registertype");
            return (Criteria) this;
        }

        public Criteria andRegistertypeNotIn(List<String> values) {
            addCriterion("registerType not in", values, "registertype");
            return (Criteria) this;
        }

        public Criteria andRegistertypeBetween(String value1, String value2) {
            addCriterion("registerType between", value1, value2, "registertype");
            return (Criteria) this;
        }

        public Criteria andRegistertypeNotBetween(String value1, String value2) {
            addCriterion("registerType not between", value1, value2, "registertype");
            return (Criteria) this;
        }

        public Criteria andRegistertimeIsNull() {
            addCriterion("registerTime is null");
            return (Criteria) this;
        }

        public Criteria andRegistertimeIsNotNull() {
            addCriterion("registerTime is not null");
            return (Criteria) this;
        }

        public Criteria andRegistertimeEqualTo(Date value) {
            addCriterion("registerTime =", value, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeNotEqualTo(Date value) {
            addCriterion("registerTime <>", value, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeGreaterThan(Date value) {
            addCriterion("registerTime >", value, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeGreaterThanOrEqualTo(Date value) {
            addCriterion("registerTime >=", value, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeLessThan(Date value) {
            addCriterion("registerTime <", value, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeLessThanOrEqualTo(Date value) {
            addCriterion("registerTime <=", value, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeIn(List<Date> values) {
            addCriterion("registerTime in", values, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeNotIn(List<Date> values) {
            addCriterion("registerTime not in", values, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeBetween(Date value1, Date value2) {
            addCriterion("registerTime between", value1, value2, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeNotBetween(Date value1, Date value2) {
            addCriterion("registerTime not between", value1, value2, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegisteripIsNull() {
            addCriterion("registerIp is null");
            return (Criteria) this;
        }

        public Criteria andRegisteripIsNotNull() {
            addCriterion("registerIp is not null");
            return (Criteria) this;
        }

        public Criteria andRegisteripEqualTo(String value) {
            addCriterion("registerIp =", value, "registerip");
            return (Criteria) this;
        }

        public Criteria andRegisteripNotEqualTo(String value) {
            addCriterion("registerIp <>", value, "registerip");
            return (Criteria) this;
        }

        public Criteria andRegisteripGreaterThan(String value) {
            addCriterion("registerIp >", value, "registerip");
            return (Criteria) this;
        }

        public Criteria andRegisteripGreaterThanOrEqualTo(String value) {
            addCriterion("registerIp >=", value, "registerip");
            return (Criteria) this;
        }

        public Criteria andRegisteripLessThan(String value) {
            addCriterion("registerIp <", value, "registerip");
            return (Criteria) this;
        }

        public Criteria andRegisteripLessThanOrEqualTo(String value) {
            addCriterion("registerIp <=", value, "registerip");
            return (Criteria) this;
        }

        public Criteria andRegisteripLike(String value) {
            addCriterion("registerIp like", value, "registerip");
            return (Criteria) this;
        }

        public Criteria andRegisteripNotLike(String value) {
            addCriterion("registerIp not like", value, "registerip");
            return (Criteria) this;
        }

        public Criteria andRegisteripIn(List<String> values) {
            addCriterion("registerIp in", values, "registerip");
            return (Criteria) this;
        }

        public Criteria andRegisteripNotIn(List<String> values) {
            addCriterion("registerIp not in", values, "registerip");
            return (Criteria) this;
        }

        public Criteria andRegisteripBetween(String value1, String value2) {
            addCriterion("registerIp between", value1, value2, "registerip");
            return (Criteria) this;
        }

        public Criteria andRegisteripNotBetween(String value1, String value2) {
            addCriterion("registerIp not between", value1, value2, "registerip");
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

        public Criteria andDutytypeIsNull() {
            addCriterion("dutyType is null");
            return (Criteria) this;
        }

        public Criteria andDutytypeIsNotNull() {
            addCriterion("dutyType is not null");
            return (Criteria) this;
        }

        public Criteria andDutytypeEqualTo(Integer value) {
            addCriterion("dutyType =", value, "dutytype");
            return (Criteria) this;
        }

        public Criteria andDutytypeNotEqualTo(Integer value) {
            addCriterion("dutyType <>", value, "dutytype");
            return (Criteria) this;
        }

        public Criteria andDutytypeGreaterThan(Integer value) {
            addCriterion("dutyType >", value, "dutytype");
            return (Criteria) this;
        }

        public Criteria andDutytypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("dutyType >=", value, "dutytype");
            return (Criteria) this;
        }

        public Criteria andDutytypeLessThan(Integer value) {
            addCriterion("dutyType <", value, "dutytype");
            return (Criteria) this;
        }

        public Criteria andDutytypeLessThanOrEqualTo(Integer value) {
            addCriterion("dutyType <=", value, "dutytype");
            return (Criteria) this;
        }

        public Criteria andDutytypeIn(List<Integer> values) {
            addCriterion("dutyType in", values, "dutytype");
            return (Criteria) this;
        }

        public Criteria andDutytypeNotIn(List<Integer> values) {
            addCriterion("dutyType not in", values, "dutytype");
            return (Criteria) this;
        }

        public Criteria andDutytypeBetween(Integer value1, Integer value2) {
            addCriterion("dutyType between", value1, value2, "dutytype");
            return (Criteria) this;
        }

        public Criteria andDutytypeNotBetween(Integer value1, Integer value2) {
            addCriterion("dutyType not between", value1, value2, "dutytype");
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