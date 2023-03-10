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
2023-02-06
[1단계:개념] 1. 게시판의 등록을 위한 프로세스와 이와 연결되는 코드 파일과 관련성을 기술하세요
1) DB 
		- 등록 sql 작성
			 INSERT INTO board values(board_seq.nextval,
			#{refno}, #{subject}, #{content},#{writer},0, sysdate, sysdate)
		- 등록을 위한 vo
		- 공통 mybatis 
		- dao interface
			public void insertBoard(Board ins);
		- mapper
			<insert id="insertBoard" parameterType="board">
				 INSERT INTO board values(board_seq.nextval,
			#{refno}, #{subject}, #{content},#{writer},0, sysdate, sysdate)
			</insert>
	2) service
		public void insertBoard(Board ins){
			dao.insertBoard(ins);
		}
	3) controller 
		- 등록을 위한 from controller 메서드 구현 
			@GetMapping("/insertFrm.do")
			public String insertFrm(){
				return "a02_insertBoard";
			}
		- 등록처리 controller 메서드 구현 
			@PostMapping("/insert.do")
			public String insert(Board ins, Model d){
				service.inserBoard(ins);
				d.addAttribute("msg","등록성공");
				return "02_insertBoard";
			}
	4) 뷰
		- 화면리스트 뷰에서 등록 버튼 클릭시, 등록 처리 화면 이동
			<button type="button" onclick="insertFrm()">
			function insertFrm(){
				location.href="${path}/insertFrm.do"
			}
			<button>조회화면</button>
		- 화면리스트 뷰에서 등록 버튼 클릭시, 등록 처리 화면 이동
		- 등록form을 위한 화면 구현 
			#{refno}, #{subject}, #{content}, #{writer},
			<input name="refno" value="0"/>
			<input name="subject" value=""/>
			<input name="content" value=""/>
			<input name="writer" value=""/>
# 수정/삭제를 위한 상세화면
1. 처리 프로세스
	1) 리스트 화면에서 특정 데이터 더블 클릭시
	2) 해당 데이터에 있는 key인 no으로 요청값으로 하여
	3) 컨트롤러를 처리되어 
		- 이 글에 대한 조회수를 update한 후,
		- 이 글의 상세 데이터를 DB에 데이터를 가져온 후, 
		DB에 데이터를 가져온 후, 
		이 모델데이터 기반으로
	4) 상세 화면이 로딩된다.
		- 게시물 번호, 답글 번호, 제목, 작성자, 조회수,
			등록일, 수정일, 내용 			
	5) 다음 단계를 위한 수정/삭제/답글/메인화면 기능 버튼과 
		함께 리스트 된다. 

[1단계:개념] 2. 게시판의 상세화면을 위한 프로세스와 이와 연결되는 코드 파일과 관련성을 기술하세요
1) DB처리
		- sql, 상세 조회/조회수
		SELECT * FROM board 
			WHERE NO = #{no} 
			UPDATE board 
		- vo
		- 공통
		- dao
			public Board getBoard(int no);
		- mapper
		<select id="getBoard" resultType="board" parameterType="int">
			SELECT * FROM board 
			WHERE NO = #{no} 
		</select> 
		- service
----------------------------------------------
	2) controller 및 화면 구현
		- no 키를 받은 상세 요청 controller 구현
			@GetMapping("board.do")
			public String getBoard(@RequestParam("no") String no, Model d){
				service.uptReadCnt(no);
				d.addAttribute("board",service.getBoard(no))
				return "a03_board";	
			}
		- 모델데이터 처리
		- 모델데이터 기반 상세화면 로딩 		
			게시글 번호, 답글 번호, 제목, 작성자, 조회수, 등록일, 수정일, 내용
	3) 화면단 구현
		- 리스트화면(a01_boardList.jsp)
			<tr ondblclick="goDetail(${no})">
			function goDetail(no){
				location.href="${path}/board.do?no="+no
			}
		- 상세화면(a03_board).jsp
			<input name="no" value="${board.no}"/>
			<input name="refno" value="${board.refno}"/>
			<input name="subject" value="${board.subject}"/>
			<input name="writer" value="${board.writer}"/>
			<input name="readcnt" value="${board.readcnt}"/>
			<input valye="${board.regdte}"/}
			<input valye="${board.uptdte}"/}
			<textarea name="conent">${board.content}</textarea>
