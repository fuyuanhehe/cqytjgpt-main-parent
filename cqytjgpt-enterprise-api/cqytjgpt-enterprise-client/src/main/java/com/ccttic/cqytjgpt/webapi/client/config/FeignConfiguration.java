package com.ccttic.cqytjgpt.webapi.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.auth.BasicAuthRequestInterceptor;

@Configuration
public class FeignConfiguration{
//     @Bean
//     public Contract feignContract(){
//         return new feign.Contract.Default();
//    }

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
         return new BasicAuthRequestInterceptor("client_1","123456");
   }
}