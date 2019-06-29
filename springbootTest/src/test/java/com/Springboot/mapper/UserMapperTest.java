package com.Springboot.mapper;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.Springboot.SpringbootTestApplication;
import com.Springboot.services.UserService;
import com.Springboot.vo.User;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringJUnitConfig(classes = SpringbootTestApplication.class)
@WebAppConfiguration
public class UserMapperTest {

	 @Autowired private UserService userService;
	    
     private User user1;
    
     @Before
     public void setup() {
          user1 = new User();
          user1.setUsername("kakao");
          user1.setPassword("kakao");
          user1.setAccountNonExpired(true);
          user1.setAccountNonLocked(true);
          user1.setCredentialsNonExpired(true);
          user1.setEnabled(true);
          user1.setAuthorities(AuthorityUtils.createAuthorityList("USER"));
     }
    
     @Test
     public void createUserTest() {

         System.out.println("-0-------------------------------------------------------------");

         PasswordEncoder passwordEncoder = userService.passwordEncoder();
         System.out.println(passwordEncoder.encode("kakao"));
          User user = userService.readUser(user1.getUsername());
          assertThat(user.getUsername(), is(user1.getUsername()));
         
          System.out.printf(user.getUsername(), is(user1.getUsername()));
          assertThat(passwordEncoder.matches("pass1", user.getPassword()), is(true));
          System.out.println("-0-------------------------------------------------------------");

          Collection<? extends GrantedAuthority> authorities1 = user1.getAuthorities();
          Iterator<? extends GrantedAuthority> it = authorities1.iterator();
          Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) user.getAuthorities();
          while (it.hasNext()) {
               GrantedAuthority authority = it.next();
               assertThat(authorities, hasItem(new SimpleGrantedAuthority(authority.getAuthority())));
          }
     }	

}
