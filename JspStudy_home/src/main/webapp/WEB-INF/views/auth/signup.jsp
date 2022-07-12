<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<style type="text/css">
	#container{
		margin: 0px auto;
		display:flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
		
		width: 500px;
		height: 700px;
	}
</style>

</head>
<body>
	<div id="container">
		<div>
			<h1>회원가입</h1>
		</div>
		<form action="/JspStudy_home/signup" method="post">
			<div>
				<div class="item-input">
					<label class="item-label">이메일</label>
					<input type="text" name="email">
				</div>
				<div class="item-input">
					<label class="item-label">이름</label>
					<input type="text" name="name">
				</div>
				<div class="item-input">
					<label class="item-label">사용자이름</label>
					<input type="text" name="username">
				</div>
				<div class="item-input">
					<label class="item-label">비밀번호</label>
					<input type="password" name="password">
				</div>
			</div>
			<button type="submit">회원가입</button>
		</form>
	</div>
	
	<script type="text/javascript">
		const itemInputs = document.querySelectorAll(".item-input");
		const usernameInput = itemInputs[2].querySelector("input");
		
		usernameInput.onblur = () => {
			
			$.ajax({  // ajax 기본 메소드 호출 / ({객체})
				type: "get",  //메소드
				url: "/JspStudy_home/signup-username-check", //요청주소
				date: {
					username: usernameInput.value
				},
				dataType: "text", //응답을 받았을 때 데이터타입
				success: function(data) { //리스폰스때 응답된 값이 들어옴
					alert(data);
				},
				error: function(date) {
					alert("비동기 통신 오류");
				}
			}); 
			
		}
	
		
	</script>
</body>
</html>