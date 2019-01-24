<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.sql.*" %>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<sql:setDataSource var="booksDataSource"
	driver="oracle.jdbc.driver.OracleDriver"
	url="jdbc:oracle:thin:@localhost:1521:xe"
	user="mybts"
	password="1234" />
<sql:query dataSource="${booksDataSource}" var="bookList" >
	SELECT * FROM tbl_books
</sql:query>	

 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서정보 관리</title>
<style>
	header {
		background-color: #00aba9;
		color: #fff;
		paddin: 10px;
		font-size: 20pt;
		font-weight: bold;
		text-align: center;
	}
	
	nav {
		width: 100%;
		color: #fff;
		background-color: #00aba9;
		font-weight: normal;
		font-size: 10px;
	}

</style>

</head>
<body>
<header>
	<h2>도서정보</h2>
	<nav>
		<a href="#">홈</a>
		<a href="#">도서정보보기</a>
		<a href="#">로그인</a>
		<a href="#">회원가입</a>
		<a href="#">About</a>
	</nav>
</header>
<section>
	<table>
		<tr>
			<th>도서명</th>
			<th>출판사</th>
			<th>저자</th>
			<th>가격</th>
		</tr>
		<c:forEach var="row"  items="${bookList.rows}">
			<tr>
				<td>${row.tb_name }</td>
				<td>${row.tb_comp }</td>
				<td>${row.tb_auth }</td>
				<th>${row.tb_price }</th>
			</tr>
		</c:forEach>
	</table>
</section>

</body>
</html>



