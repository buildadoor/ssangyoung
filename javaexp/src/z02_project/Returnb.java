package z02_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javaexp.a13_database.DB;
import z02_project.vo.Return;

public class Returnb {

	private PreparedStatement pstmt;
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	static Scanner sc = new Scanner(System.in);
	public static String scanreturnwhether, scanisbn;
	public static int scanuserno, scanrentalno;

	public void ReturnBook(int userno, int rentalno) {
		
		String sql = "UPDATE rental\r\n"
				+ "SET RETURNWHETHER = 'O'\r\n"
				+ "WHERE USERSNO = ?\r\n"
				+ "AND RETURNWHETHER = 'X'\r\n"
				+ "AND rentalno = ?";
		
		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			System.out.println(sql);
			pstmt.setInt(1, userno);
			pstmt.setInt(2, rentalno);
			pstmt.executeUpdate();
			con.commit();
			System.out.println("수정완료");
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
//	private String returning() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	public void Returnbo(){
		// TODO Auto-generated method stub
		Returnb dao = new Returnb();
		Scanner sc = new Scanner(System.in);
//	    String rrnpat = "^\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|[3][01])\\-[1-4][0-9]{6}$";
//        System.out.println("주민번호 검증 결과:"+srrn.matches(rrnpat)+"(이상없음)");
		// call1.insertBookusers();

		//sc.nextLine();
		System.out.println("┌────────────────도서반납────────────────┐");
		System.out.print("회원 번호를 입력하세요:");
		scanuserno = sc.nextInt();
		System.out.print("대여 번호를 입력하세요:");
		scanrentalno = sc.nextInt();
		System.out.println("└──────────────────────────────────────┘");
		System.out.println(scanuserno);
		System.out.println(scanrentalno);
		dao.ReturnBook(scanuserno, scanrentalno);
	}

}
