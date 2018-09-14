<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="member.Member"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		member.Member member = new member.Member();

		member.setName("김성범");
		member.setEmail("asdfadf");

		request.setAttribute("member", member);
	%>
	<h3>&lt;c:set&gt;</h3>
	<c:set value="Hello World" var="msg" />
	msg : ${msg}
	<BR> msg :
	<%=pageContext.getAttribute("msg")%><BR>

	<c:set target="${member}" property="email" value="changed@test.net" />

	Member name : ${member.name}
	<BR> Member email : ${member.email}

	<!-- if문 -->
	<c:choose>
		<c:when test="${param.sel == 'a'}">
		a 선택 ${param.sel == 'a'}
		</c:when>
		<c:when test="${param.sel == 'b'}">
		b 선택
		</c:when>
		<c:when test="${param.sel == 'c'}">
		c 선택
		</c:when>
		<c:otherwise>
		아무것도 없음
		</c:otherwise>
	</c:choose>
	<select>
		<option ${param.sel == 'a' ? 'selected' : '' }>a</option>
		<option ${param.sel == 'b' ? 'selected' : '' }>b</option>
		<option ${param.sel == 'c' ? 'selected' : '' }>c</option>
	</select>
	<c:if test="${param.sel == 'a'}" var="varName" scope="application"> 
Body content 
</c:if>
</body>
</html>