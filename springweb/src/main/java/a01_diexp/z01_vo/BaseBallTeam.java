package a01_diexp.z01_vo;

import java.util.Map;

//팀명, 승,무,패
public class BaseBallTeam {
	private String tname;
	private int win;
	private int draw;
	private int lose;
	public BaseBallTeam() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BaseBallTeam(String tname, int win, int draw, int lose) {
		this.tname = tname;
		this.win = win;
		this.draw = draw;
		this.lose = lose;
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
	public int getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}
	public int getLose() {
		return lose;
	}
	public void setLose(int lose) {
		this.lose = lose;
	}
	
}
