<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/include-head.jspf" %>
</head>
<body>
<header>
	<h3>주소록 보기</h3>
</header>

<section>
	<table>
		<tr>
			<th>확번</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>주소</th>
			<th>상세주소</th>
		<tr>
		<c:choose>
			<c:when test="${empty addrList}" >
				<tr>
					<td colspan="5">데이터가 없습니다</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="vo" items="${addrList}" >
					<tr>
						<td><a href="../forms/addr_input2.jsp?ad_num=${vo.ad_num}">${vo.ad_num}</a></td>
						<td>${vo.ad_name}</td>
						<td>${vo.ad_tel}</td>
						<td>${vo.ad_addr1}</td>
						<td>${vo.ad_addr2}</td>
					</tr>
				</c:forEach>	
			</c:otherwise>
		</c:choose>
		
	</table>
	<div id="button-div">
		<button type="button" 
			onclick="location.href='insert' ">주소추가</button>
		<button type="button" 
			onclick="confirm('정말 돌아 갈까요')">돌아가기</button>
	</div>
	
</section>
<footer onclick="alert('반갑습니다')">
	<address>CopyRight &copy; callor@callor.com</address>
</footer>
</body>
</html>