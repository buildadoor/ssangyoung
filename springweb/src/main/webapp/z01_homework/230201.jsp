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
2023-02-01
[1단계:개념] 1. 고정아이피를 통해서 svn/git서버 설정과 클라이언트를 통해 접속하는 설정 과정을 기술하세요.
			고정ip구매 (클린ip)
			서버 컴퓨터에다가 ip를 구매한 사이트에서 제공하는 프로그램을 깔고 로그인후 연결 
			visual svn 다운로드 후 계정 user01 패스워드 user01 생성 
			아이피 연결 후 
			이클립스 a02_javaexp설치 후 market에서 svn 설치후
			svn repository연동하여 import  (고정아이피넣은 url) 
			oracle방화벽설치 

[1단계:확인] 2. (조별과제) svn/git에 서버에 리파지토리로 prj01 폴드를 만들고, 이 폴드에 다이나믹웹프로젝트 올리고, 
            클라이언트에서 해당 프로젝트를 import처리하세요 
            https://49.238.181.236/svn/prj01/
            
[1단계:개념] 3. 고정아이피를 통해서 DB서버 설정과 원격에서 접속하기위해 설정해야 하는 내용을 기술하세요.
             <property name="url" value="jdbc:oracle:thin:@49.238.181.236:1521:xe"></property>
             <property name="username" value="user01"></property>
             <property name="password" value="user01"></property>
			
테이블 생성 			
			기존 워크스페이스에 새데이터베이스 연결 oracle 
			host에 고정 아이피 입력
			id = system 
			password = 1111
			입력 
			(게정 만드려면 
			-- 관리자 계정 접속 system/1111
			GRANT CONNECT,RESOURCE,UNLIMITED TABLESPACE TO user01 IDENTIFIED BY user01;
			ALTER USER user01 DEFAULT TABLESPACE USERS;
			ALTER USER user01 TEMPORARY TABLESPACE TEMP;)
[1단계:확인] 4. (조별과제) 원격에 있는 DB서버에 system/1111 계정으로 접근하여 조원들의 각 계정을 만들어서,
           해당 계정으로 접속하여 member테이블을 만들고 데이터를 넣고, 다른 조원 계정으로 접속해서 데이터를
           확인하세요.
           user01, user02 두개 넣었음. 
           
[1단계:확인] 5. (조별과제) 프로젝트 진행할 다이나믹웹프로젝트 만들어, 스프링환경으로 처리하여, controller로
            첫화면이 로딩되게 처리하세요.
[1단계:확인] 6. (조별과제) 프로젝트 진행할 다이나믹웹프로젝트 만들어, 스프링환경으로 처리하여, controller로
            DB처리가 되는 첫화면이 로딩되게 처리하세요.
[1단계:개념] 7. vue의 디렉티브 3가지 형식 {{}}, v-text, v-html의 차이를 기술하세요.

 	 {{모델명}} : 모델데이터를 처리하는 기본 형식
 		출력형식 태그에 바로 사용한다. ex) <h2>{{모델명}}</h2>
 	 v-text : 모델데이터를 태그의 속성으로 선언하여 출력할 데이터를
 		처리하는 방식. html랜더링(해석)하지 않는다.
 	 v-html : 태그가 포함된	모델데이터를 html로 랜더링(해석)해서
 		출력할 때, 속성으로 선언한다.
 
 
 2023-02-01
[1단계:개념] 1. 고정아이피를 통해서 svn/git서버 설정과 클라이언트를 통해 접속하는 설정 과정을 기술하세요.
[1단계:확인] 2. (조별과제) svn/git에 서버에 리파지토리로 prj01 폴드를 만들고, 이 폴드에 다이나믹웹프로젝트 올리고, 
            클라이언트에서 해당 프로젝트를 import처리하세요 
[1단계:개념] 3. 고정아이피를 통해서 DB서버 설정과 원격에서 접속하기위해 설정해야 하는 내용을 기술하세요.
[1단계:확인] 4. (조별과제) 원격에 있는 DB서버에 system/1111 계정으로 접근하여 조원들의 각 계정을 만들어서,
           해당 계정으로 접속하여 member테이블을 만들고 데이터를 넣고, 다른 조원 계정으로 접속해서 데이터를
           확인하세요.
	DB 설치시, 비밀번호 : @@@@  관리자 계정 비밀번호            
 	C:\oraclexe\app\oracle\product\11.2.0\server\rdbms\admin\scott.sql
 	계정은 system//1111계정으로 접근해서 계정을 만들고,
 		계정생성(id,pass), 
 		계정에 권한을 부여(접근, 테이블생성 및 사용하는 권한, 물리적 파일을 접근하여 사용  
 	
 	// ex) scott/tiger 비번호는 대소문자 구분
 	GRANT CONNECT,RESOURCE,UNLIMITED TABLESPACE TO SCOTT IDENTIFIED BY tiger;
 	// ex) himan/7777  계정생성 및 비번호 설정.
	ALTER USER SCOTT DEFAULT TABLESPACE USERS;
	ALTER USER SCOTT TEMPORARY TABLESPACE TEMP;
	 	
 	GRANT CONNECT,RESOURCE,UNLIMITED TABLESPACE TO himan IDENTIFIED BY 7777;
	ALTER USER himan DEFAULT TABLESPACE USERS;
	ALTER USER himan TEMPORARY TABLESPACE TEMP;	  	
 	// tablespace는 물리적 저장위치와 연결되어 있어, 데이터베이스가 만들어지고 실제 물리적
 	// 위치의 저장소도 연결하여야 한다. 	
           
[1단계:확인] 5. (조별과제) 프로젝트 진행할 다이나믹웹프로젝트 만들어, 스프링환경으로 처리하여, controller로
            첫화면이 로딩되게 처리하세요.
[1단계:확인] 6. (조별과제) 프로젝트 진행할 다이나믹웹프로젝트 만들어, 스프링환경으로 처리하여, controller로
            DB처리가 되는 첫화면이 로딩되게 처리하세요.
 	컨테이너 부분에 DB 연결 정보와 계정/비번으로 스프링환경 설정을 완료한다.
		<property name="url" value="jdbc:oracle:thin:@106.10.23.227:1521:xe"/>	
		<property name="username" value="himan"/>	
		<property name="password" value="7777"/>	 	           
            
            
[1단계:개념] 7. vue의 디렉티브 3가지 형식 {{}}, v-text, v-html의 차이를 기술하세요.
 
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