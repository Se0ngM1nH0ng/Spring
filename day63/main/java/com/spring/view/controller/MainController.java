package com.spring.view.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.biz.board.BoardDAO;
import com.spring.biz.board.BoardVO;
import com.spring.biz.member.MemberVO;

@Controller
public class MainController {

	@ModelAttribute("searchMap")
	public Map<String,String> searchMap(){
		Map<String,String> map=new HashMap<String,String>();
		map.put("제목", "TITLE");
		map.put("작성자", "WRITER");
		return map;
	}
	
	@RequestMapping(value="/main.do")
	public String main(@ModelAttribute("mem")MemberVO mVO, BoardVO bVO, BoardDAO bDAO, Model model) {
		System.out.println("searchCondition: "+bVO.getSearchCondition());
		System.out.println("searchContent: "+bVO.getSearchContent());
		
		mVO.setMid("test");
		mVO.setMpw("1234");
		
		System.out.println("MainController 로그");
		
		// model.addAttribute("mem", mVO);
		model.addAttribute("datas", bDAO.selectAll(bVO));
		return "main.jsp";
	}

}