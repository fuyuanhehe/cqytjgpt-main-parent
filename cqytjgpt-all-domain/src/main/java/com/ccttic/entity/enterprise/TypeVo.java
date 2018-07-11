package com.ccttic.entity.enterprise;

import java.io.Serializable;
import java.util.List;
//权限  实体
public class TypeVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4374683237815784158L;
	//账号类型
	private String empType;
	//企业id
	private List<String> list;

public TypeVo() {
}

public TypeVo(String empType, List<String> list) {
	super();
	this.empType = empType;
	this.list = list;
}

@Override
public String toString() {
	return "TypeVo [empType=" + empType + ", list=" + list + "]";
}

public String getEmpType() {
	return empType;
}

public void setEmpType(String empType) {
	this.empType = empType;
}

public List<String> getList() {
	return list;
}

public void setList(List<String> list) {
	this.list = list;
}


}
