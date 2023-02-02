package jspexp.a1_mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspexp.vo.Emp;

/**
 * Servlet implementation class A03_MVC
 */
@WebServlet(name = "mvc02_2.do", urlPatterns = { "/mvc02_2.do" })
public class A04_MVC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 http://localhost:7080/mvc02_1.do
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1. 요청값
		//2. 모델처리 

		request.setAttribute("emp", new Emp(100,"홍길동",3500.0));
		
		//3. view단 호출
		String page = "WEB-INF\\a01_mvc\\a04_view.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
