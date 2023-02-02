package jspexp.vo;

public class Computer {
	private String company;
	private int price;
	private String type;
	public Computer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Computer(String company, int price, String type) {
		this.company = company;
		this.price = price;
		this.type = type;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}

