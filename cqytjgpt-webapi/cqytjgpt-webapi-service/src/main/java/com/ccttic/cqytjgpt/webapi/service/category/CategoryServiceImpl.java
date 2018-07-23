package com.ccttic.cqytjgpt.webapi.service.category;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccttic.cqytjgpt.webapi.interfaces.category.ICategoryService;
import com.ccttic.cqytjgpt.webapi.mapper.category.CategoryMapper;
import com.ccttic.entity.category.Category;
import com.ccttic.entity.category.CategoryAttr;
import com.ccttic.util.common.RandomHelper;
import com.ccttic.util.exception.AppException;

/**
   功能说明：     数据字典业务实现类
 @version  1.0.0
 @author  sqli
 @date  2016年12月29日
 */
@Service
public class CategoryServiceImpl implements ICategoryService {
	@Resource
	private CategoryMapper mapper;

	@Override
	@Transactional
	public int addCategory(Category category) throws Exception {
		category.setId(RandomHelper.uuid());
		return mapper.addCategory(category);
	}

	@Override
	@Transactional
	public int updateCategory(Category category) throws Exception {
		return mapper.updateCategory(category);
	}

	@Override
	@Transactional
	public int deleteCategory(String id) throws Exception {
		return mapper.deleteCategory(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Category findCategoryById(String id) throws Exception {
		return mapper.findCategoryById(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public Map<Category, List<Category>> findAllCategorys(String categoryCd) throws AppException {
		Map<Category, List<Category>> categorys = null;
		Object obj = (Object)System.getProperties().get("dataDictObj");
		if(obj != null) {
			categorys = (Map<Category, List<Category>>) obj;
		} else {
			categorys = new TreeMap<Category, List<Category>>(new Comparator<Category>() {
				/* 
				 * int compare(Object o1, Object o2) 返回一个基本类型的整型， 
				 * 返回负数表示：o1 小于o2， 
				 * 返回0 表示：o1和o2相等， 
				 * 返回正数表示：o1大于o2。 
				 */
				public int compare(Category o1, Category o2) {
	
					//指定排序器按照升序排列  
					return o1.getCategoryCd().compareTo(o2.getCategoryCd());
				}
			});
	
			List<Category> firstCategorys = mapper.getFirstCategorys();
	
			List<Category> firsts = new ArrayList<Category>();
			List<Category> seconds = new ArrayList<Category>();
			
			for (Category firstCategory : firstCategorys) {
				if("ROOT".equals(firstCategory.getAttrCd())) {
					firsts.add(firstCategory);
				} else {
					seconds.add(firstCategory);
				}
			}
	
			for (Category firstCategory : firsts) {
					
				List<Category> tmpList = new ArrayList<Category>();
				for(Category secondCategory: seconds) {
					if(secondCategory.getAttrCd().equals(firstCategory.getCategoryCd())) {
						tmpList.add(secondCategory);
					}
				}
				categorys.put(firstCategory, tmpList);
			}
			System.getProperties().put("dataDictObj", categorys);
		}

		return categorys;

	}

	@Override
	@Transactional(readOnly = true)
	public List<CategoryAttr> findCategoryAttrsByCd(CategoryAttr categoryAttr) throws Exception {
		return mapper.findCategoryAttrsByCd(categoryAttr);
	}
	
	@Override
	@Transactional(readOnly = true)
	public CategoryAttr findCategoryAttrNmByCd(CategoryAttr categoryAttr) throws Exception {
		return mapper.findCategoryAttrNmByCd(categoryAttr);
	}
	
	@Override
	@Transactional(readOnly = true)
	public String findCategoryAttrNm(String categoryCd, String attrCd) throws AppException {
		String attrNm = "";
		
		Map<Category, List<Category>> categorys = findAllCategorys(categoryCd);
		
		Set<Category> keys = categorys.keySet();
		for (Category key : keys) {
			if(key.getCategoryCd().equals(categoryCd)) {
				List<Category> childBeans = categorys.get(key);
				for(Category bean : childBeans) {
					if(bean.getCategoryCd().equals(attrCd)) {
						attrNm = bean.getCategoryNm();
						break;
					}
				}
				break;
			}
		}
		
		return attrNm;
	}
}
