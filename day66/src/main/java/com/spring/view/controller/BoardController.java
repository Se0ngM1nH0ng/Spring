package com.spring.view.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.biz.board.BoardService;
import com.spring.biz.board.BoardVO;
import com.spring.biz.member.MemberVO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	@ModelAttribute("searchMap")
	public Map<String,String> searchMap(){
		Map<String,String> map=new HashMap<String,String>();
		map.put("제목", "TITLE");
		map.put("작성자", "WRITER");
		return map;
	}
	
	@RequestMapping(value="/main.do")
	public String main(@ModelAttribute("mem")MemberVO mVO, BoardVO bVO, Model model) {
		System.out.println("searchCondition: "+bVO.getSearchCondition());
		System.out.println("searchContent: "+bVO.getSearchContent());
		
		mVO.setMid("test");
		mVO.setMpw("1234");
		
		System.out.println("BoardController 로그");
		
		// model.addAttribute("mem", mVO);
		model.addAttribute("datas", boardService.selectAll(bVO));
		return "main.jsp";
	}
	
	@RequestMapping(value="/board.do")
	public String selectBoard(BoardVO bVO, Model model) {
		System.out.println("BoardController 로그");
		model.addAttribute("data", boardService.selectOne(bVO));
		boardService.update(bVO);
		return "board.jsp";
	}
	
	@RequestMapping(value="/updateBoard.do")
	public String updateBoard(BoardVO bVO) {
		System.out.println("BoardController 로그");
		boardService.update(bVO);
		return "board.do";
	}
	
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardVO bVO) {
		System.out.println("BoardController 로그");
		if(boardService.delete(bVO)){
			return "redirect:main.do";
		}
		else{
			return "board.do";
		}
	}
	
	@RequestMapping(value="/insertBoard.do", method=RequestMethod.GET)
	public String insertBoardPage() {
		System.out.println("BoardController 로그");
		
		return "redirect:insertBoard.jsp";
	}
	
	@RequestMapping(value="/insertBoard.do", method=RequestMethod.POST)
	public String insertBoard(BoardVO bVO) {
		System.out.println("BoardController 로그");
		
		if(boardService.insert(bVO)){
			return "redirect:main.do";
		}
		else{
			return "redirect:insertBoard.jsp";
		}
	}
	
}
