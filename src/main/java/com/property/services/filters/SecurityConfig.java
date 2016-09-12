package com.property.services.filters;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder.inMemoryAuthentication().withUser("rest").password("rest").roles("REST");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("CSRF DISABLED");
		http
		  .csrf().disable();
	}
  
  
}
