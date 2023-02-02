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
2023-01-25
[1단계:개념] 1. 새로운 dao패키지, 새로운 dao와 새로운 mapper를 추가했을 때, 새로운 vo를 mybatis에 추가할 때, 처리할 내용을 기술하세요.
  1. 사용할(XXXMapper.xml) 패키지명 포함 vo클래스를 alias 선언한다.
  ex)<typeAliases>
		<typeAlias alias="dept" type="springweb.z01_vo.Dept"/>
		<typeAlias alias="empdept" type="springweb.z01_vo.EmpDept"/>
	</typeAliases>
  2. 사용 XXXMapper.xml에 추가한다.
  ex)a01_diexp\mybatis\resource\A01_EmpMapper.xml
     a01_diexp\mybatis\resource\A01_ExpMapper.xml

[1단계:확인] 2. salgrade활용하여 select * from salgrade를 처리할려고 한다. 처리순서를 기술하세요. 
	package a01_diexp.z08_mydb;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z08_mydb.vo.Salgrade;

public class A01_DIExp93 {

   public static void main(String[] args) {
		// http://localhost:7080/springweb/start.do
      //컨테이너 객체 호출 처리
      String path="a01_diexp\\z08_mydb\\a01_di93.xml";
      AbstractApplicationContext
      ctx = new GenericXmlApplicationContext(path);
      //DL(dependency lookup)으로 id명으로 객체를 찾아서 가져온다.
      A02_ExpDao dao = ctx.getBean("a02_ExpDao",A02_ExpDao.class);
      System.out.println("컨테이너 객체 호출:"+dao.getSalgrade());
      System.out.println("데이터 건수"+dao.getSalgrade().size());
      for(Salgrade s : dao.getSalgrade()) {
    	  System.out.print(s.getGrade()+"\t");
    	  System.out.print(s.getLosal()+"\t");
    	  System.out.print(s.getHisal()+"\n");
      }
      System.out.println("종료");
      ctx.close();
      //di10.xml
      // <bean id="obj" class="java.lang.Object"/>
   }

}

	
	
	1) sql
		select * from salgrade;
	2) dao의 메서드 선언
		public List<Salgrade> getSalgrade();
		
	3) XXXMapper.xml
		dao
		<select id="getSalgrade" resultType="salgrade">
				select * from salgrade
		</select>
	4) main()에서 호출
		List<Salgrade> slist = dao.getSalgrade()
		System.out.println("등급 데이터 크기:"+slist.size());
[1단계:확인] 3. a01_diexp.mybatis하위에 dao3패키지를 만들어 회원테이블을 조회할려고 한다. 처리순서와 내용 코드를 기술하세요.
   	diXX.xml
   	  dao3 패키지 추가시 xml에서 ','로 추가 구분해서 value에 할당한다.
      <property name="basePackage" value="a01_diexp.mybatis.dao,a01_diexp.mybatis.dao2"/>
	SQL
	  select * from member;
	vo: 결과에 따른 vo객체 생성
	DAO단 INTERFACE 기능메서드 선언
			public List<Member> getMemberList();
	mapper 
		공통 mybatis에서 선언한 alias명인 객체 
		<select id="getMemberList" resultType="member">
		select * from member
		</select>
	main()
		Member mem01 = dao.getMemberList();
		mem.getName(); 
		mem.getAuth(); 


[1단계:개념] 4. resultType을 쓰는 경우와 resultMap을 쓰는 경우의 차이점을 기술하세요.  
	resultType은 컬럼명과 property 동일한 경우에 사용하고
	resultMap은 컬럼명과 property 다르게 설정해야하는 경우에 사용한다.
	(1:다, 1:1 객체)
	select sal + nvl(comm,0) tot
	from emp
	column tot ==> Emp에 setSal 할당이 필요한 경우 resultMap을 활용
	
	
