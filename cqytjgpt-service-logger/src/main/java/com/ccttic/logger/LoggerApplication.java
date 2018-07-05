package com.ccttic.logger;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableDiscoveryClient
@EnableTransactionManagement
@EnableAsync
@MapperScan(basePackages = "com.ccttic.logger.mapper")
public class LoggerApplication {
    public static void main(String [] args) {
         new SpringApplicationBuilder(LoggerApplication.class).web(true).run(args);
    }
}
