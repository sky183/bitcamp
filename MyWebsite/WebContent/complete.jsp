<%@page import="com.codechobo.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.net.URLDecoder"%>

<%
	UserInfo u = (UserInfo) request.getAttribute("userInfo");
	String name = null;
	String user_id = null;
	String password = null;
	String password2 = null;
	String email = null;
	String reg_num = null;
	String zip = null;
	String address = null;
	String job = null;
	String hobbys[] = null;
	String pr = null;
	String hobby[] = new String[6];
	String prevUri = null;
	if (u != null) {
		name = u.getName();
		user_id = u.getUser_id();
		password = u.getPassword();
		password2 = u.getPassword2();
		email = u.getEmail();
		reg_num = u.getReg_num();
		zip = u.getZip();
		address = u.getAddress();
		job = u.getJob();
		hobbys = u.getHobbys();
		pr = u.getPr();
		prevUri = u.getPrevUri();
	}
	if (name == null)
		name = "";
	if (user_id == null)
		user_id = "";
	if (password == null)
		password = "";
	if (password2 == null)
		password2 = "";
	if (email == null)
		email = "";
	if (reg_num == null)
		reg_num = "";
	if (zip == null)
		zip = "";
	if (address == null)
		address = "";
	if (job == null)
		job = "";
	if (hobbys != null) {
		for (int i = 0; i < hobbys.length; i++) {
			hobby[i] = "checked";
		}
	}
	if (pr == null)
		pr = "";

	if (prevUri == null) {
		prevUri = request.getParameter("prevUri");
		if (prevUri == null) {
			prevUri = "index.jsp";
		}
	}
%>



<!DOCTYPE html>

<head>
<title>비트캠프 신촌</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="mystylesheet/mystylesheet.css?ver=1">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.2.0/css/all.css?ver=3"
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
			</a> <a class="rightactive">회원가입</a>


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
				<div
					style="text-align: center; display: inline; padding-left: 38%; font-weight: bold; font-size: 25px;">회원가입</div>
				<br> <br>
				<div style="padding-left: 10px; color: red;" id="error">
					<label><b style="padding-left: 20%;">회원가입이 완료되었습니다!</b></label>
				</div>
				<br> <br>
				<div style="width: 100%;">
					<div class="complete">1.이름</div>
					<div class="complete2"><%=name%></div>
				</div>
				<div style="width: 100%;">
					<div class="complete">2.id</div>
					<div class="complete2"><%=user_id%></div>
				</div>
				<div style="width: 100%;">
					<div class="complete">3.메일주소</div>
					<div class="complete2"><%=email%></div>
				</div>
				<div style="width: 100%;">
					<div class="complete">4.주민번호</div>
					<div class="complete2"><%=reg_num%></div>
				</div>
				<div style="width: 100%;">
					<div class="complete">5.우편번호</div>
					<div class="complete2"><%=zip%></div>
				</div>
				<div style="width: 100%;">
					<div class="complete">6.주소</div>
					<div class="complete2"><%=address%></div>
				</div>
				<div style="width: 100%;">
					<div class="complete">7.직업</div>
					<div class="complete2"><%=job%></div>
				</div>
				<div style="width: 100%;">
					<div class="complete">8.취미</div>
					<div class="complete2">
						<%
							if (hobbys != null) {
								for (int i = 0; i < hobbys.length; i++) {
						%>
						<%=hobbys[i]%>&nbsp
						<%
							}
							} else {
						%>
						&nbsp
						<%
							}
						%>
					</div>
				</div>
				<div style="width: 100%;">
					<div class="complete">9.가입인사</div>
					<div class="complete2"><%=pr%></div>
				</div>

				<form action="<%=prevUri%>" method="post" style="padding-left: 34%;">
					<button type="submit"
						style="background-color: darkred; width: 200px;">완료</button>
				</form>
			</div>


		<%@include file="commons/footer.jsp"%>
</body>

</html>