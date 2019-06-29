package com.Springboot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.Springboot.mapper.UserMapper;
import com.Springboot.vo.User;

@RestController
public class UserContoller {

	@Autowired UserMapper userMapper;

	@RequestMapping(value="/login")
	public String login(){
		return "login page";
		
	}

	
	/* 이것도 언젠간 써먹으니까 준비해두자 http://localhost:8800/test/kakao?username=kakao*/
	@RequestMapping("/test/{name}")
	public User home(HttpServletRequest request) {
		String name =request.getParameter("username");
		System.out.println("---------------------------------------------");
		System.out.println(name);
		User user = userMapper.readUserInfo((name));          
		return user;
	}
	
	@RequestMapping(value="/home")
	public ModelAndView loginPage(Authentication auth) {
		ModelAndView model = new ModelAndView();
		if(auth !=null && auth.getName()!=null) {
			model.addObject("messeage", "welcome "+auth.getName()+" user");//매개변수 , 값
		}else {
			model.addObject("messeage", "welcome anonymouse user");//매개변수 , 값
		}
		
		model.setViewName("home");//return view 네임지정
		
		return model;
	}
}
