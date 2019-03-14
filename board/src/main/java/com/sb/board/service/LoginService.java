package com.sb.board.service;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sb.board.dao.BoardDao;
import com.sb.board.model.MemberVO;

@Repository
public class LoginService {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private BoardDao Dao;
	
	@Transactional
	public boolean login(String id, String pw, HttpSession session) throws SQLException {

		Dao = sqlSessionTemplate.getMapper(BoardDao.class);

		boolean result = false;

		MemberVO member = Dao.selectById(id);

		// 비밀번호 비교
		if (member == null || !member.getPw().equals(pw)) {
				
		} else {

			// 로그인 처리 : 세션에 사용자 데이터 저장
			member.setPw("");		//db에서 받아온 패스워드를 세션에는 제외하고 저장

			session.setAttribute("member", member);
//
//			//세션 시간
//			session.setMaxInactiveInterval(60*60*2);
			
			result = true;
		}

		return result;

	}

}
