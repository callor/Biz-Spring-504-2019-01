<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/include/include-head.jspf" %>
<script>
$(function(){
	$(".memoROW").click(function(){
		var id = $(this).attr("data-memo-id")
		alert(id + " 번 메모를 선택 했네요")
		
	})
	
})
</script>
</head>

<body>
<%@ include file="/WEB-INF/include/include-header.jspf" %>
<section>
	<table>
		<tr>
			<th>NO</th>
			<th>작성일</th>
			<th>작성자</th>
			<th>제목</th>
		</tr>
		<c:choose>
			<c:when test="${empty MEMOS}">
				<tr>
					<td colspan="4">메모가 없습니다</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${MEMOS}" var="memoVO" varStatus="i">
				<tr class="memoROW" data-memo-id="${memoVO.id}">
					<td>${i.count}</td>
					<td>${memoVO.m_date}</td>
					<td>${memoVO.m_auth}</td>
					<td>${memoVO.m_subject}</td>
				</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</section>
<footer>
	<address>CopyRight &copy; callor@callor.com</address>
</footer>
 <script src="https://unpkg.com/aos@next/dist/aos.js"></script>
  <script>
    AOS.init();
  </script>
</body>
</html>