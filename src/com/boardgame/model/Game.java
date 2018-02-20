package com.boardgame.model;

import java.util.Date;

public class Game {
	private int gameNo;
	private String description;
	private String title;
	private String imagePath;
	private Date openDate;
	private String state;
	
	public Game() {		
	}
	
	public Game(int gameNo, String description, String title, String imagePath, Date openDate,
			String state) {
		super();
		this.gameNo = gameNo;
		this.description = description;
		this.title = title;
		this.imagePath = imagePath;
		this.openDate = openDate;
		this.state = state;
	}

	public int getgameNo() {
		return gameNo;
	}

	public void setgameNo(int gameNo) {
		this.gameNo = gameNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getimagePath() {
		return imagePath;
	}

	public void setimagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Date getopenDate() {
		return openDate;
	}

	public void setopenDate(Date openDate) {
		this.openDate = openDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + gameNo;
		result = prime * result + ((imagePath == null) ? 0 : imagePath.hashCode());
		result = prime * result + ((openDate == null) ? 0 : openDate.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Game other = (Game) obj;
		if(other.gameNo == this.gameNo)
			return true;
		return false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Game [gameNo=");
		builder.append(gameNo);
		builder.append(", description=");
		builder.append(description);
		builder.append(", title=");
		builder.append(title);
		builder.append(", imagePath=");
		builder.append(imagePath);
		builder.append(", openDate=");
		builder.append(openDate);
		builder.append(", state=");
		builder.append(state);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
