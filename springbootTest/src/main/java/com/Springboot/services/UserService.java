package com.Springboot.services;

import com.Springboot.vo.User;

/**
 * 
 * @author p
 *
 */
public interface UserService {
	public User getUserByUsername(String username);
}
