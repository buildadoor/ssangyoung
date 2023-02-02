package z02_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javaexp.a13_database.DB;

public class UserDelete {
	private PreparedStatement pstmt;
	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public void deleteBookusers(String uname) {
		String sql = "DELETE FROM bookusers\r\n" + "WHERE uname =?";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, uname);
			System.out.println("삭제 회원수: " + pstmt.executeUpdate());
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

	public void deleteUse() {
//		// TODO Auto-generated method stub
		UserDelete dao = new UserDelete();
		Scanner sc = new Scanner(System.in);
		System.out.println("┌────────────────회원삭제────────────────┐");
		System.out.print("삭제할 회원명: ");
		String deleteuname = sc.nextLine();
		dao.deleteBookusers(deleteuname);
		System.out.println("└─────────────────삭제완료────────────────┘");

	}

}
