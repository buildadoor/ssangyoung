package z03_kurlyproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class A02_MenuforUser {
	private PreparedStatement pstmt;
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	static Scanner sc = new Scanner(System.in);
	public static void SystemMenu() {
		Brandnew newproduct = new Brandnew();
		Sale saleproduct = new Sale();
		A01_Menu1 main = new A01_Menu1();
		while (true) {
			System.out.println("┌────────────────🛒🍶Kurly🍶🛒───────────────┐");
			System.out.println("1. 신상품    ");
			System.out.println("2. 알뜰상품   ");
			System.out.println("3. 상품검색    ");
			System.out.println("4. 구매하기    ");
			System.out.println("5. 문의하기    ");
			System.out.println("6. 답변확인    ");
			System.out.println("7. 회원탈퇴    ");
			System.out.println("9. 이전 페이지로");
			System.out.println("└────────────────────────────────────────────┘");
			System.out.print("원하시는 페이지 번호를 입력하세요 : ");
			int num = sc.nextInt();
			sc.nextLine();
			switch (num) {
			case 1:
				newproduct.product();
				break;
			case 2:
				saleproduct.product();
//				if(newproduct.scananswer=="O") { 
//					newproduct.getProductList();
//				} else  {
//					System.out.println("이전 페이지로 이동합니다.");
//					
//				}
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				
				break;
			case 7:
				
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
		A02_MenuforUser dao = new A02_MenuforUser();
		SystemMenu();
	}

}

