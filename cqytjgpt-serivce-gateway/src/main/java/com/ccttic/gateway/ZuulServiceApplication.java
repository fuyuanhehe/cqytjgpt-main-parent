package com.ccttic.gateway;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
@EnableDiscoveryClient
// 扫描mapper
@MapperScan("com.ccttic.gateway.mapper")
public class ZuulServiceApplication {
    public static void main(String [] args) {
    	 SpringApplication.run(ZuulServiceApplication.class, args);
    }
}
