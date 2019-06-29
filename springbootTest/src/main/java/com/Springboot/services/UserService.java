package com.Springboot.services;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.Springboot.vo.User;

public interface UserService extends UserDetailsService {
	  Collection<GrantedAuthority> getAuthorities(String username);
	  public User readUser(String username);
	  public PasswordEncoder passwordEncoder();
}
