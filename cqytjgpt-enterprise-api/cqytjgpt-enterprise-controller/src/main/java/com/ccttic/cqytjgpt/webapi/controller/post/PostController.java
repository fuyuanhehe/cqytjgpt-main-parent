package com.ccttic.cqytjgpt.webapi.controller.post;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ccttic.cqytjgpt.webapi.interfaces.employee.IEmployeeService;
import com.ccttic.cqytjgpt.webapi.interfaces.post.IPostService;
import com.ccttic.entity.common.ResponseMsg;
import com.ccttic.entity.employee.EmployeePermission;
import com.ccttic.entity.employee.EmployeeVo;
import com.ccttic.entity.employee.EssEmployee;
import com.ccttic.entity.post.EssPost;
import com.ccttic.entity.post.EssPostVo;
import com.ccttic.entity.post.ObjectList;
import com.ccttic.entity.role.Department;
import com.ccttic.util.annotation.Resource;
import com.ccttic.util.annotation.ResourceScan;
import com.ccttic.util.common.Const;
import com.ccttic.util.common.JsonUtil;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageRequest;
@Api(tags="岗位管理")
@RestController
@RequestMapping("/post")
public class PostController {
    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private IPostService postService;
    @Autowired
    private IEmployeeService employeeService;

    /**
     * 分页查询岗位
     *
     * @return
     */
    @ApiOperation(value="分页查询岗位")
    @ApiImplicitParams({
            @ApiImplicitParam(name="access_token",value="token",required=true,paramType="query "),
            @ApiImplicitParam(name="postnm",value="岗位名称",required=true,paramType="form ")
    })
    @RequestMapping(value = "selectPost", method = RequestMethod.POST)
    @ResourceScan(rsc = @Resource(cd = Const.SELECT_POST, name = "岗位主页", hierarchy = 3, isMenue = true, pcd = Const.ORGANIZATION_SUPERVISE)
            , prsc = {@Resource(cd = Const.POST_MANAGEMENT,name = "岗位管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
            @Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT)})
    public ResponseMsg<Page<EssPostVo>> selectPost(@RequestParam String access_token, ServletResponse response,
                                                   @RequestBody EssPostVo post) {
        ResponseMsg<Page<EssPostVo>> rm = new ResponseMsg<>();

        EmployeeVo employee = employeeService.getUserInfo(access_token);

        EmployeePermission employeePermission = employeeService.getEmployeePermission(employee) ;
        if(null == employeePermission){
            rm.fail("该用户无数据权限");
            return rm;
        }

        try {
            PageRequest page = new PageRequest();
            page.setPage(post.getPage());
            page.setRows(post.getRows());
            Page<EssPostVo> pager = postService.selectPost(page, post, employeePermission);

            rm.setData(pager);
            rm.setMessage("获取post数据成功");
            rm.setStatus(0);
        } catch (Exception e) {
            rm.setMessage("获取post数据失败");
            rm.setStatus(-1);
            logger.info(e);
        }
        return rm;
    }

//    /**
//     * 获取所有组织
//     *
//     * @param request
//     * @param response
//     * @return
//     */
//    @RequestMapping(value = "selectAllOrganization", method = RequestMethod.POST)
//    public ResponseMsg<List<Organization>> selectAllOrganization(ServletRequest request, ServletResponse response, @RequestParam String access_token) {
//        ResponseMsg<List<Organization>> rm = new ResponseMsg<>();
//
//
//        String username = JWTUtil.getUsername(access_token);
//        // redis get data
//        EmployeeVo vo = (EmployeeVo) redisService.get(username + Const.TOKEN);
//        // 2. 判断REDIS是否为空
//        if (null != vo) {
//
//        } else {
//            EmployeeVo employee;
//            try {
//                employee = employeeService.findEmployeeByAccount(username);
//                // 3. 更新redis里用户缓存
//                redisService.set(username + Const.TOKEN, employee, Const.USER_REDIS_LIVE);
//
//            } catch (Exception e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//
//        }
//
//
//        if (vo.getCanSeeOrgs() != null && vo.getCanSeeOrgs().size() > 0) {
//            rm.setData(vo.getCanSeeOrgs());
//            rm.setMessage("获取Organization数据成功");
//            rm.setStatus(0);
//        } else {
//
//            rm.setMessage("获取Organization数据为空");
//            rm.setStatus(-1);
//        }
//
//        return rm;
//    }

