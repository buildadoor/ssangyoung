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
<%

%>
	<c:choose>
					<c:when test="${param.id=='himan' && param.pass=='7777'}">
						<jsp:useBean id="mem" class="jspexp.vo.Member" scope="session"/>
						${mem.setId(param.id)}${mem.setName('홍길동')}${mem.setAuth('admin')}
						<c:set var="isFail" value="N"/>						
					</c:when>
					<c:otherwise>
						<c:set var="isFail" value="Y"/>
					</c:otherwise>
				</c:choose>
</body>
<script>

var isFail='${isFail}'
	if(isFail=='Y'){
		alert("로그인 실패\n로그인 페이지로 이동합니다.")
		location.href="a01_login.jsp"
	}
	if(isFail=='N'){
		alert("로그인 성공\n메인 페이지로 이동합니다.")
		location.href="a03_checkSession.jsp"
	}
	/*

 */
</script>
</html>