<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ include file="/WEB-INF/views/include/include_head.jspf" %>

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
<script>
$(function(){

	$("#btn_write").click(function(){
		location.href = "mail"
	})
	
	$(".email_row").click(function(){
		let id = $(this).attr("data-id")
		location.href = "view?id=" + id
	})
	
})


</script>
</head>
<body>
<header>
	<h3>Email 관리 시스템</h3>
</header>
<section>
	<article>
		<table>
			<tr>
				<th>작성일자</th>
				<th>작성시각</th>
				<th>보내는 Email</th>
				<th>받는 Email</th>
				<th>제목</th>
			</tr>	
			<c:choose>
				<c:when test="${empty MAILS}">
					<tr>
						<td colspan=5>리스트가 없습니다</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${MAILS}" var ="mail">
						<tr class="email_row" data-id="${mail.id}">
							<td>${mail.s_date}</td>
							<td>${mail.s_time}</td>
							<td>${mail.from_email}</td>
							<td>${mail.to_email}</td>
							<td>${mail.s_subject}</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
		<hr/>
		<button id="btn_write">Email 작성</button>
	</article>
</section>


</body>
</html>