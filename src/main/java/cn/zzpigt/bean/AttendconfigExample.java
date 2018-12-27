package cn.zzpigt.bean;

import java.util.ArrayList;
import java.util.List;

public class AttendconfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AttendconfigExample() {
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

        public Criteria andDutynameIsNull() {
            addCriterion("dutyName is null");
            return (Criteria) this;
        }

        public Criteria andDutynameIsNotNull() {
            addCriterion("dutyName is not null");
            return (Criteria) this;
        }

        public Criteria andDutynameEqualTo(String value) {
            addCriterion("dutyName =", value, "dutyname");
            return (Criteria) this;
        }

        public Criteria andDutynameNotEqualTo(String value) {
            addCriterion("dutyName <>", value, "dutyname");
            return (Criteria) this;
        }

        public Criteria andDutynameGreaterThan(String value) {
            addCriterion("dutyName >", value, "dutyname");
            return (Criteria) this;
        }

        public Criteria andDutynameGreaterThanOrEqualTo(String value) {
            addCriterion("dutyName >=", value, "dutyname");
            return (Criteria) this;
        }

        public Criteria andDutynameLessThan(String value) {
            addCriterion("dutyName <", value, "dutyname");
            return (Criteria) this;
        }

        public Criteria andDutynameLessThanOrEqualTo(String value) {
            addCriterion("dutyName <=", value, "dutyname");
            return (Criteria) this;
        }

        public Criteria andDutynameLike(String value) {
            addCriterion("dutyName like", value, "dutyname");
            return (Criteria) this;
        }

        public Criteria andDutynameNotLike(String value) {
            addCriterion("dutyName not like", value, "dutyname");
            return (Criteria) this;
        }

        public Criteria andDutynameIn(List<String> values) {
            addCriterion("dutyName in", values, "dutyname");
            return (Criteria) this;
        }

        public Criteria andDutynameNotIn(List<String> values) {
            addCriterion("dutyName not in", values, "dutyname");
            return (Criteria) this;
        }

        public Criteria andDutynameBetween(String value1, String value2) {
            addCriterion("dutyName between", value1, value2, "dutyname");
            return (Criteria) this;
        }

        public Criteria andDutynameNotBetween(String value1, String value2) {
            addCriterion("dutyName not between", value1, value2, "dutyname");
            return (Criteria) this;
        }

        public Criteria andGeneralIsNull() {
            addCriterion("general is null");
            return (Criteria) this;
        }

        public Criteria andGeneralIsNotNull() {
            addCriterion("general is not null");
            return (Criteria) this;
        }

        public Criteria andGeneralEqualTo(String value) {
            addCriterion("general =", value, "general");
            return (Criteria) this;
        }

        public Criteria andGeneralNotEqualTo(String value) {
            addCriterion("general <>", value, "general");
            return (Criteria) this;
        }

        public Criteria andGeneralGreaterThan(String value) {
            addCriterion("general >", value, "general");
            return (Criteria) this;
        }

        public Criteria andGeneralGreaterThanOrEqualTo(String value) {
            addCriterion("general >=", value, "general");
            return (Criteria) this;
        }

        public Criteria andGeneralLessThan(String value) {
            addCriterion("general <", value, "general");
            return (Criteria) this;
        }

        public Criteria andGeneralLessThanOrEqualTo(String value) {
            addCriterion("general <=", value, "general");
            return (Criteria) this;
        }

        public Criteria andGeneralLike(String value) {
            addCriterion("general like", value, "general");
            return (Criteria) this;
        }

        public Criteria andGeneralNotLike(String value) {
            addCriterion("general not like", value, "general");
            return (Criteria) this;
        }

        public Criteria andGeneralIn(List<String> values) {
            addCriterion("general in", values, "general");
            return (Criteria) this;
        }

        public Criteria andGeneralNotIn(List<String> values) {
            addCriterion("general not in", values, "general");
            return (Criteria) this;
        }

