<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>emp_list</title>
</head>
<body>

<table border>
   <tr>
      <td>사원번호</td>
      <td>사원이름</td>
      <td>직급</td>
      <td>관리</td>
   </tr>
   <%
      // 1. 데이터베이스 드라이버 로드
/*       Class.forName("oracle.jdbc.driver.OracleDriver"); */
      
      Connection conn = null;
      Statement stmt = null;
      ResultSet rs = null;
      
      String url = "jdbc:oracle:thin:@localhost:1522:orcl";
      String user = "scott";
      String pw = "tiger";
      try{
      // 2. 컨넥션 객체 생성
      conn = DriverManager.getConnection(url,user,pw);
      
      // 3. statement 객체 생성
      stmt = conn.createStatement();
      
      String list_sql = "select empno, ename, job from emp order by empno";
      
      // 4. 쿼리 실행
      rs = stmt.executeQuery(list_sql);
      
      if(rs.next()){
         do{
         %>
   <tr>
      <td><%= rs.getInt(1) %></td>
      <td><%= rs.getString(2) %></td>
      <td><%= rs.getString(3) %></td>
      <td><a href ="editForm.jsp?empno=<%= rs.getInt(1) %>">수정</a> <a href="delete.jsp?empno=<%= rs.getInt(1) %>">삭제</a></td>
   </tr>
         
         <%
         } while(rs.next());
         //rs에 다음 목록이 없다면?
      } else{
         %>
   <tr>
      <td colspan = "3">등록된 사원정보가 없습니다.</td>
   </tr>
         
         <%
      }
      
      } finally{
         
         if(rs != null){
            try{
               rs.close();
            } catch (SQLException se){
            }
         }
         if(stmt != null){
            try{
               stmt.close();
            } catch(SQLException se){
            }
         }
         if(conn != null){
            try{
               conn.close();
            }catch(SQLException se){
            }
         }
      }
      
   %>
   
</table>


</body>
</html>