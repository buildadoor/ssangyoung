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
<%
//전달 데이터 - 회원명 회원권한
%>
	<h2>포함화면</h2>
	<div style="border:1px solid green" >
	<jsp:include page="a04_subPage.jsp">
		<jsp:param value="김길동" name="name"/>
		<jsp:param value="관리자" name="auth"/>
	</jsp:include>
	</div>
	
</body>
<script type="text/javascript">
/*

 */

var div = document.querySelector("#container")
div.innerHTML+="<br>"
</script>
</html>