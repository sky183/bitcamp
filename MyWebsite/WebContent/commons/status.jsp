<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	if (login) {
%>
<a class="right" href="logout.jsp">로그아웃</a>
<%
	} else {
%>
<a class="right" href="login.jsp">로그인</a>
<%
	}
%>