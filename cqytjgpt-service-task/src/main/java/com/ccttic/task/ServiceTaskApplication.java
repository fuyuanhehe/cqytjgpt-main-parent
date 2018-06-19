package com.ccttic.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ImportResource;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@ImportResource(locations = {"classpath:quartz-triggers.xml"})
public class ServiceTaskApplication {
    public static void main(String [] args) {
        SpringApplication.run(ServiceTaskApplication.class, args);
    }
}
