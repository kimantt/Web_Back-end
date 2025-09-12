<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="frmMember" method="post" action="newMemberOk.jsp">
	<table>
		<tr><th>회원 가입창</th><th></th></tr>
		<tr><td>아이디</td><td><input type="text" name="memID"></td></tr>
		<tr><td>비밀번호</td><td><input type="text" name="memPWD"></td></tr>
		<tr><td>이름</td><td><input type="text" name="memName"></td></tr>
		<tr><td>이메일</td><td><input type="text" name="memEmail"></td></tr>
	</table>
	<input type="submit" value="가입하기">
	<input type="reset" value="다시입력">
	</form>
</body>
</html>