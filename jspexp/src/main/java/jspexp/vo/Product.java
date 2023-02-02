package jspexp.vo;
//jspexp.vo.Product
public class Product {
	private String product;
	private int price;
	private int cnt;
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
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
	public Product(String product, int price, int cnt) {
		this.product = product;
		this.price = price;
		this.cnt = cnt;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
}
