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
#2번
1. 화면구성 /파일 만들기
2. 요청값 처리
	1) 요청값에 따라, 요청범위로 설정
	2. 요청 페이지 처리 (forward)
	a50_check.jsp
	<%
String pname = request.getParameter("pname");
if(pname!=null){
	String page01="";
	if(pname.equals("사과")){
		request.setAttribute("msg","재고 있음");
		page01="a53_main.jsp";
	}else{
		request.setAttribute("msg","재고 없음");
		page01="a54_main.jsp";
	}
	RequestDispatcher rd = request.getRequestDispatcher(page01);
	rd.forward(request,response);
}
%>
3. 최종 페이지 가져오기
a53_main.jsp (재고 있음), 
<h2><%=request.getAttribute("msg")%></h2>
<h2><%=request.getParameter("pname")%>재고</h2>//입력한 이름
a54_main.jsp (재고 없음), 
<h2><%=request.getAttribute("msg")%></h2>

--%>
<form method="post" action="a50_check.jsp">
	과일명 : <input type="text" name="pname"/>
	<input type="submit" value="재고여부"/>

</form>
<%--
3번
z04_cal.jsp
	String price = request.getParameter("price"); if(price==null) price="0";
	String cnt = request.getParameter("cnt"); if(price==null) cnt="0";
	int priceI = Integer.parseInt(price);
	int cntI = Integer.parseInt(cnt);
	int tot = price*cntI;
	request.setAttribute("tot",tot);
	String page01="z42_normal.jsp";
	if(tot>=100000){
		page0101 = "z41_mvp.jsp";
	}
	<jsp:forward page="<%=page01%>"/>
	}
z41_mvp.jsp
	<h2><%=request.getParameter("name")%> 구매 MVP 페이지</h2>
	<h3><%=request.getAttributer("tot")%> 원 구매</h3>
z42_normal.jsp
	<h2><%=request.getParameter("name")%> 구매 일반 페이지</h2>
	<h3><%=request.getAttributer("tot")%> 원 구매</h3>
 --%>
<h2>구매 처리에 따른 등급페이지 이동</h2>
<form method="post" action="z40_cal.jsp">
	물건명 : <input type="text" name="name"/>
	가격 : <input type="text" name="price"/>
	갯수 : <input type="text" name="cnt"/>
	<input type="submit" value="구매"/>
</form>
<h2>아이디 등록 유효 check</h2>
<form method="post" action="a51_check.jsp">
	아이디:<input type="text" name="id"/>
	<input type="submit" value="등록여부" />
</form>

<%
String hasId = (String)request.getAttribute("hasId");
boolean isCheck = false;
if(hasId!=null){
		isCheck = true;
}
String id = request.getParameter("id");
%>
<script type="text/javascript">
var isCheck = <%=isCheck%>
if(isCheck){
	var hasId = "<%=hasId%>"
	if(hasId=="Y"){
		alert("등록된 아이디가 있습니다.");
	}else{
		alert("등록 가능한 아이디입니다.");
		document.querySelector("[name=id]").value="<%=id%>"
	}
}
</script>
	<%--
3번
1. 화면 구현
	name="id"
	<form method="post" action="a51_check.jsp">
	아이디:<input type="text" name="id"/>
	<input type="submit" value="등록여부" />
</form>
	
2. a51_check.jsp
	<%
	String id= request.getParameter("id");
	if(id!=null){
	 A06_PreparedDao dao = new A06_PreparedDao();
	//dao.checkId(id)
	request.setAttribute("hasId",dao.checkId(id)?"Y":"N");
	%>
		<jsp:forward page="064_1202.jsp"/>
	<%
	}
	
	%>
3. 현재페이지
	<%
String hasId = (String)request.getAttribute("hasId");
boolean isCheck = false;
if(hasId!=null){ //초기 페이지와 구분..
		isCheck = true;
}
String id = request.getParameter("id");
%>

<script type="text/javascript">

var isFirst = <%=isFirst%>
if(isFirst){ //입력을 받아서 forward되었을 때
	var hasId = "<%=hasId%>"
	if(hasId=="Y"){
		alert("등록된 아이디가 있습니다.");
	}else{
		alert("등록 가능한 아이디입니다.");
		document.querySelector("[name=id]").value="<%=id%>"
	}
}
</script>
 --%>
 <%--
 5번
 
 --%>
 <br><br><br><br><br>
오늘로부터 몇일? <input type ="date" name="indate"/>
<input type="button" value="날짜확인" onclick="calDate()"/>
<h3 id="showDt"></h3>


<script>
	function calDate(){
		var toDay = new Date() //오늘 날짜
		var inDate = document.querySelector("[name=indate]").value.split("-")
		var stDay = new Date(inDate[0],inDate[1]-1,inDate[2])
		var diff = toDay.getTime()-stDay.getTime()
		//날짜수만 나올 수 있게 내림처리..
		var dayCnt = Math.floor(diff/1000/60/60/24)
		console.log(dayCnt)
		//Math.abs(dayCnt) : 오늘 이전은 + , 오늘 이후는 - 값 절대값 처리
		//((dayCnt>0)?"전":"이후") : 오늘 이후는 -이므로 이후로 그외는 전
		document.querySelector("#showDt").innerText =
			Math.abs(dayCnt)+"일 "+ ((dayCnt>0)?"전":"이후")
	}
</script>
<%--
8번
JSON 
--%> <br>
<table id="fifa">
	<thead><tr><th>팀</th><th>승</th><th>무</th><th>패</th><th>승률</th></tr></thead>
	<tbody>
	</tbody>
</table>

<script>
var hgrp = []
hgrp.push({nat:"포르투갈",win:2,eq:0,def:1})
hgrp.push({nat:"한국",win:1,eq:1,def:1})
hgrp.push({nat:"우루과이",win:1,eq:1,def:1})
hgrp.push({nat:"가나",win:0,eq:0,def:2})
console.log(hgrp)
hgrp.map(function(team){
	team.win = team.win+1
	team.winRatio =  Math.round(team.win/(team.win+team.def)*100)
	return team
})
// 새로운 배열에 할당
var hgrp = hgrp.filter(function(team){
	return team.winRatio>=50
})
var show=""
hgrp.forEach(function(t){
	show+="<tr><td>"+t.nat+"</td><td>"+t.win+"</td><td>"+t.eq+"</td><td>"+t.def+"</td><td>"+t.winRatio+"%</td></tr>"	
})
document.querySelector("#fifa tbody").innerHTML = show
console.log(hgrp)
</script>
<script type="text/javascript">
/*

 */

var div = document.querySelector("#container")
div.innerHTML+="<br>"
</script>
</html>