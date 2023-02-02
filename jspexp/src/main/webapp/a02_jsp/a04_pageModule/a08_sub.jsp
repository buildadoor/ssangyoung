<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"    
    import="jspexp.vo.*"
    %>

<%
String name= request.getParameter("name"); if(name==null) name="";
String price= request.getParameter("price"); if(price==null) price="";
%>