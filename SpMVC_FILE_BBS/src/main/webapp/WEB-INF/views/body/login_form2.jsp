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
<style>
.login_body{
	margin:0;
	padding:0;
	background: #34495e;
}
.login_form {
	width:400px;
	padding: 40px;
	
	position: absolute;
	top:50%;
	left:50%;
	transform:translate(-50%, -50%);
	
	background: #191919;
	text-align: center;
	z-order:1;
	
}

.login_form h2 {
	color:white;
	font-weight: 500;
}

.login_form input[type="text"],
.login_form input[type="password"] {
	border:0;
	background: none;
	display: block;
	margin : 20px auto;
	text-align: center;
	border: 2px solid #3498db;
	padding: 14px 10px;
	width: 200px;
	outline: none;
	color:white;
	border-radius: 25px;
	transition : 0.2s;

}

.login_form input[type="text"]:focus,
.login_form input[type="password"]:focus {
	width:280px;
	border-color : #2ecc71;
}



.login_form button {
	border:0;
	background: none;
	display: block;
	margin: 20px auto;
	text-align: center;
	border : 2px solid #2ecc71;
	padding:14px 40px; 
	outline: none;
	color:white;
	border-radius: 25px;
	cursor: pointer;

}

.login_form button:hover {
	background: #2ecc71;
}

h4 {
	background-color: red;
	color:yellow;
	font-style: bold;
	padding-top:10px;
	padding-bottom: 10px;
	border-radius: 25px;
}

</style>
<body class="login_body">
	<form class="login_form" method="POST">
		<h2>로그인</h2>
		<c:if test="${LOGIN_MSG == 'LOGIN_REQ' }">
			<h4>로그인을 해야 사용할수 있습니다</h4>
		</c:if>
		<input type="text" name="m_userid" placeholder=""사용자 ID">
		<input type="password" name="m_password" placeholder=""비밀번호">
		<button>로그인</button>
	</form>
</body>
</html>