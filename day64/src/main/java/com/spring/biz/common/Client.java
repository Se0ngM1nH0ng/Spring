package com.spring.biz.common;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.biz.board.BoardService;
import com.spring.biz.board.BoardVO;
import com.spring.biz.member.MemberService;
import com.spring.biz.member.MemberVO;

public class Client {

	public static void main(String[] args) {
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		
		BoardService bs=(BoardService)factory.getBean("boardService");
		MemberService ms=(MemberService)factory.getBean("memberService");
		MemberVO mVO=new MemberVO();
		Scanner sc=new Scanner(System.in);
		System.out.print("아이디 입력) ");
		String mid=sc.next();
		System.out.print("비밀번호 입력) ");
		String mpw=sc.next();
		mVO.setMid(mid);
		mVO.setMpw(mpw);
		mVO=ms.selectOne(mVO);
		if(mVO==null) {
			System.out.println("로그인 실패");
		}
		else {
			System.out.println("로그인 성공");
			BoardVO bVO=new BoardVO();
			System.out.print("제목 입력) ");
			String title=sc.next();
			System.out.print("내용 입력) ");
			String content=sc.next();
			bVO.setContent(content);
			bVO.setTitle(title);
			bVO.setWriter(mVO.getMid());
			bs.insert(bVO);
		}
		List<BoardVO> datas=bs.selectAll(null);
		for(BoardVO v:datas) {
			System.out.println(v);
		}
		
		factory.close();
	}

}
