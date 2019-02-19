<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-scale,initial-scale=1">
<meta charset="UTF-8">
<title>매입매출 리스트</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>

td.w3-text-right {
	text-align: right;
}

</style>
</head>
<body>
<header class="w3-green">
	<h3 class="w3-center w3-whilte">매입매출 리스트</h3>
</header>
<section>
	<table class="w3-table-all">
		<tr>
			<th>No</th>
			<th>거래일자</th>
			<th>거래시간</th>
			<th>거래구분</th>
			<th>상품이름</th>
			<th>수량</th>
			
			<th>매입단가</th>
			<th>매입가격</th>
			
			<th>매출단가</th>
			<th>매출가격</th>
		</tr>
		<c:choose>
			<c:when test="${empty IOLIST}" >
				<tr><td colspan="10">거래내역이 없습니다</td></tr>
			</c:when>
			<c:otherwise>
			<c:forEach var="VO" items="${IOLIST}" varStatus="i">
				<tr>
					<td>${i.count}</td>
					<td>${VO.io_date}</td>
					<td>${VO.io_time}</td>
					<td>
						<c:if test="${VO.io_check=='1'}">매입</c:if>
						<c:if test="${VO.io_check=='2'}">매출</c:if>
					</td>
					<td>${VO.io_cname}</td>
					<td>${VO.io_su}</td>
					
					<!-- 매입표시 -->
					<c:if test="${VO.io_check=='1'}">
						<td class="w3-text-right">
							<fmt:formatNumber value="${VO.io_price}"
								type="number" pattern=".0" />
						</td>
						<td class="w3-text-right">
							<fmt:formatNumber 
								value="${VO.io_price * VO.io_su}"
								type="number" />  
						</td>
						<td></td><td></td>
					</c:if>
					
					<!-- 매출표시 -->
					<c:if test="${VO.io_check=='2'}">
						<td></td><td></td>
						<td class="w3-text-right">${VO.io_price}</td>
						<td class="w3-text-right">
						<fmt:formatNumber 
							value="${VO.io_price * VO.io_su}"
							type="currency" /></td>
					</c:if>
				 </tr>		
			 </c:forEach>	
			</c:otherwise>
		</c:choose>
	</table>
</section>
</body>
</html>
<!-- 

fmt formatNumber var="값" type="number" 숫자형으로 3자리마다 컴마 포함
fmt formatNumber var="값" type="currency" 화폐형으로 
				3자리마다 컴마 포함하고 화폐단위 표시

fmt formatNumber var="값.값" type="percent" 
		만약 0.3 이면 30% 표현
		만약 1.2 이면 120% 표현
		
fmt formatNumber var="값.12313" pattern=".00" 
		숫자형으로 표현하되	소수점이하 2자리까지 표시
		
fmt formatDate pattern="yyyy/mm/dd" : 값이 날짜형일 경우 		
		

 -->







