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
2023-02-08
[1단계:개념] 1. 게시판에서 파일 업로드 위해, 처리해야 할 DB 구조를 기술하세요.
 		dao public void insertUploadFile(BoardFile f);
        mybatis.xml BoardFile ==> boardFile
        Mapper.xml <select id="insertUploadFile" parameter="boardFile"

[1단계:개념] 2. 파일업로드를 위한 MultipartFile과 form화면 처리, VO처리, File과 각 코드별 상관 관계를 처리하세요.
      컨테이너, controller, vo, service처리, 화면단
환경설정 
      공통환경설정(업로드경로):resource\a00_config
         file.upload=webapp하위에 z01_upload폴드 지정
      컨테이너(업로드뷰):resource\a01_container.xml
         <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver"/>
      컨트롤러 호출(업로드기능메서드추가):A01_Controller.java
      	@Autowired(required=false)
	private A02_Service service;
	// http://localhost:7080/board/list.do
	@RequestMapping("/list.do")
	public String boardList(
			@ModelAttribute("sch") BoardSch sch,Model d) {
		d.addAttribute("list", service.boardList(sch));
		return "a01_boardList";
	}
	@GetMapping("/insertFrm.do")
	public String inserFrm(){
		return "a02_insertBoard";
	}
	@PostMapping("/insert.do")
	public String insert(Board ins, Model d){
		service.insertBoard(ins);
		d.addAttribute("msg","등록성공");
		return "a02_insertBoard";
	}	
      서비스(업로드 처리 메서드 추가):A02_Service.java
         private String uploadFile(MultiPartFile f) // 특정 위치에 업로드
         public void insertBoard(Board ins){
            BoardFile f = new BoardFile()
            dao.insertUploadFile(f);
            uploadFile(ins.getReport());
      DB처리(업로드 정보 저장)
         A03_Dao.java
            public void insertUploadFile(BoardFile f);
         a02_mybatis.xml
            BoardFile ==> boardFile
         a03_Mapper.xml
            <select id="insertUploadFile" parameter="boardFile"
      VO(업로드 처리 요청 객체 추가): 
      	 Board.java (MultiPartFile report, String fname)
         BoardFile.java(no, fname, regdte, uptdte, etc)
      화면단(파일 첨부 처리): a02_insertBoard.jsp
      	<input type="file" name="report"/>
      화면단(첨부된 리스트 처리): a03_board.jsp
         <input value="${board.fname}"
   2) 환경 설정
      파일업로드 컨테이너 선언
    	 <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver"/>
      파일업로드할 파일서버 경로 위치 공통 설정파일 선언
     	 user.upload=C:\a01_javaexp\workspace\board2\src\main\webapp\z01_upload
   3) DB 처리
      테이블 생성
      	 create table boardfile(
      	 	no number,
      	 	fname varchar2(500),
      	 	etc varchar2(500),
      	 	regdte date, 
      	 	uptdte date
      	 );
      sql 작성
		insert into boadfile values(board_seq.currval,
		'a01.text','파일등록',sysdate,sysdate);

		select fname
		from boardfile
		where no = 1000;
      vo 
		no, fname, etc, regdte, uptdte
      mybatis 공통
      	boardfile
      dao
      	public void insertUploadFile(BoardFile f);
      	public String getBoardFile(int no);
      mapper
      	<insert id="insertBoard" parameterType="board">
		INSERT INTO board values(board_seq.nextval,
			#{refno}, #{subject},#{content},#{writer},
			0, sysdate, sysdate)			
		</insert>	
		<select id="getBoard" resultType="board" parameterType="int">
			SELECT * FROM board
			WHERE NO = #{no}			
		</select>
   4) controller/service단 구현
   	@Value("${user.upload}"}
   	private String upload;
   
 	private String uploadFile(MultiPartFile f){
		if(report!=null){
			String fname = report.getOriginalFilename();
			if( fname!=null && !fname.equals(""){
				File fObj = new File(upload+fname);
				try{
					f.transferTo(fObj);
				}catch(Exception e){
					System.out.println("업로드예외"+e.getMessage());
				}
			}
		}
	}
 	public void insertBoard(Board ins){
        String fname = ins.getReport().getOriginalFilename();
        if( !fname.equlas("")){
        	uploadFile(ins.getReport());
        	BoardFile f = new BoardFile();
        	f.setFname(fname);
        	f.setEct(ins.getTitle());
        	dao.imsertIploadFile(f);
        }
			         
       dao.insertUploadFile(ins);
    }
    public Board getBoard(int no) {
		Board b = dao.getBoard(no);
		b.setFname(dao.getBoardFile(no));
		return b;
    }
   
   5) 화면단 구현(등록)
   		<form enctype="multipart/form-data">
   		<div class="custom-file">
		        <input type="file" name="report" class="custom-file-input" id="file01">
		        <label class="custom-file-label" for="file01">파일을 선택하세요!</label>
		</div>
		$(".custom-file-input").on("change",function(){
        	$(this).next(".custom-file-label").text($(this).val())
        })	  
   6) 화면단 구현(상세화면)
   		<input type="text" value="${board.fname}">
[1단계:개념] 3. 게시판에서 파일다운로드를 위해서 처리해야할 환경과 처리 순서를 기술하세요.
환경	1) 상세화면에서 파일을 클릭시,
	2) 다운로드 컨트롤러를 파일명과 함께 전달
	3) 다운로드 컨트롤러에서 모델데이터 파일명 설정
	4) 다운로드 viewer 호출 
순서	1) 다운로드 viewer 구현
		- 모델명(파일명)
	2) 컨테이너에 등록 
	3) 다운로드컨트롤러 메서드 추가..
		요청값 : name
		모델명 name 설정
		다운로드 뷰어 호출..
	4) 화면단
		파일클릭시, 컨트롤러 호출 location.href
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