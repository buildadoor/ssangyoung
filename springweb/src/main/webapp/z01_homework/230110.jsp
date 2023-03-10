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
2022-01-10
[1단계:개념] 1. 스프링의 요청값 처리방식을 요청 키와 값을 기준으로 controller단에 선언하는 내용을 기술하세요
1. controller롤 뷰단 호출
	1) Controller만들기 @Controller 선언
		springweb.a01_start.A01_Controller.java
		// http://localhost:7080/springweb/start.do 
		@RequestMapping("/start.do")
		public String start(){
			return "/views/a01_start/a01_start.jsp";
		}
		// 위 주소를 호출할 떄, return 할 view를 forward
		// 처리한다.
	2) View단 선언
		WEB-INF/views/a01_start/a01_start.jsp
	3) container에 등록(dispatcher-servlet.xml)
		<bean class="springweb.a01_start.A01_Controller"/>
		스프링은 일단, 첫번째 컨트롤러를 호출할 때, 
		컨테이너에서 클래스를 객체화하여 메모리에 로딩 후, 호출시에 로딩된 객체를 
		사용한다.	
[1단계:개념] 2. 스프링의 모델데이터 선언방식을 예제를 통해서 기술하세요.
1. 요청값 처리
	/call.do?name=himan
	public String call(@RequestParam("name")String name){
		System.out.println("요청이름:"+name);
	}
2. 모델 데이터 처리
3. 요청 및 모델 데이터 처리
	1) 초기 화면을 로딩
		초기 화면 로딩 메서드 선언
		@RequestMapping("/call10.do")
		
		WEB-INF\views\a01_start\a10_callCalcu.jsp
		
		<form action="${path}/call11.do">
			물건가격:<input type="text" name="price"/>
			물건갯수:<input type="text" name="cnt"/>
			<input type="submit" value="총계"/>
	2) 요청값 전달
		@RequestParam("price") int price,
		@RequestParam("cnt") int cnt
	3) 요청값에 따라 모델데이터 설정
		d.addAttribute("calcu", price*cnt);
	4) 화면 출력
		물건 가격 : ${param.price}
		물건 갯수 : ${param.cnt}
		총계 : ${calcu}
[1단계:확인] 3. 스프링 요청값, 모델, 뷰 연습(RequestParam으로 요청처리)  
               1) 점수를 입력하고 점수에 따른 등급분류(A~F)를 모델로 처리하고  화면에 출력하세요.(get/post 구분)
              // http://localhost:7080/springweb/point.do

	   @GetMapping("/point.do")
		public String point01() {
			return "WEB-INF\\views\\z01_hw\\a01_Point.jsp";
		}
		@PostMapping("/point.do")
		public String point02(
							@RequestParam("point") int point,
							Model d
					){
			return "WEB-INF\\views\\z01_hw\\a01_Point.jsp";
		}
		
              
               2) 아이디와 패스워드를 입력하여 인증 여부 모델로 설정하고 화면에 출력하세요(get/post 구분)
               3) 초기화면에 임의의 구구단이 나오게 하고 정답을 입력하면 그 결과에 따라 정답/오답 출력되게 처리하세요(get/post 통합)
                 컨트롤 단: defaultValue를 통해 숫자값 처리
				 모델데이터로 임의의 2~9, 1~9 전달되게 처리한다.
				 화면에 form 안에 [ 3 ] X [ 4 ] ? [ @@ ] [정답확인]
				 형식으로 임의의 모델데이터를 input의 value값으로 전달하게 한다.
				 	모델데이터 rGrade, rCnt (문제제출), msg(정답처리)
				 요청값 : grade, cnt, inRelpy로 선언하여 전달한다.
				 다시 controller에 요청데이터를 전달하여 
				 해당 값이 맞으면 정답 그렇지 않으면 오답이 되게 처리한다.
				 그 결과 내용을 alert으로 로딩이 되게하고, 다음 문제가 풀어지게 
				 한다.   
               4) 컴퓨터와 하는 가위바위보라는 타이틀로 해당 내용을 선택했을 때, 컴퓨터와 나의 결과에 따라 승/무/패가 처리되게 하세요.(get/post 통합)
