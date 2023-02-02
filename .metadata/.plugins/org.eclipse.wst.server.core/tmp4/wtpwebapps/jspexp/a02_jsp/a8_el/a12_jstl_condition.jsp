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
<div id="container"></div>
<%-- 
#jstl의 흐름제어
1. if - 조건이 true일 경우 몸체 내용 실행
	<c:if test="조건">
	</c:if>
2. choose when - otherwise
	<c:choose>
		<c:when test="${조건1}">
			처리내용1
		</c:when>
		<c:when test="${조건2}">
			처리내용2
		</c:when>
		<c:otherwise>
			기타처리경우
		</c:otherwise>
	</c:choose>
--%>

<form>
	부서명:<input type="text" name="dname"/>
	<input type="submit"/>
</form>
<%--
#el의 empty
1. null, ""(공백)을 다 포함하는 내용을 처리할 때, 활용된다.
2. not empty : null이 아니고, ""(공백)이 아닐때
 --%>
<c:if test="${not empty param.dname}">
	<h2>등록한 부서명은 ${param.dname}</h2>
</c:if>
<%--ex)국어 영어 점수를 입력해서 해당 점수가 있을 때만 총합이 출력되게 하세요 --%>
<form>
	국어:<input type="text" name="kor"/>
	영어:<input type="text" name="eng"/>
	<input type="submit"/>
</form>
<c:if test="${not empty param.kor && not empty param.eng}">
	<%--jstl은 모두가 전역변수 개념 블럭 내부에 선언한 데이터도 
		전역변수이기에 외부에서 사용가능하다--%>
	<c:set var="tot" value="${param.kor+param.eng}"></c:set>
	<c:set var="avg" value="${tot/2}"></c:set>
	<h2>총합${tot}</h2>
</c:if>
<h3>평가등급:
<c:choose>
	<c:when test="${avg>=90}">A등급</c:when>
	<c:when test="${avg>=80}">B등급</c:when>
	<c:when test="${avg>=70}">C등급</c:when>
	<c:when test="${avg>=60}">D등급</c:when>
	<c:when test="${avg>=0}">F등급</c:when>
	<c:otherwise>등급은 점수가 0-100일때 가능합니다</c:otherwise>
</c:choose>
</h3>
<%--ex)나이를 입력받아 성년/미성년 나이범위는 숫자로 0이상입니다. --%>
<form>
	나이:<input type="text" name=age"/>
	<input type="submit"/>
</form>
<c:if test="${not empty param.age}">
	<%--jstl은 모두가 전역변수 개념 블럭 내부에 선언한 데이터도 
		전역변수이기에 외부에서 사용가능하다--%>
<h3>입력한 나이 :${param.age},구분
<c:choose>
	<c:when test="${age>=18}">성년</c:when>
	<c:when test="${age>=0}">미성년</c:when>
	<c:otherwise>나이범위는 숫자로 0이상입니다.</c:otherwise>
</c:choose>
</h3>
</c:if>


</body>
<script type="text/javascript">
/*

 */

var div = document.querySelector("#container")
div.innerHTML+="<br>"
</script>
</html>