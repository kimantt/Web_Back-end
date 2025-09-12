<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% request.setCharacterEncoding("utf-8"); %>
	<jsp:useBean id="member" class="sec01.MemberBean" scope="page">
		<jsp:setProperty property="*" name="member"/>
	</jsp:useBean>
	<h1>Bean 속성값 출력</h1>
	아이디 : <%=member.getMemID() %><br>
	비밀번호 : <%=member.getMemPWD() %><br>
	성명 : <%=member.getMemName() %><br>
	이메일 : <%=member.getMemEmail() %><br>
</body>
</html>