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
		<option value="SEOUL" 
			<c:if test="${ADDR.a_city =='SEOUL'}"> SELECTED</c:if>
			>서울특별시</option>
			
		<option value="GW" 
			<c:if test="${ADDR.a_city =='GW'}"> SELECTED</c:if>
			>광주광역시</option>
			
		<option value="BUSAN"
			<c:if test="${ADDR.a_city =='BUSAN'}"> SELECTED</c:if>
			>부산광역시</option>
			
		<option value="INCHUN"
			<c:if test="${ADDR.a_city =='INCHUN'}"> SELECTED</c:if>
			>인천광역시</option>
			
		<option value="JUNNAM"
			<c:if test="${ADDR.a_city =='JUNNAM'}"> SELECTED</c:if>
			>전라남도</option>
	</select><br/>
	<button>전송</button>
</form>
</body>
</html>