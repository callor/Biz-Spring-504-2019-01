<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" /> 
<hr/>
<table>
<tr>
		<th>NO</th>
		<th>CODE</th>
		<th>거래처명</th>
		<th>대표자명</th>
		<th>대표전화</th>
		<th>주소</th>
</tr>
<tr>
	<c:choose>
		<c:when test="${empty LIST}">
			<td colspan=20>자료가 없습니다.</td>
		</c:when>
		<c:otherwise>
			<c:forEach items="${LIST}" var="vo" varStatus="i">
				<tr class="d_select">
					<td>${i.count}</td>
					<td>${vo.d_code}</td>
					<td>${vo.d_name}</td>
					<td>${vo.d_ceo}</td>
					<td>${vo.d_tel}</td>
					<td>${vo.d_addr}</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</tr>
</table>
<hr/>
<script>
$(function(){
	$(".d_select").click(function(){
		
		let tds = $(this).children()
		
		let d_code  = tds.eq(1).text()
		let d_name = tds.eq(2).text()
		
		$("#io_dcode").val(d_code)
		$("#d_name").text(d_name)
		
		$("#myModal").css("display","none")
	})
})

</script>










