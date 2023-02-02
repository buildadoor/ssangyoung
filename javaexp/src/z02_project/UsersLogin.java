package z02_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javaexp.a13_database.DB;

public class UsersLogin {
	private PreparedStatement pstmt;
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	static UsersLogin login = new UsersLogin();
	static Scanner sc = new Scanner(System.in);
	static String scanid, scanpassword;
	public static int checkdiv;

	public void Login() {
		System.out.println("┌────────────────로그인────────────────┐");
		System.out.print("id:");
		scanid = sc.nextLine();
		System.out.print("password:");
		scanpassword = sc.nextLine();
		System.out.println("└─────────────────────────────────────┘");
		String sql = "SELECT USERSNO  \r\n" + "FROM BOOKUSERS \r\n" + "WHERE id = ? AND PASSWORD = ?";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, scanid);
			pstmt.setString(2, scanpassword);
			rs = pstmt.executeQuery();
			rs.next();
			checkdiv = rs.getInt(1);
			// System.out.println("등록건수:" + pstmt.executeUpdate());
			con.commit();
		} catch (SQLException e) {
			// System.out.println("DB에러:" + e.getMessage());
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UsersLogin dao = new UsersLogin();
		System.out.println("이전 페이지로 돌아갑니다.");
	}
}
