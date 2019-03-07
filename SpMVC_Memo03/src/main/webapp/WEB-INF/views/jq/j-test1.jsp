<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Insert title here</title>
<script 
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
var a = 30

// 이곳에서 body tag 에 바탕색을 red로 설정하는
// js 코드를 작성을 한다면 js 코드는 문법 오류를 낼것이다.
// 그리고, 이후의 js 코드는 모두 무시해 버린다.
// 그래서 표준 js 코드에서는 tag에 어떤 속성을 변경하는 코드는
// 문서 끝의 body, html이 끝난 이후에 작성을 한다.
// document.getElementById("body")
// .setAttribute("backgroundColor","#FF0000")

// 이러한 불편때문에
// JQuery는 document.ready 라는 키워드를 만들었다
// document.ready(function(){}) 문법은
// 현재 문서의 html 이 모두 완성된 다음에
// function으로 지정된 영역의 코드를 실행하라
// 하는 것입니다.
// 최초의 코드 : JQuery(document.ready(function(){}))
$(document).ready(function(){
})

$(function(){
	// $(".q").on("click1",function(){ })
	// $(".q").bind("click",function() { })
	$(".q, .b, .c").click(function(){
		let num = $(this).attr("data-num")
		let id = $(this).attr("id") 
		// alert(num)
		// $("#as" + num).css("display","block")
		$("#as" + num).toggleClass("block")
	})
})
</script>

</head>
<body id="body">
	<header>
		<nav>
		</nav>
	</header>
	<style>
		.q {
			background-color: yellow;
			color : black;
			font-size:30px;
			margin:10px;
		}

		.as {
			background-color: white;
			color : black;
			font-size:30px;
			margin:10px;
			display: none;
		}
		
		.block {
			display: block;
		}
	</style>
	<section>
		<article>
			<div class="q" id="q1" data-num="1">DIV 1</div>
			<p class="as" id="as1">P1 Korea </p>

			<div class="q" id="q2" data-num="2">DIV 2</div>
			<p class="as" id="as2">P2 대한민국</p>

			<div class="q" id="q3" data-num="3">DIV 3</div>
			<p class="as" id="as3">P3 우리나라</p>
		</article>
	</section>
	<footer>
	</footer>
</body>
<script>

document.getElementById("body")
// .setAttribute("background-color","red")
.style.backgroundColor = "blue"

</script>
</html>