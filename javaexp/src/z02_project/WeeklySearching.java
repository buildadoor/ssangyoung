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
import z02_project.vo.Bookusers;
import z02_project.vo.Week;


public class WeeklySearching {
	private PreparedStatement pstmt;
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	
	public List<Week> getWeeklyList(Week sch){
		List<Week> wlist = new ArrayList<Week>();
	
		String sql = "SELECT * FROM PROGRAM WHERE PNAME LIKE '%'||?||'%'"; 
		try {
			con = DB.con();
			pstmt = con.prepareStatement(sql); 
			pstmt.setString(1, sch.getPname());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("─────────────────────────────────────주간프로그램───────────────────────────────────");
				System.out.println("프로그램 번호: "+rs.getString("pno"));
				System.out.println("프로그램 제목: "+rs.getString("pname"));
				System.out.println("프로그램 내용:"+"\n"+rs.getString("pcontents"));
				System.out.println("게시일: "+rs.getString("ptime"));
				System.out.println("공지기간: "+rs.getString("noticedate"));
				System.out.println("관리자 번호: "+rs.getString("usersno"));
				System.out.println("───────────────────────────────────────────────────────────────────────"
						+ "──────────");				
	}
		

		} catch (SQLException e) {
			System.out.println("DB에러:"+e.getMessage());
		} catch(Exception e) {
			System.out.println("일반에러:"+e.getMessage());
		}finally {
			DB.close(rs, pstmt, con);
		}
		return wlist;
	}

public void program() {
	WeeklySearching dao = new WeeklySearching();
	Scanner sc = new Scanner(System.in); 
	System.out.print("주간 프로그램을 조회하시려면 'O'을 입력하세요: ");
	String pname = sc.nextLine();
	if(pname.equals("O")) {
		List<Week> wlist = dao.getWeeklyList(new Week());
	}else {
		System.out.println("이전 페이지로 돌아갑니다.");
		
	}
}
public static void main(String[] args) {
	// TODO Auto-generated method stub
	WeeklySearching dao = new WeeklySearching();
	Scanner sc = new Scanner(System.in); 
	System.out.print("주간 프로그램을 조회하시려면 'O'을 입력하세요: ");
	String pname = sc.nextLine();
	if(pname.equals("O")) {
		List<Week> wlist = dao.getWeeklyList(new Week());
	}else {
		System.out.println("이전 페이지로 돌아갑니다.");
		A02_Usermenu menu = new A02_Usermenu();
		menu.main(args);
	}
		

		
}
}

