package com.Springboot.rest.servcie;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

@Service
public class RestServiceImpl implements RestfulService {

	@Override
	public String restfulApiKkakao(String keyword) {
		String rtnResult = null; 
		try {
			rtnResult = getRestFulApiKakaoSerach(keyword);
		} catch (ParseException | IOException e) {	
			e.printStackTrace();
		}
		return rtnResult;
	}

	/**
	 * 
	 * @param keyword : 사용자가 검색한 키워드
	 * @return 리턴코드(rtnStateCode), json 데이터 형식
	 * @throws ParseException
	 * @throws IOException
	 */
	public String getRestFulApiKakaoSerach(String keyword) throws ParseException, IOException {
		
		String jsonData = null;
		final String USER_AGENT = "KakaoAK 1c34ad52f343baa8e023b821aa14f5a6";
	    String GET_URL = "https://dapi.kakao.com/v2/local/search/keyword.json?query=";    
	    try {
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
	        jsonData = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
	        
	        httpClient.close();
	    }catch (ClientProtocolException e) {
	    	e.printStackTrace();
		}
		return jsonData;

    }

}
