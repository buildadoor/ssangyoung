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
2023-02-09
[1단계:개념] 1. 게시물의 수정 삭제를  DB처리단/화면처리/컨트롤단을 나누어 핵심 코드를 정리해 보세요
# 게시판 수정
DB 처리 , service 
		sql 	
			update board
				set content = #{content},
					subject = #{title),z
					uptdte = sysdate
			   where no = #{no}
		dao
			public void updateBoard(Board upt);
		mappper
			<update id= "updateBoard" parameterType="board">
				update board
					set content = #{content},
						subject = #{subject},
						uptdte = sysdate
				   where no = #{no}			
			</update>   
controller 
@PostMapping("/boardUpt.do")
public String boardUpt(Board upt, Model d) {
	service.updateBoard(upt);
	d.addAttribute("board",service.getBoard(upt.getNo()));
	d.addAttribute("msg","수정완료");
	return "a03_board";
}
화면단
		$("#uptBtn").click(function(){
			if(confirm("수정하시겠습니까?")){
				$("form").attr("action","${path}/boardUpt.do");
				$("form").submit();
			}
		})
		if(msg=="수정완료"){
			if(confirm(msg+" 전체조회화면 이동하시겠습니까?")){
				location.href = "${path}/list.do";
			}
		}
# 게시판 삭제
DB 처리, service	
	sql delete from board where no = 1
	dao public void deleteBoard(int no);		
	mapper
		<delete id="deleteBoard" parameterType="int">
			delete 
			from board 
			where no = #{no}
		</delete>	
	service
		public void deleteBoard(int no){
			dao.deleteBoard(no);
		}
controller 
@GetMapping("/delBoard.do")
public String delBoard(@RequestParam("no") int no, Model d) {
	service.deleteBoard(no);
	d.addAttribute("msg", "삭제완료");
	return "a03_board";
화면단
		if(msg=="삭제완료"){
		if(confirm(msg+" 전체조회화면 이동하시겠습니까?")){
			location.href = "${path}/list.do";
		}
	}
	if(msg=="삭제완료"){
		alert(msg+" 전체조회화면 이동하겠습니다!");
		location.href = "${path}/list.do";
	}


[1단계:개념] 2. vue의 이벤트 처리 기본 형식을 기술하세요
1) view 단
	v-on:이벤트명 = "inline 모델데이터 처리 or 기능메서드"
	==> @:이벤트명 = "inline 모델데이터 처리 or 기능메서드"
		ex) v-on:click = "tot = grade*cnt"
		    v-on:click = "totAll"
		    <input v-model="grade"/>
		    <input v-model="cnt"/>
		    {{grade}} X {{cnt}} = {{tot}}
		new Vue({
			data:{grade:0,cnt:0, tot:0},
			methods:{
				function totAll(){
					// this : 전역변수로 모델 데이터나 포함된 기능 메서드 접근이 가능..
					this.tot = this.grade*this.cnt
				}
			}
		})
	2) Vue 인스턴스 객체 선언
		기능 메서드 함수 정의		
		methods:{
			함수명1:function(){
				처리할 내용
			},
			함수명2:fucntion(){
				처리할 내용
			}
		}
[1단계:확인] 3. inline 이벤트 처리로 단가:[1000] [1개] 계:@@@ ==> 갯수에 클릭시 마다 갯수가 올라가면 입력된 단가의 계가 출력되게 하세요.
$(document).ready(function(){
		var vm = new Vue({
			el:".container",
			data:{msg:"이벤트 처리", price:0, cnt:0, tot:0,cnt2:0}
		});	
	});

</script>
</head>
<body>

<div class="container">
  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <input v-model="price" class="form-control mr-sm-2" placeholder="가격을 입력하세요" />
	    <input v-model="cnt" class="form-control mr-sm-2" placeholder="갯수를 입력하세요" />
	    <button v-on:click="tot+=price*cnt, cnt2+=parseInt(cnt)"  class="btn btn-info" type="button">총계 확인</button>
 	</nav>
