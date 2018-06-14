package com.ccttic.entity.illegal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DrIllicitExample {
    /**
     * dr_illicit
     */
    protected String orderByClause;

    /**
     * dr_illicit
     */
    protected boolean distinct;

    /**
     * dr_illicit
     */
    protected List<Criteria> oredCriteria;

    public DrIllicitExample() {
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

    /**
     * dr_illicit null
     */
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andIdcardIsNull() {
            addCriterion("idcard is null");
            return (Criteria) this;
        }

        public Criteria andIdcardIsNotNull() {
            addCriterion("idcard is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardEqualTo(String value) {
            addCriterion("idcard =", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotEqualTo(String value) {
            addCriterion("idcard <>", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardGreaterThan(String value) {
            addCriterion("idcard >", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("idcard >=", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLessThan(String value) {
            addCriterion("idcard <", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLessThanOrEqualTo(String value) {
            addCriterion("idcard <=", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLike(String value) {
            addCriterion("idcard like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotLike(String value) {
            addCriterion("idcard not like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardIn(List<String> values) {
            addCriterion("idcard in", values, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotIn(List<String> values) {
            addCriterion("idcard not in", values, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardBetween(String value1, String value2) {
            addCriterion("idcard between", value1, value2, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotBetween(String value1, String value2) {
            addCriterion("idcard not between", value1, value2, "idcard");
            return (Criteria) this;
        }

        public Criteria andPermitcarIsNull() {
            addCriterion("permitCar is null");
            return (Criteria) this;
        }

        public Criteria andPermitcarIsNotNull() {
            addCriterion("permitCar is not null");
            return (Criteria) this;
        }

        public Criteria andPermitcarEqualTo(String value) {
            addCriterion("permitCar =", value, "permitcar");
            return (Criteria) this;
        }

        public Criteria andPermitcarNotEqualTo(String value) {
            addCriterion("permitCar <>", value, "permitcar");
            return (Criteria) this;
        }

        public Criteria andPermitcarGreaterThan(String value) {
            addCriterion("permitCar >", value, "permitcar");
            return (Criteria) this;
        }

        public Criteria andPermitcarGreaterThanOrEqualTo(String value) {
            addCriterion("permitCar >=", value, "permitcar");
            return (Criteria) this;
        }

        public Criteria andPermitcarLessThan(String value) {
            addCriterion("permitCar <", value, "permitcar");
            return (Criteria) this;
        }

        public Criteria andPermitcarLessThanOrEqualTo(String value) {
            addCriterion("permitCar <=", value, "permitcar");
            return (Criteria) this;
        }

        public Criteria andPermitcarLike(String value) {
            addCriterion("permitCar like", value, "permitcar");
            return (Criteria) this;
        }

        public Criteria andPermitcarNotLike(String value) {
            addCriterion("permitCar not like", value, "permitcar");
            return (Criteria) this;
        }

        public Criteria andPermitcarIn(List<String> values) {
            addCriterion("permitCar in", values, "permitcar");
            return (Criteria) this;
        }

        public Criteria andPermitcarNotIn(List<String> values) {
            addCriterion("permitCar not in", values, "permitcar");
            return (Criteria) this;
        }

        public Criteria andPermitcarBetween(String value1, String value2) {
            addCriterion("permitCar between", value1, value2, "permitcar");
            return (Criteria) this;
        }

        public Criteria andPermitcarNotBetween(String value1, String value2) {
            addCriterion("permitCar not between", value1, value2, "permitcar");
            return (Criteria) this;
        }

        public Criteria andMgrdepartIsNull() {
            addCriterion("mgrDepart is null");
            return (Criteria) this;
        }

        public Criteria andMgrdepartIsNotNull() {
            addCriterion("mgrDepart is not null");
            return (Criteria) this;
        }

        public Criteria andMgrdepartEqualTo(String value) {
            addCriterion("mgrDepart =", value, "mgrdepart");
            return (Criteria) this;
        }

        public Criteria andMgrdepartNotEqualTo(String value) {
            addCriterion("mgrDepart <>", value, "mgrdepart");
            return (Criteria) this;
        }

        public Criteria andMgrdepartGreaterThan(String value) {
            addCriterion("mgrDepart >", value, "mgrdepart");
            return (Criteria) this;
        }

        public Criteria andMgrdepartGreaterThanOrEqualTo(String value) {
            addCriterion("mgrDepart >=", value, "mgrdepart");
            return (Criteria) this;
        }

        public Criteria andMgrdepartLessThan(String value) {
            addCriterion("mgrDepart <", value, "mgrdepart");
            return (Criteria) this;
        }

        public Criteria andMgrdepartLessThanOrEqualTo(String value) {
            addCriterion("mgrDepart <=", value, "mgrdepart");
            return (Criteria) this;
        }

        public Criteria andMgrdepartLike(String value) {
            addCriterion("mgrDepart like", value, "mgrdepart");
            return (Criteria) this;
        }

        public Criteria andMgrdepartNotLike(String value) {
            addCriterion("mgrDepart not like", value, "mgrdepart");
            return (Criteria) this;
        }

        public Criteria andMgrdepartIn(List<String> values) {
            addCriterion("mgrDepart in", values, "mgrdepart");
            return (Criteria) this;
        }

        public Criteria andMgrdepartNotIn(List<String> values) {
            addCriterion("mgrDepart not in", values, "mgrdepart");
            return (Criteria) this;
        }

        public Criteria andMgrdepartBetween(String value1, String value2) {
            addCriterion("mgrDepart between", value1, value2, "mgrdepart");
            return (Criteria) this;
        }

        public Criteria andMgrdepartNotBetween(String value1, String value2) {
            addCriterion("mgrDepart not between", value1, value2, "mgrdepart");
            return (Criteria) this;
        }

        public Criteria andMgrdepartareaidIsNull() {
            addCriterion("mgrDepartAreaId is null");
            return (Criteria) this;
        }

        public Criteria andMgrdepartareaidIsNotNull() {
            addCriterion("mgrDepartAreaId is not null");
            return (Criteria) this;
        }

        public Criteria andMgrdepartareaidEqualTo(String value) {
            addCriterion("mgrDepartAreaId =", value, "mgrdepartareaid");
            return (Criteria) this;
        }

        public Criteria andMgrdepartareaidNotEqualTo(String value) {
            addCriterion("mgrDepartAreaId <>", value, "mgrdepartareaid");
            return (Criteria) this;
        }

        public Criteria andMgrdepartareaidGreaterThan(String value) {
            addCriterion("mgrDepartAreaId >", value, "mgrdepartareaid");
            return (Criteria) this;
        }

        public Criteria andMgrdepartareaidGreaterThanOrEqualTo(String value) {
            addCriterion("mgrDepartAreaId >=", value, "mgrdepartareaid");
            return (Criteria) this;
        }

        public Criteria andMgrdepartareaidLessThan(String value) {
            addCriterion("mgrDepartAreaId <", value, "mgrdepartareaid");
            return (Criteria) this;
        }

        public Criteria andMgrdepartareaidLessThanOrEqualTo(String value) {
            addCriterion("mgrDepartAreaId <=", value, "mgrdepartareaid");
            return (Criteria) this;
        }

        public Criteria andMgrdepartareaidLike(String value) {
            addCriterion("mgrDepartAreaId like", value, "mgrdepartareaid");
            return (Criteria) this;
        }

        public Criteria andMgrdepartareaidNotLike(String value) {
            addCriterion("mgrDepartAreaId not like", value, "mgrdepartareaid");
            return (Criteria) this;
        }

        public Criteria andMgrdepartareaidIn(List<String> values) {
            addCriterion("mgrDepartAreaId in", values, "mgrdepartareaid");
            return (Criteria) this;
        }

        public Criteria andMgrdepartareaidNotIn(List<String> values) {
            addCriterion("mgrDepartAreaId not in", values, "mgrdepartareaid");
            return (Criteria) this;
        }

        public Criteria andMgrdepartareaidBetween(String value1, String value2) {
            addCriterion("mgrDepartAreaId between", value1, value2, "mgrdepartareaid");
            return (Criteria) this;
        }

        public Criteria andMgrdepartareaidNotBetween(String value1, String value2) {
            addCriterion("mgrDepartAreaId not between", value1, value2, "mgrdepartareaid");
            return (Criteria) this;
        }

        public Criteria andDriverIdIsNull() {
            addCriterion("driver_id is null");
            return (Criteria) this;
        }

        public Criteria andDriverIdIsNotNull() {
            addCriterion("driver_id is not null");
            return (Criteria) this;
        }

        public Criteria andDriverIdEqualTo(String value) {
            addCriterion("driver_id =", value, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdNotEqualTo(String value) {
            addCriterion("driver_id <>", value, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdGreaterThan(String value) {
            addCriterion("driver_id >", value, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdGreaterThanOrEqualTo(String value) {
            addCriterion("driver_id >=", value, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdLessThan(String value) {
            addCriterion("driver_id <", value, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdLessThanOrEqualTo(String value) {
            addCriterion("driver_id <=", value, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdLike(String value) {
            addCriterion("driver_id like", value, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdNotLike(String value) {
            addCriterion("driver_id not like", value, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdIn(List<String> values) {
            addCriterion("driver_id in", values, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdNotIn(List<String> values) {
            addCriterion("driver_id not in", values, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdBetween(String value1, String value2) {
            addCriterion("driver_id between", value1, value2, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdNotBetween(String value1, String value2) {
            addCriterion("driver_id not between", value1, value2, "driverId");
            return (Criteria) this;
        }

        public Criteria andScoretotalIsNull() {
            addCriterion("scoreTotal is null");
            return (Criteria) this;
        }

        public Criteria andScoretotalIsNotNull() {
            addCriterion("scoreTotal is not null");
            return (Criteria) this;
        }

        public Criteria andScoretotalEqualTo(String value) {
            addCriterion("scoreTotal =", value, "scoretotal");
            return (Criteria) this;
        }

        public Criteria andScoretotalNotEqualTo(String value) {
            addCriterion("scoreTotal <>", value, "scoretotal");
            return (Criteria) this;
        }

        public Criteria andScoretotalGreaterThan(String value) {
            addCriterion("scoreTotal >", value, "scoretotal");
            return (Criteria) this;
        }

        public Criteria andScoretotalGreaterThanOrEqualTo(String value) {
            addCriterion("scoreTotal >=", value, "scoretotal");
            return (Criteria) this;
        }

        public Criteria andScoretotalLessThan(String value) {
            addCriterion("scoreTotal <", value, "scoretotal");
            return (Criteria) this;
        }

        public Criteria andScoretotalLessThanOrEqualTo(String value) {
            addCriterion("scoreTotal <=", value, "scoretotal");
            return (Criteria) this;
        }

        public Criteria andScoretotalLike(String value) {
            addCriterion("scoreTotal like", value, "scoretotal");
            return (Criteria) this;
        }

        public Criteria andScoretotalNotLike(String value) {
            addCriterion("scoreTotal not like", value, "scoretotal");
            return (Criteria) this;
        }

        public Criteria andScoretotalIn(List<String> values) {
            addCriterion("scoreTotal in", values, "scoretotal");
            return (Criteria) this;
        }

        public Criteria andScoretotalNotIn(List<String> values) {
            addCriterion("scoreTotal not in", values, "scoretotal");
            return (Criteria) this;
        }

        public Criteria andScoretotalBetween(String value1, String value2) {
            addCriterion("scoreTotal between", value1, value2, "scoretotal");
            return (Criteria) this;
        }

        public Criteria andScoretotalNotBetween(String value1, String value2) {
            addCriterion("scoreTotal not between", value1, value2, "scoretotal");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andVehinoIsNull() {
            addCriterion("vehiNo is null");
            return (Criteria) this;
        }

        public Criteria andVehinoIsNotNull() {
            addCriterion("vehiNo is not null");
            return (Criteria) this;
        }

        public Criteria andVehinoEqualTo(String value) {
            addCriterion("vehiNo =", value, "vehino");
            return (Criteria) this;
        }

        public Criteria andVehinoNotEqualTo(String value) {
            addCriterion("vehiNo <>", value, "vehino");
            return (Criteria) this;
        }

        public Criteria andVehinoGreaterThan(String value) {
            addCriterion("vehiNo >", value, "vehino");
            return (Criteria) this;
        }

        public Criteria andVehinoGreaterThanOrEqualTo(String value) {
            addCriterion("vehiNo >=", value, "vehino");
            return (Criteria) this;
        }

        public Criteria andVehinoLessThan(String value) {
            addCriterion("vehiNo <", value, "vehino");
            return (Criteria) this;
        }

        public Criteria andVehinoLessThanOrEqualTo(String value) {
            addCriterion("vehiNo <=", value, "vehino");
            return (Criteria) this;
        }

        public Criteria andVehinoLike(String value) {
            addCriterion("vehiNo like", value, "vehino");
            return (Criteria) this;
        }

        public Criteria andVehinoNotLike(String value) {
            addCriterion("vehiNo not like", value, "vehino");
            return (Criteria) this;
        }

        public Criteria andVehinoIn(List<String> values) {
            addCriterion("vehiNo in", values, "vehino");
            return (Criteria) this;
        }

        public Criteria andVehinoNotIn(List<String> values) {
            addCriterion("vehiNo not in", values, "vehino");
            return (Criteria) this;
        }

        public Criteria andVehinoBetween(String value1, String value2) {
            addCriterion("vehiNo between", value1, value2, "vehino");
            return (Criteria) this;
        }

        public Criteria andVehinoNotBetween(String value1, String value2) {
            addCriterion("vehiNo not between", value1, value2, "vehino");
            return (Criteria) this;
        }

        public Criteria andVehinotypeIsNull() {
            addCriterion("vehiNoType is null");
            return (Criteria) this;
        }

        public Criteria andVehinotypeIsNotNull() {
            addCriterion("vehiNoType is not null");
            return (Criteria) this;
        }

        public Criteria andVehinotypeEqualTo(String value) {
            addCriterion("vehiNoType =", value, "vehinotype");
            return (Criteria) this;
        }

        public Criteria andVehinotypeNotEqualTo(String value) {
            addCriterion("vehiNoType <>", value, "vehinotype");
            return (Criteria) this;
        }

        public Criteria andVehinotypeGreaterThan(String value) {
            addCriterion("vehiNoType >", value, "vehinotype");
            return (Criteria) this;
        }

        public Criteria andVehinotypeGreaterThanOrEqualTo(String value) {
            addCriterion("vehiNoType >=", value, "vehinotype");
            return (Criteria) this;
        }

        public Criteria andVehinotypeLessThan(String value) {
            addCriterion("vehiNoType <", value, "vehinotype");
            return (Criteria) this;
        }

        public Criteria andVehinotypeLessThanOrEqualTo(String value) {
            addCriterion("vehiNoType <=", value, "vehinotype");
            return (Criteria) this;
        }

        public Criteria andVehinotypeLike(String value) {
            addCriterion("vehiNoType like", value, "vehinotype");
            return (Criteria) this;
        }

        public Criteria andVehinotypeNotLike(String value) {
            addCriterion("vehiNoType not like", value, "vehinotype");
            return (Criteria) this;
        }

        public Criteria andVehinotypeIn(List<String> values) {
            addCriterion("vehiNoType in", values, "vehinotype");
            return (Criteria) this;
        }

        public Criteria andVehinotypeNotIn(List<String> values) {
            addCriterion("vehiNoType not in", values, "vehinotype");
            return (Criteria) this;
        }

        public Criteria andVehinotypeBetween(String value1, String value2) {
            addCriterion("vehiNoType between", value1, value2, "vehinotype");
            return (Criteria) this;
        }

        public Criteria andVehinotypeNotBetween(String value1, String value2) {
            addCriterion("vehiNoType not between", value1, value2, "vehinotype");
            return (Criteria) this;
        }

        public Criteria andIllicittimeIsNull() {
            addCriterion("illicitTime is null");
            return (Criteria) this;
        }

        public Criteria andIllicittimeIsNotNull() {
            addCriterion("illicitTime is not null");
            return (Criteria) this;
        }

        public Criteria andIllicittimeEqualTo(String value) {
            addCriterion("illicitTime =", value, "illicittime");
            return (Criteria) this;
        }

        public Criteria andIllicittimeNotEqualTo(String value) {
            addCriterion("illicitTime <>", value, "illicittime");
            return (Criteria) this;
        }

        public Criteria andIllicittimeGreaterThan(String value) {
            addCriterion("illicitTime >", value, "illicittime");
            return (Criteria) this;
        }

        public Criteria andIllicittimeGreaterThanOrEqualTo(String value) {
            addCriterion("illicitTime >=", value, "illicittime");
            return (Criteria) this;
        }

        public Criteria andIllicittimeLessThan(String value) {
            addCriterion("illicitTime <", value, "illicittime");
            return (Criteria) this;
        }

        public Criteria andIllicittimeLessThanOrEqualTo(String value) {
            addCriterion("illicitTime <=", value, "illicittime");
            return (Criteria) this;
        }

        public Criteria andIllicittimeLike(String value) {
            addCriterion("illicitTime like", value, "illicittime");
            return (Criteria) this;
        }

        public Criteria andIllicittimeNotLike(String value) {
            addCriterion("illicitTime not like", value, "illicittime");
            return (Criteria) this;
        }

        public Criteria andIllicittimeIn(List<String> values) {
            addCriterion("illicitTime in", values, "illicittime");
            return (Criteria) this;
        }

        public Criteria andIllicittimeNotIn(List<String> values) {
            addCriterion("illicitTime not in", values, "illicittime");
            return (Criteria) this;
        }

        public Criteria andIllicittimeBetween(String value1, String value2) {
            addCriterion("illicitTime between", value1, value2, "illicittime");
            return (Criteria) this;
        }

        public Criteria andIllicittimeNotBetween(String value1, String value2) {
            addCriterion("illicitTime not between", value1, value2, "illicittime");
            return (Criteria) this;
        }

        public Criteria andIllicitscoreIsNull() {
            addCriterion("illicitScore is null");
            return (Criteria) this;
        }

        public Criteria andIllicitscoreIsNotNull() {
            addCriterion("illicitScore is not null");
            return (Criteria) this;
        }

        public Criteria andIllicitscoreEqualTo(String value) {
            addCriterion("illicitScore =", value, "illicitscore");
            return (Criteria) this;
        }

        public Criteria andIllicitscoreNotEqualTo(String value) {
            addCriterion("illicitScore <>", value, "illicitscore");
            return (Criteria) this;
        }

        public Criteria andIllicitscoreGreaterThan(String value) {
            addCriterion("illicitScore >", value, "illicitscore");
            return (Criteria) this;
        }

        public Criteria andIllicitscoreGreaterThanOrEqualTo(String value) {
            addCriterion("illicitScore >=", value, "illicitscore");
            return (Criteria) this;
        }

        public Criteria andIllicitscoreLessThan(String value) {
            addCriterion("illicitScore <", value, "illicitscore");
            return (Criteria) this;
        }

        public Criteria andIllicitscoreLessThanOrEqualTo(String value) {
            addCriterion("illicitScore <=", value, "illicitscore");
            return (Criteria) this;
        }

        public Criteria andIllicitscoreLike(String value) {
            addCriterion("illicitScore like", value, "illicitscore");
            return (Criteria) this;
        }

        public Criteria andIllicitscoreNotLike(String value) {
            addCriterion("illicitScore not like", value, "illicitscore");
            return (Criteria) this;
        }

        public Criteria andIllicitscoreIn(List<String> values) {
            addCriterion("illicitScore in", values, "illicitscore");
            return (Criteria) this;
        }

        public Criteria andIllicitscoreNotIn(List<String> values) {
            addCriterion("illicitScore not in", values, "illicitscore");
            return (Criteria) this;
        }

        public Criteria andIllicitscoreBetween(String value1, String value2) {
            addCriterion("illicitScore between", value1, value2, "illicitscore");
            return (Criteria) this;
        }

        public Criteria andIllicitscoreNotBetween(String value1, String value2) {
            addCriterion("illicitScore not between", value1, value2, "illicitscore");
            return (Criteria) this;
        }

        public Criteria andIllicitamountIsNull() {
            addCriterion("illicitAmount is null");
            return (Criteria) this;
        }

        public Criteria andIllicitamountIsNotNull() {
            addCriterion("illicitAmount is not null");
            return (Criteria) this;
        }

        public Criteria andIllicitamountEqualTo(String value) {
            addCriterion("illicitAmount =", value, "illicitamount");
            return (Criteria) this;
        }

        public Criteria andIllicitamountNotEqualTo(String value) {
            addCriterion("illicitAmount <>", value, "illicitamount");
            return (Criteria) this;
        }

        public Criteria andIllicitamountGreaterThan(String value) {
            addCriterion("illicitAmount >", value, "illicitamount");
            return (Criteria) this;
        }

        public Criteria andIllicitamountGreaterThanOrEqualTo(String value) {
            addCriterion("illicitAmount >=", value, "illicitamount");
            return (Criteria) this;
        }

        public Criteria andIllicitamountLessThan(String value) {
            addCriterion("illicitAmount <", value, "illicitamount");
            return (Criteria) this;
        }

        public Criteria andIllicitamountLessThanOrEqualTo(String value) {
            addCriterion("illicitAmount <=", value, "illicitamount");
            return (Criteria) this;
        }

        public Criteria andIllicitamountLike(String value) {
            addCriterion("illicitAmount like", value, "illicitamount");
            return (Criteria) this;
        }

        public Criteria andIllicitamountNotLike(String value) {
            addCriterion("illicitAmount not like", value, "illicitamount");
            return (Criteria) this;
        }

        public Criteria andIllicitamountIn(List<String> values) {
            addCriterion("illicitAmount in", values, "illicitamount");
            return (Criteria) this;
        }

        public Criteria andIllicitamountNotIn(List<String> values) {
            addCriterion("illicitAmount not in", values, "illicitamount");
            return (Criteria) this;
        }

        public Criteria andIllicitamountBetween(String value1, String value2) {
            addCriterion("illicitAmount between", value1, value2, "illicitamount");
            return (Criteria) this;
        }

        public Criteria andIllicitamountNotBetween(String value1, String value2) {
            addCriterion("illicitAmount not between", value1, value2, "illicitamount");
            return (Criteria) this;
        }

        public Criteria andIllicitadressIsNull() {
            addCriterion("illicitAdress is null");
            return (Criteria) this;
        }

        public Criteria andIllicitadressIsNotNull() {
            addCriterion("illicitAdress is not null");
            return (Criteria) this;
        }

        public Criteria andIllicitadressEqualTo(String value) {
            addCriterion("illicitAdress =", value, "illicitadress");
            return (Criteria) this;
        }

        public Criteria andIllicitadressNotEqualTo(String value) {
            addCriterion("illicitAdress <>", value, "illicitadress");
            return (Criteria) this;
        }

        public Criteria andIllicitadressGreaterThan(String value) {
            addCriterion("illicitAdress >", value, "illicitadress");
            return (Criteria) this;
        }

        public Criteria andIllicitadressGreaterThanOrEqualTo(String value) {
            addCriterion("illicitAdress >=", value, "illicitadress");
            return (Criteria) this;
        }

        public Criteria andIllicitadressLessThan(String value) {
            addCriterion("illicitAdress <", value, "illicitadress");
            return (Criteria) this;
        }

        public Criteria andIllicitadressLessThanOrEqualTo(String value) {
            addCriterion("illicitAdress <=", value, "illicitadress");
            return (Criteria) this;
        }

        public Criteria andIllicitadressLike(String value) {
            addCriterion("illicitAdress like", value, "illicitadress");
            return (Criteria) this;
        }

        public Criteria andIllicitadressNotLike(String value) {
            addCriterion("illicitAdress not like", value, "illicitadress");
            return (Criteria) this;
        }

        public Criteria andIllicitadressIn(List<String> values) {
            addCriterion("illicitAdress in", values, "illicitadress");
            return (Criteria) this;
        }

        public Criteria andIllicitadressNotIn(List<String> values) {
            addCriterion("illicitAdress not in", values, "illicitadress");
            return (Criteria) this;
        }

        public Criteria andIllicitadressBetween(String value1, String value2) {
            addCriterion("illicitAdress between", value1, value2, "illicitadress");
            return (Criteria) this;
        }

        public Criteria andIllicitadressNotBetween(String value1, String value2) {
            addCriterion("illicitAdress not between", value1, value2, "illicitadress");
            return (Criteria) this;
        }

        public Criteria andIllicitIsNull() {
            addCriterion("illicit is null");
            return (Criteria) this;
        }

        public Criteria andIllicitIsNotNull() {
            addCriterion("illicit is not null");
            return (Criteria) this;
        }

        public Criteria andIllicitEqualTo(String value) {
            addCriterion("illicit =", value, "illicit");
            return (Criteria) this;
        }

        public Criteria andIllicitNotEqualTo(String value) {
            addCriterion("illicit <>", value, "illicit");
            return (Criteria) this;
        }

        public Criteria andIllicitGreaterThan(String value) {
            addCriterion("illicit >", value, "illicit");
            return (Criteria) this;
        }

        public Criteria andIllicitGreaterThanOrEqualTo(String value) {
            addCriterion("illicit >=", value, "illicit");
            return (Criteria) this;
        }

        public Criteria andIllicitLessThan(String value) {
            addCriterion("illicit <", value, "illicit");
            return (Criteria) this;
        }

        public Criteria andIllicitLessThanOrEqualTo(String value) {
            addCriterion("illicit <=", value, "illicit");
            return (Criteria) this;
        }

        public Criteria andIllicitLike(String value) {
            addCriterion("illicit like", value, "illicit");
            return (Criteria) this;
        }

        public Criteria andIllicitNotLike(String value) {
            addCriterion("illicit not like", value, "illicit");
            return (Criteria) this;
        }

        public Criteria andIllicitIn(List<String> values) {
            addCriterion("illicit in", values, "illicit");
            return (Criteria) this;
        }

        public Criteria andIllicitNotIn(List<String> values) {
            addCriterion("illicit not in", values, "illicit");
            return (Criteria) this;
        }

        public Criteria andIllicitBetween(String value1, String value2) {
            addCriterion("illicit between", value1, value2, "illicit");
            return (Criteria) this;
        }

        public Criteria andIllicitNotBetween(String value1, String value2) {
            addCriterion("illicit not between", value1, value2, "illicit");
            return (Criteria) this;
        }

        public Criteria andIllicitdescIsNull() {
            addCriterion("illicitDesc is null");
            return (Criteria) this;
        }

        public Criteria andIllicitdescIsNotNull() {
            addCriterion("illicitDesc is not null");
            return (Criteria) this;
        }

        public Criteria andIllicitdescEqualTo(String value) {
            addCriterion("illicitDesc =", value, "illicitdesc");
            return (Criteria) this;
        }

        public Criteria andIllicitdescNotEqualTo(String value) {
            addCriterion("illicitDesc <>", value, "illicitdesc");
            return (Criteria) this;
        }

        public Criteria andIllicitdescGreaterThan(String value) {
            addCriterion("illicitDesc >", value, "illicitdesc");
            return (Criteria) this;
        }

        public Criteria andIllicitdescGreaterThanOrEqualTo(String value) {
            addCriterion("illicitDesc >=", value, "illicitdesc");
            return (Criteria) this;
        }

        public Criteria andIllicitdescLessThan(String value) {
            addCriterion("illicitDesc <", value, "illicitdesc");
            return (Criteria) this;
        }

        public Criteria andIllicitdescLessThanOrEqualTo(String value) {
            addCriterion("illicitDesc <=", value, "illicitdesc");
            return (Criteria) this;
        }

        public Criteria andIllicitdescLike(String value) {
            addCriterion("illicitDesc like", value, "illicitdesc");
            return (Criteria) this;
        }

        public Criteria andIllicitdescNotLike(String value) {
            addCriterion("illicitDesc not like", value, "illicitdesc");
            return (Criteria) this;
        }

        public Criteria andIllicitdescIn(List<String> values) {
            addCriterion("illicitDesc in", values, "illicitdesc");
            return (Criteria) this;
        }

        public Criteria andIllicitdescNotIn(List<String> values) {
            addCriterion("illicitDesc not in", values, "illicitdesc");
            return (Criteria) this;
        }

        public Criteria andIllicitdescBetween(String value1, String value2) {
            addCriterion("illicitDesc between", value1, value2, "illicitdesc");
            return (Criteria) this;
        }

        public Criteria andIllicitdescNotBetween(String value1, String value2) {
            addCriterion("illicitDesc not between", value1, value2, "illicitdesc");
            return (Criteria) this;
        }

        public Criteria andPickdepartmentIsNull() {
            addCriterion("pickDepartment is null");
            return (Criteria) this;
        }

        public Criteria andPickdepartmentIsNotNull() {
            addCriterion("pickDepartment is not null");
            return (Criteria) this;
        }

        public Criteria andPickdepartmentEqualTo(String value) {
            addCriterion("pickDepartment =", value, "pickdepartment");
            return (Criteria) this;
        }

        public Criteria andPickdepartmentNotEqualTo(String value) {
            addCriterion("pickDepartment <>", value, "pickdepartment");
            return (Criteria) this;
        }

        public Criteria andPickdepartmentGreaterThan(String value) {
            addCriterion("pickDepartment >", value, "pickdepartment");
            return (Criteria) this;
        }

        public Criteria andPickdepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("pickDepartment >=", value, "pickdepartment");
            return (Criteria) this;
        }

        public Criteria andPickdepartmentLessThan(String value) {
            addCriterion("pickDepartment <", value, "pickdepartment");
            return (Criteria) this;
        }

        public Criteria andPickdepartmentLessThanOrEqualTo(String value) {
            addCriterion("pickDepartment <=", value, "pickdepartment");
            return (Criteria) this;
        }

        public Criteria andPickdepartmentLike(String value) {
            addCriterion("pickDepartment like", value, "pickdepartment");
            return (Criteria) this;
        }

        public Criteria andPickdepartmentNotLike(String value) {
            addCriterion("pickDepartment not like", value, "pickdepartment");
            return (Criteria) this;
        }

        public Criteria andPickdepartmentIn(List<String> values) {
            addCriterion("pickDepartment in", values, "pickdepartment");
            return (Criteria) this;
        }

        public Criteria andPickdepartmentNotIn(List<String> values) {
            addCriterion("pickDepartment not in", values, "pickdepartment");
            return (Criteria) this;
        }

        public Criteria andPickdepartmentBetween(String value1, String value2) {
            addCriterion("pickDepartment between", value1, value2, "pickdepartment");
            return (Criteria) this;
        }

        public Criteria andPickdepartmentNotBetween(String value1, String value2) {
            addCriterion("pickDepartment not between", value1, value2, "pickdepartment");
            return (Criteria) this;
        }

        public Criteria andPickdepartmentdescIsNull() {
            addCriterion("pickDepartmentDesc is null");
            return (Criteria) this;
        }

        public Criteria andPickdepartmentdescIsNotNull() {
            addCriterion("pickDepartmentDesc is not null");
            return (Criteria) this;
        }

        public Criteria andPickdepartmentdescEqualTo(String value) {
            addCriterion("pickDepartmentDesc =", value, "pickdepartmentdesc");
            return (Criteria) this;
        }

        public Criteria andPickdepartmentdescNotEqualTo(String value) {
            addCriterion("pickDepartmentDesc <>", value, "pickdepartmentdesc");
            return (Criteria) this;
        }

        public Criteria andPickdepartmentdescGreaterThan(String value) {
            addCriterion("pickDepartmentDesc >", value, "pickdepartmentdesc");
            return (Criteria) this;
        }

        public Criteria andPickdepartmentdescGreaterThanOrEqualTo(String value) {
            addCriterion("pickDepartmentDesc >=", value, "pickdepartmentdesc");
            return (Criteria) this;
        }

        public Criteria andPickdepartmentdescLessThan(String value) {
            addCriterion("pickDepartmentDesc <", value, "pickdepartmentdesc");
            return (Criteria) this;
        }

        public Criteria andPickdepartmentdescLessThanOrEqualTo(String value) {
            addCriterion("pickDepartmentDesc <=", value, "pickdepartmentdesc");
            return (Criteria) this;
        }

        public Criteria andPickdepartmentdescLike(String value) {
            addCriterion("pickDepartmentDesc like", value, "pickdepartmentdesc");
            return (Criteria) this;
        }

        public Criteria andPickdepartmentdescNotLike(String value) {
            addCriterion("pickDepartmentDesc not like", value, "pickdepartmentdesc");
            return (Criteria) this;
        }

        public Criteria andPickdepartmentdescIn(List<String> values) {
            addCriterion("pickDepartmentDesc in", values, "pickdepartmentdesc");
            return (Criteria) this;
        }

        public Criteria andPickdepartmentdescNotIn(List<String> values) {
            addCriterion("pickDepartmentDesc not in", values, "pickdepartmentdesc");
            return (Criteria) this;
        }

        public Criteria andPickdepartmentdescBetween(String value1, String value2) {
            addCriterion("pickDepartmentDesc between", value1, value2, "pickdepartmentdesc");
            return (Criteria) this;
        }

        public Criteria andPickdepartmentdescNotBetween(String value1, String value2) {
            addCriterion("pickDepartmentDesc not between", value1, value2, "pickdepartmentdesc");
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

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andIsdeletedIsNull() {
            addCriterion("isDeleted is null");
            return (Criteria) this;
        }

        public Criteria andIsdeletedIsNotNull() {
            addCriterion("isDeleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsdeletedEqualTo(Boolean value) {
            addCriterion("isDeleted =", value, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedNotEqualTo(Boolean value) {
            addCriterion("isDeleted <>", value, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedGreaterThan(Boolean value) {
            addCriterion("isDeleted >", value, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isDeleted >=", value, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedLessThan(Boolean value) {
            addCriterion("isDeleted <", value, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedLessThanOrEqualTo(Boolean value) {
            addCriterion("isDeleted <=", value, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedIn(List<Boolean> values) {
            addCriterion("isDeleted in", values, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedNotIn(List<Boolean> values) {
            addCriterion("isDeleted not in", values, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedBetween(Boolean value1, Boolean value2) {
            addCriterion("isDeleted between", value1, value2, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isDeleted not between", value1, value2, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updateTime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updateTime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updateTime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updateTime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updateTime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updateTime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updateTime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updateTime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updateTime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andDeletetimeIsNull() {
            addCriterion("deleteTime is null");
            return (Criteria) this;
        }

        public Criteria andDeletetimeIsNotNull() {
            addCriterion("deleteTime is not null");
            return (Criteria) this;
        }

        public Criteria andDeletetimeEqualTo(Date value) {
            addCriterion("deleteTime =", value, "deletetime");
            return (Criteria) this;
        }

        public Criteria andDeletetimeNotEqualTo(Date value) {
            addCriterion("deleteTime <>", value, "deletetime");
            return (Criteria) this;
        }

        public Criteria andDeletetimeGreaterThan(Date value) {
            addCriterion("deleteTime >", value, "deletetime");
            return (Criteria) this;
        }

        public Criteria andDeletetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("deleteTime >=", value, "deletetime");
            return (Criteria) this;
        }

        public Criteria andDeletetimeLessThan(Date value) {
            addCriterion("deleteTime <", value, "deletetime");
            return (Criteria) this;
        }

        public Criteria andDeletetimeLessThanOrEqualTo(Date value) {
            addCriterion("deleteTime <=", value, "deletetime");
            return (Criteria) this;
        }

        public Criteria andDeletetimeIn(List<Date> values) {
            addCriterion("deleteTime in", values, "deletetime");
            return (Criteria) this;
        }

        public Criteria andDeletetimeNotIn(List<Date> values) {
            addCriterion("deleteTime not in", values, "deletetime");
            return (Criteria) this;
        }

        public Criteria andDeletetimeBetween(Date value1, Date value2) {
            addCriterion("deleteTime between", value1, value2, "deletetime");
            return (Criteria) this;
        }

        public Criteria andDeletetimeNotBetween(Date value1, Date value2) {
            addCriterion("deleteTime not between", value1, value2, "deletetime");
            return (Criteria) this;
        }

        public Criteria andCreatebyIsNull() {
            addCriterion("createBy is null");
            return (Criteria) this;
        }

        public Criteria andCreatebyIsNotNull() {
            addCriterion("createBy is not null");
            return (Criteria) this;
        }

        public Criteria andCreatebyEqualTo(String value) {
            addCriterion("createBy =", value, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyNotEqualTo(String value) {
            addCriterion("createBy <>", value, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyGreaterThan(String value) {
            addCriterion("createBy >", value, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyGreaterThanOrEqualTo(String value) {
            addCriterion("createBy >=", value, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyLessThan(String value) {
            addCriterion("createBy <", value, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyLessThanOrEqualTo(String value) {
            addCriterion("createBy <=", value, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyLike(String value) {
            addCriterion("createBy like", value, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyNotLike(String value) {
            addCriterion("createBy not like", value, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyIn(List<String> values) {
            addCriterion("createBy in", values, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyNotIn(List<String> values) {
            addCriterion("createBy not in", values, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyBetween(String value1, String value2) {
            addCriterion("createBy between", value1, value2, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyNotBetween(String value1, String value2) {
            addCriterion("createBy not between", value1, value2, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatedepcdIsNull() {
            addCriterion("createDepCd is null");
            return (Criteria) this;
        }

        public Criteria andCreatedepcdIsNotNull() {
            addCriterion("createDepCd is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedepcdEqualTo(String value) {
            addCriterion("createDepCd =", value, "createdepcd");
            return (Criteria) this;
        }

        public Criteria andCreatedepcdNotEqualTo(String value) {
            addCriterion("createDepCd <>", value, "createdepcd");
            return (Criteria) this;
        }

        public Criteria andCreatedepcdGreaterThan(String value) {
            addCriterion("createDepCd >", value, "createdepcd");
            return (Criteria) this;
        }

        public Criteria andCreatedepcdGreaterThanOrEqualTo(String value) {
            addCriterion("createDepCd >=", value, "createdepcd");
            return (Criteria) this;
        }

        public Criteria andCreatedepcdLessThan(String value) {
            addCriterion("createDepCd <", value, "createdepcd");
            return (Criteria) this;
        }

        public Criteria andCreatedepcdLessThanOrEqualTo(String value) {
            addCriterion("createDepCd <=", value, "createdepcd");
            return (Criteria) this;
        }

        public Criteria andCreatedepcdLike(String value) {
            addCriterion("createDepCd like", value, "createdepcd");
            return (Criteria) this;
        }

        public Criteria andCreatedepcdNotLike(String value) {
            addCriterion("createDepCd not like", value, "createdepcd");
            return (Criteria) this;
        }

        public Criteria andCreatedepcdIn(List<String> values) {
            addCriterion("createDepCd in", values, "createdepcd");
            return (Criteria) this;
        }

        public Criteria andCreatedepcdNotIn(List<String> values) {
            addCriterion("createDepCd not in", values, "createdepcd");
            return (Criteria) this;
        }

        public Criteria andCreatedepcdBetween(String value1, String value2) {
            addCriterion("createDepCd between", value1, value2, "createdepcd");
            return (Criteria) this;
        }

        public Criteria andCreatedepcdNotBetween(String value1, String value2) {
            addCriterion("createDepCd not between", value1, value2, "createdepcd");
            return (Criteria) this;
        }

        public Criteria andUpdatebyIsNull() {
            addCriterion("updateBy is null");
            return (Criteria) this;
        }

        public Criteria andUpdatebyIsNotNull() {
            addCriterion("updateBy is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatebyEqualTo(String value) {
            addCriterion("updateBy =", value, "updateby");
            return (Criteria) this;
        }

        public Criteria andUpdatebyNotEqualTo(String value) {
            addCriterion("updateBy <>", value, "updateby");
            return (Criteria) this;
        }

        public Criteria andUpdatebyGreaterThan(String value) {
            addCriterion("updateBy >", value, "updateby");
            return (Criteria) this;
        }

        public Criteria andUpdatebyGreaterThanOrEqualTo(String value) {
            addCriterion("updateBy >=", value, "updateby");
            return (Criteria) this;
        }

        public Criteria andUpdatebyLessThan(String value) {
            addCriterion("updateBy <", value, "updateby");
            return (Criteria) this;
        }

        public Criteria andUpdatebyLessThanOrEqualTo(String value) {
            addCriterion("updateBy <=", value, "updateby");
            return (Criteria) this;
        }

        public Criteria andUpdatebyLike(String value) {
            addCriterion("updateBy like", value, "updateby");
            return (Criteria) this;
        }

        public Criteria andUpdatebyNotLike(String value) {
            addCriterion("updateBy not like", value, "updateby");
            return (Criteria) this;
        }

        public Criteria andUpdatebyIn(List<String> values) {
            addCriterion("updateBy in", values, "updateby");
            return (Criteria) this;
        }

        public Criteria andUpdatebyNotIn(List<String> values) {
            addCriterion("updateBy not in", values, "updateby");
            return (Criteria) this;
        }

        public Criteria andUpdatebyBetween(String value1, String value2) {
            addCriterion("updateBy between", value1, value2, "updateby");
            return (Criteria) this;
        }

        public Criteria andUpdatebyNotBetween(String value1, String value2) {
            addCriterion("updateBy not between", value1, value2, "updateby");
            return (Criteria) this;
        }

        public Criteria andUpdatedepcdIsNull() {
            addCriterion("updateDepCd is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedepcdIsNotNull() {
            addCriterion("updateDepCd is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedepcdEqualTo(String value) {
            addCriterion("updateDepCd =", value, "updatedepcd");
            return (Criteria) this;
        }

        public Criteria andUpdatedepcdNotEqualTo(String value) {
            addCriterion("updateDepCd <>", value, "updatedepcd");
            return (Criteria) this;
        }

        public Criteria andUpdatedepcdGreaterThan(String value) {
            addCriterion("updateDepCd >", value, "updatedepcd");
            return (Criteria) this;
        }

        public Criteria andUpdatedepcdGreaterThanOrEqualTo(String value) {
            addCriterion("updateDepCd >=", value, "updatedepcd");
            return (Criteria) this;
        }

        public Criteria andUpdatedepcdLessThan(String value) {
            addCriterion("updateDepCd <", value, "updatedepcd");
            return (Criteria) this;
        }

        public Criteria andUpdatedepcdLessThanOrEqualTo(String value) {
            addCriterion("updateDepCd <=", value, "updatedepcd");
            return (Criteria) this;
        }

        public Criteria andUpdatedepcdLike(String value) {
            addCriterion("updateDepCd like", value, "updatedepcd");
            return (Criteria) this;
        }

        public Criteria andUpdatedepcdNotLike(String value) {
            addCriterion("updateDepCd not like", value, "updatedepcd");
            return (Criteria) this;
        }

        public Criteria andUpdatedepcdIn(List<String> values) {
            addCriterion("updateDepCd in", values, "updatedepcd");
            return (Criteria) this;
        }

        public Criteria andUpdatedepcdNotIn(List<String> values) {
            addCriterion("updateDepCd not in", values, "updatedepcd");
            return (Criteria) this;
        }

        public Criteria andUpdatedepcdBetween(String value1, String value2) {
            addCriterion("updateDepCd between", value1, value2, "updatedepcd");
            return (Criteria) this;
        }

        public Criteria andUpdatedepcdNotBetween(String value1, String value2) {
            addCriterion("updateDepCd not between", value1, value2, "updatedepcd");
            return (Criteria) this;
        }
    }

    /**
     * dr_illicit
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * dr_illicit null
     */
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