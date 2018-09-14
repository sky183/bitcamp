<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String sessionCheck = (String) session.getAttribute("MEMBERID");
	String prevUri = request.getRequestURI().toString();
	boolean login = sessionCheck == null ? false : true;
	if (login) {
	} else {
		request.setAttribute("prevUri", prevUri);
		RequestDispatcher reqDis = request.getRequestDispatcher("login.jsp");
		reqDis.forward(request, response);
	}
%>
