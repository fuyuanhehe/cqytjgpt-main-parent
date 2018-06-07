package com.ccttic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@MapperScan("com.ccttic.mapper")
public class ScreenWebAPIApplication {
    public static void main( String[] args ){
    	 new SpringApplicationBuilder(ScreenWebAPIApplication.class).web(true).run(args);    }
}
