package com.spring.view.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		mVO=mDAO.selectOne(mVO);
		if(mVO==null){
			response.sendRedirect("controller.jsp?action=main");
		}
		else{
			session.setAttribute("member", mVO.getMid());
			response.sendRedirect("controller.jsp?action=main");
		}
		*/
		
		return null;
	}

}
