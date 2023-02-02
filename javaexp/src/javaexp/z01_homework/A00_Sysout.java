package javaexp.z01_homework;

import java.util.Scanner;

public class A00_Sysout {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	Scanner tag = new Scanner(System.in);
	System.out.print("태그 - 이 책을 읽으면 기분이 어떤가요?");
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
		System.out.println("선택 범위가 아닙니다.");
	}
		System.out.println(reviewTag);
	}

}