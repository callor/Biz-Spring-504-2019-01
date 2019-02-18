<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="addList1" method="POST">
	<p>숫자1:<input type="text" name="intNum1" value="${intNum1}">
	<p>숫자2:<input type="text" name="intNum2" value="${intNum2}">
	<p><button>계산</button>
	</form>
	
	<hr/>
	<p>결과: ${SUM}  

</body>
</html>