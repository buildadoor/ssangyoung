<%@ page language="java" contentType="text/html; charset=UTF-8"
'    pageEncoding="UTF-8"
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
	<style>td{width:25%;}</style>
	<script type="text/javascript">
/*
 
 */
</script>
</head>
<body>
<h3>부서정보 </h3>
<table id="dtab">
	<thead>
		<tr><th>부서번호</th><th>부서명</th><th>부서위치</th></tr>
	</thead>
	<tbody>
	</tbody>	
</table>
	<h2></h2>
	<h2></h2>
	<h2></h2>
	<h2></h2>
	<h2></h2>
	<h2></h2>
	<h2></h2>
	<script type="text/javascript">
	var dlist=[
		{deptno:10,dname:'인사',loc:'서울'},
		{deptno:20,dname:'재무',loc:'인천'},
		{deptno:30,dname:'회계',loc:'대전'},
		{deptno:40,dname:'기획',loc:'제주도'}
	]
	 var show=""
	dlist.forEach(function(dept){
		show+="<tr><td>"+dept.deptno+"</td><td>"+dept.dname+"</td><td>"+dept.loc+"</td></tr>"	
	});
	 var tbody = document.querySelector("#dtab>tbody")
	 tbody.innerHTML = show
	 
	var colors = ['red','orange','yellow','green','blue','navy','purple']
	var h2Arr = document.querySelectorAll("h2")
	colors.forEach(function(color idx){
		h2Arr[idx].innerText = color // idx와 문자 matching되게 처리할 수 있기때문에 문자처리 
		h2Arr[idx].style.background= color
		});	
	</script>
	<table>
		<tr><td></td><td></td><td></td><td></td></tr>
		<tr><td></td><td></td><td></td><td></td></tr>
		<tr><td></td><td></td><td></td><td></td></tr>
		<tr><td></td><td></td><td></td><td></td></tr>
	</table>
	<script type="text/javascript">
/*	var tds = document.querySelectorAll("td")
	function init(){
		for(var idx=0;idx<tds.length;idx++){
			tds[idx].innerText=idx+1	
			tds[idx].style.background=""	
		}	
	}
	init()
	var idx=0	
	
	setInterval(function(){
		init() //초기화로 해당 cell만 노랑색 처리..
		tds[idx%16].style.background="yellow"//idx%16 0~15 범위 계쏙 반복 처리
		idx++;
	},300)
	*/
	</script>
<%-- 
#
--%>
<div id="container01"></div>
<%--
				<h2>덧셈연습</h2>
		<input id="exnum01"/> + <input id="exnum02"/>? <br>			
		정답입력: <input id="inNum"/>		
--%>
<script type="text/javascript">
//	while(true){	//무한대 연습 가능
		if(confirm("덧셈연습하겠습니까?")){
			var exnum01 = document.querySelector("#exnum01")
			var num01 = parseInt(Math.random()*100)
			exnum01.value= num01
			var exnum02 = document.querySelector("#exnum02")
			var num02 = parseInt(Math.random()*100)
			exnum02.value= num02
			var corNum = num01+num02
			var set01 = setTimeout(function(){
				
				var inNum = Number(document.querySelector("#inNum").value)
				if(corNum == inNum){
					alert("정답")
				}else{
					alert("오답")
				}
			},5000}
		}

		//else{
			//break;
	//	}
//	}	
	</script>
<%--
		타석:<input type="text" name="set01"/>
		안타:<input type="text" name="hit01"/>
<input type="button" value="타율계산" onclick="calHitRatio()"/>
<h2>타율(소숫점이하):@@@, 타율(%):@@@</h2>
--%>
</body>
<script type="text/javascript">
/*

 */
 function calHitRatio(){
		var set01 = document.querySelector("[name=set01]").value
		var hit01 = document.querySelector("[name=hit01]").value
		var hitRatio1 = parseInt(hit01/set01*100) //자동형변환 처리 
		var hitRatio2 = Number(hit01)/Number(set01) //명시적 형변환 처리 
		var show = document.querySelector("h2")
		show.innerText="타율(소숫점이하):"+hitRatio2+",타율(%):"+hitRatio1
}
//<input type="button" value="타율계산" onclick="calHitRatio()"/>
</script>
</html>