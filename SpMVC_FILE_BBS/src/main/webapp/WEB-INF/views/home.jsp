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
	background-color: #F35B66;
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
		<c:if test="${BODY == 'JOIN_FORM'}" >
			<%@ include file="/WEB-INF/views/body/join_form.jsp" %>
		</c:if>
		<c:if test="${BODY == 'FILE_UP'}" >
			<%@ include file="/WEB-INF/views/body/file_up_form.jsp" %>
		</c:if>
		<c:if test="${BODY == 'FILES_UP'}" >
			<%@ include file="/WEB-INF/views/body/files_up_form.jsp" %>
		</c:if>
		<c:if test="${BODY == 'LOGIN_FORM'}" >
			<%@ include file="/WEB-INF/views/body/login_form2.jsp" %>
		</c:if>
		<c:if test="${BODY == 'BBS_WRITE'}" >
			<%@ include file="/WEB-INF/views/body/bbs_form.jsp" %>
		</c:if>
		<c:if test="${BODY == 'BBS_LIST'}" >
			<%@ include file="/WEB-INF/views/body/bbs_list.jsp" %>
		</c:if>
		<c:if test="${BODY == 'BBS_VIEW'}" >
			<%@ include file="/WEB-INF/views/body/bbs_view.jsp" %>
		</c:if>



	</article>
</section>
</body>
</html>