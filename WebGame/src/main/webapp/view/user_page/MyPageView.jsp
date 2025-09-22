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
<title>마이 페이지</title>
</head>
<body>
	<h1>${sessionScope.Name}님의 마이 페이지</h1>
	<hr style="width:300px">
	<div style="margin-top:10px">
	<a href="${contextPath}/User/ModifyForm"><button>회원정보 수정</button></a>
	&nbsp;
	<button type="button" 
        onclick="if(confirm('정말로 탈퇴하시겠습니까?')) location.href='${contextPath}/User/Delete';">
    	회원탈퇴
	</button>
	<br>
	<div style="margin-top:10px">
	<a href="${contextPath}/"><button>메인으로</button></a>
	</div>
	</div>
</body>
</html>