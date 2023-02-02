package javaexp.z01_project;

import java.util.Scanner;

public class A03_Review {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int grade = 0;
		String heart = "";
		do {
			System.out.print("평점 - 이 책에 대한 당신의 마음을 남겨주세요 (입력범위 1~4): ");
			grade = sc.nextInt();
		} while (grade > 4 || grade < 1);
		while (grade > 0) {
		heart += "♥";
		grade--;
		}
		//리뷰 작성
		System.out.print("리뷰 - 이책을 간단히 말하면? ");
		Scanner sc02 = new Scanner(System.in);
		String review = sc02.nextLine();
		//태그 선택 
		Scanner tag = new Scanner(System.in);
		System.out.print("태그 - 이 책을 읽으면 기분이 어떤가요? ");
		String reviewTag = tag.nextLine();
		switch (reviewTag) {
		case "좋아요":
			break;
		case "잘읽혀요":
			break;
		case "정독해요":
			break;
		case "기발해요":
			break;
		case "유용해요":
			break;
		case "기타":
			break;
		default:
			System.out.println("태그 선택 범위를 벗어났습니다.");
		}
		//
		System.out.println("****하얼빈 리뷰 작성 페이지****");
		System.out.println("평점 - 이 책에 대한 당신의 마음을 남겨주세요\n" + heart);
		System.out.println("태그 - 이 책을 읽으면 기분이 어떤가요?\n"+reviewTag);
		System.out.println("리뷰 - 이책을 간단히 말하면?\n"+review);
		// 이미지 첨부 여부
		Scanner addImage = new Scanner(System.in);
		System.out.println("이미지첨부 (파일을 선택하시려면 Y)");
		String image = addImage.nextLine();
		if(image.equals("Y")) {
			System.out.println("파일을 선택합니다.");
		}else {
			System.out.println("파일을 선택하지 않습니다.");
		}
		
	}

}



