<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<style>
	table {
		width:100%;
		border-collapse: collapse;
		border-spacing: 0;
		border:1px solid #ccc;
	}
	
	tr {
		border-bottom: 1px solid #ddd
	}
	
	tr:nth-child(odd) {
		background-color: #fff
	}
	
	tr:nth-child(even) {
		background-color: #f1f1f1;
	}
	
	tr:hover {
		background-color: #ccc;
	}
	
	td, th {
		text-align: left;
		padding: 8px 8px;
		vertical-align: top
	}
	
	td:first-child, th:first-child {
		padding-left : 16px;
	}
	
	

</style>
<body>
<table>
	<tr>
		<th>No</th>
		<th>작성자</th>
		<th>작성일자</th>
		<th>시간</th>
		<th>제목</th>
		<th>조회수</th>
	</tr>
	<c:choose>
		<c:when test="${empty BBS_LIST}">
			<tr><td colspan=6>게시물이 없습니다</td></tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${BBS_LIST}"  var="BBS" varStatus="i">
				<tr class="bbs_row" data-id="${BBS.id}">
					<td>${i.count}</td>
					<td>${BBS.b_userid}</td>
					<td>${BBS.b_date}</td>
					<td>${BBS.b_time}</td>
					<td>${BBS.b_subject}</td>
					<td>${BBS.b_hit}</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>
<hr />
<button id="btn-write">글쓰기</button>
<script>
	$(function(){
		$("#btn-write").click(function(){
			location.replace("<c:url value = '/bbs/write' />")
		})
		
		$(".bbs_row").click(function(){
			let id = $(this).attr("data-id")
			location.replace("<c:url value = '/bbs/view' />" 
						+ "?id=" 
						+ id)
			
		})
	})
</script>



