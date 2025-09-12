<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>폼에 입력된 값으로 빈 속성값 설정</title>
</head>
<body>
	<% request.setCharacterEncoding("utf-8"); %>
	<!-- StudentBean 클래스의 속성값을 한번에 저장 : 값은 request 객체 파라미터로 전달 -->
	<jsp:useBean id="student" class="sec01.StudentBean" scope="page">
		<jsp:setProperty property="*" name="student"/>
	</jsp:useBean>
	
	<h3>빈 속성값 출력 (Getter 사용)</h3>
	학번 : <%=student.getStdNo() %> <br>
	이름 : <%=student.getStdName() %> <br>
	전화 : <%=student.getStdPhone() %> <br>
	주소 : <%=student.getStdAddress() %> <br>
	학년 : <%=student.getStdYear() %> <br>
	관심분야 : 
	<%
		String[] stdInterests = student.getStdInterests();
		for (int i = 0; i < stdInterests.length; i++) { %>
			<%=stdInterests[i] %>
	<%	}
	%>
</body>
</html>