<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
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
			<tr>
				<td class="td1" id="num" name="${boardVO.num}">${boardVO.num}</td>
				<td class="td2">${boardVO.title}</td>
				<td class="td3">${boardVO.name}</td>
				<td class="td4">${boardVO.viewcount}</td>
			</tr>
			<tr>
				<td colspan="4" class="td5">${boardVO.text}</td>
			</tr>

		</tbody>
	</table>
	<div class="left">
		<button type="button" onclick="updatePw()">비밀번호 설정</button>
	</div>
	
</div>	
</body>

<script type="text/javascript">

	var num = $('#num').attr('name');
	
	function error(){
		alert('비밀번호가 일치하지 않습니다!');
	}

	function updatePw(){

		var popupX = (window.screen.width / 2) - (400 / 2);

    	var popupY= (window.screen.height / 2) - (80 / 2);
    	
    	openWin = window.open("<%=request.getContextPath()%>/updatePw",
                "childForm", "status=no, width=400, height=80, left="+ popupX 
                + ", top="+ popupY + ", screenX="+ popupX + ", screenY= "+ popupY + ", location = no, resizable = no, scrollbars = no");
		
	};
</script>

</html>