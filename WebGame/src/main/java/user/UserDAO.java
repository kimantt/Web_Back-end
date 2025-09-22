package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UserDAO implements IUserDAO{
	// 유저 DAO
	private DataSource dataFactory;
	
	public static UserDAO instance = new UserDAO();
	
	private UserDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context)ctx.lookup("java:/comp/env");
			this.dataFactory = (DataSource)envContext.lookup("jdbc/oracle");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static UserDAO getInstance() {
		if (instance == null) {
			instance = new UserDAO();
		}
		return instance;
	}
	
	@Override
	public UserDTO selectUser(UserDTO dto) throws Exception {
		// 유저정보 조회
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		UserDTO result = null;
		String id = dto.getId();
		
		try {
		    con = dataFactory.getConnection();
		    
		    pstmt = con.prepareStatement("select * from users where id = ?");
		    pstmt.setString(1, id);
		    rs = pstmt.executeQuery();
		    if (rs.next()) {
		    	String pw = rs.getString("pass");
		    	String name = rs.getString("name");
		    	
		    	result = new UserDTO(id, pw, name);
		    }
		    
		} catch(Exception e) {
			throw e;
			
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {}
		}
		
		return result;
	}
	
	@Override
	public String insertUser(UserDTO dto) throws Exception {
		// 유저정보 저장 시도
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String id = dto.getId();
		String pass = dto.getPass();
	    String name = dto.getName();
		
		try {
		    con = dataFactory.getConnection();
		    
		    // 아이디 중복 검사
		    pstmt = con.prepareStatement("select * from users where id = ?");
		    pstmt.setString(1, id);
		    rs = pstmt.executeQuery();
		    if (rs.next()) {
		    	return "중복된 아이디입니다.";
		    }
		    else {
		    	// 아이디와 이름 중복 검사
		    	pstmt = con.prepareStatement("select * from users where id = ? and name = ?");
		    	pstmt.setString(1, id);
		    	pstmt.setString(2, name);
			    rs = pstmt.executeQuery();
			    if (rs.next()) {
			    	return "이미 존재하는 사용자입니다.";
			    }
		    }
		    
		    // 중복 검사 끝난 뒤 회원가입 시도
		    pstmt = con.prepareStatement("insert into users values(?,?,?)");
		    pstmt.setString(1, id);
	    	pstmt.setString(2, pass);
	    	pstmt.setString(3, name);
		    
		    int result = pstmt.executeUpdate();
			if (result == 0) { // 회원가입이 안됐는데 오류 안나면 여기로
				return "회원가입에 실패했습니다. 다시 시도해주세요.";
			}
		    
		} catch(Exception e) {
			throw e;
			
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {}
		}
		
		// 회원가입에 성공하면 여기로
		return "success";
	}
	
	@Override
	public boolean updateUser(UserDTO dto) throws Exception {
		// 회원정보 수정 시도
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = dataFactory.getConnection();
			String sql = "update users set pass = ?, name = ? where id = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, dto.getPass());
			pstmt.setString(2, dto.getName());
	    	pstmt.setString(3, dto.getId());
			
			int result = pstmt.executeUpdate();
			
			if (result == 0) {
				System.out.println("회원정보 수정에 실패했습니다. 다시 시도해주세요.");
				return false;
			}
			
		} catch(Exception e) {
			throw e;
			
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {}
		}
		return true;
	}

	@Override
	public boolean deleteUser(UserDTO dto) throws Exception {
		// 회원탈퇴 시도
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String id = dto.getId();
		
		try {
			con = dataFactory.getConnection();
			pstmt = con.prepareStatement("delete users where id = ?");
			pstmt.setString(1, id);
			
			int result = pstmt.executeUpdate();
			if (result == 0) {
				return false;
			}
			
		} catch(Exception e) {
			throw e;
			
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {}
		}
		
		// 회원탈퇴 성공
		return true;
	}

	@Override
	public LoginResult loginCheck(UserDTO dto) throws Exception {
		// 로그인 시도
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String id = dto.getId();
		String pass = dto.getPass();
		
		try {
			con = dataFactory.getConnection();
			pstmt = con.prepareStatement("select * from users where id = ?");
			pstmt.setString(1, id);
		    rs = pstmt.executeQuery();
		    
		    if (rs.next()) { 
		    	if (pass.equals(rs.getString(2))) {
		    		dto.setName(rs.getString(3));
					return new LoginResult("success", dto);
		    	}
		    	else {
		    		return new LoginResult("error:wrong password", null);
		    	}
		    }
		    else {
		    	return new LoginResult("error:no user", null);
		    }
			
		} catch(Exception e) {
			throw e;
			
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {}
		}
	}
	
	public class LoginResult {
		public final String result;
		public final UserDTO dto;
		
		public LoginResult(String result, UserDTO dto) {
			this.result = result;
			this.dto = dto;
		}
	}

}
