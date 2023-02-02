package z02_project;
// 도서관 
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javaexp.a13_database.DB;
//책 등록 
public class Library {
	private PreparedStatement pstmt;
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	public static String scanlocal, scanlibraryname;
	static Scanner sc = new Scanner(System.in);
	static Library Lib = new Library();
	public void Library() {
		String sql = "INSERT INTO library VALUES(?,?)"; 
		try {
			System.out.println("┌────────────────지역도서관등록────────────────┐");
			System.out.print("등록할 지역을 입력하세요:");
			scanlocal = sc.nextLine();
			System.out.print("등록할 도서관을 입력하세요:");
			scanlibraryname = sc.nextLine();
			System.out.println("└───────────────────────────────────────────┘");
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, scanlocal);
			pstmt.setString(2, scanlibraryname);

			rs = pstmt.executeQuery();
			con.commit();
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
		Library dao = new Library();
		dao.Library();
		
	}

}
