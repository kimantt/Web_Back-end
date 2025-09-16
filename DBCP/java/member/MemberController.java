package member;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 현재 서블릿이 Front의 역할을 하려면
 * uri는 특정 uri/* -> 특정 uri로 시작하는 요청은 모두 현재 서블릿이 처리
 */
@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MemberDAO memberDAO;

	/**
	 * memberDAO 객체 인스턴스 생성 : DataSource 객체 생성
	 */
	public void init(ServletConfig config) throws ServletException {
		memberDAO = new MemberDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	/**
	 * 모든 요청 처리 메서드 : doHandle()
	 */
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = null; // forward 시킬 페이지의 location 저장
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String action = request.getPathInfo(); // 서블릿에 전달된 경로만 반환
		System.out.println("action : " + action);
		
		// http://localhost:8080/MemberControl/member/listMembers.do 로 요청하면 전체 회원정보 조회기능을 응답
		if (action == null || action.equals("/listMembers.do")) { // 회원정보 조회
			System.out.println("회원정보 페이지");
			List<MemberVO> membersList = memberDAO.listMembers();
			request.setAttribute("membersList", membersList); // DAO로부터 반환받은 회원정보를 attribute에 바인딩
			nextPage = "/view/member/listMembers.jsp"; // 현재 요청에 대한 view 파일, MemberControl/listMembers.jsp
			
		} else if (action.equals("/memberForm.do")) { // 회원가입폼 전송요청
			nextPage = "/view/member/memberForm.jsp";
			
		} else if (action.equals("/addMember.do")) { // 회원가입 처리
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			
			MemberVO memberVO = new MemberVO(id, pwd, name, email);
			memberDAO.addMember(memberVO);
			request.setAttribute("msg", "addMember");
			nextPage = "/member/listMembers.do";
			
		} else if (action.equals("/modMemberForm.do")) { // 회원정보수정폼 전송요청
			String id = request.getParameter("id");
			MemberVO memInfo = memberDAO.findMember(id);
			request.setAttribute("memInfo", memInfo);
			nextPage = "/view/member/modMemberForm.jsp";
			
		} else if (action.equals("/modMember.do")) { // 회원정보수정 처리
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			
			MemberVO memberVO = new MemberVO(id, pwd, name, email);
			memberDAO.modMember(memberVO);
			request.setAttribute("msg", "modMember");
			nextPage = "/member/listMembers.do";
			
		} else if (action.equals("/delMember.do")) { // 회원 삭제
			String id = request.getParameter("id");
			memberDAO.delMember(id);
			request.setAttribute("msg", "delMember");
			nextPage = "/member/listMembers.do";
			
		} else { // 나머지 모든 요청은 회원리스트로 가도록
			List<MemberVO> membersList = memberDAO.listMembers();
			request.setAttribute("membersList", membersList);
			nextPage = "/view/member/listMembers.jsp";
		}
		
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
	}
	
}
