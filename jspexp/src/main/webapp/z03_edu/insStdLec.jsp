<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     import="java.util.*"
     import="jspexp.vo.*"
    import="jspexp.a13_database.*"
    import="jspexp.a13_database.vo.*"
 %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="utf-8"/>

<jsp:useBean id="dao" class="jspexp.a13_database.stdMgr"></jsp:useBean>
{"hasLec":${dao.checkDupLec(mem.id,param.lecTimes,param.lecNum,param.major)}}


<c:if test="${not dao.checkDupLec(mem.id,param.lecTimes,param.lecNum,param.major)}">
	${dao.insStdLec(mem.id,param.lecNum)}
</c:if>


