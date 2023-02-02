package z02_project;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javaexp.a13_database.DB;
//책 등록 
public class Book {
	public static String scanisbn, scanbname, scanpublisher, scanwriter, scangenre, scanrentalwhether;
	public static int scanprice, scanclassno;
	private PreparedStatement pstmt;
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	static Scanner sc = new Scanner(System.in);
	static Book Book = new Book();


	public void insertBook() {
		String sql = "INSERT INTO books VALUES(?,?,?,?,?,?,sysdate,?,?)"; 
		try {
			System.out.println("┌────────────────도서등록────────────────┐");
			System.out.print("ISBN을 입력하세요:");
			scanisbn = sc.nextLine();
			System.out.print("도서명을 입력하세요:");
			scanbname = sc.nextLine();
			System.out.print("출판사를 입력하세요:");
			scanpublisher = sc.nextLine();
			System.out.print("저자를 입력하세요:");
			scanwriter = sc.nextLine();
			System.out.print("장르를 입력하세요:");
			scangenre = sc.nextLine();//date pass 
			System.out.print("가격 입력하세요:");
			scanprice = sc.nextInt();
			System.out.print("대여여부를 입력:");
			scanrentalwhether = sc.nextLine();
			sc.nextLine();
			System.out.print("책 분류번호를 입력하세요:");
			scanclassno = sc.nextInt();
			System.out.println("└──────────────────────────────────────┘");
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, scanisbn);
			pstmt.setString(2, scanbname);
			pstmt.setString(3, scanpublisher);
			pstmt.setString(4, scanwriter);
			pstmt.setString(5, scangenre);
			pstmt.setInt(6, scanprice);
			pstmt.setString(7, scanrentalwhether);
			pstmt.setInt(8, scanclassno);
			rs = pstmt.executeQuery();
			con.commit();
		} catch (SQLException e) {
			System.out.println("DB에러:"+e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("rollback 에러:"+e.getMessage());
			}
		} catch(Exception e) {
			System.out.println("일반에러:"+e.getMessage());
		}finally {
			DB.close(rs, pstmt, con);
		}
	
	}
	
	public void booksearching() {
		// TODO Auto-generated method stub
		Book dao = new Book();
		dao.insertBook();
		
	}

}
