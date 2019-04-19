<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />    
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>책나라 관리자 화면</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- jquery를 사용해서 만든 3rd party 라이브러리 -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-contextmenu/2.7.1/jquery.contextMenu.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-contextmenu/2.7.1/jquery.contextMenu.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-contextmenu/2.7.1/jquery.ui.position.js"></script>

<link href="${rootPath}/css/list.css?ver=1" rel="stylesheet">
<style>

	body,html{
	
		height: 100%;
	}

	section {
		display: flex;
		flex-flow: column;
	}
	
	#admin-title {
		height: 70px;
		background-color: blue;
		color:white;
		text-align: center;
	}
	
	#admin-body {
		display: flex;
		padding:0;
		border:1px solid blue;
	}
	
	#admin-body aside {
		background-color: green;
		color:white;
		padding:0;
	}
	
	#admin-body ul {
		width:300px;
		padding:0px;
		text-align: center;
	}
	
	#admin-body li {
		list-style: none;
		margin:0;
	}
	
	#admin-body a {
		color:white;
		text-decoration: none;
		display: block;
		padding: 5% 5%;
		font-size: 20px;
	}
	
	#admin-body a:hover {
		background-color: #ddd;
		color:black;
	}

</style>
</head>
<body>
<section>
	<article id="admin-title">
		<h3>책나라 관리자</h3>
	</article>
	<article id="admin-body">
		<aside>
			<ul>
				<li><a href="${rootPath}/">판매관리</a></li>			
				<li><a href="${rootPath}/admin/user">회원관리</a></li>
				<li><a href="${rootPath}/admin/book">도서관리</a></li>
				<li><a href="">대여관리</a></li>
			</ul>
		</aside>
		<article>
			<c:choose>
				<c:when test="${ fn:startsWith(BODY,'USER') }">
					<c:if test="${BODY=='USER_LIST' }" >
						<h3>회원정보 관리</h3>
						<div>
							<%@include file="/WEB-INF/views/admin_body/admin_user_write.jspf" %>
						</div>
						<div>
							<%@include file="/WEB-INF/views/admin_body/admin_user_list.jspf" %>
						</div>
					</c:if>
				</c:when>
				<c:when test="${BODY == 'BOOK_LIST'}" >
					<h3>도서정보 관리</h3>
					<div>
						<%@include file="/WEB-INF/views/admin_body/admin_book_write.jspf" %>
					</div>
					<div>
						<%@include file="/WEB-INF/views/admin_body/admin_book_list.jspf" %>
					</div>
				</c:when>
				<c:otherwise>
					<h3>아직 구현되지 않은 기능입니다.</h3>
				</c:otherwise>
			</c:choose>
		</article>
	</article>
</section>

</body>
</html>