package sec08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnect {
	
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "C##SQL_USER";
			String pwd = "1234";
			
			con = DriverManager.getConnection(url, user, pwd);
			
			if (con != null)
				System.out.println("DB 연결 성공");
			else
				System.out.println("DB 연결 실패");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection con, PreparedStatement pstmt) {
		try {
			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection con) {
		try {
			if (con != null) {
				con.close();
				con = null;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement pstmt) {
		try {
			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
