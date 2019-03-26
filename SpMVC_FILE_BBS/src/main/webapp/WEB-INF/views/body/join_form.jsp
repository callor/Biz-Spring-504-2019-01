<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" 
		prefix="form" %>

<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<style>
	fieldset{
		width:70%;
		margin:20px auto; /* 가로방향 중앙정렬 */
	}
	
	legend {
		font-size:12pt;
		font-weight: bold;
		color : #3d65ff;
	}
	
	.in-label {
		display: inline-block;
		width:20%;
		
		float:left;
		text-align: right;
		margin-right: 5px;
		padding:8px;
	}
	
	.in-box-border {
		display: inline-block;
		width:70%;
	}
	
	.in-box {
		padding:8px;
		margin:3px;
		display: inline-block;
		width:70%;
		border:1px solid #ccc;
	}
	
	.in-box:hover {
		background-color: #ddd;
		border:1px solid blue;
	}
	
	input:invalid {
		background-color: #ffdddd;
		border:2px solid red;
	}
	
	/* span 설정 */
	#userid_error {
		width:70%;
		color:red;
		font-weight: bold;
	}
	
	.userid_label {
		display: none;
	}
	
	.in-box-error {
		display:inline-block;
		margin-left:20px;
		font-size:12px;
		color:red;
	}
	
</style>
<%
/*
 form:form의 modelAttribute 속성
 Controller와 view(*.jsp)파일간에 VO 객체에 담긴
 데이터를 쉽게 교환하기 위한 통로로 설정하는 항목
 command라는 속성으로 사용되고
 form tag 에서는 필수 항목
 
 method 는 HTML tag에서는 기본값이 GET이나
 form:form에서는 기본값이 POST

 */
%>
<form:form modelAttribute="memberVO"
		action="${rootPath}/member/join"
		autocomplete="off">
	<fieldset>
	<c:choose>
		<c:when test="${ACTION == 'UPDATE'}" >
			<legend>회원정보 변경</legend>
			<div class='message'>
				* 회원정보를 변경하려면 비밀번호를 반드시 입력해 주세요
			</div>
		</c:when>
		<c:otherwise>
			<legend>회원가입</legend>	
		</c:otherwise>
	</c:choose>
	
	<%
	/*
		form:input taglib의 input box는 HTML과 사용법이 다소 다르다
		HTML			taglib		주의
		name			path		반드시 modelAttribute의 맴버변수설정
		기타속성		거의 비슷
		required		required="required"
	
	*/
	%>
	<label  class="in-label" for="m_userid">회원ID</label>
	<div class="in-box-border">
		<form:input class="in-box"
			placeholder="회원ID를 입력하세요"
			id="m_userid" 
			path="m_userid" /><br/>
		<form:errors path="m_userid" class="in-box-error"/>
	</div>
			
	<label class="in-label" for="m_password">비밀번호</label>
	<div class="in-box-border">
		<form:password  class="in-box"
			id="m_password" 
			path="m_password" /><br/>
		<form:errors path="m_password"  class="in-box-error"/>
	</div>
	
	<label  class="in-label" for="m_re_password">비밀번호확인</label>
	<div class="in-box-border">
		<form:password  class="in-box"
			id="m_re_password" 
			path="m_re_password" /><br/>
		<form:errors path="m_re_password" class="in-box-error"/>
	</div>
	
	<label class="in-label" for="m_name">이름</label>
	<div class="in-box-border">
		<form:input type="text"  class="in-box"
			id="m_name" 
			path="m_name" /><br/>
		<form:errors path="m_name"  class="in-box-error"/>
	</div>
	
	<label class="in-label" for="m_tel">전화번호</label>
	<div class="in-box-border">
		<form:input type="text" class="in-box"
			id="m_tel" 
			path="m_tel" /><br/>
		<form:errors path="m_tel" class="in-box-error"/>			
	</div>
		
	<label class="in-label" for="btn-join"></label>
	<button id="btn-join-1" type="submit">회원가입</button>
	</fieldset>
</form:form>