        public Criteria andGeneralBetween(String value1, String value2) {
            addCriterion("general between", value1, value2, "general");
            return (Criteria) this;
        }

        public Criteria andGeneralNotBetween(String value1, String value2) {
            addCriterion("general not between", value1, value2, "general");
            return (Criteria) this;
        }

        public Criteria andDutytime1IsNull() {
            addCriterion("dutyTime1 is null");
            return (Criteria) this;
        }

        public Criteria andDutytime1IsNotNull() {
            addCriterion("dutyTime1 is not null");
            return (Criteria) this;
        }

        public Criteria andDutytime1EqualTo(String value) {
            addCriterion("dutyTime1 =", value, "dutytime1");
            return (Criteria) this;
        }

        public Criteria andDutytime1NotEqualTo(String value) {
            addCriterion("dutyTime1 <>", value, "dutytime1");
            return (Criteria) this;
        }

        public Criteria andDutytime1GreaterThan(String value) {
            addCriterion("dutyTime1 >", value, "dutytime1");
            return (Criteria) this;
        }

        public Criteria andDutytime1GreaterThanOrEqualTo(String value) {
            addCriterion("dutyTime1 >=", value, "dutytime1");
            return (Criteria) this;
        }

        public Criteria andDutytime1LessThan(String value) {
            addCriterion("dutyTime1 <", value, "dutytime1");
            return (Criteria) this;
        }

        public Criteria andDutytime1LessThanOrEqualTo(String value) {
            addCriterion("dutyTime1 <=", value, "dutytime1");
            return (Criteria) this;
        }

        public Criteria andDutytime1Like(String value) {
            addCriterion("dutyTime1 like", value, "dutytime1");
            return (Criteria) this;
        }

        public Criteria andDutytime1NotLike(String value) {
            addCriterion("dutyTime1 not like", value, "dutytime1");
            return (Criteria) this;
        }

        public Criteria andDutytime1In(List<String> values) {
            addCriterion("dutyTime1 in", values, "dutytime1");
            return (Criteria) this;
        }

        public Criteria andDutytime1NotIn(List<String> values) {
            addCriterion("dutyTime1 not in", values, "dutytime1");
            return (Criteria) this;
        }

        public Criteria andDutytime1Between(String value1, String value2) {
            addCriterion("dutyTime1 between", value1, value2, "dutytime1");
            return (Criteria) this;
        }

        public Criteria andDutytime1NotBetween(String value1, String value2) {
            addCriterion("dutyTime1 not between", value1, value2, "dutytime1");
            return (Criteria) this;
        }

        public Criteria andDutytime2IsNull() {
            addCriterion("dutyTime2 is null");
            return (Criteria) this;
        }

        public Criteria andDutytime2IsNotNull() {
            addCriterion("dutyTime2 is not null");
            return (Criteria) this;
        }

        public Criteria andDutytime2EqualTo(String value) {
            addCriterion("dutyTime2 =", value, "dutytime2");
            return (Criteria) this;
        }

        public Criteria andDutytime2NotEqualTo(String value) {
            addCriterion("dutyTime2 <>", value, "dutytime2");
            return (Criteria) this;
        }

        public Criteria andDutytime2GreaterThan(String value) {
            addCriterion("dutyTime2 >", value, "dutytime2");
            return (Criteria) this;
        }

        public Criteria andDutytime2GreaterThanOrEqualTo(String value) {
            addCriterion("dutyTime2 >=", value, "dutytime2");
            return (Criteria) this;
        }

        public Criteria andDutytime2LessThan(String value) {
            addCriterion("dutyTime2 <", value, "dutytime2");
            return (Criteria) this;
        }

        public Criteria andDutytime2LessThanOrEqualTo(String value) {
            addCriterion("dutyTime2 <=", value, "dutytime2");
            return (Criteria) this;
        }

