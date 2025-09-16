package product;

public class ProductVO {
	private String no;
	private String name;
	private int price;
	private String maker;
	private String color;
	private int ctgNo;
	
	public ProductVO() {
		System.out.println("ProductVO 생성");
	}

	public ProductVO(String no, String name, int price, String maker, String color, int ctgNo) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.maker = maker;
		this.color = color;
		this.ctgNo = ctgNo;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getCtgNo() {
		return ctgNo;
	}

	public void setCtgNo(int ctgNo) {
		this.ctgNo = ctgNo;
	}
	
}
