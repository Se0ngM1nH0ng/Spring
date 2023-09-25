package com.spring.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCUtil {
	   //static final String driverName_MySQL="com.mysql.cj.jdbc.Driver";
	   static final String driverName="oracle.jdbc.driver.OracleDriver";
	   //static final String url_MySQL="jdbc:mysql://localhost/kim";
	   static final String url="jdbc:oracle:thin:@localhost:1521:xe";
	   static final String userName="JHYUN";
	   static final String password="1234";
	   
	public static Connection getConnection() {
		Connection conn=null;
		try {
			Class.forName(driverName);
			conn=DriverManager.getConnection(url, userName, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
