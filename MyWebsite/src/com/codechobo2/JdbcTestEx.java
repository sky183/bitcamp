package com.codechobo2;
/*package com.codechobo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcTestEx {
	public static void main(String[] args) {
		
		UserDao udao = UserDao.getInstance();

		List<User> list = udao.selectAllUsers();
		System.out.println(list);

//	     User u = new User("asdf","남궁성","1234","aaa@aa8a.com");
		//
//	     System.out.println(udao.insertUser(u));
//	     u.setUser_id("asdf");
//	     System.out.println(udao.updateUser(u));
//	     System.out.println(udao.selectUser(u));   
//	     System.out.println(udao.deleteUser(u));
//	     System.out.println(udao.selectUser(u));   
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
			String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
			String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
			String DB_USER = "asdf1234"; // DB의 userid와 pwd를 알맞게 변경
			String DB_PASSWORD = "1234";

			// 드라이버를 로딩한다.
			try {
				Class.forName(DB_DRIVER);
				this.conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); // 데이터베이스의 연결을 설정한다.
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // if
	}

	void rollback() {
		if (conn != null) {
			try {
				conn.rollback();
			} catch (SQLException e) {

			}
		}
	}

	void close(AutoCloseable... acs) {
		try {
			for (AutoCloseable ac : acs) {
				if (ac != null)
					ac.close();
			}
		} catch (Exception e) {
		}
	}
}

class UserDao extends Dao {
	UserDao() {
		super(null, "user_info");
	}

	UserDao(Connection conn) {
		super(conn, "user_info");
	}
	private static UserDao instance;
	
	public static UserDao getInstance() {
		if (instance == null) {
			instance = new UserDao();
		}
		return instance;
	}
	

		// 모든 사용자의 정보를 DB에서 가져다 List에 담아서 반환하는 메서드
		List<User> selectAllUsers() {
			List<User> list = new ArrayList<User>();
			String query = "SELECT * FROM user_info"; // 모든 사용자의 정보를 가져온다.
			ResultSet rs = null;

			try (Statement stmt = conn.createStatement(); // Statement를 가져온다.
			) {
				rs = stmt.executeQuery(query); // SQL문을 실행한다.

				while (rs.next()) {
					User u = new User();
					u.setUser_id(rs.getString(1));
					u.setName(rs.getString(2));
					u.setPassword(rs.getString(3));
					u.setEmail(rs.getString(4));
					u.setIn_date(rs.getDate(5));
					u.setUp_date(rs.getDate(6));
					list.add(u);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (rs != null)
					try {
						rs.close();
					} catch (SQLException e) {
					}
				;
			}

			return list;
		}

		// 매개변수로 받은 User객체의 id로 DB에서 조회한 결과를 User객체에 담아 받환하는 메서드
		User selectUser(User u) {
			String query = "SELECT * FROM user_info WHERE USER_ID = ?"; // 사용자 정보를 가져온다. ''를 사용하지 않음에 주의
			ResultSet rs = null;

			try (PreparedStatement ps = conn.prepareStatement(query);) {
				// 3.2 쿼리 셋팅 & 실행
				ps.setString(1, u.getUser_id());

				rs = ps.executeQuery(); // rs = ps.executeQuery(query);과 같이 하지 않음에 주의

				while (rs.next()) {
					u.setUser_id(rs.getString(1));
					u.setName(rs.getString(2));
					u.setPassword(rs.getString(3));
					u.setEmail(rs.getString(4));
					u.setIn_date(rs.getDate(5));
					u.setUp_date(rs.getDate(6));
				}

				return u;
			} catch (Exception e) {
				e.printStackTrace();

				return null;
			} finally {
				if (rs != null)
					try {
						rs.close();
					} catch (SQLException e) {
					}
				;
			}
		}

		// 매개변수로 받은 User객체의 id로 DB에 조회해서 해당 데이터를 삭제하고 그 결과를 반환하는 메서드.

		int deleteUser(User u) {
			int cnt = 0; // delete한 결과를 저장하기 위한 변수
			String query = "DELETE FROM user_info WHERE USER_ID = ?"; // 사용자 정보를 가져온다. ''를 사용하지 않음에 주의

			try ( // 3.1 DB연결
					PreparedStatement ps = conn.prepareStatement(query);) {
				conn.setAutoCommit(true);

				// 3.2 쿼리 셋팅 & 실행
				ps.setString(1, u.getUser_id());

				cnt = ps.executeUpdate(); // ps.executeUpdate(sql);과 같이 하지 않음에 주의

				return cnt;
			} catch (Exception e) {
				e.printStackTrace();

				return -1;
			}
		}

		// 매개변수로 받은 객체에 담긴 데이터를 DB에 넣고, 성공하면 1을 실패하면 -1을 반환하는 메서드

		int insertUser(User u) {
			int cnt = 0; // insert한 결과를 저장하기 위한 변수

			String sql = "insert into USER_INFO values (?,?,?,?,now(),now())"; // ""안에 ;를 넣지 않아도 된다.
//	     String sql = "insert into USER_INFO values (?,?,?,?, sysdate, sysdate)"; // oracle일 경우

			try ( // 3.1 DB연결
					PreparedStatement ps = conn.prepareStatement(sql);) {
				conn.setAutoCommit(true);

				// 3.2 쿼리 셋팅 & 실행
				ps.setString(1, u.getUser_id());
				ps.setString(2, u.getName());
				ps.setString(3, u.getPassword());
				ps.setString(4, u.getEmail());
//	      ps.setDate(5, java.sql.Date.valueOf("2013-09-04"));
				ps.setDate(5, u.getIn_date());
				ps.setDate(6, u.getUp_date());

				cnt = ps.executeUpdate(); // ps.executeUpdate(sql);과 같이 하지 않음에 주의

				return cnt;
			} catch (Exception e) {
				e.printStackTrace();

				return -1;
			}
		}

		// 매개변수로 저장한 객체를 DB에 update하는 메서드. 성공하면 1을 반환, 실패하면 -1을 반환
		int updateUser(User u) {
			String sql = "UPDATE user_info set name=?, password=?, email=?, in_date=?, up_date=? "
					+ " WHERE user_id = ?"; // ""안에 ;를 넣지 않아도 된다.

			try ( // 3.1 DB연결
					PreparedStatement ps = conn.prepareStatement(sql);) {
				conn.setAutoCommit(true);
				// 3.2 쿼리 셋팅 & 실행
				ps.setString(1, u.getName());
				ps.setString(2, u.getPassword());
				ps.setString(3, u.getEmail());
				// ps.setDate(5, java.sql.Date.valueOf("2013-09-04"));
				ps.setDate(4, u.getIn_date());
				ps.setDate(5, u.getUp_date());
				ps.setString(6, u.getUser_id());

				return ps.executeUpdate(); // ps.executeUpdate(sql);과 같이 하지 않음에 주의
			} catch (Exception e) {
				e.printStackTrace();

				return -1;
			}
		}
	}

}

class User {
	private String user_id;
	private String password;
	private String name;
	private String email;
	private java.sql.Date in_date;
	private java.sql.Date up_date;

	public User() {
	}

	public User(String user_id, String password, String name, String email) {
		this(user_id, password, name, email, new java.sql.Date(new java.util.Date().getTime()),
				new java.sql.Date(new java.util.Date().getTime()));
	}

	public User(String user_id, String password, String name, String email, java.sql.Date in_date,
			java.sql.Date up_date) {
		super();
		this.user_id = user_id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.in_date = in_date;
		this.up_date = up_date;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", password=" + password + ", name=" + name + ", email=" + email
				+ ", in_date=" + in_date + ", up_date=" + up_date + "]";
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getIn_date() {
		return in_date;
	}

	public void setIn_date(Date in_date) {
		this.in_date = in_date;
	}

	public Date getUp_date() {
		return up_date;
	}

	public void setUp_date(Date up_date) {
		this.up_date = up_date;
	}
}
*/