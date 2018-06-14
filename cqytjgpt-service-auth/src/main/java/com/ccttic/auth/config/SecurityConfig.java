package com.ccttic.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;

import com.ccttic.auth.security.DomainUserDetailsService;
import com.ccttic.auth.security.AuthenticationProviderExt;

/**
 * web 安全控制
 * @author syao
 * @version v1.0
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationProviderExt authenticationProvider;
	
	@Autowired
	private DomainUserDetailsService userDetail;

    @Bean
    public UserDetailsService userDetailsService(){
//        return new DomainUserDetailsService();
    	return userDetail;
    }


//  @Bean
//  public PasswordEncoder passwordEncoder() {
//      return new PasswordEncodes();
//  }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
//                .passwordEncoder(passwordEncoder());
        auth.authenticationProvider(authenticationProvider);
    }

    @Bean
    public SecurityEvaluationContextExtension securityEvaluationContextExtension() {
        return new SecurityEvaluationContextExtension();
    }

    //不定义没有password grant_type
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }



}
