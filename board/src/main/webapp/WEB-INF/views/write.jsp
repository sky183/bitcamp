<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
 <style type="text/css">
 	#wrapper{
		width: 650px;
		margin: 100px auto;
	}
	
	.input1, .input2{
		width: 550px;
	}
	.input2{
		height: 400px;
	}
	
	.td1{
		width: 65px;
	}
	.cen{
		text-align: center;
	}
	.right{
		text-align: right;
		padding-right: 50px;
	}
 </style>
</head>
<body>
	<div id="wrapper">
		<div style="text-align: center;">
			글쓰기
		</div>
		<form method="post">
			<table>
				<tr>
					<td class="td1">
						제목
					</td>
					<td class="td2">
						<input type="text" name="title" class="input1">
					</td>
				</tr>
				<tr>
					<td class="td1">
						내용
					</td>
					<td class="td2">
						<input type="text" name="text" class="input2">
						<input type="hidden" name="password" id="password">
					</td>
				</tr>
			</table>
			<div class="right">
				<button type="button" onClick="setPw()">비밀번호 설정</button>
			</div>
			<div class="cen">
				<button type="submit">저장</button>
				<button type="button" onClick="location.href='/board'">취소</button>
			</div>
		</form>
		

	</div>
	<script type="text/javascript">
	
		function setPw(){
			
			var popupX = (window.screen.width / 2) - (380 / 2);

        	var popupY= (window.screen.height / 2) - (80 / 2);
        	
            openWin = window.open("setPw",
                    "childForm", "status=no, width=380, height=80, left="+ popupX 
                    + ", top="+ popupY + ", screenX="+ popupX + ", screenY= "+ popupY + ", location = no, resizable = no, scrollbars = no");
			
		}
		
		function error(){
			alert('비밀번호가 서로 일치하지 않습니다!');			
		}
	</script>
	
</body>
</html>