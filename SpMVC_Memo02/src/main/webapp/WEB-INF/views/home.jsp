<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    
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
	
</head>
<body>
<%@ include file="/WEB-INF/include/include-header.jspf" %>
<section>

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