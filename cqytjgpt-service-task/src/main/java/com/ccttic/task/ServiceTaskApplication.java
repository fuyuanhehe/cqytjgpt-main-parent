package com.ccttic.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceTaskApplication {
    public static void main(String [] args) {
       SpringApplication.run(ServiceTaskApplication.class, args);
    }
}
