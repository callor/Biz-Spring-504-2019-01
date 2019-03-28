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
	
	.in-file-box {
		border : 2px solid blue;	
	}
	
	.in-file-box h3 {
		text-align: center;
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
<form:form 
	enctype="multipart/form-data"
	action="${rootPath}/bbs/write_tag"	
	modelAttribute="bbsVO">

	<fieldset>
	<legend>게시판 작성</legend>
	<label  class="in-label" for="b_userid">회원ID</label>
	<div class="in-box-border">
		<form:input class="in-box" readonly="true"
			placeholder="회원ID를 입력하세요"
			id="b_userid" 
			path="b_userid" /><br/>
		<form:errors path="b_userid" class="in-box-error"/>
	</div>
			
	<label class="in-label" for="b_date">작성일자</label>
	<div class="in-box-border">
		<form:input class="in-box"
			id="b_date" 
			path="b_date" /><br/>
		<form:errors path="b_date"  class="in-box-error"/>
	</div>

	<label class="in-label" for="b_time">작성시각</label>
	<div class="in-box-border">
		<form:input class="in-box"
			id="b_time" 
			path="b_time" /><br/>
		<form:errors path="b_time"  class="in-box-error"/>
	</div>

	
	<label  class="in-label" for="b_subject">제목</label>
	<div class="in-box-border">
		<form:input  class="in-box"
			id="b_subject" 
			path="b_subject" /><br/>
		<form:errors path="b_subject" />
	</div>

	<label class="in-label" for="b_content">내용</label>
	<div class="in-box-border">
		<form:textarea type="text" class="in-box"
			id="b_content" 
			path="b_content" rows="5" /><br/>
		<form:errors path="b_content" class="in-box-error"/>			
	</div>
	
	<label class="in-label"></label>
	<input type="file" id="b_file" name="b_file">
	<hr/>
	
	<label class="in-label" for="btn-join"></label>
	<button id="btn-join-1" type="submit">저장</button>
	</fieldset>
</form:form>