        public Criteria andDutytime2Like(String value) {
            addCriterion("dutyTime2 like", value, "dutytime2");
            return (Criteria) this;
        }

        public Criteria andDutytime2NotLike(String value) {
            addCriterion("dutyTime2 not like", value, "dutytime2");
            return (Criteria) this;
        }

        public Criteria andDutytime2In(List<String> values) {
            addCriterion("dutyTime2 in", values, "dutytime2");
            return (Criteria) this;
        }

        public Criteria andDutytime2NotIn(List<String> values) {
            addCriterion("dutyTime2 not in", values, "dutytime2");
            return (Criteria) this;
        }

        public Criteria andDutytime2Between(String value1, String value2) {
            addCriterion("dutyTime2 between", value1, value2, "dutytime2");
            return (Criteria) this;
        }

        public Criteria andDutytime2NotBetween(String value1, String value2) {
            addCriterion("dutyTime2 not between", value1, value2, "dutytime2");
            return (Criteria) this;
        }

        public Criteria andDutytime3IsNull() {
            addCriterion("dutyTime3 is null");
            return (Criteria) this;
        }

        public Criteria andDutytime3IsNotNull() {
            addCriterion("dutyTime3 is not null");
            return (Criteria) this;
        }

        public Criteria andDutytime3EqualTo(String value) {
            addCriterion("dutyTime3 =", value, "dutytime3");
            return (Criteria) this;
        }

        public Criteria andDutytime3NotEqualTo(String value) {
            addCriterion("dutyTime3 <>", value, "dutytime3");
            return (Criteria) this;
        }

        public Criteria andDutytime3GreaterThan(String value) {
            addCriterion("dutyTime3 >", value, "dutytime3");
            return (Criteria) this;
        }

        public Criteria andDutytime3GreaterThanOrEqualTo(String value) {
            addCriterion("dutyTime3 >=", value, "dutytime3");
            return (Criteria) this;
        }

        public Criteria andDutytime3LessThan(String value) {
            addCriterion("dutyTime3 <", value, "dutytime3");
            return (Criteria) this;
        }

        public Criteria andDutytime3LessThanOrEqualTo(String value) {
            addCriterion("dutyTime3 <=", value, "dutytime3");
            return (Criteria) this;
        }

        public Criteria andDutytime3Like(String value) {
            addCriterion("dutyTime3 like", value, "dutytime3");
            return (Criteria) this;
        }

        public Criteria andDutytime3NotLike(String value) {
            addCriterion("dutyTime3 not like", value, "dutytime3");
            return (Criteria) this;
        }

        public Criteria andDutytime3In(List<String> values) {
            addCriterion("dutyTime3 in", values, "dutytime3");
            return (Criteria) this;
        }

        public Criteria andDutytime3NotIn(List<String> values) {
            addCriterion("dutyTime3 not in", values, "dutytime3");
            return (Criteria) this;
        }

        public Criteria andDutytime3Between(String value1, String value2) {
            addCriterion("dutyTime3 between", value1, value2, "dutytime3");
            return (Criteria) this;
        }

        public Criteria andDutytime3NotBetween(String value1, String value2) {
            addCriterion("dutyTime3 not between", value1, value2, "dutytime3");
            return (Criteria) this;
        }

        public Criteria andDutytime4IsNull() {
            addCriterion("dutyTime4 is null");
            return (Criteria) this;
        }

        public Criteria andDutytime4IsNotNull() {
            addCriterion("dutyTime4 is not null");
            return (Criteria) this;
        }

        public Criteria andDutytime4EqualTo(String value) {
            addCriterion("dutyTime4 =", value, "dutytime4");
            return (Criteria) this;
        }

        public Criteria andDutytime4NotEqualTo(String value) {
            addCriterion("dutyTime4 <>", value, "dutytime4");
            return (Criteria) this;
        }

