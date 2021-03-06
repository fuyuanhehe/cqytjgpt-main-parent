package com.ccttic.cqytjgpt.webapi.mapper.category;

import java.util.List;

import com.ccttic.entity.category.Category;
import com.ccttic.entity.category.CategoryAttr;
import com.ccttic.util.exception.AppException;

/**
 * 
   功能说明：    MyBatis数据字典映射
 @version  1.0.0
 @author  sqli
 @date  2016年12月29日
 */
public interface CategoryMapper {
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
	 * @param category
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
	 * 获取一级数据字典
	 * @return
	 * @throws AppException
	 */
	public List<Category> getFirstCategorys() throws AppException;

	/**
	 * 获取二级数据字典
	 * @param categoryCd
	 * @return
	 * @throws AppException
	 */
	public List<Category> getSecondCategorys(String categoryCd) throws AppException;

	/**
	 * 获取列表数据
	 * @param CategoryAttr
	 * @return
	 * @throws AppException
	 */
	public List<CategoryAttr> findCategoryAttrsByCd(CategoryAttr categoryAttr) throws AppException;
	
	/**
	 * 获取属性名称
	 * @param categoryCd
	 * @return
	 * @throws AppException
	 */
	public CategoryAttr findCategoryAttrNmByCd(CategoryAttr categoryAttr) throws AppException;
}
