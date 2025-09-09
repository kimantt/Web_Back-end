package sec02;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class bookServlet
 */
@WebServlet("/bookInsert")
public class bookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메서드 호출");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String bookNo = request.getParameter("bookNo");
		String bookName = request.getParameter("bookName");
		String bookAuthor = request.getParameter("bookAuthor");
		String bookPrice = request.getParameter("bookPrice");
		String bookYear = request.getParameter("bookYear");
		String bookMonth = request.getParameter("bookMonth");
		String bookDate = request.getParameter("bookDate");
		String bookStock = request.getParameter("bookStock");
		String pubNo = request.getParameter("pubNo");
		
		System.out.println("도서번호 : " + bookNo
							+"\n도서명 : " + bookName
							+"\n저자 : " + bookAuthor
							+"\n가격 : " + bookPrice
							+"\n발행일 : " + bookYear + "-" + bookMonth + "-" + bookDate
							+"\n재고 : " + bookStock
							+"\n출판사번호 : " + pubNo);
	}

}
