package com.boardgame.model;

public class Admin {
	private int no;				//넘버
	private String id;			//아이디
	private String password;	//비밀번호
	private String name;		//닉네임
	
	public Admin() {
	}

	public Admin(int no, String id, String password, String name) {
		this.no = no;
		this.id = id;
		this.password = password;
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminUser [no=");
		builder.append(no);
		builder.append(", id=");
		builder.append(id);
		builder.append(", password=");
		builder.append(password);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}
	
}
