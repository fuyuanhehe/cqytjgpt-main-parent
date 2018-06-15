package com.ccttic.entity.employee;

import java.io.Serializable;
import java.util.Date;

import com.ccttic.entity.BaseBean;

public class EssEmployee extends BaseBean implements Serializable{
	private static final long serialVersionUID = -8349678655503842856L;
    /**
     * 主键ID
     */
    private String id;

    /**
     * 员工代码
     */
    private String empcd;

    /**
     * 员工姓名
     */
    private String empnm;

    /**
     * 工号
     */
    private String empno;

    /**
     * 职务
     */
    private String duty;

    /**
     * 性别
     */
    private String empgender;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 移动电话
     */
    private String mobile;

    /**
     * 注册邮箱，可通知用
     */
    private String email;

    /**
     * 入职日期
     */
    private Date entrydate;

    /**
     * 离职日期
     */
    private Date leavedate;

    /**
     * 用户账号
     */
    private String account;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 员工状态
     */
    private String empstatus;

    /**
     * 员工类型
     */
    private String emptype;

   

    /**
     * 主键ID
     * @return id 主键ID
     */
    public String getId() {
        return id;
    }

    /**
     * 主键ID
     * @param id 主键ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 员工代码
     * @return empCd 员工代码
     */
    public String getEmpcd() {
        return empcd;
    }

    /**
     * 员工代码
     * @param empcd 员工代码
     */
    public void setEmpcd(String empcd) {
        this.empcd = empcd == null ? null : empcd.trim();
    }

    /**
     * 员工姓名
     * @return empNm 员工姓名
     */
    public String getEmpnm() {
        return empnm;
    }

    /**
     * 员工姓名
     * @param empnm 员工姓名
     */
    public void setEmpnm(String empnm) {
        this.empnm = empnm == null ? null : empnm.trim();
    }

    /**
     * 工号
     * @return empNo 工号
     */
    public String getEmpno() {
        return empno;
    }

    /**
     * 工号
     * @param empno 工号
     */
    public void setEmpno(String empno) {
        this.empno = empno == null ? null : empno.trim();
    }

    /**
     * 职务
     * @return duty 职务
     */
    public String getDuty() {
        return duty;
    }

    /**
     * 职务
     * @param duty 职务
     */
    public void setDuty(String duty) {
        this.duty = duty == null ? null : duty.trim();
    }

    /**
     * 性别
     * @return empGender 性别
     */
    public String getEmpgender() {
        return empgender;
    }

    /**
     * 性别
     * @param empgender 性别
     */
    public void setEmpgender(String empgender) {
        this.empgender = empgender == null ? null : empgender.trim();
    }

    /**
     * 联系电话
     * @return phone 联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 联系电话
     * @param phone 联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 移动电话
     * @return mobile 移动电话
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 移动电话
     * @param mobile 移动电话
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 注册邮箱，可通知用
     * @return email 注册邮箱，可通知用
     */
    public String getEmail() {
        return email;
    }

    /**
     * 注册邮箱，可通知用
     * @param email 注册邮箱，可通知用
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 入职日期
     * @return entryDate 入职日期
     */
    public Date getEntrydate() {
        return entrydate;
    }

    /**
     * 入职日期
     * @param entrydate 入职日期
     */
    public void setEntrydate(Date entrydate) {
        this.entrydate = entrydate;
    }

    /**
     * 离职日期
     * @return leaveDate 离职日期
     */
    public Date getLeavedate() {
        return leavedate;
    }

    /**
     * 离职日期
     * @param leavedate 离职日期
     */
    public void setLeavedate(Date leavedate) {
        this.leavedate = leavedate;
    }

    /**
     * 用户账号
     * @return account 用户账号
     */
    public String getAccount() {
        return account;
    }

    /**
     * 用户账号
     * @param account 用户账号
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * 用户密码
     * @return password 用户密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 用户密码
     * @param password 用户密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 员工状态
     * @return empStatus 员工状态
     */
    public String getEmpstatus() {
        return empstatus;
    }

    /**
     * 员工状态
     * @param empstatus 员工状态
     */
    public void setEmpstatus(String empstatus) {
        this.empstatus = empstatus == null ? null : empstatus.trim();
    }

    /**
     * 员工类型
     * @return empType 员工类型
     */
    public String getEmptype() {
        return emptype;
    }

    /**
     * 员工类型
     * @param emptype 员工类型
     */
    public void setEmptype(String emptype) {
        this.emptype = emptype == null ? null : emptype.trim();
    }

}