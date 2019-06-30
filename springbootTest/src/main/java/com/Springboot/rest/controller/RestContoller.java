package com.Springboot.rest.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Springboot.mapper.UserMapper;
import com.Springboot.vo.User;

import net.minidev.json.JSONObject;

public class RestContoller {

	@Autowired
	UserMapper userMapper;

}
