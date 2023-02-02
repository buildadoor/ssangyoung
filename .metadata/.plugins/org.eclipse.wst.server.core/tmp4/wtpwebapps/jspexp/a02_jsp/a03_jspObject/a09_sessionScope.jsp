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
<%-- 
# 기본 객체와 영역
0. 개요
	JSP의 변수/객체는 네가지 영역으로 나누어 해당 변수가 존재하는 범위를
	지정하여 처리할 수 있다. 화면 단위로만 유지하는 경우, 요청값이 있어
	요청처리되는 범위까지 가지고 있는 경우, 동일한 브라우저로 서버와 연결되어
	있는 경우까지 유지되는 경우, 서버가 다시 시작되기까지 유지되는 범위로
	처리할 수 있다.
	
	서버의 자원 (메모리, cpu 등)을 효율적으로 필요에 의해서 사용하기위해 
	session scope를 사용한다.
	
	
1. 네가지 영역
	1) page 영역 : 하나의 jsp 페이지를 처리할 때 사용되는 영역
	2) request 영역 : 하나의 http 요청을 처리할 때 사용되는 영역
		특정페이지에서 request, response 탑재시켜 forward
		계속 전달하면서 가지고 있는 정보 ps) 가방을 들고 다닌 것 
	3) session 영역 : 하나의 웹 브라우저와 관련된 영역
		특정 메모리에 session 정보를 저장시켜
		ps) 특정한 위치에 금고로 보관(서버와 클라이언트가 손을 잡고 있을 때까지만)
	4) application 영역 : 하나의 웹 어플리케이션 관련된 영역
		클라이언트 상관없이 서버에서 보관하는 정ㅂ
		ps) 서버가 없어지거나 재가동할 떄 사라진다.
		
		==> DB영역 : 브라우저/서버 계속
			웹서버가 재기동 되더라도 DB서버에 데이터가 저장되어 있기때문에
			활용할 수 있다. - 가장 넓은 영역의 지속적인 데이터를 처리할 때는
			DB 서버에 데이터를 할당한다.
			ex) 로그인 정보, 회원 정보, 몇주전 구매한 구매 정보 등..
			
	
2. 기능 메서드 
	1) XXX.setAttribution("저장키","저장값/객체") : 키로 저장
	2) XXX.getAttribution("저장키") : 키로 호출 
	3) XXX.removeAttribution("저장키") : 저장된 키의 속성을 삭제 
--%>
<%
// 1. page 범위 설정
pageContext.setAttribute("page01", "페이지 범위 데이터(page scope)");
// 2. request 범위 설정
request.setAttribute("request02", "request범위 데이터(request scope)");
// 3. session 범위 설정
session.setAttribute("session03", "session 범위 데이터(session scope)");
// 4. application 범위 설정
application.setAttribute("application04", "application 범위 데이터(application scope)");
%>

<table>
	<tr><th>페이지 범위 데이터</th><td><%=pageContext.getAttribute("page01") %></td></tr>
	<tr><th>요청 범위 데이터</th><td><%=request.getAttribute("request02") %></td></tr>
	<tr><th>세션 범위 데이터</th><td><%=session.getAttribute("session03") %></td></tr>
	<tr><th>어플리케이션 범위 데이터</th><td><%=application.getAttribute("application04") %></td></tr>

</table>
<a href="a11_requestTest.jsp"> request테스트를 합니다.</a>
<a href="a10_showScopePage.jsp"> session테스트를 합니다.</a>
<!-- 
#session 범위
0. 하나의 브라우저(client) 서버와 연결관계에 있는 범위에서 설정값이 
	유지된다. 
1. 같은 브라우저에서 요청값을 forward하지 않아도 있는 데이터 범위
2. 서버 vs 브라우저가 연결관계에 있을 때, 유지된다.
	1) 브라우저를 다 닫아버리면 사라진다.
	2) 다른 브라우저로 로딩해도 사라진다.

ex)a15_sessionExp.jsp 물건명 가격 갯수 구매처를 각 4가지 session 범위로
설정하여 출력하고, session 범위 확인 클릭시, a16_showSession.jsp로 4가지 session범위에
해당하는지 확인하세요.

 
 -->
</body>
<script type="text/javascript">
/*

 */
</script>
</html>