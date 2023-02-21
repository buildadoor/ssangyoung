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
2023-02-17
[1단계:개념] 1. fullcalendar 등록 처리시, DB 처리할 내용을 기술하세요
			sql
				INSERT INTO calendar01 values(cal01_seq.nextval, '첫번째 일정 등록',
				'2023-02-17T10:00:00','2023-02-18T23:59:00', '이윤아','내용',
				'#0404B4','#FFFF00',1,'url');
		    vo
		    	private int id;
				private String title;
				private String start;
				private String end;
				private String writer;
				private String content;
				private String backgroundColor;
				private String textColor;
				private boolean allDay;
				// url 생략
		    공통 mybatis
		    dao
		    	public void insertCalendar(Calendar ins);
		    mapper 추가 
		    	
			service 
					public void insertCalendar(Calendar ins) {
					dao.insertCalendar(ins);
			controller
						@RequestMapping("/insCalendar.do")
						public String insertCalendar(Calendar ins, Model d) {
							service.insertCalendar(ins);
							d.addAttribute("msg","일정등록성공");
							return "pageJsonReport";
						}
	
[1단계:개념] 2. fullcalendar controller단 처리 내용을 기술하세요
			@RequestMapping("/insCalendar.do")
						public String insertCalendar(Calendar ins, Model d) {
							service.insertCalendar(ins);
							d.addAttribute("msg","일정등록성공");
							return "pageJsonReport";
						}
[1단계:확인] 3. ajax로 처리할 수 있게  일정명 날짜 작성자를 요청값을 받아 등록되는 backend단을 구현하세요
	function ajaxFun(url){
  		$.ajax({
  			type:"post",
  			url:"/springweb/"+url,
  			data:$("form").serialize(), // form하위 데이터 요청형식변경
  			dataType:"json",
  			success:function(data){
  				alert(data.msg)
  				location.reload() 
  				// 화면 refresh 전체데이터 로딩 처리
  			},
  			error:function(err){
  				console.log(err)
  			}
  		})
  	}
[1단계:개념] 4. fullcalendar 등록 화면단 처리 기능메서드와 등록할 데이터의 form데이터를 기술하세요
    <form class="form" novalidate>
	          <input type="hidden" name="id" value="0"/>
	          <div class="mb-3">
	            <label for="title">일정명</label>
	            <input type="text" name="title" class="form-control" id="title" placeholder="일정타이틀입력" >
	          </div>
	          <div class="row">
	            <div class="col-md-6 mb-3">
	              <label for="start">시작일</label>
	              <!-- 
	              GMT 시간과 한국에서 사용되는 시간 +9차이
	               -->
	              <input readonly type="text" id="start" class="form-control"  >
	              <input type="hidden" name="start" class="form-control"  >
	            </div>
	            <div class="col-md-6 mb-3">
	              <label for="end">종료일</label>
	              <input readonly type="text" id="end" class="form-control">
	              <input type="hidden" name="end" class="form-control">
	            </div>  
	          </div>
	          <div class="row">
	            <div class="col-md-6 mb-3">
	              <label for="writer">작성자</label>
	              <input type="text" name="writer" class="form-control" id="writer" >
	            </div>
	            <div class="col-md-6 mb-3">
 	              <label for="allDay">종일여부</label>
 	              <!-- 
 	              db : 1/0
 	               -->
				  <select  id="allDay" class="form-control" >
				   	<option value="true">종일</option>
				   	<option value="false">시간</option>
				  </select>
				  <input type="hidden" name="allDay"/>
	            </div>  
	              <script type="text/javascript">
	              	$("#allDay").change(function(){
	              		$("[name=allDay]").val($(this).val()=='true'?1:0);
	      	        })
	              	// 16:05~~
	              </script>	
	            
	          </div>
	          <div class="row">
	            <div class="col-md-6 mb-3">
	              <label for="textColor">글자색상</label>
	              <input type="color"  value="#ccffff"  name="textColor" class="form-control" id="textColor" >
	            </div>
	            <div class="col-md-6 mb-3">
	              <label for="backgroundColor">배경색상</label>
	              <input type="color"  value="#0099cc"  name="backgroundColor" class="form-control" id="backgroundColor" >
	            </div>  
	          </div>
	          <div class="mb-3">
	            <label for="content">내용</label>
	            <textarea name="content" rows="5" class="form-control" id="content" placeholder="일정내용입력"></textarea>
	          </div>	          	          	
	          <div class="mb-3">
	            <label for="url">링크 주소</label>
	            <input type="url" name="url" class="form-control" id="url" placeholder="링크할 주소 입력" >
	          </div>
	        </form>
[1단계:개념] 5. 등록시 가져오는 매개변수 데이터 arg.start의 데이터 유형을 확인하고, toISOString()과 toLocaleString()의 차이점을 확인하세요
     	  $("[name=start]").val(arg.start.toISOString())
          $("#start").val(arg.start.toLocaleString())
          $("[name=end]").val(arg.end.toISOString())
          $("#end").val(arg.end.toLocaleString())
          
          
          toISOString() - 2023-02-20T14:20:53.422Z을 반환한다.
          toLocaleDateString() - 2/20/2023을 반환한다.
[1단계:개념] 6. 등록시 처리되는 arg.allDay의 유형과 실제 등록처리시 1/0을 나누는 이유에 대하여 기술하세요.
종일과 시간 여부 . 
[1단계:확인] 5. 오늘 진행한 내용을 a22_fulcandarExp.html에 하나씩 확인하면서 적용하세요
 
 
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