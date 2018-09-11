package com.ccttic.cqytjgpt.enterpriseapi.controller.warning;

import com.ccttic.cqytjgpt.enterpriseapi.interfaces.employee.IEmployeeService;
import com.ccttic.cqytjgpt.enterpriseapi.interfaces.enterprise.IEnterpriseService;
import com.ccttic.cqytjgpt.enterpriseapi.interfaces.redis.RedisService;
import com.ccttic.cqytjgpt.enterpriseapi.interfaces.warning.IWarningService;
import com.ccttic.entity.common.ResponseMsg;
import com.ccttic.entity.danger.DrDanger;
import com.ccttic.entity.danger.DrDangerVo;
import com.ccttic.entity.danger.vo.VehiDangerVo;
import com.ccttic.entity.employee.EmployeePermission;
import com.ccttic.entity.employee.EmployeeVo;
import com.ccttic.entity.enterprise.EssEnterprise;
import com.ccttic.util.annotation.Resource;
import com.ccttic.util.annotation.ResourceScan;
import com.ccttic.util.common.Const;
import com.ccttic.util.exception.AppException;
import com.ccttic.util.jwt.JWTUtil;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 预警提示
 *
 * @author admin
 */
@Api(tags = "预警提示")
@Controller
@RequestMapping("/warning")
public class WarningController implements Serializable {
    private static final long serialVersionUID = 2213999569272828267L;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private RedisService<EmployeeVo> redisService;

    @Autowired
    private IWarningService warningService;

    @Autowired
    private IEnterpriseService enterpriseService;


