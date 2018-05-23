package com.ccttic.controller;

import com.ccttic.service.TestService;
import com.ccttic.util.logger.annotation.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/test")
    @Logger(content = "123456", remark = "test", operType = 1)
    public String getTestString() {
        return testService.toNameString();
    }
}
