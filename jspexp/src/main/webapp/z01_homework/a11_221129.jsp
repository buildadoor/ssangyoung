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
 function cklen(obj){
		var len = obj.value.length
		var span = document.querySelector("span")	
		span.innerText=len+"자"
	}
 function cklen1(obj){
		var len = obj.value.length
		var div = document.querySelector("div")	
		if(len>17){
			alert("아이디는 글자수를 8~16자로 제한합니다")
			obj.value = obj.value.substring(8,16)
		}else{
			div.innerText=len+"/16"
				}
	}
</script>
</head>
<body>

<h3>
2022-11-29<br>
[1단계:개념] 1. [js] 대입연산자를 통한 변수의 대입과 객체의 대입의 메모리 할당의 차이점을 예제를 통해서 기술하세요<br><hr>

[1단계:확인] 2. [js] 선수1(소속,이름,득점)을 json 객체로 선언하여, 대입연산자로 선수2할당한 경우와 ...(spread) 키워드로 
                  deep복사한 선수2를 만들어 득점을 증가했을 때, 차이를 출력하세요.<br><hr>
[1단계:확인] 3. [js] 회원 아이디를 입력하면 입력된 수를 옆에 표시하세요.<br><hr>
아이디를 입력하세요
<textarea name="id" onkeyup="cklen(this)"></textarea>
<span>0</span>
<hr>
[2단계:확인] 3. [js] 회원 아이디를 입력시 글자수 제한을 8~16로 처리하기로 했다. 입력시, 해당 범위에 맞지 않으면
               하단에 입력범위는 8~16 표시하고 그외에는 입력가능으로 표시하게 하세요.<br><hr>
*최소 8글자 설정 방법을 모르겠음 
아이디를 입력하세요
<textarea name="id2" onkeyup="cklen1(this)"></textarea>
<div>0</div>
[2단계:확인] 4. [js] 팀인원등록[    ][등록] ==> 선수명을 ,단위로 구분해서 등록 버튼을 누르면 바로 밑에 테이블 형식으로 번호(1.2...)와 함께 이름이 출력되게 하세요



[1단계:확인] 5. [jsp] 웹 서버단위로 초기 설정값을 설정할려고 한다. 처리 방식을 기술하세요<br><hr>
wEB-INF 폴더 하위에 있는 web.xml 파일을 xml editor로 오픈<br>
 	

[1단계:확인] 6. [jsp] 웹 서버에서 DB 주소, port, sid, 계정, 비번설정해서 DB를 접속할려고 한다. 처리하고, 호출하세요.<br><hr>


[1단계:개념] 7. [jsp] 세션 scope의 4가지 범위를 예제와 함께 기술하세요.<br><hr>

	1) page 영역 : 하나의 jsp 페이지를 처리할 때 사용되는 영역<br>
	2) request 영역 : 하나의 http 요청을 처리할 때 사용되는 영역<br>
	3) session 영역 : 하나의 웹 브라우저와 관련된 영역<br>
	4) application 영역 : 하나의 웹 어플리케이션 관련된 영역<br>
	<hr>
[1단계:확인] 8. [jsp] 회원을 아이디(page), 이름(request), 포인트(session), 권한(application) 범위로 설정하여, 출력하세요.<br><hr>
               요청값 범위 확인, 세션값 범위 확인 클릭을 통해 해당 범위 데이터를 확인하세요.<br><hr>
<%
// 1. page 범위 설정
pageContext.setAttribute("id", "yoonah");
// 2. request 범위 설정
request.setAttribute("name", "이윤아");
// 3. session 범위 설정
session.setAttribute("point", 9999999);
// 4. application 범위 설정
application.setAttribute("auth", "관리자");
%>

<table>
	<tr><th>아이디: (페이지 범위 데이터)</th><td><%=pageContext.getAttribute("id") %></td></tr>
	<tr><th>이름: (요청 범위 데이터)</th><td><%=request.getAttribute("name") %></td></tr>
	<tr><th>포인트: (세션 범위 데이터)</th><td><%=session.getAttribute("point") %></td></tr>
	<tr><th>권한: (어플리케이션)</th><td><%=application.getAttribute("auth") %></td></tr>
</table>
<a href="z06_requestTest.jsp"> request테스트를 합니다.</a><br>

[3단계:확인] 9. [jsp] 로그인페이지(z10_login.jsp) 아이디와 패드워드를 입력해서,  z11_checkValid.jsp로 submit처리하여
                  인증이되면 session범위로 id를  설정하여 z11_main.jsp에 @@님 로그인되었습니다. 출력하게하고,
                  그렇지 않으면 request의 forward메서드로 다리 z01_login.jsp 화면에서 로그인 실폐하였습니다가 
                  출력되게 하세요.<br><hr>
</h3>
</body>
<script type="text/javascript">
/*

 */

var div = document.querySelector("#container")
div.innerHTML+="<br>"
</script>
</html>