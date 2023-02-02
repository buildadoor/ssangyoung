package z02_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javaexp.a13_database.DB;

public class BookDelete {
	private PreparedStatement pstmt;
	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public void deleteBooks(String bname) {
		String sql = "DELETE FROM books\r\n" + "WHERE bname =?";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bname);
			System.out.println("삭제건수:" + pstmt.executeUpdate());
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

	public void DeleteBook() {
		// TODO Auto-generated method stub
		BookDelete dao = new BookDelete();
		Scanner sc = new Scanner(System.in);
		System.out.println("도서 삭제 페이지입니다.");
		System.out.print("삭제할 도서명: ");
		String deletebname = sc.nextLine();
		dao.deleteBooks(deletebname);
		System.out.println("도서 정보가 삭제되었습니다.");
	}

}
