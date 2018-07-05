package com.ccttic.logger;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableAsync
@MapperScan(basePackages = "com.ccttic.logger.mapper")
public class LoggerApplication {
    public static void main(String [] args) {
         new SpringApplicationBuilder(LoggerApplication.class).web(true).run(args);
    }
}
