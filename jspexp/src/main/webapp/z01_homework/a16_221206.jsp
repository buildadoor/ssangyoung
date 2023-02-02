<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"    
    import="jspexp.vo.*"
    import="jspexp.a13_database.*"    
    import="jspexp.a13_database.vo.*"     
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/a00_com/a01_common.css" rel="stylesheet">
<script type="text/javascript">
/*
 
 */
</script>
</head>
<body>
<div id="container"></div>
<%-- 
2022-12-06
[1단계:개념] 1. 배열형 DOM객체의 속성 처리 방식을 기본예제로 기술하세요.

      1) 출력
         .innerHTML : 화면에 출력할 내용을 랜더링(html 적용)한 내용의 태그를 
            가져오거나 처리하는 속성
         .innerText : 화면에 출력할 내용을 html 적용하지 않은 순서한 내용 자체를 가져오거나
                     랜더링하지 않는 속성
      2) 기본 속성 
         .속성    = 속성값 : 태그가 가지고 있는 기본 속성을 읽어 오거나 설정할 수 있다.
      3) style 속성
         .style.속성 = 속성값 : css속성이 적용된 내용을 설정할 수 있다.
      4) form 요소객체 속성
         .value = "값" : 데이터의 입력 처리를 할 때, form 하위 객체의 요소인 value를 통해서
                     효과적으로 처리할 수 있다.
                     
[1단계:확인] 2. 월드컵 16강 팀들을 배열로 리스트하고, 8X2 테이블에 DOM으로 출력하세요 


[1단계:확인] 3. 사원번호/사원명 5개,  부서번호와 부서명4개를 json데이터를 선언하고, 하나는 테이블에 하나는 select의 option에 레이블과 value로 출력해보세요
[1단계:개념] 4. 예외 처리하는 형식(페이지 지정, 서버단위) 내용을 기본 예제를 통해서 설명하세요.
[1단계:확인] 5. z55_errPage.jsp로 에러 페이지를 지정하고, z51_callError.jsp 지정된 페이지로 에러가 호출되게 처리해보세요.
[1단계:확인] 6. 새로운 프로젝트를 web.xml 파일과 함께 만들어서 404, 500 에러를 페이지를 지정하여 대체 화면으로 처리하세요.
[1단계:확인] 7. 위 프로젝트에 NullPoinerException, ArrayIndexOutBoundsException을 처리하는 에러페이지를 만들고 web.xml에 등록하고 테스트를 통해서 해당 화면이 나타나게 하세요.
--%>
	
<table id="tab01">

    <tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>
    <tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>
</table>
</body>

<script type="text/javascript">



var tds = document.querySelectorAll("#tab01 td")
var 16go = ["네덜란드","미국","아르헨티나","호주","일본","크로아티아","브라질","대한민국","잉글랜드","세네갈","프랑스","폴란드","모로코","스페인","포르투갈","스위스"]
for(var idx=0; idx<tds.length;idx++){
	tds[idx].innerText=names[idx]
}

/*

 */

var div = document.querySelector("#container")
div.innerHTML+="<br>"
</script>
</html>