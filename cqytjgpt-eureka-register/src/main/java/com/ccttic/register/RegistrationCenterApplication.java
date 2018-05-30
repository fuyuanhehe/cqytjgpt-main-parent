package com.ccttic.register;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ConfigurableApplicationContext;

@EnableEurekaServer
@SpringBootApplication
public class RegistrationCenterApplication {
	
	
    public static void main(String [] args) {
        // 保留context
        ConfigurableApplicationContext context = new SpringApplicationBuilder(RegistrationCenterApplication.class).web(true).run(args);
    }
    
    
    
    
    
}
