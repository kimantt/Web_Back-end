<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Application Info</title>
</head>
<body>
	<div style="width:300px; margin:0 auto;">
	<h1 style="margin-top:10px; margin-bottom:10px; text-align:center;">애플리케이션 정보</h1>
	<hr>
	제목 : 웹게임 <br>
	제작자 : 홍길동 <br>
	내용 : 가위바위보 게임/숫자 알아맞히기 게임
	<div style="margin-top:10px;">
	<a href="${contextPath}/"><button>메인으로</button></a>
	</div></div>
</body>
</html>