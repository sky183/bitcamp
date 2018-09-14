<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.net.URLDecoder"%>
<%
	String prevUri = (String) request.getAttribute("prevUri");
	if (prevUri == null)
		prevUri = "index.jsp";
%>
<!DOCTYPE html>

<head>
<title>비트캠프 신촌</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="mystylesheet/mystylesheet.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
	integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ"
	crossorigin="anonymous">
</head>

<body>

	<%@include file="commons/header.jsp"%>

	<div id="id01" class="modal"></div>

	<div class="navbarmain">
		<div class="navbar" id="myTopnav">
			<a href="index.jsp">Home</a> <a href="board.jsp">자유게시판</a> <a
				href="study.jsp">스터디게시판</a> <a href="data.jsp">자료실</a> <a
				href="image.jsp">이미지</a> <a href="javascript:void(0);" class="icon"
				onclick="myFunction()"> <i class="fa fa-bars"></i>
			</a> <a class="rightactive">로그인</a>


		</div>
	</div>

	<script>
		function myFunction() {
			var x = document.getElementById("myTopnav");
			if (x.className === "navbar") {
				x.className += " responsive";
			} else {
				x.className = "navbar";
			}
		}
	</script>


	<div class="row">
		<div class="main"
			style="width: 60%; margin: auto; padding-right: 0; padding-top: 4%;">
			<form action="/LoginAction" method="post">
				<div
					style="text-align: center; display: inline; padding-left: 38%; font-weight: bold; font-size: 25px;">Login
					Form</div>
				<div style="padding-left: 10px; color: red;" id="error">
					<%
						String error = (String) request.getAttribute("error");
						if (error != null) {
					%>
					<label><b><%=error%></b></label>
					<%
						} else {
					%>
					<label><b>&nbsp</b></label>
					<%
						}
					%>
				</div>



				<!-- 	쿠키값 가져오기 -->
				<%
					String name = "";
					String psw = "";
					String remember = "";

					Cookie[] cookies = request.getCookies();
					if (cookies != null && cookies.length > 0) {
						for (int i = 0; i < cookies.length; i++) {
							if (cookies[i].getName().equals("idck")) {
								name = URLDecoder.decode(cookies[i].getValue(), "utf-8");
							} else if (cookies[i].getName().equals("pwck")) {
								psw = URLDecoder.decode(cookies[i].getValue(), "utf-8");
							} else if (cookies[i].getName().equals("remember")) {
								remember = "checked=\"checked\"";
							}
						}
					}
					
					if((String) request.getAttribute("user_id") != null){
						name = (String) request.getAttribute("user_id");
					}
					
				%>


				<div class="container">
					<label for="id" style="float: left; width: 100%;" > <b>아이디</b>
					</label> <input type="text" style="width:100%;" placeholder="아이디를 입력하세요." name="id" id="id"
						required value=<%=name%>> <label for="pwd" style="float: left; width: 100%;" > <b>비밀번호</b>
					</label> <input type="password" style="width:100%;" placeholder="비밀번호를 입력하세요." name="pwd"
						id="pwd" required value=<%=psw%>> <input type="hidden"
						name="prevUri" value=<%=prevUri%>>
					<button type="submit">로그인</button>
					<label> <input type="checkbox" <%=remember%>
						name="remember" id="remember">아이디 비밀번호 기억
					</label>
				</div>
			</form>
			<div class="container" style="background-color: #f1f1f1">
				<form action="/membership.jsp" method="post">
					<input type="hidden" name="prevUri" value=<%=prevUri%>>
					<button type="submit" class="cancelbtn">회원가입</button>
				</form>
				<span class="psw"><a href="#">아이디/비밀번호찾기</a> </span>
			</div>


		</div>

		<%@include file="commons/footer.jsp"%>
</body>

</html>