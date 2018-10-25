package com.bit.dao;

import java.util.List;

import com.bit.model.Message;

public interface MessageDao {

	public int insert(Message message);

	public int selectCount();

	public List<Message> selectList(int firstRow, int endRow);

	public Message select(int messageId);

	public int update (Message message);
	
	public void delete(int messageId);

}



