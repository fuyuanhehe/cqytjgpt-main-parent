package com.ccttic.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceTaskApplication {
    public static void main(String [] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ServiceTaskApplication.class, args);
    }
}
