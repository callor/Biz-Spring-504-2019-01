<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<sql:setDataSource var="addrDataSource"
	driver="oracle.jdbc.driver.OracleDriver"
	url="jdbc:oracle:thin:@localhost:1521:xe"
	user="mybts"
	password="1234" />
	
<sql:update dataSource="${addrDataSource}" var="addrList" >
	UPDATE tbl_addr 
		SET ad_num = ? ,
			ad_name = ?,
			ad_tel = ?,
			ad_addr1 = ?,
			ad_addr2 = ?
		WHERE ad_num = ?
		<sql:param value="${param.ad_num}" />
		<sql:param value="${param.ad_name}" />
		<sql:param value="${param.ad_tel}" />
		<sql:param value="${param.ad_addr1}" />
		<sql:param value="${param.ad_addr2}" />
		<sql:param value="${param.ad_num}" />
</sql:update>
<c:redirect url="../controller/addr_list_jstl.jsp" />    






