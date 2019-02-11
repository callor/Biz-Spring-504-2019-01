<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/include/include-head.jspf" %>
</script>
</head>

<body>
<%@ include file="/WEB-INF/include/include-header.jspf" %>
<section>
	<c:if test="${BODY == 'LIST' }">
		<%@ include file="/WEB-INF/views/body/memo_list.jspf" %>
	</c:if>
	<c:if test="${BODY == 'VIEW' }" >
		<%@ include file="/WEB-INF/views/body/memo_view.jspf" %>
	</c:if>
	<c:if test="${BODY == 'WRITE' }" >
		<%@ include file="/WEB-INF/views/body/memo_write.jspf" %>
	</c:if>
	<c:if test="${BODY == 'MEMBER_JOIN' }" >
		<%@ include file="/WEB-INF/views/body/member_write.jspf" %>
	</c:if>


</section>
<footer>
	<address>CopyRight &copy; callor@callor.com</address>
</footer>
</body>
</html>