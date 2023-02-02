package z03_kurlyproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javaexp.a13_database.DB;

public class Question {
	public static String scanquestion, scananswer;
	public static int scanuserno, scancallno;
	private PreparedStatement pstmt;
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	static Scanner sc = new Scanner(System.in);

	public void question() {
		String sql = "INSERT INTO qna values(qna_seq.NEXTval,?,?,?)"; 
		try {
			System.out.println("┌────────────────────문의하기───────────────────┐");
			System.out.print("회원번호를 입력하세요: ");
			scanuserno = sc.nextInt();
			sc.nextLine();
			System.out.print("문의내용을 입력하세요: ");
			scanquestion = sc.nextLine();
			System.out.println("└─────────────────────────────────────────────┘");
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, scanuserno);
			pstmt.setString(2, scanquestion);
			pstmt.setString(3, null);
			rs = pstmt.executeQuery();
			con.commit();
			System.out.println("질문이 등록되었습니다.");
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
		Question dao = new Question();
		dao.question();
	}

}

