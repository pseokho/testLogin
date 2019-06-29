package com.Springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	//단, 사용자 데이터는 애플리케이션 실행 시점에 생성합니다.
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		//password encoding
		PasswordEncoder encoder =PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication().withUser("user")
		.password(encoder.encode("1234")).roles("USER");
		
		/*
		 * auth.inMemoryAuthentication().withUser("user")
		 * .password("1234").roles("USER");
		 */
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
