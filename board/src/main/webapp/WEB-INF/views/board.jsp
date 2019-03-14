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
		<c:forEach items="${boardList}" var="boardList">
			<tr>
				<td class="td1">${boardList.num}</td>
				<td><a id="${boardList.num}" href="#" onclick="openChild('${boardList.num}')">${boardList.title}</a></td>
<%-- 				<td><a id="${boardList.num}" href="<%=request.getContextPath()%>/view/${boardList.num}">${boardList.title}</a></td> --%>
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
	
	
	<script type="text/javascript">
    
        var openWin;
        
        var num;
        
        function error(){
        	alert('비밀번호가 일치하지 않습니다!');
        }
        
    
        function openChild(e) {
        	
        	num = e;
        	
        	$.ajax({
				url : '<%=request.getContextPath()%>/confirm?num=' + num,
				method : 'GET',
				error : function(error) {
			        alert("Error!");
			    },
				success : function(data) {
					if (data) {
						location.href = "<%=request.getContextPath()%>/view/" + num
					} else {
						var popupX = (window.screen.width / 2) - (280 / 2);

			        	var popupY= (window.screen.height / 2) - (20 / 2);
			        	
			            openWin = window.open("confirmPw?num=" + num,
			                    "childForm", "status=no, width=280, height=20, left="+ popupX 
			                    + ", top="+ popupY + ", screenX="+ popupX + ", screenY= "+ popupY + ", location = no, resizable = no, scrollbars = no");
					}
				}
			});
        	
        }
        

        
   </script>


	
</div>	
</body>

</html>