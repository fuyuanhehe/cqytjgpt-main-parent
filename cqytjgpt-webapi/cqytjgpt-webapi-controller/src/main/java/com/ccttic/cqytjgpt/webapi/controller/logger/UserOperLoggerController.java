package com.ccttic.cqytjgpt.webapi.controller.logger;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccttic.cqytjgpt.webapi.client.system.UserOperLoggerFeign;
import com.ccttic.entity.common.ResponseMsg;
import com.ccttic.entity.logger.UserOperLogger;
import com.ccttic.util.annotation.OperLogging;
import com.ccttic.util.page.PageRequest;

@RestController
@RequestMapping("/operlog")
public class UserOperLoggerController {

	@Autowired
    private UserOperLoggerFeign feign;

	@RequestMapping(value="/multi",method= {RequestMethod.GET,RequestMethod.POST})
    @OperLogging(content="分页查询用户操作日志")
    public ResponseMsg<List<UserOperLogger>> findOperLogger(UserOperLogger userOperLogger, PageRequest page) {
		return feign.findOperLogger(userOperLogger, page.getPage(),page.getRows());
    }

	@RequestMapping(value="/single",method= {RequestMethod.GET,RequestMethod.POST})
    @OperLogging(content="根据ID查询用户操作日志")
    public ResponseMsg<UserOperLogger> findOperLogger(String id) {
		return feign.findOperLogger(id);
    }
}
