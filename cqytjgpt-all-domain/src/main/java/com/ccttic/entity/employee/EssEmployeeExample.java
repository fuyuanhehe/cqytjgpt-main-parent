package com.ccttic.entity.employee;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EssEmployeeExample {
    /**
     * ess_employee
     */
    protected String orderByClause;

    /**
     * ess_employee
     */
    protected boolean distinct;

    /**
     * ess_employee
     */
    protected List<Criteria> oredCriteria;

    public EssEmployeeExample() {
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
     * ess_employee null
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

        public Criteria andEmpcdIsNull() {
            addCriterion("empCd is null");
            return (Criteria) this;
        }

        public Criteria andEmpcdIsNotNull() {
            addCriterion("empCd is not null");
            return (Criteria) this;
        }

        public Criteria andEmpcdEqualTo(String value) {
            addCriterion("empCd =", value, "empcd");
            return (Criteria) this;
        }

        public Criteria andEmpcdNotEqualTo(String value) {
            addCriterion("empCd <>", value, "empcd");
            return (Criteria) this;
        }

        public Criteria andEmpcdGreaterThan(String value) {
            addCriterion("empCd >", value, "empcd");
            return (Criteria) this;
        }

        public Criteria andEmpcdGreaterThanOrEqualTo(String value) {
            addCriterion("empCd >=", value, "empcd");
            return (Criteria) this;
        }

        public Criteria andEmpcdLessThan(String value) {
            addCriterion("empCd <", value, "empcd");
            return (Criteria) this;
        }

        public Criteria andEmpcdLessThanOrEqualTo(String value) {
            addCriterion("empCd <=", value, "empcd");
            return (Criteria) this;
        }

        public Criteria andEmpcdLike(String value) {
            addCriterion("empCd like", value, "empcd");
            return (Criteria) this;
        }

        public Criteria andEmpcdNotLike(String value) {
            addCriterion("empCd not like", value, "empcd");
            return (Criteria) this;
        }

        public Criteria andEmpcdIn(List<String> values) {
            addCriterion("empCd in", values, "empcd");
            return (Criteria) this;
        }

        public Criteria andEmpcdNotIn(List<String> values) {
            addCriterion("empCd not in", values, "empcd");
            return (Criteria) this;
        }

        public Criteria andEmpcdBetween(String value1, String value2) {
            addCriterion("empCd between", value1, value2, "empcd");
            return (Criteria) this;
        }

        public Criteria andEmpcdNotBetween(String value1, String value2) {
            addCriterion("empCd not between", value1, value2, "empcd");
            return (Criteria) this;
        }

        public Criteria andEmpnmIsNull() {
            addCriterion("empNm is null");
            return (Criteria) this;
        }

        public Criteria andEmpnmIsNotNull() {
            addCriterion("empNm is not null");
            return (Criteria) this;
        }

        public Criteria andEmpnmEqualTo(String value) {
            addCriterion("empNm =", value, "empnm");
            return (Criteria) this;
        }

        public Criteria andEmpnmNotEqualTo(String value) {
            addCriterion("empNm <>", value, "empnm");
            return (Criteria) this;
        }

        public Criteria andEmpnmGreaterThan(String value) {
            addCriterion("empNm >", value, "empnm");
            return (Criteria) this;
        }

        public Criteria andEmpnmGreaterThanOrEqualTo(String value) {
            addCriterion("empNm >=", value, "empnm");
            return (Criteria) this;
        }

        public Criteria andEmpnmLessThan(String value) {
            addCriterion("empNm <", value, "empnm");
            return (Criteria) this;
        }

        public Criteria andEmpnmLessThanOrEqualTo(String value) {
            addCriterion("empNm <=", value, "empnm");
            return (Criteria) this;
        }

        public Criteria andEmpnmLike(String value) {
            addCriterion("empNm like", value, "empnm");
            return (Criteria) this;
        }

        public Criteria andEmpnmNotLike(String value) {
            addCriterion("empNm not like", value, "empnm");
            return (Criteria) this;
        }

        public Criteria andEmpnmIn(List<String> values) {
            addCriterion("empNm in", values, "empnm");
            return (Criteria) this;
        }

        public Criteria andEmpnmNotIn(List<String> values) {
            addCriterion("empNm not in", values, "empnm");
            return (Criteria) this;
        }

        public Criteria andEmpnmBetween(String value1, String value2) {
            addCriterion("empNm between", value1, value2, "empnm");
            return (Criteria) this;
        }

        public Criteria andEmpnmNotBetween(String value1, String value2) {
            addCriterion("empNm not between", value1, value2, "empnm");
            return (Criteria) this;
        }

        public Criteria andEmpnoIsNull() {
            addCriterion("empNo is null");
            return (Criteria) this;
        }

        public Criteria andEmpnoIsNotNull() {
            addCriterion("empNo is not null");
            return (Criteria) this;
        }

        public Criteria andEmpnoEqualTo(String value) {
            addCriterion("empNo =", value, "empno");
            return (Criteria) this;
        }

        public Criteria andEmpnoNotEqualTo(String value) {
            addCriterion("empNo <>", value, "empno");
            return (Criteria) this;
        }

        public Criteria andEmpnoGreaterThan(String value) {
            addCriterion("empNo >", value, "empno");
            return (Criteria) this;
        }

        public Criteria andEmpnoGreaterThanOrEqualTo(String value) {
            addCriterion("empNo >=", value, "empno");
            return (Criteria) this;
        }

        public Criteria andEmpnoLessThan(String value) {
            addCriterion("empNo <", value, "empno");
            return (Criteria) this;
        }

        public Criteria andEmpnoLessThanOrEqualTo(String value) {
            addCriterion("empNo <=", value, "empno");
            return (Criteria) this;
        }

        public Criteria andEmpnoLike(String value) {
            addCriterion("empNo like", value, "empno");
            return (Criteria) this;
        }

        public Criteria andEmpnoNotLike(String value) {
            addCriterion("empNo not like", value, "empno");
            return (Criteria) this;
        }

        public Criteria andEmpnoIn(List<String> values) {
            addCriterion("empNo in", values, "empno");
            return (Criteria) this;
        }

        public Criteria andEmpnoNotIn(List<String> values) {
            addCriterion("empNo not in", values, "empno");
            return (Criteria) this;
        }

        public Criteria andEmpnoBetween(String value1, String value2) {
            addCriterion("empNo between", value1, value2, "empno");
            return (Criteria) this;
        }

        public Criteria andEmpnoNotBetween(String value1, String value2) {
            addCriterion("empNo not between", value1, value2, "empno");
            return (Criteria) this;
        }

        public Criteria andDutyIsNull() {
            addCriterion("duty is null");
            return (Criteria) this;
        }

        public Criteria andDutyIsNotNull() {
            addCriterion("duty is not null");
            return (Criteria) this;
        }

        public Criteria andDutyEqualTo(String value) {
            addCriterion("duty =", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyNotEqualTo(String value) {
            addCriterion("duty <>", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyGreaterThan(String value) {
            addCriterion("duty >", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyGreaterThanOrEqualTo(String value) {
            addCriterion("duty >=", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyLessThan(String value) {
            addCriterion("duty <", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyLessThanOrEqualTo(String value) {
            addCriterion("duty <=", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyLike(String value) {
            addCriterion("duty like", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyNotLike(String value) {
            addCriterion("duty not like", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyIn(List<String> values) {
            addCriterion("duty in", values, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyNotIn(List<String> values) {
            addCriterion("duty not in", values, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyBetween(String value1, String value2) {
            addCriterion("duty between", value1, value2, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyNotBetween(String value1, String value2) {
            addCriterion("duty not between", value1, value2, "duty");
            return (Criteria) this;
        }

        public Criteria andEmpgenderIsNull() {
            addCriterion("empGender is null");
            return (Criteria) this;
        }

        public Criteria andEmpgenderIsNotNull() {
            addCriterion("empGender is not null");
            return (Criteria) this;
        }

        public Criteria andEmpgenderEqualTo(String value) {
            addCriterion("empGender =", value, "empgender");
            return (Criteria) this;
        }

        public Criteria andEmpgenderNotEqualTo(String value) {
            addCriterion("empGender <>", value, "empgender");
            return (Criteria) this;
        }

        public Criteria andEmpgenderGreaterThan(String value) {
            addCriterion("empGender >", value, "empgender");
            return (Criteria) this;
        }

        public Criteria andEmpgenderGreaterThanOrEqualTo(String value) {
            addCriterion("empGender >=", value, "empgender");
            return (Criteria) this;
        }

        public Criteria andEmpgenderLessThan(String value) {
            addCriterion("empGender <", value, "empgender");
            return (Criteria) this;
        }

        public Criteria andEmpgenderLessThanOrEqualTo(String value) {
            addCriterion("empGender <=", value, "empgender");
            return (Criteria) this;
        }

        public Criteria andEmpgenderLike(String value) {
            addCriterion("empGender like", value, "empgender");
            return (Criteria) this;
        }

        public Criteria andEmpgenderNotLike(String value) {
            addCriterion("empGender not like", value, "empgender");
            return (Criteria) this;
        }

        public Criteria andEmpgenderIn(List<String> values) {
            addCriterion("empGender in", values, "empgender");
            return (Criteria) this;
        }

        public Criteria andEmpgenderNotIn(List<String> values) {
            addCriterion("empGender not in", values, "empgender");
            return (Criteria) this;
        }

        public Criteria andEmpgenderBetween(String value1, String value2) {
            addCriterion("empGender between", value1, value2, "empgender");
            return (Criteria) this;
        }

        public Criteria andEmpgenderNotBetween(String value1, String value2) {
            addCriterion("empGender not between", value1, value2, "empgender");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andEntrydateIsNull() {
            addCriterion("entryDate is null");
            return (Criteria) this;
        }

        public Criteria andEntrydateIsNotNull() {
            addCriterion("entryDate is not null");
            return (Criteria) this;
        }

        public Criteria andEntrydateEqualTo(Date value) {
            addCriterionForJDBCDate("entryDate =", value, "entrydate");
            return (Criteria) this;
        }

        public Criteria andEntrydateNotEqualTo(Date value) {
            addCriterionForJDBCDate("entryDate <>", value, "entrydate");
            return (Criteria) this;
        }

        public Criteria andEntrydateGreaterThan(Date value) {
            addCriterionForJDBCDate("entryDate >", value, "entrydate");
            return (Criteria) this;
        }

        public Criteria andEntrydateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("entryDate >=", value, "entrydate");
            return (Criteria) this;
        }

        public Criteria andEntrydateLessThan(Date value) {
            addCriterionForJDBCDate("entryDate <", value, "entrydate");
            return (Criteria) this;
        }

        public Criteria andEntrydateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("entryDate <=", value, "entrydate");
            return (Criteria) this;
        }

        public Criteria andEntrydateIn(List<Date> values) {
            addCriterionForJDBCDate("entryDate in", values, "entrydate");
            return (Criteria) this;
        }

        public Criteria andEntrydateNotIn(List<Date> values) {
            addCriterionForJDBCDate("entryDate not in", values, "entrydate");
            return (Criteria) this;
        }

        public Criteria andEntrydateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("entryDate between", value1, value2, "entrydate");
            return (Criteria) this;
        }

        public Criteria andEntrydateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("entryDate not between", value1, value2, "entrydate");
            return (Criteria) this;
        }

        public Criteria andLeavedateIsNull() {
            addCriterion("leaveDate is null");
            return (Criteria) this;
        }

        public Criteria andLeavedateIsNotNull() {
            addCriterion("leaveDate is not null");
            return (Criteria) this;
        }

        public Criteria andLeavedateEqualTo(Date value) {
            addCriterionForJDBCDate("leaveDate =", value, "leavedate");
            return (Criteria) this;
        }

        public Criteria andLeavedateNotEqualTo(Date value) {
            addCriterionForJDBCDate("leaveDate <>", value, "leavedate");
            return (Criteria) this;
        }

        public Criteria andLeavedateGreaterThan(Date value) {
            addCriterionForJDBCDate("leaveDate >", value, "leavedate");
            return (Criteria) this;
        }

        public Criteria andLeavedateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("leaveDate >=", value, "leavedate");
            return (Criteria) this;
        }

        public Criteria andLeavedateLessThan(Date value) {
            addCriterionForJDBCDate("leaveDate <", value, "leavedate");
            return (Criteria) this;
        }

        public Criteria andLeavedateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("leaveDate <=", value, "leavedate");
            return (Criteria) this;
        }

        public Criteria andLeavedateIn(List<Date> values) {
            addCriterionForJDBCDate("leaveDate in", values, "leavedate");
            return (Criteria) this;
        }

        public Criteria andLeavedateNotIn(List<Date> values) {
            addCriterionForJDBCDate("leaveDate not in", values, "leavedate");
            return (Criteria) this;
        }

        public Criteria andLeavedateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("leaveDate between", value1, value2, "leavedate");
            return (Criteria) this;
        }

        public Criteria andLeavedateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("leaveDate not between", value1, value2, "leavedate");
            return (Criteria) this;
        }

        public Criteria andAccountIsNull() {
            addCriterion("account is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("account is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(String value) {
            addCriterion("account =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(String value) {
            addCriterion("account <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(String value) {
            addCriterion("account >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(String value) {
            addCriterion("account >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(String value) {
            addCriterion("account <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(String value) {
            addCriterion("account <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLike(String value) {
            addCriterion("account like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotLike(String value) {
            addCriterion("account not like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(List<String> values) {
            addCriterion("account in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(List<String> values) {
            addCriterion("account not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(String value1, String value2) {
            addCriterion("account between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(String value1, String value2) {
            addCriterion("account not between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andEmpstatusIsNull() {
            addCriterion("empStatus is null");
            return (Criteria) this;
        }

        public Criteria andEmpstatusIsNotNull() {
            addCriterion("empStatus is not null");
            return (Criteria) this;
        }

        public Criteria andEmpstatusEqualTo(String value) {
            addCriterion("empStatus =", value, "empstatus");
            return (Criteria) this;
        }

        public Criteria andEmpstatusNotEqualTo(String value) {
            addCriterion("empStatus <>", value, "empstatus");
            return (Criteria) this;
        }

        public Criteria andEmpstatusGreaterThan(String value) {
            addCriterion("empStatus >", value, "empstatus");
            return (Criteria) this;
        }

        public Criteria andEmpstatusGreaterThanOrEqualTo(String value) {
            addCriterion("empStatus >=", value, "empstatus");
            return (Criteria) this;
        }

        public Criteria andEmpstatusLessThan(String value) {
            addCriterion("empStatus <", value, "empstatus");
            return (Criteria) this;
        }

        public Criteria andEmpstatusLessThanOrEqualTo(String value) {
            addCriterion("empStatus <=", value, "empstatus");
            return (Criteria) this;
        }

        public Criteria andEmpstatusLike(String value) {
            addCriterion("empStatus like", value, "empstatus");
            return (Criteria) this;
        }

        public Criteria andEmpstatusNotLike(String value) {
            addCriterion("empStatus not like", value, "empstatus");
            return (Criteria) this;
        }

        public Criteria andEmpstatusIn(List<String> values) {
            addCriterion("empStatus in", values, "empstatus");
            return (Criteria) this;
        }

        public Criteria andEmpstatusNotIn(List<String> values) {
            addCriterion("empStatus not in", values, "empstatus");
            return (Criteria) this;
        }

        public Criteria andEmpstatusBetween(String value1, String value2) {
            addCriterion("empStatus between", value1, value2, "empstatus");
            return (Criteria) this;
        }

        public Criteria andEmpstatusNotBetween(String value1, String value2) {
            addCriterion("empStatus not between", value1, value2, "empstatus");
            return (Criteria) this;
        }

        public Criteria andEmptypeIsNull() {
            addCriterion("empType is null");
            return (Criteria) this;
        }

        public Criteria andEmptypeIsNotNull() {
            addCriterion("empType is not null");
            return (Criteria) this;
        }

        public Criteria andEmptypeEqualTo(String value) {
            addCriterion("empType =", value, "emptype");
            return (Criteria) this;
        }

        public Criteria andEmptypeNotEqualTo(String value) {
            addCriterion("empType <>", value, "emptype");
            return (Criteria) this;
        }

        public Criteria andEmptypeGreaterThan(String value) {
            addCriterion("empType >", value, "emptype");
            return (Criteria) this;
        }

        public Criteria andEmptypeGreaterThanOrEqualTo(String value) {
            addCriterion("empType >=", value, "emptype");
            return (Criteria) this;
        }

        public Criteria andEmptypeLessThan(String value) {
            addCriterion("empType <", value, "emptype");
            return (Criteria) this;
        }

        public Criteria andEmptypeLessThanOrEqualTo(String value) {
            addCriterion("empType <=", value, "emptype");
            return (Criteria) this;
        }

        public Criteria andEmptypeLike(String value) {
            addCriterion("empType like", value, "emptype");
            return (Criteria) this;
        }

        public Criteria andEmptypeNotLike(String value) {
            addCriterion("empType not like", value, "emptype");
            return (Criteria) this;
        }

        public Criteria andEmptypeIn(List<String> values) {
            addCriterion("empType in", values, "emptype");
            return (Criteria) this;
        }

        public Criteria andEmptypeNotIn(List<String> values) {
            addCriterion("empType not in", values, "emptype");
            return (Criteria) this;
        }

        public Criteria andEmptypeBetween(String value1, String value2) {
            addCriterion("empType between", value1, value2, "emptype");
            return (Criteria) this;
        }

        public Criteria andEmptypeNotBetween(String value1, String value2) {
            addCriterion("empType not between", value1, value2, "emptype");
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
     * ess_employee
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * ess_employee null
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