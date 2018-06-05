package com.ccttic.controller.logger;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccttic.entity.common.beans.ResponseMsg;
import com.ccttic.entity.logger.UserOperLogger;
import com.ccttic.util.logger.annotation.OperLogging;
import com.ccttic.util.logger.worker.UserOperLoggerService;
import com.ccttic.util.page.Page;
import com.ccttic.util.page.PageRequest;

@RestController
@RequestMapping("/operlog")
public class UserOperLoggerController {

    private Logger logger = LoggerFactory.getLogger(UserOperLoggerController.class);

    @Autowired
    private UserOperLoggerService userOperLoggerService;

	@RequestMapping(value="/multi",method= {RequestMethod.GET,RequestMethod.POST})
    @OperLogging(content="分页查询用户操作日志")
    public ResponseMsg<List<UserOperLogger>> findOperLogger(UserOperLogger userOperLogger, PageRequest page) {
        ResponseMsg<List<UserOperLogger>> resp = new ResponseMsg<List<UserOperLogger>>();
        try {
        	Page<UserOperLogger> pagedLogger = userOperLoggerService.findAllUserOperLogger(userOperLogger,page);
        	resp.success("分页查询用户操作日志成功");
        	resp.setData(pagedLogger.getRecords());
        	resp.setTotal(pagedLogger.getTotalRows().intValue());
        } catch (Exception e) {
            logger.error("{}出现异常：{}", UserOperLoggerController.class.getSimpleName(), e.getMessage());
            resp.fail("分页查询用户操作日志失败");
        }
        return resp;
    }

	@RequestMapping(value="/single",method= {RequestMethod.GET,RequestMethod.POST})
    @OperLogging(content="根据ID查询用户操作日志")
    public ResponseMsg<UserOperLogger> findOperLogger(String id) {
    	ResponseMsg<UserOperLogger> resp = new ResponseMsg<UserOperLogger>();
        try {
            if (id == null || id.trim().length() == 0)
                throw new NullPointerException("ID不能为空");
            UserOperLogger singleUserOperLog = userOperLoggerService.findSingleUserOperLog(id);
            resp.success("根据ID查询用户操作日志成功");
            resp.setData(singleUserOperLog);
        } catch (Exception e) {
            logger.error("{}出现异常：{}", UserOperLoggerController.class.getSimpleName(), e.getMessage());
            resp.fail("根据ID查询用户操作日志失败");
        }
        return resp;
    }
}
