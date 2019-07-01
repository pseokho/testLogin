package com.Springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@MapperScan(value={"com.Springboot.mapper"})
@EnableWebSecurity
public class RestFulSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestFulSpringbootApplication.class, args);
	}

}
