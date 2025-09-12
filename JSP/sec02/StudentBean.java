package sec01;

public class StudentBean {
	// 필드와 getter, setter가 있는 데이터 저장기능의 클래스
	private String stdNo;
	private String stdName;
	private String stdPhone;
	private String stdAddress;
	private int stdYear;
	private String[] stdInterests;
	
	public String getStdNo() {
		return stdNo;
	}
	public void setStdNo(String stdNo) {
		this.stdNo = stdNo;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getStdPhone() {
		return stdPhone;
	}
	public void setStdPhone(String stdPhone) {
		this.stdPhone = stdPhone;
	}
	public String getStdAddress() {
		return stdAddress;
	}
	public void setStdAddress(String stdAddress) {
		this.stdAddress = stdAddress;
	}
	public int getStdYear() {
		return stdYear;
	}
	public void setStdYear(int stdYear) {
		this.stdYear = stdYear;
	}
	public String[] getStdInterests() {
		return stdInterests;
	}
	public void setStdInterests(String[] stdInterests) {
		this.stdInterests = stdInterests;
	}
}
