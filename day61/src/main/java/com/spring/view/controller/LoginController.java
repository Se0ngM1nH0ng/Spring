package com.spring.view.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.biz.member.MemberDAO;
import com.spring.biz.member.MemberVO;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("LoginController 로그");
		
		HttpSession session=request.getSession();
		MemberDAO mDAO = new MemberDAO();
		MemberVO mVO = new MemberVO();
		
		mVO.setMid((String)request.getParameter("mid"));
		mVO.setMpw((String)request.getParameter("mpw"));
		
		
		System.out.println("LoginController 로그: get "+mVO);
		
		mVO=mDAO.selectOne(mVO);
		System.out.println("LoginController 로그: mVO "+mVO);
		if(mVO!=null){
			session.setAttribute("mid", mVO.getMid());
			// response.sendRedirect("main.do");
			System.out.println("LoginController 로그: session"+session.getAttribute("member"));
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:main.do");
		//redirect: 가 붙으면 VR 설정 무시후 main.do 요청함
		// VR은 default로 foward 방식 채용

		return mav; // .do로 끝나므로 Controller로 가려고 함
		
	}

}
