package com.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bit.model.MemberInfo;

@Repository
public class MemberDao {

	String sql;
	PreparedStatement pstmt;
	ResultSet rs;

	private MemberDao() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("JDBC드라이버 로드 완료" + cnfe.getMessage());
		}
	}

	public List<MemberInfo> selectAll(Connection conn) {
		List<MemberInfo> members = new ArrayList<MemberInfo>();
		sql = "select * from member";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql); 
			while (rs.next()) {
				MemberInfo member = new MemberInfo();
				member.setIdx(rs.getInt(1));
				member.setUserId(rs.getString(2));
				member.setPassword(rs.getString(3));
				member.setUserName(rs.getString(4));
				member.setUserPhoto(rs.getString(5));
				member.setRegDate(rs.getDate(6));
				members.add(member);
			}
			pstmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return members;
	}

	public MemberInfo select(Connection conn, String userId) {
		sql = "select * from member where userid='" + userId + "'";
		MemberInfo mem = new MemberInfo();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				int i = 1;
				mem.setIdx(rs.getInt(i));
				mem.setUserId(rs.getString(++i));
				mem.setPassword(rs.getString(++i));
				mem.setUserName(rs.getString(++i));
				mem.setUserPhoto(rs.getString(++i));
				mem.setRegDate(rs.getDate(++i));

				break;
			}
			pstmt.close();
			rs.close();
			/* conn.close(); */
		} catch (Exception e) {

		}

		return mem;
	}

	public int update(Connection conn, MemberInfo mem) throws Exception {
		try {

			sql = "update member set password=?, username=?, userphoto=? where userid=?";
			pstmt = conn.prepareStatement(sql);
			int i = 1;
			
			pstmt.setString(i, mem.getPassword());
			pstmt.setString(++i, mem.getUserName());
			pstmt.setString(++i, mem.getUserPhoto());
			pstmt.setString(++i, mem.getUserId());
			pstmt.executeUpdate();

			pstmt.close();

			return 1;
		} catch (Exception e) {
			throw e;
//			return -1;
		}
	}

	public int insert(Connection conn, MemberInfo mem) throws Exception {
		try {
			sql = "insert into member values (seq.nextval,?,?,?,?,sysdate)";
			pstmt = conn.prepareStatement(sql);
			int i = 1;

			pstmt.setString(i, mem.getUserId());
			pstmt.setString(++i, mem.getPassword());
			pstmt.setString(++i, mem.getUserName());
			pstmt.setString(++i, mem.getUserPhoto());

			pstmt.executeUpdate();

			pstmt.close();

			return 1;
		} catch (Exception e) {
			throw e;
		}
	}
	
	public int delete(Connection conn, String userId) throws Exception {
		try {
			sql = "delete from member where userid = ?";
			pstmt = conn.prepareStatement(sql);
			int i = 1;
			
			pstmt.setString(i, userId);
			
			pstmt.executeUpdate();
			
			pstmt.close();
			
			return 1;
		} catch (Exception e) {
			throw e;
		}
	}
}
