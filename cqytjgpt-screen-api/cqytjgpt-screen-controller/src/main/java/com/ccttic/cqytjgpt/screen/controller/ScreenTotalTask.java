package com.ccttic.cqytjgpt.screen.controller;

import com.ccttic.cqytjgpt.screen.interfaces.danger.IScreenService;
import com.ccttic.entity.common.ResponseMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/task")
public class ScreenTotalTask {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private IScreenService screenService;
    /**
     * 分区隐患信息
     */
    @RequestMapping("/areaDangerInfo")
    public ResponseMsg<List<Map<String, Object>>> areaDangerInfo() {
        ResponseMsg<List<Map<String, Object>>> response = new ResponseMsg<List<Map<String, Object>>>();
        try {
            log.info("开始查询分区隐患信息");
            List<Map<String, Object>> list = screenService.areaDangerInfo();
            screenService.insertScreenTotal(list);
            log.info("插入分区隐患信息成功");
        } catch (Exception e) {
            log.error("分区隐患信息查询失败" + e.getMessage());
            response.fail("分区隐患信息查询失败" + e.getMessage());
        }
        return response;
    }
}
