<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int intNum1 = 30;
	int intNum2 = 40;
	
	int intSum = intNum1 + intNum2;
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>안녕하세요</h1>
	<p>나의 홈페이지에 오신것을 환영합니다</p>
	<p><%= intNum1 %> 더하기 <%= intNum2 %> 는 
		<%= intSum %> 입니다 </p>
		
	<%
		intSum = 0;
		for(int i = 0 ; i < 100 ; i++) {
			intSum += i;
	%>		
			<p>덧셈중 : <%=intSum %>
			<p>덧셈중 : <%= i %>
			
	<%
		}
	%>	

</body>
</html>






