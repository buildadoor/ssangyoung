package z02_project;

//도서 검색 삭제 !  
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Scanner;

import javaexp.a13_database.DB;
import z02_project.vo.Books;

public class BookChange {
	private PreparedStatement pstmt;
	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public void updateBooks(String bname, Books upt) {
		String sql = "UPDATE books SET rentalwhether = ? WHERE bname = ?";
		PreparedStatement pstmt = null;
		System.out.println(sql);

		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setString(2, rentalwhether());

			System.out.println("수정건수:" + pstmt.executeUpdate());
			con.commit();
		} catch (SQLException e) {
			System.out.println("DB에러:" + e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("rollback 에러:" + e.getMessage());
			}
		} catch (Exception e) {
			System.out.println("일반에러:" + e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
	}

	private String rentalwhether() {
		// TODO Auto-generated method stub
		return null;
	}

	public void changebook() {
		// TODO Auto-generated method stub
		BookChange dao = new BookChange();
		Scanner sc = new Scanner(System.in);
		System.out.println("┌────────────────도서수정────────────────┐");
		System.out.print("수정할 도서명 : ");
		String sbname = sc.nextLine();
		System.out.print("수정할 내용 : ");
		String srentalwhether = sc.next();
		Books upt = new Books();
		System.out.println("└────────────────수정완료─────────────────┘");

	}

}
