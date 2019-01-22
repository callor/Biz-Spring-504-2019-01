<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<sql:setDataSource var="addrDataSource"
	driver="oracle.jdbc.driver.OracleDriver"
	url="jdbc:oracle:thin:@localhost:1521:xe"
	user="mybts"
	password="1234" />
<sql:query dataSource="${addrDataSource}" var="addrList" >
	SELECT * FROM tbl_addr
</sql:query>	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
<style>
	header {
		background-color : #00aba9;
		color : #fff;
		text-align: center;
		font-size:20px;
		padding : 5px;
	}
	
	footer {
		background-color : #00aba9;
		color : #fff;
		text-align: center;
		padding : 5px;
	}
	
	table {
		border-spacing: 0;
		width:100%;
		display:table;
		border : 1px solid #ccc;
	}
	
	tr {
		border : 1px solid #ddd;
	}
	
	td, th {
		border : 1px solid #ddd;
	}
	
	#button-div {
		font-size:0;
		border : 1px solid lightgray;
		
		width : 212px; /* 밖깥쪽 요소보다 작게 */
		margin : 0 auto; /* block요소를 어떤 다른 요소 내부에서 */
						 /* 가로방향 중앙에 배치하고 할때 */
	
	}
	
	#button-div button {
		width : 100px;
		margin : 3px;
	}
	

</style>
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
		<c:forEach var="row" items="${addrList.rows}" >
		<tr>
			<td><a href="../forms/addr_input2.jsp?ad_num=${row.ad_num}">${row.ad_num}</a></td>
			<td>${row.ad_name}</td>
			<td>${row.ad_tel}</td>
			<td>${row.ad_addr1}</td>
			<td>${row.ad_addr2}</td>
		</tr>
		</c:forEach>	
	</table>
	<div id="button-div">
		<button onclick="location.href= '/sp003/forms/addr_input.jsp' ">주소추가</button>
		<button type="button" 
			onclick="confirm('정말 돌아 갈까요')">돌아가기</button>
	</div>
	
</section>
<footer onclick="alert('반갑습니다')">
	<address>CopyRight &copy; callor@callor.com</address>
</footer>
</body>
</html>