package com.ccttic.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

@EnableTurbineStream
@EnableDiscoveryClient
@EnableHystrixDashboard
@SpringBootApplication
public class HystrixDashBoardApp {
    public static void main(String [] args) {
       SpringApplication.run(HystrixDashBoardApp.class, args);
    }
}
