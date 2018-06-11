/**
 * 
 */
package com.ccttic.exception;

/**
 * 
    * @ClassName: ResourceMappingException  
    * @Description: 资源资源数据无法查找到
    * @author Administrator  
    * @date 2018年6月5日  
    *
 */
public class ResourceDoNotFonundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceDoNotFonundException() {
		super();
	}
	
	public ResourceDoNotFonundException(String str) {
		super(str);
	}
	
}