        public Criteria andDutytime4GreaterThan(String value) {
            addCriterion("dutyTime4 >", value, "dutytime4");
            return (Criteria) this;
        }

        public Criteria andDutytime4GreaterThanOrEqualTo(String value) {
            addCriterion("dutyTime4 >=", value, "dutytime4");
            return (Criteria) this;
        }

        public Criteria andDutytime4LessThan(String value) {
            addCriterion("dutyTime4 <", value, "dutytime4");
            return (Criteria) this;
        }

        public Criteria andDutytime4LessThanOrEqualTo(String value) {
            addCriterion("dutyTime4 <=", value, "dutytime4");
            return (Criteria) this;
        }

        public Criteria andDutytime4Like(String value) {
            addCriterion("dutyTime4 like", value, "dutytime4");
            return (Criteria) this;
        }

        public Criteria andDutytime4NotLike(String value) {
            addCriterion("dutyTime4 not like", value, "dutytime4");
            return (Criteria) this;
        }

        public Criteria andDutytime4In(List<String> values) {
            addCriterion("dutyTime4 in", values, "dutytime4");
            return (Criteria) this;
        }

        public Criteria andDutytime4NotIn(List<String> values) {
            addCriterion("dutyTime4 not in", values, "dutytime4");
            return (Criteria) this;
        }

        public Criteria andDutytime4Between(String value1, String value2) {
            addCriterion("dutyTime4 between", value1, value2, "dutytime4");
            return (Criteria) this;
        }

        public Criteria andDutytime4NotBetween(String value1, String value2) {
            addCriterion("dutyTime4 not between", value1, value2, "dutytime4");
            return (Criteria) this;
        }

        public Criteria andDutytime5IsNull() {
            addCriterion("dutyTime5 is null");
            return (Criteria) this;
        }

        public Criteria andDutytime5IsNotNull() {
            addCriterion("dutyTime5 is not null");
            return (Criteria) this;
        }

        public Criteria andDutytime5EqualTo(String value) {
            addCriterion("dutyTime5 =", value, "dutytime5");
            return (Criteria) this;
        }

        public Criteria andDutytime5NotEqualTo(String value) {
            addCriterion("dutyTime5 <>", value, "dutytime5");
            return (Criteria) this;
        }

        public Criteria andDutytime5GreaterThan(String value) {
            addCriterion("dutyTime5 >", value, "dutytime5");
            return (Criteria) this;
        }

        public Criteria andDutytime5GreaterThanOrEqualTo(String value) {
            addCriterion("dutyTime5 >=", value, "dutytime5");
            return (Criteria) this;
        }

        public Criteria andDutytime5LessThan(String value) {
            addCriterion("dutyTime5 <", value, "dutytime5");
            return (Criteria) this;
        }

        public Criteria andDutytime5LessThanOrEqualTo(String value) {
            addCriterion("dutyTime5 <=", value, "dutytime5");
            return (Criteria) this;
        }

        public Criteria andDutytime5Like(String value) {
            addCriterion("dutyTime5 like", value, "dutytime5");
            return (Criteria) this;
        }

        public Criteria andDutytime5NotLike(String value) {
            addCriterion("dutyTime5 not like", value, "dutytime5");
            return (Criteria) this;
        }

        public Criteria andDutytime5In(List<String> values) {
            addCriterion("dutyTime5 in", values, "dutytime5");
            return (Criteria) this;
        }

        public Criteria andDutytime5NotIn(List<String> values) {
            addCriterion("dutyTime5 not in", values, "dutytime5");
            return (Criteria) this;
        }

        public Criteria andDutytime5Between(String value1, String value2) {
            addCriterion("dutyTime5 between", value1, value2, "dutytime5");
            return (Criteria) this;
        }

        public Criteria andDutytime5NotBetween(String value1, String value2) {
            addCriterion("dutyTime5 not between", value1, value2, "dutytime5");
            return (Criteria) this;
        }

