package cn.zzpigt.bean;

import java.util.ArrayList;
import java.util.List;

public class OperateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OperateExample() {
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

        public Criteria andOperateidIsNull() {
            addCriterion("operateId is null");
            return (Criteria) this;
        }

        public Criteria andOperateidIsNotNull() {
            addCriterion("operateId is not null");
            return (Criteria) this;
        }

        public Criteria andOperateidEqualTo(Integer value) {
            addCriterion("operateId =", value, "operateid");
            return (Criteria) this;
        }

        public Criteria andOperateidNotEqualTo(Integer value) {
            addCriterion("operateId <>", value, "operateid");
            return (Criteria) this;
        }

        public Criteria andOperateidGreaterThan(Integer value) {
            addCriterion("operateId >", value, "operateid");
            return (Criteria) this;
        }

        public Criteria andOperateidGreaterThanOrEqualTo(Integer value) {
            addCriterion("operateId >=", value, "operateid");
            return (Criteria) this;
        }

        public Criteria andOperateidLessThan(Integer value) {
            addCriterion("operateId <", value, "operateid");
            return (Criteria) this;
        }

        public Criteria andOperateidLessThanOrEqualTo(Integer value) {
            addCriterion("operateId <=", value, "operateid");
            return (Criteria) this;
        }

        public Criteria andOperateidIn(List<Integer> values) {
            addCriterion("operateId in", values, "operateid");
            return (Criteria) this;
        }

        public Criteria andOperateidNotIn(List<Integer> values) {
            addCriterion("operateId not in", values, "operateid");
            return (Criteria) this;
        }

        public Criteria andOperateidBetween(Integer value1, Integer value2) {
            addCriterion("operateId between", value1, value2, "operateid");
            return (Criteria) this;
        }

        public Criteria andOperateidNotBetween(Integer value1, Integer value2) {
            addCriterion("operateId not between", value1, value2, "operateid");
            return (Criteria) this;
        }

        public Criteria andOperatenameIsNull() {
            addCriterion("operateName is null");
            return (Criteria) this;
        }

        public Criteria andOperatenameIsNotNull() {
            addCriterion("operateName is not null");
            return (Criteria) this;
        }

        public Criteria andOperatenameEqualTo(String value) {
            addCriterion("operateName =", value, "operatename");
            return (Criteria) this;
        }

        public Criteria andOperatenameNotEqualTo(String value) {
            addCriterion("operateName <>", value, "operatename");
            return (Criteria) this;
        }

        public Criteria andOperatenameGreaterThan(String value) {
            addCriterion("operateName >", value, "operatename");
            return (Criteria) this;
        }

        public Criteria andOperatenameGreaterThanOrEqualTo(String value) {
            addCriterion("operateName >=", value, "operatename");
            return (Criteria) this;
        }

        public Criteria andOperatenameLessThan(String value) {
            addCriterion("operateName <", value, "operatename");
            return (Criteria) this;
        }

        public Criteria andOperatenameLessThanOrEqualTo(String value) {
            addCriterion("operateName <=", value, "operatename");
            return (Criteria) this;
        }

        public Criteria andOperatenameLike(String value) {
            addCriterion("operateName like", value, "operatename");
            return (Criteria) this;
        }

        public Criteria andOperatenameNotLike(String value) {
            addCriterion("operateName not like", value, "operatename");
            return (Criteria) this;
        }

        public Criteria andOperatenameIn(List<String> values) {
            addCriterion("operateName in", values, "operatename");
            return (Criteria) this;
        }

        public Criteria andOperatenameNotIn(List<String> values) {
            addCriterion("operateName not in", values, "operatename");
            return (Criteria) this;
        }

        public Criteria andOperatenameBetween(String value1, String value2) {
            addCriterion("operateName between", value1, value2, "operatename");
            return (Criteria) this;
        }

        public Criteria andOperatenameNotBetween(String value1, String value2) {
            addCriterion("operateName not between", value1, value2, "operatename");
            return (Criteria) this;
        }

        public Criteria andOperateactionIsNull() {
            addCriterion("operateAction is null");
            return (Criteria) this;
        }

        public Criteria andOperateactionIsNotNull() {
            addCriterion("operateAction is not null");
            return (Criteria) this;
        }

