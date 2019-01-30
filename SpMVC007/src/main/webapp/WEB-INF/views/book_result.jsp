<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib 
	uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %>
	
	    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>도서정보</h3>
<p>도서명 : ${BOOK.b_title} 
<p>출판사명 : ${BOOK.b_comp}
<p>저자명 : ${BOOK.b_auth}
<p>가격 : ${BOOK.b_price}

<c:forEach var="bookVO" items="${BOOKS}">
	<p>${bookVO.b_title} 
		: ${bookVO.b_comp} 
		: ${bookVO.b_auth} 
		: ${bookVO.b_price}
</c:forEach>

</body>
</html>