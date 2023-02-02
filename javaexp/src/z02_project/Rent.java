package z02_project;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javaexp.a13_database.DB;

//returndate가 14일 지나면 연체자 입니다 뜨게 
public class Rent {
	private PreparedStatement pstmt;
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	public static String scanreturnwhether, scanshipwhether, scanisbn, scanbname, scanpublisher, scanwriter, scangenre,
			scanrentalwhether;
	public static int scanuserno, scanprice, scanclassno;

	static Scanner sc = new Scanner(System.in);
	static Rent Rental = new Rent();

	public void Rental() {
		String sql = "INSERT INTO rental values(rentallist_seq.NEXTval,?,?,?,TO_CHAR(sysdate+14,'YYYYMMDD'),?)";
		try {
			System.out.println("┌────────────────도서대출────────────────┐");
			System.out.print("회원번호를 입력하세요:");
			scanuserno = sc.nextInt();
			System.out.print("대여할 도서의 ISBN을 입력하세요:");
			sc.next();
			scanisbn = sc.nextLine();
			System.out.print("배송 희망여부(O,X)를 입력하세요:");
			scanshipwhether = sc.nextLine();
//			if(scanshipwhether=="O") { //이게 O이면 
//				System.out.println("회원 정보에 등록된 주소로 7일 이내에 도서가 배송될 예정입니다.");
//		}
			// O일시 주소 이거 맞냐고 물어보기
			// System.out.print("반납 여부를 입력하세요:");
			// sreturnwhether = sc.nextLine();
			scanreturnwhether = ("X");
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, scanuserno);
			pstmt.setString(2, scanisbn);
			pstmt.setString(3, scanshipwhether);
			pstmt.setString(4, scanreturnwhether);
			System.out.println("도서 반납은 대여일로부터 14일입니다.");
			System.out.println("└────────────────대출완료────────────────┘");
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rent dao = new Rent();
		dao.Rental();

	}

}
