<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<!-- request 객체에 저장되어져서 전달되는 answer값에 따라
		 두 페이지 중 하나로 포워딩
		 응답에 대한 표현은 없이 처리만 하는 페이지에서 html 코드는 필요없음
		 불필요한 html 태그가 있으면 서블릿 변환될때 out.print문에 의해 출력되게됨-->
	<%! String answer; %>
	<%
		request.setCharacterEncoding("utf-8");
		answer = request.getParameter("answer");
		
		if (answer.equals("서울")) {
			response.sendRedirect("pass.jsp");
		} else {
			response.sendRedirect("fail.jsp");
		}
	%>
	