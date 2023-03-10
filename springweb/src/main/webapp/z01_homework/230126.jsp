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
2023-01-26
[1단계:개념] 1. resultMap을 사용하는 경우와 설정형식을 기술하세요
resultMap은 컬럼명과 property 다르게 설정해야하는 경우에 사용한다.
	(1:다, 1:1 객체)
	select sal + nvl(comm,0) tot
	from emp
	column tot ==> Emp에 setSal 할당이 필요한 경우 resultMap을 활용
[1단계:확인] 2. select id user, pass password99, auth authority from member sql을 resultmap을 이용해서  DB 처리를하세요

select id user99, pass password99, auth authority  from MEMBER
	public List<Member> getMemberList();
    
     <select id="getMemberList" resultType="member">
      select id user99, pass password99, auth authority  from MEMBER
   	 </select>
   	
    System.out.println("데이터 건수"+dao.getMemberList().size());	

[1단계:확인] 3. 부서번호로 조회와 부서정보를 등록하는 처리를 parameterType 속성을 이용하여 처리하세요
		 <insert id="insertDept" parameterType="dept">
      insert into dept100
      values(#{deptno}, #{dname}, #{loc})
   </insert>
   	<delete id="deleteDept" parameterType="int">
			delete from Dept100
			where deptno = #{deptno}
	</delete>
   <select id = "getDept" resultType ="dept" parameterType="int">
			select *
			from dept100
			where deptno=#{deptno}
	</select>
	
	Dept dept = dao.getDept(10);
	dao.insertDept(new Dept(10,"회계","천안"));
	dao.deleteDept(10);
	
[1단계:확인] 4. 회원정보(member)를 삭제하는 처리를 하세요
	dao 
		public void deleteMember(String id);
	sql
		delete from member
			where id = #{id}
	main 
		dao.deleteMember("아이디");


[3단계:확인] 5. product, member, buyinfo 테이블의 조인관계를 설정하여  BuyProduct VO에 Product, Member 객체를 포함하여 resultMap을 활용한 DB처리를 하세요  
sql
SELECT p.name pname, price, m.mid, m.name, pass, auth, b.bcnt
FROM product111 p, member111 m, buyinfo111 b
WHERE p.pid = b.pid and m.mid = b.mid
vo
	Member(id, pass, name, auth)
	Product(name, price, bcnt)
	 ==> BuyInfo Member member; Product product;
공통 mybatis 
	member, product 등록  
dao
	public List<BuyInfo> getBuyInfo();
mapper
	<resultMap id="buyRst" type="buyinfo">
		<association type="member">	
			<result column="name" property="name"/>
			<result column="mid" property="id"/>
			<result column="pass" property="pass"/>
			<result column="name" property="name"/>
			<result column="auth" property="auth"/>
		<association type="product">	
 			<result column="pname" property="name"/>
 			<result column="price" property="price"/>
 			<result column="bcnt" property="bcnt"/>
main()
	 List<BuyInfo> blist = dao.getBuyInfo();
 
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