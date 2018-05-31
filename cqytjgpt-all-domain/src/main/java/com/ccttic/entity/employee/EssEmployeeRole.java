package com.ccttic.entity.employee;

public class EssEmployeeRole {
    /**
     * 主键ID
     */
    private String id;

    /**
     * 版本号
     */
    private Integer version;

    /**
     * 人员ID
     */
    private String empId;

    /**
     * 角色ID
     */
    private String roleId;

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
     * 人员ID
     * @return emp_id 人员ID
     */
    public String getEmpId() {
        return empId;
    }

    /**
     * 人员ID
     * @param empId 人员ID
     */
    public void setEmpId(String empId) {
        this.empId = empId;
    }

    /**
     * 角色ID
     * @return role_id 角色ID
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * 角色ID
     * @param roleId 角色ID
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}