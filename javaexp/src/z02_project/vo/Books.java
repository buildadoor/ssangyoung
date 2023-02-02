package z02_project.vo;

public class Books {
	private String isbn;
	private String bname;
	private String publisher;
	private String writer;
	private String genre;
	private int price;
	private String rentalwhether;
	private int classno;
	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	public Books(String bname) {
		this.bname = bname;
	}

	public Books(String isbn, String bname, String publisher, String writer, String genre, int price,
			String rentalwhether, int classno) {
		this.isbn = isbn;
		this.bname = bname;
		this.publisher = publisher;
		this.writer = writer;
		this.genre = genre;
		this.price = price;
		this.rentalwhether = rentalwhether;
		this.classno = classno;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getRentalwhether() {
		return rentalwhether;
	}
	public void setRentalwhether(String rentalwhether) {
		this.rentalwhether = rentalwhether;
	}
	public int getClassno() {
		return classno;
	}
	public void setClassno(int classno) {
		this.classno = classno;
	}
	
}
	