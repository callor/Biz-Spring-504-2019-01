<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib 
	uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %>    
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
	$("#btn-join").click(function(){
		let m_userid = $("#m_userid").val()
		let m_password = $("#m_password").val()
		let m_re_password = $("#m_re_password").val()
		if(m_userid == "") {
			alert("id(email)을 반드시 입력하세요")
			$("#m_userid").focus();
			return false;
		}
		if(m_password == "") {
			alert("비밀번호를 반드시 입력하세요")
			$("#m_password").focus()
			return false;
		}
		if(m_re_password == "") {
			alert("비밀번호를 한번더 입력하세요")
			$("#m_re_password").focus()
			return false;
		}
		if(m_password != m_re_password) {
			alert("비밀번호와 확인이 일치하지 않습니다")
			$("#m_password").val("")
			$("#m_re_password").val("")
			$("#m_password").focus()
			return false;
		}
		$("form").submit()
	})
	
	// input box에서 tab를 입력하거나
	// 다른 부분에 마우스를 클릭 했을때
	// 이벤트를 발생
	$("#m_userid").blur(function(event){
		
		event.preventDefault()
		
		let userid= $("#m_userid").val()

		if(userid == "") {
			// alert("아이디는 반드시 입력하세요")
			$("#userid_error").text("* 아이디를 입력하세요")
			// userid_label 클래스의 css 속성중에
			// display를 inline-block 설정하라
			
			// attr('display','inline-block')
			// prop('display','inline-block')
			// css('display','inline-block')
			$(".userid_label").css("display","inline-block")
			return false;
		}
		
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
<form action="<c:url value='/join' />" 
		method="POST"
		 autocomplete="off">

	<fieldset>
	<legend>회원가입</legend>
	<label  class="in-label" for="m_userid">회원ID</label>
	<input type="text" class="in-box" required
			placeholder="회원ID를 입력하세요"
			id="m_userid" name="m_userid"><br/>
			
	<label class="in-label userid_label"></label>
	<span id="userid_error" class="userid_label"></span>
			
	<label class="in-label" for="m_password">비밀번호</label>
	<input type="password" class="in-box"
			id="m_password" name="m_password"><br/>
			
	<label  class="in-label" for="m_re_password">비밀번호확인</label>
	<input type="password" class="in-box"
			id="m_re_password" name="m_re_password"><br/>
	
	<label class="in-label" for="m_name">이름</label>
	<input type="text"  class="in-box"
			id="m_name" name="m_name"><br/>
	
	<label class="in-label" for="m_tel">전화번호</label>
	<input type="text" class="in-box"
			id="m_tel" name="m_tel"><br/>
	
	<label class="in-label" for="btn-join"></label>
	<button id="btn-join" type="button">회원가입</button>
	</fieldset>
</form>