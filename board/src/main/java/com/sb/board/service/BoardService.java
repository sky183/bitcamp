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
		
		if (boardVO.getPassword() == null || boardVO.getPassword().equals("")) {
			dao.insertBoard2(boardVO);
		} else {
			dao.insertBoard(boardVO);
		}
		
	}
	
	// 게시글 조회
	@Transactional
	public BoardVO selectBoard(int num) throws Exception {

		BoardVO boardVO = new BoardVO();
		dao = sqlSessionTemplate.getMapper(BoardDao.class);
		boardVO = dao.selectBoard(num);

		return boardVO;
	}
	
	// 비번 업데이트
	@Transactional
	public void updatePw(BoardVO boardVO) throws Exception {
		
		dao = sqlSessionTemplate.getMapper(BoardDao.class);
		
		dao.updatePw(boardVO);
		
	}
	
}