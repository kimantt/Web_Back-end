package sec08;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductSelectServlet
 */
@WebServlet("/productSelect")
public class ProductSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// character setting
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		// get prdList and binding
		ProductDAO dao = new ProductDAO();
		ArrayList<ProductVO> prdList = dao.productSelect();
		request.setAttribute("prdList", prdList);
		
		// forward to view
		RequestDispatcher dispatch = request.getRequestDispatcher("productView2");
		dispatch.forward(request, response);
	}

}
