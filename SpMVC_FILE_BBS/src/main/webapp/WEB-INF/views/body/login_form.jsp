<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" 
		value="${pageContext.request.contextPath}" />   

<style>
	fieldset{
		width:400px;
		margin:30px auto; /* 가로방향 중앙정렬 */
		display: flex;
		flex-direction: column;
		border-radius: 15px;
		border:2px solid red;
	
	}
	
	legend {
	
		font-size:12pt;
		font-weight:bold;
		color:#3d65ff;
		text-align:center;
	
	}
	
	.in-box {
		box-sizing:border-box;
		padding:16px;
		border:1px solid #ccc;
		height: 40px;
		border-radius: 7px;
	}

	.width-90 {
		display: inline-block;
		width:90%;
		margin:15px auto;
	}

	.in-box:hover {
		background-color: #ddd;
		border:1px solid blue;
	}
	
	.in-box:focus {
		outline:none;
	}
	
	input:invalid {
		background-color: #ffdddd;
		border:2px solid red;
	}

	.btn-login {
		background-color: green;
		color:yellow;
		font-size : 20px;
		font-weight: bold;
		padding:10px;
		border-radius: 15px;
		
	}
	
	.btn-login:hover {
		background-color: rgba(0,255,0,0.8);
		box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
		text-shadow: 2px 2px aqua;
	}
	.error-box {
		display: none;
		padding:0.3rem;
		border-radius: 7px;
		background-color: red;
		color:yellow;
		text-align: center;
	}
	
</style>

<script 
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<form action="${rootPath }/login/login" 
		method="POST"
		 autocomplete="off">

	<fieldset>
	<legend>로그인</legend>

	<h3 id="error-msg" class="error-box width-90"></h3>
	<input type="text" class="in-box width-90" required
			placeholder="회원ID를 입력하세요"
			id="m_userid" name="m_userid">
			
	<input type="password" class="in-box width-90"
			placeholder="비밀번호를 입력하세요"
			id="m_password" name="m_password">
		
	<button id="btn-login" type="submit" 
		class="width-90 btn-login">로그인</button>
	</fieldset>
</form>