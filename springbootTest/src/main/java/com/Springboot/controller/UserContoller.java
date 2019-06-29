package com.Springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	@RequestMapping(value="/home")
	public String home() {
		return "home page";
	}
	
	@RequestMapping("/test/{name}")
	public User home(String name) {
		System.out.println("---------------------------------------------");
		System.out.println(name);
		User user = userMapper.readUserInfo((name));          
		return user;
	}
	
	@RequestMapping(value="/")
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
