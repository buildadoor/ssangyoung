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
var body = document.querySelector("p")
function product(... products){
	body.innerHTML+=product01+":"+product02+":"+products+"<br>"
}
product("핸드폰")
product("핸드폰","이어폰")
product("핸드폰","이어폰","태블릿")


function login(empno="0",ename="무명",deptno="0"){
	var divObj = document.querySelector("div")
	divObj.innerHTML ="사원번호:"+empno+", 사원명:"+ename+", 부서번호:"+deptno+"<br>"
	
}
</script>
</head>
<body>

<%-- 
2022-11-21
[1단계:확인] 1. [js] 가변매개변수 arguments를 활용하여 가변적으로 구매 정보를 매개변수로 처리하여 출력하게 하세요.
--%><h3>클릭하여 선택하세요👍👍</h3>
	<h3 onclick="cafe()">미선택</h3>
	<h3 onclick="cafe('아이스 아메리카노')">아이스아메리카노</h3>
	<h3 onclick="cafe('쿠키',2500)">쿠키 2500원</h3>
	<h3 onclick="cafe('치즈케이크',6000,2)">치즈케이크,6000원,2조각</h3>
	<span></span>

<%--
[1단계:확인] 2. [js] ... 가변매개변수에 따라 등록할 물건의 이름 1/2/3개 다른 매개변수로 설정하여 하단에 p태그로 클릭시 마다 처리되게 하세요
--%>
	<p></p>	
<%--
[1단계:확인] 3. [js] default 가변매개변수를 활용하여 사원번호, 사원명, 부서번호를 클릭시 마다, 처리하는 내용을 하단에 테이블로 추가 하여 출력하세요
               login(), login(7780) login(7880,'오길동') login(8000,'이영자','인사')

--%>
<hr>
<h3 onclick="login()">사원등록 기본</h3>
	<h3 onclick="login(7780)">login(7780) </h3>
	<h3 onclick="login(7880,'오길동')">login(7880,'오길동')</h3>
	<h3 onclick="login(8000,'이영자','인사')">login(8000,'이영자','인사')</h3>
	<div></div>
<%--
[1단계:확인] 4. [js] 화살표 함수를 활용하여 사칙연산을 처리 및 출력하세요.
--%>
<hr>

<h1 onclick="this.innerText=plus(100,20)">100,20 더하기</h1>
	<h1 onclick="this.innerText=minus(100,20)">100,20 빼기</h1>
	<h1 onclick="this.innerText=multi(100,20)">100,20 곱하기</h1>
	<h1 onclick="this.innerText=div(100,20)"">100,20 나누기</h1>
<%--
[1단계:확인] 5. [js] 키오스크 메뉴판(3가지)과 동일하게 메뉴가 나오고 +/-에 따라서 갯수가 선택되게 하여
               아래에 메뉴내용과 총금액이 나오게 처리하세요.
	1) 화면구성
	2) +/-에 대한 이벤트 핸들러 함수 선언과 이벤트 처리 
	3) 메뉴내용과 총금액 처리

--%><%--
[1단계:확인] 6. [jsp] jsp에서 숫자형 데이터가 요청값이 없더라도 숫자형 데이터가 에러 나지 않게 할려고 한다.
                 아래 화면을 입력값이 없더라도 전송시 에러 발생하지 않게
                첫번째 숫자 : [   ]
                두번째 숫자 : [   ]  [합산]
               1) javascript 단 처리 부분
               2) jsp 처리 부분을 나누어서 처리하세요
--%> <%!
           int chInt(String req){
              int ret = 0;
              if(req!=null){
                 try{
                 ret = Integer.parseInt(req);
                 }catch(Exception e){
                    log("에러발생:"+e.getMessage());
                 }
              }
              return ret;
           }
           %>
          <form>
               <h2>첫번째 숫자: <input type="text" name="num01"/></h2>
               <h2>두번째 숫자: <input type="text" name="num02"/></h2>
               <input type="submit" value="합산" />
            </form>
             <% 
         int num01 = chInt(request.getParameter("num01"));
         int num02 = chInt(request.getParameter("num02"));
         int plusTot = num01+num02;
         %>
         <h3>합산: <%=plusTot %></h3><%--
[1단계:확인] 7. [jsp] script의 declare를 활용하여, 입력값이 70이상 일때, 합격 그외 불합격 처리하는 기는
            메서드를 선언하고, expression으로 호출하여 처리하세요.
--%>
<%!
String ret = "";
public String div(int plusTot){
    
      if(plusTot>70){ 
        ret = "결과 : 합격";
      } else{
         ret="결과 : 불합격";
      }
      return ret;
   }
%>


<%
String num1 = request.getParameter("num1");
String num2 = request.getParameter("num2");
int num1Int=0;
if(num1!=null  && !num1.equals("")) num1Int = Integer.parseInt(num1);
int num2Int=0;
if(num2!=null  && !num2.equals("")) num2Int = Integer.parseInt(num2);
int tot = num1Int+num2Int;
div(tot);
%>
<hr>
<h3>7번</h3>
<form>
   1과목 점수:<input type="text" name="num1">
   2과목 점수:<input type="text" name="num2">
      <input type="submit" value="합계">
   </form>
   <div>총 점수:<%=tot %></div>
   <div><%=ret %></div>
</body>
<script>


var span = document.querySelector("span")
function cafe(){
	if(arguments.length==0){
		span.innerHTML+="선택 안함<br>"
	}else{
		var add=""
	 	for(var idx in arguments){
			add += arguments[idx]+"."	
	}
	span.innerHTML+=add+"<br>"
}
}

const plus  = (num01, num02) => num01+num02
const minus  = (num01, num02) => num01-num02
const multi  = (num01, num02) => num01*num02
const div = (num01, num02) => num01/num02


</script>
</html>