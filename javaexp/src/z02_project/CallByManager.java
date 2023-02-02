package z02_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javaexp.a13_database.DB;
import javaexp.a13_database.vo.Dept;
import z02_project.vo.Books;
import z02_project.vo.Calluser;

public class CallByManager {
	public static String scancallanswer;
	public static int scanuserno, scancallno, scanusersno, scanmanagerno;
	private PreparedStatement pstmt;
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	static Scanner sc = new Scanner(System.in);

	public void Callbymanager(String callanswer, int managerno, int callno ) {
		String sql = "UPDATE CALL SET callanswer = ?, managerno = ? \r\n"
				+ "WHERE callno = ?";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, callanswer);
			pstmt.setInt(2, managerno);
			pstmt.setInt(3, callno);
			System.out.println("답변건수:" + pstmt.executeUpdate());
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
	
	public void CallManager() {
		CallByManager dao = new CallByManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("─────────────────────────────────────상담답변─────────────────────────────────");
		System.out.print("답변할 상담 번호를 입력하세요:");
		scancallno = sc.nextInt();
		System.out.print("관리자 번호를 입력하세요:");
		scanmanagerno = sc.nextInt();
		sc.nextLine();
		System.out.print("답변 내용을 입력하세요:");
		scancallanswer = sc.nextLine();
		System.out.println("────────────────────────────────────────────────────────────────────────────");
		dao.Callbymanager(scancallanswer,scanmanagerno,scancallno);
	}

}