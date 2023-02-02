package z03_kurlyproject.vo;

public class Product {
private String isbn;
private String fication;
private String productname;
private int price;
private String information;
private String pompany;
private String registerdate;
private int discount;
public Product() {
	super();
	// TODO Auto-generated constructor stub
}
public Product(String isbn, String fication, String productname, int price, String information, String pompany,
		String registerdate, int discount) {
	this.isbn = isbn;
	this.fication = fication;
	this.productname = productname;
	this.price = price;
	this.information = information;
	this.pompany = pompany;
	this.registerdate = registerdate;
	this.discount = discount;
}
public Product(String isbn) {
	this.isbn = isbn;
}
public Product(String isbn, int discount) {
	this.isbn = isbn;
	this.discount = discount;
}
public String getIsbn() {
	return isbn;
}
public void setIsbn(String isbn) {
	this.isbn = isbn;
}
public String getFication() {
	return fication;
}
public void setFication(String fication) {
	this.fication = fication;
}
public String getProductname() {
	return productname;
}
public void setProductname(String productname) {
	this.productname = productname;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getInformation() {
	return information;
}
public void setInformation(String information) {
	this.information = information;
}
public String getPompany() {
	return pompany;
}
public void setPompany(String pompany) {
	this.pompany = pompany;
}
public String getRegisterdate() {
	return registerdate;
}
public void setRegisterdate(String registerdate) {
	this.registerdate = registerdate;
}
public int getDiscount() {
	return discount;
}
public void setDiscount(int discount) {
	this.discount = discount;
}

}

