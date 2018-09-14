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
			if (hobby[i] != "")
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
<link rel="stylesheet" href="mystylesheet/mystylesheet.css?ver=3">
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
			<form action="/MembershipAction" method="post">
				<div
					style="text-align: center; display: inline; padding-left: 38%; font-weight: bold; font-size: 25px;">회원가입</div>
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
				<script type="text/javascript">
					
				</script>


				<div class="container">
					<div class="label">
						<label for="name"><b>*이름</b></label>
					</div>
					<input type="text" placeholder="이름을 입력하세요." name="name"
						value="<%=name%>" required>

					<div class="label">
						<label for="user_id"> <b>*ID</b></label>
					</div>
					<input type="text" style="width: 60%;" placeholder="아이디를 입력하세요."
						name="user_id" value="<%=user_id%>" required> <input
						type="hidden" name="prevUri" value=<%=prevUri%>>
					<button type="button" class="cancelbtn">중복검사</button>

					<div class="label">
						<label for="password"> <b>*비밀번호</b></label>
					</div>
					<input type="password" placeholder="비밀번호를 입력하세요." name="password"
						value="<%=password%>" required>
					<div class="label">
						<label for="password2"> <b>*비밀번호확인</b></label>
					</div>
					<input type="password" placeholder="비밀번호를 다시 입력하세요."
						name="password2" value="<%=password2%>" required>
					<div class="label">
						<label for="email"> <b>*메일주소</b></label>
					</div>
					<input type="text" placeholder="메일주소를 입력하세요." name="email"
						value="<%=email%>" required>
					<div class="label">
						<label for="reg_num"> <b>*주민등록번호</b></label>
					</div>
					<input type="text" placeholder="주민등록번호를 ' - ' 제외하고 입력하세요."
						name="reg_num" value="<%=reg_num%>" required>

					<div class="label">
						<label for="zip"> <b>*우편번호</b></label>
					</div>
					<input type="text" style="width: 60%;" placeholder="우편번호를 입력하세요."
						name="zip" value="<%=zip%>" required>
					<form action="" method="post">
						<input type="hidden" name="prevUri" value=<%=prevUri%>>
						<button type="submit" class="cancelbtn">우편번호검색</button>
					</form>

					<div class="label">
						<label for="address"> <b>*주소</b></label>
					</div>
					<input type="text" placeholder="주소를 입력하세요." name="address"
						value="<%=address%>" required>

					<div class="label">
						<label for="job"> <b>직업</b></label>
					</div>
					<select name="job">
						<option value="학생">학생</option>
						<option value="비트캠프">비트캠프</option>
						<option value="강사">강사</option>
						<option value="교수">교수</option>
						<option value="회사원">회사원</option>
					</select>

					<div class="label">
						<label for="hobby"> <b>취미</b></label>
					</div>
					<div class="check">
						<input type="checkbox" name="hobby" value="독서" <%=hobby[0]%>>독서
						<input type="checkbox" name="hobby" value="드라이브" <%=hobby[1]%>>드라이브
						<input type="checkbox" name="hobby" value="영화" <%=hobby[2]%>>영화
						<input type="checkbox" name="hobby" value="콘서트" <%=hobby[3]%>>콘서트
						<input type="checkbox" name="hobby" value="쇼핑" <%=hobby[4]%>>쇼핑
						<input type="checkbox" name="hobby" value="놀이동산" <%=hobby[5]%>>놀이동산
					</div>


					<div class="label">
						<label for="pr"> <b>한줄자기소개</b></label>
					</div>
					<input type="text" placeholder="자기소개를 입력하세요." name="pr"
						value="<%=password2%>"> <input type="hidden"
						name="prevUri" value="<%=prevUri%>">
					<button type="submit" style="background-color: darkred;">회원가입</button>
				</div>
			</form>
		</div>

		<%@include file="commons/footer.jsp"%>
</body>

</html>