    @ApiOperation(value = "根据条件获取车辆预警信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access_token", value = "token", required = true, paramType = "query "),
            @ApiImplicitParam(name = "areaId", value = "区域id", required = true, paramType = "form "),
            @ApiImplicitParam(name = "ownerenterprise", value = "公司名", required = true, paramType = "form "),
            @ApiImplicitParam(name = "vehino", value = "车牌号", required = true, paramType = "form "),
            @ApiImplicitParam(name = "dangertype", value = "预警等级", required = true, paramType = "form "),
            @ApiImplicitParam(name = "scrappedstate", value = "逾期未报废", required = true, paramType = "form "),
            @ApiImplicitParam(name = "illicitstate", value = "违法未处理", required = true, paramType = "form "),
            @ApiImplicitParam(name = "overdueexaminestate", value = "逾期未检验", required = true, paramType = "form "),
            @ApiImplicitParam(name = "list", value = "企业列表", required = true, paramType = "form ")
    })
    @RequestMapping(value = "/qryVehicleList", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    @ResourceScan(rsc = @Resource(cd = Const.VEHICLE_WARNING, url = "/warning/qryVehicleList", name = "车辆预警", isMenue = true, hierarchy = 2, pcd = Const.WARNING)
            , prsc = {@Resource(cd = Const.WARNING, name = "预警提示", isMenue = true, hierarchy = 1, pcd = Const.ROOT)})
    public ResponseMsg<List<VehiDangerVo>> getVehicleWarningList(@RequestBody VehiDangerVo vdvo,
                                                                 @RequestParam String access_token) {
        ResponseMsg<List<VehiDangerVo>> resp = new ResponseMsg<List<VehiDangerVo>>();
        PageRequest page = new PageRequest();
        page.setPage(vdvo.getPage());
        page.setRows(vdvo.getRows());
        // redis get data
        EmployeeVo employee = employeeService.getUserInfo(access_token);
        ;
        if (employee == null) {
            resp.fail("查询失败！,获取用户信息失败");
            return resp;
        }
        EmployeePermission employeePermission = employeeService.getEmployeePermission(employee);

        if (null == employeePermission) {
            resp.fail("查询失败！,获取用户权限失败");
            return resp;
        }

        try {
            Page<VehiDangerVo> pager = warningService.qryVehicleList(page, vdvo, employeePermission);
            resp.setData(pager.getRecords());
            resp.setTotal(pager.getTotalRows().intValue());
            resp.success("查询成功！");
        } catch (AppException e) {
            resp.fail("查询失败！");
        }
        return resp;
    }

    @ApiOperation(value = "根据条件获取驾驶员预警信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access_token", value = "token", required = true, paramType = "query "),
            @ApiImplicitParam(name = "areaCd", value = "区域id", required = true, paramType = "form "),
            @ApiImplicitParam(name = "etpNm", value = "公司名", required = true, paramType = "form "),
            @ApiImplicitParam(name = "drivername", value = "驾驶员名", required = true, paramType = "form "),
            @ApiImplicitParam(name = "dangertype", value = "预警等级", required = true, paramType = "form "),
            @ApiImplicitParam(name = "fullstudystate", value = "满分学习", required = true, paramType = "form "),
            @ApiImplicitParam(name = "overdueproofstate", value = "逾期未报废", required = true, paramType = "form "),
            @ApiImplicitParam(name = "overdueexaminestate", value = "逾期未审验", required = true, paramType = "form "),
            @ApiImplicitParam(name = "list", value = "想要查询的企业id,不传就查所有", required = false, paramType = "form ")
    })
    @RequestMapping(value = "/qryDriverList", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    @ResourceScan(rsc = @Resource(cd = Const.DRIVER_WARNING, url = "/warning/qryDriverList", name = "驾驶员预警", isMenue = true, hierarchy = 2, pcd = Const.WARNING)
            , prsc = {@Resource(cd = Const.WARNING, name = "预警提示", isMenue = true, hierarchy = 1, pcd = Const.ROOT)})
    public ResponseMsg<Page<DrDangerVo>> getDriverWarningList(@RequestBody DrDangerVo drVO, @RequestParam String access_token) {
        ResponseMsg<Page<DrDangerVo>> resp = new ResponseMsg<Page<DrDangerVo>>();
        List<String> list = new ArrayList<>();
        PageRequest page = new PageRequest();
        List<EssEnterprise> entList ;
        page.setPage(drVO.getPage());
        page.setRows(drVO.getRows());

        EmployeeVo employee = employeeService.getUserInfo(access_token);
        ;
        if (employee == null) {
            resp.fail("查询失败！,获取用户信息失败");
            return resp;
        }
        EmployeePermission employeePermission = employeeService.getEmployeePermission(employee);

        if (null == employeePermission) {
            resp.fail("查询失败！,获取用户权限失败");
            return resp;
        }
        if (null == drVO.getList()){

            entList = enterpriseService.getSubordinateEnterprise(employeePermission.getEnterpriseId());
        }else{
            entList = new ArrayList<>();
            EssEnterprise enterprise = new EssEnterprise();
            enterprise.setId(drVO.getList().get(0));
            entList.add(enterprise);

        }
        try {
            Page<DrDangerVo> pager = warningService.qryDriverList(page, drVO,entList);
            resp.setData(pager);
            resp.success("查询成功！");
        } catch (AppException e) {
            resp.fail("查询失败！");
        }
        return resp;
    }

    @ApiOperation(value = "根据id获取车辆预警信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "预警id", required = true, paramType = "form ")
    })
    @RequestMapping(value = "/getByIdVehicleWarning", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseMsg<VehiDangerVo> getByIdVehicleWarning(@RequestBody VehiDangerVo vo) {
        ResponseMsg<VehiDangerVo> resp = new ResponseMsg<VehiDangerVo>();

        try {
            VehiDangerVo vehi = warningService.qryOneVehicle(vo);
            resp.setData(vehi);
            resp.success("查询成功！");
        } catch (AppException e) {
            resp.fail("查询失败！");
        }
        return resp;
    }

    @ApiOperation(value = "根据id获取驾驶人预警信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "预警id", required = true, paramType = "form ")
    })
    @RequestMapping(value = "/getByIdDriverWarning", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseMsg<DrDanger> getByIdDriverWarning(@RequestBody DrDanger dr) {
        ResponseMsg<DrDanger> resp = new ResponseMsg<DrDanger>();

        try {
            DrDanger driver = warningService.qryOneDriver(dr);
            resp.setData(driver);
            resp.success("查询成功！");
        } catch (AppException e) {
            resp.fail("查询失败！");
        }
        return resp;
    }

    @RequestMapping(value = "/getEnterprise", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    @ResourceScan(rsc = @Resource(cd = Const.ENTERPRISE_WARNING, url = "/warning/getEnterprise", name = "企业预警", isMenue = true, hierarchy = 2, pcd = Const.WARNING)
            , prsc = {@Resource(cd = Const.WARNING, name = "预警提示", isMenue = true, hierarchy = 1, pcd = Const.ROOT)})
    public ResponseMsg<List<EssEnterprise>> getEnterprise(@RequestParam String access_token) {
        ResponseMsg<List<EssEnterprise>> resp = new ResponseMsg<List<EssEnterprise>>();

        List<EssEnterprise> ent = null;
        String username = JWTUtil.getUsername(access_token);
        // redis get data
        EmployeeVo emp = (EmployeeVo) redisService.get(username + Const.TOKEN);

        try {
            // 2. 判断REDIS是否为空
            if (null != emp) {
                ent = emp.getCanSeeEnt();
                resp.setData(ent);
                resp.success("获取企业列表成功");
            } else {

                EmployeeVo employee = employeeService.findEmployeeByAccount(username);
                ent = employee.getCanSeeEnt();
                // 3. 更新redis里用户缓存
                redisService.set(username + Const.TOKEN, employee, Const.USER_REDIS_LIVE);
                resp.setData(ent);
                resp.success("获取企业列表成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.fail("获取企业列表失败" + e);
        }

        return resp;
    }

}
