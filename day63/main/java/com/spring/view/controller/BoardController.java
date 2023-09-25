package com.spring.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.biz.board.BoardDAO;
import com.spring.biz.board.BoardVO;

@Controller
public class BoardController {

	@RequestMapping(value="/board.do")
	public String selectBoard(BoardVO bVO, BoardDAO bDAO, Model model) {
		System.out.println("BoardController 로그");
		model.addAttribute("data", bDAO.selectOne(bVO));
		bDAO.update(bVO);
		return "board.jsp";
	}
	
	@RequestMapping(value="/updateBoard.do")
	public String updateBoard(BoardVO bVO, BoardDAO bDAO) {
		System.out.println("BoardController 로그");
		if(bDAO.update(bVO)){
			return "redirect:main.do";
		}
		else{
			return "board.do";
		}
	}
	
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardVO bVO, BoardDAO bDAO) {
		System.out.println("BoardController 로그");
		if(bDAO.delete(bVO)){
			return "redirect:main.do";
		}
		else{
			return "board.do";
		}
	}
	
}
