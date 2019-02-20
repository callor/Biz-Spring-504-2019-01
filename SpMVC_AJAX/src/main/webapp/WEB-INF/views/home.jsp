<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" 
	content="width=device-width,initial-scale=1">
<meta charset="UTF-8">
<title>나라 plus</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/home.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(function(){

	$(".p-tr").click(function(){
		// id 값을 추출할수 있으면 몇번째 tr이 클릭 되었는지
		// 알수가 있다.
		
		// attr() 함수 
		// $(...) : 선택자, selector라고 하는 객체의
		// 속성값을 getter하거나 setter하는 함수다
		// $(this).attr("data-my-name","홍길동") 
		let id = $(this).attr("id")
		let p_ccode = $(this).attr("data-p-ccode")
		let p_cname = $(this).attr("data-p-cname")
		let p_iprice = $(this).attr("data-p-iprice")
		let p_oprice = $(this).attr("data-p-oprice")

		// attr과 거의 같은 기능을 하는데
		// 일부 tag나 선택자로부터 값을 추출하지 못하는
		// JS 버그를 개선한 함수
		// p_oprice = $(this).prop("data-p-oprice")
		
		let su = 1
		/*
			JS에서 숫자 문자열의 연산
			숫자 + 문자열 => 문자열 + 문자열
			
			다른 연산(-, *, /)는 문법 오류가 난다.
			
			따라서 문자열을 숫자로 변환해야 한다.
			>> parseInt()
		*/
		let p_isum = su * parseInt(p_iprice) 
		let p_osum = su * parseInt(p_oprice) // 숫자 + 문자열 = 문자열 + 문자열
		
		let p_string = "<p>" + p_ccode + "<br>" 
						+ p_cname  + "<br>"
						+ p_iprice  + "<br>"
						+ p_oprice  + "<br>"
						+ "<span class='isum'>" + p_isum + "</span>"  + "<br>"
						+ "<span class='osum'>" + p_osum  + "</span>"  + "<br>"
						+ "<p>"
		
		// $(...).text() 어떤 tag 내부에 있는
		// text를 getter하거나 setter 하는 함수
		// let s_cart = $("#s-cart").text()
		// $("#s-cart").text(s_cart + p_string)
		
		// 그런데 text()함수는 일반문자열로 모든 것을 취급한다
		// 따라서 tag를 부여해도 속성이 적용되지 않는다.
		
		// tag의 속성(효과)를 부여하고 싶을때는
		// html() 이라는 함수를 사용한다.
		let s_cart = $("#s-cart").html()
		$("#s-cart").html(s_cart + p_string)
		
		a = 3
		b = 4
		s = a + b
		
		a = 'A' //작은따옴표, 큰따옴표 관계없이 문자열 표현
		b = 'B'
		s = a + b
		
		return false;
						
		alert("선택한 상품은 \n" 
				+ "상품코드:" + p_ccode + "\n"
				+ "상품명:" + p_cname + "\n"
				+ "매입가격:" + p_iprice + "\n"
				+ "판매가격:" + p_oprice + "\n"
				
				+ " 입니다 ")
	
	}) // $(.p-tr).click END
	
	$("#btn-total").click(function(){
		
		// 버튼을 클릭 했을때 합계를 계산
		
		
		var isum = 0
		var osum = 0
		
		// forEach와 원리가 비슷한데
		// .isum 클래스 개수만큼 자동 반복하면서
		// item에 각각 한개의 항목(select)들을 저장해준다.
		// item을 selector로 설정하여
		// 		>> $(item)처럼 설정
		// 그 항목에서 text를 추출하고
		// 숫자로 변환한후 isum 변수에 누적한다.
		
		$(".isum").each(function(index,item){
			isum += parseInt( $(item).text() )
		})
		$(".osum").each(function(index,item){
			osum += parseInt( $(item).text() )
		})

		alert("매입합계:" + isum + "\n"
			+"매출합계:" + osum)
		
	})
	
})
</script>
	
</head>

<body>

<header>
	<h2>나라 Plus</h2>
</header>
<nav>
	<a href="#">Home</a>
	<a href="#">상품검색</a>
	<a href="#">About</a>
	<button id="btn-total">합계</button>
</nav>
<section>

	<article id="p-list">
		<table class="w3-table-all">
			<tr>
				<th>상품코드</th>
				<th>상품이름</th>
				<th>과세구분</th>
				<th>매입단가</th>
				<th>판매단가</th>
			</tr>
			<c:choose>
				<c:when test="${empty PROS}">
					<tr>
						<td colspan=5>
						상품리스트가 없습니다
						</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="PVO" items="${PROS}" varStatus="i">
						<tr class="p-tr" 
						data-p-ccode = "${PVO.p_ccode}"
						data-p-cname = "${PVO.p_cname}"
						data-p-iprice = "${PVO.p_iprice}"
						data-p-oprice = "${PVO.p_oprice}"
						id="${i.index}">
							<td>${PVO.p_ccode}</td>
							<td>${PVO.p_cname}</td>
							<td>
								<c:if test="${PVO.p_vat == '1'}">과세</c:if>
								<c:if test="${PVO.p_vat == '2'}">면세</c:if>
							</td>
							<td>${PVO.p_iprice}</td>
							<td>${PVO.p_oprice}</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			
		</table>
	</article>

	<article id="s-cart">
	</article>

</section>
<footer>
</footer>

</body>
</html>

