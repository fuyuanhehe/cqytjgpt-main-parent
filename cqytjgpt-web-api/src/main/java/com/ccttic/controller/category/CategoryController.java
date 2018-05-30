package com.ccttic.controller.category;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccttic.common.beans.ResponseMsg;
import com.ccttic.common.exception.AppException;
import com.ccttic.entity.category.Category;
import com.ccttic.entity.category.CategoryAttr;
import com.ccttic.entity.category.vo.TreeCategoryBean;
import com.ccttic.service.category.ICategoryService;

@RestController
@RequestMapping("/param")
public class CategoryController implements Serializable {
	
	private static final long serialVersionUID = -1032335560287290997L;

	private Logger logger = LoggerFactory.getLogger(CategoryController.class);
	 
	@Autowired
    private ICategoryService categoryService;
	

	/**
	 * 获取数据字典树
	 * @return
	 * @throws AppException
	 */
	@GetMapping("/findAllCategorys")
	public ResponseMsg<List<TreeCategoryBean>> findAllCategorys(HttpServletRequest request) throws AppException {
		ResponseMsg<List<TreeCategoryBean>> resp = new ResponseMsg<List<TreeCategoryBean>>();
		String categoryCd = request.getParameter("categoryCd");
		List<TreeCategoryBean> beans = new ArrayList<TreeCategoryBean>();
		int total = 0;
	
		Map<Category, List<Category>> categorys = this.categoryService.findAllCategorys(categoryCd);
		Set<Category> keys = categorys.keySet();

		for (Category key : keys) {
			TreeCategoryBean root = new TreeCategoryBean();
			root.setId(key.getId());
			root.setCategoryCd(key.getCategoryCd());
			root.setAttrCd(key.getAttrCd());
			root.setCategoryNm(key.getCategoryNm());
			root.setCategorydesc(key.getCategorydesc());
			root.setState("closed");
			List<Category> childBeans = categorys.get(key);
			for (Category bean : childBeans) {
				TreeCategoryBean treeChild = new TreeCategoryBean();
				treeChild.setId(bean.getId());
				treeChild.setCategoryCd(bean.getCategoryCd());
				treeChild.setAttrCd(bean.getAttrCd());
				treeChild.setCategoryNm(bean.getCategoryNm());
				treeChild.setCategorydesc(bean.getCategorydesc());
				root.getChildren().add(treeChild);
				total++;
			}
			total++;
			beans.add(root);
		}
		
		resp.success("获取菜单树成功");
		resp.setData(beans);
		resp.setTotal(total);
		
		return resp;
	}

	/**
	 * 编辑菜单树
	 * @return
	 * @throws AppException
	 */
	/*@RequestMapping(value = { "/editCategory" }, produces = { "text/plain;charset=UTF-8" })
	@ResponseBody
	public String editCategory(Category category) throws AppException {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			boolean result = false;
			int cnt = 0;

			category.setUpdateBy(this.getEmployeeCd());
			category.setUpdateByNm(this.getEmployeeNm());
			category.setUpdateOrgCd(this.getOrgCd());
			category.setUpdateOrgCdNm(this.getOrgNm());

			if (ObjectHelper.isEmpty(category.getId())) {
				category.setCreateBy(this.getEmployeeCd());
				category.setCreateByNm(this.getEmployeeNm());
				category.setCreateOrgCd(this.getOrgCd());
				category.setCreateOrgCdNm(this.getOrgNm());
				//新增
				cnt = this.categoryService.addCategory(category);
			} else {
				//修改
				cnt = this.categoryService.updateCategory(category);
			}

			if (cnt > 0) {
				result = true;
				System.getProperties().remove("dataDictObj");
			}
			String msg = "编辑数据字典信息成功!";
			if(!result) {
				msg = "编辑数据字典信息失败!";
			}
			map.put("result", result);
			map.put("msg", msg);
		} catch (Exception ae) {
			ae.printStackTrace();
			map.put("result", false);
			map.put("msg", "系统异常," + ae.getMessage());
		}
		return ObjectHelper.objectToJson(map);
	}*/

	/**
	 * 删除字典树
	 * @return
	 * @throws AppException
	 */
	@DeleteMapping("/deleteCategory")
	public ResponseMsg<Boolean> deleteCategory(String id) throws AppException {
		ResponseMsg<Boolean> resp = new ResponseMsg<Boolean>();
		try {
			boolean result = false;
			int cnt = this.categoryService.deleteCategory(id);

			String msg = "删除数据字典信息成功!";
			if (cnt > 0) {
				result = true;
				System.getProperties().remove("dataDictObj");
			} else {
				msg = "删除数据字典信息失败!";
			}
			resp.success(msg);
			resp.setData(result);
		} catch (Exception ae) {
			resp.fail("系统异常," + ae.getMessage());
			resp.setData(false);
			logger.error("删除数据字典失败",ae);
		}
		return resp;
	}

	/**
	 * 获取数据字典树
	 * @return
	 * @throws AppException
	 */
	@GetMapping("/findCategoryAttrsByCd" )
	public ResponseMsg<List<Map<String, String>>> findCategoryAttrsByCd(String categoryCd, String allflag) throws Exception {
		ResponseMsg<List<Map<String, String>>> resp = new ResponseMsg<List<Map<String, String>>>();
		List<Map<String, String>> mapDataList = new ArrayList<Map<String, String>>();

		CategoryAttr categoryAttr = new CategoryAttr();
		categoryAttr.setCategoryCd(categoryCd);
		List<CategoryAttr> categoryAttrs = this.categoryService.findCategoryAttrsByCd(categoryAttr);
		//是否含有"全部"项
		if ("1".equals(allflag)) {
			Map<String, String> mapData = new HashMap<String, String>();
			mapData.put("attrCd", "");
			mapData.put("attrNm", "全部");
			mapData.put("actualval", "");

			mapDataList.add(mapData);
		}
		for (CategoryAttr c : categoryAttrs) {
			Map<String, String> mapData = new HashMap<String, String>();
			mapData.put("attrCd", c.getAttrCd());
			mapData.put("attrNm", c.getAttrNm());
			mapData.put("actualval", c.getActualval());

			mapDataList.add(mapData);
		}
		
		resp.success("获取数据字典成功");
		resp.setData(mapDataList);

		// 页面返回数据

		return resp;
	}
	
	/**
	 * 获取数据字典树
	 * @return
	 * @throws AppException
	 */
	@GetMapping("/findCategoryAttrNm")
	public ResponseMsg<String> findCategoryAttrNm(String categoryCd, String attrCd) throws Exception {
		
		ResponseMsg<String> resp = new  ResponseMsg<String>();

		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			String attrNm = this.categoryService.findCategoryAttrNm(categoryCd, attrCd);
			if(attrNm == null 
					|| "".equals(attrNm)) {
				resp.fail("获取数据字典数据失败！");
			} else {
				resp.success("获取数据字典数据成功");
				resp.setData(attrNm);
			}
		} catch (Exception ae) {
			resp.fail("系统异常," + ae.getMessage());
			logger.error("获取数据字典数据失败",ae);
		}
		
		// 页面返回数据
		return resp;
	}
}
