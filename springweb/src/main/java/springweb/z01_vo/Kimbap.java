package springweb.z01_vo;

public class Kimbap {
	private int price;
	private int cnt;
	private int tot;
	public Kimbap() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Kimbap(int price, int cnt, int tot) {
		this.price = price;
		this.cnt = cnt;
		this.tot = tot;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	
}
