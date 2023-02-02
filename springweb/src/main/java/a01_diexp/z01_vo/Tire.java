package a01_diexp.z01_vo;

public class Tire {
	private String company;
	private int price;
	public Tire() {
		super();
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Tire(String company, int price) {
		this.company = company;
		this.price = price;
	}
}
