package com.Springboot.services;

import com.Springboot.domain.User;

/**
 * 
 * @author p
 *
 */
public interface UserService {
	public User getUserByUsername(String username);
}
