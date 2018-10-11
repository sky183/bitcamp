<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
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
   String empno = request.getParameter("empno");
   
   //1. 데이터베이스 드라이버 로드
/*       Class.forName("oracle.jdbc.driver.OracleDriver"); */
      
      Connection conn = null;
      Statement stmt = null;
      ResultSet rs = null;
      
      String url = "jdbc:oracle:thin:@localhost:1522:orcl";
      String user = "scott";
      String pw = "tiger";
      
      // 2. 컨넥션 객체 생성
      conn = DriverManager.getConnection(url,user,pw);
            
      // 3. statement 객체 생성
      stmt = conn.createStatement();
      
      String list_sql = "select empno, ename, job from emp where empno = " + empno;
            
      // 4. 쿼리 실행
      rs = stmt.executeQuery(list_sql);
      
      String ename = null;
      String job = null;
      //rs가 있다면 해당 변수에 데이터베이스의 값을 불러옴
      if(rs.next()){
         ename = rs.getString("ename");
         job = rs.getString("job");
      }
%>

<form action="edit.jsp" type = "psot">
   <table>
      <tr>
         <td>사원번호</td>
         <td><input type = "text" value = "<%= empno %>"  name = "empno" readonly></td>
      </tr>
      <tr>
         <td>사원이름</td>
         <td><input type = "text" value = "<%= ename %>"  name = "ename"></td>
      </tr>
      <tr>
         <td>사원직급</td>
         <td><input type = "text" value = "<%= job %>"  name = "job"></td>
      </tr>
      <tr>
         <td colsapn = "2"><input type = "submit" value = "수정"></td>
      </tr>
   </table>
</form>
</body>
</html>