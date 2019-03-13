<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<link rel="stylesheet" 
	href=<c:url value="/css/memo_input_style.css" /> >
	
<script>
$(function(){
	$(".file_delete").click(function(){
		
		// tbl_files 의 PK 값
		let id = $(this).attr("data-id")
		if(id == 0) {
			alert("삭제할 그림이 없습니다")
			return false
		}

		// 삭제여부 확인에서 취소를 클릭하면
		// 진행 중단
		if(!confirm("첨부 파일을 삭제할까요?")) {
			return false
		}
		
		$.ajax({
			url : "<c:url value='/files' />",
			method : "DELETE",
			data : {id},
			success:function(result) {

				if(result == 'FAIL') {
					alert("첨부파일 삭제 실패")
					return false;
				}
				
				let pid = $("#id").val()
				$.ajax({
					url : "<c:url value='/memo_view' />",
					method:"GET",
					data : {id:pid},
					success:function(result) {
						$("#body").html(result)
					}
				})
			
			},
			error:function() {
				alert("서버와 통신 오류")
			}
		})
	}) // end file_delete
	
	$("#btn-write").click(function(){
		
		// ajax로 file과 memoVO를 한꺼번에 서버에 전송하기
		// 1 js 에 내장된 FormData 클래스를 사용한다.
		// 2. jquery가 내부적으로 form을 배열로 관리하고 있는데
		//   현재 작성중인 form만 추출하기 위해서
		//   배열의 0번째 라는 것을 반드시 명시를 해야한다.
		let form = $('form')[0]
		
		// 2. form 문서를 FormData라는 객체 형식으로 일단
		// 		변환을 시킨다.
		let fData = new FormData(form)
		// memoVO 각 요소들이 포함이 되어 있는 상태
		// 그런데 fData에는 input type=file은 기본적으로
		//	포함이 되지 않는다.
		// 3. fData 객체에 임의로 input type=file 항목을
		//	추가를 해줘야 한다.
		// m_file 이라는 이름으로(서버의 매개변수 이름)
		// input type=file 요소를 추가 하는 코드
		fData.append('m_file',$("#m_file")[0].files[0])
		
		$.ajax({
			url : "<c:url value='/memo_file' />",
			method:"POST",
			data:fData,
			processData:false,	// 데이터 별다른 처리 하지 말고
			contentType:false,	// contentType도 지정하지 말라,
			success:function(result){
				$.ajax({
					url : "<c:url value='/memo_list2' />",
					method:"GET",
					success:function(result){
						$("#body").html(result)
					}
				})
			},
			error:function(){
				alert("서버와 통신 오류 발생")
			}
		})
		
	}) // end btn-write
	$("#btn-delete").click(function(){
		let id = $("#id").val()
		if(id == '0'){
			alert("삭제할 메모가 없습니다")
			return false
		}
		
		if(!confirm("정말 메모를 삭제 할까요")) {
			 return false;
		}
		
		$.ajax({
			url : "<c:url value='/memo_delete' />",
			method:"GET",
			data:{id},
			success:function(result){
				$.ajax({
					url : "<c:url value='/memo_list2' />",
					method:"GET",
					success:function(result){
						$("#body").html(result)
					}
				})
			},
			error:function(){
				alert("서버와 통신 오류 발생")
			}
		})
		
		
	})
})

</script>	
<style>
	.file_delete{
		cursor: pointer;
		
		display: inline-block;
		width:100px;
		background-color: orange;
		color:white;
		text-align: center;
		border-radius: 6px;
		padding:5px 0;
		margin-left:10px;
	}
	.file_delete:hover{
		background-color: red;
	}
	
	.image_file {
		-webkit-transform:scale(1); /* 크롬 구버전 호환 */
		-moz-transform:scale(1); /* 파이어폭스 구버전 */
		-ms-transform:scale(1); /* ie */
		-o-transform:scale(1); /* opera */
		transform:scale(1); /* width 나 height로 설정된 상태로 유지 */
		
		-webkit-transition:all 0.3s ease-in-out;
		-moz-transition:all 0.3s ease-in-out;
		-ms-transition:all 0.3s ease-in-out;
		-o-transition:all 0.3s ease-in-out;
		transition:all 0.3s ease-in-out;
		/* ease-in-out : 보간법이라는 scale 변화 규칙에 따라 크기를 변화 */
	}
	
	.image_file:hover {
		-webkit-transform:scale(3); /* 크롬 구버전 호환 */
		-moz-transform:scale(3); /* 파이어폭스 구버전 */
		-ms-transform:scale(3); /* ie */
		-o-transform:scale(3); /* opera */
		transform:scale(3); /* width 나 height를 3배로 확대 */
	}
	
	#btn-delete{
		background-color: red;
	}
	
	#btn-delete:hover {
		background-color: orange;
	}
	
</style>	
<section>
	<!-- 
		form에서 파일을 업로드 하려면
		반드시 enctype=multipart/form-data로 설정해 주어야 한다
	 -->
	<form action=<c:url value="/memo_file"/> 
			enctype="multipart/form-data"
			method="POST">
	
		<input type="hidden" 
			name="id" 
			id="id"
			value=<c:out value="${MEMO.id}" default="0" />  >
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
		<%
		/*
			input type=file 에서 accept 속성
			미 지정 하면 : 모든파일(*.*) 선택
			image/* : 이미지와 관련 파일들만 선택
			audio/* : 오디오(음성파일)과 관련된 파일들만 선택
			video/* : 동영상과 관련된 파일들만 선택
			
			그와 파일 제한
			".jpg" ".png" : 확장자가 jpg png인 파일만
			".jpg, .png" : 확장자가 jpg 이거나 png 인 파일만
			".jpg, .png, .gif" : 
					확장자가 jpg 이거나 png 이거나 gif 인 파일
			
			※ IE 10 미만에서는 사용불가
		*/
		%>
		<input type="file" 
				accept="image/*"
				id="m_file" name="m_file">

		<hr />
		<label></label>
		<p><b>첨부파일</b></p>
		<div>
			<c:if test="${not empty MEMO.files}">
				<label></label>
				<p>
				<c:forEach items="${MEMO.files}" var="file" varStatus="1">
					<a href="<c:url value='/files/${file.save_file_name}' />" 
						target="_new">
					   <img class="image_file" 
						 src="<c:url value='/files/${file.save_file_name}' />"  
						 width="50px">
					</a> 
					${file.file_name}
					<span class="file_delete" 
						title="${file.file_name} 파일을 삭제합니다"
						data-id="${file.id}"> 삭제 </span>&nbsp;&nbsp;&nbsp;&nbsp;
				</c:forEach>
			</c:if>
		</div>
		<hr />

		<label></label>
		<button id="btn-write" type="button">메모저장</button>
		<button id="btn-delete" type="button">메모삭제</button>
	</form>
</section>