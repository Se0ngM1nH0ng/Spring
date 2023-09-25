package com.spring.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.biz.common.LogAdvice;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	// Service 레이어가 관념적으로 존재하는데, 그것을 구현한 클래스
	// Service 레이어에서는 DAO를 사용함
	//  == C 파트
	//  : DAO를 사용할것이기때문에
	//    DAO와 메서드 시그니처를 맞추면 유리함
	// 아~~ 메서드 시그니처를 강제하고싶다!
	//  => 인터페이스
	
	@Autowired
	private BoardDAO boardDAO;
	// 의존관계 -> DI
	
	@Override
	public BoardVO selectOne(BoardVO bVO) {
		return boardDAO.selectOne(bVO);
	}

	@Override
	public List<BoardVO> selectAll(BoardVO bVO) {
		return boardDAO.selectAll(bVO);
	}

	@Override
	public boolean insert(BoardVO bVO) {
		
		if(bVO.getContent().equals("티모별로임")) {
			throw new ArithmeticException("등록할 수 없는 게시글입니다.");
		}
		
		return boardDAO.insert(bVO);
	}

	@Override
	public boolean update(BoardVO bVO) {
		return boardDAO.update(bVO);
	}

	@Override
	public boolean delete(BoardVO bVO) {
		return boardDAO.delete(bVO);
	}
}