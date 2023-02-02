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
#Expression Language
1. jsp에서 사용가능한 새로운 스크립트 언어
2. el의 주요 기능
	1) jsp의 4가지 기본 객체가 제공하는 영역의 속성을 가진 변수로 사용
	2) 집합 객체에 대한 접근 방법 제공
	3) 수치 연산, 관계 연산, 논리 연산자 제고
	4) 자바 클래스의 메서드 호출 기능 제공
	5) 표현 언어만의 기본 객체 제공
3. 간단한 구문 때문에 표현식 대신 사용
	- el와 jstl로 인해서 script(expression, sciplet)를 
		사용하지 않을 수도 있다.
--%>
<%
	//페이지 범위 변수 선언 
	pageContext.setAttribute("num01",25);
	pageContext.setAttribute("num02",35);
	pageContext.setAttribute("name","홍길동");
	session.setAttribute("sess01","안녕하세요");
	
	pageContext.setAttribute("product","윤이네닭발");
	pageContext.setAttribute("price",18000);
	pageContext.setAttribute("cnt",3);
%>

<h2>숫자1:${num01}</h2>
<h2>숫자2:${num02}</h2>
<h2>합산:${num01+num02}</h2>
<h2>이름:${name}</h2>
<h2>이름2:${name01}</h2>
<h2>세션값:${sess01}</h2>
<a href="a02_.el_basic2.jsp">세션값 확인하러가기(과연 머선 일이)</a>

<h2>상품${product}</h2>
<h2>가격${price}</h2>
<h2>갯수${cnt}</h2>
<h2>합산:${price*cnt}</h2>
<h2>등급:${price*cnt>10000}</h2>
<h2>등급:${price*cnt>10000?'MVP':'일반고객'}</h2>

<%--request객체로 물건명 가격 갯수를 할당, el로 호출하되, 총계까지 출력하세요 --%>


</body>
<script type="text/javascript">
/*

 */

var div = document.querySelector("#container")
div.innerHTML+="<br>"
</script>
</html>