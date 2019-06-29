package com.Springboot.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.Springboot.vo.User;


//@Repository 해당 클래스가 데이터베이스에 접근하는 클래스임을 명시
@Repository("com.Springboot.mapper.UserMapper")
public interface UserMapper {
	
	public User readUserInfo(String username);
    public List<String> readAuthority(String username);

	
}
