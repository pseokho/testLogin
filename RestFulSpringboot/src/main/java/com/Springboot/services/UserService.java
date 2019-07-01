package com.Springboot.services;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.Springboot.vo.User;

public interface UserService extends UserDetailsService {
    /* 인증 레벨 */
    Collection<GrantedAuthority> getAuthorities(String username);
    /* 유저 확인*/
    /**
     * 사용자의 정보를확인하기위해.
     * @param username : 유저명
     * @return User에 정보를 리턴한다.
    */
    public User readUserInfo(String username);
    public PasswordEncoder passwordEncoder();
}
