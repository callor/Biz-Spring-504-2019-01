<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<link rel="stylesheet" 
	href=<c:url value="/css/memo_input_style.css" /> >
	
<style>
	.file_delete{
		cursor: pointer;
	}
</style>	
<script>
$(function(){
	$(".file_delete").click(function(){
		let id = $(this).attr("data-id")
		$.ajax({
			url : "<c:url value='/files' />",
			method : "DELETE",
			data : {id},
			success:function(result) {
				alert(result)
			},
			error:function() {
				alert("서버와 통신 오류")
			}
		})
	})
})

</script>	
<section>
	<!-- 
		form에서 파일을 업로드 하려면
		반드시 enctype=multipart/form-data로 설정해 주어야 한다
	 -->
	<form action=<c:url value="/memo_file"/> 
			enctype="multipart/form-data"
			method="POST">
	
		<input type="hidden" name="id" value=<c:out value="${MEMO.id}" default="0" />  >
		<label for="m_auth">USERID</label>
		<input 
			type="text"  
			value="${LOGIN_INFO.m_userid}" 
			id="m_auth" 
			name="m_auth"><br/>

		<label for="m_auth">작성자</label>
		<input 
			type="text"  
			value="${LOGIN_INFO.m_name}" readonly><br/>
		
		<label for="m_date">작성일자</label>
		<input value="${MEMO.m_date}" type="date" id="m_date" name="m_date"><br/>
		
		<label for="m_subject">제목</label>
		<input value="${MEMO.m_subject}" type="text" id="m_subject" name="m_subject"><br/>
		
		<label for="m_text">메모</label>
		<textarea rows="5" id="m_text" name="m_text">${MEMO.m_text}</textarea><br/>
		
		<label for="m_file">파일</label>
		<input type="file" id="m_file" name="m_file">

		<hr />
		<p><b>첨부파일</b></p>
		<div>
			<c:if test="${not empty MEMO.files}">
				<p>
				<c:forEach items="${MEMO.files}" var="file" varStatus="1">
					${file.file_name} 
					<span class="file_delete" data-id="${file.id}"> 삭제 </span><br/>
				</c:forEach>
			</c:if>
		</div>
		<hr />

		<label></label>
		<button>메모저장</button>
	</form>

</section>