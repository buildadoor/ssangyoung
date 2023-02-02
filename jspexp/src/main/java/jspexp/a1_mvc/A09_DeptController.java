package jspexp.a1_mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspexp.vo.Dept;

@WebServlet(name = "deptList.do"
, urlPatterns = { "/deptList.do" })
public class A09_DeptController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private A10_Service service;  
    public A09_DeptController() {
    	service = new A10_Service();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//post 방식 한글 요청값 처리시 필요
	    request.setCharacterEncoding("utf-8");
		String deptnoS = request.getParameter("deptno");
		if(deptnoS==null || deptnoS.equals("")) deptnoS = "0";
		int deptno = Integer.parseInt(deptnoS);
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		Dept sch = new Dept(deptno,dname,loc);
		request.setAttribute("deptList", 
				service.getDeptList(sch));
		String page = "WEB-INF/a01_mvc/a08_deptList.jsp";
		request.getRequestDispatcher(
			page).forward(request,response);
	}
}