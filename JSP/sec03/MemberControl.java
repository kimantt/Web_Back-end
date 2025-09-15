package sec02;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberControl
 */
@WebServlet("/memberSelect")
public class MemberControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemberControl() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberVO> memList = dao.memberSelect(); // member2 테이블의 모든 레코드 조회 후 arrayList에 저장
		
		request.setAttribute("membersList", memList);
		
		// view로 binding data forward
		RequestDispatcher dispatch = request.getRequestDispatcher("09_15/ex/memberListView.jsp");
		dispatch.forward(request, response);
	}

}
