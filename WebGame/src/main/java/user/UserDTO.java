package user;

public class UserDTO {
	// 유저 DTO
	// 유저 1명의 정보 저장
	private String id;
	private String pass;
	private String name;
	
	public UserDTO() {}
	
	public UserDTO(String id, String pass, String name) {
		this.id = id;
		this.pass = pass;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