[1단계:확인] 5. 1대 다 resultMap 활용
      1. select ename name, mgr manager, sal salaray from emp로 sql을 처리하여 mybatis에서 처리할려고 한다.vo를 변경하지 않고 처리하세요.
		sql select ename name, mgr manager, sal salary
		vo emp
		dao public List<Emp> getEmpList()
		mapper 
			<resultMap id="empResult" type="emp">
				<result column = "name" property="ename"/>
				<result column = "manager" property="mgr"/>
				<result column = "salary" property="sal"/>
			<select id="getEmpList" resultMap="empResult">
				select ename name, mgr manager, sal salary from emp
      2. select deptno no, dname departname, loc location from dept sql 처리






package a01_diexp;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.mybatis.dao.A02_ExpDao;
import springweb.z01_vo.Dept;
import springweb.z01_vo.Emp;

public class DIExp23 {

   public static void main(String[] args) {
		// http://localhost:7080/springweb/start.do
      //컨테이너 객체 호출 처리
      String path="a01_diexp\\di22.xml";
      AbstractApplicationContext
      ctx = new GenericXmlApplicationContext(path);
      //DL(dependency lookup)으로 id명으로 객체를 찾아서 가져온다.
      A02_ExpDao dao = ctx.getBean("a02_ExpDao",A02_ExpDao.class);
      List<Emp> empList = dao.getEmpData();
      System.out.println("데이터 건수:"+empList.size());
      for(Emp e:empList) {
    	  System.out.print(e.getEmpno()+"\t");
    	  System.out.print(e.getEname()+"\t");
    	  System.out.print(e.getSal()+"\n");
      }
      
      List<Emp> hw01List = dao.getHw01();
      System.out.println("hw01 데이터 건수:"+hw01List.size());
      for(Emp hw01:hw01List) {
    	  System.out.print(hw01.getEname()+"\t");
    	  System.out.print(hw01.getMgr()+"\t");
    	  System.out.print(hw01.getSal()+"\n");
      }
      List<Dept> hw02List = dao.getHw02();
      System.out.println("hw02 데이터 건수:"+hw02List.size());
      for(Dept hw02:hw02List) {
    	  System.out.print(hw02.getDeptno()+"\t");
    	  System.out.print(hw02.getDname()+"\t");
    	  System.out.print(hw02.getLoc()+"\n");
      }
      System.out.println("종료");
      ctx.close();
   }

}
--DAO
package a01_diexp.mybatis.dao;

import java.util.List;

import springweb.z01_vo.Dept;
import springweb.z01_vo.Emp;

public interface A02_ExpDao {
	public List<Emp> getEmpData();
	public List<Emp> getHw01();
	public List<Dept> getHw02();
}

--Mapper
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
   PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
   "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >   
<mapper namespace="a01_diexp.mybatis.dao.A02_ExpDao">
<!-- 
SELECT empno NO, ename name, sal+nvl(comm,0) tot
FROM emp100

no, name, tot : column
empno, ename, sal : Emp 안에 property 할당

 -->
	<resultMap type="emp" id="empSult">
		  <result column="no" property="empno"/>
		  <result column="name" property="ename"/>
		  <result column="tot" property="sal"/>
	</resultMap>
	<!-- 
	public List<Emp> getEmpData();
	 -->
	<select id="getEmpData" resultMap="empSult">
		SELECT empno NO, ename name, 
				sal+nvl(comm,0) tot
		FROM emp100
	</select>
	<!-- 
select ename name, mgr manager, sal salaray from emp
select deptno no, dname departname, loc location from dept
	 -->
	 <resultMap type="emp" id="hw01">
		  <result column="name" property="ename"/>
		  <result column="manager" property="mgr"/>
		  <result column="salaray" property="sal"/>
	</resultMap>
	<!-- 
	public List<Emp> getHw01();
	 -->
	<select id="getHw01" resultMap="hw01">
	select ename name, mgr manager, sal salaray from emp
	</select>
	
	 <resultMap type="dept" id="hw02">
		  <result column="no" property="deptno"/>
		  <result column="departname" property="dname"/>
		  <result column="location" property="loc"/>
	</resultMap>
	<!-- 
	public List<Emp> getHw02();
	 -->
	<select id="getHw02" resultMap="hw02">
	select deptno no, dname departname, loc location from dept
	</select>
</mapper>      
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