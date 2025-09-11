<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	int x = 10; // 전역변수
	float f = 3.14f;
	public int plus(int x) {
		return x+10;
	}
%>
<%
	// 스크립트릿에서는 메서드 선언이 불가능함 - 메서드 정의는 선언부에서 정의해야함
//	public int minus(int x) {
//		return 0;
//	}
%>
<%=x %><br>
f변수의 값 : <%=f %><br>
plus 메서드 호출 : <%=plus(x) %> <!-- jsp 선언문에서 정의한 메서드 호출 후 결과가 출력 -->
</body>
</html>