package model;

import java.util.Date;

public class SubReply {
	private int user_no;		//외래키 user
	private String content;		//내용
	private int reple_no;		//외래키 reple reple_no
	private Date date;			//생성일
	private boolean is_active;	//활성화 1, 삭제시 0
	
	public SubReply() {
	}
	
	public SubReply(int user_no, String content, int reple_no, Date date, boolean is_active) {
		super();
		this.user_no = user_no;
		this.content = content;
		this.reple_no = reple_no;
		this.date = date;
		this.is_active = is_active;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReple_no() {
		return reple_no;
	}

	public void setReple_no(int reple_no) {
		this.reple_no = reple_no;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + (is_active ? 1231 : 1237);
		result = prime * result + reple_no;
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
		SubReply other = (SubReply) obj;
		if(this.reple_no == other.reple_no && this.user_no == other.user_no)
			return true;
		return false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SubReply [user_no=");
		builder.append(user_no);
		builder.append(", content=");
		builder.append(content);
		builder.append(", reple_no=");
		builder.append(reple_no);
		builder.append(", date=");
		builder.append(date);
		builder.append(", is_active=");
		builder.append(is_active);
		builder.append("]");
		return builder.toString();
	}
	
}