[1단계:확인] 4. 스프링 요청값, 모델, 뷰 연습(VO객체로 요청처리)                 
               1) 프리미어리그 팀의 정보(팀명, 승,무,패,골득실)를 VO객체를 만들고, form으로 등록 처리했을 때, 입력된 정보를 vo를 통해서 하단에 출력되게 하세요.
               vo 
               package springweb.z01_vo;

public class Team {
	private String tname;
	private int win;
	private int lose;
	private int draw;
	private int goal;
	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Team(String tname, int win, int lose, int draw, int goal) {
		this.tname = tname;
		this.win = win;
		this.lose = lose;
		this.draw = draw;
		this.goal = goal;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public int getWin() {
		return win;
	}
	public void setWin(int win) {
		this.win = win;
	}
	public int getLose() {
		return lose;
	}
	public void setLose(int lose) {
		this.lose = lose;
	}
	public int getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}
	public int getGoal() {
		return goal;
	}
	public void setGoal(int goal) {
		this.goal = goal;
	}
	
}
 view 
 <div class="container">
	<form id="frm01" class="form-inline"  method="post">
  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <input name="tname" class="form-control mr-sm-2" placeholder="팀명" />
	    <input name="win" class="form-control mr-sm-2" placeholder="승" />
	    <input name="draw" class="form-control mr-sm-2" placeholder="무" />
	    <input name="lose" class="form-control mr-sm-2" placeholder="패" />
	    <input name="goal" class="form-control mr-sm-2" placeholder="골득실" />
	    <button class="btn btn-info" type="submit">등록</button>
 	</nav>
	</form>
   <table class="table table-hover table-striped">
    <thead>
    
      <tr class="table-success text-center">
        <th>팀명</th>
        <th>승</th>
        <th>무</th>
        <th>패</th>
        <th>골득실</th>
      </tr>
    </thead>	
    <tbody>
    	<tr><td>${team.tname}</td><td>${team.win}</td><td>${team.draw}</td>
    	<td>${team.lose}</td><td>${team.goal}</td></tr>
    </tbody>
	</table>    
               2) 회원정보(회원아이디, 이름, 패스워드, 권한, 포인트 )를 vo객체 만들고, 등록시 등록되게 하세요.
 vo
 package springweb.z01_vo;

public class Member {
	private String id;
	private String name;
	private String password;
	private String auth;
	private int point;
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Member(String id, String name, String password, String auth, int point) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.auth = auth;
		this.point = point;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
}
 
 view
 <div class="container">
	<form id="frm01" class="form-inline"  method="post">
  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <input name="id" class="form-control mr-sm-2" placeholder="아이디" />
	    <input name="name" class="form-control mr-sm-2" placeholder="이름" />
	    <input name="password" class="form-control mr-sm-2" placeholder="패스워드" />
	    <input name="auth" class="form-control mr-sm-2" placeholder="권한" />
	    <input name="point" class="form-control mr-sm-2" placeholder="포인트" />
	    <button class="btn btn-info" type="submit">등록</button>
 	</nav>
	</form>
   <table class="table table-hover table-striped">
    <thead>
    
      <tr class="table-success text-center">
        <th>아이디</th>
        <th>이름</th>
        <th>패스워드</th>
        <th>권한</th>
        <th>포인트</th>
      </tr>
    </thead>	
    <tbody>
    	<tr><td>${member.id}</td><td>${member.name}</td><td>${member.password}</td>
    	<td>${member.auth}</td><td>${member.point}</td></tr>
    </tbody>
	</table>                  
              
               3) 김밥의 갯수나 가격   가격[0] 갯수 @ 총계 @@@  [다음 1개 확인] 초기화면이고 클릭시 마다 입력된 가격에서 한개씩 갯수가 올라가
                  계산되게 하세요..
                  [3000] 갯수 1  총계 3000  [다음 2개 확인-버튼] 
                  [3000] 갯수 2  총계 6000  [다음 3개 확인-버튼] 
 --%>

 </body>
</html>