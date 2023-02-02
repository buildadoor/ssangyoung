package z02_project;

import java.util.Scanner;

public class A02_Usermenu {

	static Scanner sc = new Scanner(System.in);
	public static void UserMenu() {
		A02_Usermenu Umenu = new A02_Usermenu();
		A03_BookMenuforU BmenuU = new A03_BookMenuforU();
		A04_CallMenuU CmenuU = new A04_CallMenuU();
		LibrarySearching library = new LibrarySearching();
		WeeklySearching program = new WeeklySearching();
		ReadKing king = new ReadKing();
		while (true) {
			System.out.println("┌────────────────회원페이지─────────────┐");
			System.out.println("1. 도서");
			System.out.println("2. 상담");
			System.out.println("3. 주간 프로그램 확인");
			System.out.println("4. 독서왕 조회");
			System.out.println("5. 도서관 검색");
			System.out.println("9. 이전 페이지");
			System.out.println("└────────────────────────────────────┘");
			System.out.print("원하시는 페이지의 번호를 입력하세요 : ");
			int num = sc.nextInt();
			sc.nextLine();

			switch (num) {
			case 1:
				BmenuU.UserMenu();
				break;
			case 2:
				CmenuU.callu();
				break;
			case 3:
				program.program();
				break;
			case 4:
				king.king();
				break;
			case 5:
				library.searchinglib();
				break;
			case 9:
				System.out.println("이전 페이지로 돌아갑니다.");
				return;
			default:
				System.out.println("메뉴를 다시 선택해주세요.");
			}}

		}
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			A02_Usermenu dao = new A02_Usermenu();
			UserMenu();
		}

	}
		