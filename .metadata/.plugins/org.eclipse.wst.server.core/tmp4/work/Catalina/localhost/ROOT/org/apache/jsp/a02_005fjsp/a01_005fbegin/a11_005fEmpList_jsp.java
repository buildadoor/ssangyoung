/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.70
 * Generated at: 2022-12-14 11:57:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.a02_005fjsp.a01_005fbegin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import jspexp.a13_database.*;
import jspexp.a13_database.vo.*;

public final class a11_005fEmpList_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_packages.add("jspexp.a13_database");
    _jspx_imports_packages.add("javax.servlet.jsp");
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
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<link href=\"/a00_com/a01_common.css\" rel=\"stylesheet\">\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("/*\r\n");
      out.write(" a06_EmpList.jsp\r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write("*/\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<!-- 요청값 받기  -->\r\n");

String ename=request.getParameter("ename");if(ename==null) ename="";
String job=request.getParameter("job");if(job==null) job="";
String frSal=request.getParameter("frSal");if(frSal==null) frSal="0";
String toSal=request.getParameter("toSal");if(toSal==null) toSal="9999";
double frSalD =Double.parseDouble(frSal);
double toSalD =Double.parseDouble(toSal);

A02_EmpDao dao=new A02_EmpDao();/* 전체내용 */
Emp sch=new Emp(ename, job, frSalD, toSalD);
//초기에 전체 데이터 로딩, 입력 내용에 따라서 검색되게 처리 

      out.write("\r\n");
      out.write("<h2>사원정보</h2>\r\n");
      out.write("<form id=\"frm01\">\r\n");
      out.write("    \r\n");
      out.write("   <table>\r\n");
      out.write("     <col width=\"40%\">\r\n");
      out.write("      <tr><th>사원명</th>\r\n");
      out.write("          <td colspan=\"2\"><input type=\"text\" name=\"ename\" value=\"");
      out.print(ename);
      out.write("\"/></td></tr>\r\n");
      out.write("      <tr><th>직책명</th>\r\n");
      out.write("          <td colspan=\"2\"><input type=\"text\" name=\"job\"value=\"");
      out.print(job);
      out.write("\"/></td></tr>\r\n");
      out.write("      <tr><th>급여</th>\r\n");
      out.write("          <td><input type=\"text\" name=\"frSal\" value=\"0\" value=\"");
      out.print(frSal);
      out.write("\"/></td>\r\n");
      out.write("          <td><input type=\"text\" name=\"toSal\" value=\"9999\" value=\"");
      out.print(toSal);
      out.write("\"/></td></tr>\r\n");
      out.write("                        \r\n");
      out.write("      <tr><td colspan=\"3\">\r\n");
      out.write("          <input type=\"button\" onclick=\"send()\" value=\"검색\"/>\r\n");
      out.write("      </td></tr>                  \r\n");
      out.write("                        \r\n");
      out.write("    </table>  \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<!--  \r\n");
      out.write("-------------------------------------------------------------------------------\r\n");
      out.write("유효성 체크\r\n");
      out.write("-->\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    function send(){\r\n");
      out.write("       //사전에 전송되기 전에 데이터 유형성 check해서 전송\r\n");
      out.write("       var frSalObj=document.querySelector(\"[name=frSal]\")\r\n");
      out.write("       var toSalObj=document.querySelector(\"[name=toSal]\")\r\n");
      out.write("       //isNaN():숫자형 데이터인지를 확인 \r\n");
      out.write("       //Is not a number? \r\n");
      out.write("        //숫자형일 때, false\r\n");
      out.write("        //숫자형이 아닐 때, true \r\n");
      out.write("        //frSalObj.value==\"\": 데이터를 입력하지 않을 때 \r\n");
      out.write("        // \"\".trim():공백제거\r\n");
      out.write("        if((frSalObj.value.trim()==\"\")||isNaN(frSalObj.value)){\r\n");
      out.write("           alert(\"공백이거나 숫자형 데이터가 아닙니다.\")\r\n");
      out.write("           frSalObj.value=\"\";\r\n");
      out.write("           frSalObj.focus()\r\n");
      out.write("           return;// 프로세스 진행 방지\r\n");
      out.write("        }\r\n");
      out.write("        if((frSalObj.value.trim()==\"\")||isNaN(toSalObj.value)){\r\n");
      out.write("           alert(\"공백이거나 숫자형 데이터가 아닙니다.\")\r\n");
      out.write("           frSalObj.value=\"\";\r\n");
      out.write("           frSalObj.focus()\r\n");
      out.write("           return;// 프로세스 진행 방지\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("       \r\n");
      out.write("        if(Number(frSalObj.value) >Number(toSalObj.value) ){\r\n");
      out.write("           alert(\"시작 범위가 마지막 범위보다 크네요\")\r\n");
      out.write("           frSalObj.value=\"\"\r\n");
      out.write("           toSalObj.value=\"\"\r\n");
      out.write("           frSalObj.focus()\r\n");
      out.write("           return;\r\n");
      out.write("        }\r\n");
      out.write("        // 모든 유효성이 check되었을 때, 서버로 전송처리..\r\n");
      out.write("        // submit()을 클릭한 것과 동일한 효과처리 \r\n");
      out.write("        document.querySelector(\"#frm01\").submit()\r\n");
      out.write("        alert(\"전송\");\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("       alert(\"공백인경우\"+(frSalObj.value.trim()==\"\") );\r\n");
      out.write("       alert(\"숫자형이 아닐 경우\"+isNaN(frSalObj.value));\r\n");
      out.write("       \r\n");
      out.write("       \r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
      out.write("<!--  \r\n");
      out.write("-------------------------------------------------------------------------------\r\n");
      out.write("-->\r\n");
      out.write("\r\n");
      out.write("<table>\r\n");
      out.write("   <tr>\r\n");
      out.write("       <th>사원번호</th><th>사원명</th><th>직책명</th>\r\n");
      out.write("       <th>관리자번호</th><th>급여</th><th>부서번호</th>  \r\n");
      out.write("   </tr>\r\n");
      out.write("   \r\n");
      out.write("   ");

    for(Emp e:dao.getEmpSch(sch)){
   
      out.write("\r\n");
      out.write("   <tr>\r\n");
      out.write("      <td>");
      out.print(e.getEmpno() );
      out.write("</td>\r\n");
      out.write("      <td>");
      out.print(e.getEname() );
      out.write("</td>\r\n");
      out.write("      <td>");
      out.print(e.getJob() );
      out.write("</td>\r\n");
      out.write("      <td>");
      out.print(e.getMgr() );
      out.write("</td>\r\n");
      out.write("      <td>");
      out.print(e.getSal() );
      out.write("</td>\r\n");
      out.write("      <td>");
      out.print(e.getDeptno() );
      out.write("</td>\r\n");
      out.write("   </tr>\r\n");
      out.write("    ");
} 
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("/*\r\n");
      out.write("\r\n");
      out.write("*/\r\n");
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
