package com.ccttic.entity.danger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DrDangerExample {
    /**
     * dr_danger
     */
    protected String orderByClause;

    /**
     * dr_danger
     */
    protected boolean distinct;

    /**
     * dr_danger
     */
    protected List<Criteria> oredCriteria;

    public DrDangerExample() {
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
     * dr_danger null
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

        public Criteria andDrivernameIsNull() {
            addCriterion("driverName is null");
            return (Criteria) this;
        }

        public Criteria andDrivernameIsNotNull() {
            addCriterion("driverName is not null");
            return (Criteria) this;
        }

        public Criteria andDrivernameEqualTo(String value) {
            addCriterion("driverName =", value, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameNotEqualTo(String value) {
            addCriterion("driverName <>", value, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameGreaterThan(String value) {
            addCriterion("driverName >", value, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameGreaterThanOrEqualTo(String value) {
            addCriterion("driverName >=", value, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameLessThan(String value) {
            addCriterion("driverName <", value, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameLessThanOrEqualTo(String value) {
            addCriterion("driverName <=", value, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameLike(String value) {
            addCriterion("driverName like", value, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameNotLike(String value) {
            addCriterion("driverName not like", value, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameIn(List<String> values) {
            addCriterion("driverName in", values, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameNotIn(List<String> values) {
            addCriterion("driverName not in", values, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameBetween(String value1, String value2) {
            addCriterion("driverName between", value1, value2, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameNotBetween(String value1, String value2) {
            addCriterion("driverName not between", value1, value2, "drivername");
            return (Criteria) this;
        }

        public Criteria andDriveridcardIsNull() {
            addCriterion("driverIdcard is null");
            return (Criteria) this;
        }

        public Criteria andDriveridcardIsNotNull() {
            addCriterion("driverIdcard is not null");
            return (Criteria) this;
        }

        public Criteria andDriveridcardEqualTo(String value) {
            addCriterion("driverIdcard =", value, "driveridcard");
            return (Criteria) this;
        }

        public Criteria andDriveridcardNotEqualTo(String value) {
            addCriterion("driverIdcard <>", value, "driveridcard");
            return (Criteria) this;
        }

        public Criteria andDriveridcardGreaterThan(String value) {
            addCriterion("driverIdcard >", value, "driveridcard");
            return (Criteria) this;
        }

        public Criteria andDriveridcardGreaterThanOrEqualTo(String value) {
            addCriterion("driverIdcard >=", value, "driveridcard");
            return (Criteria) this;
        }

        public Criteria andDriveridcardLessThan(String value) {
            addCriterion("driverIdcard <", value, "driveridcard");
            return (Criteria) this;
        }

        public Criteria andDriveridcardLessThanOrEqualTo(String value) {
            addCriterion("driverIdcard <=", value, "driveridcard");
            return (Criteria) this;
        }

        public Criteria andDriveridcardLike(String value) {
            addCriterion("driverIdcard like", value, "driveridcard");
            return (Criteria) this;
        }

        public Criteria andDriveridcardNotLike(String value) {
            addCriterion("driverIdcard not like", value, "driveridcard");
            return (Criteria) this;
        }

        public Criteria andDriveridcardIn(List<String> values) {
            addCriterion("driverIdcard in", values, "driveridcard");
            return (Criteria) this;
        }

        public Criteria andDriveridcardNotIn(List<String> values) {
            addCriterion("driverIdcard not in", values, "driveridcard");
            return (Criteria) this;
        }

        public Criteria andDriveridcardBetween(String value1, String value2) {
            addCriterion("driverIdcard between", value1, value2, "driveridcard");
            return (Criteria) this;
        }

        public Criteria andDriveridcardNotBetween(String value1, String value2) {
            addCriterion("driverIdcard not between", value1, value2, "driveridcard");
            return (Criteria) this;
        }

        public Criteria andDangertypeIsNull() {
            addCriterion("dangerType is null");
            return (Criteria) this;
        }

        public Criteria andDangertypeIsNotNull() {
            addCriterion("dangerType is not null");
            return (Criteria) this;
        }

        public Criteria andDangertypeEqualTo(String value) {
            addCriterion("dangerType =", value, "dangertype");
            return (Criteria) this;
        }

        public Criteria andDangertypeNotEqualTo(String value) {
            addCriterion("dangerType <>", value, "dangertype");
            return (Criteria) this;
        }

        public Criteria andDangertypeGreaterThan(String value) {
            addCriterion("dangerType >", value, "dangertype");
            return (Criteria) this;
        }

        public Criteria andDangertypeGreaterThanOrEqualTo(String value) {
            addCriterion("dangerType >=", value, "dangertype");
            return (Criteria) this;
        }

        public Criteria andDangertypeLessThan(String value) {
            addCriterion("dangerType <", value, "dangertype");
            return (Criteria) this;
        }

        public Criteria andDangertypeLessThanOrEqualTo(String value) {
            addCriterion("dangerType <=", value, "dangertype");
            return (Criteria) this;
        }

        public Criteria andDangertypeLike(String value) {
            addCriterion("dangerType like", value, "dangertype");
            return (Criteria) this;
        }

        public Criteria andDangertypeNotLike(String value) {
            addCriterion("dangerType not like", value, "dangertype");
            return (Criteria) this;
        }

        public Criteria andDangertypeIn(List<String> values) {
            addCriterion("dangerType in", values, "dangertype");
            return (Criteria) this;
        }

        public Criteria andDangertypeNotIn(List<String> values) {
            addCriterion("dangerType not in", values, "dangertype");
            return (Criteria) this;
        }

        public Criteria andDangertypeBetween(String value1, String value2) {
            addCriterion("dangerType between", value1, value2, "dangertype");
            return (Criteria) this;
        }

        public Criteria andDangertypeNotBetween(String value1, String value2) {
            addCriterion("dangerType not between", value1, value2, "dangertype");
            return (Criteria) this;
        }

        public Criteria andOwnergenerIsNull() {
            addCriterion("ownerGener is null");
            return (Criteria) this;
        }

        public Criteria andOwnergenerIsNotNull() {
            addCriterion("ownerGener is not null");
            return (Criteria) this;
        }

        public Criteria andOwnergenerEqualTo(String value) {
            addCriterion("ownerGener =", value, "ownergener");
            return (Criteria) this;
        }

        public Criteria andOwnergenerNotEqualTo(String value) {
            addCriterion("ownerGener <>", value, "ownergener");
            return (Criteria) this;
        }

        public Criteria andOwnergenerGreaterThan(String value) {
            addCriterion("ownerGener >", value, "ownergener");
            return (Criteria) this;
        }

        public Criteria andOwnergenerGreaterThanOrEqualTo(String value) {
            addCriterion("ownerGener >=", value, "ownergener");
            return (Criteria) this;
        }

        public Criteria andOwnergenerLessThan(String value) {
            addCriterion("ownerGener <", value, "ownergener");
            return (Criteria) this;
        }

        public Criteria andOwnergenerLessThanOrEqualTo(String value) {
            addCriterion("ownerGener <=", value, "ownergener");
            return (Criteria) this;
        }

        public Criteria andOwnergenerLike(String value) {
            addCriterion("ownerGener like", value, "ownergener");
            return (Criteria) this;
        }

        public Criteria andOwnergenerNotLike(String value) {
            addCriterion("ownerGener not like", value, "ownergener");
            return (Criteria) this;
        }

        public Criteria andOwnergenerIn(List<String> values) {
            addCriterion("ownerGener in", values, "ownergener");
            return (Criteria) this;
        }

        public Criteria andOwnergenerNotIn(List<String> values) {
            addCriterion("ownerGener not in", values, "ownergener");
            return (Criteria) this;
        }

        public Criteria andOwnergenerBetween(String value1, String value2) {
            addCriterion("ownerGener between", value1, value2, "ownergener");
            return (Criteria) this;
        }

        public Criteria andOwnergenerNotBetween(String value1, String value2) {
            addCriterion("ownerGener not between", value1, value2, "ownergener");
            return (Criteria) this;
        }

        public Criteria andOwnerorgidIsNull() {
            addCriterion("ownerOrgId is null");
            return (Criteria) this;
        }

        public Criteria andOwnerorgidIsNotNull() {
            addCriterion("ownerOrgId is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerorgidEqualTo(String value) {
            addCriterion("ownerOrgId =", value, "ownerorgid");
            return (Criteria) this;
        }

        public Criteria andOwnerorgidNotEqualTo(String value) {
            addCriterion("ownerOrgId <>", value, "ownerorgid");
            return (Criteria) this;
        }

        public Criteria andOwnerorgidGreaterThan(String value) {
            addCriterion("ownerOrgId >", value, "ownerorgid");
            return (Criteria) this;
        }

        public Criteria andOwnerorgidGreaterThanOrEqualTo(String value) {
            addCriterion("ownerOrgId >=", value, "ownerorgid");
            return (Criteria) this;
        }

        public Criteria andOwnerorgidLessThan(String value) {
            addCriterion("ownerOrgId <", value, "ownerorgid");
            return (Criteria) this;
        }

        public Criteria andOwnerorgidLessThanOrEqualTo(String value) {
            addCriterion("ownerOrgId <=", value, "ownerorgid");
            return (Criteria) this;
        }

        public Criteria andOwnerorgidLike(String value) {
            addCriterion("ownerOrgId like", value, "ownerorgid");
            return (Criteria) this;
        }

        public Criteria andOwnerorgidNotLike(String value) {
            addCriterion("ownerOrgId not like", value, "ownerorgid");
            return (Criteria) this;
        }

        public Criteria andOwnerorgidIn(List<String> values) {
            addCriterion("ownerOrgId in", values, "ownerorgid");
            return (Criteria) this;
        }

        public Criteria andOwnerorgidNotIn(List<String> values) {
            addCriterion("ownerOrgId not in", values, "ownerorgid");
            return (Criteria) this;
        }

        public Criteria andOwnerorgidBetween(String value1, String value2) {
            addCriterion("ownerOrgId between", value1, value2, "ownerorgid");
            return (Criteria) this;
        }

        public Criteria andOwnerorgidNotBetween(String value1, String value2) {
            addCriterion("ownerOrgId not between", value1, value2, "ownerorgid");
            return (Criteria) this;
        }

        public Criteria andDangertimeIsNull() {
            addCriterion("dangerTime is null");
            return (Criteria) this;
        }

        public Criteria andDangertimeIsNotNull() {
            addCriterion("dangerTime is not null");
            return (Criteria) this;
        }

        public Criteria andDangertimeEqualTo(String value) {
            addCriterion("dangerTime =", value, "dangertime");
            return (Criteria) this;
        }

        public Criteria andDangertimeNotEqualTo(String value) {
            addCriterion("dangerTime <>", value, "dangertime");
            return (Criteria) this;
        }

        public Criteria andDangertimeGreaterThan(String value) {
            addCriterion("dangerTime >", value, "dangertime");
            return (Criteria) this;
        }

        public Criteria andDangertimeGreaterThanOrEqualTo(String value) {
            addCriterion("dangerTime >=", value, "dangertime");
            return (Criteria) this;
        }

        public Criteria andDangertimeLessThan(String value) {
            addCriterion("dangerTime <", value, "dangertime");
            return (Criteria) this;
        }

        public Criteria andDangertimeLessThanOrEqualTo(String value) {
            addCriterion("dangerTime <=", value, "dangertime");
            return (Criteria) this;
        }

        public Criteria andDangertimeLike(String value) {
            addCriterion("dangerTime like", value, "dangertime");
            return (Criteria) this;
        }

        public Criteria andDangertimeNotLike(String value) {
            addCriterion("dangerTime not like", value, "dangertime");
            return (Criteria) this;
        }

        public Criteria andDangertimeIn(List<String> values) {
            addCriterion("dangerTime in", values, "dangertime");
            return (Criteria) this;
        }

        public Criteria andDangertimeNotIn(List<String> values) {
            addCriterion("dangerTime not in", values, "dangertime");
            return (Criteria) this;
        }

        public Criteria andDangertimeBetween(String value1, String value2) {
            addCriterion("dangerTime between", value1, value2, "dangertime");
            return (Criteria) this;
        }

        public Criteria andDangertimeNotBetween(String value1, String value2) {
            addCriterion("dangerTime not between", value1, value2, "dangertime");
            return (Criteria) this;
        }

        public Criteria andCorrecttimeIsNull() {
            addCriterion("correctTime is null");
            return (Criteria) this;
        }

        public Criteria andCorrecttimeIsNotNull() {
            addCriterion("correctTime is not null");
            return (Criteria) this;
        }

        public Criteria andCorrecttimeEqualTo(String value) {
            addCriterion("correctTime =", value, "correcttime");
            return (Criteria) this;
        }

        public Criteria andCorrecttimeNotEqualTo(String value) {
            addCriterion("correctTime <>", value, "correcttime");
            return (Criteria) this;
        }

        public Criteria andCorrecttimeGreaterThan(String value) {
            addCriterion("correctTime >", value, "correcttime");
            return (Criteria) this;
        }

        public Criteria andCorrecttimeGreaterThanOrEqualTo(String value) {
            addCriterion("correctTime >=", value, "correcttime");
            return (Criteria) this;
        }

        public Criteria andCorrecttimeLessThan(String value) {
            addCriterion("correctTime <", value, "correcttime");
            return (Criteria) this;
        }

        public Criteria andCorrecttimeLessThanOrEqualTo(String value) {
            addCriterion("correctTime <=", value, "correcttime");
            return (Criteria) this;
        }

        public Criteria andCorrecttimeLike(String value) {
            addCriterion("correctTime like", value, "correcttime");
            return (Criteria) this;
        }

        public Criteria andCorrecttimeNotLike(String value) {
            addCriterion("correctTime not like", value, "correcttime");
            return (Criteria) this;
        }

        public Criteria andCorrecttimeIn(List<String> values) {
            addCriterion("correctTime in", values, "correcttime");
            return (Criteria) this;
        }

        public Criteria andCorrecttimeNotIn(List<String> values) {
            addCriterion("correctTime not in", values, "correcttime");
            return (Criteria) this;
        }

        public Criteria andCorrecttimeBetween(String value1, String value2) {
            addCriterion("correctTime between", value1, value2, "correcttime");
            return (Criteria) this;
        }

        public Criteria andCorrecttimeNotBetween(String value1, String value2) {
            addCriterion("correctTime not between", value1, value2, "correcttime");
            return (Criteria) this;
        }

        public Criteria andCorrectstateIsNull() {
            addCriterion("correctState is null");
            return (Criteria) this;
        }

        public Criteria andCorrectstateIsNotNull() {
            addCriterion("correctState is not null");
            return (Criteria) this;
        }

        public Criteria andCorrectstateEqualTo(String value) {
            addCriterion("correctState =", value, "correctstate");
            return (Criteria) this;
        }

        public Criteria andCorrectstateNotEqualTo(String value) {
            addCriterion("correctState <>", value, "correctstate");
            return (Criteria) this;
        }

        public Criteria andCorrectstateGreaterThan(String value) {
            addCriterion("correctState >", value, "correctstate");
            return (Criteria) this;
        }

        public Criteria andCorrectstateGreaterThanOrEqualTo(String value) {
            addCriterion("correctState >=", value, "correctstate");
            return (Criteria) this;
        }

        public Criteria andCorrectstateLessThan(String value) {
            addCriterion("correctState <", value, "correctstate");
            return (Criteria) this;
        }

        public Criteria andCorrectstateLessThanOrEqualTo(String value) {
            addCriterion("correctState <=", value, "correctstate");
            return (Criteria) this;
        }

        public Criteria andCorrectstateLike(String value) {
            addCriterion("correctState like", value, "correctstate");
            return (Criteria) this;
        }

        public Criteria andCorrectstateNotLike(String value) {
            addCriterion("correctState not like", value, "correctstate");
            return (Criteria) this;
        }

        public Criteria andCorrectstateIn(List<String> values) {
            addCriterion("correctState in", values, "correctstate");
            return (Criteria) this;
        }

        public Criteria andCorrectstateNotIn(List<String> values) {
            addCriterion("correctState not in", values, "correctstate");
            return (Criteria) this;
        }

        public Criteria andCorrectstateBetween(String value1, String value2) {
            addCriterion("correctState between", value1, value2, "correctstate");
            return (Criteria) this;
        }

        public Criteria andCorrectstateNotBetween(String value1, String value2) {
            addCriterion("correctState not between", value1, value2, "correctstate");
            return (Criteria) this;
        }

        public Criteria andDangerdescIsNull() {
            addCriterion("dangerDesc is null");
            return (Criteria) this;
        }

        public Criteria andDangerdescIsNotNull() {
            addCriterion("dangerDesc is not null");
            return (Criteria) this;
        }

        public Criteria andDangerdescEqualTo(String value) {
            addCriterion("dangerDesc =", value, "dangerdesc");
            return (Criteria) this;
        }

        public Criteria andDangerdescNotEqualTo(String value) {
            addCriterion("dangerDesc <>", value, "dangerdesc");
            return (Criteria) this;
        }

        public Criteria andDangerdescGreaterThan(String value) {
            addCriterion("dangerDesc >", value, "dangerdesc");
            return (Criteria) this;
        }

        public Criteria andDangerdescGreaterThanOrEqualTo(String value) {
            addCriterion("dangerDesc >=", value, "dangerdesc");
            return (Criteria) this;
        }

        public Criteria andDangerdescLessThan(String value) {
            addCriterion("dangerDesc <", value, "dangerdesc");
            return (Criteria) this;
        }

        public Criteria andDangerdescLessThanOrEqualTo(String value) {
            addCriterion("dangerDesc <=", value, "dangerdesc");
            return (Criteria) this;
        }

        public Criteria andDangerdescLike(String value) {
            addCriterion("dangerDesc like", value, "dangerdesc");
            return (Criteria) this;
        }

        public Criteria andDangerdescNotLike(String value) {
            addCriterion("dangerDesc not like", value, "dangerdesc");
            return (Criteria) this;
        }

        public Criteria andDangerdescIn(List<String> values) {
            addCriterion("dangerDesc in", values, "dangerdesc");
            return (Criteria) this;
        }

        public Criteria andDangerdescNotIn(List<String> values) {
            addCriterion("dangerDesc not in", values, "dangerdesc");
            return (Criteria) this;
        }

        public Criteria andDangerdescBetween(String value1, String value2) {
            addCriterion("dangerDesc between", value1, value2, "dangerdesc");
            return (Criteria) this;
        }

        public Criteria andDangerdescNotBetween(String value1, String value2) {
            addCriterion("dangerDesc not between", value1, value2, "dangerdesc");
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

        public Criteria andIllicitstateIsNull() {
            addCriterion("illicitState is null");
            return (Criteria) this;
        }

        public Criteria andIllicitstateIsNotNull() {
            addCriterion("illicitState is not null");
            return (Criteria) this;
        }

        public Criteria andIllicitstateEqualTo(Integer value) {
            addCriterion("illicitState =", value, "illicitstate");
            return (Criteria) this;
        }

        public Criteria andIllicitstateNotEqualTo(Integer value) {
            addCriterion("illicitState <>", value, "illicitstate");
            return (Criteria) this;
        }

        public Criteria andIllicitstateGreaterThan(Integer value) {
            addCriterion("illicitState >", value, "illicitstate");
            return (Criteria) this;
        }

        public Criteria andIllicitstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("illicitState >=", value, "illicitstate");
            return (Criteria) this;
        }

        public Criteria andIllicitstateLessThan(Integer value) {
            addCriterion("illicitState <", value, "illicitstate");
            return (Criteria) this;
        }

        public Criteria andIllicitstateLessThanOrEqualTo(Integer value) {
            addCriterion("illicitState <=", value, "illicitstate");
            return (Criteria) this;
        }

        public Criteria andIllicitstateIn(List<Integer> values) {
            addCriterion("illicitState in", values, "illicitstate");
            return (Criteria) this;
        }

        public Criteria andIllicitstateNotIn(List<Integer> values) {
            addCriterion("illicitState not in", values, "illicitstate");
            return (Criteria) this;
        }

        public Criteria andIllicitstateBetween(Integer value1, Integer value2) {
            addCriterion("illicitState between", value1, value2, "illicitstate");
            return (Criteria) this;
        }

        public Criteria andIllicitstateNotBetween(Integer value1, Integer value2) {
            addCriterion("illicitState not between", value1, value2, "illicitstate");
            return (Criteria) this;
        }

        public Criteria andFailurestateIsNull() {
            addCriterion("failureState is null");
            return (Criteria) this;
        }

        public Criteria andFailurestateIsNotNull() {
            addCriterion("failureState is not null");
            return (Criteria) this;
        }

        public Criteria andFailurestateEqualTo(Integer value) {
            addCriterion("failureState =", value, "failurestate");
            return (Criteria) this;
        }

        public Criteria andFailurestateNotEqualTo(Integer value) {
            addCriterion("failureState <>", value, "failurestate");
            return (Criteria) this;
        }

        public Criteria andFailurestateGreaterThan(Integer value) {
            addCriterion("failureState >", value, "failurestate");
            return (Criteria) this;
        }

        public Criteria andFailurestateGreaterThanOrEqualTo(Integer value) {
            addCriterion("failureState >=", value, "failurestate");
            return (Criteria) this;
        }

        public Criteria andFailurestateLessThan(Integer value) {
            addCriterion("failureState <", value, "failurestate");
            return (Criteria) this;
        }

        public Criteria andFailurestateLessThanOrEqualTo(Integer value) {
            addCriterion("failureState <=", value, "failurestate");
            return (Criteria) this;
        }

        public Criteria andFailurestateIn(List<Integer> values) {
            addCriterion("failureState in", values, "failurestate");
            return (Criteria) this;
        }

        public Criteria andFailurestateNotIn(List<Integer> values) {
            addCriterion("failureState not in", values, "failurestate");
            return (Criteria) this;
        }

        public Criteria andFailurestateBetween(Integer value1, Integer value2) {
            addCriterion("failureState between", value1, value2, "failurestate");
            return (Criteria) this;
        }

        public Criteria andFailurestateNotBetween(Integer value1, Integer value2) {
            addCriterion("failureState not between", value1, value2, "failurestate");
            return (Criteria) this;
        }

        public Criteria andOverdueproofstateIsNull() {
            addCriterion("overdueProofState is null");
            return (Criteria) this;
        }

        public Criteria andOverdueproofstateIsNotNull() {
            addCriterion("overdueProofState is not null");
            return (Criteria) this;
        }

        public Criteria andOverdueproofstateEqualTo(Integer value) {
            addCriterion("overdueProofState =", value, "overdueproofstate");
            return (Criteria) this;
        }

        public Criteria andOverdueproofstateNotEqualTo(Integer value) {
            addCriterion("overdueProofState <>", value, "overdueproofstate");
            return (Criteria) this;
        }

        public Criteria andOverdueproofstateGreaterThan(Integer value) {
            addCriterion("overdueProofState >", value, "overdueproofstate");
            return (Criteria) this;
        }

        public Criteria andOverdueproofstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("overdueProofState >=", value, "overdueproofstate");
            return (Criteria) this;
        }

        public Criteria andOverdueproofstateLessThan(Integer value) {
            addCriterion("overdueProofState <", value, "overdueproofstate");
            return (Criteria) this;
        }

        public Criteria andOverdueproofstateLessThanOrEqualTo(Integer value) {
            addCriterion("overdueProofState <=", value, "overdueproofstate");
            return (Criteria) this;
        }

        public Criteria andOverdueproofstateIn(List<Integer> values) {
            addCriterion("overdueProofState in", values, "overdueproofstate");
            return (Criteria) this;
        }

        public Criteria andOverdueproofstateNotIn(List<Integer> values) {
            addCriterion("overdueProofState not in", values, "overdueproofstate");
            return (Criteria) this;
        }

        public Criteria andOverdueproofstateBetween(Integer value1, Integer value2) {
            addCriterion("overdueProofState between", value1, value2, "overdueproofstate");
            return (Criteria) this;
        }

        public Criteria andOverdueproofstateNotBetween(Integer value1, Integer value2) {
            addCriterion("overdueProofState not between", value1, value2, "overdueproofstate");
            return (Criteria) this;
        }

        public Criteria andOverdueexaminestateIsNull() {
            addCriterion("overdueExamineState is null");
            return (Criteria) this;
        }

        public Criteria andOverdueexaminestateIsNotNull() {
            addCriterion("overdueExamineState is not null");
            return (Criteria) this;
        }

        public Criteria andOverdueexaminestateEqualTo(Integer value) {
            addCriterion("overdueExamineState =", value, "overdueexaminestate");
            return (Criteria) this;
        }

        public Criteria andOverdueexaminestateNotEqualTo(Integer value) {
            addCriterion("overdueExamineState <>", value, "overdueexaminestate");
            return (Criteria) this;
        }

        public Criteria andOverdueexaminestateGreaterThan(Integer value) {
            addCriterion("overdueExamineState >", value, "overdueexaminestate");
            return (Criteria) this;
        }

        public Criteria andOverdueexaminestateGreaterThanOrEqualTo(Integer value) {
            addCriterion("overdueExamineState >=", value, "overdueexaminestate");
            return (Criteria) this;
        }

        public Criteria andOverdueexaminestateLessThan(Integer value) {
            addCriterion("overdueExamineState <", value, "overdueexaminestate");
            return (Criteria) this;
        }

        public Criteria andOverdueexaminestateLessThanOrEqualTo(Integer value) {
            addCriterion("overdueExamineState <=", value, "overdueexaminestate");
            return (Criteria) this;
        }

        public Criteria andOverdueexaminestateIn(List<Integer> values) {
            addCriterion("overdueExamineState in", values, "overdueexaminestate");
            return (Criteria) this;
        }

        public Criteria andOverdueexaminestateNotIn(List<Integer> values) {
            addCriterion("overdueExamineState not in", values, "overdueexaminestate");
            return (Criteria) this;
        }

        public Criteria andOverdueexaminestateBetween(Integer value1, Integer value2) {
            addCriterion("overdueExamineState between", value1, value2, "overdueexaminestate");
            return (Criteria) this;
        }

        public Criteria andOverdueexaminestateNotBetween(Integer value1, Integer value2) {
            addCriterion("overdueExamineState not between", value1, value2, "overdueexaminestate");
            return (Criteria) this;
        }

        public Criteria andFullstudystateIsNull() {
            addCriterion("fullStudyState is null");
            return (Criteria) this;
        }

        public Criteria andFullstudystateIsNotNull() {
            addCriterion("fullStudyState is not null");
            return (Criteria) this;
        }

        public Criteria andFullstudystateEqualTo(Integer value) {
            addCriterion("fullStudyState =", value, "fullstudystate");
            return (Criteria) this;
        }

        public Criteria andFullstudystateNotEqualTo(Integer value) {
            addCriterion("fullStudyState <>", value, "fullstudystate");
            return (Criteria) this;
        }

        public Criteria andFullstudystateGreaterThan(Integer value) {
            addCriterion("fullStudyState >", value, "fullstudystate");
            return (Criteria) this;
        }

        public Criteria andFullstudystateGreaterThanOrEqualTo(Integer value) {
            addCriterion("fullStudyState >=", value, "fullstudystate");
            return (Criteria) this;
        }

        public Criteria andFullstudystateLessThan(Integer value) {
            addCriterion("fullStudyState <", value, "fullstudystate");
            return (Criteria) this;
        }

        public Criteria andFullstudystateLessThanOrEqualTo(Integer value) {
            addCriterion("fullStudyState <=", value, "fullstudystate");
            return (Criteria) this;
        }

        public Criteria andFullstudystateIn(List<Integer> values) {
            addCriterion("fullStudyState in", values, "fullstudystate");
            return (Criteria) this;
        }

        public Criteria andFullstudystateNotIn(List<Integer> values) {
            addCriterion("fullStudyState not in", values, "fullstudystate");
            return (Criteria) this;
        }

        public Criteria andFullstudystateBetween(Integer value1, Integer value2) {
            addCriterion("fullStudyState between", value1, value2, "fullstudystate");
            return (Criteria) this;
        }

        public Criteria andFullstudystateNotBetween(Integer value1, Integer value2) {
            addCriterion("fullStudyState not between", value1, value2, "fullstudystate");
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
     * dr_danger
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * dr_danger null
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