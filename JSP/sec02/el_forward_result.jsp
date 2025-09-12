<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el_forward_result</title>
</head>
<body>
	request 객체에 attribute로 바인딩 된 data를 el로 출력 <br>
	id : ${id} <br> <!-- 바인딩된 속성값은 속성명만 사용하면됨 -->
	pwd : ${pwd} <br>
	name : ${name} <br>
	email : ${email} <br>
</body>
</html>