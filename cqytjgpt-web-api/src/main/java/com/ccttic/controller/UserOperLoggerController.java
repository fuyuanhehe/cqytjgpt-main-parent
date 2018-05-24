package com.ccttic.controller;

import com.ccttic.entity.UserOperLogger;
import com.ccttic.util.logger.worker.UserOperLoggerService;
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
@RequestMapping("/log/user")
public class UserOperLoggerController {

    private Logger logger = LoggerFactory.getLogger(UserOperLoggerController.class);

    @Autowired
    private UserOperLoggerService userOperLoggerService;

    @GetMapping("/multi")
    public Map<String, Object> findOperLogger(UserOperLogger userOperLogger, Integer startRecod, Integer offset) {
        Map<String, Object> reMap = new HashMap<>();
        Map<String, Object> params = new HashMap<>();
        try {
            if (startRecod != null && startRecod > 0) {
                if (offset == null)
                    offset = Integer.valueOf(10);
                params.put("startRecod", Integer.valueOf(startRecod - 1) * offset);
                params.put("offset", offset);
            }
            if (userOperLogger != null) {
                params.put("operType", userOperLogger.getOperType());
                params.put("operBy", userOperLogger.getOperBy());
                params.put("content", userOperLogger.getContent());
                params.put("operTime", userOperLogger.getOperTime());
                params.put("ipAddr", userOperLogger.getIpAddr());
                params.put("remark", userOperLogger.getRemark());
            }
            List<UserOperLogger> allUserOperLogger = userOperLoggerService.findAllUserOperLogger(params);
            Integer userOperLoggerCount = userOperLoggerService.findAllUserOperLoggerCount(params);
            reMap.put("data", allUserOperLogger);
            reMap.put("size", userOperLoggerCount);
            reMap.put("state", true);
            reMap.put("msg", "查询成功");
        } catch (Exception e) {
            logger.error("{}出现异常：{}", UserOperLoggerController.class.getSimpleName(), e.getMessage());
            reMap.put("state", false);
            reMap.put("msg", e.getMessage());
        }
        return reMap;
    }

    @GetMapping("/single")
    public Map<String, Object> findOperLogger(String id) {
        Map<String, Object> reMap = new HashMap<>();
        Map<String, Object> params = new HashMap<>();
        try {
            if (id == null || id.trim().length() == 0)
                throw new NullPointerException("ID不能为空");
            UserOperLogger singleUserOperLog = userOperLoggerService.findSingleUserOperLog(id);
            reMap.put("data", singleUserOperLog);
            reMap.put("state", true);
            reMap.put("msg", "查询成功");
        } catch (Exception e) {
            logger.error("{}出现异常：{}", UserOperLoggerController.class.getSimpleName(), e.getMessage());
            reMap.put("state", false);
            reMap.put("msg", e.getMessage());
        }
        return reMap;
    }
}
