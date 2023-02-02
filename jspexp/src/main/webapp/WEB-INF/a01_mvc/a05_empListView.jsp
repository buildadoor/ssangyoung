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

<%--
# 

 --%>
 	<h2>사원 정보 리스트</h2>
 	<table>
 		<tr><th>사원번호</th><th>사원명</th><th>직책</th></tr>
		<c:forEach var = "emp" items="${empList}">
 		<tr><td>${emp.empno}</td><td>${emp.ename}</td><td>${emp.job}</td></tr>
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