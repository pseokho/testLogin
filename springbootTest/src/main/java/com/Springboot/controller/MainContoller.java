package com.Springboot.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.Springboot.mapper.UserMapper;
import com.Springboot.rest.servcie.RestfulService;

import net.minidev.json.JSONObject;

@Controller
public class MainContoller {

	@Autowired UserMapper userMapper;
	@Autowired RestfulService restfulColler;
	@RequestMapping(value="/login")
	public String login(){
		return "login page";
		
	}


	/* 이것도 언젠간 써먹으니까 준비해두자 http://localhost:8800/test/kakao?username=kakao*/
	@RequestMapping(value="/serach"  ,method =  RequestMethod.GET)
	public @ResponseBody JSONObject serach(@RequestParam Map<String, Object> param) {
		JSONObject result= new JSONObject();
		String keyword =param.get("keyword").toString(); 
		System.out.println(keyword);
				
		result.put("result",restfulColler.restfulApiKkakao(keyword)); 
		result.put("status","SUCCESS");
	
		System.out.println("결과값은 :"+result);
		return result;
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