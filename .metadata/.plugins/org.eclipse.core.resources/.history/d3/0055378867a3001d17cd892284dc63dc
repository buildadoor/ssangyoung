<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<fmt:requestEncoding value="utf-8"/>     
<!DOCTYPE html>
<%--
2023-02-02
[1단계:개념] 1. 양방향 디렉티브의 기본처리형식을 기술하세요.
입력요소객체 v-model="모델명1"
	ex) <input v-model="name"/>	
	{{모델명1}}
	<h2 v-text="모델명1"></h2>
	<h2 v-html="모델명2"></h2>
	ex)
	<h2>{{name}}</h2>
	<h2 v-text="name"></h2>
	<h2 v-html="name"></h2>
	
[1단계:확인] 2. 양방향 디렉티브를 활용하여 타석과 안타를 입력하여 타율이 출력되게 하세요
	$(document).ready(function(){
		var vm = new Vue({
			el:".container",
			data:{msg:"230202", hit:0,bat:0}
		});	
	});
</script>
</head>
<body>
<div class="container">
	<div class="jumbotron text-center">
	  <h2 >{{msg}}</h2>
	  <h3>타율:{{Number(hit)/Number(bat)}}</h3>
	</div>
  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  		<input v-model="bat" class="form-control mr-sm-2" placeholder="타석" />
	    <input v-model="hit" class="form-control mr-sm-2" placeholder="안타" />
 	</nav>

[2단계:확인] 3. 양방향 디렉티브를 활용하여 임의의 구구단 문제의 정답을 입력했을 때, 정답인지 여부를 출력되게 하세요
               5 X 7 = [정답입력]  정답/오답
               <body>
    <div id="root">
        <div> {{firstNum}} X {{secondNum}} = </div>
        <form v-on:submit="onSubmitForm">
            <input type="number" ref="answer" v-model="value" /> <!-- v-model => vue와 html 바인딩!! data value를 input 과 연결 -->
            <button type="submit">정답입력</button>
        </form>
        <div id="result">{{result}}</div>
    </div>
</body>
    <script>
        const app = new Vue({
           el: '#root',
           data: {
               firstNum: Math.ceil(Math.random() * 9),
               secondNum:Math.ceil(Math.random() * 9),
               value:'',
               result:'',
           },
           methods:{
               onSubmitForm(e){
                   e.preventDefault(); 
                   if(this.firstNum * this.secondNum === parseInt(this.value)){
                       this.result = '정답';
                       this.firstNum = Math.ceil(Math.random() * 9);
                       this.secondNum = Math.ceil(Math.random() * 9);
                       this.value = '';
                       this.$refs.answer.focus();
                   } else {
                       this.result = '오답';
                       this.value = '';
                       this.$refs.answer.focus(); 
                   }
               },
           },
        });
[1단계:확인] 4. v-if 조건문을 활용하여 입력한 아이디와 패스워드가 맞으면 로그인성공/로그인실패/아이디와패스워드를 입력하세요로
               구분하여 출력하세요.
[1단계:개념] 5. v-if와 v-show의 차이점을 기술하세요.
v-show 는, 말 그대로 이미 화면에 그려놓고
상황에 따라서 display:none, display:block 사용
미리 화면에 렌더링 해두었기 때문에, 
보여주고 숨기는 동작이 반복되는 경우에 효율적이다. 
[1단계:확인] 6. v-for의 객체단위 사용을 이용하여 모델명으로 컴퓨터(com01), 모델객체로 제조사, 가격, CPU사양으로 속성으로 설정하여
               테이블에 속성 : 속성값 형식으로 출력하세요.
      $(document).ready(function(){
		var vm = new Vue({
			el:".container",
			data:{msg:"반복문 처리",com01:{company:"삼성",price:2000000,cpu:"i5"}         
               
      <div class="jumbotron text-center">
	  <h2 >{{msg}}</h2>
	  <h3 v-for="(val,prop) in com01">{{prop}} :{{val}}</h3>
	</div>
[1단계:확인] 7. v-for와 단일형태 배열 데이터(2호선 지역철역명)을 선언하고, ol의 리스트로 출력하세요.
		 	$(document).ready(function(){
		var vm = new Vue({
			el:".container",
			data:{msg:"230202"},
		subways:["당산","합정","홍대입구"]
		
	<div class="jumbotron text-center">
	  <h2 >{{msg}}</h2>
		  <h3  v-for="(subway, idx) in subways">{{idx+1}} ) {{subway}}</h3>
	</div>
[1단계:확인] 8. v-for와 객체형 배열데이터(프리미어리그팀-팀명,승,무,패,승점)을 선언하고, 테이블로 출력하세요.
 	$(document).ready(function(){
		var vm = new Vue({
			el:".container",
			data:{msg:"230202"},
				teamList:[
					{tname:"팀1", win:7,draw:1,lose:3,score:35},
					{tname:"팀2", win:4,draw:2,lose:1,score:15},
					{tname:"팀3", win:5,draw:4,lose:0,score:52},
				]
			}
		});	
 
    <table class="table table-hover table-striped">
    <thead>
      <tr class="table-success text-center">
        <th>팀명</th>
        <th>승</th>
        <th>무</th>
        <th>패</th>
        <th>승점</th>
      </tr>
    </thead>
    <tbody>
		<tr v-for="(team, idx) in teamList">
			<td>{{team.tname}}</td>
			<td>{{team.win}}</td>
			<td>{{team.draw}}</td>
			<td>{{team.lose}}</td>
			<td>{{team.score}}</td></tr>
    </tbody>
 --%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css" >
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css" >
<style>
   td{text-align:center;}
</style>
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api" type="text/javascript"></script>
<script type="text/javascript">
   $(document).ready(function(){
      <%-- 
      
      --%>
   
</script>
</head>

<body>
<div class="jumbotron text-center">
  <h2>과제</h2>
  <%--
  <h2 data-toggle="modal" data-target="#exampleModalCenter">
   --%>
</div>
<div class="container">
   
   	<h2>부서번호(autowiring처리)</h2>
    <table id="deptInfo" class="table table-hover table-striped">
      <col width="33%">
      <col width="33%">
      <col width="33%">
     <thead>
      <tr class="table-success text-center">
        <th>부서번호</th>
        <th>부서명</th>
        <th>부서위치</th>
      </tr>
    </thead>   
    <tbody>
		<td>${dept.deptno}</td><td>${dept.dname}</td><td>${dept.loc}</td>
    </tbody>
   </table>   
   
   
   
   
   <h2>회원리스트조회(ajax)</h2>
   <form id="frm02" class="form-inline"  method="post">
     <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
       <input class="form-control mr-sm-2 sch" placeholder="회원명" name="name"/>
       <input class="form-control mr-sm-2 sch" placeholder="회원권한" name="auth" />
    </nav>
   </form>
   
   
   
   
   
   
   
   
   <table id="memList" class="table table-hover table-striped">
      <col width="25%">
      <col width="25%">
      <col width="25%">
      <col width="25%">
     <thead>
    
      <tr class="table-success text-center">
        <th>아이디</th>
        <th>이름</th>
        <th>포인트</th>
        <th>권한</th>
      </tr>
    </thead>   
    <tbody>
    </tbody>
   </table>   
   
   

   <h2>물건명 처리</h2>
   <form id="frm01" class="form-inline"  method="post">
     <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
       <input class="form-control mr-sm-2 sch" placeholder="가격입력" name="price"/>
       <input class="form-control mr-sm-2 sch" placeholder="갯수입력" name="cnt" />
    </nav>
   </form>
  
    
</div>

</body>
</html>