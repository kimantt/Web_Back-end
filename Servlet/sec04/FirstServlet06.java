package sec04;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet06
 */
@WebServlet("/first06")
public class FirstServlet06 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 바인딩 방식으로 데이터를 생성하고 redirect 방식으로 데이터 전달 - 불가능
	 * dispatch 방식으로 데이터 포워딩
	 * request.setAttribute()
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//데이터 바인딩
		request.setAttribute("name", "홍길동"); // value 홍길동은 Object 타입 객체로 전달
		request.setAttribute("address", "서울시 강남구");
		
		//response.sendRedirect("second06");
		
		// dispatch 방식으로 포워딩
		RequestDispatcher dispatch = request.getRequestDispatcher("second06");
		dispatch.forward(request, response);
	}

}
