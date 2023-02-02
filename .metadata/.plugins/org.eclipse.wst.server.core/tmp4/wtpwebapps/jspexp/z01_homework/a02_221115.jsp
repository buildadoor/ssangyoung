<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="jspexp.vo.*"
    import="java.util.*"
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
 2022-11-14
[1단계:개념] 1. jsp를 이용하여 객체형 배열을 처리할려고 한다. 처리하는 순서를 기술하세요.
- 구조 만들기/ import 처리
- 리스트로 데이터 넣기
- 반복문 처리하기 
[1단계:확인] 2. Computer 클래스에 제조사, 가격, 종류 속성을 선언하고, jsp 화면에 테이블로 리스트를 출력하세요.
*/
<%
List<Computer> clist = new ArrayList<Computer>();
clist.add(new Computer("삼성",1500000,"데스크탑"));
clist.add(new Computer("애플",1800000,"노트북"));

	for(int idx=0;idx<clist.size();idx++){
		Computer c = clist.get(idx);
		log(c.getCompany()+":"+c.getPrice()+":"+c.getType());
	}
%>
/*
[1단계:개념] 3. jsp에서 DB처리를 위해 필요한 설정을 기술하세요.
1. 새 프로젝트 생성 후 경로 설정
1)  Build Path
① Build Path > configure build path
② Classpath > Add External JARs.. 클릭 
③ connector J. jar 파일 선택
④ Apply and Close
2) 'WEB-INF > lib'에 connector J. jar 파일 붙여넣기

2. DB 연동
※ JDBC
 1) low level 코딩 
   - dbdemo.jsp 생성
   ① Driver Loading
   ② MySQL Connection
   ③ Statement 객체 생성
   ④ SQL 문 실행하기
   ⑤ ResultSet 처리하기
   ⑥ Close
   ⑦ 결과 출력
*/

/*
 	1) jdbc드라버를 설정(웹프로그래밍단위)
 		\webaoo\WEP-INF\lib
 	2) dao를 위한 설정처리(ip,port,sid,계정,비번)
 		연결부분확인
 	3) dao을 기능 메서드 구현 
 	4) jsp에서 해당 dao import, vo import 
 		
		
 	*/
/*
 
[1단계:확인] 4. dao에 부서정보를 찾아서, jsp로 부서정보를 출력하세요.
	1) 부서정보 기능메서드 확인
	2) jsp import 확인
	3) dao객체 생성 
	4) 반복문을 통해서 출력화면 
	5) script(scriplet, expression)을 통해서 table형식으로 출력처리 
//import jspexp.vo.* 삭제 처리..
	*/

/*

[1단계:확인] 5. dao에 회원정보리스트 처리 기능메서드를 추가하고 jsp로 회원정보리스트를 출력하세요.
1.dao 기능 메서드 처리 순서 
	1)sql확인
	2)vo추가
	3)기능메서드추가
	4)dao호출
	5)for script
*/

/*
 
[1단계:개념] 6. js의 함수의 기본형식을 기술하고 매개변수로 밑면과 높이를 전달하고, 삼각형의 면적으로 리턴값을 alert() 출력되게 처리해보세요.
1. 함수는 기능 처리를 위한 코드의 집합체라고 할 수 있다.
2. 기본형식
   function 함수명(매개변수,...){
     프로세스 처리
     
     return 리턴값;
*/
/*
 
[1단계:개념] 7. 이벤트와 이벤트핸들러 함수와의 관계를 실제 이벤트 처리 코드를 기준으로 설명하세요.
1. js에서는 속성으로 on이벤트명="이벤트핸들러"를 통해서
해당 이벤트가 발생했을 때, 처리할 코드를 특정한 함수를 통해서 정의한 내용을 수행할 수 있다.
2. 처리 순서
	1) 이벤트 핸들러 함수 선언 : 이벤트를 통해서 처리할 내용 함수 선언
	2) 이벤트 속성 선언 및 이벤트 핸들러 함수 호출
		태그 on이벤트명="이벤트 핸들러 함수()"
   3) 이벤트 핸들러에 매개변수 전달 
   	함수에 매개변수를 선언하여 문자열, 숫자 데이터를 전달할 수 있다.
*/
/*

[1단계:확인] 8. 학생의 이름 정보와 국어,영어,수학점수를 입력 후, 클릭시, 총점과 평균이 출력되게 하세요.
?
*/
function calcu(){
	var stname = document.querySelector("[name=pname]").value;
	var kor = document.querySelector("[name=kor]").value;
	var eng = document.querySelector("[name=eng]").value;
	var math = document.querySelector("[name=math]").value;
	//+ 연산자 이외는 자동형변환이 적용되어 Number()을 사용하지 않더라도 연산이 된디.
	var plus = kor+eng+math;
	document.querySelector("h4").innerText=pname+", 총점:"+plus
	var avg = (kor+eng+math);
	document.querySelector("h5").innerText=pname+", 평균:"+avg
	}
	
