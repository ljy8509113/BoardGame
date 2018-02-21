package com.boardgame.model;

public class Game {
	private Integer gameNo;
	private String description;
	private String title;
	private String imagePath;
	private String state;
	private String fileName;
	
	public Game() {		
	}
	
	public Game(Integer gameNo, String description, String title, String imagePath, String state, String fileName) {
		this.gameNo = gameNo;
		this.description = description;
		this.title = title;
		this.imagePath = imagePath;
		this.state = state;
		this.fileName = fileName;
	}

	public int getGameNo() {
		return gameNo;
	}

	public void setGameNo(int gameNo) {
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
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
		builder.append(", state=");
		builder.append(state);
		builder.append(", fileName=");
		builder.append(fileName);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
