package com.Springboot.rest.servcie;

import java.io.IOException;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

@Service
public class RestServiceImpl implements RestfulService{


	public void restfulApiKkakao(String keyword) {
		Map<String, Object> rtnResult = null;
		System.out.println("restful test 들오옴");
		try {
			temp(keyword);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
	}
	@Override
	public Map<String, Object> restfulApiKkakao(Map<String, Object> param) {
		Map<String, Object> rtnResult = null;
		System.out.println("restful test 들오옴");
		
		// TODO Auto-generated method stub
		return rtnResult;
	}
	
	public void temp(String keyword) throws ClientProtocolException, IOException {
		final String USER_AGENT = "KakaoAK 1c34ad52f343baa8e023b821aa14f5a6";
	    String GET_URL = "https://dapi.kakao.com/v2/local/search/keyword.json?query=";    

	      //http client 생성
        CloseableHttpClient httpClient = HttpClients.createDefault();
        GET_URL=GET_URL+keyword;
        //get 메서드와 URL 설정
        HttpGet httpGet = new HttpGet(GET_URL);
 
        //agent 정보 설정
        httpGet.addHeader("Authorization", USER_AGENT);
        httpGet.addHeader("Content-type", "application/json");

 
        //get 요청
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
        
        System.out.println("GET Response Status");
        System.out.println(httpResponse.getStatusLine().getStatusCode());
        String json = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        
        System.out.println(json);
        
        httpClient.close();

    }




}
