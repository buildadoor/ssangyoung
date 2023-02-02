package z03_kurlyproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javaexp.a13_database.DB;

public class Answer {
	
	public static void main(String[] args) {}
		// TODO Auto-generated method stub
		public static String scananswer;
		public static int scancallno;
		private PreparedStatement pstmt;
		private Connection con;
		private Statement stmt;
		private ResultSet rs;
		static Scanner sc = new Scanner(System.in);

		public void answer(String answer, int callno ) {
			String sql ="UPDATE qna SET ANSWER = ? WHERE callno = ?";
			try {
				con = DB.con();
				con.setAutoCommit(false);
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, answer);
				pstmt.setInt(2, callno);
				System.out.println("답변이 등록되었습니다.");
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
		
		public void answer() {
			Answer dao = new Answer();
			Scanner sc = new Scanner(System.in);
			System.out.println("┌────────────────────문의답변───────────────────┐");
			System.out.print("답변할 게시글 번호를 입력하세요:");
			scancallno = sc.nextInt();
			sc.nextLine();
			System.out.print("답변 내용을 입력하세요:");
			scananswer = sc.nextLine();
			System.out.println("└─────────────────────────────────────────────┘");
			dao.answer(scananswer,scancallno);
		}


}
