package com.codechobo2;
/*package com.codechobo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JdbcTest8 {
	public static void main(String[] args) {
		UserDao udao = UserDao.getInstance();

		List<User> list = udao.selectAllUsers();
		System.out.println(list);

	} // main()의 끝

} // 클래스의 끝

class Dao {
	Connection conn;
	String tableName = "";

	Dao() {
		this(null, "");
	}

	Dao(String tableName) {
		this(null, tableName);
	}

	Dao(Connection conn, String tableName) {
		this.tableName = tableName;
		if (conn != null) {
			this.conn = conn;
		} else {
			conn = null;
		}
	}

	void rollback() {
		if (conn != null) {
			try {
				conn.rollback();
			} catch (SQLException e) {

			}
		}
	}

	void close(AutoCloseable... acs) throws Exception {
		for (int i = 0; i < acs.length; i++) {
			if (acs[i] != null)
				try {
					acs[i].close();
				} catch (SQLException sqle) {
				}
		}
	}
}

class UserDao extends Dao {

	PreparedStatement pstmt = null;
	ResultSet rs = null;
	static String url = "jdbc:mysql://localhost:3306/book_ex?useUnicode=true&characterEncoding=utf8";
	static String id = "zerock"; // 사용자 계정
	static String pw = "1234"; // 사용자 계정의 패스워드

	private UserDao() throws SQLException {
		super(DriverManager.getConnection(url, id, pw), "user_info");
	};

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 데이터베이스와 연동하기 위해 DriverManager에 등록한다.
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private static UserDao instance;

	public static UserDao getInstance() throws SQLException {
		if (instance == null) {
			instance = new UserDao();
		}
		return instance;
	}

	List<User> selectAllUsers() {

		String user_id = "";
		String password = "";
		String name = "";
		String email = "";
		List<User> list = new ArrayList<User>();

		try {

			conn = DriverManager.getConnection(url, id, pw); // DriverManager 객체로부터 Connection 객체를 얻어온다.

			String sql = "select * from user_info"; // sql 쿼리
			pstmt = conn.prepareStatement(sql); // prepareStatement에서 해당 sql을 미리 컴파일한다.
			rs = pstmt.executeQuery(); // 쿼리를 실행한다.

			while (rs.next()) { // 결과를 한 행씩 돌아가면서 가져온다.
				user_id = rs.getString("USER_ID");
				password = rs.getString("PASSWORD");
				name = rs.getString("NAME");
				email = rs.getString("EMAIL");
				list.add(new User(user_id, password, name, email));
			}
		} catch (Exception e) { // 예외가 발생하면 예외 상황을 처리한다.
			e.printStackTrace();
			System.out.println("USER_INFO 테이블의 새로운 레코드 업데이트에 실패했습니다.");
		} finally { // 쿼리가 성공 또는 실패에 상관없이 사용한 자원을 해제 한다.
			try {
				close(pstmt, conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;

	}

	int deleteUser(String userId) {

		int delete = 0;

		try {
			conn = DriverManager.getConnection(url, id, pw); // DriverManager 객체로부터 Connection 객체를 얻어온다.

			String sql = "delete from user_info where USER_ID = ?"; // sql 쿼리
			pstmt = conn.prepareStatement(sql); // prepareStatement에서 해당 sql을 미리 컴파일한다.
			pstmt.setString(1, userId);

			pstmt.executeUpdate(); // 쿼리를 실행한다.
			return delete;

		} catch (Exception e) { // 예외가 발생하면 예외 상황을 처리한다.
			e.printStackTrace();
			System.out.println("USER_INFO 테이블 삭제에 실패했습니다.");
			return -1;
		} finally { // 쿼리가 성공 또는 실패에 상관없이 사용한 자원을 해제 한다. (순서중요)
			try {
				close(pstmt, conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	User selectUser(String userId) {

		String user_id = "";
		String password = "";
		String name = "";
		String email = "";

		try {

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
			try {
				close(pstmt, conn, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return new User(user_id, password, name, email);

	}

	int updateUser(User u) {
		int update = 0;

		try {

			conn = DriverManager.getConnection(url, id, pw); // DriverManager 객체로부터 Connection 객체를 얻어온다.

			String sql = "UPDATE user_info SET PASSWORD=?, NAME=?, EMAIL=? WHERE USER_ID=?"; // sql 쿼리
			pstmt = conn.prepareStatement(sql); // prepareStatement에서 해당 sql을 미리 컴파일한다.
			pstmt.setString(1, u.getPw());
			pstmt.setString(2, u.getName());
			pstmt.setString(3, u.getMailid());
			pstmt.setString(4, u.getId());
			pstmt.executeUpdate(); // 쿼리를 실행한다.

			System.out.println("USER_INFO 테이블에 레코드를 업데이트하였습니다."); // 성공시 메시지 출력
		} catch (Exception e) { // 예외가 발생하면 예외 상황을 처리한다.

			e.printStackTrace();
			System.out.println("USER_INFO 테이블의 새로운 레코드 업데이트에 실패했습니다.");

		} finally { // 쿼리가 성공 또는 실패에 상관없이 사용한 자원을 해제 한다. (순서중요)
			try {
				close(pstmt, conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return update;

	}

	void insertUser(User u) {

		try {
			String url = "jdbc:mysql://localhost:3306/book_ex?useUnicode=true&characterEncoding=utf8"; // 사용하려는 데이터베이스명을
																										// 포함한 URL 기술
			String id = "zerock"; // 사용자 계정
			String pw = "1234"; // 사용자 계정의 패스워드

			conn = DriverManager.getConnection(url, id, pw); // DriverManager 객체로부터 Connection 객체를 얻어온다.

			String sql = "insert into user_info values(?,?,?,?,?,?)"; // sql 쿼리
			pstmt = conn.prepareStatement(sql); // prepareStatement에서 해당 sql을 미리 컴파일한다.
			pstmt.setString(1, u.getId());
			pstmt.setString(2, u.getPw());
			pstmt.setString(3, u.getName());
			pstmt.setString(4, u.getMailid()); // 현재 날짜와 시간
			pstmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
			pstmt.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
			pstmt.executeUpdate(); // 쿼리를 실행한다.

			System.out.println("member 테이블에 새로운 레코드를 추가했습니다."); // 성공시 메시지 출력
		} catch (Exception e) { // 예외가 발생하면 예외 상황을 처리한다.

			e.printStackTrace();
			System.out.println("member 테이블에 새로운 레코드 추가에 실패했습니다.");

		} finally { // 쿼리가 성공 또는 실패에 상관없이 사용한 자원을 해제 한다. (순서중요)
			try {
				close(pstmt, conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
*/