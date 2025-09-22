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
<title>가위바위보</title>
</head>
<body>
		<div style="width:300px; margin:0 auto; text-align:center;">
		<h1 style="margin-top:10px; margin-bottom:10px;\">가위바위보 게임</h1>
		<hr>
		<div>무엇을 내시겠습니까?</div>
		<div style="margin-top:10px; margin-bottom:10px;">
		<a href="${contextPath}/Game/GaBaBoResult?playerInput=0"><button>가위</button></a>&nbsp;
		<a href="${contextPath}/Game/GaBaBoResult?playerInput=1"><button>바위</button></a>&nbsp;
		<a href="${contextPath}/Game/GaBaBoResult?playerInput=2"><button>보</button></a>
		</div></div>
</body>
</html>