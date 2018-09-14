<%@page import="java.util.TreeMap"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	Map<String, String> members = new HashMap<String, String>();
	members.put("김민수", "양아치");
	members.put("김성범", "존잘남");
	members.put("김태원", "양남");
	members.put(null, null);


	request.setAttribute("members", members);
	
	
%>
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
				<td><c:out value="${member}" /></td>
				<td><c:out value="${member.key}" escapeXml="false">
						<font color=red>이름 없음</font>
					</c:out></td>
					<td><c:out value="${member.value}" escapeXml="false">
						<font color=red>email 없음</font>
					</c:out></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>