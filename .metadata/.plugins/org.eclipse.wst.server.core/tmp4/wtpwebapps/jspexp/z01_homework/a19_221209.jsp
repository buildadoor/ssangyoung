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
#2022-12-09
[1단계:개념] 1. 세션의 삭제방법을 기술하세요
#세션 종류/타임 아웃
1. session.invalidate() 이용해서 세션 종료
	1) 세션이 종료되면 기존에 생성된 세션이 삭제
	2) 이후 접근시 새로운 세션 생성됨
2. 마지막 세션 사용 이후, 유효 시간이 지나면 자동 종료
	1) web.xml 파일에서 지정
		<session-config>
			<session-timeout>
				30 ==> 분단위
				
	2) session 기본 객체의 setMaxInactiveInterval()메서드 이용해서 지정
		초 단위 지정
		
[1단계:확인] 2. 로그인 클릭시 session에 설정 후 다시 Member의 아이디와 이름이 출력되고 하고,
           로그아웃 클릭시, 로그인해야합니다가 출력되게 하세요.
           --%>
           
           
           <%--
[1단계:확인] 3. el로 session범위로 사원 정보 사원번호, 사원명, 부서명을 저장후, 페이지가 이동해서도
           해당 정보를 출력하는 것을 확인하세요.
           
           이동 페이지
           <% Emp e = (Emp)session.getAttribute("e01");
boolean hasSess=e!=null;
if(hasSess){
%>

         
<h2>세션값확인</h2>
<h3>사원번호:<%=e.getEmpno()%></h3>
<h3>사원명:<%=e.getEname()%></h3>
<h3>사원부서:<%=e.getJob()%></h3>
<%} %>
           --%>
           
         <%
       Emp m = new Emp(10,"홍길동","회계");
         session.setAttribute("e01", m);
         
%>
<h3>세션 확인하러 갑시당</h3>



           <%--
[1단계:확인] 4. 1~100까지 임의의 숫자를 session객체에 국어/영어/수학 점수로 할당후, el로 각 점수와 총점,
            평균, 평균70이상일때 합격 그외는 불합격을 출력하세요.
            ???
            
[1단계:개념] 5. el의 property란 무엇인가 기술하세요.
1. jsp에서 사용가능한 새로운 스크립트 언어
2. el의 주요 기능
	1) jsp의 4가지 기본 객체가 제공하는 영역의 속성을 가진 변수로 사용
	2) 집합 객체에 대한 접근 방법 제공
	3) 수치 연산, 관계 연산, 논리 연산자 제고
	4) 자바 클래스의 메서드 호출 기능 제공``
	5) 표현 언어만의 기본 객체 제공
3. 간단한 구문 때문에 표현식 대신 사용
	- el와 jstl로 인해서 script(expression, sciplet)를 
		사용하지 않을 수도 있다.
[1단계:확인] 6. Member객체로 session객체로 할당한 후, 해당 객체를 el로 호출하여 출력하세요.
--%><%
request.setAttribute("m01",new Member("홍길동","회원"));
%>

	<h2>이름:${m01.name}</h2>
	<h2>권한:${m01.auth}</h2>
</body>
<script type="text/javascript">
/*

 */
 var h3 = document.querySelector("h3");
 h3.onclick=function(){
 	location.href="x02_check.jsp"
 }
var div = document.querySelector("#container")
div.innerHTML+="<br>"
</script>
</html>