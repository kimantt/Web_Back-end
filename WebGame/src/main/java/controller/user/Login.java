package controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.UserDAO;
import user.UserDAO.LoginResult;
import user.UserDTO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/User/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		UserDAO dao = UserDAO.getInstance();
		LoginResult result = dao.loginCheck(new UserDTO(id, pw, null));
		
		if ("success".equals(result.result)) {
			HttpSession session = request.getSession();
			session.setAttribute("Name", result.dto.getName());
			session.setAttribute("ID", result.dto.getId());
			response.sendRedirect(request.getContextPath() + "/");
		}
		else if ("error:wrong password".equals(result.result)) {
			response.getWriter().println(
					"<script>"
					+ "alert('비밀번호가 틀렸습니다.'); location.href='" 
			        + request.getContextPath() + "/User/LoginForm';"
			      + "</script>");
		}
		else if ("error:no user".equals(result.result)) {
			response.getWriter().println(
					"<script>"
					+ "alert('해당 아이디의 사용자가 없습니다.'); location.href='" 
			        + request.getContextPath() + "/User/LoginForm';"
			      + "</script>");
		}
	}
}
