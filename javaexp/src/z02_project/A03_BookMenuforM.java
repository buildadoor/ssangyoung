package z02_project;

import java.util.Scanner;

public class A03_BookMenuforM {

	static Scanner sc = new Scanner(System.in);
	static A03_BookMenuforM BmenuM = new A03_BookMenuforM();
	//static BookDelete delete = new BookDelete();
	static Book Book = new Book();
	public static void UserMenu() {
		BookDelete Delete = new BookDelete(); 
		BookChange changebook = new BookChange();
		RentalSearching rental = new RentalSearching();
		
		while (true) {
			System.out.println("┌────────────────도서관리────────────────┐");
			System.out.println("1. 도서 등록");
			System.out.println("2. 도서 수정");
			System.out.println("3. 도서 삭제");
			System.out.println("4. 대출 현황");
			System.out.println("9. 이전페이지");
			System.out.println("└──────────────────────────────────────┘");
			System.out.print("원하시는 페이지의 번호를 입력하세요 : ");
			int num = sc.nextInt();
			sc.nextLine();

			switch (num) {
			case 1:
				Book.insertBook();
				break;
			case 2:
				changebook.changebook();
				break;
			case 3:
				Delete.DeleteBook();
				break;
			case 4:
				rental.rentallist();
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
			A03_BookMenuforM dao = new A03_BookMenuforM();
			UserMenu();
		}

	}
		