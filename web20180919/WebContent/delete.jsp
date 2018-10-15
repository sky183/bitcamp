<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
   String empno = request.getParameter("empno");

   //1. 데이터베이스 드라이버 로드
/*     Class.forName("oracle.jdbc.driver.OracleDriver");  */
   
   Connection conn = null;
   PreparedStatement pstmt = null;
   
   //데이터베이스에 연결정보 가져옴
   String url = "jdbc:oracle:thin:@localhost:1522:orcl";
   String user = "scott";
   String pw = "tiger";
   int resultCnt = 0;
   
   try{
   conn = DriverManager.getConnection(url,user,pw);
   
   String sql = "delete from emp where empno = ?";
   
   pstmt = conn.prepareStatement(sql);
   //empno는 파라미터로 값을 불러올때 string타입이므로 int타입으로 변환시켜줘야함
   pstmt.setInt(1, Integer.parseInt(empno));
   resultCnt = pstmt.executeUpdate();
   
   } finally{
      pstmt.close();
      conn.close();
   }
%>

<h1> 삭제완료 <%= resultCnt %> <a href = "emp_list.jsp">emp LIST</a></h1>
</body>
</html>