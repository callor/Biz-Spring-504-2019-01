<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.star-w {
		width : 205px;
	}
	
	.star-w, .star-r {
		display: inline-block;
		height: 39px;
		background:url( "<c:url value='/images/star.png' />" )no-repeat;
	}
	
	.star-r {
		background-position: left bottom;
		line-height: 0;
		vertical-align: top;
		width:50%;
	}
</style>
<script 
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(function(){
	$("#stars").change(function(){
		let v = $(this).val()
		let w = parseInt(v) * 10
		
		$(".star-r").css("width",w + "%")
				
	})
})

</script>

</head>
<body>
<h3>별점주기</h3>
<div>
	<span class="star-w">
		<span class="star-r"></span>
	</span>
</div>
<p>점수주기 : 
<input type="range" id="stars" min="0" max="10">
<p><input type="date">


</body>
</html>