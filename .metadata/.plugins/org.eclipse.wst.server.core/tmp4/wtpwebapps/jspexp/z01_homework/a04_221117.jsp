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
<script>
/*
 
 */ function callObj(obj){
		location.href="z02_show.jsp";}
</script>
</head>
<body>
<%-- 
2022-11-17
[1단계:개념] 1. [jsp] 문자열과 숫자형 요청값을 처리시 default 설정 처리내용을 기술하세요.

# 문자형 데이터 요청값 처리
1. 요청값
 ?name=사과&price=3000&cnt=2
2. 변수를 지정해서 할당하면 기본 문자열로 할당이 된다.
# 요청값이 없을 때, default 데이터를 위한 처리
1. if조건을 통해서 null인 경우 
   1) 문자열 ==> ""
   2) 숫자 ==> 0

# 숫자형 데이터 요청값 처리
1. default 변수 선언.
   int num01=0;
2. 요청값 설정
   String num01S = request.getParameter("num01);
3. 해당 요청데이터가 있을 때, 형변환 처리.
   if(num01S!=null) num01 = Integer.parseInt(num01S);
* 함수형 처리(기능메서드 선언 처리)
int chInt(String req){
   int num =0;
   if(req!=null) num = Integer.parseInt(req);
   return num;
}


[1단계:확인] 2. [jsp] dao에 회원정보리스트를 검색하는 기능메서드(조회 조건 추가)를 만들고, 출력처리 하세요..


[1단계:확인] 3. [jsp] 아래의 sql 활용하여  dao기능메서드를 추가하고 검색리스트를 출력하세요.
               SELECT * 
               FROM salgrade
               WHERE grade BETWEEN 1 AND 5;

               등급 시작 [   ]
               등급 끝 [   ]   [검색]
               검색된 리스트
--%>
<% 
String low=request.getParameter("low");      if(low==null) low="0";
String hi=request.getParameter("hi");      if(hi==null) hi="9999";
int lowsalInt = Integer.parseInt(low);
int hisalInt = Integer.parseInt(hi);
A04_salgrade SDao = new A04_salgrade();
SalGrade sch3 = new SalGrade(lowsalInt, hisalInt);
%>
<form>
   <table>
      <tr><th>최저등급</th><td colspan="2"><input type="text" name="low" value="<%=low %>"/></td></tr>
      <tr><th>최고등급</th><td colspan="2"><input type="text" name="hi" value="<%=hi %>"/></td></tr>
      <tr><td colspan="3"><input type="submit" value="검색"/></td></tr>
   </table>
</form>

<table>
         <tr><th>등급</th><th>최저연봉</th><th>최고연봉</th></tr>
         <%
         for(SalGrade s:SDao.getGradeSch(sch3)){
         %>
         <tr>
            <td><%=s.getGrade() %></td>
            <td><%=s.getLowsal() %></td>
            <td><%=s.getHisal() %></td>
         </tr>
         <%} %>
      </table>
<%-- 
[1단계:확인] 4. [js] h1 클릭하세요를 클릭시,  z02_show.jsp로 이동되게 함수를 선언하고 js의 페이지 이동 기능 객체를 활용하여 처리하세요
--%>
	<h1 onclick="callObj(this)">4번 문제입니다.<br> 클릭하시면 z02_show.jsp페이지로 이동됩니다!</h1>
	
<%-- [1단계:확인] 5. [jsp==>js] jsp변수로 이름, 나이, 성인여부(나이가 20이상 ) 스크립트릿(<%%>)에 선언하고, 
               js에서 이를 할당하여 alert()으로 출력되게 하세요.
--%>
               
<%-- 
[1단계:확인] 6. [jsp] 기존 사원정보 조회리스트 기준으로 사원정보 등록으로 화면 이동 및 등록 처리 후, 리스트 화면으로 이동 되게 기능처리하세요.
--%>
               
<%-- 
[1단계:확인] 7. [js] let변수와 var의 차이점을 10~100까지 5씩 증가하는 for문의 합산값을 통해서 확인하세요.
--%>
               
<%-- 
[1단계:확인] 8. [js] 객체와 for in 구문의 관계를 음악정보(음악명,가수명,발매연도)를 통해 선언하고 출력하세요.
--%>
               
<%-- 
[1단계:확인] 9. [js] 배열과 for of 구문을 통해서 프리미어리그 순위 리스트를 테이블로 출력해보세요.
--%><table id="table"></table>
</body>
<script>
/*

 */
//7. [js] let변수와 var의 차이점을 10~100까지 5씩 증가하는 for문의 합산값을 통해서 확인하세요.
 var body = document.body
  var tot2 = 0 //전역변수

 for (var cnt2=10;cnt2<=100;cnt2++){ //지역변수
	 
 	script.innerHTML +=cnt2+"," 
 	tot2+=cnt2 //지역변수를 전역변수에 할당
 }
 body.innerHTML += "var으로 전역변수 호출tot2:"+tot2+"<br>"
 body.innerHTML += "var으로 지역변수 호출cnt2:"+cnt2+"<br>"
 //8번
 var music = {song:"새삥", singer:"지코", year:2022}
var body = document.body
for (let mus in music){
	body.innerHTML+=mus+":"+music[pro]+"<br>"

}
 //9번
 let league = ["아스널","맨시티","뉴캐슬","토트넘","맨유","리버풀","브라이튼","첼시"]
 var show = document.querySelector("#table")
 for (const pl of league){ 
	 table.innerHTML += "<h2>"+league+"</h2>"
 }
 
 
</script>
</html>