<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>매입매출 관리 시스템</title>
<link href="${rootPath}/css/list.css?ver=1" rel="stylesheet">  
<link href="${rootPath}/css/write.css?ver=3" rel="stylesheet">
<style>

* {
	box-sizing: border-box;
}
body {
	margin:0px;
	padding:0px;
}

header {
	position: fixed;
	top:0;
	width:100%;
	padding:20px;
	background-color: #f5b335;
}
nav {
	display: flex;
	align-items: flex-end;
	justify-content: space-between;
	transition:align-items 0.2s;
}
.logo {
	font-size:2rem; /* rem = em단위와 유사, em 단위를 사용하지 말자 */
	display: inline-block;
	padding:20px 30px;
	/* background-color: #F35B66; */
	color:#fff;
	margin:50px 0 0 50px;
	transition: all 0.2s;
}

ul {
	display: flex;
	margin:50px 50px 0 0;
	padding:0;
	list-style-type : none;
}

li a {
	display: block;
	padding: 10px 20px;
	text-decoration: none;
	color:black;
}

li a:hover {
	background-color: #ddd;
}

.main {
	display: block;
	padding:0 20px;
	
}


.scroll {
	box-shadow : 0 7px 0 0 rgba(0,0,0,0.1);
}

.scroll .logo {
	padding:10px 20px;
	font-size:1.5rem;
}


.scroll nav {
	align-items: center;
}

.scroll .logo,
.scroll ul {
	margin:0px;
}

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script>
$(function(){
	
	// header tag의 높이를 알려주는 함수
	var hHeight = $("header").outerHeight()
	$(".main").css("padding-top",hHeight)
	
	// mouse 휠이 상하 방향으로 스크롤 될때
	$(window).scroll(function(e){
		// 아랫방향으로 스크롤 하면
		// header tag scroll 이라는 클래스를 적용시키고
		if( $(window).scrollTop() > 150) {
			$("header").addClass("scroll")
			
		// 위쪽방향으로 스크롤하면
		// header tag scroll 클래스를 제거해서
		// 원래 모양대로 되돌아 가도록 한다.
		} else {
			$("header").removeClass("scroll")
		}
	})
	

})
</script>
</head>
<body>
<%@ include file="/WEB-INF/views/include/main_menu.jspf" %>
<section class="main">
	<article id="body">
	<c:choose>
		<c:when test="${BODY == 'IO_LIST'}">
			<h3>매입매출 리스트</h3>
			<%@ include file="/WEB-INF/views/body/iolist/io_list.jspf" %>
		</c:when>
		<c:when test="${BODY == 'P_LIST'}">
			<h3>상품정보 리스트</h3>
			<%@ include file="/WEB-INF/views/body/product/p_list.jspf" %>
		</c:when>
		<c:when test="${BODY == 'D_LIST'}">
			<h3>거래처정보 리스트</h3>
			<%@ include file="/WEB-INF/views/body/dept/d_list.jspf" %>
		</c:when>

		<c:when test="${BODY == 'IO_WRITE'}">
			<%@ include file="/WEB-INF/views/body/iolist/io_write.jspf" %>
		</c:when>
		<c:when test="${BODY == 'P_WRITE'}">
			<%@ include file="/WEB-INF/views/body/product/p_write.jspf" %>
		</c:when>
		<c:when test="${BODY == 'D_WRITE'}">
			<%@ include file="/WEB-INF/views/body/dept/d_write.jspf" %>
		</c:when>
		
		<c:otherwise>
			<%@ include file="/WEB-INF/views/body/dumy_view.jsp" %>
		</c:otherwise>
	</c:choose>
	</article>
</section>
</body>
</html>