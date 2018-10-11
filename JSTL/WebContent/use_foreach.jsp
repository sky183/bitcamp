<%@page import="java.util.Date"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
HashMap<String, Object> mapdata = new HashMap<String, Object>();
mapdata.put("name", "최범균");
mapdata.put("today", new Date());
mapdata.put("number", 12);
/* request.setAttribute("maps", mapdata); */
%>
<c:set var="intArray" value="<%=new int[] {1,2,3,4,5} %>"></c:set>
<c:set var="maps" value="<%=mapdata %>"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>int형 배열</h4>
<c:forEach var="intnum" items="${intArray}" begin="0" end="20" varStatus="i">
 ${i.count} = ${intnum} <br>
</c:forEach>
<h4>Map</h4>
<c:forEach var="i" items="${maps}">
 ${i.key} = ${i.value}<br>
</c:forEach>
</body>
</html>