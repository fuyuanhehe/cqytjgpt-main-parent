package com.ccttic.cqytjgpt.screen.controller;

import com.ccttic.cqytjgpt.screen.interfaces.danger.IScreenService;
import com.ccttic.cqytjgpt.screen.mapper.danger.TaskDangerMapper;
import com.ccttic.entity.common.ResponseMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/task")
public class ScreenTotalTask {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private IScreenService screenService;
    @Autowired
    private TaskDangerMapper taskMapper;
    /**
     * 分区隐患信息
     */
    @RequestMapping("/areaDangerInfo")
    public ResponseMsg<List<Map<String, Object>>> areaDangerInfo() {
        ResponseMsg<List<Map<String, Object>>> response = new ResponseMsg<List<Map<String, Object>>>();
        try {
            log.info("开始查询分区隐患信息");
            List<Map<String, Object>> list = screenService.areaDangerInfo();
            //清空统计表
            screenService.deleteScreenTotal();
            screenService.insertScreenTotal(list);
            log.info("插入分区隐患信息成功");
        } catch (Exception e) {
            log.error("分区隐患信息查询失败" + e.getMessage());
            response.fail("分区隐患信息查询失败" + e.getMessage());
        }
        return response;
    }
    @RequestMapping("/etpDangerTotal")
    public ResponseMsg<List<Map<String,Object>>> etpDangerTotal(){
        ResponseMsg<List<Map<String, Object>>> response = new ResponseMsg<List<Map<String, Object>>>();

        try {
            log.info("开始查询企业隐患信息");

            Map carMap = screenService.allCar();
            // 机动车总数
            double car = (long)carMap.get("allCar");
            List<Map<String,Object>> etpList = taskMapper.allEtp();
            List<Map<String,Object>> insertList = new ArrayList<>();
            Map param = new HashMap();
            param.put("tableName","etp_danger_"+Calendar.getInstance().get(Calendar.YEAR));
            log.info("清空etpDanger表");
            taskMapper.deleteAll(param);
            param.put("list",insertList);
            int count = 0;
            for (Map m: etpList) {
                insertList.add(m);
                if(insertList.size()>100){
                    taskMapper.insertEtpTotal(param);
                    Thread.sleep(5000);
                    insertList.clear();
                    continue;
                }

                m.put("etpId",m.get("id"));
                // 获取组织机构
                Map org = taskMapper.findOrgByOrgId((String) m.get("orgId"));

                if(org.get("area_id")==null){
                    m.put("areaCd","");
                    m.put("areaNm","");
                }else{
                    Map area = taskMapper.findAreaByAreaId((String)org.get("area_id"));
                    m.put("areaCd",area.get("areaCd"));
                    m.put("areaNm",area.get("areaNm"));
                }
                m.put("orgNm",org.get("orgNm"));

               Map theMap= taskMapper.findDangerGroupByMonthByEtpId((String) m.get("id"));
               // 将对应企业每个月的隐患数插入
                if(theMap==null){
                    theMap = setDangerGroupByMonth();
                }
               m.putAll(theMap);
                // 隐患等级判断开始
              double dangerCar=taskMapper.findDangerCarByEtpId((String)m.get("id"));
              m.put("dangerCar",dangerCar);
              m.put("allCar",car);


              double firstDangerCar =taskMapper.findFirstDangerCarByEtpId((String)m.get("id"));

              double radioDanger = dangerCar/car;

                m.put("radioDangerCar",(int)(radioDanger*100));
              // 一级占比数
              double radioFirst = firstDangerCar/dangerCar;
              m.put("radioFirstDanger",(int)(radioFirst*100));
                if(dangerCar<15){
                    m.put("dangerType",0);
                    continue;
                }
              if(radioDanger>0 && radioDanger<0.2){
                  if(radioFirst>0 && radioFirst<0.3){
                      m.put("dangerType",0);
                  }
                  if(radioFirst>0.3 && radioFirst<0.5){
                      m.put("dangerType",3);
                  }
                  if(radioFirst>0.5){
                      m.put("dangerType",2);
                  }
              }else if(radioDanger>0.2 && radioDanger<0.4){
                  if(radioFirst>0 && radioFirst<0.3){
                      m.put("dangerType",3);
                  }
                  if(radioFirst>0.3 && radioFirst<0.5){
                      m.put("dangerType",2);
                  }
                  if(radioFirst>0.5){
                      m.put("dangerType",1);
                  }
              }else if(radioDanger>0.4 ){
                  if(radioFirst>0 && radioFirst<0.3){
                      m.put("dangerType",2);
                  }
                  if(radioFirst>0.3 && radioFirst<0.5){
                      m.put("dangerType",1);
                  }
                  if(radioFirst>0.5){
                      m.put("dangerType",1);
                  }
              }


            }
            taskMapper.insertEtpTotal(param);


        } catch (Exception e) {
            e.printStackTrace();
            log.error("企业隐患信息查询失败" + e.getMessage());
            response.fail("企业隐患信息查询失败" + e.getMessage());
        }
        return response;
    }
    public Map  setDangerGroupByMonth(){
        Map map = new HashMap();
        map.put("m1",0);
        map.put("m2",0);
        map.put("m3",0);
        map.put("m4",0);
        map.put("m5",0);
        map.put("m6",0);
        map.put("m7",0);
        map.put("m8",0);
        map.put("m9",0);
        map.put("m10",0);
        map.put("m11",0);
        map.put("m12",0);
        map.put("year",0);
        return map;
    }
}
