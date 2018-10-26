<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/common/headercheck.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/default.css">
<script src="https://code.jquery.com/jquery-1.10.0.js"></script>

<style>
h2 {
	padding: 10px;
}

table {
	margin-top: 10px;
}

td {
	padding: 10px 20px;
}

#memberPhoto {
	background-size: 100%;
	width: 150px;
	height: 150px;
	border: 1px solid #333333;
	margin: 20px 0;
}
</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp"%>

	<div id="contents">
		<h2>회원리스트</h2>

		<hr>

		<div class="memHeader">
			<select name="viewType" id="viewType">
				<option value="viewType">viewType</option>
<!-- 				<option value="HTML" selected disabled hidden="hidden">viewType</option> -->
				<option value="HTML">HTML</option>
				<option value="JSON">JSON</option>
				<option value="XML">XML</option>
			</select>
		</div>
		
		<div id="type"></div>
		
		<table border="1" class="memList">
			<tr>
				<td>아이디</td>
				<td>비밀번호</td>
				<td>이름</td>
				<td colspan="2">사진</td>
				<td>가입일</td>
				<td>관리</td>
			</tr>
			<tbody id="tbody">
			</tbody>
		</table>


	</div>

<script>


	$(document).ready(function() {
		/* 기본 뷰타입으로 불러온다. */
	 	$('.memList').load('memberList/viewType');  
		$('#viewType').change(function() {
			if ($(this).val() == 'viewType') {}
			if ($(this).val() == 'HTML') {
				$.ajax({
					url : 'memberList/viewType?type=HTML',
					data : {
						viewType : $(this).val()
					},
					error : function(error) {
				        alert("Error!");
				    },
					success : function(data) {
						$('#type, .memList').empty();
						$('.memList').append(data);
					}
				});
			}
			if ($(this).val() == 'JSON') {
				$.getJSON('memberList/viewType?type=JSON', function(data) {
					success : 
						$('#type, #tbody').empty();
						$('#type').append(JSON.stringify(data)+"<hr>"); 
						$.each(data, function(key, value) {
						$('#tbody').append(
 								'<tr>' + 
								'<td>' + value.userId + '</td><td>' +
								 value.password + '</td><td>' +
								 value.userName + '</td><td>' +
								 value.userPhoto + '</td>' +
								'<td id="memberPhoto" style="' +
								'background-image: url(\'' + '<%=request.getContextPath()%>' + '/uploadfile/userphoto/' + value.userPhoto + '\');"></td><td>' +
								value.regDate + '</td><td>' +
								'<a	href="' + '<%=request.getContextPath()%>' + '/memberModify/'+ value.userId + '">수정</a>' +
								'<a	href="' + '<%=request.getContextPath()%>' + '/memberDelete/'+ value.userId +'/'+ value.userPhoto +'">삭제</a></td>' + 
								'<tr>' 
						);
					});

				});
			}
			if ($(this).val() == 'XML') {
				$.ajax({
					url : 'memberList/viewType?type=XML',
					error : function(error) {
				        alert('error');
				    },
					success : function(data) {
						$('#type, #tbody').empty();
						$('#type').append($(data).text()+'<hr>');
						$(data).find('members').find('member').each(function(){
								var userid = $(this).find('userid').text().trim()
								var password = $(this).find('password').text().trim()
								var username = $(this).find('username').text().trim()
								var userphoto = $(this).find('userphoto').text().trim()
								var regdate = $(this).find('regdate').text().trim()
								$('#tbody').append(
									'<tr>' + 
									'<td>' + userid + '</td><td>' +
									password + '</td><td>' +
									username + '</td><td>' +
									userphoto + '</td>' +
									'<td id="memberPhoto" style="' +
									'background-image: url(\'' + '<%=request.getContextPath()%>' + '/uploadfile/userphoto/' + userphoto + '\');"></td><td>' +
									regdate + '</td><td>' +
									'<a	href="' + '<%=request.getContextPath()%>' + '/memberModify/'+ userid + '">수정</a>' +
									'<a	href="' + '<%=request.getContextPath()%>' + '/memberDelete/'+ userid +'/'+ userphoto +'">삭제</a></td>' + 
									'<tr>' 
							);
						});	
					}
				});
			}
		});
	});

</script>


</body>
</html>