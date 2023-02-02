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
2022-12-07
[1단계:개념] 1. 쿠키값의 생명주기(생성,변경,소멸)을 서버와 클라이언트 위치와 관계에서 코드와 함께 설명하세요.
생성
쿠키는 클라이언트의 요청에 의해서, 서버안에서 객체를 생성하여 response
		객체에 쿠키를 추가하여 클라이언트에 보내어지면 클라이언트(브라우저)에서
		지정한 경로에 저장이 된다.
활용
쿠키가 서버에서 생성되어 클라이언트에 지정되면, 다시 요청객체 request에 
		의해 서버에 보내지면서 쿠키값을 key/value 형식으로 호출하여 사용할 수 있다.
쿠키는 동일한 키로 addCookie로 할당하면 동일한 키로 설정된 내용을 변경해준다.
		price ==>3000
		price ==>5000 (최종으로 값으로 설정된 값이 해당 쿠키의 key에 할당된 값이 된다.)

쿠키의 소멸
쿠키는 서버에서 해당 쿠키의 키명으로 유효시간으로 기능메서드로 설정하여
		다시 클라이언트로 보내지면, 해당 시간이 지나면 클라이언트 안에서 사라지게 된다.	 
		삭제할 쿠키를 참조변수로 가져와서 setMaxAge(0)으로 설정하여 
		
[1단계:확인] 2. 쿠키값(coffee/americano)로 설정 후, 페이지 링크로 설정된 쿠키값을 리스트하세요.

[1단계:확인] 3. 쿠키값(coffee/vanilla)로 변경후, 페이지 링크로 설정된 쿠키값을 리스트하세요.
[1단계:확인] 4. 쿠키값(커피) 삭제 후,  페이지 링크로 설정된 쿠키값을 리스트하세요.
[1단계:개념] 5. form 요소객체의 주요 속성을 기술하세요.
1. form 하위 요소객체의 특징
	1) 선택자 : name, id
		document.querySelector("[name=속성값]")
		var document.querySelector("#아이디명")
	2) 속성값 변경 : value를 통해서 처리 
		dom01.value
		dom01.value="할당처리"
		
[1단계:확인] 6. 오늘 월드컵 대전 팀과 결과를 날짜/팀1/팀2/결과를 입력해서 테이블로 추가리스트 되게 처리하세요.
[1단계:확인] 7. 가위/바위/보를 select로 선택하게 하고, 컴퓨터와 play를 클릭해서, 나의 선택과 컴퓨터 선택 결과가 나와서 승/무/패가 출력되게 하세요.
[1단계:확인] 8. [@@][select +,-,*,/][@@] [결과확인] 임의의 숫자 두개가 나오고 연산자의 선택하고 결과확인에 따라 연산처리결과가 하단에 h2로 출력되게 하세요

--%>
<%
	//1. 쿠키만들기
	Cookie c1 = new Cookie("coffee","americano");
	//2. 쿠키 클라이언트에 보내기 
	response.addCookie(c1);
%>
	<h2>쿠키 굽기</h2>
	<a href="x01_showCookie.jsp">내가 만든 쿠키🍪🍪🍪🍪</a>
<h2>2022-12-07 월드컵 </h2>
	날짜:<input type="text" name="date"/>
	팀1:<input type="text" name="t1"/>
	팀2:<input type="text" name="t2"/>
	결과:<input type="text" name="result"/>
	<input type="button" value="등록" onclick="add()"/>
	
<table id="Worldcup">
	<thead>
		<tr><th>날짜</th><th>팀1</th><th>팀2</th><th>결과</th></tr>
	<tbody>
	</tbody>
</table>
</body>
<h2>8번</h2>
<div id="result3"></div>
<select name="exp8" onchange="exp08(this.value)">
   <option value="+">+
   <option value="-">-
   <option value="*">*
   <option value="/">/
</select>
<div id="result4"></div>=<div id="result5"></div>
<script type="text/javascript">
var dateObj = document.querySelector("[name=date]")
var t1Obj = document.querySelector("[name=t1]")
var t2Obj = document.querySelector("[name=t2]")
var resultObj = document.querySelector("[name=result]")
var recObj = document.querySelector("#Worldcup tbody")
function addRec(){
	recObj.innerHTML += "<tr><td>"+dateObj.value+"</td><td>"+t1Obj.value+
	"</td><td>"+t2Obj.value+"</td><td>"+resultObj.value+"</td></tr>";
	dateObj.value=""; dateObj.focus()
	t1Obj.value=""; t1Obj.focus()
	t2Obj.value=""; t2Obj.focus()
	resultObj.value=""; resultObj.focus()
}

var num01 = Math.floor(Math.random()*101)
var num02 = Math.floor(Math.random()*101)
var result3 = document.querySelector("#result3")
result3.innerText = num01
var result4 = document.querySelector("#result4")
result4.innerText = num02

function exp08(val){
   var result5 = document.querySelector("#result5")

   var show = eval(num01+val+num02)
   result5.innerHTML = show
}

var div = document.querySelector("#container")
div.innerHTML+="<br>"
</script>
</html>