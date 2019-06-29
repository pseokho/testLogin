package com.Springboot.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.Springboot.services.UserServiceImpl;

/**
 * @Brief Spring Security 제약 조건 설정하는 곳
 * @author p
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	UserServiceImpl usersevice;

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
	 auth.userDetailsService(usersevice).passwordEncoder(usersevice.passwordEncoder());
		 
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http
	        .authorizeRequests()
	            .antMatchers("/home/**")
	            .authenticated()
	            .antMatchers("/login/**")
	            .permitAll()
	    		.and()
	    		.httpBasic();
	}

}
