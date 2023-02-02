<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"    
    import="jspexp.vo.*"
    import="javaexp.sql.*"
    import="jspexp.a13_database.*"    
    import="jspexp.a13_database.vo.*"     
    %>
<%
 	// post방식에서 한글요청값을 받을 때, 반드시 설정되어야한다.
 	request.setCharacterEncoding("utf-8");
 %>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 <fmt:requestEncoding value="UTF-8"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>쌍용대학교</title>
		<link href="img/ss.png" rel="shortcut icon" type="image/x-icon">
		<link href="PJ_css/main.css" type="text/css" rel="stylesheet">
		<script type="text/javascript"
  		 src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
  		 <script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>

	</head>
	<body>
	<div>
      <div>
         <div class="flex-box1">
            <div id="box1">
               <div id="top-box1">
                  <span id="tob-box1-span">쌍용대학교</span>
               </div>

            </div>
            <div id="top-box2">
 			   <span id="tob-box2-span">${pro.proName} 교수</span>
               <span id="tob-box2-span"><input type="button" id="bt2" value="로그아웃" onclick="logout()"></span>
            </div>
         </div>
		
         <div class="flex-box2">
            <div id="flex-box2_box1">
               <div>
                  <div id="nav-box">
                    <ul id="navi">                   
                        <li class="group">
							<div class="title">공지사항</div>
							<ul class="sub">
								<li><a href="noticeNo1.jsp">공지사항 조회</a></li>
							</ul>                       	
                           <div class="title">강의 관리</div>
                           <ul class="sub">
							  <li><a href="lectureadd.jsp">강의 등록</a></li>
                              <li><a href="lecturemodify.jsp">강의 수정</a></li>
                              <li><a href="lecturedelete.jsp">강의 삭제</a></li>
                              <li><a href="lecEval.jsp?id=${pro.id}">강의평가 조회</a></li>
                              <li><a href="lecplanadd.jsp">강의계획서 관리</a></li>
                           </ul>
                        </li>
                        <li class="group">
                           <div class="title">성적 관리</div>
                           <ul class="sub">
                              <li><a href="schStudent.jsp?id=${pro.id}">성적 입력</a></li>
                           </ul>
                        </li>
                        <li class="group">
                           <div class="title">학생관리</div>
                           <ul class="sub">
                              <li><a href="search.jsp">학생 조회</a></li>
                              <li><a href="sendemail.jsp">이메일 발송</a></li>
                              <li><a href="studentAt.jsp">출결 관리</a></li>
                           </ul>
                        </li>
                     </ul>
                  </div>

               </div>
            </div>
            <div id="flex-box2_box2">
               <div class="main-box-flex">
                  <div id="main-box1">
                     <div id="main-box1-iteam">
                        <span class="span-margin" id="span1">성적입력</span>
                     </div>
                     <div>
                        <span class="span-margin">성적관리 > 성적입력</span>
                     </div>
                  </div>
               </div>


				<jsp:useBean id="dao" class="jspexp.a13_database.A01_schStudent"/>
				<jsp:useBean id="sch" class="jspexp.a13_database.Student"/>
				<jsp:setProperty property="*" name="sch"/>
				<%
				String lecNum = request.getParameter("lecNum");
				int lecNumInt = 0;
				if(lecNum != null) lecNumInt = Integer.parseInt(lecNum);
				session.setAttribute("lecNum", lecNumInt);
				
				if(lecNum != null){
				%>
				<c:if test="${lecNum eq lecNumInt}">${sch.setLecNum(lecNumInt)}</c:if>
				<% } %>
			
               <div class="main-box-flex">
                  <div id="main-box2">
                     <div id="subtitle">수강생리스트 | 과목명</div>
					
                     <table>
                         <col width="20%">
                         <col width="20%">
                         <col width="20%">
                         <col width="20%">
                         <col width="20%">
                         <thead>
                            <tr><th>학번</th><th>이름</th><th>학과</th><th>학년</th><th>성적관리</th></tr>
                         </thead>
                         <tbody>
                        	<c:forEach var="std" items="${dao.schStu(sch)}">
                            <tr>
								<td>${std.id}</td>
								<td>${std.stdName}</td>
								<td>${std.majorName}</td>
								<td>${std.stdYear}</td>
								<td>
									<a onclick="inputGrade(${std.id})" class="entry"><span>입력/수정</span></a>
									<a onclick="delGrade(${std.id})" class="del"><span>삭 제</span></a>
								</td>
							</tr>
							</c:forEach>
                         </tbody>
                      </table>
                  </div>
               </div>
               
               
            </div>
         </div>

      </div>
    </div>
		
	</body>
	<script type="text/javascript">
	 $(document).ready(function() {

	      //모든 서브 메뉴 감추기
	      $(".sub").css({
	         display : "none"
	      });
	      //$(".sub").hide(); //위코드와 동일 

	      $(".title").click(function() {
	         //일단 서브메뉴 다 가립니다.
	         //$(".sub").css({display:"none"});

	         //열린 서브메뉴에 대해서만 가립니다.
	         $(".sub").each(function() {
	            console.log($(this).css("display"));
	            if ($(this).css("display") == "block") {
	               //$(".sub").css({display:"none"});
	               //$(this).hide();
	               $(this).slideUp("fast");
	            }
	         });

	         //현재 요소의 다음 요소를 보이게 합니다.
	         //$(this).next("ul").css({display:"block"});
	         //$(this).next("ul").show();
	         $(this).next("ul").slideDown("fast");

	      })
	   });
	 
	 function logout(){
		  Swal.fire({
			  title: '로그아웃하시겠습니까?',
			  icon: 'question',
			  showCancelButton: true, // cancel버튼 보이기. 기본은 원래 없음
			  confirmButtonColor: '#3085d6', // confrim 버튼 색깔 지정
			  cancelButtonColor: '#d33', // cancel 버튼 색깔 지정
			  confirmButtonText: '확인', // confirm 버튼 텍스트 지정
			  cancelButtonText: '취소' // cancel 버튼 텍스트 지정
			}).then((result) => {
			  if (result.value) {
	              //"삭제" 버튼을 눌렀을 때 작업할 내용을 이곳에 넣어주면 된다. 
				  location.href="a01_login_DB.jsp"
	              
			  }
			})

	      }
	 
	 
	 //성적 입력/수정 페이지 이동
	  var lecNumInt = <%=lecNumInt %>
    function inputGrade(id) {
         location.href="inputGrade.jsp?id="+id+"&lecNum="+lecNumInt;
    }
	 
	 
	 
	 //성적 삭제
	 function delGrade(id) {
		 Swal.fire({
			  title: '해당 학생의 성적을\n삭제하시겠습니까?',
			  text: "삭제한 성적은 다시 복구시킬 수 없습니다.",
			  icon: 'warning',
			  showCancelButton: true, 
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: '확인', 
			  cancelButtonText: '취소'
			}).then((result) => {
				  if (result.value) {s
					  location.href="delGrade.jsp?id="+id+"&lecNum="+lecNumInt;
				  }
		 	})
	 }
	 
	 
	</script>
</html>