        public Criteria andDutytime6IsNull() {
            addCriterion("dutyTime6 is null");
            return (Criteria) this;
        }

        public Criteria andDutytime6IsNotNull() {
            addCriterion("dutyTime6 is not null");
            return (Criteria) this;
        }

        public Criteria andDutytime6EqualTo(String value) {
            addCriterion("dutyTime6 =", value, "dutytime6");
            return (Criteria) this;
        }

        public Criteria andDutytime6NotEqualTo(String value) {
            addCriterion("dutyTime6 <>", value, "dutytime6");
            return (Criteria) this;
        }

        public Criteria andDutytime6GreaterThan(String value) {
            addCriterion("dutyTime6 >", value, "dutytime6");
            return (Criteria) this;
        }

        public Criteria andDutytime6GreaterThanOrEqualTo(String value) {
            addCriterion("dutyTime6 >=", value, "dutytime6");
            return (Criteria) this;
        }

        public Criteria andDutytime6LessThan(String value) {
            addCriterion("dutyTime6 <", value, "dutytime6");
            return (Criteria) this;
        }

        public Criteria andDutytime6LessThanOrEqualTo(String value) {
            addCriterion("dutyTime6 <=", value, "dutytime6");
            return (Criteria) this;
        }

        public Criteria andDutytime6Like(String value) {
            addCriterion("dutyTime6 like", value, "dutytime6");
            return (Criteria) this;
        }

        public Criteria andDutytime6NotLike(String value) {
            addCriterion("dutyTime6 not like", value, "dutytime6");
            return (Criteria) this;
        }

        public Criteria andDutytime6In(List<String> values) {
            addCriterion("dutyTime6 in", values, "dutytime6");
            return (Criteria) this;
        }

        public Criteria andDutytime6NotIn(List<String> values) {
            addCriterion("dutyTime6 not in", values, "dutytime6");
            return (Criteria) this;
        }

        public Criteria andDutytime6Between(String value1, String value2) {
            addCriterion("dutyTime6 between", value1, value2, "dutytime6");
            return (Criteria) this;
        }

        public Criteria andDutytime6NotBetween(String value1, String value2) {
            addCriterion("dutyTime6 not between", value1, value2, "dutytime6");
            return (Criteria) this;
        }

        public Criteria andDutytype1IsNull() {
            addCriterion("dutyType1 is null");
            return (Criteria) this;
        }

        public Criteria andDutytype1IsNotNull() {
            addCriterion("dutyType1 is not null");
            return (Criteria) this;
        }

        public Criteria andDutytype1EqualTo(String value) {
            addCriterion("dutyType1 =", value, "dutytype1");
            return (Criteria) this;
        }

        public Criteria andDutytype1NotEqualTo(String value) {
            addCriterion("dutyType1 <>", value, "dutytype1");
            return (Criteria) this;
        }

        public Criteria andDutytype1GreaterThan(String value) {
            addCriterion("dutyType1 >", value, "dutytype1");
            return (Criteria) this;
        }

        public Criteria andDutytype1GreaterThanOrEqualTo(String value) {
            addCriterion("dutyType1 >=", value, "dutytype1");
            return (Criteria) this;
        }

        public Criteria andDutytype1LessThan(String value) {
            addCriterion("dutyType1 <", value, "dutytype1");
            return (Criteria) this;
        }

        public Criteria andDutytype1LessThanOrEqualTo(String value) {
            addCriterion("dutyType1 <=", value, "dutytype1");
            return (Criteria) this;
        }

        public Criteria andDutytype1Like(String value) {
            addCriterion("dutyType1 like", value, "dutytype1");
            return (Criteria) this;
        }

        public Criteria andDutytype1NotLike(String value) {
            addCriterion("dutyType1 not like", value, "dutytype1");
            return (Criteria) this;
        }

        public Criteria andDutytype1In(List<String> values) {
            addCriterion("dutyType1 in", values, "dutytype1");
            return (Criteria) this;
        }

