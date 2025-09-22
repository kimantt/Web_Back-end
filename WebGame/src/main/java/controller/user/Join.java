package controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.UserDAO;
import user.UserDTO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/User/Join")
public class Join extends HttpServlet {
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
		String name = request.getParameter("name");
		UserDTO dto = new UserDTO(id, pw, name);
		
		UserDAO dao = UserDAO.getInstance();
		String result = dao.insertUser(dto);
		
		if ("success".equals(result)) {
			HttpSession session = request.getSession();
			session.setAttribute("Name", dto.getName());
			session.setAttribute("ID", dto.getId());
			response.getWriter().println(
					"<script>"
					+ "alert('회원가입을 성공했습니다'); location.href='" 
			        + request.getContextPath() + "/';"
			      + "</script>");
		}
		else {
			response.getWriter().println(
					"<script>"
					+ "alert('" + result + "'); location.href='" 
			        + request.getContextPath() + "/User/JoinForm';"
			      + "</script>");
		}
	}
}
