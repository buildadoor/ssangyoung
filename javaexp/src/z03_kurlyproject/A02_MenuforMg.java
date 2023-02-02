package z03_kurlyproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class A02_MenuforMg {
	private PreparedStatement pstmt;
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	static Scanner sc = new Scanner(System.in);
	public static void SystemMenu() {
		Brandnew newproduct = new Brandnew();
		Sale saleproduct = new Sale();
		Answer answer = new Answer();
		A01_Menu1 main = new A01_Menu1();
		while (true) {
			System.out.println("┌────────────────────Kurly───────────────────┐");
			System.out.println("1. 물품등록");
			System.out.println("2. 물품수정");
			System.out.println("3. 물품삭제");
			System.out.println("4. 문의답변");
			System.out.println("5. 공지등록");
			System.out.println("6. 공지수정");
			System.out.println("5. 공지삭제");
			System.out.println("9. 이전 페이지로");
			System.out.println("└────────────────────────────────────────────┘");
			System.out.print("원하시는 페이지 번호를 입력하세요 : ");
			int num = sc.nextInt();
			sc.nextLine();
			switch (num) {
			case 1:
		
				break;
			case 2:

				break;
			case 3:
				
				break;
			case 4:
				answer.answer();
				break;
			case 5:
				
				break;
			case 6:
				
				break;
			case 9:
				System.out.println("이전 페이지로 돌아갑니다.");
				//main.SystemMenu();
				return;
			default:
				System.out.println("메뉴를 다시 선택해주세요.");
			}

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A02_MenuforMg dao = new A02_MenuforMg();
		SystemMenu();
	}

}