        public Criteria andDutytype1NotIn(List<String> values) {
            addCriterion("dutyType1 not in", values, "dutytype1");
            return (Criteria) this;
        }

        public Criteria andDutytype1Between(String value1, String value2) {
            addCriterion("dutyType1 between", value1, value2, "dutytype1");
            return (Criteria) this;
        }

        public Criteria andDutytype1NotBetween(String value1, String value2) {
            addCriterion("dutyType1 not between", value1, value2, "dutytype1");
            return (Criteria) this;
        }

        public Criteria andDutytype2IsNull() {
            addCriterion("dutyType2 is null");
            return (Criteria) this;
        }

        public Criteria andDutytype2IsNotNull() {
            addCriterion("dutyType2 is not null");
            return (Criteria) this;
        }

        public Criteria andDutytype2EqualTo(String value) {
            addCriterion("dutyType2 =", value, "dutytype2");
            return (Criteria) this;
        }

        public Criteria andDutytype2NotEqualTo(String value) {
            addCriterion("dutyType2 <>", value, "dutytype2");
            return (Criteria) this;
        }

        public Criteria andDutytype2GreaterThan(String value) {
            addCriterion("dutyType2 >", value, "dutytype2");
            return (Criteria) this;
        }

        public Criteria andDutytype2GreaterThanOrEqualTo(String value) {
            addCriterion("dutyType2 >=", value, "dutytype2");
            return (Criteria) this;
        }

        public Criteria andDutytype2LessThan(String value) {
            addCriterion("dutyType2 <", value, "dutytype2");
            return (Criteria) this;
        }

        public Criteria andDutytype2LessThanOrEqualTo(String value) {
            addCriterion("dutyType2 <=", value, "dutytype2");
            return (Criteria) this;
        }

        public Criteria andDutytype2Like(String value) {
            addCriterion("dutyType2 like", value, "dutytype2");
            return (Criteria) this;
        }

        public Criteria andDutytype2NotLike(String value) {
            addCriterion("dutyType2 not like", value, "dutytype2");
            return (Criteria) this;
        }

        public Criteria andDutytype2In(List<String> values) {
            addCriterion("dutyType2 in", values, "dutytype2");
            return (Criteria) this;
        }

        public Criteria andDutytype2NotIn(List<String> values) {
            addCriterion("dutyType2 not in", values, "dutytype2");
            return (Criteria) this;
        }

        public Criteria andDutytype2Between(String value1, String value2) {
            addCriterion("dutyType2 between", value1, value2, "dutytype2");
            return (Criteria) this;
        }

        public Criteria andDutytype2NotBetween(String value1, String value2) {
            addCriterion("dutyType2 not between", value1, value2, "dutytype2");
            return (Criteria) this;
        }

        public Criteria andDutytype3IsNull() {
            addCriterion("dutyType3 is null");
            return (Criteria) this;
        }

        public Criteria andDutytype3IsNotNull() {
            addCriterion("dutyType3 is not null");
            return (Criteria) this;
        }

        public Criteria andDutytype3EqualTo(String value) {
            addCriterion("dutyType3 =", value, "dutytype3");
            return (Criteria) this;
        }

        public Criteria andDutytype3NotEqualTo(String value) {
            addCriterion("dutyType3 <>", value, "dutytype3");
            return (Criteria) this;
        }

        public Criteria andDutytype3GreaterThan(String value) {
            addCriterion("dutyType3 >", value, "dutytype3");
            return (Criteria) this;
        }

        public Criteria andDutytype3GreaterThanOrEqualTo(String value) {
            addCriterion("dutyType3 >=", value, "dutytype3");
            return (Criteria) this;
        }

        public Criteria andDutytype3LessThan(String value) {
            addCriterion("dutyType3 <", value, "dutytype3");
            return (Criteria) this;
        }

