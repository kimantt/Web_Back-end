package member;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private DataSource dataFactory;
	private Connection con;
	private PreparedStatement pstmt;
	
	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context)ctx.lookup("java:/comp/env"); // jndi에 접근하기 위한 기본경로 설정
			this.dataFactory = (DataSource)envContext.lookup("jdbc/oracle");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 전체 회원정보 조회
	public List<MemberVO> listMembers() {
		List<MemberVO> membersList = new ArrayList<MemberVO>();
		
		try {
			con = dataFactory.getConnection();
			String query = "select * from  member2 order by MEMJOINDATE desc";
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("MEMID");
				String pwd = rs.getString("mempwd");
				String name = rs.getString("memname");
				String email = rs.getString("mememail");
				Date joinDate = rs.getDate("memjoinDate");
				
				MemberVO memberVO = new MemberVO(id, pwd, name, email, joinDate);
				membersList.add(memberVO);
			}
			
			rs.close();
			pstmt.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return membersList;
	}
	
	// 회원가입
	public void addMember(MemberVO m) {
		try {
			con = dataFactory.getConnection();
			
			String id = m.getId();
			String pwd = m.getPwd();
			String name = m.getName();
			String email = m.getEmail();
			
			String query = "INSERT INTO member2 (memid, mempwd, memname, mememail)" + " VALUES(?, ? ,? ,?)";
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 회원정보 검색
	public MemberVO findMember(String _id) {
		MemberVO memInfo = null;
		
		try {
			con = dataFactory.getConnection();
			
			String query = "select * from  member2 where memid=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, _id);
			System.out.println(query);
			
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			String id = rs.getString("memid");
			String pwd = rs.getString("mempwd");
			String name = rs.getString("memname");
			String email = rs.getString("mememail");
			Date joinDate = rs.getDate("memjoinDate");
			
			memInfo = new MemberVO(id, pwd, name, email, joinDate);
			
			pstmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return memInfo;
	}
	
	// 회원정보 수정
	public void modMember(MemberVO memberVO) {
		String id = memberVO.getId();
		String pwd = memberVO.getPwd();
		String name = memberVO.getName();
		String email = memberVO.getEmail();
		
		try {
			con = dataFactory.getConnection();
			
			String query = "update member2 set mempwd=?,memname=?,mememail=?  where memid=?";
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, pwd);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			pstmt.setString(4, id);
			
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 회원정보 삭제
	public void delMember(String id) {
		try {
			con = dataFactory.getConnection();
			
			String query = "delete from member2 where memid=?";
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1,id);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
