<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="mvjsp.Thermometer"%>
<jsp:useBean id="t" scope="request" class="mvjsp.Thermometer"></jsp:useBean>
<!-- 빈을 사용하거나 아래와 같이 자바 코드로 객체 생성해서 사용해도 됨 -->
<%-- <%
	Thermometer thermometer = new Thermometer();
	request.setAttribute("t", thermometer);
%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${t.setCelsius('서울', 27.3) }
	서울온도 : 섭씨
	${t.getCelsius('서울')} 도 / 화씨 ${t.getFahrenheit('서울')}
	<br>
	정보: ${t.info}
</body>
</html>