<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 JSP 페이지</title>
</head>
<body>
	<div id="header">
		<h2>나의 JSP 페이지</h2>
		<h4>나의 홈페이에 오신 것을 환영합니다</h4>
	</div>
	<div id="section">
		<div>
		<form action="/sp002/join.jsp">
			<!-- 
				label tag는 input tag와 한 그룹으로 만들어서
				input tag를 선택하는데 조금 편한 기능을 부여한다.
				
				label tag for 속성은 어떤 input tag를 감쌀 것인지
				나타내는 값이다.
				for="input tag의 id값" 형식으로 작성 한다.
			-->
			<label for="userId">아이디</label>
			<input type="text" id="userId" name="userId" /><br/>
			
			<!-- 
				label에 for 속성을 사용하지 않고
				label tag로 input tag를 감싸는 구조로 만들어 된다.
				이때는 tag를 tag가 감싸고 있는 형태가 되어
				문법적인 문제로 layout이 무너지는 현상을 겪을수도 있다.
			 -->
			<label for="password01">비밀번호
				<input type="password" id="password01" name="password" /><br/>
			</label>
			
			<label for="email">이메일</label>
			<!-- 
				input tag에 type 속성을 포함할수 있는데,
				type="password" : 입력박스에 문자 대신 *표를 보여
				입력중 문자가 노출되는 것을 방지 한다.
				
				type="email" : 모바일 환경에서 이 속성이 적용된
				입력창을 터치하면 email 주소를 쉽게 입력할 수 있도록
				@ 문자와 .com 등의 문자가 적용된 키보드를 보여준다.
				
				type="tel" : 모바일에서 전화번호를 쉽게 입력할수 있도록
				키보드가 나타 난다.			
				
				타입을 지정하지 않으면
				기본값으로 type="text" 가 적용된다.

				하지만 일반적으로 type="text" 로 작성을 한다.	
			
			 -->
			<input type="email" email" name="email" /><br/>
			
			<label for="userName">이름</label>
			<input id="userName" name="userName" /><br/>
			
			<!-- 
				button tag에 type 이 있는데
				기본값은 type="submit"이며
				이 것은 클릭 했을때 form에 포함된 입력 값들을
				서버로 전송하는 기능이 자동 적용된다.
				
				type="reset" : 입력박스에 타이핑한 값을 모두
				지우고 입력박스를 비우는 기능을 한다.
				
				type="button" : 초기에 아무런 기능도 없는
				버튼 모양만을 만들고자 할때
				>> javaScript에서 button을 제어할때 사용한다.
			
			 -->
			<button>회원가입</button>
			<button type="reset">다시작성</button>
			
		</form>
		</div>
	</div>




</body>
</html>