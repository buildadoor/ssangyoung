package z02_project;

import java.util.Scanner;

public class A02_ManagerMenu {

	static Scanner sc = new Scanner(System.in);

	public static void ManagerMenu() {
		A02_ManagerMenu Mmenu = new A02_ManagerMenu();
		A03_UserMenuforM UmenuM = new  A03_UserMenuforM();
		A03_BookMenuforM BmenuM = new A03_BookMenuforM();
		A04_CallMenu callm = new A04_CallMenu();
		UserSearching user = new UserSearching();
		Weekly Program = new Weekly();
		Library Lib = new Library();
		
	
		while (true) {
			System.out.println("┌──────────────관리자페이지──────────────┐");
			System.out.println("1. 회원");
			System.out.println("2. 도서");
			System.out.println("3. 상담");
			System.out.println("4. 주간 프로그램 등록");
			System.out.println("5. 도서관 등록");
			System.out.println("9. 이전 페이지");
			System.out.println("└─────────────────────────────────────┘");
			System.out.print("원하시는 페이지의 번호를 입력하세요 : ");
			int num = sc.nextInt();
			sc.nextLine();

			switch (num) {
			case 1:
				UmenuM.UserMenu();
				break;
			case 2:
				BmenuM.UserMenu();
				break;
			case 3:
				callm.callm();
				break;
			case 4:
				Program.Weekly();
				break;
			case 5:
				Lib.Library();
				break;
			case 9:
				System.out.println("이전 페이지로 돌아갑니다.");
				return;
			default:
				System.out.println("메뉴를 다시 선택해주세요.");
			}

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A02_ManagerMenu dao = new A02_ManagerMenu();
		ManagerMenu();
	}

}
