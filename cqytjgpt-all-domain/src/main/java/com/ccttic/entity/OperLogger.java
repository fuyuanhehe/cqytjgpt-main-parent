package com.ccttic.entity;

import java.io.Serializable;

public class OperLogger implements Serializable {
    private static final long serialVersionUID = -6888925596209686545L;
    // 操作日志ID
    private String id;
    // 操作者姓名
    private String operName;
    // 访问的链接
    private String url;
    // 提交的参数
    private String params;
    // 访问的时间
    private String startTime;
    // 结束的时间
    private String endTime;
    // 是否成功 0 成功 1 失败
    private int success;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOperName() {
        return operName;
    }

    public void setOperName(String operName) {
        this.operName = operName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }
}
