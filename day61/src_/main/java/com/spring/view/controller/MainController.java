package com.spring.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.biz.board.BoardDAO;

@Controller
public class MainController {

	@RequestMapping(value="/main.do")
	public ModelAndView main(BoardDAO bDAO, ModelAndView mav) {
		System.out.println("MainController 로그");
		
		mav.addObject("datas", bDAO.selectAll(null));
		mav.setViewName("main.jsp");
		// /WEB-INF/views/ + main + .jsp
		return mav;
	}

}