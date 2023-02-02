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
2022-12-08
[1단계:개념] 1. form요소객체의 하위 속성을 속성값을 동적으로 변경하는 코드를 기술하세요
	 input
		-value
		-readonly : 읽기 전용 필드
		-required : 필수 입력 필드
		-type : 형식을 지정
			hidden 보이지 않는 형식
			text/search/tel/url/email/password/date/button/file..
			등 여러 속성값으로 설정할 수 있다.
			radio/checkbox : checked 속성 포함
			
[1단계:확인] 2. 회원아이디를 입력하고 옆에 유효 CHECK 버튼을 클릭시,
               글자수가 8~16이고, himan가 아닐 때만 유효여부 checkbox표기하고, readOnly 속성으로 설정하세요.
               회원아이디 [    ] [유효check]  []유효여부 --%>
   
               
               <%--
[1단계:확인] 3. checkbox, radio, select의 js로 접근할 때, 차이점을 기술하세요.
checkbox와 radio는 사용자의 선택을 위한 대표적인 폼 엘리먼트이다. 
checkbox는 다중, radio는 하나 
select는 옵션이 많을 때 사용자의 선택을 위한 대표적인 폼 엘리먼트이다.

[1단계:확인] 4. checkbox와 월드컵 출전팀을 리스트하고, check 후, 16강진출 버튼 클릭시, 선택된 팀만 하단에 리스트하게 하세요.
--%>
   <h2>월드컵 출전팀</h2>
   <input type="checkbox" name="nation" value="미국"/>미국<br>
   <input type="checkbox" name="nation" value="대한민국"/>대한민국<br>
   <input type="checkbox" name="nation" value="카타르"/>카타르<br>
   <input type="checkbox" name="nation" value="이란"/>이란<br>
   <input type="checkbox" name="nation" value="일본"/>일본<br>
   <input type="checkbox" name="nation" value="호주"/>호주<br>
   <input type="checkbox" name="nation" value="가나"/>가나<br>
   <input type="checkbox" name="nation" value="브라질"/>브라질<br>
   <input type="checkbox" name="nation" value="캐나다"/>캐나다<br>
   <input type="checkbox" name="nation" value="포르투갈"/>포르투갈<br>
   <input type="button"  onclick="16go()" value="16강 진출"/>
<%--
[1단계:확인] 5. radio를 이용해서 현재 해결해야 할 문제(3가지) 중에 가장 중요한 것을 클릭시, 하단에 표현되게 하세요.
--%>
 <h2>문제</h2>
   <input type="radio" name="issue" value="과제"/>과제<br>
   <input type="radio" name="issue" value="프로젝트"/>프로젝트<br>
   <input type="radio" name="issue" value="복습"/>복습<br>
    <p id="show"></p>
      
<%-- 
[1단계:확인] 6. 물건명, 가격select(1000단위~9000), 갯수(select 1~9) 가격나 갯수를 선택시, 하단에 구매한 물건과 총비용을 출력되게 하세요
--%>
<h2>6번</h2>
	사과 가격을 선택하세요 : 
	<select name="price" >
		<option>1000</option>
		<option>2000</option>
		<option>3000</option>
		<option>4000</option>
		<option>5000</option>
		<option>6000</option>
		<option>7000</option>
		<option>8000</option>
		<option>9000</option>
	 </select>
	  <input type="button" onclick="chGen2()"value="선택"/>
	 사과 갯수를 선택하세요 : 
	<select name="cnt" >
		<option>1</option>
		<option>2</option>
		<option>3</option>
		<option>4</option>
		<option>5</option>
		<option>6</option>
		<option>7</option>
		<option>8</option>
		<option>9</option>
	 </select>
 <input type="button" onclick="chGen()"value="선택"/>
	<h2>선택된 갯수:<span id="chG"></span></h2>
	<h2>선택된 가격:<span id="chG2"></span></h2>
<script>


var chG = document.querySelector("#chG")
function chGen(){
	//select의 하위에 선택 옵션
	var opts = document.querySelectorAll("[name=cnt]>option")
	for(var idx=0;idx<opts.length;idx++){
	
		if(opts[idx].selected){//선택되었을때
			chG.innerText=opts[idx].value
		}
	}
}
function selGen(obj){
	
		chG.innerText=obj.value	
	
}


var chG2 = document.querySelector("#chG2")
function chGen2(){
	//select의 하위에 선택 옵션
	var opts = document.querySelectorAll("[name=price]>option")
	for(var idx=0;idx<opts.length;idx++){
	
		if(opts[idx].selected){//선택되었을때
			chG2.innerText=opts[idx].value
		}
	}
}
function selGen2(obj){
	
		chG2.innerText=obj.value	
	
}
</script>
	 <br>
   <input type="radio" name="price" value="과제"/>과제<br>
   <input type="radio" name="i" value="프로젝트"/>프로젝트<br>
   <input type="radio" name="issue" value="복습"/>복습<br>
    <p id="show"></p>

<%--

[1단계:확인] 7. 쿠키와 세션의 궁극적인 차이점으로 설정 코드와 함께 설명하세요

저장 위치의 차이
-쿠키는 클라이언트(사용자의)의 로컬에 저장된다.
-세션은 서버에 저장된다.
-쿠키와 세션의 차이는 보통 이 저장 위치의 차이에서 기인한다.
생명주기
-쿠키는 사용자의 로컬에 파일로 저장되어 있기 때문에 브라우저가 종료되어도 남아있는다.
-세션은 브라우저가 종료되면 함께 사라진다.
용량의 차이
-쿠키는 최대 4kb저장 가능
-세션은 무제한

[1단계:확인] 8. Emp Vo로 세션을 설정하고, 세션이 없을 때, 세션설정하는 페이지로 이동하게 하되, 세션 확인하는 페이지에서
                   10/20/30/40  테이블 리스트에서 클릭시, 해당 부서만 접근가능 alert() 그 외는 접근 불가능 alert()로딩되게 처리하세요.
--%>
<%
Dept d = new Dept("10","회계");
session.setAttribute("dept",d);
%>
<h2>세션 생성</h2>
<h3>세션 확인</h3>
</body>
<script type="text/javascript">



document.querySelector("h3").onclick=function(){
	location.hrf="x01_check.jsp";
}


/*

 */
 var issue = document.querySelectorAll("[name=issue]")
 var show = document.body.querySelector("#show")
    for(var idx=0; idx<issue.length;idx++){
       issue[idx].onclick=function(){
			var add= ""
			for(var idx=0;idx<issue.length;idx++){
				if(issue[idx].checked){
					add+=issue[idx].value
			}
			}
			show.innerText=add;
       }
    }
    function ckData(){
       var add="";
       for(var idx=0;idx<issue.length;idx++){
          if(issue[idx].checked){
             add+=issue[idx].value+",";
          }
      
       show.innerText=add
    }
   }
  
var div = document.querySelector("#container")
div.innerHTML+="<br>"
</script>
</html>