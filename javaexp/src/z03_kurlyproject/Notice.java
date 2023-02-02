package z03_kurlyproject;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javaexp.a13_database.DB;

public class Notice {
	private PreparedStatement pstmt;
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	static Scanner sc = new Scanner(System.in);
	public static String scancontents,scannoticename, scanregisdate, scanenddate;
	public static int scanuserno;
	static Notice Program = new Notice();
	
	public void notice() {
	String sql = "INSERT INTO noticekurly values(?,?,?,sysdate,?)";
		try {
			System.out.println("┌────────────────────공지등록───────────────────┐");
			System.out.print("관리자 번호를 입력하세요:");
			scanuserno = sc.nextInt();
			sc.nextLine();
			System.out.print("공지사항 제목을 입력하세요:");
			scannoticename= sc.nextLine();
			System.out.print("공지사항 내용을 입력하세요\n");
			scancontents = sc.nextLine();
			System.out.print("공지 기간을 입력하세요:");
			scanenddate = sc.nextLine();
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, scanuserno);
			pstmt.setString(2, scannoticename);
			pstmt.setString(3, scancontents);
			pstmt.setString(4, scanenddate);
			rs = pstmt.executeQuery();
			con.commit();
			System.out.println("└─────────────────────────────────────────────┘");
			System.out.println("공지사항이 등록되었습니다.");
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
		Notice dao = new Notice();
		dao.notice();

//	dao.deleteProgramSelect(time1);
//	List<Program> proList = dao.programTime();
//	for(Program e:proList) {}
	}

}
