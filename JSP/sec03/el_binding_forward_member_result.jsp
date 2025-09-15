<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberVO 객체 바인딩</title>
</head>
<body>
아이디 : ${mem.getId()} <br>
비밀번호 : ${mem.getPwd()} <br>
이름 : ${mem.getName()} <br>
이메일 : ${mem.getEmail()} <br>

<h3>태그의 속성값으로 표현언어 사용</h3>
<form action="memberEdit.jsp" method="post">
	아이디 : <input type="text" name="id" value="${mem.id}" readonly><br>
	비밀번호 : <input type="text" name="pwd" value="${mem.pwd}"><br>
	이름 : <input type="text" name="name" value="${mem.name}"><br>
	이메일 : <input type="text" name="email" value="${mem.email}"><br>
	<input type="submit" value="수정완료">
</form>
</body>
</html>