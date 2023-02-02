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
import z02_project.vo.Return;

public class RentalSearching {
	private PreparedStatement pstmt;
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	public static int scanuserno;

	public List<Return> getRentalList() {
		List<Return> rtlist = new ArrayList<Return>();
		String sql = "SELECT * FROM Rental WHERE USERSNO = ?";
		try {
			con = DB.con();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, scanuserno);//
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("┌────────────────대출현황────────────────┐");
				System.out.println("대여번호: " + rs.getInt("rentalno"));
				System.out.println("회원번호: " + rs.getInt("usersno"));
				System.out.println("도서번호: " + rs.getString("isbn"));
				System.out.println("배송희망: " + rs.getString("shipwhether"));
				System.out.println("반납일: " + rs.getString("returndate"));
				System.out.println("반납여부: " + rs.getString("returnwhether"));
				System.out.println("└──────────────────────────────────────┘");
			}

		} catch (SQLException e) {
			System.out.println("DB에러:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반에러:" + e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}

		return rtlist;
	}

	public void rentallist() {

		RentalSearching dao = new RentalSearching();
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 회원번호: ");
		scanuserno = sc.nextInt();
		List<Return> rlist = dao.getRentalList();
		System.out.println("이전 페이지로 돌아갑니다.");


	}


		public static void main(String[] args) {
		// TODO Auto-generated method stub
		RentalSearching dao = new RentalSearching();
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 회원번호: ");
		scanuserno = sc.nextInt();
		List<Return> rlist = dao.getRentalList();
		System.out.println("이전 페이지로 돌아갑니다.");

	}
}
