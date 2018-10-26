<%@page import="java.util.List"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${members!=null}">
[
<c:forEach var="member" items="${members}" varStatus="status">
{"userId":"${member.userId}","password":"${member.password}",
"userName":"${member.userName}","userPhoto":"${member.userPhoto}" ,"regdate":"${member.regDate}"}
<c:if test="${status.last==false}">
,
</c:if>
</c:forEach>
]
</c:if>
