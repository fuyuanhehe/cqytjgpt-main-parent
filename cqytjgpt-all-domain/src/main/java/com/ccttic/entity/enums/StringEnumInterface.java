
package com.ccttic.entity.enums;

/**
 * 
    * @ClassName: StringEnumInterface  
    * @Description: 枚举接口 
    * @author Administrator  
    * @date 2018年6月13日  
    *
 */
public interface StringEnumInterface {

	/**
	 * 根据输入值映射成相应的枚举类型
	 * @param input
	 * @return 
	 */
	StringEnumInterface toEnum(String input);
	
	/**
	 * @return 枚举编码
	 */
	String getValue();
	
	/**
	 * @return 枚举含义
	 */
	String getText();
	
	/**
	 * @return JSON 
	 */
	String toString();
	
}
