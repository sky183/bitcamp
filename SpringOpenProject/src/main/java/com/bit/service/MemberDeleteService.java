package com.bit.service;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bit.dao.MemberDao;
import com.bit.dao.MemberInfoDao;
import com.bit.jdbc.ConnectionProvider;
import com.bit.jdbc.JdbcUtil;

@Repository
public class MemberDeleteService {

	@Autowired
	SqlSessionTemplate sessionTemplate;

	private MemberInfoDao memberDao;

	@Transactional
	public int memberDelete(String userId, String userPhoto, HttpServletRequest request) throws Exception {

		memberDao = sessionTemplate.getMapper(MemberInfoDao.class);

		int resultCnt = 0;

		// 물리적 저장 경로
		String uploadUri = "/uploadfile/userphoto";

		// uploadUri 경로의 시스템 경로
		String dir = request.getSession().getServletContext().getRealPath(uploadUri);

		if (userId != null) {

			memberDao.delete(userId);
			
			new File(dir, userPhoto).delete();

		}
		return resultCnt;

	}
}
