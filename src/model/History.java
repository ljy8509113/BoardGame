package model;

public class History {
	private int user_no;
	private int total;
	private int win;
	private int lose;
	private int stop;
	private float winning_rate;
	private int game_no;
	
	public History() {		
	}
	
	public History(int user_no, int total, int win, int lose, int stop, float winning_rate, int game_no) {
		super();
		this.user_no = user_no;
		this.total = total;
		this.win = win;
		this.lose = lose;
		this.stop = stop;
		this.winning_rate = winning_rate;
		this.game_no = game_no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
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

	public float getWinning_rate() {
		return winning_rate;
	}

	public void setWinning_rate(float winning_rate) {
		this.winning_rate = winning_rate;
	}

	public int getGame_no() {
		return game_no;
	}

	public void setGame_no(int game_no) {
		this.game_no = game_no;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + game_no;
		result = prime * result + lose;
		result = prime * result + stop;
		result = prime * result + total;
		result = prime * result + user_no;
		result = prime * result + win;
		result = prime * result + Float.floatToIntBits(winning_rate);
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
		if(other.game_no == this.game_no && other.user_no == this.user_no)
			return true;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("History [user_no=");
		builder.append(user_no);
		builder.append(", total=");
		builder.append(total);
		builder.append(", win=");
		builder.append(win);
		builder.append(", lose=");
		builder.append(lose);
		builder.append(", stop=");
		builder.append(stop);
		builder.append(", winning_rate=");
		builder.append(winning_rate);
		builder.append(", game_no=");
		builder.append(game_no);
		builder.append("]");
		return builder.toString();
	}
	
}
