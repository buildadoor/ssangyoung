package javaexp.z01_homework;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class A22_0922 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 2022-09-22
[1단계:개념] 1. Stream이 무엇인지 기술하고, 자바의 대표적인 입출력 객체를 선언하세요.
//해설	Stream이란 물결이란 뜻으로 프로그래밍에서는 데이터의 흐름을
		처리할때, 사용하는 객체이다.
		주로 콘솔창에 입력되는 데이터, 파일을 통해서 입력된 데이터,
		네트워크를 통해서 전송해오는 데이터를 읽고 쓸때, 중간에 객체로
		이동하거나 전송할때 활용되낟.
		InputStream, OutputStream객체를 상위 객체로 하여
		하위에 여러가지 기능을 추가하는 객체들이 있다. 
		
		
		자바에서는 Stream이라는 api 객체를 통해서, 데이터를 입력하거나 출력을 하는 등 처리를 하고 있다.
		 파일의 데이터를 입/출력 또는 파일 자체를 전송
		 -System.out.println()은 기본적인 자바의 OutputStream의
		 한 형태로 console창을 통해 출력을 하게 한다.
		 -System.in:자바에서 InputStream의 한 형태로 console창에
		 데이터를 입력할때, 사용되는 객체이다.
	
[1단계:코드] 2. InputStream을 이용하여, 70점 이상인지 여부를 확인하여 출력하세요.(byte ==> char ==> String ==> int 변환 필요) 
				 System.out.println("점수를 입력하세요.");
         InputStream score = System.in;
         byte[] arr = new byte[2];
         try {
            score.read(arr);
            String s = new String(arr);
            int num = Integer.parseInt(s);
            if(num>=70) {
               System.out.println("70점이상입니다!!");
            }
            else {
               System.out.println("70점이하입니다!!");
            }
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }


[1단계:개념] 3. byte 기반 stream과  문자기반 stream의 내용과 차이점을 기술하세요.
		byte기반으로 입,출력하는 클래스는 InputStream(최상위), OutputStream가 있고 
		한글 입력 불가능.
        문자기반 stream의 최상위 클래스는 Writer는 한글을 입력처리 가능.


[1단계:코드] 4. read(byte[])를 활용하여 웹기반 자바프로그램은 무엇인가?라은 질문에 jsp이면 정답 그렇지 않으면 오답으로 처리하세요.
			InputStream is =System.in;
			byte[] inArr = new byte[3];
			System.out.print("웹기반 자바 프로그램은 무엇인가?:");
			try {
				is.read(inArr);
				String inputjava = new String(inArr);
				System.out.println("입력한 정답"+inputjava);
				if(inputjava.equals("jsp")) {
					System.out.println("딩동댕! 정답입니다!");
				}else {
					System.out.println("땡! 오답입니다!");
				}
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
		}
[1단계:코드] 5. InputStreamReader를 이용하여 물건명, 가격, 갯수를 입력받고, 총계까지 출력하세요.
	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		 try {
	            System.out.print("물건명을 입력하세요.");
	            String prod = bf.readLine();
	            System.out.print("가격을 입력하세요.");
	            String price = bf.readLine();
	            System.out.print("갯수를 입력하세요.");
	            String count = bf.readLine();
	            int sum = Integer.parseInt(price)*Integer.parseInt(count);
	            System.out.println(" ~~ 물건구매 입력창 ~~");
	            System.out.println("물건명: "+prod);
	            System.out.println("가격: "+price+"원");
	            System.out.println("갯수: "+count+"개");
	            System.out.println("총계: "+sum+"원");
	         } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }

[1단계:개념] 6. File객체/물리적파일의 생성방법을 기술하세요.
			File file = new File("C:\\aa\aa.txt");
	 		File file2 = new File("C:/aa/aa.txt");
	 		*파일 또는 디렉토리 존재 유무 확인 메서드
	 		boolean isExist = file.exists()
			boolean createNewFile() 새로운 파일을 생성
	 		*파일 및 디렉토리 생성 및 삭제 메소드
	 		boolean createNewFile() 새로운 파일을 생성
	 		boolean mkdir() 새로운 디렉토리 생성
	 		boolean mkdirs() 경로상에 없는 모든 디렉토리를 생성
	 		boolean delete() 파일 또는 디렉토리 삭제

[1단계:코드] 7. homework 패키지 하위에 z01_home,z02_home,z02_home 폴드를 만들고 그 하위에 각각 menual1.txt~menual10.txt 파일을 생성하세요
		String file01 = "C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp_homework\\z01_home";
		String file02 = "C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp_homework\\z02_home";
		String file03 = "C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp_homework\\z03_home";
		String path01 = "C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp_homework\\menual01.txt";
		String path02 = "C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp_homework\\menual02.txt";
		String path03 = "C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp_homework\\menual03.txt";
		String path04 = "C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp_homework\\menual04.txt";
		String path05 = "C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp_homework\\menual05.txt";
		String path06 = "C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp_homework\\menual06.txt";
		String path07 = "C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp_homework\\menual07.txt";
		String path08 = "C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp_homework\\menual08.txt";
		String path09 = "C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp_homework\\menual09.txt";
		String path10 = "C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp_homework\\menual10.txt";
		File f01 = new File(file01);
		File f02 = new File(file02);
		File f03 = new File(file03);
		File f04 = new File(path01);
		File f05 = new File(path02);
		File f06 = new File(path03);
		File f07 = new File(path04);
		File f08 = new File(path05);
		File f09 = new File(path06);
		File f10 = new File(path07);
		File f11 = new File(path08);
		File f12 = new File(path09);
		File f13 = new File(path10);
		System.out.println(f01.exists());
		System.out.println(f02.exists());
		System.out.println(f03.exists());
		try {
		if(!f01.exists()) f01.createNewFile();
		if(!f02.exists()) f02.createNewFile();
		if(!f03.exists()) f03.createNewFile();
		if(!f04.exists()) f04.createNewFile();
		if(!f05.exists()) f05.createNewFile();
		if(!f06.exists()) f06.createNewFile();
		if(!f07.exists()) f07.createNewFile();
		if(!f08.exists()) f08.createNewFile();
		if(!f09.exists()) f09.createNewFile();
		if(!f10.exists()) f10.createNewFile();
		if(!f11.exists()) f11.createNewFile();
		if(!f12.exists()) f12.createNewFile();
		if(!f13.exists()) f13.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}



== 평가대비(자바) 객관식 문제 ==
1.  바이트 단위 입출력을 위한 최상위 입력 스트림 클래스는?
1) File 2) OutputStream 3) InputStream 4) Reader
정답 ==> 3번
2.  아래 내용 중에 한글을 입력 처리해주는 Stream은 무엇인가?
1) InputStream 2) OutputStream 3) Writer 4) Reader
정답 ==> 4번 - 문자 입력 기반 클래스 
3. Reader객체의 하위 객체가 아닌 것은 무엇인가?
1) FileReader 2) BufferedReader 3) InputStreamReader 4) InputStream
정답 ==> 4번 - 입력스트림클래스
4. 디렉토리에 포함되 파일 및 서브디렉토리 목록 배열로 리턴 File객체 하위의 기능메서드는?
1) list() 2) listFiles() 3) canRead() 4) getParentFile()
정답 ==> 1번
2-디렉토리에 포함된 파일 및 서브 디렉토리 목록 전부를 File 배열로 리턴
3-읽을 수 있는지 여부
4-부모 디렉토리를 File객체로 생성 후 리턴

정답 : 3 4 4 1

 */
	}

}
