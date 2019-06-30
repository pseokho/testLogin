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
import com.fasterxml.jackson.core.JsonProcessingException;


@Controller
public class MainContoller {

	@Autowired UserMapper userMapper;
	@Autowired RestfulService restfulColler;
	@RequestMapping(value="/login")
	public String login(){
		return "login page";
		
	}


	/* 이것도 언젠간 써먹으니까 준비해두자 http://localhost:8800/test/kakao?username=kakao*/
	@RequestMapping(value="/serach" , produces = "application/text; charset=utf8" ,method =  RequestMethod.GET)
	public @ResponseBody String serach(@RequestParam Map<String, Object> param) throws ParseException, JsonProcessingException, org.apache.tomcat.util.json.ParseException {

		String keyword =param.get("keyword").toString();
		//String jsonData = restfulColler.restfulApiKkakao(keyword); ㄱrerere

		/*
		 * JSONParser parser = new JSONParser(restfulColler.restfulApiKkakao(keyword));
		 * JSONObject json = (JSONObject) parser.parse(); JSONArray jsonArray = new
		 * JSONArray(); System.out.println("결과값2 : " + jsonArray);
		 */
		JSONObject json = new JSONObject(restfulColler.restfulApiKkakao(keyword));
		JSONArray jsonArray = new  JSONArray(json.get("documents").toString());
		//이제 됐음 개쉬운건데 씨벌 아니근데 진짜 엿같네이런거보니 존나 4시간을 안돠ㅣ서헤멧는데
		//두줄이면 되는거였음 좋은거쓰면 지금 보면 나 이거관련헤서 한 웹페이지 20개는해봄
		//이제됐네 아까 그 씨벌 거지같은거 애미뒤진거 써서 시간 낭비존나함 아니근데 이게 한두번이아님 저거 pom.xml보면 존나이상한거많음 그래서아래다 붙인거야
		//이래서 초기 셋팅 이 중요함 처음해보고 잘 저장해놔야댐 ㅇㅇㅇ이대로일딴 commit점
	
		//result.put("rtnCode", "200"); rr
		//result.put("status","SUCCESS");d
		System.out.println("---------------------------------------------------------");
		System.out.println("결과값1 : " + jsonArray); //<-- ㄱㄱ 찌 ㄱㅇㅇ어보자 ㅇㅇ 근ㄷ게 시발 나도그럼 lib좀바꿔도ㅚ겟네 좆같은거많은데
		//System.out.println("결과값2 : " + jsonArray);
		return jsonArray.toString();
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
