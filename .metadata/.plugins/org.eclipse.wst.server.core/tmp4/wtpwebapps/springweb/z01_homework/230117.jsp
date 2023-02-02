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
		2023-01-17
[1단계:개념] 1. 출력을 처리하는 기능메서드를 기술하고, 이 기능메서드에 callback함수가 처리될 때 어떤 효과가 나는지 기술하세요
# 데이터 처리 기능 메서드와 callback함수 처리
1. text(), html(), val()
2. text(function(idx){
	다중의 요소객체의 경우 index값을 매개변수로 받고
	리턴값을 해당 데이터에 대한 처리를 할 수 있다.
	return "처리할 데이터";
[1단계:확인] 2. callback함수를 이용하여 5*5 테이블에 1~25번호를 붙이고, 짝/홀별로 배경색상을 다르게 처리하세요
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/springweb/a00_com/jquery.min.js"></script>
<script type="text/javascript">
/*
# 데이터 처리 기능 메서드와 callback함수 처리
1. text(), html(), val()
2. text(function(idx){
	// 다중의 요소객체의 경우 index값을 매개변수로 받고
	// 리턴값을 해당 데이터에 대한 처리를 할 수 있다.
	return "처리할 데이터";
})
 */
	$(document).ready(function(){
		$("#show td").text(function(idx, txt){
			console.log(idx+""+txt)
			return idx+" hello"
		})
		// h3를 7개 만들고, 0-6 번호를 붙여 출력하세요
		// h2를 7개 만들고, 무지개 색상을 출력하세요
		var colors = ['red','orange','yellow','green','blue','navy','purple']
		$("h3").text(function(idx, txt){
			$(this).css("color",colors[idx])
			return colors[idx];
		})
		var aligns = ["left","center","right"]
		$(".in01").val(function(idx){
			$(this).css("text-align",aligns[idx%3])
			return colors[idx];
		})
	});
	</script>

</head>
<body>
	  <h2>콜백함수</h2>
	  <input type="text" class="in01"/>
	  <input type="text" class="in01"/>
	  <input type="text" class="in01"/>
	  <input type="text" class="in01"/>
	  <input type="text" class="in01"/>
	  <input type="text" class="in01"/>
	  <input type="text" class="in01"/>
	  <h3></h3>
	  <h3></h3>
	  <h3></h3>
	  <h3></h3>
	  <h3></h3>
	  <h3></h3>
	  <h3></h3>
	  <table id="show" width="300pt" height="300pt" border>
	  	<tr><td>기존데이터1</td><td></td><td></td></tr>
	  	<tr><td></td><td></td><td></td></tr>
	  	<tr><td></td><td>기존데이터2</td><td></td></tr>
	  </table>
</body>
</html>
[1단계:개념] 3. 부모/조상객체를 선택하는 기능메서드를 기술하세요
		$("요소객체").parent() : 바로 상위부모
 		$("요소객체").parents("지정") : 요소객체를 포함하고 있는 
 				모든 조상객체를 가운데 지칭
 		$("요소객체").parentsUtils("지정") : 모든 조상객체에서 특정한 객체 


[1단계:확인] 4. <p><h2>,<p><h2>,<p><h2> 구조로 된 상황에서 h2를 클릭시, 상위 p태그이 border의 테두리가 파랑색으로 처리되게 하세요  


[1단계:개념] 5. 자식/후손 객체를 선택하는 기능메서드를 기술하세요
		$("요소객체").children()
		$("요소객체").find("하위 중에 찾을 객체")

[1단계:개념] 6. 형제 객체를 선택하는 기능메서드를 기술하세요
		$("요소객체").siblings() : 요소객체와 같은 부모객체를 둔 모든 형제객체를 선택
 		$("요소객체").next() : 형제객체 중, 바로 다음에 나오는 객체
 		$("요소객체").nextAll() : 형제객체 중, 바로 다음에 나오는 모든 객체
 		$("요소객체").nextUntil() : 형제객체 중, 바로 다음에 지정한 객체까지 
 		$("요소객체").prev() : 형제객체 중, 바로 이전객체
 		$("요소객체").prevAll() : 형제객체 중, 바로 이전객체들
 		$("요소객체").prevUntil() : 형제객체 중, 바로 이전객체까지 객체들

[1단계:활용] 7. 입력시, next()를 활용해서 유효성(글자수 8~16)에 대한 내용을 표시하게 하세요.
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/a00_com/bootstrap.min.css" >
<style>
   td{text-align:center;}
</style>
<script src="/springweb/a00_com/jquery.min.js"></script>
<script src="/a00_com/bootstrap.min.js"></script>
<script type="text/javascript">
   $(document).ready(function(){
      // 테이블에 칸마다 번호 매기기
    $('#exp7').keyup(function(){
               var len = $(this).val().length
               if(len<8||len>16){
                  $(this).next().text("8~16글자 까지 입력가능합니다.").css("color","red")
               }else{
                  $(this).next().text('글자수:'+len).css("color","")
               }
            })
      
   });
</script>
</head>
<body>

   <h2>7번문제</h2>
     <textarea id="exp7" maxlength="16"></textarea>
     <div></div>
     <div id="exp7_2"></div>
     
</body>
<script>
</script>
</html>
     
[1단계:활용] 8. eq()를 활용하여 화살표로 커서를 움직일 때 마다, 3X3테이블의 특정한 td의 배경색상이 위치가 이동이 되게 하세요
정명오빠가 보내준거 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/a00_com/bootstrap.min.css" >
<style>
   td{text-align:center;}
</style>
<script src="/springweb/a00_com/jquery.min.js"></script>
<script src="/a00_com/bootstrap.min.js"></script>
<script type="text/javascript">
   $(document).ready(function(){
      // 테이블에 칸마다 번호 매기기
      $('#ex08 td').text(function(idx){
         return idx
      })
      // 시작하자마자 첫번째 놈한테 background적용
      $('#ex08 td').first().css("background","yellow");
      
      var tdcnt = $('#ex08 td').length // 총 td갯수
      var trcnt = $('#ex08 tr').length // 총 tr갯수
      var Linetdcnt = tdcnt/trcnt // 한 줄당 td갯수
      var idx = 0;// 현재 index값
      
      $(document).keydown(function(){
         $('#ex08 td').css("background","")
         //왼쪽
         if(event.keyCode==37){ 
            if(idx==0){idx=tdcnt-1} // index 0번이면 trcnt-1(마지막칸)으로 이동
            else{idx--} // 0이아니면 index--
         //오른쪽
         }else if(event.keyCode==39){ 
            if(idx==tdcnt-1){idx=0;} //마지막칸에서 오른쪽누르면 index 0번 으로
            else{idx++} //아니면 index++
            
         // 위쪽
         }else if(event.keyCode==38){
            if(idx>Linetdcnt-1){//Linetdcnt-1은 첫번째 줄의 index를 의미
               idx-=Linetdcnt // 첫번쨰 줄의 index보다 크면 위로 갈 번호가 있으니 이동
            }else{
               idx=(Linetdcnt*(trcnt-1))+idx//첫번쨰줄 index에서 위로 이동할시, 같은 열의 마지막 행으로 이동
            }
         //아래쪽
         } else if(event.keyCode==40){ 
            if(idx/Linetdcnt<trcnt-1){// idx/Linetdcnt는 몇번째 줄인지의미 //trcnt-1은 마지막줄을 의미
               idx+=Linetdcnt; //마지막줄보다 작다는건 아래로 갈 칸이 있으므로 라인하나의 칸갯수만큼+
            }else{
               idx= idx%(Linetdcnt*(trcnt-1))//마지막줄이면 해당열의 첫번째 행으로 이동
            }
         }
         
      $('#ex08 td').eq(idx).css("background","yellow");
      console.log(event.keyCode+":"+idx)
      })
      
      
      
   });
</script>
</head>
<body>

     <table id="ex08" width="50%" height="500px" border>
        <tr><td></td><td></td><td></td><td></td></tr>
        <tr><td></td><td></td><td></td><td></td></tr>
        <tr><td></td><td></td><td></td><td></td></tr>
     </table>
     

</body>
<script>
</script>
</html>
ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
1) 이벤트 커서 이벤트로 처리되는 것을 확인
	$("대상객체").on("keyup",function(){
		console.log(event.keyCode)
	})
2) table에 key에 따른 변경 처리
	- 테이블 3*3 생성
