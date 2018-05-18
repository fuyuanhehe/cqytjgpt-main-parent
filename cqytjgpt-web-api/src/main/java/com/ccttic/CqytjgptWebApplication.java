package com.ccttic;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class CqytjgptWebApplication {
    public static void main(String [] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(CqytjgptWebApplication.class).web(true).run(args);
    }
}
