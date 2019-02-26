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
<style>
	* {
		box-sizing: border-box;
		
	}
	body {
		width:100%;
		padding:0;
		margin:0;
	}
	header {
		background:linear-gradient(to left ,#00AF00, #00F000);
		height: 70px;
		text-align: center;
		color:white;
		margin:0;	
		
		/* 
		tag내에 box형의 tag가 있을때
		내부의 tag를 상하좌우 중앙정렬할때
		*/
		
		display:flex;
		/* 내부의 address 를 중심에 놓기 위해 */	
		align-items: center;
		justify-content: center;

	}
	
	nav {
		background-color: blue;
		padding:0px
	
	}
	
	nav a {
	
		display: inline-block;
		width:auto;
		
		text-decoration: none;
		padding:.8em;
		margin:0px;
		color:white;
	
	}
	
	nav a:hover {
		background-color: #ccc;
		color:black;
		font-weight: bold;
	}
	
	.main-container {
		border:1px solid blue;
		padding:5px;
	
	}
	
	footer {
		background-color: #0000ff;
		text-align: center;
		padding: 0.3em;
		color:white;
		font-size: 12px;
	
		display:flex;
		/* 내부의 address 를 중심에 놓기 위해 */	
		align-items: center;
		justify-content: center;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<header>
	<h2>회원가입</h2>
</header>
<nav>
	<a href="<c:url value='/' />" >홈</a>
	<a href="#">로그인</a>
	<a href=<c:url value="/join" /> >회원가입</a>
	<a href=<c:url value="/admin" /> >관리자</a>
	<a href="#">시스템정보</a>
</nav>
<section class="main-container">
	<c:if test="${BODY == 'JOIN-FORM'}" >
		<%@ include file="/WEB-INF/views/bodys/join-form.jspf" %>
	</c:if>


</section>
<footer>
	<address>CopyRight &copy; callor@callor.com</address>
</footer>
</body>
</html>