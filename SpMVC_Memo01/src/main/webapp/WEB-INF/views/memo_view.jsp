<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/include/include-head.jspf" %>
<script>
// script 내에서 $(function(){      }) 영역은
// JQuery 영역임을 선언한다.
$(function(){
	var memo_id = "${MEMO.id}"
	var memo_string = "${MEMO.m_subject}" 
	
	$("#btn_update").click(function(){
		location.href="/memo01/memo_update?id=" + memo_id
	})
	
	$("#btn_delete").click(function(){
		if(confirm(memo_string + "를(을) 삭제할까요")) {
			location.href="/memo01/memo_delete?id=" + memo_id
		}
	})
	

	
})

</script>
<style>
	#memo_date {
		font-size:10pt;
		vertical-align: middle;
	}

</style>

</head>
<body>
<%@ include file="/WEB-INF/include/include-header.jspf" %>
<%@ include file="/WEB-INF/include/include-nav.jspf" %>
<section class="w3-border w3-margin-top w3-margin-bottom">
	<article class="w3-topbar w3-bottombar w3-border-green w3-margin-bottom">
		<h3>${MEMO.m_subject} <span id="memo_date">( 작성일자 : ${MEMO.m_date} )</span></h3>
		<p>${MEMO.m_text}</p>
	</article>
	<article>
		<button type="button" id="btn_update" class="w3-button w3-blue">메모수정</button>
		<button type="button" id="btn_delete" class="w3-button w3-red">메모삭제</button>
	</article>
</section>
<%@ include file="/WEB-INF/include/include-footer.jspf" %>
</body>
</html>

