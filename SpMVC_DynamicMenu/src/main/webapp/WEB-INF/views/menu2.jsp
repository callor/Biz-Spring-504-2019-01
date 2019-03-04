<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" 
		href="<c:url value='/css/menu.css' />" >
</head>
<body>
<nav>
	<ul>
		<c:if test="${not empty MENUS}">
			<c:forEach var="MENU" items="${MENUS}" varStatus="index">
				<c:choose>
					<c:when test="${empty MENU.sub_menus}">
						<li><a href="<c:url value='${MENU.menu_href}' />" >${MENU.menu_title}</a>	
					</c:when>
					<c:otherwise>
						<li class="dropdown">
						<a href="javascript:void(0)" class="dropbtn">${MENU.menu_title}</a>
						<div class="dropdown-content">
							<c:forEach var="SUB" items="${MENU.sub_menus}" varStatus="i">
								<a href="<c:url value='${SUB.menu_href}' />" >${SUB.menu_title} </a>
							</c:forEach>
						</div>
						</li>
					</c:otherwise>
				
				</c:choose>
			
										
			</c:forEach>
		</c:if>
	</ul>	
</nav>
</body>
</html>