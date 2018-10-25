package com.bit.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bit.dao.MessageDao;
import com.bit.exception.ServiceException;
import com.bit.model.Message;

@Repository
public class WriteMessageService {

	@Autowired
	SqlSessionTemplate sessionTemplate;

	private MessageDao messageDao;

	@Transactional
	public void write(Message message) {

		messageDao = sessionTemplate.getMapper(MessageDao.class);
		
		messageDao.insert(message);

	}

}
