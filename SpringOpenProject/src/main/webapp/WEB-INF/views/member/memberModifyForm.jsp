<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/default.css">
    <style>
        h2, td {
            padding-bottom: 10px;
            padding-top: 10px;
        }

        td {
            text-align: center;
            border: 1px solid black;
            width: 100px;
        }


    </style>
</head>
<body>
<%@ include file="/WEB-INF/views/common/header.jsp"%>

<form action="<%=request.getContextPath()%>/memberModified" method="post" enctype="multipart/form-data">

    <h2> 회원 수정</h2>
    <table>
        <tr>
            <td class="tablehead">
                id
            </td>
            <td>
                <input type="text" readonly name="userId" value="${memberInfo.userId}">
            </td>

        </tr>
        <tr>
            <td class="tablehead">
                pwd
            </td>
            <td>
                <input type="text" name="password" value="${memberInfo.password}">
            </td>
        </tr>
        <tr>
            <td class="tablehead">
                name
            </td>
            <td>
                <input type="text" name="userName" value="${memberInfo.userName}">
            </td>

        </tr>
        <tr>
            <td class="tablehead">
                photo
            </td>
            <td>
                <input type="file" name="photoFile">
                <%--사진을 수정안할 수 있기 때문에 이전값으로 저장해서 보내줌 --%>
                <input type="hidden" name="preUserPhoto" value="${memberInfo.userPhoto}" >
            </td>
        </tr>
        <tr>
            <td colspan="2" style="padding: 0; height: 70px">
                <input class="summm" type="submit" value="수 정">
            </td>

        </tr>
    </table>
</form>
</body>
</html>

