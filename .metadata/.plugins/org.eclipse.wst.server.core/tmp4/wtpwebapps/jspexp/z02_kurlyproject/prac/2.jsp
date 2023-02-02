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
String password = request.getParameter("password");
if(id.equals("ssangyong") && password.equals("abc123")){
				session.setAttribute("id",id);
				response.sendRedirect("1.jsp");
			}else{
				//request.setAttribute()로 처리해도 되지만.
				//request.getParameter("id")로 처리가 되기에 생략가능
				request.getRequestDispatcher("0.jsp"
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