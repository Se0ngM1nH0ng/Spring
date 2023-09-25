package com.spring.view.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.biz.member.MemberDAO;
import com.spring.biz.member.MemberVO;

@Controller
public class LoginController { // 비슷한 로직끼리 같은 파일에서 관리하기때문에 응집도가 높아짐

	@RequestMapping(value="/login.do")
	public String login(MemberVO mVO, MemberDAO mDAO, HttpSession session) {
		System.out.println("LoginController 로그");
		
		mVO=mDAO.selectOne(mVO);
		if(mVO!=null){
			session.setAttribute("member", mVO.getMid());
		}
		
		return "redirect:main.do";
	}
	
	@RequestMapping(value="/logout.do")
	public String logout(HttpSession session){
		System.out.println("LogoutController 로그");
		
		session.removeAttribute("member");
		
		return "redirect:main.do";
	}

}