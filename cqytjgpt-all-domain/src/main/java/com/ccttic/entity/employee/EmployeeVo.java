package com.ccttic.entity.employee;

import java.io.Serializable;
import java.util.List;

import com.ccttic.entity.enterprise.EssEnterprise;
import com.ccttic.entity.post.EssPost;
import com.ccttic.entity.role.Department;
import com.ccttic.entity.role.Organization;
import com.ccttic.entity.role.RoleModels;

public class EmployeeVo extends EssEmployee implements Serializable{
	private static final long serialVersionUID = -4656386997456826076L;
	// 员工所在岗位
	private List<EssPost> posts;
	private List<EssPost> canSeePosts;
	private List<EssEmployee> canSeeEmp;
	// 员工所在部门
	private List<Department> deps;
	
	private List<Department> canSeeDeps;
	// 员工所在企业
	private EssEnterprise ent;
	
	private List<EssEnterprise> canSeeEnt;
	// 员工所在组织
	private Organization org;
	
	private List<Organization> canSeeOrgs;
	// 角色
	private List<RoleModels> models;
	// 员工能使用的菜单
	private  List<Object> menus; 
	//验证码 
	private String picCode;


	public List<EssEmployee> getCanSeeEmp() {
		return canSeeEmp;
	}

	public void setCanSeeEmp(List<EssEmployee> canSeeEmp) {
		this.canSeeEmp = canSeeEmp;
	}

	public Organization getOrg() {
		return org;
	}

	public void setOrg(Organization org) {
		this.org = org;
	}

	public List<EssPost> getCanSeePosts() {
		return canSeePosts;
	}

	public void setCanSeePosts(List<EssPost> canSeePosts) {
		this.canSeePosts = canSeePosts;
	}

	public List<Department> getCanSeeDeps() {
		return canSeeDeps;
	}

	public void setCanSeeDeps(List<Department> canSeeDeps) {
		this.canSeeDeps = canSeeDeps;
	}

	public List<EssEnterprise> getCanSeeEnt() {
		return canSeeEnt;
	}

	public void setCanSeeEnt(List<EssEnterprise> canSeeEnt) {
		this.canSeeEnt = canSeeEnt;
	}

	public List<Organization> getCanSeeOrgs() {
		return canSeeOrgs;
	}

	public void setCanSeeOrgs(List<Organization> canSeeOrgs) {
		this.canSeeOrgs = canSeeOrgs;
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

	public EssEnterprise getEnt() {
		return ent;
	}

	public void setEnt(EssEnterprise ent) {
		this.ent = ent;
	}
}
