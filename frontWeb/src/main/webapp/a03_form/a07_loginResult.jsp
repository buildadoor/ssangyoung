<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%
	//post방식에서 한글요청값을 받을 때, 반드시 설정되어야 한다.
	request.setCharacterEncoding("utf-8");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center"> 로그인 결과</h2>
<h3 align="center">아이디:${param.id}</h2>
<h3 align="center">비밀번호:${param.pass}</h2>
<h3 align="center">${param.id=='himan' and param.pass=='7777'
					?'로그인성공':'로그인실패'}</h3>
					
<%--jsp 주석 (클라이언트에 전송해도 나타나지 않음--%>
<%--
${조건문?true일때:faluse일때}
1. el(jsp에서 사용하는 언어)
	'':문자열 처리
2. 산술연산을 효율적으로 처리한다.
	1) 숫자형문자는 숫자로 자동 변환해서 처리해준다.
	2) ?price=3000&cnt=5 
		=> 네트웍상 전송되는 모든 데이터는 문자열이지만 el는
			자동으로 연산시 숫자형으로 변환해준다.
		${param.price*param.cnt}
		
	
	
 --%>					
</body>
</html>