    @ApiOperation(value="根据组织查询部门")
    @ApiImplicitParams({
            @ApiImplicitParam(name="orgid",value="组织id",required=true,paramType="form ")
    })
    @RequestMapping(value = "selectDepartment", method = RequestMethod.POST)
    public ResponseMsg<List<Department>> selectDepartment(@RequestBody String orgid) {
        ResponseMsg<List<Department>> rm = new ResponseMsg<>();
        Map<String, String> map = JsonUtil.jsonToMap(orgid);
        try {
            List<Department> list = postService.getDepartmentByOrg(map);
            rm.setData(list);
            rm.setMessage("获取department数据成功");
            rm.setStatus(0);
        } catch (Exception e) {


            rm.setMessage("获取department数据失败");
            rm.setStatus(-1);
            logger.info(e);
        }

        return rm;
    }

    @ApiOperation(value="根据部门查询员工")
    @ApiImplicitParams({
            @ApiImplicitParam(name="depid",value="部门id",required=true,paramType="form ")
    })
    @RequestMapping(value = "selectEmployeeByDep", method = RequestMethod.POST)
    public ResponseMsg<List<EssEmployee>> selectEmployee(@RequestBody String depid) {
        ResponseMsg<List<EssEmployee>> rm = new ResponseMsg<>();
        Map<String, String> map = JsonUtil.jsonToMap(depid);
        try {
            List<EssEmployee> list = postService.getEmployeeByDep(map);
            rm.setData(list);
            rm.setMessage("获取Employee数据成功");
            rm.setStatus(0);
        } catch (Exception e) {

            rm.setMessage("获取Employee数据失败");
            rm.setStatus(-1);
            logger.info(e);
        }

        return rm;
    }

