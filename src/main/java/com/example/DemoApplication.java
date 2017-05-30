package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import java.security.Principal;

@SpringBootApplication
//@EnableOAuth2Sso
@EnableAspectJAutoProxy
public class DemoApplication /*extends WebSecurityConfigurerAdapter*/ {

//	@Override
//	public void configure(HttpSecurity security) throws Exception {
//		security
//				.antMatcher("/**")
//				.authorizeRequests()
//				.antMatchers("/", "/login**", "/webjars/**")
//				.permitAll()
//				.anyRequest()
//				.authenticated()
//				.and().logout().logoutSuccessUrl("/").permitAll();
//	}

//	@RequestMapping(value = "/user")
//	public Principal user(Principal principal) {
//		return principal;
//	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
