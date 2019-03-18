<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://www.springframework.org/tags/form" 
			prefix="form"%> 
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="addr" modelAttribute="addrVO" autocomplete="off">
	<label>이름</label>
	<form:input id="a_name" 
			path="a_name" 
			placeholder="이름을 입력하세요" /><br/>
	
	<label>전화번호</label>
	<form:input id="a_tel" 
			path="a_tel" 
			placeholder="전화번호를 입력하세요"/><br/>
	
	<label>시/도</label>
	<form:select id="a_city" path="a_city">
		<form:options items="${CITIES}" 
				itemLabel="label" 
				itemValue="value" />
	</form:select><br/>
	<button>전송</button>
</form:form>
</body>
</html>





