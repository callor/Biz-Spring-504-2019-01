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
	#bbs_view {
		border : 1px solid blue;
	}
	.bbs_box {
		width:70%;
		margin:10px auto;
	}
</style>
<body>
	<article id="bbs_view" class="bbs_box">
		<h3>${bbsVO.b_subject}</h3>
		<p>작성일자 : ${bbsVO.b_date}<p>
		<p>작성시각 : ${bbsVO.b_time}<p>
		<p>내용 : ${bbsVO.b_content}<p>
		<p><img src="${pageContext.request.contextPath}/files/${bbsVO.b_image}">
	</article>
	<c:if test="${bbsVO.b_userid == login_info.m_userid}" >
		<div class="bbs_box">
			<button type="button" id="bbs_update">편집</button>
			<button type="button" id="bbs_delete">삭제</button>
		</div>	
	</c:if>
</body>
</html>
<script>
$(function(){
	$("#bbs_update").click(function(){
		let id = ${bbsVO.id}
		location.href = "<c:url value='/bbs/update' />" + "?id=" + id
	})
	$("#bbs_delete").click(function(){
		let id = ${bbsVO.id}
		if(confirm("게시물을 삭제할까요?")) {
			location.href = "<c:url value='/bbs/delete' />" + "?id=" + id
		}
		
	})
})

</script>

