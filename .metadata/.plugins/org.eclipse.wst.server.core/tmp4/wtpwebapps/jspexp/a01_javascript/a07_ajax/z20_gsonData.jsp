<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="sch" class="jspexp.vo.Dept"/>
<jsp:setProperty name="sch" property="*"/>
<c:if test="${empty param.dname }">${sch.setDname('') }</c:if>
<c:if test="${empty param.loc }">${sch.setLoc('') }</c:if>
<jsp:useBean id="gson" class="com.google.gson.Gson"/>
<jsp:useBean id="dao" class="jspexp.a13_database.A06_PreparedDao"/>
${gson.toJson(dao.getDeptList(sch))}
