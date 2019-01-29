<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/include/include-head.jspf" %>
<script>
$(function(){
	
	$("#btn_save").click(function(){
		
		var auth = $("#m_auth").val();
		var subject = $("#m_subject").val();
		
		if(auth == "") {
			alert("작성자 이름은 반드시 입력해야 합니다")
			$("#m_auth").focus()
			return false;
		}
		
		if(subject == "") {
			alert("제목은 반드시 입력해야 합니다")
			$("#m_subject").focus()
			return
		}
		$("form").submit();
		
	})
	
	$("#btn_save").on("click",function(){
		
	})
	
	
	
})	
</script>
</head>
<body>
<%@ include file="/WEB-INF/include/include-header.jspf" %>
<%@ include file="/WEB-INF/include/include-nav.jspf" %>
<section>
	<form action="memo_write" id="memo_form" method="POST">
		
		<input type="hidden" id="id" name="id" value="${MEMO.id}">
		
		<label for="m_auth">작성자</label>
		<input  type="text" 
				id="m_auth" 
				name="m_auth"
				value="${MEMO.m_auth}" 
				placeholder="작성자 이름을 입력하세요"
				class="w3-input w3-border w3-hover-light-gray">
		
		<label for="m_date">작성일자</label>
		<input type="date" id="m_date" name="m_date"
				value="${MEMO.m_date}"
				placeholder="작성일자를 입력하세요"
				class="w3-input w3-border w3-hover-light-gray">
		
		<label for="m_subject">제목</label>
		<input type="text" id="m_subject" name="m_subject"
				value="${MEMO.m_subject}"
			placeholder="제목을 입력하세요"
				class="w3-input w3-border w3-hover-light-gray">
		
		<label>메모</label>
		<textarea rows="5" id="m_text" name="m_text"
			placeholder="메모 내용을 입력하세요" 
			class="w3-input w3-border w3-hover-light-gray">${MEMO.m_text}</textarea>
	
		<button id="btn_save" 
			type="button" class="w3-button w3-purple">메모저장</button>
			
		<span id="m_message">메시지영역</span>
	</form>
</section>

</body>
</html>