package com.bit.service;

import java.util.Collections;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bit.dao.MessageDao;
import com.bit.model.Message;
import com.bit.model.MessageListView;

@Repository
public class GetMessageListService {

	@Autowired
	SqlSessionTemplate sessionTemplate;

	private MessageDao messageDao;

	// 한 페이지에 보여줄 메시지의 수
	private static final int MESSAGE_COUNT_PER_PAGE = 10;

	@Transactional
	public MessageListView getMessageList(int pageNumber) {

		messageDao = sessionTemplate.getMapper(MessageDao.class);

		int currentPageNumber = pageNumber;

		// 전체 메시지 구하기
		int messageTotalCount = messageDao.selectCount();
		List<Message> messageList = null;
		int firstRow = 0;
		int endRow = 0;
		if (messageTotalCount > 0) {
			firstRow = (pageNumber - 1) * MESSAGE_COUNT_PER_PAGE;
			endRow = MESSAGE_COUNT_PER_PAGE;
			messageList = messageDao.selectList(firstRow, endRow);
		} else {
			currentPageNumber = 0;
			messageList = Collections.emptyList();
		}
		return new MessageListView(messageList, messageTotalCount, currentPageNumber, MESSAGE_COUNT_PER_PAGE, firstRow,
				endRow);
	}
}
