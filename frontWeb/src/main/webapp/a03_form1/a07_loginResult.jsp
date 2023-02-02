<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%
    //post방식에서 한글 요청값을 받을때 반드시 설정해주어야 한다.
    // a05_rev.jsp
     request.setCharacterEncoding("UTF-8");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3 align="center">등록된아이디:${param.id}</h3>
	<h3 align="center">등록된아이디:${param.pass}</h3>
	<h3 align="center">${param.id=='himan' and param.pass=='7777'?'로그인성공':'로그인실패'}</h3>
	
	<%-- jsp주석
	
	${조건문?true일 때: false일때}
	1. el(jsp에서 사용하는 언어)
		'':문자열처리
	2. 산술연산으로 효율적으로 처리 한다.
		1) 산술연산을 효율적으로 처리한다.
		2)  ?price=3000&cnt=5
			==> 네트워크상 전송되는 모든 데이터는 문자열이지만 el는 자동으로 형변환처리하여, 숫자형으로 변환해서 처리해준다.
			${param.price*param.cnt}
	 
	 
	 
	 --%>
	 
	 
	
</body>
</html>