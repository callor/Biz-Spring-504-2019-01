<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Dyanmic Menu</title>
<link rel="stylesheet" 
		href="<c:url value='/css/menu.css' />" >

</head>
<body>
<nav>
	<ul>
		<li><a href="#">Home</a></li>
		<li><a href="<c:url value='/menu1' /> ">메뉴시스템1</a></li>
		<li><a href="#">로그인</a></li>
		<li><a href="#">회원가입</a></li>
	</ul>
</nav>

</body>
</html>