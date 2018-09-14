package com.codechobo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
			String DB_DRIVER = "com.mysql.jdbc.Driver";
			String DB_URL = "jdbc:mysql://localhost:3306/book_ex?useUnicode=true&characterEncoding=utf8";
			String DB_USER = "zerock"; // DB의 userid와 pwd를 알맞게 변경
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
				u.setPassword(rs.getString(2));
				u.setName(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setReg_num(rs.getString(5));
				u.setZip(rs.getString(6));
				u.setAddress(rs.getString(7));
				u.setJob(rs.getString(8));
				u.setHobby(rs.getString(9));
				u.setPr(rs.getString(10));
				u.setIn_date(rs.getDate(11));
				u.setUp_date(rs.getDate(12));
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
			ps.setString(1, u.getUser_id()); // User_ID 에 아이디를 넣어서 ps에 담아서 쿼리실행
			rs = ps.executeQuery(); // rs = ps.executeQuery(query);과 같이 하지 않음에 주의
			rs.next();
			do {
				u.setUser_id(rs.getString(1));
				u.setPassword(rs.getString(2));
				u.setName(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setReg_num(rs.getString(5));
				u.setZip(rs.getString(6));
				u.setAddress(rs.getString(7));
				u.setJob(rs.getString(8));
				u.setHobby(rs.getString(9));
				u.setPr(rs.getString(10));
				u.setIn_date(rs.getDate(11));
				u.setUp_date(rs.getDate(12));
			} while (rs.next());

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

		String sql = "insert into USER_INFO values (?,?,?,?,?,?,?,?,?,?,now(),now())"; // ""안에 ;를 넣지 않아도 된다.
//     String sql = "insert into USER_INFO values (?,?,?,?, sysdate, sysdate)"; // oracle일 경우

		try ( // 3.1 DB연결
				PreparedStatement ps = conn.prepareStatement(sql);) {
			conn.setAutoCommit(true);

			// 3.2 쿼리 셋팅 & 실행
			ps.setString(1, u.getUser_id());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getName());
			ps.setString(4, u.getEmail());
			ps.setString(5, u.getReg_num());
			ps.setString(6, u.getZip());
			ps.setString(7, u.getAddress());
			ps.setString(8, u.getJob());
			ps.setString(9, u.getHobby());
			ps.setString(10, u.getPr());
			
			cnt = ps.executeUpdate(); // ps.executeUpdate(sql);과 같이 하지 않음에 주의

			return cnt;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	// 매개변수로 저장한 객체를 DB에 update하는 메서드. 성공하면 1을 반환, 실패하면 -1을 반환
	int updateUser(User u) {
		String sql = "UPDATE user_info set name=?, password=?, email=?, reg_num=?, zip=?, address=?, job=?, hobby=?, pr=?, in_date=?, up_date=? "
				+ " WHERE user_id = ?"; // ""안에
		// ;를
		// 넣지
		// 않아도
		// 된다.

		try ( // 3.1 DB연결
				PreparedStatement ps = conn.prepareStatement(sql);) {
			conn.setAutoCommit(true);
			// 3.2 쿼리 셋팅 & 실행
			ps.setString(1, u.getName());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getReg_num());
			ps.setString(5, u.getZip());
			ps.setString(6, u.getAddress());
			ps.setString(7, u.getJob());
			ps.setString(8, u.getHobby());
			ps.setString(9, u.getPr());
			ps.setDate(10, u.getIn_date());
			ps.setDate(11, u.getUp_date());
			ps.setString(12, u.getUser_id());

			return ps.executeUpdate(); // ps.executeUpdate(sql);과 같이 하지 않음에 주의
		} catch (Exception e) {
			e.printStackTrace();

			return -1;
		}
	}
}

class User {
	private String user_id;
	private String password;
	private String name;
	private String email;
	private String reg_num;
	private String zip;
	private String address;
	private String job;
	private String hobby;
	private String pr;
	private java.sql.Date in_date;
	private java.sql.Date up_date;

	public User() {
	}

	public User(String user_id) {
		this.user_id = user_id;
	}

	public User(String user_id, String password, String name, String email, String reg_num, String zip, String address,
			String job, String hobby, String pr) {
		this(user_id, password, name, email, reg_num, zip, address, job, hobby, pr,
				new java.sql.Date(new java.util.Date().getTime()), new java.sql.Date(new java.util.Date().getTime()));
	}

	public User(String user_id, String password, String name, String email, String reg_num, String zip, String address,
			String job, String hobby, String pr, java.sql.Date in_date, java.sql.Date up_date) {
		super();
		this.user_id = user_id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.reg_num = reg_num;
		this.zip = zip;
		this.address = address;
		this.job = job;
		this.hobby = hobby;
		this.pr = pr;
		this.in_date = in_date;
		this.up_date = up_date;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", password=" + password + ", name=" + name + ", email=" + email
				+ ", reg_num=" + reg_num + ", zip=" + zip + ", address=" + address + ", job=" + job + ", hobby=" + hobby
				+ ", pr=" + pr + ", in_date=" + in_date + ", up_date=" + up_date + "]";
	}

	public String getPr() {
		return pr;
	}

	public void setPr(String pr) {
		this.pr = pr;
	}

	public String getReg_num() {
		return reg_num;
	}

	public void setReg_num(String reg_num) {
		this.reg_num = reg_num;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
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
