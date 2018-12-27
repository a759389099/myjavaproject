package cn.zzpigt.bean;

import java.util.ArrayList;
import java.util.List;

public class AffairmodelitemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AffairmodelitemExample() {
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

        public Criteria andModelitemidIsNull() {
            addCriterion("modelItemId is null");
            return (Criteria) this;
        }

        public Criteria andModelitemidIsNotNull() {
            addCriterion("modelItemId is not null");
            return (Criteria) this;
        }

        public Criteria andModelitemidEqualTo(Integer value) {
            addCriterion("modelItemId =", value, "modelitemid");
            return (Criteria) this;
        }

        public Criteria andModelitemidNotEqualTo(Integer value) {
            addCriterion("modelItemId <>", value, "modelitemid");
            return (Criteria) this;
        }

        public Criteria andModelitemidGreaterThan(Integer value) {
            addCriterion("modelItemId >", value, "modelitemid");
            return (Criteria) this;
        }

        public Criteria andModelitemidGreaterThanOrEqualTo(Integer value) {
            addCriterion("modelItemId >=", value, "modelitemid");
            return (Criteria) this;
        }

        public Criteria andModelitemidLessThan(Integer value) {
            addCriterion("modelItemId <", value, "modelitemid");
            return (Criteria) this;
        }

        public Criteria andModelitemidLessThanOrEqualTo(Integer value) {
            addCriterion("modelItemId <=", value, "modelitemid");
            return (Criteria) this;
        }

        public Criteria andModelitemidIn(List<Integer> values) {
            addCriterion("modelItemId in", values, "modelitemid");
            return (Criteria) this;
        }

        public Criteria andModelitemidNotIn(List<Integer> values) {
            addCriterion("modelItemId not in", values, "modelitemid");
            return (Criteria) this;
        }

        public Criteria andModelitemidBetween(Integer value1, Integer value2) {
            addCriterion("modelItemId between", value1, value2, "modelitemid");
            return (Criteria) this;
        }

        public Criteria andModelitemidNotBetween(Integer value1, Integer value2) {
            addCriterion("modelItemId not between", value1, value2, "modelitemid");
            return (Criteria) this;
        }

        public Criteria andModelitemnameIsNull() {
            addCriterion("modelItemName is null");
            return (Criteria) this;
        }

        public Criteria andModelitemnameIsNotNull() {
            addCriterion("modelItemName is not null");
            return (Criteria) this;
        }

        public Criteria andModelitemnameEqualTo(String value) {
            addCriterion("modelItemName =", value, "modelitemname");
            return (Criteria) this;
        }

        public Criteria andModelitemnameNotEqualTo(String value) {
            addCriterion("modelItemName <>", value, "modelitemname");
            return (Criteria) this;
        }

        public Criteria andModelitemnameGreaterThan(String value) {
            addCriterion("modelItemName >", value, "modelitemname");
            return (Criteria) this;
        }

        public Criteria andModelitemnameGreaterThanOrEqualTo(String value) {
            addCriterion("modelItemName >=", value, "modelitemname");
            return (Criteria) this;
        }

        public Criteria andModelitemnameLessThan(String value) {
            addCriterion("modelItemName <", value, "modelitemname");
            return (Criteria) this;
        }

        public Criteria andModelitemnameLessThanOrEqualTo(String value) {
            addCriterion("modelItemName <=", value, "modelitemname");
            return (Criteria) this;
        }

        public Criteria andModelitemnameLike(String value) {
            addCriterion("modelItemName like", value, "modelitemname");
            return (Criteria) this;
        }

        public Criteria andModelitemnameNotLike(String value) {
            addCriterion("modelItemName not like", value, "modelitemname");
            return (Criteria) this;
        }

        public Criteria andModelitemnameIn(List<String> values) {
            addCriterion("modelItemName in", values, "modelitemname");
            return (Criteria) this;
        }

        public Criteria andModelitemnameNotIn(List<String> values) {
            addCriterion("modelItemName not in", values, "modelitemname");
            return (Criteria) this;
        }

        public Criteria andModelitemnameBetween(String value1, String value2) {
            addCriterion("modelItemName between", value1, value2, "modelitemname");
            return (Criteria) this;
        }

        public Criteria andModelitemnameNotBetween(String value1, String value2) {
            addCriterion("modelItemName not between", value1, value2, "modelitemname");
            return (Criteria) this;
        }

