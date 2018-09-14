package com.codechobo2;

import java.sql.*;

import com.codechobo.User;

public class MVCTest4 {
	public static void main(String[] args) {

		User u = selectUser("asdf"); // 객체 u에 저장된 user_id와 동일한 행의 정보를 update하는 메서드

		System.out.println(u);
	}

	static User selectUser(String userId) {

		Connection conn = null; // null로 초기화 한다.
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String user_id = "";
		String password = "";
		String name = "";
		String email = "";

		try {
			String url = "jdbc:mysql://localhost:3306/book_ex?useUnicode=true&characterEncoding=utf8"; // 사용하려는 데이터베이스명을
																										// 포함한 URL 기술
			String id = "zerock"; // 사용자 계정
			String pw = "1234"; // 사용자 계정의 패스워드

			Class.forName("com.mysql.jdbc.Driver"); // 데이터베이스와 연동하기 위해 DriverManager에 등록한다.

			conn = DriverManager.getConnection(url, id, pw); // DriverManager 객체로부터 Connection 객체를 얻어온다.

			String sql = "select * from user_info where USER_ID = ?"; // sql 쿼리
			pstmt = conn.prepareStatement(sql); // prepareStatement에서 해당 sql을 미리 컴파일한다.

			pstmt.setString(1, userId);
			rs = pstmt.executeQuery(); // 쿼리를 실행한다.

			while (rs.next()) { // 결과를 한 행씩 돌아가면서 가져온다.
				user_id = rs.getString("USER_ID");
				password = rs.getString("PASSWORD");
				name = rs.getString("NAME");
				email = rs.getString("EMAIL");
			}
		} catch (Exception e) { // 예외가 발생하면 예외 상황을 처리한다.
			e.printStackTrace();
			System.out.println("USER_INFO 테이블의 새로운 레코드 업데이트에 실패했습니다.");
		} finally { // 쿼리가 성공 또는 실패에 상관없이 사용한 자원을 해제 한다. (순서중요)
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException sqle) {
				} // PreparedStatement 객체 해제
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException sqle) {
				} // Connection 해제
		}
		return  new User(user_id, password, name, email);

	}

}
