/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.70
 * Generated at: 2022-12-22 06:42:22 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.z00_005fpractice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import jspexp.vo.*;
import javaexp.sql.*;
import jspexp.a13_database.*;
import jspexp.a13_database.vo.*;

public final class a02_005flectureadd_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("jspexp.a13_database.vo");
    _jspx_imports_packages.add("javaexp.sql");
    _jspx_imports_packages.add("jspexp.a13_database");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("jspexp.vo");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>쌍용 대학교</title>\r\n");
      out.write("<link href=\"main.css\" type=\"text/css\" rel=\"stylesheet\">\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("   src=\"http://code.jquery.com/jquery-1.8.3.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<style>\r\n");
      out.write("@import url(a00_main.css);  \r\n");
      out.write("\r\n");
      out.write("#addtable{\r\n");
      out.write("margin-top:5%;\r\n");
      out.write("margin-left: 40%;\r\n");
      out.write("font-size: 15px;\r\n");
      out.write("}\r\n");
      out.write("#bt{\r\n");
      out.write("margin-top:3%;\r\n");
      out.write("margin-left: 50%;\r\n");
      out.write("font-size: 15px;\r\n");
      out.write("background-color:navy;\r\n");
      out.write("color:white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("<body>\r\n");
      out.write("   <div>\r\n");
      out.write("      <div>\r\n");
      out.write("         <div class=\"flex-box1\">\r\n");
      out.write("            <div id=\"box1\">\r\n");
      out.write("               <div id=\"top-box1\">\r\n");
      out.write("                  <span id=\"tob-box1-span\">쌍용대학교</span>\r\n");
      out.write("               </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div id=\"top-box2\">\r\n");
      out.write("               <span id=\"tob-box2-span\">");
      out.print(session.getAttribute("id"));
      out.write("교수</span>\r\n");
      out.write("            </div>\r\n");
      out.write("         </div>\r\n");
      out.write("\r\n");
      out.write("         <div class=\"flex-box2\">\r\n");
      out.write("            <div id=\"flex-box2_box1\">\r\n");
      out.write("               <div>\r\n");
      out.write("                  <div id=\"nav-box\">\r\n");
      out.write("                     <ul id=\"navi\">\r\n");
      out.write("                        <li class=\"group\">\r\n");
      out.write("                           <div class=\"title\">공지사항</div>\r\n");
      out.write("                           <ul class=\"sub\">\r\n");
      out.write("                              <li><a href=\"#\">-공지게시판</a></li>\r\n");
      out.write("                           </ul>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li class=\"group\">\r\n");
      out.write("                           <div class=\"title\">강의관리</div>\r\n");
      out.write("                           <ul class=\"sub\">\r\n");
      out.write("                              <li><a href=\"a02_lectureadd.jsp\">-강의 등록</a></li>\r\n");
      out.write("                              <li><a href=\"a02_lecturemodify.jsp\">-강의 수정</a></li>\r\n");
      out.write("                              <li><a href=\"a02_lecturedelete.jsp\">-강의 삭제</a></li>\r\n");
      out.write("                           </ul>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li class=\"group\">\r\n");
      out.write("                           <div class=\"title\">출결관리</div>\r\n");
      out.write("                           <ul class=\"sub\">\r\n");
      out.write("                              <li><a href=\"#\">-출결 등록</a></li>\r\n");
      out.write("                              <li><a href=\"#\">-출결 삭제</a></li>\r\n");
      out.write("                           </ul>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li class=\"group\">\r\n");
      out.write("                           <div class=\"title\">강의계획서관리</div>\r\n");
      out.write("                           <ul class=\"sub\">\r\n");
      out.write("                              <li><a href=\"#\">-강의계획서 등록</a></li>\r\n");
      out.write("                              <li><a href=\"#\">-강의계획서 수정</a></li>\r\n");
      out.write("                              <li><a href=\"#\">-강의계획서 삭제</a></li>\r\n");
      out.write("                           </ul>\r\n");
      out.write("                        </li>\r\n");
      out.write("                     </ul>\r\n");
      out.write("                  </div>\r\n");
      out.write("\r\n");
      out.write("               </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div id=\"flex-box2_box2\">\r\n");
      out.write("               <div class=\"main-box-flex\">\r\n");
      out.write("                  <div id=\"main-box1\">\r\n");
      out.write("                     <div id=\"main-box1-iteam\">\r\n");
      out.write("                        <span class=\"span-margin\" id=\"span1\">강의등록</span>\r\n");
      out.write("                     </div>\r\n");
      out.write("                     <div>\r\n");
      out.write("                        <span class=\"span-margin\">강의관리 > 강의등록</span>\r\n");
      out.write("                     </div>\r\n");
      out.write("                  </div>\r\n");
      out.write("               </div>\r\n");
      out.write("\r\n");
      out.write("               <div class=\"main-box-flex\">\r\n");
      out.write("                  <div id=\"main-box2\">\r\n");
      out.write("                     <div>\r\n");
      out.write("                     <form>\r\n");
      out.write("                     <table id=\"addtable\">\r\n");
      out.write("                     	<tr><td>연도</td><td>\r\n");
      out.write("                     		<select name=\"lecYear\">\r\n");
      out.write("	                     	<option value=\"2018\">2018</option>\r\n");
      out.write("	                     	<option value=\"2019\">2019</option>\r\n");
      out.write("	                     	<option value=\"2020\">2020</option>\r\n");
      out.write("	                     	<option value=\"2021\">2021</option>\r\n");
      out.write("	                     	<option value=\"2022\" selected>2022</option>\r\n");
      out.write("	                     	<option value=\"2023\">2023</option>\r\n");
      out.write("	                     	</select>\r\n");
      out.write("                     	</td></tr>\r\n");
      out.write("                     	<tr><td>학기</td><td>\r\n");
      out.write("                     	 	<select name=\"semester\">\r\n");
      out.write("	                     	<option value=\"1\">1학기</option>\r\n");
      out.write("	                     	<option value=\"2\" selected>2학기</option>\r\n");
      out.write("	                     	</select>\r\n");
      out.write("                     	</td></tr>\r\n");
      out.write("                     	<tr><td>강의번호</td><td><input type=\"text\" name=\"lecNum\" placeholder=\"강의번호\"/></td></tr>\r\n");
      out.write("                     	<tr><td>강의명</td><td><input type=\"text\" name=\"lecName\" placeholder=\"강의명\"/></td></tr>\r\n");
      out.write("                     	<tr><td>강의실 위치</td><td><input type=\"text\" name=\"lecLoc\" placeholder=\"강의실 위치\"/></td></tr>\r\n");
      out.write("                     	<tr><td>학점</td><td>\r\n");
      out.write("							<select name=\"grade\">\r\n");
      out.write("	                     	<option value=\"1\">1</option>\r\n");
      out.write("	                     	<option value=\"2\">2</option>\r\n");
      out.write("	                     	<option value=\"3\" selected>3</option>\r\n");
      out.write("	                     	</select>\r\n");
      out.write("                     	</td></tr>\r\n");
      out.write("                     	<tr><td>학과번호</td><td><input type=\"text\" name=\"majorNo\" placeholder=\"학과\"/></td></tr>\r\n");
      out.write("                     	<tr><td>시간</td><td><input type=\"text\" name=\"times\" placeholder=\"시간\"/></td></tr>\r\n");
      out.write("                     	<tr><td>구분</td><td>\r\n");
      out.write("	                     	<select name=\"sort\">\r\n");
      out.write("	                     	<option value=\"전공필수\">전공필수</option>\r\n");
      out.write("	                     	<option value=\"전공선택\" selected>전공선택</option>\r\n");
      out.write("	                     	<option value=\"교양필수\">교양필수</option>\r\n");
      out.write("	                     	<option value=\"교양선택\">교양선택</option>\r\n");
      out.write("	                     	</select>\r\n");
      out.write("                     	</td></tr>\r\n");
      out.write("                     </table>\r\n");
      out.write("                     <input type=\"submit\" id=\"bt\" onclick=\"ckValid()\" value=\"등록\"/>\r\n");
      out.write("                     </form>\r\n");
      out.write("                     </div>\r\n");
      out.write("                  </div>\r\n");
      out.write("               </div>\r\n");
      out.write("            </div>\r\n");
      out.write("         </div>\r\n");
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("   </div>\r\n");
      out.write("   <div></div>\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("   $(document).ready(function() {\r\n");
      out.write("\r\n");
      out.write("      //모든 서브 메뉴 감추기\r\n");
      out.write("      $(\".sub\").css({\r\n");
      out.write("         display : \"none\"\r\n");
      out.write("      });\r\n");
      out.write("      //$(\".sub\").hide(); //위코드와 동일 \r\n");
      out.write("\r\n");
      out.write("      $(\".title\").click(function() {\r\n");
      out.write("         //일단 서브메뉴 다 가립니다.\r\n");
      out.write("         //$(\".sub\").css({display:\"none\"});\r\n");
      out.write("\r\n");
      out.write("         //열린 서브메뉴에 대해서만 가립니다.\r\n");
      out.write("         $(\".sub\").each(function() {\r\n");
      out.write("            console.log($(this).css(\"display\"));\r\n");
      out.write("            if ($(this).css(\"display\") == \"block\") {\r\n");
      out.write("               //$(\".sub\").css({display:\"none\"});\r\n");
      out.write("               //$(this).hide();\r\n");
      out.write("               $(this).slideUp(\"fast\");\r\n");
      out.write("            }\r\n");
      out.write("         });\r\n");
      out.write("\r\n");
      out.write("         //현재 요소의 다음 요소를 보이게 합니다.\r\n");
      out.write("         //$(this).next(\"ul\").css({display:\"block\"});\r\n");
      out.write("         //$(this).next(\"ul\").show();\r\n");
      out.write("         $(this).next(\"ul\").slideDown(\"fast\");\r\n");
      out.write("\r\n");
      out.write("      })\r\n");
      out.write("   });\r\n");
      out.write(" \r\n");
      out.write("   ");


	String lecName = request.getParameter("lecName");
	String lecLoc = request.getParameter("lecLoc");
	String lecPlan = null;
	String lecNum = request.getParameter("lecNum");
	int lecNumInt = 0;
	if(lecNum!=null&&!lecNum.equals("")){
		System.out.println("문자열크기:"+lecNum.length());
		try{
			lecNumInt = Integer.parseInt(lecNum);
		}catch(Exception e){
			log(e.getMessage());
		}
	}
	String lecYear = request.getParameter("lecYear");
	int lecYearInt = 0;
	if(lecYear!=null&&!lecYear.equals("")){
		System.out.println("문자열크기:"+lecYear.length());
		try{
			lecYearInt = Integer.parseInt(lecYear);
		}catch(Exception e){
			log(e.getMessage());
		}
	}
	String semester = request.getParameter("semester");
	int semesterInt = 0;
	if(semester!=null&&!semester.equals("")){
		System.out.println("문자열크기:"+semester.length());
		try{
			semesterInt = Integer.parseInt(semester);
		}catch(Exception e){
			log(e.getMessage());
		}
	}
	String grade = request.getParameter("grade");
	int gradeInt = 0;
	if(grade!=null&&!grade.equals("")){
		System.out.println("문자열크기:"+grade.length());
		try{
			gradeInt = Integer.parseInt(grade);
		}catch(Exception e){
			log(e.getMessage());
		}
	}
	String majorNo = request.getParameter("majorNo");
	int majorNoInt = 0;
	if(majorNo!=null&&!majorNo.equals("")){
		System.out.println("문자열크기:"+majorNo.length());
		try{
			majorNoInt = Integer.parseInt(majorNo);
		}catch(Exception e){
			log(e.getMessage());
		}
	}
	String times = request.getParameter("times");
	String sort = request.getParameter("sort");
	String id = null;
	   boolean isInsert = false;
	   if(lecNum!=null&& !lecNum.equals("")){
		 lectureVO ins = new lectureVO(lecNumInt, lecName, lecLoc, lecYearInt, semesterInt, gradeInt, majorNoInt, times, sort);
	     eduDao dao = new eduDao();
	      dao.insertLecture(ins);
	      isInsert = true;
	   }
	
   
      out.write("   \r\n");
      out.write("   document.querySelector(\"table\").submit();\r\n");
      out.write("</script>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
