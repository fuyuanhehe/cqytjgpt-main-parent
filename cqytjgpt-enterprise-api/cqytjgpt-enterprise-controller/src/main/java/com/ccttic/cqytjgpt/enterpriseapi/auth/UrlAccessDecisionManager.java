package com.ccttic.cqytjgpt.enterpriseapi.auth;

import java.util.Collection;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class UrlAccessDecisionManager implements AccessDecisionManager {
	@Override
	public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection)
			throws AccessDeniedException, AuthenticationException {
		// Iterator<ConfigAttribute> iterator = collection.iterator();
		// while (iterator.hasNext()) {
		// ConfigAttribute ca = iterator.next();
		// String role = ca.getAttribute();
		// // 当前用户所具有的权限
		// Collection<? extends GrantedAuthority> authorities =
		// authentication.getAuthorities();
		// for (GrantedAuthority authority : authorities) {
		// if (authority.getAuthority().equals(role)) {
		// return;
		// }
		// }
		// }
		// throw new AccessDeniedException("权限不足!");

	}

	@Override
	public boolean supports(ConfigAttribute configAttribute) {
		return true;
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return true;
	}
}
