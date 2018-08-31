package com.ccttic.cqytjgpt.enterpriseapi.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ResourcesAuthLoad implements CommandLineRunner {

	@Autowired
 private	UrlFilterInvocationSecurityMetadataSource soruce;
	
	@Override
	public void run(String... args) throws Exception {
		soruce.doLoadResourceDefine();

	}

}
