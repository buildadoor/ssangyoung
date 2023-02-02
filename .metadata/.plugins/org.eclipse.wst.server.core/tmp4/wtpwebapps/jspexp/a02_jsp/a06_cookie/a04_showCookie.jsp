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
#
--%>
<h2 align="center">🍪🍪🍪장바구니 담긴 물건 확인 - 쿠키값 보기🍪🍪🍪</h2>
<%
	Cookie [] cookies = request.getCookies();
	
%>
<table>
	<tr><th>키</th><th>값</th></tr>
	<%for(Cookie ck:cookies){
			if(!ck.getName().equals("JSESSIONID")){
	%>
	<tr><td><%=ck.getName() %></td><td><%=ck.getValue() %></td></tr>
	<%}
	}
	%>
</table>

</body>
<script type="text/javascript">
/*

 */

var div = document.querySelector("#container")
div.innerHTML+="<br>"
</script>
</html>