<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%
  Date date = new Date();
  SimpleDateFormat sf = new SimpleDateFormat("yyyy년 MM월 dd일");
  String sDate = sf.format(date);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>오늘은 : <%= sDate %> 입니다</h3>


</body>
</html>