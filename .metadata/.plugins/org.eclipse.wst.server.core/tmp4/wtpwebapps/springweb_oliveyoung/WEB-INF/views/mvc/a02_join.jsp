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


 --%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css" >
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css" >

  <style>
    body {
      min-height: 100vh;
    }

    .input-form {
      max-width: 680px;

      margin-top: 80px;
      padding: 32px;

      background: #fff;
      -webkit-border-radius: 10px;
      -moz-border-radius: 10px;
      border-radius: 10px;
      -webkit-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
      -moz-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
      box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15)
    }
  </style>
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var msg = "${msg}"
		if(msg!=""){
			if(confirm(msg+"\n 조회화면으로 이동하시겠습니까?")){
				location.href="${path}/ovMemberList.do"
			}
		}
		$("#goMain").click(function(){
			location.href="${path}/ovMemberList.do"			
		});
		$("#regBtn").click(function(){
			var isInValid = false
			for(var idx=0;idx<$(".ckValid").length;idx++){
				if($(".ckValid").eq(idx).val()==""){
					alert("필수정보를 입력해주세요.")
					$(".ckValid").eq(idx).focus()
					isInValid = true
					break;
				}
			}
			if(isInValid){
				return
			}
			$("form").submit()
		})
	});
</script>
</head>
<body>
    <!-- Topbar Start -->
    <div class="container-fluid">
        <div class="row align-items-center py-3 px-xl-5">
            <div class="col-lg-4 d-none d-lg-block">
                <a href="" class="text-decoration-none">
                  　<img style="width:80%" src="project_oliveyoung/img/main.png">
                </a>
            </div>
            <div class="col-lg-3 col-3 text-left">
                <form action="">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Search for products">
                        <div class="input-group-append">
                            <span class="input-group-text bg-transparent text-success">
                                <i class="fa fa-search"></i>
                            </span>
                        </div>
                    </div>
                </form>
            </div>
            <div style="margin-left:150px;" class="col-lg-4 col-4">
               <a class="text-dark" href="">회원가입</a>
               <span class="text-muted px-2">|</span>
               <a class="text-dark" href="">로그인</a>
               <span class="text-muted px-2">|</span>
               <a class="text-dark" href="">고객센터</a>
        </div>
        </div>
    </div>
    <!-- Topbar End -->
      <!-- Navbar Start -->
    <div style="margin-top:30px" class="container-fluid">
        <div class="row border-top px-xl-5">
            <div class="col-lg-3 d-none d-lg-block">
                <a class="btn shadow-none d-flex align-items-center justify-content-between bg-success text-white w-100" data-toggle="collapse" href="#navbar-vertical" style="height: 65px; margin-top: -1px; padding: 0 30px;">
                    <h6 class="m-0"><b>카테고리</b></h6>
                    <i class="fa fa-angle-down text-dark"></i>
                </a>
                <nav class="collapse position-absolute navbar navbar-vertical navbar-light align-items-start p-0 border border-top-0 border-bottom-0 bg-light" id="navbar-vertical" style="width: calc(100% - 30px); z-index: 1;">
                    <div class="navbar-nav w-100 overflow-hidden" style="height: 410px">
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link" data-toggle="dropdown">기초화장품 <i class="fa fa-angle-down float-right mt-1"></i></a>
                            <div class="dropdown-menu position-absolute bg-secondary border-0 rounded-0 w-100 m-0">
                                <a href="" class="dropdown-item">스킨케어</a>
                                <a href="" class="dropdown-item">마스크팩</a>
                                <a href="" class="dropdown-item">클렌징</a>
                                <a href="" class="dropdown-item">선케어</a>
                            </div>
                        </div>
                        <a href="" class="nav-item nav-link">더모코스메틱</a>
                        <a href="" class="nav-item nav-link">메이크업/네일</a>
                        <a href="" class="nav-item nav-link">바디케어</a>
                        <a href="" class="nav-item nav-link">헤어케어</a>
                        <a href="" class="nav-item nav-link">향수/디퓨저</a>
                    </div>
                </nav>
            </div>
                <div class="col-lg-9">
                <nav class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0">
                    <a href="" class="text-decoration-none d-block d-lg-none">
                        <h1 class="m-0 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border px-3 mr-1">E</span>Shopper</h1>
                    </a>
                    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                        <div class="navbar-nav mr-auto py-0">
                            <a href="index.html" class="nav-item nav-link"><b>오특</b></a>
                            <a href="index.html" class="nav-item nav-link"><b>신상</b></a>
                            <a href="index.html" class="nav-item nav-link"><b>랭킹</b></a>
                            <a href="index.html" class="nav-item nav-link"><b>프리미엄관</b></a>
                            <a href="index.html" class="nav-item nav-link"><b>기획전</b></a>
                            <a href="index.html" class="nav-item nav-link"><b>세일</b></a>
                            <a href="index.html" class="nav-item nav-link"><b>기프트카드</b></a>
                            <a href="index.html" class="nav-item nav-link"><b>멤버쉽/쿠폰</b></a>
                            <a href="index.html" class="nav-item nav-link"><b>이벤트</b></a>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
    </div>
    
    <div class="input-form-backgroud row">
      <div class="input-form col-md-12 mx-auto">
        <h4 class="mb-3">회원가입</h4>
        <form method="post" action="${path}/insert.do" class="validation-form" novalidate>
        	<input type="hidden" name="refno" value="0"/>
          <div class="mb-3">
            <label for="id">아이디</label>
            <input name="id" type="text" class="form-control  ckValid" placeholder="아이디를 입력" required>
            <div class="invalid-feedback">
              아이디를 입력하세요
            </div>
          </div>
          <div class="mb-3">
            <label for="pass">비밀번호</label>
            <input type="password" name="pass" class="form-control ckValid"  placeholder="비밀번호를 입력" required>
            <div class="invalid-feedback">
              비밀번호를 입력해주세요.
            </div>
          </div>   
          <div class="mb-3">
            <label for="nickname">이름</label>
            <input type="text" name="nickname" class="form-control ckValid" placeholder="이름을 입력" required>
            <div class="invalid-feedback">
              이름을 입력해주세요.
            </div>
          </div>   
          <div class="mb-3">
            <label for="address">주소</label>
            <input type="text" name="address" class="form-control ckValid"  placeholder="주소를 입력" required>
            <div class="invalid-feedback">
              주소를 입력해주세요.
            </div>
          </div>   
          <div class="mb-4"></div>
          <button id="regBtn" type="button" style="background-color:#A6CD48">회원가입</button>
		<!-- 
	      <button id="goMain" type="button" style="background-color:#A6CD48">조회 화면</button>
         -->
        </form>
      </div>
    </div>
</body>
</html>