package com.ccttic.test.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RefreshScope
@RestController
public class TestController {
    @Value("${name}")
    private String name;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hello")
    public String getHello() {
        return restTemplate.getForEntity("http://cqytjgpt-consume-test-2/hello2", String.class).getBody() + "----" + name;
    }

}
