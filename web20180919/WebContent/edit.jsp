<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
   request.setCharacterEncoding("utf-8");
   //에딧 폼에서 데이터를 받아온다
   String empno = request.getParameter("empno");
   String ename = request.getParameter("ename");
   String job = request.getParameter("job");
   //1. 데이터베이스 드라이버 로드
/*    Class.forName("oracle.jdbc.driver.OracleDriver"); */
         
   Connection conn = null;
   PreparedStatement pstmt = null;
   //데이터베이스에 연결정보 가져옴
   String url = "jdbc:oracle:thin:@localhost:1522:orcl";
   String user = "scott";
   String pw = "tiger";
   int resultCnt=0;
   try{
   //컨넥션 객체를 가져옴
   conn = DriverManager.getConnection(url,user,pw);
   
   //prepared객체 생성(prepared는 생성전에 sql문을 먼저 만들어야함)
   String sql = "update emp set ename = ?, job = ? where empno = ?";
   pstmt = conn.prepareStatement(sql);
   //pstmt에 파라미터로 받아온 값을 ?에 대입하고 저장해서 업데이트함
   pstmt.setString(1, ename);
   pstmt.setString(2, job);
   pstmt.setInt(3, Integer.parseInt(empno));
   //update문이므로 익스큐트 쿼리가 아니라 업데이트
   resultCnt = pstmt.executeUpdate();

   } finally{
      pstmt.close();
      conn.close();
   }
   
%>

<h1><% if(resultCnt > 0){
      %>수정완료 <a href = "emp_list.jsp">emp LIST</a></h1>
      <%
}
%>
</body>
</html>