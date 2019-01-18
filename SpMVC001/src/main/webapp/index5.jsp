<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String strId = request.getParameter("userId");
	String strPassword = request.getParameter("pass");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h4>ID : <%= strId %></h4>
	<h4>Password : <%= strPassword %></h4>

</body>
</html>