        public Criteria andDutytype3LessThanOrEqualTo(String value) {
            addCriterion("dutyType3 <=", value, "dutytype3");
            return (Criteria) this;
        }

        public Criteria andDutytype3Like(String value) {
            addCriterion("dutyType3 like", value, "dutytype3");
            return (Criteria) this;
        }

        public Criteria andDutytype3NotLike(String value) {
            addCriterion("dutyType3 not like", value, "dutytype3");
            return (Criteria) this;
        }

        public Criteria andDutytype3In(List<String> values) {
            addCriterion("dutyType3 in", values, "dutytype3");
            return (Criteria) this;
        }

        public Criteria andDutytype3NotIn(List<String> values) {
            addCriterion("dutyType3 not in", values, "dutytype3");
            return (Criteria) this;
        }

        public Criteria andDutytype3Between(String value1, String value2) {
            addCriterion("dutyType3 between", value1, value2, "dutytype3");
            return (Criteria) this;
        }

        public Criteria andDutytype3NotBetween(String value1, String value2) {
            addCriterion("dutyType3 not between", value1, value2, "dutytype3");
            return (Criteria) this;
        }

        public Criteria andDutytype4IsNull() {
            addCriterion("dutyType4 is null");
            return (Criteria) this;
        }

        public Criteria andDutytype4IsNotNull() {
            addCriterion("dutyType4 is not null");
            return (Criteria) this;
        }

        public Criteria andDutytype4EqualTo(String value) {
            addCriterion("dutyType4 =", value, "dutytype4");
            return (Criteria) this;
        }

        public Criteria andDutytype4NotEqualTo(String value) {
            addCriterion("dutyType4 <>", value, "dutytype4");
            return (Criteria) this;
        }

        public Criteria andDutytype4GreaterThan(String value) {
            addCriterion("dutyType4 >", value, "dutytype4");
            return (Criteria) this;
        }

        public Criteria andDutytype4GreaterThanOrEqualTo(String value) {
            addCriterion("dutyType4 >=", value, "dutytype4");
            return (Criteria) this;
        }

        public Criteria andDutytype4LessThan(String value) {
            addCriterion("dutyType4 <", value, "dutytype4");
            return (Criteria) this;
        }

        public Criteria andDutytype4LessThanOrEqualTo(String value) {
            addCriterion("dutyType4 <=", value, "dutytype4");
            return (Criteria) this;
        }

        public Criteria andDutytype4Like(String value) {
            addCriterion("dutyType4 like", value, "dutytype4");
            return (Criteria) this;
        }

        public Criteria andDutytype4NotLike(String value) {
            addCriterion("dutyType4 not like", value, "dutytype4");
            return (Criteria) this;
        }

        public Criteria andDutytype4In(List<String> values) {
            addCriterion("dutyType4 in", values, "dutytype4");
            return (Criteria) this;
        }

        public Criteria andDutytype4NotIn(List<String> values) {
            addCriterion("dutyType4 not in", values, "dutytype4");
            return (Criteria) this;
        }

        public Criteria andDutytype4Between(String value1, String value2) {
            addCriterion("dutyType4 between", value1, value2, "dutytype4");
            return (Criteria) this;
        }

        public Criteria andDutytype4NotBetween(String value1, String value2) {
            addCriterion("dutyType4 not between", value1, value2, "dutytype4");
            return (Criteria) this;
        }

        public Criteria andDutytype5IsNull() {
            addCriterion("dutyType5 is null");
            return (Criteria) this;
        }

        public Criteria andDutytype5IsNotNull() {
            addCriterion("dutyType5 is not null");
            return (Criteria) this;
        }

        public Criteria andDutytype5EqualTo(String value) {
            addCriterion("dutyType5 =", value, "dutytype5");
            return (Criteria) this;
        }

        public Criteria andDutytype5NotEqualTo(String value) {
            addCriterion("dutyType5 <>", value, "dutytype5");
            return (Criteria) this;
        }

