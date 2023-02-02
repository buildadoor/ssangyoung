package javaexp.a12_io;

import java.io.File;
import java.io.IOException;

public class A08_File {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 #파일 입출력
		 1.File클래스
		 	1)파일 시스템의 파일을 표현하는 클래스
		 	- 파일의 크기, 파일 속상, 파일 이름 등의 정보 제공
		 	- 디렉토리 생성, 디렉토리 존재하는 파일 리스트 얻어내는 기능 제공
		 	2) 파일 객체 생성
	 			File file = new File("C:\\aa\aa.txt");
	 			File file2 = new File("C:/aa/aa.txt");
	 		3) 파일 또는 디렉토리 존재 유무 확인 메서드
	 			boolean isExist = file.exists()
	 		4) 파일 및 디렉토리 생성 및 삭제 메소드
	 			boolean createNewFile() 새로운 파일을 생성
	 			boolean mkdir() 새로운 디렉토리 생성
	 			boolean mkdirs() 경로상에 없는 모든 디렉토리를 생성
	 			boolean delete() 파일 또는 디렉토리 삭제
		 */
	String file01 ="C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp\\a12_io\\A01_Basic.java";
	// 클래스 오른쪽마우스 properties 경로복사 
	String file02 = "C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp\\a12_io\\z01_txt";
	String path = "C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp\\a12_io\\a01_path";
	File f01 = new File(file01);
	File f02 = new File(file02);
	File f03 = new File(path);


	System.out.println(f01.exists());
	System.out.println(f02.exists());

	try {
	if(!f01.exists()) f01.createNewFile();
	if(!f02.exists()) f02.createNewFile();
	if(!f03.exists()) f03.mkdir();//디렉토리 경로 설정 
	File f04 = new File("Z02_test.txt");
	if(f04.exists()) f04.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//ex) a12_io하위에 z01_path 경로를 만들고.
	// 		 그 하위에 a01_show.txt, a02_show.txt 파일을 생성하세요
	String path2 = "C:\\\\a01_javaexp\\\\workspace\\\\javaexp\\\\src\\\\javaexp\\\\a12_io\\\\z01_path";
	File f04 = new File(path2);
	if(!f04.exists()) f04.mkdir();
	String file03 = "C:\\\\a01_javaexp\\\\workspace\\\\javaexp\\\\src\\\\javaexp\\\\a12_io\\\\a01_show.txt";
	String file04 = "C:\\\\a01_javaexp\\\\workspace\\\\javaexp\\\\src\\\\javaexp\\\\a12_io\\\\a02_show.txt";
	File f05 = new File(file03);
	File f06 = new File(file04);
	
		try {
			if(!f05.exists()) f05.createNewFile();
			if(!f06.exists()) f06.createNewFile();
		} catch (IOException e) {

			e.printStackTrace();
		}
	
	
	/*
	 # 파일 및 디렉토리 정보 리턴 메소드
	 boolean canExcute():실행 파일 여부
	 boolean canRead(): 읽을 수 있는지 여부
	 boolean canWrite(): 쓸 수 있는지 여부
	 String getName() : 파일의 이름 리턴
	 String getParent() : 부모 디렉토리 리턴
	 File getParentFile() : 부모 디렉토리를 File객체로 생성 후 리턴
	 String getPath() : 전체 경로 리턴
	 boolean isDirectory() : 디렉토리인지 여부
	 boolean isFile() 파일인지 여부 
	 long length() : 파일의 크기 리턴
	 String[] list() : 디렉토리에 포함된 파일을 서브디렉토리 목록 배열로 리턴
	 File[] listFiles() : 디렉토리에 포함된 파일 및 서브 디렉토리 목록
	 						전부를 File 배열로 리턴
	 */
	}
	
}
