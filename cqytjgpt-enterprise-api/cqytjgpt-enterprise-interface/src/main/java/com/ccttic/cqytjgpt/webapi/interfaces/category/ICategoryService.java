package com.ccttic.cqytjgpt.webapi.interfaces.category;

import java.util.List;
import java.util.Map;

import com.ccttic.entity.category.Category;
import com.ccttic.entity.category.CategoryAttr;
import com.ccttic.util.exception.AppException;

/**
   功能说明：     数据字典业务接口
 @version  1.0.0
 @author  sqli
 @see  com.studio.framework.service.param.ICategoryService.java
 @date  2016年12月29日
 */

public interface ICategoryService {
	/**
	 * 新增数据字典
	 * @param category
	 * @return
	 * @throws Exception
	 */
	public int addCategory(Category category) throws Exception;

	/**
	 * 修改数据字典
	 * @param category
	 * @return
	 * @throws Exception
	 */
	public int updateCategory(Category category) throws Exception;

	/**
	 * 删除数据字典
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int deleteCategory(String id) throws Exception;
	
	/**
	 * 根据ID查询数据字典
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Category findCategoryById(String id) throws Exception;

	/**
	 * 获取所有数据字典
	 * @return
	 * @throws AppException
	 */
	public Map<Category, List<Category>> findAllCategorys(String categoryCd) throws AppException;

	/**
	 * 根据category查询数据字典
	 * @param categoryAttr
	 * @return
	 * @throws Exception
	 */
	public List<CategoryAttr> findCategoryAttrsByCd(CategoryAttr categoryAttr) throws Exception;
	
	/**
	 * 根据category查询数据字典
	 * @param categoryAttr
	 * @return
	 * @throws Exception
	 */
	public CategoryAttr findCategoryAttrNmByCd(CategoryAttr categoryAttr) throws Exception;
	
	/**
	 * 根据categoryCd和attrCd查询数据字典
	 * @param categoryCd
	 * @param attrCd
	 * @return attrNm
	 * @throws Exception
	 */
	public String findCategoryAttrNm(String categoryCd, String attrCd) throws AppException;
}
