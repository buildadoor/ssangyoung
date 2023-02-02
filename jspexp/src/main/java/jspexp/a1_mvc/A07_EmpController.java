package jspexp.a1_mvc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspexp.vo.Emp;


@WebServlet(name = "empList.do", urlPatterns = { "/empList.do" })
public class A07_EmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private A08_EmpService service;  
     public A07_EmpController() {
      service = new A08_EmpService();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//post 방식 한글 요청값 처리시 필요
	request.setCharacterEncoding("utf-8");
	String ename = request.getParameter("ename");
	String job = request.getParameter("job");
	String frSalS = request.getParameter("frSal");
	String toSalS = request.getParameter("toSal");

	// 모델 데이터 선언 
	// 생성자를 통해서 서비스단 객체 생성 
	// 모델은 View단에 넘김 핵심 데이터
	request.setAttribute("sch",service.getEmp(ename,job,frSalS,toSalS));
	request.setAttribute("empList", service.empList());
	//뷰단 호출	
	String page = "WEB-INF/a01_mvc/a07_empList.jsp";
	request.getRequestDispatcher(
		page).forward(request,response);
}
	//ex) A09_DeptController.java A10_Service.java
	//WEB-INF/a01_mvc/a08_deptList.jsp;
}