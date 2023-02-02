package z02_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javaexp.a13_database.DB;
import z02_project.vo.Books;

public class BookSearching {
	private PreparedStatement pstmt;
	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public List<Books> getBooksList(Books sch) {
		List<Books> blist = new ArrayList<Books>();
		String sql = "SELECT * \r\n" + "FROM books\r\n" + "WHERE bname LIKE '%'||?||'%'";
		try {
			con = DB.con();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sch.getBname());//
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("┌────────────────도서정보────────────────┐");
				System.out.println("isbn: " + rs.getString("isbn"));
				System.out.println("도서명: " + rs.getString("bname"));
				System.out.println("출판사: " + rs.getString("publisher"));
				System.out.println("작가: " + rs.getString("writer"));
				System.out.println("장르: " + rs.getString("genre"));
				System.out.println("가격: " + rs.getInt("price"));
				System.out.println("대여가능여부: " + rs.getString("rentalwhether"));
				System.out.println("분류번호: " + rs.getInt("classno"));
				System.out.println("└──────────────────────────────────────┘");
			}
		} catch (SQLException e) {
			System.out.println("DB에러:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반에러:" + e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
		return blist;
	}

	public void booksearching() {
		// TODO Auto-generated method stub
		BookSearching dao = new BookSearching();
		Scanner sc = new Scanner(System.in);
		System.out.println("도서 검색 페이지입니다.");
		System.out.print("검색할 도서명: ");
		String bookname = sc.nextLine();
		//
		List<Books> blist = dao.getBooksList(new Books(bookname));
		System.out.println("이전 페이지로 돌아갑니다.");
		// 출판사 작가 장르 가격 대여가능여부 분류
//		for(Books b: dao.getBooksList(new Books("bookname"))) {
//				System.out.print(b.getIsbn()+"\t");
//				System.out.print(b.getBname()+"\t");
//				System.out.print(b.getPublisher()+"\t");
//				System.out.print(b.getWriter()+"\t");
//				System.out.print(b.getGenre()+"\t");
//				System.out.print(b.getPrice()+"\t");
//				System.out.print(b.getRentalwhether()+"\t");
//				System.out.print(b.getClassno()+"\n");
//				}

	}

}
