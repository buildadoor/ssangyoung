package jspexp.a13_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Join {
	private PreparedStatement pstmt;
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	static Scanner sc = new Scanner(System.in);
	public  String scanusersno, scandiv, scanusername, scanrrn, scanaddress, scanphonenumber, scanid, scanpassword;
	public int scanpoint;

	public boolean Joinid(String id) {
		boolean bReturn = false;
		String sql = "SELECT * FROM kurlyuser WHERE id = '" + id + "'";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				int nRowCnt = rs.getRow(); 
				if (nRowCnt < 1) { 
					bReturn = false;
				} else {
					bReturn = true;
				}
			}
		} catch (SQLException e) {
			System.out.println("DB처리예외:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("기타예외:" + e.getMessage());
		} finally {
			DB.close(rs, stmt, con);
		}
		return bReturn; // 행갯수가 있으면 true를 리턴
	}
	public void insertKurlyuser(User us) {
		String sql = "INSERT INTO kurlyuser values(kurlyuser_seq.NEXTval,?\r\n"
				+ "									,?,?,\r\n" + "									?,?,\r\n"
				+ "									?,?,?)";
		// System.out.println(sql);
		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, us.getDiv());
			pstmt.setString(2, us.getUname());
			pstmt.setString(3, us.getRrn());
			pstmt.setString(4, us.getAddress());
			pstmt.setString(5, us.getPhonenumber());
			pstmt.setString(6, us.getId());
			pstmt.setString(7, us.getPassword());
			pstmt.setInt(8, us.getPoint());
			rs = pstmt.executeQuery();
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
	
	public void JoinKurly() {
		// TODO Auto-generated method stub
		Join dao = new Join();
		System.out.println("┌────────────────────회원가입───────────────────┐");
		scandiv = "회원";
		scanpoint=3000;
		System.out.print("이름을 입력하세요: ");
		scanusername = sc.next();
		System.out.print("주민등록번호를 입력하세요:"
				+ "\n('-'를 포함하여 입력해주세요)" + "\n");
		scanrrn = sc.next();
		sc.nextLine();
		System.out.print("주소를 입력하세요: ");
		scanaddress = sc.nextLine();
		System.out.print("핸드폰번호를 입력하세요:\n('-'를 포함하여 입력해주세요)" + "\n");
		scanphonenumber = sc.nextLine();
		while (true) {
			System.out.print("아이디를 입력하세요: ");
			scanid = sc.next();
			if (dao.Joinid(scanid) == true) {
				System.out.println("아이디 중복입니다. 다시 입력해주세요");
			} else {
				System.out.println("아이디 생성이 성공하였습니다.");
				break;
			}
		}
		System.out.print("비밀번호를 입력하세요: ");
		scanpassword = sc.next();
		System.out.println("회원가입 축하 적립금 3000point가 지급되었습니다.");
		System.out.println("└───────────Kurly 회원가입을 환영합니다!───────────┘");
	dao.insertKurlyuser(new User(scandiv, scanusername, scanrrn, scanaddress, scanphonenumber, scanid, scanpassword,scanpoint));
	
	}

}
