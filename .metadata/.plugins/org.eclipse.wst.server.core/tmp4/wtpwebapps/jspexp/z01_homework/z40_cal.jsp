<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
   import="java.util.*"
   import="jspexp.vo.*"
    import="jspexp.a13_database.*"    
    import="jspexp.a13_database.vo.*"
   %>
<%request.setCharacterEncoding("utf-8");%>
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
<%
   String price = request.getParameter("price"); if(price==null) price="0";
   String cnt = request.getParameter("cnt"); if(cnt==null) cnt="0";
   int priceI = Integer.parseInt(price);
   int cntI = Integer.parseInt(cnt);
   int tot = priceI*cntI;
   request.setAttribute("tot",tot);
   String page01 = "z42_normal.jsp";
   if(tot>=100000){
      page01 = "z41_mvp.jsp";
   }
%>
<jsp:forward page="<%=page01%>"/>

   <div id="container"></div>
   <script type="text/javascript">
   var div = document.querySelector("#container")
   </script>
<%--

 --%>
</body>
<script type="text/javascript">
/*

 */
</script>
</html>