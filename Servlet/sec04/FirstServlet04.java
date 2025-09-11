package sec04;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet04
 */
@WebServlet("/first04")
public class FirstServlet04 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * redirect 방식으로 다른 서블릿에 데이터 전달
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html'charset=utf-8");
		String name = "홍길동"; // 조합문자를 url 파라미터 값으로 추가할때는 url 사용가능한 범위의 코드로 변경해야함
		String encodeName = URLEncoder.encode(name, "utf-8");
		int age = 20;
		// 파라미터 추가 : uri?파라미터명=값&파라미터명=값
		response.sendRedirect("second04?name="+encodeName+"&age="+age);
	}

}
