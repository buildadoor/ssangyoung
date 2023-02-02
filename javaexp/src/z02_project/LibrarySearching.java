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
import z02_project.vo.Libraries;

public class LibrarySearching {
	private PreparedStatement pstmt;
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	
	public List<Libraries> getLibrariesList(Libraries sch) {
		List<Libraries> llist = new ArrayList<Libraries>();
		String sql = "SELECT * FROM library WHERE local = ?";
		try {
			con = DB.con();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sch.getLocal());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("┌────────────────도서관────────────────┐");
				System.out.println("지역: " + rs.getString("local"));
				System.out.println("도서관명: " + rs.getString("libraryname"));
				System.out.println("└─────────────────────────────────────┘");
			}
		} catch (SQLException e) {
			System.out.println("DB에러:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반에러:" + e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
		return llist;
	}
public void searchinglib() 	{
	LibrarySearching dao = new LibrarySearching();
	Scanner sc = new Scanner(System.in);
	System.out.println("검색할 지역을 입력하세요");
	System.out.print("지역: ");
	String local = sc.nextLine();
	List<Libraries> llist = dao.getLibrariesList(new Libraries(local));
	System.out.println("이전 페이지로 돌아갑니다.");
}


public static void main(String[] args) {
	//public static void main(String[] args) {
		// TODO Auto-generated method stub
		LibrarySearching dao = new LibrarySearching();
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 지역을 입력하세요");
		System.out.print("지역: ");
		String local = sc.nextLine();
		List<Libraries> llist = dao.getLibrariesList(new Libraries(local));
		System.out.println("이전 페이지로 돌아갑니다.");
	}

}
