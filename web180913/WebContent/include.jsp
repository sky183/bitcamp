<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%   MemberInfo memberInfo  = (memberInfo) request.setAttribute(“memberinfo"); %>
이름 :
<%= memberinfo.getName() %>
. . .
<%--  --%>
이름 :${memberInfo.name}
