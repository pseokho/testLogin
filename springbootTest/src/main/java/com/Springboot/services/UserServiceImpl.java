package com.Springboot.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.Springboot.mapper.UserMapper;
import com.Springboot.vo.User;

@Service
public class UserServiceImpl implements UserMapper {
	
	@Resource(name = "com.Springboot.mapper.UserMapper")
	UserMapper userdMapper;
	@Override
	public int getUserCount() throws Exception {
		// TODO Auto-generated method stub
		int uCount = userdMapper.getUserCount();
		return uCount;
	}

	@Override
	public List<User> getTotalUserInfo() throws Exception {
		// TODO Auto-generated method stub
		 List<User>  users = userdMapper.getTotalUserInfo();
		return users;
	}

	@Override
	public User getUserInfo(String username) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("qerqerqerqereqrqereqrqer : "  + username);
		User user = userdMapper.getUserInfo(username);
		return user;
	}
	
}
