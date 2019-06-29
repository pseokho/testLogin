package com.Springboot.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @brief 유져 테이블에 필드값과 매칭되는 값들 Vo선언. 기본적으로 NULL값은 비허용이다. username, password
 *        ,role은 변경 되지않는 걸 가장해 setter를 사용하지않는다
 * @author pyun.
 * @deprecated tostring은 개발 시 값 확인을위해 넣어둔것으로 추후 삭제해도 무관함.
 */
@Entity // user 개체선언
@Table(name = "users")
public class User {

	@Id
	private String username;

	@Column(nullable = false)
	private String password; // 패스워드 필드

	@Column(nullable = false)
	private Boolean enable; // 로그인 횟수 초과로인한 정지 유저판단

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Role role; // 권한 관리

	@Column(nullable = false)
	private int errcount; // 로그인에러 횟수 추후에 로직 수정

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public void setErrcount(int errcount) {
		this.errcount = errcount;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public Boolean getEnable() {
		return enable;
	}

	public int getErrcount() {
		return errcount;
	}

	public Role getRole() {
		return role;
	}



	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", enable=" + enable + ", errcount=" + errcount
				+ ", role=" + role + "]";
	}

}