/*

[1단계:확인] 9. 1~9까지 번호가 있는 3X3테이블을 만들고 해당 td를 클릭시 마다, 클릭한 td만 배경색상과 글자 색상이 변경되게 처리하세요.

*/
function callObj(obj){
	obj.align="center";
	obj.style.color="blue";//css속성변경
	obj.style.background="aliceblue";
	
}
/*
 
[3단계:확인] 10. 좋아요버튼과 싫어요 버튼 만들고, 좋아요 버튼을 누를 때 마다 
                  하단에 ♥가 증가되고, 싫어요 버튼을 누를 때 마다♡ 증가 되게 처리해보세요 
*/
function addlike(obj){
	document.querySelector("#likelist").innerText+=obj.innerText+"♥";
}
function addhate(obj){
	document.querySelector("#hatelist").innerText+=obj.innerText+"♡";
}
</script>

</head>
<body>
<%-->
<%
A06_PareparedDao dao = new A06_PareparedDao();
%>

<h2>부서정보</h2>
<table>
	<tr><th>부서번호</th><th>부서명</th><th>부서위치</th></tr>
	<%for(Dept d:dao.getDeptList(new Dept("",""))){%>
	<tr><th><%=d.getDeptno()%></th><th><%=d.getDname() %></th><th><%=d.getLoc() %></th></tr>
	<%}%>
</table>

<hr>
    <%
    List<Dept> dlist = new ArrayList<Dept>();
    dlist.add(new Dept(00001,"마케팅","천안"));
    dlist.add(new Dept(00002,"재무","부산"));
    dlist.add(new Dept(00003,"인사","울산"));
  
 
 
  	for(int idx=0;idx<dlist.size();idx++){
  		Dept d = dlist.get(idx);
  		log(d.getDeptno()+":"+d.getDname()+":"+d.getLoc());
  	}
    %>
   <table width=300px border>
	<tr><th>부서번호</th><th>부서명</th><th>지역</th></tr>
	<%for(Dept d:dlist){%>
	<tr><td><%=d.getDeptno()%></td><td><%=d.getDname()%></td><td><%=d.getLoc()%></td></tr>
	<%}%>
	 <hr>
    <%
    List<Customer> culist = new ArrayList<Customer>();
    culist.add(new Customer("이길동",51,"서울"));
    culist.add(new Customer("송길동",41,"대전"));
    culist.add(new Customer("남궁길동",31,"대구"));
 
 
  	for(int idx=0;idx<culist.size();idx++){
  		Customer cu = culist.get(idx);
  		log(cu.getName()+":"+cu.getAge()+":"+cu.getLoc());
  	}
    %>
     --%>
     
     
<hr>
   <table width=300px border>

	<tr><th>회원명</th><th>나이</th><th>지역</th></tr>
	<%for(Customer cu:culist){%>
	<tr><td><%=cu.getName()%></td><td><%=cu.getAge()%></td><td><%=cu.getLoc()%></td></tr>
	<%}%>
	
<hr>
	학생이름:<input type="text" name="stname"/>
	국어점수:<input type="text" name="kor"/>
	영어점수:<input type="text" name="eng"/>
	수학점수:<input type="text" name="math"/>
	<input type="button" value="계산" onclick="calcu()"/>
	<h4>총점</h4>
	<h5>평균</h5>
	
	<hr>
<table width=300px border>
	<tr><th>제조사</th><th>가격</th><th>종류</th></tr>
	<%for(Computer c:clist){%>
	<tr><td><%=c.getCompany()%></td>
	<td><%=c.getPrice()%></td>
	<td><%=c.getType()%></td></tr>
	<%}%>
</table>
<hr>
표 클릭!
<table>
	<tr>
		<td onclick=callObj(this)>1</td><td onclick=callObj(this)>2</td><td onclick=callObj(this)>3</td>
	</tr>
	<tr>
		<td onclick=callObj(this)>4</td><td onclick=callObj(this)>5</td><td onclick=callObj(this)>6</td>
	</tr>
	<tr>
	<td onclick=callObj(this)>7</td><td onclick=callObj(this)>8</td><td onclick=callObj(this)>9</td>
	</tr>
</table>
	
</body>
<hr>
<h3 id="likelist">좋아요</h3>
<h3 id="hatelist">싫어요</h3>
	
<input type="button" onclick="addlike(this)" value="좋아요">
<input type="button" onclick="addhate(this)" value="싫어요">
	
	
<script type="text/javascript">
/*
 
*/
</script>
</html>