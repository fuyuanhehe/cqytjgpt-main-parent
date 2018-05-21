package com.ccttic.task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@EnableTask
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceTaskApplication {
    public static void main(String [] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ServiceTaskApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return new HelloWorldCommandLineRunner();
    }

    public static class HelloWorldCommandLineRunner implements CommandLineRunner {
        @Override
        public void run(String... strings) throws Exception {
            System.out.println("Hello World!================================================");
        }
    }
}
