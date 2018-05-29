package com.ccttic.util.common;

/**
   功能说明：     
 @version  1.0.0
 @author  Administrator
 @see  com.zdsoft.common.util.TableObject.java
 @date  2017年8月2日
 */

public class TableObject {
	private String columnName;
	private String columnType;
	private String dataType;
	private String maxLength;
	private String nullLable;
	private String columnDefault;
	private String columnDesc;

	/**
	 * 
	 */
	public TableObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param columnName
	 * @param columnType
	 * @param dataType
	 * @param maxLength
	 * @param nullLable
	 * @param columnDefault
	 * @param columnDesc
	 */
	public TableObject(String columnName, String columnType, String dataType, String maxLength, String nullLable,
			String columnDefault, String columnDesc) {
		super();
		this.columnName = columnName;
		this.columnType = columnType;
		this.dataType = dataType;
		this.maxLength = maxLength;
		this.nullLable = nullLable;
		this.columnDefault = columnDefault;
		this.columnDesc = columnDesc;
	}

	/**
	 * @return the columnName
	 */
	public String getColumnName() {
		return columnName;
	}

	/**
	 * @param columnName the columnName to set
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	/**
	 * @return the columnType
	 */
	public String getColumnType() {
		return columnType;
	}

	/**
	 * @param columnType the columnType to set
	 */
	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	/**
	 * @return the dataType
	 */
	public String getDataType() {
		return dataType;
	}

	/**
	 * @param dataType the dataType to set
	 */
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	/**
	 * @return the maxLength
	 */
	public String getMaxLength() {
		return maxLength;
	}

	/**
	 * @param maxLength the maxLength to set
	 */
	public void setMaxLength(String maxLength) {
		this.maxLength = maxLength;
	}

	/**
	 * @return the nullLable
	 */
	public String getNullLable() {
		return nullLable;
	}

	/**
	 * @param nullLable the nullLable to set
	 */
	public void setNullLable(String nullLable) {
		this.nullLable = nullLable;
	}

	/**
	 * @return the columnDefault
	 */
	public String getColumnDefault() {
		return columnDefault;
	}

	/**
	 * @param columnDefault the columnDefault to set
	 */
	public void setColumnDefault(String columnDefault) {
		this.columnDefault = columnDefault;
	}

	/**
	 * @return the columnDesc
	 */
	public String getColumnDesc() {
		return columnDesc;
	}

	/**
	 * @param columnDesc the columnDesc to set
	 */
	public void setColumnDesc(String columnDesc) {
		this.columnDesc = columnDesc;
	}

}
