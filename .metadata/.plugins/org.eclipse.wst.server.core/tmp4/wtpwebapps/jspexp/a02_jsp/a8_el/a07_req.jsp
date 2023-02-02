<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"    
    import="jspexp.vo.*"
    import="jspexp.a13_database.*"    
    import="jspexp.a13_database.vo.*"     
    %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
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

<c:set var="bprod" value="바나나" scope="page" />
<c:set var="bloc" value="제주" scope="request" />
<c:set var="bperson" value="홍길동" scope="session" />
<c:set var="rcnt" value="2000" scope="application" />
<h1>페이지범위 확인</h1>
<h2>구매물건:${bprod}</h2>      
<h2>구매장소:${bloc}</h2>      
<h2>구매자:${bperson}</h2>      
<h2>재고량:${rcnt}</h2>

 <%--forword처리할때는 다른 변수로 설정이 필요하다  --%>
 <jsp:forward page="a08_session.jsp"></jsp:forward>
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