package com.ccttic.entity.employee;

import java.util.Date;

public class EssEmployee {
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
     * 版本号
     */
    private Integer version;

    /**
     * 是否删除
     */
    private Boolean isdeleted;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 修改时间
     */
    private Date updatetime;

    /**
     * 删除时间
     */
    private Date deletetime;

    /**
     * 创建人编码
     */
    private String createby;

    /**
     * 创建人机构编码
     */
    private String createdepcd;

    /**
     * 修改人编码
     */
    private String updateby;

    /**
     * 修改人机构编码
     */
    private String updatedepcd;

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
        this.id = id;
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
        this.empcd = empcd;
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
        this.empnm = empnm;
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
        this.empno = empno;
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
        this.duty = duty;
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
        this.empgender = empgender;
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
        this.phone = phone;
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
        this.mobile = mobile;
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
        this.account = account;
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
        this.password = password;
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
        this.empstatus = empstatus;
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
        this.emptype = emptype;
    }

    /**
     * 版本号
     * @return version 版本号
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 版本号
     * @param version 版本号
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * 是否删除
     * @return isDeleted 是否删除
     */
    public Boolean getIsdeleted() {
        return isdeleted;
    }

    /**
     * 是否删除
     * @param isdeleted 是否删除
     */
    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }

    /**
     * 创建时间
     * @return createTime 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 创建时间
     * @param createtime 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 修改时间
     * @return updateTime 修改时间
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 修改时间
     * @param updatetime 修改时间
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * 删除时间
     * @return deleteTime 删除时间
     */
    public Date getDeletetime() {
        return deletetime;
    }

    /**
     * 删除时间
     * @param deletetime 删除时间
     */
    public void setDeletetime(Date deletetime) {
        this.deletetime = deletetime;
    }

    /**
     * 创建人编码
     * @return createBy 创建人编码
     */
    public String getCreateby() {
        return createby;
    }

    /**
     * 创建人编码
     * @param createby 创建人编码
     */
    public void setCreateby(String createby) {
        this.createby = createby;
    }

    /**
     * 创建人机构编码
     * @return createDepCd 创建人机构编码
     */
    public String getCreatedepcd() {
        return createdepcd;
    }

    /**
     * 创建人机构编码
     * @param createdepcd 创建人机构编码
     */
    public void setCreatedepcd(String createdepcd) {
        this.createdepcd = createdepcd;
    }

    /**
     * 修改人编码
     * @return updateBy 修改人编码
     */
    public String getUpdateby() {
        return updateby;
    }

    /**
     * 修改人编码
     * @param updateby 修改人编码
     */
    public void setUpdateby(String updateby) {
        this.updateby = updateby;
    }

    /**
     * 修改人机构编码
     * @return updateDepCd 修改人机构编码
     */
    public String getUpdatedepcd() {
        return updatedepcd;
    }

    /**
     * 修改人机构编码
     * @param updatedepcd 修改人机构编码
     */
    public void setUpdatedepcd(String updatedepcd) {
        this.updatedepcd = updatedepcd;
    }
}