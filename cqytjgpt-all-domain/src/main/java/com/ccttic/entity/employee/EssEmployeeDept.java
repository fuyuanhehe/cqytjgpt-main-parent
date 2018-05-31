package com.ccttic.entity.employee;

public class EssEmployeeDept {
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
     * 部门ID
     */
    private String depId;

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
     * 部门ID
     * @return dep_id 部门ID
     */
    public String getDepId() {
        return depId;
    }

    /**
     * 部门ID
     * @param depId 部门ID
     */
    public void setDepId(String depId) {
        this.depId = depId;
    }
}