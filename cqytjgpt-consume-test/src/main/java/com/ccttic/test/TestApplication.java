package com.ccttic.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class TestApplication {
    public static void main(String [] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(TestApplication.class).web(true).run(args);
    }

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hello")
    public String getHello() {
        return restTemplate.getForEntity("http://cqytjgpt-consume-test-2/hello2", String.class).getBody();
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
