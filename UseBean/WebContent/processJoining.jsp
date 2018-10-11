<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="member.MemberInfo"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="member" class="member.MemberInfo"></jsp:useBean>
<jsp:setProperty name="member" property="*" />
<jsp:setProperty name="member" property="password" value="${member.id}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="400" border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td>아이디</td>
			<td>${member.id}</td>
		</tr>
		<tr>
			<td>암호</td>
			<td>${member.password}</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${member.name}</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>${member.email}</td>
		</tr>
		<tr>
			<td>주소</td>
			<td colspan="3">${member.address}</td>
		</tr>
	</table>
</body>
</html>