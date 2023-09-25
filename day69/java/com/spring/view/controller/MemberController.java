package com.spring.view.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.biz.member.MemberService;
import com.spring.biz.member.MemberVO;

@Controller
public class MemberController { // 비슷한 로직끼리 같은 파일에서 관리하기때문에 응집도가 높아짐

	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/check.do")
	public String checkPage() {		
		return "redirect:check.jsp";	
	}
	
	@RequestMapping(value="/mypage.do")
	public String mypage(MemberVO mVO, Model model) {		
		mVO=memberService.selectOne(mVO);
		if(mVO==null){
			return "redirect:check.do";
		}
		else {
			model.addAttribute("data", mVO);
			return "mypage.jsp";
		}		
	}
	
	@RequestMapping(value="/signUp.do", method=RequestMethod.GET)
	public String signUpPage() {		
		return "redirect:signUp.jsp";	
	}
	
	@RequestMapping(value="/signUp.do", method=RequestMethod.POST)
	public String signUp(MemberVO mVO) {		
		if(memberService.insert(mVO)){
			return "redirect:main.do";
		}
		else {
			return "redirect:signUp.jsp";
		}		
	}
	
	@RequestMapping(value="/login.do")
	public String login(MemberVO mVO, HttpSession session) {		
		mVO=memberService.selectOne(mVO);
		if(mVO!=null){
			session.setAttribute("member", mVO.getMid());
		}
		
		return "redirect:main.do";
	}
	
	@RequestMapping(value="/logout.do")
	public String logout(HttpSession session){		
		session.removeAttribute("member");
		
		return "redirect:main.do";
	}
	
	@RequestMapping(value="/updateMember.do")
	public String updateMember(MemberVO mVO, HttpSession session) {		
		if(memberService.update(mVO)){
			session.removeAttribute("member");
			return "redirect:main.do";
		}
		else {
			return "redirect:mypage.do"; /////
		}
	}
	
	@RequestMapping(value="/deleteMember.do")
	public String deleteMember(MemberVO mVO, HttpSession session) {
		if(memberService.delete(mVO)){
			session.removeAttribute("member");
			return "redirect:main.do";
		}
		else {
			return "redirect:mypage.do"; /////
		}
	}

}