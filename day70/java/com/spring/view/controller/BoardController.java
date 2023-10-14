package com.spring.view.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.spring.biz.board.BoardService;
import com.spring.biz.board.BoardVO;
import com.spring.biz.member.MemberVO;

@Controller
@SessionAttributes("data")
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	@ModelAttribute("searchMap") "searchMap" 이름으로 보내는 데이터는 제목과 작성자를 포함한다. 
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
		if(bVO.getSearchCondition() == null) {
			bVO.setSearchCondition("TITLE");
			bVO.setSearchContent("");
		} // 검색 로직에서 종종 활용되는 기법
		
		mVO.setMid("test");
		mVO.setMpw("1234");
		
		// model.addAttribute("mem", mVO);
		model.addAttribute("datas", boardService.selectAll(bVO));
		return "main.jsp";
	}
	
	@RequestMapping(value="/board.do")
	public String selectBoard(BoardVO bVO, Model model) {
		model.addAttribute("data", boardService.selectOne(bVO));
		bVO.setSearchCondition("CNT");
		boardService.update(bVO);
		return "board.jsp";
	}
	
	@RequestMapping(value="/updateBoard.do")
	public String updateBoard(@ModelAttribute("data")BoardVO bVO) throws IllegalStateException, IOException {
		MultipartFile fileUpload=bVO.getFileUpload();
		if(!fileUpload.isEmpty()){
			String fileName=fileUpload.getOriginalFilename();
			System.out.println("파일명: "+fileName);
			
			bVO.setFileName(fileName);
			
			fileUpload.transferTo(new File("D:\\KIM\\ws\\day60\\src\\main\\webapp\\images\\"+fileName));
		}
		
		boardService.update(bVO);
		return "board.do";
	}
	
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardVO bVO) {
		if(boardService.delete(bVO)){
			return "redirect:main.do";
		}
		else{
			return "board.do";
		}
	}
	
	@RequestMapping(value="/insertBoard.do", method=RequestMethod.GET)
	public String insertBoardPage() {
		// AOP 이전에는 일일히 로그를 직접 추가했었음
		// 단순 페이지요청조차도 로그가 찍혔음
		// 메서드 호출 == 느림
		
		// service를 사용하는 건에 대해서만 AOP를 수행하기때문에,
		// 로그가 안찍힘
		// 메서드 안 호출 == 빠름
		
		return "redirect:insertBoard.jsp";
	}
	
	@RequestMapping(value="/insertBoard.do", method=RequestMethod.POST)
	public String insertBoard(BoardVO bVO) throws IllegalStateException, IOException {
		MultipartFile fileUpload=bVO.getFileUpload();
		if(!fileUpload.isEmpty()){ // 파일업로드가 있을 시
			String fileName=fileUpload.getOriginalFilename();
			System.out.println("파일명: "+fileName);
			
			bVO.setFileName(fileName);
			
			fileUpload.transferTo(new File("D:\\KIM\\ws\\day60\\src\\main\\webapp\\images\\"+fileName));
		}
		
		if(boardService.insert(bVO)){
			return "redirect:main.do";
		}
		else{
			return "redirect:insertBoard.jsp";
		}
	}
	
}
