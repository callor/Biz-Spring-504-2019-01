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
	<%@ include file="../include/include-header-blue.jspf" %>
	
	<%@ include file="../include/include-nav.jspf" %>

	<section class="w3-border-top w3-border-bottom w3-border-green w3-margin-top">
		<div class="w3-yellow w3-padding">
			<p>w3-padding
		</div>
		<div class="w3-blue w3-padding-16">
			<p>w3-padding-16
		</div>
		<div class="w3-green w3-padding-24">
			<p>w3-padding-24
		</div>
		<div class="w3-gray w3-padding-32">
			<p>w3-padding-32
		</div>
		<div class="w3-yellow w3-padding w3-padding-16">
			<p>w3-padding와 w3-padding-16
		</div>
		
		


	</section>

</body>
</html>



