package com.Springboot.services;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.Springboot.vo.User;

public interface UserService extends UserDetailsService {
	  /* 인증 레벨 */
	  Collection<GrantedAuthority> getAuthorities(String username);
	  /* 유저 확인*/
	  public User readUser(String username);
	  public PasswordEncoder passwordEncoder();
}
