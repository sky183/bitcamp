<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="member.MemberInfo"%>
 <jsp:useBean id="member" scope="request" class="member.MemberInfo"></jsp:useBean> 
${member.setId("cool")}
${member.setName("유영진")}
<jsp:forward page="useObject.jsp"></jsp:forward>