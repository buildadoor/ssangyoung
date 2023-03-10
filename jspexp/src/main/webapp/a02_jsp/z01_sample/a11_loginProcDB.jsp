<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    import="jspexp.vo.*"
    import="jspexp.a13_database.*"%>
<%
    // post방식에서 한글요청값을 받을 때, 반드시 설정되어야한다.
    request.setCharacterEncoding("utf-8");
 %>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 <fmt:requestEncoding value="UTF-8"/>
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
   <jsp:useBean id="reqMem" class="jspexp.vo.Member"/>
   <jsp:useBean id="dao" class="jspexp.a13_database.A06_PreparedDao"></jsp:useBean>
   <jsp:setProperty property="*" name="reqMem"/>
   <%-- DB에 데이터가 있는지 여부 --%>
   <c:if test="${not empty dao.login(reqMem)}">
      <%-- 1. session 설정 --%>
      <c:set var="sesMem" scope="session" value="${dao.login(reqMem)}"/>
      <%-- 2. 로그인 상태로 check된 경우 쿠키 생성 --%>
      <c:if test="${param.loginChk}">
         <%
            Cookie ck1 = new Cookie("id", reqMem.getId());
            Cookie ck2 = new Cookie("pass", reqMem.getPass());
            ck1.setMaxAge(60*60*24); ck1.setPath("/");
            ck2.setMaxAge(60*60*24); ck2.setPath("/");
            response.addCookie(ck1);
            response.addCookie(ck2);
         %>
      </c:if>
   </c:if>
   <%-- 쿠키값이 있는 경우 DB 세션 처리 --%>
   <c:if test="${not empty cookie.id.value}">
      ${reqMem.setId(cookie.id.value)}
      ${reqMem.setPass(cookie.pass.value)}
      <c:set var="sesMem" scope="session" value="${dao.login(reqMem)}"/>
   </c:if>
   
   
   <%-- 
      # 요청값과 useBean을 통한 데이터 할당.
      1. 요청값 : ?id=himan&pass=7777
      2. useBean 클래스 선언으로 요청값 받기
         1) 위 query string에서 id=himan인 경우
         2) 클래스에 void setId(String id){}와 같이 
            id요청 키에 해당하는 property(setId==>id) 동일한 메서드가
            선언되어 있으면
            setPass(String pass){}
         3) <jsp:setProperty property="*" name="reqMem"/>로 인해서 자동할당 처리된다.
            reqMem.setId("himan"); 내부 코드로
            reqMem.setPass("7777"); 내부 코드로
      # 로그인 및 세션 쿠키 처리
      1. 아이디와 패스워드 입력
         1) useBean으로 DB에 접근해서 id/pass가 있는 경우
            DB에서 VO를 받아 session 설정한다.
            메인 화면으로 이동 처리
         2) useBean으로 DB에 접근해서 id/pass가 없는 경우
            다시 로그인 페이지 이동
      2. 쿠키값이 있어서 이동한 경우
         1) 쿠키의 id와 pass를 받아 DB에 접근하여 session 설정
            메인화면을 이동 처리.
   --%>
   <body>
      받은 id : ${reqMem.id},
      받은 pass : ${reqMem.pass}
      check처리 : ${param.loginChk},
      상태유지여부 : ${not empty param.loginChk? '로그인상태유지':'로그인상태유지 안됨'}
   </body>
   <script type="text/javascript">
      var ckSess = "${sesMem.id}"
      var ckCk = "${cookie.id.value}"
      if(ckSess != ''){ // 세션값이 설정된 경우
         if( ckCk == '' ){
            alert("로그인 성공\b메인페이지 이동")
         }else{
            alert("자동 로그인\n메인 페이지 이동")
         }
         location.href = "a12_main.jsp"
      }else{
         alert("로그인 실패\n로그인페이지 이동")
      }
   /*
      
   */
   </script>
</html>