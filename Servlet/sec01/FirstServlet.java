package sec01;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet; //url mapping에 활용
import javax.servlet.http.HttpServlet; //상속
import javax.servlet.http.HttpServletRequest; //http 요청관련
import javax.servlet.http.HttpServletResponse; //http 응답관련

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet") //uri 매핑 - 1. @WebServlet 어노테이션 사용, 2. web.xml 사용
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see Servlet#init(ServletConfig)
	 * 초기화 메서드
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("FirstServlet : init 메서드 호출");
	}

	/**
	 * @see Servlet#destroy()
	 * 생명주기 마지막에 호출되는 메서드
	 * 소스코드 변경 시 재컴파일, 서버가 재시작(서버종료) 시
	 */
	public void destroy() {
		System.out.println("FirstServlet : destroy 메서드 호출");
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 클라이언트 폼에서 method가 get일때 호출되는 메서드
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirstServlet : doGet 메서드 호출");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
