<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="jspexp.a13_database.*"
   %>
<%--
jspexp.a13_database.A06_PreparedDao checkId

데이터가 있으면 true, 없으면 false 
{"hasMember":true}
{"hasMember":false}

http://localhost:7080/a01_javascript/a07_ajax/z16_checkId.jsp?id=himan


--%>
<jsp:useBean id="dao" class="jspexp.a13_database.A06_PreparedDao"/>
{"hasMember":${dao.checkId(param.id)}}