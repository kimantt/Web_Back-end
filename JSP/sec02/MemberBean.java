package sec01;

public class MemberBean {
	
	private String memID;
	private String memPWD;
	private String memName;
	private String memEmail;
	
	public MemberBean() {}

	public MemberBean(String memID, String memPWD, String memName, String memEmail) {
		this.memID = memID;
		this.memPWD = memPWD;
		this.memName = memName;
		this.memEmail = memEmail;
	}

	public String getMemID() {
		return memID;
	}

	public void setMemID(String memID) {
		this.memID = memID;
	}

	public String getMemPWD() {
		return memPWD;
	}

	public void setMemPWD(String memPWD) {
		this.memPWD = memPWD;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemEmail() {
		return memEmail;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}
	
}
