<%@page import="member.member"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <jsp:useBean id="member" class="member.member" scope="request"></jsp:useBean> --%>
<%
 List members = new ArrayList();
 members.add(new member("김민수", "양아치"));
 members.add(new member("김성범", "존잘남"));
 members.add(new member("김태원", "소대장"));
 members.add(new member("한다윗", "예수님"));
 
/*  request.setAttribute("members", members);  */
%>
<c:set var="members" value="<%=members %>"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" cellpadding=5 cellspacing=0>
		<c:forEach var="member" items="${members}">
			<tr>
				<td><c:out value="${member.name}"></c:out></td>
				<td><c:out value="${member.email}" escapeXml="false">
						<font color="red">email 없음</font>
					</c:out></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>