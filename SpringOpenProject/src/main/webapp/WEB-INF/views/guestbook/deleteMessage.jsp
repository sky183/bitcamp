<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/default.css">
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<c:choose>
		<c:when test="${status==0}">
			<script>
				alert('메시지를 삭제하였습니다.');
			</script>
		</c:when>
		<c:when test="${status==1}">
			<script>
				alert('삭제 처리 중 에러가 발생하였습니다.');
			</script>
		</c:when>
		<c:when test="${status==2}">
			<script>
				alert('입력한 암호가 올바르지 않습니다. 암호를 확인해주세요.');
			</script>
		</c:when>
		<c:when test="${status==3}">
			<script>
				alert('메세지가 없습니다.');
			</script>
		</c:when>
		<c:when test="${status==4}">
			<script>
				alert('삭제 권한이 없습니다.');
			</script>
		</c:when>
		<c:otherwise>
			<script>
				alert('삭제 처리 중 에러가 발생하였습니다.');
			</script>
		</c:otherwise>
	</c:choose>
	<script>
		location.href = '<%=request.getContextPath()%>/list';
	</script>

	<!-- 	<br />
	<a href="list">[목록 보기]</a> -->
</body>
</html>










