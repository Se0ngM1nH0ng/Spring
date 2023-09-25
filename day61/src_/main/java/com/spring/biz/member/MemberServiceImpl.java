package com.spring.biz.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	// Service 레이어가 관념적으로 존재하는데, 그것을 구현한 클래스
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public MemberVO selectOne(MemberVO mVO) {
		return memberDAO.selectOne(mVO);
	}

	@Override
	public List<MemberVO> selectAll(MemberVO mVO) {
		return memberDAO.selectAll(mVO);
	}

	@Override
	public boolean insert(MemberVO mVO) {
		return memberDAO.insert(mVO);
	}

	@Override
	public boolean update(MemberVO mVO) {
		return memberDAO.update(mVO);
	}

	@Override
	public boolean delete(MemberVO mVO) {
		return memberDAO.delete(mVO);
	}
}
