package com.boardgame.model;

import java.io.Serializable;
import java.util.Date;

public class SubReply implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int userNo;		//외래키 user
	private String content;		//내용
	private int repleNo;		//외래키 reple repleNo
	private Date date;			//생성일
	private boolean isActive;	//활성화 1, 삭제시 0
	
	public SubReply() {
	}
	
	public SubReply(int userNo, String content, int repleNo, Date date, boolean isActive) {
		super();
		this.userNo = userNo;
		this.content = content;
		this.repleNo = repleNo;
		this.date = date;
		this.isActive = isActive;
	}

	public int getuserNo() {
		return userNo;
	}

	public void setuserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getrepleNo() {
		return repleNo;
	}

	public void setrepleNo(int repleNo) {
		this.repleNo = repleNo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result + repleNo;
		result = prime * result + userNo;
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
		SubReply other = (SubReply) obj;
		if(this.repleNo == other.repleNo && this.userNo == other.userNo)
			return true;
		return false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SubReply [userNo=");
		builder.append(userNo);
		builder.append(", content=");
		builder.append(content);
		builder.append(", repleNo=");
		builder.append(repleNo);
		builder.append(", date=");
		builder.append(date);
		builder.append(", isActive=");
		builder.append(isActive);
		builder.append("]");
		return builder.toString();
	}
	
}
