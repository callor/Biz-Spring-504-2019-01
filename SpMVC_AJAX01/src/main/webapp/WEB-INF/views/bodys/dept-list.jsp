<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" 
		value="${pageContext.request.contextPath}" />    
<style>
table {
	border-collapse: collapse;
	border-spacing: 0;/* td와 td간의 간격을 0 */
	width:100%;
	border:1px solid #ccc;
}

tr {
	border-bottom: 1px solid #ddd;
}

/* tr의 각 요소들에 대한 세팅 */
/* 홀수 tr과 짝수 tr의 색깔을 달리해서 라인 구분을 설정 */
tbody tr:nth-child(even) {
	background-color: #f1f1f1;
}
tbody tr:nth-child(odd) {
	background-color: #fff;
}

tbody tr:hover {
	background-color: #ccc;
}

th, td {
	padding:8px;
	text-align: left;
	cursor:pointer;
}

th:first-child, td:first-child {
	padding-left:16px;
}

</style>
<script>
$(function(){
	
	var deptList = Array() // 자바스크립트 배열 선언
	/*
	
		js 배열은 동적배열
		초기에 배열을 생성한후 자유롭게 
		데이터들을 추가 삭제가 가능 
		1. 배열을 생성 : var arr = Array()
		2. 배열을 추가 : arr.push("값")
	
	*/
	
	$(".d-tr").click(function(){

		let dcode = $(this).attr("data-d-code")
		let dname = $(this).attr("data-d-name")
		let dceo = $(this).attr("data-d-ceo")
		
		$("#d_code").val(dcode)
		$("#d_name").val(dname)
		$("#d_ceo").val(dceo)
		
	})
	
	
	$("#btn-send").click(function(){
		$.ajaxSettings.traditional = true;
		$.ajax({
			url : "${rootPath}/dept.json.array",

			method:"POST",
			traditional:true, // 배열을 보낼때 반드시 설정
			// dataType:"JSON", // 서버에서 받을때 JSON으로 받아라
			contentType:"application/json", // 서버로 보낼때 JSON으로 보내라
			data:JSON.stringify(deptList), // 데이터를 JSON 형식으로 서버로 보내라

			success:function(result){
				alert(result)
			},
			error : function(){
				alert("서버와 통신 오류!!")
			}
		})
	})
})

</script>
<table>
	<tr>
		<th>NO</th>
		<th>CODE</th>
		<th>거래처명</th>
		<th>대표</th>
	</tr>
	<c:choose>
		<c:when test="${empty DEPTLIST}">
			<tr><td colspan=4>거래처 정보가 없습니다</td></tr>
		</c:when>
		<c:otherwise>

			<c:forEach items="${DEPTLIST}" 
						var="dVO" varStatus="i">
			<!-- for 시작 -->
			<tr class="d-tr" 
				data-d-code="${dVO.d_code}"
				data-d-name="${dVO.d_name}"
				data-d-ceo="${dVO.d_ceo}" >
				<td>${i.count}</td>
				<td>${dVO.d_code}</td>
				<td>${dVO.d_name}</td>
				<td>${dVO.d_ceo}</td>
			</tr>
			<!-- for 끝 -->
			</c:forEach>

		</c:otherwise>
	
	
	</c:choose>
</table>