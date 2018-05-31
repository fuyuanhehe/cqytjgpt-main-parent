package com.ccttic.entity.employee;

public class EssEmployeePost {
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
     * 岗位ID
     */
    private String postId;

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
     * 岗位ID
     * @return post_id 岗位ID
     */
    public String getPostId() {
        return postId;
    }

    /**
     * 岗位ID
     * @param postId 岗位ID
     */
    public void setPostId(String postId) {
        this.postId = postId;
    }
}