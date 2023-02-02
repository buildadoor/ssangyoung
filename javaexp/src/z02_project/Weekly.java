package z02_project;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javaexp.a13_database.DB;
//주간 프로그램 
public class Weekly {
	private PreparedStatement pstmt;
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	static Scanner sc = new Scanner(System.in);
	public static String scanpno, scanpname, scanpcontents, scanptime, scannoticedate;
	public static int scanuserno;
	static Weekly Program = new Weekly();
	
	public void Weekly() {
	String sql = "INSERT INTO program values(program_seq.NEXTval,?,\r\n"
			+ "?,\r\n"
			+ "sysdate,?,?)";
		try {
			System.out.println("─────────────────────────────────────주간프로그램───────────────────────────────────");
			System.out.print("프로그램명을 입력하세요:");
			scanpname = sc.nextLine();
			System.out.print("내용을 입력하세요:");
			scanpcontents = sc.nextLine();
			System.out.print("공지기간을 입력하세요:");
			scannoticedate = sc.nextLine();
			System.out.print("관리자 번호를 입력하세요:");
			scanuserno = sc.nextInt();
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, scanpname);
			pstmt.setString(2, scanpcontents);
			pstmt.setString(3, scannoticedate);
			pstmt.setInt(4, scanuserno);
			rs = pstmt.executeQuery();
			con.commit();
			System.out.println("───────────────────────────────────────────────────────────────────────────────");
			System.out.println("프로그램이 등록되었습니다.");
			System.out.println("이전 페이지로 돌아갑니다.");
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
		Weekly dao = new Weekly();
		dao.Weekly();

//	dao.deleteProgramSelect(time1);
//	List<Program> proList = dao.programTime();
//	for(Program e:proList) {}
	}

}
