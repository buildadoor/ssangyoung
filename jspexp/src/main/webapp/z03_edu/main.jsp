<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쌍용 대학교</title>
<link href="PJ_css/main.css" type="text/css" rel="stylesheet">
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
					<span id="tob-box2-span">사용자</span>
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
										<li><a href="#">공지사항 조회</a></li>
										<li><a href="#">공지사항 등록</a></li>
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
								<span class="span-margin" id="span1">메뉴 이름</span>
							</div>
							<div>
								<span class="span-margin">메뉴이름 > 메뉴이름</span>
							</div>
						</div>
					</div>

					<div class="main-box-flex">
						<div id="main-box2">
							<div></div>
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
</script>
</html>