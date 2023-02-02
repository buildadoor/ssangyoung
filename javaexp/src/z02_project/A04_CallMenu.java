package z02_project;

import java.util.Scanner;

public class A04_CallMenu {

	static Scanner sc = new Scanner(System.in);

	public static void callm() {
		CallByManager Call = new CallByManager();
		CheckCall check = new CheckCall();
		while (true) {
			System.out.println("┌───────────────상담관련───────────────┐");
			System.out.println("1. 상담글 확인");
			System.out.println("2. 상담 답변");
			System.out.println("9. 이전 페이지");
			System.out.println("└────────────────────────────────────┘");
			System.out.print("원하시는 페이지의 번호를 입력하세요 : ");
			int num = sc.nextInt();
			sc.nextLine();

			switch (num) {
			case 1:
				check.checkcall();
				break;
			case 2:
				Call.CallManager();
				break;

			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("메뉴를 다시 선택해주세요.");
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A04_CallMenu dao = new A04_CallMenu();
		callm();
	}

}