3) 오른쪽 왼쪽 키를 입력시, 좌우 이동 및 배경색 변경
	잔역변수로 tIdx=0;
	$("td").eq(인덱스번호).css("background",pink);
	tIdx++; tIdx--
4) 위아래 키 입력시, 상하 이동 및 배경색 변경
	0 1 2
	3 4 5
	6 7 8 
	
	아래키 입력시: 0 ==> 3 ==> 6
	위로키 입력시: 8 ==> 5 ==> 2
[1단계:개념] 9. 의존성 자동 주입이란 무엇이고 이것과 관련한 옵션은 어떤 것들이 있는가?
	컨테이너에서 autowiring 옵션을 이용하면, 객체가 현재 메모리에 로딩된
	상태이기에 바로 new XXXX() 형태로 객체를 생성하여 할당 없이 처리가
	가능한데 이것을 의존성 자동 주입 설정이라고 한다.
	
	*의존성 자동 주입 설정 옵션
	1) autwire="bytype"
		스프링 컨테이너 메모리가 해당 객체 타입으로 들어올 수 없는
		메서드가 정의가 되어 있으면 자동으로 할당이 되게 처리하는 것을
		말한다. 
		ex) public void setHandPhone(HandPhone phone){
	2) autowire="byName"
		by Type은 컨테이너에 들어올 수 있는 객체가 하나일 때, 처리가 
		가능한데, 특정 객체가 여러개 선언되어 있는 경우 byName으로 하면
		일단 type이 같고 id값이 같은 property가 있는 메서드가
		있을 경우 할당하는 것을 말한다.
	3) autowire="constructor"
		생성자를 통해서 해당 타입이 할당될 때, 자동 주입된다.
	4) autowire="autodetect"
		우선 할당할 수 있는 생성자를 살피고, 없을 때는 기능메서드살펴서
		byType으로 할당한다.
	5) autowire="no"
		자동 주입을 하지 못하게 한다. default이다.	

