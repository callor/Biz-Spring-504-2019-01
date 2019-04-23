<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<style>
.cart_item_delete {
	cursor: pointer;
}
</style>
<script>
$(function(){

	$("#btn_cart_clear").click(function(){
		$.get("${rootPath}/rent/cart_clear",function(result){
			$("#cart-box").html(result)
		})
	})
	
	$(".cart_item_delete").click(function(){
		let index = $(this).attr("data-index")
		$.get("${rootPath}/rent/cart_item_delete/" + index,function(){
			$("#cart-box").html(result)
		})
	})

})

</script>    
<h3>장바구니</h3>
<div>
	<button id="btn_check_out">결제</button>
	<button id="btn_cart_clear">비우기</button>	
</div>
<table>
	<tr>
		<th>NO</th>
		<th>도서명</th>
		<th>가격</th>
		<th></th>
	</tr>
	
		<%
		/*
		session을 jsp에서 취급하는 방법
		servlet-jsp 버전이 3.x 이전에는
		session.getAttribute() 라는 JSP method를 이용해서
		session 값을 추출하고 취급을 했어야 한다.

		최근버전의 servlet에서는 일반 model에 담긴 데이터 처럼
		바로 변수명을 꺼내서 사용할수 있다.
		
		private String cart_date;
		private String cart_return_date;
		private long cart_book_seq;
		private String cart_book_title;
		
		private long cart_book_price;
		private long cart_user_seq;
		private String cart_user_name;
		
		private String cart_return_yn;
		*/
		%>
	<c:choose>
		<c:when test="${empty CART}">
			<tr><td colspan="4">장바구니 비었음</td>
		</c:when>
		<c:otherwise>
			<c:forEach var="item" items="${CART}" varStatus="i">
				<tr>
					<td>${i.count}</td>
					<td class="b_title">${item.cart_book_title}</td>
					<td>${item.cart_book_price}</td>
					<th class="cart_item_delete" data-index="${i.index}">x</th>	
				</tr>		
			</c:forEach>	
		</c:otherwise>
	</c:choose>
</table>