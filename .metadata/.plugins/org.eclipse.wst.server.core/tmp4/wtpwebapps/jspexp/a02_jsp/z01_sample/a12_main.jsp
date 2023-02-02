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
<h2>메인페이지</h2>
<h2>로그인 아이디:${sesMem.id}</h2>
<h2>로그인 이름:${sesMem.name}</h2>
<h2>로그인 권한:${sesMem.auth}</h2>
<input type="button" value="로그아웃" onclick="logout()"/>
<script type="text/javascript">
	function logout(){
		if(confirm("로그아웃하시겠습니까?")){
			location.href="a13_logout.jsp"
		}
		
	}
</script>
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