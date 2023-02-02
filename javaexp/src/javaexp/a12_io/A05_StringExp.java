package javaexp.a12_io;

import java.io.IOException;
import java.io.InputStream;

public class A05_StringExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//ex)검색할 물건명(영문)으로 입력하고
		//"apple"와 동일하면 검색되었습니다. 그렇지 않으면 없습니다 출력
		
		InputStream is =System.in;
		System.out.print("검색할 물건명:");
		byte[] product = new byte[5];
		try {
			is.read(product);
			String inputProd = new String(product);//byte[]==>char[]==>String
			System.out.println("입력한 물건"+inputProd);
			if(inputProd.equals("apple")) {
				System.out.println("검색되었습니다.");
			}else {
				System.out.println("없습니다");
			}
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
