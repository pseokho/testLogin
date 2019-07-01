package com.Springboot.controller;

import java.text.ParseException;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
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
import com.Springboot.vo.HistSearch;
import com.fasterxml.jackson.core.JsonProcessingException;


@Controller
public class MainContoller {

	@Autowired UserMapper userMapper;
	@Autowired RestfulService restfulColler;
	@RequestMapping(value="/login")
	public String login(){

		return "";
		
	}


	@RequestMapping(value="/serach" , produces = "application/text; charset=utf8" ,method =  RequestMethod.GET)
	public @ResponseBody String serach(@RequestParam Map<String, Object> param) throws ParseException, JsonProcessingException, org.apache.tomcat.util.json.ParseException {

		JSONObject json = new JSONObject(restfulColler.restfulApiKkakao(param));
		JSONArray jsonArray = new  JSONArray(json.get("documents").toString());

		return json.toString();
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
