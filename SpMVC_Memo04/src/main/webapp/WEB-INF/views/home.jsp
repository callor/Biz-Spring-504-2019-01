<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" 
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" 
			crossorigin="anonymous">
</head>
<body class="w3-container">
<%@ include file="/WEB-INF/views/include/include-nav.jspf" %>

<c:choose>
	<c:when test="${BODY == 'MEMO_LIST'}">
		<%@ include file="/WEB-INF/views/body/memo_list.jspf" %>
	</c:when>
	<c:when test="${BODY == 'MEMO_WRITE'}">
		<%@ include file="/WEB-INF/views/body/memo_write.jspf" %>
	</c:when>
	<c:otherwise>
		<h2>한줄메모장</h2>
	</c:otherwise>

</c:choose>


</body>
</html>