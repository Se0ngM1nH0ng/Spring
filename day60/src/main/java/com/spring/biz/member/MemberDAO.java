package com.spring.biz.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.biz.common.JDBCUtil;

@Repository("memberDAO")
public class MemberDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	
	private final String insert="INSERT INTO MEMBER VALUES(?,?,?)";
	private final String selectOne="SELECT * FROM MEMBER WHERE MID=? AND MPW=?"; // getOne
	private final String selectAll="SELECT * FROM MEMBER"; // getAll
	private final String update="UPDATE MEMBER SET MPW=?,NAME=? WHERE MID=?";
	private final String delete="DELETE FROM MEMBER WHERE MID=? AND MPW=?";
	
	public MemberVO selectOne(MemberVO mVO) {
		MemberVO data=null;
		System.out.println("MemberDAO 로그 selectOne() 메서드");
		conn=JDBCUtil.getConnection();
		try {
			pstmt=conn.prepareStatement(selectOne);
			pstmt.setString(1, mVO.getMid());
			pstmt.setString(2, mVO.getMpw());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new MemberVO();
				data.setMid(rs.getString("MID"));
				data.setMpw(rs.getString("MPW"));
				data.setName(rs.getString("NAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
		return data;
	}
	public List<MemberVO> selectAll(MemberVO mVO) {
		List<MemberVO> datas=new ArrayList<MemberVO>();
		System.out.println("MemberDAO 로그 selectAll() 메서드");
		conn=JDBCUtil.getConnection();
		try {
			pstmt=conn.prepareStatement(selectAll);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				MemberVO data=new MemberVO();
				data.setMid(rs.getString("MID"));
				data.setMpw(rs.getString("MPW"));
				data.setName(rs.getString("NAME"));
				datas.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
		return datas;
	}
	
	public boolean insert(MemberVO mVO) {
		System.out.println("MemberDAO 로그 insert() 메서드");
		conn=JDBCUtil.getConnection();
		try {
			pstmt=conn.prepareStatement(insert);
			pstmt.setString(1, mVO.getMid());
			pstmt.setString(2, mVO.getMpw());
			pstmt.setString(3, mVO.getName());
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
	public boolean update(MemberVO mVO) {
		System.out.println("MemberDAO 로그 update() 메서드");
		conn=JDBCUtil.getConnection();
		try {
			pstmt=conn.prepareStatement(update);
			pstmt.setString(1, mVO.getMpw());
			pstmt.setString(2, mVO.getName());
			pstmt.setString(3, mVO.getMid());
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
	public boolean delete(MemberVO mVO) {
		System.out.println("MemberDAO 로그 delete() 메서드");
		conn=JDBCUtil.getConnection();
		try {
			pstmt=conn.prepareStatement(delete);
			pstmt.setString(1, mVO.getMid());
			pstmt.setString(2, mVO.getMpw());
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
