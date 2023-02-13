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
2023-02-07
[1단계:개념] 1. 파일 업로드시, DB에 넣는 이유와  DB에 처리되는 처리 프로세스를 기술하세요
업로드된 파일을 기준으로 이미지 화면을 보거나 다시 첨부파일로 등록 하여 사용할 때,
DB에 등록하여 다른 정보와 함께 처리하여야 한다.
[1단계:확인] 2. /upload4.do 컨트롤러,  a11_upload.jsp  vo(FileExpVo.java) 자료내용(content), 파일객체(report)
               table fileexp(no, content, fname)  webapp/z03_upload 폴드
               화면 : 파일내용:[     ] 파일:[    ]  파일을 업로드 처리하고 DB에 등록 하세요.
               1) DB단 처리
		create table filerep2(
			no number,
			title varchar2(100),
			path varchar2(500),
			tempfile varchar2(100),
			fname varchar2(100),
			etc varchar2(200),
			regdte date,
			uptdte date
		);	
               2) controller 단 화면단 처리
        public String upload4(@RequestParam(value = "report", required = false) MultipartFile report, Model d) {
      if (report != null && service3.uploadFile(report) != null) {
         d.addAttribute("msg", "업로드 성공");
      }
      return "WEB-INF\\views\\a05_mvc\\a14_fileUpload.jsp";
   }         
               
 3) view단 처리
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
		var msg="${msg}"
		if(msg!=""){
			alert(msg)
		}
	});
</script>
</head>

<body>
<div class="jumbotron text-center">
  <h2>파일 업로드</h2>

</div>
<div class="container">
	<form id="frm01" enctype="multipart/form-data" 
		class="form"  method="post">
  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <input type="file" name="report" class="form-control mr-sm-2"/>
	    <button class="btn btn-info" type="submit">파일업로드</button>
 	</nav>
	</form>
</body>
</html>
               
               
[1단계:확인] 3. 위 등록된 리스트를 /filelist3.do로 출력한다.
   @RequestMapping("/fileList3.do")
   public String fileList3(@RequestParam(value="title", defaultValue="")String title, Model d) {
      d.addAttribute("flist",service.getFileList(title));
      return "WEB-INF\\views\\a05_mvc\\a14_fileUpLoadList.jsp";
   }
[1단계:개념] 4. 파일 다운로드시 필요한 처리 프로세스를 설명하세요
	1) 웹 화면에 리스트된 파일을 클릭하면, 해당 파일 이름 요청값으로 다운로드 컨트롤러 호출
	2) url과 파일을 받아서 특정 controller 메서드를 호출하고,
	3) 다운로드 view를 통해 요청 파일명을 통해 다운로드 처리 한다.

[1단계:개념] 5. 다운로드 viewer의 구현의 핵심 선언 내용 4가지를 기술하세요
	1. 파일 객체 생성
		 		파일다운로드 컨트롤러에서 모델명으로 온 파일명 정보를 가져온다.
		      model.addAttribute("downloadFile", 파일명)
			1) 파일명 선언
		String fname = (String)model.get("downloadFile");
			2) 경로명과 함께 파일 객체 생성
		File file = new File(upload+fname);
		
		 2. 파일 객체를 client에 전달하기 위한 response 객체 속성 선언
			1) 파일을 클라이언트 전달하기 위해 contentType 설정
		response.setContentType("application/download;charset=utf-8");
			2) 전달할 파일을 크기 설정
		response.setContentLengthLong((int)file.length());
		  3) 헤더정보에 파일명을 입력하는데, 한글일 경우 encoding을 처리해야 한다.
		fname = URLEncoder.encode(fname,"utf-8").replaceAll("\\+"," ");
		 attachment;filename="파일명"
		response.setHeader("Content-Disposition", "attachment;filename=\""+fname+"\"");
		  4)헤더정보를 통해서 binary데이터 전송
		response.setHeader("Content-Transfer-Encoding", "binary");
		 3. FileInputStream으로 파일 객체 탑제, response객체의 OutputStream으로 
		    스트림으로 client에 보내기
		FileInputStream fis = new FileInputStream(file);
		OutputStream out = response.getOutputStream();
		 	1) FileCopyUtils를 통해 파일 객체를 outstream에 할당.
		FileCopyUtils.copy(fis, out);
		 4. response객체의 stream 자원 해제..
		out.flush();
[1단계:확인] 6. Z02_Viewer를 만들고 z01_upload에 처리된 파일을 다운 받게 하면 모델명으로 filename으로 설정된 파일을
               다운로드 하게 선언하고,   A02_DownController.java에서  download2.do 로 다운로드 되게 하세요.
public class Z02_DownloadView extends AbstractView{
	@Value("${file.upload2}")
	private String upload;

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, 
			HttpServletRequest requst, HttpServletResponse response)
			throws Exception {
		String fname = (String)model.get("downloadFile");
		File file = new File(upload+fname);
		response.setContentType("application/download;charset=utf-8");
		response.setContentLengthLong((int)file.length());
		fname = URLEncoder.encode(fname,"utf-8").replaceAll("\\+"," ");
		response.setHeader("Content-Disposition", "attachment;filename=\""+fname+"\"");
		response.setHeader("Content-Transfer-Encoding", "binary");
		FileInputStream fis = new FileInputStream(file);
		OutputStream out = response.getOutputStream();
		FileCopyUtils.copy(fis, out);
		out.flush();
	}
	
}
 
@Controller
public class A02_DownLoadCtrl {
	@GetMapping("/download2.do")
	public String download(@RequestParam("fname") String fname, Model d) {
		d.addAttribute("downloadFile", fname);
		return "downloadViewer";
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