/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.70
 * Generated at: 2023-01-03 09:33:40 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.z03_005fedu;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import jspexp.vo.*;
import jspexp.a13_database.*;

public final class tuition_005fbill_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1670827704816L));
    _jspx_dependants.put("jar:file:/C:/a01_javaexp/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp4/wtpwebapps/jspexp/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("jar:file:/C:/a01_javaexp/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp4/wtpwebapps/jspexp/WEB-INF/lib/jstl-1.2.jar!/META-INF/fmt.tld", Long.valueOf(1153352682000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("jspexp.a13_database");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("jspexp.vo");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ffmt_005frequestEncoding_0026_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

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
    _005fjspx_005ftagPool_005ffmt_005frequestEncoding_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005ffmt_005frequestEncoding_0026_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
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
      out.write("        \r\n");
      out.write("\r\n");
      out.write(" ");
      if (_jspx_meth_fmt_005frequestEncoding_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>쌍용 대학교</title>\r\n");
      out.write("<link href=\"main.css\" type=\"text/css\" rel=\"stylesheet\">\r\n");
      out.write("<style>\r\n");
      out.write("@charset \"UTF-8\";\r\n");
      out.write("\r\n");
      out.write("body {\r\n");
      out.write("   margin: 0;\r\n");
      out.write("   padding: 0px;\r\n");
      out.write("   background-color: #f2f2f9;\r\n");
      out.write("   font-weight: bold;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".flex-box1 {\r\n");
      out.write("   display: flex;\r\n");
      out.write("   width: 100%;\r\n");
      out.write("   justify-content: space-between;\r\n");
      out.write("   height: 80px;\r\n");
      out.write("   box-shadow: 1px 1px;\r\n");
      out.write("   background-color: white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#top-box1 {\r\n");
      out.write("   text-align: center;\r\n");
      out.write("   font-size: 25px;\r\n");
      out.write("   height: 100%;\r\n");
      out.write("   position: relative;\r\n");
      out.write("   width: 340px;\r\n");
      out.write("   background-color: rgb(41, 128, 185);\r\n");
      out.write("   color: white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#tob-box1-span {\r\n");
      out.write("   position: relative;\r\n");
      out.write("   top: 25px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#tob-box2-span {\r\n");
      out.write("   position: relative;\r\n");
      out.write("   top: 30px;\r\n");
      out.write("   right: 40px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#top-box2 {\r\n");
      out.write("   margin-right: 20px;\r\n");
      out.write("   height: 100%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#box1 {\r\n");
      out.write("   width: 200px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".flex-box2 {\r\n");
      out.write("   display: flex;\r\n");
      out.write("   width: 100%;\r\n");
      out.write("   justify-content: space-between;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#flex-box2_box1 {\r\n");
      out.write("   height: 899px;\r\n");
      out.write("   background: rgb(41, 128, 185);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#flex-box2_box2 {\r\n");
      out.write("   width: 90%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".main-box-flex {\r\n");
      out.write("   display: flex;\r\n");
      out.write("   justify-content: center;\r\n");
      out.write("   margin: 40px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#main-box1 {\r\n");
      out.write("   display: flex;\r\n");
      out.write("   justify-content: space-between;\r\n");
      out.write("   align-items: center;\r\n");
      out.write("   width: 100%;\r\n");
      out.write("   height: 50px;\r\n");
      out.write("   border: 1px solid gray;\r\n");
      out.write("   box-shadow: 1px 1px;\r\n");
      out.write("   background-color:white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#main-box2 {\r\n");
      out.write("   width: 100%;\r\n");
      out.write("   height: 650px;\r\n");
      out.write("   border: 1px solid gray;\r\n");
      out.write("   box-shadow: 1px 1px;\r\n");
      out.write("   background-color:white;\r\n");
      out.write("   \r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".span-margin{\r\n");
      out.write("   margin-left:40px;\r\n");
      out.write("   margin-right:40px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#span1{\r\n");
      out.write("   font-size:20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#nav-box {\r\n");
      out.write("   width: 100%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ul#navi {\r\n");
      out.write("   width: 200px;\r\n");
      out.write("   text-indent: 10px;\r\n");
      out.write("   font-size: 15px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ul#navi, ul#navi ul {\r\n");
      out.write("   margin: 0;\r\n");
      out.write("   padding: 0;\r\n");
      out.write("   list-style: none;\r\n");
      out.write("   width: 340px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("li.group {\r\n");
      out.write("   color: white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("li.group div.title {\r\n");
      out.write("   height: 50px;\r\n");
      out.write("   line-height: 50px;\r\n");
      out.write("   background: rgb(64, 89, 106);\r\n");
      out.write("   cursor: pointer;\r\n");
      out.write("   padding-left: 25px;\r\n");
      out.write("   font-weight: 600;\r\n");
      out.write("   background-image: url(\"img/down.png\");\r\n");
      out.write("   background-position: right 10px center;\r\n");
      out.write("   background-repeat: no-repeat;\r\n");
      out.write("   background-size: 15px 15px;\r\n");
      out.write("   font-size: 17px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ul.sub li {\r\n");
      out.write("   height: 35px;\r\n");
      out.write("   line-height: 35px;\r\n");
      out.write("   background: rgb(41, 128, 185);\r\n");
      out.write("   cursor: pointer;\r\n");
      out.write("   padding-left: 40px;\r\n");
      out.write("   font-weight: 550;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ul.sub li a {\r\n");
      out.write("   display: block;\r\n");
      out.write("   width: 100%;\r\n");
      out.write("   height: 100%;\r\n");
      out.write("   text-decoration: none;\r\n");
      out.write("   color: white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ul.sub li:hover {\r\n");
      out.write("   background: rgb(64, 89, 106);\r\n");
      out.write("}\r\n");
      out.write("#bt2{\r\n");
      out.write("font-size: 15px;\r\n");
      out.write("border-radius:4px; \r\n");
      out.write("background:#0066CC;\r\n");
      out.write("color:white;\r\n");
      out.write("border:1px solid gray;\r\n");
      out.write("font-size:15px;\r\n");
      out.write("}\r\n");
      out.write(".tui{\r\n");
      out.write("	overflow-y:scroll;\r\n");
      out.write("	height:600px;\r\n");
      out.write("	align:center;\r\n");
      out.write("	width:700px;\r\n");
      out.write("	margin-left:300px;\r\n");
      out.write("\r\n");
      out.write("	margin-top:30px;\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write(".img{\r\n");
      out.write("	margin-left:100px;\r\n");
      out.write("	margin-right:auto;\r\n");
      out.write("	width:530px;\r\n");
      out.write("	heght:380px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("   src=\"http://code.jquery.com/jquery-1.8.3.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("   <div>\r\n");
      out.write("      <div>\r\n");
      out.write("         <div class=\"flex-box1\">\r\n");
      out.write("            <div id=\"box1\">\r\n");
      out.write("               <div id=\"top-box1\">\r\n");
      out.write("                  <span id=\"tob-box1-span\">쌍용대학교</span>\r\n");
      out.write("               </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            <div id=\"top-box2\">\r\n");
      out.write("                <span id=\"tob-box2-span\">ID ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mem.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" 학생</span>\r\n");
      out.write("               <span id=\"tob-box2-span\"><input type=\"button\" id=\"bt2\" value=\"로그아웃\" onclick=\"logout()\" /></span>\r\n");
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
      out.write("\r\n");
      out.write("                           <ul class=\"sub\">\r\n");
      out.write("                              <li><a href=\"noticeBoard.jsp\">공지게시판</a></li>\r\n");
      out.write("                           </ul>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li class=\"group\">\r\n");
      out.write("                           <div class=\"title\">수강신청</div>\r\n");
      out.write("                           <ul class=\"sub\">\r\n");
      out.write("                              <li><a href=\"regLecture_01.jsp\">수강신청</a></li>\r\n");
      out.write("                              <li><a href=\"regLecture_02.jsp\">수강신청내역</a></li>\r\n");
      out.write("                              <li><a href=\"timeTable.jsp\">시간표</a></li>\r\n");
      out.write("                           </ul>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li class=\"group\">\r\n");
      out.write("                           <div class=\"title\">강의 관리</div>\r\n");
      out.write("                           <ul class=\"sub\">\r\n");
      out.write("                              <li><a href=\"std_grade_sch.jsp\">성적조회</a></li>\r\n");
      out.write("                              <li><a href=\"std_lecPlan_sch.jsp\">강의계획서 조회</a></li>\r\n");
      out.write("                              <li><a href=\"std_lecEval_ins.jsp\">강의평가</a></li>\r\n");
      out.write("                           </ul>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li class=\"group\">\r\n");
      out.write("                           <div class=\"title\">학적 관리</div>\r\n");
      out.write("                           <ul class=\"sub\">\r\n");
      out.write("                              <li><a href=\"std_inform_sch.jsp\">학적정보</a></li>\r\n");
      out.write("                              <li><a href=\"std_inform_upt.jsp\">학적정보 변경</a></li>\r\n");
      out.write("                              <li><a href=\"std_inform_uptpw.jsp\">비밀번호 변경</a></li>\r\n");
      out.write("                              <li><a href=\"tuition_bill.jsp\">등록금 고지서 조회</a></li>\r\n");
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
      out.write("                        <span class=\"span-margin\" id=\"span1\">등록금고지서</span>\r\n");
      out.write("                     </div>\r\n");
      out.write("                     <div>\r\n");
      out.write("                        <span class=\"span-margin\">학적 > 등록금고지서 조회</span>\r\n");
      out.write("                     </div>\r\n");
      out.write("                  </div>\r\n");
      out.write("               </div>\r\n");
      out.write("\r\n");
      out.write("               <div class=\"main-box-flex\">\r\n");
      out.write("                  <div id=\"main-box2\">\r\n");
      out.write("                     <div>\r\n");
      out.write("                    \r\n");
      out.write("                     	");
      jspexp.a13_database.stdMgr dao = null;
      dao = (jspexp.a13_database.stdMgr) _jspx_page_context.getAttribute("dao", javax.servlet.jsp.PageContext.PAGE_SCOPE);
      if (dao == null){
        dao = new jspexp.a13_database.stdMgr();
        _jspx_page_context.setAttribute("dao", dao, javax.servlet.jsp.PageContext.PAGE_SCOPE);
      }
      out.write("\r\n");
      out.write("                        ");
      jspexp.vo.Tuition sch = null;
      sch = (jspexp.vo.Tuition) _jspx_page_context.getAttribute("sch", javax.servlet.jsp.PageContext.PAGE_SCOPE);
      if (sch == null){
        sch = new jspexp.vo.Tuition();
        _jspx_page_context.setAttribute("sch", sch, javax.servlet.jsp.PageContext.PAGE_SCOPE);
      }
      out.write("\r\n");
      out.write("                       ");
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("sch"), request);
      out.write("\r\n");
      out.write("	                     	 ");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("	                     	 ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("	                     	\r\n");
      out.write("	                     	\r\n");
      out.write("					 </div>\r\n");
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
      out.write("function logout(){\r\n");
      out.write("    if(confirm(\"로그아웃하시겠습니까?\")){\r\n");
      out.write("       location.href=\"a01_login_DB.jsp\"\r\n");
      out.write("    }\r\n");
      out.write(" }\r\n");
      out.write(" \r\n");
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

  private boolean _jspx_meth_fmt_005frequestEncoding_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  fmt:requestEncoding
    org.apache.taglibs.standard.tag.rt.fmt.RequestEncodingTag _jspx_th_fmt_005frequestEncoding_005f0 = (org.apache.taglibs.standard.tag.rt.fmt.RequestEncodingTag) _005fjspx_005ftagPool_005ffmt_005frequestEncoding_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.RequestEncodingTag.class);
    boolean _jspx_th_fmt_005frequestEncoding_005f0_reused = false;
    try {
      _jspx_th_fmt_005frequestEncoding_005f0.setPageContext(_jspx_page_context);
      _jspx_th_fmt_005frequestEncoding_005f0.setParent(null);
      // /z03_edu/tuition_bill.jsp(8,1) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_fmt_005frequestEncoding_005f0.setValue("UTF-8");
      int _jspx_eval_fmt_005frequestEncoding_005f0 = _jspx_th_fmt_005frequestEncoding_005f0.doStartTag();
      if (_jspx_th_fmt_005frequestEncoding_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005ffmt_005frequestEncoding_0026_005fvalue_005fnobody.reuse(_jspx_th_fmt_005frequestEncoding_005f0);
      _jspx_th_fmt_005frequestEncoding_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_fmt_005frequestEncoding_005f0, _jsp_getInstanceManager(), _jspx_th_fmt_005frequestEncoding_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /z03_edu/tuition_bill.jsp(274,24) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty mem.id}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sch.setId(\"\")}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f0_reused = false;
    try {
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent(null);
      // /z03_edu/tuition_bill.jsp(275,24) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("tui");
      // /z03_edu/tuition_bill.jsp(275,24) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/z03_edu/tuition_bill.jsp(275,24) '${dao.getFileName(mem.id)}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${dao.getFileName(mem.id)}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("	                     	 <div class=\"tui\">\r\n");
            out.write("	                     	 	<img class=\"img\" src=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tui.fileName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\"/>\r\n");
            out.write("	                     	 </div>\r\n");
            out.write("	                     	 ");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
      _jspx_th_c_005fforEach_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f0_reused);
    }
    return false;
  }
}
