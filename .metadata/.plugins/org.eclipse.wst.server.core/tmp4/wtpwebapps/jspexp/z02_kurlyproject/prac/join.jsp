<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="javax.naming.*" %>
<%@page import="java.sql.*" %>
 <%@page
    import="java.util.*"    
    import="jspexp.vo.*"
    import="jspexp.a13_database.*"    
    import="jspexp.a13_database.vo.*"     
    %>
    	<!-- div id password uname rrn phonenumber address -->
<%
String div = request.getParameter("div");
String id = request.getParameter("id");
String password = request.getParameter("password");
String uname = request.getParameter("uname");
String rrn = request.getParameter("rrn");
String phonenumber = request.getParameter("phonenumber");
String address = request.getParameter("address");
%>

 <%
 Connection conn=null;
 PreparedStatement pstmt=null;
 ResultSet re = null;
 
 try{
     Context init = new InitialContext();
     
    pstmt=conn.prepareStatement("Insert into kurlyuser values(kurlyuser_seq.NEXTval,?,?,?,?,?,?,?,3000)");
 	pstmt.setString(1, div);
	pstmt.setString(2, uname);
	pstmt.setString(3, rrn);
	pstmt.setString(4, address);
	pstmt.setString(5, phonenumber);
	pstmt.setString(6, id);
	pstmt.setString(7,password);
	
     int result = pstmt.executeUpdate();
 
     if(result!=0){
         out.println("<script>");
         out.println("location.href='Login.jsp'");
         out.println("</script>");
     }else {
         out.println("<script>");
         out.println("location.href='Join.jsp'");
         out.println("</script>");
     }
 }catch(Exception e){
     e.printStackTrace();     
     }
 response.sendRedirect("join.jsp");
%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
 
</body>
</html>
