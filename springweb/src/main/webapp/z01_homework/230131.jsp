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
2023-01-31
[1단계:개념] 1. 부트스트랩의 모달창 로딩 방식을 예제를 통해 기술하세요 
if(proc=="ins" || proc=="upt" || proc=="schOne" ){
			// 요청값으로 단일 검색을 받았을 때, 모달창 로딩
			$("#modal01").click();
			// 1. 모달창 로딩 방법
			// 		1) 모달창 로딩을 위한 클릭 요소객체(버튼 등)
			//      2) 모달창 로딩
<p id="modal01" data-toggle="modal" data-target="#exampleModalCenter" ></p>
-[1단계:확인] 2. 사원 아이디로 사원 정보를 json데이터로 로딩을 위한 DB및 controller단 get방식 처리를 하세요
			DB 및 controller단 get방식 처리를 하세요
			1) sql
			2) vo확인
			3) mybatis공통 vo
			4) dao
			5) mapper
			6) service
			===========
			7) controller
			
//memberMyAjax.do?id=himan
	//http://localhost:7080/springweb/memberMyAjax.do?id=himan
	@GetMapping("/memberMyAjax.do")
	public String memberMyAjax(@RequestParam("id") String id, Model d) {
		d.addAttribute("mem",service.getMember(id));
		
		return "pageJsonReport";
	}
}

-[1단계:확인] 3. salgrade 테이블을 ajax로 로딩된 데이터를 출력하고, 행별 등급을 클릭시, 등급상세화면이 ajax로 로딩되게 처리하세요.
sql
	select * from salgrade
	select * from salgrade where grade = #{grade}
	 
vo Salgrade
공통my salgrade, salMapper.xml
dao 
	public List<Salgrade> getSalList();
 	public Salgrade getSalgrade(int grade);
mapper
		<select id="getSalList" resultType="salgrade">
	select * from salgrade
	</select>
	 <select id="getSalgrade" parameterType="int"
	 resultType="salgrade">
	select * from salgrade where grade = #{grade}
	</select>
sql 
	select * from salgrade where grade=1
dao 
	public salgrade getSalgrade(int grade);
service
controller 
		/salgradeInit.do
		/salgradeList.do
		/salgrade.do
view 
		a05_salgradeList.jsp
		
		function search(){
		$.ajax({
			url:"${path}/salgradeList.do",
			type:"post",
			dataType:"json",
			success:function(data){
				var slist = data.slist
				console.log(slist)
				var show=""
				$(slist).each(function(idx, sal){
					show+="<tr ondblclick='goPage("+sal.grade+")'>"
					show+="<td>"+sal.grade+"</td>"
					show+="<td>"+sal.hisal+"</td>"
					show+="<td>"+sal.losal+"</td>"
					show+="</tr>"
				})
				$("table tbody").html(show)
			}
		})
	} 
	function goPage(grade){
		$("#modal01").click()
		$.ajax({
			url:"${path}/salgrade.do",
			type:"get",
			data:"grade="+grade,
			dataType:"json",
			success:function(data){
				var sal = data.sal
				console.log(sal)
				$("#frm02 [name=grade]").val(sal.grade);
				$("#frm02 [name=hisal]").val(sal.hisal);
				$("#frm02 [name=losal]").val(sal.losal);
			}
		})		
	}		


-[1단계:확인] 4. 부서 상세화면에서 ajax로 부서정보를 수정/삭제 처리하세요.
	1) DB처리 
	sql	
			update dept100
				set dname=#{dname},
					loc=#{loc}
				where deptno=#{deptno}
				
			delete 
			from dept100
			where deptno=#{deptno}
			
			
	vo dept
	공통mybatis dept
	dao
		public void updateDept(Dept upt);
		public void deleteDept(int deptno);
		
	service

	controller	
		/updateDept.do
		/deleteDept.do
	
		
	2) 화면구현 
		다이얼로그 화면에
			수정 
			삭제버튼 추가
		$("#uptBtn").click(function(){
			//유효성 check 
			$.ajax({
				url:"#{path}/updateDept.do",
				type:"get",
				data:$("#frm02").serialize(),
				dataType:"json",
				success:function(data){
					var dept = data.dept
					if(dept!=null){
						alert("수정완료");
					}
					// 리스트 데이터 update
					var dlist = data.dlist
				}
				
			})
		})
		$("delBtn").click(function(){
			$.ajax({
				url:"#{path}/deleteDept.do",
				type:"get",
				data:$("#frm02").serialize(),
				dataType:"json",
				success:function(data){
						alert("삭제완료");
					// 리스트 데이터 update
					var dlist = data.dlist
				}
			})
		})


[1단계:개념] 5. vue의 개발환경을 위한 설정 방법을 기술하세요.
// 1. 모델데이터
		var model = {msg:"Vue 시작"}
		// 3. view model : view와 model을 연결
		var vm = new Vue({
			el:"#simple", //vue를 적용할 요소객체 최상위 범위 
			data:model	  //모델 데이터 
			
[1단계:확인] 6. vue의 MVVM패턴을 이용하여 모델로 선언한 name, age, loc를 통해서 화면에 이름 나이 사는 곳에 출력되게하세요.

 
 
 
 
 
 

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
	// 2. 모델 
	var model = {name:"홍길동", age:25, loc:"서울"}
	// 3. 뷰모델
	var vm = new Vue({
		el:"#show", //view범위 선언,
		data:model //모델데이터 선언
		
	
		})
	});
</script>
</head>

<body>
<!-- 1. view -->
<div  id="show" class="jumbotron text-center">
  <h2>이름:{{name}}</h2>
  <h2>나이:{{age}}</h2>
  <h2>사는곳:{{loc}}</h2>
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