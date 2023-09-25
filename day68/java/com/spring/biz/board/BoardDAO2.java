package com.spring.biz.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("boardDAO")
public class BoardDAO2 {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String insert = "INSERT INTO BOARD (BID,TITLE,CONTENT,WRITER) VALUES((SELECT NVL(MAX(BID),0)+1 FROM BOARD),?,?,?)";
	private final String selectOne = "SELECT * FROM BOARD WHERE BID=?"; // getOne
	private final String selectAll = "SELECT * FROM BOARD ORDER BY BID DESC"; // getAll
	private final String selectAll_TITLE = "SELECT * FROM BOARD WHERE TITLE LIKE '%'||?||'%' ORDER BY BID DESC";
	private final String selectAll_WRITER = "SELECT * FROM BOARD WHERE WRITER LIKE '%'||?||'%' ORDER BY BID DESC";
	private final String update = "UPDATE BOARD SET TITLE=?,CONTENT=? WHERE BID=?";
	private final String update_CNT = "UPDATE BOARD SET CNT=CNT+1 WHERE BID=?";
	private final String delete = "DELETE FROM BOARD WHERE BID=?";

	public BoardVO selectOne(BoardVO bVO) {

		System.out.println("BoardDAO2 로그 selectOne() 메서드");
		Object[] args = { bVO.getBid() };
		//jdbcTemplate.queryForObject(selectOne, args, new BoardRowMapper());
		// queryForObject는 upate와 달리 메서드시그니처가 정해져 있다
		// SQL을 실행할때에 필요한 INPUT과 <<< 배열의 형태
		// SQL을 실행완료한 후의 OUTPUT을 지정해야함 << 객체의 형태

		return jdbcTemplate.queryForObject(selectOne, args, new BoardRowMapper());
	}

	public List<BoardVO> selectAll(BoardVO bVO) {
		List<BoardVO> datas = new ArrayList<BoardVO>();
		System.out.println("BoardDAO2 로그 selectAll() 메서드");
		
		
		if(bVO.getSearchCondition()==null || bVO.getSearchCondition().isEmpty()) {
			Object[] args = { };
			datas = jdbcTemplate.query(selectAll, args, new BoardRowMapper());
			
		}
		else if(bVO.getSearchCondition().equals("TITLE")) {
			Object[] args = { bVO.getSearchContent()};
			datas = jdbcTemplate.query(selectAll_TITLE, args, new BoardRowMapper());
		}
		else if(bVO.getSearchCondition().equals("WRITER")) {
			Object[] args = { bVO.getSearchContent()};
			datas = jdbcTemplate.query(selectAll_WRITER, args, new BoardRowMapper());
		}
		
		return datas;

	}

	public boolean insert(BoardVO bVO) {
		System.out.println("BoardDAO2 로그 insert() 메서드");

		int rs = jdbcTemplate.update(insert, bVO.getTitle(), bVO.getContent(), bVO.getWriter());
		if (rs <= 0) {
			return false;
		}
		return true;
	}

	public boolean update(BoardVO bVO) {
		System.out.println("BoardDAO2 로그 update() 메서드");// ㅋㅋㅋㅋㅋㅋ???????????????????????이게 코드냐?

		int rs;
		if (bVO.getSearchCondition() != null && bVO.getSearchCondition().equals("CNT")) {
			rs = jdbcTemplate.update(update_CNT, bVO.getBid());
		} else {
			rs = jdbcTemplate.update(update, bVO.getTitle(), bVO.getContent(), bVO.getBid());
		}

		if (rs <= 0) {
			return false;
		}
		return true;

	}

	public boolean delete(BoardVO bVO) {
		System.out.println("BoardDAO 로그 delete() 메서드");
		int rs = jdbcTemplate.update(delete, bVO.getBid());
		if (rs <= 0) {
			return false;
		}
		return true;
	}
}

// RowMapper 인터페이스
// 1) 어떤 ResultSet(DB)을 어떤 자바객체와 매핑해야 하는지 강제해주는 역할
//								-> DB와 매핑되는 자바객체 == "VO"
// 2) VO를 알아야하기 때문에 <> 설정 필수
class BoardRowMapper implements RowMapper<BoardVO> {
	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO data = new BoardVO();
		data.setBid(rs.getInt("BID"));
		data.setCnt(rs.getInt("CNT"));
		data.setContent(rs.getString("CONTENT"));
		data.setTitle(rs.getString("TITLE"));
		data.setWriter(rs.getString("WRITER"));
		return data;
	}

}
