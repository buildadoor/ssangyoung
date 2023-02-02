package springweb.z01_vo;

public class Player {
	//name hseat hit hitRatio 
	private String name;
	private int hseat; 
	private int hit;
	private double hitRatio;
	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Player(String name, int hseat, int hit, double hitRatio) {
		this.name = name;
		this.hseat = hseat;
		this.hit = hit;
		this.hitRatio = hitRatio;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHseat() {
		return hseat;
	}
	public void setHseat(int hseat) {
		this.hseat = hseat;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public double getHitRatio() {
		return hitRatio;
	}
	public void setHitRatio(double hitRatio) {
		this.hitRatio = hitRatio;
	}
}
