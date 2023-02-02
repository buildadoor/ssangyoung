<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"    
    import="jspexp.vo.*"
    import="javaexp.sql.*"
    import="jspexp.a13_database.*"    
    import="jspexp.a13_database.vo.*"     
    %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쌍용 대학교</title>
<link href="PJ_css/noticeNo2.css" type="text/css" rel="stylesheet">
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
					<span id="tob-box2-span">관리자</span>
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
										<li><a href="noticeNo2.jsp">공지사항 등록</a></li>
									</ul>
								</li>
								<li class="group">
									<div class="title">학적관리</div>
									<ul class="sub">
										<li><a href="#">학생관리</a></li>
										<li><a href="#">등록금 고지서 등록</a></li>
									</ul>
								</li>
								<li class="group">
									<div class="title">장학금 관리</div>
									<ul class="sub">
										<li><a href="#">학생성적 조회</a></li>
										<li><a href="#">장학생 등록</a></li>
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
								<span class="span-margin" id="span1">공지사항 조회</span>
							</div>
							<div>
								<span class="span-margin">공지사항 > 공지사항 등록</span>
							</div>
						</div>
					</div>
					<div class="main-box-flex">
						<div id="main-box2">
							<div>
								<div id="table-div">
									<%
									String title = request.getParameter("title");
									if (title == null)
										title = "";
									String contents = request.getParameter("contents");
									if (contents == null)
										contents = "";
									boolean isInsert = false;

									if (title != null && !title.equals("")) {
										noticeVO ins = new noticeVO(title, contents);
										noticeDao dao = new noticeDao();

										dao.insertNotice(ins);
										isInsert = true;
									}
									%>
									<form>
										<div id="title-div">
											<input type="text" placeholder="제목을 입력해주세요" name="title">
										</div>
										<div id="contents-div">
											<textarea rows="30" cols="50" placeholder="내용을 입력해주세요"
												name="contents"></textarea>
										</div>
										<div id="btn-div">
											<input type="button" onclick="regist()" value="등록"
												id="regBtn" />
										</div>
									</form>
									<script type="text/javascript">
										var isInsert =<%=isInsert%>;
										if (isInsert) {
											alert("등록성공!!")
											location.href = "noticeNo1.jsp"
											
										}
										function regist() {
											var title = document
													.querySelector("[name=title]")
											var contents = document
													.querySelector("[name=contents]")
											if (title.value == "") {
												alert("제목을 입력해주세요!")
												title.focus()
												return;
											}
											if (contents.value == "") {
												alert("내용을 입력해주세요!")
												contents.focus()
												return;
											}
											document.querySelector("form").submit();
										}
									</script>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
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
</script>
</html>