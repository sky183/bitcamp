package com.sb.board.dao;

import java.util.List;

import com.sb.board.model.BoardVO;
import com.sb.board.model.MemberVO;

public interface BoardDao {
	
	// 로그인
	public MemberVO selectById(String id);
	
	// 게시글 리스트 조회
	public List<BoardVO> boardList() throws Exception;
	
    // 게시글 등록
	public void insertBoard(BoardVO boardVO) throws Exception;

	// 게시글 조회
	public BoardVO selectBoard(int num) throws Exception;

	// 게시글 조회수 증가
	public void countView(int num) throws Exception;



}
