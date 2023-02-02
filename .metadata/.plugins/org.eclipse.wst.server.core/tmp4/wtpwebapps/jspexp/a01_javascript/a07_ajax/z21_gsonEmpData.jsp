<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
ex) z21_gsonEmpData.jsp 사원정보 json 리스트 데이터 처리
 --%>
<jsp:useBean id="dao" class="jspexp.a13_database.A02_EmpDao"/>
<jsp:useBean id="sch" class="jspexp.vo.Emp"/>
<jsp:setProperty name="sch" property="*"/>
<c:if test="${ empty param.ename}">${sch.setEname('')}</c:if>
<c:if test="${ empty param.job}">${sch.setJob('')}</c:if>
<c:if test="${ empty param.toSal}">${sch.setToSal(9999)}</c:if>
<jsp:useBean id="json" class="com.google.gson.Gson"/>
${json.toJson(dao.getEmpSch(sch))}

