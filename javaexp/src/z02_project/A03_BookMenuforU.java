package z02_project;

import java.util.Scanner;

public class A03_BookMenuforU {

	static Scanner sc = new Scanner(System.in);


	public static void UserMenu() {
		A03_BookMenuforU BmenuU = new A03_BookMenuforU();
		BookSearching booksearching = new BookSearching();
		Rent Rental = new Rent();
		Returnb bookreturn = new Returnb();
		while (true) {
			System.out.println("┌───────────────도서관련───────────────┐");
			System.out.println("1. 도서 검색");
			System.out.println("2. 도서 대출");
			System.out.println("3. 도서 반납");
			System.out.println("9. 이전 페이지");
			System.out.println("└────────────────────────────────────┘");
			System.out.print("원하시는 페이지의 번호를 입력하세요 : ");
			int num = sc.nextInt();
			sc.nextLine();

			switch (num) {
			case 1:
				booksearching.booksearching();
				break;
			case 2:
				Rental.Rental();
				break;
			case 3:
				bookreturn.Returnbo();
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
		A03_BookMenuforU dao = new A03_BookMenuforU();
		UserMenu();
	}

}
