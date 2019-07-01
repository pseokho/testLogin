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

import com.Springboot.mapper.SearchHistMapper;
import com.Springboot.mapper.UserMapper;
import com.Springboot.rest.servcie.RestfulService;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * 실제 서비스가 처리되도록 Model 역활
 * @author p
 *
 */
@Controller
public class MainContoller {

	
	//user 데이터 관련 mapper
	@Autowired UserMapper userMapper;
	//serach 관련 mapper
	@Autowired SearchHistMapper searchHistMapper;
	//restFul연동 Controller
	@Autowired RestfulService restfulController;
	@RequestMapping(value="/login")
	public String login(){

		return "";
		
	}


	@RequestMapping(value="/serach" , produces = "application/text; charset=utf8" ,method =  RequestMethod.GET)
	public @ResponseBody String serach(@RequestParam Map<String, Object> param) throws ParseException, JsonProcessingException, org.apache.tomcat.util.json.ParseException {

		JSONObject json = new JSONObject(restfulController.restfulApiKkakao(param));
		JSONArray jsonArray = new  JSONArray(json.get("documents").toString());

		// 검색 완료시  Keyword가 Null 이아닌이상 검색 기록을 남겨야된다.
		String username = param.get("useranme").toString();
		String keyword  = param.get("keywrod").toString();
		System.out.println("username : " + username +" keyworld : "+ keyword);
		//restfulController.insertSearchHist();
		
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
