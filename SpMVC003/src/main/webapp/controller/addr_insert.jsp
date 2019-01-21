<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
	String ad_num = request.getParameter("ad_num");
	String ad_name = request.getParameter("ad_name");
	String ad_tel = request.getParameter("ad_tel");
	String ad_addr1 = request.getParameter("ad_addr1");
	String ad_addr2 = request.getParameter("ad_addr2");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<section>
	<p>학번: <%= ad_num %>
	<p>이름: <%= ad_name %>
	<p>전화번호: <%= ad_tel %>
	<p>주소: <%= ad_addr1 %>,  <%= ad_addr2 %>
</section>

<%
	Connection dbConn;
	
	String oracleDriver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "mybts";
	String password = "1234" ;
	
	String sql = " INSERT INTO tbl_addr " ;
	sql += " VALUES ( ?,?,?,?,?)" ;
	
	PreparedStatement ps;
	ResultSet rs = null;
	
	try {
		
		Class.forName(oracleDriver);
		dbConn = DriverManager.getConnection(url, user, password);
		ps = dbConn.prepareStatement(sql);
		ps.setString(1,ad_num);
		ps.setString(2,ad_name);
		ps.setString(3,ad_tel);
		ps.setString(4,ad_addr1);
		ps.setString(5,ad_addr2);
		
		int ret = ps.executeUpdate();
		ps.close();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	// 현재 페이지를 리스트 보기로 바꾸어라
	response.sendRedirect("/sp003/controller/addr_list.jsp");

%>


</body>
</html>