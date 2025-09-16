package product;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/product/*")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ProductDAO productDAO;

	/**
	 * ProductDAO 객체 인스턴스 생성 : DataSource 객체 생성
	 */
	public void init(ServletConfig config) throws ServletException {
		productDAO = new ProductDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	/**
	 * 모든 요청 처리 메서드 : doHandle()
	 */
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = null; // forward 시킬 페이지의 location 저장
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String action = request.getPathInfo(); // 서블릿에 전달된 경로만 반환
		System.out.println("action : " + action);
		
		// http://localhost:8080/MemberControl/product/listProducts.do 로 요청하면 전체 상품정보 조회기능을 응답
		if (action == null || action.equals("/listProducts.do")) { // 상품정보 조회
			System.out.println("상품정보 페이지");
			List<ProductVO> productsList = productDAO.listProducts();
			request.setAttribute("productsList", productsList); // DAO로부터 반환받은 상품정보를 attribute에 바인딩
			nextPage = "/view/product/listProducts.jsp"; // 현재 요청에 대한 view 파일, MemberControl/listProducts.jsp
			
		} else if (action.equals("/productForm.do")) { // 상품추가폼 전송요청
			nextPage = "/view/product//productForm.jsp";
			
		} else if (action.equals("/addProduct.do")) { // 상품추가 처리
			String no = request.getParameter("no");
			String name = request.getParameter("name");
			int price = Integer.parseInt(request.getParameter("price"));
			String maker = request.getParameter("maker");
			String color = request.getParameter("color");
			int ctgNo = Integer.parseInt(request.getParameter("ctgNo"));
			
			ProductVO productVO = new ProductVO(no, name, price, maker, color, ctgNo);
			productDAO.addProduct(productVO);
			request.setAttribute("msg", "addProduct");
			nextPage = "/product/listProducts.do";
			
		} else if (action.equals("/modProductForm.do")) { // 상품정보수정폼 전송요청
			String no = request.getParameter("no");
			ProductVO productInfo = productDAO.findProduct(no);
			request.setAttribute("productInfo", productInfo);
			nextPage = "/view/product//modProductForm.jsp";
			
		} else if (action.equals("/modProduct.do")) { // 상품정보수정 처리
			String no = request.getParameter("no");
			String name = request.getParameter("name");
			int price = Integer.parseInt(request.getParameter("price"));
			String maker = request.getParameter("maker");
			String color = request.getParameter("color");
			int ctgNo = Integer.parseInt(request.getParameter("ctgNo"));
			
			ProductVO productVO = new ProductVO(no, name, price, maker, color, ctgNo);
			productDAO.modProduct(productVO);
			request.setAttribute("msg", "modProduct");
			nextPage = "/product/listProducts.do";
			
		} else if (action.equals("/delProduct.do")) { // 상품 삭제
			String no = request.getParameter("no");
			productDAO.delProduct(no);
			request.setAttribute("msg", "delProduct");
			nextPage = "/product/listProducts.do";
			
		} else { // 나머지 모든 요청은 상품리스트로 가도록
			List<ProductVO> productsList = productDAO.listProducts();
			request.setAttribute("productsList", productsList);
			nextPage = "/view/product//listProducts.jsp";
		}
		
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
	}
	
}
