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
<div id="container"></div>
<%-- 
#쿠키만들기
--%>
<%
	//1. 쿠키만들기
	Cookie c1 = new Cookie("c01","himan");
	//2. 쿠키 클라이언트에 보내기 
	response.addCookie(c1);
%>
	<h2>쿠키 굽기 완료~</h2>
	<a href="a02_showCookie.jsp">내가 만든 쿠키~🍪🍪🍪🍪</a>



</body>
<script type="text/javascript">
/*

 */

var div = document.querySelector("#container")
div.innerHTML+="<br>"
</script>
</html>