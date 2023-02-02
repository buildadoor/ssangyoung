package javaexp.a12_io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class A07_BufferReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//ex)BufferedReader객체를 통해 좋아하는 음악과 가수명을 입력받아 출력하세요
//		Reader rd = new InputStreamReader(System.in);
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		try {
		System.out.print("음악명 입력:");
		String music = bf.readLine();	
		System.out.print("가수명 입력:");
		String singer = bf.readLine();
		System.out.println("입력한 음악: "+music);
		System.out.println("입력한 가수: "+singer);
		bf.close();
	//	rd.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		/*
		Reader song = new InputStreamReader(System.in);
		BufferedReader bfr = new BufferedReader(song);	
		System.out.print("좋아하는 음악을 입력하세요:"+"\n");
		Reader singer = new InputStreamReader(System.in);
		BufferedReader bfr2 = new BufferedReader(singer);
		System.out.print("좋아하는 가수를 입력하세요:");
		try {
				String inputLine = bfr.readLine();
				System.out.println("입력한 노래:"+inputLine);
				//String inputLine2 = bfr2.readLine();
				//System.out.println("입력한 가수:"+inputLine2);
				song.close();
				//singer.close();
			
				String inputLine2 = bfr2.readLine();
				System.out.println("입력한 가수:"+inputLine2);
				singer.close();
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
*/
	
	}
}
