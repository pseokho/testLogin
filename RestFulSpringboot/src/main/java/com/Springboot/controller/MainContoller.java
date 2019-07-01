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

import com.Springboot.rest.servcie.RestfulService;
import com.Springboot.services.SearchHistSerivce;
import com.Springboot.vo.HistSearch;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * 실제 서비스가 처리되도록 Model 역활
 * 
 * @author p
 *
 */
@Controller
public class MainContoller {
    // serach 관련 Controller
    @Autowired
    SearchHistSerivce searchController;
    // restFul연동 Controller
    @Autowired
    RestfulService restfulController;

    @RequestMapping(value = "/login")
    public String login() {

        return "";

    }

    @RequestMapping(value = "/serach", produces = "application/text; charset=utf8", method = RequestMethod.GET)
    public @ResponseBody String serach(@RequestParam Map<String, Object> param, Authentication auth)
            throws ParseException, JsonProcessingException, org.apache.tomcat.util.json.ParseException {

        JSONObject json = new JSONObject(restfulController.restfulApiKkakao(param));
        JSONArray jsonArray = new JSONArray(json.get("documents").toString());

        // 검색 완료시 Keyword가 Null 이아닌이상 검색 기록을 남겨야된다.
        String username = auth.getName();
        String keyword = param.get("keyword").toString();
        System.out.println(username);
        searchController.insertSearchHist(username, keyword);

        System.out.println( " 제대로 들어갓나 ?");
        int aa =searchController.histCount();
        System.out.println(aa);
        HistSearch aaa= searchController.LastHist();
        System.out.println(aaa.toString());
        return json.toString();
    }

    @RequestMapping(value = "/home")
    public ModelAndView loginPage(Authentication auth) {
        ModelAndView model = new ModelAndView();

        String username = auth.getName();
        model.addObject("username", username);
        model.setViewName("home");// return view 네임지정

        return model;
    }
}
