package sec06;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductBindingServlet
 */
@WebServlet("/productBinding")
public class ProductBindingServlet extends HttpServlet {
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
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ProductVO> prdList = new ArrayList<ProductVO>();
		prdList.add(new ProductVO("1001", "선풍기", 60000, 5));
		prdList.add(new ProductVO("1002", "모니터", 200000, 2));
		prdList.add(new ProductVO("1003", "의자", 100000, 7));
		request.setAttribute("prdList", prdList); // 데이터 바인딩
		
		// 포워딩
		RequestDispatcher dispatch = request.getRequestDispatcher("productView");
		dispatch.forward(request, response);
	}

}
