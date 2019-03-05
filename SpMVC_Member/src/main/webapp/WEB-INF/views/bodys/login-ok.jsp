<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(function(){
	$("#win_close").click(function(){
		if(confirm("닫을까요")) {
			opener.location.reload()
			// open.parent.reload() ERR
			// open.parent.location.reload() ERR
			window.close();
		}
	})
	
})
</script>
</head>
<body>
<button id="win_close">닫기</button>


</body>
</html>