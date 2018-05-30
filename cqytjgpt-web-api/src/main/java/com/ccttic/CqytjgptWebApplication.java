package com.ccttic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.ccttic.mapper")
@EnableFeignClients
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class CqytjgptWebApplication {
    public static void main(String [] args) {
        new SpringApplicationBuilder(CqytjgptWebApplication.class).web(true).run(args);
    }
}
