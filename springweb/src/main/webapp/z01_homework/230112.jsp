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
<%--
2022-01-12
[1단계:개념] 1. jquery의 선택자 선언형식과 특징을 기술하세요
선택자 선언형식
	* : 모든 요소를 선택
	요소명 : 요소 이름을 기반으로 선택
	.클래스명 : 클래스 속성을 기반으로 선택
	#id명 : id 속성을 기반으로 선택
	
	- $는 jQuery를 선언하거나 접근할 때 사용 (선택자)
	- $는 jQuery의 별칭
	- 따라서 $(selector).action(), jQuery(selector).action() 둘 다 사용 가능
	- selector는 css와 같은 선택자 (id 선택자, class 선택자 등)
	- action()은 HTML에서 요소를 가지고 설정하는 함수
특징
     DOM과 관련된 처리를 쉽게 구현
     일관된 이벤트 연결을 쉽게 구현
     시각적 효과를 쉽게 구현
     Ajax 애플리케이션을 쉽게 구현
     
[1단계:확인] *2. 1X4테이블에서 td의 배경색상을 파랑색, 글자정렬 중앙으로 처리하고, 판매하는 과일명을 리스트하고, 클릭시마다 하단 p에 구매한 과일정보를 출력하세요
$(document).ready(function(){
		$("h2").text("2번 문제")
	    $("td").mouseenter(function(){
		   $(this).css({background: "blue",textAlign:"center"})
		})
	
		
	});
</script>
</head>
<body>
	  <h2></h2>
	  <table width="400" height="400" border>
	<tr><td></td><td></td><td></td><td></td></tr>
  	</table>
ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ해설 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/springweb/a00_com/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    $("#tab01 td").css({
    	background:"blue",
    	color:"yellow",
    	textAlign:"center",
    	fontSize:"30pt"
    }).click(function(){
    	var fruit = $(this).text()
    	$("#buyList").text($("#buyList").text()+fruit+",")
    	//$("#buyList").append(fruit+",")
    })
});
</script>
</head>
<body>
  <h2>물건구매</h2>

  <table id="tab01" height="100" border>
	<tbody>
		<tr><td>사과</td><td>바나나</td>
		<td>딸기</td><td>오렌지</td></tr>
	</table>
	</tbody>
	<p id="buyList"></p>
</body>
</html>
[1단계:확인] 3. 5X4테이블 행열단위로 짝/홀단위 배경색상을 다르게 처리하고, 커서에 따라 글자크기와 글자색상으로 다르게 처리하세요
[1단계:개념] 4. jquery의 이벤트의 종류와 내용을 기술하세요.
로딩이벤트 
 -로딩이 되었을 때 
마우스이벤트 
 -클릭, 더블클릭, 호버 등
키보드이벤트 
 -눌렀을 때, 떼었을 때 
포커스이벤트 
- 선택한 요소에 생성, 이동, 선택한 요소의 값이 바뀌었을 때 


[1단계:확인]* 5. 3X3테이블에 각 td마다 마우스 커서와 커서를 벗어났을 때, 배경색상을 변경하고, 클릭시 마다 카운트가 증가되게 처리하세요
ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ풀이 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/springweb/a00_com/jquery.min.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	$("#tab02 td").css("text-align","center"
	).hover(function(){
		 $(this).css("background","yellow")
		},function(){
		 $(this).css("background","orange")
		})
	var cnt=0;
	$("#tab02 td").click(function(){
		$("#cnt01").text("카운트:"+(++cnt))
	})
		
	});
</script>
</head>
<body>
	 <span id="cnt01">카운트:0</span>
	<table id="tab02" boder height="300px" width="300px">
	<tr><td>1</td><td>2</td><td>3</td></tr>
	<tr><td>4</td><td>5</td><td>6</td></tr>
	<tr><td>7</td><td>8</td><td>9</td></tr>
</table>
</body>
</html>



ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/springweb/a00_com/jquery.min.js"></script>
<script type="text/javascript">

$(document).ready(function(){
		$("h2").text("5번 문제")
		var cnt=0;
	    $("td").mouseenter(function(){
		   $(this).css("background", "aliceblue")
		   $(this).text(cnt)
		   cnt++
		})
	    $("td").mouseleave(function(){
		   $(this).css("background","yellow")
		})
		
		
	});
</script>
</head>
<body>
	  <h2></h2>
	  <table width="400" height="400" border>
	<tr><td></td><td></td><td></td></tr>
	<tr><td></td><td></td><td></td></tr>
	<tr><td></td><td></td><td></td></tr>
  	</table>
</body>
</html>

ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ합친거
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/springweb/a00_com/jquery.min.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	$("#tab01 td").css({
    	background:"blue",
    	color:"yellow",
    	textAlign:"center",
    	fontSize:"30pt"
    }).click(function(){
    	var fruit = $(this).text()
    	$("#buyList").text($("#buyList").text()+fruit+",")
    	//$("#buyList").append(fruit+",")
    })
	$("#tab02 td").css("text-align","center"
	).hover(function(){
		 $(this).css("background","yellow")
		},function(){
		 $(this).css("background","orange")
		})
	var cnt=0;
	$("#tab02 td").click(function(){
		$("#cnt01").text("카운트:"+(++cnt))
	})
		
	});
