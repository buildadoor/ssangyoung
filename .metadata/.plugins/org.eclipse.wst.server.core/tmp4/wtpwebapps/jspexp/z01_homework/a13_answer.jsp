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
#3번 처리순서
1. 화면 구현
2. 이벤트 핸들러 선언
	1) 필요한 DOM 객체 선언 
	2) 기준일 : 년 - 월 - 일 2022-12-02 ==> 년/월/일 분리 추출 
		substring, split("-")
	3) Date()에 생성과 할당
		기능메서드 +,- setDate(getDate()+@@)
	4) 출력DOM에 toLocaleString()
	
--%>
기준 <input type="date" name="date01"/><br>
계산할 일수 : <input type="text" name="dcnt" value=0> 
<input type="button" value="이전" onclick="calcu(false)"/>
<input type="button" value="이후" onclick="calcu(true)"/>
<p id="show01" align="center"></p>


<%--7번 --%>
<h2>include 액션 태그</h2>
<div style="border:1px solid blue">
	<jsp:include page="z21_sub.jsp">
		<jsp:param value="잉글랜드" name="nation"/>
		<jsp:param value="7" name="point"/>
	</jsp:include>
</div>
<%--8번 --%>
<h2>카타르 월드컵 최고 득점 선수</h2>
<form>
	나라:<input type="text" name="nation"/>
	이름:<input type="text" name="name"/>
	점수:<input type="text" name="point"/>
	<input type="submit" />
</form>
<%@ include file="z22_sub.jsp" %>
<br>
<h3>입력 결과</h3>
<h3>나라: <%=nation %></h2>
<h3>이름: <%=name %></h3>
<h3>점수: <%=point %></h3>
<%--9번 
장바구니 z23_sub.jsp / 2 z24_sub.jsp
--%>
<style>td{width:33%;height:33%;}</style>
<h2>두개의 장바구니에 담기</h2>
<select name="cart">
	<option value="cart1">장바구니1</option>
	<option value="cart2">장바구니2</option>
</select>
<table>
	<%
	String []fruits = {"사과","바나나","수박","오렌지","귤","딸기","키위","망고","체리"};
	for(int idx=0;idx<fruits.length;idx++){
		if(idx%3==0) out.print("<tr>");
		out.print("<td onclick='ch01(this.innerText)'>"+fruits[idx]+"</td>");
		if(idx%3==2) out.print("</tr>");
	}
	%>
</table>
<iframe name="cart01" src="z23_sub.jsp" height="200px"></iframe>
<iframe name="cart02" src="z24_sub.jsp" height="200px"></iframe>

<script type="text/javascript">  
function ch01(fruit){
	var chCart = document.querySelector("[name=cart]").value
	
	if(chCart=="cart1")cart01.document.body.innerHTML+=fruit+","
	if(chCart=="cart2")cart02.document.body.innerHTML+=fruit+","
}
</script>


<script type="text/javascript">  
var date01 = document.querySelector("[name=date01]")
var dcnt = document.querySelector("[name=dcnt]")
var show01 = document.querySelector("#show01")
var d = new Date()
date01.value = d.toISOString().split("T")[0]
function calcu(isAfter){
   var d = date01.value.split("-")
   // console.log(d)
   // console.log(d[1]-1+"월(-1)처리")
   // 입력
   var dt01 = new Date(d[0],d[1]-1,d[2])
   var datecnt = parseInt(dcnt.value) //입력된 내용을 형변환 +
   // 날수 처리
   if( !isAfter ) datecnt = -datecnt
   //console.log(datecnt)
   dt01.setDate(dt01.getDate()+datecnt)
   show01.innerText = dt01.toLocaleString()
}

// 오늘 날짜 설정.
// console.log(d.toISOString())
// console.log(d.toISOString().split("T"))
// console.log(d.getFullYear()+"-"+(d.getMonth()+1)+"-"+d.getDate())
// date01.value=d.getFullYear()+"-"+(d.getMonth()+1)+"-"+d.getDate()
</script>

	
	
</body>
<script type="text/javascript">
/*

 */
var div = document.querySelector("#container")
div.innerHTML+="<br>"
</script>
</html>