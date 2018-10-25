package com.bit.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bit.dao.MessageDao;
import com.bit.model.Message;

@Repository
public class WriteMessageService {

	@Autowired
	SqlSessionTemplate sessionTemplate;

	private MessageDao messageDao;

	@Transactional
	public void write(Message message) throws Exception {

		messageDao = sessionTemplate.getMapper(MessageDao.class);
		
		if (message.getMessage() != null && !message.getMessage().equals("")) {
			messageDao.insert(message);
		} else {
			throw new Exception();
		}
		

	}

}
