package com.ccttic.common.listener;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.data.redis.config.annotation.web.http.RedisHttpSessionConfiguration;
/**
 * 
    * @ClassName: Config  
    * @Description: spring session分布式session配置
    * @author syao  
    * @date 2018年6月4日  
    *
 */
@Configuration
@EnableRedisHttpSession
public class Config {
 
    @Value("${spring.redis.host:localhost}")
    String HostName;
    
    @Value("${spring.redis.port:6379}")
    int Port;

    @Bean
    public JedisConnectionFactory connectionFactory() {
        JedisConnectionFactory connection = new JedisConnectionFactory();
        connection.setPort(Port);
        connection.setHostName(HostName);
        return connection;
    }
    
    @Bean
    public RedisHttpSessionConfiguration creae(){
    	return new RedisHttpSessionConfiguration();
    }
}