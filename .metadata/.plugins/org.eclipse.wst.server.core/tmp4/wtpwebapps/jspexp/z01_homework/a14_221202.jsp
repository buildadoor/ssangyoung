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
2022-12-02
[1단계:개념] 1. [jsp] forward란 무엇인가? 페이지 처리의 scope 범위를 기술하세요.
 특정한 페이지에서 request와 response 객체와 함께 
대상 페이지로 전송하는 기능을 하는 액션 스크립트
요청값을 받아서 중간 페이지에서 분기 처리할 때, 주로 활용된다.
	1) 로그인 화면 ==> 중간 페이지 ==> 다시 로그인이냐? 메인페이지냐 	
[1단계:확인] 2. [jsp] 물건명:[   ][재고여부] 클릭시, form으로 submit 처리하여 
               a50_check.jsp에 이동해서 a53_main.jsp(재고 있음),  a54_main.jsp(재고 없음),  
               --%>
    
               <%--
[2단계:확인] 3. [jsp] form으로 물건명 가격 갯수를 입력해서 전송했을 때, 두번째 페이지(z40_cal.jsp)에서 총비용이
               100000이상이면 MVP페이지(z41_mvp.jsp)로 forward처리 그렇지 않으면 Normal페이지(z42_normal.jsp)로 이동하게 하세요.
[3단계:확인] 3. [jsp] id:[   ][등록여부] 클릭시, form으로 submit 처리하여 a51_check.jsp에 이동해서 DB에 있을 때와 없을 때는 나누어 
            request setAttribute("hasId","Y"/"N")로 설정하여 등록가능 여부를 처리하세요
[1단계:개념] 4. [js] 날짜 객체의 getTime()은 어떤 메서드 인가?
1. getTime()를 통해서 1970/1/1 기준으로 1/1000 시간을 가져올 수있다.
	우리나라는 GMT + 9:00
	
[1단계:확인] 5. [js] 2022/12/01와 2023/01/01의 사이의 시간과 날짜수를 출력하세요.
	var div = document.querySelector("#container")
 	var show=""
	 var d1 = new Date(2022,11,01)
	  var d2 = new Date(2023,0,01)
	  var minus = d2.getTime()-d1.getTime() 
	  show+="시간:"+parseInt(minus/1000/60/60)+"<br>"
	  show+="일수:"+parseInt(minus/1000/60/60/24)+"<br>"
	  div.innerHTML=show
[2단계:확인] 5. [js] 오늘로 부터 몇일? [@@@@-@@-@@][날짜 확인] 날짜를 @@@-@@-@@ 형식으로 입력하고,
               날짜 확인 버튼을 클릭시, 며칠되었지 출력하세요.

[1단계:개념] 7. [js] map(), filter()의 차이점을 기술하세요
1.map
collection 인자에 연산을 거쳐 나온값으로 새로운 collection을 구성할 수 있다.
val list = listOf(2,4,6,8)
list.map{it+2} // {4,6,8,10}으로 구성된 collection이 return 된다.

2. filter
이름을 보면 알 수 있겠지만 조건을 걸어 filtering시킬 수 있는 함수 이다. filter내에서 true를 return하는 인자만 모아 새로운 collection을 구성하여 return 한다.
val list = listOf(2,4,6,8)
list.filter{it<5} // {2,4}으로 구성된 collection이 return 된다.

[1단계:확인] 8. [js] 0~100점의 임의의 국어점수 5명을 만들고 출력하고, 이 점수를 15% 점수를 올린 배열과 60점이상인 배열을 출력하세요.
 
	  div.innerHTML="<h2>5명의 국어점수</h2>"
	  var arr =[]
	  for(var cnt=1;cnt<=5;cnt++){
	 	 arr.push(Math.floor(Math.random()*101))
	  }
	  div.innerHTML+="국어점수"+arr+"<br>"
	 var arr2= arr.map(function(score){return Math.round(score*.15)}) 
	  div.innerHTML+="15% 상승:"+arr2+"<br>"
	 var arr3 = arr.filter(function(score){return score>=60})
	  div.innerHTML+="60점 이상:"+arr3+"<br>"	  
[3단계:확인] 8. [js] 월드컵 조별팀의 기본속성(나라,승,무,패)로 특정조의 팀들을 현재 성적으로 등록시키고, 승수를 한번에 1씩 올리고, 해당 팀들을 테이블로 출력하고, 이중 승률이 50%이상인 팀만 추출하여 배열 출력하세요
--%>
</body>
<script type="text/javascript">
/*

 */
 var div = document.querySelector("#container")
 var show=""
	 var d1 = new Date(2022,11,01)
	  var d2 = new Date(2023,0,01)
	  var minus = d2.getTime()-d1.getTime() 
	  show+="시간:"+parseInt(minus/1000/60/60)+"<br>"
	  show+="일수:"+parseInt(minus/1000/60/60/24)+"<br>"
	  div.innerHTML=show

	  
	  div.innerHTML="<h2>5명의 국어점수</h2>"
	  var arr =[]
	  for(var cnt=1;cnt<=5;cnt++){
	 	 arr.push(Math.floor(Math.random()*101))
	  }
	  div.innerHTML+="국어점수"+arr+"<br>"
	 var arr2= arr.map(function(score){return Math.round(score*.15)}) 
	  div.innerHTML+="15% 상승:"+arr2+"<br>"
	 var arr3 = arr.filter(function(score){return score>=60})
	  div.innerHTML+="60점 이상:"+arr3+"<br>"	  
</script>
</html>