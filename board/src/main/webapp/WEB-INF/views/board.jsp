<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style type="text/css">
td, tr, table{
 	border-collapse:collapse;  
	border: 1px solid black;
}

td{
	padding: 5px 15px;
}
.td1{
	width: 65px;
}
.td2{
	width: 350px;
}
.td3{
	width: 80px;
}
.td4{
	width: 80px;
}
.td1, .td2, .td3, .td4, .cen{
	text-align: center;
}
.cen{
	margin-top : 20px;
}
#wrapper{
	width: 650px;
	margin: 100px auto;
}

</style>
</head>
<body>
<div id="wrapper">

	<table>
		<thead>
			<tr>
				<td class="td1">번호</td>
				<td class="td2">제목</td>
				<td class="td3">작성자</td>
				<td class="td4">조회수</td>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${boardList}" var="boardList">
			<tr>
				<td class="td1">${boardList.num}</td>
				<td><a href="<%=request.getContextPath()%>/view/${boardList.num}">${boardList.title}</a></td>
				<td class="td3">${boardList.name}</td>
				<td class="td4">${boardList.viewcount}</td>
				<td style="display: none;">${boardList.password}</td>
			</tr>
		</c:forEach>

		</tbody>
	</table>
	<div class="cen">
		<button type="button" onClick="location.href='write'">글쓰기</button>
	</div>
	
</div>	
</body>

</html>