package com.bit.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bit.dao.MessageDao;
import com.bit.model.Message;

@Repository
public class ViewMessageService {

	@Autowired
	SqlSessionTemplate sessionTemplate;

	private MessageDao messageDao;

	@Transactional
	public Message getMessage(int id) {

		messageDao = sessionTemplate.getMapper(MessageDao.class);

		Message message;

		message = messageDao.select(id);

		return message;

	}

}