        public Criteria andOperateactionEqualTo(String value) {
            addCriterion("operateAction =", value, "operateaction");
            return (Criteria) this;
        }

        public Criteria andOperateactionNotEqualTo(String value) {
            addCriterion("operateAction <>", value, "operateaction");
            return (Criteria) this;
        }

        public Criteria andOperateactionGreaterThan(String value) {
            addCriterion("operateAction >", value, "operateaction");
            return (Criteria) this;
        }

        public Criteria andOperateactionGreaterThanOrEqualTo(String value) {
            addCriterion("operateAction >=", value, "operateaction");
            return (Criteria) this;
        }

        public Criteria andOperateactionLessThan(String value) {
            addCriterion("operateAction <", value, "operateaction");
            return (Criteria) this;
        }

        public Criteria andOperateactionLessThanOrEqualTo(String value) {
            addCriterion("operateAction <=", value, "operateaction");
            return (Criteria) this;
        }

        public Criteria andOperateactionLike(String value) {
            addCriterion("operateAction like", value, "operateaction");
            return (Criteria) this;
        }

        public Criteria andOperateactionNotLike(String value) {
            addCriterion("operateAction not like", value, "operateaction");
            return (Criteria) this;
        }

        public Criteria andOperateactionIn(List<String> values) {
            addCriterion("operateAction in", values, "operateaction");
            return (Criteria) this;
        }

        public Criteria andOperateactionNotIn(List<String> values) {
            addCriterion("operateAction not in", values, "operateaction");
            return (Criteria) this;
        }

        public Criteria andOperateactionBetween(String value1, String value2) {
            addCriterion("operateAction between", value1, value2, "operateaction");
            return (Criteria) this;
        }

        public Criteria andOperateactionNotBetween(String value1, String value2) {
            addCriterion("operateAction not between", value1, value2, "operateaction");
            return (Criteria) this;
        }

        public Criteria andOperateurlIsNull() {
            addCriterion("operateURL is null");
            return (Criteria) this;
        }

        public Criteria andOperateurlIsNotNull() {
            addCriterion("operateURL is not null");
            return (Criteria) this;
        }

        public Criteria andOperateurlEqualTo(String value) {
            addCriterion("operateURL =", value, "operateurl");
            return (Criteria) this;
        }

        public Criteria andOperateurlNotEqualTo(String value) {
            addCriterion("operateURL <>", value, "operateurl");
            return (Criteria) this;
        }

        public Criteria andOperateurlGreaterThan(String value) {
            addCriterion("operateURL >", value, "operateurl");
            return (Criteria) this;
        }

        public Criteria andOperateurlGreaterThanOrEqualTo(String value) {
            addCriterion("operateURL >=", value, "operateurl");
            return (Criteria) this;
        }

        public Criteria andOperateurlLessThan(String value) {
            addCriterion("operateURL <", value, "operateurl");
            return (Criteria) this;
        }

        public Criteria andOperateurlLessThanOrEqualTo(String value) {
            addCriterion("operateURL <=", value, "operateurl");
            return (Criteria) this;
        }

        public Criteria andOperateurlLike(String value) {
            addCriterion("operateURL like", value, "operateurl");
            return (Criteria) this;
        }

        public Criteria andOperateurlNotLike(String value) {
            addCriterion("operateURL not like", value, "operateurl");
            return (Criteria) this;
        }

        public Criteria andOperateurlIn(List<String> values) {
            addCriterion("operateURL in", values, "operateurl");
            return (Criteria) this;
        }

        public Criteria andOperateurlNotIn(List<String> values) {
            addCriterion("operateURL not in", values, "operateurl");
            return (Criteria) this;
        }

        public Criteria andOperateurlBetween(String value1, String value2) {
            addCriterion("operateURL between", value1, value2, "operateurl");
            return (Criteria) this;
        }

        public Criteria andOperateurlNotBetween(String value1, String value2) {
            addCriterion("operateURL not between", value1, value2, "operateurl");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(Integer value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(Integer value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Integer value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Integer value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Integer value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<Integer> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<Integer> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(Integer value1, Integer value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(Integer value1, Integer value2) {
            addCriterion("pid not between", value1, value2, "pid");
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