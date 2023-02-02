package z02_project;

import java.util.ArrayList;
import java.util.Scanner;

import z02_project.vo.Books;

public class A03_UserMenuforM {
	static Scanner sc = new Scanner(System.in);

	public static void UserMenu() {
		UserDelete delete = new UserDelete();
		UserSearching user = new UserSearching();
		while (true) {
			System.out.println("┌────────────────회원관리────────────────┐");
			System.out.println("1. 회원 조회");
			System.out.println("2. 회원 삭제");
			System.out.println("9. 이전 페이지");
			System.out.println("└──────────────────────────────────────┘");
			System.out.print("원하시는 페이지의 번호를 입력하세요 : ");
			int num = sc.nextInt();
			sc.nextLine();

			switch (num) {
			case 1:
				user.user();
				break;
			case 2:
				delete.deleteUse();
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
			A03_UserMenuforM dao = new A03_UserMenuforM();
			UserMenu();
		}

	}
		