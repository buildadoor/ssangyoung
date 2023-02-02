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
<%--3번--%>
<script type="text/javascript">
function ckId(obj){
	var len = obj.value.length
	var spanOb = document.querySelector("span")
	var msg = "아이디는 8~16 사이 입력 가능합니다."
	spanOb.style.color="red"
	if(len>=8 && len<=16){
		msg = "유효한 아이디입력"
			spanOb.style.color="blue"
	}
	spanOb.innerText = msg
}
</script>
회원아이디: <input type="text" name: "id" onkeyup="ckId(this)"/>
<span>아이디입력</span> <br>
<%--4번--%>

 <script type="text/javascript">
 function regTab(){
	 var data = document.querySelector("[name=regMem]").value
	 var players = data.split(",") 
	 //"홍길동,김길동,신길동"==>["홍길동","김길동","신길동"]
	 var shHTML = "<table><tr><th>번호</th><th>이름</th></tr>"
	 players.forEach(function(player,idx){
	 	shHTML +="<tr><th>"+(idx+1)+"</th><th>"+player+"</th></tr>"
	 })
	 shHTML+="</table>"
	 document.querySelector("#show").innerHTML = shHTML;
 }
 </script>
 <h3>팀 인원등록</h3>
 <input type="text" name="regMem" />
 <input type="button" value="등록" onclick="regTab()"/>
 <div id="show"></div>
 <br>
 <%--
 5번
 web.xml : 설정
 application : 호출(서버단위 설정값)
 --%>
 <%--
 6번
 자바의 변경이나 서버 단위 설정 정보를 변경(web xml..)은 실행시 반드시 sever restart (서버 재기동)하여야한다. 
 --%>
 <h3>DB정보</h3>
 <h3>주소 : <%=application.getInitParameter("ip") %></h3>
 <h3>포트 : <%=application.getInitParameter("port") %></h3>
 <h3>DB : <%=application.getInitParameter("sid") %></h3>
 <h3>계정 : <%=application.getInitParameter("username") %></h3>
 <h3>패스워드 : <%=application.getInitParameter("pass") %></h3>
</body>
<%--
9번
#처리순서
1. 업무처리 flow 확인
	로그인페이지 아이디 패스워드 입력 ==> 인증여부에 따라서 ==> 로그인페이지
													메인페이지
2. 개발 순서 
	1) 로그인 화면 구성(z10_login.jsp)
		-4) 항목을 같이 처리해도 무방하다
	2) form action 요청 페이지 호출 설정( 유효성 check-js)
	3) 요청값을 받은 내용을 처리 (z11_checkValid.jsp)
		-DB나 조건에 의해 인증되었을떄, 세션 값 설정 z12_main.jsp 이동 처리
				-인증되지 않았을 떄, forward로 z10_login.jsp 이동
			if(id.equals("himan") && pass.equals("7777"){
				session.setAttribute("id",id);
				response.sendRedirect("");
			}else{
				//request.setAttribute()로 처리해도 되지만.
				//request.getParameter("id")로 처리가 되기에 생략가능
				request.getRequestDispather("z10_login.jsp"
				).forward(request, response);
			}

	4) 유효화하지 않은 id에 대한 로그인 화면 요청값 처리 (z10_login.jsp)
		-request 객체로 요청값 확인 및 인증되지 않음 경고창 처리
		String id = request.getParameter("id")
		boolean isInvalid = false;
		if(id!=null){
			isInvalid = true;
		}
		js
		var isInvalid = <%=isInvalid%>;
		if(isInvalid) alert("<%=id%>는 인증된 계정이 아닙니다");
	5) 메인 화면에서 session 출력 z11_main.jsp
		<h2><%=session.getAttribute("id")%>님 로그인 중입니다.</h2>
 --%>

<script type="text/javascript">
/*

 */

var div = document.querySelector("#container")
div.innerHTML+="<br>"
</script>
</html>