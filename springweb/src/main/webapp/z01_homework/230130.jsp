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
2023-01-30
[1단계:개념] 1. form화면을 두개 사용하는 이유를 기술하세요
 화면 - 데이터
      1) form형식 처리
      2) model데이터 출력 jstl처리
   # 화면 처리(수정 삭제를 위한 단일 화면)
   1. 위리스트 화면에서 클릭 시, id값을 통해 요청 화면 로딩
      controller, model(proc(schOne)), view
   2. 화면 - 데이터 
      1) 단일 데이터 로딩키, 요청 id값을 기준으로 모달창 로딩 후,
      2) model데이터 출력 jstl 처리
[2단계:확인] 2. 오늘 처리한 회원관리 화면에서 회원등록 처리를 다이얼로그 박스를 활용해 처리 해보세요.
1) DB처리
	- sql insert into member200 values('goodMan','9999','정수라','normal',3000);
	- vo 확인
	- mybatis 공통 점검 
	- dao public void insertMember(Member ins);
	- mapper 
		<insert id="insertMember" parameterType="member">
			insert into member200 values(#{id},#{pass},#{name},#{auth},#{poimt})
2) view단 처리
	- 등록버튼 추가 - 모달창로딩(form데이터에 데이터가 없어야함)
	- 모달창 안에 form데이터 
		타이틀 : 회원등록, ps) 상세 화면에서 회원상세정보로 처리
		form데이터에 데이터가 없어야 함
		버튼 : 등록버튼 / 닫기 ps) 상세화면에서는 수정/삭제버튼만 있게 처리.
		모달창안에 등록 버튼 클릭시, 
			입력여부 및 유효성 처리...권한 추가시를 위해 고려? 
		$("#frm02 [name=proc]).val("ins");
		$("#frm02").attr("action","${path}/insertMember.do")
3) controller 처리 		
	- @PostMapping("insertMember.do")
	public String insertMember(Member ins, Model d){
	 service.insertMember(ins);
	 d.addAttribute("mem",service.getMember(ins.getId());
	 return "";
	}	
4) view단 
	if(proc=="ins"){
		alert("등록완료");
		}
ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
dao
public void insertMember(Member ins);
mapper
	 <insert id="insertMember" parameterType="member">
      insert into member200
      values(#{id}, #{pass}, #{name}, #{auth},#{point})
   </insert>
serivce
	public void insMember(Member ins) {
		dao.insertMember(ins);
	}
controller
@RequestMapping("/memberIns")
	public String memberIns(Member ins, Model d) {
		service.insMember(ins);
		return "WEB-INF\\views\\a05_mvc\\a03_memberList.jsp";
	} 
jsp
		$("#insBtn").click(function(){
			if(confirm("등록하시겠습니까?")){
				$("#frm02 [name=proc]").val("del");
				$("#frm02").attr("action","${path}/memberIns.do");
				$("#frm02").submit();
			}			
		})
		
<button id="insBtn" type="button" class="btn btn-warning">등록</button>
        


[1단계:개념] 3. 컨테이너에서 viewResolver를 선언하는 이유를 기술하세요.
# ViewResolver
1. 뷰단에 대한 여러가지 형식을 지정하여 처리하는 lib를 말한다.
2. container에서 default 웹 html, jsp를 지원하고 있다.

[1단계:개념] 4. jsp와 컨테이너에서 bean으로 선언된 view의 우선 순위 설정 방법을 기술하세요
	<!-- 
	1. viewResolver 1순위 선언 : bean을 선언되어 있으면 해당 뷰를 찾게 처리
	 -->
	<bean id="btnViewResolver"
		class="org.springframework.web.servlet.view.BeanNameViewResolver">
		<property name="order" value="0"/>
	</bean> 
	<!-- 
	2. 위에 선언된 viewer이외는 모두 html/jsp 뷰..
	 -->
	<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="order" value="1"/>
	</bean>
	<!-- 위에서 1순위 채택하는 json viewer -->
	<bean id="pageJsonReport" class="org.springframework.web.servlet.view.json.MappingJackson2JsonView">
		<property name="contentType" 
			value="text/html;charset=utf-8"/>	
	</bean>
	
[1단계:확인] 5. Member객체를 json view로 출력하세요.
	@GetMapping("callJson05.do")
	public String calljson05(Model d) {
		d.addAttribute("json05",new Member("himan","7777","홍길동","admin",9999,"서울"));
		return "pageJsonReport";
	}


[1단계:확인] 6. select * from emp100으로 데이터 처리(dao,mapper에 추가)하여 json view로 출력하세요.
 
 vo Emp
 dao public List<Emp> getEmpAll();
 mapper 
 	<select id="getEmpAll" resultType="emp"?
 		select * from emp100
 	</select>
 	
 service 호출
 controller 
 	@RequestMapping("/getEmpAll.do")
 	public String getEmpAll(Model d){
 		d.addAttribute("empList",service,getEmpAll()");
 		return "pageJsonReport";
 	}
 
 
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