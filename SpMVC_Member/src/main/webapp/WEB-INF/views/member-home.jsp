<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib 
	uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" 
	content="width=device-width,initial-scale=1">
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" 
		href="<c:url value='/css/member_main.css' />">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<header>
	<h2>회원가입</h2>
</header>
<%@ include file="/WEB-INF/views/include/include-nav.jspf" %>
<section class="main-container">
	<c:if test="${BODY == 'JOIN-FORM'}" >
		<%@ include file="/WEB-INF/views/bodys/join-form.jspf" %>
	</c:if>
	<c:if test="${BODY == 'LOGIN-FORM'}" >
		<%@ include file="/WEB-INF/views/bodys/login-form.jspf" %>
	</c:if>
	
</section>
<footer>
	<address>CopyRight &copy; callor@callor.com</address>
</footer>
</body>
</html>