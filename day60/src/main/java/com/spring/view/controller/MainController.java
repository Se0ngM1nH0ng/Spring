package com.spring.view.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		request.setAttribute("datas", bDAO.selectAll(null));
		request.getRequestDispatcher("main.jsp").forward(request, response);
		*/
		
		return null;
	}

}
