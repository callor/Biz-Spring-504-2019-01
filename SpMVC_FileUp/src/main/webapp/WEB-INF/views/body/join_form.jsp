<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
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

</style>

<script>
$(function(){
		$.ajax({
			
			url : "<c:url value='id_check' />",
			method:"POST",
			data : {m_userid:userid},
			success:function(result) {
				$("#userid_error").html(result)
				$(".userid_label").css("display","inline-block")
			},
			error:function(){
				alert("서버오류")
			}
		})
	})
})
</script>	
<form:form action="<c:url value='/join' />" 
		method="POST" 
		modelAttribute="memberVO"
		autocomplete="off">

	<fieldset>
	<legend>회원가입</legend>
	<label  class="in-label" for="m_userid">회원ID</label>
	<form:input class="in-box" required
			placeholder="회원ID를 입력하세요"
			id="m_userid" 
			path="m_userid" /><br/>
			
	<label class="in-label" for="m_password">비밀번호</label>
	<form:password class="in-box"
			id="m_password" 
			path="m_password" /><br/>
			
	<label  class="in-label" for="m_re_password">비밀번호확인</label>
	<form:password type="password" class="in-box"
			id="m_re_password" 
			path="m_re_password" /><br/>
	
	<label class="in-label" for="m_name">이름</label>
	<form:input type="text"  class="in-box"
			id="m_name" 
			path="m_name" /><br/>
	
	<label class="in-label" for="m_tel">전화번호</label>
	<form:input type="text" class="in-box"
			id="m_tel" 
			path="m_tel" /><br/>
	
	<label class="in-label" for="btn-join"></label>
	<button id="btn-join" type="button">회원가입</button>
	</fieldset>
</form:form>