package com.ccttic.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @HystrixCommand(fallbackMethod = "name")
    public String toNameString() {
        return "this is cqytjgpt-web-api";
    }

    public String name() {
        return "this is cqytjgpt-web-api";
    }
}
