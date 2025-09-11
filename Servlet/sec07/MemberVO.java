package sec07;

import java.util.Date;

public class MemberVO {
	
	private String memID;
	private String memPWD;
	private String memName;
	private String memEmail;
	private Date memJoinDate;
	
	public MemberVO() {}

	public MemberVO(String memID, String memPWD, String memName, String memEmail, Date memJoinDate) {
		this.memID = memID;
		this.memPWD = memPWD;
		this.memName = memName;
		this.memEmail = memEmail;
		this.memJoinDate = memJoinDate;
	}

	public String getMemID() {
		return memID;
	}

	public String getMemPWD() {
		return memPWD;
	}

	public String getMemName() {
		return memName;
	}

	public String getMemEmail() {
		return memEmail;
	}

	public Date getMemJoinDate() {
		return memJoinDate;
	}
	
}
