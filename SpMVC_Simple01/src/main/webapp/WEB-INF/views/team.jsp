<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scal=1">
<meta charset="UTF-8">
<title></title>
</head>
<body>
<header>
	<h3>화면구현 UI 발표 순서</h3>
</header>
<section>
	<ol>
	<c:forEach var="member" items="${TEAMS}" varStatus="i">
		<li>${member}</li>	
	</c:forEach>
	</ol>
</section>
</body>
</html>