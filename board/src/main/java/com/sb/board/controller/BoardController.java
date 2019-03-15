package com.sb.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sb.board.model.BoardVO;
import com.sb.board.model.MemberVO;
import com.sb.board.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	BoardService service = new BoardService();
	
	//페이지 이동
	@RequestMapping(value = "/{page}", method = RequestMethod.GET)
	public String errorController(@PathVariable("page") String page) throws Exception {
		return page;

	}
		
	//게시판리스트
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView boardListController() throws Exception {

		ModelAndView modelAndView = new ModelAndView("board");

		List<BoardVO> boardList = service.boardList();

		modelAndView.addObject("boardList", boardList);

		return modelAndView;

	}

	//글쓰기
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String boardWriteController2(BoardVO boardVO, HttpSession session) throws Exception {

		MemberVO member = (MemberVO) session.getAttribute("member");

		boardVO.setName(member.getName());

		try {

			service.boardWrite(boardVO);

		} catch (Exception e) {
		}

		return "redirect:/";
	}
	
	//게시글 보기
	@RequestMapping(value = "/view/{num}", method = RequestMethod.GET)
	public ModelAndView boardViewController(@PathVariable("num") int num) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView("view");
		
		BoardVO boardVO = service.selectBoard(num);
		
		service.countView(num);
		
		modelAndView.addObject("boardVO", boardVO);
		
		return modelAndView;
		
	}
	
	//팝업 이동
	@RequestMapping(value = "/confirm", method = RequestMethod.GET)
	@ResponseBody
	public boolean confirmPw(@RequestParam("num") int num) throws Exception {
		
		BoardVO boardVO = service.selectBoard(num);
		
		if (boardVO.getPassword() == null  || boardVO.getPassword() == "") {
			
			return true;
			
		}
		
		return false;
		
	}
	//비번 유효성 확인
	@RequestMapping(value = "/passwordConfirm", method = RequestMethod.GET)
	@ResponseBody
	public boolean confirmPw(@RequestParam("num") int num, @RequestParam("password") String password) throws Exception {
		
		BoardVO boardVO = service.selectBoard(num);
		
		if (boardVO.getPassword().equals(password)) {
			return true;
		}
		
		return false;
		
	}
	
	//비번업뎃
	@RequestMapping(value = "/upPw", method = RequestMethod.GET)
	@ResponseBody
	public String updatePw(@RequestParam("num") int num, @RequestParam("password") String password) throws Exception {
		
		BoardVO boardVO = new BoardVO();
		
		boardVO.setNum(num);
		boardVO.setPassword(password);
		
		service.updatePw(boardVO);
		
		return "비밀번호 등록 완료!";
		
	}
	
	
}
