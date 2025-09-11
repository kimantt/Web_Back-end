package sec08;

public class ProductVO {
	
	private String prdNo;
	private String prdName;
	private int prdPrice;
	private String prdMaker;
	private String prdColor;
	private int ctgNo;
	
	public ProductVO() {}
	
	public ProductVO(String prdNo, String prdName, int prdPrice, String prdMaker, String prdColor, int ctgNo) {
		this.prdNo = prdNo;
		this.prdName = prdName;
		this.prdPrice = prdPrice;
		this.prdMaker = prdMaker;
		this.prdColor = prdColor;
		this.ctgNo = ctgNo;
	}

	public String getPrdNo() {
		return prdNo;
	}

	public String getPrdName() {
		return prdName;
	}

	public int getPrdPrice() {
		return prdPrice;
	}

	public String getPrdMaker() {
		return prdMaker;
	}

	public String getPrdColor() {
		return prdColor;
	}

	public int getCtgNo() {
		return ctgNo;
	}
}