[1단계:확인] 3. 현재프로젝트에 진행하는 게시물이나 등록/상세화면 내용이 있으면 그것으로 진행하고
      그외는 baseballtream테이블을 만들기 기준으로 스프링으로 팀리스트를 만들고, 팀등록과 상세화면을 처리하여 출력하세요.
       @GetMapping("/insertFrm.do")
		public String inserFrm(){
			return "a02_join.jsp";
		}
		@PostMapping("/insert.do")
		public String insert(OvMember ins, Model d){
			service.insertOvMember(ins);
			d.addAttribute("msg","회원가입완료");
			return "a02_join.jsp";
		}	
}
  	<insert id="insertOvMember" parameterType="OvMember">
		INSERT INTO ovmember values(#{id},#{pass},1,#{nickname},#{address},3000)			
	</insert>	    
      
[1단계:개념] 4. 파일 업로드를 위한 환경 설정을 기술하세요.
# 파일업로드와 다운로드
1. 기능
	1) 특정 파일을 등록하고, 서버의 특정 경로에 파일을 업로드 처리한다.
	2) 파일의 이름을 클릭하면, 서버에서 client로 파일을 다운로드 처리한다.
2. 환경 설정
	1) 스프링에서 지원하는 파일업로드 모듈 컨테이너에 설정
		<bean id="multipartResolver"
			class="org.springframework.web.multipart.CommonsMultipartResolver"/>
	2) 사용자 정의 다운로드 뷰 선언
	3) 공통 설정 파일 conf
		파일 서버의 경로 위치를지정 fileupload=c:\....
3. 개발 순서
	1) 업로드 화면 (jsp)
		- 업로드 파일 객체
			<input type="file" name="report"/>
		- form에서 파일을 stream으로 전달할 수 있는 속성값을 설정
			<form enctype="multipart/form-data"
	2) 컨트롤단 처리
		- 업로드 하는 파일을 받을 수 있는 요청객체 선언
			단일 데이터
				public String upload(@RequestParam("report") MultipartFile file)
		   VO 객체형
		   		class Board{
		   			private MultipartFile report;
		   			public void setReport(MultipartFile m)..
		   		} 		
		   		public String upload(Board board	
	3) 서비스단 처리
		- 네트웍을 통해 객체로 전달된 MultipartFile을 특정한 물리적
			위치로 저장할 수 있는 File 객체로 변환하여야 한다.
		- File객체는 특정한 물리적 위치기반 파일 생성.
		 	공통 파일로 지정한 ${fileupload}로 파일 위치를 접근하여
		 	업로드 처리 할 수 있다.
		- MultipartFile ==> File 변환
		ex) 게시판의 경우는 업로드 파일 정보를 특정한 게시물과 연관관계를
			설정하여야 첨부파일로 처리할 수 있다.
[1단계:확인] 5. /uploadFrm2.do로 업로드 화면, /upload2.do로 파일업로드 처리하게 처리하세요
 package springweb.a05_mvc.a01_controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class Z01_FileUploadController {
	//http://localhost:7080/springweb/uploadFrm2.do
	@GetMapping("/uploadFrm2.do")
	public String uploadFrm2() {
		return "WEB-INF\\views\\a05_mvc\\z10_fileUpload.jsp";
	}
	@PostMapping("/upload2.do")
	public String upload(@RequestParam("report") MultipartFile report) {
		System.out.println("####서버까지 온 파일:"+
							report.getOriginalFilename());
		return "WEB-INF\\views\\a05_mvc\\z10_fileUpload.jsp";
	}
	
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