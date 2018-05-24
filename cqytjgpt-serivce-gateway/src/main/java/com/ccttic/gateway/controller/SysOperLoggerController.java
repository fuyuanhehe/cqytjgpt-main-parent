package com.ccttic.gateway.controller;

import com.ccttic.entity.OperLogger;
import com.ccttic.gateway.service.OperLoggerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/log")
public class SysOperLoggerController {

    private Logger logger = LoggerFactory.getLogger(SysOperLoggerController.class);

    @Autowired
    private OperLoggerService operLoggerService;

    @GetMapping("/find/syslogs")
    public Map<String, Object> findOperLogger(OperLogger operLogger, Integer startRecod, Integer offset) {
        Map<String, Object> reMap = new HashMap<>();
        Map<String, Object> params = new HashMap<>();
        try {
            if (startRecod != null && startRecod > 0) {
                if (offset == null)
                    offset = Integer.valueOf(10);
                params.put("startRecod", Integer.valueOf(startRecod - 1) * offset);
                params.put("offset", offset);
            }
            if (operLogger != null) {
                params.put("operName", operLogger.getOperName());
                params.put("url", operLogger.getUrl());
                params.put("startTime", operLogger.getStartTime());
                params.put("endTime", operLogger.getEndTime());
                params.put("success", operLogger.getSuccess());
            }
            List<OperLogger> sysOperLogger = operLoggerService.findSysOperLogger(params);
            Integer sysOperLoggerCount = operLoggerService.findSysOperLoggerCount(params);
            reMap.put("data", sysOperLogger);
            reMap.put("size", sysOperLoggerCount);
            reMap.put("state", true);
            reMap.put("msg", "查询成功");
        } catch (Exception e) {
            logger.error("{}出现异常：{}", SysOperLoggerController.class.getSimpleName(), e.getMessage());
            reMap.put("state", false);
            reMap.put("msg", e.getMessage());
        }
        return reMap;
    }

    @GetMapping("/find/single")
    public Map<String, Object> findOperLogger(String id) {
        Map<String, Object> reMap = new HashMap<>();
        Map<String, Object> params = new HashMap<>();
        try {
            if (id == null || id.trim().length() == 0)
                throw new NullPointerException("ID不能为空");
            OperLogger singleSysOperLogger = operLoggerService.findSingleSysOperLogger(id);
            reMap.put("data", singleSysOperLogger);
            reMap.put("state", true);
            reMap.put("msg", "查询成功");
        } catch (Exception e) {
            logger.error("{}出现异常：{}", SysOperLoggerController.class.getSimpleName(), e.getMessage());
            reMap.put("state", false);
            reMap.put("msg", e.getMessage());
        }
        return reMap;
    }
}
