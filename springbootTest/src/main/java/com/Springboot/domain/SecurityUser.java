package com.Springboot.domain;

import org.springframework.security.core.authority.AuthorityUtils;

public class SecurityUser extends  org.springframework.security.core.userdetails.User {
	

	private User user;
	
	public SecurityUser(User user) {
		super(user.getUsername(),user.getPassword(),
				AuthorityUtils.createAuthorityList(user.getRole().toString()));
		this.user=user;
	}
	public User getUser() {
		return user;
	}

	public Role getRole() {
		return user.getRole();
	}
	
	
	

}
