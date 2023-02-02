<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     import="jspexp.vo.Dept"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 
2022-11-14
[1단계:개념] 1. javascript의 출력형식과 입력 형식 함수를 기술하세요.
	#js 기본 출력 형식
	1. 경고창 
		alert ("출력내용");
	2. console출력
		f12으로 console 확인
		console.log("출력내용")
	3. 화면 출력
		document.write("출력내용")
		==> body하단에 DOM객체로 특정 요소객체 접근해서
		처리
[1단계:개념] 2. DOM 객체를 단일객체와 다중 객체의 차이점을 기술하세요.

1) 단일 객체 인식
		var object = document.querySelector("선택자")
		//단일 객체 선언과 할당.
		//여러 개 선언되어 있더라도 첫번째 하나만 처리할 때.
		//#아이디명 형식으로 단일 내용을 선택자로 해서 처리할 때, 주로 사용된다.
	2) 다중 객체 인식
		var array = document.querySelectorAll("선택자")
		//하나가 아닌 여러개 객체를 선언하고 각각의 DOM객체에 대한 속성을
		//따로따로 처리해야할 때, 활용된다.
		//array[0].innerText="첫번째", array[1].innerText="두번째"
	cf) css에서 사용하는 선택자를 이용하여 단일 객체에 대한 처리와 다중 객체에
	대한 처리를 할 수 있다.
	
[1단계:확인] 3. js(javascript)의 입력창으로 물건명, 가격, 갯수를 입력받아서, 화면에 출력해보세요. 
--%>
	<% 
	String product="아이폰14";
	int price = 1100000;
	int cnt= 1;
	%>
	<h2>물건명:<%=product%></h2>
	<h2>가격:<%=price%></h2>
	<h2>갯수:<%=cnt%></h2>
<%--
[1단계:확인] 4. 70점 이상입니까?라는 confirm 입력 받아서 내용에 따라 합격/불합격을 화면에 출력하세요.
--%>
<h4>4번 문제</h4>
<h5>합격여부</h5>
<%--
[1단계:확인] 5. 테이블 3X3을 만들고, DOM을 활용하여 1행1열 1행2열 1행3열. 9개의 td의 내용을 출력하세요.
--%>
<table>
	<tr><td></td><td></td><td></td></tr>
	<tr><td></td><td></td><td></td></tr>
	<tr><td></td><td></td><td></td></tr>

</table>
<%--

[1단계:확인] 6. 위 내용을 열마다 물건명 가격 갯수 class를 따로 선언하여 선택자로 물건명 가격 갯수가 3개 나오게 출력하세요.
--%>

<%--
[1단계:개념] 7. jsp에서 scriptlet와 expression의 차이를 기술하세요.
-scriptlet : <% %>

-표현(expression) :<%=%>

scriptlet과 expression의 차이를 보여주는데 scriptlet과 expression 모두 java 코드 입력에  사용되지만 expression에 입력되는 값은 print() method의 parameter 값으로 들어간다는 점이 차이점	
--%>

<%--
[1단계:확인] 8. 부서정보 VO을 클래스로 선언하고, 화면에 부서정보를 출력하세요.
jspexp.vo.Dept
--%>
	<% 
	Dept d01 = new Dept("마케팅",100001,"천안");
%>
	<h3>8번 부서정보</h3>
	<table width=30% border>
		<tr><th>부서명</th><td><%=d01.getDname()%></td></tr>
		<tr><th>부서번호</th><td><%=d01.getDeptno()%></td></tr>
		<tr><th>부서위치</th><td><%=d01.getLoc()%></td></tr>
	
	</table>
<%--
[1단계:확인] 9. 배열로 선수명3개, 선수성적3개, 소속팀3개를 선언하고 for문에 의해 테이블로 출력하세요.
--%>
<%
String []pname = {"최민정","김길리","박지원"};
String []pscore = {"은메달","금메달","금메달"};
String []pteam = {"성남시청","서현고","서울시청"};
for(int idx=0;idx<pname.length;idx++){
	System.out.println(pname[idx]+":"+pscore[idx]+":"+pteam[idx]);
}
%>
<table width="50%" style="border-collapse:collapse" border>
	<tr><th>선수이름</th><th>선수성적</th><th>소속팀</th></tr>
	<%for(int idx=0;idx<pname.length;idx++){ %>
	<tr><td><%=pname[idx] %></td>
	<td><%=pscore[idx] %></td>
	<td><%=pteam[idx] %></td></tr>
	<%} %>
	
	
</body>
<script type="text/javascript">
var isPass = confirm("70점 이상입니까?")
document.querySelector("h5").innerText="합격여부: "+(isPass?"합격":"불합격")
	</script>
</html>