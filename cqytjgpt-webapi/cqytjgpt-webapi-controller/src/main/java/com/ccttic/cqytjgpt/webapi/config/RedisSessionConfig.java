package com.ccttic.cqytjgpt.webapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
/**
 * 
    * @ClassName: Config  
    * @Description: spring session分布式session配置
    * @author syao  
    * @date 2018年6月4日  
    *
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds=60)
public class RedisSessionConfig {
 
}