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
 * Servlet implementation class Delete
 */
@WebServlet("/User/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			
			UserDAO dao = UserDAO.getInstance();
			HttpSession session = request.getSession();
			String id = (String)session.getAttribute("ID");
			
			if (dao.deleteUser(new UserDTO(id, null, null))) {
				session.invalidate();
				
				response.getWriter().println(
						"<script>"
						+ "alert('탈퇴했습니다.'); location.href='" 
				        + request.getContextPath() + "/';"
				      + "</script>");
			}
			else {
				response.getWriter().println(
						"<script>"
						+ "alert('나중에 다시 시도해주세요.'); location.href='" 
				        + request.getContextPath() + "/';"
				      + "</script>");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
