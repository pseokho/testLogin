package com.Springboot;

import javax.annotation.PostConstruct;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.Springboot.services.UserService;

@SpringBootApplication
@MapperScan(value = { "com.Springboot.mapper" })
@EnableWebSecurity
public class RestFulSpringbootApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RestFulSpringbootApplication.class, args);
    }
    @Autowired
    UserService userService;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public void run(String... args) throws Exception {
        String user = "root";
        String pwd = passwordEncoder.encode("root");
        userService.createUsers(user, pwd);
        userService.createUserAuthority(user);
    }

}
