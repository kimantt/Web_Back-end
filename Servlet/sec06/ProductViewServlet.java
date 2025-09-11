package sec06;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductViewServlet
 */
@WebServlet("/productView")
public class ProductViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	@SuppressWarnings("unchecked")
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ProductVO> prdList = (ArrayList<ProductVO>)request.getAttribute("prdList");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body><table border='1'>");
		out.println("<tr><th>상품번호</th><th>상품명</th><th>가격</th><th>재고량</th></tr>");
		for (ProductVO vo : prdList) {
			out.println("<tr><td>" + vo.getId() + "</td>");
			out.println("<td>" + vo.getName() + "</td>");
			out.println("<td>" + vo.getPrice() + "</td>");
			out.println("<td>" + vo.getStock() + "</td></tr>");
		}
		out.println("</table></body></html>");
	}

}
