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
	String id = (String)session.getAttribute("id");

%>
<h2><%=id%>님 로그인 중입니다.</h2>
</body>
<script type="text/javascript">
	var id = "<%=id%>"
	alert(id+"님 로그인 성공")
/*

 */

var div = document.querySelector("#container")
div.innerHTML+="<br>"
</script>
</html>