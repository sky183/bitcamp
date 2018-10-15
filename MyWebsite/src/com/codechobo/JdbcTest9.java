package com.codechobo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcTest9 {
	public static void main(String[] args) {
		UserDao udao = UserDao.getInstance();

		
		  List<User> list = udao.selectAllUsers(); 
		  System.out.println(list);
		 

		User u = new User("sky18sdf3","sdfsdf", "sdsdfsdf", "sdsdfsdf", "sdsdfsdf", "sdsdfsdf", "sdsdfsdf", "sdsdfsdf", "sdsdfsdf", "sdsdfsdf");
//
		System.out.println(udao.insertUser(u));
//		u.setUser_id("sky183");
//		System.out.println(udao.updateUser(u));
		System.out.println(udao.selectUser(u));
//     System.out.println(udao.deleteUser(u));
//     System.out.println(udao.selectUser(u));   
	} // main()의 끝
} // 클래스의 끝

