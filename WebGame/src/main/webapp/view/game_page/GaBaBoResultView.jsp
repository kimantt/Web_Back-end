<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가위바위보</title>
</head>
<body>
		<div style="width:300px; margin:0 auto; text-align:center;">
		<h1 style="margin-top:10px; margin-bottom:10px;\">가위바위보 게임</h1>
		<hr>
		<c:choose>
			<c:when test="${empty result}">
				<div>오류 : 다시 시도해주세요.</div>
			</c:when>
			<c:otherwise>
				<div>${result}<br>
				컴퓨터는 ${computerChoice}를 냈습니다.<br>
				</div>
			</c:otherwise>
		</c:choose>
		<div style="margin-top:10px; margin-bottom:10px;">
		<a href="${contextPath}/"><button>메인으로</button></a>&nbsp;
		<a href="${contextPath}/Game/GaBaBoMain"><button>다시하기</button></a>
		</div></div>
</body>
</html>