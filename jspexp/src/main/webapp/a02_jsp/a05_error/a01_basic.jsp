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
#jsp에서 에러 처리
1. 개발을 하면 프로그램적인 에러가 발생할 수 있다. 자바 프로그램에서는
	이러한 에러가 발생되면, 예외처리로 해당 에러에 대한 내용의 원인을 출력해주고,
	에러가 발생하더라도 정상적으로 프로세스를 흘러가게 해준다.
2. 위와 같은 기본적인 에러 처리를 바탕으로 jsp는 화면단이 추가되기에 에러가 발생시,
	화면을 어떻게 처리해주어야 하는 부분이 추가적으로 처리되어야 한다.
3. 그래서, jsp는 에러가 발생했을 때, 에러가 나는 복잡한 화면 대신에 처리하는 화면을
	출력하는데, 크게 두가지 방식으로 처리한다.
	1) 에러페이지를 만들고, 각 페이지마다 페이지 지시자로 에러가 발생했을 때,
		출력할 jsp 페이지를 지정해서 처리하는 것과
	2) web.xml에 에러페이지를 지정하여, 서버단위로 발생하는 모든 에러에 대하여
		지정한 페이지를 로딩하게 된다.
	3) 우선순위는 가장 세부적인 설정이 처리된다.
		즉, web.xml는 전체 에러 
		각 페이지마다 페이지 지시자로 에러 처리 (우선순위)
	4) 서버 단위 에러도 넓은 단위 에러는 좁고 세부적인 에러에 우선 순위가 밀린다.
		500 ==> 서버 내부 에러 : 자바 코드
			NullPointerException 설정시 세부적인 NullPointerException 
			설정한 페이지로 처리 ..
4. 서버 단위 에러 처리 방식
	1) web.xml를 통해 이 서버를 통해 처리되는 모든 예외를 대신한 페이지를 처리할 수 있는데,
		이도 2가지로 상황에 따른 예외를 처리한다.
	2) web 반응 코드에 의한 예외 처리
	3) 예외 클래스에 의한 에러 처리화면 로딩 

#에러 페이지 지정 처리
1. 에러가 발생했을 때 나타낼 페이지 구현
	1) 지시자 선언	
	<%@ page isErrorPage = "true" %>
	이 페이지는 에러 처리를 위한 페이지 임을 나타낸다 .
	이렇게 속성값을 지정하면, 예외의 기본 객체의 참조 변수 exception을 처리할 수 있다.
	ex) <%=exception.getMessage()%>
	ex) <%=exception.printStackTrace()%>
	이 부분은 자바관련 코드 예외가 발생시만 처리할 수 있기 때문에 
	500 이외에 에러에 대해서는 exception 클래스가 생성되지 않을 수 
	있기에 전체 에러를 한꺼번에 처리하려면,
	if(exception!=null)를 통해서 처리하여야 한다.
	

2. 에러가 발생할 가능성이 있는 페이지 구현
	1) 페이지별로 에러발생시, 에러 페이지 지정 
	2) 페이지 지시자 선언
		<%@ page errorPage = "만들어 둔 에러페이지 지정"%>
# 서버단위에러 처리 
1. 서버의 설정페이지 web.xml에서 응답코드(http)별로
	에러페이지를 지정할 수 있다.
	<error-page>
		<error-code>응답코드</error-code>
		<location>에러페이지uri</location>
			webapp기준으로 하위에 특정한 경로에 에러페이지를 지정하여 처리
	ps) 응답코드
		200 : 요청이 성공적으로 처리
		301 : 요청한 자원이 이동, 헤더 정보에 이동 위치를 알려줄테니 다시 요청
		304 : 클라이언트가 임시 보관한 응답 결과와 다르지 않다.
		400 : 잘못된 요청
		401 : 인증 오류
		403 : 사용자 허가 모드 오류
		404 : 요청한 자원을 못찾음
		405 : 요청한 method 지원하지 않음
		500 : 서버 내부에서 오류가 발생 - 프로그램적 오류(java를 클래스예외는 이 경우에 해당함)

2. 서버의 설정 페이지 web.xml에 예외 클래스별로 예외 페이지도 지정할 수 있다.
		<error-page>
			<exception-type>java.lang.XXXException</exception-type>
			<location>경로지정</location>

3. 처리 순서
	1) webapp기준으로 특정한 위치에 에러를 나타낼 화면을 구현한다.
	2) 응답코드 또는 예외 클래스별로 에러 처리화면의 jsp를 만들고 경로와 파일명을 기준으로
		서버단위(web.xml)로 처리한다.
	3) 서버를 리스타트 후 테스트 코드를 통해서 에러처리를 확인한다.

4. 예외 처리의 우선순위
	0) 예외 처리는 중첩적으로 처리될 때, 우선순위가 아래의 조건에 따라 처리된다.
		-web.xml에서 선언한 예외는 전체 서버 예외이기에,
			개별페이지에서 예외처리를 하면 해당 개별 페이지가 처리된다.
		-web.xml에서 500전체 서버에러에 대한 내용은
			개별적인 예외 처리보다 우선선위가 뒤로 된다.
			# 우선순위
			500 < Exception < 개별적인 예외 클래스 	
	1) web.xml에서 선언한 예외는 전체 서버 예외 이기에,
		개별페이지에서 예외처리를 하면 해당 개별페이지가 처리된다.
		



ex) z01_errorPage.jsp로 경로를 설정하고 web.xml에
500에러를 처리한 후 
테스트페이지 a04_server_error.jsp-nullpounter강제발생에서 처리한 결과를 확인하세요
a04_server_error
ex) z05_numberFormat.jsp 예외 페이지를 만들고 
web.mxl
a05_numberFormat.jsp 만들어
Integer.parseInt("이십오")로 처리하게 하세요

--%>
</body>
<script type="text/javascript">
/*

 */

var div = document.querySelector("#container")
div.innerHTML+="<br>"
</script>
</html>