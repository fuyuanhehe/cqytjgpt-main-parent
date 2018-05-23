package com.ccttic.entity;

import java.io.Serializable;

/**
 * 说明：用户操作实体类型
 * */
public class UserOperLogger implements Serializable {
    private static final long serialVersionUID = -863043122186541444L;

    private String id; // 标识符
    private String content; // 操作内容
    private int operType; // 0:增加;1:修改;2:删除,3查询
    private String operBy; // 操作人
    private String operTime; // 操作时间
    private String ipAddr; // ip地址
    private String remark; // 备注（预留字段，暂时无用）

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getOperType() {
        return operType;
    }

    public void setOperType(int operType) {
        this.operType = operType;
    }

    public String getOperBy() {
        return operBy;
    }

    public void setOperBy(String operBy) {
        this.operBy = operBy;
    }

    public String getOperTime() {
        return operTime;
    }

    public void setOperTime(String operTime) {
        this.operTime = operTime;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
