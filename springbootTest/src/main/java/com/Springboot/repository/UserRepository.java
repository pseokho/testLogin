package com.Springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Springboot.domain.User;

/**
 * @brief JpaRepository를 사용해 유저 이름으로 데이터에베이스에서 값을 찾는다. 
 * @author p
 *
 */
public interface UserRepository extends JpaRepository<User, String>{
	public User findByUsername(String username); 

}
