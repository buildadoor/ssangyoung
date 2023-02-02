package springweb.z01_vo;

public class Team {
	private String tname;
	private int win;
	private int lose;
	private int draw;
	private int goal;
	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Team(String tname, int win, int lose, int draw, int goal) {
		this.tname = tname;
		this.win = win;
		this.lose = lose;
		this.draw = draw;
		this.goal = goal;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
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
	public int getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}
	public int getGoal() {
		return goal;
	}
	public void setGoal(int goal) {
		this.goal = goal;
	}
	
}
