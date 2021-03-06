package com.ccttic.cqytjgpt.screen.controller;

import java.util.List;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ccttic.cqytjgpt.screen.interfaces.danger.IScreenService;
import com.ccttic.entity.common.ResponseMsg;

/**
 * @author zzy 源头监管大屏展示
 */
@RestController
@RequestMapping("/screen")
@Api(tags="大屏监管")
public class ScreenController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IScreenService screenService;


    // 查询全市接入驾驶员
    @RequestMapping(value="allDriver",method = RequestMethod.POST)
    @ApiOperation(value="查询全市接入的驾驶员")
    public ResponseMsg<Map<String, Object>> allDriver() {
        ResponseMsg<Map<String, Object>> response = new ResponseMsg<Map<String, Object>>();
        try {
            Map<String, Object> map = screenService.allDriver();
            response.setData(map);
            response.success("全市接入驾驶员查询成功");
        } catch (Exception e) {
            log.error("全市接入驾驶员查询失败" + e.getMessage());
            response.fail("全市接入驾驶员查询失败" + e.getMessage());
        }
        return response;
    }

    // 查询全市接入机动车
    @RequestMapping(value="allCar",method = RequestMethod.POST)
    @ApiOperation(value="查询全市接入的机动车")
    public ResponseMsg<Map<String, Object>> allCar() {
        ResponseMsg<Map<String, Object>> response = new ResponseMsg<Map<String, Object>>();
        try {
            Map<String, Object> map = screenService.allCar();
            response.setData(map);
            response.success("全市接入机动车查询成功");
        } catch (Exception e) {
            log.error("全市接入机动车查询失败" + e.getMessage());
            response.fail("全市接入机动车查询失败" + e.getMessage());
        }
        return response;
    }

    // 查询全市接入企业
    @RequestMapping(value="allEnterprise",method = RequestMethod.POST)
    @ApiOperation(value="查询全市接入的企业")
    public ResponseMsg<Map<String, Object>> allEnterprise() {
        ResponseMsg<Map<String, Object>> response = new ResponseMsg<Map<String, Object>>();
        try {
            Map<String, Object> map = screenService.allEnterprise();
            response.setData(map);
            response.success("全市接入企业查询成功");
        } catch (Exception e) {
            log.error("全市接入企业查询失败" + e.getMessage());
            response.fail("全市接入企业查询失败" + e.getMessage());
        }
        return response;
    }

    // 查询分所
    @RequestMapping(value="findPlace",method = RequestMethod.POST)
    @ApiOperation(value="查询所有分所")
    public ResponseMsg<List<Map<String, Object>>> findPlace() {
        ResponseMsg<List<Map<String, Object>>> response = new ResponseMsg<List<Map<String, Object>>>();
        try {
            List<Map<String, Object>> list = screenService.findPlace();
            response.setData(list);
            response.success("分所信息查询成功");
        } catch (Exception e) {
            log.error("分所信息查询失败" + e.getMessage());
            response.fail("分所信息查询失败" + e.getMessage());
        }
        return response;
    }


    // 驾驶人隐患发现情况
    @RequestMapping(value="findDangerForDriver",method = RequestMethod.POST)
    @ApiOperation(value="查询驾驶人隐患发现情况")
    public ResponseMsg<Map<String, Object>> findDangerForDriver() {
        ResponseMsg<Map<String, Object>> response = new ResponseMsg<Map<String, Object>>();
        try {
            Map<String, Object> map = screenService.findDangerForDriver();
            response.setData(map);
            response.success("驾驶人隐患发现情况查询成功");
        } catch (Exception e) {
            log.error("驾驶人隐患发现情况查询失败" + e.getMessage());
            response.fail("驾驶人隐患发现情况查询失败" + e.getMessage());
        }
        return response;
    }

    /**
     * 机动车隐患发现情况
     */
    @RequestMapping(value="findDangerForCar",method = RequestMethod.POST)
    @ApiOperation(value="查询机动车隐患发现情况")
    public ResponseMsg<Map<String, Object>> findDangerForCar() {
        ResponseMsg<Map<String, Object>> response = new ResponseMsg<Map<String, Object>>();
        try {
            Map<String, Object> map = screenService.findDangerForCar();
            response.setData(map);
            response.success("机动车隐患发现情况查询成功");
        } catch (Exception e) {
            log.error("机动车隐患发现情况查询失败" + e.getMessage());
            response.fail("机动车隐患发现情况查询失败" + e.getMessage());
        }
        return response;
    }
    /**
     * 企业隐患发现情况
     */
    @RequestMapping(value="findDangerForEnterprise",method = RequestMethod.POST)
    @ApiOperation(value="查询企业隐患发现情况")
    public ResponseMsg<Map<String, Object>> findDangerForEnterprise() {
        ResponseMsg<Map<String, Object>> response = new ResponseMsg<Map<String, Object>>();
        try {
            Map<String, Object> map = screenService.findDangerForEnterprise();
            response.setData(map);
            response.success("企业隐患发现情况查询成功");
        } catch (Exception e) {
            log.error("企业隐患发现情况查询失败" + e.getMessage());
            response.fail("企业隐患发现情况查询失败" + e.getMessage());
        }
        return response;
    }

    /**
     * 驾驶员隐患问题分布情况
     */
    @RequestMapping(value="distributionDangerForDriver",method = RequestMethod.POST)
    @ApiOperation(value="查询驾驶人隐患分布情况")
    // dateMap 暂时没用了
    public ResponseMsg<List<Map<String, Object>>> distributionDangerForDriver(@RequestBody Map<String, Object> dateMap) {
        ResponseMsg<List<Map<String, Object>>> response = new ResponseMsg<List<Map<String, Object>>>();
        // dateMap 年季月
        try {
            List<Map<String, Object>> map = screenService.distributionDangerForDriver(dateMap);
            response.setData(map);
            response.success("驾驶员隐患问题分布情况查询成功");
        } catch (Exception e) {
            log.error("驾驶员隐患问题分布情况查询失败" + e.getMessage());
            response.fail("驾驶员隐患问题分布情况查询失败" + e.getMessage());
        }
        return response;
    }

    /**
     * 机动车隐患问题分布情况
     *
     * @param dateMap year年 season季 month月
     */
    @RequestMapping(value="distributionDangerForCar",method = RequestMethod.POST)
    @ApiOperation(value="查询机动车隐患分布情况")
    public ResponseMsg<List<Map<String, Object>>> distributionDangerForCar(@RequestBody Map<String, Object> dateMap) {
        ResponseMsg<List<Map<String, Object>>> response = new ResponseMsg<List<Map<String, Object>>>();
        // dateMap 年季月
        try {
            List<Map<String, Object>> map = screenService.distributionDangerForCar(dateMap);
            response.setData(map);
            response.success("机动车隐患问题分布情况查询成功");
        } catch (Exception e) {
            log.error("机动车隐患问题分布情况查询失败" + e.getMessage());
            response.fail("机动车隐患问题分布情况查询失败" + e.getMessage());
        }
        return response;

    }
    /**
     * 企业隐患问题分布情况
     * @param dateMap year年 season季 month月
     */
    @RequestMapping(value="distributionDangerForEnterprise",method = RequestMethod.POST)
    @ApiOperation(value="查询企业隐患分布情况")
    public ResponseMsg<List<Map<String, Object>>> distributionDangerForEnterprise(@RequestBody Map<String, Object> dateMap) {
        ResponseMsg<List<Map<String, Object>>> response = new ResponseMsg<List<Map<String, Object>>>();
        // dateMap 年季月
        try {
            List<Map<String, Object>> map = screenService.distributionDangerForEnterprise(dateMap);
            response.setData(map);
            response.success("企业隐患问题分布情况查询成功");
        } catch (Exception e) {
            log.error("企业隐患问题分布情况查询失败" + e.getMessage());
            response.fail("企业隐患问题分布情况查询失败" + e.getMessage());
        }
        return response;

    }

    /**
     * 驾驶员隐患治理结果分析
     */
    @RequestMapping(value="handleDangerForDriver",method = RequestMethod.POST)
    @ApiOperation(value="查询驾驶员隐患治理结果分析")
    public ResponseMsg<Map<String, Object>> handleDangerForDriver() {
        ResponseMsg<Map<String, Object>> response = new ResponseMsg<Map<String, Object>>();
        try {
            Map<String, Object> map = screenService.handleDangerForDriver();
            response.setData(map);
            response.success("驾驶员隐患治理结果分析查询成功");
        } catch (Exception e) {
            log.error("驾驶员隐患治理结果分析查询失败" + e.getMessage());
            response.fail("驾驶员隐患治理结果分析查询失败" + e.getMessage());
        }
        return response;
    }

    /**
     * 机动车隐患治理结果分析
     */
    @RequestMapping(value="handleDangerForCar",method = RequestMethod.POST)
    @ApiOperation(value="查询机动车隐患治理结果分析")
    public ResponseMsg<Map<String, Object>> handleDangerForCar() {
        ResponseMsg<Map<String, Object>> response = new ResponseMsg<Map<String, Object>>();
        try {
            log.info("开始查询处理过的机动车");
            Map<String, Object> map = screenService.handleDangerForCar();
            response.setData(map);
            response.success("机动车隐患治理结果分析查询成功");
        } catch (Exception e) {
            log.error("机动车隐患治理结果分析查询失败" + e.getMessage());
            response.fail("机动车隐患治理结果分析查询失败" + e.getMessage());
        }
        return response;
    }
    /**
     * 企业隐患治理结果分析
     */
    @RequestMapping(value="handleDangerForEnterprise",method = RequestMethod.POST)
    @ApiOperation(value="查询企业隐患治理结果分析")
    public ResponseMsg<Map<String, Object>> handleDangerForEnterprise() {
        ResponseMsg<Map<String, Object>> response = new ResponseMsg<Map<String, Object>>();
        try {
            log.info("开始查询处理过的企业");
            Map<String, Object> map = screenService.handleDangerForEnterprise();
            response.setData(map);
            response.success("企业隐患治理结果分析查询成功");
        } catch (Exception e) {
            log.error("企业隐患治理结果分析查询失败" + e.getMessage());
            response.fail("企业隐患治理结果分析查询失败" + e.getMessage());
        }
        return response;
    }

    /**
     * 驾驶员整治效果趋势分析
     */
    @RequestMapping(value="resultDangerForDriver",method = RequestMethod.POST)
    @ApiOperation(value="查询驾驶员隐患治理趋势分析")
    public ResponseMsg<Map<String, Object>> resultDangerForDriver() {
        ResponseMsg<Map<String, Object>> response = new ResponseMsg<Map<String, Object>>();
        try {
            log.info("开始查询驾驶员整治效果趋势");
            Map<String, Object> map = screenService.resultDangerForDriver();
            response.setData(map);
            response.success("驾驶员整治效果趋势分析查询成功");
        } catch (Exception e) {
            log.error("驾驶员整治效果趋势分析查询失败" + e.getMessage());
            response.fail("驾驶员整治效果趋势分析查询失败" + e.getMessage());
        }
        return response;
    }

    /**
     * 机动车整治效果趋势分析
     */
    @RequestMapping(value="resultDangerForCar",method = RequestMethod.POST)
    @ApiOperation(value="查询机动车隐患治理趋势分析")
    public ResponseMsg<Map<String, Object>> resultDangerForCar() {
        ResponseMsg<Map<String, Object>> response = new ResponseMsg<Map<String, Object>>();
        try {
            log.info("开始查询机动车整治效果趋势");
            Map<String, Object> map = screenService.resultDangerForCar();
            response.setData(map);
            response.success("查询成功");
        } catch (Exception e) {
            log.error("机动车整治效果趋势分析查询失败" + e.getMessage());
            response.fail("机动车整治效果趋势分析查询失败" + e.getMessage());
        }
        return response;
    }
    /**
     * 企业整治效果趋势分析
     */
    @RequestMapping(value="resultDangerForEnterprise",method = RequestMethod.POST)
    @ApiOperation(value="查询企业隐患治理趋势分析")
    public ResponseMsg<Map<String, Object>> resultDangerForEnterprise() {
        ResponseMsg<Map<String, Object>> response = new ResponseMsg<Map<String, Object>>();
        try {
            log.info("开始查询企业整治效果趋势");
            Map<String, Object> map = screenService.resultDangerForEnterprise();
            response.setData(map);
            response.success("查询成功");
        } catch (Exception e) {
            log.error("企业整治效果趋势分析查询失败" + e.getMessage());
            response.fail("企业整治效果趋势分析查询失败" + e.getMessage());
        }
        return response;
    }

    /**
     * 分区隐患信息
     */
    @RequestMapping(value="areaDangerInfo",method = RequestMethod.POST)
    @ApiOperation(value="查询大地图信息")
    public ResponseMsg<List<Map<String, Object>>> areaDangerInfo() {
        ResponseMsg<List<Map<String, Object>>> response = new ResponseMsg<List<Map<String, Object>>>();
        try {
            log.info("开始查询分区隐患信息");
            // 从统计表里面去拿 由定时任务跑出来
            List<Map<String, Object>> map = screenService.areaInfoTotal();
            response.setData(map);
            response.success("分区隐患信息查询成功");
        } catch (Exception e) {
            log.error("分区隐患信息查询失败" + e.getMessage());
            response.fail("分区隐患信息查询失败" + e.getMessage());
        }
        return response;
    }


    /**
     * 隐患驾驶员通报
     * @param map top 第几条
     */
    @RequestMapping(value="noticeDangerForDriver",method = RequestMethod.POST)
    @ApiOperation(value="查询隐患驾驶员通报")
    @ApiImplicitParams({
            @ApiImplicitParam(name="top",value="查询条数，{top:1}",required=true,paramType="body"),
    })
    public ResponseMsg<Map<String, Object>> noticeDangerForDriver(@RequestBody Map<String, Object> map) {
        ResponseMsg<Map<String, Object>> response = new ResponseMsg<Map<String, Object>>();
        try {
            log.info("开始查询隐患驾驶员通报");
            Map<String, Object> driver = screenService.noticeDangerForDriver(map);
            response.setData(driver);
            response.success("隐患驾驶员通报查询成功");
        } catch (Exception e) {
            log.error("隐患驾驶员通报查询失败" + e.getMessage());
            response.fail("隐患驾驶员通报查询失败" + e.getMessage());
        }
        return response;
    }

    /**
     * 机动车通报
     * @param map top 第几条
     */
    @RequestMapping(value="noticeDangerForCar",method = RequestMethod.POST)
    @ApiOperation(value="查询隐患机动车通报")
    @ApiImplicitParams({
            @ApiImplicitParam(name="top",value="查询条数，{top:1}",required=true,paramType="body"),
    })
    public ResponseMsg<Map<String, Object>> noticeDangerForCar(@RequestBody Map<String, Object> map) {
        ResponseMsg<Map<String, Object>> response = new ResponseMsg<Map<String, Object>>();
        try {
            log.info("开始查询隐患机动车通报");
            Map<String, Object> vehiDanger = screenService.noticeDangerForCar(map);
            response.setData(vehiDanger);
            response.success("隐患机动车通报查询成功");
        } catch (Exception e) {
            log.error("隐患机动车通报查询失败" + e.getMessage());
            response.fail("隐患机动车通报查询失败" + e.getMessage());
        }
        return response;
    }
    /**
     * 企业通报
     * @param map top 第几条
     */
    @RequestMapping(value="noticeDangerForEnterprise",method = RequestMethod.POST)
    @ApiOperation(value="查询隐患企业通报")
    @ApiImplicitParams({
            @ApiImplicitParam(name="top",value="查询条数，{top:1}",required=true,paramType="body"),
    })
    public ResponseMsg<Map<String, Object>> noticeDangerForEnterprise(@RequestBody Map<String, Object> map) {
        ResponseMsg<Map<String, Object>> response = new ResponseMsg<Map<String, Object>>();
        try {
            log.info("开始查询隐患企业通报");
            Map<String, Object> entDanger = screenService.noticeDangerForEnterprise(map);
            response.setData(entDanger);
            response.success("隐患企业通报查询成功");
        } catch (Exception e) {
            log.error("隐患企业通报查询失败" + e.getMessage());
            response.fail("隐患企业通报查询失败" + e.getMessage());
        }
        return response;
    }

    /**
     * 各区隐患排名
     */
    @RequestMapping(value="areaDangersTop",method = RequestMethod.POST)
    @ApiOperation(value="查询各区隐患排名")
    public ResponseMsg<List<Map<String, Object>>> areaDangersTop() {
        ResponseMsg<List<Map<String, Object>>> response = new ResponseMsg<List<Map<String, Object>>>();
        try {
            log.info("开始查询各区隐患排行");
            List<Map<String, Object>> topList = screenService.areaDangersTop();
            response.setData(topList);
            response.success("各区隐患排名查询成功");
        } catch (Exception e) {
            log.error("各区隐患排名查询失败" + e.getMessage());
            response.fail("各区隐患排名查询失败" + e.getMessage());
        }
        return response;
    }
    /**
     * 各区治理排名
     */
    @RequestMapping(value="areaHandleDangersTop",method = RequestMethod.POST)
    @ApiOperation(value="查询各区治理排名")
    public ResponseMsg<List<Map<String, Object>>> areaHandleDangersTop() {
        ResponseMsg<List<Map<String, Object>>> response = new ResponseMsg<List<Map<String, Object>>>();
        try {
            log.info("开始查询各区治理排行");
            List<Map<String, Object>> topList = screenService.areaHandleDangersTop();
            response.setData(topList);
            response.success("各区治理排名查询成功");
        } catch (Exception e) {
            log.error("各区治理排名查询失败" + e.getMessage());
            response.fail("各区治理排名查询失败" + e.getMessage());
        }
        return response;
    }
    /**
     * 各区驾驶员隐患占比
     */
    @RequestMapping(value="ratioDangerForDriver",method = RequestMethod.POST)
    @ApiOperation(value="查询各区驾驶员隐患占比")
    public ResponseMsg<List<Map<String, Object>>> ratioDangerForDriver() {
        ResponseMsg<List<Map<String, Object>>> response = new ResponseMsg<List<Map<String, Object>>>();
        try {
            log.info("开始查询各区驾驶员占比");
            List<Map<String, Object>> topList = screenService.ratioDangerForDriver();
            response.setData(topList);
            response.success("各区驾驶员隐患占比查询成功");
        } catch (Exception e) {
            log.error("各区驾驶员隐患占比查询失败" + e.getMessage());
            response.fail("各区驾驶员隐患占比查询失败" + e.getMessage());
        }
        return response;
    }

    /**
     * 各区机动车隐患占比
     */
    @RequestMapping(value="ratioDangerForCar",method = RequestMethod.POST)
    @ApiOperation(value="查询各区机动车隐患占比")
    public ResponseMsg<List<Map<String, Object>>> ratioDangerForCar() {
        ResponseMsg<List<Map<String, Object>>> response = new ResponseMsg<List<Map<String, Object>>>();
        try {
            log.info("开始查询各区机动车占比");
            List<Map<String, Object>> topList = screenService.ratioDangerForCar();
            response.setData(topList);
            response.success("各区机动车隐患占比查询成功");
        } catch (Exception e) {
            log.error("各区机动车隐患占比查询失败" + e.getMessage());
            response.fail("各区机动车隐患占比查询失败" + e.getMessage());
        }
        return response;
    }

    /**
     * 各区企业隐患占比
     */
    @RequestMapping(value="ratioDangerForEnterprise",method = RequestMethod.POST)
    @ApiOperation(value="查询各区企业隐患占比")
    public ResponseMsg<List<Map<String, Object>>> ratioDangerForEnterprise() {
        ResponseMsg<List<Map<String, Object>>> response = new ResponseMsg<List<Map<String, Object>>>();
        try {
            log.info("开始查询各区企业占比");
            List<Map<String, Object>> topList = screenService.ratioDangerForEnterprise();
            response.setData(topList);
            response.success("各区企业隐患占比查询成功");
        } catch (Exception e) {
            log.error("各区企业隐患占比查询失败" + e.getMessage());
            response.fail("各区企业隐患占比查询失败" + e.getMessage());
        }
        return response;
    }

    /**
     * 各分所驾驶员治理情况
     * @param map orgId 分所id
     */
    @RequestMapping(value="deptDangerForDriver",method = RequestMethod.POST)
    @ApiOperation(value="查询各分所驾驶员治理情况")
    @ApiImplicitParams({
            @ApiImplicitParam(name="orgId",value="分所id，{orgId:1}",required=true,paramType="body"),
    })
    public ResponseMsg<Map<String, Object>> deptDangerForDriver(@RequestBody Map<String, Object> map) {
        ResponseMsg<Map<String, Object>> response = new ResponseMsg<Map<String, Object>>();

        // map 不同分所   ，驾驶人或机动车
        try {
            log.info("开始查询各分所驾驶员治理情况");
            Map<String, Object> tempMap = screenService.deptDangerForDriver(map);
            response.setData(tempMap);
            response.success("各分所驾驶员治理情况查询成功");
        } catch (Exception e) {
            log.error("各分所驾驶员治理情况查询失败" + e.getMessage());
            response.fail("各分所驾驶员治理情况查询失败" + e.getMessage());
        }
        return response;
    }

    /**
     * 各分所机动车治理情况
     * @param map orgId 分所id
     */
    @RequestMapping(value="deptDangerForCar",method = RequestMethod.POST)
    @ApiOperation(value="查询各分所机动车治理情况")
    @ApiImplicitParams({
            @ApiImplicitParam(name="orgId",value="分所id，{orgId:1}",required=true,paramType="body"),
    })
    public ResponseMsg<Map<String, Object>> deptDangerForCar(@RequestBody Map<String, Object> map) {
        ResponseMsg<Map<String, Object>> response = new ResponseMsg<Map<String, Object>>();
        try {
            log.info("开始查询各分所机动车治理情况");
            Map<String, Object> tempMap = screenService.deptDangerForCar(map);
            response.setData(tempMap);
            response.success("各区机动车治理情况查询成功");
        } catch (Exception e) {
            log.error("各区机动车治理情况查询失败" + e.getMessage());
            response.fail("各区机动车治理情况查询失败" + e.getMessage());
        }
        return response;
    }
    /**
     * 各分所企业治理情况
     * @param map orgId 分所id
     */
    @RequestMapping(value="deptDangerForEnterprise",method = RequestMethod.POST)
    @ApiOperation(value="查询各分所企业治理情况")
    @ApiImplicitParams({
            @ApiImplicitParam(name="orgId",value="分所id，{orgId:1}",required=true,paramType="body"),
    })
    public ResponseMsg<Map<String, Object>> deptDangerForEnterprise(@RequestBody Map<String, Object> map) {
        ResponseMsg<Map<String, Object>> response = new ResponseMsg<Map<String, Object>>();
        try {
            log.info("开始查询各分所企业治理情况");
            Map<String, Object> tempMap = screenService.deptDangerForCar(map);
            response.setData(tempMap);
            response.success("各区企业治理情况查询成功");
        } catch (Exception e) {
            log.error("各区企业治理情况查询失败" + e.getMessage());
            response.fail("各区企业治理情况查询失败" + e.getMessage());
        }
        return response;
    }
} 
