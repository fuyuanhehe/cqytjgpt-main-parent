package com.ccttic.auth.security;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.ccttic.auth.common.exception.AppException;
import com.ccttic.auth.model.Employee;
import com.ccttic.auth.model.RoleEmp;
import com.ccttic.auth.service.IEmployeeService;



/**
 * @author syao
 * @version v1.0
 */
@Component
public class DomainUserDetailsService implements UserDetailsService {

	private final Logger logger = LoggerFactory.getLogger(DomainUserDetailsService.class);
	
	@Autowired
    private  	IEmployeeService  employeeService;

	
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       System.out.println("-------------------->"+username);
        //通过账号把用户加载出来
        Employee emp =  employeeService.findEmployeeByAccount(username);
        if(emp==null){
        	return null;
        }
		//根据用户查找他的角色
        List<RoleEmp> listRloe =null;
		try {
			listRloe = employeeService.findRolesByEmpId(emp.getId());
		} catch (AppException e) {
			logger.error("查询用户失败");
			throw new UsernameNotFoundException("查询失败");
		}
        if(listRloe == null){
        	// 创建spring security安全用户
			User user = new User(emp.getAccount(), emp.getPassword(),AuthorityUtils.createAuthorityList(""));
			return user;
        }else{
        	 Set<GrantedAuthority> userAuthotities = new HashSet<>();
            for(RoleEmp re : listRloe){
            	userAuthotities.add(new SimpleGrantedAuthority("ROLE_"+re.getRoleCd()));
            }
       			// 创建spring security安全用户
       			User user = new User(emp.getAccount(), emp.getPassword(),userAuthotities);
       			return user;
        }

		

    }
}
