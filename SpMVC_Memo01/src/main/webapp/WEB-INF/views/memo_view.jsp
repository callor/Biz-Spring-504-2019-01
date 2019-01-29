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
	
	$(".memoRow").click(function(){
		var memo_id = $(this).attr("data-memo-id")
		alert("클릭한 메모의 PK = " + memo_id)
		location.href="/memo01/memo_view?id=" + memo_id
		
	})
	
})

</script>


</head>
<body>
<%@ include file="/WEB-INF/include/include-header.jspf" %>
<%@ include file="/WEB-INF/include/include-nav.jspf" %>
<section class="w3-border w3-margin-top w3-margin-bottom">
	<article class="w3-topbar w3-bottombar w3-border-green w3-margin-bottom">
		<h3>${MEMO.m_subject}</h3>
		<p>${MEMO.m_text}</p>
	</article>
	<article>
		<button type="button" class="w3-button w3-blue">메모수정</button>
		<button type="button" class="w3-button w3-red">메모삭제</button>
	</article>
</section>
<%@ include file="/WEB-INF/include/include-footer.jspf" %>
</body>
</html>

