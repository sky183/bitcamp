package com.bit.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bit.dao.MessageDao;
import com.bit.exception.InvalidMessagePassowrdException;
import com.bit.exception.MemberNotFoundException;
import com.bit.exception.MessageNotFoundException;
import com.bit.exception.ServiceException;
import com.bit.model.Message;

@Repository
public class DeleteMessageService {

	@Autowired
	SqlSessionTemplate sessionTemplate;

	private MessageDao messageDao;
	
	@Transactional
	public void deleteMessage(int messageId, String userName, String password) throws ServiceException,
			InvalidMessagePassowrdException, MessageNotFoundException, MemberNotFoundException {

		messageDao = sessionTemplate.getMapper(MessageDao.class);

		Message message = messageDao.select(messageId);
		if (message == null) {
			throw new MessageNotFoundException("메시지가 없습니다:" + messageId);
		}
		if (!(message.getGuestName().equals(userName) || userName.equals("sky18333@naver.com"))) {
			throw new MemberNotFoundException();
		}
		if (!message.hasPassword()) {
			throw new InvalidMessagePassowrdException();
		}
		if (!message.getPassword().equals(password)) {
			throw new InvalidMessagePassowrdException();
		}

		messageDao.delete(messageId);
	}

}
