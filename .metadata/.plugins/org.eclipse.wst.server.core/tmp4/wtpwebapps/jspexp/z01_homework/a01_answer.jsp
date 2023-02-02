<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
	table{border-collapse:collapse;}
	</style>
</head>
<body>
<%--
3번 문제 
<h3>물건정보입력</h3>
<table id="prodTab" width="50%" border>
	<tr><th>물건명</th><td></td></tr>
	<tr><th>가격</th><td></td></tr>
	<tr><th>갯수</th><td></td></tr>
	<tr><th>총계</th><td></td></tr>
	</table>
<script type="text/javascript">
	var pname = prompt("물건명","")
	var price = prompt("가격입력","0")
	var cnt = prompt("갯수입력","0")
	var tds = document.querySelectorAll("#prodTab td");
	tds[0].innerText = pname;
	tds[1].innerText = price;
	tds[2].innerText = cnt;
	tds[3].innerText = price*cnt; //js에서 +(덧셈)연산자 이외는 자동형변환을 해준다.
	</script>
	 --%>
<%--5번 --%>
<h2>물건정보</h2>
<table id="tab03" height="300px" border>
	<tr><td></td><td></td><td></td></tr>
	<tr><td></td><td></td><td></td></tr>
	<tr><td></td><td></td><td></td></tr>
</table>
<script type="text/javascript">
	var tds = document.querySelectorAll("td");//DOM객체를 배열로 받아서 
	//index번호로 접근해서 innerText 속성을 이용해서 값을 할당
	tds[0].innerText="1행1열";tds[1].innerText="1행2열";tds[2].innerText="1행3열";
	tds[3].innerText="2행1열";tds[4].innerText="2행2열";tds[5].innerText="2행3열";
	tds[6].innerText="3행1열";tds[7].innerText="3행2열";tds[8].innerText="3행3열";
	
</script>
<%--6번 --%>
<table id="tab03" height="300px" border>
	<tr><th>물건명</th><th>가격</th><th>갯수</th></tr>
	<tr><td class="pname"></td><td class="price"></td><td class="cnt"></td></tr>
	<tr><td class="pname"></td><td class="price"></td><td class="cnt"></td></tr>
	<tr><td class="pname"></td><td class="price"></td><td class="cnt"></td></tr>
</table>
<script type="text/javascript">
	var pnames = document.querySelectorAll("#tab03 .pname");//DOM객체를 배열로 받아서 
	var prices = document.querySelectorAll("#tab03 .price");//DOM객체를 배열로 받아서 
	var cnts = document.querySelectorAll("#tab03 .cnt");//DOM객체를 배열로 받아서 
	//index번호로 접근해서 innerText 속성을 이용해서 값을 할당
	pnames[0].innerText="사과";pnames[1].innerText="바나나";pnames[2].innerText="딸기";
	//클래스단위로 접근하기에 클래스마다 0 index 다시 시작
	prices[0].innerText="1200";prices[1].innerText="4000";prices[2].innerText="12000";
	cnts[0].innerText="3";cnts[1].innerText="2";cnts[2].innerText="5";
	
</script>

<%--9번 --%>
<%
	String[]players={"최정","송성문","김성현"};
	String[]teams={"SSG","키움","SSG"};
	double[]records={0.476,0.381,0.348};

	for(int idx=0;idx<players.length;idx++){
		log(players[idx]+":"+teams[idx]+":"+records[idx]);
	}
%>
	<table height="300px" border>
	<tr><th>번호</th><th>소속팀</th><th>선수명</th><th>성적</th></tr>
	<%for(int idx=0;idx<players.length;idx++){%>
	<tr><td><%=idx+1%></td><td><%=players[idx]%></td><td><%=teams[idx]%></td><td><%=records[idx]%></td></tr>
	<%}%>
</table>
</body>
</html>