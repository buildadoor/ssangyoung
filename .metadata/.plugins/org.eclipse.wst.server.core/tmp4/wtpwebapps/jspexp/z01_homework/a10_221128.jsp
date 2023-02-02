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

2022-11-28
[1단계:개념] 1. [jsp] 세션 scope의 첫단계 객체 pageContext 는 어디까지 데이터가 유지 되는 것인가?<hr>
 <h4>하나의 페이지를 처리할 때 사용하는 영역 즉, 해당페이지를 벗어나면 데이터가 삭제됨</h4> <hr>

[1단계:확인] 2. [jsp] 물건가격과 갯수를 pageContext로 저장하고, 저장된 내용을 출력하되, 총계까지 출력하세요.<hr>
<%
pageContext.setAttribute("product", new Product("키보드",85000,2)); 
%>
<%
Product product = (Product)pageContext.getAttribute("product");
%>
 <h4>물건명:<%=product.getProduct()%></h4>
 <h4>가격:<%=product.getPrice()%></h4>
 <h4>갯수:<%=product.getCnt()%></h4>
 <h4>총계:<%=product.getCnt()*product.getPrice()%></h4><hr>
 
[1단계:확인] 3. [jsp] Dept정보를 pageContext범위로 저장하고 호출하세요.<hr>

<%
pageContext.setAttribute("dept", new Dept(1001,"회계","서울")); 
%>
<%
Dept dept = (Dept)pageContext.getAttribute("dept");
%>
 <h3>부서번호:<%=dept.getDeptno()%></h3>
 <h3>부서명:<%=dept.getDname()%></h3>
 <h3>부서위치:<%=dept.getLoc()%></h3>
[1단계:개념] 4. [jsp] application 범위를 설명하고 회원 아이디와 권한 이름을 설정하고 다른 페이지에서 호출하세요.<hr>
<%
application.setAttribute("id","아이디: ddochi");
application.setAttribute("auth","권한: 관리자");
%>
<h3><%=application.getAttribute("id") %></h3>
<h3><%=application.getAttribute("auth") %></h3>
<a href="z05_login.jsp">페이지 이동 id, 권한 확인</a><hr>
[1단계:확인] 5. [js] json형식의 객체로 월드컵의 팀명 소속조 승 무 패의 속성을 선언하고, for in 구문 테이블로 출력하세요<hr>
승 1 무 0 패 -1 <br> 

[1단계:확인] 6. [js] 월드컵의 날짜와 시간별 팀1, 팀2의 일정을 출력하는 생성자형 객체를 선언하고, 오늘 한국/가나팀 일정계획을 출력하세요.<hr>

[1단계:확인] 7. [js] 위 내용을 내일일정 기준으로 여러 경기를 배열로 추가해서 출력하게 하세요.<hr>

[1단계:확인] 8. [js] class Product에 물건명과 가격을 선언하여 생성자를 통해 초기화하고 set get 메서드를 통해서 호출하고 저장하는
            필드를 은닉하여 처리하게 하세요.<hr>



</body>
<script type="text/javascript">
<%--
var div = document.querySelector("#container")
function Team(tname, part, win, draw, lose){
	   this.tname = tname
	   this.part = part
	   this.win = win
	   this.draw = draw
	   this.lose = lose
	   this.score = function(){
	      div.innerHTML+="<h2>"+this.tname+","+this.part+" 점수:"+this.win+this.draw+this.lose+"</h2>"
	   }
	}
	div.innerHTML="<h3>카타르 승점</h3>"

	var teams = []
	teams.push(new Team("카타르","A조",0,0,2))
	teams.forEach(function(t01){
	   t01.score()
	})
	
ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	
	class Soccer{
	constuctor(name, time){
		this.name = name 
		this.time = time
	}
	getPlay(){
		return this.name+":"+this.time
	}
}
var h1 = new Soccer("한국","11월28일 22시")
var h2 = new Soccer("가나","11월28일 22시")
div.innerHTML+=h1.getPlay()+":<br>"
ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
class Soccer02{
	constuctor(name, time){
		this.name = name 
		this.time = time
	}
	get Name(){
		return this._name
	}
	get Time(){
	return this._time;
	}
	set Name(input){
	return this._width=input
	}
	set Time(input){
	return this._time=input
}
}
var t2 = new Soccer02 ("가나","오늘 22시")
t2.Name = "가나"// set width(input)호출 처리 .. _width 은닉처리
div.innerHTML+=t2.getName+":"+t2.time+"<br>"
	--%>
</script>
</html>