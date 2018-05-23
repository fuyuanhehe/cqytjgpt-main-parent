package com.ccttic.auth.config;

import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncodes implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		return (String) rawPassword;
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
//		rawPassword=rawPassword+"123";
		if(rawPassword.equals(encodedPassword)){
			return true;
		}
		return false;
	}

}
