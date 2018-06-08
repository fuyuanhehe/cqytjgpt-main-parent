package com.ccttic.entity.employee;

import java.util.List;

import com.ccttic.entity.post.EssPost;
import com.ccttic.entity.role.Department;
import com.ccttic.entity.role.Organization;
import com.ccttic.entity.role.vo.Model_menus;

public class EmployeeVo extends EssEmployee {
	// 员工所在岗位
	private List<EssPost> posts;
	// 员工所在部门
	private List<Department> deps;
	// 员工所在组织
	private List<Organization> orgs;
	// 员工能使用的菜单
	private List<Model_menus> menus;
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
	public List<Model_menus> getMenus() {
		return menus;
	}
	public void setMenus(List<Model_menus> menus) {
		this.menus = menus;
	}
	public EmployeeVo(List<EssPost> posts, List<Department> deps, List<Organization> orgs, List<Model_menus> menus) {
		super();
		this.posts = posts;
		this.deps = deps;
		this.orgs = orgs;
		this.menus = menus;
	}
	public EmployeeVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
