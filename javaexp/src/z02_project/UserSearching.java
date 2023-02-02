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

public class UserSearching {
	private PreparedStatement pstmt;
	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public List<Bookusers> getBookusersList(Bookusers sch) {
		List<Bookusers> ulist = new ArrayList<Bookusers>();
		String sql = "SELECT * \r\n" + "FROM BOOKUSERS\r\n" + "WHERE uname = ?";
		try {
			con = DB.con();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sch.getUname());//
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("┌────────────────회원아이디────────────────┐");
				System.out.println("회원번호: " + rs.getString("usersno"));
				System.out.println("구분: " + rs.getString("div"));
				System.out.println("이름: " + rs.getString("uname"));
				System.out.println("주민등록번호: " + rs.getString("rrn"));
				System.out.println("주소: " + rs.getString("address"));
				System.out.println("핸드폰번호: " + rs.getString("phone_number"));
				System.out.println("아이디: " + rs.getString("id"));
				System.out.println("대여횟수: " + rs.getInt("rentalcnt"));
				System.out.println("└──────────────────────────────────────┘");
			}

		} catch (SQLException e) {
			System.out.println("DB에러:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반에러:" + e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}

		return ulist;
	}

	public void user() {
		UserSearching dao = new UserSearching();
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 회원명: ");
		String username = sc.nextLine();
		List<Bookusers> blist = dao.getBookusersList(new Bookusers(username));
		System.out.println("이전 페이지로 돌아갑니다.");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserSearching dao = new UserSearching();
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 회원명: ");
		String username = sc.nextLine();
		List<Bookusers> blist = dao.getBookusersList(new Bookusers(username));
		System.out.println("이전 페이지로 돌아갑니다.");
	}
}
