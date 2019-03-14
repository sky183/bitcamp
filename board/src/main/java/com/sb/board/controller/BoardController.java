package com.sb.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sb.board.model.BoardVO;
import com.sb.board.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	BoardService service = new BoardService();
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView boardListController() throws Exception {
		
		ModelAndView modelAndView = new ModelAndView("board");
		
		List<BoardVO> boardList = service.boardList();
		
		modelAndView.addObject("boardList", boardList);
		
		return modelAndView;
		
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String boardWriteController() throws Exception {
			
		return "write";
		
	}
}
