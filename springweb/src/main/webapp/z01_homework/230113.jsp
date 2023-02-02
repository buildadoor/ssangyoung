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
2023-01-13
[1단계:개념] 1. 스프링에서 DI란 무엇인가?
			-spring framework에서 사용되는 컨테이너의 처리개념이다.
		 	스프링 프레임웍의 핵심 개념으로 이에 대한 이론과 실제 처리 방법을 
			확인하고, 스프링의 환경설정과 객체 사용에 대한 명확한 기준을
			정립하고 활용할 수 있게 된다.
[1단계:개념] 2. 스프링에서 IOC란 무엇인가
			-객체의 생성, 사용, 소멸로 처리되는 생명 주기의 관리까지
			기존에 개발자의 각 객체 안에서 호출해서 처리되는 내용을 
			건테이너에 의해 처리되게끔 객체에 대한 제어권을 
			바뀌었다는 것을 의미한다.
			컴포넌트 의존 관계 결정, 설정 및 생명 주기를 해결하기 위한
			디자인 패턴을 말한다.
			스프링 프레임웍크도 객체에 대한 생성 및 생명주기를 관리할 수 있는
			기능을 제공하고 있음을 말하고, 이것을 IOC라고 한다.
			IOC는 컨테이너에서 객체으 생성을 책임지고, 의존성을 관리한다.
			의존성관리란 객체간에 Controller ==> service ==> Dao 형태로
			상호의존을 하여 처리하는 것을 말하고, 이러한 것을 컨테이너에서
			관리하는 것을 말한다.
[1단계:개념] 3. DI설정의 위한 가상환경 설정 방법을 기술하세요
			src java바로 밑에 a01_diexp폴더 생성
				-DIExp10.java, di10.xml z01_vo 패키지
					di10.xml(가상컨테이너)
					DIExp10.java(컨테이너에 있는 객체를 DL로 호출해서 활용)
				-DIExp11.java, di11.xml 
				(복사해서 java파일 path 수정하는 방식으로 ) 
[1단계:확인] 4. property를 활용해서 가상 컨테이너안에서 BaseBallPlayer(이름, 팀명, 타율)를 선언하세요
[1단계:확인] 5. constructor를 활용해서 가상 컨테이너안에서 BaseBallTeam를(팀명, 승,무,패) 선언하세요
[1단계:확인] 6. BaseBallPlayer에 소속 팀 객체를 선언하여 1:1로 할당하고, 
			해당 선수와 소속팀 정보를 출력 메서드를 선언하세요.
		xml
		<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
   xmlns:task="http://www.springframework.org/schema/task" 
   xmlns:aop="http://www.springframework.org/schema/aop" 
   xmlns:context="http://www.springframework.org/schema/context"
   xmlns:mvc="http://www.springframework.org/schema/mvc"
   xmlns:p="http://www.springframework.org/schema/p"
   xmlns:c="http://www.springframework.org/schema/c"
   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
   xmlns:util="http://www.springframework.org/schema/util"
   xmlns:websocket="http://www.springframework.org/schema/websocket"
   xmlns:sec="http://www.springframework.org/schema/security"
   xmlns:tx="http://www.springframework.org/schema/tx" 
    
   xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/task
       http://www.springframework.org/schema/task/spring-task.xsd       
       http://www.springframework.org/schema/aop
       http://www.springframework.org/schema/aop/spring-aop.xsd
       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context.xsd
       http://www.springframework.org/schema/mvc
       http://www.springframework.org/schema/mvc/spring-mvc.xsd     
       http://www.springframework.org/schema/util
       http://www.springframework.org/schema/util/spring-util.xsd
       http://www.springframework.org/schema/websocket
       http://www.springframework.org/schema/websocket/spring-websocket.xsd
       http://www.springframework.org/schema/security
       http://www.springframework.org/schema/security/spring-security.xsd   
       http://www.springframework.org/schema/tx
       http://www.springframework.org/schema/tx/spring-tx.xsd   
      " >
      <bean id="obj" class="java.lang.Object"/>
      
       <bean id="bt01" class="a01_diexp.z01_vo.BaseBallTeam">
     		<constructor-arg value="SSG"/>
     		<constructor-arg value="88"/>
     		<constructor-arg value="4"/>
     		<constructor-arg value="52"/>
       </bean>
       
       <bean id="bp01" class="a01_diexp.z01_vo.BaseBallPlayer">
			<property name="name" value="안상현"/>
			<property name="avg" value="0.158"/>
       </bean>
      <bean id="bp02" class="a01_diexp.z01_vo.BaseBallPlayer">
     		<property name="name" value="김성민"/>
     		<property name="avg" value="0.286"/>
       		<property name="baseBallTeam" ref="bt01"/>
       </bean>
       
      
	</beans>
	
	java
	package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z01_vo.BaseBallPlayer;

public class DIExp50 {

   public static void main(String[] args) {

      //컨테이너 객체 호출 처리
      String path="a01_diexp\\di50.xml";
      AbstractApplicationContext ctx = new GenericXmlApplicationContext();
      ctx = new GenericXmlApplicationContext(path);
      // ex) Car (name, maxSpeed), CarRacer(name, car)
      // 1:1 관계 설정 				driving() 운행합니다/ 차가 없네요.
      BaseBallPlayer bp01 = ctx.getBean("bp01",BaseBallPlayer.class);
      BaseBallPlayer bp02 = ctx.getBean("bp02",BaseBallPlayer.class);
      bp01.baseball();
      bp02.baseball();
      System.out.println("종료");
      ctx.close();
      //di10.xml
      // <bean id="obj" class="java.lang.Object"/>
     
   }

}

Player VO
package a01_diexp.z01_vo;
//이름, 팀명, 타율
public class BaseBallPlayer {
	private String name;
	private  double avg;
	private BaseBallTeam baseBallTeam;
	public BaseBallPlayer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BaseBallPlayer(String name, double avg) {
		this.name = name;
		this.avg = avg;
	}
	public void baseball() {
		System.out.println("선수명: "+name);
		System.out.println("타율: "+avg);
		if(baseBallTeam!=null) {
			System.out.println("#KBO리그#");
			System.out.println("팀명:"+baseBallTeam.getTname());
			System.out.println("승:"+baseBallTeam.getWin());
			System.out.println("무:"+baseBallTeam.getDraw());
			System.out.println("패:"+baseBallTeam.getLose());
		}else {
			System.out.println("소속 팀이 없습니다.");
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public BaseBallTeam getBaseBallTeam() {
		return baseBallTeam;
	}
	public void setBaseBallTeam(BaseBallTeam baseBallTeam) {
		this.baseBallTeam = baseBallTeam;
	}
	
}

Team VO
package a01_diexp.z01_vo;
//팀명, 승,무,패
public class BaseBallTeam {
	private String tname;
	private int win;
	private int draw;
	private int lose;
	public BaseBallTeam() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BaseBallTeam(String tname, int win, int draw, int lose) {
		this.tname = tname;
		this.win = win;
		this.draw = draw;
		this.lose = lose;
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
	public int getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}
	public int getLose() {
		return lose;
	}
	public void setLose(int lose) {
		this.lose = lose;
	}
	
}
			
			

--%>

 </body>
</html>