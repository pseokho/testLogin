package com.Springboot.services;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.Springboot.SpringbootTestApplication;
import com.Springboot.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringJUnitWebConfig(classes= SpringbootTestApplication.class)
@WebAppConfiguration
public class UserServiceImplTest {
	
	@Autowired
	private UserService service;

	@Test
	public void testGetUserByUsername() {
		//fail("Not yet implemented");
		String username="admin";
		User user = service.getUserByUsername(username);
		System.out.println(user);
		
		assertThat(user.getPassword(), is("admin"));
	}

}
