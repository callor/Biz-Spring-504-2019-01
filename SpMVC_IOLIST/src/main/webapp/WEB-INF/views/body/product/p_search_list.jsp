<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<style>
	tr {
		cursor:pointer;
	}
</style>
<script>
$(function(){
	$(".p-select").click(function(){
		
		let tds = $(this).children() // td들을 모두 뽑아라 tds 
									 // td 들의 배열이 된다.
									 
		let p_code = tds.eq(1).text()
		let p_name = tds.eq(2).text()
		let p_tax = tds.eq(3).text()
		let p_iprice = tds.eq(4).text()
		let p_oprice = tds.eq(5).text()
		
		let io_inout = $("#io_inout").val() // form에 있는 매입매출
		
		$("#io_pcode").val(p_code)
		$("#p_name").text(p_name)
		
		if(p_tax == '1') {
			$("#io_tax_on").attr("checked",true)
		} else {
			$("#io_tax_off").attr("checked",true)
		}
		
		if(io_inout == '1') { // 매입일 경우
			$("#io_price").val(p_iprice)
		} else if(io_inout == '2') {
			$("#io_price").val(p_oprice)
		}
		$("#myModal").css("display","none")
		
	})
})

</script>  
<table>
<tr>
		<th>NO</th>
		<th>상품코드</th>
		<th>상품이름</th>
		<th>과세</th>
		<th>매입단가</th>
		<th>매출단가</th>

</tr>
<tr>
	<c:choose>
		<c:when test="${empty LIST}">
			<td colspan=20>자료가 없습니다.</td>
		</c:when>
		<c:otherwise>
			<c:forEach items="${LIST}" var="vo" varStatus="i">
				<tr class="p-select">
					<td>${i.count}</td>
					<td>${vo.p_code}</td>
					<td>${vo.p_name}</td>
					<td>${vo.p_tax}</td>
					<td>${vo.p_iprice}</td>
					<td>${vo.p_oprice}</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</tr>
</table>
<hr/>
