<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"  
    import="jspexp.vo.*"  
    import="jspexp.a13_database.*"
   %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/a00_com/a01_common.css" rel="stylesheet">
<script>
/*
 
 */
</script>
</head>
<body>
	<h2>부서 정보</h2>
	<form method="post">
	부서번호:<input type=" text" name="deptno" value="${param.deptno}"/><br>
	부서명:<input type=" text" name="dname" value="${param.dname}"/>	<br>
	부서위치:<input type=" text" name="loc" value="${param.loc}"/>	<br>
	<input type="submit" value="검색"/><br>
	</form>
	<table>
		<tr><th>부서번호</th><th>부서명　</th><th>부서위치</th>
	<c:forEach var="dept" items="${deptList}">
	<tr>
		<td>${dept.deptno}</td>
		<td>${dept.dname}</td>
		<td>${dept.loc}</td>
	</tr>
	</c:forEach>
	</table>
<%

%>
</body>
<script>
/*

 */
</script>
</html>