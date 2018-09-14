<%@ page contentType = "text/html; charset=utf-8" %>
<%
	request.setAttribute("name", "최범균");
	Cookie cook = new Cookie("id", "sky183");
	response.addCookie(cook);
%>
<html>
<head><title>EL Object</title></head>
<body>

요청 URI: ${pageContext.request.requestURI}<br>
request의 name 속성: ${requestScope.name}<br>
code 파라미터: ${param.code}<br>
${param.id}<br>
${cook.name}<br>
</body>
</html>
