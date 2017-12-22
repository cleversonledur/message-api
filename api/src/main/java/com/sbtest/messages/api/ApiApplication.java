package com.sbtest.messages.api;

import com.sbtest.messages.api.security.SecUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@SpringBootApplication
@ComponentScan("com.sbtest.messages.api")
public class ApiApplication {

	@Autowired
	SecUserDetailsService userDetailsService;
	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(userDetailsService);
	}

	public static void main(String[] args) {

		SpringApplication.run(ApiApplication.class, args);




	}
}
