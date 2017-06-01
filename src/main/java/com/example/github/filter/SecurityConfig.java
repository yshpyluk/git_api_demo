package com.example.github.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(HttpSecurity security) throws Exception {
		security
				.antMatcher("/**")
				.authorizeRequests()
				.anyRequest()
				.authenticated()
				.and().formLogin()
				.and().logout().logoutSuccessUrl("/").permitAll();
	}

	@Override
	public void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder.inMemoryAuthentication()
				.withUser("user1").password("pass1").roles("USER")
				.and()
				.withUser("admin").password("pass2").roles("USER", "ADMIN");
	}
}
