package com.spring.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.biz.board.BoardDAO;
import com.spring.biz.board.BoardVO;

@Controller
public class InsertBoardController {

	@RequestMapping(value="/insertBoard.do", method=RequestMethod.GET)
	public String insertBoardPage() {
		System.out.println("InsertBoardPageController 로그");
		
		return "redirect:insertBoard.jsp"; // redirect 를 붙이면 ViewResolver 가 동작하지 않는다.
	}
	
	@RequestMapping(value="/insertBoard.do", method=RequestMethod.POST)
	public String insertBoard(BoardVO bVO, BoardDAO bDAO) {
		System.out.println("InsertBoardController 로그");
		
		if(bDAO.insert(bVO)){
			return "redirect:main.do";
		}
		else{
			return "redirect:insertBoard.jsp";
		}
	}

}
