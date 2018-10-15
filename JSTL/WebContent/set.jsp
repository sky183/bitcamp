<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@page import="member.member"%> --%>
<jsp:useBean id="member" class="member.member" scope="request"></jsp:useBean>
<%-- <jsp:setProperty name="member" property="name" value="바보"/> --%>
<%-- <jsp:setProperty name="member" property="email" value="바보"/> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>&lt;c:set&gt;</h3>
	<c:set value="Hello World" var="msg" scope="request"/>
	msg : ${msg}
	<BR>
	<%=request.getAttribute("msg")%>
	<c:remove var="msg" />
	<br>
	msg : ${msg}
	<BR> 
	<c:set target="${member}" property="name" value="바보" />
	<c:set target="${member}" property="email" value="changed@test.net" />
	Member name : ${member.name}
	<BR> Member email : ${member.email}


</body>
</html>