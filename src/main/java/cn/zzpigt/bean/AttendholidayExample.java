package cn.zzpigt.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AttendholidayExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AttendholidayExample() {
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

        public Criteria andHolidayidIsNull() {
            addCriterion("holidayId is null");
            return (Criteria) this;
        }

        public Criteria andHolidayidIsNotNull() {
            addCriterion("holidayId is not null");
            return (Criteria) this;
        }

        public Criteria andHolidayidEqualTo(Integer value) {
            addCriterion("holidayId =", value, "holidayid");
            return (Criteria) this;
        }

        public Criteria andHolidayidNotEqualTo(Integer value) {
            addCriterion("holidayId <>", value, "holidayid");
            return (Criteria) this;
        }

        public Criteria andHolidayidGreaterThan(Integer value) {
            addCriterion("holidayId >", value, "holidayid");
            return (Criteria) this;
        }

        public Criteria andHolidayidGreaterThanOrEqualTo(Integer value) {
            addCriterion("holidayId >=", value, "holidayid");
            return (Criteria) this;
        }

        public Criteria andHolidayidLessThan(Integer value) {
            addCriterion("holidayId <", value, "holidayid");
            return (Criteria) this;
        }

        public Criteria andHolidayidLessThanOrEqualTo(Integer value) {
            addCriterion("holidayId <=", value, "holidayid");
            return (Criteria) this;
        }

        public Criteria andHolidayidIn(List<Integer> values) {
            addCriterion("holidayId in", values, "holidayid");
            return (Criteria) this;
        }

        public Criteria andHolidayidNotIn(List<Integer> values) {
            addCriterion("holidayId not in", values, "holidayid");
            return (Criteria) this;
        }

        public Criteria andHolidayidBetween(Integer value1, Integer value2) {
            addCriterion("holidayId between", value1, value2, "holidayid");
            return (Criteria) this;
        }

        public Criteria andHolidayidNotBetween(Integer value1, Integer value2) {
            addCriterion("holidayId not between", value1, value2, "holidayid");
            return (Criteria) this;
        }

        public Criteria andHolidaynameIsNull() {
            addCriterion("holidayName is null");
            return (Criteria) this;
        }

        public Criteria andHolidaynameIsNotNull() {
            addCriterion("holidayName is not null");
            return (Criteria) this;
        }

        public Criteria andHolidaynameEqualTo(String value) {
            addCriterion("holidayName =", value, "holidayname");
            return (Criteria) this;
        }

        public Criteria andHolidaynameNotEqualTo(String value) {
            addCriterion("holidayName <>", value, "holidayname");
            return (Criteria) this;
        }

        public Criteria andHolidaynameGreaterThan(String value) {
            addCriterion("holidayName >", value, "holidayname");
            return (Criteria) this;
        }

        public Criteria andHolidaynameGreaterThanOrEqualTo(String value) {
            addCriterion("holidayName >=", value, "holidayname");
            return (Criteria) this;
        }

        public Criteria andHolidaynameLessThan(String value) {
            addCriterion("holidayName <", value, "holidayname");
            return (Criteria) this;
        }

        public Criteria andHolidaynameLessThanOrEqualTo(String value) {
            addCriterion("holidayName <=", value, "holidayname");
            return (Criteria) this;
        }

        public Criteria andHolidaynameLike(String value) {
            addCriterion("holidayName like", value, "holidayname");
            return (Criteria) this;
        }

        public Criteria andHolidaynameNotLike(String value) {
            addCriterion("holidayName not like", value, "holidayname");
            return (Criteria) this;
        }

        public Criteria andHolidaynameIn(List<String> values) {
            addCriterion("holidayName in", values, "holidayname");
            return (Criteria) this;
        }

        public Criteria andHolidaynameNotIn(List<String> values) {
            addCriterion("holidayName not in", values, "holidayname");
            return (Criteria) this;
        }

        public Criteria andHolidaynameBetween(String value1, String value2) {
            addCriterion("holidayName between", value1, value2, "holidayname");
            return (Criteria) this;
        }

        public Criteria andHolidaynameNotBetween(String value1, String value2) {
            addCriterion("holidayName not between", value1, value2, "holidayname");
            return (Criteria) this;
        }

        public Criteria andBegindateIsNull() {
            addCriterion("beginDate is null");
            return (Criteria) this;
        }

        public Criteria andBegindateIsNotNull() {
            addCriterion("beginDate is not null");
            return (Criteria) this;
        }

        public Criteria andBegindateEqualTo(Date value) {
            addCriterionForJDBCDate("beginDate =", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateNotEqualTo(Date value) {
            addCriterionForJDBCDate("beginDate <>", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateGreaterThan(Date value) {
            addCriterionForJDBCDate("beginDate >", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("beginDate >=", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateLessThan(Date value) {
            addCriterionForJDBCDate("beginDate <", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("beginDate <=", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateIn(List<Date> values) {
            addCriterionForJDBCDate("beginDate in", values, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateNotIn(List<Date> values) {
            addCriterionForJDBCDate("beginDate not in", values, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("beginDate between", value1, value2, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("beginDate not between", value1, value2, "begindate");
            return (Criteria) this;
        }

        public Criteria andEnddateIsNull() {
            addCriterion("endDate is null");
            return (Criteria) this;
        }

        public Criteria andEnddateIsNotNull() {
            addCriterion("endDate is not null");
            return (Criteria) this;
        }

        public Criteria andEnddateEqualTo(Date value) {
            addCriterionForJDBCDate("endDate =", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotEqualTo(Date value) {
            addCriterionForJDBCDate("endDate <>", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateGreaterThan(Date value) {
            addCriterionForJDBCDate("endDate >", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("endDate >=", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateLessThan(Date value) {
            addCriterionForJDBCDate("endDate <", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("endDate <=", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateIn(List<Date> values) {
            addCriterionForJDBCDate("endDate in", values, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotIn(List<Date> values) {
            addCriterionForJDBCDate("endDate not in", values, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("endDate between", value1, value2, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("endDate not between", value1, value2, "enddate");
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