package com.ccttic.entity.employee;

import java.util.List;

import com.ccttic.entity.post.EssPost;
import com.ccttic.entity.role.Department;
import com.ccttic.entity.role.Enterprise;
import com.ccttic.entity.role.Organization;
import com.ccttic.entity.role.RoleModels;

public class EmployeeVo extends EssEmployee {
	// 员工所在岗位
	private List<EssPost> posts;
	// 员工所在部门
	private List<Department> deps;
	// 员工所在企业
	private Enterprise ent;
	// 员工所在组织
	private List<Organization> orgs;
	// 角色
	private List<RoleModels> models;
	// 员工能使用的菜单
	private  List<Object> menus; 
	//验证码 
	private String picCode;

      public EmployeeVo() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeVo(List<EssPost> posts, List<Department> deps, Enterprise ent, List<Organization> orgs,
			List<RoleModels> models, List<Object> menus, String picCode) {
		super();
		this.posts = posts;
		this.deps = deps;
		this.ent = ent;
		this.orgs = orgs;
		this.models = models;
		this.menus = menus;
		this.picCode = picCode;
	}



	public List<EssPost> getPosts() {
		return posts;
	}

	public void setPosts(List<EssPost> posts) {
		this.posts = posts;
	}

	public List<Department> getDeps() {
		return deps;
	}

	public void setDeps(List<Department> deps) {
		this.deps = deps;
	}

	public List<Organization> getOrgs() {
		return orgs;
	}

	public void setOrgs(List<Organization> orgs) {
		this.orgs = orgs;
	}

	public List<RoleModels> getModels() {
		return models;
	}

	public void setModels(List<RoleModels> models) {
		this.models = models;
	}

	public List<Object> getMenus() {
		return menus;
	}

	public void setMenus(List<Object> menus) {
		this.menus = menus;
	}

	public String getPicCode() {
		return picCode;
	}

	public void setPicCode(String picCode) {
		this.picCode = picCode;
	}

	
	public Enterprise getEnt() {
		return ent;
	}

	public void setEnt(Enterprise ent) {
		this.ent = ent;
	}

	@Override
	public String toString() {
		return "EmployeeVo [posts=" + posts + ", deps=" + deps + ", orgs=" + orgs + ", models="
				+ models + ", menus=" + menus + ", picCode=" + picCode + ", ent=" + ent + "]";
	}


}
