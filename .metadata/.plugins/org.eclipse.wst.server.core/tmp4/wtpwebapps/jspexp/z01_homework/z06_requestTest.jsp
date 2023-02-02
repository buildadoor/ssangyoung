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


<table>
	<tr><th>아이디: (페이지 범위 데이터)</th><td><%=pageContext.getAttribute("id") %></td></tr>
	<tr><th>이름: (요청 범위 데이터)</th><td><%=request.getAttribute("name") %></td></tr>
	<tr><th>포인트: (세션 범위 데이터)</th><td><%=session.getAttribute("point") %></td></tr>
	<tr><th>권한: (어플리케이션)</th><td><%=application.getAttribute("auth") %></td></tr>
</table>
<script type="text/javascript">
/*

 */

var div = document.querySelector("#container")
div.innerHTML+="<br>"
</script>
</html>