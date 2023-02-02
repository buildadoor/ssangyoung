package javaexp.z01_homework;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class A23_0923 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 2022-09-23
[1단계:코드] 1. File객체를 통해 현재 경로 기준으로 room1~3만들고, Person1.txt~Person10.txt를 생성하세요.
		String file01 ="C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp_homework\\room1";
		String file02 ="C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp_homework\\room2";
		String file03 ="C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp_homework\\room3";
		File f01 = new File(file01);
		File f02 = new File(file02);
		File f03 = new File(file03);
		System.out.println(f01.exists());
		System.out.println(f02.exists());
		System.out.println(f03.exists());

		try {
		if(!f01.exists()) f01.createNewFile();
		if(!f02.exists()) f02.createNewFile();
		if(!f03.exists()) f03.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
//Person1.txt~Person10.txt 다시하기 
[1단계:개념] 2. OutputStream 객체란 무엇인가? 기능메서드와 함께 설명하세요.
			
			바이트기반 출력 스트림의 최상위 클래스로 추상 클래스
			 OutputStream
			 # 하위 객체들 
			 FileOutStream
			 PrintStream
			 BufferedOutputStream
			 DataOutputStream
			-기능 메서드
			write (int b) : 출력 스트림으로 1바이트를 보낸다.
			write (byte[]b) : 출력 스트림으로 매개값으로 주어진
							바이트 배열 b의 모든 바이트를 보낸다.
			write (byte[]b, intoff, int len)
			flush() : 버퍼에 잔류하는 모든 바이트를 출력한다.
			close() : 사용한 시스템을 반납하고 출력 스트림을 닫는다.


[1단계:코드] 3. 기본 OutputStream객체를 생성해서 System.out을 할당하여, byte, byte[]로 데이터를 출력하세요.
		
		OutputStream os = System.out;
		try {
			os.write(65);
			byte[] b = {66,67,68,69,70};
			os.write(b);
			os.flush();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

[1단계:코드] 4. 기본 Writer객체 활용하여 char[], String을 write()로 출력하세요.
	Writer out = new OutputStreamWriter(System.out); 
		String file01 = "C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp_homework\\room1";
		try {
			OutputStream os = new FileOutputStream(file01);
			Writer writer = new FileWriter(file01);
			os.write(60);
			char[] arr = {'과','제','어','렵','다'};
			writer.write(arr);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

[1단계:코드] 5. Reader객체를 통해서 입력된 데이터를 FileWriter를 활용하여 파일에 내용을 기록하세요.
      ex) 회원정보(아이디/패스워드/이름/포인트) 탭간격처리.
      	String file01 = "C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp_homework\\room2";
		try {
			Writer writer = new FileWriter(file01);
			writer.append('회');
			writer.append('원');
			writer.append('정');
			writer.append('보');
			writer.append('\n');
			writer.write("ID\tPW\tNAME\tPOINT(String)\n ");
			writer.flush();
			writer.close();
		} catch (IOException e) {
			System.out.println("IO에러"+e.getMessage());
		}	catch (Exception e) {
			System.out.println("일반에러:"+e.getMessage());
		}		
[2단계:코드] 6. Path 객체를 활용하여 새파일 등록/파일내용 기록/파일 삭제를 처리하세요.


[1단계:코드] 7. Files와 Path를 활용하여 경로2개를 만들고, 경로1의 파일을 5개 임의로 만들어, 경로2에 1~5번이 numbering된 파일을 만드세요.


[2단계:코드] 8. 일기장 시스템 만들기. Scanner를 이용해서 오늘날짜를 입력하면 @@@@년@@월@@일.txt 파일이 생성되고
      날짜를 포함하여 오늘의 일기를 기록하고 Q!를 입력시 입력이 종료되면 해당 파일에 기록이 되게 처리하세요.
      
      
== 평가대비(자바) 객관식 문제 ==
1. 바이트 기반 출력 스트림의 최상위 클래스로 추상 클래스는 무엇인가?
1) InputStream 2) OutputStream 3) Reader 4) Writer
정답:2
OutputStream은 바이트기반 출력 스트림의 최상위 클래스로 추상 클래스이다.
2. 바이트 기반 출력 스트림의 최상위 클래스로 추상 클래스는 무엇인가?
1) InputStream 2) OutputStream 3) Reader 4) Writer
정답:2 //같은 문제 ?? 
 */
		//해설
	/*
	 1번
	 1) File 생성할 기준 경로 (최상위 경로)
	 2) File(경로) room1의 경로 객체 생성
	 3) File(파일) Person1.txt 파일 객체 생성. 
	 4) 위 경로 객체 for 처리
	 5) 위 파일 객체 for처리 
	 */
	/*
		String sPath = "C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp_homework";
			try {		
				for(int rcnt=1;rcnt<=3;rcnt++) {
				String roomPath= sPath+"\\room"+rcnt; //기준 경로 + 추가 경로
				File room = new File(roomPath);
				if(!room.exists()) room.mkdir();
				for(int fcnt=1;fcnt<=10;fcnt++) {
				String fName= roomPath+"\\Person"+fcnt+".txt";
				File file = new File(fName);
				if(!file.exists())
				file.createNewFile();
				}}				
			} catch (IOException e) {
				// TODO Auto-generated catch block
			System.out.println(e.getMessage());
				e.printStackTrace();
			}
			*/
		//6번 
		/*
		 1) File 객체 만들기 
		 2) FileWriter를 활용하여 파일 내용 쓰기 처리
		 3) Path를 전환 후 파일 삭제 처리하기 
		 /*
		String sPath2 = "C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp_homework";
		String fname2 = "z01_show99.txt";
		File f = new File(sPath2, fname2);
					try {
				if(!f.exists()) f.createNewFile();
				// 파일명 ==> File ==> FileWriter ==> PrintWriter
				// 생성자로 담기
				FileWriter fw = new FileWriter(f);
				// 파일 내용 쓰기 처리
				PrintWriter out = new PrintWriter(fw);
				out.print("문자열을 파일에 입력처리합니다~!!");
				out.close();
				fw.close();
				Path delFile = Paths.get(sPath2+"\\"+fname2);
				Files.delete(delFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		/*
		 7번 
		 room3에 있는 파일을 
		 new Room4에 복사하면서
		 Person1.txt ~ Person5.txt
		 ==> 
		 1001File.txt ~ 1005File.txt로 만들기 처리 
		 */
		/*
		 client1 ==> show.txt ==> server
		 							DB - 1001.txt show.txt 상세정보
		 							File서버 - 1001.txt (저장될 파일명)
		 client2 ==> show.txt ==> server
		 							DB - 1002.txt  show.txt 상세정보 
		 							File서버 - 1002.txt (저장될 파일명)
		 client 3 <== show.text == DB - 1002.txt  show.txt
		 							File서버 - 1002.txt (저장될 파일명)
		 */	
		/*
		try {
			for(int fcnt=1;fcnt<=5;fcnt++) {
			String path1 = "C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp_homework\\room3";
			String org1 = path1+"\\Person1."+fcnt+"txt";
			String path2 = "C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp_homework\\newRoom4";
			String tar1 = path2+"\\1001"+fcnt+"File.txt";
			Path orgFile = Paths.get(org1);
			Path tarFile = Paths.get(tar1);
			Files.copy(orgFile, tarFile, StandardCopyOption.REPLACE_EXISTING);
			}
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		/*
		 8번
		 1) 파일생성
				파일명을 입력받아서, File객체에 파일 생성하기
				-기준 경로
				-입력된 내용을 파일명 만들기
		 2) 입력된 내용으로 파일쓰기 
		 		-File ==> PrintWriter
		 		-반복문을 통해서 계속 내용 입력 후,
		 		-Q!통해서 파일 쓰기 종료 처리 
		 		
		*/
		Scanner sc = new Scanner(System.in);
		System.out.print("일기장 등록할 날짜입력(YYYYMMDD):");
		String date = sc.next();// \n을 뺴고 입력
		System.out.println("입력할 파일명:"+date+".txt");
		String dPath = "C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp_homework\\Z01_Diary";
		File df = new File(dPath+date+".txt");
		try {
			if(!df.exists()) df.createNewFile();;
			System.out.println("내용을 입력하세요!");
			//파일명 ==> File() ==> FileWriter() ==> PrintWriter()
			FileWriter fw = new FileWriter(df);
			PrintWriter out = new PrintWriter(fw);
			out.write("날짜"+date+"\n");
			StringBuffer sbf = new StringBuffer();
			while(true) {
				String data = sc.nextLine();
				//마지막 라인에서 Q!를 입력시 .. 
				if(data.equals("Q!")) {
					break;
				}
				sbf.append(data+"\n");
			}
			// 최종적으로 입력받은 문자열을 쓰기 처리 
			out.write(sbf.toString());
			System.out.println("일기 쓰기를 종료합니다");
			out.flush();
			// 자원해제 ..
			out.close();
			fw.close();
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	
		
		}
	}
