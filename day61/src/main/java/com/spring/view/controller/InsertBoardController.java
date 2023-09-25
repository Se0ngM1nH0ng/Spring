package com.spring.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.biz.board.BoardDAO;
import com.spring.biz.board.BoardVO;

public class InsertBoardController implements Controller{
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		BoardDAO bDAO=new BoardDAO();
		BoardVO bVO=new BoardVO();
		bVO.setContent(request.getParameter("content"));
		bVO.setTitle(request.getParameter("title"));
		bVO.setWriter(request.getParameter("writer"));
		if(bDAO.insert(bVO)){
			ModelAndView mav = new ModelAndView();
			mav.setViewName("redirect:main.do");
			return mav;
		}
		
		return null;
	}
	

}
