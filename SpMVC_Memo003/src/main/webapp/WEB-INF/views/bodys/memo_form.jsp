<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<link rel="stylesheet" 
	href=<c:url value="/css/memo_input_style.css" /> >
<section>
	<form action=<c:url value="/memo"/> method="POST">
	
		<input type="hidden" name="id" value=<c:out value="${MEMO.id}" default="0" />  >
		<label for="m_auth">작성자</label>
		<input value="${MEMO.m_auth}" type="text" id="m_auth" name="m_auth"><br/>
		
		<label for="m_date">작성일자</label>
		<input value="${MEMO.m_date}" type="date" id="m_date" name="m_date"><br/>
		
		<label for="m_subject">제목</label>
		<input value="${MEMO.m_subject}" type="text" id="m_subject" name="m_subject"><br/>
		
		<label for="m_text">메모</label>
		<textarea rows="5" id="m_text" name="m_text">${MEMO.m_text}</textarea><br/>
		
		<hr />
		<label></label>
		<button>메모저장</button>
	</form>
</section>