<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<%@ include file="/WEB-INF/views/include/include_head.jspf" %>
<style>
	fieldset{
		width:70%;
		margin:20px auto; /* 가로방향 중앙정렬 */
		display: flex;
		flex-direction: column;
		padding:1em;
	}
	
	legend {
		font-size:12pt;
		font-weight: bold;
		color : #3d65ff;
	}

	div {
		display: flex;
	}

	label {
		
		display:inline-block;
		width:20%;
		text-align: right;
		margin-right: 5px;
		padding:8px;
	}
	
	input,textarea{
		display:inline-block;
		width:70%;
		padding:8px;
		margin:3px;
	}
	


	
	.btn.blue {
		background-color: blue;
	}

	.btn.green {
		background-color: green;
	}
	
	.btn.orange {
		background-color: orange;
	}

	.btn:hover {
		background-color: #ddd;
	}

</style>
<script>
$(function(){
	$("#mail_list").click(function(){
		location.replace("<c:url value='/' />")	
	})
	
})

</script>
<body>
<header>
	<h3>Email 관리 시스템</h3>
</header>	
<section>
	<article>
		<form:form modelAttribute="mailVO" id="mail_form">
			<fieldset>
				<legend>Email 작성</legend>
				<div>
					<label for="from_email">보내는 Email</label>
					<form:input type="text" id="from_email" path="from_email"/>
				</div>
				<div>
					<label for="to_email">받는 Email</label>
					<form:input type="text" id="to_email" path="to_email"/>
				</div>
				<div>
					<label for="s_subject">메일 제목</label>
					<form:input type="text" id="s_subject" path="s_subject"/>
				</div>
				<div>
					<label for="s_content"></label>
					<form:textarea rows="10" id="s_content" path="s_content"/>
				</div>
				<div>
					<label for="files"></label>
					<input type="file" name="files" id="files" multiple="multiple">
				</div>
			<div>
				<label for="mail_save"></label>
				<button type="submit" id="mail_save" class="btn blue">메일 저장</button>
				<button type="button"  id="mail_send" class="btn green">메일 보내기</button>
				<button type="button"  id="mail_list" class="btn orange">목록으로</button>
			</div>

			</fieldset>

		</form:form>	
	</article>
</section>
</body>