    @ApiOperation(value="创建岗位")
    @ApiImplicitParams({
            @ApiImplicitParam(name="depId",value="部门id",required=true,paramType="form"),
            @ApiImplicitParam(name="description",value="岗位描述",required=true,paramType="form"),
            @ApiImplicitParam(name="postcd",value="岗位编号",required=true,paramType="form"),
            @ApiImplicitParam(name="postnm",value="岗位名称",required=true,paramType="form"),
            @ApiImplicitParam(name="id",value="员工id",required=false,paramType="form"),
            @ApiImplicitParam(name="account",value="员工账号",required=false,paramType="form"),
            @ApiImplicitParam(name="password",value="员工密码",required=false,paramType="form"),
            @ApiImplicitParam(name="empno",value="员工工号",required=false,paramType="form"),
            @ApiImplicitParam(name="empnm",value="员工名",required=false,paramType="form"),
            @ApiImplicitParam(name="emptype",value="员工类型",required=false,paramType="form")

    })
    @RequestMapping(value = "addpost", method = RequestMethod.POST)
    @ResourceScan(rsc = @Resource(cd = Const.ADD_POST, name = "创建岗位", hierarchy = 3, isMenue = false, pcd = Const.ORGANIZATION_SUPERVISE)
            , prsc = {@Resource(cd = Const.POST_MANAGEMENT, url = "/post/addpost", name = "岗位管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
            @Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT)})
    public ResponseMsg<String> addpost(@RequestBody EssPostVo post) {
        ResponseMsg<String> rm = new ResponseMsg<>();
        try {
            String Msg = postService.addPost(post);
            if(null !=Msg){
                rm.fail(Msg);
                return rm;
            }
            rm.setMessage("添加post数据成功");
            rm.setStatus(0);
        } catch (Exception e) {
            e.printStackTrace();
            rm.setMessage("添加post数据失败");
            rm.setStatus(-1);
            logger.info(e);
        }
        return rm;
    }
    @ApiOperation(value="修改岗位")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="id",required=true,paramType="form"),
            @ApiImplicitParam(name="depId",value="部门id",required=true,paramType="form"),
            @ApiImplicitParam(name="description",value="岗位描述",required=true,paramType="form"),
            @ApiImplicitParam(name="postcd",value="岗位编号",required=true,paramType="form"),
            @ApiImplicitParam(name="postnm",value="岗位名称",required=true,paramType="form"),
            @ApiImplicitParam(name="id",value="员工id",required=false,paramType="form"),
            @ApiImplicitParam(name="account",value="员工账号",required=false,paramType="form"),
            @ApiImplicitParam(name="password",value="员工密码",required=false,paramType="form"),
            @ApiImplicitParam(name="empno",value="员工工号",required=false,paramType="form"),
            @ApiImplicitParam(name="empnm",value="员工名",required=false,paramType="form"),
            @ApiImplicitParam(name="emptype",value="员工类型",required=false,paramType="form")

    })
    @RequestMapping(value = "updatepost", method = RequestMethod.POST)
    @ResourceScan(rsc = @Resource(cd = Const.MODIFY_POST, name = "修改岗位", hierarchy = 3, isMenue = false, pcd = Const.ORGANIZATION_SUPERVISE)
            , prsc = {@Resource(cd = Const.POST_MANAGEMENT, url = "/post/updatepost", name = "岗位管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
            @Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT)})
    public ResponseMsg<String> updatepost(@RequestBody EssPostVo post) {
        ResponseMsg<String> rm = new ResponseMsg<>();

        try {
            postService.updatePost(post);
            rm.setMessage("修改post数据成功");
            rm.setStatus(0);
        } catch (Exception e) {
            e.printStackTrace();
            rm.setMessage("修改post数据失败");
            rm.setStatus(-1);
            logger.info(e);
        }
        return rm;
    }

    /**
     * 删除岗位
     *
     * @return
     */
    @ApiOperation(value="根据部门查询员工")
    @ApiImplicitParams({
            @ApiImplicitParam(name="depid",value="部门id",required=true,paramType="form ")
    })
    @RequestMapping(value = "delpost", method = RequestMethod.POST)
    @ResourceScan(rsc = @Resource(cd = Const.DELETE_POST, name = "删除岗位", hierarchy = 3, isMenue = false, pcd = Const.ORGANIZATION_SUPERVISE)
            , prsc = {@Resource(cd = Const.POST_MANAGEMENT, url = "/post/delpost", name = "岗位管理", isMenue = true, hierarchy = 2, pcd = Const.SYSTEM_SUPERVISE),
            @Resource(cd = Const.SYSTEM_SUPERVISE, name = "系统管理", isMenue = true, hierarchy = 1, pcd = Const.ROOT)})
    public ResponseMsg<String> delpost(@RequestBody ObjectList list) {
        ResponseMsg<String> rm = new ResponseMsg<>();
        List<Map<String, String>> maps =list.listMap;
        try {
            if (maps != null ) {
                for (int i = 0; i < maps.size(); i++) {
                    postService.delPost(maps.get(i));
                }
            }
            rm.setMessage("删除post数据成功");
            rm.setStatus(0);
        } catch (Exception e) {
            e.printStackTrace();
            rm.setMessage("删除post数据失败");
            rm.setStatus(-1);
            logger.info(e);
        }
        return rm;
    }

    /**
     * 查询部门下的岗位
     *
     * @param request
     * @param post
     * @return
     */
    @RequestMapping(value = "/selectPostUnderDep", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseMsg<List<EssPost>> selectPostUnderDep(HttpServletRequest request,
                                                         @RequestBody String post) {
        ResponseMsg<List<EssPost>> rm = new ResponseMsg<List<EssPost>>();
        Map<String, String> map = JsonUtil.jsonToMap(post);

        try {
            List<EssPost> list = postService.selectPostUnderDep(map);
            rm.setData(list);
            rm.success("获得post数据成功");
        } catch (Exception e) {
            e.printStackTrace();
            rm.fail("获得post数据失败");
            logger.info(e);
        }
        return rm;
    }

}
