package user;

import user.UserDAO.LoginResult;

public interface IUserDAO {
	// 유저 DAO 인터페이스
	
	// 유저정보 조회
	public UserDTO selectUser(UserDTO dto) throws Exception;
	
	// 유저정보 저장 (회원가입)
	public String insertUser(UserDTO dto) throws Exception;
	
	// 유저정보 수정
	public boolean updateUser(UserDTO dto) throws Exception;
	
	// 유저정보 삭제 (회원탈퇴)
	public boolean deleteUser(UserDTO dto) throws Exception;
	
	// 로그인 검사
	public LoginResult loginCheck(UserDTO dto) throws Exception;
}
