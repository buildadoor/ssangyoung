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
2023-02-15
[1단계:개념] 1. 컴포넌트를 구성하는 속성과 처리 방법에 대하여 기술하세요
Vue.component("컴포넌트명",{
		template:"컴포넌트로 출력한 포함된 화면 태그",
		data:{
			function(){
					return {컴포넌트에서 사용할 모델 데이터}
			}
		},
		속성:속성값,
		mothods:{
			기능메서드:function(){
				
			}
		}
	})
[1단계:확인] 2. com01 컴포넌트를 통해 속성값(부서번호,부서명,부서위치)을 전달하여 부서정보를 출력하세요.
<template id="tmp01">
   <div>
      <h2>부서번호 {{deptno}}</h2>
      <h2>부서명{{dname}}</h2>
      <h2>부서위치{{loc}}</h2>
   </div>
</template>
<script type="text/javascript">
   
   Vue.component("com01",{
      template:"#tmp01",
      props:["dname","deptno","loc"]
   })
   $(document).ready(function(){
      var vm = new Vue({
         el:".container",
         data:{msg:"230215"}
      });   
   });
</script>
</head>
<body>

<div class="container">
   <div class="jumbotron text-center">
     <h2 >{{msg}}</h2>
     <com01></com01>
     <com01 deptno="10" dname="재무" loc="LA"></com02>
   </div>
[1단계:확인] 3. com02 컴포넌트를 통해 속성값(배열형데이터)을 전달하여 리그명과 팀순위를 출력하세요.(컴포넌트3개호출)
<template id="tmp02">
   <h2>{{league}}</h2>
   <table class="table table-hover table-striped">
   <tr class="table-success text-center">
   <th>순위</th><th>팀명</th><th>승점</th></tr>
   <tbody>
   <tr v-for="(t,idx) in teams">
   <td>{{idx+1}}</td><td>{{t.tname}}</td><td>{{t.score}}</td></tr></tbody></table>
</template>
Vue.component("com02",{
   template:"#tmp02",
   props:{
      league:{type:string},
      teams:{type:Array}
   }
})
data:{msg:"시작!!(뷰와함께)",avgAll:0,finAvg:0,
      tlist:[
         {tname:'아스널',score:51},
         {tname:'맨시티',score:48},
         {tname:'맨유',score:46}
      ]
<com02 league:="프리미어리그" :teams="tlist"></com02>
[1단계:개념] 4. 컴포넌트의 하위계층에서 상위계층으로 이벤트 핸들러 처리 프로세스를 설명하세요.
컴포넌트 메서드 선언
      이벤트핸들러1: function(){
         this.$emit("상위에서 선언 이벤트명",전달할 데이터1,전달할 데이터2...)
      }
      <하위컴포넌트 @이벤트="이벤트핸들러1"
      
      <상위컴포넌트 @상위에서 선언 이벤트명 = "상위 선언 이벤트 핸들러"
      
      methods:상위 선언 이벤트 핸들러(하위에서 전달한 데이터받은 변수1, 변수2){}
[1단계:확인] 5. 입력된 학생한명당 국어/영어/수학점수를 컴포넌트를 반 전체 평균을 출력하세요.
 
 
 
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
	});
</script>
</head>

<body>
<div class="jumbotron text-center">
  <h2 data-toggle="modal" data-target="#exampleModalCenter">타이틀</h2>

</div>
<div class="container">
	<form id="frm01" class="form-inline"  method="post">
  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <input class="form-control mr-sm-2" placeholder="제목" />
	    <input class="form-control mr-sm-2" placeholder="내용" />
	    <button class="btn btn-info" type="submit">Search</button>
 	</nav>
	</form>
   <table class="table table-hover table-striped">
   	<col width="10%">
   	<col width="50%">
   	<col width="15%">
   	<col width="15%">
   	<col width="10%">
    <thead>
    
      <tr class="table-success text-center">
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회</th>
      </tr>
    </thead>	
    <tbody>
    	<tr><td></td><td></td><td></td><td></td><td></td></tr>
    	<tr><td></td><td></td><td></td><td></td><td></td></tr>
    	<tr><td></td><td></td><td></td><td></td><td></td></tr>
    </tbody>
	</table>    
    
</div>
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">타이틀</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
		<form id="frm02" class="form"  method="post">
	     <div class="row">
	      <div class="col">
	        <input type="text" class="form-control" placeholder="사원명 입력" name="ename">
	      </div>
	      <div class="col">
	        <input type="text" class="form-control" placeholder="직책명 입력" name="job">
	      </div>
	     </div>
	    </form> 
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
</body>
</html>