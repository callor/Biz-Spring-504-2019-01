<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userId = request.getParameter("userId");
	String password = request.getParameter("password");
	String email = request.getParameter("email");
	String userName = request.getParameter("userName");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원가입 정보</h3>
	
	<p>아이디 : <%= userId %> <br/>
		비밀번호 : <%= password %><br />
		email : <%= email %><br />
		userName : <%= userName %>

	<p>회원 가입을 환영합니다

</body>
</html>



