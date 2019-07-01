package com.Springboot.mapper;

import org.springframework.stereotype.Repository;

//@Repository 해당 클래스가 데이터베이스에 접근하는 클래스임을 명시
@Repository("com.Springboot.mapper.SearchMapper")
public interface SearchHist {
	//public void  insertShearchHist (SearchHistory searchHistory); //이력생성
	//INSERT INTO SearchHistory(username, keyWrod ,serachTime)  VALUES('' , '',sysdate');

}
