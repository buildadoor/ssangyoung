/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.70
 * Generated at: 2023-01-04 06:19:14 UTC
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
import javaexp.sql.*;
import jspexp.a13_database.*;
import jspexp.a13_database.vo.*;

public final class schStudent1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_packages.add("jspexp.a13_database.vo");
    _jspx_imports_packages.add("javaexp.sql");
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

      out.write('\r');
      out.write('\n');

 	// post방식에서 한글요청값을 받을 때, 반드시 설정되어야한다.
 	request.setCharacterEncoding("utf-8");
 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" ");
      if (_jspx_meth_fmt_005frequestEncoding_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("	<head>\r\n");
      out.write("		<meta charset=\"UTF-8\">\r\n");
      out.write("		<title>쌍용대학교</title>\r\n");
      out.write("		<link href=\"img/ss.png\" rel=\"shortcut icon\" type=\"image/x-icon\">\r\n");
      out.write("		<link href=\"PJ_css/main.css\" type=\"text/css\" rel=\"stylesheet\">\r\n");
      out.write("		<script type=\"text/javascript\"\r\n");
      out.write("  		 src=\"http://code.jquery.com/jquery-1.8.3.min.js\"></script>\r\n");
      out.write("  		 <script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@9\"></script>\r\n");
      out.write("\r\n");
      out.write("	</head>\r\n");
      out.write("	<body>\r\n");
      out.write("	<div>\r\n");
      out.write("      <div>\r\n");
      out.write("         <div class=\"flex-box1\">\r\n");
      out.write("            <div id=\"box1\">\r\n");
      out.write("               <div id=\"top-box1\">\r\n");
      out.write("                  <span id=\"tob-box1-span\">쌍용대학교</span>\r\n");
      out.write("               </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            <div id=\"top-box2\">\r\n");
      out.write(" 			   <span id=\"tob-box2-span\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pro.proName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" 교수</span>\r\n");
      out.write("               <span id=\"tob-box2-span\"><input type=\"button\" id=\"bt2\" value=\"로그아웃\" onclick=\"logout()\"></span>\r\n");
      out.write("            </div>\r\n");
      out.write("         </div>\r\n");
      out.write("		\r\n");
      out.write("         <div class=\"flex-box2\">\r\n");
      out.write("            <div id=\"flex-box2_box1\">\r\n");
      out.write("               <div>\r\n");
      out.write("                  <div id=\"nav-box\">\r\n");
      out.write("                    <ul id=\"navi\">                   \r\n");
      out.write("                        <li class=\"group\">\r\n");
      out.write("							<div class=\"title\">공지사항</div>\r\n");
      out.write("							<ul class=\"sub\">\r\n");
      out.write("								<li><a href=\"noticeNo1.jsp\">공지사항 조회</a></li>\r\n");
      out.write("							</ul>                       	\r\n");
      out.write("                           <div class=\"title\">강의 관리</div>\r\n");
      out.write("                           <ul class=\"sub\">\r\n");
      out.write("							  <li><a href=\"lectureadd.jsp\">강의 등록</a></li>\r\n");
      out.write("                              <li><a href=\"lecturemodify.jsp\">강의 수정</a></li>\r\n");
      out.write("                              <li><a href=\"lecturedelete.jsp\">강의 삭제</a></li>\r\n");
      out.write("                              <li><a href=\"lecEval.jsp?id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pro.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">강의평가 조회</a></li>\r\n");
      out.write("                              <li><a href=\"lecplanadd.jsp\">강의계획서 관리</a></li>\r\n");
      out.write("                           </ul>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li class=\"group\">\r\n");
      out.write("                           <div class=\"title\">성적 관리</div>\r\n");
      out.write("                           <ul class=\"sub\">\r\n");
      out.write("                              <li><a href=\"schStudent.jsp?id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pro.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">성적 입력</a></li>\r\n");
      out.write("                           </ul>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li class=\"group\">\r\n");
      out.write("                           <div class=\"title\">학생관리</div>\r\n");
      out.write("                           <ul class=\"sub\">\r\n");
      out.write("                              <li><a href=\"search.jsp\">학생 조회</a></li>\r\n");
      out.write("                              <li><a href=\"sendemail.jsp\">이메일 발송</a></li>\r\n");
      out.write("                              <li><a href=\"studentAt.jsp\">출결 관리</a></li>\r\n");
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
      out.write("                        <span class=\"span-margin\" id=\"span1\">성적입력</span>\r\n");
      out.write("                     </div>\r\n");
      out.write("                     <div>\r\n");
      out.write("                        <span class=\"span-margin\">성적관리 > 성적입력</span>\r\n");
      out.write("                     </div>\r\n");
      out.write("                  </div>\r\n");
      out.write("               </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("				");
      jspexp.a13_database.A01_schStudent dao = null;
      dao = (jspexp.a13_database.A01_schStudent) _jspx_page_context.getAttribute("dao", javax.servlet.jsp.PageContext.PAGE_SCOPE);
      if (dao == null){
        dao = new jspexp.a13_database.A01_schStudent();
        _jspx_page_context.setAttribute("dao", dao, javax.servlet.jsp.PageContext.PAGE_SCOPE);
      }
      out.write("\r\n");
      out.write("				");
      jspexp.a13_database.Student sch = null;
      sch = (jspexp.a13_database.Student) _jspx_page_context.getAttribute("sch", javax.servlet.jsp.PageContext.PAGE_SCOPE);
      if (sch == null){
        sch = new jspexp.a13_database.Student();
        _jspx_page_context.setAttribute("sch", sch, javax.servlet.jsp.PageContext.PAGE_SCOPE);
      }
      out.write("\r\n");
      out.write("				");
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("sch"), request);
      out.write("\r\n");
      out.write("				");

				String lecNum = request.getParameter("lecNum");
				int lecNumInt = 0;
				if(lecNum != null) lecNumInt = Integer.parseInt(lecNum);
				session.setAttribute("lecNum", lecNumInt);
				
				if(lecNum != null){
				
      out.write("\r\n");
      out.write("				");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("				");
 } 
      out.write("\r\n");
      out.write("			\r\n");
      out.write("               <div class=\"main-box-flex\">\r\n");
      out.write("                  <div id=\"main-box2\">\r\n");
      out.write("                     <div id=\"subtitle\">수강생리스트 | 과목명</div>\r\n");
      out.write("					\r\n");
      out.write("                     <table>\r\n");
      out.write("                         <col width=\"20%\">\r\n");
      out.write("                         <col width=\"20%\">\r\n");
      out.write("                         <col width=\"20%\">\r\n");
      out.write("                         <col width=\"20%\">\r\n");
      out.write("                         <col width=\"20%\">\r\n");
      out.write("                         <thead>\r\n");
      out.write("                            <tr><th>학번</th><th>이름</th><th>학과</th><th>학년</th><th>성적관리</th></tr>\r\n");
      out.write("                         </thead>\r\n");
      out.write("                         <tbody>\r\n");
      out.write("                        	");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                         </tbody>\r\n");
      out.write("                      </table>\r\n");
      out.write("                  </div>\r\n");
      out.write("               </div>\r\n");
      out.write("               \r\n");
      out.write("               \r\n");
      out.write("            </div>\r\n");
      out.write("         </div>\r\n");
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("		\r\n");
      out.write("	</body>\r\n");
      out.write("	<script type=\"text/javascript\">\r\n");
      out.write("	 $(document).ready(function() {\r\n");
      out.write("\r\n");
      out.write("	      //모든 서브 메뉴 감추기\r\n");
      out.write("	      $(\".sub\").css({\r\n");
      out.write("	         display : \"none\"\r\n");
      out.write("	      });\r\n");
      out.write("	      //$(\".sub\").hide(); //위코드와 동일 \r\n");
      out.write("\r\n");
      out.write("	      $(\".title\").click(function() {\r\n");
      out.write("	         //일단 서브메뉴 다 가립니다.\r\n");
      out.write("	         //$(\".sub\").css({display:\"none\"});\r\n");
      out.write("\r\n");
      out.write("	         //열린 서브메뉴에 대해서만 가립니다.\r\n");
      out.write("	         $(\".sub\").each(function() {\r\n");
      out.write("	            console.log($(this).css(\"display\"));\r\n");
      out.write("	            if ($(this).css(\"display\") == \"block\") {\r\n");
      out.write("	               //$(\".sub\").css({display:\"none\"});\r\n");
      out.write("	               //$(this).hide();\r\n");
      out.write("	               $(this).slideUp(\"fast\");\r\n");
      out.write("	            }\r\n");
      out.write("	         });\r\n");
      out.write("\r\n");
      out.write("	         //현재 요소의 다음 요소를 보이게 합니다.\r\n");
      out.write("	         //$(this).next(\"ul\").css({display:\"block\"});\r\n");
      out.write("	         //$(this).next(\"ul\").show();\r\n");
      out.write("	         $(this).next(\"ul\").slideDown(\"fast\");\r\n");
      out.write("\r\n");
      out.write("	      })\r\n");
      out.write("	   });\r\n");
      out.write("	 \r\n");
      out.write("	 function logout(){\r\n");
      out.write("		  Swal.fire({\r\n");
      out.write("			  title: '로그아웃하시겠습니까?',\r\n");
      out.write("			  icon: 'question',\r\n");
      out.write("			  showCancelButton: true, // cancel버튼 보이기. 기본은 원래 없음\r\n");
      out.write("			  confirmButtonColor: '#3085d6', // confrim 버튼 색깔 지정\r\n");
      out.write("			  cancelButtonColor: '#d33', // cancel 버튼 색깔 지정\r\n");
      out.write("			  confirmButtonText: '확인', // confirm 버튼 텍스트 지정\r\n");
      out.write("			  cancelButtonText: '취소' // cancel 버튼 텍스트 지정\r\n");
      out.write("			}).then((result) => {\r\n");
      out.write("			  if (result.value) {\r\n");
      out.write("	              //\"삭제\" 버튼을 눌렀을 때 작업할 내용을 이곳에 넣어주면 된다. \r\n");
      out.write("				  location.href=\"a01_login_DB.jsp\"\r\n");
      out.write("	              \r\n");
      out.write("			  }\r\n");
      out.write("			})\r\n");
      out.write("\r\n");
      out.write("	      }\r\n");
      out.write("	 \r\n");
      out.write("	 \r\n");
      out.write("	 //성적 입력/수정 페이지 이동\r\n");
      out.write("	  var lecNumInt = ");
      out.print(lecNumInt );
      out.write("\r\n");
      out.write("    function inputGrade(id) {\r\n");
      out.write("         location.href=\"inputGrade.jsp?id=\"+id+\"&lecNum=\"+lecNumInt;\r\n");
      out.write("    }\r\n");
      out.write("	 \r\n");
      out.write("	 \r\n");
      out.write("	 \r\n");
      out.write("	 //성적 삭제\r\n");
      out.write("	 function delGrade(id) {\r\n");
      out.write("		 Swal.fire({\r\n");
      out.write("			  title: '해당 학생의 성적을\\n삭제하시겠습니까?',\r\n");
      out.write("			  text: \"삭제한 성적은 다시 복구시킬 수 없습니다.\",\r\n");
      out.write("			  icon: 'warning',\r\n");
      out.write("			  showCancelButton: true, \r\n");
      out.write("			  confirmButtonColor: '#3085d6',\r\n");
      out.write("			  cancelButtonColor: '#d33',\r\n");
      out.write("			  confirmButtonText: '확인', \r\n");
      out.write("			  cancelButtonText: '취소'\r\n");
      out.write("			}).then((result) => {\r\n");
      out.write("				  if (result.value) {s\r\n");
      out.write("					  location.href=\"delGrade.jsp?id=\"+id+\"&lecNum=\"+lecNumInt;\r\n");
      out.write("				  }\r\n");
      out.write("		 	})\r\n");
      out.write("	 }\r\n");
      out.write("	 \r\n");
      out.write("	 \r\n");
      out.write("	</script>\r\n");
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
      // /z03_edu/schStudent1.jsp(15,1) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
      // /z03_edu/schStudent1.jsp(106,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${lecNum eq lecNumInt}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sch.setLecNum(lecNumInt)}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
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
      // /z03_edu/schStudent1.jsp(123,25) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("std");
      // /z03_edu/schStudent1.jsp(123,25) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/z03_edu/schStudent1.jsp(123,25) '${dao.schStu(sch)}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${dao.schStu(sch)}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("                            <tr>\r\n");
            out.write("								<td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${std.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("								<td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${std.stdName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("								<td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${std.majorName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("								<td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${std.stdYear}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("								<td>\r\n");
            out.write("									<a onclick=\"inputGrade(");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${std.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write(")\" class=\"entry\"><span>입력/수정</span></a>\r\n");
            out.write("									<a onclick=\"delGrade(");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${std.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write(")\" class=\"del\"><span>삭 제</span></a>\r\n");
            out.write("								</td>\r\n");
            out.write("							</tr>\r\n");
            out.write("							");
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
