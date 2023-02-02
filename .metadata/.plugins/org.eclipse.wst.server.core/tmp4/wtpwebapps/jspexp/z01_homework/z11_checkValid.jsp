<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"    
    import="jspexp.vo.*"
    import="jspexp.a13_database.*"    
    import="jspexp.a13_database.vo.*"     
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/a00_com/a01_common.css" rel="stylesheet">
<script type="text/javascript">
/*
 
 */
</script>
</head>
<body>
<%
String id = request.getParameter("id");
String pass = request.getParameter("pass");
if(id.equals("himan") && pass.equals("7777")){
				session.setAttribute("id",id);
				response.sendRedirect("z12_main.jsp");
			}else{
				//request.setAttribute()로 처리해도 되지만.
				//request.getParameter("id")로 처리가 되기에 생략가능
				request.getRequestDispatcher("z10_login.jsp"
				).forward(request, response);
			}
			 %>		
<div id="container"></div>
<%-- 
#
--%>
</body>
<script type="text/javascript">
/*

 */

var div = document.querySelector("#container")
div.innerHTML+="<br>"
</script>
</html>