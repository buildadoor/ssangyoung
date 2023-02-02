package javaexp.a12_io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class A16_PathObj {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * # Path 1. 파일을 보다 효과적으로 복사, 삭제 처리 주는 객체
		 */
		String fname = "C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp\\a12_io\\Z02_Test.txt";
		Path filPath = Paths.get(fname);
		File f = filPath.toFile();
		System.out.println(f.getName());
		System.out.println(f.getPath());
		System.out.println(f.exists());
		System.out.println(f.length());
		// ex) Z04_newFile.txt 파일 생성
		// Path로 처리하고. 해당 정보를 출력하세요 .
		String fold01 = "C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp\\a12_io\\";
		File f01 = new File(fold01, "Z04_newFile.txt");
		// ctrl+shift+f(자동 소스 정리)
		try {
			if (!f01.exists())
				f01.createNewFile();
			Path newPath = Paths.get(fold01 + "\\" + "Z04_newFile.txt");
			System.out.println(newPath.getFileName());
			System.out.println(newPath.getParent());
			System.out.println(newPath.getNameCount());
			File newFile = newPath.toFile();
			System.out.println("# 다시 파일 객체로 변경 #");
			System.out.println(newFile.getName());
		
		
			//파일 삭제 처리.. 
			Files.delete(filPath);
			System.out.println(filPath.getFileName()+"삭제 완료");
		
		
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
