<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script>
	const isLoggedIn = ${not empty sessionScope.Name ? "true" : "false"};
	
	if (!isLoggedIn) {
		alert('로그인이 필요합니다.');
		location.href='${contextPath}/';
	}
</script>
<title>숫자 맞추기</title>
</head>
<body>
		<div style="width:350px; margin:0 auto; text-align:center;">
		<h1 style="margin-top:10px; margin-bottom:10px;">숫자 맞추기 게임</h1>
		<hr>
		<div>어떤 숫자일까요? 맞춰보세요^^ (1 ~ 10)</div>
		<div style="margin-top:10px; margin-bottom:10px;">
		<form action="${contextPath}/Game/GuessResult" method="post" target="guessFrame">
		<input type="text" name="number">&nbsp;
		<input type="submit" value="입력">
		</form>
		<iframe name="guessFrame" style="border:none; width:100%; height:200px;"></iframe>
		</div></div>
</body>
</html>