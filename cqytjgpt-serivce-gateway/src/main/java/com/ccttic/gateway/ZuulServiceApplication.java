package com.ccttic.gateway;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@EnableZuulProxy
@SpringBootApplication
@EnableDiscoveryClient
// 扫描mapper
@MapperScan("com.ccttic.gateway.mapper")
public class ZuulServiceApplication {
    public static void main(String [] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ZuulServiceApplication.class).web(true).run(args);
    }
}
