<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>숫자 맞추기</title>
</head>
<body>
		<div style="margin:0 auto; text-align:center;">
		${result}
		<div style="margin-top:10px; margin-bottom:10px;">
		<a href="${contextPath}/" target="_top"><button>메인으로</button></a>
		<c:choose>
			<c:when test="${correct}">
				&nbsp;
				<form action="${contextPath}/Game/GuessResult" method="post" target="_top" style="display:inline-block;">
    				<input type="hidden" name="reset" value="true"/>
    				<button type="submit">다시하기</button>
				</form>		
			</c:when>
		</c:choose>
		</div></div>
</body>
</html>