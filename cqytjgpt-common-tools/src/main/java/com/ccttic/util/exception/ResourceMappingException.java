/**
 * 
 */
package com.ccttic.util.exception;

/**
 * 
    * @ClassName: ResourceMappingException  
    * @Description: 资源映射异常  
    * @author Administrator  
    * @date 2018年6月5日  
    *
 */
public class ResourceMappingException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceMappingException() {
		super();
	}
	
	public ResourceMappingException(String str) {
		super(str);
	}
	
}
