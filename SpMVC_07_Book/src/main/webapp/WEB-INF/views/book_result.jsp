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
<table>
	<tr>
	<c:forEach var="bookVO" items="${BOOKS}" varStatus="i">
		
			<td>
				${bookVO.b_title}<br/> 
			${bookVO.b_comp}<br/> 
			${bookVO.b_auth}<br/> 
			${bookVO.b_price}
			</td>
			<c:if test="${i.count % 4 eq 0}" ></tr><tr></c:if>
	
	</c:forEach>
	</tr>
</table>
</body>
</html>