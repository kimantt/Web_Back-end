package controller.game;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import game.Guess;
import game.Guess.GuessResultPack;

/**
 * Servlet implementation class GuessResultView
 */
@WebServlet("/Game/GuessResult")
public class GuessResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Guess game;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String reset = request.getParameter("reset");
	    if ("true".equals(reset)) {
	        game = new Guess();
	        
	        RequestDispatcher dispatch = request.getRequestDispatcher("/Game/GuessMain");
			dispatch.forward(request, response);
			return;
	    }
		
		String number = request.getParameter("number");
		
		GuessResultPack result = game.run(number);
		request.setAttribute("correct", result.correct);
		request.setAttribute("result", result.result);
		
		RequestDispatcher dispatch = request.getRequestDispatcher("/view/game_page/GuessResultView.jsp");
		dispatch.forward(request, response);
	}

}
