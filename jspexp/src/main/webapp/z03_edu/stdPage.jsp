<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"    
    import="jspexp.vo.*"
    import="javaexp.sql.*"
    import="jspexp.a13_database.*"    
    import="jspexp.a13_database.vo.*"     
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
<link href="PJ_css/noticeNo1.css" type="text/css" rel="stylesheet">
<link href="PJ_css/input.css" type="text/css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
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
                <span id="tob-box2-span">ID ${mem.id} 학생</span>
               <span id="tob-box2-span"><input type="button" id="bt2" value="로그아웃" onclick="logout()" /></span>
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
                              <li><a href="noticeBoard.jsp">공지게시판</a></li>
                           </ul>
                        </li>
                        <li class="group">
                           <div class="title">수강신청</div>
                           <ul class="sub">
                              <li><a href="regLecture_01.jsp">수강신청</a></li>
                              <li><a href="regLecture_02.jsp">수강신청내역</a></li>
                              <li><a href="timeTable.jsp">시간표</a></li>
                           </ul>
                        </li>
                        <li class="group">
                           <div class="title">강의 관리</div>
                           <ul class="sub">
                              <li><a href="std_grade_sch.jsp">성적조회</a></li>
                              <li><a href="std_lecPlan_sch.jsp">강의계획서 조회</a></li>
                              <li><a href="std_lecEval_ins.jsp">강의평가</a></li>
                           </ul>
                        </li>
                        <li class="group">
                           <div class="title">학적 관리</div>
                           <ul class="sub">
                              <li><a href="std_inform_sch.jsp">학적정보</a></li>
                              <li><a href="std_inform_upt.jsp">학적정보 변경</a></li>
                              <li><a href="std_inform_uptpw.jsp">비밀번호 변경</a></li>
                              <li><a href="tuition_bill.jsp">등록금 고지서 조회</a></li>
                           </ul>
                        </li>
                     </ul>
                  </div>

               </div>
            </div>
          		<div class="main-box-flex">
						<div id="main-box2">
							<div>
								<div id="search-div">
									<form>
										<select name="condition" id="input01">
											<option value="title">제목</option>
											<option value="contents">내용</option>
											<option value="both">제목+내용</option>
										</select>
										<input type="text" name="search" id="input02" />
										<input type="submit" value="검색" id="btn01">
									</form>
								</div>
								<div id="table-div">
									<%
									String title = "";
									String contents = "";
									String condition = request.getParameter("condition");
									if (condition == null)
										condition = "";
									if (condition.equals("title")) {
										title = request.getParameter("search");
									} else if (condition.equals("contents")) {
										contents = request.getParameter("search");
									} else if (condition.equals("both")) {
										title = request.getParameter("search");
										contents = request.getParameter("search");
									}

									noticeDao dao = new noticeDao();
									noticeVO sch = new noticeVO(title, contents);
									%>
									
									<table width="1400">
										<col width="10px">
										<col width="100px">
										<col width="10px">
										<col width="50px">
										<col width="10px">
										<thead>
											<tr>
												<th>번호</th>
												<th>제목</th>
												<th>작성자</th>
												<th>등록일</th>
												<th>조회수</th>
											</tr>
										</thead>
										<tbody>
											<%
											for (noticeVO n : dao.getNotices(sch)) {
											%>
											<tr>
												<td><%=n.getNoticeNo()%></td>
												<td><a href="noticeNo3.jsp"/><%=n.getTitle()%></td>
												<td>관리자</td>
												<td><%=n.getNoticeDate()%></td>
												<td><%=n.getViews()%></td>
											</tr>
											<%
											}
											%>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div></div>
</body>
<script>
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
	
	// 로그아웃
function logout(){
    if(confirm("로그아웃하시겠습니까?")){
       location.href="a01_login_DB.jsp"
    }
 }
</script>
</html>