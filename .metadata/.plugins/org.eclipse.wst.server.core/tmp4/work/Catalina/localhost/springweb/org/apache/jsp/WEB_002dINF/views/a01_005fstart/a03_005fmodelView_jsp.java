/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.70
 * Generated at: 2023-01-10 03:53:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.a01_005fstart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class a03_005fmodelView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("jar:file:/C:/a01_javaexp/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp4/wtpwebapps/springweb/WEB-INF/lib/jstl-1.2.jar!/META-INF/fmt.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1673244311960L));
    _jspx_dependants.put("jar:file:/C:/a01_javaexp/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp4/wtpwebapps/springweb/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ffmt_005frequestEncoding_0026_005fvalue_005fnobody;

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
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ffmt_005frequestEncoding_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005ffmt_005frequestEncoding_0026_005fvalue_005fnobody.release();
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
      out.write("\r\n");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_fmt_005frequestEncoding_005f0(_jspx_page_context))
        return;
      out.write("     \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/a00_com/bootstrap.min.css\" >\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/a00_com/jquery-ui.css\" >\r\n");
      out.write("<style>\r\n");
      out.write("	td{text-align:center;}\r\n");
      out.write("</style>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/a00_com/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/a00_com/popper.min.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/a00_com/bootstrap.min.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/a00_com/jquery-ui.js\"></script>\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/vue/dist/vue.js\"></script>\r\n");
      out.write("<script src=\"https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api\" type=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("	$(document).ready(function(){\r\n");
      out.write("		");
      out.write("	\r\n");
      out.write("	});\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write(" 	 \r\n");
      out.write("	 \r\n");
      out.write("	 \r\n");
      out.write("<div class=\"jumbotron text-center\">\r\n");
      out.write("  <h2 data-toggle=\"modal\" data-target=\"#exampleModalCenter\">\r\n");
      out.write("  \r\n");
      out.write("  	<h2>이름: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${md_name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</h2>\r\n");
      out.write("	<h2>나이: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${md_age}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</h2>\r\n");
      out.write("	<h2>사는 곳: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${md_loc}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</h2>\r\n");
      out.write("	 </h2>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("	<form id=\"frm01\" class=\"form-inline\"  method=\"post\">\r\n");
      out.write("  	<nav class=\"navbar navbar-expand-sm bg-dark navbar-dark\">\r\n");
      out.write("	    <input class=\"form-control mr-sm-2\" placeholder=\"제목\" />\r\n");
      out.write("	    <input class=\"form-control mr-sm-2\" placeholder=\"내용\" />\r\n");
      out.write("	    <button class=\"btn btn-info\" type=\"submit\">Search</button>\r\n");
      out.write(" 	</nav>\r\n");
      out.write("	</form>\r\n");
      out.write("   <table class=\"table table-hover table-striped\">\r\n");
      out.write("   	<col width=\"10%\">\r\n");
      out.write("   	<col width=\"50%\">\r\n");
      out.write("   	<col width=\"15%\">\r\n");
      out.write("   	<col width=\"15%\">\r\n");
      out.write("   	<col width=\"10%\">\r\n");
      out.write("    <thead>\r\n");
      out.write("    \r\n");
      out.write("      <tr class=\"table-success text-center\">\r\n");
      out.write("        <th>번호</th>\r\n");
      out.write("        <th>제목</th>\r\n");
      out.write("        <th>작성자</th>\r\n");
      out.write("        <th>작성일</th>\r\n");
      out.write("        <th>조회</th>\r\n");
      out.write("      </tr>\r\n");
      out.write("    </thead>	\r\n");
      out.write("    <tbody>\r\n");
      out.write("    	<tr><td></td><td></td><td></td><td></td><td></td></tr>\r\n");
      out.write("    	<tr><td></td><td></td><td></td><td></td><td></td></tr>\r\n");
      out.write("    	<tr><td></td><td></td><td></td><td></td><td></td></tr>\r\n");
      out.write("    </tbody>\r\n");
      out.write("	</table>    \r\n");
      out.write("    \r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"modal fade\" id=\"exampleModalCenter\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalCenterTitle\" aria-hidden=\"true\">\r\n");
      out.write("  <div class=\"modal-dialog modal-dialog-centered\" role=\"document\">\r\n");
      out.write("    <div class=\"modal-content\">\r\n");
      out.write("      <div class=\"modal-header\">\r\n");
      out.write("        <h5 class=\"modal-title\" id=\"exampleModalLongTitle\">타이틀</h5>\r\n");
      out.write("        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n");
      out.write("          <span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("        </button>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"modal-body\">\r\n");
      out.write("		<form id=\"frm02\" class=\"form\"  method=\"post\">\r\n");
      out.write("	     <div class=\"row\">\r\n");
      out.write("	      <div class=\"col\">\r\n");
      out.write("	        <input type=\"text\" class=\"form-control\" placeholder=\"사원명 입력\" name=\"ename\">\r\n");
      out.write("	      </div>\r\n");
      out.write("	      <div class=\"col\">\r\n");
      out.write("	        <input type=\"text\" class=\"form-control\" placeholder=\"직책명 입력\" name=\"job\">\r\n");
      out.write("	      </div>\r\n");
      out.write("	     </div>\r\n");
      out.write("	    </form> \r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"modal-footer\">\r\n");
      out.write("        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\r\n");
      out.write("        <button type=\"button\" class=\"btn btn-primary\">Save changes</button>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
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

  private boolean _jspx_meth_c_005fset_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    boolean _jspx_th_c_005fset_005f0_reused = false;
    try {
      _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fset_005f0.setParent(null);
      // /WEB-INF/views/a01_start/a03_modelView.jsp(7,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setVar("path");
      // /WEB-INF/views/a01_start/a03_modelView.jsp(7,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/a01_start/a03_modelView.jsp(7,0) '${pageContext.request.contextPath }'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${pageContext.request.contextPath }",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
      if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      _jspx_th_c_005fset_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fset_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fset_005f0_reused);
    }
    return false;
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
      // /WEB-INF/views/a01_start/a03_modelView.jsp(8,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_fmt_005frequestEncoding_005f0.setValue("utf-8");
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
}
