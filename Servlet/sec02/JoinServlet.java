package sec02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/insertMember")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("JoinServlet : init 메서드 호출");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("JoinServlet : destroy 메서드 호출");
	}

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
		// 요청처리
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String phone = request.getParameter("phonF") + "-" + request.getParameter("phonS") + "-" + request.getParameter("phonT");
		String grade = request.getParameter("grade");
		String[] interests = request.getParameterValues("interests");
		String department = request.getParameter("department");
		
		// 응답처리
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head></head><body>");
		out.println("<h1>회원 가입 내용</h1>");
		out.println("성명 : " + name + "<br>");
		out.println("ID : " + id + "<br>");
		out.println("비밀번호 : " + pw + "<br>");
		out.println("휴대폰 번호 : " + phone + "<br>");
		out.println("학년 : " + grade + "학년<br>");
		out.println("관심분야 : ");
		for (String str : interests) {
			out.print(str + " ");
		}
		out.println("<br>학과 : " + department + "<br>");
		out.println("</body></html>");
	}

}
