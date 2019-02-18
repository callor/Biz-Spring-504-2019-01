<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="calc" method="POST">
		<p>숫자 1 : <input type="text" name="intNum1">
		<p>숫자 2 : <input type="text" name="intNum2">
		<p><button>계산</button>
	</form>
	<hr/>
	<p>덧셈 : ${ADD}</p>
	<p>뺄셈 : ${MINUS}</p>
	<p>곱셈 : ${MULTI}</p>
	<p>나눗셈 : ${DEVIDE}</p>
</body>
</html>