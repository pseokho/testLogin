package com.Springboot.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.header.writers.frameoptions.WhiteListedAllowFromStrategy;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;

import com.Springboot.services.UserServiceImpl;

/**
 * @Brief Spring Security 제약 조건 설정하는 곳
 * @author p
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserServiceImpl usersevice;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usersevice).passwordEncoder(usersevice.passwordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*
         * http .authorizeRequests() .antMatchers("/home/**") .authenticated()
         * .antMatchers("/**") .permitAll() .and() .httpBasic();
         */
        http.authorizeRequests().antMatchers("/h2-console/**").permitAll().anyRequest().authenticated().and().csrf()
                .ignoringAntMatchers("/h2-console/**").and().headers().addHeaderWriter(
                        new XFrameOptionsHeaderWriter(new WhiteListedAllowFromStrategy(Arrays.asList("localhost")) // 여기!
                        )).and().httpBasic();
        

        http.sessionManagement()
          .maximumSessions(1)  // 같은 아이디로 1명만 로그인 할 수 있음
          .maxSessionsPreventsLogin(false) // 신규 로그인 사용자의 로그인이 허용되고, 기존 사용자는 세션아웃 됨
          .and();
    }

}
