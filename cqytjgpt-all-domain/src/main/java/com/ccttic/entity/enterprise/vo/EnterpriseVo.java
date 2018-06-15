  
    /**    
    * @Title: EnterpriseVo.java  
    * @Package com.ccttic.entity.enterprise.vo  
    * @Description: TODO(用一句话描述该文件做什么)  
    * @author Administrator  
    * @date 2018年6月12日  
    * @version V1.0    
    */  
    
package com.ccttic.entity.enterprise.vo;

import com.ccttic.entity.enterprise.EssEnterprise;

/**  
    * @ClassName: EnterpriseVo  
    * @Description: 企业注册VO对象  
    * @author Administrator  
    * @date 2018年6月12日  
    *    
    */

public class EnterpriseVo extends EssEnterprise {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String account;
	
	private String password;
	
	private String email;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
