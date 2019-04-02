<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<style>
.view-box {
	width:70%;
	border:1px solid blue;
	padding:.5rem;
	margin: 10px auto;
}

b {
	color:blue;
}

</style>

<article class="view-box">
	<p><b>작성자 ID: </b> ${bbsVO.b_userid}
	<p><b>작성일자: </b> ${bbsVO.b_date }
	<p><b>작성시각: </b> ${bbsVO.b_time}
	<p><b>제목: </b> ${bbsVO.b_subject}
	<p><b>내용: </b> ${bbsVO.b_content}
	
	<p><button id="btn-update">편집</button>
	<button id="btn-delete">삭제</button>
</article>
<script>
$(function(){
	$("#btn-update").click(function(){
			location.replace("<c:url value='/update' />"
								+"?id=" + ${bbsVO.id}) 
	})

	$("#btn-delete").click(function(){
		if(confirm("정말 삭제할까요")) {
			// 게시물을 보는 과정에 삭제를 시도하고
			// 삭제를 한 경우
			// 뒤로가 버튼을 눌러
			// 기존 게시물을 보는것을 막기 위해
			// replace를 사용한다.
			location.replace("<c:url value='/delete' />" 
							+ "?id=" + ${bbsVO.id})
		}		
	})
})
</script>

