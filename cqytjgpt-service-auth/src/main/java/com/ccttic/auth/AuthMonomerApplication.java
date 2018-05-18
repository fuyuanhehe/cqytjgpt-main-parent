package com.ccttic.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableDiscoveryClient
@EnableTransactionManagement
@MapperScan(basePackages = "com.ccttic.auth.mapper")
public class AuthMonomerApplication {
    public static void main(String [] args) {
         new SpringApplicationBuilder(AuthMonomerApplication.class).web(true).run(args);
    }
}
