<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(function(){
	$(".my-card").click(function(){
		let id = $(this).attr("data-id")
		$.ajax ({
			url : "<c:url value='/memo_view' />",
			method : "GET",
			data : {id},
			success:function(result){
				$("#body").html(result)
			}
		})
	})
	
	$("#btn_memo").click(function(){
		$.ajax({
			url : "<c:url value='/memo' />",
			method : "GET",
			success:function(result){
				$("#body").html(result)
			}
		})
	})
})
</script>
<style>
section {
	display: flex;
	flex-wrap: wrap; /* flex box들이 가로방향으로 채워지면 줄바꿈 */
}

.my-card {

	flex : 0 0 300px;
	height: 332px;
	margin:20px;
	padding-top:16px;
	padding-bottom:16px;
	box-shadow: 0 4px 10px 0 rgba(0,0,0,0.2),
				0 4px 20px 0 rgba(0,0,0,0.9);
				
	overflow: auto;
	
	display: flex;
	flex-direction:column;
	align-items: center;
	justify-content: center;

}
</style>
</head>
<body>
<section>
<c:if test="${not empty MEMOS }">
	<c:forEach items="${MEMOS}" var="memo" varStatus="i">
		<c:if test="${not empty memo.files}">
			<c:forEach items="${memo.files}" var="file" >
				<div class="my-card" data-id="${memo.id}">
					<img width="200px" hegth="200px"
					src="<c:url value='/files/${file.save_file_name}' />" >
					<p>${memo.m_date}</p>
					<p>${memo.m_subject}</p>
					<p>${memo.m_text}</p>
				</div>
			</c:forEach>
		</c:if>
		<c:if test="${empty memo.files}">
			<div class="my-card"  data-id="${memo.id}">
				<h3>${memo.m_subject}</h3>
				<p>${memo.m_date}</p>
				<p>${memo.m_text}</p>
			</div>
		</c:if>
	</c:forEach>
</c:if>
</section>
<button id="btn_memo">메모작성</button>

</body>
</html>