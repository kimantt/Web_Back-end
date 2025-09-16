package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ProductDAO {
	private DataSource dataFactory;
	private Connection con;
	private PreparedStatement pstmt;
	
	public ProductDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context)ctx.lookup("java:/comp/env");
			this.dataFactory = (DataSource)envContext.lookup("jdbc/oracle");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 전체 상품 조회
	public List<ProductVO> listProducts() {
		List<ProductVO> productsList = new ArrayList<ProductVO>();
		
		try {
			con = dataFactory.getConnection();
			String query = "select * from product order by prdNo";
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String no = rs.getString("prdNo");
				String name = rs.getString("prdName");
				int price = rs.getInt("prdPrice");
				String maker = rs.getString("prdMaker");
				String color = rs.getString("prdColor");
				int ctgNo = rs.getInt("ctgNo");
				
				ProductVO productVO = new ProductVO(no, name, price, maker, color, ctgNo);
				productsList.add(productVO);
			}
			
			rs.close();
			pstmt.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return productsList;
	}
	
	// 상품 등록
	public void addProduct(ProductVO p) {
		try {
			con = dataFactory.getConnection();
			
			String no = p.getNo();
			String name = p.getName();
			int price = p.getPrice();
			String maker = p.getMaker();
			String color = p.getColor();
			int ctgNo = p.getCtgNo();
			
			String query = "INSERT INTO product VALUES(?, ?, ?, ?, ?, ?)";
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, no);
			pstmt.setString(2, name);
			pstmt.setInt(3, price);
			pstmt.setString(4, maker);
			pstmt.setString(5, color);
			pstmt.setInt(6, ctgNo);
			
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 상품 검색
	public ProductVO findProduct(String _no) {
		ProductVO prdInfo = null;
		
		try {
			con = dataFactory.getConnection();
			
			String query = "select * from product where prdNo = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, _no);
			System.out.println(query);
			
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			String no = rs.getString("prdNo");
			String name = rs.getString("prdName");
			int price = rs.getInt("prdPrice");
			String maker = rs.getString("prdMaker");
			String color = rs.getString("prdColor");
			int ctgNo = rs.getInt("ctgNo");
			
			prdInfo = new ProductVO(no, name, price, maker, color, ctgNo);
			
			pstmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return prdInfo;
	}
	
	// 상품정보 수정
	public void modProduct(ProductVO productVO) {
		String no = productVO.getNo();
		String name = productVO.getName();
		int price = productVO.getPrice();
		String maker = productVO.getMaker();
		String color = productVO.getColor();
		int ctgNo = productVO.getCtgNo();
		
		try {
			con = dataFactory.getConnection();
			
			String query = "update product set prdName=?,prdPrice=?,prdMaker=?,prdColor=?,ctgNo=? where prdNo=?";
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, name);
			pstmt.setInt(2, price);
			pstmt.setString(3, maker);
			pstmt.setString(4, color);
			pstmt.setInt(5, ctgNo);
			pstmt.setString(6, no);
			
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 상품 삭제
	public void delProduct(String no) {
		try {
			con = dataFactory.getConnection();
			
			String query = "delete from product where prdNo=?";
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1,no);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
