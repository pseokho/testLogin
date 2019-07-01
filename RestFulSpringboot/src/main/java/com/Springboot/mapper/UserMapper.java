package com.Springboot.mapper;

import java.util.List;

import com.Springboot.vo.User;


public interface UserMapper {
	
	public User readUserInfo(String username);
    public List<String> readAuthority(String username);

	
}
