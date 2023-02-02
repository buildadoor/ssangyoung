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
# jsp에서 화면 분할 방식
1. 다른 객체를 포함하는 방식
	jsp 액션태그 사용
2. 파일은 2개이지만 하나의 객체로 다시 만들어 처리하는 방식 
	page 지시자 사용

 --%>
<h2>메인페이지</h2>
<jsp:include page="a11_sub01.jsp">
	<jsp:param value="사과" name="name"/>
	<jsp:param value="3000" name="price"/>
	<jsp:param value="2" name="cnt"/>
</jsp:include>
<%--
#a11_sub01.jsp
<h2>포함된 페이지</h2>
물건명: ${param.name}
가격: ${param.price}
갯수: ${param.cnt}
 --%>
<%


%>
</body>
<script>
/*

 */
</script>
</html>