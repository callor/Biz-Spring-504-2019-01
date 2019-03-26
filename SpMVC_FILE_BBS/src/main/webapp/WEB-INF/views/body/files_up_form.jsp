<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
.drag_area {
	width: 70%;
	height: 200px;
	border: 1px solid blue;
	margin: 0 auto;
	text-align: center;
}

.drag_area:hover {
	cursor: pointer;
	background-color: #ccc;
}

#img-container {
	display: flex;
}

#images {
	flex : 0 0 auto;
	margin : 5px auto;
	
	display: flex;
	align-items: center;
	justify-content: center;
	
	border:1px solid blue;
}

.img-box {
	flex : 0 0  100px;
	height: 100px;
	margin:10px;
	border-radius: 6px;
}

h2 {
	text-align: center;
}

</style>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(function() {

		$(".drag_area").on("dragover", function(e) {
			$('h3').text('파일을 내려 놓으세요')
			return false // 코드진행을 중단.
		})

		// drop event가 발생을 하면
		// 즉, 파일을 끌어서 drag_area box에 놓으면
		// drop event가 발생을 하고
		// 끌어 놓은 파일에 대한 정보가 e 매개 변수에 담기게 된다.
		$('.drag_area').on('drop', function(e) {
			$('h3').text('파일을 등록하는중')

			let files = e.originalEvent.dataTransfer.files

			// ajax로 전송하기 위해 formData 객체를 생성
			let fData = new FormData();

			// fData에 파일 정보를 추가
			// file : Controller에서 사용할 변수 이름
			// fData.append('file', files[0]) // 1개의 파일만 추출
			for(let i = 0 ; i < files.length; i++) {
				fData.append('files',files[i])				
			}

			$.ajax({
				url : "<c:url value='/file/files' />",
				method:"POST",
				data:fData,
				dataType:"JSON",
				processData:false,
				contentType:false,
				success:function(result) {
					// JSON형태로 수신한 문자열을 이용해서
					// HTML 코드를 생성한 후 본문에 그려보자
					if(result == null) {
						$("h3").text("파일 업로드 오류")
					} else {
						for(let i = 0 ; i < result.length ; i++ ) {
							 // 특정한 영역에 문자열이나 html코드를 추기하는
							$('#images').append(
									$('<img/>',{
										src : "<c:url value='/files/' />" + result[i] ,
										class : 'img-box'
									})
							)
						} // for end
						$('h3').text('파일 업로드 성공')
					}
				}
				,error:function() {
					alert('서버와 통신 오류')
				}
			})
			return false;
		})
	})
</script>

</head>
<body>
<h2>다중 파일 Drag and Drop</h2>
<article>
	<div class="drag_area">
		<h3>업로드할 파일들을 드래그</h3>
	</div>
</article>
<article id="img-container">
	<div id="images">
	</div>
</article>
</body>
</html>