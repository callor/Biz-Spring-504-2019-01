<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<article>
	<div id="minor-menu">
		<c:set var="i" value="0"/>
		<c:set var="j" value="5"/>
		<table>
			<c:forEach var="FoodVO" items="${CATEFOOD}">
				<c:if test="${i%j == 0}" >
					<tr>
				</c:if>
				<c:if test="${i%j == j-1}" >
					</tr>
				</c:if>
				<c:set var="i" value="${i+1}" />
			</c:forEach>
		</table>
	</div>
	<div id="minor-menu1">
		<c:set var="j" value="5"/>
		<table>
			<c:forEach var="FoodVO" items="${CATEFOOD}" varStatus="i">
				<c:if test="${i.index % j ==0}" >
					<tr>
				</c:if>
				<c:if test="${i.index % j == j-1}" >
					</tr>
				</c:if>
				
			</c:forEach>
		</table>
	</div>



</article>

</body>
</html>