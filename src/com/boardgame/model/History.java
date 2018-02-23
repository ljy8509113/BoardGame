package com.boardgame.model;

import java.io.Serializable;

public class History implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int userNo;
	private int total;
	private int win;
	private int lose;
	private int stop;
	private float winningRate;
	private int gameNo;
	
	public History() {		
	}
	
	public History(int userNo, int total, int win, int lose, int stop, float winningRate, int gameNo) {
		super();
		this.userNo = userNo;
		this.total = total;
		this.win = win;
		this.lose = lose;
		this.stop = stop;
		this.winningRate = winningRate;
		this.gameNo = gameNo;
	}

	public int getuserNo() {
		return userNo;
	}

	public void setuserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}

	public int getStop() {
		return stop;
	}

	public void setStop(int stop) {
		this.stop = stop;
	}

	public float getwinningRate() {
		return winningRate;
	}

	public void setwinningRate(float winningRate) {
		this.winningRate = winningRate;
	}

	public int getgameNo() {
		return gameNo;
	}

	public void setgameNo(int gameNo) {
		this.gameNo = gameNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + gameNo;
		result = prime * result + lose;
		result = prime * result + stop;
		result = prime * result + total;
		result = prime * result + userNo;
		result = prime * result + win;
		result = prime * result + Float.floatToIntBits(winningRate);
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
		History other = (History) obj;
		if(other.gameNo == this.gameNo && other.userNo == this.userNo)
			return true;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("History [userNo=");
		builder.append(userNo);
		builder.append(", total=");
		builder.append(total);
		builder.append(", win=");
		builder.append(win);
		builder.append(", lose=");
		builder.append(lose);
		builder.append(", stop=");
		builder.append(stop);
		builder.append(", winningRate=");
		builder.append(winningRate);
		builder.append(", gameNo=");
		builder.append(gameNo);
		builder.append("]");
		return builder.toString();
	}
	
}
