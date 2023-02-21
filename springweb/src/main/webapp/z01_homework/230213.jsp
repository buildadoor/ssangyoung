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
2023-02-13
[1단계:개념] 1. 게시판에서 답글을 처리할려고 한다. 기본 답글 처리 속성을 기술하고, 변경되는 방법을 기술하세요.
      1) form화면
      2) DB 처리
      3) 요청 controller
      
      
- 답글 클릭 시 form 요소데이터의 변경 및 submit으로 글 요청값 전달       
   $("[name=refno]").val($("[name=no]").val())   
   $("[name=subject]").val($( "RE:"+$("[name=subject]").val() ))   
   $("[name=content]").val("\n\n\n===이전글==="+$("[name=content]").val())   
      $("form").attr("action","${path}/insert.do");
         $("form").submit()
- 등록 처리 프로세스로 진행
- 계층형 sql 작성(mapper)
   select rownum cnt, level    : rownum:글을 순서별로 numbering처리/level:계층 레벨처리
   start with refno=0         
   connect by prior no=refno
   order siblings by no desc
   -- 최근 등록된 글을 가장 먼저 나오게 처리(계층구조)
- VO(Board) 추가 cnt, level
- 화면단 처리
   no==>cnt, 
   level을 기준으로 왼쪽 들여쓰기 처리(계층 레벨에 따른 간격 추가)   

      
      
[1단계:개념] 2. 게시판에서 답글을 처리될 때, 계층형 sql 처리를 하여야 한다. 계층형 sql의 기능 내용을 기술하세요.

select *
from board
start with 최상위계층의 조건을 설정 
connect by prior 하위컬럼 = 상위컬럼 //하위와 상위 컬럼 연결조건
==>
최상위 계층 조건 refno=0
하위와 상위 컬럼 연결 조건 no=refno
==>
ex) mgr = null인 president가 최상위 계층
   empno=mgr가 하위와 상위 컬럼 연결 조건
ex)
   select levle, e.*
   from emp e
   start with mgr=null
   connect by prior empno=mgr;   
[1단계:개념] 3. 계층형 데이터 처리로 추가되는 vo의 속성과 역할을 기술하세요
private int cnt;
private int level;

rownum : 데이터를 1부터 리스트 처리 ==> cnt로 처리
level  : 계층형 sql레벨 처리(답글레벨)
[1단계:개념] 4. 페이징 처리에 필요한 속성과 service단의 로직처리를 기술하세요.
필요한 속성:데이터 속성 rownum >> 라인별 번호
- curPage   클릭한 현재페이지 번호
- start/end 데이터의 시작번호, 마지막번호를 도출
   where rownum between 시작번호 and 마지막번호
   한페이지당 보여줄 데이터(pageSize), 클릭한 페이지 번호(curPage)를 통해서 
   rownum/cnt         pageSize 5
   1  2  3  4  5  [1]  시작번호 1  마지막번호5
    6  7  8  9  10 [2]    시작번호 6  마지막번호10
    11 12 13 14 15 [3]   시작번호 11 마지막번호15
    16 17 18 19 20 [4]   시작번호 16 마지막번호20      //데이터건수20
    마지막번호   :  curPage*pageSize
    시작번호    : (curPage-1)*pageSize+1

[1단계:개념] 5. 페이지 처리시, service단 처리 내용과 화면단(jsp) 처리 내용을 상호관계를 설정하세요.
	<input type="hidden" name="curPage"/>
		총 페이지 수 표시
		<select name="pageSize">
		페이지 리스트
		<c:forEach var="cnt" begin="1" 
			end="${sch.pageCount}">
			<span onclick="goPage(${cnt})">${cnt}</span>			
		
		function goPage(page){
			${"name=curPage").val(page)
			$("form").submit();
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