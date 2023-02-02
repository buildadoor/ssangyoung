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
#
2번 
	1) 화면구현
		//- 문제 출력 h2, ? (정답입력 출력 내용 span)
		- 테이블 구현
		 0~9, 상단에 문제 출력 td, 입력한 정답출력 td, 입력 초기화 td(C), 정답확인 td 
	2) DOM 객체 선언 및 임의의 문제 출력 
		//var gugu = document.querySelector("h2")
		var inNum = document.querySelector("span")
		var tds = document.querySelector("#table td")
		var gugu = tds[0] 
		var inNum = tds[1]
		ranGugu(); //초기에 함수 선언 
		var corNum = 0
		function ranGugu(){
			var grade = Math.floor(Math.random()*8+2)
			var cnt = Math.floor(Math.random()*9+2)
			corNum = grade*cnt
			gugu.innerText = grade + " X " + cnt
		}
	3) 이벤트 처리 (익명)
		- 클릭시, ?에 입력한 숫자 출력
		for(var idx = 0; idx<tds.length;idx++){
			tds[idx].onclick=function(){
				if(this.innerText =="정답확인") {
					//입력한 내용과 정답 여부가 같은지 
					if(tds[1].innerText==corNum){
						alert("정답\n다음 문제");
						ranGugu();
						
					}else{
						 alert("오답\n다른 정답을 입력하세요");
						inNum.innerText=""
					}	
				}else{
					//번호를 클릭시, 입력한 내용을 출력하는 곳에 출력 처리
					tds[1].innerText += this.innerText
					if(this.innerText =="C")tds[1].innerText=""
				}
				
			}
		}
		
		
		- 정답여부 클릭시, 입력한 숫자와 정답인지 확인
		- 다음 문제
--%>
   <table id="tab01">
               <col width="33%"><col width="33%"><col width="33%">
               <tr style="height:40px"><td colspan="2">@@X@@</td><td>0</td></tr>
               <tr><td>1</td><td>2</td><td>3</td></tr>
               <tr><td>4</td><td>5</td><td>6</td></tr>
               <tr><td>7</td><td>8</td><td>9</td></tr>
               <tr><td>C</td><td>0</td><td>정답확인</td></tr>
    </table>
    <script>
    var tds = document.querySelectorAll("#tab01 td")
	var corNum = 0
	//var gugu = tds[0] 
	//var inNum = tds[1]
	ranGugu(); //초기에 함수 선언 
	function ranGugu(){
		var grade = Math.floor(Math.random()*8+2)
		var cnt = Math.floor(Math.random()*9+2)
		corNum = grade*cnt
		tds[0].innerText = grade + " X " + cnt
	}
	for(var idx = 0; idx<tds.length;idx++){
		tds[idx].onclick=function(){
			if(this.innerText =="정답확인") {
				//입력한 내용과 정답 여부가 같은지 
				if(tds[1].innerText==corNum){
					alert("정답\n다음 문제로 넘어갑니다.");
					ranGugu();
					
				}else{
					 alert("오답\n다른 정답을 입력하세요");
					inNum.innerText=""
				}	
			}else{
				//번호를 클릭시, 입력한 내용을 출력하는 곳에 출력 처리
				tds[1].innerText += this.innerText
				if(this.innerText =="C")tds[1].innerText=""
			}
			
		}
	}
	</script>
    <h2>cls</h2>
     <table id="tab02">
   <tr><td class="cls02 cls03 cls04">1</td><td class="cls04">2</td><td class="cls04">3</td><td class="cls04">4</td></tr>
   <tr><td class="cls02 cls03" >5</td><td>6</td><td>7</td><td>8</td></tr>
   <tr><td class="cls02 cls03" >9</td><td>10</td><td>11</td><td>12</td></tr>
   <tr class="cls01"><td class="cls02 cls03">13</td><td>14</td><td>15</td><td>16</td></tr>
   </table>
</body>
<script>
var tds2 = document.querySelectorAll("#tab02 td")
var cls01 = document.querySelectorAll(".cls01")
var cls02 = document.querySelectorAll(".cls02")
var cls03 = document.querySelectorAll(".cls03")
var cls04 = document.querySelectorAll(".cls04")
for(var idx=0; idx<tds2.length;idx++){
	tds2[idx].innerText=idx+1+"번째"
}

for(var idx=0; idx<cls01.length;idx++){
	cls01[idx].style.background="yellow"
}
for(var idx=0; idx<cls01.length;idx++){
	cls02[idx].style.color="blue"
}
for(var idx=0; idx<cls01.length;idx++){
	cls03[idx].innerText="빙고"
}
for(var idx=0; idx<cls01.length;idx++){
	cls04[idx].style.textAlign="right"
}




</script>
<!--4번
1) 화면 구현
	<td class="cls01">
	<td class="cls02">
	<td class="cls03 cls04"> : 동일한 요소객체가 중첩될때 
	<td class="cls04">
2) DOM객체 호출 
	var tds2 = document.querySelectorAll("#tab02 td")
	var cls01 = document.querySelectorAll(".cls01")
	var cls02 = document.querySelectorAll(".cls02")
	var cls03 = document.querySelectorAll(".cls03")
	var cls04 = document.querySelectorAll(".cls04")
	
	
	for(val idx=0; idx<tds2.length;idx++){
 		tds2[idx].innerText=idx+1+"번째"
 	}
	
 	for(val idx=0; idx<cls01.length;idx++){
 		cls01[idx].style.background="yellow"
 	}
 	for(val idx=0; idx<cls01.length;idx++){
 		cls02[idx].style.color="blue"
 	}
 	for(val idx=0; idx<cls01.length;idx++){
 		cls03[idx].innerText="빙고"
 	}
 	for(val idx=0; idx<cls01.length;idx++){
 		cls04[idx].style.textAlign="right"
 	}
 -->
 <!-- 7번
 1.화면구현
 2. DOM객체 선택
 	var tds3 =document.querySelectorAll(#tab02 td")
 	var tdsEven =document.querySelectorAll(#tab02 td:nth-child(2n)")
 	for(var idx=0;idx<tds3.length;idx++){
 		tds3[idx].innerText=Math.floor(Math.random()*101);
 	}
 	for(var idx=0;idx<tdsEven.length;idx++){
 		tdsEven[idx].style.color = "blue";
 	}
  -->
 <table id="tab03">
 <tr><td></td><td></td><td></td><td></td><td></td></tr>
 <tr><td></td><td></td><td></td><td></td><td></td></tr>
 <tr><td></td><td></td><td></td><td></td><td></td></tr>
 <tr><td></td><td></td><td></td><td></td><td></td></tr>
 <tr><td></td><td></td><td></td><td></td><td></td></tr>
 <tr><td></td><td></td><td></td><td></td><td></td></tr>
 </table>
 
<script type="text/javascript">

		var tds3 =document.querySelectorAll("#tab03 td")
		var tdsEven =document.querySelectorAll("#tab03 td:nth-child(2n)")
	 	for(var idx=0;idx<tds3.length;idx++){
	 		tds3[idx].innerText=Math.floor(Math.random()*101);
	 	}
	 	for(var idx=0;idx<tdsEven.length;idx++){
	 		tdsEven[idx].style.color = "blue";
	 	}
	
var div = document.querySelector("#container")
div.innerHTML+="<br>"
</script>
</html>