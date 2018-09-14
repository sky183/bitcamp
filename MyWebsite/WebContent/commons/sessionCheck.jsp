<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String sessionCheck = (String) session.getAttribute("MEMBERID");
	boolean login = sessionCheck == null ? false : true;
%>