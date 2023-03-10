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
2023-01-27
[1단계:개념] 1. db가 연결된 스프링 MVC패턴의 개발 순서를 기술하세요.
1. 흐름 순서
	1) url 요청값 처리
	2) controller호출
	3) 모델 데이터 처리 (dao호출 후, 데이터 설정)
	4) view 화면 호출, 모델 데이터 출력
2. 처리 순서
	1) 처리할 데이터 sql, dao 처리
	2) controller 작성 및 초기화면 로딩
	3) dao호출 및 모델 데이터 할당 
	4) 모델 데이터에 맞게 화면단 구현 
3. 실제 핵심 코드
	1) DAO 환경 구현 
[1단계:확인] 2. 회원관리 화면을 처리하세요(member테이블 활용하여 리스트)


[1단계:확인] 3. 회원관리 화면을 처리하세요(member테이블 활용하여 단일 데이터 조회)


[1단계:확인] 4. 회원관리 화면을 처리하세요(member테이블 활용하여 수정)

[1단계:확인] 5. 회원관리 화면을 처리하세요(member테이블 활용하여 삭제)s

[1단계:개념] 6. 모델어트리뷰트로 콤보박스를 사용하는 경우 처리하는 순서를 기술하세요.
# 모델어트리뷰를 통한 DB와 연결된 공통 COMBOX생성
1. select형태의 콤보형선택은 DB연결되어서 처리되는 경우가 많다.
2. controller단에서 공통으로 사용되는 key/value형식의 데이터는 ModelAttribute로 선언하여 사용한다.
3. 처리 순서
	1) sql ==> dao 기능 메서드 추가
	2) controller단 modelattribute 선언
	3) view단에서 공통 modelattribute호출
	
[1단계:확인] 7. 회원테이블(member)에 권한을 콤보박스를 사용하여 검색조건으로 추가하여 처리하세요. 
sql
	SELECT DISTINCT auth
	FROM member200

	select * from member200
	where id like '%'||#{id}||'%'
	and name like '%'||#{name}||'%'
	<if test="auth!=''">
	and auth = #{auth}
	</if>
	select * from member200
	where id = #{id}
	update member 
		set name=#{name},
			pass=#{pass},
			point=#{point},
			auth=#{auth}
		where id = #{id}
	delete member200
	where id = #{id}

vo Member
	springweb.z01_vo.Member
공통 mybatis member, MemberMapper.xml 
dao 
MemberDao

dao
public List<String> getAuthCom();
public List<Member> getMemberList(Member sch);
public Member getMember(String id);
public void uptMember(Member upt);
public void delMember(String id);

mapper 
<select id="getAuthCom" result="string">
	SELECT DISTINCT auth
		FROM member200
</select>
<select id="getMemberList" parameteType="member" result="member">
	select * from member200
	where id like '%'||#{id}||'%'
	and name like '%'||#{name}||'%'
	<if test="auth!=''">
	and auth = #{auth}
	</if>
</select>
<select id="getMember" parameteType="string">
	SELECT DISTINCT auth
		FROM member200
</select>
<update id="uptMember" parameteType="member">
select * from member200
	where id = #{id}
	update member 
		set name=#{name},
			pass=#{pass},
			point=#{point},
			auth=#{auth}
		where id = #{id}
</update>
<delete id="delMember" parameteType="string">
	member200
	where id = #{id}
</delete>


# 화면 처리(리스트화면)
1. 초기화면 호출
	controller(공통콤보, 초기리스트), model, view 
2. 화면 - 데이터
	1) form형식 처리
	2) model데이터 출력 jstl처리
# 화면 처리(수정 삭제를 위한 단일 화면)
1. 위 리스트 화면에서 클릭시, id값을 통해 요청 화면 로딩 
	controller, model(proc(schOne)), view 
2. 화면 - 데이터
	1) 단일 데이터 로딩키, 요청 id값을 기준으로 모달창 로딩 후, 
	2) model데이터 출력 jstl처리
# 데이터 변경 후, 수정 버튼 클릭시
1. 수정 처리 controller 호출
	controller, model(수정 로딩 표시 proce-upt), view	
	A03_MemberController.java
		@ModelAttribute("authCom")
		public Member getAuthCom(){
			return service.getAuthCom()
		}
		/memberListMy.do
		d.addAttribute("mlist",service.getMemberList(sch));
		..dao.단 처리 메서드 호출
	A03_MemberService.java	
2. 화면 - 데이터
	1) 수정 처리 후임을 전송
# 삭제 버튼 클릭시
1. 수정 처리 controller 호출
	controller, model(삭제 로딩 표시 proce-del), view	
2. 화면 - 
	삭제 alert띄우고, 다시 location.href
	

 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<fmt:requestEncoding value="utf-8"/>     
<!DOCTYPE html>
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
		//alert("${sch.deptno},${sch.mgr},${sch.job}")
		$("[name=id]").val("${sch.id}");
		$("[name=name]").val("${sch.name}");
		$("[name=auth]").val("${sch.auth}");	
	});
</script>
</head>

<body>
<div class="jumbotron text-center">
  <h2 >회원정보(spring MVC)</h2>

</div><!-- // deptCom, mgrCom jobCom -->
<div class="container">
	<form id="frm01" class="form"  method="post">
  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <select name="member" class="form-control mr-sm-2">
	    
	    <button class="btn btn-info" type="submit">Search</button>
 	</nav>
	</form>
   <table class="table table-hover table-striped">
   	<col width="20%">
   	<col width="20%">
   	<col width="20%">
   	<col width="20%">
   	<col width="20%">
    <thead>
    
      <tr class="table-success text-center">
        <th>id</th>
        <th>회원명</th>
        <th>권한</th>
        <th>주소</th>
        <th>포인트</th>
      </tr>
    </thead>
    <tbody>
    	<c:forEach var="member" items="${memberList}">
    	<tr><td>${member.id}</td><td>${member.name}</td>
    		<td>${member.auth}</td>
    		<td>${member.address}</td>
    		<td>${member.point}</td>
    		
    		</tr>
    	</c:forEach>
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
	        <input type="text" class="form-control" placeholder="권한 입력" name="auth">
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