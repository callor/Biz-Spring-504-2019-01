<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" 
	content="width=device-width,initial-scale=1">
<meta charset="UTF-8">
<title>나라 Plus</title>
<link rel="stylesheet" 
	href="<c:url value='/css/home.css' />">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>	
</head>
<body>
	<header class="main-header"><h2>나라 Plus</h2></header>
	<section class="content-container">
		<aside class="sidebar">
			<%@ include file="/WEB-INF/views/include/include-nav.jspf" %>

		</aside>
		<article class="main">
			<div class="page-header">section header</div>
			<div class="content">
				<div class="column sub1">
					<%@ include file="/WEB-INF/views/bodys/dept-list.jspf" %>
				</div>
				<div class="column sub2">
				<p>거래처 코드 : <span id="d-code"></span><br/> 
				거래처명 : <span id="d-name"></span><br/>
				대표자명 : <span id="d-ceo"></span>
				<p><button id="btn-send">전송</button>
				<p id="d-list"></p>
				</div>			
			</div>		
		</article>
	</section>
	<footer>
		<address>CopyRight &copy; callor@callor.com</address>
	</footer>
</body>
</html>



