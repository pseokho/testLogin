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

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	UserServiceImpl usersevice;

	//단, 사용자 데이터는 애플리케이션 실행 시점에 생성합니다.
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception{

/*		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("select username, password, role form users where username=?");*/
		//password encoding
		PasswordEncoder encoder =PasswordEncoderFactories.createDelegatingPasswordEncoder();
		 auth.userDetailsService(usersevice).passwordEncoder(usersevice.passwordEncoder());
		 

		/*
		 * int count = usersevice.getUserCount();
		 * 
		 * System.out.println("user 수는 :"+count); for(int i=0;i<count;i++) {
		 * 
		 * auth.inMemoryAuthentication().
		 * withUser(usersevice.getTotalUserInfo().get(i).getUsername())
		 * .password(encoder.encode(usersevice.getTotalUserInfo().get(i).getPassword()))
		 * .roles("USER");
		 * 
		 * System.out.print("withUser('"+usersevice.getTotalUserInfo().get(i).
		 * getUsername()+"')");
		 * System.out.print(".password("+usersevice.getTotalUserInfo().get(i).
		 * getPassword()+")");
		 * System.out.println(encoder.encode(usersevice.getTotalUserInfo().get(i).
		 * getPassword())); }
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
