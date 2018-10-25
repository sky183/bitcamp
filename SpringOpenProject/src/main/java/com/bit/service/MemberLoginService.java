package com.bit.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bit.dao.MemberInfoDao;
import com.bit.model.MemberInfo;

@Repository
public class MemberLoginService {

	@Autowired
	SqlSessionTemplate sessionTemplate;

	private MemberInfoDao memberDao;

	@Transactional
	public MemberInfo memberLogin(String userId, String password) throws Exception {

		MemberInfo memberInfo;

		memberDao = sessionTemplate.getMapper(MemberInfoDao.class);

		memberInfo = memberDao.selectById(userId);

		if (!memberInfo.getPassword().equals(password)) {
			throw new Exception();
		}

		return memberInfo;

	}
}
