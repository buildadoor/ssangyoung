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

2022-12-06
[1단계:개념] 1. 배열형 DOM객체의 속성 처리 방식을 기본예제로 기술하세요.
[1단계:확인] 2. 월드컵 16강 팀들을 배열로 리스트하고, 8X2 테이블에 DOM으로 출력하세요 
[1단계:확인] 3. 사원번호/사원명 5개,  부서번호와 부서명4개를 json데이터를 선언하고, 하나는 테이블에 하나는 select의 option에 레이블과 value로 출력해보세요
[1단계:개념] 4. 예외 처리하는 형식(페이지 지정, 서버단위) 내용을 기본 예제를 통해서 설명하세요.
[1단계:확인] 5. z55_errPage.jsp로 에러 페이지를 지정하고, z51_callError.jsp 지정된 페이지로 에러가 호출되게 처리해보세요.
[1단계:확인] 6. 새로운 프로젝트를 web.xml 파일과 함께 만들어서 404, 500 에러를 페이지를 지정하여 대체 화면으로 처리하세요.
[1단계:확인] 7. 위 프로젝트에 NullPointerException, ArrayIndexOutBoundsException을 처리하는 에러페이지를 만들고 web.xml에 등록하고 테스트를 통해서 해당 화면이 나타나게 하세요.
			1) 예외 파일 생성
				z03_null.jsp
					isErrorPage="true"
					객체가 null로 설정되어 발생 에러입니다
					<%=exception.getClass.getName()%>
					<%=exception.getMessage()%>
				z04_arrayIndex.jsp
					isErrorPage = "true"
					배열의 index 범위를 확인하세요 
					<%=exception.getClass().getName()%>
					<%=exception.getMessage()%>
			2) web.xml 
				<error-page>
 	<exception-type>java.lang.nullPointerException</exception-type>
 	<location>z03_null.jsp</location>
 	<exception-type>java.lang.ArrayIndexOutBoundsException</exception-type>
 	<location>z04_arrayIndex.jsp</location>
				
--%>
<h2>json데이터 처리1(요소에 할당)</h2>
<table id="tab01">
	<thead><th>사원번호</th><th>사원명</th></thead>
	<tbody>
		<tr><td>0</td><td>1</td></tr>
		<tr><td>2</td><td>3</td></tr>
		<tr><td>4</td><td>5</td></tr>
		<tr><td>6</td><td>7</td></tr>
		<tr><td>8</td><td>9</td></tr>
	</tbody>
</table>
<script type="text/javascript">
	var emps = [
				{empno:7800,ename:"홍길동"},
				{empno:7801,ename:"박길동"},
				{empno:7802,ename:"김길동"},
				{empno:7803,ename:"송길동"},
				{empno:7804,ename:"오길동"}
			   ]	
	var tds = document.querySelectorAll("#tab01 td")
	emps.forEach(function(emp, idx){
			//  0 {empno:7800,ename:"홍길동"}
			//  0 {empno:7801,ename:"김길동"}
		tds[idx*2].innerText = emp.empno
		tds[idx*2+1].innerText = emp.ename
		
	})
</script>
<h2>json데이터 처리2(동적요소만들기)</h2>
<select name="dept" onchange="alert(this.value)"></select>
<script type="text/javascript">
	var dept = [
		{deptno:10,dname:"인사"},
		{deptno:20,dname:"재무"},
		{deptno:30,dname:"회계"},
		{deptno:40,dname:"기획"}
		]
	var deptDom = document.querySelector("[name=dept]")
	var addHtml = ""
	dept.forEach(function(dept){
		addHtml+="<option value='"+dept.deptno+"'>"
					+dept.dname+"</option>"
	})	
	deptDom.innerHTML = addHtml
</script>
</body>
<script type="text/javascript">
/*
3번
 */

var div = document.querySelector("#container")
div.innerHTML+="<br>"
</script>
</html>