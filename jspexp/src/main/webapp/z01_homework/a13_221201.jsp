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
--%>
<style>iframe{border:1px solid blue;}</style>
<h2>프레임포함</h2>
이름:<input type="text" name="name">
<input type="button" value="팀1에 등록" onclick="go(0)">
<input type="button" value="팀2에 전송" onclick="go(1)"><br>

<iframe name="frame01" src="z13_sub.jsp" 
width="48%" 
height="50%"></iframe>

<iframe name="frame02" src="z14_sub.jsp" 
width="48%" 
height="50%"></iframe>
</body>

<script type="text/javascript">
/*
2022-12-01
[1단계:개념] 1. 날짜객체(Date)의 기능메서드(년/월/일, 요일, 시간/분,초)를 기술하세요
1. 날짜와 시간을 표시하는 객체
2. 생성
	1) 현재날짜
	var 변수명 = new Date()
	2) 특정날짜
	Date("영문명 날짜")
	Date("영문명 날짜, 년도")
	Date("영문명 날짜, 년도, 시:분,초")
	Date("년도, 월index, 날짜")
	//요일 월/화/수/목/금/토/일 0~6
	//월(month) JAN/FEB/MAR... 0~11
	Date(년도, 월index, 날짜)
	Date(년도, 월index, 날짜,시,분,초)
	Date(년도, 월index, 날짜,시,분,초,1/1000초)
2. 기능 메서드
	1) toXXXString()
	   toLocaleString() : 해당 국가별 날짜/시간형식으로 출력
	2) setXXX(입력값): 저장처리 메서드
	3) getXXX(): 저장내용 가져오는 메서드
[1단계:확인] 2. 현재날짜로 부터 2000시간 이후의 년도, 월, 일, 시간:분 형식으로 출력하세요.
var toDay = new Date()
sh.innerHTML += "2번 오늘로 부터 2000시간 이후"+toDay.toLocaleString()+"<br>"
sh.innerHTML+=shw

[1단계:확인] 3. 기념일 계산 : 기준 년 [    ] 월[    ] 일[     ] 계산할 일수 : [select 100/500/1000] 이후 ==> 선택했을 때, 해당 날짜를 출력


[3단계:확인] 3. 기념일 계산 : 기준일 [    ] 계산할 일수 : [    ] [이전][이후]  기준일(type="date")은 default로 오늘 날짜가 년-월-일로 입력되고, 해당날짜를 입력 후, 버튼 클릭시, 기념을 계산할 날짜가 하단에 출력되게 하세요.

[1단계:개념] 4. 날짜의 기능메서드(년/월/일, 요일, 시간/분,초)를 기술하세요
=1번
[1단계:개념] 5. 전체 날짜 시간 기능메서드(형식 따른 내용) 기술하세요.
형식: toXXXXString()
Date, Time, GMT, ISO, UTC, JSON, Locale, LocaleDate, LocaleTime
	
[1단계:개념] 6. include 액션태그와 include 지시자와 기능적인 차이점을 기술하세요.
*/<!--include지시자 : 원래 페이지 안으로 include 지시어로 지정한 페이지의 소스가 그대로 복사 된다. 
<jsp:include> 액션태그 : 소스 코드가 복사되는 것이 아니라 제어권 자체가 include 액션으로 지정된 페이지로 넘어갔다가 다시 원래 페이지로 돌아온다. 
 지시자 include는 주로 조각난 코드를 삽입하고자 할 때 사용된다.
 요청한 소스코드를 텍스트를 포함해서 하나로 인식해서 컴파일한다.
 한번만 컴파일 
 include 액션 태그를 만나면 해당 페이지로 실행 제어가 넘어가서 포함되는 페이지를 실행시킨다
 해당 페이지의 실행이 종료되면 원래 페이지로 복귀하며 최종적으로 클라이언트에게 보여지게된다
-->/*
[1단계:확인] 7. include 액션태그를 활용하여 하위페이지 z21_sub.jsp에 월드컵 B조별리그 1위 팀명과 승점을 전송해보세요
*/
<%--
<div style="border:1px solid indigo">
	<%@ include file="z21_sub.jsp" %>
</div>
<h2>선언된 변수 호출</h2>
<h3><%=nation %></h3>
<h3><%=score %></h3>
--%>
/*
[1단계:확인] 8. include 지시자를 활용하여 메인헤서 최고 득점 선수 정보(국가, 이름, 점수) 정보를 form으로 입력하게 하고 하위페이지 z22_sub.jsp에서 요청값을 처리하고, 다시 메인에서 입력된 요청변수를 출력하게 하세요


[1단계:확인] 9. 2개 iframe을 활용하여 이름을 입력하게 하고 선택하게 하여 2개 팀에 선수를 나누어 출력하게 하세요.
??
[2단계:확인] 9. select[장바구니1/장바구니2]로 선택하게 하고 3X3 과일명을 리스트하고, 해당 과일명을 클릭시마다 포함된 장바구니1(iframe), 장바구니2(iframe)에 포함되게 하세요.
 */
 
 function go(idx){
	   //var fr=document.querySelectorAll("iframe")
	   //alert(fr)
	   //frame, href에서 호출되는 객체는 BOM(browser object medel)
	   //DOM객체의 상위 객체로 bom명.document.querySelector("포함된 객체 접근")  //dom의 상위객체임
	   var nameVal = document.querySelector("[name=name]").value
	   if(idx==0) frame01.document.body.innerHTML+=nameVal
	   if(idx==1) frame02.document.body.innerHTML+=nameVal

	}

</script>
</html>