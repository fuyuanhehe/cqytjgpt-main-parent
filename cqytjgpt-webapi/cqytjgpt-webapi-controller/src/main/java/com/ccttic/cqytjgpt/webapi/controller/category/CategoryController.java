package com.ccttic.cqytjgpt.webapi.controller.category;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ccttic.cqytjgpt.webapi.interfaces.category.ICategoryService;
import com.ccttic.entity.category.Category;
import com.ccttic.entity.category.CategoryAttr;
import com.ccttic.entity.category.vo.TreeCategoryBean;
import com.ccttic.entity.common.ResponseMsg;
import com.ccttic.util.annotation.OperLogging;
import com.ccttic.util.common.ObjectHelper;
import com.ccttic.util.exception.AppException;

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
	@RequestMapping(value="/findAllCategorys",method= {RequestMethod.GET,RequestMethod.POST})
	@OperLogging(content="获取数据字典树")
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
	@RequestMapping(value="/editCategory",method= {RequestMethod.GET,RequestMethod.POST})
	@OperLogging(content="编辑数据字典")
	public ResponseMsg<Boolean> editCategory(Category category) {
		ResponseMsg<Boolean> resp = new ResponseMsg<Boolean>();
		try {
			boolean result = false;
			int cnt = 0;
			if(StringUtils.isEmpty(category.getId())){
				//新增
				cnt = this.categoryService.addCategory(category);
			}else {
				//修改
				cnt = this.categoryService.updateCategory(category);
			}

			if (cnt > 0) {
				result = true;
			}
			String msg = "编辑数据字典信息成功!";
			if(!result) {
				msg = "编辑数据字典信息失败!";
			}
			resp.success(msg);
			resp.setData(result);
		} catch (Exception ae) {
			logger.error("编辑数据字典异常",ae);
			resp.fail("编辑数据字典异常");
		}
		return resp;
	}

	/**
	 * 删除字典树
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value="/deleteCategory",method= {RequestMethod.GET,RequestMethod.POST})
	@OperLogging(content="删除数据字典",operType=2)
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
	@RequestMapping(value="/findCategoryAttrsByCd",method= {RequestMethod.GET,RequestMethod.POST})
	@OperLogging(content="根据分类cd获取数据字典树")
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
	@RequestMapping(value="/findCategoryAttrNm",method= {RequestMethod.GET,RequestMethod.POST})
	@OperLogging(content="根据分类cd和属性cd获取数据字典配置")
	public ResponseMsg<String> findCategoryAttrNm(String categoryCd, String attrCd) throws Exception {
		ResponseMsg<String> resp = new  ResponseMsg<String>();
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
	
	/**
	 * 根据条件获取数据字典数据
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value="/findCategoryAttr",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ResponseMsg<List<CategoryAttr>> findCategoryAttr(@RequestBody CategoryAttr attr){
		ResponseMsg<List<CategoryAttr>> resp = new  ResponseMsg<List<CategoryAttr>>();
		try {
			List<CategoryAttr> categoryAttrs = categoryService.findCategoryAttrsByCd(attr);
			resp.setData(categoryAttrs);
			resp.success("获取信息成功！");
		} catch (Exception e) {
			resp.fail("获取信息失败！");
			logger.error(e.getMessage());
		}
		return resp;
	}
}