        public Criteria andModelitemtypeIsNull() {
            addCriterion("modelItemType is null");
            return (Criteria) this;
        }

        public Criteria andModelitemtypeIsNotNull() {
            addCriterion("modelItemType is not null");
            return (Criteria) this;
        }

        public Criteria andModelitemtypeEqualTo(Integer value) {
            addCriterion("modelItemType =", value, "modelitemtype");
            return (Criteria) this;
        }

        public Criteria andModelitemtypeNotEqualTo(Integer value) {
            addCriterion("modelItemType <>", value, "modelitemtype");
            return (Criteria) this;
        }

        public Criteria andModelitemtypeGreaterThan(Integer value) {
            addCriterion("modelItemType >", value, "modelitemtype");
            return (Criteria) this;
        }

        public Criteria andModelitemtypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("modelItemType >=", value, "modelitemtype");
            return (Criteria) this;
        }

        public Criteria andModelitemtypeLessThan(Integer value) {
            addCriterion("modelItemType <", value, "modelitemtype");
            return (Criteria) this;
        }

        public Criteria andModelitemtypeLessThanOrEqualTo(Integer value) {
            addCriterion("modelItemType <=", value, "modelitemtype");
            return (Criteria) this;
        }

        public Criteria andModelitemtypeIn(List<Integer> values) {
            addCriterion("modelItemType in", values, "modelitemtype");
            return (Criteria) this;
        }

        public Criteria andModelitemtypeNotIn(List<Integer> values) {
            addCriterion("modelItemType not in", values, "modelitemtype");
            return (Criteria) this;
        }

        public Criteria andModelitemtypeBetween(Integer value1, Integer value2) {
            addCriterion("modelItemType between", value1, value2, "modelitemtype");
            return (Criteria) this;
        }

        public Criteria andModelitemtypeNotBetween(Integer value1, Integer value2) {
            addCriterion("modelItemType not between", value1, value2, "modelitemtype");
            return (Criteria) this;
        }

        public Criteria andModelitemoptionIsNull() {
            addCriterion("modelItemOption is null");
            return (Criteria) this;
        }

        public Criteria andModelitemoptionIsNotNull() {
            addCriterion("modelItemOption is not null");
            return (Criteria) this;
        }

        public Criteria andModelitemoptionEqualTo(String value) {
            addCriterion("modelItemOption =", value, "modelitemoption");
            return (Criteria) this;
        }

        public Criteria andModelitemoptionNotEqualTo(String value) {
            addCriterion("modelItemOption <>", value, "modelitemoption");
            return (Criteria) this;
        }

        public Criteria andModelitemoptionGreaterThan(String value) {
            addCriterion("modelItemOption >", value, "modelitemoption");
            return (Criteria) this;
        }

        public Criteria andModelitemoptionGreaterThanOrEqualTo(String value) {
            addCriterion("modelItemOption >=", value, "modelitemoption");
            return (Criteria) this;
        }

        public Criteria andModelitemoptionLessThan(String value) {
            addCriterion("modelItemOption <", value, "modelitemoption");
            return (Criteria) this;
        }

        public Criteria andModelitemoptionLessThanOrEqualTo(String value) {
            addCriterion("modelItemOption <=", value, "modelitemoption");
            return (Criteria) this;
        }

        public Criteria andModelitemoptionLike(String value) {
            addCriterion("modelItemOption like", value, "modelitemoption");
            return (Criteria) this;
        }

        public Criteria andModelitemoptionNotLike(String value) {
            addCriterion("modelItemOption not like", value, "modelitemoption");
            return (Criteria) this;
        }

        public Criteria andModelitemoptionIn(List<String> values) {
            addCriterion("modelItemOption in", values, "modelitemoption");
            return (Criteria) this;
        }

        public Criteria andModelitemoptionNotIn(List<String> values) {
            addCriterion("modelItemOption not in", values, "modelitemoption");
            return (Criteria) this;
        }

        public Criteria andModelitemoptionBetween(String value1, String value2) {
            addCriterion("modelItemOption between", value1, value2, "modelitemoption");
            return (Criteria) this;
        }

        public Criteria andModelitemoptionNotBetween(String value1, String value2) {
            addCriterion("modelItemOption not between", value1, value2, "modelitemoption");
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