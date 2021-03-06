package com.Springboot.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.JpaRepository;
@Entity // user 개체선언
@Table(name = "histSearch")
public class HistSearch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //  pk생성전략을 DB에 위임한다는 의미입니다. mysql로 보면 pk 필드를 auto_increment로 설정해 놓은 경우로 보면 됩니다.
    private long id;
    @Column(nullable = false)
	private String username  ;

	@Column(nullable = false)
	private String keyword ;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	 public interface HistSearchRepository extends JpaRepository<HistSearch, Long> {
	 }
	
}
