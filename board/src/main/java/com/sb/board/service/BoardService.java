package com.sb.board.service;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sb.board.dao.BoardDao;
import com.sb.board.model.BoardVO;

@Repository
public class BoardService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private BoardDao dao;

	// 게시글 리스트 조회
	@Transactional
	public List<BoardVO> boardList() throws Exception {

		List<BoardVO> boardList = new ArrayList<BoardVO>();
		dao = sqlSessionTemplate.getMapper(BoardDao.class);
		boardList = dao.boardList();

		return boardList;
	}
	
	// 게시글 작성
	@Transactional
	public void boardWrite(BoardVO boardVO) throws Exception {
		
		dao = sqlSessionTemplate.getMapper(BoardDao.class);
		dao.insertBoard(boardVO);
		
	}
}