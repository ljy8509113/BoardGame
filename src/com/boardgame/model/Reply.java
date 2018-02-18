package com.boardgame.model;

import java.util.Date;

public class Reply {
	private int repleNo;		//넘버
	private int userNo;		//외래키 user
	private String content;		//내용
	private int boardNo;		//외래키 board boardNo
	private Date date;			//생성일
	private boolean isActive;	//활성화 1, 삭제시 0
	
	public Reply() {		
	}
	
	public Reply(int repleNo, int userNo, String content, int boardNo, Date date, boolean isActive) {
		super();
		this.repleNo = repleNo;
		this.userNo = userNo;
		this.content = content;
		this.boardNo = boardNo;
		this.date = date;
		this.isActive = isActive;
	}

	public int getrepleNo() {
		return repleNo;
	}

	public void setrepleNo(int repleNo) {
		this.repleNo = repleNo;
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

	public int getboardNo() {
		return boardNo;
	}

	public void setboardNo(int boardNo) {
		this.boardNo = boardNo;
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
		result = prime * result + boardNo;
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
		Reply other = (Reply) obj;
		if(other.boardNo == this.boardNo && repleNo == other.repleNo)
			return true;
		return false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Reply [repleNo=");
		builder.append(repleNo);
		builder.append(", userNo=");
		builder.append(userNo);
		builder.append(", content=");
		builder.append(content);
		builder.append(", boardNo=");
		builder.append(boardNo);
		builder.append(", date=");
		builder.append(date);
		builder.append(", isActive=");
		builder.append(isActive);
		builder.append("]");
		return builder.toString();
	}
	
}
