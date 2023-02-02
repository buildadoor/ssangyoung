package jspexp.a10_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class A01_ServletStart
 */
@WebServlet(name = "servlet01.do", urlPatterns = { "/servlet01.do" })
public class A01_ServletStart extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A01_ServletStart() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
    */
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      request.setCharacterEncoding("utf-8");
      PrintWriter out = response.getWriter();
      //jsp는 out.print()안에 들어갈 내용
      out.print("<h2>servlet은 jsp가 만드는 것</h2>");
      //HttpSession session = request.getSession();
      
   }

}