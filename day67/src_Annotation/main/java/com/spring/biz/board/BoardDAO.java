package com.spring.biz.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.biz.common.JDBCUtil;

@Repository("boardDAO") // @Component를 상속받은 @
public class BoardDAO {
	private Connection conn;
	private PreparedStatement pstmt;

	private final String insert="INSERT INTO BOARD (BID,TITLE,CONTENT,WRITER) VALUES((SELECT NVL(MAX(BID),0)+1 FROM BOARD),?,?,?)";
	private final String selectOne="SELECT * FROM BOARD WHERE BID=?"; // getOne
	private final String selectAll="SELECT * FROM BOARD ORDER BY BID DESC"; // getAll
	private final String selectAll_TITLE="SELECT * FROM BOARD WHERE TITLE LIKE '%'||?||'%' ORDER BY BID DESC";
	private final String selectAll_WRITER="SELECT * FROM BOARD WHERE WRITER LIKE '%'||?||'%' ORDER BY BID DESC";
	private final String update="UPDATE BOARD SET TITLE=?,CONTENT=? WHERE BID=?";
	private final String update_CNT="UPDATE BOARD SET CNT=CNT+1 WHERE BID=?";
	private final String delete="DELETE FROM BOARD WHERE BID=?";

	public BoardVO selectOne(BoardVO bVO) {
		BoardVO data=null;
		System.out.println("BoardDAO 로그 selectOne() 메서드");
		conn=JDBCUtil.getConnection();
		try {
			pstmt=conn.prepareStatement(selectOne);
			pstmt.setInt(1, bVO.getBid());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new BoardVO();
				data.setBid(rs.getInt("BID"));
				data.setCnt(rs.getInt("CNT"));
				data.setContent(rs.getString("CONTENT"));
				data.setTitle(rs.getString("TITLE"));
				data.setWriter(rs.getString("WRITER"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
		return data;
	}
	public List<BoardVO> selectAll(BoardVO bVO) {
		List<BoardVO> datas=new ArrayList<BoardVO>();
		System.out.println("BoardDAO 로그 selectAll() 메서드");
		conn=JDBCUtil.getConnection();
		try {
			if(bVO.getSearchCondition()==null || bVO.getSearchCondition().isEmpty()) {
				pstmt=conn.prepareStatement(selectAll);
			}
			else if(bVO.getSearchCondition().equals("TITLE")) {
				pstmt=conn.prepareStatement(selectAll_TITLE);
				pstmt.setString(1, bVO.getSearchContent());
			}
			else if(bVO.getSearchCondition().equals("WRITER")) {
				pstmt=conn.prepareStatement(selectAll_WRITER);
				pstmt.setString(1, bVO.getSearchContent());
			}
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				BoardVO data=new BoardVO();
				data.setBid(rs.getInt("BID"));
				data.setCnt(rs.getInt("CNT"));
				data.setContent(rs.getString("CONTENT"));
				data.setTitle(rs.getString("TITLE"));
				data.setWriter(rs.getString("WRITER"));
				datas.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
		return datas;
	}

	public boolean insert(BoardVO bVO) {
		System.out.println("BoardDAO 로그 insert() 메서드");
		conn=JDBCUtil.getConnection();
		try {
			pstmt=conn.prepareStatement(insert);
			pstmt.setString(1, bVO.getTitle());
			pstmt.setString(2, bVO.getContent());
			pstmt.setString(3, bVO.getWriter());
			int rs=pstmt.executeUpdate();
			if(rs<=0) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
		return true;
	}
	public boolean update(BoardVO bVO) {
		System.out.println("BoardDAO 로그 update() 메서드");
		conn=JDBCUtil.getConnection();
		try {
			if(bVO.getSearchCondition()!=null && bVO.getSearchCondition().equals("CNT")) {
				pstmt=conn.prepareStatement(update_CNT);
				pstmt.setInt(1, bVO.getBid());
			}
			else {
				pstmt=conn.prepareStatement(update);
				pstmt.setString(1, bVO.getTitle());
				pstmt.setString(2, bVO.getContent());
				pstmt.setInt(3, bVO.getBid());
			}
			int rs=pstmt.executeUpdate();
			if(rs<=0) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
		return true;
	}
	public boolean delete(BoardVO bVO) {
		System.out.println("BoardDAO 로그 delete() 메서드");
		conn=JDBCUtil.getConnection();
		try {
			pstmt=conn.prepareStatement(delete);
			pstmt.setInt(1, bVO.getBid());
			int rs=pstmt.executeUpdate();
			if(rs<=0) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
		return true;
	}
}