</script>
</head>
<body>
 <h2>물건구매</h2>

  <table id="tab01" height="100" border>
	<tbody>
		<tr><td>사과</td><td>바나나</td>
		<td>딸기</td><td>오렌지</td></tr>
	</table>
	</tbody>
	<p id="buyList"></p>
	 <span id="cnt01">카운트:0</span>
	<table id="tab02" boder height="300px" width="300px">
	<tr><td>1</td><td>2</td><td>3</td></tr>
	<tr><td>4</td><td>5</td><td>6</td></tr>
	<tr><td>7</td><td>8</td><td>9</td></tr>
</table>
</body>
</html>
ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
[1단계:확인]* 6. member테이블의 항목을 회원정보 등록 화면 form으로 만들고 유효성을 처리하세요(모두 입력처리, 아이디(5~16), 패스워드, 패스워드 확인 )
	$(document).ready(function(){
		$("h2").text("form객체 관련 이벤트")
		/*
		1. keyup/keydown : 입력시 처리되는 이벤트 : event.keyCode
		2. focus/blur : 포커싱 되었을 때, 처리되는 이벤트 
		*/
		$("input").on({
			focus:function(){
				$(this).css({"background":"pink","font-size":"15pt"})
			},
			blur:function(){
				$(this).css({"background":"","font-size":"100%"})
			},
			keyup:function(){
				//jquery에서 form객체의 value 속성은 .val()읽기, .val("himan") 쓰기 처리
				var len=$(this).val().length
				if(event.keyCode==13){
					if(len==0){
						alert("데이터를 입력하세요")
					}
				}
			}
		})
		$("#etc").keyup(function(){
			var str = $(this).val()
			var len = str.length
			if(len>=16){
				$(this).css("background","yellow")
				alert("글자수 초과입니다.")
				$(this).val(str.substring(5,16))
				len--
			}
			$("#wordCnt").text(len+"/20")
		})
	});
</script>
</head>
<body>
	  <h2></h2>
	  이름:<input type="text" name="name"/><br>
	  아이디:<input id="etc" type="text" name="id"/><br>
	  패스워드:<input type="password" name="pass"/><br>
	  패스워드확인:<input type="password" name="pass"/><br>
	  주소:<input type="password" name="address"/><br>

