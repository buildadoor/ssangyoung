<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
# 폼요소
	0. 기본형식
	<태그명 type="">
	1. input 태그
		1) 대부분은 input 태그로 시작하여 type의 속성에 따라
		2) type 속성
			text : 한줄 텍스트 입력 창 ex) <input type="text">
			password : 암호 임력을 위한 한줄 텍스트 입력창
			button : 단순 버튼
			hidden : 데이터는 보이지 않지만 전송할 필요가 있을 때, 활용
				ex) 기능버튼 등록/수정/삭제이 있지만, 요청값에 의해서 해당 내용을 전송해야할 때, 활용 된다.
					즉, 요청값이 표시가 되지는 않지만 그 요청값이 프로세스에 따라 보이지 않게 전송될 때
					활용된다.
				하나의 form으로 여러개의 frame선택
				
			checkbox : 체크박스(다중선택) []
			radio : 라디오 박스(단일선택) ()
			file : 파일 선택
			month|week|date|time|datetime-local : 년,월,일,시간등의 입력창
			number|range : 스핀 버튼과 슬라이드바로 편리한 숫자 입력창
			color : 색상 선택 창
			email|url|tel|search : 이미지,url, 전화번호, 검색키워드 등 형식 검사 기능을 가진 텍스트 입력창
			submit : form전체 데이터를 서버에 전송하는 버튼
			reset : form전체 데이터를 입력 중, 초기화가 필요할 때, 클릭 시 초기화 처리
			
	2. select 태그
		1) 기본형식
			<select name="">
				<option selected value=""></option>
				<option value=""></option>
		2) 선택 형식으로 처리할 수 있는 요소 객체
		
	3. botton
		1) 기본형식
			<button type="button|submit|reset">버튼의 레이블</button>
				주의) button태그의 default type은 submit이기 때문에, 설정하지 않고, 버튼을 클릭하면
				서버로 전송되어 모든데이터가 초기화 된다.
		2) 버튼모양 요소객체
	4. textarea
		1)기본형식
			<textarea cols="10" rows="20" ></textarea>
		2)여러줄 텍스트입력창
 -->
 	<input><br>
 	<!-- 
 	 #텍스트 입력
 	  1. input type="text|password" 속성1="속성값" 속성2="속성값"
 	  2. 기타 속성
 	  	1) name="요소이름" : 서버에 전송시 요청 key로 사용된다. javascript에서도 선택자로 활용
 	  	2) maxlength="입력할 수 있는 최대 문자갯수 지정"
 	  	3) size="화면에 보이는 문자입력 갯수 지정"
 	  		css로 설정해서 크기 설정을 해주면 좋다
 	  		<input style="width:20px"/>
 	  	4) value="초기값으로 설정한 문자열 지정" : 입력하는 데이터를 vlaue속성에 데이터로 할당된다.
 	  				이 value값의 내용을 서버에 전송시 요청 value로 사용된다.
 	  		입력되는 값==>value값으로 할당 ==> submit버튼이 클릭되는 시점에 현재 
 	  		입력된 value값을 name="key" value="입력값" 전송을 한다.
 	  		key=입력값
 	  	5) placeholder : 실제 데이터가 입력된게 아닌 해당항목에 설명으로 적어놓을수 있는 기능
 	 -->
 	 	기본 문자열:<input type="text"/><br>
 	 	패스워드 입력:<input type="password"/><br>
 	    최대 입력 크기설정:<input type="text" maxlength="5" placeholder="5자 미만으로 입력"/><br>
 	    보이는 박스의 크기설정:<input type="text" size="5"/><br>
 	    최대글자수 및 박스 크기설정:<input type="text" maxlength="5" size="5"/><br>
 	    초기값/실제전달되는값:<input type="text" value="안녕하세요"/><br>
 	    서버로 전송시 name/value이 혼합되어 전송:
 	    <input type="text" name="msg" value="반갑습니다."/>
 	    ==> msg=반갑습니다.<br>
 	    
 	   <!-- ex) form에 포함해서 물건명(7자) 갯수(2자) 입력이 가능 및 화면도 보이게 처리하여 
 	   		10_form_element.html?pname=사과&price=3000&cnt=2
 	   		html로는 요청받지 못하지만 위와같이 submit로 전송되는 모습을 볼수 있다.-->
 	   <form>
 	   구매물건명:<input type="text" name="product" size="7" maxlength="7"/><br>
 	   구매 가격:<input type="text" name="price" size="4" maxlength="4"/><br>
 	   구매 갯수:<input type="text" name="cnt" size="2" maxlength="2" style="width:10px;"/><br>
 	   <!-- 기본 태그의 속성의 한계를 css가 보완해주고있따. -->
 	   <input type="submit" value="submit">
 	   </form>
 	   
 	   <h3>구매물건 정보</h3>
 	  	<h4>구매물건:${param.product}</h4>
 	   <h4>구매한 갯수:${param.price}</h4>
 	   <h4>가격:${param.cnt}</h4>
 	   <br>
 	  <hr>
<!-- 
  #여러줄의 문자열 입력창 textarea
  	1.기본형식
  		<textarea 속성="속성값" ...></textarea>
  	2. 속성
  		1) cols : 열갯수
  		2) rows: 행 갯수 - 텍스트 입력창의 크기로 가로세로 문자수(영어를 기준)
  		3) name: 요소이름
 -->
 	<form>
 		자소서내용<br><textarea name="intro"
 		 cols="20" rows="5">이곳에 자기소개서 작성</textarea>
 		<input type="submit"/>
 	</form>
 <!-- ex) 작성자(10), 암호(8), 내용(여러 줄 입력) 형식으로 데이터를 입력하는 fomr을 작성하세요 -->
 <style>
   table{border-collapse:collapse;}
 </style>
 	<hr>
 	<h2>폼 예시문제</h2>
 	<form>
 	<table border="1">
 	<col width="20%">
 	<col width="80%">
 	<tbody>
 	<!-- 
 		#placeholder : 데이터가 입려고디지 않았을때, 해당 내용에 대한 설명
 						내용을 초기에 설정할 수 있다. 데이터가 입력되는 순간 사라진다.
 	 -->
 	<tr><td>작성자</td><td><input type="text" name=writer size="26" maxlength="10" placeholder="홍길동"></td></tr>
 	<tr><td>암 호</td><td><input type="password" name=pass01 size="26" maxlength="8" placeholder="최대 8자리"></td></tr>
 	<tr><td>내 용</td><td><textarea name=write cols="26" rows="10" placeholder="여기에 문의할 내용작성"></textarea><br></td></tr>
 	 <!-- default데이터는 태그 시작과 끝 사이에 입력한다. -->
 	<tr><td colspan="2" style="text-align:center"><input type="submit" value="문의하기 완료"></td></tr>
 	</tbody>
 	</table>
			
 	</form>
</body>
</html>