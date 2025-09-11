package sec08;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductDAO {

	public ArrayList<ProductVO> productSelect() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<ProductVO> prdList = new ArrayList<ProductVO>();
		
		try {
			con = DBConnect.getConnection();
			String query = "select * from product";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				ProductVO vo = new ProductVO(rs.getString(1),
											 rs.getString(2),
											 rs.getInt(3),
											 rs.getString(4),
											 rs.getString(5),
											 rs.getInt(6));
				
				prdList.add(vo);
			}
			
		} catch(Exception e) {
			System.out.println("상품 조회 실패");
			e.printStackTrace();
			
		} finally {
			DBConnect.close(con, pstmt, rs);
		}
		
		return prdList;
	}
	
}
