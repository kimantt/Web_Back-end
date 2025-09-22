package controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
@WebServlet("/User/ModifyForm")
public class ModifyForm extends HttpServlet {
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
			UserDTO dto = dao.selectUser(new UserDTO(id, null, null));
			
			request.setAttribute("id", dto.getId());
			request.setAttribute("pw", dto.getPass());
			request.setAttribute("name", dto.getName());
			
			RequestDispatcher dispatch = request.getRequestDispatcher("/view/user_page/ModifyForm.jsp");
			dispatch.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
