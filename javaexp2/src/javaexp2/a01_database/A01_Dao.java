package javaexp2.a01_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class A01_Dao {
	//	필드 선언. import
	private static Connection con;
	//기능 메서드 선언 ..
	public static void setConnection() throws SQLException {
		//1. 드라이버 메모리 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 연결 성공");
		} catch (ClassNotFoundException e) {
			
			// TODO Auto-generated catch block
			System.out.println("드라이버연결오류(오타확인)"+e.getMessage());
		}
		//2. 특정 서버 접속처리 --@localhost
				String info = "jdbc:oracle:thin:@localhost:1521:xe";
				con = DriverManager.getConnection(info, "scott","tiger");		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			setConnection();
			System.out.println("접속성공!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("접속에러:"+e.getMessage());
		}
	}
	}

