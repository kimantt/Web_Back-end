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
<title>회원정보 수정</title>
</head>
<body>
	<h3>회원정보 수정</h3>
	<form method="post" action="${contextPath}/User/Modify">
	<table>
		<tr>
			<td style="text-align:right">ID</td>
			<td><input type="text" name="id" value="${id}" readonly></td>
		</tr>
		<tr>
			<td style="text-align:right">비밀번호</td>
			<td><input type="password" name="pw" value="${pw}"></td>
		</tr>
		<tr>
			<td style="text-align:right">이름</td>
			<td><input type="text" name="name" value="${name}"></td>
		</tr>
	</table>
	<div style="text-align:center; margin-top:5px">
		<button type="button" onclick="location.href='${contextPath}/'">메인으로</button>&nbsp;
		<input type="submit" value="수정완료">
	</div>
	</form>
</body>
</html>