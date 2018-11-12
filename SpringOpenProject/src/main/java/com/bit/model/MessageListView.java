package com.bit.model;

import java.util.List;

import org.springframework.stereotype.Repository;


public class MessageListView {
	private int messageTotalCount;
	private int currentPageNumber;
	private List<Message> messageList;
	private int pageTotalCount;
	private int messageCountPerPage;
	private int firstRow;
	private int endRow;

	public MessageListView(List<Message> messageList, int messageTotalCount, int currentPageNumber,
			int messageCountPerPage, int startRow, int endRow) {
		this.messageList = messageList;
		this.messageTotalCount = messageTotalCount;
		this.currentPageNumber = currentPageNumber;
		this.messageCountPerPage = messageCountPerPage;
		this.firstRow = startRow;
		this.endRow = endRow;
		calculatePageTotalCount();

	}
	
	//페이지 계산하기 - 메세지 총 갯수가 0이면 페이지 총 갯수도 0이다.
	//메세지 총 갯수가 0이 아니면 메세지 페이지 총 갯수는 메세지 총 갯수 / 10이다.
	//여기서 메세지 총 갯수를 10으로 나눈 나머지가 0보다 크면 페이지 총 갯수에 하나 더 추가해준다.
	private void calculatePageTotalCount() {
		if (messageTotalCount == 0) {
			pageTotalCount = 0;
		} else {
			pageTotalCount = messageTotalCount / messageCountPerPage;
			if (messageTotalCount % messageCountPerPage > 0) {
				pageTotalCount++;
			}
		}

	}

	public int getMessageTotalCount() {
		return messageTotalCount;
	}

	public int getCurrentPageNumber() {
		return currentPageNumber;
	}

	public List<Message> getMessageList() {
		return messageList;
	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public int getMessageCountPerPage() {
		return messageCountPerPage;
	}

	public int getFirstRow() {
		return firstRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public boolean isEmpty() {
		return messageTotalCount == 0;
	}

}
