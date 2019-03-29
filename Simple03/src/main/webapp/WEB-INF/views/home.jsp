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
<h3>스프링 계산기</h3>
<form method="POST" action="calc">
	<label>첫번째숫자</label>
	<input type="text" name="num1" value="${num1}"><br/>
	
	<label>두번째숫자</label>
	<input type="text" name="num2" value="${num2}"><br/>
	
	<label>연 산 자</label>
	<select name="op">
		<option value="P">덧셈</option>
		<option value="T">곱셈</option>
		<option value="M">뺄셈</option>
	</select><br/>
	
	<button>전송</button>
</form>
<p>결과 : ${result}


</body>
</html>