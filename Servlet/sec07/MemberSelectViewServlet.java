package sec07;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * member2 테이블의 데이터 조회된 결과를 받아서 view 출력 진행
 */
@WebServlet("/memSelect")
public class MemberSelectViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 받음
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 비즈니스 로직 처리 : DAO 호출하고 결과 받아옴
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberVO> memList = dao.memberSelect();
		
		// 응답 처리
		out.print("<html><head></head><body>");
		out.print("<table border=1><tr align='center' bgcolor='gold'>");
		out.print("<td>아이디</td><td>비밀번호</td><td>이름</td>" 
		       + "<td>이메일</td><td>가입일</td><td>삭제</td></tr>");
		
		for (MemberVO vo : memList) {
			out.print("<tr><td>" + vo.getMemID() + "</td>");
			out.print("<td>" + vo.getMemPWD() + "</td>");
			out.print("<td>" + vo.getMemName() + "</td>");
			out.print("<td>" + vo.getMemEmail() + "</td>");
			out.print("<td>" + vo.getMemJoinDate() + "</td>");
			out.print("<td><a href='/Servlet01/memDelete?memId=" +  vo.getMemID() + "'>삭제</a></td></tr>");
		}
		out.print("</table></body></html>");
		// out 객체는 i/o 스트림 객체이기 때문에 자원 사용함 -> close
		out.close();
	}
}
