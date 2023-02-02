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
2023-01-20
[1단계:개념] 1. mybatis 설정의 위해 container에서 설정할 내용을 기술하세요.
컨테이너에 DB연결 객체 선언
DBCP연결 객체를 통해 드라이버, 아이피, 계정, 패스워드를 통해 연결한다. 
( 기존 DB파일에 있던 정보 가져오기)
<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">
             <property name="driverClassName" value="oracle.jdbc.driver.OracleDriver"/>
             <property name="url" value="jdbc:oracle:thin:@localhost:1521:xe"></property>
             <property name="username" value="scott"></property>
             <property name="password" value="tiger"></property>
</bean>		

[1단계:개념] 2. mybatis 설정의 위해 mybatis.Spring.xml에서 설정할 내용을 기술하세요
	<!DOCTYPE mapper
   			PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  			"http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
  	public List<Emp> getEmpList(Emp sch);
		
		springweb.a05_mvc.a03_dao
		public List<Emp> getEmpList(Emp sch);
		
		A01_EmpMapper.xml" : 선언된 인터페이스 상속하여
			실제 사용할 DAO객체를 생성
		- 인터페이스명 ==> namespace명
		- 요소객체 안에 사용할 sql 처리..
		- 메서드명 ==> id
		- 메서드의 매개변수 ==> parameterType
		- 메서드의 리턴값 ==> resultType
	<!-- 1. 사용할(XXXMapper.xml) 패키지명 포함 vo클래스를 alias 선언 -->
	<typeAliases>
		<typeAlias alias="emp" type="springweb.z01_vo.Emp"/>
	</typeAliases>
	<!-- 2. 사용 XXXMapper.xml을 추가  a01_diexp\mybatis\resource\A01_EmpMapper.xml -->
	<mappers>
		<mapper resource="a01_diexp/mybatis/resource/A01_EmpMapper.xml"/>
	</mappers>		
[1단계:개념] 3. dao와 XXXMapper.xml의 연동 규칙을 기술하세요.
	1) sql 작성
		select *
		FROM emp100
		where ename like '%'||''||'%'
		and job like '%'||''||'%'
	2) sql 처리를 위한 DTO(VO)를 작성	
		Emp
	3) db처리 인터페이스 선언(dao패키지하위에)
		public List<Emp> getEmpList(Emp sch);
		springweb.a05_mvc.a03_dao
		public List<Emp> getEmpList(Emp sch);
	4) 공통 mybatis xml에 공통 vo 등록, 
		각 업무 단위 mapper.xml을 추가 및 선언.
	4) mapper.xml에서 
		A01_EmpMapper.xml" : 선언된 인터페이스 상속하여
			실제 사용할 DAO객체를 생성
		( 인터페이스를 상속받은 실제 Dao객체를 위 규칙에 생성하는 xml파일..)
		ex)
		<mapper namespace="a01_diexp.mybatis.dao.A01_EmpDao">
   	<select id="getEmpList"  resultType="emp" parameterType="emp">
      select * 
      from emp100
      where ename like '%'||#{ename}||'%'
      and job like '%'||#{job}||'%'   
   	</select>
   
		
[1단계:확인] 4. 단일 리턴값 처리 연습(아래와 같은 sql을 처리하는 dao와 mapper.xml을 구현하고  main()에서 호출하세요.
    --      1) 최고 관리자 번호
SELECT max(mgr) FROM emp100;
--      2) 40번 부서의 최근 입사자의 입사일
 select to_char(max(HIREDATE), 'YYYY-MM-DD') from emp100 where deptno=40;
--      3) 직책이 SALESMAN의 최저 급여
SELECT min(sal) FROM emp100 WHERE job = 'SALESMAN';
--      4) 연봉이 2000~4000 구간의 사원의 수
SELECT COUNT(*) FROM EMP100 WHERE sal BETWEEN 2000 AND 4000;
--      5) 1/4분기에 입사한 사원의 수
SELECT count(*) FROM emp100 WHERE to_char(hiredate,'Q')='4';
      
      
[1단계:확인] 4. 단일 객체 처리 연습(아래와 같은 sql을 처리하는 dao와 mapper.xml을 구현하고  main()에서 호출하세요.
--      1) 직책이 MANAGER인 사원의 최고 급여자
SELECT max(sal) FROM emp100 WHERE job = 'MANAGER';
--      2) 부서번호가 10인 부서정보 (Dept alias 등록 필요 - dept - 공통 mybatis에)
  select * from dept where deptno=10;
--      3) 사원명이 TURNER인 사원의 정보
SELECT * FROM emp100 WHERE ename = 'TURNER';
--      4) 최초 입사자의 사원 정보 
select * from emp100 where hiredate=(select max(hiredate) from emp);
--      5) 2/4분기 최고 급여자의 정보
 SELECT * FROM EMP100 WHERE SAL=(SELECT MAX(SAL) FROM EMP100 WHERE to_char(HIREDATE, 'q')=2);
      
      
      DIExp53.java
      package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.mybatis.dao.A01_EmpDao;
import springweb.z01_vo.Emp;

public class DIExp53 {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      // 컨테이너 객체 호출 처리
      String path = "a01_diexp\\di22.xml";
      AbstractApplicationContext 
      ctx = new GenericXmlApplicationContext(path);
      // DL(dependency lookup)으로 id명으로 객체를 찾아서 가져온다.
      // A01_EmpDao
      A01_EmpDao dao = ctx.getBean("a01_EmpDao", A01_EmpDao.class);
      System.out.println("4번");
      System.out.println("1) 최고 관리자 번호:"+dao.hw01());
      System.out.println("2) 40번 부서의 최근 입사자의 입사일:"+dao.hw02());
      System.out.println("3) 직책이 SALESMAN의 최저 급여:"+dao.hw03());
      System.out.println("4) 연봉이 2000~4000 구간의 사원의 수:"+dao.hw04());
      System.out.println("5) 1/4분기에 입사한 사원의 수:"+dao.hw05());
      System.out.println("5번");
      System.out.println("1) 직책이 MANAGER인 사원의 최고 급여자:"+dao.hw06());
      System.out.println("2) 부서번호가 10인 부서정보:"+dao.hw07());
      System.out.println("3) 사원명이 TURNER인 사원의 정보:"+dao.hw08());
      System.out.println("4) 최초 입사자의 사원 정보 :"+dao.hw09());
      System.out.println("5) 2/4분기 최고 급여자의 정보:"+dao.hw10());
      ctx.close();
      // di10.xml
      // <bean id="obj" class="java.lang.Object" />
   }

}

A01_EmpDao
package a01_diexp.mybatis.dao;

import java.sql.Date;
import java.util.List;

import springweb.z01_vo.Emp;

public interface A01_EmpDao {
   public List<Emp> getEmpList(Emp sch);
   public int empCount();
   public double empMaxSal();
   public String getEname();
   public double getMaxSalByDept();
   public int getMaxMgr();
   public String getJboByEname();
   
   public Emp getEmpByEmpno();
   public Emp getEmpByEname();
//과제   
		public int hw01();
		public String hw02();
		public double hw03();
		public int hw04();
		public int hw05();
		public String hw06();
		public String hw07();
		public String hw08();
		public String hw09();
		public String hw10();
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