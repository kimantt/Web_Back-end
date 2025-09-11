package sec08;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductViewServlet2
 */
@WebServlet("/productView2")
public class ProductViewServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	@SuppressWarnings("unchecked")
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ProductVO> prdList = (ArrayList<ProductVO>)request.getAttribute("prdList");
		
		PrintWriter out = response.getWriter();
		out.print("<html><head></head><body>");
		out.print("<table border=1><tr align='center' bgcolor='gold'>");
		out.print("<td>상품번호</td><td>상품명</td><td>가격</td>" 
		       + "<td>제조사</td><td>색상</td><td>카테고리 번호</td></tr>");
		
		for (ProductVO vo : prdList) {
			out.print("<tr><td>" + vo.getPrdNo() + "</td>");
			out.print("<td>" + vo.getPrdName() + "</td>");
			out.print("<td>" + vo.getPrdPrice() + "</td>");
			out.print("<td>" + vo.getPrdMaker() + "</td>");
			out.print("<td>" + vo.getPrdColor() + "</td>");
			out.print("<td>" + vo.getCtgNo() + "</td></tr>");
		}
		out.print("</table></body></html>");
		out.close();
	}

}
