package com.Springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	/*
	 * @RequestMapping(value="/", method= RequestMethod.GET) public ModelAndView
	 * rootPage() { ModelAndView model = new ModelAndView();
	 * model.addObject("login_message","hello 로그인이 필요합니다.");
	 * model.setViewName("home");//return view 네임지정 return model; }
	 * 
	 * 로그인 로직이 필요함
	 * 
	 * @RequestMapping(value="/login") public ModelAndView loginPage() {
	 * ModelAndView model = new ModelAndView();
	 * model.addObject("login_message","로그인이 필요합니다.");
	 * model.setViewName("home");//return view 네임지정 return model; }
	 */

	/*
	 * @RequestMapping("/test") public User testUserCount() throws Exception{ //
	 * fail("Not yet implemented");
	 * System.out.println(usersevice.getUserInfo("kakao")); return null;
	 * 
	 * }
	 * 
	 */

}
