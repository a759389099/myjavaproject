package cn.zzpigt.bean;

import java.util.ArrayList;
import java.util.List;

public class AffairmodelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AffairmodelExample() {
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

        public Criteria andAffairmodelnameIsNull() {
            addCriterion("affairModelName is null");
            return (Criteria) this;
        }

        public Criteria andAffairmodelnameIsNotNull() {
            addCriterion("affairModelName is not null");
            return (Criteria) this;
        }

        public Criteria andAffairmodelnameEqualTo(String value) {
            addCriterion("affairModelName =", value, "affairmodelname");
            return (Criteria) this;
        }

        public Criteria andAffairmodelnameNotEqualTo(String value) {
            addCriterion("affairModelName <>", value, "affairmodelname");
            return (Criteria) this;
        }

        public Criteria andAffairmodelnameGreaterThan(String value) {
            addCriterion("affairModelName >", value, "affairmodelname");
            return (Criteria) this;
        }

        public Criteria andAffairmodelnameGreaterThanOrEqualTo(String value) {
            addCriterion("affairModelName >=", value, "affairmodelname");
            return (Criteria) this;
        }

        public Criteria andAffairmodelnameLessThan(String value) {
            addCriterion("affairModelName <", value, "affairmodelname");
            return (Criteria) this;
        }

        public Criteria andAffairmodelnameLessThanOrEqualTo(String value) {
            addCriterion("affairModelName <=", value, "affairmodelname");
            return (Criteria) this;
        }

        public Criteria andAffairmodelnameLike(String value) {
            addCriterion("affairModelName like", value, "affairmodelname");
            return (Criteria) this;
        }

        public Criteria andAffairmodelnameNotLike(String value) {
            addCriterion("affairModelName not like", value, "affairmodelname");
            return (Criteria) this;
        }

        public Criteria andAffairmodelnameIn(List<String> values) {
            addCriterion("affairModelName in", values, "affairmodelname");
            return (Criteria) this;
        }

        public Criteria andAffairmodelnameNotIn(List<String> values) {
            addCriterion("affairModelName not in", values, "affairmodelname");
            return (Criteria) this;
        }

        public Criteria andAffairmodelnameBetween(String value1, String value2) {
            addCriterion("affairModelName between", value1, value2, "affairmodelname");
            return (Criteria) this;
        }

        public Criteria andAffairmodelnameNotBetween(String value1, String value2) {
            addCriterion("affairModelName not between", value1, value2, "affairmodelname");
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

        public Criteria andAffairchainIsNull() {
            addCriterion("affairChain is null");
            return (Criteria) this;
        }

        public Criteria andAffairchainIsNotNull() {
            addCriterion("affairChain is not null");
            return (Criteria) this;
        }

        public Criteria andAffairchainEqualTo(String value) {
            addCriterion("affairChain =", value, "affairchain");
            return (Criteria) this;
        }

        public Criteria andAffairchainNotEqualTo(String value) {
            addCriterion("affairChain <>", value, "affairchain");
            return (Criteria) this;
        }

        public Criteria andAffairchainGreaterThan(String value) {
            addCriterion("affairChain >", value, "affairchain");
            return (Criteria) this;
        }

        public Criteria andAffairchainGreaterThanOrEqualTo(String value) {
            addCriterion("affairChain >=", value, "affairchain");
            return (Criteria) this;
        }

        public Criteria andAffairchainLessThan(String value) {
            addCriterion("affairChain <", value, "affairchain");
            return (Criteria) this;
        }

        public Criteria andAffairchainLessThanOrEqualTo(String value) {
            addCriterion("affairChain <=", value, "affairchain");
            return (Criteria) this;
        }

        public Criteria andAffairchainLike(String value) {
            addCriterion("affairChain like", value, "affairchain");
            return (Criteria) this;
        }

        public Criteria andAffairchainNotLike(String value) {
            addCriterion("affairChain not like", value, "affairchain");
            return (Criteria) this;
        }

        public Criteria andAffairchainIn(List<String> values) {
            addCriterion("affairChain in", values, "affairchain");
            return (Criteria) this;
        }

        public Criteria andAffairchainNotIn(List<String> values) {
            addCriterion("affairChain not in", values, "affairchain");
            return (Criteria) this;
        }

        public Criteria andAffairchainBetween(String value1, String value2) {
            addCriterion("affairChain between", value1, value2, "affairchain");
            return (Criteria) this;
        }

        public Criteria andAffairchainNotBetween(String value1, String value2) {
            addCriterion("affairChain not between", value1, value2, "affairchain");
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