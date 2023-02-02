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

public class CheckCall {
	private PreparedStatement pstmt;
	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public List<Calluser> getCallList() {
		List<Calluser> clist = new ArrayList<Calluser>();
		String sql = "SELECT * FROM CALL";
		try {
			con = DB.con();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("─────────────────────────────────────상담목록조회─────────────────────────────────");
				System.out.println("상담 번호: " + rs.getInt("callno"));
				System.out.println("회원 번호: " + rs.getInt("usersno"));
				System.out.println("게시글 조회:" + "\n" + rs.getString("callcontents"));
				System.out.println("───────────────────────────────────────────────────────────────────────────────");
			}

		} catch (SQLException e) {
			System.out.println("DB에러:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반에러:" + e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
		return clist;
	}

	public void checkcall() {
		CheckCall dao = new CheckCall();
		Scanner sc = new Scanner(System.in);
		System.out.print("상담글을 조회하시려면 'O'을 입력하세요: ");
		String pname = sc.nextLine();
		if (pname.equals("O")) {
			dao.getCallList();
		} else {
			System.out.println("이전 페이지로 돌아갑니다.");

		}
		System.out.println("이전 페이지로 돌아갑니다.");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckCall dao = new CheckCall();
		Scanner sc = new Scanner(System.in);
		System.out.print("상담글을 조회하시려면 'O'을 입력하세요: ");
		String pname = sc.nextLine();
		if (pname.equals("O")) {
			dao.getCallList();
		} else {
			System.out.println("이전 페이지로 돌아갑니다.");

		}

		System.out.println("이전 페이지로 돌아갑니다.");

	}
}
