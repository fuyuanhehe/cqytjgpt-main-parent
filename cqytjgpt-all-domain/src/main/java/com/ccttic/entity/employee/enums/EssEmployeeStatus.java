  
    /**    
    * @Title: EssEmployeeStatus.java  
    * @Package com.ccttic.entity.employee.enums  
    * @Description: TODO(用一句话描述该文件做什么)  
    * @author Administrator  
    * @date 2018年6月13日  
    * @version V1.0    
    */  
    
package com.ccttic.entity.employee.enums;


import org.apache.commons.lang3.StringUtils;

import com.ccttic.entity.enums.StringEnumInterface;

/**  
    * @ClassName: EssEmployeeStatus  
    * @Description: 员工状态枚举  
    * @author Administrator  
    * @date 2018年6月13日  
    *    
    */

public enum EssEmployeeStatus implements StringEnumInterface {
	
	START("0", "已启用"), STOP("-1", "停用"), VERIFY("-2", "未审核");

	private final String value;
	private final String text;

	private EssEmployeeStatus(String value, String text) {
		this.value = value;
		this.text = text;
	}

	  
	    /* (非 Javadoc)  
	    *   
	    *   
	    * @param input
	    * @return  
	    * @see com.ccttic.entity.enums.StringEnumInterface#toEnum(java.lang.String)  
	    */  
	    
	@Override
	public StringEnumInterface toEnum(String input) {
		if (StringUtils.isBlank(StringUtils.trim(input))) {
			return null;
		}

		if ("0".equals(input) || "已启用".equals(input)) {
			return START;
		} else if ("-1".equals(input) || "停用".equals(input)) {
			return STOP;
		} else if ("-2".equals(input) || "未审核".equals(input)) {
			return VERIFY;
		} else {
			return null;
		}
	}

	  
	    /* (非 Javadoc)  
	    *   
	    *   
	    * @return  
	    * @see com.ccttic.entity.enums.StringEnumInterface#getValue()  
	    */  
	    
	@Override
	public String getValue() {
		return value;
	}

	  
	    /* (非 Javadoc)  
	    *   
	    *   
	    * @return  
	    * @see com.ccttic.entity.enums.StringEnumInterface#getText()  
	    */  
	    
	@Override
	public String getText() {
		return text;
	}

}
