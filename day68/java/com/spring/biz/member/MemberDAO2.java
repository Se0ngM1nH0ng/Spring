package com.spring.biz.member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository("memberDAO")
public class MemberDAO2 {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String insert = "INSERT INTO MEMBER VALUES(?,?,?,'USER')";
	private final String selectOne = "SELECT * FROM MEMBER WHERE MID=? AND MPW=?"; // getOne
	private final String selectAll = "SELECT * FROM MEMBER"; // getAll
	private final String update = "UPDATE MEMBER SET MPW=?,NAME=? WHERE MID=?";
	private final String delete = "DELETE FROM MEMBER WHERE MID=?";

	public MemberVO selectOne(MemberVO mVO) {

		System.out.println("MemberDAO 로그 selectOne() 메서드");
		Object[] args = { mVO.getMid(), mVO.getMpw() };
		return jdbcTemplate.queryForObject(selectOne, args, new MemberRowMapper());
	}

	public List<MemberVO> selectAll(MemberVO mVO) {
		List<MemberVO> datas = new ArrayList<MemberVO>();
		System.out.println("MemberDAO 로그 selectAll() 메서드");

		Object[] args = { };
		return jdbcTemplate.query(selectAll, args, new MemberRowMapper());
	}

	public boolean insert(MemberVO mVO) {
		System.out.println("MemberDAO 로그 insert() 메서드");

		int rs = jdbcTemplate.update(insert, mVO.getMid(), mVO.getMpw(), mVO.getName());
		if (rs <= 0) {
			return false;
		}
		
		return true;
	}

	public boolean update(MemberVO mVO) {
		System.out.println("MemberDAO 로그 update() 메서드");
		
		int rs = jdbcTemplate.update(update, mVO.getMpw(), mVO.getName(), mVO.getMid() );
		if (rs <= 0) {
			return false;
		}

		return true;
	}

	public boolean delete(MemberVO mVO) {
		System.out.println("MemberDAO 로그 delete() 메서드");
		
		int rs = jdbcTemplate.update(delete, mVO.getMid() );
		if (rs <= 0) {
			return false;
		}

		return true;
	}
}

class MemberRowMapper implements RowMapper<MemberVO> {
	@Override
	public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberVO data = new MemberVO();
		data.setMid(rs.getString("MID"));
		data.setMpw(rs.getString("MPW"));
		data.setName(rs.getString("NAME"));
		data.setRole(rs.getString("ROLE"));
		return data;
	}

}