[1단계:확인] 10. Pencil과 Eraser를 1:1관계로 설정하고 의존성 자동 주입으로 처리해보세요.(byType)

[1단계:확인] 11. BusDriver와 Bus를 선언하고 버스기사가 여러 대의 버스가운데 선택된 의존성 자동 주입을 처리해보세요(byName)
 <bean id="drive01" class="a01_diexp.z01_vo.BusDriver"
      c:_0="홍길동" c:_1="43"/>
      <bean id="bus01" class="a01_diexp.z01_vo.Bus"
           p:busInfo="대전행" autowire="byName"/>
//
      Bus obj = ctx.getBean("bus01",Bus.class);
      System.out.println("컨테이너객체호출"+obj);
      

[1단계:개념] 12. 특정 패키지 자동 클래스 선언 형식을 기술하세요
		특정 패키지에 있는 객체들을 @Component선언없이 메모리 로딩하려면
		아래의 옵션을 추가
		<context:component-scan base-package="적용할 최상위패키지명">		
			<context:include-filter type="regex" expression=".*/>
			정규식표현식에 해당하는 클래스를 메모리에 로딩하는 것을 .*란 하위에 있는
			모든 클래스를 지정한다.
			
[1단계:확인] 13. z06_vo 패키지에 Person, Product, Music 클래스를 복사하고  컨테이너에서 해당 객체들을 호출하게 처리하세요
 	DIExp52
 	package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import a01_diexp.z06_vo.Music;
import a01_diexp.z06_vo.Person;
import a01_diexp.z06_vo.Product;

public class DIExp52 {

   public static void main(String[] args) {

      //컨테이너 객체 호출 처리
      String path="a01_diexp\\di52.xml";
      AbstractApplicationContext ctx = new GenericXmlApplicationContext();
      ctx = new GenericXmlApplicationContext(path);
      //DL(dependency lookup)으로 id명으로 객체를 찾아서 가져온다.
      Person person = ctx.getBean("person",Person.class);
      Product product = ctx.getBean("product",Product.class);
      Music music = ctx.getBean("music",Music.class);
      System.out.println("컨테이너 객체 호출:"+music);
      System.out.println("컨테이너 객체 호출:"+person);
      System.out.println("컨테이너 객체 호출:"+product);
      System.out.println("종료");
      ctx.close();
      //di10.xml
      // <bean id="obj" class="java.lang.Object"/>
   }

}
		xml
      <bean id="obj" class="java.lang.Object"/>
      <context:component-scan base-package="a01_diexp.z06_vo">
      	<context:include-filter type="regex" expression=".*"/>			
      </context:component-scan>
		--%>	
	});
</script>
</head>

<body>
<%--



--%>

 </body>
</html>