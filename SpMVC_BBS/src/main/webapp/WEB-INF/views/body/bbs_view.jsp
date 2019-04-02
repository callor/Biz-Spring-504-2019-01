<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<style>
.view-box {
	width:70%;
	boder:1px solid blue;
	padding:.5rem;
	margin: 10px auto;
}

b {
	color:blue;
}

</style>

<article class="view-box">
	<p><b>작성자 ID: </b> ${BBS.b_userid}
	<p><b>작성일자: </b> ${BBS.b_date }
	<p><b>작성시각: </b> ${BBS.b_time}
	<p><b>제목: </b> ${BBS.b_subject}
	<p><b>내용: </b> ${BBS.b_content}
</article>
