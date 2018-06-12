package com.ccttic.entity.enterprise;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EssEnterpriseExample {
    /**
     * ess_enterprise
     */
    protected String orderByClause;

    /**
     * ess_enterprise
     */
    protected boolean distinct;

    /**
     * ess_enterprise
     */
    protected List<Criteria> oredCriteria;

    public EssEnterpriseExample() {
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
     * ess_enterprise null
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

        public Criteria andOrgIdIsNull() {
            addCriterion("org_id is null");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNotNull() {
            addCriterion("org_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrgIdEqualTo(String value) {
            addCriterion("org_id =", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotEqualTo(String value) {
            addCriterion("org_id <>", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThan(String value) {
            addCriterion("org_id >", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("org_id >=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThan(String value) {
            addCriterion("org_id <", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThanOrEqualTo(String value) {
            addCriterion("org_id <=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLike(String value) {
            addCriterion("org_id like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotLike(String value) {
            addCriterion("org_id not like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIn(List<String> values) {
            addCriterion("org_id in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotIn(List<String> values) {
            addCriterion("org_id not in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdBetween(String value1, String value2) {
            addCriterion("org_id between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotBetween(String value1, String value2) {
            addCriterion("org_id not between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andEtpcdIsNull() {
            addCriterion("etpCd is null");
            return (Criteria) this;
        }

        public Criteria andEtpcdIsNotNull() {
            addCriterion("etpCd is not null");
            return (Criteria) this;
        }

        public Criteria andEtpcdEqualTo(String value) {
            addCriterion("etpCd =", value, "etpcd");
            return (Criteria) this;
        }

        public Criteria andEtpcdNotEqualTo(String value) {
            addCriterion("etpCd <>", value, "etpcd");
            return (Criteria) this;
        }

        public Criteria andEtpcdGreaterThan(String value) {
            addCriterion("etpCd >", value, "etpcd");
            return (Criteria) this;
        }

        public Criteria andEtpcdGreaterThanOrEqualTo(String value) {
            addCriterion("etpCd >=", value, "etpcd");
            return (Criteria) this;
        }

        public Criteria andEtpcdLessThan(String value) {
            addCriterion("etpCd <", value, "etpcd");
            return (Criteria) this;
        }

        public Criteria andEtpcdLessThanOrEqualTo(String value) {
            addCriterion("etpCd <=", value, "etpcd");
            return (Criteria) this;
        }

        public Criteria andEtpcdLike(String value) {
            addCriterion("etpCd like", value, "etpcd");
            return (Criteria) this;
        }

        public Criteria andEtpcdNotLike(String value) {
            addCriterion("etpCd not like", value, "etpcd");
            return (Criteria) this;
        }

        public Criteria andEtpcdIn(List<String> values) {
            addCriterion("etpCd in", values, "etpcd");
            return (Criteria) this;
        }

        public Criteria andEtpcdNotIn(List<String> values) {
            addCriterion("etpCd not in", values, "etpcd");
            return (Criteria) this;
        }

        public Criteria andEtpcdBetween(String value1, String value2) {
            addCriterion("etpCd between", value1, value2, "etpcd");
            return (Criteria) this;
        }

        public Criteria andEtpcdNotBetween(String value1, String value2) {
            addCriterion("etpCd not between", value1, value2, "etpcd");
            return (Criteria) this;
        }

        public Criteria andEtpnmIsNull() {
            addCriterion("etpNm is null");
            return (Criteria) this;
        }

        public Criteria andEtpnmIsNotNull() {
            addCriterion("etpNm is not null");
            return (Criteria) this;
        }

        public Criteria andEtpnmEqualTo(String value) {
            addCriterion("etpNm =", value, "etpnm");
            return (Criteria) this;
        }

        public Criteria andEtpnmNotEqualTo(String value) {
            addCriterion("etpNm <>", value, "etpnm");
            return (Criteria) this;
        }

        public Criteria andEtpnmGreaterThan(String value) {
            addCriterion("etpNm >", value, "etpnm");
            return (Criteria) this;
        }

        public Criteria andEtpnmGreaterThanOrEqualTo(String value) {
            addCriterion("etpNm >=", value, "etpnm");
            return (Criteria) this;
        }

        public Criteria andEtpnmLessThan(String value) {
            addCriterion("etpNm <", value, "etpnm");
            return (Criteria) this;
        }

        public Criteria andEtpnmLessThanOrEqualTo(String value) {
            addCriterion("etpNm <=", value, "etpnm");
            return (Criteria) this;
        }

        public Criteria andEtpnmLike(String value) {
            addCriterion("etpNm like", value, "etpnm");
            return (Criteria) this;
        }

        public Criteria andEtpnmNotLike(String value) {
            addCriterion("etpNm not like", value, "etpnm");
            return (Criteria) this;
        }

        public Criteria andEtpnmIn(List<String> values) {
            addCriterion("etpNm in", values, "etpnm");
            return (Criteria) this;
        }

        public Criteria andEtpnmNotIn(List<String> values) {
            addCriterion("etpNm not in", values, "etpnm");
            return (Criteria) this;
        }

        public Criteria andEtpnmBetween(String value1, String value2) {
            addCriterion("etpNm between", value1, value2, "etpnm");
            return (Criteria) this;
        }

        public Criteria andEtpnmNotBetween(String value1, String value2) {
            addCriterion("etpNm not between", value1, value2, "etpnm");
            return (Criteria) this;
        }

        public Criteria andEtpshortnmIsNull() {
            addCriterion("etpshortNm is null");
            return (Criteria) this;
        }

        public Criteria andEtpshortnmIsNotNull() {
            addCriterion("etpshortNm is not null");
            return (Criteria) this;
        }

        public Criteria andEtpshortnmEqualTo(String value) {
            addCriterion("etpshortNm =", value, "etpshortnm");
            return (Criteria) this;
        }

        public Criteria andEtpshortnmNotEqualTo(String value) {
            addCriterion("etpshortNm <>", value, "etpshortnm");
            return (Criteria) this;
        }

        public Criteria andEtpshortnmGreaterThan(String value) {
            addCriterion("etpshortNm >", value, "etpshortnm");
            return (Criteria) this;
        }

        public Criteria andEtpshortnmGreaterThanOrEqualTo(String value) {
            addCriterion("etpshortNm >=", value, "etpshortnm");
            return (Criteria) this;
        }

        public Criteria andEtpshortnmLessThan(String value) {
            addCriterion("etpshortNm <", value, "etpshortnm");
            return (Criteria) this;
        }

        public Criteria andEtpshortnmLessThanOrEqualTo(String value) {
            addCriterion("etpshortNm <=", value, "etpshortnm");
            return (Criteria) this;
        }

        public Criteria andEtpshortnmLike(String value) {
            addCriterion("etpshortNm like", value, "etpshortnm");
            return (Criteria) this;
        }

        public Criteria andEtpshortnmNotLike(String value) {
            addCriterion("etpshortNm not like", value, "etpshortnm");
            return (Criteria) this;
        }

        public Criteria andEtpshortnmIn(List<String> values) {
            addCriterion("etpshortNm in", values, "etpshortnm");
            return (Criteria) this;
        }

        public Criteria andEtpshortnmNotIn(List<String> values) {
            addCriterion("etpshortNm not in", values, "etpshortnm");
            return (Criteria) this;
        }

        public Criteria andEtpshortnmBetween(String value1, String value2) {
            addCriterion("etpshortNm between", value1, value2, "etpshortnm");
            return (Criteria) this;
        }

        public Criteria andEtpshortnmNotBetween(String value1, String value2) {
            addCriterion("etpshortNm not between", value1, value2, "etpshortnm");
            return (Criteria) this;
        }

        public Criteria andEtplawerIsNull() {
            addCriterion("etpLawer is null");
            return (Criteria) this;
        }

        public Criteria andEtplawerIsNotNull() {
            addCriterion("etpLawer is not null");
            return (Criteria) this;
        }

        public Criteria andEtplawerEqualTo(String value) {
            addCriterion("etpLawer =", value, "etplawer");
            return (Criteria) this;
        }

        public Criteria andEtplawerNotEqualTo(String value) {
            addCriterion("etpLawer <>", value, "etplawer");
            return (Criteria) this;
        }

        public Criteria andEtplawerGreaterThan(String value) {
            addCriterion("etpLawer >", value, "etplawer");
            return (Criteria) this;
        }

        public Criteria andEtplawerGreaterThanOrEqualTo(String value) {
            addCriterion("etpLawer >=", value, "etplawer");
            return (Criteria) this;
        }

        public Criteria andEtplawerLessThan(String value) {
            addCriterion("etpLawer <", value, "etplawer");
            return (Criteria) this;
        }

        public Criteria andEtplawerLessThanOrEqualTo(String value) {
            addCriterion("etpLawer <=", value, "etplawer");
            return (Criteria) this;
        }

        public Criteria andEtplawerLike(String value) {
            addCriterion("etpLawer like", value, "etplawer");
            return (Criteria) this;
        }

        public Criteria andEtplawerNotLike(String value) {
            addCriterion("etpLawer not like", value, "etplawer");
            return (Criteria) this;
        }

        public Criteria andEtplawerIn(List<String> values) {
            addCriterion("etpLawer in", values, "etplawer");
            return (Criteria) this;
        }

        public Criteria andEtplawerNotIn(List<String> values) {
            addCriterion("etpLawer not in", values, "etplawer");
            return (Criteria) this;
        }

        public Criteria andEtplawerBetween(String value1, String value2) {
            addCriterion("etpLawer between", value1, value2, "etplawer");
            return (Criteria) this;
        }

        public Criteria andEtplawerNotBetween(String value1, String value2) {
            addCriterion("etpLawer not between", value1, value2, "etplawer");
            return (Criteria) this;
        }

        public Criteria andLawertelIsNull() {
            addCriterion("lawerTel is null");
            return (Criteria) this;
        }

        public Criteria andLawertelIsNotNull() {
            addCriterion("lawerTel is not null");
            return (Criteria) this;
        }

        public Criteria andLawertelEqualTo(String value) {
            addCriterion("lawerTel =", value, "lawertel");
            return (Criteria) this;
        }

        public Criteria andLawertelNotEqualTo(String value) {
            addCriterion("lawerTel <>", value, "lawertel");
            return (Criteria) this;
        }

        public Criteria andLawertelGreaterThan(String value) {
            addCriterion("lawerTel >", value, "lawertel");
            return (Criteria) this;
        }

        public Criteria andLawertelGreaterThanOrEqualTo(String value) {
            addCriterion("lawerTel >=", value, "lawertel");
            return (Criteria) this;
        }

        public Criteria andLawertelLessThan(String value) {
            addCriterion("lawerTel <", value, "lawertel");
            return (Criteria) this;
        }

        public Criteria andLawertelLessThanOrEqualTo(String value) {
            addCriterion("lawerTel <=", value, "lawertel");
            return (Criteria) this;
        }

        public Criteria andLawertelLike(String value) {
            addCriterion("lawerTel like", value, "lawertel");
            return (Criteria) this;
        }

        public Criteria andLawertelNotLike(String value) {
            addCriterion("lawerTel not like", value, "lawertel");
            return (Criteria) this;
        }

        public Criteria andLawertelIn(List<String> values) {
            addCriterion("lawerTel in", values, "lawertel");
            return (Criteria) this;
        }

        public Criteria andLawertelNotIn(List<String> values) {
            addCriterion("lawerTel not in", values, "lawertel");
            return (Criteria) this;
        }

        public Criteria andLawertelBetween(String value1, String value2) {
            addCriterion("lawerTel between", value1, value2, "lawertel");
            return (Criteria) this;
        }

        public Criteria andLawertelNotBetween(String value1, String value2) {
            addCriterion("lawerTel not between", value1, value2, "lawertel");
            return (Criteria) this;
        }

        public Criteria andEtpsaferIsNull() {
            addCriterion("etpSafer is null");
            return (Criteria) this;
        }

        public Criteria andEtpsaferIsNotNull() {
            addCriterion("etpSafer is not null");
            return (Criteria) this;
        }

        public Criteria andEtpsaferEqualTo(String value) {
            addCriterion("etpSafer =", value, "etpsafer");
            return (Criteria) this;
        }

        public Criteria andEtpsaferNotEqualTo(String value) {
            addCriterion("etpSafer <>", value, "etpsafer");
            return (Criteria) this;
        }

        public Criteria andEtpsaferGreaterThan(String value) {
            addCriterion("etpSafer >", value, "etpsafer");
            return (Criteria) this;
        }

        public Criteria andEtpsaferGreaterThanOrEqualTo(String value) {
            addCriterion("etpSafer >=", value, "etpsafer");
            return (Criteria) this;
        }

        public Criteria andEtpsaferLessThan(String value) {
            addCriterion("etpSafer <", value, "etpsafer");
            return (Criteria) this;
        }

        public Criteria andEtpsaferLessThanOrEqualTo(String value) {
            addCriterion("etpSafer <=", value, "etpsafer");
            return (Criteria) this;
        }

        public Criteria andEtpsaferLike(String value) {
            addCriterion("etpSafer like", value, "etpsafer");
            return (Criteria) this;
        }

        public Criteria andEtpsaferNotLike(String value) {
            addCriterion("etpSafer not like", value, "etpsafer");
            return (Criteria) this;
        }

        public Criteria andEtpsaferIn(List<String> values) {
            addCriterion("etpSafer in", values, "etpsafer");
            return (Criteria) this;
        }

        public Criteria andEtpsaferNotIn(List<String> values) {
            addCriterion("etpSafer not in", values, "etpsafer");
            return (Criteria) this;
        }

        public Criteria andEtpsaferBetween(String value1, String value2) {
            addCriterion("etpSafer between", value1, value2, "etpsafer");
            return (Criteria) this;
        }

        public Criteria andEtpsaferNotBetween(String value1, String value2) {
            addCriterion("etpSafer not between", value1, value2, "etpsafer");
            return (Criteria) this;
        }

        public Criteria andSafertelIsNull() {
            addCriterion("saferTel is null");
            return (Criteria) this;
        }

        public Criteria andSafertelIsNotNull() {
            addCriterion("saferTel is not null");
            return (Criteria) this;
        }

        public Criteria andSafertelEqualTo(String value) {
            addCriterion("saferTel =", value, "safertel");
            return (Criteria) this;
        }

        public Criteria andSafertelNotEqualTo(String value) {
            addCriterion("saferTel <>", value, "safertel");
            return (Criteria) this;
        }

        public Criteria andSafertelGreaterThan(String value) {
            addCriterion("saferTel >", value, "safertel");
            return (Criteria) this;
        }

        public Criteria andSafertelGreaterThanOrEqualTo(String value) {
            addCriterion("saferTel >=", value, "safertel");
            return (Criteria) this;
        }

        public Criteria andSafertelLessThan(String value) {
            addCriterion("saferTel <", value, "safertel");
            return (Criteria) this;
        }

        public Criteria andSafertelLessThanOrEqualTo(String value) {
            addCriterion("saferTel <=", value, "safertel");
            return (Criteria) this;
        }

        public Criteria andSafertelLike(String value) {
            addCriterion("saferTel like", value, "safertel");
            return (Criteria) this;
        }

        public Criteria andSafertelNotLike(String value) {
            addCriterion("saferTel not like", value, "safertel");
            return (Criteria) this;
        }

        public Criteria andSafertelIn(List<String> values) {
            addCriterion("saferTel in", values, "safertel");
            return (Criteria) this;
        }

        public Criteria andSafertelNotIn(List<String> values) {
            addCriterion("saferTel not in", values, "safertel");
            return (Criteria) this;
        }

        public Criteria andSafertelBetween(String value1, String value2) {
            addCriterion("saferTel between", value1, value2, "safertel");
            return (Criteria) this;
        }

        public Criteria andSafertelNotBetween(String value1, String value2) {
            addCriterion("saferTel not between", value1, value2, "safertel");
            return (Criteria) this;
        }

        public Criteria andAdminEmpidIsNull() {
            addCriterion("admin_empid is null");
            return (Criteria) this;
        }

        public Criteria andAdminEmpidIsNotNull() {
            addCriterion("admin_empid is not null");
            return (Criteria) this;
        }

        public Criteria andAdminEmpidEqualTo(String value) {
            addCriterion("admin_empid =", value, "adminEmpid");
            return (Criteria) this;
        }

        public Criteria andAdminEmpidNotEqualTo(String value) {
            addCriterion("admin_empid <>", value, "adminEmpid");
            return (Criteria) this;
        }

        public Criteria andAdminEmpidGreaterThan(String value) {
            addCriterion("admin_empid >", value, "adminEmpid");
            return (Criteria) this;
        }

        public Criteria andAdminEmpidGreaterThanOrEqualTo(String value) {
            addCriterion("admin_empid >=", value, "adminEmpid");
            return (Criteria) this;
        }

        public Criteria andAdminEmpidLessThan(String value) {
            addCriterion("admin_empid <", value, "adminEmpid");
            return (Criteria) this;
        }

        public Criteria andAdminEmpidLessThanOrEqualTo(String value) {
            addCriterion("admin_empid <=", value, "adminEmpid");
            return (Criteria) this;
        }

        public Criteria andAdminEmpidLike(String value) {
            addCriterion("admin_empid like", value, "adminEmpid");
            return (Criteria) this;
        }

        public Criteria andAdminEmpidNotLike(String value) {
            addCriterion("admin_empid not like", value, "adminEmpid");
            return (Criteria) this;
        }

        public Criteria andAdminEmpidIn(List<String> values) {
            addCriterion("admin_empid in", values, "adminEmpid");
            return (Criteria) this;
        }

        public Criteria andAdminEmpidNotIn(List<String> values) {
            addCriterion("admin_empid not in", values, "adminEmpid");
            return (Criteria) this;
        }

        public Criteria andAdminEmpidBetween(String value1, String value2) {
            addCriterion("admin_empid between", value1, value2, "adminEmpid");
            return (Criteria) this;
        }

        public Criteria andAdminEmpidNotBetween(String value1, String value2) {
            addCriterion("admin_empid not between", value1, value2, "adminEmpid");
            return (Criteria) this;
        }

        public Criteria andOwnertrafficIsNull() {
            addCriterion("ownerTraffic is null");
            return (Criteria) this;
        }

        public Criteria andOwnertrafficIsNotNull() {
            addCriterion("ownerTraffic is not null");
            return (Criteria) this;
        }

        public Criteria andOwnertrafficEqualTo(String value) {
            addCriterion("ownerTraffic =", value, "ownertraffic");
            return (Criteria) this;
        }

        public Criteria andOwnertrafficNotEqualTo(String value) {
            addCriterion("ownerTraffic <>", value, "ownertraffic");
            return (Criteria) this;
        }

        public Criteria andOwnertrafficGreaterThan(String value) {
            addCriterion("ownerTraffic >", value, "ownertraffic");
            return (Criteria) this;
        }

        public Criteria andOwnertrafficGreaterThanOrEqualTo(String value) {
            addCriterion("ownerTraffic >=", value, "ownertraffic");
            return (Criteria) this;
        }

        public Criteria andOwnertrafficLessThan(String value) {
            addCriterion("ownerTraffic <", value, "ownertraffic");
            return (Criteria) this;
        }

        public Criteria andOwnertrafficLessThanOrEqualTo(String value) {
            addCriterion("ownerTraffic <=", value, "ownertraffic");
            return (Criteria) this;
        }

        public Criteria andOwnertrafficLike(String value) {
            addCriterion("ownerTraffic like", value, "ownertraffic");
            return (Criteria) this;
        }

        public Criteria andOwnertrafficNotLike(String value) {
            addCriterion("ownerTraffic not like", value, "ownertraffic");
            return (Criteria) this;
        }

        public Criteria andOwnertrafficIn(List<String> values) {
            addCriterion("ownerTraffic in", values, "ownertraffic");
            return (Criteria) this;
        }

        public Criteria andOwnertrafficNotIn(List<String> values) {
            addCriterion("ownerTraffic not in", values, "ownertraffic");
            return (Criteria) this;
        }

        public Criteria andOwnertrafficBetween(String value1, String value2) {
            addCriterion("ownerTraffic between", value1, value2, "ownertraffic");
            return (Criteria) this;
        }

        public Criteria andOwnertrafficNotBetween(String value1, String value2) {
            addCriterion("ownerTraffic not between", value1, value2, "ownertraffic");
            return (Criteria) this;
        }

        public Criteria andOwnertransportIsNull() {
            addCriterion("ownerTransport is null");
            return (Criteria) this;
        }

        public Criteria andOwnertransportIsNotNull() {
            addCriterion("ownerTransport is not null");
            return (Criteria) this;
        }

        public Criteria andOwnertransportEqualTo(String value) {
            addCriterion("ownerTransport =", value, "ownertransport");
            return (Criteria) this;
        }

        public Criteria andOwnertransportNotEqualTo(String value) {
            addCriterion("ownerTransport <>", value, "ownertransport");
            return (Criteria) this;
        }

        public Criteria andOwnertransportGreaterThan(String value) {
            addCriterion("ownerTransport >", value, "ownertransport");
            return (Criteria) this;
        }

        public Criteria andOwnertransportGreaterThanOrEqualTo(String value) {
            addCriterion("ownerTransport >=", value, "ownertransport");
            return (Criteria) this;
        }

        public Criteria andOwnertransportLessThan(String value) {
            addCriterion("ownerTransport <", value, "ownertransport");
            return (Criteria) this;
        }

        public Criteria andOwnertransportLessThanOrEqualTo(String value) {
            addCriterion("ownerTransport <=", value, "ownertransport");
            return (Criteria) this;
        }

        public Criteria andOwnertransportLike(String value) {
            addCriterion("ownerTransport like", value, "ownertransport");
            return (Criteria) this;
        }

        public Criteria andOwnertransportNotLike(String value) {
            addCriterion("ownerTransport not like", value, "ownertransport");
            return (Criteria) this;
        }

        public Criteria andOwnertransportIn(List<String> values) {
            addCriterion("ownerTransport in", values, "ownertransport");
            return (Criteria) this;
        }

        public Criteria andOwnertransportNotIn(List<String> values) {
            addCriterion("ownerTransport not in", values, "ownertransport");
            return (Criteria) this;
        }

        public Criteria andOwnertransportBetween(String value1, String value2) {
            addCriterion("ownerTransport between", value1, value2, "ownertransport");
            return (Criteria) this;
        }

        public Criteria andOwnertransportNotBetween(String value1, String value2) {
            addCriterion("ownerTransport not between", value1, value2, "ownertransport");
            return (Criteria) this;
        }

        public Criteria andEtpadressIsNull() {
            addCriterion("etpAdress is null");
            return (Criteria) this;
        }

        public Criteria andEtpadressIsNotNull() {
            addCriterion("etpAdress is not null");
            return (Criteria) this;
        }

        public Criteria andEtpadressEqualTo(String value) {
            addCriterion("etpAdress =", value, "etpadress");
            return (Criteria) this;
        }

        public Criteria andEtpadressNotEqualTo(String value) {
            addCriterion("etpAdress <>", value, "etpadress");
            return (Criteria) this;
        }

        public Criteria andEtpadressGreaterThan(String value) {
            addCriterion("etpAdress >", value, "etpadress");
            return (Criteria) this;
        }

        public Criteria andEtpadressGreaterThanOrEqualTo(String value) {
            addCriterion("etpAdress >=", value, "etpadress");
            return (Criteria) this;
        }

        public Criteria andEtpadressLessThan(String value) {
            addCriterion("etpAdress <", value, "etpadress");
            return (Criteria) this;
        }

        public Criteria andEtpadressLessThanOrEqualTo(String value) {
            addCriterion("etpAdress <=", value, "etpadress");
            return (Criteria) this;
        }

        public Criteria andEtpadressLike(String value) {
            addCriterion("etpAdress like", value, "etpadress");
            return (Criteria) this;
        }

        public Criteria andEtpadressNotLike(String value) {
            addCriterion("etpAdress not like", value, "etpadress");
            return (Criteria) this;
        }

        public Criteria andEtpadressIn(List<String> values) {
            addCriterion("etpAdress in", values, "etpadress");
            return (Criteria) this;
        }

        public Criteria andEtpadressNotIn(List<String> values) {
            addCriterion("etpAdress not in", values, "etpadress");
            return (Criteria) this;
        }

        public Criteria andEtpadressBetween(String value1, String value2) {
            addCriterion("etpAdress between", value1, value2, "etpadress");
            return (Criteria) this;
        }

        public Criteria andEtpadressNotBetween(String value1, String value2) {
            addCriterion("etpAdress not between", value1, value2, "etpadress");
            return (Criteria) this;
        }

        public Criteria andEtpregadressIsNull() {
            addCriterion("etpRegAdress is null");
            return (Criteria) this;
        }

        public Criteria andEtpregadressIsNotNull() {
            addCriterion("etpRegAdress is not null");
            return (Criteria) this;
        }

        public Criteria andEtpregadressEqualTo(String value) {
            addCriterion("etpRegAdress =", value, "etpregadress");
            return (Criteria) this;
        }

        public Criteria andEtpregadressNotEqualTo(String value) {
            addCriterion("etpRegAdress <>", value, "etpregadress");
            return (Criteria) this;
        }

        public Criteria andEtpregadressGreaterThan(String value) {
            addCriterion("etpRegAdress >", value, "etpregadress");
            return (Criteria) this;
        }

        public Criteria andEtpregadressGreaterThanOrEqualTo(String value) {
            addCriterion("etpRegAdress >=", value, "etpregadress");
            return (Criteria) this;
        }

        public Criteria andEtpregadressLessThan(String value) {
            addCriterion("etpRegAdress <", value, "etpregadress");
            return (Criteria) this;
        }

        public Criteria andEtpregadressLessThanOrEqualTo(String value) {
            addCriterion("etpRegAdress <=", value, "etpregadress");
            return (Criteria) this;
        }

        public Criteria andEtpregadressLike(String value) {
            addCriterion("etpRegAdress like", value, "etpregadress");
            return (Criteria) this;
        }

        public Criteria andEtpregadressNotLike(String value) {
            addCriterion("etpRegAdress not like", value, "etpregadress");
            return (Criteria) this;
        }

        public Criteria andEtpregadressIn(List<String> values) {
            addCriterion("etpRegAdress in", values, "etpregadress");
            return (Criteria) this;
        }

        public Criteria andEtpregadressNotIn(List<String> values) {
            addCriterion("etpRegAdress not in", values, "etpregadress");
            return (Criteria) this;
        }

        public Criteria andEtpregadressBetween(String value1, String value2) {
            addCriterion("etpRegAdress between", value1, value2, "etpregadress");
            return (Criteria) this;
        }

        public Criteria andEtpregadressNotBetween(String value1, String value2) {
            addCriterion("etpRegAdress not between", value1, value2, "etpregadress");
            return (Criteria) this;
        }

        public Criteria andEtptelIsNull() {
            addCriterion("etpTel is null");
            return (Criteria) this;
        }

        public Criteria andEtptelIsNotNull() {
            addCriterion("etpTel is not null");
            return (Criteria) this;
        }

        public Criteria andEtptelEqualTo(String value) {
            addCriterion("etpTel =", value, "etptel");
            return (Criteria) this;
        }

        public Criteria andEtptelNotEqualTo(String value) {
            addCriterion("etpTel <>", value, "etptel");
            return (Criteria) this;
        }

        public Criteria andEtptelGreaterThan(String value) {
            addCriterion("etpTel >", value, "etptel");
            return (Criteria) this;
        }

        public Criteria andEtptelGreaterThanOrEqualTo(String value) {
            addCriterion("etpTel >=", value, "etptel");
            return (Criteria) this;
        }

        public Criteria andEtptelLessThan(String value) {
            addCriterion("etpTel <", value, "etptel");
            return (Criteria) this;
        }

        public Criteria andEtptelLessThanOrEqualTo(String value) {
            addCriterion("etpTel <=", value, "etptel");
            return (Criteria) this;
        }

        public Criteria andEtptelLike(String value) {
            addCriterion("etpTel like", value, "etptel");
            return (Criteria) this;
        }

        public Criteria andEtptelNotLike(String value) {
            addCriterion("etpTel not like", value, "etptel");
            return (Criteria) this;
        }

        public Criteria andEtptelIn(List<String> values) {
            addCriterion("etpTel in", values, "etptel");
            return (Criteria) this;
        }

        public Criteria andEtptelNotIn(List<String> values) {
            addCriterion("etpTel not in", values, "etptel");
            return (Criteria) this;
        }

        public Criteria andEtptelBetween(String value1, String value2) {
            addCriterion("etpTel between", value1, value2, "etptel");
            return (Criteria) this;
        }

        public Criteria andEtptelNotBetween(String value1, String value2) {
            addCriterion("etpTel not between", value1, value2, "etptel");
            return (Criteria) this;
        }

        public Criteria andAttachmentIdIsNull() {
            addCriterion("attachment_id is null");
            return (Criteria) this;
        }

        public Criteria andAttachmentIdIsNotNull() {
            addCriterion("attachment_id is not null");
            return (Criteria) this;
        }

        public Criteria andAttachmentIdEqualTo(String value) {
            addCriterion("attachment_id =", value, "attachmentId");
            return (Criteria) this;
        }

        public Criteria andAttachmentIdNotEqualTo(String value) {
            addCriterion("attachment_id <>", value, "attachmentId");
            return (Criteria) this;
        }

        public Criteria andAttachmentIdGreaterThan(String value) {
            addCriterion("attachment_id >", value, "attachmentId");
            return (Criteria) this;
        }

        public Criteria andAttachmentIdGreaterThanOrEqualTo(String value) {
            addCriterion("attachment_id >=", value, "attachmentId");
            return (Criteria) this;
        }

        public Criteria andAttachmentIdLessThan(String value) {
            addCriterion("attachment_id <", value, "attachmentId");
            return (Criteria) this;
        }

        public Criteria andAttachmentIdLessThanOrEqualTo(String value) {
            addCriterion("attachment_id <=", value, "attachmentId");
            return (Criteria) this;
        }

        public Criteria andAttachmentIdLike(String value) {
            addCriterion("attachment_id like", value, "attachmentId");
            return (Criteria) this;
        }

        public Criteria andAttachmentIdNotLike(String value) {
            addCriterion("attachment_id not like", value, "attachmentId");
            return (Criteria) this;
        }

        public Criteria andAttachmentIdIn(List<String> values) {
            addCriterion("attachment_id in", values, "attachmentId");
            return (Criteria) this;
        }

        public Criteria andAttachmentIdNotIn(List<String> values) {
            addCriterion("attachment_id not in", values, "attachmentId");
            return (Criteria) this;
        }

        public Criteria andAttachmentIdBetween(String value1, String value2) {
            addCriterion("attachment_id between", value1, value2, "attachmentId");
            return (Criteria) this;
        }

        public Criteria andAttachmentIdNotBetween(String value1, String value2) {
            addCriterion("attachment_id not between", value1, value2, "attachmentId");
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

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
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

        public Criteria andDisporderIsNull() {
            addCriterion("dispOrder is null");
            return (Criteria) this;
        }

        public Criteria andDisporderIsNotNull() {
            addCriterion("dispOrder is not null");
            return (Criteria) this;
        }

        public Criteria andDisporderEqualTo(Integer value) {
            addCriterion("dispOrder =", value, "disporder");
            return (Criteria) this;
        }

        public Criteria andDisporderNotEqualTo(Integer value) {
            addCriterion("dispOrder <>", value, "disporder");
            return (Criteria) this;
        }

        public Criteria andDisporderGreaterThan(Integer value) {
            addCriterion("dispOrder >", value, "disporder");
            return (Criteria) this;
        }

        public Criteria andDisporderGreaterThanOrEqualTo(Integer value) {
            addCriterion("dispOrder >=", value, "disporder");
            return (Criteria) this;
        }

        public Criteria andDisporderLessThan(Integer value) {
            addCriterion("dispOrder <", value, "disporder");
            return (Criteria) this;
        }

        public Criteria andDisporderLessThanOrEqualTo(Integer value) {
            addCriterion("dispOrder <=", value, "disporder");
            return (Criteria) this;
        }

        public Criteria andDisporderIn(List<Integer> values) {
            addCriterion("dispOrder in", values, "disporder");
            return (Criteria) this;
        }

        public Criteria andDisporderNotIn(List<Integer> values) {
            addCriterion("dispOrder not in", values, "disporder");
            return (Criteria) this;
        }

        public Criteria andDisporderBetween(Integer value1, Integer value2) {
            addCriterion("dispOrder between", value1, value2, "disporder");
            return (Criteria) this;
        }

        public Criteria andDisporderNotBetween(Integer value1, Integer value2) {
            addCriterion("dispOrder not between", value1, value2, "disporder");
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
     * ess_enterprise
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * ess_enterprise null
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