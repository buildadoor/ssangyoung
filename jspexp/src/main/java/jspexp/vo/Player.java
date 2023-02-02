package jspexp.vo;
//jspexp.vo.Player
public class Player {

	private String team;
	private String pname;
	private double score;
	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Player(String team, String pname, double score) {
		this.team = team;
		this.pname = pname;
		this.score = score;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	
}
