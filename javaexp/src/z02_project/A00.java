package z02_project;

import java.util.Scanner;

import z02_project.vo.Bookusers;

public class A00 {
	static Scanner sc = new Scanner(System.in);
	public static void SystemMenu() {
		UserJoin join = new UserJoin();
		UsersLogin login = new UsersLogin();
		A02_ManagerMenu Mmenu = new A02_ManagerMenu();
		A02_Usermenu Umenu = new A02_Usermenu();
		while (true) {
			System.out.println("┌────────────도서관리프로그램────────────┐");
			System.out.println("1. 회원 가입");
			System.out.println("2. 로그인");
			System.out.println("9. 종료");
			System.out.println("└────────────────────────────────────┘");
			System.out.print("원하시는 페이지의 번호를 입력하세요 : ");
			int num = sc.nextInt();
			sc.nextLine();
			switch (num) {
			case 1:
				join.Join();//이름중복넣기
				break;
			case 2:
				login.Login();
				
				if(login.checkdiv==41) { //관리자 회원번호 41 그외 모든 아이디는 회원
					System.out.println("관리자 확인이 되었습니다. 관리자 페이지로 이동합니다.");
					Mmenu.ManagerMenu();
				} else  {
					Umenu.UserMenu();
				}
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
		A00 dao = new A00();
		SystemMenu();
	}

}
