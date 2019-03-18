<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="addr" method="POST">
	<label>이름</label>
	<input type="text" value="${ADDR.a_name}" id="a_name" name="a_name"><br/>
	
	<label>전화번호</label>
	<input type="text" id="a_tel" value="${ADDR.a_tel}" name="a_tel"><br/>
	
	<label>시/도</label>
	<select id="a_city" name="a_city">
		<c:forEach items="${CITIES}" var="city">
			<option value="${city.value}"
			<c:if test="${ADDR.a_city == city.value}">SELECTED</c:if>
			>${city.label}</option>
		</c:forEach>
	</select><br/>
	<button>전송</button>
</form>
</body>
</html>