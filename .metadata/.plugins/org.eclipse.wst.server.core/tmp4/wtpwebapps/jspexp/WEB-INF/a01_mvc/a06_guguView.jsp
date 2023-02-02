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
	<form action="/gugu.do"> 
								
			<select name="num01">
			<c:forEach var="grade" begin="2" end="9">				<option>2</option>
			<option>${grade}</option>
			</c:forEach>
			</select>
			<%--
			보이는 label과 value값이 동일할 경우 lable만 
			설정하더라도 value값이 설정이 된다.
			<option value="${grade}"
			${grade}</option>필요가 없다
			다를 때는 서버에는 value로 설정된 값이 전달된다.
			<option value="10">인사</option>
			<option value="20">재무</option>
			<option value="30">회계</option>
			
			 --%>
			X
			<select name="num02">
			<c:forEach var="cnt" begin="2" end="9">				<option>2</option>
			<option>${cnt}</option>
			</c:forEach>
			</select>
			=
			<br>
			<input type="submit" value="계산"/>
		</form>
		<h2>${result}</h2>
<%--
# 

 --%>
<%

%>
</body>
<script>
/*

 */
</script>
</html>