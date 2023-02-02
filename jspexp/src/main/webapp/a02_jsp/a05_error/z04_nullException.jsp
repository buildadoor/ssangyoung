<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"    
    import="jspexp.vo.*"
    import="jspexp.a13_database.*"    
    import="jspexp.a13_database.vo.*"
    isErrorPage="true"     
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

	<h2 align="center">Null pointer 예외 발생</h2>
	<h2 align="center">데이터가 없는지 확인해주세요</h2>
	<table>
		<tr><th><%=exception.getClass().getName() %></th></tr>
		<tr><th><%=exception.getMessage() %></th></tr>
	</table>
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