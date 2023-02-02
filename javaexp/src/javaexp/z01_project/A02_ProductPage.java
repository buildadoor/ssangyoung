package javaexp.z01_project;

import java.util.Scanner;

public class A02_ProductPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// book, isbn, intro, bookpage, size, ogPrice,bookPrice

		Book b1 = new Book();
		b1.setBook("하얼빈");
		b1.setOgPrice(16000);
		b1.setBookPrice(b1.getOgPrice() - (b1.getOgPrice() * 10 / 100));
		b1.setIsbn("9788954699914(895469991X)");
		b1.setBookpage(308);
		b1.setSize("136 * 196 * 27 mm /512g");
		b1.setIntro("이 책이 속한 분야\r\n" + "소설 > 한국소설 > 역사/대하소설\r\n" + "소설 > 장르소설 > 역사소설『칼의 노래』를 넘어서는 깊이와 감동\r\n"
				+ "김훈이 반드시 써내야만 했던 일생의 과업r\n" + "‘우리 시대 최고의 문장가’ ‘작가들의 작가’로 일컬어지는 소설가 김훈의 신작 장편소설 『하얼빈』이 출간되었다.\r\n"
				+ "『하얼빈』은 김훈이 작가로 활동하는 내내 인생 과업으로 삼아왔던 특별한 작품이다. 작가는 청년 시절부터\r\n"
				+ "안중근의 짧고 강렬했던 생애를 소설로 쓰려는 구상을 품고 있었고,\r\n"
				+ "안중근의 움직임이 뿜어내는 에너지를 글로 감당하기 위해 오랜 시간을 들여 ‘인간 안중근’을 깊이 이해해나갔다.\r\n"
				+ "그리고 2022년 여름, 치열하고 절박한 집필 끝에 드디어 그 결과물을 세상에 내놓게 되었다.");
		Scanner sc = new Scanner(System.in);
		System.out.println("상세페이지를 조회하시려면 'Y'를 입력하세요.");
		String ys = sc.nextLine();
		if (ys.equals("Y")) {
			System.out.println(b1.getBook() + " 상세페이지");
			System.out.println("정가: " + b1.getOgPrice());
			System.out.println("판매가: " + b1.getBookPrice());
			System.out.println("ISBN: " + b1.getIsbn());
			System.out.println("책크기 : " + b1.getSize());
			System.out.println("책소개 :" + b1.getIntro());
		} else {
			System.out.println("상세페이지 조회 종료!");
		}
	}
}

class Book {
	private String book; // 책 이름
	private String isbn; // 책 번호
	private String intro; // 책 소개
	private String size; // 책 크기
	private int ogPrice; // 정가
	private int bookPrice = ogPrice - (ogPrice * 10 / 100); // 판매가
	private int bookpage; // 쪽수

	Book() {
	}

	public Book(String book, String isbn, String intro, String size, int ogPrice, int bookPrice, int bookpage) {
		this.book = "book";
		this.isbn = "isbn";
		this.intro = "intro";
		this.size = "size";
		this.ogPrice = ogPrice;
		this.bookPrice = bookPrice;
		this.bookpage = bookpage;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getOgPrice() {
		return ogPrice;
	}

	public void setOgPrice(int ogPrice) {
		this.ogPrice = ogPrice;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	public int getBookpage() {
		return bookpage;
	}

	public void setBookpage(int bookpage) {
		this.bookpage = bookpage;
	}

}