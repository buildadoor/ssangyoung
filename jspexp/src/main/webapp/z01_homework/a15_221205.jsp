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
function calcu(){
	var calStr = document.querySelector("#calStr").value
	var calStr = document.querySelector("#show").innerText=calStr
				+"="+eval(calStr)
}
</script>
</head>

<body>
<div id="container"></div>
<%-- 
2022-12-05
[1단계:개념] 1. JSON객체의 형변환메서드 2개의 기능을 예제를 통해서 기술하세요.

						network환경
 		클라이언트1 	--> json문자열 ---> 서버(json문자열==>json객체==>ArrayList())
 		(json객체==>json문자열)
 		클라이언트2	<-- json문자열 <---
 		(json문자열==>json객체)
 
  JSON.parse() : json문자열을 객체로 변환해서 활용 
("key":"value,"key":value)

[1단계:확인] 2. 임의의 구구단 출력 h2로 출력 eval함수를 활용하여 3X3 테이블에  0~9 정답확인 문자열 생성
            @@@ X @@  = ?
            테이블 ==> cell 클릭시 ?에 입력될 숫자를 출력하고,
            정답확인 버튼 클릭시 출력되게 처리. 정답여부를 출력되게 하세요
            --%>
            
        <h3>구구단풀기</h3>
            <h2 id="ex2"></h2>
            
            <table id="noTab" width="50%" height="70%">
               <col width="33%"><col width="33%"><col width="33%">
               <tr><td style="text-align:right;height:20%;"colspan="3"></td></tr>
               <tr><td>1</td><td>2</td><td>3</td></tr>
               <tr><td>4</td><td>5</td><td>6</td></tr>
               <tr><td>7</td><td>8</td><td>9</td></tr>
               <tr><td colspan="3"><input type="button" value="정답확인" /></td></tr>
            </table>
            
            <script>
               var num01 = Math.floor(Math.random()*101+1)
               var num02 = Math.floor(Math.random()*101+1)
               var ex2 = document.querySelector("#ex2")
               ex2.innerHTML = num01+" X "+num02+" = "
               var answer = num01*num02
               
                  var gugudan =document.querySelectorAll("#noTab td")
               for(var idx=0;idx<gugudan.length;idx++){
                  gugudan[idx].onclick=function(){
                     gugudan[0].innerText += this.innerText
                  },gugudan[10].onclick=function(){
                     if(answer==gugudan[0].innerText){
                           alert("정답 입니다")
                        }else{
                           alert("정답이 아닙니다!")
                        }
                  }
               }
            </script>
         
            <%--
[1단계:개념] 3. DOM의 선택자의 종류와 출력기능 속성을 구분하여 기술하세요.
 선택자
      - css의 선택자를 통하여 객체를 선택할 수 있다.
         태그, #아이디, .클래스
         document.querySelector("h1")
      - 단일
         var ch01 = document.querySelector("#ch01")
      - 다중선택
         var cls01 = document.querySelectorAll(".cls01")
      복합선택자,[속성=속성값] 등 css의 선택자를 활용하여 선택자 처리를 할 수 있다.
      
 기본 속성 
         .속성 = 속성값 : 태그가 가지고 있는 기본 속성을 읽어 오거나 설정할 수 있다.
      	
[1단계:확인] 4. 4X4 테이블을 1~16까지 출력하고, 가장 밑라인 클래스로 cls01은 배경색상을 노랑색 ,  왼쪽라인 클래스로 cls02 글자색상을 파랑색, 
      왼쪽라인 클래스로 cls03 빙고라고 표시, 위쪽 라인은 클래스로 cls04 처리하고 글자를 오른쪽 정렬 처리 처리되게 하세요.
      --%>
    <table>
   <tr><td class="cls02 cls03 cls04">1</td><td class="cls04">2</td><td class="cls04">3</td><td class="cls04">4</td></tr>
   <tr><td class="cls02 cls03" >5</td><td>6</td><td>7</td><td>8</td></tr>
   <tr><td class="cls02 cls03" >9</td><td>10</td><td>11</td><td>12</td></tr>
   <tr class="cls01"><td class="cls02 cls03">13</td><td>14</td><td>15</td><td>16</td></tr>
   </table>
      <%--
[1단계:개념] 5. DOM의 css 속성과 일반 속성의 차이점을 기술하세요.
    	style 속성
         .style.속성 = 속성값 : css속성이 적용된 내용을 설정할 수 있다.
      	form 요소객체 속성
         .value = "값" : 데이터의 입력 처리를 할 때, form 하위 객체의 요소인 value를 통해서
                     효과적으로 처리할 수 있다.

[1단계:개념] 6. DOM의 innerText와 innerHTML의 차이점을 기술하세요.
  		  .innerHTML : 화면에 출력할 내용을 랜더링(html 적용)한 내용의 태그를 
            가져오거나 처리하는 속성
         .innerText : 화면에 출력할 내용을 html 적용하지 않은 순서한 내용 자체를 가져오거나
                     랜더링하지 않는 속성

[1단계:확인] 7. 5X5 테이블을 임의의 25개 숫자(0~100)로 출력하고, 이 중 짝수 열의 글자색상을 파랑색으로 출력하세요.


--%>
<table>
	<tr><td></td><td></td><td></td><td></td><td></td></tr>
	<tr><td></td><td></td><td></td><td></td><td></td></tr>
	<tr><td></td><td></td><td></td><td></td><td></td></tr>
	<tr><td></td><td></td><td></td><td></td><td></td></tr>
	<tr><td></td><td></td><td></td><td></td><td></td></tr>

</table>
</body>
<script type="text/javascript">
/*
가장 밑라인 클래스로 cls01은 배경색상을 노랑색 ,  왼쪽라인 클래스로 cls02 글자색상을 파랑색, 
 왼쪽라인 클래스로 cls03 빙고라고 표시, 위쪽 라인은 클래스로 cls04 처리하고 글자를 오른쪽 정렬 처리 처리되게 하세요.
 */
 

	 
	 
	 
 var cls01 = document.querySelectorAll(".cls01")
 cls01[0].style.background="yellow"
 var cls02 = document.querySelectorAll(".cls02")
 cls02[0].style.color="blue"
 cls02[1].style.color="blue"
 cls02[2].style.color="blue"
 cls02[3].style.color="blue"
var cls03 = document.querySelectorAll(".cls03")
cls03[0].innerText = "빙고" 
cls03[1].innerText = "빙고" 
cls03[2].innerText = "빙고" 
cls03[3].innerText = "빙고" 
var cls04 = document.querySelectorAll(".cls04")
cls04[0].style.textAlign="right"
cls04[1].style.textAlign="right"
cls04[2].style.textAlign="right"
cls04[3].style.textAlign="right"
// 왼쪽라인 클래스 cls02,cls03 어떻게 적용 ? ! 
var div = document.querySelector("#container")
div.innerHTML+="<br>"
</script>
</html>