<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<style>
	* {	margin:0 auto; }
	
	h3 {
		margin-top:10px;
		margin-bottom:10px;
		text-align:center;
	}
</style>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h3>회원가입</h3>
	<form method="post" action="${contextPath}/User/Join">
	<table>
		<tr>
			<td style="text-align:right">ID</td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td style="text-align:right">비밀번호</td>
			<td><input type="password" name="pw"></td>
		</tr>
		<tr>
			<td style="text-align:right">이름</td>
			<td><input type="text" name="name"></td>
		</tr>
	</table>
	<div style="text-align:center; margin-top:5px">
		<button type="button" onclick="location.href='${contextPath}/'">메인으로</button>&nbsp;
		<input type="submit" value="회원가입">
	</div>
	</form>
</body>
</html>