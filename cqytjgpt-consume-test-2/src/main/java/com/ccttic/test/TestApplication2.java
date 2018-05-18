package com.ccttic.test;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class TestApplication2 {
    public static void main(String [] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(TestApplication2.class).web(true).run(args);
    }

    @RequestMapping("/hello2")
    public String getHello() {
        return "hello2-TestApplication2";
    }
}
