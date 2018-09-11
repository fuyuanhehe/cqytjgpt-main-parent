package com.ccttic.entity.enterprise;

import com.ccttic.entity.role.Department;

import java.util.List;

public class DeptTree extends Department{
    private String superId;
    private String orgNm;
    private List<DeptTree> subList;

    public String getSuperId() {
        return superId;
    }

    public void setSuperId(String superId) {
        this.superId = superId;
    }

    public String getOrgNm() {
        return orgNm;
    }

    public void setOrgNm(String orgNm) {
        this.orgNm = orgNm;
    }

    public List<DeptTree> getSubList() {
        return subList;
    }

    public void setSubList(List<DeptTree> subList) {
        this.subList = subList;
    }


}
