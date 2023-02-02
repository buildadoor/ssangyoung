package z03_kurlyproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javaexp.a13_database.DB;
import z03_kurlyproject.vo.User;

public class Findpw {
	private PreparedStatement pstmt;
	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public List<User> getUserAllList(String id, String rrn) {
		List<User> ulist = new ArrayList<User>();
		String sql = "SELECT PASSWORD FROM kurlyuser WHERE rrn = ? AND id = ?";
		try {
			con = DB.con();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, rrn);
	
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("────────────비밀번호찾깅───────────");
				System.out.println("id: " + rs.getString("id"));
				System.out.println("주민번호: " + rs.getString("rrn"));
				System.out.println("────────────────────────────────");
			}

		} catch (SQLException e) {
			System.out.println("DB에러:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반에러:" + e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}

		return ulist;
	}

	public void checkuser() {
		Findpw dao = new Findpw();
		Scanner sc = new Scanner(System.in);
		System.out.print("회원 번호: ");
		String id= sc.next();
		String rrn = sc.next();
		dao.getUserAllList(id,rrn);
		List<User> ulist = dao.getUserAllList(id, rrn);
		System.out.println("이전 페이지로 돌아갑니다.");
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Findpw dao = new Findpw();
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디: ");
		String id= sc.next();
		System.out.print("주민번호: ");
		String rrn = sc.next();
		dao.getUserAllList(id,rrn);
		List<User> ulist = dao.getUserAllList(id, rrn);
		//550505-1515155
		System.out.println("이전 페이지로 돌아갑니다.");
	}
}
