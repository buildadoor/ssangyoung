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
import z02_project.vo.Return;



public class ReadKing {
	private PreparedStatement pstmt;
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	
	
	public List<Return> getReturnList(Return sch){
		List<Return> rlist = new ArrayList<Return>();
		String sql = "SELECT USERSNO,MM.RWC\r\n"
				+ "FROM(SELECT USERSNO,COUNT(RETURNWHETHER) RWC\r\n"
				+ "FROM RENTAL\r\n"
				+ "WHERE RETURNWHETHER ='O'\r\n"
				+ "GROUP BY USERSNO\r\n"
				+ "ORDER BY RWC DESC) MM\r\n"
				+ "WHERE rownum<=3"; 
 
		try {
			con = DB.con();
			pstmt = con.prepareStatement(sql); 
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("┌─────────────독서왕(top3!)────────────┐");
				System.out.println("회원번호: "+rs.getString("USERSNO"));	
				System.out.println("└────────────────────────────────────┘");				
	}
			
		} catch (SQLException e) {
			System.out.println("DB에러:"+e.getMessage());
		} catch(Exception e) {
			System.out.println("일반에러:"+e.getMessage());
		}finally {
			DB.close(rs, pstmt, con);
		}
		return rlist;
	}
public void king() {
	ReadKing dao = new ReadKing();
	Scanner sc = new Scanner(System.in); 
	System.out.print("독서왕을 조회하시려면 'O'을 입력하세요: ");
	String pname = sc.nextLine();
	if(pname.equals("O")) {
		List<Return> rlist = dao.getReturnList(new Return());
	}else {
		System.out.println("이전 페이지로 돌아갑니다.");
	}

}
	public static void main(String[] args) {
	// TODO Auto-generated method stub
	ReadKing dao = new ReadKing();
	Scanner sc = new Scanner(System.in); 
	System.out.print("독서왕을 조회하시려면 'O'을 입력하세요: ");
	String pname = sc.nextLine();
	if(pname.equals("O")) {
		List<Return> rlist = dao.getReturnList(new Return());
	}else {
		System.out.println("이전 페이지로 돌아갑니다.");
		A02_Usermenu menu = new A02_Usermenu();
		menu.main(args);
	}

		
}
}


