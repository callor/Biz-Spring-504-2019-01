<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" 
	content="width=device-width,initial-scale=1">
<meta charset="UTF-8">
<title>나라 plus</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/home.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(function(){

	$(".p-tr").click(function(){
		// id 값을 추출할수 있으면 몇번째 tr이 클릭 되었는지
		// 알수가 있다.
		let id = $(this).attr("id")
		let p_ccode = $(this).attr("data-p-ccode")
		let p_cname = $(this).attr("data-p-cname")
		let p_iprice = $(this).attr("data-p-iprice")
		let p_oprice = $(this).attr("data-p-oprice")
		
		let p_string = "<p>" + p_ccode + "<br>" 
						+ p_cname  + "<br>"
						+ p_iprice  + "<br>"
						+ p_oprice + "<p>"
		
		let s_cart = $("#s-cart").text()
		$("#s-cart").text(s_cart + p_string)
						
		
		a = 3
		b = 4
		s = a + b
		
		a = 'A' //작은따옴표, 큰따옴표 관계없이 문자열 표현
		b = 'B'
		s = a + b
		
		alert("선택한 상품은 \n" 
				+ "상품코드:" + p_ccode + "\n"
				+ "상품명:" + p_cname + "\n"
				+ "매입가격:" + p_iprice + "\n"
				+ "판매가격:" + p_oprice + "\n"
				
				+ " 입니다 ")
	
	})	
	
})
</script>
	
</head>

<body>

<header>
	<h2>나라 Plus</h2>
</header>
<nav>
	<a href="#">Home</a>
	<a href="#">상품검색</a>
	<a href="#">About</a>
</nav>
<section>

	<article id="p-list">
		<table class="w3-table-all">
			<tr>
				<th>상품코드</th>
				<th>상품이름</th>
				<th>과세구분</th>
				<th>매입단가</th>
				<th>판매단가</th>
			</tr>
			<c:choose>
				<c:when test="${empty PROS}">
					<tr>
						<td colspan=5>
						상품리스트가 없습니다
						</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="PVO" items="${PROS}" varStatus="i">
						<tr class="p-tr" 
						data-p-ccode = "${PVO.p_ccode}"
						data-p-cname = "${PVO.p_cname}"
						data-p-iprice = "${PVO.p_iprice}"
						data-p-oprice = "${PVO.p_oprice}"
						id="${i.index}">
							<td>${PVO.p_ccode}</td>
							<td>${PVO.p_cname}</td>
							<td>
								<c:if test="${PVO.p_vat == '1'}">과세</c:if>
								<c:if test="${PVO.p_vat == '2'}">면세</c:if>
							</td>
							<td>${PVO.p_iprice}</td>
							<td>${PVO.p_oprice}</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			
		</table>
	</article>

	<article id="s-cart">
	</article>

</section>
<footer>
</footer>

</body>
</html>

