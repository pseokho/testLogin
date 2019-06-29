package com.Springboot.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityTestController {

	@RequestMapping(value="/", method= RequestMethod.GET)
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
