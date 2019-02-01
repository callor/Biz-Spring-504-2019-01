<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/include/include-head.jspf" %>
<script>
$(function(){
	
	// memoROW 로 등록된 class가 클릭 되면...
	$(".memoROW").click(function(){
		
		// 클릭된 this(tr)에 숨어있는 data-memo-id 값을 추출해서
		// id 변수에 담아라
		var id = $(this).attr("data-memo-id")
		
		// id의 값은 DB에서 추출한 레코드의 PK 값이 된다.
		// alert(id + " 번 메모를 선택 했네요")
		location.href ="${pageContext.request.contextPath}/memo_view?MSG=&id=" + id
		
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