<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<c:set var="rootPath" 
	value="${pageContext.request.contextPath}" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>네이버는 내친구</title>
<link rel="stylesheet" href="${rootPath}/css/naver.css">

<style>
	body {
		display: flex;
		margin:0;
		flex-flow: column wrap;
	}
	
	header {
		background-color: #ccc;
		text-align: center;
	}
	
	nav {
		display: flex;
		flex-flow: row wrap;
		background-color: green;
		color : white;
	}
	
	nav a {
		display: inline-block;
		text-decoration: none;
		padding : 10px;
		margin: 0 5px 0 5px; /* top 과 bottom 은 0, 좌우는 5px */
		color:inherit; /* nav에 설정된 컬러를 그대로 가져와라 */
	}
	
	nav a:hover {
		background-color: #ccc;
		color:blue;
		font-weight: bold;
	}
	
	footer {
		flex : 0 0 50px;
		text-align: center;
		padding:10px;
		color:#fff;
		background-color: rgba(60,100,160,0.9)
	}
	
	footer address {
	
	}
	
	#main-container {
		flex : 1 0 auto;
		display: flex;
		flex-flow : row wrap;
		height: 100%;
		justify-content: center;
	}
	
	.book-item {
		border:1px solid blue;
		background-color : #ccc;
		border-radius : 5px;
		
		margin:5px;
		padding:5px;
	}
	
	#search {
		margin:10px;
	}
	
	img { 
	
		float:left;
		margin:3px; 
	}
	
	
</style>
</head>
<body>
	<header>
		<h3>네이버 검색</h3>
	</header>
	<nav>
		<a href="#">Home</a>
		<form action="naver" method="POST" 
			id="naver">
			<select name="cate">
				<option value="BOOK">도서정보</option>
				<option value="MOVIE">영화정보</option>
				<option value="NEWS">뉴스</option>
			</select>
			<input 
				type="text" 
				name="search" 
				id="search"
				placeholder="검색어 입력 후 Enter"> 
		</form>
	</nav>

	<section id="main-container">
		<c:forEach items="${NAVER}" var="book">
		<article class="book-item na-col s1 m1 c1">
			<h4>
			<a href="${book.link}" target=_NEW>
			${book.title}
			</a></h4>
			<img src="${book.image}">
			<p>${book.description}</p>
		</article>
		</c:forEach>
	</section>
	<footer>
		<address>CopyRight &copy; callor@callor.com</address>
	</footer>
</body>
</html>