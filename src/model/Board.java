package model;

import java.util.Date;

public class Board {
	private int board_no;		//넘버
	private int user_no;		//외래키 user
	private String title;		//제목
	private Date date;			//생성일
	private String content;		//내용
	private boolean is_active;	//활성화 1, 삭제시 0
	private int count;			//조회수
	private String reader;		//읽은 사람 user_no, ,로 구분
	
	public Board() {
	}
	
	public Board(int board_no, int user_no, String title, Date date, String content, boolean is_active, int count,
			String reader) {
		super();
		this.board_no = board_no;
		this.user_no = user_no;
		this.title = title;
		this.date = date;
		this.content = content;
		this.is_active = is_active;
		this.count = count;
		this.reader = reader;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
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

	public boolean isIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
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
		result = prime * result + board_no;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + count;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + (is_active ? 1231 : 1237);
		result = prime * result + ((reader == null) ? 0 : reader.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + user_no;
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
		if(other.board_no == this.board_no)
			return true;
		return false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Board [board_no=");
		builder.append(board_no);
		builder.append(", user_no=");
		builder.append(user_no);
		builder.append(", title=");
		builder.append(title);
		builder.append(", date=");
		builder.append(date);
		builder.append(", content=");
		builder.append(content);
		builder.append(", is_active=");
		builder.append(is_active);
		builder.append(", count=");
		builder.append(count);
		builder.append(", reader=");
		builder.append(reader);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
