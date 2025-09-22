package controller.game;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import game.GaBaBo;
import game.GaBaBo.GaBaBoResultPack;

/**
 * Servlet implementation class GaBaBoResultView
 */
@WebServlet("/Game/GaBaBoResult")
public class GaBaBoResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		int playerInput = Integer.parseInt(request.getParameter("playerInput"));
		
		GaBaBo game = new GaBaBo(playerInput);
		GaBaBoResultPack result = game.run();
		
		if (result != null) {
			request.setAttribute("computerChoice", result.computerChoice);
			request.setAttribute("result", result.result);
		}
		
		RequestDispatcher dispatch = request.getRequestDispatcher("/view/game_page/GaBaBoResultView.jsp");
		dispatch.forward(request, response);
	}

}
