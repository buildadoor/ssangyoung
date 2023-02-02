<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"    
    import="jspexp.vo.*"
    import="jspexp.a13_database.*"    
    import="jspexp.a13_database.vo.*"   
    import="jspexp.vo.Person, jspexp.vo.Product"   
    session = "true"
    %>
    <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/a00_com/a01_common.css" rel="stylesheet">
<style type="text/css">
/*

*/

</style>

<script>
/*
 form 하위 요소객체와 request.getParameterNames()를 이용하여
 
 
 사원명/사원번호/부서이름을 등록리스트하세요
*/

</script>

</head>
<body>

<h2>4번문제</h2>
<%
int totnum01=0;
int totnum02=0;
int totnum03=0;
String snames[] = request.getParameterValues("sname");

String[] s1point = request.getParameterValues("s1point"); 
int[] s1points = null;
if(s1point!=null){
   s1points = new int[s1point.length];
   for(int i=0;i<s1point.length;i++){
      s1points[i] = Integer.parseInt(s1point[i]);
      totnum01+=s1points[i];
   }
   
}
String s2point[] = request.getParameterValues("s2point"); 
int[] s2points = null;
if(s2point!=null){
   s2points = new int[s2point.length];
   for(int i=0;i<s2point.length;i++){
      s2points[i] = Integer.parseInt(s2point[i]);
      totnum02+=s2points[i];
   }
   
}
String s3point[] = request.getParameterValues("s3point"); 
int[] s3points = null;
if(s3point!=null){
   s3points = new int[s3point.length];
   for(int i=0;i<s3point.length;i++){
      s3points[i] = Integer.parseInt(s3point[i]);
      totnum03+=s3points[i];
      
   }
   
}


 %>   
   
<form id="emplist">
   학생1:<input type="text" name="sname">
   학생1국어:<input type="text" name="s1point">
   학생1영어:<input type="text" name="s1point">
   학생1수학:<input type="text" name="s1point">
   학생2:<input type="text" name="sname">
   학생2국어:<input type="text" name="s2point">
   학생2영어:<input type="text" name="s2point">
   학생2수학:<input type="text" name="s2point">
   학생3:<input type="text" name="sname">
   학생3국어:<input type="text" name="s3point">
   학생3영어:<input type="text" name="s3point">
   학생3수학:<input type="text" name="s3point">
   <input type="submit">   
</form>   

<%
     if(snames!=null){
    %>
    <h3><%=snames[0]%>+의 점수:<%=totnum01 %></h3>
    <h3><%=snames[1]%>+의 점수:<%=totnum02 %></h3>
    <h3><%=snames[2]%>+의 점수:<%=totnum03 %></h3>
   <%} %>
  <%
      String T1point = request.getParameter("1team_point");
      int T1pointInt = 0;
      if(T1point!=null){ T1pointInt=Integer.parseInt(T1point);}
      String T2point = request.getParameter("2team_point");
      int T2pointInt = 0;
      if(T2point!=null){ T2pointInt=Integer.parseInt(T2point);}
      
      String div = "";
      if(T1pointInt>T2pointInt){
         div="1팀승";
      }else{
         div="2팀승";
      }
      
      
      
%>

<h3>7번</h3>
<hr>
   <form>
      팀1 팀명<input type="text" name="1team">
      팀1 점수 <input type="text" name="1team_point">
      팀2 팀명<input type="text" name="2team">
      팀2 점수 <input type="text" name="2team_point">
         <input type="submit" value="제출">
   </form>   
         <h3>1팀점수:<%=T1pointInt %></h3>
         <h3>2팀점수:<%=T2pointInt %></h3>
         <h3>최종결과:<%=div %></h3>
    
    </body>
<script type="text/javascript">



</script>
</html>

</head>
<body>
	
</body>
<script type="text/javascript">


</script>
</html>