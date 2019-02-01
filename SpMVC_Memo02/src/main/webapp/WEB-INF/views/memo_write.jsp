<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" 
	content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>메모장</title>

<!-- 본문에 포함된 css 내용을 별도 파일로 분리 -->
<link rel="stylesheet" 
	href=<c:url value="/css/memo_main.css" /> >
<link rel="stylesheet" 
	href=<c:url value="/css/memo_input_style.css" /> >

</head>
<body>
<%@ include file="/WEB-INF/include/include-header.jspf" %>
<style>
	#message {
		color : red;
		font-size:30pt;
	}
</style>
<section>
	<form action=<c:url value="/memo"/> method="POST">
		<p id="message"><b>${MESSAGE}</b>
		<label for="m_auth">작성자</label>
		<input type="text" id="m_auth" name="m_auth"><br/>
		
		<label for="m_date">작성일자</label>
		<input type="date" id="m_date" name="m_date"><br/>
		
		<label for="m_subject">제목</label>
		<input type="text" id="m_subject" name="m_subject"><br/>
		
		<label for="m_text">메모</label>
		<textarea rows="5" id="m_text" name="m_text"></textarea><br/>
		
		<hr />
		<label></label>
		<button>메모저장</button>
	</form>

</section>
<footer>
	<address>CopyRight &copy; callor@callor.com</address>
</footer>


 <script src="https://unpkg.com/aos@next/dist/aos.js"></script>
  <script>
    AOS.init();
  </script>
</body>
</html>