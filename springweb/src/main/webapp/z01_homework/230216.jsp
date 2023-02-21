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
2023-02-16
[1단계:개념] 1. vue의 pop, event 처리과정을 기술하세요
  function(){
         this.$emit("선언한 이벤트명",전달할 데이터1,전달할 데이터2...)
      }
      <하위컴포넌트 @이벤트="이벤트핸들러1"
      
      <상위컴포넌트 @상위에서 선언 이벤트명 = "상위 선언 이벤트 핸들러"
      
      methods:상위 선언 이벤트 핸들러(하위에서 전달한 데이터받은 변수1, 변수2){}
[1단계:개념] 2. 플러그인 프로그램의 처리 과정을 기술하세요
	1) 필요로하는 플러그인 프로그램 검색 및 다운로드
	2) document 문서나 화면기능 처리 및 소스를 통해서 주요 기능 파악
	3) 처리되는 json내용 확인, 특정이벤트에 의해 처리할 서버단 연동 부분확인
	4) json 데이터 확인했으면, 이 json데이터가 고정형 rdbms에서 table 구조상 처리할 
		내용을 확인하고, 생성한다.
	5) api에서 데이터 CRUD(입력/조회/수정/삭제) 처리할 기능메서드에 대한 내용을 확인한다.
	6) 위 내용에 필요한 요청값, 리스트 데이터를 확인한다.
	7) 스프링에서 backend단 처리를 한다.
		DB:sql, vo, 공통 mybatis, XXXMapper, dao, service
		요청 controller단: 요청값과 url주소에 의해 호출되는 기능메서드 추가 및
			service단과 호출처리
	8) 플러그인 프로그램의 crud기능 메서드 확인 및 요청값 및 출력 json데이터 처리할 
		내용으로 ajax 처리한다.
	9) 부가적으로 필요로 하는 화면 ui 확인(다이얼로그 박스, form형식, 차트 ...)
	10) 서버단과 연동할 계획을 정리하고, 특정 시점에 ajax가 처리되게 코드 한다.
	
[1단계:개념] 3. 플러그인 프로그램의 환경설정 과정을 오늘한 fullcalenar 기준 기술하세요
 fullcandar 플러그인 프로그램 처리
1. 필요로하는 플러그인 프로그램 검색 및 다운로드	
2. 스프링 개발환경으로 설정하기
	1) lib 복사
		 a03_fullcalendar/dist 폴드를 a00_com/으로 복사한다.
	2) examples/selectable.html 파일을 복사
		WEB-INF/views/a05_mvc/하위에 a20_fullcalendar.html로
		이름을 변경해서 저장한다.
		<script src='/springweb/a00_com/dist/index.global.js'></script>
	3) springweb.a05_mvc.a01_controller 패키지 하위
		A20_CalenController.java를 만들고, 해당 html을  a20_fullcalendar.html
		Get방식으로 /calendar.do 메서드를 통해서, 해당 화면이 로딩된게 한다.
3. 처리되는 json내용 확인, 특정이벤트에 의해 처리할 서버단 연동 부분확인		
	 events: [] 가 데이터 로딩되는 속성
4. json 데이터 확인했으면, 이 json데이터가 고정형 rdbms에서 table 구조상 처리할 
		내용을 확인하고, 생성한다.
	5) api에서 데이터 CRUD(입력/조회/수정/삭제) 처리할 기능메서드에 대한 내용을 확인하다
		
5. controller 단 호출 처리
	1) /calendarAjax.do
		view : pageJsonReport를 통해서 json데이터 출력하세요 하세요.
				
6. 화면단에서 데이터 등록 및 등록된 데이터 확인 처리..
	1) json 데이터의 삭제
	2) event 처리에서 json데이터 처리하기
[1단계:개념] 4. 진행할 fullcaledar api 의 주요 속성 내용과 DB 처리 방법을 기술하세요.

DB 설계
		create table calendar01(
			id number primary key,
			title varchar2(100),
			start01 varchar2(50),
			end01 varchar2(50),
			writer  varchar2(50),
			content   varchar2(500),
			backgroundColor varchar2(20), 
			textColor  varchar2(20),
			allDay number(1), 
			url	varchar2(500)	
		);				
		create sequence cal01_seq
			start with 1
			minvalue 1;
		SELECT * FROM calendar01;
		sql : SELECT * FROM calendar01
		vo : 
		class Calendar{
			private int id;
			private String title;
			private String start;
			private String end;
			private String writer;
			private String content;
			private String backgroundColor;
			private String textColor;
			private boolean allDay;
			private String url;
		}
		공통 Mybatis
			calendar
			A20_CalendarMapper.xml
		dao
			A20_CalendarDao.java
			public List<Calendar> calList();	
		mapper 
			  <resultMap type="calendar" id="calRst">
			      <result column="start01" property="start"/>
			      <result column="end01" property="end"/>
			   </resultMap>
			   <select id="calList" resultMap="calRst">
			      SELECT * FROM calendar01
			   </select>
		service	
				@Autowired(required=false)
			private A20_CalendarDao dao;
			
			public List<Calendar> calList(){
				return dao.calList();
			}

[1단계:확인] 5. 테이블 calen2(id,title, start) sequence calen2_seq를 만들고  DB입력 VO 만들기 후, controller /cal2Ajax.do로 호출하여 json데이터가 로딩 되게 하세요
 
DB 설계
		create table calendar02(
			id number primary key,
			title varchar2(100),
			start01 varchar2(50)
		);				
		create sequence cal02_seq
			start with 1
			minvalue 1;
		SELECT * FROM calendar02;
		sql : SELECT * FROM calendar02
		vo : 
		class Calendar2{
			private int id;
			private String title;
			private String start;
		}
		공통 Mybatis
			calendar
			A21_CalendarMapper.xml
		dao
			A21_CalendarDao.java
			public List<Calendar2> calList2();	
		mapper 
			  <resultMap type="calendar2" id="calRst">
			      <result column="start01" property="start"/>
			      <result column="end01" property="end"/>
			   </resultMap>
			   <select id="calList" resultMap="calRst">
			      SELECT * FROM calendar02
			   </select>
		service	
				@Autowired(required=false)
			private A21_CalendarDao dao;
			
			public List<Calendar2> calList2(){
				return dao.calList2();
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