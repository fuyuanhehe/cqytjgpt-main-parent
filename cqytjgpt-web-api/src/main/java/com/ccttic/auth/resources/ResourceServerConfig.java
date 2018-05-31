package com.ccttic.auth.resources;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * 资源授权
 * @author syao
 * @version v1.0
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig  extends ResourceServerConfigurerAdapter{

//  @Value("${resource.id:spring-boot-application}")
  private String resourceId="cqytjgpt-web-api";
  
  
  
  @Autowired
  UrlAccessDecisionManager accessDecisionManager;
  
  @Autowired
  UrlFilterInvocationSecurityMetadataSource urlFilterInvocationSecurityMetadataSource;

  
    @Override
    public void configure(HttpSecurity http) throws Exception {
    	
       http.cors().and().csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
                .and()
                .authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
        			
        			@Override
        			public <O extends FilterSecurityInterceptor> O postProcess(O object) {
        				object.setSecurityMetadataSource(urlFilterInvocationSecurityMetadataSource);
        				object.setAccessDecisionManager(accessDecisionManager);
        				return object;
        			}
        		})
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .anyRequest().authenticated()
            .and()
                .httpBasic();
    	
   
	
            
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        //  resources.resourceId("order-service").stateless(true);
        resources.resourceId(resourceId);
    }
    







}
