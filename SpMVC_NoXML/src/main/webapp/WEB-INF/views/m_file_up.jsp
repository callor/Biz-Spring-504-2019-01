<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Insert title here</title>

<style>

* {
	box-sizing: border-box;
}
body {
	margin:0px;
	padding:0px;
}

header {
	position: fixed;
	top:0;
	width:100%;
	padding:20px;
	background-color: #f5b335;
}
nav {
	display: flex;
	align-items: flex-end;
	justify-content: space-between;
	transition:align-items 0.2s;
}
.logo {
	font-size:2rem; /* rem = em단위와 유사, em 단위를 사용하지 말자 */
	display: inline-block;
	padding:20px 30px;
	background-color: #F35B66;
	color:#fff;
	margin:50px 0 0 50px;
	transition: all 0.2s;
}

ul {
	display: flex;
	margin:50px 50px 0 0;
	padding:0;
	list-style-type : none;
}

li a {
	display: block;
	padding: 10px 20px;
	text-decoration: none;
	color:black;
}

li a:hover {
	background-color: #ddd;
}

.main {
	display: block;
	padding:0 20px;
	
}


.scroll {
	box-shadow : 0 7px 0 0 rgba(0,0,0,0.1);
}

.scroll .logo {
	padding:10px 20px;
	font-size:1.5rem;
}


.scroll nav {
	align-items: center;
}

.scroll .logo,
.scroll ul {
	margin:0px;
}
	.drag_area {
		width:70%;
		height: 200px;
		border:1px solid blue;
		margin:0 auto;
		text-align: center;
	}
	
	.drag_area:hover {
		cursor:pointer;
		background-color: #ccc;
	}
	
	#m_file {
	 	display: none;
	}

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(function(){

	var hHeight = $("header").height()
	$(".main").css("padding-top",hHeight + 100)
	
	
	/*
		drag and drop 을 구현해서
		파일 끌어놓기로 서버 업로드 실행한다.
	*/
	$('.drag_area').on('dragover', function(e){
		$('h3').text('내려 놓으세요')
		return false
	})
	
	// drop event의 핸들러 function에 매개변수(e)를 지정하고
	// e 변수에서 drag and drop된 파일의 정보를 추출하여
	// 서버로 전송한다.
	$('.drag_area').on('drop',function(e){
		$('h3').text('파일 올리는 중....')
		
		// drop 된 파일들에 대한 정보를 추출
		let file = e.originalEvent.dataTransfer.files
		
		// 서버로 전송하기 위해서 FormData를 생성
		let fData = new FormData()
		
		// FormData에 파일정보를 추가
		fData.append('file',file[0])
		
		$.ajax({
			url : "<c:url value='/file_up' />",
			method : "POST",
			data:fData,
			processData : false,
			contentType:false,
			success:function(result) {
				if(result == 'FAIL') alert('파일 업로드 오류')
				else {
					let h = "<img src=" 
						+ "<c:url value='/files/' />" + result + ">"
					$("#images").html(h)
				}
			},
			error:function(){
				alert("서버와 통신 오류!!")
			}
		})
		return false
	})

	$("#btn-up").click(function(){
	
		let form = $("form")[0]
		let fData = new FormData(form)
		$.ajax({
			url : "<c:url value='/files_up' />",
			method:"POST",
			data:fData,
			contentType:false,
			processData:false,
			success:function(result){
				alert(result)
			},
			error:function() {
				alert("오류")
			}
		})
		
		
	})
	

})
</script>
</head>
<body>
<%@ include file="/WEB-INF/views/include/main_menu.jspf" %>
<section class="main">
	<article id="body">
	<form enctype="multipart/form-data">
		<input type='file' name="files" multiple>
		<button type="button" id="btn-up">전송</button>

	</form>
	</article>
	<article id="images">
	
	</article>
</section>
</body>
</html>