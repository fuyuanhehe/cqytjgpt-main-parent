
package com.ccttic.entity.employee;

import java.io.Serializable;
import java.util.LinkedList;


/**
 * 
    * @ClassName: ResourceInfo  
    * @Description: 系统资源扫描信息
    * @author Administrator  
    * @date 2018年6月5日  
    *
 */
public class ResourceInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String resourceCd;
	
	private String identity;
	
	private String parentCd;
	
	private String name;
	
	private String url;
	
	private int hierarchy;
	
	private boolean isMenue;
	
	private boolean available;
	
	private String icon;
	
	private int sortOrder;
	
	private String description;
	
	
	private LinkedList<ResourceInfo> partenResourceInfos = new LinkedList<ResourceInfo>(); 

	/**
	 * @return the resourceCd
	 */
	public String getResourceCd() {
		return resourceCd;
	}

	/**
	 * @param resourceCd the resourceCd to set
	 */
	public void setResourceCd(String resourceCd) {
		this.resourceCd = resourceCd;
	}

	/**
	 * @return the identity
	 */
	public String getIdentity() {
		return identity;
	}

	/**
	 * @param identity the identity to set
	 */
	public void setIdentity(String identity) {
		this.identity = identity;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the hierarchy
	 */
	public int getHierarchy() {
		return hierarchy;
	}

	/**
	 * @param hierarchy the hierarchy to set
	 */
	public void setHierarchy(int hierarchy) {
		this.hierarchy = hierarchy;
	}

	/**
	 * @return the isMenue
	 */
	public boolean isMenue() {
		return isMenue;
	}

	/**
	 * @param isMenue the isMenue to set
	 */
	public void setMenue(boolean isMenue) {
		this.isMenue = isMenue;
	}

	/**
	 * @return the available
	 */
	public boolean isAvailable() {
		return available;
	}

	/**
	 * @param available the available to set
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}








	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public int getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return 当前资源的所有父资源
	 */
	public LinkedList<ResourceInfo> getPartenResourceInfos() {
		return partenResourceInfos;
	}
	
	/**
	 * 添加父节点资源
	 * @param resourceInfo
	 */
	public void addPartenResourceInfo(ResourceInfo resourceInfo) {
		partenResourceInfos.add(resourceInfo);
	}

	/**
	 * @return the parentCd
	 */
	public String getParentCd() {
		return parentCd;
	}

	/**
	 * @param parentCd the parentCd to set
	 */
	public void setParentCd(String parentCd) {
		this.parentCd = parentCd;
	}
	
}
