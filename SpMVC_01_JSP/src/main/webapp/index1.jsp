<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 
	브라우저에서 보내온 request 관련 정보는
	request(일종의 vo)에 담겨 있다.
	서버에서는 request에서 값을 getter 해서
	뭔가 처리를 할 것이다.
 -->
<p>Remote Addr : <%= request.getRemoteAddr() %></p>
<p>Request URI : <%= request.getRequestURI() %></p>
<p>Request Method : <%= request.getMethod() %></p>
<p>Request ETC : <%= request.getLocalName() %></p>



</body>
</html>