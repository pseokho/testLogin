package com.Springboot.rest.servcie;

import java.util.Map;

public interface RestfulService {

	//kakaoAIP연동
	public Map<String, Object> restfulApiKkakao(String keyword);

}
