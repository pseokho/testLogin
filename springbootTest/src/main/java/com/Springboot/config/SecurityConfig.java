package com.Springboot.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
//@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		//auth.inMemoryAuthentication().withUser("test").password("test");
		auth.inMemoryAuthentication().withUser("test").password("{noop}1111").roles("USER");
	}
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	            .authorizeRequests()
	            	.antMatchers("//user/**")
	            	.access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPER')")
	                .and()
	            .formLogin()
	            	.permitAll() //모든사람접근가능
	                .defaultSuccessUrl("/") //성공시 메인화면 url로
	                .and()
	            .logout()	
	                .permitAll() //모든사람접근가능
	        		.logoutSuccessUrl("/"); //성공시 루트
	    }
}
