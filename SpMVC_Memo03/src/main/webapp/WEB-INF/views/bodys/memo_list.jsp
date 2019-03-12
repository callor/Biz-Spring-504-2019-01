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
table {
	border-collapse:collapse;
	border-spacing: 0;
	width:100%;
	border:1px solid #ccc;
}

tr {
	border:1px solid #ddd;
}

tr:nth-child(even) {
	background-color: #ccc;
}
tr:nth-child(odd) {
	background-color: #fff;
}

tr:hover {
	background-color: #ddd;
}

td {
	text-align: center;
}

td, th {
	padding: 8px 8px;
	vertical-align: top
}

td:first-child, th:first-child {
	padding-left:16px;
}

</style>
<script>
$(function(){
	$(".memo_tr").click(function(){
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
</head>
<body>
<table>
	<tr>
		<th>NO</th>
		<th>작성자</th>
		<th>작성일자</th>
		<th>제목</th>
		<th>첨부파일</th>
	</tr>
	<c:choose>
		<c:when test="${empty MEMOS}">
			<tr><td colspan=4>메모가 없습니다</td></tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${MEMOS}" var="memo" varStatus="i">
				<tr class="memo_tr" data-id="${memo.id}">
					<td>${i.count}</td>
					<td>${memo.m_auth}</td>
					<td>${memo.m_date}</td>
					<td>${memo.m_subject}</td>
					<td>
						<c:if test="${not empty memo.files}" >
							<c:forEach items="${memo.files}" 
									var="file" varStatus="f">
								<img src="<c:url value='/files/${file.save_file_name}' /> ">							
							</c:forEach>						
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>

<button id="btn_memo">메모작성</button>

</body>
</html>