<div class="jumbotron text-center">
	  <h2 >{{msg}}</h2>
	   	<h3>단가:{{price}} 갯수:{{cnt2}}개 총계:{{tot}}</h3>
	</div>


[1단계:확인] 4. methods 선언 이벤트 처리로 학생의 성적 국어, 영어, 수학 점수를 입력해서 select로 총점/평균/최고/최저 점수를 선택시 출력하세요.

[1단계:개념] 5. vue에서 ajax로 데이터를 처리하기 위해 구성해야할 환경을 기술하세요.
	1) vue 객체를 선언을 통해  이벤트에 의해 처리된 내용은
	2) url, 요청값으로 특정한 controller 기능 기능메서드 호출한다.
	3) 해당 기능 메서드를 통해 받은 데이터는 json 객체로 받는다.
	4) 이 json 데이터를 vue 객체의 모델 데이터에 할당한다.
	5) 모델 데이터는 실시간으로 화면에 리스트를 출력 처리한다.
	
[1단계:개념] 6. fetch api ajax를 연동하기 위한 기능메서드의 속성을 기술하세요.
- fetch ajax 처리 api 사용 방법
		jquery : $.ajax({속성:속성값})
		lib 설정 :https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api
		var url = "${path}/empListAjax.do?ename=&job="
		fetch(url).then(함수1).then(함수2).catch(함수3)
				
		fetch(url).then(function(response){
			반응객체 처리
			return response.json(); // json 데이터만 다음 블럭에 전달
		}).then(function(json){
			모델명 = json : 서버에서 온 json 데이터 할당.
		})catch(function(err){
			예외 처리
		})			

- 개발 순서
	1) backend단 처리 (스프링을 통한 json 데이터 로딩 처리)
		/springweb/empListAjax.do?ename=A&job=ER
	
	2) vue 모델데이터선언 :요청값, 결과값
		ename,job, empList:[]
	3) vue의 기능 메서드 선언 (methods)
	4) 화면 ui 구현 : 요청값을 처리할 form- v-model선언, 리스트 데이터 구현 - vue의 결과 리스트
		@이벤트="이벤트핸들러함수"
	5) fetch api를 통한 데이터 로딩 처리.
		함수안에 this와 함수밖에서 모델 데이터를 처리하기 위한 this를 구분하기 위한 변수 선언
		var vm = this  : 함수 밖에서 모델 데이터를 접근 하기 위하여 사용..
[1단계:확인] 7. vue와 fetch api를 이용하여 A03_MemberController.java의 /memberListMy.do ==> /memberListAjax.do 로 만들어
               json데이터를 가져오게 하여 vue로 ajax처리하세요
@RequestMapping("memberListAjax.do")
	public String memberListAjax(@ModelAttribute("sch")Member sch,Model d) {
		d.addAttribute("memberList", service.getBsMemberList(sch));
		return "pageJsonReport";
	}
	$(document).ready(function(){
		var vm = new Vue({
			el:".container",
			data:{msg:"0209 과제", id:"",name:"",memberList:[]},
			methods:{
				schKeyup:function(){
					if(event.keyCode==13){
						this.fetchList(); // this. 
					}
				},
				fetchList:function(){
					//alert("검색 처리")
					console.log("id:"+this.id)
					console.log("이름:"+this.name)
					this.memberList = [] // 검색 리스트 데이터 초기화
					var url="/springweb/empListAjax.do?id="+this.id+"&name="+this.name
					var vm = this; // Vue객체의 다른 속성(모델,메서드)를 fetch api 안에서 사용하기 위해 선언
					fetch(url).then(function(response){
						console.log(response)
						return response.json()
					}).then(function(json){
						console.log("#서버에서 받아온 json데이터")
						vm.memberList = json.memberList
						console.log(json.memberList)
					}).catch(function(err){
						console.log(err)
					})
				}
			}
		});	
	});
	
	
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
  <h2>로그인</h2>
  <%--
  <h2 data-toggle="modal" data-target="#exampleModalCenter">
   --%>
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