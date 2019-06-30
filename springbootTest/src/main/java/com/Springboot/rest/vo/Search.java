package com.Springboot.rest.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity // user 개체선언
@Table(name = "serch")
@SequenceGenerator(
        name="USER_SEQ_GEN", //시퀀스 제너레이터 이름
        sequenceName="USER_SEQ", //시퀀스 이름
        initialValue=1, //시작값
        allocationSize=1 //메모리를 통해 할당할 범위 사이즈
        )

public class Search {

	@Id
    @GeneratedValue(
            strategy=GenerationType.SEQUENCE, //사용할 전략을 시퀀스로  선택
            generator="USER_SEQ_GEN" //식별자 생성기를 설정해놓은  USER_SEQ_GEN으로 설정        
            )
	private String id;
	@Temporal(TemporalType.DATE)
	private Date serachTime;
	@Column(name = "username")
	private String username;

	@Column(name = "keyword")
	private String keyWrod;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getSerachTime() {
		return serachTime;
	}

	public void setSerachTime(Date serachTime) {
		this.serachTime = serachTime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getKeyWrod() {
		return keyWrod;
	}

	public void setKeyWrod(String keyWrod) {
		this.keyWrod = keyWrod;
	}
	
	

}
