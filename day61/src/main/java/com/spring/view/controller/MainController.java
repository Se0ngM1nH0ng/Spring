package com.spring.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.biz.board.BoardDAO;
import com.spring.biz.board.BoardVO;

public class MainController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("MainController 로그");
		/*
		request.setAttribute("datas", bDAO.selectAll(null));
		request.getRequestDispatcher("main.jsp").forward(request, response);
		
		
		*/
		BoardDAO bDAO=new BoardDAO();
		List<BoardVO> datas=bDAO.selectAll(null);
		request.setAttribute("datas", datas);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		/*
		*	/WEB-INF/views/ + main +.jsp
		*/

		return mav; // main.jsp 즉, VIEW로 갈려고 함
	}

}
