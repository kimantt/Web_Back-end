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
 * Servlet implementation class Modify
 */
@WebServlet("/User/Modify")
public class Modify extends HttpServlet {
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
			
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			if (dao.updateUser(new UserDTO(id, pw, name))) {
				HttpSession session = request.getSession();
				
				session.setAttribute("Name", name);
				
				response.getWriter().println(
						"<script>"
						+ "alert('회원정보를 수정했습니다.'); location.href='" 
				        + request.getContextPath() + "/';"
				      + "</script>");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
