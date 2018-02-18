package com.boardgame.model;

import java.util.Date;

public class Board {
	private int boardNo;		//넘버
	private int userNo;		//외래키 user
	private String title;		//제목
	private Date date;			//생성일
	private String content;		//내용
	private boolean isActive;	//활성화 1, 삭제시 0
	private int count;			//조회수
	private String reader;		//읽은 사람 userNo, ,로 구분
	
	public Board() {
	}
	
	public Board(int boardNo, int userNo, String title, Date date, String content, boolean isActive, int count,
			String reader) {
		super();
		this.boardNo = boardNo;
		this.userNo = userNo;
		this.title = title;
		this.date = date;
		this.content = content;
		this.isActive = isActive;
		this.count = count;
		this.reader = reader;
	}

	public int getboardNo() {
		return boardNo;
	}

	public void setboardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public int getuserNo() {
		return userNo;
	}

	public void setuserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getReader() {
		return reader;
	}

	public void setReader(String reader) {
		this.reader = reader;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + boardNo;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + count;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result + ((reader == null) ? 0 : reader.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		
		Board other = (Board) obj;
		if(other.boardNo == this.boardNo)
			return true;
		return false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Board [boardNo=");
		builder.append(boardNo);
		builder.append(", userNo=");
		builder.append(userNo);
		builder.append(", title=");
		builder.append(title);
		builder.append(", date=");
		builder.append(date);
		builder.append(", content=");
		builder.append(content);
		builder.append(", isActive=");
		builder.append(isActive);
		builder.append(", count=");
		builder.append(count);
		builder.append(", reader=");
		builder.append(reader);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