        public Criteria andDutytype5GreaterThan(String value) {
            addCriterion("dutyType5 >", value, "dutytype5");
            return (Criteria) this;
        }

        public Criteria andDutytype5GreaterThanOrEqualTo(String value) {
            addCriterion("dutyType5 >=", value, "dutytype5");
            return (Criteria) this;
        }

        public Criteria andDutytype5LessThan(String value) {
            addCriterion("dutyType5 <", value, "dutytype5");
            return (Criteria) this;
        }

        public Criteria andDutytype5LessThanOrEqualTo(String value) {
            addCriterion("dutyType5 <=", value, "dutytype5");
            return (Criteria) this;
        }

        public Criteria andDutytype5Like(String value) {
            addCriterion("dutyType5 like", value, "dutytype5");
            return (Criteria) this;
        }

        public Criteria andDutytype5NotLike(String value) {
            addCriterion("dutyType5 not like", value, "dutytype5");
            return (Criteria) this;
        }

        public Criteria andDutytype5In(List<String> values) {
            addCriterion("dutyType5 in", values, "dutytype5");
            return (Criteria) this;
        }

        public Criteria andDutytype5NotIn(List<String> values) {
            addCriterion("dutyType5 not in", values, "dutytype5");
            return (Criteria) this;
        }

        public Criteria andDutytype5Between(String value1, String value2) {
            addCriterion("dutyType5 between", value1, value2, "dutytype5");
            return (Criteria) this;
        }

        public Criteria andDutytype5NotBetween(String value1, String value2) {
            addCriterion("dutyType5 not between", value1, value2, "dutytype5");
            return (Criteria) this;
        }

        public Criteria andDutytype6IsNull() {
            addCriterion("dutyType6 is null");
            return (Criteria) this;
        }

        public Criteria andDutytype6IsNotNull() {
            addCriterion("dutyType6 is not null");
            return (Criteria) this;
        }

        public Criteria andDutytype6EqualTo(String value) {
            addCriterion("dutyType6 =", value, "dutytype6");
            return (Criteria) this;
        }

        public Criteria andDutytype6NotEqualTo(String value) {
            addCriterion("dutyType6 <>", value, "dutytype6");
            return (Criteria) this;
        }

        public Criteria andDutytype6GreaterThan(String value) {
            addCriterion("dutyType6 >", value, "dutytype6");
            return (Criteria) this;
        }

        public Criteria andDutytype6GreaterThanOrEqualTo(String value) {
            addCriterion("dutyType6 >=", value, "dutytype6");
            return (Criteria) this;
        }

        public Criteria andDutytype6LessThan(String value) {
            addCriterion("dutyType6 <", value, "dutytype6");
            return (Criteria) this;
        }

        public Criteria andDutytype6LessThanOrEqualTo(String value) {
            addCriterion("dutyType6 <=", value, "dutytype6");
            return (Criteria) this;
        }

        public Criteria andDutytype6Like(String value) {
            addCriterion("dutyType6 like", value, "dutytype6");
            return (Criteria) this;
        }

        public Criteria andDutytype6NotLike(String value) {
            addCriterion("dutyType6 not like", value, "dutytype6");
            return (Criteria) this;
        }

        public Criteria andDutytype6In(List<String> values) {
            addCriterion("dutyType6 in", values, "dutytype6");
            return (Criteria) this;
        }

        public Criteria andDutytype6NotIn(List<String> values) {
            addCriterion("dutyType6 not in", values, "dutytype6");
            return (Criteria) this;
        }

        public Criteria andDutytype6Between(String value1, String value2) {
            addCriterion("dutyType6 between", value1, value2, "dutytype6");
            return (Criteria) this;
        }

        public Criteria andDutytype6NotBetween(String value1, String value2) {
            addCriterion("dutyType6 not between", value1, value2, "dutytype6");
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