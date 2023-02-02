package javaexp.a12_io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class A15_FileWriter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String file01 = "C:\\a01_javaexp\\workspace\\javaexp\\src\\javaexp\\a12_io\\Z02_Test.txt";
		try {
			Writer writer = new FileWriter(file01);
			writer.write(65);
			writer.append('안');
			writer.append('녕');
			writer.append('\n');
			char []arrc =  {'오','늘',' ','금','요','일','\n'};
			writer.write(arrc);
			writer.write("내일은 토요일 (String)\n ");
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("IO에러"+e.getMessage());
		}	catch (Exception e) {
			System.out.println("일반에러:"+e.getMessage());
		}		
	}
}
