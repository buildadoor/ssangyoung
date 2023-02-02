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
import z02_project.vo.Calluser;

public class CheckAnswer {
	private PreparedStatement pstmt;
	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public List<Calluser> getCallAllList(int userno) {
		List<Calluser> culist = new ArrayList<Calluser>();
		String sql = "SELECT * FROM CALL WHERE usersno = ?";
		try {
			con = DB.con();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userno);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("─────────────────────────────────────상담조회─────────────────────────────────");
				System.out.println("상담 번호: " + rs.getInt("callno"));
				System.out.println("회원 번호: " + rs.getInt("usersno"));
				System.out.println("상담 내용: " + rs.getString("callcontents"));
				System.out.println("관리자 번호: " + rs.getInt("managerno"));
				System.out.println("답변 내용: " + rs.getString("callanswer"));
				System.out.println("────────────────────────────────────────────────────────────────────────────");
			}

		} catch (SQLException e) {
			System.out.println("DB에러:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반에러:" + e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}

		return culist;
	}

	public void checkuser() {
		CheckAnswer dao = new CheckAnswer();
		Scanner sc = new Scanner(System.in);
		System.out.print("회원 번호: ");
		int usersno = sc.nextInt();
		dao.getCallAllList(usersno);
		System.out.println("이전 페이지로 돌아갑니다.");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckAnswer dao = new CheckAnswer();
		Scanner sc = new Scanner(System.in);
		System.out.print("회원 번호: ");
		int usersno = sc.nextInt();
		dao.getCallAllList(usersno);
		System.out.println("이전 페이지로 돌아갑니다.");
	}
}
