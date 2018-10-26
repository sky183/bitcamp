<%@page import="java.util.List"%>
<%@ page language="java" contentType="application/xml; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${members!=null}">
<members>
<c:forEach var="member" items="${members}" varStatus="status">
<member>
	<userid>
	${member.userId}
	</userid>
	<password>
	${member.password}
	</password>
	<username>
	${member.userName}
	</username>
	<userphoto>
	${member.userPhoto}
	</userphoto>
	<regdate>
	${member.regDate}
	</regdate>
</member>
</c:forEach>
</members>
</c:if>