ㅡㅡㅡㅡㅡㅡㅡㅡ
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>회원가입 화면 샘플 - Bootstrap</title>

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

  <style>
    body {
      min-height: 100vh;

      background: -webkit-gradient(linear, left bottom, right top, from(#92b5db), to(#1d466c));
      background: -webkit-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);
      background: -moz-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);
      background: -o-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);
      background: linear-gradient(to top right, #92b5db 0%, #1d466c 100%);
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
<script src="/springweb/a00_com/jquery.min.js"></script>
<script type="text/javascript">
   $(document).ready(function(){
      $("h4").text("회원가입 jquery유효성")
      /* id, pass, pass확인, 이름, 권한, 포인트 */
      // form  하위에 내용은 자동을 enter키를 통해서 submit
      // 되는 기본적인 속성이 있다. 이를 방지하기 위해서
      // event.preventDefault()를 설정하여야 한다.
      $("input").keydown(function(){
         //console.log(event.keyCode)
         if(event.keyCode===13){
            console.log(event.keyCode)
            event.preventDefault();
         }
      })
      
   });
</script>   
  
  
</head>

<body>
  <div class="container">
    <div class="input-form-backgroud row">
      <div class="input-form col-md-12 mx-auto">
        <h4 class="mb-3">회원가입</h4>
        <form class="validation-form" novalidate>
           <input hidden="hidden" />
          <div class="mb-3">
            <label for="id">아이디</label>
            <input type="text" class="form-control" 
               id="id" name="id" 
               placeholder="아이디입력하세요" required>
            <div class="invalid-feedback">
             아이디를 입력해주세요
            </div>
          </div>   
          <script>
             //  범위 및 ajax 처리
             $("#id").keyup(function(){
                if(event.keyCode==13){
                   var idLen = $(this).val().length
                   if( !(idLen>=5 && idLen<=16) ){
                      alert("아이디는 5~16사이로 입력합니다.")
                   }else{
                      // ajax 처리로 등록여부 확인 처리 후,
                      // 해당 결과에 따라 유효성 메세지 표시
                      
                   }
                }
             })
             
             
          
          </script>
               
           <div class="row">
            <div class="col-md-6 mb-3">
              <label for="pass">패스워드</label>
              <input type="password" class="form-control" 
                 id="pass" name="pass" placeholder="패스워드 입력해주세요" value="" required>
              <div class="invalid-feedback">
                패스워드 입력해주세요
              </div>
            </div>
            <div class="col-md-6 mb-3">
              <label for="passFrm">패스워드확인</label>
              <input type="password" class="form-control"
                  id="passFrm" placeholder="패스워드 확인 입력해주세요" value="" required>
              <div class="invalid-feedback">
                패스워드 확인 입력해주세요
              </div>
            </div>
          </div>  
          <script type="text/javascript">
             var passVal = $("#pass").val()
             var passFrmVal = $("#passFrm").val()
             if(passVal.length>0){
                if(passVal!=passFrmVal){
                   alert("패스워드와 패스워드 확인이 같지 않습니다.")
                }
                
             }else{
                alert("패스워드를 입력하세요")
             }
          
          </script>
           
          <div class="mb-3">
              <label for="name">이름</label>
              <input type="text" class="form-control" 
              id="name" placeholder="이름을 입력해주세요." value="" required>
              <div class="invalid-feedback">
                이름을 입력해주세요.
              </div>
          </div>
                       
          <div class="row">
            <div class="col-md-6 mb-3">
              <label for="auth">권한</label>
              <select class="custom-select d-block w-100" id="auth">
                <option value="">권한을 선택하세요</option>
                <option>관리자</option>
                <option>일반사용자</option>
                <option>방문객</option>
              </select>              
              <div class="invalid-feedback">
                권한을 설정해주세요
              </div>
            </div>
            <div class="col-md-6 mb-3">
              <label for="point">포인트</label>
              <input  type="number" name="point" class="form-control" id="point"
               placeholder="기본 포인트를 입력해주세요 " value="1000" required>
              <div class="invalid-feedback">
                기본 포인트를 입력해주세요 
              </div>
            </div>
            
          </div>
          <hr class="mb-4">
          <div class="custom-control custom-checkbox">
            <input type="checkbox" class="custom-control-input" id="aggrement" required>
            <label class="custom-control-label" for="aggrement">개인정보 수집 및 이용에 동의합니다.</label>
          </div>
          <div class="mb-4"></div>
          <button id="regBtn" class="btn btn-primary btn-lg btn-block"
              type="button">가입 완료</button>
              
        </form>
           <script type="text/javascript">
              $("#regBtn").click(function(){
                 if(confirm("가입하시겠습니까?")){
                    // 위에 선언된 유효성 check
                    // 1. 공백, id DB확인 부분(hidden)
                    // 2. pass, passFrm처리 
                    $("form").submit()
                 }
                 
              })
           </script>
      </div>
    </div>
    <footer class="my-3 text-center text-small">
      <p class="mb-1">&copy; 2021 YD</p>
    </footer>
  </div>

</body>

</html>
-----------------------------------------------------------------------		  
[1단계:개념] 7. jquery의 속성 선언 형식을 기술하세요.
다운로드에서 압축되지 않은 페이지에서 다른 이름으로 저장하여 css파일 저장
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css" >
[1단계:확인] *8. 회원등록화면에서 회원이미지를 [이미지보이기/보이지않게]로 클릭하면서 확인했다가/사라졌다를 클릭에 따라 반복하게 하세요.
 $(document).ready(function() {
    	$("h2").text("8번 문제")
        $("#btn").click(function() {
            if($("#displayDiv").css("display") == "none") {
                $("#displayDiv").css("display", "block");
            }
            else {
                $("#displayDiv").css("display", "none");
            }
        });
    });
</script>
</head>
<body>
    <h2></h2>
    <button type="button" id="btn">보기 또는 숨기기</button>
    <div id="displayDiv">
        <img src="2.jpeg" width="400" height="300">
    </div>   
</body>
[1단계:개념] 9. 모델어트리뷰트란 무엇인가? 개념과 실제 사용 방법에 대하여 기술하세요.
# 모델어트리뷰를 통한 DB와 연결된 공통 COMBOX생성
1. select형태의 콤보형선택은 DB연결되어서 처리되는 경우가 많다.
2. controller단에서 공통으로 사용되는 key/value형식의 데이터는 ModelAttribute로 선언하여 사용한다.
3. 처리 순서
	1) sql ==> dao 기능 메서드 추가
	2) controller단 modelattribute 선언
	3) view단에서 공통 modelattribute호출
[1단계:확인] *10. 부서정보를 DB와 연동된 콤보박스를 만들어 a01_empList.jsp에 적용하여 출력하세요.(부서정보 추가등록으로 확인)
[1단계:확인] *11. 급여등급(등급,시작범위)-salgrade을 콤보박스 만들어서 선택하게 처리할려고 한다. sql부터시작하여 화면단 출력까지 처리하세요 
1. sql

SELECT losal key, grade val 
FROM salgrade;
2. vo - code
3. dao 기능 메서드 추가 
4. 모델어트리뷰터 controller 추리 
5. 화면단 select 추가


--%>

 </body>
</html>