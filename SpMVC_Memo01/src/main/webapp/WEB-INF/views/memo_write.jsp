<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/include/include-head.jspf" %>

<script>
// 자바스크립트 코드를 작성하는 영역
function myfunc() {
	
	// alert("반갑습니다")
	/* 
		document(HTML문서)에서
		id가 m_message로 설정된 tag를 찾아서
		그곳의 문자열을 반갑습니다 로 설정하라
	*/
	document.getElementById("m_message").innerHTML = "반갑습니다"
	
	/*
	   var : JS에서 변수를 선언하는 key word
	   String, int 이런 형들은 없이
	   var, let 라는 keyword로 시작되면 변수 선언문이 된다.
	*/
	var s_auth = document.getElementById("m_auth").value
	if(s_auth == "") {
		alert("작성자 이름은 반드시 입력해야 합니다")
		return false
	}
	
	var s_subject = document.getElementById("m_subject").value
	if(s_subject == "") {
		alert("제목은 반드시 입력해야 합니다")
		document.getElementById("m_subject").focus()
		return false
	}
	
	/*
	 form에 있는 메모저장 button의 click을 무력화 시키고
	 JS 함수를 실행하도록 설정을 변경 했기 때문에
	 form에 입력된 데이터들을 서버로 전송하기 위해
	 마지막에 submit을 강제로 실행 시켜 줘야 한다.
	*/
	document.getElementById("memo_form").submit()
	
}

</script>
</head>
<body>
<%@ include file="/WEB-INF/include/include-header.jspf" %>
<%@ include file="/WEB-INF/include/include-nav.jspf" %>
<section>
	<form action="memo_write" id="memo_form" method="POST">
		<label for="m_auth">작성자</label>
		<input  type="text" 
				id="m_auth" 
				name="m_auth" 
				placeholder="작성자 이름을 입력하세요"
				class="w3-input w3-border w3-hover-light-gray">
		
		<label for="m_date">작성일자</label>
		<input type="text" id="m_date" name="m_date"
				placeholder="작성일자를 입력하세요"
				class="w3-input w3-border w3-hover-light-gray">
		
		<label for="m_subject">제목</label>
		<input type="text" id="m_subject" name="m_subject"
			placeholder="제목을 입력하세요"
				class="w3-input w3-border w3-hover-light-gray">
		
		<label>메모</label>
		<textarea rows="5" id="m_text" name="m_text"
			placeholder="메모 내용을 입력하세요" 
			class="w3-input w3-border w3-hover-light-gray"></textarea>
	
		<button 
			onclick="myfunc()"
			type="button" class="w3-button w3-purple">메모저장</button>
			
		<span id="m_message">메시지영역</span>
	</form>
</section>

</body>
</html>