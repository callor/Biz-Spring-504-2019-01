<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/*
	이 페이지 head에 view port를 설정하고
	w3.css를 사용할수 있도록 link를 설정한다.
*/
%>    
<!DOCTYPE html>
<html>
<head>
<%@ include file="../include/include-head.jspf" %>	
</head>
<!-- 
	header의 바탕색을 teal 색으로 설정하고
	header를 w3-panel로 설정
	글자를 가운데 정렬
	
	nav의 바탕색을 blue 색으로 설정하고
	각 nav 항목을 bar로 설정
 -->
<body>
	<!-- 여기는 header 영역 -->
	<%@ include file="../include/include-header-red.jspf" %>
	
	<!-- 여기는 nav 영역 -->
	<%@ include file="../include/include-nav.jspf" %>
	
	
	<section class="w3-border-top w3-border-bottom w3-border-green w3-margin-top">
		<p>도서정보는 내가 만든 어플
		<p>2019년 1월 24일
		<p>CopyRight &copy; callor@callor.com
	</section>

</body>
</html>



