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
	
	//매개변수 페이지넘버는 표시할 페이지
	@Transactional
	public MessageListView getMessageList(int pageNumber) {

		messageDao = sessionTemplate.getMapper(MessageDao.class);

		int currentPageNumber = pageNumber;

		// 전체 메시지 구하기
		//메세지 갯수
		int messageTotalCount = messageDao.selectCount();
		//메세지가 담길 리스트
		List<Message> messageList = null;
		int firstRow = 0;
		int endRow = 0;
		//메세지 갯수가 0보다 크면 첫 행에는 표시할 페이지 -1  * 10을 한다 - 이것은 표시할 행의 시작 인덱스다.
		//마지막 행에는 표시할 페이지 갯수를 적는다.
		if (messageTotalCount > 0) {
			firstRow = (pageNumber - 1) * MESSAGE_COUNT_PER_PAGE;
			endRow = MESSAGE_COUNT_PER_PAGE;
			//현재 페이지에 표시할 메세지를 가져온다.
			messageList = messageDao.selectList(firstRow, endRow);
		} else {
			currentPageNumber = 0;
			messageList = Collections.emptyList();
		}
		return new MessageListView(messageList, messageTotalCount, currentPageNumber, MESSAGE_COUNT_PER_PAGE, firstRow,
				endRow);
	}
}
