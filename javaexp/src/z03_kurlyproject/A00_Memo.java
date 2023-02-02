package z03_kurlyproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class A00_Memo {
	private PreparedStatement pstmt;
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	static Scanner sc = new Scanner(System.in);
	public static void SystemMenu() {
		Join Kurlyjoin = new Join();
		A00 Kurlylogin = new A00();
		A02_MenuforUser user = new A02_MenuforUser();
		A02_MenuforMg usermg = new A02_MenuforMg();
		
		while (true) {
			System.out.println("┌────────────────────Kurly───────────────────┐");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("9. 로그아웃");
			System.out.println("└────────────────────────────────────────────┘");
			System.out.print("원하시는 페이지 번호를 입력하세요 : ");
			int num = sc.nextInt();
			sc.nextLine();
			switch (num) {
			case 1:
				Kurlyjoin.JoinKurly();
				break;
			case 2:
				Kurlylogin.Login();

				
				if(Login.checkuser==1) { 
					
					System.out.println("관리자 확인이 되었습니다. 관리자 페이지로 이동합니다.");
					usermg.SystemMenu();
				} else  {
					System.out.println("회원 확인이 되었습니다. 회원 페이지로 이동합니다.");
					user.SystemMenu();
				}
				break;
			case 9:
				System.out.println("로그아웃 되었습니다. \n프로그램을 종료합니다!");
				return;
			default:
				System.out.println("메뉴를 다시 선택해주세요.");
			}

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A00_Memo dao = new A00_Memo();
		SystemMenu();
	}

}
