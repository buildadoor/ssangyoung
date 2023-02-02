package z02_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javaexp.a13_database.DB;

public class CallByUser {
	public static String scancallcontents;
	public static int scanuserno, scancallno, usersno;
	private PreparedStatement pstmt;
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	static Scanner sc = new Scanner(System.in);

	public void Callcontents() {//String userno
		String sql = "INSERT INTO call values(callno_seq.NEXTval,?,?,?,?)"; 
		try {
			System.out.println("─────────────────────────────────────상담하기─────────────────────────────────");
			System.out.print("회원 번호를 입력하세요: ");
			scanuserno = sc.nextInt();
			sc.nextLine();
			System.out.print("상담 내용을 입력하세요: ");
			scancallcontents = sc.nextLine();
			System.out.println("────────────────────────────────────────────────────────────────────────────");
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, scanuserno);
			pstmt.setString(2, scancallcontents);
			pstmt.setString(3, null);
			pstmt.setString(4, null);
			rs = pstmt.executeQuery();
			con.commit();
			System.out.println("상담 등록이 완료되었습니다.");
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CallByUser dao = new CallByUser();
		dao.Callcontents();
	}

}

