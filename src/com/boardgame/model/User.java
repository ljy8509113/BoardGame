package com.boardgame.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int userNo;		//넘버
	private String email;		//가입 이메일(id)
	private String password;	//비밀번호
	private String nickname;	//보여질 닉네임
	private Date birthday;		//생일 - 추후 연령대별 통계 쓸일 있으면 사용
	private Date joinDate;		//가입일
	private Integer failCount;	//로그인 실패 횟수
	private Set<Authority> authorities;	// 해당 사용자의 권한 목록
	
	public User() {		
	}
	
	public User(int userNo, String email, String password, String nickname, Date birthday, Date joinDate, Integer failCount) {
		super();
		this.userNo = userNo;
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.birthday = birthday;
		this.joinDate = joinDate;
		this.failCount = failCount;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Integer getFailCount() {
		return failCount;
	}

	public void setFailCount(Integer failCount) {
		this.failCount = failCount;
	}
	
	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((joinDate == null) ? 0 : joinDate.hashCode());
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + userNo;
		result = prime * result + failCount;
		result = prime * result + ((authorities == null) ? 0 : authorities.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if(other.userNo == this.userNo)
			return true;
		return false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [userNo=");
		builder.append(userNo);
		builder.append(", email=");
		builder.append(email);
		builder.append(", password=");
		builder.append(password);
		builder.append(", nickname=");
		builder.append(nickname);
		builder.append(", birthday=");
		builder.append(birthday);
		builder.append(", joinDate=");
		builder.append(joinDate);
		builder.append(", failCount=");
		builder.append(failCount);
		builder.append(", authorities=");
		builder.append(authorities);
		builder.append("]");
		return builder.toString();
	}
	
}
