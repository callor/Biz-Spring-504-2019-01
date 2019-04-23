<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<h3>장바구니</h3>
<table>
	<tr>
		<th>NO</th>
		<th>도서명</th>
		<th>가격</th>
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
			<tr><td colspan="2">장바구니 비었음</td>
		</c:when>
		<c:otherwise>
			<c:forEach var="item" items="${CART}" varStatus="i">
				<tr>
					<td>${i.count}</td>
					<td>${item.cart_book_title}</td>
					<td>${item.cart_book_price}</td>	
				</tr>		
			</c:forEach>	
		</c:otherwise>
	</c:choose>
</table>