package cn.zzpigt.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AffairchainExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AffairchainExample() {
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

        public Criteria andAffairchainidIsNull() {
            addCriterion("affairChainId is null");
            return (Criteria) this;
        }

        public Criteria andAffairchainidIsNotNull() {
            addCriterion("affairChainId is not null");
            return (Criteria) this;
        }

        public Criteria andAffairchainidEqualTo(Integer value) {
            addCriterion("affairChainId =", value, "affairchainid");
            return (Criteria) this;
        }

        public Criteria andAffairchainidNotEqualTo(Integer value) {
            addCriterion("affairChainId <>", value, "affairchainid");
            return (Criteria) this;
        }

        public Criteria andAffairchainidGreaterThan(Integer value) {
            addCriterion("affairChainId >", value, "affairchainid");
            return (Criteria) this;
        }

        public Criteria andAffairchainidGreaterThanOrEqualTo(Integer value) {
            addCriterion("affairChainId >=", value, "affairchainid");
            return (Criteria) this;
        }

        public Criteria andAffairchainidLessThan(Integer value) {
            addCriterion("affairChainId <", value, "affairchainid");
            return (Criteria) this;
        }

        public Criteria andAffairchainidLessThanOrEqualTo(Integer value) {
            addCriterion("affairChainId <=", value, "affairchainid");
            return (Criteria) this;
        }

        public Criteria andAffairchainidIn(List<Integer> values) {
            addCriterion("affairChainId in", values, "affairchainid");
            return (Criteria) this;
        }

        public Criteria andAffairchainidNotIn(List<Integer> values) {
            addCriterion("affairChainId not in", values, "affairchainid");
            return (Criteria) this;
        }

        public Criteria andAffairchainidBetween(Integer value1, Integer value2) {
            addCriterion("affairChainId between", value1, value2, "affairchainid");
            return (Criteria) this;
        }

        public Criteria andAffairchainidNotBetween(Integer value1, Integer value2) {
            addCriterion("affairChainId not between", value1, value2, "affairchainid");
            return (Criteria) this;
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

        public Criteria andAffairchainorderIsNull() {
            addCriterion("affairChainOrder is null");
            return (Criteria) this;
        }

        public Criteria andAffairchainorderIsNotNull() {
            addCriterion("affairChainOrder is not null");
            return (Criteria) this;
        }

        public Criteria andAffairchainorderEqualTo(Byte value) {
            addCriterion("affairChainOrder =", value, "affairchainorder");
            return (Criteria) this;
        }

        public Criteria andAffairchainorderNotEqualTo(Byte value) {
            addCriterion("affairChainOrder <>", value, "affairchainorder");
            return (Criteria) this;
        }

        public Criteria andAffairchainorderGreaterThan(Byte value) {
            addCriterion("affairChainOrder >", value, "affairchainorder");
            return (Criteria) this;
        }

        public Criteria andAffairchainorderGreaterThanOrEqualTo(Byte value) {
            addCriterion("affairChainOrder >=", value, "affairchainorder");
            return (Criteria) this;
        }

        public Criteria andAffairchainorderLessThan(Byte value) {
            addCriterion("affairChainOrder <", value, "affairchainorder");
            return (Criteria) this;
        }

        public Criteria andAffairchainorderLessThanOrEqualTo(Byte value) {
            addCriterion("affairChainOrder <=", value, "affairchainorder");
            return (Criteria) this;
        }

        public Criteria andAffairchainorderIn(List<Byte> values) {
            addCriterion("affairChainOrder in", values, "affairchainorder");
            return (Criteria) this;
        }

        public Criteria andAffairchainorderNotIn(List<Byte> values) {
            addCriterion("affairChainOrder not in", values, "affairchainorder");
            return (Criteria) this;
        }

        public Criteria andAffairchainorderBetween(Byte value1, Byte value2) {
            addCriterion("affairChainOrder between", value1, value2, "affairchainorder");
            return (Criteria) this;
        }

        public Criteria andAffairchainorderNotBetween(Byte value1, Byte value2) {
            addCriterion("affairChainOrder not between", value1, value2, "affairchainorder");
            return (Criteria) this;
        }

        public Criteria andAffairchaintimeIsNull() {
            addCriterion("affairChainTime is null");
            return (Criteria) this;
        }

        public Criteria andAffairchaintimeIsNotNull() {
            addCriterion("affairChainTime is not null");
            return (Criteria) this;
        }

        public Criteria andAffairchaintimeEqualTo(Date value) {
            addCriterion("affairChainTime =", value, "affairchaintime");
            return (Criteria) this;
        }

        public Criteria andAffairchaintimeNotEqualTo(Date value) {
            addCriterion("affairChainTime <>", value, "affairchaintime");
            return (Criteria) this;
        }

        public Criteria andAffairchaintimeGreaterThan(Date value) {
            addCriterion("affairChainTime >", value, "affairchaintime");
            return (Criteria) this;
        }

        public Criteria andAffairchaintimeGreaterThanOrEqualTo(Date value) {
            addCriterion("affairChainTime >=", value, "affairchaintime");
            return (Criteria) this;
        }

        public Criteria andAffairchaintimeLessThan(Date value) {
            addCriterion("affairChainTime <", value, "affairchaintime");
            return (Criteria) this;
        }

        public Criteria andAffairchaintimeLessThanOrEqualTo(Date value) {
            addCriterion("affairChainTime <=", value, "affairchaintime");
            return (Criteria) this;
        }

        public Criteria andAffairchaintimeIn(List<Date> values) {
            addCriterion("affairChainTime in", values, "affairchaintime");
            return (Criteria) this;
        }

        public Criteria andAffairchaintimeNotIn(List<Date> values) {
            addCriterion("affairChainTime not in", values, "affairchaintime");
            return (Criteria) this;
        }

        public Criteria andAffairchaintimeBetween(Date value1, Date value2) {
            addCriterion("affairChainTime between", value1, value2, "affairchaintime");
            return (Criteria) this;
        }

        public Criteria andAffairchaintimeNotBetween(Date value1, Date value2) {
            addCriterion("affairChainTime not between", value1, value2, "affairchaintime");
            return (Criteria) this;
        }

        public Criteria andAffairchainremarkIsNull() {
            addCriterion("affairChainRemark is null");
            return (Criteria) this;
        }

        public Criteria andAffairchainremarkIsNotNull() {
            addCriterion("affairChainRemark is not null");
            return (Criteria) this;
        }

        public Criteria andAffairchainremarkEqualTo(String value) {
            addCriterion("affairChainRemark =", value, "affairchainremark");
            return (Criteria) this;
        }

        public Criteria andAffairchainremarkNotEqualTo(String value) {
            addCriterion("affairChainRemark <>", value, "affairchainremark");
            return (Criteria) this;
        }

        public Criteria andAffairchainremarkGreaterThan(String value) {
            addCriterion("affairChainRemark >", value, "affairchainremark");
            return (Criteria) this;
        }

        public Criteria andAffairchainremarkGreaterThanOrEqualTo(String value) {
            addCriterion("affairChainRemark >=", value, "affairchainremark");
            return (Criteria) this;
        }

        public Criteria andAffairchainremarkLessThan(String value) {
            addCriterion("affairChainRemark <", value, "affairchainremark");
            return (Criteria) this;
        }

        public Criteria andAffairchainremarkLessThanOrEqualTo(String value) {
            addCriterion("affairChainRemark <=", value, "affairchainremark");
            return (Criteria) this;
        }

        public Criteria andAffairchainremarkLike(String value) {
            addCriterion("affairChainRemark like", value, "affairchainremark");
            return (Criteria) this;
        }

        public Criteria andAffairchainremarkNotLike(String value) {
            addCriterion("affairChainRemark not like", value, "affairchainremark");
            return (Criteria) this;
        }

        public Criteria andAffairchainremarkIn(List<String> values) {
            addCriterion("affairChainRemark in", values, "affairchainremark");
            return (Criteria) this;
        }

        public Criteria andAffairchainremarkNotIn(List<String> values) {
            addCriterion("affairChainRemark not in", values, "affairchainremark");
            return (Criteria) this;
        }

        public Criteria andAffairchainremarkBetween(String value1, String value2) {
            addCriterion("affairChainRemark between", value1, value2, "affairchainremark");
            return (Criteria) this;
        }

        public Criteria andAffairchainremarkNotBetween(String value1, String value2) {
            addCriterion("affairChainRemark not between", value1, value2, "affairchainremark");
            return (Criteria) this;
        }

        public Criteria andAffairchainstateIsNull() {
            addCriterion("affairChainState is null");
            return (Criteria) this;
        }

        public Criteria andAffairchainstateIsNotNull() {
            addCriterion("affairChainState is not null");
            return (Criteria) this;
        }

        public Criteria andAffairchainstateEqualTo(Byte value) {
            addCriterion("affairChainState =", value, "affairchainstate");
            return (Criteria) this;
        }

        public Criteria andAffairchainstateNotEqualTo(Byte value) {
            addCriterion("affairChainState <>", value, "affairchainstate");
            return (Criteria) this;
        }

        public Criteria andAffairchainstateGreaterThan(Byte value) {
            addCriterion("affairChainState >", value, "affairchainstate");
            return (Criteria) this;
        }

        public Criteria andAffairchainstateGreaterThanOrEqualTo(Byte value) {
            addCriterion("affairChainState >=", value, "affairchainstate");
            return (Criteria) this;
        }

        public Criteria andAffairchainstateLessThan(Byte value) {
            addCriterion("affairChainState <", value, "affairchainstate");
            return (Criteria) this;
        }

        public Criteria andAffairchainstateLessThanOrEqualTo(Byte value) {
            addCriterion("affairChainState <=", value, "affairchainstate");
            return (Criteria) this;
        }

        public Criteria andAffairchainstateIn(List<Byte> values) {
            addCriterion("affairChainState in", values, "affairchainstate");
            return (Criteria) this;
        }

        public Criteria andAffairchainstateNotIn(List<Byte> values) {
            addCriterion("affairChainState not in", values, "affairchainstate");
            return (Criteria) this;
        }

        public Criteria andAffairchainstateBetween(Byte value1, Byte value2) {
            addCriterion("affairChainState between", value1, value2, "affairchainstate");
            return (Criteria) this;
        }

        public Criteria andAffairchainstateNotBetween(Byte value1, Byte value2) {
            addCriterion("affairChainState not between", value1, value2, "affairchainstate");
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