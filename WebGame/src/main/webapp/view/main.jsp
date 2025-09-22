<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<style>
	* {margin:0 auto;}
	
	h1 {
		margin-top:10px;
		margin-bottom:10px;
		text-align:center;
	}
	
	div {
		text-align:center;
	}
</style>
<meta charset="UTF-8">
<title>WebGame</title>
</head>
<body>
	<h1>게임에 오신 것을 환영합니다</h1>
	<div style="margin-bottom:10px">
	<c:choose>
	<c:when test="${not empty sessionScope.Name}">
		${sessionScope.Name}님 환영합니다!
	</c:when>
	<c:otherwise>
		<a href="${contextPath}/User/LoginForm"><button>로그인</button></a>
	</c:otherwise>
	</c:choose>
	</div>
	<table border="1">
	<tr><td style="text-align:center;"><h3>메뉴</h3></td></tr>
	<tr><td><a href="${contextPath}/info">1. 애플리케이션 정보</a></td></tr>
	<tr><td><a href="${contextPath}/Game/GaBaBoMain">2. 가위바위보 게임</a></td></tr>
	<tr><td>
	<a href="javascript:void(0);" onclick="document.getElementById('GuessGame').submit();">3. 숫자 맞추기 게임</a>
	</td></tr>
	</table>
	<c:choose>
	<c:when test="${not empty sessionScope.Name}">
		<div style="margin-top:10px">
		<a href="${contextPath}/User/MyPage"><button>마이 페이지</button></a>
		&nbsp;
		<a href="${contextPath}/User/Logout"><button>로그아웃</button></a>
		</div>
	</c:when>
	</c:choose>
	
	
	<form id="GuessGame" action="${contextPath}/Game/GuessResult" method="post">
    	<input type="hidden" name="reset" value="true"/>
	</form>	
</body>
</html>